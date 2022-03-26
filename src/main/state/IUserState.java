package src.main.state;

import java.util.Map;
import main.model.User;

public interface IUserState {
    
    public void addUser(User user);
    public Map<String, User> getAllUsers();
    public User getCurrentUser();
    public void setCurrentUser(User user);
}
