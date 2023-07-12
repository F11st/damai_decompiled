package com.alibaba.appmonitor.offline;

import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.config.SystemConfigMgr;
import com.alibaba.analytics.core.selfmonitor.CrashListener;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.analytics.utils.UTServerAppStatusTrigger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import tb.hl2;
import tb.nf1;
import tb.nl2;
import tb.ol2;
import tb.pl2;
import tb.pq;
import tb.ql2;
import tb.sp;
import tb.ve0;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class TempEventMgr implements SystemConfigMgr.IKVChangeListener, CrashListener, UTServerAppStatusTrigger.UTServerAppStatusChangeCallback {
    private static TempEventMgr j = new TempEventMgr();
    private List<pl2> a = Collections.synchronizedList(new ArrayList());
    private List<pl2> b = Collections.synchronizedList(new ArrayList());
    private List<pl2> c = Collections.synchronizedList(new ArrayList());
    private List<nf1> d = Collections.synchronizedList(new ArrayList());
    private long e = -2;
    private ScheduledFuture f = null;
    private ScheduledFuture g = null;
    private Runnable h = new Runnable() { // from class: com.alibaba.appmonitor.offline.TempEventMgr.1
        @Override // java.lang.Runnable
        public void run() {
            TempEventMgr.this.w();
        }
    };
    private Runnable i = new Runnable() { // from class: com.alibaba.appmonitor.offline.TempEventMgr.2
        @Override // java.lang.Runnable
        public void run() {
            TempEventMgr.this.o();
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    private class CleanTableTask implements Runnable {
        private CleanTableTask() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TempEventMgr.this.l();
            TempEventMgr.this.m();
            TempEventMgr.this.n();
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static /* synthetic */ class a {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[EventType.values().length];
            a = iArr;
            try {
                iArr[EventType.ALARM.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[EventType.COUNTER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[EventType.STAT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    private TempEventMgr() {
        UTServerAppStatusTrigger.d(this);
        sp.b().a(this);
        SystemConfigMgr.i().l("offline_duration", this);
        hl2.c().f(new CleanTableTask());
        v();
    }

    private void g(List<?> list) {
        ArrayList arrayList;
        if (list != null && list.size() > 0) {
            synchronized (list) {
                arrayList = new ArrayList(list);
                list.clear();
            }
            Variables.n().k().q(arrayList);
        }
    }

    private void h(List<nf1> list) {
        if (list == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        synchronized (list) {
            for (int i = 0; i < list.size(); i++) {
                nf1 nf1Var = list.get(i);
                nf1 u = u(nf1Var.getModule(), nf1Var.c());
                if (u != null) {
                    nf1Var._id = u._id;
                    arrayList.add(nf1Var);
                } else {
                    arrayList2.add(nf1Var);
                }
            }
            list.clear();
        }
        if (arrayList.size() > 0) {
            Variables.n().k().s(arrayList);
        }
        if (arrayList2.size() > 0) {
            Variables.n().k().q(arrayList2);
        }
    }

    private void i(Class<? extends ve0> cls) {
        k(cls);
        if (Variables.n().k().d(cls) > 50000) {
            j(cls, 10000);
        }
    }

    private long j(Class<? extends ve0> cls, int i) {
        String p = Variables.n().k().p(cls);
        pq k = Variables.n().k();
        return k.f(cls, " _id in ( select _id from " + p + "  ORDER BY  _id ASC LIMIT " + i + " )", null);
    }

    private int k(Class<? extends ve0> cls) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(5, -7);
        pq k = Variables.n().k();
        return k.f(cls, "commit_time< " + (calendar.getTimeInMillis() / 1000), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l() {
        i(nl2.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        i(ol2.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        i(ql2.class);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o() {
        EventType[] values;
        Logger.d();
        char c = 0;
        for (EventType eventType : EventType.values()) {
            while (true) {
                List<? extends pl2> s = s(eventType, 500);
                Object[] objArr = new Object[4];
                objArr[c] = "type";
                int i = 1;
                objArr[1] = eventType;
                int i2 = 2;
                objArr[2] = "events.size()";
                int i3 = 3;
                objArr[3] = Integer.valueOf(s.size());
                Logger.f(null, objArr);
                if (s.size() == 0) {
                    break;
                }
                int i4 = 0;
                while (i4 < s.size()) {
                    int i5 = a.a[eventType.ordinal()];
                    if (i5 == i) {
                        nl2 nl2Var = (nl2) s.get(i4);
                        if (nl2Var.a()) {
                            EventRepo.s().d(eventType.getEventId(), nl2Var.a, nl2Var.b, nl2Var.h, Long.valueOf(nl2Var.c), nl2Var.d, nl2Var.e);
                        } else {
                            EventRepo.s().b(eventType.getEventId(), nl2Var.a, nl2Var.b, nl2Var.h, nl2Var.f, nl2Var.g, Long.valueOf(nl2Var.c), nl2Var.d, nl2Var.e);
                        }
                    } else if (i5 == i2) {
                        ol2 ol2Var = (ol2) s.get(i4);
                        EventRepo.s().m(eventType.getEventId(), ol2Var.a, ol2Var.b, ol2Var.f, ol2Var.g, Long.valueOf(ol2Var.c), ol2Var.d, ol2Var.e);
                    } else if (i5 == i3) {
                        ql2 ql2Var = (ql2) s.get(i4);
                        EventRepo.s().j(eventType.getEventId(), ql2Var.a, ql2Var.b, ql2Var.b(), ql2Var.a());
                    }
                    i4++;
                    i = 1;
                    i2 = 2;
                    i3 = 3;
                }
                p(s);
                c = 0;
            }
        }
    }

    private void p(List<? extends pl2> list) {
        Variables.n().k().g(list);
    }

    private Class<? extends ve0> q(EventType eventType) {
        if (EventType.ALARM == eventType) {
            return nl2.class;
        }
        if (EventType.COUNTER == eventType) {
            return ol2.class;
        }
        if (EventType.STAT == eventType) {
            return ql2.class;
        }
        return pl2.class;
    }

    private long r() {
        int j2 = SystemConfigMgr.i().j("offline_duration");
        return j2 <= 0 ? 21600000 : j2 <= 3600 ? 3600000 : j2 * 1000;
    }

    public static TempEventMgr t() {
        return j;
    }

    private void v() {
        long r = r();
        if (this.e != r) {
            this.e = r;
            this.g = hl2.c().e(this.g, this.i, this.e);
        }
    }

    public void e(EventType eventType, pl2 pl2Var) {
        if (EventType.ALARM == eventType) {
            this.a.add(pl2Var);
        } else if (EventType.COUNTER == eventType) {
            this.b.add(pl2Var);
        } else if (EventType.STAT == eventType) {
            this.c.add(pl2Var);
        }
        if (this.a.size() < 100 && this.b.size() < 100 && this.c.size() < 100) {
            ScheduledFuture scheduledFuture = this.f;
            if (scheduledFuture == null || (scheduledFuture != null && scheduledFuture.isDone())) {
                this.f = hl2.c().d(this.f, this.h, 30000L);
                return;
            }
            return;
        }
        this.f = hl2.c().d(null, this.h, 0L);
    }

    public void f(nf1 nf1Var) {
        if (nf1Var != null) {
            this.d.add(nf1Var);
        }
        if (this.d.size() >= 100) {
            this.f = hl2.c().d(null, this.h, 0L);
        } else {
            this.f = hl2.c().d(this.f, this.h, 30000L);
        }
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onBackground() {
        Logger.f("TempEventMgr", "onBackground", Boolean.TRUE);
        this.f = hl2.c().d(null, this.h, 0L);
    }

    @Override // com.alibaba.analytics.core.config.SystemConfigMgr.IKVChangeListener
    public void onChange(String str, String str2) {
        if ("offline_duration".equalsIgnoreCase(str)) {
            v();
        }
    }

    @Override // com.alibaba.analytics.core.selfmonitor.CrashListener
    public void onCrash(Thread thread, Throwable th) {
        Logger.d();
        w();
    }

    @Override // com.alibaba.analytics.utils.UTServerAppStatusTrigger.UTServerAppStatusChangeCallback
    public void onForeground() {
    }

    public List<? extends pl2> s(EventType eventType, int i) {
        pq k = Variables.n().k();
        Class<? extends ve0> q = q(eventType);
        return k.i(q, "commit_time<" + ((System.currentTimeMillis() / 1000) - (r() / 1000)), "access,sub_access,module,monitor_point", i);
    }

    public nf1 u(String str, String str2) {
        pq k = Variables.n().k();
        List<? extends ve0> i = k.i(nf1.class, "module=\"" + str + "\" and monitor_point=\"" + str2 + "\"", null, 1);
        if (i == null || i.size() <= 0) {
            return null;
        }
        return (nf1) i.get(0);
    }

    public void w() {
        Logger.d();
        g(this.a);
        g(this.b);
        g(this.c);
        h(this.d);
    }
}
