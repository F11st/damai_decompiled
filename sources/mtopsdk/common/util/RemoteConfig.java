package mtopsdk.common.util;

import android.content.Context;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class RemoteConfig {
    private static final String TAG = "mtopsdk.RemoteConfig";
    public static final String TB_SPEED_TS_ENABLE = "tsEnable";
    public static final String TB_SPEED_U_LAND = "preUland";
    private static RemoteConfig instance;
    private static Map<String, Integer> segmentSizeMap;
    private Map<String, String> configItemsMap = null;
    public boolean enableErrorCodeMapping = true;
    public boolean enableBizErrorCodeMapping = false;
    public long bizErrorMappingCodeLength = 24;
    public boolean enableSpdy = true;
    @Deprecated
    public boolean enableUnit = true;
    public boolean enableSsl = true;
    public boolean enableCache = true;
    public boolean enableProperty = false;
    public boolean degradeToSQLite = false;
    public boolean enableNewExecutor = true;
    public long apiLockInterval = 10;
    public String individualApiLockInterval = "";
    public String degradeApiCacheList = "";
    public String removeCacheBlockList = "";
    public String degradeBizErrorMappingApiList = "";
    public String errorMappingMsg = "";
    public long antiAttackWaitInterval = 20;
    public int useSecurityAdapter = 6;
    public boolean prefetch = false;
    public int segmentRetryTimes = -1;
    public int uploadThreadNums = -1;
    public boolean processBgMethodNew = true;
    public final Set<String> useHttpsBizcodeSets = new HashSet();
    public final Set<String> degradeBizcodeSets = new HashSet();
    public boolean enableArupTlog = true;

    static {
        HashMap hashMap = new HashMap();
        segmentSizeMap = hashMap;
        hashMap.put("2G", 32768);
        segmentSizeMap.put("3G", 65536);
        segmentSizeMap.put("4G", 524288);
        segmentSizeMap.put("WIFI", 524288);
        segmentSizeMap.put("UNKONWN", 131072);
        segmentSizeMap.put("NET_NO", 131072);
    }

    private String getConfigItemByKey(String str, String str2) {
        String str3 = null;
        try {
            Map<String, String> map = this.configItemsMap;
            if (map != null) {
                str3 = map.get(str);
            }
        } catch (Exception e) {
            TBSdkLog.w(TAG, "[getConfigItemByKey] get config item error; key=" + str, e);
        }
        return str3 == null ? str2 : str3;
    }

    public static RemoteConfig getInstance() {
        if (instance == null) {
            synchronized (RemoteConfig.class) {
                if (instance == null) {
                    instance = new RemoteConfig();
                }
            }
        }
        return instance;
    }

    public Integer getSegmentSize(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        return segmentSizeMap.get(str);
    }

    public void loadLocalConfig(Context context) {
        String configItem;
        String str = "";
        try {
            configItem = ConfigStoreManager.getInstance().getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.USE_SECURITY_ADAPTER);
        } catch (Throwable unused) {
        }
        try {
            if (StringUtils.isNotBlank(configItem)) {
                this.useSecurityAdapter = Integer.parseInt(configItem);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[loadLocalConfig]local useSecurityAdapterSwitchConfig=" + configItem + ",useSecurityAdapter=" + this.useSecurityAdapter);
                }
            }
            String configItem2 = ConfigStoreManager.getInstance().getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.OPEN_PREFETCH);
            if (StringUtils.isNotBlank(configItem2)) {
                this.prefetch = Boolean.parseBoolean(configItem2);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[loadLocalConfig]local openPrefetchStr=" + configItem2 + ",prefetch=" + this.prefetch);
                }
            }
            String configItem3 = ConfigStoreManager.getInstance().getConfigItem(context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.PROCESS_BG_METHOD);
            if (StringUtils.isNotBlank(configItem3)) {
                this.processBgMethodNew = Boolean.parseBoolean(configItem3);
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, "[loadLocalConfig]local processBgMethodNewStr=" + configItem3 + ",method=" + this.processBgMethodNew);
                }
            }
        } catch (Throwable unused2) {
            str = configItem;
            TBSdkLog.e(TAG, "[loadLocalConfig]parse local useSecurityAdapter error, useSecAdapterStr=" + str);
        }
    }

    public void setSegmentSize(String str, int i) {
        if (StringUtils.isBlank(str) || i <= 0) {
            return;
        }
        segmentSizeMap.put(str, Integer.valueOf(i));
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:59:0x02d2 -> B:103:0x02e6). Please submit an issue!!! */
    public void updateRemoteConfig() {
        this.configItemsMap = SwitchConfigUtil.getSwitchConfigByGroupName(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_ANDROID_SWITCH);
        TBSdkLog.LogEnable logEnable = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[updateRemoteConfig] configItemsMap=" + this.configItemsMap);
        }
        if (this.configItemsMap == null) {
            return;
        }
        String configItemByKey = getConfigItemByKey(SwitchConfigUtil.ENABLE_ERROR_CODE_MAPPING_KEY, "true");
        this.enableErrorCodeMapping = "true".equals(configItemByKey);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableErrorCodeMapping]remote enableErrorCodeMappingConfig=" + configItemByKey + ",enableErrorCodeMapping=" + this.enableErrorCodeMapping);
        }
        String configItemByKey2 = getConfigItemByKey(SwitchConfigUtil.ENABLE_BIZ_ERROR_CODE_MAPPING_KEY, "false");
        this.enableBizErrorCodeMapping = "true".equals(configItemByKey2);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableBizErrorCodeMapping]remote enableBizErrorCodeMappingConfig=" + configItemByKey2 + ",enableBizErrorCodeMapping=" + this.enableBizErrorCodeMapping);
        }
        String configItemByKey3 = getConfigItemByKey(SwitchConfigUtil.ENABLE_SPDY_KEY, "true");
        this.enableSpdy = "true".equals(configItemByKey3);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableSpdy]remote spdySwitchConfig=" + configItemByKey3 + ",enableSpdy=" + this.enableSpdy);
        }
        String configItemByKey4 = getConfigItemByKey(SwitchConfigUtil.ENABLE_SSL_KEY, "true");
        this.enableSsl = "true".equals(configItemByKey4);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableSsl]remote spdySslSwitchConfig=" + configItemByKey4 + ",enableSsl=" + this.enableSsl);
        }
        String configItemByKey5 = getConfigItemByKey(SwitchConfigUtil.ENABLE_CACHE_KEY, "true");
        this.enableCache = "true".equalsIgnoreCase(configItemByKey5);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableCache]remote cacheSwitchConfig=" + configItemByKey5 + ",enableCache=" + this.enableCache);
        }
        String configItemByKey6 = getConfigItemByKey(SwitchConfigUtil.ENABLE_MTOPSDK_PROPERTY_KEY, "false");
        this.enableProperty = !"false".equalsIgnoreCase(configItemByKey6);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableProperty]remote mtopsdkPropertySwitchConfig=" + configItemByKey6 + ",enableProperty=" + this.enableProperty);
        }
        String configItemByKey7 = getConfigItemByKey(SwitchConfigUtil.DEGRADE_TO_SQLITE_KEY, "false");
        this.degradeToSQLite = !"false".equalsIgnoreCase(configItemByKey7);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setDegradeToSQLite]remote degradeToSQLiteConfig=" + configItemByKey7 + ",degradeToSQLite=" + this.degradeToSQLite);
        }
        String configItemByKey8 = getConfigItemByKey(SwitchConfigUtil.ENABLE_NEW_EXECUTOR, "true");
        this.enableNewExecutor = "true".equalsIgnoreCase(configItemByKey8);
        if (TBSdkLog.isLogEnable(logEnable)) {
            TBSdkLog.i(TAG, "[setEnableNewExecutor]remote enableNewExecutorConfig=" + configItemByKey8 + ",enableNewExecutor=" + this.enableNewExecutor);
        }
        String configItemByKey9 = getConfigItemByKey(SwitchConfigUtil.API_LOCK_INTERVAL_KEY, null);
        if (StringUtils.isNotBlank(configItemByKey9)) {
            try {
                this.apiLockInterval = Long.parseLong(configItemByKey9);
            } catch (Exception unused) {
                TBSdkLog.e(TAG, "[setApiLockInterval]parse apiLockIntervalConfig error,apiLockIntervalConfig=" + configItemByKey9);
            }
        }
        TBSdkLog.LogEnable logEnable2 = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable2)) {
            TBSdkLog.i(TAG, "[setApiLockInterval]remote apiLockIntervalConfig=" + configItemByKey9 + ",apiLockInterval=" + this.apiLockInterval);
        }
        String configItemByKey10 = getConfigItemByKey(SwitchConfigUtil.OPEN_PREFETCH, "false");
        this.prefetch = "true".equalsIgnoreCase(configItemByKey10);
        if (TBSdkLog.isLogEnable(logEnable2)) {
            TBSdkLog.i(TAG, "[setPrefetch]remote openPrefetchConfig=" + configItemByKey10 + ",prefetch=" + this.prefetch);
        }
        try {
            Mtop instance2 = Mtop.instance(Mtop.Id.INNER, (Context) null);
            if (instance2.getMtopConfig().context != null) {
                ConfigStoreManager.getInstance().saveConfigItem(instance2.getMtopConfig().context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.OPEN_PREFETCH, configItemByKey10);
            } else {
                TBSdkLog.e(TAG, "[prefetch]context can't be null.wait INNER mtopInstance init.");
            }
        } catch (Exception unused2) {
            TBSdkLog.e(TAG, "[prefetch]parse useSecAdapterConfig error,openPrefetchConfig=" + configItemByKey10);
        }
        String configItemByKey11 = getConfigItemByKey(SwitchConfigUtil.PROCESS_BG_METHOD, "");
        if (StringUtils.isNotBlank(configItemByKey11)) {
            this.processBgMethodNew = "true".equalsIgnoreCase(configItemByKey11);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[setPrefetch]remote openPrefetchConfig=" + configItemByKey10 + ",prefetch=" + this.prefetch);
            }
            try {
                Mtop instance3 = Mtop.instance(Mtop.Id.INNER, (Context) null);
                if (instance3.getMtopConfig().context != null) {
                    ConfigStoreManager.getInstance().saveConfigItem(instance3.getMtopConfig().context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.PROCESS_BG_METHOD, configItemByKey11);
                } else {
                    TBSdkLog.e(TAG, "[processBgMethodNew]context can't be null.wait INNER mtopInstance init.");
                }
            } catch (Exception unused3) {
                TBSdkLog.e(TAG, "[processBgMethodNew]parse processBgMethodNewConfig error,processBgMethodNewConfig=" + configItemByKey11);
            }
        }
        String configItemByKey12 = getConfigItemByKey(SwitchConfigUtil.ANTI_ATTACK_WAIT_INTERVAL_KEY, null);
        if (StringUtils.isNotBlank(configItemByKey12)) {
            try {
                this.antiAttackWaitInterval = Long.parseLong(configItemByKey12);
            } catch (Exception unused4) {
                TBSdkLog.e(TAG, "[setAntiAttackWaitInterval]parse antiAttackWaitIntervalConfig error,antiAttackWaitIntervalConfig=" + configItemByKey12);
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setAntiAttackWaitInterval]remote antiAttackWaitIntervalConfig=" + configItemByKey12 + ",antiAttackWaitInterval=" + this.antiAttackWaitInterval);
        }
        String configItemByKey13 = getConfigItemByKey(SwitchConfigUtil.BIZ_ERROR_MAPPING_CODE_LENGTH_KEY, null);
        if (StringUtils.isNotBlank(configItemByKey13)) {
            try {
                this.bizErrorMappingCodeLength = Long.parseLong(configItemByKey13);
            } catch (Exception unused5) {
                TBSdkLog.e(TAG, "[setBizErrorMappingCodeLength]parse bizErrorMappingCodeLengthConfig error,bizErrorMappingCodeLengthConfig=" + configItemByKey13);
            }
        }
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[setBizErrorMappingCodeLength]remote bizErrorMappingCodeLengthConfig=" + configItemByKey13 + ",bizErrorMappingCodeLength=" + this.bizErrorMappingCodeLength);
        }
        this.individualApiLockInterval = getConfigItemByKey(SwitchConfigUtil.INDIVIDUAL_API_LOCK_INTERVAL_KEY, "");
        this.degradeApiCacheList = getConfigItemByKey(SwitchConfigUtil.DEGRADE_API_CACHE_LIST_KEY, "");
        this.removeCacheBlockList = getConfigItemByKey(SwitchConfigUtil.REMOVE_CACHE_BLOCK_LIST_KEY, "");
        this.degradeBizErrorMappingApiList = getConfigItemByKey(SwitchConfigUtil.DEGRADE_BIZ_ERROR_MAPPING_API_LIST_KEY, "");
        this.errorMappingMsg = getConfigItemByKey(SwitchConfigUtil.ERROR_MAPPING_MSG_KEY, "");
        String configItemByKey14 = getConfigItemByKey(SwitchConfigUtil.USE_SECURITY_ADAPTER, "");
        if (StringUtils.isNotBlank(configItemByKey14)) {
            try {
                int parseInt = Integer.parseInt(configItemByKey14);
                if (parseInt != this.useSecurityAdapter) {
                    this.useSecurityAdapter = parseInt;
                    Mtop instance4 = Mtop.instance(Mtop.Id.INNER, (Context) null);
                    if (instance4.getMtopConfig().context != null) {
                        ConfigStoreManager.getInstance().saveConfigItem(instance4.getMtopConfig().context, ConfigStoreManager.MTOP_CONFIG_STORE, "", SwitchConfigUtil.USE_SECURITY_ADAPTER, configItemByKey14);
                    } else {
                        TBSdkLog.e(TAG, "[useSecurityAdapter]context can't be null.wait INNER mtopInstance init.");
                    }
                }
            } catch (Exception unused6) {
                TBSdkLog.e(TAG, "[useSecurityAdapter]parse useSecAdapterConfig error,useSecAdapterConfig=" + configItemByKey14);
            }
        }
        TBSdkLog.LogEnable logEnable3 = TBSdkLog.LogEnable.InfoEnable;
        if (TBSdkLog.isLogEnable(logEnable3)) {
            TBSdkLog.i(TAG, "[useSecurityAdapter]remote useSecurityAdapterSwitchConfig=" + configItemByKey14 + ",useSecurityAdapter=" + this.useSecurityAdapter);
        }
        if (TBSdkLog.isLogEnable(logEnable3)) {
            StringBuilder sb = new StringBuilder(128);
            sb.append("[setOtherConfigItemKey] individualApiLockInterval =");
            sb.append(this.individualApiLockInterval);
            sb.append(", degradeApiCacheList =");
            sb.append(this.degradeApiCacheList);
            sb.append(", removeCacheBlockList =");
            sb.append(this.removeCacheBlockList);
            sb.append(", degradeBizErrorMappingApiList =");
            sb.append(this.degradeBizErrorMappingApiList);
            sb.append(", errorMappingMsg =");
            sb.append(this.errorMappingMsg);
            TBSdkLog.i(TAG, sb.toString());
        }
    }

    public void updateUploadRemoteConfig() {
        Map<String, String> switchConfigByGroupName = SwitchConfigUtil.getSwitchConfigByGroupName(SwitchConfigUtil.CONFIG_GROUP_MTOPSDK_UPLOAD_SWITCH);
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, "[updateUploadRemoteConfig] uploadConfigItemsMap=" + switchConfigByGroupName);
        }
        if (switchConfigByGroupName == null) {
            return;
        }
        String str = switchConfigByGroupName.get(SwitchConfigUtil.SEGMENT_RETRY_TIMES_KEY);
        if (StringUtils.isNotBlank(str)) {
            try {
                int parseInt = Integer.parseInt(str);
                if (parseInt >= 0) {
                    this.segmentRetryTimes = parseInt;
                }
            } catch (Exception unused) {
                TBSdkLog.w(TAG, "[updateUploadRemoteConfig]parse segmentRetryTimes error,segmentRetryTimesStr=" + str);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[updateUploadRemoteConfig]remote segmentRetryTimesStr=" + str + ",segmentRetryTimes=" + this.segmentRetryTimes);
            }
        }
        String str2 = switchConfigByGroupName.get(SwitchConfigUtil.UPLOAD_THREAD_NUMS_KEY);
        if (StringUtils.isNotBlank(str)) {
            try {
                int parseInt2 = Integer.parseInt(str2);
                if (parseInt2 >= 0) {
                    this.uploadThreadNums = parseInt2;
                }
            } catch (Exception unused2) {
                TBSdkLog.w(TAG, "[updateUploadRemoteConfig]parse uploadThreadNums error,uploadThreadNumsStr=" + str2);
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                TBSdkLog.i(TAG, "[updateUploadRemoteConfig]remote uploadThreadNumsStr=" + str2 + ",uploadThreadNums=" + this.uploadThreadNums);
            }
        }
    }
}
