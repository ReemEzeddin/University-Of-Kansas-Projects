
/*
 * class: LinesEvent
 * 
 * Constructor:     LinesEvent(String line)
 * 					takes the line as a string and save it in the object.
 * main function:  String getLine() (public)
 * 					returns the line
 * 
 * */

class LinesEvent {

    private String line;

    LinesEvent(String line) {
        this.line = line;
    }

    public String getLine() {
        return line;
    }

}