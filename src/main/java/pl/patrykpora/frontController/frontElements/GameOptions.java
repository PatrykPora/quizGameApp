package pl.patrykpora.frontController.frontElements;


import lombok.Data;

@Data
public class GameOptions {
    private int numberOfQuestions = 1;
    private DifficultLevel difficultLevel;
    private int categoryId;
}
