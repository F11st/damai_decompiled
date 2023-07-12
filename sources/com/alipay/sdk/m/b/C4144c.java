package com.alipay.sdk.m.b;

import android.content.Context;
import android.os.Looper;
import com.alipay.sdk.m.c.C4151a;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.b.c */
/* loaded from: classes12.dex */
public class C4144c {
    public static InterfaceC4143b a;
    public static boolean b;

    public static synchronized String a(Context context) {
        synchronized (C4144c.class) {
            if (context != null) {
                if (Looper.myLooper() != Looper.getMainLooper()) {
                    b(context);
                    InterfaceC4143b interfaceC4143b = a;
                    if (interfaceC4143b != null) {
                        try {
                            return interfaceC4143b.a(context);
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
        synchronized (C4144c.class) {
            if (a == null && !b) {
                a = C4151a.a(context);
                b = true;
            }
        }
    }
}
