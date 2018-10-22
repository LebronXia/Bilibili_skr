package com.riane.channel.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/22.
 */

public class ChannelBean {

    /**
     * tid : 13
     * reid : 0
     * name : 番剧
     * logo : http://i0.hdslb.com/bfs/archive/6f629bd0dcd71d7b9911803f8e4f94fd0e5b4bfd.png
     * goto :
     * param :
     * uri : bilibili://pgc/bangumi
     * type : 1
     * is_bangumi : 1
     * children : [{"tid":33,"reid":13,"name":"连载动画","logo":"http://i0.hdslb.com/bfs/archive/02c1ddbe698c4cba3c6db941047957d17b7910d7.png","goto":"","param":"","type":0},{"tid":32,"reid":13,"name":"完结动画","logo":"http://i0.hdslb.com/bfs/archive/efb691127ea5b547b64431a59b27b278d6803172.png","goto":"","param":"","type":0},{"tid":51,"reid":13,"name":"资讯","logo":"","goto":"","param":"","type":0},{"tid":152,"reid":13,"name":"官方延伸","logo":"http://i0.hdslb.com/bfs/archive/8eb0bf53223544526bf99ec6f636758e2afed503.png","goto":"","param":"","type":0}]
     */

    private int tid;
    private int reid;
    private String name;
    private String logo;
    @SerializedName("goto")
    private String gotoX;
    private String param;
    private String uri;
    private int type;
    private int is_bangumi;
    private List<ChildrenBean> children;

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public int getReid() {
        return reid;
    }

    public void setReid(int reid) {
        this.reid = reid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getGotoX() {
        return gotoX;
    }

    public void setGotoX(String gotoX) {
        this.gotoX = gotoX;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIs_bangumi() {
        return is_bangumi;
    }

    public void setIs_bangumi(int is_bangumi) {
        this.is_bangumi = is_bangumi;
    }

    public List<ChildrenBean> getChildren() {
        return children;
    }

    public void setChildren(List<ChildrenBean> children) {
        this.children = children;
    }

    public static class ChildrenBean {
        /**
         * tid : 33
         * reid : 13
         * name : 连载动画
         * logo : http://i0.hdslb.com/bfs/archive/02c1ddbe698c4cba3c6db941047957d17b7910d7.png
         * goto :
         * param :
         * type : 0
         */

        private int tid;
        private int reid;
        private String name;
        private String logo;
        @SerializedName("goto")
        private String gotoX;
        private String param;
        private int type;

        public int getTid() {
            return tid;
        }

        public void setTid(int tid) {
            this.tid = tid;
        }

        public int getReid() {
            return reid;
        }

        public void setReid(int reid) {
            this.reid = reid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getLogo() {
            return logo;
        }

        public void setLogo(String logo) {
            this.logo = logo;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
