package com.huawei.hms.hatool;

import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* renamed from: com.huawei.hms.hatool.i0 */
/* loaded from: classes10.dex */
public class C5625i0 implements InterfaceRunnableC5635n0 {
    public byte[] a;
    public String b;
    public String c;
    public String d;
    public String e;
    public List<C5642q> f;

    public C5625i0(byte[] bArr, String str, String str2, String str3, String str4, List<C5642q> list) {
        this.a = (byte[]) bArr.clone();
        this.b = str;
        this.c = str2;
        this.e = str3;
        this.d = str4;
        this.f = list;
    }

    public final C5608b0 a(Map<String, String> map) {
        return AbstractC5605a0.a(this.b, this.a, map);
    }

    public final Map<String, String> a() {
        return d1.b(this.c, this.e, this.d);
    }

    public final void b() {
        C5637o0.c().a(new C5631l0(this.f, this.c, this.d, this.e));
    }

    @Override // java.lang.Runnable
    public void run() {
        C5653y.c("hmsSdk", "send data running");
        int b = a(a()).b();
        if (b != 200) {
            b();
            return;
        }
        C5653y.b("hmsSdk", "events PostRequest sendevent TYPE : %s, TAG : %s, resultCode: %d ,reqID:" + this.d, this.e, this.c, Integer.valueOf(b));
    }
}
