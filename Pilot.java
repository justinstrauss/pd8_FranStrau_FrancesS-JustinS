import java.util.*;

public class Pilot {

    public static void main (String [] args) {

	Scanner user_input = new Scanner( System.in );

	String Loc1;
	System.out.println("Please input the 3 character airport code of your take-off location: ");
	Loc1 = user_input.next().toUpperCase().trim();

	String Loc2;
	System.out.println("Please input the 3 character airport code of your destination: ");
	Loc2 = user_input.next().toUpperCase().trim();

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
		int num = Integer.parseInt(user_input.next());
		ArrayList<String> cities = flight.getCities();
		transferchoice = cities.get(num);
	
	System.out.println("Here are the airlines that fly directly from " + Loc1 + " to " + transferchoice + ".");
	Route leg1 = new Route(Loc1,transferchoice);
	leg1.findDirect();
	System.out.println( leg1.printDirects());
	String leg1choice;
	System.out.println("Enter the number corresponding to your desired airline for the first leg of your trip:");
	leg1choice = user_input.next();
	
	
	System.out.println("Here are the airlines that fly directly from " + transferchoice + " to " + Loc2 + ".");
	Route leg2 = new Route(transferchoice, Loc2);
		leg2.findDirect();
		System.out.println(leg2.printDirects());
		String leg2choice;
		System.out.println("Enter the number corresponding to your desired airline for the second leg of your trip:");
		leg2choice = user_input.next();
	
	    }

	    else {
		System.out.println("Sorry, no flights exist. You may have incorrectly entered the 3 character airport code or travel between your two desired airports may require more than one transfer. Please try again.");
	    }
	}
	
	    String date;
	    System.out.println("Please input the date of your trip: ");
	    date = user_input.next();

	    //determine price
	    //create seating chart, print seating chart



	}



    }
