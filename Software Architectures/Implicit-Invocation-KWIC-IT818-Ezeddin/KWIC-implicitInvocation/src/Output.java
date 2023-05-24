import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/*
 * class: Output 
 * 
 * Constructor:    default
 * main functions: -  void writeFile(Lines lines, File file) throws IOException
 * 					it takes the lines as Lines object and write them in the file received using a FileWriter
 * 
 * */

class Output {
    void writeFile(Lines lines, File file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        for (String line : lines.getLines()) {
            fileWriter.append(line).append('\n');
        }
        fileWriter.flush();
        fileWriter.close();
    }
}