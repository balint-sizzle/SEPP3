package main.model;

import java.util.List;

public class Consumer extends User {
    private String name;
    private final String email;
    private String phoneNumber;
    private final String password;
    private final String paymentAccountEmail;
    private List<Booking> bookingList;
    private ConsumerPreferences preferences;

    public Consumer(String name, String email, String phoneNumber, String password, String paymentAccountEmail) {
        super(email, password, paymentAccountEmail);
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.paymentAccountEmail = paymentAccountEmail;
    }

    public void addBooking(Booking booking) {
        bookingList.add(booking);
    }

    public String getName() {
        return name;
    }

    public ConsumerPreferences getPreferences() {
        return preferences;
    }

    public void setPreferences(ConsumerPreferences preferences) {
        this.preferences = preferences;
    }

    public List<Booking> getBookings() {
        return bookingList;
    }

    public void notify(String message) {
        System.out.println(message);
    }

    public void setName(String newName) {
        name = newName;
    }

    public void setPhoneNumber(String newPhoneNumber) {
        phoneNumber = newPhoneNumber;
    }

    @Override
    public String toString() {
        return email;
    }
}
