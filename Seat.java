public class Seat {
    private String myClass, val, col, type;
    private int row , price;
    private Plane myPlane;

    public Seat(Plane foo){
	myPlane = foo;	
	price = 0;
    }

    public void setPlace(int _row, String _col) {
	row = _row;
	col = _col;
	if(row <= (int)(myPlane.myType.length * (1/ 4.0)))
	    myClass = "First";
	else if(row <= (int)(myPlane.myType.length * (2/ 3.0)))
	    myClass = "Business";
	else
	    myClass = "Economy";

	if(myPlane.myType.length == 14){
	    if(col.equals("A") || (col.equals("D")))
		type = "Window";
	    else
		type = "Aisle";

	}
	if(myPlane.myType.length == 40) {
	    if(col.equals("A") || (col.equals("F")))
		type = "Window";
	    else if (col.equals("C") || (col.equals("D")))
		type = "Aisle";
	    else
		type = "Middle";
	}


	if(myPlane.myType.length == 44){
	    if(col.equals("A") || (col.equals("G")))
		type = "Window";
	    else if (col.equals("B") || (col.equals("C")) || col.equals("E") || (col.equals("F")))
		type = "Aisle";
	    else
		type = "Middle";

	}

    }


    public int getPrice(int daysLeft) {
	if(myClass.equals("First")

	   //figure out normal prices

    }

    public String setVal(String _val) {
	val = _val;
    }

    public String getVal() {
	return val;
    }


    public String getClass() {
	return myClass;
    }



    


}
