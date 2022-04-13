package main.command;

import main.controller.Context;
import main.model.Event;
import main.model.User;
import main.model.Consumer;
import main.model.EventStatus;
import main.model.ConsumerPreferences;
import main.model.EntertainmentProvider;

public enum LogStatus{LIST_USER_EVENTS_SUCCESS, LIST_USER_EVENTS_NOT_LOGGED_IN}

public class ListEventsCommand {
    boolean userEventsOnly;
    boolean activeEventsOnly;
    LogStatus userLoggedIn;


    public ListEventsCommand(boolean userEventsOnly, //filter events depending on user; 
                                                            //provider: ones they created
                                                            //consumer: ones that match their preferences
                            boolean activeEventsOnly)
                                    {
                                        this.userEventsOnly = userEventsOnly;
                                        this.activeEventsOnly = activeEventsOnly;
                                        this.matches = new List();
                                    }
    
    public void execute(Context context){
        List<Event> events = context.getEventState().getAllEvents();
        

        if (this.userEventsOnly){
            User user = context.getUserState();
            if (user){
                for (Event event : events){
                    if (user instanceof Consumer){
                        for (EventPerformance performance : event.getPerformances())
                            {
                                ConsumerPreferences preferences = user.getPreferences();
                                if (preferences.preferSocialDistancing == performance.hasSocialDistancing() &&
                                    preferences.preferAirFiltration == performance.hasAirFiltration() &&
                                    preferences.preferOutdoorsOnly == performance.isOutdoors() &&
                                    preferences.preferredMaxVenueSize <= performance.getMaxVenueSize() &&
                                    preferences.preferredMaxCapacity <= performance.getMaxCapacity()){
                                    if (this.activeEventsOnly){
                                        if (event.getStatus() == EventStatus.ACTIVE) this.matches.add(event);
                                    }
                                    else{
                                        this.matches.add(event);
                                        }
                                    }
                            }
                    }
                    if (user instanceof EntertainmentProvider){
                        if (user.equals(event.getOrganiser())){
                            if (this.activeEventsOnly){
                                if (event.getStatus()==EventStatus.ACTIVE){
                                    this.matches.add(event);
                                }
                            }
                            else{
                                this.matches.add(event);
                            }

                        }
                    }
                }
            }
        }
        else{
            for (Event event : events){
                if (event.getStatus == EventStatus.ACTIVE) this.matches.add(event);
            }

        }
    }

    public List<Event> getResult(){
        return this.matches;
    }
}
