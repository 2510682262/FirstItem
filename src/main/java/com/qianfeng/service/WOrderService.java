package com.qianfeng.service;

import com.qianfeng.pojo.WOrder;
import com.qianfeng.vo.VWOrder;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface WOrderService {

    public void addOrder(WOrder order, Integer watchId, HttpSession session);

    public List<VWOrder> findById(HttpSession session);

    public void deleteByOrderId(Integer orderId);


}
