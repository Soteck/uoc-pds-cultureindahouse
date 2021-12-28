package dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

@Data
@NoArgsConstructor
public class AddOrUpdateEventOrganizer {

    public String name;
    public String description;
    public int userId;


    public AddOrUpdateEventOrganizer(EventOrganizerVO vo, int userId) {
        this.name = vo.getName();
        this.description = vo.getDescription();
        this.userId = userId;
    }
}
