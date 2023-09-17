package br.com.footballManager.api.players.repositories;

import br.com.footballManager.api.players.entities.PlayerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository <PlayerEntity, Integer>{

}
