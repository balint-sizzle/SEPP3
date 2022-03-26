package src.main.state;

import java.util.HashMap;
import java.util.Map;

import main.model.User;

public class UserState extends Object implements IUserState{

    User currentUser;
    HashMap<String,User> allUsers;

    public UserState(){
        this.currentUser = null;
        this.allUsers = new HashMap<String,User>();
        // TODO add preregistered gov rep accounts to users list
    }

    public UserState(IUserState other){
        // TODO duplicate other IUserState
    }

    @Override
    public void addUser(User user) {
        this.allUsers.put(user.getEmail(), user);
    }

    @Override
    public Map<String, User> getAllUsers() {
        return this.allUsers;
    }

    @Override
    public User getCurrentUser() {
        return this.currentUser;
    }

    @Override
    public void setCurrentUser(User user) {
        this.currentUser = user;
        
    }
    
}
