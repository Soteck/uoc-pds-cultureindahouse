package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendCommentUser {

    public int eventId;
    public int userId;
    public String text;
}
