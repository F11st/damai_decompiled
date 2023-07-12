package com.taobao.android.dinamicx.notification;

import com.taobao.android.dinamicx.e;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import java.lang.ref.WeakReference;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import tb.bu;
import tb.r10;
import tb.ry;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DXSignalProduce {
    public static int f = 50;
    CopyOnWriteArrayList<WeakReference<DXNotificationCenter>> a;
    CopyOnWriteArrayList<WeakReference<bu>> b;
    CopyOnWriteArrayList<WeakReference<com.taobao.android.dinamicx.notification.a>> c;
    private int d;
    int e;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface SignalReceiver {
        void onReceiver();
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    private static final class a {
        private static final DXSignalProduce a = new DXSignalProduce();
    }

    public static DXSignalProduce e() {
        return a.a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        int i = 0;
        while (i < this.b.size()) {
            bu buVar = this.b.get(i).get();
            if (buVar != null) {
                buVar.onReceiver();
                i++;
            } else {
                this.b.remove(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int i = 0;
        while (i < this.a.size()) {
            DXNotificationCenter dXNotificationCenter = this.a.get(i).get();
            if (dXNotificationCenter != null) {
                dXNotificationCenter.onReceiver();
                i++;
            } else {
                this.a.remove(i);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        int i = 0;
        while (i < this.c.size()) {
            com.taobao.android.dinamicx.notification.a aVar = this.c.get(i).get();
            if (aVar != null) {
                aVar.onReceiver();
                i++;
            } else {
                this.c.remove(i);
            }
        }
    }

    public void f(bu buVar) {
        if (buVar != null) {
            this.b.add(new WeakReference<>(buVar));
        }
    }

    public void g(DXNotificationCenter dXNotificationCenter) {
        if (dXNotificationCenter != null) {
            this.a.add(new WeakReference<>(dXNotificationCenter));
        }
    }

    void k() {
        y00.r().scheduleAtFixedRate(new Runnable() { // from class: com.taobao.android.dinamicx.notification.DXSignalProduce.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    DXSignalProduce.this.i();
                    DXSignalProduce.this.h();
                    DXSignalProduce.this.j();
                } catch (Throwable th) {
                    DXSignalProduce dXSignalProduce = DXSignalProduce.this;
                    if (dXSignalProduce.e < dXSignalProduce.d) {
                        e eVar = new e(r10.DB_NAME);
                        e.a aVar = new e.a("Signal", "Signal_Exception", e.DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH);
                        aVar.e = ry.a(th);
                        eVar.c.add(aVar);
                        DXAppMonitor.n(eVar);
                        DXSignalProduce.this.e++;
                    }
                }
            }
        }, 0L, f, TimeUnit.MILLISECONDS);
    }

    private DXSignalProduce() {
        this.d = 10;
        this.a = new CopyOnWriteArrayList<>();
        this.b = new CopyOnWriteArrayList<>();
        this.c = new CopyOnWriteArrayList<>();
        k();
    }
}
