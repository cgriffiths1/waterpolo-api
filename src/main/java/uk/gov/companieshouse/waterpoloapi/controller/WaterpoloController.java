package uk.gov.companieshouse.waterpoloapi.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import uk.gov.companieshouse.waterpoloapi.model.PlayerModel;
import uk.gov.companieshouse.waterpoloapi.model.TeamModel;
import uk.gov.companieshouse.waterpoloapi.repository.TeamRepository;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/water-polo-api")
public class WaterpoloController {

    private TeamRepository repository;

    @Value("${resource.dir}")
    private String resourcedir;

    @Autowired
    public WaterpoloController(TeamRepository repository) {
        this.repository = repository;
    }

    private File getResourceAsFile(String path){
        String fullpath = resourcedir + "/" + path;
        return new File(fullpath);
    }

    @GetMapping("/teams")
    public List<TeamModel> getAllTeams(){
        List<TeamModel> teamList = repository.findAll();

        return teamList;
    }

    public List<TeamModel> getAllTeamsFromFile(){
        List<TeamModel> teamList = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        try{
            teamList = objectMapper.readValue(getResourceAsFile("readData.json"), new TypeReference<List<TeamModel>>() {
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
            playerList = objectMapper.readValue(getResourceAsFile("players.json"), new TypeReference<List<PlayerModel>>() {
            });

        }
        catch(IOException e){
            e.printStackTrace();
        }
        return playerList;
    }

    @PostMapping("/teams")
    public void sendTeams(@RequestBody TeamModel newTeam){
        repository.insert(newTeam);
    }

    @GetMapping("/teams/{name}")
    public TeamModel getTeam(@PathVariable String name){
        Optional<TeamModel> teamsList = repository.findById(name);

        return teamsList.orElse(null);
    }

    @PostMapping("/teams/delete")
    public void deleteTeam(@RequestBody TeamModel team){
        repository.delete(team);
    }

    @PostMapping("/teams/update")
    public void updateTeam(@RequestBody TeamModel team){
        repository.save(team);
    }
}
