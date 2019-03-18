package com.qianfeng.controller;

import com.qianfeng.pojo.JsonBean;
import com.qianfeng.pojo.WUser;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.qianfeng.service.WUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class WUserController {

    @Autowired
    private WUserService wUserService;

    @RequestMapping("/judge.do")
    @ResponseBody
    public JsonBean findbySession(HttpSession session) {
        JsonBean bean = new JsonBean ();

        try {
            WUser user = wUserService.findBySession (session);
            bean = JsonUtils.createJsonBean (1, user);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }
        return bean;

    }

    @RequestMapping("/resetPassword.do")
    @ResponseBody
    public JsonBean resetPassword(WUser user) {
        JsonBean bean = new JsonBean ();

        try {
            wUserService.resetP (user);
            bean = JsonUtils.createJsonBean (1, user);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }
        return bean;

    }

    @RequestMapping("/findById.do")
    @ResponseBody
    public JsonBean findById(Integer userId) {
        JsonBean bean = new JsonBean ();

        try {
            WUser user = wUserService.findByUserId (userId);
            bean = JsonUtils.createJsonBean (1, user);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }
        return bean;

    }

    @RequestMapping("/updateUser.do")
    @ResponseBody
    public JsonBean updateUser(WUser user, HttpSession session) {
        JsonBean bean = new JsonBean ();

        try {
            wUserService.updateUser (user,session);
            bean = JsonUtils.createJsonBean (1, user);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }
        return bean;

    }


}
