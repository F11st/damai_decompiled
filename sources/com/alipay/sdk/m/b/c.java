package com.alipay.sdk.m.b;

import android.content.Context;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class c {
    public static b a;
    public static boolean b;

    public static synchronized String a(Context context) {
        synchronized (c.class) {
            if (context != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    b(context);
                    b bVar = a;
                    if (bVar != null) {
                        try {
                            return bVar.a(context);
                        } catch (Exception unused) {
                        }
                    }
                    return null;
                }
                throw new IllegalStateException("Cannot be called from the main thread");
            }
            throw new RuntimeException("Context is null");
        }
    }

    public static void b(Context context) {
        if (a != null || b) {
            return;
        }
        synchronized (c.class) {
            if (a == null && !b) {
                a = com.alipay.sdk.m.c.a.a(context);
                b = true;
            }
        }
    }
}
