package com.amap.api.mapcore.util;

import java.net.Proxy;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.if  reason: invalid class name */
/* loaded from: classes10.dex */
public class Cif {
    private ig a;
    private ii b;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.if$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4587a {
        void onDownload(byte[] bArr, long j);

        void onException(Throwable th);

        void onFinish();

        void onStop();
    }

    public Cif(ii iiVar) {
        this(iiVar, 0L, -1L);
    }

    public void a(InterfaceC4587a interfaceC4587a) {
        this.a.a(this.b.getURL(), this.b.c(), this.b.isIPRequest(), this.b.getIPDNSName(), this.b.getRequestHead(), this.b.getParams(), this.b.getEntityBytes(), interfaceC4587a, ig.a(2, this.b));
    }

    public Cif(ii iiVar, long j, long j2) {
        this(iiVar, j, j2, false);
    }

    public Cif(ii iiVar, long j, long j2, boolean z) {
        this.b = iiVar;
        Proxy proxy = iiVar.c;
        ig igVar = new ig(iiVar.a, iiVar.b, proxy == null ? null : proxy, z);
        this.a = igVar;
        igVar.b(j2);
        this.a.a(j);
    }

    public void a() {
        this.a.a();
    }
}
