package pl.patrykpora.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.patrykpora.database.entities.PlayerEntity;
import pl.patrykpora.frontController.frontElements.DifficultLevel;
import pl.patrykpora.frontController.frontElements.GameOptions;
import pl.patrykpora.repository.PlayerRepository;
import pl.patrykpora.service.QuizDataService;

import java.util.List;

@Component
@Log
public class StartUp implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private QuizDataService quizDataService;

    @Override
    public void run(String... args) throws Exception {
        log.info("startup action processing .... ");
        PlayerEntity playerEntity = new PlayerEntity("Patryk");
        log.info("created player : " + playerEntity);
        playerRepository.save(playerEntity);
        PlayerEntity playerEntityTwo = new PlayerEntity("Anna");
        log.info("created player : " + playerEntity);
        playerRepository.save(playerEntityTwo);
        showPlayersLoadedFormDataBase();
        quizDataService.getCategoriesForQuiz();

        GameOptions startOptions = new GameOptions();
        startOptions.setCategoryId(20);
        startOptions.setDifficultLevel(DifficultLevel.easy);
        startOptions.setNumberOfQuestions(10);
        quizDataService.getQuizQuestions(startOptions);
    }

    private void showPlayersLoadedFormDataBase() {
        List<PlayerEntity> playersList = playerRepository.findAll();
        for (PlayerEntity player : playersList) {
            log.info("player from database: " + player);
        }
    }
}
