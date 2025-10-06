package controller;

import model.Afdeling;
import model.Persoon;
import model.Werknemer;
import model.ZZper;

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

        Werknemer baas = new Werknemer("Mark", "Den Haag", afdelingen[2], 10000);
        Werknemer medewerker = new Werknemer("Caroline", "Delft", afdelingen[1], 4000);
        ZZper assistent = new ZZper("Klaas", "Diemen", afdelingen[3], 50);
        ZZper projectleider = new ZZper("Ronald", "Zaandam", afdelingen[0], 80.0);

        assistent.huurIn(160);
        projectleider.huurIn(320);

        Persoon[] personen = {
                baas,
                medewerker,
                assistent,
                projectleider};

        System.out.printf("Het aantal personen in het bedrijf is %d\n", Persoon.getAantalPersonen());
        System.out.println(baas);
        System.out.println(medewerker);
        System.out.println(assistent);

        System.out.println();
        for (Persoon persoon : personen) {
            toonJaarinkomen(persoon);
        }
    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }
}
