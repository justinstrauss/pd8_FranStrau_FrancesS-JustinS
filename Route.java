import java.util.*;

public class Route {

    private String _origin;
    private double _lat1;
    private double _long1;
    private String _dest;
    private double _lat2;
    private double _long2;

    private double distance;
    private ArrayList cities = new ArrayList();

    private ListMaker master = new ListMaker("routes.dat", 59637, 8);
    private String[][] routes = master.getList();
    private ListMaker master2 = new ListMaker("airlines.dat", 5996, 8);
    private String[][] airlines = master2.getList();
    private ListMaker master3 = new ListMaker("airports.dat", 7734, 11);
    private String[][] airports = master3.getList();

    private ArrayList<Integer> directs = new ArrayList<Integer>();
    private ArrayList<String> transfers = new ArrayList<String>();

    public Route(String origin, String dest) { // add verification of codes
	_origin = origin;
	_dest = dest;
    }

    public double calcDistance() {
	for (int a = 0; a < airports.length; a++) {
	    if (_origin.equals(airports[a][4])) {
		_lat1 = Double.parseDouble(airports[a][6]);
		_long1 = Double.parseDouble(airports[a][7]);
	    }
	    if (_dest.equals(airports[a][4])) {
		_lat2 = Double.parseDouble(airports[a][6]);
		_long2 = Double.parseDouble(airports[a][7]);
	    }
	}
	distance = haversine(_lat1, _long1, _lat2, _long2);
	return distance;
    }

    public static double haversine(
				   double lat1, double lng1, double lat2, double lng2) {
	int r = 6371; // average radius of the earth in km
	double dLat = Math.toRadians(lat2 - lat1);
	double dLon = Math.toRadians(lng2 - lng1);
	double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) +
	    Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) 
	    * Math.sin(dLon / 2) * Math.sin(dLon / 2);
	double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
	double d = r * c;
	return d;
    }

    public ArrayList<Integer> findDirect() {
	for(int r = 0; r < routes.length; r++)
	    if ((routes[r][2].equals(_origin) && routes[r][4].equals(_dest))) 
		directs.add(r);

	HashSet hs = new HashSet();
	hs.addAll(directs);
	directs.clear();
	directs.addAll(hs);

	return directs;
    }

    public ArrayList getCities() {
	return cities;
    }

    public ArrayList<Integer> getDirects() {
	return directs;
    }

    public boolean anyDirects() {
	return !(findDirect().size() == 0);
    }

    public boolean anyTransfers() {
	return !(findTransfer().size() == 0);
    }

    public String printDirects() {
	String ret = "";
	for(int i = 0; i < directs.size(); i++) {
	    for(int j = 0; j < airlines.length; j++) {
		if (routes[directs.get(i)][0].equals(airlines[j][3])) {
		    ret += i + ": " + airlines[j][1] + "\n";
		    break;
		}
	    }
	}
	return ret;
    }

    public String printTransfers() {
	String ret = "";
	for(int i = 0; i < transfers.size(); i++)
	    cities.add(transfers.get(i));

	HashSet hs = new HashSet();
	hs.addAll(cities);
	cities.clear();
	cities.addAll(hs);

	for(int i = 0; i < cities.size(); i++) {
	    for(int j = 0; j < airports.length; j++) {
		if (cities.get(i).equals(airports[j][4])) {
		    ret += i + ": " + cities.get(i) + " - " + airports[j][1]
			+ " in " + airports[j][2] + ", " + airports[j][3] + "\n";
		    break;
		}
	    }
	}
	return ret;

    }


    public ArrayList<String> findTransfer() {
	ArrayList<String> transfers1 = new ArrayList<String>();


	for(int r = 0; r < routes.length; r++) {
	    if ( routes[r][2].equals(_origin))
		transfers1.add(routes[r][4]);
	}
	String origin1 = _origin;

	for(String i: transfers1) {
	    _origin = i;

	    for(int r = 0; r < routes.length; r++)
		if ((routes[r][2].equals(_origin) && routes[r][4].equals(_dest)))
		    transfers.add(routes[r][2]);
	    
	}
	_origin = origin1;

	return transfers;


    }

}
