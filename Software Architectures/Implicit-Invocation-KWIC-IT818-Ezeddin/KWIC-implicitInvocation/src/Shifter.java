import java.util.*;

/*
 * class: Shifter 
 * 
 * main attribute: Lines shifts (private)
 * Constructor:    takes a the lines as a Lines object and save it in the object. 
 * main functions: - overriding update function that takes the observable object as well as the object to be shifted
 * 					it castes the object to a LinesEvent object and saved the shifted lines to the Lines in the object 
 * 				   - String arrToString (List<String> arr) (private)
 * 					converts the List<String> into one string and returns it.
 * 					
 * */

class Shifter implements Observer {

    private Lines shifts;

    Shifter(Lines shifts) {
        this.shifts = shifts;
    }

    @Override
    public void update(Observable o, Object arg) {
        LinesEvent event = (LinesEvent) arg;

        List<String> result = new LinkedList<>();
        List<String> words = new ArrayList<>(Arrays.asList(event.getLine().split(" ")));
        int lastIndex = words.size() - 1;
        for (int i = 0; i < words.size(); ++i) {
            words.add(0, words.remove(lastIndex));
            result.add(arrToString(words));
        }

        for (String shift : result) {
            shifts.insert(shift);
        }
    }

    private String arrToString(List<String> arr) {
        StringBuilder builder = new StringBuilder();
        for (String node : arr) {
            builder.append(node);
            builder.append(" ");
        }
        builder.deleteCharAt(builder.length() - 1);
        return builder.toString();
    }
}