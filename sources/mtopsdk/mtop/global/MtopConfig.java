package mtopsdk.mtop.global;

import android.content.Context;
import androidx.annotation.NonNull;
import anetwork.network.cache.Cache;
import java.io.InputStream;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicBoolean;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.manager.FilterManager;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.common.MtopStatsListener;
import mtopsdk.mtop.domain.EntranceEnum;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.network.NetworkPropertyService;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.network.Call;
import mtopsdk.security.ISign;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class MtopConfig {
    private static final String TAG = "mtopsdk.MtopConfig";
    public static LogAdapter logAdapterImpl;
    public AntiAttackHandler antiAttackHandler;
    public String appKey;
    public int appKeyIndex;
    public String appVersion;
    public String authCode;
    public Cache cacheImpl;
    public Context context;
    public String deviceId;
    @NonNull
    public final String instanceId;
    public Mtop mtopInstance;
    public MtopStatsListener mtopStatsListener;
    public NetworkPropertyService networkPropertyService;
    public String placeId;
    public int processId;
    public String routerId;
    public volatile ISign sign;
    public String ttid;
    public IUploadStats uploadStats;
    public String utdid;
    public String wuaAuthCode;
    public volatile long xAppConfigVersion;
    public String xOrangeQ;
    public EnvModeEnum envMode = EnvModeEnum.ONLINE;
    public EntranceEnum entrance = EntranceEnum.GW_INNER;
    public int onlineAppKeyIndex = 0;
    public int dailyAppkeyIndex = 0;
    public final byte[] lock = new byte[0];
    public AtomicBoolean isAllowSwitchEnv = new AtomicBoolean(true);
    public volatile boolean notifySessionResult = false;
    public volatile boolean enableNewDeviceId = true;
    public volatile boolean enableHeaderUrlEncode = false;
    public final Set<Integer> mtopFeatures = new CopyOnWriteArraySet();
    protected final Map<String, String> mtopProperties = new ConcurrentHashMap();
    public final Map<String, String> mtopGlobalHeaders = new ConcurrentHashMap();
    public final Map<String, String> mtopGlobalQuerys = new ConcurrentHashMap();
    public final Map<String, String> mtopGlobalABTestParams = new ConcurrentHashMap();
    protected AtomicBoolean loadPropertyFlag = new AtomicBoolean(false);
    public Call.Factory callFactory = null;
    public FilterManager filterManager = null;
    public final MtopDomain mtopDomain = new MtopDomain();

    /* compiled from: Taobao */
    /* renamed from: mtopsdk.mtop.global.MtopConfig$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum;

        static {
            int[] iArr = new int[EnvModeEnum.values().length];
            $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum = iArr;
            try {
                iArr[EnvModeEnum.ONLINE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.PREPARE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[EnvModeEnum.TEST_SANDBOX.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class MtopDomain {
        public static final int FOR_DAILY = 2;
        public static final int FOR_DAILY_2ND = 3;
        public static final int FOR_ONLINE = 0;
        public static final int FOR_PREPARED = 1;
        final String[] defaultDomains;

        MtopDomain() {
            this.defaultDomains = r0;
            String[] strArr = {"acs.m.taobao.com", "acs.wapa.taobao.com", "acs.waptest.taobao.com", "api.waptest2nd.taobao.com"};
        }

        public String getDomain(EnvModeEnum envModeEnum) {
            int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            return this.defaultDomains[0];
                        }
                        return this.defaultDomains[3];
                    }
                    return this.defaultDomains[2];
                }
                return this.defaultDomains[1];
            }
            return this.defaultDomains[0];
        }

        public void updateDomain(EnvModeEnum envModeEnum, String str) {
            int i = AnonymousClass1.$SwitchMap$mtopsdk$mtop$domain$EnvModeEnum[envModeEnum.ordinal()];
            if (i == 1) {
                this.defaultDomains[0] = str;
            } else if (i == 2) {
                this.defaultDomains[1] = str;
            } else if (i == 3) {
                this.defaultDomains[2] = str;
            } else if (i != 4) {
            } else {
                this.defaultDomains[3] = str;
            }
        }
    }

    public MtopConfig(String str) {
        this.instanceId = str;
    }

    public Map<String, String> getMtopProperties() {
        if (this.loadPropertyFlag.compareAndSet(false, true)) {
            try {
                InputStream open = this.context.getAssets().open("mtopsdk.property");
                Properties properties = new Properties();
                properties.load(open);
                if (!properties.isEmpty()) {
                    for (Map.Entry entry : properties.entrySet()) {
                        try {
                            Object key = entry.getKey();
                            Object value = entry.getValue();
                            if (key == null || value == null) {
                                TBSdkLog.e(TAG, "invalid mtopsdk property,key=" + key + ",value=" + value);
                            } else {
                                this.mtopProperties.put(key.toString(), value.toString());
                            }
                        } catch (Exception e) {
                            TBSdkLog.e(TAG, "load mtopsdk.property in android assets directory error.", e);
                        }
                    }
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, " load mtopsdk.property file in android assets directory succeed");
                }
            } catch (Exception unused) {
                TBSdkLog.e(TAG, "load mtopsdk.property in android assets directory failed!");
            }
        }
        return this.mtopProperties;
    }

    public void registerMtopSdkProperty(@NonNull String str, @NonNull String str2) {
        if (StringUtils.isNotBlank(str) && StringUtils.isNotBlank(str2)) {
            getMtopProperties().put(str, str2);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, "[registerMtopSdkProperty]register MtopSdk Property succeed,key=" + str + ",value=" + str2);
            }
        }
    }
}
