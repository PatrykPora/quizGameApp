package pl.patrykpora.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@NoArgsConstructor
@Getter
public class QuestionsDto {

    @JsonProperty("response_code")
    private int responseCode;
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
