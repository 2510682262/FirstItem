package com.qianfeng.service.impl;

import com.qianfeng.dao.WUserMapper;
import com.qianfeng.dao.WWatchMapper;
import com.qianfeng.pojo.WUser;
import com.qianfeng.pojo.WWatch;
import com.qianfeng.service.WUserService;
import com.qianfeng.service.WWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class WWatchServiceImpl implements WWatchService {

    @Autowired
    private WWatchMapper watchDao;

    @Override
    public List<WWatch> selectByCondition(WWatch watch, Integer page, Integer limit) {

        List<WWatch> list = null;
        try {
            list = watchDao.selectByCondition (watch,page,limit);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return list;
    }

    @Override
    public List<WWatch> selectAll(Integer page, Integer limit) {

        List<WWatch> list = watchDao.selectAll (page, limit);

        return list;
    }

    @Override
    public WWatch selectById(Integer id) {

        WWatch wWatch = null;
        try {
            wWatch = watchDao.selectByPrimaryKey (id);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return wWatch;
    }

    @Override
    public List<WWatch> selectByWatchName(String watchName) {

        List<WWatch> list = watchDao.selectByWatchName (watchName);
        if (list == null){
            throw new RuntimeException ("没有与搜索名字相似的手表");
        }
        return list;
    }

    @Override
    public Integer count(WWatch watch) {

        Integer count = null;
        try {
            count = watchDao.count (watch);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return count;
    }
}
