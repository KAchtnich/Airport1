package ViewCL;
import Model.*;

public class CMenue {
    /**
     *   * Die main-Methode dient zum Start der Applikation. Sie instanziiert das
     *    * Hauptmenü und wertet in einer Schleife die Benutzeraktionen im Menü aus.
     *  *
     * * @param args Standard Kommandozeilenparameter, werden nicht weiter
     *  * verwendet
     * */
    CAirport a = new CAirport();
    public static void main(String[] args) {
        CMenue Menu= new CMenue();
        while(Menu.wahlen()){
        }
        System.out.println("---------------------");
        System.out.println("kommen Sie wieder");

    }
    // Das ist der Instruktior von CMenue
    public CMenue(){
    }

    // Das ist die Anzeige ganz am Anfang
    private void anzeige(){
        System.out.println("Herzlich Wilkomen" );
        System.out.println("Am Flughafen");
        System.out.println("-------------------------------");
        System.out.println("Hauptmenue");
        System.out.println("-------------------------------");
        System.out.println("1. Landen");
        System.out.println("2. Starten");
        System.out.println("3. Exit");
        System.out.println("-------------------------------");

    }

    // das ist der Switch für die Auswahl
    private boolean wahlen(){
        while(true){
            anzeige();
            int wahl = ConsoleReader.readInteger("Ihre Wahl: ");
            switch(wahl){
                case 1:
                    landen();
                    return true;
                case 2:
                    starten();
                    return true;
                case 3:
                    System.out.println("Auf Wiedersehen");
                    System.exit(0);
                default:
                    System.out.println("auswahl ungültig");
                    return false;
            }
        }
    }

    // Das ist der Unterordner für landen
    private void landen(){
        int Flugnummer = ConsoleReader.readInteger("Flugnummer");
        CFlight k = new CFlight();
        k.land(Flugnummer);
        a.searchFreeGate(k);
        a.land(k);
    }
    // Das ist der Unterordner für starten
    private void starten(){
        int Flugnummer = ConsoleReader.readInteger("Flugnummer");
        CFlight k = new CFlight();
        k.start(Flugnummer);

    }

}
