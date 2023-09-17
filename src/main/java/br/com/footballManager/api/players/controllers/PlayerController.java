package br.com.footballManager.api.players.controllers;

import br.com.footballManager.api.players.dto.PlayerDTO;
import br.com.footballManager.api.players.entities.PlayerEntity;
import br.com.footballManager.api.players.repositories.PlayerRepository;
import br.com.footballManager.api.players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jogador")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PlayerController {


    @Autowired
    private PlayerService playerService;

    @PostMapping
    public void createNewPlayer(@RequestBody PlayerDTO player ) {
        playerService.createNewPlayer(new PlayerEntity(player));
    }
}
