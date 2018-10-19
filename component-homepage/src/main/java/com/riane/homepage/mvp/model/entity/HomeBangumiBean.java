package com.riane.homepage.mvp.model.entity;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/10/17.
 */

public class HomeBangumiBean {

    /**
     * ad : []
     * recommend_cn : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/38ff1938c6071beac11efb70f2ce53140988e96d.jpg","desc":"东方美学，创世幻想","id":29595,"is_auto":1,"link":"http://bangumi.bilibili.com/anime/24667","title":"【完结推荐】天谕 第二季：苍古之绊","wid":59}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/1fb653e1e9a825ef1487216c834d3f72c647a8aa.jpg","favourites":"609453","is_auto":0,"is_finish":0,"is_started":1,"last_time":1539309600,"newest_ep_index":"总集篇3","pub_time":1535299201,"season_id":24438,"season_status":2,"title":"小绿和小蓝","total_count":72,"watching_count":0,"wid":84},{"cover":"http://i0.hdslb.com/bfs/bangumi/aeb1cfa1938d700466551519a6ad76a87be3a89a.jpg","favourites":"413867","is_auto":0,"is_finish":1,"is_started":1,"last_time":1536976800,"newest_ep_index":"10","pub_time":1531497601,"season_id":24709,"season_status":2,"title":"百鬼幼儿园","total_count":10,"watching_count":0,"wid":84},{"cover":"http://i0.hdslb.com/bfs/bangumi/90e7759af39e768e3116938dfca60f7d602ac7c5.jpg","favourites":"491292","is_auto":0,"is_finish":0,"is_started":1,"last_time":1539316800,"newest_ep_index":"5","pub_time":1537502400,"season_id":24267,"season_status":13,"title":"剑网3·侠肝义胆沈剑心","total_count":12,"watching_count":0,"wid":84}]}
     * recommend_jp : {"foot":[{"cover":"http://i0.hdslb.com/bfs/bangumi/ae65d7c57c8ed84ff950f48fd1deecdb4e8fabc2.jpg","id":29596,"is_auto":1,"link":"https://www.bilibili.com/bangumi/play/ss5998/","title":"Re:CREATORS","wid":81}],"recommend":[{"cover":"http://i0.hdslb.com/bfs/bangumi/fe356b227e0005454ab2c267c9d7de902eebe837.png","favourites":"214770","is_auto":0,"is_finish":0,"is_started":1,"last_time":1539710940,"newest_ep_index":"3","pub_time":1538501340,"season_id":25742,"season_status":13,"title":"强风吹拂","total_count":0,"watching_count":0,"wid":82},{"cover":"http://i0.hdslb.com/bfs/bangumi/93800a3560fa26f3f63ea8ac0cd5c4bfa9e3d4ea.png","favourites":"737595","is_auto":0,"is_finish":0,"is_started":1,"last_time":1539181800,"newest_ep_index":"1","pub_time":1539181800,"season_id":25717,"season_status":13,"title":"我喜欢的是小说里的你","total_count":10,"watching_count":0,"wid":82},{"cover":"http://i0.hdslb.com/bfs/bangumi/911c5a54441d614ac53b46574838d4721a80cf98.jpg","favourites":"2604912","is_auto":0,"is_finish":0,"is_started":1,"last_time":1539448200,"newest_ep_index":"2","pub_time":1538843400,"season_id":25510,"season_status":13,"title":"刀剑神域 Alicization","total_count":0,"watching_count":0,"wid":82}]}
     * recommend_review : []
     * timeline : [{"area_id":1,"cover":"http://i0.hdslb.com/bfs/bangumi/853afc1e8cbba2f6395d4ae1bfbcd3d9b6beb27a.jpg","delay":0,"ep_id":251855,"favorites":60533,"follow":0,"is_published":1,"order":2,"pub_date":"2018-10-17","pub_index":"第2话","pub_time":"12:00","pub_ts":1539748800,"season_id":25588,"season_status":2,"square_cover":"http://i0.hdslb.com/bfs/bangumi/bd0d3fd43676a87853a9490c4fe5a6c070d23e1b.jpg","title":"战斗吧歌姬 第一季"},{"area_id":1,"cover":"http://i0.hdslb.com/bfs/bangumi/6ac89e4c8cdc09c0a3f04835f92f0ad5c310e60d.jpg","delay":0,"ep_id":251621,"favorites":297571,"follow":0,"is_published":1,"order":23,"pub_date":"2018-10-17","pub_index":"第20话","pub_time":"10:00","pub_ts":1539741600,"season_id":6491,"season_status":2,"square_cover":"http://i0.hdslb.com/bfs/bangumi/df0ea04c661cbeb3f8567ea92ce54c3d015c962b.jpg","title":"幻界王"},{"area_id":2,"cover":"http://i0.hdslb.com/bfs/bangumi/781d16fc2aef145b5386ff2b088fdd3dbb6b32df.jpg","delay":0,"ep_id":232249,"favorites":291850,"follow":0,"is_published":1,"order":15,"pub_date":"2018-10-17","pub_index":"第15话","pub_time":"04:30","pub_ts":1539721800,"season_id":24611,"season_status":13,"square_cover":"http://i0.hdslb.com/bfs/bangumi/0caf41dc61a203bac3c13b97616666e10af1bc4d.jpg","title":"中间管理录利根川"}]
     */
    //国产动画推荐
    private RecommendCnBean recommend_cn;
    //番号推荐
    private RecommendJpBean recommend_jp;
    //头部广告
    private List<?> ad;
    private List<?> recommend_review;
    private List<TimelineBean> timeline;

    public RecommendCnBean getRecommend_cn() {
        return recommend_cn;
    }

    public void setRecommend_cn(RecommendCnBean recommend_cn) {
        this.recommend_cn = recommend_cn;
    }

    public RecommendJpBean getRecommend_jp() {
        return recommend_jp;
    }

    public void setRecommend_jp(RecommendJpBean recommend_jp) {
        this.recommend_jp = recommend_jp;
    }

    public List<?> getAd() {
        return ad;
    }

    public void setAd(List<?> ad) {
        this.ad = ad;
    }

    public List<?> getRecommend_review() {
        return recommend_review;
    }

    public void setRecommend_review(List<?> recommend_review) {
        this.recommend_review = recommend_review;
    }

    public List<TimelineBean> getTimeline() {
        return timeline;
    }

    public void setTimeline(List<TimelineBean> timeline) {
        this.timeline = timeline;
    }

    public static class RecommendCnBean {
        private List<FootBean> foot;
        private List<RecommendBean> recommend;

        public List<FootBean> getFoot() {
            return foot;
        }

        public void setFoot(List<FootBean> foot) {
            this.foot = foot;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }
    }

    public static class RecommendJpBean {
        private List<FootBean> foot;
        private List<RecommendBean> recommend;

        public List<FootBean> getFoot() {
            return foot;
        }

        public void setFoot(List<FootBean> foot) {
            this.foot = foot;
        }

        public List<RecommendBean> getRecommend() {
            return recommend;
        }

        public void setRecommend(List<RecommendBean> recommend) {
            this.recommend = recommend;
        }

    }

    public static class FootBean {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/38ff1938c6071beac11efb70f2ce53140988e96d.jpg
         * desc : 东方美学，创世幻想
         * id : 29595
         * is_auto : 1
         * link : http://bangumi.bilibili.com/anime/24667
         * title : 【完结推荐】天谕 第二季：苍古之绊
         * wid : 59
         */

        private String cover;
        private String desc;
        private int id;
        private int is_auto;
        private String link;
        private String title;
        private int wid;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIs_auto() {
            return is_auto;
        }

        public void setIs_auto(int is_auto) {
            this.is_auto = is_auto;
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

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }
    }

    public static class RecommendBean {
        /**
         * cover : http://i0.hdslb.com/bfs/bangumi/1fb653e1e9a825ef1487216c834d3f72c647a8aa.jpg
         * favourites : 609453
         * is_auto : 0
         * is_finish : 0
         * is_started : 1
         * last_time : 1539309600
         * newest_ep_index : 总集篇3
         * pub_time : 1535299201
         * season_id : 24438
         * season_status : 2
         * title : 小绿和小蓝
         * total_count : 72
         * watching_count : 0
         * wid : 84
         */

        private String cover;
        private String favourites;
        private int is_auto;
        private int is_finish;
        private int is_started;
        private int last_time;
        private String newest_ep_index;
        private int pub_time;
        private int season_id;
        private int season_status;
        private String title;
        private int total_count;
        private int watching_count;
        private int wid;

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public String getFavourites() {
            return favourites;
        }

        public void setFavourites(String favourites) {
            this.favourites = favourites;
        }

        public int getIs_auto() {
            return is_auto;
        }

        public void setIs_auto(int is_auto) {
            this.is_auto = is_auto;
        }

        public int getIs_finish() {
            return is_finish;
        }

        public void setIs_finish(int is_finish) {
            this.is_finish = is_finish;
        }

        public int getIs_started() {
            return is_started;
        }

        public void setIs_started(int is_started) {
            this.is_started = is_started;
        }

        public int getLast_time() {
            return last_time;
        }

        public void setLast_time(int last_time) {
            this.last_time = last_time;
        }

        public String getNewest_ep_index() {
            return newest_ep_index;
        }

        public void setNewest_ep_index(String newest_ep_index) {
            this.newest_ep_index = newest_ep_index;
        }

        public int getPub_time() {
            return pub_time;
        }

        public void setPub_time(int pub_time) {
            this.pub_time = pub_time;
        }

        public int getSeason_id() {
            return season_id;
        }

        public void setSeason_id(int season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public int getTotal_count() {
            return total_count;
        }

        public void setTotal_count(int total_count) {
            this.total_count = total_count;
        }

        public int getWatching_count() {
            return watching_count;
        }

        public void setWatching_count(int watching_count) {
            this.watching_count = watching_count;
        }

        public int getWid() {
            return wid;
        }

        public void setWid(int wid) {
            this.wid = wid;
        }
    }

    public static class TimelineBean {
        /**
         * area_id : 1
         * cover : http://i0.hdslb.com/bfs/bangumi/853afc1e8cbba2f6395d4ae1bfbcd3d9b6beb27a.jpg
         * delay : 0
         * ep_id : 251855
         * favorites : 60533
         * follow : 0
         * is_published : 1
         * order : 2
         * pub_date : 2018-10-17
         * pub_index : 第2话
         * pub_time : 12:00
         * pub_ts : 1539748800
         * season_id : 25588
         * season_status : 2
         * square_cover : http://i0.hdslb.com/bfs/bangumi/bd0d3fd43676a87853a9490c4fe5a6c070d23e1b.jpg
         * title : 战斗吧歌姬 第一季
         */

        private int area_id;
        private String cover;
        private int delay;
        private int ep_id;
        private int favorites;
        private int follow;
        private int is_published;
        private int order;
        private String pub_date;
        private String pub_index;
        private String pub_time;
        private int pub_ts;
        private int season_id;
        private int season_status;
        private String square_cover;
        private String title;

        public int getArea_id() {
            return area_id;
        }

        public void setArea_id(int area_id) {
            this.area_id = area_id;
        }

        public String getCover() {
            return cover;
        }

        public void setCover(String cover) {
            this.cover = cover;
        }

        public int getDelay() {
            return delay;
        }

        public void setDelay(int delay) {
            this.delay = delay;
        }

        public int getEp_id() {
            return ep_id;
        }

        public void setEp_id(int ep_id) {
            this.ep_id = ep_id;
        }

        public int getFavorites() {
            return favorites;
        }

        public void setFavorites(int favorites) {
            this.favorites = favorites;
        }

        public int getFollow() {
            return follow;
        }

        public void setFollow(int follow) {
            this.follow = follow;
        }

        public int getIs_published() {
            return is_published;
        }

        public void setIs_published(int is_published) {
            this.is_published = is_published;
        }

        public int getOrder() {
            return order;
        }

        public void setOrder(int order) {
            this.order = order;
        }

        public String getPub_date() {
            return pub_date;
        }

        public void setPub_date(String pub_date) {
            this.pub_date = pub_date;
        }

        public String getPub_index() {
            return pub_index;
        }

        public void setPub_index(String pub_index) {
            this.pub_index = pub_index;
        }

        public String getPub_time() {
            return pub_time;
        }

        public void setPub_time(String pub_time) {
            this.pub_time = pub_time;
        }

        public int getPub_ts() {
            return pub_ts;
        }

        public void setPub_ts(int pub_ts) {
            this.pub_ts = pub_ts;
        }

        public int getSeason_id() {
            return season_id;
        }

        public void setSeason_id(int season_id) {
            this.season_id = season_id;
        }

        public int getSeason_status() {
            return season_status;
        }

        public void setSeason_status(int season_status) {
            this.season_status = season_status;
        }

        public String getSquare_cover() {
            return square_cover;
        }

        public void setSquare_cover(String square_cover) {
            this.square_cover = square_cover;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }
}
