package com.youku.httpcommunication;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class a {
    public static void a(String str, String str2) {
        if (b.b) {
            if (str2 == null) {
                str2 = "";
            }
            Log.v(str, str2);
        }
    }

    public static void a(String str, String str2, Throwable th) {
        if (b.b) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2, th);
        }
    }

    public static void a(String str, Throwable th) {
        if (b.b) {
            if (str == null) {
                str = "";
            }
            Log.e("HttpCommunication", str, th);
        }
    }

    public static void b(String str, String str2) {
        if (b.b) {
            if (str2 == null) {
                str2 = "";
            }
            Log.d(str, str2);
        }
    }

    public static void c(String str, String str2) {
        if (b.b) {
            if (str2 == null) {
                str2 = "";
            }
            Log.e(str, str2);
        }
    }
}
