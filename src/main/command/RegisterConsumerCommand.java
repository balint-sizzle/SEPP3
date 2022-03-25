package src.main.command;

import com.ibm.java.diagnostics.utils.commands.ICommand;

public class RegisterConsumerCommand extends Object implements ICommand {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String paymentAccountEmail;

    public void execute(Context context) {
        boolean valid = !(this.name == null || 
                          this.email == null || 
                          this.phoneNumber == null || 
                          this.password == null || 
                          this.paymentAccountEmail == null);
    }

    public Consumer getResult() {
        return Consumer(this.name, this.email, this.phoneNumber, this.password, this.paymentAccountEmail);
    }

}
