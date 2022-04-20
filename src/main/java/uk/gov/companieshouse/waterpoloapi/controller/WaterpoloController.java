package uk.gov.companieshouse.waterpoloapi.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.*;
import uk.gov.companieshouse.waterpoloapi.model.PlayerModel;
import uk.gov.companieshouse.waterpoloapi.model.TeamModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/water-polo-api")
public class WaterpoloController {

    @GetMapping("/teams")
    public List<TeamModel> getAllTeams(){
        List<TeamModel> teamList = getAllTeamsFromFile();

        return teamList;
    }

    public List<TeamModel> getAllTeamsFromFile(){
        List<TeamModel> teamList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            teamList = objectMapper.readValue(new File("src/main/resources/readData.json"), new TypeReference<List<TeamModel>>() {
            });

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return teamList;
    }

    @GetMapping("/allPlayers")
    public List<PlayerModel> getAllPlayersFromFile(){
        List<PlayerModel> playerList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            playerList = objectMapper.readValue(new File("src/main/resources/players.json"), new TypeReference<List<PlayerModel>>() {
            });

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return playerList;
    }

    @PostMapping("/teams")
    public void sendTeams(@RequestBody TeamModel newTeam){
        List<TeamModel> teamsListNew = getAllTeamsFromFile();
        try{
            teamsListNew.add(newTeam);
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/readData.json").toFile(), teamsListNew);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @GetMapping("/teams/{name}")
    public TeamModel getTeam(@PathVariable String name){
        List<TeamModel> teamsList = getAllTeamsFromFile();

        for (int i = 0; i < teamsList.size(); i++) {
            if (teamsList.get(i).getTeamName().equals(name)){
                return teamsList.get(i);
            }
        }
        return null;
    }

    @PostMapping("/teams/delete")
    public void deleteTeam(@RequestBody TeamModel team){
        List<TeamModel> teamsList = getAllTeamsFromFile();
        try {
            for (int i = 0; i < teamsList.size(); i++) {
                if (teamsList.get(i).getTeamName().equals(team.getTeamName())) {
                    teamsList.remove(teamsList.get(i));
                }
            }

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/readData.json").toFile(), teamsList);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    @PostMapping("/teams/update")
    public void updateTeam(@RequestBody TeamModel team){
        List<TeamModel> teamsList = getAllTeamsFromFile();
        try {
            for (int i = 0; i < teamsList.size(); i++) {
                if (teamsList.get(i).getTeamName().equals(team.getTeamName())) {
                    TeamModel teamModel = teamsList.get(i);
                    teamModel.setTeamName("Updated Team");
                }
            }

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/readData.json").toFile(), teamsList);
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
