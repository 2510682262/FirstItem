package com.qianfeng.dao;


import com.qianfeng.pojo.WDict;
import com.qianfeng.vo.VWDict;

import java.util.List;

public interface WDictMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(WDict record);

    int insertSelective(WDict record);

    WDict selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(WDict record);

    int updateByPrimaryKey(WDict record);

    public List<WDict> selectAll();

    public List<VWDict> menuInfo();

}