package com.riane.homepage.mvp.model.entity;

import com.chad.library.adapter.base.entity.MultiItemEntity;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/15.
 */

public class RecommentIndexBean implements MultiItemEntity{

    /**
     * title : 我...我我我一点也不羡慕~哼
     * cover : https://i0.hdslb.com/bfs/archive/6cdaa51ef7c40a6e4878ff20891af8835dd08acc.jpg
     * uri : bilibili://video/33192977?page=1&player_preload=%7B%22cid%22%3A58098846%2C%22expire_time%22%3A1539593044%2C%22file_info%22%3A%7B%22112%22%3A%5B%7B%22timelength%22%3A52920%2C%22filesize%22%3A40753780%7D%5D%2C%2215%22%3A%5B%7B%22timelength%22%3A52920%2C%22filesize%22%3A3220071%7D%5D%2C%2232%22%3A%5B%7B%22timelength%22%3A52920%2C%22filesize%22%3A7021592%7D%5D%2C%2264%22%3A%5B%7B%22timelength%22%3A52920%2C%22filesize%22%3A14477610%7D%5D%2C%2280%22%3A%5B%7B%22timelength%22%3A52920%2C%22filesize%22%3A21167300%7D%5D%7D%2C%22support_quality%22%3A%5B112%2C80%2C64%2C32%2C15%5D%2C%22support_formats%22%3A%5B%22hdflv2%22%2C%22flv%22%2C%22flv720%22%2C%22flv480%22%2C%22flv360%22%5D%2C%22support_description%22%3A%5B%22%E9%AB%98%E6%B8%85%201080P%2B%22%2C%22%E9%AB%98%E6%B8%85%201080P%22%2C%22%E9%AB%98%E6%B8%85%20720P%22%2C%22%E6%B8%85%E6%99%B0%20480P%22%2C%22%E6%B5%81%E7%95%85%20360P%22%5D%2C%22quality%22%3A80%2C%22url%22%3A%22http%3A%2F%2Fcn-zjwz4-dx-v-02.acgvideo.com%2Fupgcxcode%2F46%2F88%2F58098846%2F58098846-1-80.flv%3Fexpires%3D1539596400%5Cu0026platform%3Dandroid%5Cu0026ssig%3D-Lt7tZnkhreBNCc2ULD0Lg%5Cu0026oi%3D2061533922%5Cu0026nfa%3Dzlb44%2FURExVDmluh6FGErg%3D%3D%5Cu0026dynamic%3D1%5Cu0026hfa%3D2046259559%5Cu0026hfb%3DNzUxMjI5MWJlMDBjMDY0YTQxNjFjMTJiYWE0MjEwYmQ%3D%5Cu0026trid%3Dbfb10f6dbdf44edcb18993b4f3e62225%5Cu0026nfc%3D1%22%2C%22video_codecid%22%3A7%2C%22video_project%22%3Atrue%2C%22fnver%22%3A0%2C%22fnval%22%3A0%7D&player_width=1088&player_height=1920&player_rotate=0
     * param : 33192977
     * goto : av
     * desc : 54弹幕
     * play : 33420
     * danmaku : 54
     * reply : 86
     * favorite : 1115
     * coin : 171
     * share : 71
     * like : 217
     * dislike : 4
     * duration : 54
     * idx : 1539589454
     * cid : 58098846
     * tid : 21
     * tname : 日常
     * tag : {"tag_id":2504,"tag_name":"美女","count":{"atten":88164}}
     * dislike_reasons : [{"reason_id":4,"reason_name":"UP主:万能的牧羊人"},{"reason_id":2,"reason_name":"分区:日常"},{"reason_id":3,"reason_name":"标签:美女"},{"reason_id":1,"reason_name":"不感兴趣"}]
     * ctime : 1538742741
     * autoplay : 1
     * mid : 12345861
     * name : 万能的牧羊人
     * face : http://i1.hdslb.com/bfs/face/28c4f69cdd674c25d7094a24cb124688d2f715a1.jpg
     */

    public static final int BANNER = 1;
    public static final int INDEX = 2;

    private String title;
    private String cover;
    private String uri;
    private String param;
    @SerializedName("goto")
    private String gotoX;
    private String desc;
    private int play;
    private int danmaku;
    private int reply;
    private int favorite;
    private int coin;
    private int share;
    private int like;
    private int dislike;
    private int duration;
    private int idx;
    private int cid;
    private int tid;
    private String tname;
    private TagBean tag;
    private int ctime;
    private int autoplay;
    private int mid;
    private String name;
    private String face;
    private List<DislikeReasonsBean> dislike_reasons;
    private List<HomepageBannerBean> banner_item;
    private int type;

    @Override
    public int getItemType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getGotoX() {
        return gotoX;
    }

    public void setGotoX(String gotoX) {
        this.gotoX = gotoX;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getPlay() {
        return play;
    }

    public void setPlay(int play) {
        this.play = play;
    }

    public int getDanmaku() {
        return danmaku;
    }

    public void setDanmaku(int danmaku) {
        this.danmaku = danmaku;
    }

    public int getReply() {
        return reply;
    }

    public void setReply(int reply) {
        this.reply = reply;
    }

    public int getFavorite() {
        return favorite;
    }

    public void setFavorite(int favorite) {
        this.favorite = favorite;
    }

    public int getCoin() {
        return coin;
    }

    public void setCoin(int coin) {
        this.coin = coin;
    }

    public int getShare() {
        return share;
    }

    public void setShare(int share) {
        this.share = share;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getDislike() {
        return dislike;
    }

    public void setDislike(int dislike) {
        this.dislike = dislike;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getIdx() {
        return idx;
    }

    public void setIdx(int idx) {
        this.idx = idx;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public TagBean getTag() {
        return tag;
    }

    public void setTag(TagBean tag) {
        this.tag = tag;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public int getAutoplay() {
        return autoplay;
    }

    public void setAutoplay(int autoplay) {
        this.autoplay = autoplay;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFace() {
        return face;
    }

    public void setFace(String face) {
        this.face = face;
    }

    public List<DislikeReasonsBean> getDislike_reasons() {
        return dislike_reasons;
    }

    public void setDislike_reasons(List<DislikeReasonsBean> dislike_reasons) {
        this.dislike_reasons = dislike_reasons;
    }

    public static class TagBean {
        /**
         * tag_id : 2504
         * tag_name : 美女
         * count : {"atten":88164}
         */

        private int tag_id;
        private String tag_name;
        private CountBean count;

        public int getTag_id() {
            return tag_id;
        }

        public void setTag_id(int tag_id) {
            this.tag_id = tag_id;
        }

        public String getTag_name() {
            return tag_name;
        }

        public void setTag_name(String tag_name) {
            this.tag_name = tag_name;
        }

        public CountBean getCount() {
            return count;
        }

        public void setCount(CountBean count) {
            this.count = count;
        }

        public static class CountBean {
            /**
             * atten : 88164
             */

            private int atten;

            public int getAtten() {
                return atten;
            }

            public void setAtten(int atten) {
                this.atten = atten;
            }
        }
    }

    public static class DislikeReasonsBean {
        /**
         * reason_id : 4
         * reason_name : UP主:万能的牧羊人
         */

        private int reason_id;
        private String reason_name;

        public int getReason_id() {
            return reason_id;
        }

        public void setReason_id(int reason_id) {
            this.reason_id = reason_id;
        }

        public String getReason_name() {
            return reason_name;
        }

        public void setReason_name(String reason_name) {
            this.reason_name = reason_name;
        }
    }

    public List<HomepageBannerBean> getBanner_item() {
        return banner_item;
    }

    public void setBanner_item(List<HomepageBannerBean> banner_item) {
        this.banner_item = banner_item;
    }
}
