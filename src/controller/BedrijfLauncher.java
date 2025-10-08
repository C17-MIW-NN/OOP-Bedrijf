package controller;

import model.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author Vincent Velthuizen
 * Run mijn bedrijf
 */
public class BedrijfLauncher {

    public static void main(String[] args) {
        Scanner toetsenbord = new Scanner(System.in);

        System.out.print("Geef de naam: ");
        String naam = toetsenbord.next();

        System.out.print("Geef de woonplaats: ");
        String woonplaats = toetsenbord.next();

        System.out.print("Geef de naam van de afdeling: ");
        String afdelingsnaam = toetsenbord.next();

        System.out.print("Geef de plaats van de afdeling: ");
        String afdelingsplaats = toetsenbord.next();

        Afdeling afdeling = new Afdeling(afdelingsnaam, afdelingsplaats);

//        Werknemer werknemer = null;
        boolean gelukt = false;
        do {
            System.out.print("Geef het maandsalaris: ");
            double maandsalaris = toetsenbord.nextDouble();

            try {
                Werknemer werknemer = new Werknemer(naam, woonplaats, afdeling, maandsalaris);
                System.out.println(werknemer);
                gelukt = true;
            } catch (IllegalArgumentException illegalArgumentException) {
                System.out.println(illegalArgumentException.getMessage());
            } finally {
                System.out.println("Je invoer is op de juiste wijze afgehandeld.");
            }
        } while (!gelukt);

    }

    public static void toonJaarinkomen(Persoon persoon) {
        System.out.printf("%s verdient %.2f per jaar\n", persoon.getNaam(), persoon.berekenJaarinkomen());
    }
}
