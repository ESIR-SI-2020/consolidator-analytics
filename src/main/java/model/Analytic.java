package model;

import java.util.Date;
import java.util.HashMap;

public class Analytic {
    private int nbUsers;
    private HashMap<Date, Integer> usersByDay;

    public int getNbUsers() {
        return nbUsers;
    }

    public void setNbUsers(int nbUsers) {
        this.nbUsers = nbUsers;
    }

    public HashMap<Date, Integer> getUsersByDay() {
        return usersByDay;
    }

    public void setUsersByDay(HashMap<Date, Integer> usersByDay) {
        this.usersByDay = usersByDay;
    }
}
