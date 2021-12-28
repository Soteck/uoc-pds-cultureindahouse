package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventEmail {

    public String email;

    public int eventId;


    public EventEmail(String email, int eventId) {
        this.email = email;
        this.eventId = eventId;
    }
}
