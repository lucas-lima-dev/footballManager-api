package br.com.footballManager.api.teams.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrganizeTeams {
    public static Map<String, List<String>> organizarTimes(List<String> players) {
        Map<String, List<String>> teams = new HashMap<>();
        Map<String, Integer> usedSurnames = new HashMap<>();

        for (String player : players) {
            String[] arrayNomes = player.split(" ");

            if (arrayNomes.length != 2) {
                teams.putIfAbsent("OtherTeams", new ArrayList<>());
                teams.get("OtherTeams").add(player);
                continue;
            }

            String surnames = arrayNomes[1].toLowerCase();
            String surnameFirstLetter = surnames.substring(0, 1).toUpperCase();

            if (usedSurnames.containsKey(surnames)) {
                int index = usedSurnames.get(surnames) + 1;
                usedSurnames.put(surnames, index);
                surnameFirstLetter += index;
            } else {
                usedSurnames.put(surnames, 1);
            }

            teams.putIfAbsent(surnameFirstLetter, new ArrayList<>());
            teams.get(surnameFirstLetter).add(player);
        }

        return teams;
    }
}
