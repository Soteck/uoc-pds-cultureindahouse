package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendRatingUser {

    public int eventId;
    public int userId;
    public int rating;
}
