import java.util.*;

public class Main {
    public static void main(String[] args) {
        
        HotelPromotion promo[] = new HotelPromotion[2];

        Scanner in = new Scanner(System.in);//for string
        Scanner in1 = new Scanner(System.in);//for others
        
        for(int i = 0; i < promo.length; i++) {
            //input
            System.out.println("Enter the information of customer " + (i + 1) + ": ");
            System.out.println("Enter booking code: ");
            String bookingCode = in.nextLine();
            System.out.println("Enter customer name: ");
            String customerName = in.nextLine();
            System.out.println("Enter phone number: ");
            String phoneNo = in.nextLine();
            System.out.println("\nL-Luxury, B-Budget, S-SweetEscape\nChoose the promotion type(L/B/S): ");
            char promotionType = in1.next().toLowerCase().charAt(0);
            System.out.println("Enter length of stay in days: ");
            int day = in1.nextInt();
            System.out.println("Enter the block: ");
            String block = in.nextLine();
            System.out.println("Enter the level: ");
            String level = in.nextLine();
            System.out.println("Enter the room number: ");
            String no = in.nextLine();
            System.out.println("Enter the deposit: RM");
            double deposit = in1.nextDouble();

            //create promo array object
            Room roomReserve = new Room(block, level, no);
            promo[i] = new HotelPromotion(bookingCode, customerName, phoneNo, promotionType, day, roomReserve, deposit);
            System.out.println();
        }

        int choice = 0;
        int count = 0;
        String bookingCode = "";
        while (choice != 3) {
            System.out.println("1. Count and display the booking code of customers who already paid for booking.");
            System.out.println("2. Find the customer check-in based on booking code entered by the user.");
            System.out.println("3. Exit");
            System.out.print("\nEnter your choice: ");
            choice = in1.nextInt();
            System.out.println();
            switch (choice) {
                    case 1:
                            count = 0;
                            for (int i = 0; i < promo.length; i++) {
                                    if (promo[i].getDeposit() > 0) {
                                            count++;
                                    }
                            }
                            System.out.println("The number of customers who already paid for booking: " + count);
                            break;
                    case 2:
                            boolean found = false;
                            double originalPrice = 0;
                            System.out.print("Enter the booking code (e.g. " + promo[0].getBookingCode() + "): ");
                            bookingCode = in.nextLine();
                            System.out.println();

                            for (int i = 0; i < promo.length; i++) {
                                    if (promo[i].getBookingCode().equals(bookingCode)) {
                                            // Using getters to access the object's attributes
                                            System.out.println("Customer name: " + promo[i].getCustomerName());
                                            System.out.println("Phone number: " + promo[i].getPhoneNo());
                                            System.out.println("Promotion type: " + promo[i].getPromotionType());
                                            System.out.println("Day: " + promo[i].getDay());
                                            // Using composition to access the Room object inside
                                            // HotelPromotion object
                                            System.out.println("Room block: " + promo[i].getRoomReserve().getBlock());
                                            System.out.println("Room level: " + promo[i].getRoomReserve().getLevel());
                                            System.out.println("Room number: " + promo[i].getRoomReserve().getNo());
                                            
                                            switch (promo[i].getPromotionType()) {
                                                    case 'L':
                                                            originalPrice = 4000.00 * promo[i].getDay();
                                                            break;
                                                    case 'B':
                                                            originalPrice = 1500.00 * promo[i].getDay();
                                                            break;
                                                    case 'S':
                                                            originalPrice = 3300.00 * promo[i].getDay();
                                                            break;
                                            }

                                            // Using methods to perform calculations
                                            System.out.printf("Original price: RM %,.2f\n", originalPrice);
                                            System.out.printf("Discount deducted : RM %,.2f\n", promo[i].calculatePromotion());
                                            System.out.printf("Total price after discount: RM %,.2f\n", originalPrice - promo[i].calculatePromotion());
                                            System.out.printf("Deposit: RM %,.2f\n", promo[i].getDeposit());
                                            System.out.printf("Balance left to be paid: RM %,.2f\n", originalPrice - promo[i].getDeposit() - promo[i].calculatePromotion());
                                            found = true;
                                    }
                            }
                            if (!found) {
                                    System.out.println("Booking code not found.");
                            }
                            break;
                    case 3:
                            System.out.println("Thank you for using Hotel Reservation System");
                            break;
                    default:
                            System.out.println("Invalid choice.");
                            break;
            }
            System.out.println();
        }
    in.close();
    in1.close();
    }
}