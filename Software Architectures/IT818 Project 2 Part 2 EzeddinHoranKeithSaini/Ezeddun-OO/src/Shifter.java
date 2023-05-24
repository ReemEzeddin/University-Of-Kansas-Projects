import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

 /*
 * class: Shifter 
 * 
 * main attributes: ArrayList <String> lines 
 * 					ArrayList<String> keyWords
 * 
 * Constructor:    takes a the lines as a ArrayList<String> and save the shifted version of them in the object. 
 * 					also it takes the words to be capitalized as ArrayList<String> and save them in the object.
 * main functions: - ArrayList<String> circularShift(ArrayList<String> (private)
 * 					it takes the lines as ArrayList<String> to circularShift them and return the result in a new  ArrayList<String> 
 * 				   - String arrToString(ArrayList<String>) (private)
 * 					it transform the ArrayList<String> to a normal string then return it
 * 				   - ArrayList<String> getShiftedLines() (public)
 * 					returns the shifted lines
 * 				   -  int inkeywords(String) (private)
 * 					Searches in the keyWords list and return the index of the value input that equals the received value.
 *
 * */

public class Shifter {
	ArrayList <String> lines;
	ArrayList<String> keyWords;

    public Shifter(ArrayList <String> lines, ArrayList<String> keyWords) {
        this.keyWords = keyWords;
        this.lines = circularShift(lines);

    }
    
  //*********************************************
    
    private ArrayList <String> circularShift(ArrayList <String> lines){
    	ArrayList <String> result = new ArrayList <String>();
        for (String line: lines) {
        	ArrayList <String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
        	for (String element : words){
                if ( inkeywords(element) != -1) {
                     //words.set(words.indexOf(element) ,element.toUpperCase());
                	words.set(words.indexOf(element) ,"");
                	}
                }
            int lastIndex  = words.size() - 1;
            for (int i = 0; i < words.size() ; ++i) {
                words.add(0,words.remove(lastIndex));
                result.add(arrToString(words));
            }
        }
        return result;
    }
    
    //**************************************

    private String arrToString(ArrayList <String> arr){
        StringBuilder builder = new StringBuilder();
        for (String node: arr) {
            builder.append(node);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }

  //***************************************
    
    public ArrayList <String> getShiftedLines() {
        return lines;
    }

   //**************************************
    
    private int inkeywords(String word) {
    	int index = -1;
    	int i = 0;

    	for(String elem: this.keyWords) {
    		if(word.toUpperCase().equals(elem)) {
    			index = i;
    			break;
    		}
    		i++;
    	}
    	
    	return(index);
    }
    
}