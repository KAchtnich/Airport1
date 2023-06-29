package Model;

/**
 * @author Achtnich Karin
 * @Version 1.0
 *
 */
/**
 * CAirport ist der Gesammte Flughafen in einer Klasse
 *
 */
public class CAirport {
    private String name; //Name

    // die Gates
    private CNationalGate G1 = new CNationalGate(1);
    private CNationalGate G2 = new CNationalGate(2);
    private CNationalGate G3 = new CNationalGate(3);
    private CInternationalGate G4 = new CInternationalGate(ESize.BIG, 4);
    private CInternationalGate G5 = new CInternationalGate(ESize.BIG, 5);
    private CInternationalGate G6 = new CInternationalGate(ESize.SMALL, 6);
    private CNationalGate G7 = new CNationalGate(7);
    private CNationalGate G8 = new CNationalGate(8);
    private CNationalGate G9 = new  CNationalGate(9);
    private CInternationalGate G10 = new CInternationalGate(ESize.SMALL, 10);
    public CGate[] gate = {G1,G2,G3,G4,G5,G6,G7,G8,G9,G10};
    /**
     * Das ist der Initiatior von CAirport
     */
    public CAirport() {
    }

    /**
     *  Getter Name
     * @return der Getter von Name gibt den Namen des  Flughafens zuruek
     */
    public String getName() {
        return name;
    }

    /**
     *setter von Name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *, Es gibt einen String zurück, welches angibt, welches Flugzeug gelandet ist und wann. Dadurch
     * weiss das Programm, dass ein CGate besetzt wird.
     * @param A CFlight
     * @return string
     */
    public String land(CFlight A) {
        CGate x = searchFreeGate(A);
        x.setFlight(A);
        String d = "Das Flugzeug" + A.getNumber() + "ist gelandet am Gate" + x;
        System.out.println(d);
        return d;
    }

    /**
     * Suche für freie Gates
     * @param a CFlight
     * @return boolean
     */
    public CGate searchFreeGate(CFlight a) {
        boolean c = a.isNational();
        int k = 0;
        CPlane d = a.getPlane();
        if (c){ // National
            if(G9.isFree()){
                k = 9;
            }
            if(G8.isFree()){
                k = 8;
            }
            if(G7.isFree()){
                k = 7;
            }
            if(G3.isFree()){
                k = 3;
            }
            if(G2.isFree()){
                k = 2;
            }
            if(G1.isFree()){
                k = 1;
            }
        }
        if(!c){ // Internation
            if(G10.isFree() && !d.isBig()){
                k = 10;
            }
            if(G6.isFree() && !d.isBig()){
                k = 6;
            }
            if(G5.isFree() && d.isBig()){
                k = 5;
            }
            if(G4.isFree() && d.isBig()){
                k = 4;
            }
        }
        return gate[k-1];
    }

    public boolean isFull(){
        boolean d = false;
        if(!G10.isFree() && !G6.isFree()){
            d = true;
        }
        if(!G5.isFree() && !G4.isFree()){
            d = true;
        }
        if(!G1.isFree() && !G2.isFree() && !G3.isFree() && !G7.isFree() && !G8.isFree() && !G9.isFree()){
            d = true;
        }
        return d;
    }

    /**
     *getter von GateNumber
     * @param a CFlight
     * @return Gatenumber
     */
    public int getGateNumber(CFlight a) {
        int k = 0;
        for(int x = 0;x<10;x++) {
            CFlight d = gate[x].getFlight();
            if (a.equals(d)) {
                k = gate[1].getNumber();
            }
        }
        return k;
    }
}
