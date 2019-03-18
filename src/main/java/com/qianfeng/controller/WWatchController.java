package com.qianfeng.controller;

import com.qianfeng.pojo.JsonBean;
import com.qianfeng.pojo.WWatch;
import com.qianfeng.service.WUserService;
import com.qianfeng.service.WWatchService;
import com.qianfeng.utils.JsonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/watch")
public class WWatchController {

    @Autowired
    private WWatchService watchService;


    @RequestMapping("/select.do")
    @ResponseBody
    public JsonBean select(WWatch watch, Integer page, Integer limit) {

        System.out.println (watch.getWatchSex ());
        JsonBean bean = new JsonBean ();
        try {
            List<WWatch> list = watchService.selectByCondition (watch, page, limit);
            bean = JsonUtils.createJsonBean (1, list);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, "没有满足要求的手表");
        }

        return bean;
    }

    @RequestMapping("/list.do")
    @ResponseBody
    public JsonBean selectAll(Integer page, Integer limit) {
        JsonBean bean = new JsonBean ();

        try {
            List<WWatch> list = watchService.selectAll (page, limit);
            bean = JsonUtils.createJsonBean (1, list);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;

    }

    @RequestMapping("/good.do")
    @ResponseBody
    public JsonBean selectAll(Integer watchId) {
        JsonBean bean = new JsonBean ();

        try {
            WWatch wWatch = watchService.selectById (watchId);
            bean = JsonUtils.createJsonBean (1, wWatch);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/search.do")
    @ResponseBody
    public JsonBean findByWatchName(String watchName) {
        JsonBean bean = new JsonBean ();

        try {
            List<WWatch> list = watchService.selectByWatchName (watchName);
            bean = JsonUtils.createJsonBean (1, list);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;

    }

    @RequestMapping("/count.do")
    @ResponseBody
    public JsonBean count(WWatch watch) {
        JsonBean bean = new JsonBean ();

        try {
            Integer count = watchService.count (watch);
            bean = JsonUtils.createJsonBean (1, count);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0, e.getMessage ());
        }

        return bean;

    }


}
