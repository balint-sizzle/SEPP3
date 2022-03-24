package src.main.state;
import src.main.model.User;
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
}
