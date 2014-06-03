public class Route {

private String _origin;
private String _dest;
private ListMaker master = new ListMaker("routes.dat", 59637, 8);
private ArrayList<Integer> directs = new ArrayList<Integer>();
 private  String[][] routes = master.getList();


public Route(String origin, String dest) { // add verification of codes
_origin = origin;
_dest = dest;
}

public ArrayList<Integer> findDirect() {

for(int r = 0; r < routes.length; r++) {
    if ((routes[r][2].equals(_origin) || routes[r][2].equals(_dest)) && 
	(routes[r][4].equals(_origin) || routes[r][4].equals(_dest)) &&
	!(alreadyInDirects(r))) {
	directs.add(r);
    }

    return directs;

}

public boolean alreadyInDirects(Integer r) {
	for (int = 0; i<directs.size(); i++)
		if (directs[i] = r)
			return true;
	return false;
}

public boolean anyDirects() {
    if (findDirect().size() == 0)
	return false;
    else
	return true;

}

public String printDirect() {
    String ret = "";
    for(i = 0; i < directs.size(); i++) {
	ret += routes[directs.get(i)][0] + "  ";
    }
    return ret;

}

   public ArrayList<String> findTransfer() {
	ArrayList<String> transfers1 = new ArrayList<Integer>();
	ArrayList<String> transfers2 = new ArrayList<Integer>();

	for(int r = 0; r < routes.length; r++) {
	    if ( routes[r][2].equals(_origin))
		transfers1.add(routes[r][4]);
	    if (routes[r][4].equals(_dest))
		transfers2.add(routes[r][2]);
	}




    }

}
