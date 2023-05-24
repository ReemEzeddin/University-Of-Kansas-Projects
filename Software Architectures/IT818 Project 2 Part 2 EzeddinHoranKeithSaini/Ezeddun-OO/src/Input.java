import java.io.FileNotFoundException;
import java.util.List;

import java.io.IOException;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.BufferedReader;

/*
 * class: Input 
 * 
 * main attribute: String fName (private)
 * Constructor:    takes the file name as a string and save it in the object and initialize a BufferedReader. 
 * main function:  - String readALine() (public)
 * 					using the file name saved in the object, this function reads the next line and return them as a sting
 * 				   - void closing() throws IOException (public)
 * 					closes the BufferedReader
 * 
 * */

public class Input {
    private String fName;
    private BufferedReader reader;

    public Input(String fileName) throws FileNotFoundException {
        fName =  fileName;
        reader = new BufferedReader(new FileReader(fName));
    }

    //*************************************************
    
    public String readALine() {

    	String line = "";
    	try{
    	line = reader.readLine();}
    	catch (Exception e){
    	System.out.println("you have reached the end of the file");}
    	
    	return line;
    }
    
    //************************************************
    
    public ArrayList<String> getWords() throws IOException {
    	boolean next = true;

    	ArrayList <String> result = new ArrayList <String>();
    	String line = "";
        do{
        	try {
        line = readALine();
        if(line == null)
        	break;
        	}
        	catch(Exception e){
        		System.out.println("EOFException");
        		next = false;
        		break;
        	}
        	ArrayList <String> words = new ArrayList<>(Arrays.asList(line.split(" ")));
        	for(String one : words)
        		result.add(one.toUpperCase());
        } while(next != false);
        return result;
    	
    }
    
    //*************************************************
    
    public void closing() throws IOException {
    	try{
    	this.reader.close();}
    	catch (Exception e){
        	System.out.println("connot close the reader");}
        	
    }
}