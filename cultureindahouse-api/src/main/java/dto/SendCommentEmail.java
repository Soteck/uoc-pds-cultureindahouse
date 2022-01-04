package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendCommentEmail {

    public int eventId;
    public String email;
    public String text;


    public SendCommentEmail(int eventId, String email, String text) {
        this.eventId = eventId;
        this.email = email;
        this.text = text;
    }
}
