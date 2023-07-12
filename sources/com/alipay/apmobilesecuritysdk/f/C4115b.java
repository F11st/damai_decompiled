package com.alipay.apmobilesecuritysdk.f;

import java.util.LinkedList;

/* compiled from: Taobao */
/* renamed from: com.alipay.apmobilesecuritysdk.f.b */
/* loaded from: classes12.dex */
public final class C4115b {
    public static C4115b a = new C4115b();
    public Thread b = null;
    public LinkedList<Runnable> c = new LinkedList<>();

    public static C4115b a() {
        return a;
    }

    public static /* synthetic */ Thread b(C4115b c4115b) {
        c4115b.b = null;
        return null;
    }

    public final synchronized void a(Runnable runnable) {
        this.c.add(runnable);
        if (this.b == null) {
            Thread thread = new Thread(new RunnableC4116c(this));
            this.b = thread;
            thread.start();
        }
    }
}
