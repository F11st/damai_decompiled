package com.tencent.stat;

import android.content.Context;
import com.huawei.hms.opendevice.AbstractC5658c;
import com.taobao.weex.ui.component.WXComponent;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import java.util.Iterator;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatConfig {
    private static String appkey;
    private static String installChannel;
    private static StatLogger logger = StatCommonHelper.getLogger();
    static OnlineConfig userCfg = new OnlineConfig(2);
    static OnlineConfig sdkCfg = new OnlineConfig(1);
    private static StatReportStrategy statSendStrategy = StatReportStrategy.APP_LAUNCH;
    private static boolean enableStatService = true;
    private static int sessionTimoutMillis = 30000;
    private static int maxStoreEventCount = 1024;
    private static int maxLoadEventCount = 30;
    private static int maxSendRetryCount = 3;
    private static int maxBatchReportCount = 30;
    static String HIBERNATE = "__HIBERNATE__";
    private static String ta_http_proxy = null;
    static String qq = "";
    private static int sendPeriodMinutes = 1440;
    private static int maxParallelTimmingEvents = 1024;
    private static boolean enableSmartReporting = true;
    private static long lastReportStrategyCheckTime = 0;
    private static long maxReportStrategyCheckTime = 300000;
    public static boolean isAutoExceptionCaught = true;
    private static String statReportUrl = "http://pingma.qq.com:80/mstat/report";
    private static int maxSessionStatReportCount = 0;
    private static volatile int curSessionStatReportCount = 0;
    private static int maxDaySessionNumbers = 20;
    private static int currentDaySessionNumbers = 0;
    private static boolean reportTrafficStat = false;
    private static int maxReportEventLength = 4096;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class OnlineConfig {
        int type;
        JSONObject props = new JSONObject();
        String md5sum = "";
        int version = 0;

        public OnlineConfig(int i) {
            this.type = i;
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        public String toJsonString() {
            return this.props.toString();
        }
    }

    static void checkHibernate(JSONObject jSONObject) {
        try {
            String string = jSONObject.getString(HIBERNATE);
            StatLogger statLogger = logger;
            statLogger.d("hibernateVer:" + string + ", current version:1.0.0");
            long sDKLongVersion = StatCommonHelper.getSDKLongVersion(string);
            if (StatCommonHelper.getSDKLongVersion("1.0.0") <= sDKLongVersion) {
                StatPreferences.putLong(StatDispatcher.getApplicationContext(), HIBERNATE, sDKLongVersion);
                setEnableStatService(false);
                StatLogger statLogger2 = logger;
                statLogger2.warn("MTA has disable for SDK version of " + string + " or lower.");
            }
        } catch (JSONException unused) {
            logger.d("__HIBERNATE__ not found.");
        }
    }

    public static String getAppKey(Context context) {
        String str = appkey;
        if (str != null) {
            return str;
        }
        if (context != null && str == null) {
            appkey = StatCommonHelper.getAppKey(context);
        }
        String str2 = appkey;
        if (str2 == null || str2.trim().length() == 0) {
            logger.error("AppKey can not be null or empty, please read Developer's Guide first!");
        }
        return appkey;
    }

    public static int getCurSessionStatReportCount() {
        return curSessionStatReportCount;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getCurrentDaySessionNumbers() {
        return currentDaySessionNumbers;
    }

    public static String getCustomProperty(String str) {
        try {
            return userCfg.props.getString(str);
        } catch (JSONException unused) {
            return null;
        }
    }

    public static String getCustomProperty(String str, String str2) {
        String string;
        try {
            string = userCfg.props.getString(str);
        } catch (JSONException unused) {
        }
        return string != null ? string : str2;
    }

    public static String getInstallChannel(Context context) {
        String str = installChannel;
        if (str != null) {
            return str;
        }
        String installChannel2 = StatCommonHelper.getInstallChannel(context);
        installChannel = installChannel2;
        if (installChannel2 == null || installChannel2.trim().length() == 0) {
            logger.e("installChannel can not be null or empty, please read Developer's Guide first!");
        }
        return installChannel;
    }

    public static int getMaxBatchReportCount() {
        return maxBatchReportCount;
    }

    public static int getMaxDaySessionNumbers() {
        return maxDaySessionNumbers;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static int getMaxLoadEventCount() {
        return maxLoadEventCount;
    }

    public static int getMaxParallelTimmingEvents() {
        return maxParallelTimmingEvents;
    }

    public static int getMaxReportEventLength() {
        return maxReportEventLength;
    }

    public static int getMaxSendRetryCount() {
        return maxSendRetryCount;
    }

    public static int getMaxSessionStatReportCount() {
        return maxSessionStatReportCount;
    }

    public static int getMaxStoreEventCount() {
        return maxStoreEventCount;
    }

    public static String getQQ() {
        return qq;
    }

    public static int getSendPeriodMinutes() {
        return sendPeriodMinutes;
    }

    public static int getSessionTimoutMillis() {
        return sessionTimoutMillis;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static HttpHost getStatHttpProxy() {
        String str = ta_http_proxy;
        if (str == null || str.length() <= 0) {
            return null;
        }
        String str2 = ta_http_proxy;
        String[] split = str2.split(":");
        int i = 80;
        if (split.length == 2) {
            str2 = split[0];
            i = Integer.parseInt(split[1]);
        }
        return new HttpHost(str2, i);
    }

    public static String getStatReportUrl() {
        return statReportUrl;
    }

    public static StatReportStrategy getStatSendStrategy() {
        return statSendStrategy;
    }

    static String getStoredAppkeys(Context context) {
        return StatCommonHelper.decode(StatPreferences.getString(context, "_mta_ky_tag_", null));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void incCurSessionStatReportCount() {
        synchronized (StatConfig.class) {
            curSessionStatReportCount++;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void incCurrentDaySessionNumbers() {
        currentDaySessionNumbers++;
    }

    public static boolean isAutoExceptionCaught() {
        return isAutoExceptionCaught;
    }

    static boolean isBetween(int i, int i2, int i3) {
        return i >= i2 && i <= i3;
    }

    public static boolean isDebugEnable() {
        return StatCommonHelper.getLogger().isDebugEnable();
    }

    public static boolean isEnableSmartReporting() {
        return enableSmartReporting;
    }

    public static boolean isEnableStatService() {
        return enableStatService;
    }

    public static void setAppKey(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (context == null) {
            statLogger = logger;
            str2 = "ctx in StatConfig.setAppKey() is null";
        } else if (str != null && str.length() <= 256) {
            if (appkey == null) {
                appkey = getStoredAppkeys(context);
            }
            if (updateAppkeys(str) || updateAppkeys(StatCommonHelper.getAppKey(context))) {
                storeAppkeys(context, appkey);
                return;
            }
            return;
        } else {
            statLogger = logger;
            str2 = "appkey in StatConfig.setAppKey() is null or exceed 256 bytes";
        }
        statLogger.error(str2);
    }

    @Deprecated
    public static void setAppKey(String str) {
        StatLogger statLogger;
        String str2;
        if (str == null) {
            statLogger = logger;
            str2 = "appkey in StatConfig.setAppKey() is null";
        } else if (str.length() <= 256) {
            appkey = str;
            return;
        } else {
            statLogger = logger;
            str2 = "The length of appkey cann't exceed 256 bytes.";
        }
        statLogger.error(str2);
    }

    public static void setAutoExceptionCaught(boolean z) {
        isAutoExceptionCaught = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setConfig(OnlineConfig onlineConfig) throws JSONException {
        int i = onlineConfig.type;
        if (i == sdkCfg.type) {
            sdkCfg = onlineConfig;
            updateReportStrategy(onlineConfig.props);
        } else if (i == userCfg.type) {
            userCfg = onlineConfig;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static synchronized void setCurSessionStatReportCount(int i) {
        synchronized (StatConfig.class) {
            curSessionStatReportCount = i;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void setCurrentDaySessionNumbers(int i) {
        if (i < 0) {
            return;
        }
        currentDaySessionNumbers = i;
    }

    public static void setDebugEnable(boolean z) {
        StatCommonHelper.getLogger().setDebugEnable(z);
    }

    public static void setEnableSmartReporting(boolean z) {
        enableSmartReporting = z;
    }

    public static void setEnableStatService(boolean z) {
        enableStatService = z;
        if (z) {
            return;
        }
        logger.warn("!!!!!!MTA StatService has been disabled!!!!!!");
    }

    public static void setInstallChannel(String str) {
        if (str.length() > 128) {
            logger.error("the length of installChannel can not exceed the range of 128 bytes.");
        } else {
            installChannel = str;
        }
    }

    public static void setMaxBatchReportCount(int i) {
        if (isBetween(i, 2, 1000)) {
            maxBatchReportCount = i;
        } else {
            logger.error("setMaxBatchReportCount can not exceed the range of [2,1000].");
        }
    }

    public static void setMaxDaySessionNumbers(int i) {
        if (i <= 0) {
            logger.e("maxDaySessionNumbers must be greater than 0.");
        } else {
            maxDaySessionNumbers = i;
        }
    }

    public static void setMaxParallelTimmingEvents(int i) {
        if (isBetween(i, 1, 4096)) {
            maxParallelTimmingEvents = i;
        } else {
            logger.error("setMaxParallelTimmingEvents can not exceed the range of [1, 4096].");
        }
    }

    public static void setMaxReportEventLength(int i) {
        if (i <= 0) {
            logger.error("maxReportEventLength on setMaxReportEventLength() must greater than 0.");
        } else {
            maxReportEventLength = i;
        }
    }

    public static void setMaxSendRetryCount(int i) {
        if (isBetween(i, 1, 10)) {
            maxSendRetryCount = i;
        } else {
            logger.error("setMaxSendRetryCount can not exceed the range of [1,10].");
        }
    }

    public static void setMaxSessionStatReportCount(int i) {
        if (i < 0) {
            logger.error("maxSessionStatReportCount cannot be less than 0.");
        } else {
            maxSessionStatReportCount = i;
        }
    }

    public static void setMaxStoreEventCount(int i) {
        if (isBetween(i, 0, 500000)) {
            maxStoreEventCount = i;
        } else {
            logger.error("setMaxStoreEventCount can not exceed the range of [0, 500000].");
        }
    }

    public static void setQQ(Context context, String str) {
        StatService.reportQQ(context, str);
    }

    public static void setSendPeriodMinutes(int i) {
        if (isBetween(i, 1, 10080)) {
            sendPeriodMinutes = i;
        } else {
            logger.error("setSendPeriodMinutes can not exceed the range of [1, 7*24*60] minutes.");
        }
    }

    public static void setSessionTimoutMillis(int i) {
        if (isBetween(i, 1000, 86400000)) {
            sessionTimoutMillis = i;
        } else {
            logger.error("setSessionTimoutMillis can not exceed the range of [1000, 24 * 60 * 60 * 1000].");
        }
    }

    public static void setStatReportUrl(String str) {
        if (str == null || str.length() == 0) {
            logger.error("statReportUrl cannot be null or empty.");
        } else {
            statReportUrl = str;
        }
    }

    public static void setStatSendStrategy(StatReportStrategy statReportStrategy) {
        statSendStrategy = statReportStrategy;
        StatLogger statLogger = logger;
        statLogger.d("Change to statSendStrategy: " + statReportStrategy);
    }

    static void storeAppkeys(Context context, String str) {
        if (str != null) {
            StatPreferences.putString(context, "_mta_ky_tag_", StatCommonHelper.encode(str));
        }
    }

    private static boolean updateAppkeys(String str) {
        if (str == null) {
            return false;
        }
        String str2 = appkey;
        if (str2 == null) {
            appkey = str;
            return true;
        } else if (str2.contains(str)) {
            return false;
        } else {
            appkey += "|" + str;
            return true;
        }
    }

    static void updateCfg(OnlineConfig onlineConfig, JSONObject jSONObject) {
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase("v")) {
                    onlineConfig.version = jSONObject.getInt(next);
                } else if (next.equalsIgnoreCase(AbstractC5658c.a)) {
                    String string = jSONObject.getString(AbstractC5658c.a);
                    if (string.length() > 0) {
                        onlineConfig.props = new JSONObject(string);
                    }
                } else if (next.equalsIgnoreCase(WXComponent.PROP_FS_MATCH_PARENT)) {
                    onlineConfig.md5sum = jSONObject.getString(WXComponent.PROP_FS_MATCH_PARENT);
                }
            }
            StatStore statStore = StatStore.getInstance(StatDispatcher.getApplicationContext());
            if (statStore != null) {
                statStore.storeCfg(onlineConfig);
            }
            if (onlineConfig.type == sdkCfg.type) {
                updateReportStrategy(onlineConfig.props);
                checkHibernate(onlineConfig.props);
            }
        } catch (JSONException e) {
            logger.e((Exception) e);
        } catch (Throwable th) {
            logger.e(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void updateOnlineConfig(JSONObject jSONObject) {
        JSONObject jSONObject2;
        OnlineConfig onlineConfig;
        try {
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.equalsIgnoreCase(Integer.toString(sdkCfg.type))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    onlineConfig = sdkCfg;
                } else if (next.equalsIgnoreCase(Integer.toString(userCfg.type))) {
                    jSONObject2 = jSONObject.getJSONObject(next);
                    onlineConfig = userCfg;
                } else if (!next.equalsIgnoreCase("rs")) {
                    return;
                } else {
                    StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt(next));
                    if (statReportStrategy != null) {
                        statSendStrategy = statReportStrategy;
                        StatLogger statLogger = logger;
                        statLogger.d("Change to ReportStrategy:" + statReportStrategy.name());
                    }
                }
                updateCfg(onlineConfig, jSONObject2);
            }
        } catch (JSONException e) {
            logger.e((Exception) e);
        }
    }

    static void updateReportStrategy(JSONObject jSONObject) {
        try {
            StatReportStrategy statReportStrategy = StatReportStrategy.getStatReportStrategy(jSONObject.getInt("rs"));
            if (statReportStrategy != null) {
                setStatSendStrategy(statReportStrategy);
                StatLogger statLogger = logger;
                statLogger.debug("Change to ReportStrategy: " + statReportStrategy.name());
            }
        } catch (JSONException unused) {
            logger.d("rs not found.");
        }
    }
}
