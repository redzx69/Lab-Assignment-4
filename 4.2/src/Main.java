import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Lorry Rental System");
        System.out.println();
        System.out.print("Enter the amount of array: ");
        int size = input.nextInt();
        input.nextLine();
        System.out.println();

        Renter[] renters = new Renter[size];

        String name, contactNo, streetName, district, state;
        double travelDistance;
        char lorryType;
        boolean driver;
        for (int i = 0; i < size; i++) {
            System.out.print("Enter name (e.g. Ali bin Abu): ");
            name = input.nextLine();
            System.out.print("Enter contact number (e.g. 0123456789): ");
            contactNo = input.nextLine();
            System.out.print("Enter street name (e.g. Jalan 1): ");
            streetName = input.nextLine();
            System.out.print("Enter district (e.g. Cheras): ");
            district = input.nextLine();
            System.out.print("Enter state (e.g. Selangor): ");
            state = input.nextLine();
            System.out.print("Enter travel distance (KM): ");
            travelDistance = input.nextDouble();
            System.out.print("A - 1 Ton (10 ft) with 2 movers\nB - 3 Ton (17 ft) with 3 movers\nC - 5 Ton (17 ft) with 5 movers\n\nEnter lorry type: ");
            lorryType = Character.toUpperCase(input.next().charAt(0));

            System.out.print("Do you need a driver? (Y/N): ");
            char driverChar = input.next().charAt(0);
            driverChar = Character.toUpperCase(driverChar);

            if (driverChar == 'Y') {
                driver = true;
            } else {
                driver = false;
            }

            renters[i] = new Renter(name, contactNo, streetName, district, state, travelDistance, lorryType, driver);

            input.nextLine();
            System.out.println();
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (renters[i].getLorryType() == 'A' && !renters[i].getDriver()) {
                count++;
            }
        }

        System.out.println("Number of renters who choose 1-ton lorry with no driver option: " + count);

        for (int i = 0; i < size; i++) {
            if (renters[i].getLorryType() == 'A' && !renters[i].getDriver()) {
                System.out.println("\nRenter who choose 1-ton lorry with no driver option:\n");
                renters[i].displayRenter();
            }
        }

        System.out.print("Do you want to search for a renter? (Y/N): ");
        char searchChar = input.next().charAt(0);
        searchChar = Character.toUpperCase(searchChar);

        while (searchChar == 'Y') {
            boolean found = false;
            System.out.print("Enter the contact number of the renter (e.g. 0123456789): ");
            String searchContactNo = input.next();

            for (int i = 0; i < size; i++) {
                if (searchContactNo.equals(renters[i].getContactNo())) {
                    found = true;
                    renters[i].displayRenter();
                }
            }

            if (found == false) {
                System.out.println("Renter not found");
            }

            System.out.print("\nDo you want to search for another renter? (Y/N): ");
            searchChar = Character.toUpperCase(input.next().charAt(0));
        }
        System.out.println("Thank you for using Lorry Rental System\n\nDeveloped by: InsanSoftHouse Sdn Bhd");
        input.close();
    }
}