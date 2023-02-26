package pl.patrykpora.frontController;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.patrykpora.frontController.frontElements.GameOptions;
import pl.patrykpora.frontController.frontElements.UserAnswer;
import pl.patrykpora.service.GameInProgress;
import pl.patrykpora.service.QuizDataService;

@Log
@Controller
@RequestMapping
public class FrontController {

    @Autowired
    private QuizDataService quizDataService;

    @Autowired
    private GameInProgress gameInProgress;

    @GetMapping("/")
    public String startWebsite(Model model){
        return "index";
    }

    @GetMapping("/select")
    public String select(Model model){
        model.addAttribute("gameOptions", new GameOptions());
        model.addAttribute("categories",quizDataService.getCategoriesForQuiz());
        return "select";
    }

    @PostMapping("/select")
    public String setGameOptions(Model model, @ModelAttribute GameOptions gameOptions){
        log.info("user choose game options: " + gameOptions);
        gameInProgress.init(gameOptions);
        return "redirect:game";
    }

    @GetMapping("/game")
    public String game(Model model){
        model.addAttribute("userAnswer", new UserAnswer());
        model.addAttribute("currentQuestionNumber", gameInProgress.getCurrentQuestionNumber());
        model.addAttribute("totalQuestionNumber", gameInProgress.getTotalNumberOfQuestions());
        model.addAttribute("currentQuestion", gameInProgress.getCurrentQuestionText());
        model.addAttribute("currentQuestionAnswers", gameInProgress.getAllPossibleAnswersForCurrentQuestions());
        return "game";
    }
}
