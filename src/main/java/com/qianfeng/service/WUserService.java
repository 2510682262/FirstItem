package com.qianfeng.service;

import com.qianfeng.pojo.WUser;

import javax.servlet.http.HttpSession;

public interface WUserService {

    public WUser login(String userName, String userPassword);

    public void signUp(WUser wUser);

    public WUser backPasswordByPhone(String phone);

    public WUser findBySession(HttpSession session);

    public void resetP(WUser user);

    public WUser findByUserId(Integer id);

    public void exit(HttpSession session);

    public void updateUser(WUser user,HttpSession session);

}
