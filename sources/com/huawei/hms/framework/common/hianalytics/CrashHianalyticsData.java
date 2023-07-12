package com.huawei.hms.framework.common.hianalytics;

import android.os.Process;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CrashHianalyticsData extends HianalyticsBaseData {
    public static final String CRASH_TYPE = "crash_type";
    public static final String EVENT_ID_CRASH = "crash";
    public static final String EXCEPTION_NAME = "exception_name";
    public static final String MESSAGE = "message";
    public static final String PROCESS_ID = "process_id";
    public static final String STACK_TRACE = "stack_trace";
    public static final String THREAD_ID = "thread_id";
    public static final String THREAD_NAME = "thread_name";
    public static final String TIME = "time";

    public CrashHianalyticsData() {
        put("time", "" + System.currentTimeMillis());
        put(PROCESS_ID, "" + Process.myPid());
        put(THREAD_ID, "" + Process.myTid());
    }
}
