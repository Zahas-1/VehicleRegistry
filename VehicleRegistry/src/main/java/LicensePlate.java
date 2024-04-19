import java.util.ArrayList; // Importing ArrayList class from java.util package
import java.util.HashMap; // Importing HashMap class from java.util package

public class LicensePlate { // Declaration of the LicensePlate class
    // Declaration of private final instance variables for license number and country
    private final String liNumber;
    private final String country;

    // Constructor for the LicensePlate class, initializes country and license number
    public LicensePlate(String country, String liNumber) {
        this.liNumber = liNumber; // Assigns value to liNumber instance variable
        this.country = country; // Assigns value to country instance variable
    }

    @Override
    public String toString() { // Method to return a string representation of the license plate
        return country + " " + liNumber; // Returns concatenated country and license number
    }

    @Override
    public boolean equals(Object compare){ // Override equals method to compare LicensePlate objects
        // Checks if the objects are located in the same memory location
        if(this == (compare)){
            return true; // Returns true if objects are identical
        }
        // Checks if the compared object is not an instance of LicensePlate class
        if(!(compare instanceof LicensePlate)){
            return false; // Returns false if compared object is not LicensePlate
        }
        // Converts the compared object to LicensePlate type
        LicensePlate compare2 = (LicensePlate) compare;

        // Checks if the instance variables of both objects are equal
        if(this.liNumber.equals(compare2.liNumber) &&
                this.country.equals(compare2.country)){
            return true; // Returns true if both objects have identical instance variables
        }
        return false; // Returns false otherwise
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int result = 1;
        result = prime * result + ((country == null) ? 0 : country.hashCode());
        result = prime * result + ((liNumber == null) ? 0 : liNumber.hashCode());
        return result;
    }


    //Test code
    public static void main(String[] args) { // Main method for testing the LicensePlate class

        // Creating LicensePlate objects
        LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FI", "UXE-465");
        LicensePlate li3 = new LicensePlate("D", "B WQ-431");

        // Creating an ArrayList to store LicensePlate objects
        ArrayList<LicensePlate> finnishPlates = new ArrayList<>();
        finnishPlates.add(li1); // Adding LicensePlate object to the ArrayList
        finnishPlates.add(li2); // Adding LicensePlate object to the ArrayList

        // Creating a new LicensePlate object
        LicensePlate newLi = new LicensePlate("FI", "ABC-123");
        // Checking if the ArrayList contains the new LicensePlate object
        if (!finnishPlates.contains(newLi)) {
            finnishPlates.add(newLi); // Adding LicensePlate object to the ArrayList if not present
        }
        System.out.println("finnish: " + finnishPlates); // Printing the contents of the ArrayList

        // Creating a HashMap to store LicensePlate objects with owner information
        HashMap<LicensePlate, String> owners = new HashMap<>();
        owners.put(li1, "Arto"); // Adding LicensePlate object with owner information to the HashMap
        owners.put(li3, "Jürgen"); // Adding LicensePlate object with owner information to the HashMap

        // Printing owner information for specific license plates
        System.out.println("Owners:");
        System.out.println(owners.get(new LicensePlate("FI", "ABC-123"))); // Printing owner information for a specific license plate
        System.out.println(owners.get(new LicensePlate("D", "B WQ-431"))); // Printing owner information for a specific license plate
    }
}
