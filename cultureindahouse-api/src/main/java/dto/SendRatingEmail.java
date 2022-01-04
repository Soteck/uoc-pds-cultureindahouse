package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendRatingEmail {

    public int eventId;
    public String email;
    public int rating;

    public SendRatingEmail(int eventId, String email, int rating) {
        this.eventId = eventId;
        this.email = email;
        this.rating = rating;
    }
}
