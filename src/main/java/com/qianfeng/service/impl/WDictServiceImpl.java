package com.qianfeng.service.impl;

import com.qianfeng.dao.WDictMapper;
import com.qianfeng.pojo.WDict;
import com.qianfeng.service.WDictService;
import com.qianfeng.vo.VWDict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;


@Service
@Transactional
public class WDictServiceImpl implements WDictService {

    @Autowired
    private WDictMapper dictDao;

    @Override
    public List<VWDict> menu() {

        List<WDict> wDicts = dictDao.selectAll ();

        List<VWDict> menuList = new ArrayList<> ();

        // 循环遍历根据角色id查询出的数据
        for (WDict dict : wDicts) {
            // 获取list集合中每个元素的 ParentCode 的值用来判断是否是父菜单项
            Integer parentCode = dict.getDictPid ();
            // 说明是父菜单项
            if (parentCode == null) {
                int flag = 0;
                // 判断是否有相同的父菜单名称
                for(VWDict menuInfo : menuList) {
                    if (menuInfo.getMenuName().equals(dict.getDictType ())) {
                        flag = 1;
                        break;
                    }
                }
                // 说明没有同名的父菜单项
                if (flag == 0) {
                    // 创建一个VMenuInfo对象 用来保存父菜单项的数据
                    VWDict mInfo = new VWDict ();
                    // 因为当前循环的数据是父菜单项，所以将当前循环的数据添加到新创建的VMenuInfo对象中
                    mInfo.setMenuName(dict.getDictType ());
                    mInfo.setId(dict.getDictId ());
                    mInfo.setWatchName (dict.getDictWatchname ());
                    // 创建一个
                    List<VWDict> cList = new ArrayList<>();
                    mInfo.setcMenuList(cList);
                    // 将创建的VMenuInfo对象添加到要传送给前端界面的List<VMenuInfo>
                    menuList.add(mInfo);
                }
            }else { // 说明是子菜单项
                // 循环遍历要传送给前端界面的List<VMenuInfo>
                for(VWDict menuInfo : menuList) {
                    // 如果找到子菜单对应的父菜单项
                    // 进行一一赋值
                    if (dict.getDictPid () == menuInfo.getId()) {
                        VWDict cMenu = new VWDict ();
                        cMenu.setId(dict.getDictId ());
                        cMenu.setMenuName(dict.getDictItem ());
                        // 将新值添加到父菜单的子菜单列表中
                        menuInfo.getcMenuList().add(cMenu);
                        break;
                    }
                }
            }
        }

        return menuList;
    }

}
