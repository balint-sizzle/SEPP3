package main.state;
import main.model.User;
import java.util.HashMap;
import java.util.Map;

public class UserState implements IUserState{

    protected Map<String,User> users;
    private User currentUser;

    public UserState() {
        users = new HashMap<>();
        currentUser = null;
    }

    public UserState(IUserState other) {
        currentUser = other.getCurrentUser();
        users = new HashMap<>();
        users.putAll(other.getAllUsers());
    }

    public void addUser(User user) {
        users.put(user.getEmail(), user);
    }

    public Map<String,User> getAllUsers() {
        return users;
    }

    public void setCurrentUser(User user) {
        currentUser = user;
    }

    public User getCurrentUser() {
        return currentUser;
    }
=======
package main.state;

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
