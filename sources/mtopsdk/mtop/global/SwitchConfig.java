package mtopsdk.mtop.global;

import android.content.Context;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.config.MtopConfigListener;
import mtopsdk.common.util.LocalConfig;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.util.ErrorConstant;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class SwitchConfig {
    private static final String TAG = "mtopsdk.SwitchConfig";
    public static final HashSet<String> authErrorCodeSet;
    public static final Map<String, String> errorMappingMsgMap;
    public volatile Set<String> degradeApiCacheSet = null;
    public volatile Set<String> degradeBizErrorMappingApiSet = null;
    private static final SwitchConfig config = new SwitchConfig();
    private static final RemoteConfig remoteConfig = RemoteConfig.getInstance();
    private static final LocalConfig localConfig = LocalConfig.getInstance();
    private static MtopConfigListener mtopConfigListener = null;
    private static volatile Map<String, String> individualApiLockIntervalMap = new ConcurrentHashMap(8);

    static {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap(8);
        errorMappingMsgMap = concurrentHashMap;
        HashSet<String> hashSet = new HashSet<>(8);
        authErrorCodeSet = hashSet;
        concurrentHashMap.put(ErrorConstant.ErrorMappingType.NETWORK_ERROR_MAPPING, "网络竟然崩溃了");
        concurrentHashMap.put(ErrorConstant.ErrorMappingType.FLOW_LIMIT_ERROR_MAPPING, "前方拥挤，亲稍等再试试");
        concurrentHashMap.put(ErrorConstant.ErrorMappingType.SERVICE_ERROR_MAPPING, "服务竟然出错了");
        hashSet.add(ErrorConstant.ERRCODE_FAIL_SYS_ACCESS_TOKEN_EXPIRED);
        hashSet.add(ErrorConstant.ERRCODE_FAIL_SYS_ILLEGAL_ACCESS_TOKEN);
    }

    private SwitchConfig() {
    }

    public static SwitchConfig getInstance() {
        return config;
    }

    public static MtopConfigListener getMtopConfigListener() {
        return mtopConfigListener;
    }

    public long getGlobalApiLockInterval() {
        return remoteConfig.apiLockInterval;
    }

    public long getGlobalAttackAttackWaitInterval() {
        return remoteConfig.antiAttackWaitInterval;
    }

    public long getGlobalBizErrorMappingCodeLength() {
        return remoteConfig.bizErrorMappingCodeLength;
    }

    public long getIndividualApiLockInterval(String str) {
        if (StringUtils.isBlank(str)) {
            return 0L;
        }
        String str2 = individualApiLockIntervalMap.get(str);
        if (StringUtils.isBlank(str2)) {
            return 0L;
        }
        try {
            return Long.parseLong(str2);
        } catch (Exception e) {
            TBSdkLog.e(TAG, "[getIndividualApiLockInterval]parse individual apiLock interval error.apiKey=" + str + " ---" + e.toString());
            return 0L;
        }
    }

    public Map<String, String> getIndividualApiLockIntervalMap() {
        return individualApiLockIntervalMap;
    }

    public boolean getProcessBgMethodNew() {
        return remoteConfig.processBgMethodNew;
    }

    public int getUseSecurityAdapter() {
        return remoteConfig.useSecurityAdapter;
    }

    public void initConfig(Context context) {
        MtopConfigListener mtopConfigListener2 = mtopConfigListener;
        if (mtopConfigListener2 != null) {
            mtopConfigListener2.initConfig(context);
        }
    }

    public boolean isBizErrorCodeMappingOpen() {
        return localConfig.enableBizErrorCodeMapping && remoteConfig.enableBizErrorCodeMapping;
    }

    public boolean isGlobalCacheSwitchOpen() {
        return remoteConfig.enableCache;
    }

    public boolean isGlobalErrorCodeMappingOpen() {
        return localConfig.enableErrorCodeMapping && remoteConfig.enableErrorCodeMapping;
    }

    public boolean isGlobalSpdySslSwitchOpen() {
        return localConfig.enableSsl && remoteConfig.enableSsl;
    }

    public boolean isGlobalSpdySwitchOpen() {
        return localConfig.enableSpdy && remoteConfig.enableSpdy;
    }

    @Deprecated
    public boolean isGlobalUnitSwitchOpen() {
        return localConfig.enableUnit && remoteConfig.enableUnit;
    }

    public boolean isMtopsdkPropertySwitchOpen() {
        return localConfig.enableProperty && remoteConfig.enableProperty;
    }

    public SwitchConfig setGlobalSpdySslSwitchOpen(boolean z) {
        localConfig.enableSsl = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setGlobalSpdySslSwitchOpen]set local spdySslSwitchOpen=" + z);
        }
        return this;
    }

    public SwitchConfig setGlobalSpdySwitchOpen(boolean z) {
        localConfig.enableSpdy = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setGlobalSpdySwitchOpen]set local spdySwitchOpen=" + z);
        }
        return this;
    }

    @Deprecated
    public SwitchConfig setGlobalUnitSwitchOpen(boolean z) {
        localConfig.enableUnit = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setGlobalUnitSwitchOpen]set local unitSwitchOpen=" + z);
        }
        return this;
    }

    public void setMtopConfigListener(MtopConfigListener mtopConfigListener2) {
        mtopConfigListener = mtopConfigListener2;
    }

    public SwitchConfig setMtopsdkPropertySwitchOpen(boolean z) {
        localConfig.enableProperty = z;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setMtopsdkPropertySwitchOpen]set local mtopsdkPropertySwitchOpen=" + z);
        }
        return this;
    }
}
