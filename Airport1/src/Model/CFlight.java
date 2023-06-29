package Model;

/**
 * Diese Klasse stellt die Fluege dar.
 *
 */
public class CFlight {
    private int number;
    private CPlane Plane;
    private String landingTime;
    private String startingTime;

    /**
     * Initiator von CFlight
     */
    public CFlight() {
    }

    /**
     * dieser Boolean schaut ob der Flug National ist oder nicht.
     * Er funktioniert durch testen der flugnummer ob sie über bestimmte werte hat.
     * Dadurch kann man herausfinden ob National oder nicht.
     *
     * @return
     */
    public Boolean isNational() { // ToDo
        boolean k = true;
        if (number < 1000) {
            k = true;
        }
        if (number >= 1000) {
            k = false;
        }
        return k;
    }

    /**
     * getter von Number
     *
     * @return
     */
    public int getNumber() {
        return number;
    }

    /**
     * Setter von Number
     *
     * @param number
     */
    public void setNumber(int number) {
        this.number = number;
    }

    /**
     * Getter von CPlane
     *
     * @return Plane
     */
    public CPlane getPlane() {
        return Plane;
    }

    /**
     * setter von Plane
     * kann selber entscheiden welchen typ von flugzeug durch isNational. Wenn unsicher bei EType Wahl.
     *
     *
     */
    public void setPlane(CPlane plane1) {
        this.Plane = plane1;
    }

    /**
     * getter LandingTime
     *
     * @return landingTime
     */
    public String getLandingTime() {
        return landingTime;
    }

    /**
     * setter LandingTime
     *
     * @param landingTime
     */
    public void setLandingTime(String landingTime) {
        this.landingTime = landingTime;
    }

    /**
     * getter StartingTime
     *
     * @return startingTime
     */
    public String getStartingTime() {
        return startingTime;
    }

    /**
     * setter StartingTime
     *
     * @param startingTime
     */
    public void setStartingTime(String startingTime) {
        this.startingTime = startingTime;
    }
    // Landen und starten bei CMenue
    public void land(int nr) {
        System.out.println(nr + "landet.");
    }
    public void start(int nr){
        System.out.println(nr + "Startet");
    }

}