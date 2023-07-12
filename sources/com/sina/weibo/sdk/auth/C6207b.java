package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.auth.b */
/* loaded from: classes7.dex */
public final class C6207b {
    private Map<String, WbAuthListener> e;

    /* compiled from: Taobao */
    /* renamed from: com.sina.weibo.sdk.auth.b$a */
    /* loaded from: classes7.dex */
    static class C6208a {
        private static final C6207b f = new C6207b((byte) 0);
    }

    /* synthetic */ C6207b(byte b) {
        this();
    }

    public static synchronized C6207b b() {
        C6207b c6207b;
        synchronized (C6207b.class) {
            c6207b = C6208a.f;
        }
        return c6207b;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.e.put(str, wbAuthListener);
        }
    }

    private C6207b() {
        this.e = new HashMap();
    }

    public final synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.e.remove(str);
    }

    public final synchronized WbAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.e.get(str);
    }
}
