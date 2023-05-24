import java.util.Collections;
import java.util.Observable;
import java.util.Observer;

/*
 * class: Alphabetizer implements Observer
 * 
 * Constructor:    default
 * main function: 	overriding update function that takes the observable object as well as the object to be sorted
 * 					it castes the object to a Lines object and sorts them alphabetically
 * 					this sorting is case insensitive.
 * 
 * 
 **/

class Alphabetizer implements Observer {

    @Override
    public void update(Observable o, Object arg) {
        Lines lines = (Lines) o;
        Collections.sort(lines.getLines(), String.CASE_INSENSITIVE_ORDER);
    }
}