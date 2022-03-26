package src.main.model;

public class Consumer extends User {
     String email;
     String password;
     String paymentAccountEmail;
     String name;
     Long phoneNumber;

    protected Consumer(String input_email, String input_password,
                       String input_paymentAcountEmail,Long input_phoneNumber,
                       String input_name) {
        super(input_email, input_password, input_paymentAcountEmail);
        this.email = input_email;
        this.password = input_password;
        this.paymentAccountEmail = input_paymentAcountEmail;
        this.phoneNumber = input_phoneNumber;
        this.name = input_name;
    }
    public void addBooking(Booking booking){

    }
    public String getName(){
        return null;
    }
    public ConsumerPreferences getPreferences(){
        return null;
    }
    public void setPreferences(ConsumerPreferences preferences){

    }
    public list<Booking> getBookings(){
        return null;
    }
    public void notify(String message){

    }
    public void setName(String newName){

    }
    public void setPhoneNumber(String newPhoneNumber){

    }
    public String toString(){
        return null;
    }

    @Override
    public boolean checkPasswordMatch(String password) {
        return super.checkPasswordMatch(password);
    }

    @Override
    public String getPaymentACcountEmail() {
        return super.getPaymentACcountEmail();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void setPaymentAccountEmail(String paymentAccountEmail) {
        this.paymentAccountEmail = paymentAccountEmail;
    }

    @Override
    public void updatePassword(String newPassword) {
        super.updatePassword(newPassword);
    }
}
