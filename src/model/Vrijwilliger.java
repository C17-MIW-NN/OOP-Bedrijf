package model;

/**
 * @author Vincent Velthuizen
 * Purpose for the class
 */
public class Vrijwilliger extends Persoon implements Oproepbaar {
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private static final int JAARINKOMEN_VRIJWILLIGER = 0;

    private int urenGewerkt;

    public Vrijwilliger(String naam, String woonplaats, Afdeling afdeling) {
        super(naam, woonplaats, afdeling);
        urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public double berekenJaarinkomen() {
        return JAARINKOMEN_VRIJWILLIGER;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public String toString() {
        return String.format("%s en is een vrijwilliger", super.toString());
    }
}
