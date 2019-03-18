package com.qianfeng.service.impl;

import com.qianfeng.dao.WOrderMapper;
import com.qianfeng.pojo.WOrder;
import com.qianfeng.pojo.WUser;
import com.qianfeng.service.WOrderService;
import com.qianfeng.vo.VWOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
@Transactional
public class WOrderServiceImpl implements WOrderService {

    @Autowired
    private WOrderMapper orderDao;


    @Override
    public void addOrder(WOrder order, Integer watchId, HttpSession session) {

        WUser user = (WUser) session.getAttribute ("user");
        if (user == null) {
            throw new RuntimeException ("请登录后再加入购物车");
        } else {
            Date date = new Date ();
            SimpleDateFormat sim = new SimpleDateFormat ("yyyy-mm-dd HH:mm:ss");
            order.setOrderDate (date);
            order.setOrderUserId (user.getUserId ());
            order.setOrderWatchId (watchId);

            orderDao.insertSelective (order);

        }

    }

    @Override
    public List<VWOrder> findById(HttpSession session) {

        List<VWOrder> list = null;
        WUser user = (WUser) session.getAttribute ("user");
        if (user == null) {
            throw new RuntimeException ("请登录后再查看购物车");
        } else {
            list = orderDao.findByUserId (user.getUserId ());
        }

        return list;
    }

    @Override
    public void deleteByOrderId(Integer orderId) {

        WOrder order = orderDao.selectByPrimaryKey (orderId);
        if (order == null) {
            throw new RuntimeException ("订单不存在");
        } else {
            order.setOrderStatus (0);
            orderDao.updateByPrimaryKeySelective (order);
        }

    }
}
