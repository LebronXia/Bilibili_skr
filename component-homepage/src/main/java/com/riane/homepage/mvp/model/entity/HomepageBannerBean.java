package com.riane.homepage.mvp.model.entity;

/**
 * Created by zhengxiaobo on 2018/10/15.
 */

public class HomepageBannerBean {

    /**
     * id : 154312
     * title : 水树奈奈&KSL上海演唱会 延时直播
     * image : http://i0.hdslb.com/bfs/archive/54fa139efe7586a45eefb980e91bbe5c68b1f71f.jpg
     * hash : 107210af9ff959cf8e434b5ed75f6117
     * uri : https://live.bilibili.com/blackboard/activity-nana-mizuki-live-h5.html
     * request_id : 1539589444771
     * server_type : 0
     * resource_id : 631
     * index : 1
     * cm_mark : 0
     */

    private int id;
    private String title;
    private String image;
    private String hash;
    private String uri;
    private String request_id;
    private int server_type;
    private int resource_id;
    private int index;
    private int cm_mark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getRequest_id() {
        return request_id;
    }

    public void setRequest_id(String request_id) {
        this.request_id = request_id;
    }

    public int getServer_type() {
        return server_type;
    }

    public void setServer_type(int server_type) {
        this.server_type = server_type;
    }

    public int getResource_id() {
        return resource_id;
    }

    public void setResource_id(int resource_id) {
        this.resource_id = resource_id;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getCm_mark() {
        return cm_mark;
    }

    public void setCm_mark(int cm_mark) {
        this.cm_mark = cm_mark;
    }
}
