package pl.patrykpora.frontController;

import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log
@Controller
@RequestMapping
public class FrontController {

    @GetMapping("/")
    public String startWebsite(Model model){
        return "index";
    }

    @GetMapping("/select")
    public String select(Model model){
        model.addAttribute("gameOptions", new GameOptions());
        return "select";
    }

    @PostMapping("/select")
    public String setNumberOfQuestions(Model model, @ModelAttribute GameOptions gameOptions){
        log.info("user choose number of questions: " + gameOptions);
        return "index";
    }
}
