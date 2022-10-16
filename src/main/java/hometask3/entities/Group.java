package hometask3.entities;

import java.sql.SQLException;

public class Group {
    private int id = 1;
    private String name;
    private int curatorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
