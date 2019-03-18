package com.qianfeng.service.impl;

import com.qianfeng.dao.WUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.qianfeng.pojo.WUser;
import com.qianfeng.service.WUserService;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;

@Service
@Transactional
public class WUserServiceImpl implements WUserService {

    @Autowired
    private WUserMapper wUserDao;

    @Override
    public WUser login(String userName, String userPaddword) {

        WUser wUser = wUserDao.selectByUserName (userName);
        if(wUser == null){
            throw new RuntimeException ("用户名错误");
        }
        if (!wUser.getUserPassword ().equals (userPaddword)){
            throw new RuntimeException ("密码错误");
        }
        if (wUser.getUserFlag () == 0){
            throw  new RuntimeException ("用户已禁用");
        }

        return wUser;
    }

    @Override
    public void signUp(WUser wUser) {

        WUser wUser1 = wUserDao.selectByUserName (wUser.getUserName ());

        WUser wUser2 = wUserDao.selectByPhone (wUser.getUserPhone ());

        if (wUser1 == null && wUser2 == null){
            wUserDao.insertSelective (wUser);
        } else if (wUser1 != null){
            throw new RuntimeException ("用户名已存在");
        } else if (wUser2 != null){
            throw new RuntimeException ("手机号已注册");
        }


    }

    @Override
    public WUser backPasswordByPhone(String phone) {

        WUser wUser = null;
        try {
            wUser = wUserDao.selectByPhone (phone);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return wUser;
    }

    @Override
    public WUser findBySession(HttpSession session) {

        WUser user = (WUser) session.getAttribute ("user");
        if (user == null){
            throw new RuntimeException ("没有用户登录");
        } else {
            return user;
        }

    }

    @Override
    public void resetP(WUser user) {

        if (user.getUserPassword () == null || user.getUserPassword () == ""){
            throw new RuntimeException ("请输入密码");
        }

        try {
            wUserDao.updateByPrimaryKeySelective (user);
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    @Override
    public WUser findByUserId(Integer id) {

        WUser user = null;
        try {
            user = wUserDao.selectByPrimaryKey (id);
        } catch (Exception e) {
            e.printStackTrace ();
        }

        return user;
    }

    @Override
    public void exit(HttpSession session) {

        try {
            session.removeAttribute ("user");
        } catch (Exception e) {
            e.printStackTrace ();
        }

    }

    @Override
    public void updateUser(WUser user, HttpSession session) {

        WUser user1 = (WUser) session.getAttribute ("user");

        user.setUserId (user1.getUserId ());

        wUserDao.updateByPrimaryKeySelective (user);

    }
}
