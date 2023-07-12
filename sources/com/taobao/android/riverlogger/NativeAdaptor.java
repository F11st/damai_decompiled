package com.taobao.android.riverlogger;

import androidx.annotation.Keep;
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
        c cVar = new c(RVLLevel.valueOf(i), str);
        cVar.j = true;
        cVar.c = str2;
        cVar.d = str3;
        cVar.e = str4;
        cVar.f = str5;
        cVar.g = str6;
        cVar.h = j;
        cVar.i = str7;
        RVLLog.d(cVar);
    }

    static void sendMessage(String str) {
        RemoteChannel c = com.taobao.android.riverlogger.remote.b.c();
        if (c != null) {
            c.j(str);
        }
    }
}
