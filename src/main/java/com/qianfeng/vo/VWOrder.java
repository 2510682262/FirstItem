package com.qianfeng.vo;

import java.util.Date;

public class VWOrder {

    private Integer orderId;

    private Integer orderUserId;

    private Date orderDate;

    private Integer orderStatus;

    private Integer orderWatchId;

    private Integer orderCount;

    private String orderAddr;

    private Integer orderPrice;

    private String watchName;

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getOrderUserId() {
        return orderUserId;
    }

    public void setOrderUserId(Integer orderUserId) {
        this.orderUserId = orderUserId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderWatchId() {
        return orderWatchId;
    }

    public void setOrderWatchId(Integer orderWatchId) {
        this.orderWatchId = orderWatchId;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public String getOrderAddr() {
        return orderAddr;
    }

    public void setOrderAddr(String orderAddr) {
        this.orderAddr = orderAddr == null ? null : orderAddr.trim ();
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

}
