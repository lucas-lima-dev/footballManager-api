package br.com.footballManager.api.teams.service;

import br.com.footballManager.api.players.entities.PlayerEntity;
import br.com.footballManager.api.players.repositories.PlayerRepository;
import br.com.footballManager.api.teams.utils.OrganizeTeams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class TeamsService {

    @Autowired
    PlayerRepository playerRepository;

    public Map<String, List<String>> getAllTeams() {
        var result = new OrganizeTeams();
        List<String> tratedPlayers = new ArrayList<>();

        List<PlayerEntity> registeredPlayers = playerRepository.findAll();

       for(PlayerEntity player : registeredPlayers) {
           tratedPlayers.add(player.getName());
       }

        Map<String, List<String>> teams = result.organizarTimes(tratedPlayers);
        Map<String, List<String>> novoMapa = new LinkedHashMap<>();

        int i = 1;
        for (Map.Entry<String, List<String>> entry : teams.entrySet()) {
            String newKey = "time" + i;
            novoMapa.put(newKey, entry.getValue());
            i++;
        }

        return novoMapa;
    }
}
