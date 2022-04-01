package main.command;
import main.controller.Context;
import main.model.Consumer;
import src.main.command.ICommand;


public class RegisterConsumerCommand extends Object implements ICommand {
    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String paymentAccountEmail;
    private boolean isValid;

    public RegisterConsumerCommand(String name,
                                   String email,
                                   String phoneNumber,
                                   String password,
                                   String paymentAccountEmail) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.paymentAccountEmail = paymentAccountEmail;
     }

    public void execute(Context context) {
        boolean noneNull = !(name == null ||
                             email == null ||
                             phoneNumber == null ||
                             password == null ||
                             paymentAccountEmail == null);
        
        boolean isUnique = !context.getUserState().getAllUsers().containsKey(email);

        isValid = noneNull && isUnique;
    }

    public Consumer getResult() {
        if (isValid) {
            return new Consumer(name, email, phoneNumber, password, paymentAccountEmail);
        }
        else {
            return null;
        }
    }
}
