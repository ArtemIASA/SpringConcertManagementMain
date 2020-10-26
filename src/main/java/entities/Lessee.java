package entities;

import com.fasterxml.jackson.annotation.JsonTypeInfo;

import java.util.UUID;

@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="lessee")
public class Lessee {
    private UUID id;
    private String name;
    private String phoneNumber;
    private String email;

    public Lessee() {
        this.id = UUID.randomUUID();
    }

    public Lessee(String name, String phoneNumber, String email) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    private static void validatePhoneNumber(String phoneNumber) {
        String regex = "\\d{3}-\\d{3}-\\d{4}";
        if (!phoneNumber.matches(regex))
            throw new IllegalArgumentException("Number must match pattern: ddd-ddd-dddd: " + phoneNumber);
    }

    public void setPhoneNumber(String phoneNumber) {
        validatePhoneNumber(phoneNumber);
        this.phoneNumber = phoneNumber;
    }

    private static void validateEmail(String email) {
        String regex = "\\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}\\b";
        if (!email.matches(regex))
            throw new IllegalArgumentException("Email must match pattern: " +
                    "[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]: " + email);
    }

    public void setEmail(String email) {
        validateEmail(email);
        this.email = email;
    }
}
