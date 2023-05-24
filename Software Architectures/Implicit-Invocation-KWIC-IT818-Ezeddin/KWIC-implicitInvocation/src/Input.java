import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/*
 * class: Input 
 * 
 * Constructor:    default
1 * main function:  void readFile(Lines lines, File file) throws IOException (public)
 * 					using the file saved in the object, this function opens the file
 * 					and reads all its lines and insert them in "lines" passed to the function
 * 
 * */

class Input {
    void readFile(Lines lines, File file) throws IOException {
    	BufferedReader reader = new BufferedReader(new FileReader(file));
    	String line;
    	while ((line = reader.readLine()) != null) {
    	    lines.insert(line);
    	}
    	reader.close();
    }
}