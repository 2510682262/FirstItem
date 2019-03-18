package com.qianfeng.pojo;

public class WWatch {
    private Integer watchId;

    private String watchName;

    private Integer watchSex;

    private Integer watchMovement;

    private Integer watchWatchband;

    private Integer watchShape;

    private Integer watchSize;

    private Integer watchColour;

    private Integer watchSeries;

    private String watchImgpath;

    private Integer watchPrice;

    private Integer watchFlag;

    private Integer watchRecommended;

    private Integer watchContext;

    public Integer getWatchId() {
        return watchId;
    }

    public void setWatchId(Integer watchId) {
        this.watchId = watchId;
    }

    public String getWatchName() {
        return watchName;
    }

    public void setWatchName(String watchName) {
        this.watchName = watchName == null ? null : watchName.trim ();
    }

    public Integer getWatchSex() {
        return watchSex;
    }

    public void setWatchSex(Integer watchSex) {
        this.watchSex = watchSex;
    }

    public Integer getWatchMovement() {
        return watchMovement;
    }

    public void setWatchMovement(Integer watchMovement) {
        this.watchMovement = watchMovement;
    }

    public Integer getWatchWatchband() {
        return watchWatchband;
    }

    public void setWatchWatchband(Integer watchWatchband) {
        this.watchWatchband = watchWatchband;
    }

    public Integer getWatchShape() {
        return watchShape;
    }

    public void setWatchShape(Integer watchShape) {
        this.watchShape = watchShape;
    }

    public Integer getWatchSize() {
        return watchSize;
    }

    public void setWatchSize(Integer watchSize) {
        this.watchSize = watchSize;
    }

    public Integer getWatchColour() {
        return watchColour;
    }

    public void setWatchColour(Integer watchColour) {
        this.watchColour = watchColour;
    }

    public Integer getWatchSeries() {
        return watchSeries;
    }

    public void setWatchSeries(Integer watchSeries) {
        this.watchSeries = watchSeries;
    }

    public String getWatchImgpath() {
        return watchImgpath;
    }

    public void setWatchImgpath(String watchImgpath) {
        this.watchImgpath = watchImgpath == null ? null : watchImgpath.trim ();
    }

    public Integer getWatchPrice() {
        return watchPrice;
    }

    public void setWatchPrice(Integer watchPrice) {
        this.watchPrice = watchPrice;
    }

    public Integer getWatchFlag() {
        return watchFlag;
    }

    public void setWatchFlag(Integer watchFlag) {
        this.watchFlag = watchFlag;
    }

    public Integer getWatchRecommended() {
        return watchRecommended;
    }

    public void setWatchRecommended(Integer watchRecommended) {
        this.watchRecommended = watchRecommended;
    }

    public Integer getWatchContext() {
        return watchContext;
    }

    public void setWatchContext(Integer watchContext) {
        this.watchContext = watchContext;
    }
}