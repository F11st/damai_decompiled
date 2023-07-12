package com.youku.alixplayer.opensdk;

import android.content.Context;
import android.text.TextUtils;
import anet.channel.strategy.C0213a;
import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.youku.alixplayer.opensdk.utils.PlayerUtil;
import com.youku.android.liveservice.LivePlayerController;
import com.youku.live.dsl.config.IRemoteConfigImp;
import com.youku.media.arch.instruments.ConfigFetcher;
import java.lang.reflect.Method;
import java.util.HashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AXPParamsProvider {
    private static final String APP_MONITOR_MODULE_NAME = "YoukuLiveAlarm";
    private static final String APP_MONITOR_PONT_NAME = "cms_maldivesckey";
    public static final String AXPParamsProviderOrangeKeyMaldivesLiveIdsKeyString = "maldives_liveIds";
    public static final String AXPParamsProviderOrangeKeyPlayAbilitiesKeyString = "playAbilitiesKeysString";
    public static final String AXPParamsProviderOrangeNamespace = "YKLiveRoom_ABTest";
    private static final String CLIENT_IP_DEFAULT = "127.0.0.1";
    private static final String DISABLE = "0";
    private static final String ENABLE = "1";
    private static final String ERROR_CODE_COMPUTE_EXCEPTION = "1200";
    private static final String ERROR_CODE_LIVE_IDS_ERROR = "1100";
    private static final String ERROR_CODE_PARAMS_ERROR = "1000";
    private static final String JSON_PLAY_ABILITIES = "pa";
    private static final String MALDIVES_LIVE_IDS_DEFAULT = "";
    private static final String PLAY_ABILITIES_DEFAULT = "abrPlay,decode";
    private static final String SPLIT_CHAR = ",";
    private static final String VALUE_NIL = "";
    public static final String YKLRequestParameterKeyMaldives = "maldivesckey";
    @Deprecated
    private static final String YOUKU_ANDROID_PHONE_CCODE = "live01010101";
    private static String sClientType;
    private static String sLiveCCode;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class AlarmMonitor {
        private StringBuilder args;
        private String errorCode;
        private String errorMessage;
        private final String moduleName;
        private final String pointName;

        public AlarmMonitor(String str, String str2) {
            this.moduleName = str;
            this.pointName = str2;
        }

        public AlarmMonitor commitFailure(String str, String str2) {
            this.errorCode = str;
            this.errorMessage = str2;
            AppMonitor.Alarm.commitFail(this.moduleName, this.pointName, str, str2);
            return this;
        }

        public AlarmMonitor commitSuccess() {
            String str = this.moduleName;
            String str2 = this.pointName;
            StringBuilder sb = this.args;
            AppMonitor.Alarm.commitSuccess(str, str2, sb != null ? sb.toString() : "");
            return this;
        }

        public AlarmMonitor putArg(String str, String str2) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                StringBuilder sb = this.args;
                if (sb == null) {
                    this.args = new StringBuilder();
                } else {
                    sb.append(",");
                }
                StringBuilder sb2 = this.args;
                sb2.append(str);
                sb2.append("=");
                sb2.append(str2);
            }
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class ClientType {
        public static final String LAIFENG = "com.youku.crazytogether";
        public static final String UNKNOWN = "";
        public static final String YOUKU = "com.youku.phone";
        public static final String YOUKU_HWBAIPAI = "com.huawei.hwvplayer.youku";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static class DslRemoteConfig {
        private static DslRemoteConfig sInstance;
        private Object instanceRemoteConfig;
        private Method methodRemoteConfigGetString;

        private DslRemoteConfig() {
            initReflect();
        }

        private String getConfigFromConfigFetcher(String str, String str2, String str3) {
            return ConfigFetcher.getInstance().getConfig(str, str2, str3);
        }

        private String getConfigFromRemoteConfig(String str, String str2, String str3) {
            Object obj;
            Method method = this.methodRemoteConfigGetString;
            if (method != null && (obj = this.instanceRemoteConfig) != null) {
                try {
                    return (String) method.invoke(obj, str, str2, str3);
                } catch (Throwable unused) {
                }
            }
            return getConfigFromConfigFetcher(str, str2, str3);
        }

        public static DslRemoteConfig getInstance() {
            if (sInstance == null) {
                synchronized (DslRemoteConfig.class) {
                    if (sInstance == null) {
                        sInstance = new DslRemoteConfig();
                    }
                }
            }
            return sInstance;
        }

        private void initReflect() {
            try {
                Method method = IRemoteConfigImp.class.getMethod("getInstance", new Class[0]);
                this.methodRemoteConfigGetString = IRemoteConfigImp.class.getMethod("getString", String.class, String.class, String.class);
                this.instanceRemoteConfig = method.invoke(null, new Object[0]);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public String getConfig(String str, String str2, String str3) {
            return getConfigFromRemoteConfig(str, str2, str3);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    private static class PerfMonitor {
        private DimensionValueSet dimensionValueSet;
        private MeasureValueSet measureValueSet;
        private final String moduleName;
        private final String pointName;
        private long timestampStepBegin;
        private long timestampTotalBegin;

        public PerfMonitor(String str, String str2) {
            this.moduleName = str;
            this.pointName = str2;
        }

        public PerfMonitor commit() {
            AppMonitor.Stat.commit(this.moduleName, this.pointName, this.dimensionValueSet, this.measureValueSet);
            return this;
        }

        public PerfMonitor putDimension(String str, String str2) {
            if (this.dimensionValueSet == null) {
                this.dimensionValueSet = DimensionValueSet.create();
            }
            this.dimensionValueSet.setValue(str, str2);
            return this;
        }

        public PerfMonitor putStepMeasure(String str) {
            if (this.measureValueSet == null) {
                this.measureValueSet = MeasureValueSet.create();
            }
            this.measureValueSet.setValue(str, this.timestampStepBegin - System.currentTimeMillis());
            return this;
        }

        public PerfMonitor putTotalMeasure(String str) {
            if (this.measureValueSet == null) {
                this.measureValueSet = MeasureValueSet.create();
            }
            this.measureValueSet.setValue(str, this.timestampTotalBegin - System.currentTimeMillis());
            return this;
        }

        public PerfMonitor setStepBegin() {
            this.timestampStepBegin = System.currentTimeMillis();
            return this;
        }

        public PerfMonitor setTotalBegin() {
            this.timestampTotalBegin = System.currentTimeMillis();
            return this;
        }
    }

    private static String getClientType(Context context) {
        String str = sClientType;
        if (str != null) {
            return str;
        }
        String str2 = context.getApplicationInfo().packageName;
        if (ClientType.YOUKU.equals(str2)) {
            sClientType = ClientType.YOUKU;
        } else if (ClientType.LAIFENG.equals(str2)) {
            sClientType = ClientType.LAIFENG;
        } else if (ClientType.YOUKU_HWBAIPAI.equals(str2)) {
            sClientType = ClientType.YOUKU_HWBAIPAI;
        } else {
            sClientType = "";
        }
        return sClientType;
    }

    private static String getLiveCCode(Context context) {
        String str = sLiveCCode;
        if (str != null) {
            return str;
        }
        String str2 = "live01010101";
        if (context != null) {
            String clientType = getClientType(context);
            if (!ClientType.YOUKU.equals(clientType)) {
                if (ClientType.LAIFENG.equals(clientType)) {
                    str2 = "live01010101laifeng";
                } else if (ClientType.YOUKU_HWBAIPAI.equals(clientType)) {
                    str2 = "live01060101";
                }
            }
        }
        sLiveCCode = str2;
        return str2;
    }

    public static String getMaldivesCKey(Context context) {
        AlarmMonitor alarmMonitor = new AlarmMonitor(APP_MONITOR_MODULE_NAME, APP_MONITOR_PONT_NAME);
        try {
            String maldivesCKeyInternal = getMaldivesCKeyInternal(context, alarmMonitor);
            if (!"".equals(maldivesCKeyInternal)) {
                alarmMonitor.commitSuccess();
            }
            return maldivesCKeyInternal;
        } catch (Throwable th) {
            alarmMonitor.commitFailure(ERROR_CODE_COMPUTE_EXCEPTION, "compute exception : " + th.getMessage());
            return "";
        }
    }

    private static String getMaldivesCKeyInternal(Context context, AlarmMonitor alarmMonitor) {
        String[] split;
        if (context == null) {
            if (alarmMonitor != null) {
                alarmMonitor.commitFailure("1000", "context null point");
            }
            return "";
        } else if ("1".equals(DslRemoteConfig.getInstance().getConfig("YKLiveRoom_ABTest", "enable_maldives", "1"))) {
            String clientIp = C0213a.a().getClientIp();
            if (TextUtils.isEmpty(clientIp)) {
                clientIp = "127.0.0.1";
            }
            HashMap hashMap = new HashMap();
            hashMap.put(TbAuthConstants.CLIENT_IP, clientIp);
            JSONObject jSONObject = new JSONObject();
            JSONObject abilityJsonInJsonObject = PlayerUtil.getAbilityJsonInJsonObject();
            if (abilityJsonInJsonObject == null) {
                if (alarmMonitor != null) {
                    alarmMonitor.commitFailure(ERROR_CODE_LIVE_IDS_ERROR, "empty play ability");
                }
                return "";
            }
            try {
                JSONObject jSONObject2 = new JSONObject();
                String config = DslRemoteConfig.getInstance().getConfig("YKLiveRoom_ABTest", AXPParamsProviderOrangeKeyPlayAbilitiesKeyString, PLAY_ABILITIES_DEFAULT);
                if (!TextUtils.isEmpty(config) && (split = config.split(",")) != null && split.length > 0) {
                    for (String str : split) {
                        if (!TextUtils.isEmpty(str) && abilityJsonInJsonObject.has(str)) {
                            jSONObject2.put(str, abilityJsonInJsonObject.get(str));
                        }
                    }
                }
                if (jSONObject2.length() > 0) {
                    jSONObject.put("pa", jSONObject2);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
            String liveCCode = getLiveCCode(context);
            if (TextUtils.isEmpty(liveCCode)) {
                if (alarmMonitor != null) {
                    alarmMonitor.commitFailure(ERROR_CODE_LIVE_IDS_ERROR, "empty live ccode");
                }
                return "";
            }
            try {
                jSONObject.put("ckey", LivePlayerController.getCustomCKey(context, liveCCode, hashMap));
                jSONObject.put("ccode", liveCCode);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            return jSONObject.toString();
        } else {
            return "";
        }
    }
}
