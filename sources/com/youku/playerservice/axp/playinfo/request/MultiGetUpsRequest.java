package com.youku.playerservice.axp.playinfo.request;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.ut.device.UTDevice;
import com.youku.alixplayer.opensdk.ups.request.UpsConstant;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.media.arch.instruments.ConfigFetcher;
import com.youku.network.HttpIntent;
import com.youku.playerservice.axp.axpinterface.AbsPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.IPlayInfoRequest;
import com.youku.playerservice.axp.axpinterface.PlayDefinition;
import com.youku.playerservice.axp.cache.CacheManager;
import com.youku.playerservice.axp.constants.NetType;
import com.youku.playerservice.axp.playinfo.NetUpsInfo;
import com.youku.playerservice.axp.playinfo.PlayInfoResponse;
import com.youku.playerservice.axp.playinfo.PlayInfoUpsResponse;
import com.youku.playerservice.axp.playinfo.request.task.OkHttpTask;
import com.youku.playerservice.axp.playparams.PlayParams;
import com.youku.playerservice.axp.utils.Logger;
import com.youku.playerservice.axp.utils.NetworkUtil;
import com.youku.playerservice.axp.utils.StreamTypeUtils;
import com.youku.playerservice.axp.utils.TLogUtil;
import com.youku.playerservice.axp.utils.Utils;
import com.youku.upsplayer.GetUps;
import com.youku.upsplayer.IMultiVideoInfoCallBack;
import com.youku.upsplayer.data.ConnectStat;
import com.youku.upsplayer.module.SimpleVideoInfo;
import com.youku.upsplayer.request.NetworkParameter;
import com.youku.upsplayer.request.PlayVideoInfo;
import com.youku.usercenter.passport.api.Passport;
import com.youku.vpm.constants.TableField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class MultiGetUpsRequest extends AbsPlayInfoRequest {
    private static final String TAG = "MultiGetUpsRequest";
    private IPlayInfoRequest.Callback mCallback;
    private Context mContext;
    private String mDrmR1;
    private boolean mIsCancel;
    private PlayParams mPlayParams;
    private GetUps mUps;

    /* compiled from: Taobao */
    /* renamed from: com.youku.playerservice.axp.playinfo.request.MultiGetUpsRequest$2  reason: invalid class name */
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

    public MultiGetUpsRequest(Context context) {
        this.mContext = context;
        this.mUps = new GetUps(this.mContext, new OkHttpTask(this.mContext, getTimeOut(), null));
    }

    private NetworkParameter createNetworkParam() {
        NetworkParameter networkParameter = new NetworkParameter();
        networkParameter.connect_timeout = VerifyActivity.ALIAUTH_CLIENT_ERROR_GENERIC;
        networkParameter.cookie = this.mPlayParams.getPlayIdParams().getString(HttpIntent.COOKIE);
        networkParameter.userAgent = "Axp-MultiGetUpsRequest";
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
    public void request(final PlayParams playParams) {
        TLogUtil.playLog("request ups");
        this.mPlayParams = playParams;
        if (playParams == null || playParams.getPlayIdParams() == null) {
            IPlayInfoRequest.Callback callback = this.mCallback;
            if (callback != null) {
                callback.onFinished(null, null);
                return;
            }
            return;
        }
        List<String> vids = playParams.getPlayIdParams().getVids();
        int upsCode = playParams.getPlayIdParams().getRequestQuality().getUpsCode();
        PlayVideoInfo playVideoInfo = new PlayVideoInfo();
        playVideoInfo.qxd = String.valueOf(upsCode);
        playVideoInfo.vid = vids.get(0);
        playVideoInfo.ccode = playParams.getPlayIdParams().getCCode();
        playVideoInfo.client_ip = NetworkUtil.getIp(this.mContext);
        playVideoInfo.client_ts = String.valueOf(System.currentTimeMillis() / 1000);
        playVideoInfo.app_ver = Utils.getVersionName(this.mContext);
        if (Utils.isYoukuOrHuaweiBaipai(this.mContext)) {
            playVideoInfo.stoken = Passport.getSToken();
        }
        int i = AnonymousClass2.$SwitchMap$com$youku$playerservice$axp$constants$NetType[NetworkUtil.getNetType(this.mContext).ordinal()];
        playVideoInfo.network = i != 1 ? (i == 2 || i == 3 || i == 4) ? UpsConstant.UPS_NETWORK_4G : UpsConstant.UPS_NETWORK_UNKOWN : "1000";
        playVideoInfo.utid = UTDevice.getUtdid(this.mContext);
        StringBuilder sb = new StringBuilder();
        for (String str : vids) {
            if (!TextUtils.isEmpty(str)) {
                sb.append(str);
                sb.append(",");
            }
        }
        if (sb.toString().length() > 0 && sb.toString().lastIndexOf(",") == sb.toString().length() - 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        playVideoInfo.vids = sb.toString();
        NetworkParameter createNetworkParam = createNetworkParam();
        AntiTheftChainParam antiTheftChainParam = new AntiTheftChainParam();
        antiTheftChainParam.setVid(playVideoInfo.vid);
        antiTheftChainParam.setServerEnv(0);
        antiTheftChainParam.setContext(this.mContext);
        antiTheftChainParam.setClientTs(playVideoInfo.client_ts);
        antiTheftChainParam.setAntiTheftChainClientType(AntiTheftChainClientType.Internal);
        antiTheftChainParam.setCcode(playVideoInfo.ccode);
        antiTheftChainParam.setClientIP(playVideoInfo.client_ip);
        antiTheftChainParam.setUtid(playVideoInfo.utid);
        this.mUps.setUpsType(2);
        this.mUps.setAntiTheftChainParam(antiTheftChainParam);
        TLogUtil.playLog("ups getMultiVideoUrl");
        HashMap hashMap = new HashMap();
        hashMap.put("player_source", this.mPlayParams.getPlayIdParams().getString(TableField.PLAYER_SOURCE));
        this.mUps.getMultiVideoInfo(playVideoInfo, hashMap, createNetworkParam, new IMultiVideoInfoCallBack() { // from class: com.youku.playerservice.axp.playinfo.request.MultiGetUpsRequest.1
            @Override // com.youku.upsplayer.IMultiVideoInfoCallBack
            public void onGetVideoInfoResult(List<SimpleVideoInfo> list, ConnectStat connectStat) {
                JSONObject jSONObject;
                JSONObject jSONObject2;
                TLogUtil.loge(CacheManager.TAG_MEDIASOURCE, "MultiMediaSourceCacheTask multiGetUps responseCode:" + connectStat.response_code);
                ArrayList arrayList = new ArrayList();
                if (list != null) {
                    for (SimpleVideoInfo simpleVideoInfo : list) {
                        if (simpleVideoInfo != null) {
                            PlayInfoUpsResponse playInfoUpsResponse = new PlayInfoUpsResponse(MultiGetUpsRequest.this.mContext, playParams);
                            playInfoUpsResponse.setInfoType(PlayDefinition.PlayInfoType.UPS);
                            playInfoUpsResponse.setUpsInfo(new NetUpsInfo(simpleVideoInfo));
                            playInfoUpsResponse.setRequestMode(PlayInfoResponse.RequestMode.MULTIGET);
                            playInfoUpsResponse.setTimeOfRequestEnd(System.currentTimeMillis());
                            arrayList.add(playInfoUpsResponse);
                            String rawData = simpleVideoInfo.getRawData();
                            if (!TextUtils.isEmpty(rawData)) {
                                try {
                                    JSONObject parseObject = JSON.parseObject(rawData);
                                    if (parseObject != null && (jSONObject = parseObject.getJSONObject("video")) != null && (jSONObject2 = jSONObject.getJSONObject("stream_ext")) != null) {
                                        Logger.d(MultiGetUpsRequest.TAG, "parse stream_ext 正常,开始更新");
                                        StreamTypeUtils.parseAndCacheStreamExt(jSONObject2.toString());
                                    }
                                } catch (JSONException e) {
                                    e.printStackTrace();
                                    Logger.d(MultiGetUpsRequest.TAG, "parse RawData 异常");
                                }
                            }
                        }
                    }
                }
                MultiGetUpsRequest.this.mCallback.onFinished(playParams, arrayList);
            }
        });
    }

    @Override // com.youku.playerservice.axp.axpinterface.IPlayInfoRequest
    public void setRequestCallback(IPlayInfoRequest.Callback callback) {
        this.mCallback = callback;
    }
}
