package dto;

import lombok.Data;

@Data
public class SendCommentUser {

    public int eventId;
    public int userId;
    public String text;
}
