import java.util.Scanner;

public class Pilot {

    public static void main (String [] args) {

	Scanner user_input = new Scanner( System.in );

	String Loc1;
	System.out.println("Please input the 3 character airport code of your take-off location: ");
	Loc1 = user_input.next();

	String Loc2;
	System.out.println("Please input the 3 character airport code of your destination: ");
	Loc2 = user_input.next();

	Route flight = new Route(Loc1,Loc2);
	flight.findDirect();

	//verify locations
	System.out.println("Searching for direct route(s)...");


	if (flight.anyDirects()) {
	    System.out.println("Direct route(s) found. Here are the airlines that fly directly from " + Loc1 + " to " + Loc2 + " enter the number corresponding to your desired airline:");
	    System.out.println( flight.printDirect());
	    String routechoice;
	    System.out.println("Please input the number of the flight you'd like to take: ");
	routechoice = user_input.next();

	}
	else {
	    System.out.println("Searching for transfer locations...");
	    //print list
	    String transferchoice;
	    System.out.println("Please input the number of the flight you'd like to take: ");
	transferchoice = user_input.next();
	}
	
	String date;
	System.out.println("Please input the date of your trip: ");
	date = user_input.next();

	//determine price
	//create seating chart, print seating chart



    }



}
