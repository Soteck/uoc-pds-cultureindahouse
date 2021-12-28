package dto;

import lombok.Data;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

@Data
public class AddOrUpdateEventOrganizer {

    public String name;
    public String description;
    public int userId;

    public AddOrUpdateEventOrganizer() {
    }

    public AddOrUpdateEventOrganizer(String name, String description, int userId) {
        this.name = name;
        this.description = description;
        this.userId = userId;
    }


    public AddOrUpdateEventOrganizer(EventOrganizerVO vo, int userId) {
        this.name = vo.getName();
        this.description = vo.getDescription();
        this.userId = userId;
    }
}
