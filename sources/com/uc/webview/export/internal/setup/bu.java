package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.ae;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class bu {
    static final Object g = new Object();
    protected bt e;
    protected UCSubSetupTask f;
    HashSet<ae.b> h = new HashSet<>();

    public bu(UCSubSetupTask uCSubSetupTask, bt btVar) {
        this.e = btVar;
        this.f = uCSubSetupTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d() {
        return ae.d.b;
    }

    public final void a(int i, ae.b bVar, Callable<?> callable, ValueCallback<Object> valueCallback) {
        if (ae.a().a(i, bVar, callable, valueCallback) == null || i == ae.d.b) {
            return;
        }
        synchronized (g) {
            this.h.add(bVar);
        }
    }

    protected boolean a() {
        return false;
    }

    protected void b() {
    }

    public final void c() {
        com.uc.webview.export.internal.uc.startup.b.a(298);
        com.uc.webview.export.internal.utility.n.a();
        if (a()) {
            return;
        }
        b();
    }

    public final void e() {
        synchronized (g) {
            if (this.h.isEmpty()) {
                return;
            }
            Iterator<ae.b> it = this.h.iterator();
            while (it.hasNext()) {
                ae.a().a(it.next());
            }
            this.h.clear();
        }
    }
}
