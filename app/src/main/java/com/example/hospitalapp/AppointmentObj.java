package com.example.hospitalapp;

public class AppointmentObj {
    private String Age, Allergies, Gender, ID, Name, Problem;

    public AppointmentObj() {
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public String getAllergies() {
        return Allergies;
    }

    public void setAllergies(String allergies) {
        Allergies = allergies;
    }

    public String getGender() {
        return Gender;
    }

    public void setGender(String gender) {
        Gender = gender;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }
}
