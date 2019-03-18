package com.qianfeng.dao;

import org.apache.ibatis.annotations.Select;
import com.qianfeng.pojo.WUser;

public interface WUserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(WUser record);

    int insertSelective(WUser record);

    WUser selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(WUser record);

    int updateByPrimaryKey(WUser record);

    public WUser selectByUserName(String userName);

    public WUser selectByPhone(String phone);

}