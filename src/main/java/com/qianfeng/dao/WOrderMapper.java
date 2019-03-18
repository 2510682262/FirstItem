package com.qianfeng.dao;

import com.qianfeng.pojo.WOrder;
import com.qianfeng.vo.VWOrder;

import java.util.List;

public interface WOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(WOrder record);

    int insertSelective(WOrder record);

    WOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(WOrder record);

    int updateByPrimaryKey(WOrder record);

    public List<VWOrder> findByUserId(Integer id);
}