package anet.channel;

import android.content.Intent;
import android.text.TextUtils;
import anet.channel.entity.ConnType;
import anet.channel.status.NetworkStatusHelper;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.hu0;
import tb.jg1;
import tb.t9;
import tb.xa2;
import tb.zh2;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AccsSessionManager {
    private static CopyOnWriteArraySet<ISessionListener> c = new CopyOnWriteArraySet<>();
    c a;
    Set<String> b = Collections.EMPTY_SET;

    /* JADX INFO: Access modifiers changed from: package-private */
    public AccsSessionManager(c cVar) {
        this.a = null;
        this.a = cVar;
    }

    private void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        ALog.c("awcn.AccsSessionManager", "closeSessions", this.a.b, "host", str);
        this.a.p(str).p(false);
    }

    private boolean e() {
        return !(hu0.i() && t9.i()) && NetworkStatusHelper.n();
    }

    public synchronized void b() {
        Collection<xa2> c2 = this.a.f.c();
        Set<String> set = Collections.EMPTY_SET;
        if (!c2.isEmpty()) {
            set = new TreeSet<>();
        }
        for (xa2 xa2Var : c2) {
            if (xa2Var.b) {
                set.add(zh2.e(anet.channel.strategy.a.a().getSchemeByHost(xa2Var.a, xa2Var.c ? "https" : "http"), jg1.SCHEME_SLASH, xa2Var.a));
            }
        }
        for (String str : this.b) {
            if (!set.contains(str)) {
                c(str);
            }
        }
        if (e()) {
            for (String str2 : set) {
                try {
                    this.a.i(str2, ConnType.TypeLevel.SPDY, 0L);
                } catch (Exception unused) {
                    ALog.e("start session failed", null, "host", str2);
                }
            }
            this.b = set;
        }
    }

    public synchronized void d(boolean z) {
        if (ALog.g(1)) {
            ALog.c("awcn.AccsSessionManager", "forceCloseSession", this.a.b, "reCreate", Boolean.valueOf(z));
        }
        for (String str : this.b) {
            c(str);
        }
        if (z) {
            b();
        }
    }

    public void f(final Intent intent) {
        ThreadPoolExecutorFactory.i(new Runnable() { // from class: anet.channel.AccsSessionManager.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = AccsSessionManager.c.iterator();
                while (it.hasNext()) {
                    try {
                        ((ISessionListener) it.next()).onConnectionChanged(intent);
                    } catch (Exception e) {
                        ALog.d("awcn.AccsSessionManager", "notifyListener exception.", null, e, new Object[0]);
                    }
                }
            }
        });
    }

    public void g(ISessionListener iSessionListener) {
        if (iSessionListener != null) {
            c.add(iSessionListener);
        }
    }

    public void h(ISessionListener iSessionListener) {
        c.remove(iSessionListener);
    }
}
