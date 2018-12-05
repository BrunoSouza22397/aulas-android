package bruno.souza.exradiobuttoncheckboxtarde.model;

import java.util.ArrayList;

public class Person {

    private String name;
    private String gender;
    private ArrayList<String> prefs;

    public Person() {
    }

    @Override
    public String toString() {
        return "\nName = " + name +
                "\nGender = " + gender +
                "\nPrefs = " + prefs;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public ArrayList<String> getPrefs() {
        return prefs;
    }

    public void setPrefs(ArrayList<String> prefs) {
        this.prefs = prefs;
    }
}//close class
