package com.amap.api.col.s;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ee implements Runnable {
    InterfaceC4431a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.ee$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4431a {
        void a(ee eeVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC4431a interfaceC4431a;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (interfaceC4431a = this.e) == null) {
                return;
            }
            interfaceC4431a.a(this);
        } catch (Throwable th) {
            cl.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
