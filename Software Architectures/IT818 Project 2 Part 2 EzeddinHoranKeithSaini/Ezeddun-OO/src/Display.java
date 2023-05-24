import java.util.ArrayList;
import java.util.List;

/*
 * class: Display 
 * 
 * main attribute: ArrayList <String> lines (private)
 * Constructor:    takes the lines to be displayed and saves it in the object. 
 * main function:  void printing(ArrayList <String> lines) (private)
 * 					printing the lines on console.
 * 
 * */

public class Display{

	
    public Display(ArrayList<String> lines) {
        printing(lines);
    }
    
    //*************************************************
    
    private void printing(ArrayList <String> lines) {
	for (String line: lines)
		System.out.println(line);
    }
}