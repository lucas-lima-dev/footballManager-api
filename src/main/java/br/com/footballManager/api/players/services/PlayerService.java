package br.com.footballManager.api.players.services;

import br.com.footballManager.api.players.entities.PlayerEntity;
import br.com.footballManager.api.players.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {

    @Autowired
    PlayerRepository playerRepository;

    public void createNewPlayer(PlayerEntity player) { playerRepository.save(player); }
}
