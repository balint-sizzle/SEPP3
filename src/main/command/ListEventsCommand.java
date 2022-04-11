package main.command;

import main.controller.Context;
import main.model.Event;
import main.model.User;
import main.model.Consumer;
import main.model.ConsumerPreferences;
import main.model.EntertainmentProvider;

public enum LogStatus{LIST_USER_EVENTS_SUCCESS, LIST_USER_EVENTS_NOT_LOGGED_IN}

public class ListEventsCommand {
        boolean userEventsOnly;
    boolean activeEventsOnly;
    LogStatus userLoggedIn;

    public ListEventBookingsCommand(boolean userEventsOnly, //filter events depending on user; 
                                                            //provider: ones they created
                                                            //consumer: ones that match their preferences
                                    boolean activeEventsOnly)
                                    {
                                        this.userEventsOnly = userEventsOnly;
                                        this.activeEventsOnly = activeEventsOnly;
                                        
                                    }
    
    public void execute(Context context){
        List<Event> events = context.getEventState().getAllEvents();
        if (this.userEventsOnly){
            User user = context.getUserState();
            if (user){
                if (user instanceof Consumer){
                    ConsumerPreferences preferences = user.getPreferences();
                    for (Event event : events){
                        for (EventPerformance performance : event.getPerformances())
                        {
                            if (preferences.preferSocialDistancing == performance.hasSocialDistancing() &&
                                preferences.preferAirFiltration == performance.hasAirFiltration() &&
                                preferences.preferOutdoorsOnly == performance.isOutdoors() &&
                                preferences.preferredMaxVenueSize <= performance.getMaxVenueSize() &&
                                preferences.preferredMaxCapacity <= performance.getMaxCapacity())
                        }


                    }
                }
                this.userLoggedIn = LIST_USER_EVENTS_SUCCESS;
            }
            else{
                this.userLoggedIn = LIST_USER_EVENTS_NOT_LOGGED_IN;
            }
        }
    }

    public List<Event> getResult(){
        if (this.)
    }
}
