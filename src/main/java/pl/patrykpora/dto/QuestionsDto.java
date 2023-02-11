package pl.patrykpora.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
public class QuestionsDto {

    private int response_code;
    private List<QuestionDto> results;

    @NoArgsConstructor
    @Getter
    @ToString
    public static class QuestionDto{
        private String category;
        private String type;
        private String difficulty;
        private String question;
        private String correct_answer;
        private List<String> incorrect_answers;

    }

}
