package uk.gov.companieshouse.waterpoloapi.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Document(collection = "teams")
public class TeamModel {
    @Id
    private String teamName;
    @Field
    private String teamLocation;
    @Field
    private int teamRank;
    @Field
    private int teamPoints;
    @Field
    private String teamCaptain;
    @Field
    private List<PlayerModel> teamSquad;

    public TeamModel(String teamName, String teamLocation, int teamRank, int teamPoints, String teamCaptain, List<PlayerModel> teamSquad) {
        this.teamName = teamName;
        this.teamLocation = teamLocation;
        this.teamRank = teamRank;
        this.teamPoints = teamPoints;
        this.teamCaptain = teamCaptain;
        this.teamSquad = teamSquad;
    }

    public TeamModel() {
    }

    public String getTeamName(){return teamName;}

    public void setTeamName(String teamName){this.teamName = teamName;}

    public String getTeamLocation(){return teamLocation;}

    public void setTeamLocation(String teamLocation){this.teamLocation = teamLocation;}

    public int getTeamRank(){return teamRank;}

    public void setTeamRank(int teamRank){this.teamRank = teamRank;}

    public int getTeamPoints(){return teamPoints;}

    public void setTeamPoints(int teamPoints){this.teamPoints = teamPoints;}

    public String getTeamCaptain(){return teamCaptain;}

    public void setTeamCaptain(String teamCaptain){this.teamCaptain = teamCaptain;}

    public List<PlayerModel> getTeamSquad(){return teamSquad;}

    public void setTeamSquad(List<PlayerModel> teamSquad){this.teamSquad = teamSquad;}
}
