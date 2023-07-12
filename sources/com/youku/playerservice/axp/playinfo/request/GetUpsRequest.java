package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.orange.OConstant;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.alisubtitle.subtitle.AliSubtitleConfig;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.drm.DrmManager;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.player.PlayerManager;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playinfo.request.task.HttpConnectionTask;
import com.youku.playerservice.axp.playinfo.request.task.MTopTask;
import com.youku.playerservice.axp.playinfo.request.task.MockTask;
import com.youku.playerservice.axp.playparams.PlayIdParams;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.AdUtil;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.SystemUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.UpsUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.ups.data.RequestParams;
import com.youku.ups.request.a;
import com.youku.ups.request.b;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.network.INetworkTask;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.AntiTheftChainUtUtil;
import com.youku.usercenter.passport.api.Passport;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class GetUpsRequest implements IPlayInfoRequest {
    private static final String TAG = "UpsRequest";
    private IPlayInfoRequest.Callback mCallback;
    private Context mContext;
    private String mDrmR1;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;
    private b mRequest;

    public GetUpsRequest(PlayerConfig playerConfig) {
        this.mContext = playerConfig.getContext();
        this.mPlayerConfig = playerConfig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkResult(PlayParams playParams, VideoInfo videoInfo, ConnectStat connectStat) {
        PlayInfoError playInfoError;
        String str;
        String str2;
        PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(this.mContext, playParams);
        playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
        Logger.d(TAG, "checkResult");
        if (connectStat == null) {
            playInfoError = new PlayInfoError();
            playInfoError.setErrorCode(101);
            str2 = "网络连接失败";
        } else {
            String str3 = connectStat.rawUpsData;
            if (videoInfo != null) {
                String sessionId = playParams.getSessionId();
                TLogUtil.flowLog(sessionId, "ups url=" + connectStat.url);
                if (connectStat.connect_success) {
                    UtAntiTheaftBean utAntiTheaftBean = connectStat.utMsg;
                    if (utAntiTheaftBean != null && utAntiTheaftBean.isCkeyError) {
                        AntiTheftChainUtUtil.utlog(AntiTheftChainClientType.External, AntiTheftChainUtLogType.CKEYERROR, utAntiTheaftBean);
                    }
                    if (videoInfo.getError() != null) {
                        int i = videoInfo.getError().code;
                        String str4 = videoInfo.getError().note;
                        int i2 = i < 0 ? (i * (-1)) + 20000 : i;
                        PlayInfoError playInfoError2 = new PlayInfoError();
                        playInfoError2.setErrorCode(i2);
                        playInfoError2.setErrorMsg(str4);
                        playInfoError2.setConnectStat(connectStat);
                        playInfoError2.setOldErrorCode(i);
                        playInfoUpsResponse.setUpsInfo(new NetUpsInfo(videoInfo));
                        playInfoUpsResponse.setError(playInfoError2);
                        Logger.d(TAG, "server err: " + i);
                        Logger.d(TAG, "note " + str4);
                    } else if (videoInfo.getStream() == null) {
                        playInfoError = new PlayInfoError();
                        playInfoError.setErrorCode(28001);
                        str = "UPS返回信息节点异常导致解析不到播放地址";
                    } else {
                        Logger.d(TAG, "ups to main thread");
                        NetUpsInfo netUpsInfo = new NetUpsInfo(videoInfo);
                        netUpsInfo.setDrmR1(this.mDrmR1);
                        netUpsInfo.setRaw(str3);
                        playInfoUpsResponse.setUpsInfo(netUpsInfo);
                        playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.NORMAL);
                        playInfoUpsResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                    }
                    reportResult(playInfoUpsResponse);
                }
                playInfoError = new PlayInfoError();
                playInfoError.setErrorCode(connectStat.response_code);
                str = connectStat.errMsg;
                playInfoError.setErrorMsg(str);
                playInfoError.setConnectStat(connectStat);
                playInfoUpsResponse.setError(playInfoError);
                reportResult(playInfoUpsResponse);
            }
            playInfoError = new PlayInfoError();
            playInfoError.setErrorCode(28001);
            str2 = "数据请求解析异常";
        }
        playInfoError.setErrorMsg(str2);
        playInfoUpsResponse.setError(playInfoError);
        reportResult(playInfoUpsResponse);
    }

    private int constructDrmType() {
        int value = DrmType.DEFAULT.getValue() | DrmType.COPYRIGHT.getValue();
        if (ProvisionAuthenticator.isCencSupported()) {
            value |= DrmType.WV_CENC.getValue();
        }
        if (ProvisionAuthenticator.isCbcsSupported()) {
            value |= DrmType.WV_CBCS.getValue();
        }
        return (Utils.isYoukuOrHuaweiBaipai(this.mContext) && AliSubtitleConfig.isAes128Supported()) ? value | DrmType.AES128.getValue() : value;
    }

    private NetworkParameter createNetworkParam() {
        NetworkParameter networkParameter = new NetworkParameter();
        networkParameter.connect_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        networkParameter.cookie = this.mPlayParams.getPlayIdParams().getString(HttpIntent.COOKIE);
        networkParameter.userAgent = this.mPlayerConfig.getUserAgent();
        networkParameter.read_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        return networkParameter;
    }

    private String getMediaType() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(Point.STANDARD);
        stringBuffer.append(",audio");
        if (ApsUtil.enableSubtitle()) {
            stringBuffer.append(",subtitle");
        }
        if (ApsUtil.enableSei()) {
            stringBuffer.append(",sei");
        }
        stringBuffer.append(",playconf");
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

    private void putParamWithoutNull(Map<String, String> map, PlayParams playParams, String str) {
        String string = playParams.getString(str, null);
        if (TextUtils.isEmpty(string)) {
            return;
        }
        map.put(str, string);
    }

    private void putParamWithoutNull(Map<String, String> map, Map<String, String> map2, String str) {
        String str2 = map.get(str);
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        map2.put(str, str2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void reportResult(PlayInfoResponse playInfoResponse) {
        if (this.mCallback == null || this.mIsCancel) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(playInfoResponse);
        this.mCallback.onFinished(this.mPlayParams, arrayList);
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public List<PlayInfoResponse> getPlayInfoResponses() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public PlayParams getPlayParams() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public IPlayInfoRequest.State getState() {
        return null;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        String playId;
        boolean z;
        StringBuilder sb;
        int value;
        MockTask mockTask;
        TLogUtil.playLog("request ups");
        this.mPlayParams = playParams;
        if (this.mIsCancel) {
            return;
        }
        PlayIdParams playIdParams = this.mPlayParams.getPlayIdParams();
        RequestParams requestParams = new RequestParams();
        requestParams.put("player_source", this.mPlayerConfig.getString(TableField.PLAYER_SOURCE));
        requestParams.put("extag", "EXT-X-PRIVINF");
        requestParams.put("skipPreVideo", "1");
        requestParams.put("tlogSession", this.mPlayParams.getSessionId());
        requestParams.put("brand", Build.getBRAND());
        requestParams.put(OConstant.CANDIDATE_OSVER, Build.VERSION.getRELEASE());
        requestParams.put("app_ver", Utils.getVersionName(this.mContext));
        UpsUtil.addUpsParams(this.mContext, requestParams);
        UpsUtil.addUpsParams(this.mContext, requestParams, this.mPlayParams);
        putParamWithoutNull(requestParams, playParams, "local_st");
        Map<String, String> dlnaParams = playIdParams.getDlnaParams();
        if (dlnaParams == null || dlnaParams.size() <= 0) {
            requestParams.put("master_m3u8", this.mPlayerConfig.isSupport("abrPlay") ? "1" : "0");
            requestParams.put("preferClarity", String.valueOf(this.mPlayParams.getPlayIdParams().getRequestQuality().getUpsCode()));
            requestParams.put("start_point_ms", playParams.getStartTime() + "");
            requestParams.put("skh", playIdParams.isSkipHeadTail() ? "1" : "0");
        } else {
            String[] strArr = {"client_src", "client_src", "pdevice_utid", "pdevice_model", "master_m3u8", "preferClarity", "spdl", "start_point_ms", "skh"};
            for (int i = 0; i < 9; i++) {
                String str = strArr[i];
                String str2 = dlnaParams.get(str);
                if (!TextUtils.isEmpty(str2)) {
                    requestParams.put(str, str2);
                }
            }
        }
        String str3 = "vid";
        if (PlayerUtil.isVid(playIdParams.getPlayId())) {
            playId = playIdParams.getPlayId();
        } else {
            requestParams.put("vid", "");
            playId = playIdParams.getPlayId();
            str3 = "showid";
        }
        requestParams.put(str3, playId);
        if (playIdParams.getVideoStage() != 0) {
            requestParams.put("show_videoseq", playIdParams.getVideoStage() + "");
        }
        requestParams.put("ccode", !TextUtils.isEmpty(playIdParams.getCCode()) ? playIdParams.getCCode() : this.mPlayerConfig.getCCode());
        requestParams.put(RequestParams.utid, UTDevice.getUtdid(this.mContext));
        requestParams.put(RequestParams.client_ip, NetworkUtil.getIp(this.mContext));
        requestParams.put(RequestParams.client_ts, String.valueOf(System.currentTimeMillis() / 1000));
        requestParams.put("point", "1");
        requestParams.put("audiolang", "1");
        boolean useSystemPlayer = PlayerManager.getInstance().useSystemPlayer();
        if (useSystemPlayer || playIdParams.isDisableH265()) {
            requestParams.put("h265", "0");
        } else {
            requestParams.put("h265", this.mPlayerConfig.isSupport("h265") ? "1" : "0");
        }
        putParamWithoutNull(playIdParams.getExtraParams(), requestParams, Constants.Value.PASSWORD);
        requestParams.put("network", UpsUtil.getNetType(this.mContext));
        requestParams.put("tq", "0");
        String dynamicProperty = this.mPlayerConfig.getDynamicProperty(CookieUtil.COOKIE_KEY_YKTK);
        String dynamicProperty2 = this.mPlayerConfig.getDynamicProperty(IRequestConst.STOKEN);
        String dynamicProperty3 = this.mPlayerConfig.getDynamicProperty("ptoken");
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && TextUtils.isEmpty(dynamicProperty2)) {
            dynamicProperty2 = Passport.getSToken();
        }
        requestParams.put(CookieUtil.COOKIE_KEY_YKTK, dynamicProperty);
        requestParams.put(IRequestConst.STOKEN, dynamicProperty2);
        requestParams.put("ptoken", dynamicProperty3);
        if (TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getAToken())) {
            z = false;
        } else {
            requestParams.put(IRequestConst.ATOKEN, this.mPlayParams.getPlayIdParams().getAToken());
            z = true;
        }
        if ("1".equals(playParams.getString("disableDrm")) || useSystemPlayer) {
            TLogUtil.flowLog(playParams.getSessionId(), "禁用drm，请求清流");
            sb = new StringBuilder();
            value = DrmType.DEFAULT.getValue();
        } else {
            sb = new StringBuilder();
            value = constructDrmType();
        }
        sb.append(value);
        sb.append("");
        requestParams.put("drm_type", sb.toString());
        try {
            if (this.mPlayerConfig.getDrmConfig() != null) {
                DrmManager.Result generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, this.mPlayerConfig.getDrmConfig().getKeyIndex(), this.mPlayerConfig.getDrmConfig().getAuthCode());
                String str4 = generateEncryptRClient.encryptR;
                this.mDrmR1 = generateEncryptRClient.R1;
                requestParams.put("encryptR_client", str4);
                requestParams.put("key_index", generateEncryptRClient.keyIndex);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        NetworkParameter createNetworkParam = createNetworkParam();
        PlayDefinition.NetworkType networkType = this.mPlayerConfig.getNetworkType();
        if ("1".equals(SystemUtil.getSystemProperty("debug.ups.get.mock", "0"))) {
            MockTask mockTask2 = new MockTask(this.mContext);
            this.mDrmR1 = mockTask2.getR1();
            mockTask = mockTask2;
        } else {
            mockTask = networkType == PlayDefinition.NetworkType.MTOP ? new MTopTask(this.mContext, getTimeOut(), this.mPlayParams.getUpsProxyInfo()) : new HttpConnectionTask();
        }
        INetworkTask iNetworkTask = mockTask;
        String string = this.mPlayParams.getPlayIdParams().getString("domain");
        String string2 = this.mPlayParams.getPlayIdParams().getString(TbAuthConstants.IP);
        this.mRequest = (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) ? new b(this.mContext, iNetworkTask, z) : new b(this.mContext, iNetworkTask, z, string, string2);
        RequestParams requestParams2 = new RequestParams();
        if (playParams.getPlayIdParams().isDisableAd()) {
            requestParams2.put(IRequestConst.NEED_AD, "0");
            requestParams2.put(IRequestConst.NEED_BF, "2");
        } else {
            requestParams2.putAll(AdUtil.getAdRequestParams(7));
        }
        if (playIdParams.isDisableBfAd()) {
            requestParams2.put(IRequestConst.NEED_BF, "0");
        }
        if (dlnaParams != null && dlnaParams.size() > 0) {
            requestParams.putAll(dlnaParams);
        }
        this.mRequest.a(requestParams, requestParams2, createNetworkParam, new a<VideoInfo>() { // from class: com.youku.playerservice.axp.playinfo.request.GetUpsRequest.1
            @Override // com.youku.ups.request.a
            public void onFailure(com.youku.ups.data.a aVar) {
                if (GetUpsRequest.this.mIsCancel) {
                    return;
                }
                PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(GetUpsRequest.this.mContext, GetUpsRequest.this.mPlayParams);
                playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                PlayInfoError playInfoError = new PlayInfoError();
                playInfoError.setErrorCode(aVar.a());
                playInfoError.setErrorMsg(aVar.b());
                playInfoUpsResponse.setError(playInfoError);
                GetUpsRequest.this.reportResult(playInfoUpsResponse);
            }

            @Override // com.youku.ups.request.a
            public void onSuccess(com.youku.ups.data.b<VideoInfo> bVar, ConnectStat connectStat) {
                if (GetUpsRequest.this.mIsCancel) {
                    return;
                }
                GetUpsRequest getUpsRequest = GetUpsRequest.this;
                getUpsRequest.checkResult(getUpsRequest.mPlayParams, bVar.a(), connectStat);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
