package com.youku.upsplayer;

import android.content.Context;
import android.text.TextUtils;
import com.ali.ha.fulltrace.dump.DumpManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.orange.OConstant;
import com.taobao.weex.common.Constants;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.antitheftchain.interfaces.AntiTheftChainFactory;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.live.dago.widgetlib.ailplive.LiveManager;
import com.youku.ups.data.RequestParams;
import com.youku.upsplayer.data.MTopUpsRequest;
import com.youku.upsplayer.data.RequestData;
import com.youku.upsplayer.module.UpsTimeTraceBean;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.request.PlayVideoInfo;
import com.youku.upsplayer.util.AssertUtil;
import com.youku.upsplayer.util.GetInfoThread;
import com.youku.upsplayer.util.GetMultiInfoThread;
import com.youku.upsplayer.util.GetMultiUPSInfoThread;
import com.youku.upsplayer.util.Logger;
import com.youku.upsplayer.util.PlayStageTracker;
import com.youku.upsplayer.util.TestConfig;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.vpm.constants.TableField;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GetUps {
    public static final String API_NAME_DEFAULT = "mtop.youku.play.ups.appinfo.get";
    public static final String API_VERSION_DEFAULT = "1.1";
    public static final int DEFAULT = 1;
    public static final String HOST_DEFAULT = "http://ups.youku.com";
    public static final int HTTP = 2;
    public static final int MTOP = 3;
    public static final boolean NEED_ECODE_DEFAULT = true;
    public static final String TAG = "GetUps";
    public static final String UPS_MULTI_MININFO_PATH = "/ups/first_slice.json?";
    public static final String UPS_MULTI_MININFO_PATH_NEW = "/ups/single_slice.json?";
    public static final String UPS_MULTI_PATH = "/ups/multi_get.json?";
    public static final String UPS_MULTI_UPSIFO_PATH_NEW = "/ups/qget.json?";
    public static final String UPS_PATH = "/ups/get.json?";
    public static final String UPS_V2_PATH = "/ups/light_get.json?";
    private AntiTheftChainParam chainParam;
    private Context context;
    private String host;
    private String ip;
    private Map<String, String> mAdMap;
    private IVideoInfoCallBack mCallBack;
    private NetworkParameter mNetwork;
    private Map<String, String> mParams;
    private PlayVideoInfo mPlayVideoInfo;
    private IMultiMinVideoInfoCallBack multiMinVideoInfoCallBack;
    private IMultiUPSVideoInfoCallBack multiUPSVideoInfoCallBack;
    private IMultiVideoInfoCallBack multiVideoInfoCallBack;
    protected INetworkTask networkTask;
    private UpsTimeTraceBean timeTraceBean;
    private static Set<String> adEncodeParam = new HashSet<String>() { // from class: com.youku.upsplayer.GetUps.1
        {
            add(IRequestConst.MDL);
            add("device_brand");
            add(IRequestConst.OSV);
            add("ua");
        }
    };
    private static Executor mWorker = Executors.newCachedThreadPool();
    private static Executor mMultiUpsWorker = Executors.newCachedThreadPool();
    private String mApiName = "mtop.youku.play.ups.appinfo.get";
    private String mApiVersion = "1.1";
    private boolean mNeedEcode = true;
    public String mHost = "http://ups.youku.com";
    protected final int CONNECT_TIMEOUT = 15000;
    protected final int READ_TIMEOUT = 15000;
    private int upsType = 1;
    private RequestData request = null;
    private Runnable mGetMultiInfoRunnable = new Runnable() { // from class: com.youku.upsplayer.GetUps.2
        @Override // java.lang.Runnable
        public void run() {
            GetUps.this.request.upsTimeTraceBean = new UpsTimeTraceBean();
            GetUps.this.request.upsTimeTraceBean.startTrace();
            String multiInfoUrl = GetUps.this.getMultiInfoUrl();
            GetUps.this.request.upsTimeTraceBean.traceTimeGetCkey();
            if (TextUtils.isEmpty(multiInfoUrl)) {
                Logger.d(GetUps.TAG, "invalid url");
                return;
            }
            Logger.d("UpsPlayer", "multi_json url=" + multiInfoUrl);
            GetUps.this.request.url = multiInfoUrl;
            GetUps.this.request.upsType = GetUps.this.upsType;
            GetUps.this.request.upsInterfaceVersion = GetUps.this.mPlayVideoInfo.upsInterfaceVersion;
            GetUps.this.request.host = GetUps.this.host;
            GetUps.this.request.ip = GetUps.this.ip;
            if (GetUps.this.mNetwork != null) {
                GetUps.this.request.cookie = GetUps.this.mNetwork.cookie;
                GetUps.this.request.agent = GetUps.this.mNetwork.userAgent;
                GetUps.this.request.connect_timeout = GetUps.this.mNetwork.connect_timeout;
                GetUps.this.request.read_timeout = GetUps.this.mNetwork.read_timeout;
            }
            if (GetUps.this.request.connect_timeout == 0) {
                GetUps.this.request.connect_timeout = 15000;
            }
            if (GetUps.this.request.read_timeout == 0) {
                GetUps.this.request.read_timeout = 15000;
            }
            RequestData requestData = GetUps.this.request;
            GetUps getUps = GetUps.this;
            new GetMultiInfoThread(requestData, getUps.networkTask, getUps.multiVideoInfoCallBack).run();
        }
    };
    private Runnable mGetMultiUPSVideoInfoRunnable = new Runnable() { // from class: com.youku.upsplayer.GetUps.3
        @Override // java.lang.Runnable
        public void run() {
            String multiUPSInfoUrl = GetUps.this.getMultiUPSInfoUrl();
            if (TextUtils.isEmpty(multiUPSInfoUrl)) {
                Logger.d(GetUps.TAG, "invalid url");
                return;
            }
            Logger.d("UpsPlayer", "multi_min_json url=" + multiUPSInfoUrl);
            GetUps.this.request.url = multiUPSInfoUrl;
            GetUps.this.request.upsType = GetUps.this.upsType;
            GetUps.this.request.upsInterfaceVersion = GetUps.this.mPlayVideoInfo.upsInterfaceVersion;
            GetUps.this.request.host = GetUps.this.host;
            GetUps.this.request.ip = GetUps.this.ip;
            if (GetUps.this.mNetwork != null) {
                GetUps.this.request.cookie = GetUps.this.mNetwork.cookie;
                GetUps.this.request.agent = GetUps.this.mNetwork.userAgent;
                GetUps.this.request.connect_timeout = GetUps.this.mNetwork.connect_timeout;
                GetUps.this.request.read_timeout = GetUps.this.mNetwork.read_timeout;
            }
            if (GetUps.this.request.connect_timeout == 0) {
                GetUps.this.request.connect_timeout = 15000;
            }
            if (GetUps.this.request.read_timeout == 0) {
                GetUps.this.request.read_timeout = 15000;
            }
            RequestData requestData = GetUps.this.request;
            GetUps getUps = GetUps.this;
            new GetMultiUPSInfoThread(requestData, getUps.networkTask, getUps.multiUPSVideoInfoCallBack).run();
        }
    };
    private Runnable GetInfoRunnable = new Runnable() { // from class: com.youku.upsplayer.GetUps.4
        @Override // java.lang.Runnable
        public void run() {
            GetUps.this.request.upsTimeTraceBean = new UpsTimeTraceBean();
            GetUps.this.request.upsTimeTraceBean.startTrace();
            String url = GetUps.this.getUrl();
            GetUps.this.request.upsTimeTraceBean.traceTimeGetCkey();
            if (TextUtils.isEmpty(url)) {
                Logger.d(GetUps.TAG, "invalid url");
                return;
            }
            Logger.d("UpsPlayer", "ups url=" + url);
            GetUps.this.request.url = url;
            GetUps.this.request.mTopUpsRequest = GetUps.this.getMTopUpsResquest();
            GetUps.this.request.upsType = GetUps.this.upsType;
            GetUps.this.request.upsInterfaceVersion = GetUps.this.mPlayVideoInfo.upsInterfaceVersion;
            GetUps.this.request.compress = TestConfig.isIsCompressConfigValid() ? TestConfig.isCompress() : GetUps.this.mPlayVideoInfo.compress;
            GetUps.this.request.checkUrl = TestConfig.isCheckUrl();
            GetUps.this.request.host = GetUps.this.host;
            GetUps.this.request.ip = GetUps.this.ip;
            if (GetUps.this.mNetwork != null) {
                GetUps.this.request.cookie = GetUps.this.mNetwork.cookie;
                GetUps.this.request.agent = GetUps.this.mNetwork.userAgent;
                GetUps.this.request.connect_timeout = GetUps.this.mNetwork.connect_timeout;
                GetUps.this.request.read_timeout = GetUps.this.mNetwork.read_timeout;
            }
            if (GetUps.this.request.connect_timeout == 0) {
                GetUps.this.request.connect_timeout = 15000;
            }
            if (GetUps.this.request.read_timeout == 0) {
                GetUps.this.request.read_timeout = 15000;
            }
            RequestData requestData = GetUps.this.request;
            GetUps getUps = GetUps.this;
            new GetInfoThread(requestData, getUps.networkTask, getUps.mCallBack).run();
        }
    };

    public GetUps(Context context, INetworkTask iNetworkTask) {
        this.networkTask = null;
        this.context = null;
        this.networkTask = iNetworkTask;
        this.context = context;
        if (AssertUtil.mInited) {
            return;
        }
        AssertUtil.setAllowCrash(AssertUtil.isApkDebuggable(context));
    }

    private void addCommunalParam(StringBuilder sb, PlayVideoInfo playVideoInfo, AntiTheftChainParam antiTheftChainParam) {
        addParam(sb, RequestParams.client_ip, playVideoInfo.client_ip);
        addParam(sb, RequestParams.client_ts, playVideoInfo.client_ts);
        addParam(sb, RequestParams.utid, decode(playVideoInfo.utid));
        addParam(sb, "ccode", playVideoInfo.ccode);
        this.request.ccode = playVideoInfo.ccode;
        if (!TextUtils.isEmpty(playVideoInfo.encryptR_client)) {
            addParam(sb, "encryptR_client", decode(playVideoInfo.encryptR_client));
        }
        if (!TextUtils.isEmpty(playVideoInfo.key_index)) {
            addParam(sb, "key_index", playVideoInfo.key_index);
        }
        addParam(sb, "drm_type", playVideoInfo.drm_type);
        addParam(sb, "h265", playVideoInfo.h265);
        addParam(sb, AdUtConstants.XAD_UT_ARG_MEDIA_TYPE, playVideoInfo.media_type);
        if (!TextUtils.isEmpty(playVideoInfo.local_vid)) {
            addParam(sb, "local_vid", playVideoInfo.local_vid);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_time)) {
            addParam(sb, "local_time", playVideoInfo.local_time);
        }
        if (!TextUtils.isEmpty(playVideoInfo.local_point)) {
            addParam(sb, "local_point", playVideoInfo.local_point);
        }
        addParam(sb, "client_id", playVideoInfo.client_id);
        if (!TextUtils.isEmpty(playVideoInfo.play_ability)) {
            addParam(sb, "play_ability", playVideoInfo.play_ability);
        }
        if (!playVideoInfo.ccode.equals("01010301") || TextUtils.isEmpty(playVideoInfo.p_device)) {
            return;
        }
        addParam(sb, "p_device", playVideoInfo.p_device);
    }

    private void addMultiInfoParam(StringBuilder sb, PlayVideoInfo playVideoInfo, AntiTheftChainParam antiTheftChainParam) {
        String ckey = getCkey(antiTheftChainParam);
        String str = playVideoInfo.ckey;
        if (TextUtils.isEmpty(ckey)) {
            ckey = str;
        }
        this.request.ckey = ckey;
        addParam(sb, "ccode", playVideoInfo.ccode);
        addParam(sb, RequestParams.client_ip, playVideoInfo.client_ip);
        addParam(sb, RequestParams.client_ts, playVideoInfo.client_ts);
        addParam(sb, RequestParams.utid, playVideoInfo.utid);
        addParam(sb, "ytid", playVideoInfo.ytdid);
        addParam(sb, "pid", playVideoInfo.pid);
        addParam(sb, "network", playVideoInfo.network);
        addParam(sb, "drm_type", playVideoInfo.drm_type);
        addParam(sb, "key_index", playVideoInfo.key_index);
        addParam(sb, "encryptR_client", decode(playVideoInfo.encryptR_client));
        addParam(sb, "sessionId", PlayVideoInfo.minsetSessionId);
        addParam(sb, "app_ver", playVideoInfo.app_ver);
        if (!playVideoInfo.ccode.equals("01010301") || TextUtils.isEmpty(playVideoInfo.p_device)) {
            return;
        }
        addParam(sb, "p_device", playVideoInfo.p_device);
    }

    private void addMultiParam(StringBuilder sb, PlayVideoInfo playVideoInfo, AntiTheftChainParam antiTheftChainParam) {
        String ckey = getCkey(antiTheftChainParam);
        String str = playVideoInfo.ckey;
        if (TextUtils.isEmpty(ckey)) {
            ckey = str;
        }
        this.request.ckey = ckey;
        addParam(sb, LiveManager.StreamConfig.FORMAT_HLS, playVideoInfo.hls);
        addParam(sb, "h265", playVideoInfo.h265);
        addParam(sb, "qxd", playVideoInfo.qxd);
        addParam(sb, "ccode", playVideoInfo.ccode);
        addParam(sb, RequestParams.client_ip, playVideoInfo.client_ip);
        addParam(sb, RequestParams.client_ts, playVideoInfo.client_ts);
        addParam(sb, RequestParams.utid, playVideoInfo.utid);
        addParam(sb, "vids", playVideoInfo.vids);
        addParam(sb, "ckey", decode(ckey));
        addParam(sb, "network", playVideoInfo.network);
        addParam(sb, "app_ver", playVideoInfo.app_ver);
        addParam(sb, "btype", Build.getMODEL());
        if (!playVideoInfo.ccode.equals("01010301") || TextUtils.isEmpty(playVideoInfo.p_device)) {
            return;
        }
        addParam(sb, "p_device", playVideoInfo.p_device);
    }

    private void addMultiUpsInfoParam(StringBuilder sb, PlayVideoInfo playVideoInfo, AntiTheftChainParam antiTheftChainParam) {
        String ckey = getCkey(antiTheftChainParam);
        String str = playVideoInfo.ckey;
        if (TextUtils.isEmpty(ckey)) {
            ckey = str;
        }
        this.request.ckey = ckey;
        addParam(sb, "ckey", decode(ckey));
    }

    private void addParam(StringBuilder sb, PlayVideoInfo playVideoInfo, AntiTheftChainParam antiTheftChainParam) {
        String ckey = getCkey(antiTheftChainParam);
        String str = playVideoInfo.ckey;
        if (TextUtils.isEmpty(ckey)) {
            ckey = str;
        }
        addParam(sb, "ckey", decode(ckey));
        this.request.ckey = ckey;
        addParam(sb, RequestParams.client_ip, playVideoInfo.client_ip);
        addParam(sb, RequestParams.client_ts, playVideoInfo.client_ts);
        addParam(sb, RequestParams.utid, decode(playVideoInfo.utid));
        this.request.utid = playVideoInfo.utid;
        addParam(sb, "vid", playVideoInfo.vid);
        this.request.vid = playVideoInfo.vid;
        addParam(sb, "ccode", playVideoInfo.ccode);
        this.request.ccode = playVideoInfo.ccode;
        addParam(sb, "showid", playVideoInfo.showid);
        addParam(sb, "show_videoseq", playVideoInfo.show_videoseq);
        addParam(sb, "playlist_id", playVideoInfo.playlist_id);
        addParam(sb, "playlist_videoseq", playVideoInfo.playlist_videoseq);
        addParam(sb, "h265", playVideoInfo.h265);
        addParam(sb, "point", playVideoInfo.point);
        addParam(sb, "spdl", playVideoInfo.language);
        addParam(sb, "audiolang", playVideoInfo.audiolang);
        addParam(sb, AdUtConstants.XAD_UT_ARG_MEDIA_TYPE, playVideoInfo.media_type);
        addParam(sb, Constants.Value.PASSWORD, playVideoInfo.password);
        addParam(sb, "client_id", playVideoInfo.client_id);
        this.request.clientid = playVideoInfo.client_id;
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
            addParam(sb, "encryptR_client", decode(playVideoInfo.encryptR_client));
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
        if (!TextUtils.isEmpty(playVideoInfo.close_ability)) {
            addParam(sb, "close_ability", playVideoInfo.close_ability);
        }
        if (!TextUtils.isEmpty(playVideoInfo.play_scene)) {
            addParam(sb, "play_scene", playVideoInfo.play_scene);
        }
        boolean isCompress = TestConfig.isIsCompressConfigValid() ? TestConfig.isCompress() : this.mPlayVideoInfo.compress;
        addParam(sb, "compress", isCompress ? "1" : "0");
        if (TestConfig.isCheckUrl() && isCompress) {
            addParam(sb, DumpManager.LOG_PATH, "1");
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
        mTopUpsRequest.stealParamsMap.put("ckey", decode(this.request.ckey));
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ip, playVideoInfo.client_ip);
        mTopUpsRequest.stealParamsMap.put(RequestParams.client_ts, playVideoInfo.client_ts);
        mTopUpsRequest.stealParamsMap.put(RequestParams.utid, decode(playVideoInfo.utid));
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
        if (!TextUtils.isEmpty(playVideoInfo.close_ability)) {
            mTopUpsRequest.bizParamsMap.put("close_ability", playVideoInfo.close_ability);
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
        Map<String, String> map2 = this.mAdMap;
        if (map2 != null) {
            mTopUpsRequest.adParamsMap.putAll(map2);
            for (Map.Entry<String, String> entry2 : mTopUpsRequest.adParamsMap.entrySet()) {
                if (adEncodeParam.contains(entry2.getKey()) && !TextUtils.isEmpty(entry2.getValue())) {
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
                String str2 = TAG;
                Logger.e(str2, "decode " + e.toString());
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
                String str2 = TAG;
                Logger.e(str2, "encode " + e.toString());
                e.printStackTrace();
                return str;
            }
        }
        return str;
    }

    private String getCkey(AntiTheftChainParam antiTheftChainParam) {
        if (antiTheftChainParam == null) {
            return null;
        }
        try {
            PlayStageTracker.Stage upsRequest = PlayStageTracker.upsRequest();
            upsRequest.beginSection("createCkey");
            String ckey = AntiTheftChainFactory.create().getCkey(antiTheftChainParam);
            upsRequest.endSection();
            String str = TAG;
            Logger.d(str, "ckey=" + ckey);
            RequestData requestData = this.request;
            requestData.isCkeyError = false;
            requestData.ckeyErrorMsg = null;
            return ckey;
        } catch (AntiTheftChainException e) {
            this.request.isCkeyError = true;
            this.request.ckeyErrorMsg = "errorcode:" + e.getErrorCode() + " errormsg:" + e.getMessage();
            Logger.e(TAG, e.toString());
            e.printStackTrace();
            return "7B19C0AB12633B22E7FE81271162026020570708D6CC189E4924503C49D243A0DE6CD84A766832C2C99898FC5ED31F3709BB3CDD82C96492E721BDD381735026";
        }
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
    public String getMultiInfoUrl() {
        StringBuilder sb = new StringBuilder(this.mHost);
        sb.append(UPS_MULTI_PATH);
        try {
            addMultiParam(sb, this.mPlayVideoInfo, this.chainParam);
        } catch (UnsupportedEncodingException unused) {
            Logger.e(TAG, "getMultiInfoUrl exception!");
        }
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addParamWithoutEncode(sb, entry.getKey(), entry.getValue());
            }
        }
        return sb.toString();
    }

    private String getMultiMinInfoUrl() {
        StringBuilder sb = new StringBuilder(this.mHost);
        sb.append(UPS_MULTI_MININFO_PATH_NEW);
        try {
            addMultiInfoParam(sb, this.mPlayVideoInfo, this.chainParam);
        } catch (UnsupportedEncodingException unused) {
            Logger.e(TAG, "getMultiInfoUrl exception!");
        }
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addParamWithoutEncode(sb, entry.getKey(), entry.getValue());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getMultiUPSInfoUrl() {
        StringBuilder sb = new StringBuilder(this.mHost);
        sb.append(UPS_MULTI_UPSIFO_PATH_NEW);
        try {
            addMultiUpsInfoParam(sb, this.mPlayVideoInfo, this.chainParam);
        } catch (Exception unused) {
            Logger.e(TAG, "getMultiUpsInfoUrl exception!");
        }
        Map<String, String> map = this.mParams;
        if (map != null) {
            for (Map.Entry<String, String> entry : map.entrySet()) {
                addParamWithoutEncode(sb, entry.getKey(), entry.getValue());
            }
        }
        return sb.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUrl() {
        PlayVideoInfo playVideoInfo = this.mPlayVideoInfo;
        Map<String, String> map = this.mAdMap;
        if (playVideoInfo == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder(this.mHost);
        sb.append(playVideoInfo.upsInterfaceVersion == 2 ? UPS_V2_PATH : "/ups/get.json?");
        addParam(sb, playVideoInfo, this.chainParam);
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

    public static void setMultiUpsWorker(Executor executor) {
        mMultiUpsWorker = executor;
    }

    public static void setWorker(Executor executor) {
        mWorker = executor;
    }

    public boolean getMultiUPSVideoInfo(PlayVideoInfo playVideoInfo, Map<String, String> map, NetworkParameter networkParameter, IMultiUPSVideoInfoCallBack iMultiUPSVideoInfoCallBack) {
        String str = TAG;
        Logger.d(str, "getUrlInfo");
        this.request = new RequestData();
        if (this.networkTask == null || playVideoInfo == null) {
            Logger.d(str, "invalid parameter");
            return false;
        }
        this.mPlayVideoInfo = playVideoInfo;
        this.mParams = map;
        AssertUtil.setUpsInterfaceVersion(playVideoInfo.upsInterfaceVersion);
        this.mNetwork = networkParameter;
        this.multiUPSVideoInfoCallBack = iMultiUPSVideoInfoCallBack;
        mMultiUpsWorker.execute(this.mGetMultiUPSVideoInfoRunnable);
        return true;
    }

    public boolean getMultiVideoInfo(PlayVideoInfo playVideoInfo, NetworkParameter networkParameter, IMultiVideoInfoCallBack iMultiVideoInfoCallBack) {
        return getMultiVideoInfo(playVideoInfo, null, networkParameter, iMultiVideoInfoCallBack);
    }

    public boolean getMultiVideoInfo(PlayVideoInfo playVideoInfo, Map<String, String> map, NetworkParameter networkParameter, IMultiVideoInfoCallBack iMultiVideoInfoCallBack) {
        this.request = new RequestData();
        String str = TAG;
        Logger.d(str, "getUrlInfo");
        this.request = new RequestData();
        if (this.networkTask == null || playVideoInfo == null) {
            Logger.d(str, "invalid parameter");
            return false;
        }
        this.mPlayVideoInfo = playVideoInfo;
        this.mParams = map;
        AssertUtil.setUpsInterfaceVersion(playVideoInfo.upsInterfaceVersion);
        this.mNetwork = networkParameter;
        this.multiVideoInfoCallBack = iMultiVideoInfoCallBack;
        mMultiUpsWorker.execute(this.mGetMultiInfoRunnable);
        return true;
    }

    public boolean getUrlInfo(PlayVideoInfo playVideoInfo, Map<String, String> map, NetworkParameter networkParameter, IVideoInfoCallBack iVideoInfoCallBack) {
        return getUrlInfo(playVideoInfo, null, map, networkParameter, iVideoInfoCallBack);
    }

    public boolean getUrlInfo(PlayVideoInfo playVideoInfo, Map<String, String> map, Map<String, String> map2, NetworkParameter networkParameter, IVideoInfoCallBack iVideoInfoCallBack) {
        String str = TAG;
        Logger.d(str, "getUrlInfo");
        this.request = new RequestData();
        if (this.networkTask == null || playVideoInfo == null) {
            Logger.d(str, "invalid parameter");
            return false;
        }
        this.mPlayVideoInfo = playVideoInfo;
        AssertUtil.setUpsInterfaceVersion(playVideoInfo.upsInterfaceVersion);
        this.mParams = map;
        this.mAdMap = map2;
        this.mNetwork = networkParameter;
        this.mCallBack = iVideoInfoCallBack;
        mWorker.execute(this.GetInfoRunnable);
        return true;
    }

    public void setAntiTheftChainParam(AntiTheftChainParam antiTheftChainParam) {
        this.chainParam = antiTheftChainParam;
    }

    public boolean setHost(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.endsWith("/")) {
            str = str.substring(0, str.length() - 1);
        }
        this.mHost = str;
        return true;
    }

    public void setReqHost(String str) {
        this.host = str;
    }

    public void setReqIp(String str) {
        this.ip = str;
    }

    public void setUpsType(int i) {
        this.upsType = i;
    }

    public void setmApiName(String str) {
        this.mApiName = str;
    }

    public void setmApiVersion(String str) {
        this.mApiVersion = str;
    }

    public void setmNeedEcode(boolean z) {
        this.mNeedEcode = z;
    }
}
