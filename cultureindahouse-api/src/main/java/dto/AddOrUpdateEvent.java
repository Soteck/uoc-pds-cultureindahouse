package dto;

import java.util.Date;

import lombok.Data;

@Data
public class AddOrUpdateEvent {

    public String name;
    public String description;
    public String location;
    public String image;
    public Date initDate;
    public Date endDate;
    public int eventOrganizerId;
}
