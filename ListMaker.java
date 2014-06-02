import java.io.*;
import java.util.*;

public class ListMaker {

    private String[][] _dataList;

    public ListMaker( String inputFile, int rows, int columns ) {

	_dataList = new String[rows][columns];

	try {
	    Scanner sc = new Scanner( new File(inputFile) );
	    //System.out.println( "reading in file..." );
	    for (int r = 0; r < rows; r++) {
		String line = sc.nextLine();
		ArrayList<String> parsedLine = parse(line);
		for (int c = 0; c < columns; c++)
		    _dataList[r][c] = parsedLine.get(c);
	    } 
	} 

	catch( Exception e ) { System.out.println( "Error reading file" ); }

    }//end constructor

    public String[][] getList () {
	return _dataList;	
    }

    public static ArrayList<String> parse(String input) {
	ArrayList<String> retArr = new ArrayList<String>();
	String tmp = "";
	for (int i = 0; i<input.length(); i++) {
	    String sym = input.substring(i,i+1);
	    if (sym.equals(",")) {
		retArr.add(tmp);
		tmp = "";
	    }
	    else
		tmp += sym;
	}
	retArr.add(tmp);
	return retArr;
    } // method adapted from Scheme.java (HW29)

    // public static void main(String[] args) {
    // 	ListMaker master = new ListMaker("routes.dat", 59637, 8);
    // 	System.out.println(master.getList()[0][0]);
    // }
    
}
