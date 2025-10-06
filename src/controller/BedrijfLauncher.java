package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.ZZPer;

import java.util.ArrayList;

/**
 * @author Vincent Velthuizen
 * Run mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Afdeling[] afdelingen = new Afdeling[4];

        afdelingen[0] = new Afdeling("Uitvoering", "Hilversum");
        afdelingen[1] = new Afdeling("Support", "Amsterdam");
        afdelingen[2] = new Afdeling("Management", "Almere");
        afdelingen[3] = new Afdeling("Documentatie", "Gouda");

        ArrayList<Persoon> personen = new ArrayList<>();

        personen.add(new Werknemer("Mark", "Den Haag", afdelingen[2], 10000));
        personen.add(new Werknemer("Angelique", "Rotterdam", afdelingen[2], 5000));
        personen.add(new Werknemer("Caroline", "Delft", afdelingen[1], 4000));
        personen.add(new ZZPer("Klaas", "Diemen", afdelingen[3], 50.00));
        personen.add(new ZZPer("Ronald", "Zaandam", afdelingen[0], 80.00));
        personen.add(new ZZPer("Jannie", "Utrecht", afdelingen[0], 60.00));
        personen.add(new ZZPer("Anne", "Zwolle", afdelingen[0], 40.00));

        for (Persoon persoon : personen) {
            if (persoon instanceof ZZPer) {
                ((ZZPer) persoon).huurIn(320);
            }
        }

        System.out.println();
        for (Persoon persoon : personen) {
            toonJaarinkomen(persoon);
        }
    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }
}
