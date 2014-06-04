import java.util.*;

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
	for(int r = 0; r < routes.length; r++)
	    if ((routes[r][2].equals(_origin) && routes[r][4].equals(_dest))) 
		directs.add(r);
	return directs;
    }

    // public boolean alreadyInDirects(Integer r) {
    // 	for (int i = 0; i<directs.size(); i++)
    // 	    if (directs.get(i) == r)
    // 		return true;
    // 	return false;
    // }

    public boolean anyDirects() {
	if (findDirect().size() == 0)
	    return false;
	else
	    return true;

    }

    public String printDirect() {
	String ret = "";
	for(int i = 0; i < directs.size(); i++) {
	    ret += routes[directs.get(i)][0] + "  ";
	}
	return ret;

    }

}
