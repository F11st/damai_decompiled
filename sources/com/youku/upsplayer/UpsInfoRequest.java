package com.youku.upsplayer;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.orange.OConstant;
import com.taobao.weex.common.Constants;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainFactory;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.IUpsInfoRequest;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.data.GetInfoResult;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.Stream;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.ErrorConstants;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.request.PlayVideoInfo;
import com.youku.upsplayer.util.Logger;
import com.youku.upsplayer.util.PlayStageTracker;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.vpm.constants.TableField;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsInfoRequest implements IUpsInfoRequest {
    public static final String API_NAME_DEFAULT = "mtop.youku.play.ups.appinfo.get";
    public static final String API_VERSION_DEFAULT = "1.1";
    public static final String HOST_DEFAULT = "http://ups.youku.com";
    public static final boolean NEED_ECODE_DEFAULT = true;
    public static final String TAG = "UpsInfoRequest";
    public static final String UPS_PATH = "/ups/get.json?";
    private static final String UPS_WEB_ANTI = "yk_web_anti_flow_limit_captcha_20171111";
    private static final String UPS_WEB_FLOW_LIMIT = "yk_web_anti_flow_limit_wait_20171111";
    protected final int CONNECT_TIMEOUT;
    private Runnable GetInfoRunnable;
    protected final int READ_TIMEOUT;
    private String host;
    private String ip;
    private Map<String, String> mAdParams;
    private String mApiName;
    private String mApiVersion;
    private IUpsInfoRequest.IUpsInfoRequestCallback mCallBack;
    private Context mContext;
    public String mHost;
    private boolean mIsExternal;
    private boolean mNeedEcode;
    private NetworkParameter mNetwork;
    protected INetworkTask mNetworkTask;
    private Map<String, String> mParams;
    private PlayVideoInfo mPlayVideoInfo;
    private RequestData request;
    private static Set<String> sEncodeParams = new HashSet<String>() { // from class: com.youku.upsplayer.UpsInfoRequest.1
        {
            add(IRequestConst.MDL);
            add("device_brand");
            add(IRequestConst.OSV);
            add("ua");
        }
    };
    private static ExecutorService mWorker = Executors.newCachedThreadPool();

    public UpsInfoRequest(Context context, INetworkTask iNetworkTask) {
        this(context, iNetworkTask, false);
    }

    public UpsInfoRequest(Context context, INetworkTask iNetworkTask, boolean z) {
        this.mApiName = "mtop.youku.play.ups.appinfo.get";
        this.mApiVersion = "1.1";
        this.mNeedEcode = true;
        this.mHost = "http://ups.youku.com";
        this.CONNECT_TIMEOUT = 15000;
        this.READ_TIMEOUT = 15000;
        this.request = null;
        this.GetInfoRunnable = new Runnable() { // from class: com.youku.upsplayer.UpsInfoRequest.2
            @Override // java.lang.Runnable
            public void run() {
                UpsInfoRequest.this.request.upsTimeTraceBean = new UpsTimeTraceBean();
                UpsInfoRequest.this.request.upsTimeTraceBean.startTrace();
                try {
                    if (TextUtils.isEmpty(UpsInfoRequest.this.mPlayVideoInfo.ckey)) {
                        PlayVideoInfo playVideoInfo = UpsInfoRequest.this.mPlayVideoInfo;
                        UpsInfoRequest upsInfoRequest = UpsInfoRequest.this;
                        playVideoInfo.ckey = upsInfoRequest.getCkey(upsInfoRequest.mPlayVideoInfo);
                    }
                    UpsInfoRequest upsInfoRequest2 = UpsInfoRequest.this;
                    String url = upsInfoRequest2.getUrl(upsInfoRequest2.mPlayVideoInfo);
                    UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeGetCkey();
                    if (TextUtils.isEmpty(url)) {
                        Logger.d(UpsInfoRequest.TAG, "invalid url");
                        UpsInfoRequest.this.mCallBack.onFailure(new IUpsInfoRequest.UpsRequestError(28001, "invalid url", UpsInfoRequest.this.request));
                        return;
                    }
                    Logger.d("UpsPlayer", "ups url=" + url);
                    UpsInfoRequest.this.request.url = url;
                    UpsInfoRequest.this.request.mTopUpsRequest = UpsInfoRequest.this.getMTopUpsResquest();
                    UpsInfoRequest.this.request.upsType = 1;
                    UpsInfoRequest.this.request.host = UpsInfoRequest.this.host;
                    UpsInfoRequest.this.request.ip = UpsInfoRequest.this.ip;
                    if (UpsInfoRequest.this.mNetwork != null) {
                        UpsInfoRequest.this.request.cookie = UpsInfoRequest.this.mNetwork.cookie;
                        UpsInfoRequest.this.request.agent = UpsInfoRequest.this.mNetwork.userAgent;
                        UpsInfoRequest.this.request.connect_timeout = UpsInfoRequest.this.mNetwork.connect_timeout;
                        UpsInfoRequest.this.request.read_timeout = UpsInfoRequest.this.mNetwork.read_timeout;
                    }
                    if (UpsInfoRequest.this.request.connect_timeout == 0) {
                        UpsInfoRequest.this.request.connect_timeout = 15000;
                    }
                    if (UpsInfoRequest.this.request.read_timeout == 0) {
                        UpsInfoRequest.this.request.read_timeout = 15000;
                    }
                    Logger.d(UpsInfoRequest.TAG, "run start");
                    PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
                    upsRequest.beginSection("apiRequest");
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeStartRequest();
                    }
                    UpsInfoRequest upsInfoRequest3 = UpsInfoRequest.this;
                    GetInfoResult data = upsInfoRequest3.mNetworkTask.getData(upsInfoRequest3.request);
                    upsRequest.endSection();
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeStartParseResult();
                    }
                    VideoInfo processData = UpsInfoRequest.this.processData(data);
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeEndParse();
                        Logger.d("UpsPlayer", UpsInfoRequest.this.request.vid + " total ups parse cost:" + UpsInfoRequest.this.request.upsTimeTraceBean.timeEndParse + "; compress:" + UpsInfoRequest.this.request.compress);
                    }
                    if (processData != null) {
                        UpsInfoRequest.this.setAntiTheftUtData(processData, data);
                    }
                    Logger.d("UpsPlayer", "call back result");
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        data.connectStat.mUpsTimeTraceBean = UpsInfoRequest.this.request.upsTimeTraceBean;
                        data.connectStat.rawUpsData = data.data;
                    }
                    UpsInfoRequest.this.mCallBack.onSuccess(processData, data.connectStat);
                    Logger.d(UpsInfoRequest.TAG, "run finish");
                } catch (AntiTheftChainException e) {
                    UpsInfoRequest.this.mCallBack.onFailure(new IUpsInfoRequest.UpsRequestError(e.getErrorCode(), "ckey构建失败：" + e.getMessage(), UpsInfoRequest.this.request));
                }
            }
        };
        this.mContext = context;
        this.mNetworkTask = iNetworkTask;
        this.mIsExternal = z;
    }

    public UpsInfoRequest(Context context, INetworkTask iNetworkTask, boolean z, String str, String str2) {
        this.mApiName = "mtop.youku.play.ups.appinfo.get";
        this.mApiVersion = "1.1";
        this.mNeedEcode = true;
        this.mHost = "http://ups.youku.com";
        this.CONNECT_TIMEOUT = 15000;
        this.READ_TIMEOUT = 15000;
        this.request = null;
        this.GetInfoRunnable = new Runnable() { // from class: com.youku.upsplayer.UpsInfoRequest.2
            @Override // java.lang.Runnable
            public void run() {
                UpsInfoRequest.this.request.upsTimeTraceBean = new UpsTimeTraceBean();
                UpsInfoRequest.this.request.upsTimeTraceBean.startTrace();
                try {
                    if (TextUtils.isEmpty(UpsInfoRequest.this.mPlayVideoInfo.ckey)) {
                        PlayVideoInfo playVideoInfo = UpsInfoRequest.this.mPlayVideoInfo;
                        UpsInfoRequest upsInfoRequest = UpsInfoRequest.this;
                        playVideoInfo.ckey = upsInfoRequest.getCkey(upsInfoRequest.mPlayVideoInfo);
                    }
                    UpsInfoRequest upsInfoRequest2 = UpsInfoRequest.this;
                    String url = upsInfoRequest2.getUrl(upsInfoRequest2.mPlayVideoInfo);
                    UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeGetCkey();
                    if (TextUtils.isEmpty(url)) {
                        Logger.d(UpsInfoRequest.TAG, "invalid url");
                        UpsInfoRequest.this.mCallBack.onFailure(new IUpsInfoRequest.UpsRequestError(28001, "invalid url", UpsInfoRequest.this.request));
                        return;
                    }
                    Logger.d("UpsPlayer", "ups url=" + url);
                    UpsInfoRequest.this.request.url = url;
                    UpsInfoRequest.this.request.mTopUpsRequest = UpsInfoRequest.this.getMTopUpsResquest();
                    UpsInfoRequest.this.request.upsType = 1;
                    UpsInfoRequest.this.request.host = UpsInfoRequest.this.host;
                    UpsInfoRequest.this.request.ip = UpsInfoRequest.this.ip;
                    if (UpsInfoRequest.this.mNetwork != null) {
                        UpsInfoRequest.this.request.cookie = UpsInfoRequest.this.mNetwork.cookie;
                        UpsInfoRequest.this.request.agent = UpsInfoRequest.this.mNetwork.userAgent;
                        UpsInfoRequest.this.request.connect_timeout = UpsInfoRequest.this.mNetwork.connect_timeout;
                        UpsInfoRequest.this.request.read_timeout = UpsInfoRequest.this.mNetwork.read_timeout;
                    }
                    if (UpsInfoRequest.this.request.connect_timeout == 0) {
                        UpsInfoRequest.this.request.connect_timeout = 15000;
                    }
                    if (UpsInfoRequest.this.request.read_timeout == 0) {
                        UpsInfoRequest.this.request.read_timeout = 15000;
                    }
                    Logger.d(UpsInfoRequest.TAG, "run start");
                    PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
                    upsRequest.beginSection("apiRequest");
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeStartRequest();
                    }
                    UpsInfoRequest upsInfoRequest3 = UpsInfoRequest.this;
                    GetInfoResult data = upsInfoRequest3.mNetworkTask.getData(upsInfoRequest3.request);
                    upsRequest.endSection();
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeStartParseResult();
                    }
                    VideoInfo processData = UpsInfoRequest.this.processData(data);
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        UpsInfoRequest.this.request.upsTimeTraceBean.traceTimeEndParse();
                        Logger.d("UpsPlayer", UpsInfoRequest.this.request.vid + " total ups parse cost:" + UpsInfoRequest.this.request.upsTimeTraceBean.timeEndParse + "; compress:" + UpsInfoRequest.this.request.compress);
                    }
                    if (processData != null) {
                        UpsInfoRequest.this.setAntiTheftUtData(processData, data);
                    }
                    Logger.d("UpsPlayer", "call back result");
                    if (UpsInfoRequest.this.request != null && UpsInfoRequest.this.request.upsTimeTraceBean != null) {
                        data.connectStat.mUpsTimeTraceBean = UpsInfoRequest.this.request.upsTimeTraceBean;
                        data.connectStat.rawUpsData = data.data;
                    }
                    UpsInfoRequest.this.mCallBack.onSuccess(processData, data.connectStat);
                    Logger.d(UpsInfoRequest.TAG, "run finish");
                } catch (AntiTheftChainException e) {
                    UpsInfoRequest.this.mCallBack.onFailure(new IUpsInfoRequest.UpsRequestError(e.getErrorCode(), "ckey构建失败：" + e.getMessage(), UpsInfoRequest.this.request));
                }
            }
        };
        this.mContext = context;
        this.mNetworkTask = iNetworkTask;
        this.mIsExternal = z;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (str.endsWith("/")) {
            String str3 = this.host;
            str = str3.substring(0, str3.length() - 1);
        }
        this.mHost = str;
        this.host = Uri.parse(str).getHost();
        this.ip = str2;
    }

    private void addParam(StringBuilder sb, PlayVideoInfo playVideoInfo) {
        String str = playVideoInfo.ckey;
        addParam(sb, "ckey", decode(str));
        String encode = encode(playVideoInfo.utid);
        RequestData requestData = this.request;
        requestData.ckey = str;
        requestData.utid = encode(encode);
        RequestData requestData2 = this.request;
        requestData2.vid = playVideoInfo.vid;
        requestData2.ccode = playVideoInfo.ccode;
        requestData2.clientid = playVideoInfo.client_id;
        addParam(sb, RequestParams.client_ip, playVideoInfo.client_ip);
        addParam(sb, RequestParams.client_ts, playVideoInfo.client_ts);
        addParam(sb, RequestParams.utid, playVideoInfo.utid);
        addParam(sb, "vid", playVideoInfo.vid);
        addParam(sb, "ccode", playVideoInfo.ccode);
        addParam(sb, "showid", playVideoInfo.showid);
        addParam(sb, "show_videoseq", playVideoInfo.show_videoseq);
        addParam(sb, "playlist_id", playVideoInfo.playlist_id);
        addParam(sb, "playlist_videoseq", playVideoInfo.playlist_videoseq);
        addParam(sb, "h265", playVideoInfo.h265);
        addParam(sb, "point", playVideoInfo.point);
        addParam(sb, "language", playVideoInfo.language);
        addParam(sb, "audiolang", playVideoInfo.audiolang);
        addParam(sb, AdUtConstants.XAD_UT_ARG_MEDIA_TYPE, playVideoInfo.media_type);
        addParam(sb, Constants.Value.PASSWORD, playVideoInfo.password);
        addParam(sb, "client_id", playVideoInfo.client_id);
        if (!TextUtils.isEmpty(playVideoInfo.local_vid)) {
            addParam(sb, "local_vid", playVideoInfo.local_vid);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_time)) {
            addParam(sb, "local_time", playVideoInfo.local_time);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_point)) {
            addParam(sb, "local_point", playVideoInfo.local_point);
        }
        if (!TextUtils.isEmpty(playVideoInfo.yktk)) {
            addParam(sb, CookieUtil.COOKIE_KEY_YKTK, playVideoInfo.yktk);
        }
        if (!TextUtils.isEmpty(playVideoInfo.stoken)) {
            addParam(sb, IRequestConst.STOKEN, playVideoInfo.stoken);
        }
        if (!TextUtils.isEmpty(playVideoInfo.ptoken)) {
            addParam(sb, "ptoken", playVideoInfo.ptoken);
        }
        if (!TextUtils.isEmpty(playVideoInfo.src)) {
            addParam(sb, "src", playVideoInfo.src);
        }
        if (!TextUtils.isEmpty(playVideoInfo.tq)) {
            addParam(sb, "tq", playVideoInfo.tq);
        }
        addParam(sb, "mac", playVideoInfo.mac);
        addParam(sb, "network", playVideoInfo.network);
        addParam(sb, "brand", playVideoInfo.brand);
        addParam(sb, OConstant.CANDIDATE_OSVER, playVideoInfo.os_ver);
        addParam(sb, "app_ver", playVideoInfo.app_ver);
        if (!TextUtils.isEmpty(playVideoInfo.encryptR_client)) {
            addParam(sb, "encryptR_client", playVideoInfo.encryptR_client);
        }
        if (!TextUtils.isEmpty(playVideoInfo.key_index)) {
            addParam(sb, "key_index", playVideoInfo.key_index);
        }
        addParam(sb, "d_type", playVideoInfo.d_type);
        addParam(sb, "drm_type", playVideoInfo.drm_type);
        if (!TextUtils.isEmpty(playVideoInfo.psid)) {
            addParam(sb, TableField.PS_ID, playVideoInfo.psid);
        }
        if (!TextUtils.isEmpty(playVideoInfo.qxd)) {
            addParam(sb, "qxd", playVideoInfo.qxd);
        }
        if (!TextUtils.isEmpty(playVideoInfo.play_ability)) {
            addParam(sb, "play_ability", playVideoInfo.play_ability);
        }
        if (!TextUtils.isEmpty(playVideoInfo.play_scene)) {
            addParam(sb, "play_scene", playVideoInfo.play_scene);
        }
        if (!TextUtils.isEmpty(playVideoInfo.plic_source)) {
            addParam(sb, "source", playVideoInfo.plic_source);
        }
        if (!TextUtils.isEmpty(playVideoInfo.decode_ability)) {
            addParam(sb, "decode_ability", playVideoInfo.decode_ability);
        }
        if (!TextUtils.isEmpty(playVideoInfo.censor)) {
            addParam(sb, "censor", playVideoInfo.censor);
        }
        addParam(sb, "btype", Build.getMODEL());
        if (playVideoInfo.ccode.equals("01010301") && !TextUtils.isEmpty(playVideoInfo.p_device)) {
            addParam(sb, "p_device", playVideoInfo.p_device);
        }
        addParam(sb, "vv_id", playVideoInfo.vv_id);
        addParam(sb, "vid_src", playVideoInfo.vid_src);
        addParam(sb, "ext_showid", playVideoInfo.ext_showid);
    }

    private void addParam(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(encode(str2));
        }
        sb.append("&");
    }

    private void addParamWithoutEncode(StringBuilder sb, String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        sb.append(str);
        sb.append("=");
        if (!TextUtils.isEmpty(str2)) {
            sb.append(str2);
        }
        sb.append("&");
    }

    private void constructParams(MTopUpsRequest mTopUpsRequest, PlayVideoInfo playVideoInfo) {
        mTopUpsRequest.stealParamsMap.put("ckey", decode(playVideoInfo.ckey));
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ip, playVideoInfo.client_ip);
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ts, playVideoInfo.client_ts);
        mTopUpsRequest.stealParamsMap.put(RequestParams.utid, playVideoInfo.utid);
        mTopUpsRequest.stealParamsMap.put("vid", playVideoInfo.vid);
        mTopUpsRequest.stealParamsMap.put("ccode", playVideoInfo.ccode);
        if (playVideoInfo.ccode.equals("01010301") && !TextUtils.isEmpty(playVideoInfo.p_device)) {
            mTopUpsRequest.stealParamsMap.put("p_device", encode(playVideoInfo.p_device));
        }
        mTopUpsRequest.bizParamsMap.put("showid", playVideoInfo.showid);
        mTopUpsRequest.bizParamsMap.put("show_videoseq", playVideoInfo.show_videoseq);
        mTopUpsRequest.bizParamsMap.put("playlist_id", playVideoInfo.playlist_id);
        mTopUpsRequest.bizParamsMap.put("playlist_videoseq", playVideoInfo.playlist_videoseq);
        mTopUpsRequest.bizParamsMap.put("h265", playVideoInfo.h265);
        mTopUpsRequest.bizParamsMap.put("point", playVideoInfo.point);
        mTopUpsRequest.bizParamsMap.put("language", playVideoInfo.language);
        if (!TextUtils.isEmpty(playVideoInfo.local_vid)) {
            mTopUpsRequest.bizParamsMap.put("local_vid", playVideoInfo.local_vid);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_time)) {
            mTopUpsRequest.bizParamsMap.put("local_time", playVideoInfo.local_time);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_point)) {
            mTopUpsRequest.bizParamsMap.put("local_point", playVideoInfo.local_point);
        }
        mTopUpsRequest.bizParamsMap.put("audiolang", playVideoInfo.audiolang);
        mTopUpsRequest.bizParamsMap.put(AdUtConstants.XAD_UT_ARG_MEDIA_TYPE, playVideoInfo.media_type);
        mTopUpsRequest.bizParamsMap.put(Constants.Value.PASSWORD, playVideoInfo.password);
        mTopUpsRequest.bizParamsMap.put("client_id", playVideoInfo.client_id);
        mTopUpsRequest.bizParamsMap.put("mac", playVideoInfo.mac);
        mTopUpsRequest.bizParamsMap.put("network", playVideoInfo.network);
        mTopUpsRequest.bizParamsMap.put("brand", playVideoInfo.brand);
        mTopUpsRequest.bizParamsMap.put(OConstant.CANDIDATE_OSVER, playVideoInfo.os_ver);
        mTopUpsRequest.bizParamsMap.put("app_ver", playVideoInfo.app_ver);
        mTopUpsRequest.bizParamsMap.put("encryptR_client", playVideoInfo.encryptR_client);
        mTopUpsRequest.bizParamsMap.put("key_index", playVideoInfo.key_index);
        mTopUpsRequest.bizParamsMap.put("src", playVideoInfo.src);
        mTopUpsRequest.bizParamsMap.put("d_type", playVideoInfo.d_type);
        mTopUpsRequest.bizParamsMap.put("drm_type", playVideoInfo.drm_type);
        mTopUpsRequest.bizParamsMap.put(TableField.PS_ID, playVideoInfo.psid);
        mTopUpsRequest.bizParamsMap.put("qxd", playVideoInfo.qxd);
        if (!TextUtils.isEmpty(playVideoInfo.play_ability)) {
            mTopUpsRequest.bizParamsMap.put("play_ability", playVideoInfo.play_ability);
        }
        mTopUpsRequest.bizParamsMap.put("compress", playVideoInfo.compress ? "1" : "0");
        if (!TextUtils.isEmpty(playVideoInfo.plic_source)) {
            mTopUpsRequest.bizParamsMap.put("source", playVideoInfo.plic_source);
        }
        if (!TextUtils.isEmpty(playVideoInfo.decode_ability)) {
            mTopUpsRequest.bizParamsMap.put("decode_ability", playVideoInfo.decode_ability);
        }
        if (!TextUtils.isEmpty(playVideoInfo.play_scene)) {
            mTopUpsRequest.bizParamsMap.put("play_scene", playVideoInfo.play_scene);
        }
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                mTopUpsRequest.bizParamsMap.put(entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = this.mAdParams;
        if (map2 != null) {
            mTopUpsRequest.adParamsMap.putAll(map2);
            for (Map.Entry<String, String> entry2 : mTopUpsRequest.adParamsMap.entrySet()) {
                if (sEncodeParams.contains(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
                    mTopUpsRequest.adParamsMap.put(entry2.getKey(), decode(entry2.getValue()));
                }
            }
        }
        mTopUpsRequest.bizParamsMap.put("btype", encode(Build.getMODEL()));
        if (!TextUtils.isEmpty(playVideoInfo.vv_id)) {
            mTopUpsRequest.bizParamsMap.put("vv_id", playVideoInfo.vv_id);
        }
        if (!TextUtils.isEmpty(playVideoInfo.vid_src)) {
            mTopUpsRequest.bizParamsMap.put("vid_src", playVideoInfo.vid_src);
        }
        if (TextUtils.isEmpty(playVideoInfo.ext_showid)) {
            return;
        }
        mTopUpsRequest.bizParamsMap.put("ext_showid", playVideoInfo.ext_showid);
    }

    private static String decode(String str) {
        if (str != null) {
            try {
                return URLDecoder.decode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Logger.e(TAG, "decode " + e.toString());
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    private static String encode(String str) {
        if (str != null) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                Logger.e(TAG, "encode " + e.toString());
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getCkey(PlayVideoInfo playVideoInfo) {
        AntiTheftChainParam antiTheftChainParam = new AntiTheftChainParam();
        antiTheftChainParam.setVid(playVideoInfo.vid);
        antiTheftChainParam.setServerEnv(0);
        antiTheftChainParam.setContext(this.mContext);
        antiTheftChainParam.setClientTs(playVideoInfo.client_ts);
        antiTheftChainParam.setAntiTheftChainClientType(this.mIsExternal ? AntiTheftChainClientType.External : AntiTheftChainClientType.Internal);
        antiTheftChainParam.setCcode(playVideoInfo.ccode);
        antiTheftChainParam.setClientIP(playVideoInfo.client_ip);
        antiTheftChainParam.setUtid(playVideoInfo.utid);
        PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
        upsRequest.beginSection("createCkey");
        String ckey = AntiTheftChainFactory.create().getCkey(antiTheftChainParam);
        upsRequest.endSection();
        Logger.d(TAG, "ckey=" + ckey);
        return ckey;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public MTopUpsRequest getMTopUpsResquest() {
        MTopUpsRequest mTopUpsRequest = new MTopUpsRequest();
        mTopUpsRequest.API_NAME = this.mApiName;
        mTopUpsRequest.VERSION = this.mApiVersion;
        mTopUpsRequest.NEED_ECODE = this.mNeedEcode;
        constructParams(mTopUpsRequest, this.mPlayVideoInfo);
        return mTopUpsRequest;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUrl(PlayVideoInfo playVideoInfo) {
        Map<String, String> map = this.mAdParams;
        if (playVideoInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(this.mHost);
        sb.append("/ups/get.json?");
        addParam(sb, playVideoInfo);
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addParamWithoutEncode(sb, entry.getKey(), entry.getValue());
            }
        }
        Map<String, String> map2 = this.mParams;
        if (map2 != null) {
            for (Map.Entry<String, String> entry2 : map2.entrySet()) {
                addParamWithoutEncode(sb, entry2.getKey(), entry2.getValue());
            }
        }
        return sb.toString();
    }

    private Stream[] parseStream(JSONArray jSONArray) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public VideoInfo processData(GetInfoResult getInfoResult) {
        ConnectStat connectStat;
        int i;
        Logger.d(TAG, "processData");
        VideoInfo videoInfo = null;
        if (getInfoResult == null || getInfoResult.connectStat == null) {
            return null;
        }
        Logger.d(TAG, "http connect=" + getInfoResult.connectStat.connect_success + " response code=" + getInfoResult.connectStat.response_code);
        StringBuilder sb = new StringBuilder();
        sb.append("http result data =");
        sb.append(getInfoResult.data);
        Logger.d(TAG, sb.toString());
        if (getInfoResult.connectStat.connect_success) {
            try {
                if (TextUtils.isEmpty(getInfoResult.data)) {
                    return null;
                }
                videoInfo = ParseResult.parseData(getInfoResult.data);
                videoInfo.setStream(parseStream(videoInfo.getStreamJson()));
                return videoInfo;
            } catch (Exception e) {
                Logger.e(TAG, e.toString());
                String str = getInfoResult.data;
                if (str != null) {
                    if (str.contains(UPS_WEB_ANTI)) {
                        connectStat = getInfoResult.connectStat;
                        connectStat.connect_success = false;
                        i = ErrorConstants.ERROR_UPS_WEB_ANTI;
                    } else if (!getInfoResult.data.contains(UPS_WEB_FLOW_LIMIT)) {
                        return videoInfo;
                    } else {
                        connectStat = getInfoResult.connectStat;
                        connectStat.connect_success = false;
                        i = ErrorConstants.ERROR_UPS_WEB_FLOW_LIMIT;
                    }
                    connectStat.response_code = i;
                    return videoInfo;
                }
                return videoInfo;
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public void setAntiTheftUtData(VideoInfo videoInfo, GetInfoResult getInfoResult) {
        UtAntiTheaftBean utAntiTheaftBean;
        int i;
        getInfoResult.connectStat.utMsg = new UtAntiTheaftBean();
        UtAntiTheaftBean utAntiTheaftBean2 = getInfoResult.connectStat.utMsg;
        RequestData requestData = this.request;
        utAntiTheaftBean2.ccode = requestData.ccode;
        utAntiTheaftBean2.ckey = requestData.ckey;
        utAntiTheaftBean2.isCkeyError = requestData.isCkeyError;
        utAntiTheaftBean2.ckeyErrorMsg = requestData.ckeyErrorMsg;
        if (videoInfo.getUps() != null) {
            getInfoResult.connectStat.utMsg.psid = videoInfo.getUps().psid;
            getInfoResult.connectStat.utMsg.upsClientNetip = videoInfo.getUps().ups_client_netip;
        } else {
            UtAntiTheaftBean utAntiTheaftBean3 = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean3.psid = null;
            utAntiTheaftBean3.upsClientNetip = null;
        }
        if (videoInfo.getVideo() != null) {
            getInfoResult.connectStat.utMsg.title = encode(videoInfo.getVideo().title);
        } else {
            getInfoResult.connectStat.utMsg.title = null;
        }
        if (videoInfo.getUser() != null) {
            getInfoResult.connectStat.utMsg.uid = videoInfo.getUser().uid.isEmpty() ? null : videoInfo.getUser().uid;
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            i = videoInfo.getUser().vip;
        } else {
            utAntiTheaftBean = getInfoResult.connectStat.utMsg;
            utAntiTheaftBean.uid = null;
            i = 0;
        }
        utAntiTheaftBean.vip = i;
        ConnectStat connectStat = getInfoResult.connectStat;
        UtAntiTheaftBean utAntiTheaftBean4 = connectStat.utMsg;
        RequestData requestData2 = this.request;
        utAntiTheaftBean4.utid = requestData2.utid;
        utAntiTheaftBean4.vid = requestData2.vid;
        utAntiTheaftBean4.log_type = 5;
        utAntiTheaftBean4.clientid = requestData2.clientid;
        videoInfo.setConnectStat(connectStat);
    }

    @Override // com.youku.upsplayer.IUpsInfoRequest
    public void request(PlayVideoInfo playVideoInfo, Map<String, String> map, Map<String, String> map2, NetworkParameter networkParameter, IUpsInfoRequest.IUpsInfoRequestCallback iUpsInfoRequestCallback) {
        Logger.d(TAG, "getUrlInfo");
        this.request = new RequestData();
        if (networkParameter == null || playVideoInfo == null) {
            Logger.d(TAG, "invalid parameter");
            iUpsInfoRequestCallback.onFailure(new IUpsInfoRequest.UpsRequestError(0, "invalid parameter", this.request));
            return;
        }
        this.mPlayVideoInfo = playVideoInfo;
        this.mParams = map;
        this.mAdParams = map2;
        this.mNetwork = networkParameter;
        this.mCallBack = iUpsInfoRequestCallback;
        mWorker.submit(this.GetInfoRunnable);
    }
}
