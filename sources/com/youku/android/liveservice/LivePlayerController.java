package com.youku.android.liveservice;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.tao.remotebusiness.IRemoteBaseListener;
import com.taobao.tao.remotebusiness.MtopBusiness;
import com.taobao.weex.annotation.JSMethod;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import com.youku.android.liveservice.bean.Artp;
import com.youku.android.liveservice.bean.BypassPlayInfo;
import com.youku.android.liveservice.bean.Grtn;
import com.youku.android.liveservice.bean.Hls;
import com.youku.android.liveservice.bean.HttpFlv;
import com.youku.android.liveservice.bean.LivePlayControl;
import com.youku.android.liveservice.bean.Mcs;
import com.youku.android.liveservice.bean.MicInfo;
import com.youku.android.liveservice.bean.MicPlayInfo;
import com.youku.android.liveservice.bean.Mu;
import com.youku.android.liveservice.bean.Quality;
import com.youku.android.liveservice.bean.Rtp;
import com.youku.android.liveservice.bean.VideoInfo;
import com.youku.android.liveservice.utils.DrmManager;
import com.youku.android.liveservice.utils.ErrorCodeHelper;
import com.youku.android.liveservice.utils.LiveOrangeUtil;
import com.youku.android.liveservice.utils.Logger;
import com.youku.android.liveservice.utils.MTopHelper;
import com.youku.android.liveservice.utils.UriHelper;
import com.youku.android.liveservice.utils.Utils;
import com.youku.antitheftchain.exception.AntiTheftChainException;
import com.youku.antitheftchain.interfaces.AntiTheftChainClientType;
import com.youku.antitheftchain.interfaces.AntiTheftChainFactory;
import com.youku.antitheftchain.interfaces.AntiTheftChainParam;
import com.youku.live.dago.liveplayback.widget.PluginName;
import com.youku.vpm.constants.TableField;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LivePlayerController {
    public static final String CLIENT_IP = "127.0.0.1";
    public static final int E_MD_END = 30999;
    public static final int E_MD_FORCE_LOGIN = 30650;
    public static final int E_MD_INVALID_LOGIN = 30201;
    public static final int E_MD_START = 30000;
    public static final int E_PCTRL_ARER_LIMIT = 40002;
    public static final int E_PCTRL_FULL = 40001;
    public static final int E_PCTRL_QUALITY_VIP = 1001;
    private static final String LIVE_PLAY_CONTROL_VERSION_V4 = "4.0";
    private static final String PLAY_CONTROL = "mtop.youku.live.com.liveplaycontrol";
    public static final int REQUEST_QUALITY = LiveOrangeUtil.getChannelQuality();
    public static final String SDK_VERSION = "1.2.2";
    public static final int STATUS_OK = 200;
    private static final String TAG = "LivePlayerController";
    private String broadcastVideoCode;
    private String mAppKey;
    private String mCCode;
    private String mCCode4ott;
    private String mCkey;
    private Context mContext;
    private String mCurPcdnPlayUrl;
    private String mCurPlayUrl;
    private int mLastQuality;
    private String mLiveId;
    private LivePlayControl mLivePlayControl;
    private int mLiveState;
    private IPlayControlListener mPlayContorlListener;
    private long mStartTime;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    public interface IPlayControlListener {
        void requestFailure(LivePlayControl livePlayControl, int i, String str);

        void requestSuccess(VideoInfo videoInfo);
    }

    public LivePlayerController(String str) {
        this(str, null, "", "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean containLoginYtid(LivePlayControl livePlayControl) {
        MicInfo micInfo;
        List<Mcs> list;
        String str;
        String str2;
        if (livePlayControl == null || (micInfo = livePlayControl.micInfo) == null || (list = micInfo.mcs) == null || list.size() <= 0) {
            return false;
        }
        for (Mcs mcs : livePlayControl.micInfo.mcs) {
            Mu mu = mcs.mu;
            if (mu != null && (str = mu.u) != null && (str2 = livePlayControl.loginYtid) != null && str2.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private void doRequest(String str, String str2, Map<String, String> map, boolean z, boolean z2, IRemoteBaseListener iRemoteBaseListener) {
        MtopBusiness build;
        MtopRequest mtopRequest = new MtopRequest();
        MTopHelper.buildMtopRequest(mtopRequest, str, str2, z2, map);
        Mtop mtop = MTopHelper.getMtop();
        if (mtop != null) {
            build = MtopBusiness.build(mtop, mtopRequest);
        } else {
            build = MtopBusiness.build(Mtop.instance(this.mContext), mtopRequest);
        }
        MTopHelper.buildMtopBusiness(build, str, map, z, iRemoteBaseListener);
        if (Utils.isYoukuOrBaipai(this.mContext) && Utils.enableNewDomain()) {
            build.setCustomDomain("live-acs.youku.com", "pre-live-acs.youku.com", "daily-acs.youku.com");
        }
        build.startRequest();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static BypassPlayInfo getBypassPlayInfo(String str, LivePlayControl livePlayControl, String str2, String str3) {
        String str4 = livePlayControl.liveId;
        int i = livePlayControl.liveStatus;
        Quality defaultQuality = livePlayControl.getDefaultQuality();
        if (defaultQuality == null) {
            return null;
        }
        BypassPlayInfo bypassPlayInfo = new BypassPlayInfo();
        bypassPlayInfo.livePlayControl = livePlayControl;
        bypassPlayInfo.livePlayControlContent = str3;
        bypassPlayInfo.ccode = str;
        String str5 = defaultQuality.playurl;
        String str6 = defaultQuality.h265PlayUrl;
        if (str5 != null) {
            if (!str5.equals(null) && !TextUtils.isEmpty(null)) {
                bypassPlayInfo.url = null;
                bypassPlayInfo.isP2p = true;
            } else {
                bypassPlayInfo.url = str5;
                bypassPlayInfo.isP2p = false;
            }
        }
        long j = livePlayControl.now;
        long j2 = livePlayControl.endTimestamp;
        if (j > j2) {
            livePlayControl.now = j2;
        }
        long j3 = livePlayControl.startTimestamp;
        int i2 = livePlayControl.timeShiftOffset;
        if (i2 + j3 > livePlayControl.now || i2 + j3 > j2) {
            livePlayControl.timeShiftOffset = -1;
        }
        int i3 = livePlayControl.timeShiftOffset;
        if (i3 >= 0 && i3 < j2) {
            long j4 = (i3 * 1000) + (j3 * 1000);
            bypassPlayInfo.url = UriHelper.appendUriParameter(bypassPlayInfo.url, "lhs_start", stampToDate(j4));
            str6 = defaultQuality.h265PlayUrl;
            if (!TextUtils.isEmpty(str6)) {
                str6 = UriHelper.appendUriParameter(str6, "lhs_start", stampToDate(j4));
            }
        }
        bypassPlayInfo.definition = defaultQuality.name;
        bypassPlayInfo.qualityCode = defaultQuality.code;
        bypassPlayInfo.h265 = defaultQuality.h265;
        bypassPlayInfo.h265PlayUrl = str6;
        HashMap hashMap = new HashMap();
        hashMap.put("liveUrl", str5 + "&vip=0");
        hashMap.put("liveAdFlag", 1);
        hashMap.put("liveState", Integer.valueOf(i));
        hashMap.put("liveid", str4);
        hashMap.put("screenid", livePlayControl.screenId);
        hashMap.put(Constants.Name.QUALITY, String.valueOf(defaultQuality.quality));
        hashMap.put(TableField.DRM_TYPE, livePlayControl.drm ? "2" : "0");
        hashMap.put(TableField.IS_VIP, "0");
        hashMap.put(TableField.PS_ID, livePlayControl.psid);
        if (str5 != null) {
            if (!str5.equals(null) && !TextUtils.isEmpty(null)) {
                hashMap.put("cdnType", "3");
            } else {
                hashMap.put("cdnType", "1");
            }
        }
        bypassPlayInfo.utParams = hashMap;
        bypassPlayInfo.encryptRServer = livePlayControl.eRs;
        bypassPlayInfo.copyrightKey = livePlayControl.cRk;
        bypassPlayInfo.drmType = livePlayControl.drm ? 2 : 0;
        bypassPlayInfo.adJsonStr = livePlayControl.adJsonStr;
        bypassPlayInfo.subtitleUrl = livePlayControl.subtitleUrl;
        bypassPlayInfo.quality = defaultQuality.quality;
        bypassPlayInfo.playType = defaultQuality.playType;
        bypassPlayInfo.bitStream = defaultQuality.bitStream;
        bypassPlayInfo.smooth = false;
        if (i == 0) {
            if (!TextUtils.isEmpty("")) {
                bypassPlayInfo.vid = "";
            }
        } else if (i != 1 && i == 2 && !TextUtils.isEmpty("")) {
            bypassPlayInfo.vid = "";
        }
        return bypassPlayInfo;
    }

    public static String getCustomCKey(Context context, String str, Map<String, String> map) {
        String str2;
        AntiTheftChainParam antiTheftChainParam = new AntiTheftChainParam();
        antiTheftChainParam.setServerEnv(0);
        antiTheftChainParam.setCcode(str);
        antiTheftChainParam.setClientIP(map.get(TbAuthConstants.CLIENT_IP));
        antiTheftChainParam.setContext(context);
        antiTheftChainParam.setUtid(UTDevice.getUtdid(context));
        if ((map.get("liveId") instanceof String) && !TextUtils.isEmpty(map.get("liveId"))) {
            antiTheftChainParam.setVid(map.get("liveId"));
        }
        antiTheftChainParam.setClientTs(String.valueOf(System.currentTimeMillis()));
        antiTheftChainParam.setAntiTheftChainClientType(AntiTheftChainClientType.Internal);
        try {
            str2 = AntiTheftChainFactory.create().getCkey(antiTheftChainParam);
        } catch (AntiTheftChainException e) {
            e.printStackTrace();
            str2 = null;
        }
        if (Logger.DEBUG) {
            String str3 = TAG;
            Logger.d(str3, "getCKey cKey = " + str2);
        }
        return str2;
    }

    private String getEncyptX() {
        String generateEncryptRClient = DrmManager.generateEncryptRClient(this.mContext, this.mAppKey, "");
        String r1 = DrmManager.getR1();
        String encodeBase64 = DrmManager.encodeBase64(generateEncryptRClient);
        if (Logger.DEBUG) {
            String str = TAG;
            Logger.d(str, "getEncyptX drmR1=" + r1 + " drmX=" + generateEncryptRClient);
        }
        return encodeBase64;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static List<MicPlayInfo> getMicPlayInfos(LivePlayControl livePlayControl) {
        ArrayList arrayList = new ArrayList();
        if (livePlayControl.micInfo.mcs.size() > 0) {
            for (Mcs mcs : livePlayControl.micInfo.mcs) {
                MicPlayInfo micPlayInfo = new MicPlayInfo();
                micPlayInfo.rtp = getPlayRtp(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.flv = getPlayFlv(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.artp = getPlayArtp(mcs, livePlayControl.micInfo.dfi);
                micPlayInfo.grtn = getPlayGrtn(mcs, livePlayControl.micInfo.dfi);
                arrayList.add(micPlayInfo);
            }
        }
        return arrayList;
    }

    private static Artp getPlayArtp(Mcs mcs, int i) {
        List<Artp> list = mcs.ms.playInfo.artp;
        if (list != null && list.size() > 0) {
            for (Artp artp : mcs.ms.playInfo.artp) {
                if (artp.idx == i) {
                    return artp;
                }
            }
        }
        return null;
    }

    private static HttpFlv getPlayFlv(Mcs mcs, int i) {
        List<HttpFlv> list = mcs.ms.playInfo.httpFlv;
        if (list != null && list.size() > 0) {
            for (HttpFlv httpFlv : mcs.ms.playInfo.httpFlv) {
                if (httpFlv.idx == i) {
                    return httpFlv;
                }
            }
        }
        return null;
    }

    private static Grtn getPlayGrtn(Mcs mcs, int i) {
        List<Grtn> list = mcs.ms.playInfo.grtn;
        if (list != null && list.size() > 0) {
            for (Grtn grtn : mcs.ms.playInfo.grtn) {
                if (grtn.idx == i) {
                    return grtn;
                }
            }
        }
        return null;
    }

    private static Hls getPlayHls(Mcs mcs, int i) {
        List<Hls> list = mcs.ms.playInfo.hls;
        if (list != null && list.size() > 0) {
            for (Hls hls : mcs.ms.playInfo.hls) {
                if (hls.idx == i) {
                    return hls;
                }
            }
        }
        return null;
    }

    private static Rtp getPlayRtp(Mcs mcs, int i) {
        List<Rtp> list = mcs.ms.playInfo.rtp;
        if (list != null && list.size() > 0) {
            for (Rtp rtp : mcs.ms.playInfo.rtp) {
                if (rtp.idx == i) {
                    return rtp;
                }
            }
        }
        return null;
    }

    public static String stampToDate(long j) {
        String format = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date(j));
        Log.e("fornia", "offset url播放date点:" + format + " time url播放时间点:" + j);
        return format;
    }

    public String getCKey() {
        return this.mCkey;
    }

    public void getPlayControl(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z) {
        getPlayControl(str, str2, str3, str4, str5, str6, str7, str8, str9, z, "");
    }

    public void setLiveState(int i) {
        this.mLiveState = i;
    }

    public void setPlayControlListener(IPlayControlListener iPlayControlListener) {
        this.mPlayContorlListener = iPlayControlListener;
    }

    public LivePlayerController(String str, Context context, String str2, String str3) {
        this(str, context, str2, "", str3);
    }

    public void getPlayControl(String str, String str2, final String str3, String str4, String str5, String str6, String str7, String str8, String str9, boolean z, String str10) {
        this.mStartTime = System.currentTimeMillis();
        final String str11 = z ? this.mCCode4ott : this.mCCode;
        HashMap hashMap = new HashMap();
        hashMap.put("liveId", str + JSMethod.NOT_SET + str2);
        hashMap.put(TbAuthConstants.CLIENT_IP, CLIENT_IP);
        String customCKey = getCustomCKey(this.mContext, str11, hashMap);
        this.mCkey = customCKey;
        HashMap hashMap2 = new HashMap();
        hashMap2.put("liveId", str);
        hashMap2.put("sceneId", str2);
        hashMap2.put("sdkVersion", SDK_VERSION);
        hashMap2.put("app", "android");
        hashMap2.put("ckey", customCKey);
        hashMap2.put(PluginName.AD, str4);
        hashMap2.put("ccode", str11);
        hashMap2.put(PluginName.AD, str4);
        hashMap2.put("cna", "");
        hashMap2.put("keyIndex", this.mAppKey);
        hashMap2.put("encryptRClient", getEncyptX());
        if (!TextUtils.isEmpty(str3)) {
            hashMap2.put("reqQuality", str3);
        }
        hashMap2.put("playAbilities", str5);
        hashMap2.put("refer", str7);
        hashMap2.put("userQualityRecord", str9);
        if (!TextUtils.isEmpty(str6)) {
            hashMap2.put("params", str6);
        }
        if (!TextUtils.isEmpty(str10)) {
            hashMap2.put(TableField.PS_ID, str10);
        }
        hashMap2.put("osVersion", Build.VERSION.getRELEASE());
        hashMap2.put("deviceType", Utils.URLEncoder(Build.getMODEL()));
        hashMap2.put("chipset", Utils.getCpuName());
        hashMap2.put("network", Utils.getUpsNetworkType(this.mContext));
        if (Logger.DEBUG) {
            String str12 = TAG;
            Logger.d(str12, "getPlayControl params = " + hashMap2);
        }
        doRequest("mtop.youku.live.com.liveplaycontrol", "4.0", hashMap2, true, false, new IRemoteBaseListener() { // from class: com.youku.android.liveservice.LivePlayerController.1
            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            public void onError(int i, MtopResponse mtopResponse, Object obj) {
                IPlayControlListener iPlayControlListener = LivePlayerController.this.mPlayContorlListener;
                if (Logger.DEBUG) {
                    String str13 = LivePlayerController.TAG;
                    Logger.d(str13, "getPlayControl oError mtopResponse = " + mtopResponse);
                }
                if (iPlayControlListener != null) {
                    iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_ERROR, "");
                }
            }

            /* JADX WARN: Removed duplicated region for block: B:83:0x0199 A[Catch: JSONException -> 0x0243, TryCatch #0 {JSONException -> 0x0243, blocks: (B:6:0x0033, B:8:0x0060, B:14:0x0072, B:16:0x0076, B:18:0x0082, B:19:0x008a, B:21:0x009b, B:22:0x00a8, B:26:0x00b5, B:30:0x00bd, B:32:0x00c1, B:38:0x00cc, B:46:0x00da, B:48:0x00de, B:51:0x00eb, B:81:0x0166, B:83:0x0199, B:85:0x019d, B:87:0x01b9, B:89:0x01c3, B:91:0x01c8, B:90:0x01c6, B:93:0x01cf, B:95:0x01d7, B:99:0x01e1, B:100:0x01e5, B:102:0x0203, B:104:0x0209, B:106:0x020d, B:108:0x0211, B:110:0x0217, B:112:0x021c, B:111:0x021a, B:53:0x00f5, B:55:0x00ff, B:57:0x0107, B:60:0x0112, B:62:0x011a, B:64:0x011e, B:66:0x0124, B:67:0x012d, B:69:0x0134, B:70:0x013b, B:72:0x0145, B:74:0x014c, B:76:0x0153, B:78:0x0157, B:80:0x015d, B:113:0x0220, B:115:0x0227, B:117:0x022e, B:120:0x0237, B:124:0x023f), top: B:131:0x0033 }] */
            /* JADX WARN: Removed duplicated region for block: B:85:0x019d A[Catch: JSONException -> 0x0243, TryCatch #0 {JSONException -> 0x0243, blocks: (B:6:0x0033, B:8:0x0060, B:14:0x0072, B:16:0x0076, B:18:0x0082, B:19:0x008a, B:21:0x009b, B:22:0x00a8, B:26:0x00b5, B:30:0x00bd, B:32:0x00c1, B:38:0x00cc, B:46:0x00da, B:48:0x00de, B:51:0x00eb, B:81:0x0166, B:83:0x0199, B:85:0x019d, B:87:0x01b9, B:89:0x01c3, B:91:0x01c8, B:90:0x01c6, B:93:0x01cf, B:95:0x01d7, B:99:0x01e1, B:100:0x01e5, B:102:0x0203, B:104:0x0209, B:106:0x020d, B:108:0x0211, B:110:0x0217, B:112:0x021c, B:111:0x021a, B:53:0x00f5, B:55:0x00ff, B:57:0x0107, B:60:0x0112, B:62:0x011a, B:64:0x011e, B:66:0x0124, B:67:0x012d, B:69:0x0134, B:70:0x013b, B:72:0x0145, B:74:0x014c, B:76:0x0153, B:78:0x0157, B:80:0x015d, B:113:0x0220, B:115:0x0227, B:117:0x022e, B:120:0x0237, B:124:0x023f), top: B:131:0x0033 }] */
            /* JADX WARN: Removed duplicated region for block: B:92:0x01cd  */
            @Override // com.taobao.tao.remotebusiness.IRemoteListener
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void onSuccess(int r12, mtopsdk.mtop.domain.MtopResponse r13, mtopsdk.mtop.domain.BaseOutDo r14, java.lang.Object r15) {
                /*
                    Method dump skipped, instructions count: 589
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.youku.android.liveservice.LivePlayerController.AnonymousClass1.onSuccess(int, mtopsdk.mtop.domain.MtopResponse, mtopsdk.mtop.domain.BaseOutDo, java.lang.Object):void");
            }

            @Override // com.taobao.tao.remotebusiness.IRemoteBaseListener
            public void onSystemError(int i, MtopResponse mtopResponse, Object obj) {
                if (Logger.DEBUG) {
                    String str13 = LivePlayerController.TAG;
                    Logger.d(str13, "getPlayControl onSystemError mtopResponse = " + mtopResponse);
                }
                IPlayControlListener iPlayControlListener = LivePlayerController.this.mPlayContorlListener;
                if (iPlayControlListener != null) {
                    iPlayControlListener.requestFailure(null, ErrorCodeHelper.LIVE_ERROR_PLAYCONTROL_REQUEST_SYSTEM_ERROR, mtopResponse.getRetCode());
                }
            }
        });
    }

    public LivePlayerController(String str, Context context, String str2, String str3, String str4) {
        this.mLastQuality = -1;
        this.mLiveId = str == null ? "" : str;
        this.mContext = context;
        this.mCCode = str2 == null ? "" : str2;
        this.mCCode4ott = str3 == null ? "" : str3;
        this.mAppKey = str4 == null ? "" : str4;
    }
}
