package com.taobao.android.tlog.protocol;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Constants {
    public static final String KEY_APP_BUILD = "appBuild";
    public static final String KEY_CLIENT_EVENT_QUEUE = "clientEventQueue";
    public static final String KEY_FILE_NAME = "fileName";
    public static final String KEY_FILE_URL = "tfsPath";
    public static final String KEY_STAT_DATA = "statData";
    public static final int RESPONSE_CODE_FAIL_OTHER = 7;
    public static final int RESPONSE_CODE_FILE_UPLOAD_FAILED = 6;
    public static final int RESPONSE_CODE_FILE_UPLOAD_SUCCESS = 5;
    public static final int RESPONSE_CODE_NEW_COMMAND = 2;
    public static final int RESPONSE_CODE_SUCCESS_OTHER = 0;
    public static final String appIdName = "X-Rdwp-App-Id";
    public static final String appKeyName = "X-Rdwp-App-Key";
    public static final String deviceIdName = "X-Rdwp-Device-Id";
    public static final String opCodeName = "X-Rdwp-Op-Code";
    public static final String replyCode = "X-Rdwp-Reply-Code";
    public static final String replyIdName = "X-Rdwp-Reply-Id";
    public static final String replyMsg = "X-Rdwp-Reply-Message";
    public static final String requestIdName = "X-Rdwp-Request-Id";
    public static final String sessionIdName = "X-Rdwp-Session-Id";
    public static final String type = "type";
    public static final Integer version = 1;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class AndroidJointPointKey {
        public static final String EVENT_KEY_APP_STARTED = "event.launchFinished";
        public static final String EVENT_KEY_PAGE_LOAD_FINISHED = "event.pageLoadFinished";
        public static final String LIFECYCLE_KEY_ACTIVITY_CREATED = "onActivityCreated";
        public static final String LIFECYCLE_KEY_ACTIVITY_DESTROYED = "onActivityDestroyed";
        public static final String LIFECYCLE_KEY_ACTIVITY_PAUSED = "onActivityPaused";
        public static final String LIFECYCLE_KEY_ACTIVITY_RESUMED = "onActivityResumed";
        public static final String LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE = "onActivitySaveInstanceState";
        public static final String LIFECYCLE_KEY_ACTIVITY_STARTED = "onActivityStarted";
        public static final String LIFECYCLE_KEY_ACTIVITY_STOPPED = "onActivityStopped";
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static final class DevicePropertyKey {
        public static final String KEY_BATTERY_INFO = "BATTERY_INFO";
        public static final String KEY_CPU_STAT = "CPU_STAT";
        public static final String KEY_DEVICE_INFO = "DEVICE_INFO";
        public static final String KEY_IO_STAT = "IO_STAT";
        public static final String KEY_PERFORMANCE_INFO = "PERFORMANCE_INFO";
        public static final String KEY_TRAFFIC_STAT_INFO = "TRAFFIC_STAT_INFO";
    }
}
