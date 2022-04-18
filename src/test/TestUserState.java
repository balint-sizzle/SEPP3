import main.command.*;
import main.controller.Controller;
import main.logging.Logger;
import main.model.*;
import main.state.UserState;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestUserState {
    UserState uState;

    public TestUserState(){
        this.uState = new UserState();
    }

    @Test
    void add3Users(){
        User u1 = new User("User 1", "pwd1", "emal1");
        User u2 = new User("User 1", "pwd1", "emal1");
        User u3 = new User("User 1", "pwd1", "emal1");

        this.uState.addUser();
    }
}
