import java.util.Scanner;

public class Pilot {

    public static void main (String [] args) {

	Scanner user_input = new Scanner( System.in );

	String Loc1;
	System.out.println("Please input the 3 character airport code that represents your take-off location: ");
	Loc1 = user_input.next();

	String Loc2;
	System.out.println("Please input the 3 character airport code that represents your destination: ");
	Loc2 = user_input.next();

	//verify locations
	System.out.println("Searching for direct route...");

	if (directRoute()) {
	    System.out.println("Direct route found. Here are the direct flights from" + loc1 + " to " + loc2);
	    //print list
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
