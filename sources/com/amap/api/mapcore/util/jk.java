package com.amap.api.mapcore.util;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class jk implements Runnable {
    InterfaceC4598a e;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.jk$a */
    /* loaded from: classes10.dex */
    interface InterfaceC4598a {
        void a(jk jkVar);

        void b(jk jkVar);

        void c(jk jkVar);
    }

    public final void cancelTask() {
        try {
            InterfaceC4598a interfaceC4598a = this.e;
            if (interfaceC4598a != null) {
                interfaceC4598a.c(this);
            }
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "cancelTask");
            th.printStackTrace();
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        InterfaceC4598a interfaceC4598a;
        try {
            InterfaceC4598a interfaceC4598a2 = this.e;
            if (interfaceC4598a2 != null) {
                interfaceC4598a2.a(this);
            }
            if (Thread.interrupted()) {
                return;
            }
            runTask();
            if (Thread.interrupted() || (interfaceC4598a = this.e) == null) {
                return;
            }
            interfaceC4598a.b(this);
        } catch (Throwable th) {
            hd.c(th, "ThreadTask", "run");
            th.printStackTrace();
        }
    }

    public abstract void runTask();
}
