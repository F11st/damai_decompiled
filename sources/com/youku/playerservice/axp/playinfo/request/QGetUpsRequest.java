package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.taobao.orange.OConstant;
import com.tencent.connect.common.Constants;
import com.ut.device.UTDevice;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.AbsPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.constants.NetType;
import com.youku.playerservice.axp.drm.DrmManager;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.item.MediaMap;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.request.task.OkHttpTask;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.PlayerUtil;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.UpsUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.ups.data.RequestParams;
import com.youku.ups.data.b;
import com.youku.ups.request.a;
import com.youku.ups.request.c;
import com.youku.upsplayer.ParseResult;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.VideoCacheInfo;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.usercenter.passport.api.Passport;
import com.youku.usercenter.passport.util.CookieUtil;
import com.youku.vpm.constants.TableField;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class QGetUpsRequest extends AbsPlayInfoRequest {
    private static final String TAG = "QGetUpsRequest";
    private IPlayInfoRequest.Callback mCallback;
    private final Context mContext;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private final PlayerConfig mPlayerConfig;
    private c mUpsQGetRequest;

    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.playinfo.request.QGetUpsRequest$2  reason: invalid class name */
    /* loaded from: classes3.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$youku$playerservice$axp$constants$NetType;

        static {
            int[] iArr = new int[NetType.values().length];
            $SwitchMap$com$youku$playerservice$axp$constants$NetType = iArr;
            try {
                iArr[NetType.WIFI.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G2.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G3.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$youku$playerservice$axp$constants$NetType[NetType.G4.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public QGetUpsRequest(PlayerConfig playerConfig) {
        this.mPlayerConfig = playerConfig;
        Context context = playerConfig.getContext();
        this.mContext = context;
        this.mUpsQGetRequest = new c(context, new OkHttpTask(context, getTimeOut(), null));
    }

    private int constructDrmType() {
        int value = DrmType.DEFAULT.getValue() | DrmType.COPYRIGHT.getValue();
        if (ProvisionAuthenticator.isCencSupported()) {
            value |= DrmType.WV_CENC.getValue();
        }
        return ProvisionAuthenticator.isCbcsSupported() ? value | DrmType.WV_CBCS.getValue() : value;
    }

    private NetworkParameter createNetworkParam() {
        NetworkParameter networkParameter = new NetworkParameter();
        networkParameter.connect_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        networkParameter.cookie = this.mPlayParams.getPlayIdParams().getString(HttpIntent.COOKIE);
        networkParameter.userAgent = "Axp-QGetUpsRequest";
        networkParameter.read_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        return networkParameter;
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

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void cancel() {
        this.mIsCancel = true;
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void request(PlayParams playParams) {
        if (this.mIsCancel || playParams == null) {
            return;
        }
        this.mPlayParams = playParams;
        TLogUtil.playLog("ups getMultiMinVideoUrl");
        RequestParams requestParams = new RequestParams();
        UpsUtil.addUpsParams(this.mContext, requestParams);
        UpsUtil.addUpsParams(this.mContext, requestParams, this.mPlayParams);
        requestParams.putAll(this.mPlayParams.getPlayIdParams().getExtraParams());
        requestParams.put("preferClarity", String.valueOf(this.mPlayParams.getPlayIdParams().getRequestQuality().getUpsCode()));
        requestParams.put(RequestParams.client_ip, NetworkUtil.getIp(this.mContext));
        requestParams.put(RequestParams.client_ts, String.valueOf(System.currentTimeMillis() / 1000));
        requestParams.put(RequestParams.utid, UTDevice.getUtdid(this.mContext));
        requestParams.put("skh", PlayerUtil.isSkipHeadAndTail(this.mContext) ? "1" : "0");
        requestParams.put("ccode", !TextUtils.isEmpty(this.mPlayParams.getPlayIdParams().getCCode()) ? this.mPlayParams.getPlayIdParams().getCCode() : this.mPlayerConfig.getCCode());
        requestParams.put("drm_type", String.valueOf(constructDrmType()));
        requestParams.put("h265", this.mPlayerConfig.isSupport("h265") ? "1" : "0");
        if (ProvisionAuthenticator.getWidevineLevel() == ProvisionAuthenticator.WidevineLevel.L1) {
            requestParams.put("drm_level", "1");
        }
        String string = this.mPlayParams.getPlayIdParams().getString(TableField.PLAYER_SOURCE);
        requestParams.put("player_source", string);
        if (!Constants.VIA_REPORT_TYPE_START_WAP.equals(string)) {
            requestParams.put("master_m3u8", "1");
            requestParams.put("extag", URLEncoder.encode("EXT-X-PRIVINF"));
        }
        requestParams.put("d_type", MediaMap.getDolbyStreamType());
        requestParams.put("play_ability", UpsUtil.convertPlayerAbility(this.mPlayerConfig));
        requestParams.put("close_ability", UpsUtil.convertPlayerCloseAblity(this.mContext, this.mPlayerConfig));
        requestParams.put(CookieUtil.COOKIE_KEY_YKTK, this.mPlayerConfig.getDynamicProperty(CookieUtil.COOKIE_KEY_YKTK));
        requestParams.put(IRequestConst.STOKEN, this.mPlayerConfig.getDynamicProperty(IRequestConst.STOKEN));
        requestParams.put("ptoken", this.mPlayerConfig.getDynamicProperty("ptoken"));
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext) && TextUtils.isEmpty(requestParams.get(IRequestConst.STOKEN))) {
            requestParams.put(IRequestConst.STOKEN, Passport.getSToken());
        }
        requestParams.put("brand", Build.getBRAND());
        requestParams.put(OConstant.CANDIDATE_OSVER, Build.VERSION.getRELEASE());
        requestParams.put("app_ver", Utils.getVersionName(this.mContext));
        int i = AnonymousClass2.$SwitchMap$com$youku$playerservice$axp$constants$NetType[NetworkUtil.getNetType(this.mContext).ordinal()];
        requestParams.put("network", i != 1 ? (i == 2 || i == 3 || i == 4) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000");
        requestParams.put("net_status", com.youku.arch.analysis.net.c.a().b().a() + "");
        Logger.d(TAG, "播放请求前从安全保镖接口获取加密R1，将encryptR_client和key_index参数传给ups服务端");
        DrmManager.Result generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, this.mPlayerConfig.getDrmConfig().getKeyIndex(), this.mPlayerConfig.getDrmConfig().getAuthCode());
        String str = generateEncryptRClient.encryptR;
        final String str2 = generateEncryptRClient.R1;
        requestParams.put("encryptR_client", str);
        requestParams.put("key_index", generateEncryptRClient.keyIndex);
        this.mUpsQGetRequest.a(requestParams, createNetworkParam(), new a<List<VideoCacheInfo>>() { // from class: com.youku.playerservice.axp.playinfo.request.QGetUpsRequest.1
            @Override // com.youku.ups.request.a
            public void onFailure(com.youku.ups.data.a aVar) {
                PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(QGetUpsRequest.this.mContext, QGetUpsRequest.this.mPlayParams);
                playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                PlayInfoError playInfoError = new PlayInfoError();
                playInfoError.setErrorCode(aVar.a());
                playInfoError.setErrorMsg(aVar.b());
                playInfoUpsResponse.setError(playInfoError);
                ArrayList arrayList = new ArrayList();
                arrayList.add(playInfoUpsResponse);
                if (QGetUpsRequest.this.mCallback != null) {
                    QGetUpsRequest.this.mCallback.onFinished(QGetUpsRequest.this.mPlayParams, arrayList);
                }
            }

            @Override // com.youku.ups.request.a
            public void onSuccess(b<List<VideoCacheInfo>> bVar, ConnectStat connectStat) {
                if (connectStat != null) {
                    TLogUtil.playLog("qget ups url=" + connectStat.url);
                }
                ArrayList arrayList = new ArrayList();
                if (bVar == null || bVar.a() == null) {
                    Logger.d(QGetUpsRequest.TAG, "videoCacheInfoList = null ");
                    if (QGetUpsRequest.this.mCallback != null) {
                        QGetUpsRequest.this.mCallback.onFinished(QGetUpsRequest.this.mPlayParams, arrayList);
                        return;
                    }
                    return;
                }
                for (VideoCacheInfo videoCacheInfo : bVar.a()) {
                    if (videoCacheInfo != null) {
                        PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(QGetUpsRequest.this.mContext, QGetUpsRequest.this.mPlayParams);
                        playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                        playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.QGET);
                        VideoInfo videoInfo = !TextUtils.isEmpty(videoCacheInfo.errorCode) ? new VideoInfo() : ParseResult.parseJson1(videoCacheInfo.videoInfoStr);
                        videoInfo.setStream(ParseResult.parseStream(videoInfo.getStreamJson()));
                        NetUpsInfo netUpsInfo = new NetUpsInfo(videoInfo);
                        netUpsInfo.setRaw(videoCacheInfo.videoInfoStr);
                        netUpsInfo.setCacheKey(videoCacheInfo.cacheKey);
                        netUpsInfo.setDrmR1(str2);
                        netUpsInfo.setLangCode(videoCacheInfo.langeCode);
                        netUpsInfo.setQGetErrorCode(videoCacheInfo.errorCode);
                        netUpsInfo.setQGetErrorMsg(videoCacheInfo.errorMsg);
                        playInfoUpsResponse.setUpsInfo(netUpsInfo);
                        playInfoUpsResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                        arrayList.add(playInfoUpsResponse);
                    }
                }
                if (QGetUpsRequest.this.mCallback != null) {
                    QGetUpsRequest.this.mCallback.onFinished(QGetUpsRequest.this.mPlayParams, arrayList);
                }
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
