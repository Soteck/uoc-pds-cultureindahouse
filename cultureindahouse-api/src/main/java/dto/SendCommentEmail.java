package dto;

import lombok.Data;

@Data
public class SendCommentEmail {

    public int eventId;
    public String email;
    public String text;
}
