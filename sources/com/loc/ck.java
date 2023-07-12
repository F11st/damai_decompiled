package com.loc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ck implements Runnable {
    InterfaceC5811a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.loc.ck$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC5811a {
        void a(ck ckVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC5811a interfaceC5811a;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (interfaceC5811a = this.e) == null) {
                return;
            }
            interfaceC5811a.a(this);
        } catch (Throwable th) {
            an.m(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
