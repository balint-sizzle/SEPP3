package src.main.model;

// TODO:
// password needs hashed by bycrypt
// toString needs to be made meaningful

public abstract class User extends Object{
    String email;
    String password;
    String paymentAccountEmail;
    
    protected User(String input_email,
                   String input_password,
                   String input_paymentAcountEmail)
                {
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