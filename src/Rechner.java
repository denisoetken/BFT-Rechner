import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Denis on 28.01.2016.
 */
public class Rechner implements ActionListener {

    private JTextField klimmhang;
    private JTextField sprint;
    private JTextField lauf;

    private JTextField klimmWertAusgabe;
    private JTextField sprintWertAusgabe;
    private JTextField laufWertAusgabe;
    private JTextField klimmNoteAusgabe;
    private JTextField sprintNoteAusgabe;
    private JTextField laufNoteAusgabe;
    private JTextField noteGesamt;
    private JTextField ergebnisGesamt;
    private JTextField alter;
    private JCheckBox frauBox;

    private float klimmWert;
    private float sprintWert;
    private float laufWert;

    private double ergebnisKlimm;
    private double ergebnisSprint;
    private double ergebnisLauf;

    private double geschlecht15;
    private double geschlecht40;


    public Rechner(JTextField klimmhangEingabe, JTextField sprintEingabe, JTextField laufEingabe, JTextField klimmWertAusgabe, JTextField sprintWertAusgabe, JTextField laufWertAusgabe, JTextField klimmNoteAusgabe, JTextField sprintNoteAusgabe, JTextField laufNoteAusgabe, JTextField noteGesamt, JTextField ergebnisGesamt, JTextField alter, JCheckBox frauBox) {
        this.klimmhang = klimmhangEingabe;
        this.sprint = sprintEingabe;
        this.lauf = laufEingabe;
        this.klimmWertAusgabe = klimmWertAusgabe;
        this.sprintWertAusgabe = sprintWertAusgabe;
        this.laufWertAusgabe = laufWertAusgabe;
        this.klimmNoteAusgabe = klimmNoteAusgabe;
        this.sprintNoteAusgabe = sprintNoteAusgabe;
        this.laufNoteAusgabe = laufNoteAusgabe;
        this.noteGesamt = noteGesamt;
        this.ergebnisGesamt = ergebnisGesamt;
        this.alter = alter;
        this.frauBox=frauBox;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        double faktor;
        float alterInt=Float.parseFloat(alter.getText());
        this.klimmWert = Float.parseFloat(klimmhang.getText());
        this.sprintWert = Float.parseFloat(sprint.getText());
        this.laufWert = Float.parseFloat(lauf.getText());


        switch (e.getActionCommand()) {
            default: {
                break;
            }

            case "Auswerten": {


                if (alterInt > 35) {
//                   Faktor berechnen und auf alle Ergebniswerte anwenden
                    faktor = 1+((alterInt - 35) * 0.005);
                } else {
                    faktor = 1.;
                }

//                todo
                if (frauBox.isSelected()) {
                    this.geschlecht15=1.15;
                    this.geschlecht40=1.4;
                } else {
                    this.geschlecht15 = 1.;
                    this.geschlecht40 = 1.;
                }


                this.ergebnisKlimm = (75 + (5 * klimmWert)) * faktor * geschlecht40;
                String klimmErgebnis = Double.toString(this.ergebnisKlimm);
                this.klimmWertAusgabe.setText(klimmErgebnis.format("%5.2f", this.ergebnisKlimm));

                if (ergebnisKlimm > 399) {
                    this.klimmNoteAusgabe.setText("Sehr Gut");
                } else {
                    if (ergebnisKlimm > 299) {
                        this.klimmNoteAusgabe.setText("Gut");
                    } else {
                        if (ergebnisKlimm > 199) {
                            this.klimmNoteAusgabe.setText("Zufriedenstellend");
                        } else {
                            if (ergebnisKlimm > 99) {
                                this.klimmNoteAusgabe.setText("Ausreichend");
                            } else {
                                if (ergebnisKlimm < 100) {
                                    this.klimmNoteAusgabe.setText("Nicht Ausreichend");
                                }
                            }
                        }
                    }
                }


                this.ergebnisSprint = (1100 - (16.667 * sprintWert)) * faktor * geschlecht15;
                String sprintErgebnis = Double.toString(this.ergebnisSprint);
                this.sprintWertAusgabe.setText(sprintErgebnis.format("%5.2f", this.ergebnisSprint));

                if (ergebnisSprint > 399) {
                    this.sprintNoteAusgabe.setText("Sehr Gut");
                } else {
                    if (ergebnisSprint > 299) {
                        this.sprintNoteAusgabe.setText("Gut");
                    } else {
                        if (ergebnisSprint > 199) {
                            this.sprintNoteAusgabe.setText("Zufriedenstellend");
                        } else {
                            if (ergebnisSprint > 99) {
                                this.sprintNoteAusgabe.setText("Ausreichend");
                            } else {
                                if (ergebnisSprint < 100) {
                                    this.sprintNoteAusgabe.setText("Nicht Ausreichend");
                                }
                            }
                        }
                    }
                }

                this.ergebnisLauf = (((390 - laufWert) * 1.81818181)+100) * faktor * geschlecht15;
                String laufErgebnis = Double.toString(this.ergebnisLauf);
                this.laufWertAusgabe.setText(laufErgebnis.format("%5.2f", this.ergebnisLauf));

                if (ergebnisLauf > 399) {
                    this.laufNoteAusgabe.setText("Sehr Gut");
                } else {
                    if (ergebnisLauf > 299) {
                        this.laufNoteAusgabe.setText("Gut");
                    } else {
                        if (ergebnisLauf > 199) {
                            this.laufNoteAusgabe.setText("Zufriedenstellend");
                        } else {
                            if (ergebnisLauf > 99) {
                                this.laufNoteAusgabe.setText("Ausreichend");
                            } else {
                                if (ergebnisLauf < 100) {
                                    this.laufNoteAusgabe.setText("Nicht Ausreichend");
                                }
                            }
                        }
                    }
                }
                double gesamtErgebnis = (this.ergebnisKlimm + this.ergebnisSprint + this.ergebnisLauf) / 3;
                String gesamtErgebnisText = Double.toString(gesamtErgebnis);
                this.ergebnisGesamt.setText(gesamtErgebnisText.format("%5.2f", gesamtErgebnis));

                if (gesamtErgebnis > 399) {
                    this.noteGesamt.setText("Sehr Gut");
                } else {
                    if (gesamtErgebnis > 299) {
                        this.noteGesamt.setText("Gut");
                    } else {
                        if (gesamtErgebnis > 199) {
                            this.noteGesamt.setText("Zufriedenstellend");
                        } else {
                            if (gesamtErgebnis > 99) {
                                this.noteGesamt.setText("Ausreichend");
                            } else {
                                if (gesamtErgebnis < 100) {
                                    this.noteGesamt.setText("Nicht Ausreichend");
                                }
                            }
                        }
                    }
                }


                break;
            }
            case "Leeren": {
                this.sprint.setText("");
                this.sprintNoteAusgabe.setText("");
                this.sprintWertAusgabe.setText("");
                this.lauf.setText("");
                this.laufNoteAusgabe.setText("");
                this.laufWertAusgabe.setText("");
                this.klimmhang.setText("");
                this.klimmNoteAusgabe.setText("");
                this.klimmWertAusgabe.setText("");
                this.ergebnisGesamt.setText("");
                this.noteGesamt.setText("");
                this.alter.setText("");
                this.frauBox.setSelected(false);
                break;
            }
        }
    }
}
