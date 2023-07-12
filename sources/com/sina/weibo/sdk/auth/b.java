package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class b {
    private Map<String, WbAuthListener> e;

    /* compiled from: Taobao */
    /* loaded from: classes7.dex */
    static class a {
        private static final b f = new b((byte) 0);
    }

    /* synthetic */ b(byte b) {
        this();
    }

    public static synchronized b b() {
        b bVar;
        synchronized (b.class) {
            bVar = a.f;
        }
        return bVar;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.e.put(str, wbAuthListener);
        }
    }

    private b() {
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
