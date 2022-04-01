package src.main.model;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class User {
    String email;
    String passwordHash;
    String paymentAccountEmail;

    protected User(String email, String password, String paymentAccountEmail) {
        this.email = email;
        passwordHash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        this.paymentAccountEmail = paymentAccountEmail;
    }

    public boolean checkPasswordMatch(String password) {
        return BCrypt.verifyer().verify(password.toCharArray(), passwordHash).verified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String newEmail) {
        email = newEmail;
    }

    public void updatePassword(String newPassword) {
        passwordHash = BCrypt.withDefaults().hashToString(12, newPassword.toCharArray());
    }

    public String getPaymentAccountEmail() {
        return paymentAccountEmail;
    }

    public void setPaymentAccountEmail(String newPaymentAccountEmail) {
        paymentAccountEmail = newPaymentAccountEmail;
    }

    @Override
    public String toString() {
        return "User{" +
                "email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", paymentAccountEmail='" + paymentAccountEmail + '\'' +
                '}';
    }
}
=======
package main.model;

// TODO:
// password needs hashed by bycrypt
// toString needs to be made meaningful

public abstract class User extends Object{
    String email;
    String password;
    String paymentAccountEmail;
    
    protected User(String input_email, String input_password, String input_paymentAcountEmail) {
        this.email = input_email;
        this.password = input_password; 
        this.paymentAccountEmail = input_paymentAcountEmail;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String newEmail){
        this.email = newEmail;
    }

    public boolean checkPasswordMatch(String password){
        return this.password == password;
    }

    public void updatePassword(String newPassword){
        this.password = newPassword;
    }

    public String getPaymentACcountEmail(){
        return this.paymentAccountEmail;
    }

    public void setPaymentAccountEmail(String newPaymentAccountEmail){
        this.paymentAccountEmail = newPaymentAccountEmail;
    }

    @Override
    public String toString(){
        return this.email;
    }
}
