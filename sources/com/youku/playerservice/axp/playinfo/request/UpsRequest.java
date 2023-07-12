package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.youku.alisubtitle.subtitle.AliSubtitleConfig;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.PlayerConfig;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.constants.NetType;
import com.youku.playerservice.axp.drm.ProvisionAuthenticator;
import com.youku.playerservice.axp.item.DrmType;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoError;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.Point;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.ApsUtil;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.upsplayer.IUpsInfoRequest;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.AntiTheftChainUtLogType;
import com.youku.upsplayer.module.UtAntiTheaftBean;
import com.youku.upsplayer.module.VideoInfo;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.util.AntiTheftChainUtUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UpsRequest implements IPlayInfoRequest {
    private static final String TAG = "UpsRequest";
    private IPlayInfoRequest.Callback mCallback;
    private Context mContext;
    private String mDrmR1;
    private volatile boolean mIsCancel;
    private PlayParams mPlayParams;
    private PlayerConfig mPlayerConfig;
    private IUpsInfoRequest mRequest;

    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.playinfo.request.UpsRequest$2  reason: invalid class name */
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

    public UpsRequest(PlayerConfig playerConfig) {
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

    /* JADX WARN: Can't wrap try/catch for region: R(35:5|(5:139|(1:141)(1:147)|142|(1:144)(1:146)|145)(3:9|(3:11|(2:13|14)(1:16)|15)|17)|18|(1:20)(1:138)|21|(1:23)|24|(1:26)(1:137)|27|(7:118|(1:136)(3:122|(1:124)(1:135)|125)|126|(1:128)|129|(1:134)(1:132)|133)(31:31|(1:33)|34|(1:36)|37|(1:39)|40|(1:42)|43|(1:45)|46|(1:48)|50|(2:52|(1:116)(1:58))(1:117)|59|(1:63)|64|(1:66)|67|68|69|(4:71|(1:73)(1:77)|74|75)|78|(1:80)(2:110|(1:112)(1:113))|81|82|(1:109)(1:86)|87|(4:102|(1:104)(1:108)|105|(1:107))(6:91|(1:93)|94|(1:96)|97|(1:99))|100|101)|49|50|(0)(0)|59|(2:61|63)|64|(0)|67|68|69|(0)|78|(0)(0)|81|82|(1:84)|109|87|(1:89)|102|(0)(0)|105|(0)|100|101) */
    /* JADX WARN: Code restructure failed: missing block: B:108:0x0396, code lost:
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:109:0x0397, code lost:
        r0.printStackTrace();
     */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0306 A[Catch: Exception -> 0x0396, TryCatch #0 {Exception -> 0x0396, blocks: (B:99:0x02fe, B:101:0x0306, B:103:0x0337, B:104:0x0339, B:106:0x0341, B:105:0x033c), top: B:146:0x02fe }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x03bf  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x0468  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x0476  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0481  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x02e9  */
    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void request(com.youku.playerservice.axp.playparams.PlayParams r20) {
        /*
            Method dump skipped, instructions count: 1171
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.playerservice.axp.playinfo.request.UpsRequest.request(com.youku.playerservice.axp.playparams.PlayParams):void");
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
