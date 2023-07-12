package com.youku.alixplayer.opensdk.ups.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.ut.device.UTDevice;
import com.youku.alixplayer.opensdk.IVideoRequest;
import com.youku.alixplayer.opensdk.PlayVideoInfo;
import com.youku.alixplayer.opensdk.PlayerConfig;
import com.youku.alixplayer.opensdk.VideoRequestError;
import com.youku.alixplayer.opensdk.drm.DrmType;
import com.youku.alixplayer.opensdk.ups.request.service.NewHttpTask;
import com.youku.alixplayer.opensdk.utils.DrmManager;
import com.youku.alixplayer.opensdk.utils.Logger;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.alixplayer.opensdk.utils.ProvisionAuthenticator;
import com.youku.alixplayer.opensdk.utils.TLogUtil;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.upsplayer.IUpsInfoRequest;
import com.youku.upsplayer.UpsInfoRequest;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.PlayError;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.AntiTheftChainUtUtil;
import com.youku.usercenter.passport.util.CookieUtil;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class UpsVideoRequest implements IVideoRequest {
    private static final String TAG = "UpsVideoRequest";
    private IVideoRequest.Callback mCallback;
    private Context mContext;
    private String mDrmR1;
    private boolean mIsCancel;
    private PlayerConfig mPlayerConfig;
    private IUpsInfoRequest mRequest;
    private Map<String, String> mParams = new HashMap();
    private Handler mHandler = new Handler(Looper.getMainLooper());

    public UpsVideoRequest(Context context, PlayerConfig playerConfig) {
        this.mContext = context;
        this.mPlayerConfig = playerConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkResult(PlayVideoInfo playVideoInfo, VideoInfo videoInfo, ConnectStat connectStat, IVideoRequest.Callback callback) {
        if (this.mIsCancel) {
            return;
        }
        Logger.d(TAG, "checkResult");
        if (connectStat == null) {
            VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
            videoRequestError.setErrorCode(101);
            videoRequestError.setErrorMsg("网络连接失败");
            reportError(callback, videoRequestError);
        } else if (videoInfo == null) {
            VideoRequestError videoRequestError2 = new VideoRequestError(playVideoInfo);
            videoRequestError2.setErrorCode(28001);
            videoRequestError2.setErrorMsg("数据请求解析异常");
            reportError(callback, videoRequestError2);
        } else if (!connectStat.connect_success) {
            VideoRequestError videoRequestError3 = new VideoRequestError(playVideoInfo);
            videoRequestError3.setErrorCode(connectStat.response_code);
            videoRequestError3.setErrorMsg(connectStat.errMsg);
            videoRequestError3.setConnectStat(connectStat);
            reportError(callback, videoRequestError3);
        } else {
            UtAntiTheaftBean utAntiTheaftBean = connectStat.utMsg;
            if (utAntiTheaftBean != null && utAntiTheaftBean.isCkeyError) {
                AntiTheftChainUtUtil.utlog(AntiTheftChainClientType.External, AntiTheftChainUtLogType.CKEYERROR, utAntiTheaftBean);
            }
            if (videoInfo.getError() != null) {
                PlayError error = videoInfo.getError();
                VideoRequestError videoRequestError4 = new VideoRequestError(playVideoInfo);
                videoRequestError4.setHttpStatus(connectStat.response_code);
                int i = error.code;
                if (i < 0) {
                    i = (i * (-1)) + 20000;
                }
                videoRequestError4.setErrorCode(i);
                videoRequestError4.setErrorMsg(error.note);
                videoRequestError4.setConnectStat(connectStat);
                Logger.d(TAG, "server err: " + error.code);
                Logger.d(TAG, "note " + error.note);
                reportError(callback, videoRequestError4);
            } else if (videoInfo.getStream() == null) {
                VideoRequestError videoRequestError5 = new VideoRequestError(playVideoInfo);
                videoRequestError5.setHttpStatus(connectStat.response_code);
                videoRequestError5.setErrorCode(28001);
                videoRequestError5.setErrorMsg("UPS返回信息节点异常导致解析不到播放地址");
                videoRequestError5.setConnectStat(connectStat);
                reportError(callback, videoRequestError5);
            } else {
                Logger.d(TAG, "ups to main thread");
                HashMap hashMap = new HashMap();
                hashMap.put("drmR1", this.mDrmR1);
                reportSuccess(videoInfo, hashMap, callback);
            }
        }
    }

    private int constructDrmType() {
        int value = DrmType.DEFAULT.getValue() | DrmType.CHINA.getValue() | DrmType.COPYRIGHT.getValue();
        if (ProvisionAuthenticator.isCencSupported()) {
            value |= DrmType.WV_CENC.getValue();
        }
        return ProvisionAuthenticator.isCbcsSupported() ? value | DrmType.WV_CBCS.getValue() : value;
    }

    private NetworkParameter createNetworkParam() {
        NetworkParameter networkParameter = new NetworkParameter();
        networkParameter.connect_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        networkParameter.cookie = this.mPlayerConfig.getDynamicProperties().call(HttpIntent.COOKIE);
        networkParameter.userAgent = this.mPlayerConfig.getUserAgent();
        networkParameter.read_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        return networkParameter;
    }

    private String getMediaType() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Point.STANDARD);
        return stringBuffer.toString();
    }

    private int[] getTimeOut() {
        String config = ConfigFetcher.getInstance().getConfig("player_network_ups", "ups_retry", "5000,30000");
        if (TextUtils.isEmpty(config)) {
            return null;
        }
        Logger.d(TAG, "getTimeOut " + config);
        String[] split = config.split(",");
        if (split.length > 0) {
            int[] iArr = new int[split.length];
            for (int i = 0; i < split.length; i++) {
                if (split[i] != null) {
                    try {
                        iArr[i] = Integer.valueOf(split[i]).intValue();
                    } catch (Exception e) {
                        Logger.e(TAG, e.toString());
                    }
                }
                return null;
            }
            return iArr;
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportError(final IVideoRequest.Callback callback, final VideoRequestError videoRequestError) {
        this.mHandler.post(new Runnable() { // from class: com.youku.alixplayer.opensdk.ups.request.UpsVideoRequest.3
            @Override // java.lang.Runnable
            public void run() {
                IVideoRequest.Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onFailure(videoRequestError);
                }
            }
        });
    }

    private void reportSuccess(final VideoInfo videoInfo, final Map<String, String> map, final IVideoRequest.Callback callback) {
        this.mHandler.post(new Runnable() { // from class: com.youku.alixplayer.opensdk.ups.request.UpsVideoRequest.2
            @Override // java.lang.Runnable
            public void run() {
                IVideoRequest.Callback callback2 = callback;
                if (callback2 != null) {
                    callback2.onSuccess(videoInfo, map);
                }
            }
        });
    }

    public void addParams(Map<String, String> map) {
        this.mParams.putAll(map);
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void request(final PlayVideoInfo playVideoInfo, Map<String, String> map) {
        TLogUtil.playLog("request ups");
        if (map == null) {
            map = new HashMap<>();
        }
        Map<String, String> map2 = map;
        map2.put("master_m3u8", this.mPlayerConfig.isSupport("abrPlay") ? "1" : "0");
        map2.put("extag", "EXT-X-PRIVINF");
        if (playVideoInfo != null) {
            map2.put("skipPreVideo", "1");
        }
        if (ProvisionAuthenticator.getWidevineLevel() == ProvisionAuthenticator.WidevineLevel.L1) {
            map2.put("drm_level", "1");
        }
        map2.put("preferClarity", String.valueOf(playVideoInfo.getRequestQuality().getValueForUps()));
        com.youku.upsplayer.request.PlayVideoInfo playVideoInfo2 = new com.youku.upsplayer.request.PlayVideoInfo();
        if (PlayerUtil.isVid(playVideoInfo.getVid())) {
            playVideoInfo2.vid = playVideoInfo.getVid();
        } else {
            playVideoInfo2.vid = "";
            playVideoInfo2.showid = playVideoInfo.getVid();
        }
        playVideoInfo2.client_ip = PlayerUtil.getIp(this.mContext);
        playVideoInfo2.ccode = this.mPlayerConfig.getCCode();
        playVideoInfo2.utid = UTDevice.getUtdid(this.mContext);
        playVideoInfo2.client_ts = String.valueOf(System.currentTimeMillis() / 1000);
        playVideoInfo2.point = "1";
        playVideoInfo2.audiolang = "1";
        playVideoInfo2.media_type = getMediaType();
        playVideoInfo2.h265 = this.mPlayerConfig.isSupportH265() ? "1" : "0";
        int netType = PlayerUtil.getNetType(this.mContext);
        if (netType == 1) {
            playVideoInfo2.network = "1000";
        } else if (netType != 2 && netType != 3 && netType != 4) {
            playVideoInfo2.network = UpsConstant.UPS_NETWORK_UNKOWN;
        } else {
            playVideoInfo2.network = UpsConstant.UPS_NETWORK_4G;
        }
        playVideoInfo2.tq = "0";
        playVideoInfo2.brand = Build.getBRAND();
        playVideoInfo2.os_ver = Build.VERSION.getRELEASE();
        playVideoInfo2.app_ver = this.mPlayerConfig.getAppVersion();
        playVideoInfo2.yktk = this.mPlayerConfig.getDynamicProperties().call(CookieUtil.COOKIE_KEY_YKTK);
        playVideoInfo2.stoken = this.mPlayerConfig.getDynamicProperties().call(IRequestConst.STOKEN);
        playVideoInfo2.ptoken = this.mPlayerConfig.getDynamicProperties().call("ptoken");
        if (this.mPlayerConfig.isExternal()) {
            String call = this.mPlayerConfig.getDynamicProperties().call(IRequestConst.ATOKEN);
            if (!TextUtils.isEmpty(call)) {
                this.mParams.put(IRequestConst.ATOKEN, call);
            }
        }
        playVideoInfo2.client_id = this.mPlayerConfig.getClientId();
        try {
            if (this.mPlayerConfig.getDrmConfig() != null) {
                Logger.d(TAG, "播放请求前从安全保镖接口获取加密R1，将encryptR_client和key_index参数传给ups服务端");
                String keyIndex = this.mPlayerConfig.getDrmConfig().getKeyIndex();
                DrmManager.Result generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, keyIndex, this.mPlayerConfig.getDrmConfig().getAuthCode());
                String str = generateEncryptRClient.encryptR;
                this.mDrmR1 = generateEncryptRClient.R1;
                playVideoInfo2.encryptR_client = PlayerUtil.urlEncoder(str);
                playVideoInfo2.key_index = generateEncryptRClient.keyIndex;
                Logger.d("DrmManager", "R1:" + this.mDrmR1);
                Logger.d("DrmManager", "staticSafeEncrypt:" + str);
                Logger.d("DrmManager", "encryptR_client:" + playVideoInfo2.encryptR_client);
                Logger.d("DrmManager", "key_index:" + keyIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        playVideoInfo2.drm_type = constructDrmType() + "";
        map2.putAll(this.mParams);
        NetworkParameter createNetworkParam = createNetworkParam();
        INetworkTask networkTask = this.mPlayerConfig.getNetworkTask();
        if (networkTask == null) {
            networkTask = new NewHttpTask(this.mContext, getTimeOut());
        }
        INetworkTask iNetworkTask = networkTask;
        String string = this.mPlayerConfig.getBundle().getString("domain");
        String string2 = this.mPlayerConfig.getBundle().getString(TbAuthConstants.IP);
        if (!TextUtils.isEmpty(string) && !TextUtils.isEmpty(string2)) {
            this.mRequest = new UpsInfoRequest(this.mContext, iNetworkTask, this.mPlayerConfig.isExternal(), string, string2);
        } else {
            this.mRequest = new UpsInfoRequest(this.mContext, iNetworkTask, this.mPlayerConfig.isExternal());
        }
        this.mRequest.request(playVideoInfo2, map2, null, createNetworkParam, new IUpsInfoRequest.IUpsInfoRequestCallback() { // from class: com.youku.alixplayer.opensdk.ups.request.UpsVideoRequest.1
            @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
            public void onFailure(IUpsInfoRequest.UpsRequestError upsRequestError) {
                VideoRequestError videoRequestError = new VideoRequestError(playVideoInfo);
                videoRequestError.setErrorCode(upsRequestError.getErrorCode());
                videoRequestError.setErrorMsg(upsRequestError.getErrorMsg());
                UpsVideoRequest upsVideoRequest = UpsVideoRequest.this;
                upsVideoRequest.reportError(upsVideoRequest.mCallback, videoRequestError);
            }

            @Override // com.youku.upsplayer.IUpsInfoRequest.IUpsInfoRequestCallback
            public void onSuccess(VideoInfo videoInfo, ConnectStat connectStat) {
                UpsVideoRequest upsVideoRequest = UpsVideoRequest.this;
                upsVideoRequest.checkResult(playVideoInfo, videoInfo, connectStat, upsVideoRequest.mCallback);
            }
        });
    }

    @Override // com.youku.alixplayer.opensdk.IVideoRequest
    public void setVideoRequestListener(IVideoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
