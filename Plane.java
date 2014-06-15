public class Plane {
    private String[][] type1, type2, type3;

    public Plane() {
	type1 = new String[14][5];
	type2 = new String[40][7];
	type3 = new String[44][9];
    }


    public void fill1 (int daysLeft) {
	for(int r = 0; r < type1.length; r++) {
	    for(int c = 0; c < type1[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " __ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 10);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " __ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 25);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " __ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 100);
		    if (rand == 0)
			type1[r][c] = " X ";
		    else 
			type1[r][c] = " __ ";
		}


		if(c == 3)
		    type1[r][c] = " | ";
	    }
	}
    }

public void fill2 (int daysLeft) {
	for(int r = 0; r < type2.length; r++) {
	    for(int c = 0; c < type2[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " __ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 10);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " __ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 25);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " __ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 100);
		    if (rand == 0)
			type2[r][c] = " X ";
		    else 
			type2[r][c] = " __ ";
		}


		if(c == 4)
		    type2[r][c] = " | ";
	    }
	}
    }

public void fill3 (int daysLeft) {
	for(int r = 0; r < type3.length; r++) {
	    for(int c = 0; c < type3[0].length; c++) {
		int rand;
		if (daysLeft <= 7) {
		    rand = (int) (Math.random() * 5);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " __ ";
		}
		else if (daysLeft <= 28) {
		    rand = (int) (Math.random() * 10);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " __ ";
		}
		else if (daysLeft <= 84) {
		    rand = (int) (Math.random() * 25);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " __ ";
		}
		else if (daysLeft > 84) {
		    rand = (int) (Math.random() * 100);
		    if (rand == 0)
			type3[r][c] = " X ";
		    else 
			type3[r][c] = " __ ";
		}


		if(c == 3 || c == 7)
		    type1[r][c] = " | ";
	    }
	}
    }



    public String[][] fillSeats(int dist) {
	//miles
	 if(dist < 389.62) {
	    fill(type1);
	    return type1;
	}
	else if(dist < 4907.68) {
	    fill(type2);
	    return type2;
	}
	else  {
	    fill(type3);
	    return type3;
	}
    }

	public String printSeats() {
	    String ret = "";
	    String[][] arr = fillSeats();
	    if(arr.length == 14)
		ret = "   A  B     C  D " +"\n"; 
	    if(arr.length == 40)
		ret = "   A  B  C     D  E  F " +"\n"; 
	    if(arr.length == 44)
		ret = "   A  B     C  D  E     F  G " +"\n"; 

	   for(int r = 0; r < arr.length; r++) {
	    for(int c = 0; c < arr[0].length; c++) {
		if(c == 0)
		ret += r + " " + arr[r][c];
		else
		    ret +=  arr[r][c];
		}
	    ret += "\n";
	    }

	   return ret; 
	}








}