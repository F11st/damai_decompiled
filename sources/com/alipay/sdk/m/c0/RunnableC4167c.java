package com.alipay.sdk.m.c0;

/* compiled from: Taobao */
/* renamed from: com.alipay.sdk.m.c0.c */
/* loaded from: classes12.dex */
public final class RunnableC4167c implements Runnable {
    public final /* synthetic */ C4166b a;

    public RunnableC4167c(C4166b c4166b) {
        this.a = c4166b;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.a.b();
        } catch (Exception e) {
            C4168d.a(e);
        }
    }
}
