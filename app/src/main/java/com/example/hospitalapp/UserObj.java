package com.example.hospitalapp;

import java.io.Serializable;

@SuppressWarnings("serial")
public class UserObj implements Serializable {
    private String Name;
    private String ID;
    private String DoB;

    public UserObj() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDoB() {
        return DoB;
    }

    public void setDoB(String doB) {
        DoB = doB;
    }

}
