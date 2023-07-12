package tb;

import com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener;
import com.alibaba.analytics.core.store.LogStoreMgr;
import com.alibaba.analytics.core.sync.C3127a;
import com.alibaba.analytics.core.sync.C3130d;
import com.alibaba.analytics.core.sync.C3133e;
import com.alibaba.analytics.core.sync.C3134f;
import com.alibaba.analytics.core.sync.C3140h;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.delegate.C3309a;
import com.alibaba.appmonitor.event.EventType;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class ga2 implements SelfMonitorEventListener {
    private static ga2 a = new ga2();

    public static ga2 a() {
        return a;
    }

    public void b() {
        try {
            C3134f.i().l.a(this);
        } catch (Throwable th) {
            Logger.h(null, th, new Object[0]);
        }
        try {
            C3133e.h().d.a(this);
        } catch (Throwable th2) {
            Logger.h(null, th2, new Object[0]);
        }
        try {
            C3140h.mMonitor.a(this);
        } catch (Throwable th3) {
            Logger.h(null, th3, new Object[0]);
        }
        try {
            C3127a.mMonitor.a(this);
        } catch (Throwable th4) {
            Logger.h(null, th4, new Object[0]);
        }
        try {
            LogStoreMgr.g.a(this);
        } catch (Throwable th5) {
            Logger.h(null, th5, new Object[0]);
        }
        try {
            C3130d.mMonitor.a(this);
        } catch (Throwable th6) {
            Logger.h(null, th6, new Object[0]);
        }
    }

    @Override // com.alibaba.analytics.core.selfmonitor.SelfMonitorEventListener
    public void onEvent(ea2 ea2Var) {
        EventType eventType = ea2Var.b;
        if (eventType == EventType.COUNTER) {
            C3309a.C3311b.c(ea2.module, ea2Var.a, ea2Var.c, ea2Var.d.doubleValue());
        } else if (eventType == EventType.STAT) {
            C3309a.C3313d.e(ea2.module, ea2Var.a, ea2Var.e, ea2Var.f);
        }
    }
}
