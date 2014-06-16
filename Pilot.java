import java.util.*;

public class Pilot {

    public static void main (String [] args) {

	int routechoice = -1;
	String transferchoice = "";
	int leg1choice = -1;
	int leg2choice = -1;
	Route leg1 = new Route();
	Route leg2 = new Route();
	String Return = "";
	long daysUntilReturn = -1;

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
		leg1 = new Route(Loc1,transferchoice);
		leg1.findDirect();
		System.out.println( leg1.printDirects());
		
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
		leg2 = new Route(transferchoice, Loc2);
		leg2.findDirect();
		System.out.println(leg2.printDirects());
		
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

	boolean roundtrip = false;
	System.out.println("Do you wish to book a return flight as well? (yes/no)");
	String ans = user_input.next();

	if (!(ans.equals("yes")) && !(ans.equals("no")))
	    System.out.println("Input not recognized. We will assume you only want to book one way.");

	if (ans.equals("yes")) {
	    roundtrip = true;
	    Date dateReturn = new Date();
	    System.out.println("Please input the return date of your trip in yyyy/mm/dd format:");
	    Return = user_input.next();

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
	    daysUntilReturn = daysBetween(todayCal,returnCal) - 693991;
	    //System.out.println("days till return: " + daysUntilReturn);
	}

	if (todaysDate.after(dateDepart)) {
	    System.out.println("Sorry your departure date is in the past. Please try again.");
	    System.exit(3);
	}

	Calendar departCal = new GregorianCalendar();
	departCal.setTime(dateDepart);
	long daysUntilDepart = daysBetween(todayCal,departCal) - 693991;
	//System.out.println("days till depart: " + daysUntilDepart);


	//***************************************************************


	if(ans.equals("yes") &&  !(flight.anyDirects())) {
	Plane Flight4 = new Plane(daysUntilDepart, flight.calcDistance() / 2);
	System.out.println("Here is the seating chart for the first leg of your first flight");
	Flight4.fillSeats();
	System.out.println(Flight4.printSeats());

	String seatChoice4;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice4 = user_input.next().trim();

	//add error handling

	Seat seat4 = new Seat(Flight4);
	seat4.setPlace( (int)Integer.parseInt(seatChoice4.substring(0, seatChoice4.length() - 1)), seatChoice4.substring(seatChoice4.length() -1));
	System.out.println("You have chosen seat " + seatChoice4 + " which is a/an " + seat4.getType() + " seat in class " + seat4.getmyClass());



	Plane Flight5 = new Plane(daysUntilDepart, flight.calcDistance() / 2);
	System.out.println("Now choose a seat for the second leg of your first flight, here is the seating chart:");
	Flight5.fillSeats();
	System.out.println(Flight5.printSeats());

	String seatChoice5;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice5 = user_input.next().trim();

	//add error handling

	Seat seat5 = new Seat(Flight5);
	seat5.setPlace( (int)Integer.parseInt(seatChoice5.substring(0, seatChoice5.length() - 1)), seatChoice5.substring(seatChoice5.length() -1));
	System.out.println("You have chosen seat " + seatChoice5 + " which is a/an " + seat5.getType() + " seat in class " + seat5.getmyClass());



	Plane Flight6 = new Plane(daysUntilReturn, flight.calcDistance() / 2);
	System.out.println("Now choose a seat for the first leg of your return flight, here is the seating chart:");
	Flight6.fillSeats();
	System.out.println(Flight6.printSeats());

	String seatChoice6;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice6 = user_input.next().trim();

	//add error handling

	Seat seat6 = new Seat(Flight6);
	seat6.setPlace( (int)Integer.parseInt(seatChoice6.substring(0, seatChoice6.length() - 1)), seatChoice6.substring(seatChoice6.length() -1));
	System.out.println("You have chosen seat " + seatChoice6 + " which is a/an " + seat6.getType() + " seat in class " + seat6.getmyClass());


	Plane Flight7 = new Plane(daysUntilReturn, flight.calcDistance() / 2);
	System.out.println("Now choose a seat for the second leg of your return flight, here is the seating chart:");
	Flight7.fillSeats();
	System.out.println(Flight7.printSeats());

	String seatChoice7;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice7 = user_input.next().trim();

	//add error handling

	Seat seat7 = new Seat(Flight7);
	seat7.setPlace( (int)Integer.parseInt(seatChoice7.substring(0, seatChoice7.length() - 1)), seatChoice7.substring(seatChoice7.length() -1));
	System.out.println("You have chosen seat " + seatChoice7 + " which is a/an " + seat7.getType() + " seat in class " + seat7.getmyClass());



	}



	else if(ans.equals("yes") && (flight.anyDirects())) {
	    Plane Flight1 = new Plane(daysUntilDepart, flight.calcDistance());
	System.out.println("Here is the seating chart for your first flight");
	Flight1.fillSeats();
	System.out.println(Flight1.printSeats());

	String seatChoice1;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice1 = user_input.next().trim();

	//add error handling

	Seat seat1 = new Seat(Flight1);
	seat1.setPlace( (int)Integer.parseInt(seatChoice1.substring(0, seatChoice1.length() - 1)), seatChoice1.substring(seatChoice1.length() -1));
	System.out.println("You have chosen seat " + seatChoice1 + " which is a/an " + seat1.getType() + " seat in class " + seat1.getmyClass());



	Plane Flight2 = new Plane(daysUntilReturn, flight.calcDistance());
	System.out.println("Now choose a seat for your return trip, here is the seating chart for your second flight");
	Flight2.fillSeats();
	System.out.println(Flight2.printSeats());

	String seatChoice2;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice2 = user_input.next().trim();

	//add error handling

	Seat seat2 = new Seat(Flight1);
	seat2.setPlace( (int)Integer.parseInt(seatChoice2.substring(0, seatChoice2.length() - 1)), seatChoice2.substring(seatChoice2.length() -1));
	System.out.println("You have chosen seat " + seatChoice2 + " which is a/an " + seat2.getType() + " seat in class " + seat2.getmyClass());
	}

	else if (ans.equals("no") && !(flight.anyDirects())){
	Plane Flight8 = new Plane(daysUntilDepart, flight.calcDistance() / 2);
	System.out.println("Here is the seating chart for the first leg of your flight");
	Flight8.fillSeats();
	System.out.println(Flight8.printSeats());

	String seatChoice8;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice8 = user_input.next().trim();

	//add error handling

	Seat seat8 = new Seat(Flight8);
	seat8.setPlace( (int)Integer.parseInt(seatChoice8.substring(0, seatChoice8.length() - 1)), seatChoice8.substring(seatChoice8.length() -1));
	System.out.println("You have chosen seat " + seatChoice8 + " which is a/an " + seat8.getType() + " seat in class " + seat8.getmyClass());



	Plane Flight9 = new Plane(daysUntilDepart, flight.calcDistance() / 2);
	System.out.println("Now choose a seat for the second leg of your flight, here is the seating chart:");
	Flight9.fillSeats();
	System.out.println(Flight9.printSeats());

	String seatChoice9;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice9 = user_input.next().trim();

	//add error handling

	Seat seat9 = new Seat(Flight9);
	seat9.setPlace( (int)Integer.parseInt(seatChoice9.substring(0, seatChoice9.length() - 1)), seatChoice9.substring(seatChoice9.length() -1));
	System.out.println("You have chosen seat " + seatChoice9 + " which is a/an " + seat9.getType() + " seat in class " + seat9.getmyClass());





	}
	else {
   Plane Flight3 = new Plane(daysUntilDepart, flight.calcDistance());
	System.out.println("Here is the seating chart for your  flight");
	Flight3.fillSeats();
	System.out.println(Flight3.printSeats());

	String seatChoice3;
	System.out.println("Please input your seat choice (ex: 13A)");
	seatChoice3 = user_input.next().trim();

	//add error handling

	Seat seat3 = new Seat(Flight3);
	seat3.setPlace( (int)Integer.parseInt(seatChoice3.substring(0, seatChoice3.length() - 1)), seatChoice3.substring(seatChoice3.length() -1));
	System.out.println("You have chosen seat " + seatChoice3 + " which is a/an " + seat3.getType() + " seat in class " + seat3.getmyClass());


	}


	//***************************************************************

	//System.out.println("distance: " + flight.calcDistance());

	String name;
	System.out.println("What is the name of the ticket holder?");
	name = user_input.next();

	System.out.println("Your reservation is complete. Here is your itinerary:");
	
	System.out.println();
	int flightNum = 1;
	System.out.println("Ticket Holder: " + name);
	System.out.println();
	System.out.println("Flight " + flightNum + ": " + depart + " (in " + daysUntilDepart + " days)");
	flightNum++;
	if (flight.anyDirects()) {
	    System.out.println(flight.getRoutes()[flight.getDirects().get(routechoice)][0] + ": " + Loc1 + " to " + Loc2);
	    System.out.println("Distance (km): " + flight.calcDistance() + " Time (hr): " + flight.calcDistance()/850);
	}
	else {
	    System.out.println(leg1.getRoutes()[leg1.getDirects().get(leg1choice)][0] + ": " + Loc1 + " to " + transferchoice);
	    System.out.println("Distance (km): " + leg1.calcDistance() + " Time (hr): " + leg1.calcDistance()/850);
	    System.out.println();
	    System.out.println("Flight " + flightNum + ": " + depart + " (in " + daysUntilDepart + " days)");
	    flightNum++;
	    System.out.println(leg2.getRoutes()[leg2.getDirects().get(leg2choice)][0] + ": " + transferchoice + " to " + Loc2);
	    System.out.println("Distance (km): " + leg2.calcDistance() + " Time (hr): " + leg2.calcDistance()/850);
	}
	if (roundtrip) {
	    System.out.println();
	    System.out.println("Flight " + flightNum + ": " + Return + " (in " + daysUntilReturn + " days)");
	    flightNum++;
	    if (flight.anyDirects()) {
		System.out.println(flight.getRoutes()[flight.getDirects().get(routechoice)][0] + ": " + Loc2 + " to " + Loc1);
		System.out.println("Distance (km): " + flight.calcDistance() + " Time (hr): " + flight.calcDistance()/850);
	    }
	    else {
		System.out.println(leg2.getRoutes()[leg2.getDirects().get(leg2choice)][0] + ": " + Loc2 + " to " + transferchoice);
		System.out.println("Distance (km): " + leg2.calcDistance() + " Time (hr): " + leg2.calcDistance()/850);
		System.out.println();
		System.out.println("Flight " + flightNum + ": " + Return + " (in " + daysUntilReturn + " days)");
		flightNum++;
		System.out.println(leg1.getRoutes()[leg1.getDirects().get(leg1choice)][0] + ": " + transferchoice + " to " + Loc1);
		System.out.println("Distance (km): " + leg1.calcDistance() + " Time (hr): " + leg1.calcDistance()/850);
	    }
	}
	System.out.println();
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
