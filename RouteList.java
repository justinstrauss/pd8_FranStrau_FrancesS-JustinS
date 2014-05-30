import java.io.*;
import java.util.*;

public class RouteList {

    private String[][] _routeList;

    public RouteList( String inputFile ) {

	_routeList = new String[59637][8];

	try {
	    Scanner sc = new Scanner( new File(inputFile) );
	    //System.out.println( "reading in file..." );
	    for (int r = 0; r < 59637; r++) {
		String line = sc.nextLine();
		ArrayList<String> parsedLine = parse(line);
		for (int c = 0; c < 8; c++)
		    _routeList[r][c] = parsedLine.get(c);
	    } 
	} 

	catch( Exception e ) { System.out.println( "Error reading file" ); }

    }//end constructor

public String[][] getList () {
return _routeList;	

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
    
    
    public String finddirectRoute(String airportCodeOrigin, String airportCodeDest) {
    	
   public boolean isDirect() { }
    }
}
