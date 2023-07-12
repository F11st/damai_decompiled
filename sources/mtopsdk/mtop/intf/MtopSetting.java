package mtopsdk.mtop.intf;

import android.content.Context;
import androidx.annotation.NonNull;
import anetwork.network.cache.Cache;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.common.log.LogAdapter;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.SwitchConfigUtil;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.antiattack.AntiAttackHandler;
import mtopsdk.mtop.common.MtopStatsListener;
import mtopsdk.mtop.domain.EnvModeEnum;
import mtopsdk.mtop.features.MtopFeatureManager;
import mtopsdk.mtop.global.MtopConfig;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.stat.IUploadStats;
import mtopsdk.mtop.util.MtopSDKThreadPoolExecutorFactory;
import mtopsdk.network.Call;
import mtopsdk.security.ISign;
import mtopsdk.xstate.XState;
import mtopsdk.xstate.util.PhoneInfo;
import mtopsdk.xstate.util.XStateConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class MtopSetting {
    private static final String TAG = "mtopsdk.MtopSetting";
    protected static final Map<String, MtopConfig> mtopConfigMap = new HashMap();

    private MtopSetting() {
    }

    public static void addMtopStatisListener(String str, @NonNull MtopStatsListener mtopStatsListener) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.mtopStatsListener = mtopStatsListener;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [addMtopStatisListener] set MtopStatsListener succeed.");
        }
    }

    static MtopConfig getMtopConfigByID(String str) {
        MtopConfig mtopConfig;
        if (!StringUtils.isNotBlank(str)) {
            str = Mtop.Id.INNER;
        }
        Map<String, Mtop> map = Mtop.instanceMap;
        Mtop mtop = map.get(str);
        if (mtop == null) {
            synchronized (Mtop.class) {
                mtop = map.get(str);
                if (mtop == null) {
                    Map<String, MtopConfig> map2 = mtopConfigMap;
                    MtopConfig mtopConfig2 = map2.get(str);
                    if (mtopConfig2 == null) {
                        synchronized (MtopSetting.class) {
                            mtopConfig = map2.get(str);
                            if (mtopConfig == null) {
                                mtopConfig = new MtopConfig(str);
                                map2.put(str, mtopConfig);
                            }
                        }
                        mtopConfig2 = mtopConfig;
                    }
                    return mtopConfig2;
                }
            }
        }
        return mtop.getMtopConfig();
    }

    public static void removeParam(String str, String str2, @NonNull String str3) {
        if (str2 == null || str3 == null) {
            return;
        }
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[removeParam] remove Param succeed.mtopParamType=" + str2 + ",key=" + str3);
        }
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case 77406376:
                if (str2.equals(MtopParamType.QUERY)) {
                    c = 0;
                    break;
                }
                break;
            case 1924418611:
                if (str2.equals(MtopParamType.ABTEST)) {
                    c = 1;
                    break;
                }
                break;
            case 2127025805:
                if (str2.equals(MtopParamType.HEADER)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                mtopConfigByID.mtopGlobalQuerys.remove(str3);
                return;
            case 1:
                mtopConfigByID.mtopGlobalABTestParams.remove(str3);
                return;
            case 2:
                mtopConfigByID.mtopGlobalHeaders.remove(str3);
                return;
            default:
                return;
        }
    }

    public static void setAllowRemoveDeviceInfo(boolean z) {
        XState.setValue(XStateConstants.KEY_REMOVE_DEVICE_INFO, String.valueOf(z));
    }

    public static void setAntiAttackHandler(String str, AntiAttackHandler antiAttackHandler) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.antiAttackHandler = antiAttackHandler;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setAntiAttackHandler] set antiAttackHandler succeed.");
        }
    }

    public static void setAppKey(String str, String str2) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.appKey = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setAppKey] appKey=" + str2);
        }
    }

    public static void setAppKeyIndex(String str, int i, int i2) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.onlineAppKeyIndex = i;
        mtopConfigByID.dailyAppkeyIndex = i2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setAppKeyIndex] onlineAppKeyIndex=" + i + ",dailyAppkeyIndex=" + i2);
        }
    }

    public static void setAppVersion(String str, String str2) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.appVersion = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setAppVersion] appVersion=" + str2);
        }
    }

    public static void setAuthCode(String str, String str2) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.authCode = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setAuthCode] authCode=" + str2);
        }
    }

    @Deprecated
    public static void setCacheImpl(Cache cache) {
        setCacheImpl(null, cache);
    }

    public static void setCallFactoryImpl(String str, Call.Factory factory) {
        if (factory != null) {
            MtopConfig mtopConfigByID = getMtopConfigByID(str);
            mtopConfigByID.callFactory = factory;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setCallFactoryImpl] set CallFactoryImpl succeed.callFactory=" + factory);
            }
        }
    }

    public static void setDeviceInfo(IDeviceInfo iDeviceInfo) {
        PhoneInfo.setDeviceInfo(iDeviceInfo);
    }

    public static void setEnableProperty(String str, String str2, boolean z) {
        if (str2 != null) {
            MtopConfig mtopConfigByID = getMtopConfigByID(str);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setEnableProperty] set enableProperty succeed.property=" + str2 + ",enable=" + z);
            }
            str2.hashCode();
            char c = 65535;
            switch (str2.hashCode()) {
                case -514993282:
                    if (str2.equals(MtopEnablePropertyType.ENABLE_NOTIFY_SESSION_RET)) {
                        c = 0;
                        break;
                    }
                    break;
                case -309052356:
                    if (str2.equals(MtopEnablePropertyType.ENABLE_HEADER_URL_ENCODE)) {
                        c = 1;
                        break;
                    }
                    break;
                case 1971193321:
                    if (str2.equals(MtopEnablePropertyType.ENABLE_NEW_DEVICE_ID)) {
                        c = 2;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    mtopConfigByID.notifySessionResult = z;
                    return;
                case 1:
                    mtopConfigByID.enableHeaderUrlEncode = z;
                    return;
                case 2:
                    mtopConfigByID.enableNewDeviceId = z;
                    return;
                default:
                    return;
            }
        }
    }

    public static void setISignImpl(String str, ISign iSign) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.sign = iSign;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setISignImpl] set ISign succeed.signImpl=" + iSign);
        }
    }

    public static void setLogAdapterImpl(LogAdapter logAdapter) {
        if (logAdapter != null) {
            MtopConfig.logAdapterImpl = logAdapter;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[setLogAdapterImpl] set logAdapter succeed.logAdapterImpl=" + logAdapter);
            }
        }
    }

    public static void setMtopConfigListener(final MtopConfigListener mtopConfigListener) {
        SwitchConfig.getInstance().setMtopConfigListener(mtopConfigListener);
        SwitchConfigUtil.setMtopConfigListener(mtopConfigListener);
        TBSdkLog.i(TAG, "[setMtopConfigListener] set MtopConfigListener succeed.");
        MtopSDKThreadPoolExecutorFactory.submit(new Runnable() { // from class: mtopsdk.mtop.intf.MtopSetting.1
            @Override // java.lang.Runnable
            public void run() {
                Context context;
                if (MtopConfigListener.this == null || (context = MtopSetting.getMtopConfigByID(null).context) == null) {
                    return;
                }
                MtopConfigListener.this.initConfig(context);
            }
        });
    }

    public static void setMtopDomain(String str, String str2, String str3, String str4) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        if (StringUtils.isNotBlank(str2)) {
            mtopConfigByID.mtopDomain.updateDomain(EnvModeEnum.ONLINE, str2);
        }
        if (StringUtils.isNotBlank(str3)) {
            mtopConfigByID.mtopDomain.updateDomain(EnvModeEnum.PREPARE, str3);
        }
        if (StringUtils.isNotBlank(str4)) {
            mtopConfigByID.mtopDomain.updateDomain(EnvModeEnum.TEST, str4);
        }
    }

    @Deprecated
    public static void setMtopFeatureFlag(MtopFeatureManager.MtopFeatureEnum mtopFeatureEnum, boolean z) {
        setMtopFeatureFlag(null, MtopFeatureManager.getMtopFeatureByFeatureEnum(mtopFeatureEnum), z);
    }

    public static void setParam(String str, String str2, @NonNull String str3, @NonNull String str4) {
        if (str2 == null || str3 == null || str4 == null) {
            return;
        }
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setParam] set Param succeed.mtopParamType=" + str2 + ",key=" + str3 + ",value=" + str4);
        }
        str2.hashCode();
        char c = 65535;
        switch (str2.hashCode()) {
            case 77406376:
                if (str2.equals(MtopParamType.QUERY)) {
                    c = 0;
                    break;
                }
                break;
            case 1924418611:
                if (str2.equals(MtopParamType.ABTEST)) {
                    c = 1;
                    break;
                }
                break;
            case 2127025805:
                if (str2.equals(MtopParamType.HEADER)) {
                    c = 2;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                mtopConfigByID.mtopGlobalQuerys.put(str3, str4);
                return;
            case 1:
                mtopConfigByID.mtopGlobalABTestParams.put(str3, str4);
                return;
            case 2:
                mtopConfigByID.mtopGlobalHeaders.put(str3, str4);
                return;
            default:
                return;
        }
    }

    public static void setPlaceId(String str, String str2) {
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.placeId = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setPlaceId] set placeId succeed.placeId=" + str2);
        }
    }

    public static void setRouterId(String str, String str2) {
        if (StringUtils.isEmpty(str2)) {
            return;
        }
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.routerId = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setRouterId] set routerId succeed.routerId=" + str2);
        }
    }

    @Deprecated
    public static void setSecurityAppKey(String str) {
    }

    public static void setUploadStats(String str, IUploadStats iUploadStats) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.uploadStats = iUploadStats;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + "[setUploadStats] set IUploadStats succeed.uploadStats=" + iUploadStats);
        }
    }

    public static void setWuaAuthCode(String str, String str2) {
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        mtopConfigByID.wuaAuthCode = str2;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setWuaAuthCode] wuaAuthCode=" + str2);
        }
    }

    @Deprecated
    public static void setXOrangeQ(String str) {
        setXOrangeQ(null, str);
    }

    public static void setCacheImpl(String str, Cache cache) {
        if (cache != null) {
            MtopConfig mtopConfigByID = getMtopConfigByID(str);
            mtopConfigByID.cacheImpl = cache;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setCacheImpl] set CacheImpl succeed.cacheImpl=" + cache);
            }
        }
    }

    public static void setXOrangeQ(String str, String str2) {
        if (StringUtils.isNotBlank(str2)) {
            MtopConfig mtopConfigByID = getMtopConfigByID(str);
            mtopConfigByID.xOrangeQ = str2;
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, mtopConfigByID.instanceId + " [setXOrangeQ] set xOrangeQ succeed.xOrangeQ=" + str2);
            }
        }
    }

    public static void setMtopFeatureFlag(String str, int i, boolean z) {
        if (i < 1) {
            return;
        }
        MtopConfig mtopConfigByID = getMtopConfigByID(str);
        if (z) {
            mtopConfigByID.mtopFeatures.add(Integer.valueOf(i));
        } else {
            mtopConfigByID.mtopFeatures.remove(Integer.valueOf(i));
        }
    }

    @Deprecated
    public static void setAppVersion(String str) {
        setAppVersion(null, str);
    }

    @Deprecated
    public static void setAuthCode(String str) {
        setAuthCode(null, str);
    }

    @Deprecated
    public static void setAppKeyIndex(int i, int i2) {
        setAppKeyIndex(null, i, i2);
    }

    @Deprecated
    public static void setMtopDomain(String str, String str2, String str3) {
        setMtopDomain(null, str, str2, str3);
    }
}
