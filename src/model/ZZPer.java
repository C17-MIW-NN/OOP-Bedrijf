package model;

/**
 * @author Vincent Velthuizen
 * Iemand die op oproep basis voor ons bedrijf werkt.
 */
public class ZZPer extends Persoon implements Oproepbaar {
    private static final int DEFAULT_UREN_GEWERKT = 0;
    private double uurtarief;
    private int urenGewerkt;

    public ZZPer(String naam, String woonplaats, Afdeling afdeling, double uurtarief) {
        super(naam, woonplaats, afdeling);
        this.uurtarief = uurtarief;
        this.urenGewerkt = DEFAULT_UREN_GEWERKT;
    }

    @Override
    public void huurIn(int uren) {
        urenGewerkt += uren;
    }

    @Override
    public double berekenJaarinkomen() {
        return urenGewerkt * uurtarief;
    }

    @Override
    public String toString() {
        return String.format("%s en is een ZZP-er met een uurtarief van %s", super.toString(), this.uurtarief);
    }
}
