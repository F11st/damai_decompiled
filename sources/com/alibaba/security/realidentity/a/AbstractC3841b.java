package com.alibaba.security.realidentity.a;

import android.os.Handler;
import android.os.HandlerThread;
import com.alibaba.security.realidentity.a.C3850i;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.realidentity.a.b */
/* loaded from: classes8.dex */
public abstract class AbstractC3841b {
    public static final int a = 0;
    public static final int b = 1;
    public static final int c = 2;
    protected AbstractC3841b d;
    protected HandlerThread e;
    protected Handler f;

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.realidentity.a.b$a */
    /* loaded from: classes8.dex */
    static final class C3842a {
        private static final AbstractC3841b a = new C3846f();

        private C3842a() {
        }
    }

    public AbstractC3841b() {
        HandlerThread handlerThread = new HandlerThread("rp_easytrack_thread");
        this.e = handlerThread;
        handlerThread.start();
        this.f = new Handler(this.e.getLooper());
    }

    public static AbstractC3841b a() {
        if (C3842a.a.d == null) {
            C3842a.a.d = C3850i.C3851a.a.d();
        }
        return C3842a.a;
    }

    public void b() {
        AbstractC3841b abstractC3841b = this.d;
        if (abstractC3841b != null) {
            abstractC3841b.b();
        }
    }

    private static void a(AbstractC3841b abstractC3841b) {
        C3842a.a.d = abstractC3841b;
    }

    public void a(Map<String, Object> map) {
        AbstractC3841b abstractC3841b = this.d;
        if (abstractC3841b != null) {
            abstractC3841b.a(map);
        }
    }

    public void a(String str, String str2, HashMap<String, String> hashMap) {
        HashMap hashMap2 = new HashMap();
        hashMap2.putAll(hashMap);
        a(1, str, str2, hashMap2);
    }

    public void a(String str, String str2, Object obj, Object obj2, Object obj3, HashMap<String, String> hashMap) {
        AbstractC3841b abstractC3841b = this.d;
        if (abstractC3841b != null) {
            abstractC3841b.a(str, str2, obj, obj2, obj3, hashMap);
        }
    }

    public void a(int i, String str, String str2, Map<String, Object> map) {
        AbstractC3841b abstractC3841b = this.d;
        if (abstractC3841b != null) {
            abstractC3841b.a(i, str, str2, map);
        }
    }
}
