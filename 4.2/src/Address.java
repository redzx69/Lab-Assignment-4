public class Address {
    private String streetName;
    private String district;
    private String state;

    public Address(String streetName, String district, String state) {
        this.streetName = streetName;
        this.district = district;
        this.state = state;
    }

    public void setAddress(String streetName, String district, String state) {
        this.streetName = streetName;
        this.district = district;
        this.state = state;
    }

    public String getStreetName() {
        return streetName;
    }

    public String getDistrict() {
        return district;
    }

    public String getState() {
        return state;
    }

    @Override
    public String toString() {
        return "Street Name: " + streetName + "\n" +
                "District: " + district + "\n" +
                "State: " + state + "\n";
    }
}