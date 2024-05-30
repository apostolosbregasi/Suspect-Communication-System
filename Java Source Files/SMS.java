// SMS class, a subclass of Communication

public class SMS extends Communication {

	private String text;

	// Constructor utilizes super to inherit attributes from the superclass
	// and adds the text attribute
	
	public SMS(String num1, String num2, int day, int month, int year, String text) {
		super(num1, num2, day, month, year);
		this.text = text;
	}
	
	public String getText() {
		return text;
	}

	// Method to print message details
	// Uses super to print the printInfo method of the Communication class
	
	public void printInfo() {
		
		System.out.println("This SMS has the following info");
		super.printInfo();
		System.out.println("Text: " + getText());
	}

}
