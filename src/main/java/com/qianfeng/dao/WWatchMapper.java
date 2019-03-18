package com.qianfeng.dao;

import com.qianfeng.pojo.WWatch;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WWatchMapper {

    int deleteByPrimaryKey(Integer watchId);

    int insert(WWatch record);

    int insertSelective(WWatch record);

    WWatch selectByPrimaryKey(Integer watchId);

    int updateByPrimaryKeySelective(WWatch record);

    int updateByPrimaryKey(WWatch record);

    List<WWatch> selectByCondition(@Param("watch") WWatch watch, @Param("page") Integer page, @Param("limit") Integer limit);

    List<WWatch> selectAll(@Param("page") Integer page, @Param("limit") Integer limit);

    List<WWatch> selectByWatchName(String watchName);

    Integer count(WWatch watch);


}