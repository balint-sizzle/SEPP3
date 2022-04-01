package main.state;
import main.model.User;
import java.util.Map;

public interface IUserState {

    void addUser(User user);
    Map<String,User> getAllUsers();
    User getCurrentUser();
    void setCurrentUser(User user);
}
