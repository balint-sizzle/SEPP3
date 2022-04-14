package main.command;

import main.controller.Context;
import main.model.*;

import java.util.ArrayList;
import java.util.List;

enum LogStatus{LIST_USER_EVENTS_SUCCESS, LIST_USER_EVENTS_NOT_LOGGED_IN}

public class ListEventsCommand implements ICommand{

    private boolean userEventsOnly;
    private boolean activeEventsOnly;
    private List<Event> eventListResult;
    LogStatus userLoggedIn;


    public ListEventsCommand(boolean userEventsOnly, //filter events depending on user; 
                                                            //provider: ones they created
                                                            //consumer: ones that match their preferences
                            boolean activeEventsOnly)
        {
            this.userEventsOnly = userEventsOnly;
            this.activeEventsOnly = activeEventsOnly;
            this.eventListResult = new ArrayList<>();
        }
    
    public void execute(Context context){
        List<Event> events = context.getEventState().getAllEvents();

        if (this.userEventsOnly){
            User user = context.getUserState().getCurrentUser();
            if (user != null){
                for (Event event : events){
                    if (user instanceof Consumer){
                        for (EventPerformance performance : event.getPerformances())
                            {
                                ConsumerPreferences preferences = user.getPreferences();
                                if (preferences.preferSocialDistancing == performance.hasSocialDistancing() &&
                                    preferences.preferAirFiltration == performance.hasAirFiltration() &&
                                    preferences.preferOutdoorsOnly == performance.isOutdoors() &&
                                    preferences.preferredMaxVenueSize <= performance.getVenueSize() &&
                                    preferences.preferredMaxCapacity <= performance.getCapacityLimit()){
                                    if (this.activeEventsOnly){
                                        if (event.getStatus() == EventStatus.ACTIVE) eventListResult.add(event);
                                    }
                                    else{
                                        eventListResult.add(event);
                                        }
                                    }
                            }
                    }
                    if (user instanceof EntertainmentProvider){
                        if (user.equals(event.getOrganiser())){
                            if (this.activeEventsOnly){
                                if (event.getStatus()==EventStatus.ACTIVE){
                                    eventListResult.add(event);
                                }
                            }
                            else{
                                eventListResult.add(event);
                            }

                        }
                    }
                }
            }
        }
        else{
            for (Event event : events){
                if (event.getStatus() == EventStatus.ACTIVE) eventListResult.add(event);
            }

        }
    }

    public List<Event> getResult() {
        return eventListResult;
    }
}
