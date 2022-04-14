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
        this.userResult = null;
    }

    @Override
    public void execute(Context context) {
        if (context.getUserState().getAllUsers().containsKey(this.email))
        {
            User user = context.getUserState().getAllUsers().get(this.email);
            if (user.checkPasswordMatch(this.password))
            {
                context.getUserState().setCurrentUser(user);
                this.userResult = user;
            }
        }
    }

    @Override
    public Object getResult() {
        return this.userResult;
    }

}