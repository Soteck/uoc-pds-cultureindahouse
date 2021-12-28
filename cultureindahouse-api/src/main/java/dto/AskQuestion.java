package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AskQuestion {

    public int eventId;
    public String title;
    public String message;
}
