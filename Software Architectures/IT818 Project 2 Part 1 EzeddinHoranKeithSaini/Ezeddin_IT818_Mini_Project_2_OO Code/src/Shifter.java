import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * class: Shifter 
 * 
 * main attribute: List<String> lines (private)
 * Constructor:    takes a the lines as a List<String> and save the shifted version of them in the object. 
 * main functions: -List<String> circularShift(List<String> (private)
 * 					it takes the lines as List<String> to circularShift them and return the result in a new  List<String> 
 * 				   -String arrToString(List<String>) (private)
 * 					it transform the List<String> to a normal string then return it
 * 				   -List<String> getShiftedLines() (public)
 * 					returns the shifted lines
 * */


public class Shifter {
	List<String> lines;

    public Shifter(List<String> lines) {
        this.lines = circularShift(lines);
    }

    private List<String> circularShift(List<String> lines){
        List<String> result = new LinkedList<>();
        for (String line: lines) {
            List<String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
            int lastIndex = words.size() - 1;
            for (int i = 0; i < words.size() ; ++i) {
                words.add(0,words.remove(lastIndex));
                result.add(arrToString(words));
            }
        }
        return result;
    }

    private String arrToString(List<String> arr){
        StringBuilder builder = new StringBuilder();
        for (String node: arr) {
            builder.append(node);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }


    public List<String> getShiftedLines() {
        return lines;
    }
}