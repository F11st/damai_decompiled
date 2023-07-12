package com.youku.upsplayer.module;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.util.AssertUtil;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class VideoInfo {
    private String ad;
    private Domain adDomain;
    private AfterVideoInfo afterVideoStream;
    private Album album;
    private AppBuyInfo app_buy_info;
    private String bResults;
    private Cloud cloud;
    private JSONArray cmafJson;
    private Controller controller;
    private String domainController;
    private Dvd dvd;
    private PlayError error;
    private Fee fee;
    private FirstSlice firstSlice;
    private Domain hlsDomain;
    private Conf[] mConfs;
    private ConnectStat mConnectStat;
    private Sei[] mSeis;
    private Master[] master;
    private Domain mp4Domain;
    private Network network;
    private Pay pay;
    private PayScene pay_scene;
    private JSONObject playExt;
    private Playlog playlog;
    private JSONObject ppStreamConfig;
    private PreVideoInfo preVideoStream;
    private Preview preview;
    private JSONObject ps_trace;
    private SceneContent scene_content;
    private Security security;
    private Show show;
    private Stream[] stream;
    private JSONArray streamJson;
    private Stream[] stream_old;
    private Subtitle[] subtitles;
    private Ticket ticket;
    private Token token;
    private Trial trial;
    private Uploader uploader;
    private Ups ups;
    private User user;
    private Video video;
    private VideoLike videolike;
    private Videos videos;
    private Vip vip;
    private VipPayInfo vip_pay_info;
    private Watermark[] watermarks;
    private String ykAd;
    private ZPdPayInfo zpd_pay_info;

    public String getAd() {
        return this.ad;
    }

    public Domain getAdDomain() {
        return this.adDomain;
    }

    public AfterVideoInfo getAfterVideoStream() {
        return this.afterVideoStream;
    }

    public Album getAlbum() {
        AssertUtil.assertUpsV1();
        return this.album;
    }

    public AppBuyInfo getApp_buy_info() {
        AssertUtil.assertUpsV1();
        return this.app_buy_info;
    }

    public String getBResult() {
        return this.bResults;
    }

    public Cloud getCloud() {
        return this.cloud;
    }

    public JSONArray getCmafJson() {
        return this.cmafJson;
    }

    public Conf getConfs(String str) {
        Conf[] confArr = this.mConfs;
        if (confArr == null || str == null) {
            return null;
        }
        for (Conf conf : confArr) {
            if (conf != null && str.equals(conf.lang)) {
                return conf;
            }
        }
        return null;
    }

    public ConnectStat getConnectStat() {
        return this.mConnectStat;
    }

    public Controller getController() {
        return this.controller;
    }

    public String getDomainController() {
        return this.domainController;
    }

    public Dvd getDvd() {
        return this.dvd;
    }

    public PlayError getError() {
        return this.error;
    }

    public Fee getFee() {
        return this.fee;
    }

    public FirstSlice getFirstSlice() {
        return this.firstSlice;
    }

    public Domain getHlsDomain() {
        return this.hlsDomain;
    }

    public Master[] getMaster() {
        return this.master;
    }

    public Domain getMp4Domain() {
        return this.mp4Domain;
    }

    public Network getNetwork() {
        AssertUtil.assertUpsV1();
        return this.network;
    }

    public Pay getPay() {
        return this.pay;
    }

    public PayScene getPay_scene() {
        return this.pay_scene;
    }

    public JSONObject getPlayExt() {
        return this.playExt;
    }

    public Playlog getPlaylog() {
        return this.playlog;
    }

    public JSONObject getPpStreamConfig() {
        return this.ppStreamConfig;
    }

    public PreVideoInfo getPreVideoStream() {
        return this.preVideoStream;
    }

    public Preview getPreview() {
        return this.preview;
    }

    public JSONObject getPs_trace() {
        return this.ps_trace;
    }

    public SceneContent getSceneContent() {
        return this.scene_content;
    }

    public Security getSecurity() {
        return this.security;
    }

    public Sei getSei(String str) {
        Sei[] seiArr = this.mSeis;
        if (seiArr == null || str == null) {
            return null;
        }
        for (Sei sei : seiArr) {
            if (sei != null && str.equals(sei.lang)) {
                return sei;
            }
        }
        return null;
    }

    public Show getShow() {
        return this.show;
    }

    public Stream[] getStream() {
        return this.stream;
    }

    public JSONArray getStreamJson() {
        return this.streamJson;
    }

    public Stream[] getStream_old() {
        return this.stream_old;
    }

    public Subtitle[] getSubtitles() {
        return this.subtitles;
    }

    public Ticket getTicket() {
        AssertUtil.assertUpsV1();
        return this.ticket;
    }

    public Token getToken() {
        AssertUtil.assertUpsV1();
        return this.token;
    }

    public Trial getTrial() {
        return this.trial;
    }

    public Uploader getUploader() {
        return this.uploader;
    }

    public Ups getUps() {
        return this.ups;
    }

    public User getUser() {
        return this.user;
    }

    public Video getVideo() {
        return this.video;
    }

    public VideoLike getVideolike() {
        return this.videolike;
    }

    public Videos getVideos() {
        AssertUtil.assertUpsV1();
        return this.videos;
    }

    public Vip getVip() {
        return this.vip;
    }

    public VipPayInfo getVip_pay_info() {
        return this.vip_pay_info;
    }

    public Watermark[] getWatermarks() {
        return this.watermarks;
    }

    public String getYkAd() {
        return this.ykAd;
    }

    public ZPdPayInfo getZpd_pay_info() {
        AssertUtil.assertUpsV1();
        return this.zpd_pay_info;
    }

    public void setAd(String str) {
        this.ad = str;
    }

    public VideoInfo setAdDomain(Domain domain) {
        this.adDomain = domain;
        return this;
    }

    public void setAfterVideoStream(AfterVideoInfo afterVideoInfo) {
        this.afterVideoStream = afterVideoInfo;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public void setApp_buy_info(AppBuyInfo appBuyInfo) {
        this.app_buy_info = appBuyInfo;
    }

    public void setBResults(String str) {
        this.bResults = str;
    }

    public void setCloud(Cloud cloud) {
        this.cloud = cloud;
    }

    public void setCmafJson(JSONArray jSONArray) {
        this.cmafJson = jSONArray;
    }

    public void setConfs(Conf[] confArr) {
        this.mConfs = confArr;
    }

    public void setConnectStat(ConnectStat connectStat) {
        this.mConnectStat = connectStat;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void setDomainController(String str) {
        this.domainController = str;
    }

    public void setDvd(Dvd dvd) {
        this.dvd = dvd;
    }

    public void setError(PlayError playError) {
        this.error = playError;
    }

    public void setFee(Fee fee) {
        this.fee = fee;
    }

    public VideoInfo setFirstSlice(FirstSlice firstSlice) {
        this.firstSlice = firstSlice;
        return this;
    }

    public void setHlsDomain(Domain domain) {
        this.hlsDomain = domain;
    }

    public VideoInfo setMaster(Master[] masterArr) {
        this.master = masterArr;
        return this;
    }

    public void setMp4Domain(Domain domain) {
        this.mp4Domain = domain;
    }

    public void setNetwork(Network network) {
        this.network = network;
    }

    public void setPay(Pay pay) {
        this.pay = pay;
    }

    public void setPay_scene(PayScene payScene) {
        this.pay_scene = payScene;
    }

    public void setPlayExt(JSONObject jSONObject) {
        this.playExt = jSONObject;
    }

    public void setPlaylog(Playlog playlog) {
        this.playlog = playlog;
    }

    public void setPpStreamConfig(JSONObject jSONObject) {
        this.ppStreamConfig = jSONObject;
    }

    public void setPreVideoStream(PreVideoInfo preVideoInfo) {
        this.preVideoStream = preVideoInfo;
    }

    public void setPreview(Preview preview) {
        this.preview = preview;
    }

    public void setPs_trace(JSONObject jSONObject) {
        this.ps_trace = jSONObject;
    }

    public void setSceneContent(SceneContent sceneContent) {
        this.scene_content = sceneContent;
    }

    public void setSecurity(Security security) {
        this.security = security;
    }

    public void setSeis(Sei[] seiArr) {
        this.mSeis = seiArr;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    public void setStream(Stream[] streamArr) {
        this.stream = streamArr;
    }

    public void setStreamJson(JSONArray jSONArray) {
        this.streamJson = jSONArray;
    }

    public void setStream_old(Stream[] streamArr) {
        this.stream_old = streamArr;
    }

    public void setSubtitles(Subtitle[] subtitleArr) {
        this.subtitles = subtitleArr;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public void setToken(Token token) {
        this.token = token;
    }

    public void setTrial(Trial trial) {
        this.trial = trial;
    }

    public void setUploader(Uploader uploader) {
        this.uploader = uploader;
    }

    public void setUps(Ups ups) {
        this.ups = ups;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setVideo(Video video) {
        this.video = video;
    }

    public void setVideolike(VideoLike videoLike) {
        this.videolike = videoLike;
    }

    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public void setVip(Vip vip) {
        this.vip = vip;
    }

    public void setVip_pay_info(VipPayInfo vipPayInfo) {
        this.vip_pay_info = vipPayInfo;
    }

    public void setWatermarks(Watermark[] watermarkArr) {
        this.watermarks = watermarkArr;
    }

    public void setYkAd(String str) {
        this.ykAd = str;
    }

    public void setZpd_pay_info(ZPdPayInfo zPdPayInfo) {
        this.zpd_pay_info = zPdPayInfo;
    }
}
