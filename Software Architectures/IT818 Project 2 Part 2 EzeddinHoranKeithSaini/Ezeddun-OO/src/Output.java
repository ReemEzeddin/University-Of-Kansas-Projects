import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * class: Output 
 * 
 * main attribute: PrintWriter out (private)
 * Constructor:    takes a file name as a String and use it to create a new PrintWriter. 
 * main functions: - void writeLines(List<String>) (public)
 * 					it takes the lines as ArrayList <String>  and write them in the PrintWriter of the object
 * 				   - void close() (public)
 * 					to close the PrintWriter of the object
 * 
 * 
 * */

public class Output {

    private PrintWriter out;

    public Output(String filename) throws FileNotFoundException {
        out = new PrintWriter(new FileOutputStream(filename));
    }
    
    //*************************************************
    
    public void writeLines(ArrayList <String> lines) {
        int size = lines.size();
        for (int i=0;i<size;i++) {
            String str = lines.get(i).toString();
            out.write(str);
            if(i < size-1)//This prevent creating a blank like at the end of the file**
                out.write("\n");
        }
    }
    
    //*************************************************

    public void close() {
        out.close();
    }
}