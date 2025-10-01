package model;

/**
 * @author Vincent Velthuizen
 * Een persoon die betrokken is bij ons bedrijf.
 */
public class Persoon {
    private static final String DEFAULT_NAAM = "Onbekend";
    private static final String DEFAULT_WOONPLAATS = "Onbekend";
    private static final int DEFAULT_MAANDSALARIS = 0;
    private static final int MAANDEN_PER_JAAR = 12;

    public static int aantalPersonen = 0;

    public int personeelsNummer;
    public String naam;
    public String woonplaats;
    public double maandsalaris;

    public Persoon(String naam, String woonplaats, double maandsalaris) {
        this.naam = naam;
        this.woonplaats = woonplaats;
        this.maandsalaris = maandsalaris;

        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon(String naam) {
        this.naam = naam;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandsalaris = DEFAULT_MAANDSALARIS;

        this.personeelsNummer = ++aantalPersonen;
    }

    public Persoon() {
        this.naam = DEFAULT_NAAM;
        this.woonplaats = DEFAULT_WOONPLAATS;
        this.maandsalaris = DEFAULT_MAANDSALARIS;

        this.personeelsNummer = ++aantalPersonen;
    }

    public double berekenJaarinkomen() {
        return MAANDEN_PER_JAAR * maandsalaris;
    }
}
