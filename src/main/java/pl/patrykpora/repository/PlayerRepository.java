package pl.patrykpora.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.patrykpora.database.entities.PlayerEntity;

public interface PlayerRepository extends JpaRepository<PlayerEntity, Long> {
}
