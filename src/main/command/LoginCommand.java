package main.command;
import main.controller.Context;
import main.model.User;


public class LoginCommand implements ICommand{
    enum LogStatus{
        USER_LOGIN_SUCCESS,
        USER_LOGIN_EMAIL_NOT_REGISTERED,
        USER_LOGIN_WRONG_PASSWORD
    }
    private final String email;
    private final String password;
    private User userResult;

    public LoginCommand(String login_email, String login_password){
        this.email = login_email;
        this.password = login_password;
    }

    public void execute(Context context) {
        if (context.getUserState().getAllUsers().containsKey(email)) {
            User user = context.getUserState().getAllUsers().get(email);
            if (user.checkPasswordMatch(password)) {
                context.getUserState().setCurrentUser(user);
                userResult = user;
            }
        }
    }

    public User getResult() {
        return userResult;
    }

}