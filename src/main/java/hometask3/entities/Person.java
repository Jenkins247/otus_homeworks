package hometask3.entities;

import hometask3.entities.enums.*;

import java.util.Random;

public abstract class Person {

    private int id = 1;
    private String fullName;
    private String gender;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    private String getRandomMaleFullName(){
        String firstname;
        String middleName;
        String lastName;
        int x = new Random().nextInt(MFirstName.values().length);
        firstname = MFirstName.values()[x].toString();

        int y = new Random().nextInt(MMiddleName.values().length);
        middleName = MMiddleName.values()[y].toString();

        int z = new Random().nextInt(MLastName.values().length);
        lastName = MLastName.values()[z].toString();

        return String.format("%s %s %s", firstname, middleName, lastName);
    }

    private String getRandomFemaleFullName(){
        String firstname;
        String middleName;
        String lastName;

        int x = new Random().nextInt(FFirstname.values().length);
        firstname = FFirstname.values()[x].toString();

        int y = new Random().nextInt(FMiddleName.values().length);
        middleName = FMiddleName.values()[y].toString();

        int z = new Random().nextInt(FLastName.values().length);
        lastName = FLastName.values()[z].toString();

        return String.format("%s %s %s", firstname, middleName, lastName);
    }

    private String getRandomGender(){
        int x = new Random().nextInt(Gender.values().length);
        return Gender.values()[x].toString();
    }
    private void generateFullName(){
        gender = getRandomGender();
        if(gender.equals("Мужской")){
            fullName = getRandomMaleFullName();
        }else {
            fullName = getRandomFemaleFullName();
        }
    }



    public String getFullName() {
        generateFullName();
        return fullName;
    }


    public String getGender() {
        return gender;
    }
}
