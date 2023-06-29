package Model;

/**
 * Diese Klasse stellt die Gates dar.
 * Es ist eine abstrakte Klasse.
 *
 */
public abstract class CGate {
    private int number;
    private CFlight flight = null;

    /**
     * CGate Initiator von CGate
     * @param number
     */
    public CGate(int number) {
        this.number = number;
    }

    /**
     * landen eines Flugzeuges
     * @param flight
     * @return String
     */

    public String land(CFlight flight) {
        String d ="Das Flugzeug " + flight + "ist am Gate " + number;
        return d;
    }

    /**
     * Flugzeug starten
     * @return String
     */
    public String start() {
        String k = "Das Flugzeug am Gate" + number + "ist gestartet";
        return k;
    }

    /**
     *  getter Number
     * @return number
     */
    public int getNumber() {
        return number;
    }

    /**
     * setter von Number
     * @param number
     * @retrun number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Gettter von CFlight
     * @return flight
     */
    public CFlight getFlight() {
        return flight;
    }

    /**
     * setter von CFlight
     * @param flight
     * @return flight
     */
    public void setFlight(CFlight flight) {
        this.flight = flight;
    }

    /**
     * schaut ob das Gate Frei ist
     * @return boolean
     */
    public Boolean isFree() {
        boolean d = true;
        if(flight == null){
            d = true;
        }
        else{
            d = false;
        }
        return d;
    }
    // Flug löschen von CGate
    public void deleteFlight(){ flight = null;}
}


