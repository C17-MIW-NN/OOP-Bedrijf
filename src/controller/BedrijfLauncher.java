package controller;

import model.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Run mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        ArrayList<Afdeling> afdelingen = leesAfdelingenIn("resources/Afdelingen.txt");
        ArrayList<Persoon> personen = leesPersonenIn("resources/Personen.csv", afdelingen);

        printWerknemersPerAfdeling("resources/PersonenPerAfdeling.txt", afdelingen, personen);
    }

    private static void printWerknemersPerAfdeling(String bestandspad,
                                                   ArrayList<Afdeling> afdelingen,
                                                   ArrayList<Persoon> personen) {
        Collections.sort(personen);

        try (PrintWriter printWriter = new PrintWriter(bestandspad)) {
            for (Afdeling afdeling : afdelingen) {
                printWriter.printf("Afdeling: %s\n", afdeling.getAfdelingsNaam());

                for (Persoon persoon : personen) {
                    if (persoon.getAfdeling().equals(afdeling)) {
                        printWriter.println("-- " + persoon);
                    }
                }

                printWriter.println();
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het uitvoerbestand te openen " + fileNotFoundException.getMessage());
        }


    }

    private static ArrayList<Persoon> leesPersonenIn(String bestandspad, ArrayList<Afdeling> afdelingen) {
        ArrayList<Persoon> personen = new ArrayList<>();

        try (Scanner personenScanner = new Scanner(new File(bestandspad))) {
            while (personenScanner.hasNextLine()) {
                String[] persoonsgegevens = personenScanner.nextLine().split(",");

                String type = persoonsgegevens[0];
                String naam = persoonsgegevens[1];
                String woonplaats = persoonsgegevens[2];
                int afdelingsindex = Integer.parseInt(persoonsgegevens[3]);
                double ietsMetGeld = Double.parseDouble(persoonsgegevens[4]);

                switch (type) {
                    case "Werknemer":
                        personen.add(new Werknemer(naam, woonplaats, afdelingen.get(afdelingsindex), ietsMetGeld));
                        break;
                    case "Zzper":
                        personen.add(new ZZPer(naam, woonplaats, afdelingen.get(afdelingsindex), ietsMetGeld));
                        break;
                    case "Vrijwilliger":
                        personen.add(new Vrijwilliger(naam, woonplaats, afdelingen.get(afdelingsindex)));
                        break;
                    default:
                        System.out.printf("Persoon met naam: %s en woonplaats %s " +
                                        "uit het bestand kon niet verwerkt worden wegens onbekend type: %s",
                                naam, woonplaats, type);
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Personenbestand kon niet geopend worden " + fileNotFoundException.getMessage());
        }

        return personen;
    }

    private static ArrayList<Afdeling> leesAfdelingenIn(String bestandspad) {
        ArrayList<Afdeling> afdelingen = new ArrayList<>();

        File afdelingenbestand = new File(bestandspad);

        try (Scanner afdelingenScanner = new Scanner(afdelingenbestand)) {
            while (afdelingenScanner.hasNextLine()) {
                String afdelingsnaam = afdelingenScanner.nextLine();
                String afdelingsplaats = afdelingenScanner.nextLine();

                afdelingen.add(new Afdeling(afdelingsnaam, afdelingsplaats));
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Het is niet gelukt het afdelingen bestand te openen: " +
                    fileNotFoundException.getMessage());
        }

        return afdelingen;
    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }
}
