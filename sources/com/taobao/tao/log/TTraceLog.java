package com.taobao.tao.log;

import android.util.Log;
import androidx.annotation.Keep;

/* compiled from: Taobao */
@Keep
@Deprecated
/* loaded from: classes11.dex */
public class TTraceLog {
    public static final int CLICK_EVENT = 1;
    public static final int COMMON_EVENT = 0;
    public static final String EVENT_CODE_OK = "0";
    private static final int MAX_POOL_SIZE = 20;
    public static final int NET_EVENT = 2;
    private static final String TAG = "TTraceLog";
    private static TTraceLog sPool;
    private static int sPoolSize;
    private static final Object sPoolSync = new Object();
    private String bizCode;
    private String cntID;
    private String codeMsg;
    private String eventCode;
    private String eventName;
    private long eventTime;
    private int eventType;
    private String ext;
    private String module;
    private TTraceLog next;
    private String refID;
    private String tag;

    private TTraceLog() {
        init();
    }

    private static void eventInternal(LogLevel logLevel, String str, String str2, String str3, String str4, String str5, long j, String str6, String str7, String str8, int i, String str9, String str10) {
        try {
            TLogNative.writeTraceLog(logLevel, str3, str4, str, str2, str5, j, str6, str7, str8, i, str9, str10);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() {
        this.next = null;
        this.cntID = "";
        this.refID = "";
        this.module = "";
        this.tag = "";
        this.eventTime = System.currentTimeMillis();
        this.eventName = "";
        this.eventCode = "0";
        this.codeMsg = "";
        this.eventType = 0;
        this.bizCode = "";
        this.ext = "";
    }

    private static TTraceLog obtain() {
        synchronized (sPoolSync) {
            TTraceLog tTraceLog = sPool;
            if (tTraceLog != null) {
                sPool = tTraceLog.next;
                tTraceLog.next = null;
                tTraceLog.eventTime = System.currentTimeMillis();
                sPoolSize--;
                return tTraceLog;
            }
            Log.d(TAG, "Create TTraceLog object");
            return new TTraceLog();
        }
    }

    private void recycle() {
        init();
        synchronized (sPoolSync) {
            int i = sPoolSize;
            if (i < 20) {
                this.next = sPool;
                sPool = this;
                sPoolSize = i + 1;
            }
        }
    }

    public static void release() {
        Log.d(TAG, "release object pool");
        synchronized (sPoolSync) {
            sPool = null;
            if (sPoolSize > 0) {
                System.gc();
            }
            sPoolSize = 0;
        }
    }

    public void debugEvent() {
        debugEvent(this.cntID, this.refID, this.tag, this.module, this.eventTime, this.eventName, this.eventCode, this.codeMsg, this.eventType, this.bizCode, this.ext);
        recycle();
    }

    public void event() {
        event(this.cntID, this.refID, this.module, this.tag, this.eventTime, this.eventName, this.eventCode, this.codeMsg, this.eventType, this.bizCode, this.ext);
        recycle();
    }

    public TTraceLog setBizCode(String str) {
        this.bizCode = str;
        return this;
    }

    public TTraceLog setCntID(String str) {
        this.cntID = str;
        return this;
    }

    public TTraceLog setCodeMsg(String str) {
        this.codeMsg = str;
        return this;
    }

    public TTraceLog setEventCode(String str) {
        this.eventCode = str;
        return this;
    }

    public TTraceLog setEventName(String str) {
        this.eventName = str;
        return this;
    }

    public TTraceLog setEventTime(long j) {
        this.eventTime = j;
        return this;
    }

    public TTraceLog setEventType(int i) {
        this.eventType = i;
        return this;
    }

    public TTraceLog setModule(String str) {
        this.module = str;
        return this;
    }

    public TTraceLog setRefID(String str) {
        this.refID = str;
        return this;
    }

    public TTraceLog setTag(String str) {
        this.tag = str;
        return this;
    }

    public static void debugEvent(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i, String str8, String str9) {
        eventInternal(LogLevel.D, str, str2, str3, str4, TSceneLog.getGlobalSceneID(), j, str5, str6, str7, i, str8, str9);
    }

    public static void event(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i, String str8, String str9) {
        eventInternal(LogLevel.I, str, str2, str3, str4, TSceneLog.getGlobalSceneID(), j, str5, str6, str7, i, str8, str9);
    }

    public static void debugEvent(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i, String str8) {
        debugEvent(str, str2, str3, str4, j, str5, str6, str7, i, "", str8);
    }

    public static void event(String str, String str2, String str3, String str4, long j, String str5, String str6, String str7, int i, String str8) {
        event(str, str2, str3, str4, j, str5, str6, str7, i, "", str8);
    }

    public static void debugEvent(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7) {
        debugEvent(str, str2, str3, "", j, str4, str5, str6, 0, str7);
    }

    public static void event(String str, String str2, String str3, long j, String str4, String str5, String str6, String str7) {
        event(str, str2, str3, "", j, str4, str5, str6, 0, str7);
    }

    public static TTraceLog obtain(String str) {
        TTraceLog obtain = obtain();
        obtain.eventName = str;
        return obtain;
    }

    public static TTraceLog obtain(String str, String str2) {
        TTraceLog obtain = obtain();
        obtain.eventName = str;
        obtain.module = str2;
        return obtain;
    }

    public static TTraceLog obtain(String str, String str2, String str3) {
        TTraceLog obtain = obtain();
        obtain.eventName = str;
        obtain.module = str2;
        obtain.ext = str3;
        return obtain;
    }
}
