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
