public class Plane {
    private String[][] type1, type2, type3;
    private int daysLeft, distance;

    public Plane(int days, int dist) {
	type1 = new String[14][5];
	type2 = new String[40][7];
	type3 = new String[44][9];

	daysLeft = days;
	distance = dist;
    }


    public void fill1 () {
	for(int r = 0; r < type1.length; r++) {
	    for(int c = 0; c < type1[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 2);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " _ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " _ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 15);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " _ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 50);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " _ ";
		}


		if(c == 2)
		    type1[r][c] = " | ";
	    }
	}
    }

public void fill2 () {
	for(int r = 0; r < type2.length; r++) {
	    for(int c = 0; c < type2[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 1);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " _ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " _ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 15);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " _ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 50);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " _ ";
		}


		if(c == 3)
		    type2[r][c] = " | ";
	    }
	}
    }

public void fill3 () {
	for(int r = 0; r < type3.length; r++) {
	    for(int c = 0; c < type3[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 2);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " _ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " _ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 15);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " _ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 50);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " _ ";
		}


		if(c == 2 || c == 6)
		    type3[r][c] = " | ";
	    }
	}
    }



    public String[][] fillSeats() {
	//miles
	 if(distance < 389.62) {
	    fill1();
	    return type1;
	}
	else if(distance < 4907.68) {
	    fill2();
	    return type2;
	}
	else  {
	    fill3();
	    return type3;
	}
    }

	public String printSeats() {
	    String ret = "";
	    String[][] arr = fillSeats();
	    if(arr.length == 14)
		ret = "    A  B     C  D " +"\n"; 
	    if(arr.length == 40)
		ret = "    A  B  C     D  E  F " +"\n"; 
	    if(arr.length == 44)
		ret = "    A  B     C  D  E     F  G " +"\n"; 

	   for(int r = 0; r < arr.length; r++) {
	    for(int c = 0; c < arr[0].length; c++) {
		if(c == 0 && r < 9)
		    ret += " " + (r+1) + " " + arr[r][c];
		else if (c == 0 && r >= 9)
		    ret +=  (r+1) + " " + arr[r][c];
		else
		    ret +=  arr[r][c];
		}
	    ret += "\n";
	    }

	   return ret; 
	}

    public static void main(String[] args) {
	Plane me1 = new Plane(12, 3000);
	me1.fillSeats();
	System.out.println(me1.printSeats());

	Plane me2 = new Plane(90, 100);
	me2.fillSeats();
	System.out.println(me2.printSeats());


	Plane me3 = new Plane(1, 5000);
	me3.fillSeats();
	System.out.println(me3.printSeats());

    }






}