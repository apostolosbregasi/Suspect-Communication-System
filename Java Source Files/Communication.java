// Communication Class
// This class is used as an abstract class
// for the PhoneCall & SMS classes

public abstract class Communication {
	
	private String Num1;
	private String Num2;
	private int day;
	private int month;
	private int year;
	
	
	public Communication(String num1, String num2, int day, int month, int year) {
		Num1 = num1;
		Num2 = num2;
		this.day = day;
		this.month = month;
		this.year = year;
	}

	public String getNum1() {
		return Num1;
	}

	public String getNum2() {
		return Num2;
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}

	// Method that prints common elements in printInfo
	// in the PhoneCall & SMS classes
	
	public void printInfo() {
		System.out.println("Between " + getNum1() + " and " + getNum2());
		System.out.println("on " + getYear()+"/"+getMonth()+"/"+getDay());
	}
}
