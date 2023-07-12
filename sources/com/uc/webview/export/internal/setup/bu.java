package com.uc.webview.export.internal.setup;

import android.webkit.ValueCallback;
import com.uc.webview.export.internal.setup.C7257ae;
import com.uc.webview.export.internal.uc.startup.C7302b;
import com.uc.webview.export.internal.utility.C7345n;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Callable;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public abstract class bu {
    static final Object g = new Object();
    protected bt e;
    protected UCSubSetupTask f;
    HashSet<C7257ae.EnumC7259b> h = new HashSet<>();

    public bu(UCSubSetupTask uCSubSetupTask, bt btVar) {
        this.e = btVar;
        this.f = uCSubSetupTask;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int d() {
        return C7257ae.C7261d.b;
    }

    public final void a(int i, C7257ae.EnumC7259b enumC7259b, Callable<?> callable, ValueCallback<Object> valueCallback) {
        if (C7257ae.a().a(i, enumC7259b, callable, valueCallback) == null || i == C7257ae.C7261d.b) {
            return;
        }
        synchronized (g) {
            this.h.add(enumC7259b);
        }
    }

    protected boolean a() {
        return false;
    }

    protected void b() {
    }

    public final void c() {
        C7302b.a(298);
        C7345n.a();
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
            Iterator<C7257ae.EnumC7259b> it = this.h.iterator();
            while (it.hasNext()) {
                C7257ae.a().a(it.next());
            }
            this.h.clear();
        }
    }
}
