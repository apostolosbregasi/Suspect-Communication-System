import java.util.ArrayList;

// Class representing a suspect
public class Suspect {
    
    // Suspect details:
    // Name - name
    // Codename - codename
    // Country - country
    // City - city
    private String name;
    private String codename;
    private String country;
    private String city;
    
    // Three ArrayLists used for program implementation
    // 1. For storing the suspect's numbers: numbers
    // 2. For storing possible partners of a suspect: partners
    // 3. For storing common possible partners between suspects: commonPartners
    private ArrayList<String> numbers = new ArrayList<String>();
    private ArrayList<Suspect> partners = new ArrayList<Suspect>();
    private ArrayList<Suspect> commonPartners = new ArrayList<Suspect>();
    private ArrayList<Suspect> possiblePartners = new ArrayList<Suspect>();
    
    // Constructor
    public Suspect(String name, String codename, String country, String city) {
        this.name = name;
        this.codename = codename;
        this.country = country;
        this.city = city;
    }
    
    public String getName() {
        return name;
    }
    
    public String getCodeName() {
        return codename;
    }
    
    public String getCountry() {
        return country;
    }
    
    public String getCity() {
        return city;
    }
    
    // Method for adding suspect's numbers
    public void addNumber(String number) {
        numbers.add(number);
    }
    
    public ArrayList<String> getNumber() {
        return numbers;
    }
    
    // Method for adding possible partners of a suspect
    // Addition occurs only if the possible partner does not already exist in the partners ArrayList
    public void addPartners(Suspect partner) {
        if (!partners.contains(partner)) {
            partners.add(partner);
        }
    }
    
    public ArrayList<Suspect> getPartners() {
        return partners;
    }
    
    // Method to check if a suspect is in the list of possible partners of another suspect
    public boolean isConnectedTo(Suspect suspect) {
        return partners.contains(suspect);
    }
    
    // Method to return the common partners between two suspects
    public ArrayList<Suspect> getCommonPartners(Suspect s) {
        for (int i = 0; i < s.getPartners().size(); i++) {
            if (getPartners().contains(s.getPartners().get(i))) {
                commonPartners.add(s.getPartners().get(i));
            }
        }
        return commonPartners;
    }

    // Method to print all the possible partners of a suspect
    public void printPartners() {
        // Iterates through the entire list of possible partners of the suspect
        // and prints their name and codename
        for (Suspect sus_partners : partners) {
            System.out.print(sus_partners.getName() + " (" + sus_partners.getCodeName() + ") ");
            // If the possible partner is from the same country as the suspect,
            // then an asterisk is printed, otherwise the country name of the possible partner is printed
            if (getCountry().equals(sus_partners.getCountry())) {
                System.out.print("*\n");
            } else {
                System.out.print(sus_partners.getCountry() + "\n");
            }
        }
    }
}
