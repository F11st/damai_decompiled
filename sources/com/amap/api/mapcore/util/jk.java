package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class jk implements Runnable {
    a e;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    interface a {
        void a(jk jkVar);

        void b(jk jkVar);

        void c(jk jkVar);
    }

    public final void cancelTask() {
        try {
            a aVar = this.e;
            if (aVar != null) {
                aVar.c(this);
            }
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        a aVar;
        try {
            a aVar2 = this.e;
            if (aVar2 != null) {
                aVar2.a(this);
            }
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (aVar = this.e) == null) {
                return;
            }
            aVar.b(this);
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
