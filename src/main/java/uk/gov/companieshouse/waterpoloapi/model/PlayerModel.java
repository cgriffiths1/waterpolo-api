package uk.gov.companieshouse.waterpoloapi.model;

import org.springframework.data.mongodb.core.mapping.Field;

public class PlayerModel {
    @Field
    private String name;
    @Field
    private int age;
    @Field
    private String position;

    public PlayerModel(String name, int age, String position) {
        this.name = name;
        this.age = age;
        this.position = position;
    }

    public PlayerModel() {
    }

    public String getName(){return name;}

    public void setName(String name){this.name = name;}

    public int getAge(){return age;}

    public void setAge(int age){this.age = age;}

    public String getPosition(){return position;}

    public void setPosition(String position){this.position = position;}
}
