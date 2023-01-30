package pl.patrykpora.quiz;

import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.patrykpora.database.entities.PlayerEntity;
import pl.patrykpora.repository.PlayerRepository;

import java.util.List;

@Component
@Log
public class StartUp implements CommandLineRunner {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("startup action processing .... ");
        PlayerEntity playerEntity = new PlayerEntity("Patryk");
        log.info("created player : " + playerEntity);
        playerRepository.save(playerEntity);

        showPlayersLoadedFormDataBase();
    }

    private void showPlayersLoadedFormDataBase() {
        List<PlayerEntity> playersList = playerRepository.findAll();
        for (PlayerEntity player : playersList) {
            log.info("player from database: " + player);
        }
    }
}
