
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

/*
 * class: Input extends Observable
 * 
 * main attribute: List<String> lines (private)
 * Constructor:    Default
 * main functions: - void insert(String line) (public)
 * 					 inserts the string received as a line to the List<String> and notify the observers.
 * 				   - List<String> getLines() (public)
 * 					 returns the list of the lines
 * 
 * */

class Lines extends Observable {

    private List<String> lines = new ArrayList<>();

    void insert(String line) {
        lines.add(line);
        setChanged();
        notifyObservers(new LinesEvent(line));
    }

    public List<String> getLines() {
        return lines;
    }
}