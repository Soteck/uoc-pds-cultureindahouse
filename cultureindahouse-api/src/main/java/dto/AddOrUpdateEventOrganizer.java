package dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.uoc.pds.alpha.cultureindahouse.ejb.pojo.EventOrganizerVO;

@Data
@NoArgsConstructor
public class AddOrUpdateEventOrganizer {

    public String name;
    public String description;
    public String email;


    public AddOrUpdateEventOrganizer(EventOrganizerVO vo) {
        this.name = vo.getName();
        this.description = vo.getDescription();
    }

    public AddOrUpdateEventOrganizer(EventOrganizerVO vo, String email) {
        this.name = vo.getName();
        this.description = vo.getDescription();
        this.email = email;

    }
}
