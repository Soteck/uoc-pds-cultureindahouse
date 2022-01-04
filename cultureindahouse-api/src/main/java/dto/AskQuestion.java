package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AskQuestion {

    public int eventId;
    public String title;
    public String message;


    public AskQuestion(int eventId, String title, String message) {
        this.eventId = eventId;
        this.title = title;
        this.message = message;
    }
}
