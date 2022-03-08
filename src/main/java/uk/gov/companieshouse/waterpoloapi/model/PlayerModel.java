package uk.gov.companieshouse.waterpoloapi.model;

public class PlayerModel {
    private String playerName;
    private int playerAge;
    private String playerPosition;

    public PlayerModel(String name, int age, String position) {
        this.playerName = name;
        this.playerAge = age;
        this.playerPosition = position;
    }

    public PlayerModel() {
    }

    public String getPlayerName(){return playerName;}

    public void setPlayerName(String playerName){this.playerName = playerName;}

    public int getPlayerAge(){return playerAge;}

    public void setPlayerAge(int playerAge){this.playerAge = playerAge;}

    public String getPlayerPosition(){return playerPosition;}

    public void setPlayerPosition(String playerPosition){this.playerPosition = playerPosition;}
}
