package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EventUser {

    public int userId;

    public int eventId;

    public EventUser(int userId, int eventId) {
        this.userId = userId;
        this.eventId = eventId;
    }
}
