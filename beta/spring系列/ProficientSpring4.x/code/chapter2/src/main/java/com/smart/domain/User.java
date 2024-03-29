package com.smart.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Andy Ron
 */
public class User implements Serializable {
    private int userId;
    private String userName;
    private String password;
    private int credits;
    private String lastIp;
    private Date lastVisit;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public Date getLastVisit() {
        return lastVisit;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastVisit(Date lastVisit) {
        this.lastVisit = lastVisit;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
