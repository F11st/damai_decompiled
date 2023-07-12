package com.youku.upsplayer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alibaba.fastjson.parser.Feature;
import com.alipay.mobile.bqcscanservice.Constants;
import com.taobao.android.preview.DXTemplatePreviewActivity;
import com.tencent.open.miniapp.MiniApp;
import com.youku.alixplayer.config.FeatureManager;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.upsplayer.module.AfterVideoInfo;
import com.youku.upsplayer.module.Album;
import com.youku.upsplayer.module.AppBuyInfo;
import com.youku.upsplayer.module.Conf;
import com.youku.upsplayer.module.Controller;
import com.youku.upsplayer.module.Domain;
import com.youku.upsplayer.module.Dvd;
import com.youku.upsplayer.module.Fee;
import com.youku.upsplayer.module.FirstSlice;
import com.youku.upsplayer.module.Master;
import com.youku.upsplayer.module.MinVideoInfo;
import com.youku.upsplayer.module.Network;
import com.youku.upsplayer.module.Pay;
import com.youku.upsplayer.module.PayScene;
import com.youku.upsplayer.module.PlayError;
import com.youku.upsplayer.module.Playlog;
import com.youku.upsplayer.module.PreVideoInfo;
import com.youku.upsplayer.module.Preview;
import com.youku.upsplayer.module.SceneContent;
import com.youku.upsplayer.module.Security;
import com.youku.upsplayer.module.Sei;
import com.youku.upsplayer.module.Show;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.Subtitle;
import com.youku.upsplayer.module.Ticket;
import com.youku.upsplayer.module.Token;
import com.youku.upsplayer.module.Trial;
import com.youku.upsplayer.module.Uploader;
import com.youku.upsplayer.module.Ups;
import com.youku.upsplayer.module.User;
import com.youku.upsplayer.module.Video;
import com.youku.upsplayer.module.VideoCacheInfo;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.module.VideoLike;
import com.youku.upsplayer.module.Videos;
import com.youku.upsplayer.module.Vip;
import com.youku.upsplayer.module.VipPayInfo;
import com.youku.upsplayer.module.Watermark;
import com.youku.upsplayer.module.ZPdPayInfo;
import com.youku.upsplayer.util.Logger;
import com.youku.upsplayer.util.PlayStageTracker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import tb.kh1;
import tb.lu2;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ParseResult {
    public static final String TAG = "ParseResult";

    /* compiled from: Taobao */
    /* loaded from: classes3.dex */
    public static class UpsResult {
        @JSONField(name = "cost")
        public double cost;
        @JSONField(name = "data")
        public Data data = new Data();

        /* compiled from: Taobao */
        /* loaded from: classes3.dex */
        public static class Data {
            @JSONField(name = PluginName.AD)
            public String ad;
            @JSONField(name = "adDomain")
            public Domain adDomain;
            @JSONField(name = "afterVideoStream")
            public AfterVideoInfo afterVideoStream;
            @JSONField(name = Constants.EXT_INFO_VALUE_STOP_REASON_ALBUM)
            public Album album;
            @JSONField(name = "app_buy_info")
            public AppBuyInfo app_buy_info;
            @JSONField(name = "bresults")
            public String bResults;
            @JSONField(name = "cmj")
            public JSONArray cmafJson;
            @JSONField(name = "conf")
            public Conf[] confs;
            @JSONField(name = "controller")
            public Controller controller;
            @JSONField(name = "domain")
            public Domain domain;
            @JSONField(name = "domain_controller")
            public String domainController;
            @JSONField(name = "dvd")
            public Dvd dvd;
            @JSONField(name = "error")
            public PlayError error;
            @JSONField(name = "fee")
            public Fee fee;
            @JSONField(name = "hlsDomain")
            public Domain hlsDomain;
            @JSONField(name = "fs")
            public FirstSlice hlsFirstSlices;
            @JSONField(name = "master")
            public Master[] masters;
            @JSONField(name = "mp4Domain")
            public Domain mp4Domain;
            @JSONField(name = "network")
            public Network network;
            @JSONField(name = "pay")
            public Pay pay;
            @JSONField(name = "pay_scene")
            public PayScene pay_scene;
            @JSONField(name = "play_ext")
            public JSONObject play_ext;
            @JSONField(name = "playlog")
            public Playlog playlog;
            @JSONField(name = "ppStreamConfig")
            public JSONObject ppStreamConfig;
            @JSONField(name = "preVideoStream")
            public PreVideoInfo preVideoStream;
            @JSONField(name = DXTemplatePreviewActivity.PREVIEW_DINAMIC_MODULE)
            public Preview preview;
            @JSONField(name = "ps_trace")
            public JSONObject ps_trace;
            @JSONField(name = "scene_content")
            public SceneContent scene_content;
            @JSONField(name = "security")
            public Security security;
            @JSONField(name = "sei")
            public Sei[] seis;
            @JSONField(name = "show")
            public Show show;
            @JSONField(name = kh1.RESOURCE_STREAM)
            public JSONArray stream;
            @JSONField(name = "stream_old")
            public Stream[] stream_old;
            @JSONField(name = FeatureManager.FEATURE_KEY_SUBTITLE)
            public Subtitle[] subtitles;
            @JSONField(name = "ticket")
            public Ticket ticket;
            @JSONField(name = "token")
            public Token token;
            @JSONField(name = MiniApp.MINIAPP_VERSION_TRIAL)
            public Trial trial;
            @JSONField(name = "uploader")
            public Uploader uploader;
            @JSONField(name = "ups")
            public Ups ups;
            @JSONField(name = "user")
            public User user;
            @JSONField(name = "video")
            public Video video;
            @JSONField(name = "videolike")
            public VideoLike videolike;
            @JSONField(name = "videos")
            public Videos videos;
            @JSONField(name = "vip")
            public Vip vip;
            @JSONField(name = "vip_pay_info")
            public VipPayInfo vip_pay_info;
            @JSONField(name = FeatureManager.FEATURE_KEY_WATERMARK)
            public Watermark[] watermarks;
            @JSONField(name = "ykad")
            public String ykAd;
            @JSONField(name = "zpd_pay_info")
            public ZPdPayInfo zpd_pay_info;
        }

        public void apply(VideoInfo videoInfo) {
            videoInfo.setError(this.data.error);
            videoInfo.setUps(this.data.ups);
            videoInfo.setVideo(this.data.video);
            videoInfo.setStreamJson(this.data.stream);
            videoInfo.setStream_old(this.data.stream_old);
            videoInfo.setShow(this.data.show);
            videoInfo.setFee(this.data.fee);
            videoInfo.setDvd(this.data.dvd);
            videoInfo.setVideos(this.data.videos);
            videoInfo.setTrial(this.data.trial);
            videoInfo.setUser(this.data.user);
            videoInfo.setVip(this.data.vip);
            videoInfo.setTicket(this.data.ticket);
            videoInfo.setUploader(this.data.uploader);
            videoInfo.setPreview(this.data.preview);
            videoInfo.setPay_scene(this.data.pay_scene);
            videoInfo.setAlbum(this.data.album);
            videoInfo.setToken(this.data.token);
            videoInfo.setController(this.data.controller);
            videoInfo.setNetwork(this.data.network);
            videoInfo.setPlaylog(this.data.playlog);
            videoInfo.setPay(this.data.pay);
            videoInfo.setVideolike(this.data.videolike);
            videoInfo.setVip_pay_info(this.data.vip_pay_info);
            videoInfo.setZpd_pay_info(this.data.zpd_pay_info);
            videoInfo.setApp_buy_info(this.data.app_buy_info);
            videoInfo.setSceneContent(this.data.scene_content);
            videoInfo.setAd(this.data.ad);
            videoInfo.setSecurity(this.data.security);
            videoInfo.setPreVideoStream(this.data.preVideoStream);
            videoInfo.setAfterVideoStream(this.data.afterVideoStream);
            videoInfo.setSubtitles(this.data.subtitles);
            videoInfo.setMaster(this.data.masters);
            videoInfo.setFirstSlice(this.data.hlsFirstSlices);
            videoInfo.setAdDomain(this.data.adDomain);
            videoInfo.setHlsDomain(this.data.hlsDomain);
            videoInfo.setMp4Domain(this.data.mp4Domain);
            videoInfo.setDomainController(this.data.domainController);
            videoInfo.setYkAd(this.data.ykAd);
            videoInfo.setWatermarks(this.data.watermarks);
            videoInfo.setPlayExt(this.data.play_ext);
            videoInfo.setBResults(this.data.bResults);
            videoInfo.setSeis(this.data.seis);
            videoInfo.setConfs(this.data.confs);
            videoInfo.setCmafJson(this.data.cmafJson);
            videoInfo.setPpStreamConfig(this.data.ppStreamConfig);
            videoInfo.setPs_trace(this.data.ps_trace);
        }
    }

    public static VideoInfo parse(String str) {
        VideoInfo videoInfo = new VideoInfo();
        try {
            return parseJson1(str);
        } catch (Exception e) {
            e.printStackTrace();
            return videoInfo;
        }
    }

    protected static <T> T parse(JSONObject jSONObject, Class<T> cls) {
        if (jSONObject != null) {
            return (T) JSON.parseObject(jSONObject.toString(), (Class<Object>) cls, Feature.IgnoreNotMatch);
        }
        throw new JSONException("");
    }

    public static <T> T[] parseArray(JSONArray jSONArray, Class<T> cls, T[] tArr) {
        if (jSONArray == null || jSONArray.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < jSONArray.size(); i++) {
            arrayList.add(parse(jSONArray.getJSONObject(i), cls));
        }
        return (T[]) arrayList.toArray(tArr);
    }

    public static VideoInfo parseData(String str) {
        VideoInfo videoInfo = new VideoInfo();
        try {
            return parseJson1(str);
        } catch (Exception e) {
            e.printStackTrace();
            return videoInfo;
        }
    }

    public static VideoInfo parseJson1(String str) {
        VideoInfo videoInfo = new VideoInfo();
        PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
        upsRequest.beginSection("parseJson");
        upsRequest.endSection();
        ((UpsResult) JSON.parseObject(str, UpsResult.class)).apply(videoInfo);
        return videoInfo;
    }

    public static VideoInfo parseJson2(String str) {
        VideoInfo videoInfo = new VideoInfo();
        PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
        upsRequest.beginSection("parseJson2");
        JSONObject jSONObject = JSON.parseObject(str).getJSONObject("data");
        videoInfo.setError((PlayError) parse(jSONObject.getJSONObject("error"), PlayError.class));
        videoInfo.setUps((Ups) parse(jSONObject.getJSONObject("ups"), Ups.class));
        videoInfo.setVideo((Video) parse(jSONObject.getJSONObject("video"), Video.class));
        videoInfo.setStreamJson(jSONObject.getJSONArray(kh1.RESOURCE_STREAM));
        videoInfo.setShow((Show) parse(jSONObject.getJSONObject("show"), Show.class));
        videoInfo.setFee((Fee) parse(jSONObject.getJSONObject("fee"), Fee.class));
        videoInfo.setDvd((Dvd) parse(jSONObject.getJSONObject("dvd"), Dvd.class));
        videoInfo.setVideos((Videos) parse(jSONObject.getJSONObject("videos"), Videos.class));
        videoInfo.setTrial((Trial) parse(jSONObject.getJSONObject(MiniApp.MINIAPP_VERSION_TRIAL), Trial.class));
        videoInfo.setUser((User) parse(jSONObject.getJSONObject("user"), User.class));
        videoInfo.setVip((Vip) parse(jSONObject.getJSONObject("vip"), Vip.class));
        videoInfo.setTicket((Ticket) parse(jSONObject.getJSONObject("ticket"), Ticket.class));
        videoInfo.setUploader((Uploader) parse(jSONObject.getJSONObject("uploader"), Uploader.class));
        videoInfo.setPreview((Preview) parse(jSONObject.getJSONObject(DXTemplatePreviewActivity.PREVIEW_DINAMIC_MODULE), Preview.class));
        videoInfo.setPay_scene((PayScene) parse(jSONObject.getJSONObject("pay_scene"), PayScene.class));
        videoInfo.setAlbum((Album) parse(jSONObject.getJSONObject(Constants.EXT_INFO_VALUE_STOP_REASON_ALBUM), Album.class));
        videoInfo.setToken((Token) parse(jSONObject.getJSONObject("token"), Token.class));
        videoInfo.setController((Controller) parse(jSONObject.getJSONObject("controller"), Controller.class));
        videoInfo.setNetwork((Network) parse(jSONObject.getJSONObject("network"), Network.class));
        videoInfo.setPlaylog((Playlog) parse(jSONObject.getJSONObject("playlog"), Playlog.class));
        videoInfo.setPay((Pay) parse(jSONObject.getJSONObject("pay"), Pay.class));
        videoInfo.setVideolike((VideoLike) parse(jSONObject.getJSONObject("videolike"), VideoLike.class));
        videoInfo.setVip_pay_info((VipPayInfo) parse(jSONObject.getJSONObject("vip_pay_info"), VipPayInfo.class));
        videoInfo.setZpd_pay_info((ZPdPayInfo) parse(jSONObject.getJSONObject("zpd_pay_info"), ZPdPayInfo.class));
        videoInfo.setApp_buy_info((AppBuyInfo) parse(jSONObject.getJSONObject("app_buy_info"), AppBuyInfo.class));
        videoInfo.setSceneContent((SceneContent) parse(jSONObject.getJSONObject("scene_content"), SceneContent.class));
        videoInfo.setAd(jSONObject.getString(PluginName.AD));
        videoInfo.setSecurity((Security) parse(jSONObject.getJSONObject("security"), Security.class));
        videoInfo.setPreVideoStream((PreVideoInfo) parse(jSONObject.getJSONObject("preVideoStream"), PreVideoInfo.class));
        videoInfo.setAfterVideoStream((AfterVideoInfo) parse(jSONObject.getJSONObject("afterVideoStream"), AfterVideoInfo.class));
        videoInfo.setSubtitles((Subtitle[]) parseArray(jSONObject.getJSONArray(FeatureManager.FEATURE_KEY_SUBTITLE), Subtitle.class, new Subtitle[0]));
        videoInfo.setWatermarks((Watermark[]) parseArray(jSONObject.getJSONArray(FeatureManager.FEATURE_KEY_WATERMARK), Watermark.class, new Watermark[0]));
        videoInfo.setMaster((Master[]) parseArray(jSONObject.getJSONArray("master"), Master.class, new Master[0]));
        videoInfo.setFirstSlice((FirstSlice) parse(jSONObject.getJSONObject("fs"), FirstSlice.class));
        videoInfo.setPlayExt(jSONObject.getJSONObject("play_ext"));
        upsRequest.endSection();
        return videoInfo;
    }

    public static List<MinVideoInfo> parseMulFirstSliceJSon(String str) {
        Logger.d("UpsPlayer", "MIN VIDEO:" + str);
        ArrayList arrayList = new ArrayList();
        JSONArray jSONArray = JSON.parseObject(str).getJSONArray("data");
        for (int i = 0; i < jSONArray.size(); i++) {
            JSONObject jSONObject = (JSONObject) jSONArray.get(i);
            MinVideoInfo minVideoInfo = new MinVideoInfo();
            int intValue = jSONObject.getInteger("errorCode").intValue();
            minVideoInfo.setErrCode(intValue);
            minVideoInfo.setVid(jSONObject.getString("vid"));
            minVideoInfo.setShowId(jSONObject.getString("showId"));
            minVideoInfo.setVideoStr(jSONObject.getString("video"));
            if (intValue == 0) {
                minVideoInfo.setDuration(jSONObject.getLong("duration") == null ? 0L : jSONObject.getLong("duration").longValue());
                minVideoInfo.setHasHead(jSONObject.getBoolean("hasHead") == null ? false : jSONObject.getBoolean("hasHead").booleanValue());
                minVideoInfo.setTitle(jSONObject.getString("title"));
                minVideoInfo.setFirstSlicesInfo((FirstSlice) parseSafety(jSONObject.getJSONObject("firstSlice"), FirstSlice.class));
                minVideoInfo.setEncryptR_server(jSONObject.getString("encryptR_server"));
                minVideoInfo.setCopyrightKey(jSONObject.getString("copyright_key"));
                minVideoInfo.setHdrFeature(jSONObject.getBoolean("hdrFeature") == null ? false : jSONObject.getBoolean("hdrFeature").booleanValue());
                minVideoInfo.setSubTitle(jSONObject.getBoolean("subTitle").booleanValue());
                if (jSONObject.getBoolean("hasZreal") != null) {
                    minVideoInfo.setHasZreal(jSONObject.getBoolean("hasZreal").booleanValue());
                }
                JSONObject jSONObject2 = jSONObject.getJSONObject("sei");
                if (jSONObject2 != null) {
                    Sei sei = null;
                    try {
                        sei = (Sei) parse(jSONObject2, Sei.class);
                    } catch (Exception unused) {
                    }
                    minVideoInfo.setSei(sei);
                }
            }
            arrayList.add(minVideoInfo);
        }
        return arrayList;
    }

    public static List<VideoCacheInfo> parseMulUPSJSon(String str) {
        Logger.d("UpsPlayer", "UPS MulTiJSON:" + str);
        String string = JSON.parseObject(str).getString("data");
        ArrayList arrayList = new ArrayList();
        JSONArray parseArray = JSON.parseArray(string);
        for (int i = 0; i < parseArray.size(); i++) {
            JSONObject jSONObject = (JSONObject) parseArray.get(i);
            VideoCacheInfo videoCacheInfo = new VideoCacheInfo();
            videoCacheInfo.videoInfoStr = jSONObject.getString(lu2.MAIN);
            videoCacheInfo.cacheKey = jSONObject.getString("cc_key");
            videoCacheInfo.langeCode = jSONObject.getString("langCode");
            JSONObject jSONObject2 = jSONObject.getJSONObject("v_msgcode");
            if (jSONObject2 != null) {
                videoCacheInfo.errorCode = jSONObject2.getString("code");
                videoCacheInfo.errorMsg = jSONObject2.getString("note");
            }
            arrayList.add(videoCacheInfo);
        }
        return arrayList;
    }

    public static List<SimpleVideoInfo> parseMultiJSon(String str) {
        ArrayList arrayList = new ArrayList();
        JSONObject jSONObject = JSON.parseObject(str).getJSONObject("data");
        for (String str2 : jSONObject.keySet()) {
            SimpleVideoInfo simpleVideoInfo = new SimpleVideoInfo();
            simpleVideoInfo.setVid(str2);
            simpleVideoInfo.setVideoDomain((Domain) parseSafety(jSONObject.getJSONObject(str2).getJSONObject("domain"), Domain.class));
            simpleVideoInfo.setStream((Stream) parseSafety(jSONObject.getJSONObject(str2).getJSONObject(kh1.RESOURCE_STREAM), Stream.class));
            simpleVideoInfo.setWatermarks((Watermark[]) parseArray(jSONObject.getJSONObject(str2).getJSONArray(FeatureManager.FEATURE_KEY_WATERMARK), Watermark.class, new Watermark[0]));
            JSONObject jSONObject2 = jSONObject.getJSONObject(str2).getJSONObject(MiniApp.MINIAPP_VERSION_TRIAL);
            if (jSONObject2 != null) {
                simpleVideoInfo.setTrial((Map) parse(jSONObject2, Map.class));
            }
            simpleVideoInfo.setNode(jSONObject.getJSONObject(str2).getString("note"));
            simpleVideoInfo.setCode(jSONObject.getJSONObject(str2).getInteger("code"));
            simpleVideoInfo.setRawData(jSONObject.getString(str2));
            arrayList.add(simpleVideoInfo);
        }
        return arrayList;
    }

    protected static <T> T parseSafety(JSONObject jSONObject, Class<T> cls) {
        if (jSONObject == null) {
            return null;
        }
        return (T) JSON.parseObject(jSONObject.toString(), (Class<Object>) cls, Feature.IgnoreNotMatch);
    }

    public static Stream[] parseStream(JSONArray jSONArray) {
        if (jSONArray == null) {
            return null;
        }
        int size = jSONArray.size();
        Stream[] streamArr = new Stream[size];
        for (int i = 0; i < size; i++) {
            streamArr[i] = (Stream) ((JSONObject) jSONArray.get(i)).toJavaObject(Stream.class);
        }
        return streamArr;
    }
}
