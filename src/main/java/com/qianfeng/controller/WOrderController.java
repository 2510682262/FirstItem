package com.qianfeng.controller;

import com.qianfeng.pojo.JsonBean;
import com.qianfeng.pojo.WOrder;
import com.qianfeng.service.WOrderService;
import com.qianfeng.utils.JsonUtils;
import com.qianfeng.vo.VWOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/order")
public class WOrderController {

    @Autowired
    private WOrderService orderService;


    @RequestMapping("/add.do")
    @ResponseBody
    public JsonBean addOrder(WOrder order,Integer watchId, HttpSession session){
        JsonBean bean = new JsonBean ();
        try {
            orderService.addOrder (order,watchId,session);
            bean = JsonUtils.createJsonBean (1,null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0,e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/query.do")
    @ResponseBody
    public JsonBean findById(HttpSession session){

        JsonBean bean = new JsonBean ();
        try {
            List<VWOrder> list = orderService.findById (session);
            bean = JsonUtils.createJsonBean (1,list);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0,e.getMessage ());
        }

        return bean;
    }

    @RequestMapping("/delete.do")
    @ResponseBody
    public JsonBean deleteByOrderId(Integer orderId){

        JsonBean bean = new JsonBean ();
        try {
            orderService.deleteByOrderId (orderId);
            bean = JsonUtils.createJsonBean (1,null);
        } catch (Exception e) {
            e.printStackTrace ();
            bean = JsonUtils.createJsonBean (0,e.getMessage ());
        }

        return bean;
    }



}
