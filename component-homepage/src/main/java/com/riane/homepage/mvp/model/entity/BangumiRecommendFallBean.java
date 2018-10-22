package com.riane.homepage.mvp.model.entity;

/**
 * Created by zhengxiaobo on 2018/10/19.
 */

public class BangumiRecommendFallBean {

    /**
     * cover : http://i0.hdslb.com/bfs/bangumi/ae65d7c57c8ed84ff950f48fd1deecdb4e8fabc2.jpg
     * id : 29596
     * is_new : 1
     * link : https://www.bilibili.com/bangumi/play/ss5998/
     * title : Re:CREATORS
     * type : 1
     * wid : 81
     */

    private String cover;
    private long cursor;
    private String desc;
    private int id;
    private int is_new;
    private String link;
    private String title;
    private int type;
    private int wid;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIs_new() {
        return is_new;
    }

    public void setIs_new(int is_new) {
        this.is_new = is_new;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public long getCursor() {
        return cursor;
    }

    public void setCursor(long cursor) {
        this.cursor = cursor;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
