import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
// gitin

/**
 * Created by Denis on 28.01.2016.
 */
public class FrameHolder {

    public FrameHolder() {
        JFrame frame = new JFrame("BFT-Rechner");
        frame.add(Panelserstellen());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    private JPanel Panelserstellen() {

        JPanel panelAlles = new JPanel(new BorderLayout());
        JPanel gesamtEingabePanel = new JPanel(new BorderLayout());
        JPanel eingabePanel = new JPanel(new GridLayout(0, 2));
        JPanel buttonPanel = new JPanel(new BorderLayout());

        JTextField sprintText = new JTextField("Sprint 10x11m in s: ", 5);
        sprintText.setEditable(false);
        JTextField sprintEingabe = new JTextField(20);

        JTextField klimmhangText = new JTextField("Klimmhang in s: ", 5);
        klimmhangText.setEditable(false);
        JTextField klimmhangEingabe = new JTextField(20);

        JTextField laufText = new JTextField("1000m-Lauf in s: ", 5);
        laufText.setEditable(false);
        JTextField laufEingabe = new JTextField(20);

        JTextField alterText = new JTextField("Alter in Jahren: ", 5);
        alterText.setEditable(false);
        JTextField alter = new JTextField(3);


        eingabePanel.add(sprintText);
        eingabePanel.add(sprintEingabe);
        eingabePanel.add(klimmhangText);
        eingabePanel.add(klimmhangEingabe);
        eingabePanel.add(laufText);
        eingabePanel.add(laufEingabe);
        eingabePanel.add(alterText);
        eingabePanel.add(alter);


        gesamtEingabePanel.add(eingabePanel, BorderLayout.NORTH);
        gesamtEingabePanel.add(buttonPanel, BorderLayout.CENTER);

        JPanel gesamtAusgabePanel = new JPanel(new GridLayout(5, 3));

//        Headings
        JTextField disziplin = new JTextField("Displin");
        disziplin.setEditable(false);
        JTextField ergebnisWert = new JTextField("Punkte");
        ergebnisWert.setEditable(false);
        JTextField note = new JTextField("Note");
        note.setEditable(false);
        gesamtAusgabePanel.add(disziplin);
        gesamtAusgabePanel.add(ergebnisWert);
        gesamtAusgabePanel.add(note);


        JTextField headingSprint = new JTextField("Sprint: ");
        headingSprint.setEditable(false);
        gesamtAusgabePanel.add(headingSprint);
        JTextField ergebnisSprint = new JTextField();
        ergebnisSprint.setEditable(false);
        gesamtAusgabePanel.add(ergebnisSprint);
        JTextField noteSprint = new JTextField();
        noteSprint.setEditable(false);
        gesamtAusgabePanel.add(noteSprint);

        //          Disziplin:
        JTextField headingKlimm = new JTextField("Klimmhang: ");
        headingKlimm.setEditable(false);
        gesamtAusgabePanel.add(headingKlimm);
//        Punktwert:
        JTextField ergebnisKlimm = new JTextField();
        ergebnisKlimm.setEditable(false);
        gesamtAusgabePanel.add(ergebnisKlimm);
//        Note:
        JTextField noteKlimm = new JTextField();
        noteKlimm.setEditable(false);
        gesamtAusgabePanel.add(noteKlimm);

        JTextField headingLauf = new JTextField("Lauf: ");
        headingLauf.setEditable(false);
        gesamtAusgabePanel.add(headingLauf);
        JTextField ergebnisLauf = new JTextField();
        ergebnisLauf.setEditable(false);
        gesamtAusgabePanel.add(ergebnisLauf);
        JTextField noteLauf = new JTextField();
        noteLauf.setEditable(false);
        gesamtAusgabePanel.add(noteLauf);

//          Gesamtrechnung
        JTextField headingGesamt = new JTextField("Gesamt: ");
        headingGesamt.setEditable(false);
        gesamtAusgabePanel.add(headingGesamt);
        JTextField ergebnisGesamt = new JTextField();
        ergebnisGesamt.setEditable(false);
        gesamtAusgabePanel.add(ergebnisGesamt);
        JTextField noteGesamt = new JTextField();
        noteGesamt.setEditable(false);
        gesamtAusgabePanel.add(noteGesamt);

        JCheckBox frauBox = new JCheckBox("Frau", false);
        buttonPanel.add(frauBox, BorderLayout.CENTER);

        JButton auswerten = new JButton("Auswerten");
        buttonPanel.add(auswerten, BorderLayout.WEST);
        ActionListener Auswerter = new Rechner(klimmhangEingabe, sprintEingabe, laufEingabe, ergebnisKlimm, ergebnisSprint, ergebnisLauf, noteKlimm, noteSprint, noteLauf, noteGesamt, ergebnisGesamt, alter, frauBox);
        auswerten.addActionListener(Auswerter);
//        eingabePanel.add(auswerten);

        JButton leeren = new JButton("Leeren");
        buttonPanel.add(leeren, BorderLayout.EAST);
        ActionListener Leerer = new Rechner(klimmhangEingabe, sprintEingabe, laufEingabe, ergebnisKlimm, ergebnisSprint, ergebnisLauf, noteKlimm, noteSprint, noteLauf, noteGesamt, ergebnisGesamt, alter, frauBox);
        leeren.addActionListener(Leerer);

//        String vorName, String nachName, int alter, String gehoertZu
        JButton speichern = new JButton("Speichern");
        buttonPanel.add(speichern, BorderLayout.SOUTH);
        int jahre=Integer.parseInt(alter.getText());
        ActionListener Speicherer = new Sportler("Denis","Oetken",jahre,"01");
        speichern.addActionListener(Speicherer);

        JLabel copyrightLabel = new JLabel("Oetken, Denis Stand: 01.02.2016");
        copyrightLabel.setHorizontalAlignment(SwingConstants.RIGHT);

        panelAlles.add(gesamtEingabePanel, BorderLayout.NORTH);
        panelAlles.add(gesamtAusgabePanel, BorderLayout.CENTER);
        panelAlles.add(copyrightLabel, BorderLayout.SOUTH);


        gesamtEingabePanel.add(gesamtAusgabePanel, BorderLayout.SOUTH);
        return panelAlles;
    }
}

