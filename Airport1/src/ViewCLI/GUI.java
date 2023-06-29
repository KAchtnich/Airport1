package ViewCLI;

import Model.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GUI {// Felder
    private JPanel panel; // die Felder welches das Gui ausmachen
    private JPanel Buttonsholder2;
    private JPanel Flug;
    private JPanel Buttomsholder1;
    private JButton startenButton;
    private JButton landenButton;
    private JButton gatesButton;
    private JLabel GateTitel;
    private JTextField Gates;
    private JTextField Flugnummer;
    private JLabel FlugnummerTitel;
    private JTextField Starten;
    private JTextField Landen;
    private JLabel StartenTitel;
    private JLabel LandezeitTitel;
    private JButton Loschen;
    private JPanel Schema;
    private JPanel G9Panel;
    private JPanel G6Panel;
    private JButton Clear;
    private JPanel G1Panel;
    private JPanel G7Panel;
    private JPanel G8Panel;
    private JPanel G10Panel;
    private JPanel G3Panel;
    private JPanel G2Panel;
    private JPanel G4Panel;
    private JPanel G5Panel;
    private JLabel G1Titel;
    private JLabel G2Titel;
    private JLabel G3Titel;
    private JLabel G4Titel;
    private JLabel G5Titel;
    private JLabel G6Titel;
    private JLabel G7Titel;
    private JLabel G8Titel;
    private JLabel G9Titel;
    private JLabel G10Titel;
    private JPanel Flughafen;
    private JLabel TitelGate;
    private JLabel G1Label;
    private JLabel G2Label;
    private JLabel G3Label;
    private JLabel G4Label;
    private JLabel G5Label;
    private JLabel G6Label;
    private JLabel G7Label;
    private JLabel G8Label;
    private JLabel G9Label;
    private JLabel G10Label;
    private JTextField International;
    private JLabel InternationalTitel;
    private JLabel AusgabeTitel;
    private JTextField Ausgabe;
    private JLabel CapicityTitel;
    private JTextField Kapazität;
    private JLabel TypTitel;
    private JTextField RefuelTime;
    private JLabel RefuelTimeTitel;
    private JPanel Flugzeug;
    private JTabbedPane Tablator;
    private JTextField Typ;
    private JSeparator Sep1;
    private JPanel Panel1234;
    private JPanel GateInfo;
    private JLabel SizeTitel;
    private JTextField Size;
    private JLabel GateTypusTitel;
    private JTextField GateTypus;
    private JTextField Nummer;
    private JLabel NummerTitel;

    private CAirport airport = new CAirport();//Initialisierung Airport


    // Main
    public static void main(String[] args) { // Main
        JFrame frame = new JFrame("GUI");
        frame.setContentPane(new GUI().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


    public GUI() {
        // Flughafen Namen Setzten
        airport.setName("Aikido");
        TitelGate.setText("Flughafen " + airport.getName());

        // Starten
        startenButton.addActionListener(new ActionListener() { // Starten
            public void actionPerformed(ActionEvent e) { // Starten
                try {
                    String Gate = Gates.getText();// Input
                    GateInfos(airport.gate[StringtoInt(Gate)-1]);
                    CFlight d = airport.gate[StringtoInt(Gate)-1].getFlight();
                    String land = d.getLandingTime();
                    String start = d.getStartingTime();
                    int k  = d.getNumber();
                    Flugnummer.setText(intToString(k));
                    Landen.setText(land);
                    Starten.setText(start);
                    CPlane x = d.getPlane();
                    String c = x.getRefuelTime();
                    EType f = x.getType();
                    int y = x.getCapacity();

                    CGate b = airport.gate[StringtoInt(Gate)-1]; // Flug Löschen
                    b.deleteFlight();
                    RefuelTime.setText(c);
                    if (d.isNational()) {
                        International.setText("Nein");
                    }
                    if (!d.isNational()) {
                        International.setText("Ja");
                    }
                    Kapazität.setText(intToString(y));
                    if (f == EType.JET) {
                        Typ.setText("Jet");
                    }
                    if (f == EType.PROP) {
                        Typ.setText("Propeller");
                    }
                    Ausgabe.setText("Dieser Flug startet."); // Ausgabe
                    Starten.setText(d.getStartingTime());
                    SchemaUpdater();
                } catch (Exception e1) {
                    Ausgabe.setText("* :bitte ausfüllen");
                    Gates.setText("*");
                }

            }
        });

        // Gates Infos holen
        gatesButton.addActionListener(new ActionListener() { //Gates Info
            public void actionPerformed(ActionEvent e) { // Gates Information geben
                try {
                    String GateNumber = Gates.getText(); // Gate Input
                    int Gate = StringtoInt(GateNumber);
                    GateInfos(airport.gate[Gate-1]);

                    if (airport.gate[Gate - 1].isFree()) { // ist Frei
                        Ausgabe.setText("Das Gate ist Frei");
                    } else {
                        CFlight x = airport.gate[Gate - 1].getFlight(); // alle Infos bekommen
                        int d = x.getNumber();
                        String land = x.getLandingTime();
                        String start = x.getStartingTime();
                        CPlane g = x.getPlane();
                        Flugnummer.setText(intToString(d));
                        Landen.setText(land);
                        Starten.setText(start);
                        if (x.isNational()) {
                            International.setText("Nein");
                        }
                        if (!x.isNational()) {
                            International.setText("Ja");
                        }
                        Ausgabe.setText("");
                        int cap = g.getCapacity();
                        Kapazität.setText(intToString(cap));
                        EType k = g.getType();
                        if (k == EType.JET) {
                            Typ.setText("Jet");
                        }
                        if (k == EType.PROP) {
                            Typ.setText("Propeller");
                        }
                        String refuel = g.getRefuelTime();
                        RefuelTime.setText(refuel);
                        Ausgabe.setText("Vollständig");
                    }
                }
                catch(Exception e1){
                    Ausgabe.setText("* :bitte ausfüllen");
                    Gates.setText("*");
                }
            }
        });

        // Landen
        landenButton.addActionListener(new ActionListener() { // Landen
            public void actionPerformed(ActionEvent e) { // Landen
                try {
                    CFlight flight = new CFlight();
                    CPlane Plane = new CPlane();
                    String flug = Flugnummer.getText(); // Input bekommen
                    String land = Landen.getText();
                    String start = Starten.getText();
                    String Capatity = Kapazität.getText();
                    String RefuelTime1 = RefuelTime.getText();
                    flight.setNumber(StringtoInt(flug));  // Setzen der Input
                    flight.setLandingTime(land);
                    flight.setStartingTime(start);
                    Plane.setCapacity(StringtoInt(Capatity));
                    Plane.setRefuelTime(RefuelTime1);
                    Plane.setType();
                    EType k = Plane.getType();
                    if (k == EType.JET) {
                        Typ.setText("Jet");
                    }
                    if (k == EType.PROP) {
                        Typ.setText("Propeller");
                    }
                    flight.setPlane(Plane);
                    if (flight.isNational()) {
                        International.setText("Nein");
                    }
                    if (!flight.isNational()) {
                        International.setText("Ja");
                    }
                    if(!airport.isFull()) {
                        CGate b = airport.searchFreeGate(flight);// ein Freie Gate Suchen
                        GateInfos(b);
                        b.setFlight(flight);
                        int gate = b.getNumber();
                        Gates.setText(intToString(gate)); // Gates Setzten
                        SchemaUpdater();
                        Ausgabe.setText("Vollständig");
                        Ausgabe.setText("Flug  am landen"); // Korrektur von anderen
                        Landen.setText(flight.getStartingTime());// Indikator Fragen
                    }
                    else{
                        Ausgabe.setText("Alle Gates sind besetzt.");
                    }

                }
                catch(Exception e2){
                    Flugnummer.setText("*");
                    Landen.setText("*");
                    Starten.setText("*");
                    Kapazität.setText("*");
                    RefuelTime.setText("*");
                    Ausgabe.setText("* :bitte ausfüllen");
                }
            }
        });

        Clear.addActionListener(new ActionListener() { // Alle Felder leer machen
            public void actionPerformed(ActionEvent e) { // alle Felder löschen
                Flugnummer.setText("");  // Alle Felder leer
                Gates.setText("");
                Landen.setText("");
                Starten.setText("");
                International.setText("");
                Ausgabe.setText("");
                Kapazität.setText("");
                Typ.setText("");
                RefuelTime.setText("");
                GateTypus.setText("");
                Nummer.setText("");
                Size.setText("");
            }
        });

        // Panel Interaktiv
        G1Panel.addMouseListener(new MouseAdapter() { // Panel 1 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("1");
                GateInfos(airport.gate[0]);
            }
        });
        G2Panel.addMouseListener(new MouseAdapter() { // Panel 2 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("2");
                GateInfos(airport.gate[1]);
            }
        });
        G3Panel.addMouseListener(new MouseAdapter() { // Panel 3 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("3");
                GateInfos(airport.gate[2]);
            }
        });
        G4Panel.addMouseListener(new MouseAdapter() { // Panel 4 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("4");
                GateInfos(airport.gate[3]);
            }
        });
        G5Panel.addMouseListener(new MouseAdapter() { // Panel 5 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("5");
                GateInfos(airport.gate[4]);
            }
        });
        G6Panel.addMouseListener(new MouseAdapter() { // Panel 6 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("6");
                GateInfos(airport.gate[5]);
            }
        });
        G7Panel.addMouseListener(new MouseAdapter() { // Panel 7 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("7");
                GateInfos(airport.gate[6]);
            }
        });
        G8Panel.addMouseListener(new MouseAdapter() { // Panel 8 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("8");
                GateInfos(airport.gate[7]);
            }
        });
        G9Panel.addMouseListener(new MouseAdapter() { // Panel 9 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("9");
                GateInfos(airport.gate[8]);
            }
        });
        G10Panel.addMouseListener(new MouseAdapter() { // Panel 10 Interaktiv
            @Override
            public void mousePressed(MouseEvent mouseEvent) {
                super.mousePressed(mouseEvent);
                Gates.setText("10");
                GateInfos(airport.gate[9]);
            }
        });
    }

    // Umwandlungen
    private String intToString(int x){ // Diese Funktion macht int to Strings
        String c = x + "";
        return c;
    }

    private int StringtoInt(String x){ // Diese Funktion macht String to Ints
        String d = x.trim();
        int y = Integer.parseInt(d);
        return y;
    }

    // Schema
    private void SchemaUpdater(){ // Diese Funktion updated das Schema auf den aktuellen Stand

        boolean G1bool = airport.gate[0].isFree(); // alle Gates herausfinden ob Frei
        boolean G2bool = airport.gate[1].isFree();
        boolean G3bool = airport.gate[2].isFree();
        boolean G4bool = airport.gate[3].isFree();
        boolean G5bool = airport.gate[4].isFree();
        boolean G6bool = airport.gate[5].isFree();
        boolean G7bool = airport.gate[6].isFree();
        boolean G8bool = airport.gate[7].isFree();
        boolean G9bool = airport.gate[8].isFree();
        boolean G10bool = airport.gate[9].isFree();

        String Frei = "Frei"; // Variabeln
        String Besetzt = "Besetzt";

        String G1Status = Frei; // Der Status jedes Gates
        String G2Status = Frei;
        String G3Status = Frei;
        String G4Status = Frei;
        String G5Status = Frei;
        String G6Status = Frei;
        String G7Status = Frei;
        String G8Status = Frei;
        String G9Status = Frei;
        String G10Status = Frei;

        String G1Status1 = StatusChange(G1bool,G1Status); // Status in String wechseln
        String G2Status1 = StatusChange(G2bool, G2Status);
        String G3Status1 = StatusChange(G3bool,G3Status);
        String G4Status1 = StatusChange(G4bool,G4Status);
        String G5Status1 = StatusChange(G5bool,G5Status);
        String G6Status1 = StatusChange(G6bool,G6Status);
        String G7Status1 = StatusChange(G7bool,G7Status);
        String G8Status1 = StatusChange(G8bool,G8Status);
        String G9Status1 = StatusChange(G9bool,G9Status);
        String G10Status1 = StatusChange(G10bool,G10Status);

        G1Label.setText(G1Status1); // Konfiguration des Schemas
        G2Label.setText(G2Status1);
        G3Label.setText(G3Status1);
        G4Label.setText(G4Status1);
        G5Label.setText(G5Status1);
        G6Label.setText(G6Status1);
        G7Label.setText(G7Status1);
        G8Label.setText(G8Status1);
        G9Label.setText(G9Status1);
        G10Label.setText(G10Status1);

    }

   private String StatusChange(boolean bool ,String state){ // Dies ist part von SchemaUpdater()
        String Frei = "Frei"; // Gleiche Variabelnn wie Oben
        String Besetzt = "Besetzt";

        if(!bool){ // Switch der Strings
            state = Besetzt;
        }
        else{
            state = Frei;
        }
        return state; // Rückgabe
    }

    // Gates Info Anzeigen
    private void GateInfos(CGate b){
        int k = b.getNumber();
        switch(k){
            case 1:// National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 2: // National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 3:// National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 4:// international Big
                Nummer.setText(intToString(k));
                GateTypus.setText("International");
                Size.setText("Big");
                break;
            case 5:// international Big
                Nummer.setText(intToString(k));
                GateTypus.setText("International");
                Size.setText("Big");
                break;
            case 6:// International Small
                Nummer.setText(intToString(k));
                GateTypus.setText("International");
                Size.setText("Small");
                break;
            case 7:// National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 8: // National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 9:// National
                Nummer.setText(intToString(k));
                GateTypus.setText("National");
                Size.setText("-");
                break;
            case 10:// International Small
                Nummer.setText(intToString(k));
                GateTypus.setText("International");
                Size.setText("Small");
                break;
        }
    }


}
