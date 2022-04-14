package main.command;
import main.controller.Context;
import main.model.Consumer;


public class RegisterConsumerCommand implements ICommand {
    private final String name;
    private final String email;
    private final String phoneNumber;
    private final String password;
    private final String paymentAccountEmail;
    private Consumer newConsumerResult;

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

        boolean isValid = noneNull && isUnique;

        if (!isValid) {
            newConsumerResult = null;
            throw new RuntimeException("Null value or not unique.");
        }
        else {
            newConsumerResult = new Consumer(name, email, phoneNumber, password, paymentAccountEmail);
        }
    }

    public Consumer getResult() {
        return newConsumerResult;
    }
}
