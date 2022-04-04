package main.command;
import main.controller.Context;
import main.model.User;


public class LoginCommand extends Object implements ICommand{
    enum LogStatus{
        USER_LOGIN_SUCCESS,
        USER_LOGIN_EMAIL_NOT_REGISTERED,
        USER_LOGIN_WRONG_PASSWORD
    }
    private String email;
    private String password;
    private User userResult;

    public LoginCommand(String login_email, String login_password){
        this.email = login_email;
        this.password = login_password;
        this.userResult = null;
    }

    @Override
    public boolean execute(Context context) {
        if (context.getUserState().getAllUsers().containsKey(this.email))
        {
            User user = context.getUserState().getAllUsers().get(this.email);
            if (user.checkPasswordMatch(this.password))
            {
                context.getUserState().setCurrentUser(user);
                this.userResult = user;
            }
        }

        return false;
    }

    @Override
    public Object getResult() {
        return this.userResult;
    }

}