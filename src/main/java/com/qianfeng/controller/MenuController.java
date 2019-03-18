package com.qianfeng.controller;

import com.qianfeng.pojo.JsonBean;
import com.qianfeng.pojo.WDict;
import com.qianfeng.service.WDictService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VWDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class MenuController {

    @Autowired
    private WDictService dictsevice;

    @RequestMapping("/menu.do")
    @ResponseBody
    public JsonBean menu() {
        JsonBean bean;

        try {
            List<VWDict> list = dictsevice.menu ();
            bean = JsonUtils.createJsonBean (1, list);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;

    }


}
