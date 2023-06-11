public class Renter {
    private String name;
    private String contactNo;
    private Address address;
    private double travelDistance;
    private char lorrytype;
    private boolean driver;

    public Renter(String name, String contactNo, String streetName, String district, String state,
            double travelDistance, char lorrytype, boolean driver) {
        this.name = name;
        this.contactNo = contactNo;
        this.address = new Address(streetName, district, state);
        this.travelDistance = travelDistance;
        this.lorrytype = lorrytype;
        this.driver = driver;
    }

    public void setRenter(String name, String contactNo, Address address, double travelDistance, char lorrytype,
            boolean driver) {
        this.name = name;
        this.contactNo = contactNo;
        this.address = address;
        this.travelDistance = travelDistance;
        this.lorrytype = lorrytype;
        this.driver = driver;
    }

    public String getName() {
        return name;
    }

    public Address getAddress() {
        return address;
    }

    public double getTravelDistance() {
        return travelDistance;
    }

    public char getLorryType() {
        return lorrytype;
    }

    public boolean getDriver() {
        return driver;
    }

    public String getContactNo() {
        return contactNo;
    }

    public double calculateSpecialService() {
        double specialService = 0;
        if (lorrytype == 'A') {
            specialService = 0.1 * travelDistance;
        } else if (lorrytype == 'B') {
            specialService = 0.2 * travelDistance;
        } else if (lorrytype == 'C') {
            specialService = 0.3 * travelDistance;
        }
        return specialService;
    }

    public double calculateTotalPrice() {
        double totalPrice = 0;
        if (lorrytype == 'A') {
            totalPrice = 560 + calculateSpecialService();
        } else if (lorrytype == 'B') {
            totalPrice = 720 + calculateSpecialService();
        } else if (lorrytype == 'C') {
            totalPrice = 1300 + calculateSpecialService();
        }

        if (driver) {
            if (travelDistance >= 200) {
                totalPrice += 150 * 2;
            } else {
                totalPrice += 150;
            }
        }

        return totalPrice;

    }

    public void displayRenter() {
        System.out.println("Name: " + name);
        System.out.println("Contact No: " + contactNo);
        System.out.println("Address: " + address);
        System.out.printf("Travel Distance: %,.2f km\n", travelDistance);
        System.out.println("Lorry Type: " + lorrytype);
        System.out.println("Driver: " + driver);
        System.out.printf("Special Service: RM %,.2f\n", calculateSpecialService());
        System.out.printf("Total Price: RM %,.2f\n", calculateTotalPrice());
        System.out.println();

    }

}