package org.android.spdy;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class spduLog {
    public static void Logd(String str, String str2) {
        if (!SpdyAgent.enableDebug || str == null || str2 == null) {
            return;
        }
        Log.d(str, Thread.currentThread().getId() + " - " + str2);
    }

    public static void Loge(String str, String str2) {
        if (!SpdyAgent.enableDebug || str == null || str2 == null) {
            return;
        }
        Log.e(str, Thread.currentThread().getId() + " - " + str2);
    }

    public static void Logi(String str, String str2) {
        if (!SpdyAgent.enableDebug || str == null || str2 == null) {
            return;
        }
        Log.i(str, Thread.currentThread().getId() + " - " + str2);
    }

    public static void Logd(String str, String str2, Object obj) {
        if (SpdyAgent.enableDebug) {
            Logd(str, str2 + String.valueOf(obj));
        }
    }

    public static void Loge(String str, String str2, Object obj) {
        if (SpdyAgent.enableDebug) {
            Loge(str, str2 + obj);
        }
    }

    public static void Logi(String str, String str2, long j) {
        if (SpdyAgent.enableDebug) {
            Logi(str, str2 + String.valueOf(j));
        }
    }

    public static void Logi(String str, String str2, Object obj) {
        if (SpdyAgent.enableDebug) {
            Logi(str, str2 + obj);
        }
    }
}
