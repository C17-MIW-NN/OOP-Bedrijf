package model;

/**
 * @author Vincent Velthuizen
 * Een persoon die betrokken is bij ons bedrijf.
 */
public class Persoon {
    private static final double GRENSWAARDE_BONUS = 4500;
    private static final int MAANDEN_PER_JAAR = 12;

    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final double DEFAULT_MAANDSALARIS = 0.0;

    private static int aantalPersonen = 0;

    private int personeelsNummer;
    private String naam;
    private String woonplaats;
    private double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        setMaandsalaris(maandsalaris);

        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this(naam, DEFAULT_WOONPLAATS, DEFAULT_MAANDSALARIS);
    }

    public Persoon() {
        this(DEFAULT_NAAM);
    }

    public double berekenJaarinkomen() {
        return MAANDEN_PER_JAAR * maandsalaris;
    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    public static int getAantalPersonen() {
        return aantalPersonen;
    }

    public int getPersoneelsNummer() {
        return personeelsNummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public double getMaandsalaris() {
        return maandsalaris;
    }

    private void setMaandsalaris(double maandsalaris) {
        if (maandsalaris < 0) {
            System.err.printf("%.2f is een ongeldig maandsalaris, maandsalaris wordt op %.2f gezet.",
                    maandsalaris, DEFAULT_MAANDSALARIS);
            maandsalaris = DEFAULT_MAANDSALARIS;
        }

        this.maandsalaris = maandsalaris;
    }
}
