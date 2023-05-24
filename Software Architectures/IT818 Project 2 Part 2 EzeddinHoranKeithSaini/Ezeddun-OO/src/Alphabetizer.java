import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * class: Alphabetizer 
 * 
 * main attribute: ArrayList <String> lines (private)
 * Constructor:    Default
 * main function:  ArrayList <String> alphabetize(ArrayList <String>(private)
 * 					it takes a list of strings and return them sorted alphabetically
 * 					alphabetize sorting is case insensitive.
 * 
 * "public ArrayList <String> getLines()" and "public void setLines(ArrayList <String> lines)" are also available
 * 
 * */

public class Alphabetizer {
    private ArrayList <String> lines;

    public Alphabetizer(ArrayList <String> lines) {
        this.lines = alphabetize(lines);
    }
    public Alphabetizer() {
    }

    public void setLines(ArrayList <String> lines) {
        this.lines = alphabetize(lines);
    }

    private ArrayList <String> alphabetize(ArrayList <String> lines){

        Collections.sort(lines, String.CASE_INSENSITIVE_ORDER);
        return lines;
        
    }
    
    //*************************************************

    public ArrayList <String> getLines() {
        return lines;
    }
}