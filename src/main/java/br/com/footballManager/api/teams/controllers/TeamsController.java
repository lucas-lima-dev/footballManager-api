package br.com.footballManager.api.teams.controllers;

import br.com.footballManager.api.teams.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping
@CrossOrigin(origins = {"https://football-manager-front.vercel.app/"})
public class TeamsController {

    @Autowired
    private TeamsService teamsService;

    @GetMapping("/times")
    public Map<String, List<String>> getAllTeams() {
        return teamsService.getAllTeams();
    }
}
