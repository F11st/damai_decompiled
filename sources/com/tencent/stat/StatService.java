package com.tencent.stat;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.stat.common.Env;
import com.tencent.stat.common.SdkProtection;
import com.tencent.stat.common.StatCommonHelper;
import com.tencent.stat.common.StatLogger;
import com.tencent.stat.common.StatPreferences;
import com.tencent.stat.event.AdditionEvent;
import com.tencent.stat.event.CustomEvent;
import com.tencent.stat.event.ErrorEvent;
import com.tencent.stat.event.Event;
import com.tencent.stat.event.MonitorStatEvent;
import com.tencent.stat.event.PageView;
import com.tencent.stat.event.SessionEnv;
import java.lang.Thread;
import java.util.Map;
import java.util.Properties;
import java.util.WeakHashMap;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatService {
    public static final /* synthetic */ int a = 0;
    private static Handler handler;
    private static Map<CustomEvent.Key, Long> timedEventMap = new WeakHashMap();
    private static volatile long lastActivityTimestamp = 0;
    private static volatile long nextDayStartTimestamp = 0;
    private static volatile int sessionId = 0;
    private static volatile String last_pageId = "";
    private static volatile String lastReferPageId = "";
    private static Map<String, Long> timedPageEventMap = new WeakHashMap();
    private static StatLogger logger = StatCommonHelper.getLogger();
    private static Thread.UncaughtExceptionHandler originalExceptionHandler = null;
    private static boolean firstSession = true;

    /* compiled from: Taobao */
    /* renamed from: com.tencent.stat.StatService$2  reason: invalid class name */
    /* loaded from: classes11.dex */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$tencent$stat$StatReportStrategy;

        static {
            int[] iArr = new int[StatReportStrategy.values().length];
            $SwitchMap$com$tencent$stat$StatReportStrategy = iArr;
            try {
                iArr[StatReportStrategy.INSTANT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.ONLY_WIFI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.APP_LAUNCH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.DEVELOPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.BATCH.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.PERIOD.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$tencent$stat$StatReportStrategy[StatReportStrategy.ONLY_WIFI_NO_CACHE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class StatTask implements Runnable {
        private Event ev;
        private StatReportStrategy strategy;

        public StatTask(Event event) {
            this.strategy = null;
            this.ev = event;
            this.strategy = StatConfig.getStatSendStrategy();
        }

        private void sendEvents() {
            if (StatStore.getInstance().getNumStoredEvents() <= 0) {
                sendEventsNow(true);
                return;
            }
            StatStore.getInstance().storeEvent(this.ev, null);
            StatStore.getInstance().loadEvents(-1);
        }

        private void sendEventsNow(boolean z) {
            StatDispatcher.getInstance().send(this.ev, z ? new StatDispatchCallback() { // from class: com.tencent.stat.StatService.StatTask.1
                @Override // com.tencent.stat.StatDispatchCallback
                public void onDispatchFailure() {
                    StatStore.getInstance().storeEvent(StatTask.this.ev, null);
                }

                @Override // com.tencent.stat.StatDispatchCallback
                public void onDispatchSuccess() {
                    StatStore.getInstance().loadEvents(-1);
                }
            } : null);
        }

        /* JADX WARN: Code restructure failed: missing block: B:48:0x0162, code lost:
            if (com.tencent.stat.common.StatCommonHelper.isWiFiActive(r0) != false) goto L47;
         */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 378
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.tencent.stat.StatService.StatTask.run():void");
        }
    }

    public static void commitEvents(Context context, int i) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.commitEvents() can not be null!";
            } else if (i >= -1 && i != 0) {
                try {
                    StatStore.getInstance(context).loadEvents(i);
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str = "The maxNumber of StatService.commitEvents() should be -1 or bigger than 0.";
            }
            statLogger.error(str);
        }
    }

    static JSONObject getEncodeConfig() {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONObject jSONObject2 = new JSONObject();
            int i = StatConfig.sdkCfg.version;
            if (i != 0) {
                jSONObject2.put("v", i);
            }
            jSONObject.put(Integer.toString(StatConfig.sdkCfg.type), jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            int i2 = StatConfig.userCfg.version;
            if (i2 != 0) {
                jSONObject3.put("v", i2);
            }
            jSONObject.put(Integer.toString(StatConfig.userCfg.type), jSONObject3);
        } catch (JSONException e) {
            logger.e((Exception) e);
        }
        return jSONObject;
    }

    private static Handler getHandler(Context context) {
        init(context);
        return handler;
    }

    static int getSessionID(Context context, boolean z) {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z2 = z && currentTimeMillis - lastActivityTimestamp >= ((long) StatConfig.getSessionTimoutMillis());
        lastActivityTimestamp = currentTimeMillis;
        if (nextDayStartTimestamp == 0) {
            nextDayStartTimestamp = StatCommonHelper.getTomorrowStartMilliseconds();
        }
        if (currentTimeMillis >= nextDayStartTimestamp) {
            nextDayStartTimestamp = StatCommonHelper.getTomorrowStartMilliseconds();
            if (StatStore.getInstance(context).getUser(context).getType() != 1) {
                StatStore.getInstance(context).getUser(context).setType(1);
            }
            StatConfig.setCurrentDaySessionNumbers(0);
            z2 = true;
        }
        if (firstSession ? true : z2) {
            if (StatConfig.getCurrentDaySessionNumbers() < StatConfig.getMaxDaySessionNumbers()) {
                sendNewSessionEnv(context);
            } else {
                logger.e("Exceed StatConfig.getMaxDaySessionNumbers().");
            }
        }
        if (firstSession) {
            SdkProtection.endCheck(context);
            firstSession = false;
        }
        return sessionId;
    }

    static void init(Context context) {
        if (context != null && handler == null && isServiceStatActive(context)) {
            if (!SdkProtection.beginCheck(context)) {
                logger.error("ooh, Compatibility problem was found in this device!");
                logger.error("If you are on debug mode, please delete apk and try again.");
                StatConfig.setEnableStatService(false);
                return;
            }
            StatStore.getInstance(context);
            HandlerThread handlerThread = new HandlerThread("StatService");
            handlerThread.start();
            StatDispatcher.setApplicationContext(context);
            handler = new Handler(handlerThread.getLooper());
            originalExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            if (StatConfig.isAutoExceptionCaught()) {
                final Context applicationContext = context.getApplicationContext();
                Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.tencent.stat.StatService.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public void uncaughtException(Thread thread, Throwable th) {
                        if (StatConfig.isEnableStatService()) {
                            StatStore statStore = StatStore.getInstance(applicationContext);
                            Context context2 = applicationContext;
                            statStore.storeEvent(new ErrorEvent(context2, StatService.getSessionID(context2, false), 2, th), null);
                            StatService.logger.debug("MTA has caught the following uncaught exception:");
                            StatService.logger.error(th);
                            if (StatService.originalExceptionHandler == null) {
                                StatService.logger.debug("Original uncaught exception handler not set.");
                                return;
                            }
                            StatService.logger.debug("Call the original uncaught exception handler.");
                            StatService.originalExceptionHandler.uncaughtException(thread, th);
                        }
                    }
                });
            } else {
                logger.warn("MTA SDK AutoExceptionCaught is disable");
            }
            if (StatConfig.getStatSendStrategy() == StatReportStrategy.APP_LAUNCH && StatCommonHelper.isNetworkAvailable(context)) {
                StatStore.getInstance(context).loadEvents(-1);
            }
            logger.d("Init MTA StatService success.");
        }
    }

    static boolean isEmpty(String str) {
        return str == null || str.length() == 0;
    }

    static boolean isServiceStatActive(Context context) {
        if (StatCommonHelper.getSDKLongVersion("1.0.0") <= StatPreferences.getLong(context, StatConfig.HIBERNATE, 0L)) {
            StatConfig.setEnableStatService(false);
            return false;
        }
        return true;
    }

    public static void onPause(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.onPause() can not be null!");
                return;
            }
            try {
                String activityName = StatCommonHelper.getActivityName(context);
                Long remove = timedPageEventMap.remove(activityName);
                if (remove == null) {
                    StatLogger statLogger = logger;
                    statLogger.e("Starttime for PageID:" + activityName + " not found, lost onResume()?");
                    return;
                }
                Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                if (valueOf.longValue() == 0) {
                    valueOf = 1L;
                }
                if (lastReferPageId.equals(activityName)) {
                    lastReferPageId = "-";
                }
                PageView pageView = new PageView(context, lastReferPageId, getSessionID(context, false), valueOf);
                if (!pageView.getPageId().equals(last_pageId)) {
                    logger.warn("Invalid invocation since previous onResume on diff page.");
                }
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(pageView));
                }
                lastReferPageId = activityName;
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static void onResume(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.onResume() can not be null!");
                return;
            }
            try {
                if (timedPageEventMap.size() >= StatConfig.getMaxParallelTimmingEvents()) {
                    StatLogger statLogger = logger;
                    statLogger.error("The number of page events exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                    return;
                }
                last_pageId = StatCommonHelper.getActivityName(context);
                if (last_pageId == null) {
                    return;
                }
                if (!timedPageEventMap.containsKey(last_pageId)) {
                    timedPageEventMap.put(last_pageId, Long.valueOf(System.currentTimeMillis()));
                    getSessionID(context, true);
                    return;
                }
                StatLogger statLogger2 = logger;
                statLogger2.e("Duplicate PageID : " + last_pageId + ", onResume() repeated?");
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static void reportAppMonitorStat(Context context, StatAppMonitor statAppMonitor) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor == null) {
                statLogger = logger;
                str = "The StatAppMonitor of StatService.reportAppMonitorStat() can not be null!";
            } else if (statAppMonitor.getInterfaceName() != null) {
                try {
                    MonitorStatEvent monitorStatEvent = new MonitorStatEvent(context, getSessionID(context, false), statAppMonitor);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(monitorStatEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str = "The interfaceName of StatAppMonitor on StatService.reportAppMonitorStat() can not be null!";
            }
            statLogger.error(str);
        }
    }

    public static void reportError(Context context, String str) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.reportError() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), str);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(errorEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "Error message in StatService.reportError() is empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void reportException(Context context, Throwable th) {
        StatLogger statLogger;
        String str;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str = "The Context of StatService.reportException() can not be null!";
            } else if (th != null) {
                ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), 1, th);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(errorEvent));
                    return;
                }
                return;
            } else {
                statLogger = logger;
                str = "The Throwable error message of StatService.reportException() can not be null!";
            }
            statLogger.error(str);
        }
    }

    public static void reportQQ(Context context, String str) {
        if (str == null) {
            str = "";
        }
        if (StatConfig.qq.equals(str)) {
            return;
        }
        StatConfig.qq = str;
        sendAdditionEvent(context, null);
    }

    static void reportSdkSelfException(Context context, Throwable th) {
        try {
            if (StatConfig.isEnableStatService()) {
                if (context == null) {
                    logger.error("The Context of StatService.reportSdkSelfException() can not be null!");
                    return;
                }
                ErrorEvent errorEvent = new ErrorEvent(context, getSessionID(context, false), 99, th);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(errorEvent));
                }
            }
        } catch (Throwable th2) {
            StatLogger statLogger = logger;
            statLogger.e("reportSdkSelfException error: " + th2);
        }
    }

    static void sendAdditionEvent(Context context, Map<String, ?> map) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.sendAdditionEvent() can not be null!");
                return;
            }
            try {
                AdditionEvent additionEvent = new AdditionEvent(context, getSessionID(context, false), map);
                if (getHandler(context) != null) {
                    getHandler(context).post(new StatTask(additionEvent));
                }
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    static void sendNewSessionEnv(Context context) {
        if (getHandler(context) != null) {
            logger.d("start new session.");
            sessionId = StatCommonHelper.getNextSessionID();
            StatConfig.setCurSessionStatReportCount(0);
            StatConfig.incCurrentDaySessionNumbers();
            getHandler(context).post(new StatTask(new SessionEnv(context, sessionId, getEncodeConfig())));
        }
    }

    public static void setEnvAttributes(Context context, Map<String, String> map) {
        if (map == null || map.size() > 512) {
            logger.error("The map in setEnvAttributes can't be null or its size can't exceed 512.");
            return;
        }
        try {
            Env.appendEnvAttr(context, map);
        } catch (JSONException e) {
            logger.e((Exception) e);
        }
    }

    public static void startNewSession(Context context) {
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                logger.error("The Context of StatService.startNewSession() can not be null!");
                return;
            }
            try {
                stopSession();
                getSessionID(context, true);
            } catch (Throwable th) {
                reportSdkSelfException(context, th);
            }
        }
    }

    public static boolean startStatService(Context context, String str, String str2) throws MtaSDkException {
        if (!StatConfig.isEnableStatService()) {
            logger.error("MTA StatService is disable.");
            return false;
        }
        logger.d("MTA SDK version, current: 1.0.0 ,required: " + str2);
        if (context == null || str2 == null) {
            logger.error("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException("Context or mtaSdkVersion in StatService.startStatService() is null, please check it!");
        } else if (StatCommonHelper.getSDKLongVersion("1.0.0") >= StatCommonHelper.getSDKLongVersion(str2)) {
            try {
                String installChannel = StatConfig.getInstallChannel(context);
                if (installChannel == null || installChannel.length() == 0) {
                    StatConfig.setInstallChannel("-");
                }
                StatConfig.setAppKey(context, str);
                getHandler(context);
                return true;
            } catch (Throwable th) {
                logger.e(th);
                return false;
            }
        } else {
            String str3 = ("MTA SDK version conflicted, current: 1.0.0,required: " + str2) + ". please delete the current SDK and download the latest one. official website: http://mta.qq.com/ or http://mta.oa.com/";
            logger.error(str3);
            StatConfig.setEnableStatService(false);
            throw new MtaSDkException(str3);
        }
    }

    public static void stopSession() {
        lastActivityTimestamp = 0L;
    }

    public static void trackCustomBeginEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    CustomEvent.Key key = customEvent.getKey();
                    if (timedEventMap.containsKey(key)) {
                        StatLogger statLogger2 = logger;
                        statLogger2.error("Duplicate CustomEvent key: " + key.toString() + ", trackCustomBeginEvent() repeated?");
                        return;
                    } else if (timedEventMap.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        timedEventMap.put(key, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = logger;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomBeginKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomBeginEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    CustomEvent.Key key = customEvent.getKey();
                    if (timedEventMap.containsKey(key)) {
                        StatLogger statLogger2 = logger;
                        statLogger2.error("Duplicate CustomEvent key: " + key.toString() + ", trackCustomBeginKVEvent() repeated?");
                        return;
                    } else if (timedEventMap.size() <= StatConfig.getMaxParallelTimmingEvents()) {
                        timedEventMap.put(key, Long.valueOf(System.currentTimeMillis()));
                        return;
                    } else {
                        StatLogger statLogger3 = logger;
                        statLogger3.error("The number of timedEvent exceeds the maximum value " + Integer.toString(StatConfig.getMaxParallelTimmingEvents()));
                        return;
                    }
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomBeginEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    Long remove = timedEventMap.remove(customEvent.getKey());
                    if (remove != null) {
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                        customEvent.setDuration(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                        if (getHandler(context) != null) {
                            getHandler(context).post(new StatTask(customEvent));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = logger;
                    statLogger2.error("No start time found for custom event: " + customEvent.getKey().toString() + ", lost trackCustomBeginEvent()?");
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEndKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEndEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    Long remove = timedEventMap.remove(customEvent.getKey());
                    if (remove != null) {
                        Long valueOf = Long.valueOf((System.currentTimeMillis() - remove.longValue()) / 1000);
                        customEvent.setDuration(Long.valueOf(valueOf.longValue() == 0 ? 1L : valueOf.longValue()).longValue());
                        if (getHandler(context) != null) {
                            getHandler(context).post(new StatTask(customEvent));
                            return;
                        }
                        return;
                    }
                    StatLogger statLogger2 = logger;
                    statLogger2.error("No start time found for custom event: " + customEvent.getKey().toString() + ", lost trackCustomBeginKVEvent()?");
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEndEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomEvent(Context context, String str, String... strArr) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setArgs(strArr);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(customEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }

    public static void trackCustomKVEvent(Context context, String str, Properties properties) {
        StatLogger statLogger;
        String str2;
        if (StatConfig.isEnableStatService()) {
            if (context == null) {
                statLogger = logger;
                str2 = "The Context of StatService.trackCustomEvent() can not be null!";
            } else if (!isEmpty(str)) {
                try {
                    CustomEvent customEvent = new CustomEvent(context, getSessionID(context, false), str);
                    customEvent.setProperties(properties);
                    if (getHandler(context) != null) {
                        getHandler(context).post(new StatTask(customEvent));
                        return;
                    }
                    return;
                } catch (Throwable th) {
                    reportSdkSelfException(context, th);
                    return;
                }
            } else {
                statLogger = logger;
                str2 = "The event_id of StatService.trackCustomEvent() can not be null or empty.";
            }
            statLogger.error(str2);
        }
    }
}
