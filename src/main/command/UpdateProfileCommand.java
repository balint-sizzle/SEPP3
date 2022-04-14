
package main.command;

import main.controller.Context;
import main.model.User;

import java.util.Collection;

public abstract class UpdateProfileCommand implements ICommand {

    protected boolean successResult;

    protected boolean isProfileUpdateInvalid(Context context,
                                             String oldPassword,
                                             String newEmail) {
        // check if passwords match
        User currentUser = context.getUserState().getCurrentUser();

        // check if anyone else is registered with the new email already
        boolean emailNotRegistered = true;
        Collection<User> users = context.getUserState().getAllUsers().values();

        for (User user : users) {
            if (user.getEmail().equals(newEmail)) {
                emailNotRegistered = false;
                break;
            }
        }

        return (currentUser.checkPasswordMatch(oldPassword) && emailNotRegistered);
    }

    public Boolean getResult() {
        return successResult;
    }
    
}
