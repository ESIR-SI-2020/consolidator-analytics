package model;

import java.util.Date;

public class UsersByDay {
    private Date day;
    private Integer userNumber;

    public Date getDay() {
        return day;
    }

    public void setDay(Date day) {
        this.day = day;
    }

    public Integer getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(Integer userNumber) {
        this.userNumber = userNumber;
    }
}
