package com.taobao.android.riverlogger;

import androidx.annotation.Keep;
import com.taobao.android.riverlogger.remote.C6581b;
import com.taobao.android.riverlogger.remote.RemoteChannel;

/* compiled from: Taobao */
@Keep
/* loaded from: classes12.dex */
class NativeAdaptor {
    NativeAdaptor() {
    }

    static void log(int i, String str, String str2) {
        RVLLog.e(RVLLevel.valueOf(i), str, str2);
    }

    static void logInfo(int i, String str, String str2, String str3, String str4, String str5, String str6, long j, String str7) {
        C6572c c6572c = new C6572c(RVLLevel.valueOf(i), str);
        c6572c.j = true;
        c6572c.c = str2;
        c6572c.d = str3;
        c6572c.e = str4;
        c6572c.f = str5;
        c6572c.g = str6;
        c6572c.h = j;
        c6572c.i = str7;
        RVLLog.d(c6572c);
    }

    static void sendMessage(String str) {
        RemoteChannel c = C6581b.c();
        if (c != null) {
            c.j(str);
        }
    }
}
