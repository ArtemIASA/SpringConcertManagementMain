package entities;

public class Visitor {
    private String name;
    private String phoneNumber;




    private static void validatePhoneNumber(String phoneNumber){
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        if (!phoneNumber.matches(regex))
            throw new IllegalArgumentException("Number must match pattern: ddd-ddd-dddd: " + phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber){
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}