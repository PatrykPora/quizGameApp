package pl.patrykpora.service;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.patrykpora.dto.QuestionsDto;
import pl.patrykpora.frontController.frontElements.GameOptions;

import java.util.Collections;
import java.util.List;

@Service
@Log
public class GameInProgress {
    private GameOptions gameOptions;
    private int currentQuestionIndex;
    private int points;

    private List<QuestionsDto.QuestionDto> questions;

    @Autowired
    private QuizDataService quizDataService;

    public void init(GameOptions gameOptions) {
        this.gameOptions = gameOptions;
        this.currentQuestionIndex = 0;
        this.points = 0;
        this.questions = quizDataService.getQuizQuestions(gameOptions);
    }

    public int getCurrentQuestionNumber() {
        return currentQuestionIndex + 1;
    }

    public int getTotalNumberOfQuestions() {
        return questions.size();
    }

    public String getInfoAboutHowManyQuestionsLeft() {
        return "Question" + getCurrentQuestionNumber() + "/" + getTotalNumberOfQuestions();
    }

    public String getCurrentQuestionText() {
        return questions.get(currentQuestionIndex).getQuestion();
    }

    public List<String> getAllPossibleAnswersForCurrentQuestions() {
        String correctAnswer = questions.get(currentQuestionIndex).getCorrect_answer();
        List<String> allAnswers = questions.get(currentQuestionIndex).getIncorrect_answers();
        allAnswers.add(correctAnswer);
        Collections.shuffle(allAnswers);
        return allAnswers;
    }

    public boolean checkPlayerAnswerAndUpdatePoints(String playerAnswer) {
        String correctAnswer = questions.get(currentQuestionIndex).getCorrect_answer();
        if (playerAnswer.equalsIgnoreCase(correctAnswer)) {
            points++;
            return true;
        }
        return false;
    }

    public int getCurrentScore(){
        return points;
    }

    public boolean goToNextQuestion(){
        currentQuestionIndex++;
        return currentQuestionIndex < questions.size();
    }

}
