
import java.io.IOException;

import java.util.ArrayList;
import java.util.Scanner;


/*
 * class: Controller 
 * 
 * main attribute: long startTime (private static)
 * main function: *  void main(String[] args) (public static)
 * 					it creates objects of class Input, Lines, Shifter, Alphabetizer, and Output
 * 					It gives the user the ability of choosing his/her needs
 * 					- "A" or "a" to add a line (the line will be shifted and sorted).
 * 					- "D" or "d" to display the result.
 * 					- "Q" or "q" to quit. (the result will be written in a text file).
 * 					the run time is calculated in this function and printed out in milliseconds.
 * 				  *  static char menu() (public)
 * 					prints the menu of the choices and returns the use section.
 * 				  *   static ArrayList<String> getWords(Input keyWords) throws IOException
 * 					receives the input object of the words to be upper cased  and returns the words as ArrayList<String>
 * 
 * */

public class Controller {
	private static long startTimeA;
	private static long startTimeAtotal;
	private static long startTimeD;
	private static long startTimeQ;
    static long endTimeA;
    static long endTimeD;
    static long endTimeQ;
    public static void main(String[] args) throws IOException {

    	Input keywords = new Input("words.txt");
    	Lines lines = new Lines();
   	    ArrayList<String> keyWords = keywords.getWords();
    	Shifter shifter;
    	int counter = 0;
    	
    	
    	Alphabetizer alphabetizer = new Alphabetizer();
    	Display display;
    	Output output = new Output("out.txt");
		char data;
		boolean ok = true;
		do {
		do{
		ok = true;
		data = menu();
		data = Character.toUpperCase(data);
		if (data != 'Q' && data != 'A' && data != 'D'){
			ok = false;
			System.out.print("Please enter a valid input!");}
		}while( ok == false);
		
		
		if(data == 'A'){
			String line = addLine();
		startTimeA = System.currentTimeMillis();
			boolean notTheEnd = lines.addAline(line);
		  if(notTheEnd) {
			  shifter = new Shifter(lines.getLines(), keyWords);
				alphabetizer.setLines(shifter.getShiftedLines());
				counter++;
					}
		  endTimeA = System.currentTimeMillis();
		  startTimeAtotal += ( endTimeA - startTimeA );

    		}
    	if(data == 'D'){
    		startTimeD = System.currentTimeMillis();
    		if (counter == 0)
    			System.out.println("no lines added");
    		else
    			display = new Display(alphabetizer.getLines());
    		endTimeD = System.currentTimeMillis();
    	}
    	if(data == 'Q'){
    		startTimeQ = System.currentTimeMillis();
    		if (counter == 0)
    			System.out.println("no lines added");
    		else 
    			output.writeLines(alphabetizer.getLines());
    		output.close();
    		System.out.println("Goodbye");

    		endTimeQ = System.currentTimeMillis();
    		System.out.println("'A' as total took " + startTimeAtotal + " milliseconds" );
  		  	System.out.println("'D' took " + (endTimeD - startTimeD) + " milliseconds");
    		System.out.println("'Q' took " + (endTimeQ - startTimeQ) + " milliseconds");
    		System.exit(0);
    		ok = false;
    		}
		}while(ok == true);

    }

 //*************************************************
    
    public static char menu() {

        char selection;
        Scanner input = new Scanner(System.in);

        System.out.println("Choose from these choices");
        System.out.println("-------------------------\n");
        System.out.println("1 - Enter 'A' or 'a' to add a new line ");
        System.out.println("2 - Enter 'D' or 'd' to display the shifted and sorted lines");
        System.out.println("3 - Enter 'Q' or 'q' to quit");

        selection = input.next().charAt(0);
        return selection;    
    }
    
  //*************************************************
    
    public static String addLine() {
    	String message = "";

    	do {
          Scanner scanner = new Scanner(System.in);
        System.out.println("\nPlease type the line");
        if(scanner.hasNextLine()){
         message = scanner.nextLine();}

        if (message == "")
        	System.out.println("\nPlease enter a valid String");
    	}while (message == null);
    	
        return message;
    }

 }