import main.state.BookingState;
import main.model.Consumer;
import main.model.User;
import main.state.UserState;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestBookingState {
    BookingState bookingState;

    public TestBookingState(){
        this.bookingState = new BookingState();
    }


}
