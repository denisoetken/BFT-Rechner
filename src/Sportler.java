import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TreeSet;

/**
 * Created by doetken on 03.06.2016.
 */
public class Sportler implements ActionListener {

    //    TreeMap<Integer,Sportler> mappe= new TreeMap<Integer,Sportler> [];
    TreeSet<Sportler> mappe = new TreeSet<>();

    //    String vorName = "";
//    String nachName = "";
//    int alter = 0;
//    String gehoertZu = "";
    Sportler aktuell;

    //    toDo hizufügen der JTextfelder statt der primitiven Typen
    public Sportler(String vorName, String nachName, int alter, String gehoertZu) {
        aktuell = new Sportler(vorName, nachName, alter, gehoertZu);
    }

    //      toDo neuen Sportler erstellen, wenn Button gedrückt wird
    @Override
    public void actionPerformed(ActionEvent e) {

        mappe.add(this.aktuell);
    }
}
