// Class PhoneCall, subclass of Communication

public class PhoneCall extends Communication {

    private int duration;

    // Constructor: Utilizes super to inherit attributes from the superclass
    // and adds the duration parameter
    public PhoneCall(String num1, String num2, int day, int month, int year, int duration) {
        super(num1, num2, day, month, year);
        this.duration = duration;
    }

    // Getter method for duration
    public int getDuration() {
        return duration;
    }

    // Method to print phone call information
    // Uses super to also call the printInfo method of the Communication class
    public void printInfo() {
        System.out.println("This phone call has the following information:");
        super.printInfo();
        System.out.println("Duration: " + getDuration() + " seconds");
    }
}
