package com.qianfeng.pojo;

public class WUser {
    private Integer userId;

    private String userName;

    private Integer userSex;

    private String userBirthday;

    private String userPhone;

    private String userPassword;

    private String userMailbox;

    private Integer userFlag;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getUserSex() {
        return userSex;
    }

    public void setUserSex(Integer userSex) {
        this.userSex = userSex;
    }

    public String getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(String userBirthday) {
        this.userBirthday = userBirthday == null ? null : userBirthday.trim();
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone == null ? null : userPhone.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserMailbox() {
        return userMailbox;
    }

    public void setUserMailbox(String userMailbox) {
        this.userMailbox = userMailbox == null ? null : userMailbox.trim();
    }

    public Integer getUserFlag() {
        return userFlag;
    }

    public void setUserFlag(Integer userFlag) {
        this.userFlag = userFlag;
    }
}