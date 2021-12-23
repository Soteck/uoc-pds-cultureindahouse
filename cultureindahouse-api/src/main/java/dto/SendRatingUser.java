package dto;

import lombok.Data;

@Data
public class SendRatingUser {

    public int eventId;
    public int userId;
    public int rating;
}
