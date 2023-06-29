package ViewCL;
import Model.*;

public class CMenu {
    /**
     *   * Die main-Methode dient zum Start der Applikation. Sie instanziiert das
     *    * Hauptmenü und wertet in einer Schleife die Benutzeraktionen im Menü aus.
     *  *
     * * @param args Standard Kommandozeilenparameter, werden nicht weiter
     *  * verwendet
     * */
   // public static void main(String[] args) {
        // CMenu menue = new CMenu();
        // while (menue.aktion()) {
        // einfach immer wieder anzeigen
        //  }
        //  System.out.println();
        //  System.out.println("Besten Dank und auf Wiedersehen.");
    }
    /**
     * Die Benutzerschnittstelle verwaltet diesen Flugplatz
     */
    // private CAirport airport;

    /**
     * Konstruktor Bei der Konstruktion der Menüsteuerung wird auch gleich der
     * Flughafen gebaut
     */
    //  public CMenu() {
    //  airport = new CAirport();
    // }

    /**
     * Anzeige und Auswertung des Hauptmenüs
     *
     * @return gibt true zurueck, wenn das Menue nocheinmal angezeigt werden
     * soll. Bei f alse will der Benutzer die Applikation beenden
     */
    /* public boolean aktion() {
      while (true) {
       anzeigen();
         int eingabe = ConsoleReader.readInteger("Ihre Wahl");
          switch (eingabe) {
               case 1:
    //               landen();
                  return true;
                case 2:
    //               starten();
                   return true;
               case 3:
    //               gateDatenAnzeigen();
                   return true;
               case 4:
                   return false;
               default:
                   System.out.println("Ungueltige Wahl");
           }
        }
     }

    /**
     * Dient nur der reinen Anzeige der Menueoptionen
     */
    /* private void anzeigen() {
        System.out.println();
        System.out.println();
       System.out.println();
        System.out.println("Airport Scheduler Hauptmenü");
       System.out.println("===========================");
        System.out.println();
        System.out.println("1 Landen");
        System.out.println("2 Starten");
        System.out.println("3 Gatedaten");
        System.out.println();
        System.out.println("4 Ende");
     //}

    //  private void landen() {
    //  System.out.println("\n\n\nLanden...\n\n");
    //   CFlight flight = flugDatenBeschaffen();
    //   try {
    //  int gateNummer = airport.land(flight);
    //  System.out.println("Maschine ist an Gate " + gateNummer + " gelandet");
    // } catch (MyNoGateAvailableException ex) {
    //     System.out.println(ex.getMessage());
    //  }
     //}

    // private void starten() {
    //  System.out.println("\n\n\nstarten...\n\n");
    //   int gateNumber = ConsoleReader.readInteger("Gatenummer eingeben");
    // try {
    // CGate gate = airport.getGate(gateNumber);
    // if (gate.isFree()) {
    // System.out.println(

    //              "Das Gate ist nicht belegt, es gibt nichts zu starten!");
    // } else {
    //    System.out.println("Take-off Flug " + gate.getFlight().getNumber());
    //  }
    //  } catch (MyInvalidGateNumberException ex) {
    //   System.out.println(ex.getMessage());
    // }
    // }

    /* private void gateDatenAnzeigen() {
      System.out.println("\n\n\nGate Daten anzeigen...\n\n");
      int gateNummer = ConsoleReader.readInteger("Gatenummer eingeben");
     try {
        CGate gate = airport.getGate(gateNummer);
        if (gate.isFree()) {
            System.out.println("Gate ist frei\n\n\n");
            return;
       }
       if (gate instanceof CNationalGate) {
           System.out.println("Nationales Gate");
           System.out.println("---------------");
       } else {
           System.out.println("Internationales Gate");
            System.out.println("--------------------");
           System.out.println(gate.getSize() == CInternationalGate.BIG ? "Grosses Gate" : "kleines Gate");
        }
        System.out.println("Flugnummer: " + gate.getFlight().getNumber());
        System.out.println("Landezeit: " + gate.getFlight().getLandingTime());
        System.out.println("Startzeit: " + gate.getFlight().getStartingTime());
        System.out.println("Flugzeugtyp: " + (gate.getPlane().getType() == CPlane.JET ? "Jet" : "prop"));
        System.out.println("Kapazität: " + gate.getPlane().getCapacity());
      } catch (MyInvalidGateNumberException ex) {
       System.out.println(ex.getMessage());
    // }
    //  }

    // private CFlight flugDatenBeschaffen() {
    // CFlight flug = new CFlight();
    // System.out.println();
    //  System.out.println();
    //  System.out.println("Bitte Flugdaten eingeben");
    //  System.out.println("------------------------");
    // flug.setNumber(ConsoleReader.readInteger("Flugnummer"));
    // flug.setLandingTime(ConsoleReader.readString("Landezeit"));
    // flug.setStartingTime(ConsoleReader.readString("Startzeit"));
    // flug.setPlane(flugzeugDatenBeschaffen());
    // return flug;
    //  }

    // private CPlane flugzeugDatenBeschaffen() {
    // CPlane flugzeug = new CPlane();
    // flugzeug.setType(ConsoleReader.readInteger("Flugzeugtyp (0=Prop, 1=Jet)"));

    // flugzeug.setCapacity(ConsoleReader.readInteger("Passagierzahl"));
    // flugzeug.setRefuelTime(ConsoleReader.readString("Nachtankzeit"));
    // return flugzeug;
    // }

//}
*/
