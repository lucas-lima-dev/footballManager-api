package br.com.footballManager.api.players.controllers;

import br.com.footballManager.api.players.dto.PlayerDTO;
import br.com.footballManager.api.players.entities.PlayerEntity;
import br.com.footballManager.api.players.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@CrossOrigin(origins = {"https://football-manager-front.vercel.app/"})
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @PostMapping("/jogador")
    public void createNewPlayer(@RequestBody PlayerDTO player ) {
        System.out.println(player);
        playerService.createNewPlayer(new PlayerEntity(player));
    }

    @DeleteMapping("/jogador/all")
    public void deleteAllPlayers() {
        playerService.deleteAllPlayers();
    }
}
