package com.qianfeng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.qianfeng.pojo.JsonBean;
import com.qianfeng.pojo.WUser;
import com.qianfeng.service.WUserService;
import com.qianfeng.utils.JsonUtils;

import javax.servlet.http.HttpSession;


@Controller
public class LoginController {

    @Autowired
    private WUserService wUserService;

    @RequestMapping("/login.do")
    @ResponseBody
    public JsonBean login(String userName, String userPassword, HttpSession session) {
        JsonBean bean = new JsonBean ();
        try {
            WUser user = wUserService.login (userName, userPassword);
            session.setAttribute ("user", user);
            bean = JsonUtils.createJsonBean (1, null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }
        return bean;
    }

    @RequestMapping("/signUp.do")
    @ResponseBody
    public JsonBean signUp(WUser wUser) {
        JsonBean bean = new JsonBean ();
        try {
            wUserService.signUp (wUser);
            bean = JsonUtils.createJsonBean (1, null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/backPassword.do")
    @ResponseBody
    public JsonBean backPassword(String phone) {

        JsonBean bean = new JsonBean ();
        try {
            WUser wUser = wUserService.backPasswordByPhone (phone);
            bean = JsonUtils.createJsonBean (1, wUser);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/resetPassword.do")
    @ResponseBody
    public JsonBean resetP(WUser user) {

        JsonBean bean = new JsonBean ();
        try {
            wUserService.resetP (user);
            bean = JsonUtils.createJsonBean (1, null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/exit.do")
    @ResponseBody
    public JsonBean exit(HttpSession session) {

        JsonBean bean = new JsonBean ();
        try {
            wUserService.exit (session);
            bean = JsonUtils.createJsonBean (1, null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;
    }

}
