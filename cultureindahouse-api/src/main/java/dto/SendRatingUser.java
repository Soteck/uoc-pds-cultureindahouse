package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendRatingUser {

    public int eventId;
    public int userId;
    public int rating;

    public SendRatingUser(int eventId, int userId, int rating) {
        this.eventId = eventId;
        this.userId = userId;
        this.rating = rating;
    }
}
