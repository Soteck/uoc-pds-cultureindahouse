package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendCommentUser {

    public int eventId;
    public int userId;
    public String text;

    public SendCommentUser(int eventId, int userId, String text) {
        this.eventId = eventId;
        this.userId = userId;
        this.text = text;
    }
}
