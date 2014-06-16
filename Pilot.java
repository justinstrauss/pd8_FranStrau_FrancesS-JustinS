import java.util.*;
//import org.joda.time.DateTime;
//import org.joda.time.Days;

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
	    int routechoice = -1;
	    System.out.println("Enter the number corresponding to your desired airline:");
	    String tmp = user_input.next().trim();
	    try {
		routechoice = Integer.parseInt(tmp);
	    }
	    catch (Exception e) {
		System.out.println("Sorry, your input is not an number. Please try again.");
		System.exit(1);
	    }

	    if (routechoice < 0 || routechoice >= flight.getDirects().size()) {
		System.out.println("Sorry, your input is out of range. Please try again.");
		System.exit(1);
	    }

	}

	else {
	    System.out.println("No direct route found. Searching for transfer location(s)...");
	    flight.findTransfer();

	    if (flight.anyTransfers()) {
		System.out.println("Transfer location(s) found. Here are the layover cities between " + Loc1 + " and " + Loc2 + ".");
		System.out.println( flight.printTransfers());
		String transferchoice;
		int num = -1;
		ArrayList<String> cities = flight.getCities();
		System.out.println("Enter the number corresponding to your desired layover city:");
		try {
		    num = Integer.parseInt(user_input.next());
		}
		catch (Exception e) {
		    System.out.println("Sorry, your input is not an number. Please try again.");
		    System.exit(1);
		}

		if (num < 0 || num >= cities.size()) {
		    System.out.println("Sorry, your input is out of range. Please try again.");
		    System.exit(1);
		}
		
		
		transferchoice = cities.get(num);
	
		System.out.println("Here are the airlines that fly directly from " + Loc1 + " to " + transferchoice + ".");
		Route leg1 = new Route(Loc1,transferchoice);
		leg1.findDirect();
		System.out.println( leg1.printDirects());
		int leg1choice = -1;
		System.out.println("Enter the number corresponding to your desired airline:");
		String tmp1 = user_input.next().trim();
		try {
		    leg1choice = Integer.parseInt(tmp1);
		}
		catch (Exception e) {
		    System.out.println("Sorry, your input is not an number. Please try again.");
		    System.exit(1);
		}

		if (leg1choice < 0 || leg1choice >= leg1.getDirects().size()) {
		    System.out.println("Sorry, your input is out of range. Please try again.");
		    System.exit(1);
		}

	
	
		System.out.println("Here are the airlines that fly directly from " + transferchoice + " to " + Loc2 + ".");
		Route leg2 = new Route(transferchoice, Loc2);
		leg2.findDirect();
		System.out.println(leg2.printDirects());
		int leg2choice = -1;
		System.out.println("Enter the number corresponding to your desired airline:");
		String tmp2 = user_input.next().trim();
		try {
		    leg2choice = Integer.parseInt(tmp2);
		}
		catch (Exception e) {
		    System.out.println("Sorry, your input is not an number. Please try again.");
		    System.exit(1);
		}

		if (leg2choice < 0 || leg2choice >= leg2.getDirects().size()) {
		    System.out.println("Sorry, your input is out of range. Please try again.");
		    System.exit(1);
		}

	    }
	
	

	    else {
		System.out.println("Sorry, no flights exist. You may have incorrectly entered the 3 character airport code or travel between your two desired airports may require more than one transfer. Please try again.");
		System.exit(1);
	    }
	}
	
	Date dateDepart = new Date();
	System.out.println("Please input the departure date of your trip in yyyy/mm/dd format:");
	String depart = user_input.next();

	ArrayList<String> arr = new ArrayList<String>();
	String tmp3 = "";
	for (int i = 0; i<depart.length(); i++) {
	    String sym = depart.substring(i,i+1);
	    if (sym.equals("/")) {
		arr.add(tmp3);
		tmp3 = "";
	    }
	    else
		tmp3 += sym;
	}
	arr.add(tmp3);

	try {
	    dateDepart = new Date(Integer.parseInt(arr.get(0)),Integer.parseInt(arr.get(1)),Integer.parseInt(arr.get(2)));
	}
	catch (Exception e) {
	    System.out.println("Sorry, the date you inputted is either incorrectly formatted or doesn't exist. Please try again.");
	    System.exit(1);
	}

	Date todaysDate = new Date();
	Calendar todayCal = new GregorianCalendar();
	todayCal.setTime(todaysDate);

	System.out.println("Do you wish to book a return flight as well? (yes/no)");
	String ans = user_input.next();

	if (!(ans.equals("yes")) && !(ans.equals("no")))
	    System.out.println("Input not recognized. We will assume you only want to book one way.");

	if (ans.equals("yes")) {

	    Date dateReturn = new Date();
	    System.out.println("Please input the return date of your trip in mm/dd/yyyy format:");
	    String Return = user_input.next();

	    ArrayList<String> arr1 = new ArrayList<String>();
	    String tmp4 = "";
	    for (int i = 0; i<Return.length(); i++) {
		String sym = Return.substring(i,i+1);
		if (sym.equals("/")) {
		    arr1.add(tmp4);
		    tmp4 = "";
		}
		else
		    tmp4 += sym;
	    }
	    arr1.add(tmp4);

	    try {
		dateReturn = new Date(Integer.parseInt(arr1.get(0)),Integer.parseInt(arr1.get(1)),Integer.parseInt(arr1.get(2)));
	    }
	    catch (Exception e) {
		System.out.println("Sorry, the date you inputted is either incorrectly formatted or doesn't exist. Please try again.");
		System.exit(1);
	    }

	    if (todaysDate.after(dateReturn)) {
		System.out.println("Sorry your return date is in the past. Please try again.");
		System.exit(3);
	    }

	    if (dateDepart.after(dateReturn)) {
		System.out.println("Sorry your departure date is after your return date. We will assume you mixed them up.");
		Date tempDate = dateDepart;
		dateDepart = dateReturn;
		dateReturn = tempDate;
	    }

	    Calendar returnCal = new GregorianCalendar();
	    returnCal.setTime(dateReturn);
	    long daysUntilReturn = daysBetween(todayCal,returnCal) - 693991;
	    System.out.println("days till return: " + daysUntilReturn);
	}

	if (todaysDate.after(dateDepart)) {
	    System.out.println("Sorry your departure date is in the past. Please try again.");
	    System.exit(3);
	}

	Calendar departCal = new GregorianCalendar();
	departCal.setTime(dateDepart);
	long daysUntilDepart = daysBetween(todayCal,departCal) - 693991;
	System.out.println("days till depart: " + daysUntilDepart); //


	System.out.println("distance: " + flight.calcDistance()); //

	//determine price
	//create seating chart, print seating chart



    }

    public static long daysBetween(Calendar startDate, Calendar endDate) {  
	//assert: startDate must be before endDate  
	Calendar date = (Calendar) startDate.clone();  
	long daysBetween = 0;  
	while (date.before(endDate)) {  
	    date.add(Calendar.DAY_OF_MONTH, 1);  
	    daysBetween++;  
	}  
	return daysBetween;  
    }  

}
