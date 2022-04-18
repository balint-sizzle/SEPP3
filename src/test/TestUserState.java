import main.model.Consumer;
import main.model.User;
import main.state.UserState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserState {
    UserState uState;

    public TestUserState(){
        this.uState = new UserState();
    }

    @Test
    void add3Users(){
        User u1 = new Consumer("User 1", "email1", "1234", "pwd", "paymail1");
        User u2 = new Consumer("User 2", "email2", "12345", "pwd2", "paymail2");
        User u3 = new Consumer("User 3", "email3", "12346", "pwd3", "paymail3");

        this.uState.addUser(u1);
        this.uState.addUser(u2);
        this.uState.addUser(u3);

        assertEquals(null, this.uState.getCurrentUser());
        assertEquals(3, this.uState.getAllUsers().size());
    }
}
