package src.main.model;

public class ConsumerPreferences extends Object{
    public boolean preferSocialDistancing;
    public boolean preferAirFiltration;
    public boolean preferOutdoorsOnly;
    public int preferredMaxCapacity;
    public int preferredMaxVenueSize;

    ConsumerPreferences(boolean preferSocialDistancing,
                        boolean preferAirFiltration,
                        boolean preferOutdoorsOnly,
                        int preferredMaxCapacity,
                        int preferredMaxVenueSize){
        this.preferSocialDistancing = false;
        this.preferAirFiltration = false;
        this.preferOutdoorsOnly = false;
        this.preferredMaxCapacity = Integer.MAX_VALUE;
        this.preferredMaxVenueSize = Integer.MAX_VALUE;
    }

}
