package com.nexusinfo.nedusoft.models;

import java.io.Serializable;

/**
 * Created by firdous on 11/28/2017.
 */

public class UserModel implements Serializable{

    private String userID, fatherMobile, schoolCode, schoolDBName, schoolEmail;

    public UserModel(String user, String fatherMobile, String schoolCode, String schoolDBName, String schoolEmail) {
        this.userID = user;
        this.fatherMobile = fatherMobile;
        this.schoolCode = schoolCode;
        this.schoolDBName = schoolDBName;
        this.schoolEmail = schoolEmail;
    }

    public UserModel() {
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFatherMobile() {
        return fatherMobile;
    }

    public void setFatherMobile(String fatherMobile) {
        this.fatherMobile = fatherMobile;
    }

    public String getSchoolCode() {
        return schoolCode;
    }

    public void setSchoolCode(String schoolCode) {
        this.schoolCode = schoolCode;
    }

    public String getSchoolDBName() {
        return schoolDBName;
    }

    public void setSchoolDBName(String schoolDBName) {
        this.schoolDBName = schoolDBName;
    }

    public String getSchoolEmail() {
        return schoolEmail;
    }

    public void setSchoolEmail(String schoolEmail) {
        this.schoolEmail = schoolEmail;
    }
}
