package com.alibaba.security.realidentity.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.realidentity.a.i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public abstract class b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    protected b d;
    protected HandlerThread e;
    protected Handler f;

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    static final class a {
        private static final b a = new f();

        private a() {
        }
    }

    public b() {
        HandlerThread handlerThread = new HandlerThread("rp_easytrack_thread");
        this.e = handlerThread;
        handlerThread.start();
        this.f = new Handler(this.e.getLooper());
    }

    public static b a() {
        if (a.a.d == null) {
            a.a.d = i.a.a.d();
        }
        return a.a;
    }

    public void b() {
        b bVar = this.d;
        if (bVar != null) {
            bVar.b();
        }
    }

    private static void a(b bVar) {
        a.a.d = bVar;
    }

    public void a(Map<String, Object> map) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(map);
        }
    }

    public void a(String str, String str2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        a(1, str, str2, hashMap2);
    }

    public void a(String str, String str2, Object obj, Object obj2, Object obj3, HashMap<String, String> hashMap) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(str, str2, obj, obj2, obj3, hashMap);
        }
    }

    public void a(int i, String str, String str2, Map<String, Object> map) {
        b bVar = this.d;
        if (bVar != null) {
            bVar.a(i, str, str2, map);
        }
    }
}
