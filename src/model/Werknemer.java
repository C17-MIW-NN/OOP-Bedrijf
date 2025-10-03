package model;

/**
 * @author Vincent Velthuizen
 * Specifieke eigenschappen van iemand die in dienst is bij ons bedrijf.
 */
public class Werknemer extends Persoon {
    private static final double GRENSWAARDE_BONUS = 4500;
    private static final double DEFAULT_MAANDSALARIS = 0.0;
    private static final int MAANDEN_PER_JAAR = 12;

    private double maandsalaris;

    public Werknemer(String naam, String woonplaats, Afdeling afdeling, double maandsalaris) {
        super(naam, woonplaats, afdeling);
        setMaandsalaris(maandsalaris);
    }

    public Werknemer(String naam) {
        super(naam);
        setMaandsalaris(DEFAULT_MAANDSALARIS);
    }

    public Werknemer() {
        // super(); impliciet
        setMaandsalaris(DEFAULT_MAANDSALARIS);
    }

    //    public Werknemer(String naam) {
//        this(naam, DEFAULT_WOONPLAATS, new Afdeling(), DEFAULT_MAAND_SALARIS);
//    }

    public boolean heeftRechtOpBonus() {
        return maandsalaris >= GRENSWAARDE_BONUS;
    }

    @Override
    public double berekenJaarinkomen() {
        return MAANDEN_PER_JAAR * maandsalaris + (heeftRechtOpBonus() ? maandsalaris : 0.0);
    }

    @Override
    public String toString() {
        return String.format("%s en is een werknemer %s recht op een bonus",
                super.toString(),
                heeftRechtOpBonus() ? "met" : "zonder");
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

