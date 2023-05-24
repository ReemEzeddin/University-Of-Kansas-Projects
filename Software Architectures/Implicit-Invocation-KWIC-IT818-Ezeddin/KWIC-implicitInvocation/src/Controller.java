import java.io.File;
import java.io.IOException;

/*
 * class: Controller 
 * 
 * main attribute: long startTime (private static)
 * main function:  void main(String[] args) (public static)
 * 					it creates objects of class Input, Lines, Shifter, Alphabetizer, and Output
 * 					in logical order to achieve the main purpose of KWIC
 * 					the run time is calculated in this function and printed out in milliseconds.
 * 
 * */

public class Controller {

	private static long startTime = System.currentTimeMillis();
    public static void main(String[] args) {
        Lines lines = new Lines();
        Lines shifts = new Lines();
        
    	Input in = new Input();
        Shifter circularShift = new Shifter(shifts);
        Alphabetizer alphabetizer = new Alphabetizer();
        Output output = new Output();

        lines.addObserver(circularShift);
        shifts.addObserver(alphabetizer);

        try {
            in.readFile(lines, new File("input.txt"));
            output.writeFile(shifts, new File("output.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("It took " + (endTime - startTime) + " milliseconds");

    }

}