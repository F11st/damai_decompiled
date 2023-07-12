package com.alibaba.appmonitor.event;

import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.model.UTDimensionValueSet;
import com.alibaba.appmonitor.pool.a;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import tb.bg2;
import tb.f4;
import tb.fd0;
import tb.gt2;
import tb.hl2;
import tb.nf1;
import tb.of1;
import tb.pf1;
import tb.qf0;
import tb.vo;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public class EventRepo {
    private static EventRepo g;
    private AtomicInteger c = new AtomicInteger(0);
    private AtomicInteger d = new AtomicInteger(0);
    private AtomicInteger e = new AtomicInteger(0);
    private SimpleDateFormat f = new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT);
    private Map<UTDimensionValueSet, pf1> b = new ConcurrentHashMap();
    private Map<String, fd0> a = new ConcurrentHashMap();

    private EventRepo() {
    }

    private void g(EventType eventType, AtomicInteger atomicInteger) {
        if (atomicInteger.incrementAndGet() >= eventType.getTriggerCount()) {
            Logger.f("EventRepo", eventType.toString(), " event size exceed trigger count.");
            w(eventType.getEventId());
        }
    }

    private UTDimensionValueSet p(int i, Long l, String str, String str2) {
        UTDimensionValueSet uTDimensionValueSet = (UTDimensionValueSet) a.a().poll(UTDimensionValueSet.class, new Object[0]);
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), str);
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), str2);
        } else {
            Context j = Variables.n().j();
            uTDimensionValueSet.setValue(LogField.ACCESS.toString(), NetworkUtil.c(j));
            uTDimensionValueSet.setValue(LogField.ACCESS_SUBTYPE.toString(), NetworkUtil.d(j));
        }
        uTDimensionValueSet.setValue(LogField.USERID.toString(), Variables.n().B());
        uTDimensionValueSet.setValue(LogField.USERNICK.toString(), Variables.n().C());
        uTDimensionValueSet.setValue(LogField.EVENTID.toString(), String.valueOf(i));
        if (l == null) {
            l = Long.valueOf(System.currentTimeMillis() / 1000);
        }
        uTDimensionValueSet.setValue("commitDay", this.f.format(new Date(l.longValue() * 1000)));
        return uTDimensionValueSet;
    }

    private AtomicInteger q(int i) {
        if (65501 == i) {
            return this.c;
        }
        if (65502 == i) {
            return this.d;
        }
        if (65503 == i) {
            return this.e;
        }
        return null;
    }

    private qf0 r(UTDimensionValueSet uTDimensionValueSet, String str, String str2, String str3, Class<? extends qf0> cls) {
        Integer eventId;
        pf1 pf1Var;
        if (yh2.g(str) && yh2.g(str2) && (eventId = uTDimensionValueSet.getEventId()) != null) {
            synchronized (this.b) {
                pf1Var = this.b.get(uTDimensionValueSet);
                if (pf1Var == null) {
                    pf1Var = (pf1) a.a().poll(pf1.class, new Object[0]);
                    this.b.put(uTDimensionValueSet, pf1Var);
                    Logger.f("EventRepo", "put in Map utDimensionValues", uTDimensionValueSet);
                }
            }
            return pf1Var.a(eventId, str, str2, str3, cls);
        }
        return null;
    }

    public static synchronized EventRepo s() {
        EventRepo eventRepo;
        synchronized (EventRepo.class) {
            if (g == null) {
                g = new EventRepo();
            }
            eventRepo = g;
        }
        return eventRepo;
    }

    private String t(String str, String str2) {
        nf1 b = of1.c().b(str, str2);
        if (b != null) {
            return b.d();
        }
        return null;
    }

    private void v(String str, String str2) {
        nf1 b = of1.c().b(str, str2);
        if (b != null) {
            b.f();
        }
    }

    public void a(int i, String str, String str2, String str3, String str4, String str5) {
        b(i, str, str2, str3, str4, str5, null, null, null);
    }

    public void b(int i, String str, String str2, String str3, String str4, String str5, Long l, String str6, String str7) {
        UTDimensionValueSet p = p(i, l, str6, str7);
        f4 f4Var = (f4) r(p, str, str2, str3, f4.class);
        if (f4Var != null) {
            f4Var.d(l);
            f4Var.c(str4, str5);
        }
        if (Variables.n().G()) {
            f4 f4Var2 = (f4) a.a().poll(f4.class, Integer.valueOf(i), str, str2, str3);
            f4Var2.d(l);
            f4Var2.c(str4, str5);
            gt2.b(p, f4Var2);
        }
        g(EventType.getEventType(i), this.c);
    }

    public void c(int i, String str, String str2, String str3) {
        d(i, str, str2, str3, null, null, null);
    }

    public void d(int i, String str, String str2, String str3, Long l, String str4, String str5) {
        UTDimensionValueSet p = p(i, l, str4, str5);
        f4 f4Var = (f4) r(p, str, str2, str3, f4.class);
        if (f4Var != null) {
            f4Var.e(l);
        }
        if (Variables.n().G()) {
            f4 f4Var2 = (f4) a.a().poll(f4.class, Integer.valueOf(i), str, str2, str3);
            f4Var2.e(l);
            gt2.b(p, f4Var2);
        }
        g(EventType.getEventType(i), this.c);
    }

    public void e(Integer num, String str, String str2, String str3) {
        String t = t(str, str2);
        if (t != null) {
            f(t, num, str, str2, str3);
        }
    }

    public void f(String str, Integer num, String str2, String str3, String str4) {
        fd0 fd0Var;
        nf1 b = of1.c().b(str2, str3);
        if (b != null && b.b() != null) {
            if (b.b().getMeasure(str4) != null) {
                synchronized (fd0.class) {
                    fd0Var = this.a.get(str);
                    if (fd0Var == null) {
                        fd0Var = (fd0) a.a().poll(fd0.class, num, str2, str3);
                        this.a.put(str, fd0Var);
                    }
                }
                fd0Var.h(str4);
                return;
            }
            return;
        }
        Logger.i("log discard!,metric is null,please call AppMonitor.register() once before Transaction.begin(measure)", new Object[0]);
    }

    public void h() {
        ArrayList arrayList = new ArrayList(this.a.keySet());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            String str = (String) arrayList.get(i);
            fd0 fd0Var = this.a.get(str);
            if (fd0Var != null && fd0Var.g()) {
                this.a.remove(str);
            }
        }
    }

    public void i(String str, Integer num, String str2, String str3, DimensionValueSet dimensionValueSet) {
        fd0 fd0Var;
        synchronized (fd0.class) {
            fd0Var = this.a.get(str);
            if (fd0Var == null) {
                fd0Var = (fd0) a.a().poll(fd0.class, num, str2, str3);
                this.a.put(str, fd0Var);
            }
        }
        fd0Var.c(dimensionValueSet);
    }

    public void j(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet) {
        k(i, str, str2, measureValueSet, dimensionValueSet, null, null, null);
    }

    public void k(int i, String str, String str2, MeasureValueSet measureValueSet, DimensionValueSet dimensionValueSet, Long l, String str3, String str4) {
        nf1 b = of1.c().b(str, str2);
        if (b != null) {
            if (b.a() != null) {
                b.a().setConstantValue(dimensionValueSet);
            }
            if (b.b() != null) {
                b.b().setConstantValue(measureValueSet);
            }
            UTDimensionValueSet p = p(i, l, str3, str4);
            bg2 bg2Var = (bg2) r(p, str, str2, null, bg2.class);
            if (bg2Var != null) {
                bg2Var.d(dimensionValueSet, measureValueSet);
            }
            if (Variables.n().G()) {
                bg2 bg2Var2 = (bg2) a.a().poll(bg2.class, Integer.valueOf(i), str, str2);
                bg2Var2.d(dimensionValueSet, measureValueSet);
                gt2.b(p, bg2Var2);
            }
            g(EventType.getEventType(i), this.e);
            return;
        }
        Logger.i("metric is null,stat commit failed,please call AppMonitor.register() once before AppMonitor.STAT.commit()", new Object[0]);
    }

    public void l(int i, String str, String str2, String str3, double d) {
        m(i, str, str2, str3, d, null, null, null);
    }

    public void m(int i, String str, String str2, String str3, double d, Long l, String str4, String str5) {
        UTDimensionValueSet p = p(i, l, str4, str5);
        vo voVar = (vo) r(p, str, str2, str3, vo.class);
        if (voVar != null) {
            voVar.c(d, l);
        }
        if (Variables.n().G()) {
            vo voVar2 = (vo) a.a().poll(vo.class, Integer.valueOf(i), str, str2, str3);
            voVar2.c(d, l);
            gt2.b(p, voVar2);
        }
        g(EventType.getEventType(i), this.d);
    }

    public void n(String str, String str2, String str3) {
        String t = t(str, str2);
        if (t != null) {
            o(t, str3, true);
        }
    }

    public void o(String str, String str2, boolean z) {
        fd0 fd0Var = this.a.get(str);
        if (fd0Var == null || !fd0Var.d(str2)) {
            return;
        }
        this.a.remove(str);
        if (z) {
            v(fd0Var.a, fd0Var.b);
        }
        j(fd0Var.d, fd0Var.a, fd0Var.b, fd0Var.f(), fd0Var.e());
        a.a().offer(fd0Var);
    }

    public Map<UTDimensionValueSet, List<qf0>> u(int i) {
        HashMap hashMap = new HashMap();
        synchronized (this.b) {
            Iterator<Map.Entry<UTDimensionValueSet, pf1>> it = this.b.entrySet().iterator();
            while (it.hasNext()) {
                Map.Entry<UTDimensionValueSet, pf1> next = it.next();
                UTDimensionValueSet key = next.getKey();
                pf1 value = next.getValue();
                if (key.getEventId().intValue() == i) {
                    if (value != null) {
                        hashMap.put(key, value.b());
                    } else {
                        Logger.f("error", "utDimensionValues", key);
                    }
                    it.remove();
                }
            }
        }
        q(i).set(0);
        return hashMap;
    }

    public void w(int i) {
        final Map<UTDimensionValueSet, List<qf0>> u = u(i);
        hl2.c().f(new Runnable() { // from class: com.alibaba.appmonitor.event.EventRepo.1
            @Override // java.lang.Runnable
            public void run() {
                gt2.d(u);
            }
        });
    }
}
