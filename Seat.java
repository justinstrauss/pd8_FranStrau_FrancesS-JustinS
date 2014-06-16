public class Seat {
    public String myClass, val, col, type;
    private int row;
    private Plane myPlane;

    public Seat() {
	myClass= "";
	val = "";
	col = "";
	type = "";
	row = 0;
	myPlane= null;


    }

    public Seat(String _val){
	val = _val;	
    }

  public Seat(Plane foo){
	myPlane = foo;	
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



    public void setVal(String _val) {
	val = _val;
    }

    public String getVal() {
	return val;
    }


    public String getmyClass() {
	return myClass;
    }


    public String getType() {
	return type;
    }

 


    public static void main(String[] args) {
	Seat me1 = new Seat("VVV");
	System.out.println(me1.getVal());
  /* 
	Plane me2 = new Plane(90, 100);
	me2.fillSeats();
	System.out.println(me2.printSeats());


	Plane me3 = new Plane(1, 5000);
	me3.fillSeats();
	System.out.println(me3.printSeats());
  */
    }



    


}
