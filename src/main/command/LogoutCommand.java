package main.command;

import main.controller.Context;

public class LogoutCommand implements ICommand {
    public LogoutCommand() {}

    public void execute(Context context) {
        if (context.getUserState().getCurrentUser() != null) {
            context.getUserState().setCurrentUser(null);
        }
    }

    public Void getResult() {
        return null;
    }

}
