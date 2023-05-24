
import java.util.ArrayList;

/*
 * class: Lines 
 * 
 * main attribute:  ArrayList <String> lines (private)
 * Constructor:     received ArrayList <String> and save it in 'lines' attribute
 * main function:   boolean addAline(String line ) (public)
 * 					received a line as a string and add it to the list.
 * 
 * "void setLines(ArrayList <String> characters)" and " ArrayList <String> getLines()" are also available
 * 
 * */

public class Lines {
    private  ArrayList <String> lines = new ArrayList <String>();

    public Lines(ArrayList <String> lines) {
        this.lines = lines;
    }
    
    public Lines() {
    }

    //*************************************************
    public boolean addAline(String line ) {
    	if(line == null)
    		return false;
    	lines.add(line);
    	return true;
    }

    //*************************************************

    public void setLines(ArrayList <String> characters) {
        lines = characters;
    }

    //*************************************************
    public ArrayList <String> getLines() {
        return lines;
    }
}
