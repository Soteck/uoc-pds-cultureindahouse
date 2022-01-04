package dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AnswerQuestion {

    public int questionId;
    public String message;

    public AnswerQuestion(int questionId, String message) {

        this.questionId = questionId;
        this.message = message;
    }
}
