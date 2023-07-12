package com.taobao.accs.utl;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.config.ConfigManager;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.ChannelService;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.net.SmartHeartbeatImpl;
import com.taobao.accs.utl.syncps.SyncChannelSwitch;
import com.taobao.aranger.ARanger;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.weex.common.Constants;
import com.youku.resource.utils.WoodpeckerLocalConfigCenter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.android.agoo.common.AgooConstants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class OrangeAdapter {
    private static final String ACCS_ENABLE_KEY = "main_function_enable";
    private static final String ALIAS_ALARM_SWITCH = "alias_alarm_switch";
    private static final String ASP_KEY = "asp_enable";
    private static final String BACKGROUND_INTERVAL_KEY = "back_interval";
    private static final String CHANNEL_INIT_OPTIMIZE_ENABLE = "channel_init_optimize_enable";
    private static final String CHANNEL_REGISTER_RECEIVER_KEY = "channel_register_receiver_enable";
    private static final String CONNECT_TIMEOUT = "connect_timeout";
    private static final String CONN_AUTO_SWITCH = "conn_auto_switch_channel";
    private static final String CONN_FB_STATE_IN_MESSAGE_SWITCH = "fb_message_state_switch";
    private static final String CONN_SERVICE_TYPE = "connection_service_type";
    private static final int CONN_TIMEOUT_DEFAULT = 10000;
    private static final String FOREGROUND_INTERVAL_KEY = "fore_interval";
    private static final String GLOBAL_CHANNEL_KEY = "global_channel_enable";
    private static final String HEARTBEAT_KEY = "heartbeat_smart_enable";
    private static final String KEEP_ALIVE_INIT_KEY = "keep_alive_init_enable";
    private static final String MODE = "mode";
    private static final int MODE_DEFAULT = 0;
    public static final String NAMESPACE = "accs";
    private static final String NATIVE_ACCS_SWITCH = "native_accs_switch";
    private static final String NORMAL_SWITCH = "accs_normal_switch";
    private static final String REGID_KEY = "regid_enable";
    private static final String SEND_FORE_STATE_HB_SWITCH = "send_fore_state_in_hb";
    private static final String SET_MAX_THREADS_KEY = "set_max_threads_enable";
    private static final String SPDY_CONNECTION_SLEEP_KEY = "spdy_connect_sleep_enable";
    private static final String TAG = "OrangeAdapter";
    private static final String TNET_ELECTION_KEY = "election_enable";
    private static final String UP_RETRY_IDS_KEY = "up_retry_ids";
    public static boolean mOrangeValid = true;
    private static Boolean eventCollectEnabled = null;
    private static volatile Boolean isTriggerEnable = null;
    private static volatile Long lastActiveTime = null;
    private static volatile Integer ConnectTimeout = null;
    private static List<String> upRetryServiceIdList = null;
    private static volatile String eventCollectStrategy = null;
    private static volatile String strategy = null;
    private static String regId = null;
    private static Boolean regIdSwitchEnable = null;
    private static Boolean resultOfGlobalChannel = null;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class OrangeListener implements OrangeConfigListenerV1 {
        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            if (GlobalClientInfo.getContext() == null) {
                ALog.e(OrangeAdapter.TAG, "onConfigUpdate context null", new Object[0]);
                return;
            }
            try {
                ALog.i(OrangeAdapter.TAG, "onConfigUpdate", "namespace", str);
                if ("accs".equals(str)) {
                    OrangeAdapter.checkAccsEnabled();
                    OrangeAdapter.getConfigForAccs();
                }
            } catch (Throwable th) {
                ALog.e(OrangeAdapter.TAG, "onConfigUpdate", th, new Object[0]);
            }
        }
    }

    public static void checkAccsEnabled() {
        if (isAccsEnabled()) {
            if (UtilityImpl.getFocusDisableStatus(GlobalClientInfo.getContext())) {
                ALog.i(TAG, "force enable service", new Object[0]);
                ACCSManager.forceEnableService(GlobalClientInfo.getContext());
                return;
            }
            return;
        }
        ALog.e(TAG, "force disable service", new Object[0]);
        ACCSManager.forceDisableService(GlobalClientInfo.getContext());
    }

    public static void clearRegId(Context context) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
            edit.remove(Constants.SP_KEY_REG_ID);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "clearRegId fail:", th, "regId", regId);
        }
    }

    public static int getADaemonTriggerType(Context context) {
        int i;
        try {
            i = APreferencesManager.getSharedPreferences(context, "adaemon", 4).getInt("triggerType", 0);
        } catch (Throwable th) {
            ALog.e(TAG, "getADaemonTriggerType", th, new Object[0]);
            i = 0;
        }
        ALog.d(TAG, "getADaemonTriggerType", "result", Integer.valueOf(i));
        return i;
    }

    public static long getBackInterval(Context context) {
        long j;
        try {
            j = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt("back_interval", SmartHeartbeatImpl.BACKGROUND_INTERVAL);
        } catch (Throwable th) {
            ALog.e(TAG, "getBackInterval", th, new Object[0]);
            j = 270000;
        }
        ALog.d(TAG, "getBackInterval", "result", Long.valueOf(j));
        return j;
    }

    private static boolean getChannelEnabledImpl(Context context) {
        return Boolean.parseBoolean(SyncChannelSwitch.getOrSetValueInProcessLock(context, SyncChannelSwitch.FILE_SCS, String.valueOf(getConfigFromSP(context, "global_channel_enable", AdapterUtilityImpl.isTaobao(context)))));
    }

    public static String getConfig(String str, String str2, String str3) {
        if (mOrangeValid) {
            return OrangeConfig.getInstance().getConfig(str, str2, str3);
        }
        ALog.w(TAG, "no orange sdk", new Object[0]);
        return str3;
    }

    public static void getConfigForAccs() {
        HashMap hashMap = new HashMap();
        hashMap.put("election_enable", Boolean.valueOf(getConfig("accs", "election_enable", String.valueOf(GlobalClientInfo.mSupprotElection))));
        hashMap.put(Constants.SP_KEY_HB_SMART_ENABLE, Boolean.valueOf(getConfig("accs", HEARTBEAT_KEY, "true")));
        hashMap.put("global_channel_enable", Boolean.valueOf(getConfig("accs", "global_channel_enable", AdapterUtilityImpl.isTaobao(GlobalClientInfo.getContext()) ? "true" : "false")));
        hashMap.put("keep_alive_init_enable", Boolean.valueOf(getConfig("accs", "keep_alive_init_enable", "true")));
        hashMap.put("spdy_connect_sleep_enable", Boolean.valueOf(getConfig("accs", "spdy_connect_sleep_enable", "false")));
        hashMap.put(Constants.SP_CHANNEL_REGISTER_RECEIVER, Boolean.valueOf(getConfig("accs", CHANNEL_REGISTER_RECEIVER_KEY, "true")));
        hashMap.put("channel_init_optimize_enable", Boolean.valueOf(getConfig("accs", "channel_init_optimize_enable", "true")));
        hashMap.put("regid_enable", Boolean.valueOf(getConfig("accs", "regid_enable", AdapterUtilityImpl.isTaobao(GlobalClientInfo.getContext()) ? "true" : "false")));
        hashMap.put("fb_message_state_switch", Boolean.valueOf(getConfig("accs", "fb_message_state_switch", "false")));
        hashMap.put("accs_normal_switch", Boolean.valueOf(getConfig("accs", "accs_normal_switch", "true")));
        hashMap.put("native_accs_switch", Boolean.valueOf(getConfig("accs", "native_accs_switch", "false")));
        hashMap.put("alias_alarm_switch", Boolean.valueOf(getConfig("accs", "alias_alarm_switch", "true")));
        hashMap.put("conn_auto_switch_channel", Boolean.valueOf(getConfig("accs", "conn_auto_switch_channel", "false")));
        hashMap.put("send_fore_state_in_hb", Boolean.valueOf(getConfig("accs", "send_fore_state_in_hb", "false")));
        String config = getConfig("accs", "set_max_threads_enable", "false");
        hashMap.put("set_max_threads_enable", Boolean.valueOf(config));
        if (!isRegIdSwitchEnable(GlobalClientInfo.getContext()) && Boolean.parseBoolean(config)) {
            clearRegId(GlobalClientInfo.getContext());
        }
        hashMap.put("asp_enable", Boolean.valueOf(getConfig("accs", "asp_enable", "true")));
        saveConfigToSP(GlobalClientInfo.getContext(), "connection_service_type", getConfig("accs", "connection_service_type", "0"));
        saveConfigToSP(GlobalClientInfo.getContext(), "up_retry_ids", getConfig("accs", "up_retry_ids", ""));
        try {
            saveConfigToSP(GlobalClientInfo.getContext(), "connect_timeout", Integer.parseInt(getConfig("accs", "connect_timeout", String.valueOf(10000))));
        } catch (NumberFormatException unused) {
            saveConfigToSP(GlobalClientInfo.getContext(), "connect_timeout", 10000);
        }
        try {
            saveConfigToSP(GlobalClientInfo.getContext(), "fore_interval", Integer.parseInt(getConfig("accs", "fore_interval", String.valueOf((int) SmartHeartbeatImpl.FOREGROUND_INTERVAL))));
        } catch (NumberFormatException unused2) {
            saveConfigToSP(GlobalClientInfo.getContext(), "fore_interval", (int) SmartHeartbeatImpl.FOREGROUND_INTERVAL);
        }
        try {
            saveConfigToSP(GlobalClientInfo.getContext(), "back_interval", Integer.parseInt(getConfig("accs", "back_interval", String.valueOf((int) SmartHeartbeatImpl.BACKGROUND_INTERVAL))));
        } catch (NumberFormatException unused3) {
            saveConfigToSP(GlobalClientInfo.getContext(), "back_interval", (int) SmartHeartbeatImpl.BACKGROUND_INTERVAL);
        }
        saveConfigsToSP(GlobalClientInfo.getContext(), hashMap);
        saveConfigToSP(GlobalClientInfo.getContext(), ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, UtilityImpl.String2Int(getConfig("accs", ChannelService.SUPPORT_FOREGROUND_VERSION_KEY, String.valueOf(21))));
    }

    private static boolean getConfigFromSP(Context context, String str, boolean z) {
        try {
            return APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 4).getBoolean(str, z);
        } catch (Exception e) {
            ALog.e(TAG, "getConfigFromSP fail:", e, "key", str);
            return z;
        }
    }

    public static long getConnectTimeout(Context context) {
        if (ConnectTimeout == null) {
            try {
                ConnectTimeout = Integer.valueOf(APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt("connect_timeout", 10000));
            } catch (Throwable th) {
                ALog.e(TAG, "getConnectTimeout", th, new Object[0]);
            }
            ALog.d(TAG, "getConnectTimeout", "result", ConnectTimeout);
        }
        return ConnectTimeout.intValue();
    }

    public static String getConnectionServiceType(Context context) {
        String str = "0";
        try {
            str = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString("connection_service_type", "0");
        } catch (Throwable th) {
            ALog.e(TAG, "getConnectionServiceType", th, new Object[0]);
        }
        ALog.d(TAG, "getConnectionServiceType", "type", str);
        return str;
    }

    public static int getCurrentVersion(Context context) {
        int i = Constants.SDK_VERSION_CODE;
        try {
            i = getConfigFromSP(context, "version", isChannelModeEnable() ? 302 : Constants.SDK_VERSION_CODE);
        } catch (Throwable th) {
            ALog.e(TAG, "getCurrentVersion", th, new Object[0]);
        }
        ALog.d(TAG, "getCurrentVersion", "result", Integer.valueOf(i));
        return i;
    }

    public static String getEventCollectStrategy(Context context) {
        if (eventCollectStrategy == null) {
            try {
                eventCollectStrategy = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString(Constants.KEY_EVENT_COLLECT_STRATEGY, "");
            } catch (Throwable th) {
                ALog.e(TAG, "getEventCollectStrategy", th, new Object[0]);
                eventCollectStrategy = "";
            }
        }
        ALog.d(TAG, "getEventCollectStrategy", "result", eventCollectStrategy);
        return eventCollectStrategy;
    }

    public static long getForeInterval(Context context) {
        long j;
        try {
            j = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt("fore_interval", SmartHeartbeatImpl.FOREGROUND_INTERVAL);
        } catch (Throwable th) {
            ALog.e(TAG, "getForeInterval", th, new Object[0]);
            j = 45000;
        }
        ALog.d(TAG, "getForeInterval", "result", Long.valueOf(j));
        return j;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static long getLastActiveTime(Context context) {
        if (lastActiveTime == null) {
            try {
                lastActiveTime = Long.valueOf(APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getLong(Constants.SP_KEY_LAST_LAUNCH_TIME, 0L));
            } catch (Throwable th) {
                ALog.e(TAG, "getLastActiveTime", th, new Object[0]);
            }
            ALog.d(TAG, "getLastActiveTime", "result", lastActiveTime);
        }
        return lastActiveTime.longValue();
    }

    public static String getRegId(Context context) {
        if (context == null) {
            context = ARanger.getContext();
        }
        if (TextUtils.isEmpty(regId)) {
            try {
                regId = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 4).getString(Constants.SP_KEY_REG_ID, "");
            } catch (Throwable th) {
                ALog.e(TAG, "getRegId", th, new Object[0]);
            }
            ALog.d(TAG, "getRegId", "result", regId);
        }
        return regId;
    }

    public static String getStrategy(Context context) {
        if (strategy == null) {
            try {
                strategy = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString("strategy", "[]");
            } catch (Throwable th) {
                ALog.e(TAG, "getStrategy", th, new Object[0]);
                strategy = "[]";
            }
        }
        ALog.d(TAG, "getStrategy", "result", strategy);
        return strategy;
    }

    public static List<String> getUpRetryServiceIds(Context context) {
        List<String> list = upRetryServiceIdList;
        if (list != null && list.size() > 0) {
            return upRetryServiceIdList;
        }
        String str = "";
        try {
            str = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString("up_retry_ids", "");
            if (TextUtils.isEmpty(str) && ABAdapter.isFeatureOpened(Constants.AB.KEY_UP_RETRY_IMPAAS)) {
                str = Constants.IMPAAS;
            }
            if (!TextUtils.isEmpty(str)) {
                List<String> asList = Arrays.asList(str.split(","));
                upRetryServiceIdList = asList;
                return asList;
            }
        } catch (Throwable th) {
            ALog.e(TAG, "getUpRetryServiceIds", th, new Object[0]);
        }
        ALog.d(TAG, "getUpRetryServiceIds", "ids", str);
        return null;
    }

    public static boolean isAccsEnabled() {
        boolean z;
        try {
            z = Boolean.parseBoolean(getConfig("accs", ACCS_ENABLE_KEY, "true"));
        } catch (Throwable th) {
            ALog.e(TAG, "isAccsEnabled", th, new Object[0]);
            z = true;
        }
        ALog.i(TAG, "isAccsEnabled", "enable", Boolean.valueOf(z));
        return z;
    }

    public static boolean isAliasAlarmEnabled() {
        try {
            return getConfigFromSP(GlobalClientInfo.getContext(), "alias_alarm_switch", true);
        } catch (Throwable th) {
            ALog.e(TAG, "isAliasAlarmEnabled", th, new Object[0]);
            return true;
        }
    }

    public static boolean isAspEnable(Context context) {
        boolean z;
        try {
            z = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getBoolean("asp_enable", true);
        } catch (Throwable th) {
            ALog.e(TAG, "isAspEnable", th, new Object[0]);
            z = false;
        }
        ALog.d(TAG, "isAspEnable", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isChannelInitOptimizeEnable(Context context) {
        boolean z;
        try {
            z = context.getSharedPreferences(Constants.SP_FILE_NAME, 4).getBoolean("channel_init_optimize_enable", true);
        } catch (Throwable th) {
            ALog.e(TAG, "isChannelInitOptimizeEnable", th, new Object[0]);
            z = false;
        }
        ALog.d(TAG, "isChannelInitOptimizeEnable", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isChannelModeEnable() {
        if (UtilityImpl.isDualApp(GlobalClientInfo.getContext())) {
            return false;
        }
        if (resultOfGlobalChannel == null) {
            try {
                Boolean valueOf = Boolean.valueOf(getChannelEnabledImpl(GlobalClientInfo.getContext()));
                resultOfGlobalChannel = valueOf;
                ALog.e(TAG, "isGlobalChannelEnable", "result", valueOf);
                AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_CHANNEL_ENABLED, "ch_" + resultOfGlobalChannel, 0.0d);
            } catch (Throwable th) {
                ALog.e(TAG, "isGlobalChannelEnable", th, new Object[0]);
            }
        }
        Boolean bool = resultOfGlobalChannel;
        return bool != null && bool.booleanValue();
    }

    public static boolean isConnAutoSwitch2Channel() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "conn_auto_switch_channel", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isConnAutoSwitch2Channel", th, new Object[0]);
            z = false;
        }
        ALog.e(TAG, "isConnAutoSwitch2Channel", ConfigManager.q, Boolean.valueOf(z));
        return z;
    }

    public static boolean isConnectStateListenerEnable(Context context) {
        return true;
    }

    public static boolean isEventCollectEnable(Context context) {
        boolean z;
        try {
            z = getConfigFromSP(context, "switch", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isEventCollectEnable", th, new Object[0]);
            z = false;
        }
        Boolean bool = eventCollectEnabled;
        if (bool == null || bool.booleanValue() != z) {
            ALog.e(TAG, "isEventCollectEnable", "result", Boolean.valueOf(z));
            eventCollectEnabled = Boolean.valueOf(z);
        }
        return z;
    }

    public static boolean isForeBgStateInMessage() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "fb_message_state_switch", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isForeBgStateInMessage", th, new Object[0]);
            z = false;
        }
        ALog.i(TAG, "isForeBgStateInMessage", Constants.Value.FIXED, Boolean.valueOf(z));
        return z;
    }

    public static boolean isKeepAliveInit() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "keep_alive_init_enable", true);
        } catch (Throwable th) {
            ALog.e(TAG, "isKeepAliveInit", th, new Object[0]);
            z = false;
        }
        ALog.d(TAG, "isKeepAliveInit", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isNativeAccsEnabledForWindvane() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "native_accs_switch", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isNativeAccsEnabledForWindvane", th, new Object[0]);
            z = false;
        }
        ALog.e(TAG, "isNativeAccsEnabledForWindvane", ConfigManager.q, Boolean.valueOf(z));
        return z;
    }

    public static boolean isRegIdNotExists(Context context) {
        return TextUtils.isEmpty(getRegId(context));
    }

    public static boolean isRegIdSwitchEnable(Context context) {
        if (context == null) {
            context = ARanger.getContext();
        }
        if (regIdSwitchEnable == null) {
            try {
                regIdSwitchEnable = Boolean.valueOf(getConfigFromSP(context, "regid_enable", AdapterUtilityImpl.isTaobao(context)));
            } catch (Throwable th) {
                ALog.e(TAG, "isRegIdSwitchEnable", th, new Object[0]);
            }
            ALog.d(TAG, "isRegIdSwitchEnable", "result", regIdSwitchEnable);
        }
        Boolean bool = regIdSwitchEnable;
        return bool != null && bool.booleanValue();
    }

    public static boolean isRegIdSwitchEnableAndValid(Context context) {
        if (isRegIdSwitchEnable(context)) {
            return !isRegIdNotExists(context);
        }
        return false;
    }

    public static boolean isRegisterReceiverEnable(Context context) {
        boolean z;
        try {
            z = context.getSharedPreferences(com.taobao.accs.common.Constants.SP_FILE_NAME, 4).getBoolean(com.taobao.accs.common.Constants.SP_CHANNEL_REGISTER_RECEIVER, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isRegisterReceiverEnable", th, new Object[0]);
            z = true;
        }
        ALog.d(TAG, "isRegisterReceiverEnable", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSendForeStateInHeartbeat() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "send_fore_state_in_hb", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isSendForeStateInHeartbeat", th, new Object[0]);
            z = false;
        }
        ALog.e(TAG, "isSendForeStateInHeartbeat", ConfigManager.q, Boolean.valueOf(z));
        return z;
    }

    public static boolean isSetMaxThreadsEnable() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "set_max_threads_enable", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isSetMaxThreadEnable", th, new Object[0]);
            z = false;
        }
        ALog.d(TAG, "isSetMaxThreadEnable", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSmartHb() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), com.taobao.accs.common.Constants.SP_KEY_HB_SMART_ENABLE, true);
        } catch (Throwable th) {
            ALog.e(TAG, "isSmartHb", th, new Object[0]);
            z = true;
        }
        ALog.d(TAG, "isSmartHb", "result", Boolean.valueOf(z));
        return z;
    }

    public static boolean isSpdyConnectSleepEnable() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "spdy_connect_sleep_enable", false);
        } catch (Throwable th) {
            ALog.e(TAG, "isSpdyConnectSleepEnable", th, new Object[0]);
            z = false;
        }
        ALog.i(TAG, "isSpdyConnectSleepEnable", "enable", Boolean.valueOf(z));
        return z;
    }

    public static boolean isTriggerEnable(Context context) {
        if (isTriggerEnable == null) {
            try {
                isTriggerEnable = Boolean.valueOf(getConfigFromSP(context, com.taobao.accs.common.Constants.KEY_CONTROL, false));
            } catch (Throwable th) {
                ALog.e(TAG, "isTriggerEnable", th, new Object[0]);
                isTriggerEnable = Boolean.FALSE;
            }
        }
        ALog.e(TAG, "isTriggerEnable", "result", isTriggerEnable);
        return isTriggerEnable.booleanValue();
    }

    public static boolean normalChangesEnabled() {
        boolean z;
        try {
            z = getConfigFromSP(GlobalClientInfo.getContext(), "accs_normal_switch", true);
        } catch (Throwable th) {
            ALog.e(TAG, "normalChangesEnabled", th, new Object[0]);
            z = true;
        }
        ALog.i(TAG, "normalChangesEnabled", AgooConstants.MESSAGE_FLAG, Boolean.valueOf(z));
        return z;
    }

    public static void registerListener(String[] strArr, OrangeConfigListenerV1 orangeConfigListenerV1) {
        if (mOrangeValid) {
            OrangeConfig.getInstance().registerListener(strArr, orangeConfigListenerV1);
        } else {
            ALog.w(TAG, "no orange sdk", new Object[0]);
        }
    }

    public static void resetChannelModeEnable() {
        ALog.e(TAG, "resetChannelModeEnable", new Object[0]);
        resultOfGlobalChannel = Boolean.FALSE;
        saveConfigToSP(GlobalClientInfo.getContext(), "global_channel_enable", false);
        AppMonitorAdapter.commitCount("accs", BaseMonitor.COUNT_CHANNEL_ENABLED, "reset", 0.0d);
    }

    public static void resetRegIdByMain(String str) {
        regId = str;
    }

    public static void saveConfigToSP(Context context, String str, boolean z) {
        try {
        } catch (Exception e) {
            ALog.e(TAG, "saveConfigToSP fail:", e, "key", str, "value", Boolean.valueOf(z));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).edit();
        edit.putBoolean(str, z);
        edit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, "value", Boolean.valueOf(z));
    }

    private static void saveConfigsToSP(Context context, Map<String, Boolean> map) {
        SharedPreferences sharedPreferences;
        if (map != null) {
            try {
            } catch (Exception e) {
                ALog.e(TAG, "saveConfigsToSP fail:", e, WoodpeckerLocalConfigCenter.SP_CONFIGS_KEY, map.toString());
            }
            if (map.size() == 0) {
                return;
            }
            Boolean bool = map.get("asp_enable");
            if (bool != null && bool.booleanValue()) {
                sharedPreferences = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4);
            } else {
                sharedPreferences = context.getSharedPreferences(com.taobao.accs.common.Constants.SP_FILE_NAME, 4);
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            for (Map.Entry<String, Boolean> entry : map.entrySet()) {
                edit.putBoolean(entry.getKey(), entry.getValue().booleanValue());
            }
            edit.apply();
            ALog.i(TAG, "saveConfigsToSP-accs", WoodpeckerLocalConfigCenter.SP_CONFIGS_KEY, map.toString());
        }
    }

    public static void saveEventCollectStrategy(Context context, String str) {
        try {
            eventCollectStrategy = str;
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 0).edit();
            edit.putString(com.taobao.accs.common.Constants.KEY_EVENT_COLLECT_STRATEGY, str);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "saveEventCollectStrategy fail:", th, "strategy", str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void saveLastActiveTime(Context context, long j) {
        try {
            lastActiveTime = Long.valueOf(j);
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 0).edit();
            edit.putLong(com.taobao.accs.common.Constants.SP_KEY_LAST_LAUNCH_TIME, j);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "saveLastActiveTime fail:", th, "lastLaunchTime", Long.valueOf(j));
        }
    }

    public static void saveRegId(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            regId = str;
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).edit();
            edit.putString(com.taobao.accs.common.Constants.SP_KEY_REG_ID, str);
            edit.commit();
        } catch (Throwable th) {
            ALog.e(TAG, "saveRegId fail:", th, "regId", str);
        }
    }

    public static void saveStrategy(Context context, String str) {
        try {
            strategy = str;
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 0).edit();
            edit.putString("strategy", str);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "saveStrategy fail:", th, "strategy", str);
        }
    }

    public static void setADaemonTriggerType(Context context) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, "adaemon", 4).edit();
            edit.putInt("triggerType", 0);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "setADaemonTriggerType", th, new Object[0]);
        }
    }

    public static void setDefaultVersion(Context context) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 0).edit();
            edit.putInt("version", isChannelModeEnable() ? 302 : com.taobao.accs.common.Constants.SDK_VERSION_CODE);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "setDefaultVersion fail:", th, new Object[0]);
        }
    }

    private static int getConfigFromSP(Context context, String str, int i) {
        try {
            return APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).getInt(str, i);
        } catch (Exception e) {
            ALog.e(TAG, "getConfigFromSP fail:", e, "key", str);
            return i;
        }
    }

    private static String getConfigFromSP(Context context, String str, String str2) {
        try {
            return APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).getString(str, str2);
        } catch (Exception e) {
            ALog.e(TAG, "getConfigFromSP fail:", e, "key", str);
            return str2;
        }
    }

    public static void saveConfigToSP(Context context, String str, int i) {
        try {
        } catch (Exception e) {
            ALog.e(TAG, "saveConfigToSP fail:", e, "key", str, "value", Integer.valueOf(i));
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).edit();
        edit.putInt(str, i);
        edit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, "value", Integer.valueOf(i));
    }

    public static void saveConfigToSP(Context context, String str, String str2) {
        try {
        } catch (Exception e) {
            ALog.e(TAG, "saveConfigToSP fail:", e, "key", str, "value", str2);
        }
        if (context == null) {
            ALog.e(TAG, "saveTLogOffToSP context null", new Object[0]);
            return;
        }
        SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, com.taobao.accs.common.Constants.SP_FILE_NAME, 4).edit();
        edit.putString(str, str2);
        edit.apply();
        ALog.i(TAG, "saveConfigToSP", "key", str, "value", str2);
    }
}
