package dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventVO;

@Data
@NoArgsConstructor
public class AddOrUpdateEvent {

    public String name;
    public String description;
    public String location;
    public String image;
    public String initDate;
    public String endDate;
    public int eventOrganizerId;



    public AddOrUpdateEvent(EventVO event, int eventOrganizerId) {

        this.name = event.getName();
        this.description = event.getDescription();
        this.location = event.getLocation();
        this.image = event.getImage();
        this.initDate = event.getInitDate();
        this.endDate = event.getEndDate();
        this.eventOrganizerId = eventOrganizerId;
    }
}
