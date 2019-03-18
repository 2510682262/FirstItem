package com.qianfeng.service;

import com.qianfeng.pojo.WUser;
import com.qianfeng.pojo.WWatch;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.List;

public interface WWatchService {

    public List<WWatch> selectByCondition(WWatch watch, Integer page, Integer limit);

    public List<WWatch> selectAll(Integer page, Integer limit);

    public WWatch selectById(Integer id);

    public List<WWatch> selectByWatchName(String watchName);

    public Integer count(WWatch watch);


}
