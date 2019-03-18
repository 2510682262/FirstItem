package com.qianfeng.pojo;

public class WDict {
    private Integer dictId;

    private String dictType;

    private String dictItem;

    private Integer dictStatus;

    private Integer dictPid;

    private String dictWatchname;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType == null ? null : dictType.trim ();
    }

    public String getDictItem() {
        return dictItem;
    }

    public void setDictItem(String dictItem) {
        this.dictItem = dictItem == null ? null : dictItem.trim ();
    }

    public Integer getDictStatus() {
        return dictStatus;
    }

    public void setDictStatus(Integer dictStatus) {
        this.dictStatus = dictStatus;
    }

    public Integer getDictPid() {
        return dictPid;
    }

    public void setDictPid(Integer dictPid) {
        this.dictPid = dictPid;
    }

    public String getDictWatchname() {
        return dictWatchname;
    }

    public void setDictWatchname(String dictWatchname) {
        this.dictWatchname = dictWatchname == null ? null : dictWatchname.trim ();
    }
}