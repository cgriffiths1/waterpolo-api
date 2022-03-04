package uk.gov.companieshouse.waterpoloapi.controller;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uk.gov.companieshouse.waterpoloapi.model.PlayerModel;
import uk.gov.companieshouse.waterpoloapi.model.TeamModel;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(value = "/water-polo-api")
public class WaterpoloController {

    @GetMapping("/teams")
    public List<TeamModel> getAllTeams(){
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

    @PostMapping("/teams")
    public void sendTeams(){
        try{
            List<TeamModel> teamsList = Arrays.asList(
                    new TeamModel("teamName", "teamLocation", 0, 1, "teamCaptain",
                            null), new TeamModel("teamName", "teamLocation", 1, 0, "teamCaptain",
                            null)
            );

            ObjectMapper objectMapper = new ObjectMapper();
            ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());
            writer.writeValue(Paths.get("src/main/resources/writeData.json").toFile(), teamsList);

        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
