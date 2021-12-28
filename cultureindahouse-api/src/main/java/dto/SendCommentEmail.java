package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SendCommentEmail {

    public int eventId;
    public String email;
    public String text;
}
