import java.util.ArrayList; // Importing ArrayList class from java.util package
import java.util.HashMap; // Importing HashMap class from java.util package

public class VehicleRegistry { // Declaration of the VehicleRegistry class
    private LicensePlate licensePlate; // Declaration of private LicensePlate object variable
    private String owner; // Declaration of private String variable to store owner information
    private HashMap<LicensePlate, String> ownerArr; // Declaration of private HashMap with LicensePlate keys and String values to store owner information

    public VehicleRegistry(){ // Constructor for the VehicleRegistry class
        this.ownerArr = new HashMap<>(); // Initializes ownerArr as a new empty HashMap
    }

    public boolean add(LicensePlate licensePlate, String owner){ // Method to add a new license plate and owner information to the registry
        if(!ownerArr.containsKey(licensePlate)){ // Checks if the license plate is not already present in the registry
            ownerArr.put(licensePlate, owner); // Adds the license plate and owner information to the registry HashMap
            return true; // Returns true indicating successful addition
        } else return false; // Returns false indicating the license plate is already present
    }

    public String get(LicensePlate licensePlate){ // Method to retrieve owner information based on the provided license plate
        return ownerArr.getOrDefault(licensePlate, "null"); // Returns the owner information associated with the provided license plate, or "null" if not found
    }

    public boolean remove(LicensePlate licensePlate){ // Method to remove a license plate and its associated owner information from the registry
        if(ownerArr.containsKey(licensePlate)){ // Checks if the license plate is present in the registry
            ownerArr.remove(licensePlate); // Removes the license plate and associated owner information from the registry
            return true; // Returns true indicating successful removal
        } else return false; // Returns false indicating the license plate was not found
    }

    public void printLicensePlates(){ // Method to print all license plates stored in the registry
        for(LicensePlate items : ownerArr.keySet()){ // Iterates through the keys (license plates) in the registry HashMap
            System.out.println(items + ", "); // Prints each license plate
        }
    }

    public void printOwners(){ // Method to print all unique owners stored in the registry
        ArrayList<String> owners = new ArrayList<>(); // Creates an ArrayList to store unique owner names
        for(String owner : ownerArr.values()){ // Iterates through the values (owner names) in the registry HashMap
            if(!(owners.contains(owner))){ // Checks if the owner name is not already present in the ArrayList
                System.out.println(owner); // Prints the owner name
                owners.add(owner); // Adds the owner name to the ArrayList to ensure uniqueness
            }
        }
    }

    // Test code
    public static void main(String[] args) {
        VehicleRegistry registry = new VehicleRegistry(); // Creates a new VehicleRegistry object

        // Create some license plates
        LicensePlate li1 = new LicensePlate("FI", "ABC-123");
        LicensePlate li2 = new LicensePlate("FE", "UXE-465");
        LicensePlate li3 = new LicensePlate("D", "B WQ-431");
        LicensePlate li4 = new LicensePlate("E", "B WQ-431");
        LicensePlate li5 = new LicensePlate("J", "B WQ-431");
        LicensePlate li6 = new LicensePlate("D", "B WQ-431");

        // Add license plates to the registry
        registry.add(li1, "Bob");
        registry.add(li2, "Dave");
        registry.add(li4, "Dave");
        registry.add(li5, "Dave");
        registry.add(li3, "Scott");
        registry.add(li6, "Scott");
        registry.add(li3, "Bob");

        // Test getting owner by license plate
        System.out.println("Owner of ABC-123: " + registry.get(li1)); // Should print "Bob"
        System.out.println("Owner of UXE-465: " + registry.get(li2)); // Should print "Dave"
        System.out.println("Owner of B WQ-431: " + registry.get(li3)); // Should print "Scott"

        // Test removing a license plate
        System.out.println("Removing license plate ABC-123: " + registry.remove(li1)); // Should print "true"
        System.out.println("Removing license plate XYZ-789: " + registry.remove(new LicensePlate("US", "XYZ-789"))); // Should print "false"

        // Print all license plates in the registry
        registry.printLicensePlates();

        // Print all unique owners
        registry.printOwners();
    }
}
