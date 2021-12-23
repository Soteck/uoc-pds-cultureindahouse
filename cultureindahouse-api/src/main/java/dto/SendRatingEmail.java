package dto;

import lombok.Data;

@Data
public class SendRatingEmail {

    public int eventId;
    public String email;
    public int rating;
}
