package Model;

/**
 * Diese Klasse stellt die Nationalen Gates im Flughafen dar.
 *
 */
public class CNationalGate extends CGate {
    /**
     * Initator von CNationalGate
     * @param number
     */
    public CNationalGate(int number) {
        super(number);
    }
    ESize size;
    /**
     * Getter von Size
     * @return size
     */
    public ESize getSize() {
        size = ESize.SMALL;
        return size;
    }
}
