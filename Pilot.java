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
	    System.out.println("Direct route(s) found. Here are the airlines that fly directly from " + Loc1 + " to " + Loc2 + ".");
	    System.out.println( flight.printDirects());
	    String routechoice;
	    System.out.println("Enter the number corresponding to your desired airline:");
	    routechoice = user_input.next();

	}

	else {
	    System.out.println("No direct route found. Searching for transfer location(s)...");
	    flight.findTransfer();

	    if (flight.anyTransfers()) {
	    System.out.println("Transfer location(s) found. Here are the layover cities between " + Loc1 + " and " + Loc2 + ".");
		System.out.println( flight.printTransfers());
		String transferchoice;
		System.out.println("Enter the number corresponding to your desired layover city:");
		transferchoice = user_input.next();
	
	
	
	
		System.out.println("Searching for airlines for transfer locationsthe first leg of your trip...");
		flight = new Route(Loc1,transferchoice);
		flight.findDirect();
		System.out.println(flight.printDirects());
		String leg1;
		System.out.println("Please pick an airline for the first leg of your trip:");
		leg1 = user_input.next();
	
	    }

	    else {
		System.out.println("No flights exist");
	    }
	}
	
	    String date;
	    System.out.println("Please input the date of your trip: ");
	    date = user_input.next();

	    //determine price
	    //create seating chart, print seating chart



	}



    }
