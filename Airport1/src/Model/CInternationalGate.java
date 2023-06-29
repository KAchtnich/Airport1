package Model;

/**
 * Diese Stellen die lnternational Klassen dar.
 * Diese Klasse ist abhängig von CGate.
 */
public class CInternationalGate extends CGate {
    private ESize size;

    /**
     * initiator von CInternationalGate
     * @param Size
     * @param number
     */
    public CInternationalGate(ESize Size, int number) {
        super(number);
    }

    /**
     * getter von ESize
     * @return size
     */
    public ESize getSize() {
        return size;
    }

    /**
     * setter von ESize size
     * @param size
     */
    public void setSize(ESize size) {
        this.size = size;
    }
}
