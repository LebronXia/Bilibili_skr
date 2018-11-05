package com.riane.homepage.mvp.model.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by zhengxiaobo on 2018/11/2.
 */

public class VideoDetailInfo {

    private int aid;
    private int attribute;
    private int cid;
    private CmConfigBean cm_config;
    private int copyright;
    private int ctime;
    private String desc;
    private DimensionBean dimension;
    private int dm_seg;
    private int duration;
    private String dynamic;
    private ElecBean elec;
    private OwnerBean owner;
    private OwnerExtBean owner_ext;
    private String pic;
    private PlayerIconBean player_icon;
    private int pubdate;
    private ReqUserBean req_user;
    private RightsBean rights;
    private StatBean stat;
    private int state;
    private int tid;
    private String title;
    private String tname;
    private int videos;
    private List<RelateBean> relates;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public int getAttribute() {
        return attribute;
    }

    public void setAttribute(int attribute) {
        this.attribute = attribute;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public CmConfigBean getCm_config() {
        return cm_config;
    }

    public void setCm_config(CmConfigBean cm_config) {
        this.cm_config = cm_config;
    }

    public int getCopyright() {
        return copyright;
    }

    public void setCopyright(int copyright) {
        this.copyright = copyright;
    }

    public int getCtime() {
        return ctime;
    }

    public void setCtime(int ctime) {
        this.ctime = ctime;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public DimensionBean getDimension() {
        return dimension;
    }

    public void setDimension(DimensionBean dimension) {
        this.dimension = dimension;
    }

    public int getDm_seg() {
        return dm_seg;
    }

    public void setDm_seg(int dm_seg) {
        this.dm_seg = dm_seg;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDynamic() {
        return dynamic;
    }

    public void setDynamic(String dynamic) {
        this.dynamic = dynamic;
    }

    public ElecBean getElec() {
        return elec;
    }

    public void setElec(ElecBean elec) {
        this.elec = elec;
    }

    public OwnerBean getOwner() {
        return owner;
    }

    public void setOwner(OwnerBean owner) {
        this.owner = owner;
    }

    public OwnerExtBean getOwner_ext() {
        return owner_ext;
    }

    public void setOwner_ext(OwnerExtBean owner_ext) {
        this.owner_ext = owner_ext;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public PlayerIconBean getPlayer_icon() {
        return player_icon;
    }

    public void setPlayer_icon(PlayerIconBean player_icon) {
        this.player_icon = player_icon;
    }

    public int getPubdate() {
        return pubdate;
    }

    public void setPubdate(int pubdate) {
        this.pubdate = pubdate;
    }

    public ReqUserBean getReq_user() {
        return req_user;
    }

    public void setReq_user(ReqUserBean req_user) {
        this.req_user = req_user;
    }

    public RightsBean getRights() {
        return rights;
    }

    public void setRights(RightsBean rights) {
        this.rights = rights;
    }

    public StatBean getStat() {
        return stat;
    }

    public void setStat(StatBean stat) {
        this.stat = stat;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getTid() {
        return tid;
    }

    public void setTid(int tid) {
        this.tid = tid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public int getVideos() {
        return videos;
    }

    public void setVideos(int videos) {
        this.videos = videos;
    }

    public List<RelateBean> getRelates() {
        return relates;
    }

    public void setRelates(List<RelateBean> relates) {
        this.relates = relates;
    }

    public static class CmConfigBean {
        /**
         * ads_control : {"has_danmu":0}
         */

        private AdsControlBean ads_control;

        public AdsControlBean getAds_control() {
            return ads_control;
        }

        public void setAds_control(AdsControlBean ads_control) {
            this.ads_control = ads_control;
        }

        public static class AdsControlBean {
            /**
             * has_danmu : 0
             */

            private int has_danmu;

            public int getHas_danmu() {
                return has_danmu;
            }

            public void setHas_danmu(int has_danmu) {
                this.has_danmu = has_danmu;
            }
        }
    }

    public static class DimensionBean {
        /**
         * height : 726
         * rotate : 0
         * width : 1290
         */

        private int height;
        private int rotate;
        private int width;

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getRotate() {
            return rotate;
        }

        public void setRotate(int rotate) {
            this.rotate = rotate;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }
    }

    public static class ElecBean {
        /**
         * count : 4
         * elec_set : {"elec_list":[{"elec_num":20,"is_customize":0,"title":"20电池"},{"elec_num":60,"is_customize":0,"title":"60电池"},{"elec_num":450,"is_customize":0,"title":"450电池"},{"elec_num":880,"is_customize":0,"title":"880电池"},{"elec_num":0,"is_customize":1,"max_elec":99999,"min_elec":20,"title":"自定义"}],"elec_theme":0,"integrity_rate":10,"rmb_rate":10,"round_mode":0}
         * list : [{"avatar":"http://i2.hdslb.com/bfs/face/27c97cd82ce4b3d0d80c83139ec1c3b457170201.jpg","pay_mid":166734372,"rank":1,"uname":"一朵不知名的花"},{"avatar":"http://i2.hdslb.com/bfs/face/f89994600c80dbd9e203cb98d2b1c09394145044.jpg","pay_mid":36336780,"rank":2,"uname":"附雾砂镜"},{"avatar":"http://i2.hdslb.com/bfs/face/b85fc31190a39aa793185371c797307639ce5275.jpg","pay_mid":4194362,"rank":3,"uname":"蓝天之忆"},{"avatar":"http://i2.hdslb.com/bfs/face/29648399cb2d09de3d32032af7b3c5d40347d0ab.jpg","pay_mid":19746488,"rank":4,"uname":"麦克白Macbeth"}]
         * show : true
         * total : 2420
         */

        private int count;
        private ElecSetBean elec_set;
        private boolean show;
        private int total;
        private java.util.List<ListBean> list;

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public ElecSetBean getElec_set() {
            return elec_set;
        }

        public void setElec_set(ElecSetBean elec_set) {
            this.elec_set = elec_set;
        }

        public boolean isShow() {
            return show;
        }

        public void setShow(boolean show) {
            this.show = show;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ElecSetBean {
            /**
             * elec_list : [{"elec_num":20,"is_customize":0,"title":"20电池"},{"elec_num":60,"is_customize":0,"title":"60电池"},{"elec_num":450,"is_customize":0,"title":"450电池"},{"elec_num":880,"is_customize":0,"title":"880电池"},{"elec_num":0,"is_customize":1,"max_elec":99999,"min_elec":20,"title":"自定义"}]
             * elec_theme : 0
             * integrity_rate : 10
             * rmb_rate : 10
             * round_mode : 0
             */

            private int elec_theme;
            private int integrity_rate;
            private int rmb_rate;
            private int round_mode;
            private java.util.List<ElecListBean> elec_list;

            public int getElec_theme() {
                return elec_theme;
            }

            public void setElec_theme(int elec_theme) {
                this.elec_theme = elec_theme;
            }

            public int getIntegrity_rate() {
                return integrity_rate;
            }

            public void setIntegrity_rate(int integrity_rate) {
                this.integrity_rate = integrity_rate;
            }

            public int getRmb_rate() {
                return rmb_rate;
            }

            public void setRmb_rate(int rmb_rate) {
                this.rmb_rate = rmb_rate;
            }

            public int getRound_mode() {
                return round_mode;
            }

            public void setRound_mode(int round_mode) {
                this.round_mode = round_mode;
            }

            public List<ElecListBean> getElec_list() {
                return elec_list;
            }

            public void setElec_list(List<ElecListBean> elec_list) {
                this.elec_list = elec_list;
            }

            public static class ElecListBean {
                /**
                 * elec_num : 20
                 * is_customize : 0
                 * title : 20电池
                 * max_elec : 99999
                 * min_elec : 20
                 */

                private int elec_num;
                private int is_customize;
                private String title;
                private int max_elec;
                private int min_elec;

                public int getElec_num() {
                    return elec_num;
                }

                public void setElec_num(int elec_num) {
                    this.elec_num = elec_num;
                }

                public int getIs_customize() {
                    return is_customize;
                }

                public void setIs_customize(int is_customize) {
                    this.is_customize = is_customize;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public int getMax_elec() {
                    return max_elec;
                }

                public void setMax_elec(int max_elec) {
                    this.max_elec = max_elec;
                }

                public int getMin_elec() {
                    return min_elec;
                }

                public void setMin_elec(int min_elec) {
                    this.min_elec = min_elec;
                }
            }
        }

        public static class ListBean {
            /**
             * avatar : http://i2.hdslb.com/bfs/face/27c97cd82ce4b3d0d80c83139ec1c3b457170201.jpg
             * pay_mid : 166734372
             * rank : 1
             * uname : 一朵不知名的花
             */

            private String avatar;
            private int pay_mid;
            private int rank;
            private String uname;

            public String getAvatar() {
                return avatar;
            }

            public void setAvatar(String avatar) {
                this.avatar = avatar;
            }

            public int getPay_mid() {
                return pay_mid;
            }

            public void setPay_mid(int pay_mid) {
                this.pay_mid = pay_mid;
            }

            public int getRank() {
                return rank;
            }

            public void setRank(int rank) {
                this.rank = rank;
            }

            public String getUname() {
                return uname;
            }

            public void setUname(String uname) {
                this.uname = uname;
            }
        }
    }

    public static class OwnerBean {
        /**
         * face : http://i0.hdslb.com/bfs/face/43ef1859d93a70c33474c1bb177a695263204174.gif
         * mid : 1939319
         * name : 科学超电磁炮F
         */

        private String face;
        private int mid;
        private String name;

        public String getFace() {
            return face;
        }

        public void setFace(String face) {
            this.face = face;
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
    }

    public static class OwnerExtBean {
        /**
         * archives : 166
         * assists : [595271,11391549]
         * fans : 588743
         * official_verify : {"desc":"bilibili 知名UP主","type":0}
         * vip : {"accessStatus":0,"dueRemark":"","vipDueDate":1693065600000,"vipStatus":1,"vipStatusWarn":"","vipType":2}
         */

        private int archives;
        private int fans;
        private OfficialVerifyBean official_verify;
        private VipBean vip;
        private java.util.List<Integer> assists;

        public int getArchives() {
            return archives;
        }

        public void setArchives(int archives) {
            this.archives = archives;
        }

        public int getFans() {
            return fans;
        }

        public void setFans(int fans) {
            this.fans = fans;
        }

        public OfficialVerifyBean getOfficial_verify() {
            return official_verify;
        }

        public void setOfficial_verify(OfficialVerifyBean official_verify) {
            this.official_verify = official_verify;
        }

        public VipBean getVip() {
            return vip;
        }

        public void setVip(VipBean vip) {
            this.vip = vip;
        }

        public List<Integer> getAssists() {
            return assists;
        }

        public void setAssists(List<Integer> assists) {
            this.assists = assists;
        }

        public static class OfficialVerifyBean {
            /**
             * desc : bilibili 知名UP主
             * type : 0
             */

            private String desc;
            private int type;

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }
        }

        public static class VipBean {
            /**
             * accessStatus : 0
             * dueRemark :
             * vipDueDate : 1693065600000
             * vipStatus : 1
             * vipStatusWarn :
             * vipType : 2
             */

            private int accessStatus;
            private String dueRemark;
            private long vipDueDate;
            private int vipStatus;
            private String vipStatusWarn;
            private int vipType;

            public int getAccessStatus() {
                return accessStatus;
            }

            public void setAccessStatus(int accessStatus) {
                this.accessStatus = accessStatus;
            }

            public String getDueRemark() {
                return dueRemark;
            }

            public void setDueRemark(String dueRemark) {
                this.dueRemark = dueRemark;
            }

            public long getVipDueDate() {
                return vipDueDate;
            }

            public void setVipDueDate(long vipDueDate) {
                this.vipDueDate = vipDueDate;
            }

            public int getVipStatus() {
                return vipStatus;
            }

            public void setVipStatus(int vipStatus) {
                this.vipStatus = vipStatus;
            }

            public String getVipStatusWarn() {
                return vipStatusWarn;
            }

            public void setVipStatusWarn(String vipStatusWarn) {
                this.vipStatusWarn = vipStatusWarn;
            }

            public int getVipType() {
                return vipType;
            }

            public void setVipType(int vipType) {
                this.vipType = vipType;
            }
        }
    }

    public static class PlayerIconBean {
        /**
         * ctime : 1540742400
         * hash1 : 917bd1704ecbf100f21f7a9b786d44a3
         * hash2 : b17a01d78d718f3d51ac80fe4988d46c
         * url1 : http://i0.hdslb.com/bfs/archive/b61c4429dd0a047708d69dad3c6221df37dbe9ce.json
         * url2 : http://i0.hdslb.com/bfs/archive/2634f5b0b28a2b88317927099f8efe7a08c0d670.json
         */

        private int ctime;
        private String hash1;
        private String hash2;
        private String url1;
        private String url2;

        public int getCtime() {
            return ctime;
        }

        public void setCtime(int ctime) {
            this.ctime = ctime;
        }

        public String getHash1() {
            return hash1;
        }

        public void setHash1(String hash1) {
            this.hash1 = hash1;
        }

        public String getHash2() {
            return hash2;
        }

        public void setHash2(String hash2) {
            this.hash2 = hash2;
        }

        public String getUrl1() {
            return url1;
        }

        public void setUrl1(String url1) {
            this.url1 = url1;
        }

        public String getUrl2() {
            return url2;
        }

        public void setUrl2(String url2) {
            this.url2 = url2;
        }
    }

    public static class ReqUserBean {
        /**
         * attention : -999
         * coin : 0
         * dislike : 0
         * favorite : 0
         * like : 0
         */

        private int attention;
        private int coin;
        private int dislike;
        private int favorite;
        private int like;

        public int getAttention() {
            return attention;
        }

        public void setAttention(int attention) {
            this.attention = attention;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getDislike() {
            return dislike;
        }

        public void setDislike(int dislike) {
            this.dislike = dislike;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
            this.favorite = favorite;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }
    }

    public static class RightsBean {
        /**
         * autoplay : 1
         * bp : 0
         * download : 1
         * elec : 1
         * hd5 : 1
         * movie : 0
         * no_reprint : 1
         * pay : 0
         * ugc_pay : 0
         */

        private int autoplay;
        private int bp;
        private int download;
        private int elec;
        private int hd5;
        private int movie;
        private int no_reprint;
        private int pay;
        private int ugc_pay;

        public int getAutoplay() {
            return autoplay;
        }

        public void setAutoplay(int autoplay) {
            this.autoplay = autoplay;
        }

        public int getBp() {
            return bp;
        }

        public void setBp(int bp) {
            this.bp = bp;
        }

        public int getDownload() {
            return download;
        }

        public void setDownload(int download) {
            this.download = download;
        }

        public int getElec() {
            return elec;
        }

        public void setElec(int elec) {
            this.elec = elec;
        }

        public int getHd5() {
            return hd5;
        }

        public void setHd5(int hd5) {
            this.hd5 = hd5;
        }

        public int getMovie() {
            return movie;
        }

        public void setMovie(int movie) {
            this.movie = movie;
        }

        public int getNo_reprint() {
            return no_reprint;
        }

        public void setNo_reprint(int no_reprint) {
            this.no_reprint = no_reprint;
        }

        public int getPay() {
            return pay;
        }

        public void setPay(int pay) {
            this.pay = pay;
        }

        public int getUgc_pay() {
            return ugc_pay;
        }

        public void setUgc_pay(int ugc_pay) {
            this.ugc_pay = ugc_pay;
        }
    }

    public static class StatBean {
        /**
         * aid : 34772116
         * coin : 13244
         * danmaku : 630
         * dislike : 0
         * favorite : 3994
         * his_rank : 0
         * like : 10038
         * now_rank : 0
         * reply : 521
         * share : 624
         * view : 120890
         */

        private int aid;
        private int coin;
        private int danmaku;
        private int dislike;
        private int favorite;
        private int his_rank;
        private int like;
        private int now_rank;
        private int reply;
        private int share;
        private int view;

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getCoin() {
            return coin;
        }

        public void setCoin(int coin) {
            this.coin = coin;
        }

        public int getDanmaku() {
            return danmaku;
        }

        public void setDanmaku(int danmaku) {
            this.danmaku = danmaku;
        }

        public int getDislike() {
            return dislike;
        }

        public void setDislike(int dislike) {
            this.dislike = dislike;
        }

        public int getFavorite() {
            return favorite;
        }

        public void setFavorite(int favorite) {
            this.favorite = favorite;
        }

        public int getHis_rank() {
            return his_rank;
        }

        public void setHis_rank(int his_rank) {
            this.his_rank = his_rank;
        }

        public int getLike() {
            return like;
        }

        public void setLike(int like) {
            this.like = like;
        }

        public int getNow_rank() {
            return now_rank;
        }

        public void setNow_rank(int now_rank) {
            this.now_rank = now_rank;
        }

        public int getReply() {
            return reply;
        }

        public void setReply(int reply) {
            this.reply = reply;
        }

        public int getShare() {
            return share;
        }

        public void setShare(int share) {
            this.share = share;
        }

        public int getView() {
            return view;
        }

        public void setView(int view) {
            this.view = view;
        }
    }

    public static class RelateBean{

        /**
         * ad_index : 1
         * aid : 29652209
         * card_index : 1
         * cid : 51588331
         * client_ip : 122.224.130.226
         * duration : 184
         * goto : av
         * is_ad_loc : true
         * owner : {"face":"http://i0.hdslb.com/bfs/face/43ef1859d93a70c33474c1bb177a695263204174.gif","mid":1939319,"name":"科学超电磁炮F"}
         * param : 29652209
         * pic : http://i1.hdslb.com/bfs/archive/317704fa64d6c4a2723c388007029845b2a791c4.jpg
         * request_id : 1541069391112q172a22a57a125q721
         * src_id : 2031
         * stat : {"aid":29652209,"coin":45519,"danmaku":3556,"dislike":103,"favorite":26944,"his_rank":0,"like":25529,"now_rank":0,"reply":1476,"share":14435,"view":651051}
         * title : 金闪闪国语配音李云龙
         * uri : bilibili://video/29652209?player_width=1280&player_height=720&player_rotate=0
         */

        private int ad_index;
        private int aid;
        private int card_index;
        private int cid;
        private String client_ip;
        private int duration;
        @SerializedName("goto")
        private String gotoX;
        private boolean is_ad_loc;
        private OwnerBean owner;
        private String param;
        private String pic;
        private String request_id;
        private int src_id;
        private StatBean star;
        private StatBean stat;
        private String title;
        private String uri;

        public int getAd_index() {
            return ad_index;
        }

        public void setAd_index(int ad_index) {
            this.ad_index = ad_index;
        }

        public int getAid() {
            return aid;
        }

        public void setAid(int aid) {
            this.aid = aid;
        }

        public int getCard_index() {
            return card_index;
        }

        public void setCard_index(int card_index) {
            this.card_index = card_index;
        }

        public int getCid() {
            return cid;
        }

        public void setCid(int cid) {
            this.cid = cid;
        }

        public String getClient_ip() {
            return client_ip;
        }

        public void setClient_ip(String client_ip) {
            this.client_ip = client_ip;
        }

        public int getDuration() {
            return duration;
        }

        public void setDuration(int duration) {
            this.duration = duration;
        }

        public String getGotoX() {
            return gotoX;
        }

        public void setGotoX(String gotoX) {
            this.gotoX = gotoX;
        }

        public boolean isIs_ad_loc() {
            return is_ad_loc;
        }

        public void setIs_ad_loc(boolean is_ad_loc) {
            this.is_ad_loc = is_ad_loc;
        }

        public OwnerBean getOwner() {
            return owner;
        }

        public void setOwner(OwnerBean owner) {
            this.owner = owner;
        }

        public String getParam() {
            return param;
        }

        public void setParam(String param) {
            this.param = param;
        }

        public String getPic() {
            return pic;
        }

        public void setPic(String pic) {
            this.pic = pic;
        }

        public String getRequest_id() {
            return request_id;
        }

        public void setRequest_id(String request_id) {
            this.request_id = request_id;
        }

        public int getSrc_id() {
            return src_id;
        }

        public void setSrc_id(int src_id) {
            this.src_id = src_id;
        }

        public StatBean getStat() {
            return stat;
        }

        public void setStat(StatBean stat) {
            this.stat = stat;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }
    }
}
