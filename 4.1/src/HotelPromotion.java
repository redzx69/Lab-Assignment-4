public class HotelPromotion {
    private String bookingCode;
    private String customerName;
    private String phoneNo;
    private char promotionType;
    private int day;
    private Room roomReserve;
    private double deposit;

    public HotelPromotion(String bookingCode, String customerName, String phoneNo, char promotionType, int day, Room roomReserve, double deposit) {
        this.bookingCode = bookingCode;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.promotionType = promotionType;
        this.day = day;
        this.roomReserve = roomReserve;
        this.deposit = deposit;
    }

    public void setHotelPromotion(String bookingCode, String customerName, String phoneNo, char promotionType, int day,
            Room roomReserve, double deposit) {
        this.bookingCode = bookingCode;
        this.customerName = customerName;
        this.phoneNo = phoneNo;
        this.promotionType = promotionType;
        this.day = day;
        this.roomReserve = roomReserve;
        this.deposit = deposit;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public char getPromotionType() {
        return promotionType;
    }

    public int getDay() {
        return day;
    }

    public Room getRoomReserve() {
        return roomReserve;
    }

    public double getDeposit() {
        return deposit;
    }

    // processors
    public double calculatePromotion() {
        double price = 0.0;
        switch (promotionType) {
            case 'L':
            case 'l':
                price = 4000.0 * (1 - 0.25);
                break;
            case 'B':
            case 'b':
                price = 1500.0 * (1 - 0.20);
                break;
            case 'S':
            case 's':
                price = 3300.0 * (1 - 0.15);
                break;
            default:
                price = 0.0;
                System.out.print("Invalid promotion type!");
                break;
        }
        return price;
    }

    // compares two blocks is the same
    public boolean isSameBlock(HotelPromotion hotelPromotion) {
        String block1 = getRoomReserve().getBlock();
        String block2 = hotelPromotion.getRoomReserve().getBlock();
        if (block1.equals(block2)) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        return String.format("Booking code: %s\nCustomer name: %s\nPhone number: %s\nPromotion type: %cLength of stay: %d day(s)\nRoom reserve: %s\nDeposit: RM%.2f", bookingCode, customerName, phoneNo, promotionType, day, roomReserve, deposit);
    }
}