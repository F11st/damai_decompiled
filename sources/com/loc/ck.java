package com.loc;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class ck implements Runnable {
    a e;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        void a(ck ckVar);
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            if (Thread.interrupted()) {
                return;
            }
            a();
            if (Thread.interrupted() || (aVar = this.e) == null) {
                return;
            }
            aVar.a(this);
        } catch (Throwable th) {
            an.m(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }
}
