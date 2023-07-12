package com.taobao.android.dinamicx.notification;

import androidx.annotation.NonNull;
import com.taobao.android.dinamicx.C6368e;
import com.taobao.android.dinamicx.DXEngineConfig;
import com.taobao.android.dinamicx.monitor.DXAppMonitor;
import com.taobao.android.dinamicx.notification.DXSignalProduce;
import com.taobao.android.dinamicx.template.download.C6398a;
import com.taobao.android.dinamicx.template.download.DXTemplateItem;
import java.util.ArrayList;
import java.util.List;
import tb.nz;
import tb.ry;
import tb.rz;
import tb.s10;
import tb.y00;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class DXNotificationCenter implements DXSignalProduce.SignalReceiver {
    IDXNotificationListener a;
    int c;
    int d;
    int e;
    List<DXTemplateItem> f;
    List<DXTemplateItem> g;
    List<s10> h;
    boolean b = false;
    List<IDXNotificationListener> i = new ArrayList();

    public DXNotificationCenter(@NonNull DXEngineConfig dXEngineConfig) {
        int h = dXEngineConfig.h();
        this.c = h;
        int i = DXSignalProduce.f;
        this.d = (h < i ? i : h) / i;
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    private void a(s10 s10Var) {
        if (s10Var == null || s10Var.a == null) {
            return;
        }
        this.h.add(s10Var);
    }

    private boolean c() {
        return this.f.size() > 0 || this.g.size() > 0 || this.h.size() > 0;
    }

    synchronized void b() {
        this.f = new ArrayList();
        this.g = new ArrayList();
        this.h = new ArrayList();
    }

    public synchronized void d(C6398a c6398a) {
        if (c6398a == null) {
            return;
        }
        if (c6398a.b() && c6398a.a() != null) {
            this.f.add(c6398a.a());
        } else if (c6398a.a() != null) {
            this.g.add(c6398a.a());
        }
    }

    public synchronized void e(List<DXTemplateItem> list, List<DXTemplateItem> list2) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    this.f.addAll(list);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (list2 != null && list2.size() > 0) {
            this.g.addAll(list2);
        }
    }

    public synchronized void f(s10 s10Var) {
        if (s10Var != null) {
            if (s10Var.a != null) {
                a(s10Var);
            }
        }
    }

    public void g(IDXNotificationListener iDXNotificationListener) {
        if (iDXNotificationListener != null) {
            this.a = iDXNotificationListener;
            if (this.b) {
                return;
            }
            DXSignalProduce.e().g(this);
            this.b = true;
        }
    }

    synchronized void h() {
        if (c()) {
            final rz rzVar = new rz(this.f, this.g, this.h);
            b();
            y00.m(new Runnable() { // from class: com.taobao.android.dinamicx.notification.DXNotificationCenter.1
                @Override // java.lang.Runnable
                public void run() {
                    IDXNotificationListener iDXNotificationListener = DXNotificationCenter.this.a;
                    if (iDXNotificationListener != null) {
                        iDXNotificationListener.onNotificationListener(rzVar);
                        try {
                            List<IDXNotificationListener> list = DXNotificationCenter.this.i;
                            if (list == null || list.size() <= 0) {
                                return;
                            }
                            for (int i = 0; i < DXNotificationCenter.this.i.size(); i++) {
                                DXNotificationCenter.this.i.get(i).onNotificationListener(rzVar);
                            }
                        } catch (Throwable th) {
                            ry.b(th);
                            DXAppMonitor.q(nz.TAG, null, "Signal", "Signal_Exception", C6368e.DX_ERROR_CODE_SIGNAL_EXCEPTION_CRASH_2, ry.a(th));
                        }
                    }
                }
            });
        }
    }

    @Override // com.taobao.android.dinamicx.notification.DXSignalProduce.SignalReceiver
    public void onReceiver() {
        if (this.a != null && this.e == this.d) {
            h();
            this.e = 0;
            return;
        }
        this.e++;
    }
}
