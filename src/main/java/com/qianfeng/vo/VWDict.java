package com.qianfeng.vo;

import java.util.List;

public class VWDict {

    private Integer id;

    private String menuName;

    private String watchName;

    private List<VWDict> cMenuList;

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName;
    }

    public Integer getId() {
        return id;
    }

    public String getMenuName() {
        return menuName;
    }

    public List<VWDict> getcMenuList() {
        return cMenuList;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public void setcMenuList(List<VWDict> cMenuList) {
        this.cMenuList = cMenuList;
    }
}
