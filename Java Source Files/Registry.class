import java.util.*;

public class Registry {
	
	// ArrayLists used for program implementation
	
	// For storing all suspects
	private ArrayList<Suspect> suspects = new ArrayList<Suspect>();
	
	// For storing all communications
	private ArrayList<Communication> comm = new ArrayList<Communication>();
	
	// For storing all dangerous SMS messages
	private ArrayList<SMS> dangerous_sms = new ArrayList<SMS>();
	
	// For storing suspects with the highest number of potential partners
	private ArrayList<Suspect> maxsuspects = new ArrayList<Suspect>();
	
	
	// Method to add suspects to the ArrayList 'suspects'
	public void addSuspect(Suspect suspect) {
		suspects.add(suspect);
	}

	// Method to add communications to the ArrayList 'comm'
	public void addCommunication(Communication aCommunication) {
		comm.add(aCommunication);
		
		// For each communication, establish connections between suspects and add them to each other's potential partners list
		for(Suspect suspect1: suspects) {
			for(Suspect suspect2: suspects) {
				if(suspect1.getNumber().contains(aCommunication.getNum1()) && (suspect2.getNumber().contains(aCommunication.getNum2()))) {
					suspect1.addPartners(suspect2);
					suspect2.addPartners(suspect1);
				}
			}
		}
	}
	
	// Method to get the suspect with the most potential partners
	public Suspect getSuspectWithMostPartners() {
		Suspect sus;
		int max = 0;
		
		// Traverse the suspects list and find the size of the maximum potential partners list
		for(Suspect suspect: suspects) {
			if(max<suspect.getPartners().size()) {
				max = suspect.getPartners().size();	
			}
		}
		
		// Traverse the suspects list again and add suspects with the maximum number of potential partners to 'maxsuspects' ArrayList
		for(Suspect suspect: suspects) {
			if(max==suspect.getPartners().size()) {
				maxsuspects.add(suspect);
			}
		}
		
		// Choose a random suspect from 'maxsuspects' ArrayList and return
		int randomIntex = (int) (Math.random() * maxsuspects.size());
		sus = maxsuspects.get(randomIntex);
		
		return sus;
	}

	// Method to get the longest phone call between two numbers
	public PhoneCall getLongestPhoneCallBetween(String Num1, String num2) {
		
		int max = 0;
		PhoneCall phone = null;
	
		// Traverse the 'comm' ArrayList
		for(Communication com: comm) {
			// Check if the communication is a PhoneCall before proceeding
			if(com.getClass().getTypeName().equals(PhoneCall.class.getTypeName())) {
				// Cast the object 'com' as a PhoneCall object
				PhoneCall p = (PhoneCall) com;
				if(Num1.equals(p.getNum1()) && num2.equals(p.getNum2())){
					if(max < p.getDuration()) {
						max = p.getDuration();
						phone = p;
					}
				}
			}			
		}
		return phone;
	}
	
	// Method to get suspicious SMS messages between two numbers
	public ArrayList<SMS> getMessagesBetween(String Num1, String num2) {
		
		// Traverse the 'comm' ArrayList
		for(Communication com: comm) {
			// Check if the communication is an SMS before proceeding
			if(com.getClass().getTypeName().equals(SMS.class.getTypeName())) {
				// Cast the object 'com' as an SMS object
				SMS message = (SMS) com;
				if(Num1.equals(message.getNum1()) && num2.equals(message.getNum2())) {
					// Check if the SMS contains suspicious keywords and add it to 'dangerous_sms' ArrayList
					if(message.getText().contains("Bomb") || message.getText().contains("Attack")
							|| message.getText().contains("Gun") || message.getText().contains("Explosives")){
						dangerous_sms.add(message);
					}
				}	
			}	
		}
		return dangerous_sms;
	}

	// Method to print suspects originating from a specific country
	public void printSuspectsFromCountry(String country) {
		System.out.println("Suspects coming from " + country +":");
		for(Suspect suspect: suspects) {
			if(country.equals(suspect.getCountry())) {
				System.out.println(suspect.getName() + " (" + suspect.getCodeName() +")");
			}
		}	
	}
}
