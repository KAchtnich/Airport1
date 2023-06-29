package Model;

/**
 * Diese Klasse stellt ein Flugzeug dar.
 * Das Flugzeug hat folgende Eigenschaften:
 * Type, capicity und Zeit wie lange es braucht wieder der Tank aufgefüllt ist.
 */
public class CPlane {
    private EType type;
    private int capacity;
    private String refuelTime;


    public CPlane() {
    }

    /**
     * Getter von EType
     * @return type
     */
    public EType getType() {
        return type;
    }

    /**
     * Setter von EType
     * Wenn die Kapazität kleiner ist als 200 dann kann es nur Prop sein.
     * Nonsense Eingaben werden rausgetan.
     */
    public EType setType() {
        if (capacity >= 200) {
            type = EType.PROP;
        } else {
            type = EType.JET;
        }
        return type;
    }

    /**
     * getter von capacity
     * @return capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * setter von Capacity
     * @param capacity
     *
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    /**
     * getter von Refueltime
     * @return refueltime
     */
    public String getRefuelTime() {
        return refuelTime;
    }

    /**
     * setter von Refueltime
     * @param refuelTime
     */
    public void setRefuelTime(String refuelTime) {
        this.refuelTime = refuelTime;
    }

    /**
     * boolean welcher bestimmt ob Flugzeug gross ist
     * @return boolean ob gross ist oder nicht
     */
    public boolean isBig() {
        boolean d = false;
        if (capacity >= 200) {
            d = true;
        }
        return d;
    }
}

