package anet.channel.appmonitor;

import android.text.TextUtils;
import anet.channel.statist.Dimension;
import anet.channel.statist.Measure;
import anet.channel.statist.Monitor;
import anet.channel.statist.StatObject;
import anet.channel.thread.ThreadPoolExecutorFactory;
import anet.channel.util.ALog;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import tb.g4;
import tb.rj1;
import tb.wo;
import tb.zh2;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class DefaultAppMonitor implements IAppMonitor {
    private static boolean a;
    private static Map<Class<?>, List<Field>> b = new ConcurrentHashMap();
    private static Map<Class<?>, List<Field>> c = new ConcurrentHashMap();
    private static Map<Field, String> d = new ConcurrentHashMap();
    private static Random e = new Random();
    private static volatile boolean f = false;
    private static volatile boolean g = false;
    private static List<StatObject> h = new CopyOnWriteArrayList();
    private static List<g4> i = new CopyOnWriteArrayList();
    private static List<wo> j = new CopyOnWriteArrayList();
    private static Set<Class<?>> k = Collections.newSetFromMap(new ConcurrentHashMap());

    public DefaultAppMonitor() {
        try {
            a = true;
        } catch (Exception unused) {
            a = false;
        }
    }

    private boolean e() {
        if (f) {
            return true;
        }
        try {
            f = AnalyticsMgr.l();
            ALog.e("awcn.DefaultAppMonitor", "[checkAppMonitorInit]", null, "status", Boolean.valueOf(f));
        } catch (Throwable unused) {
            f = true;
        }
        return f;
    }

    private void f() {
        if (g) {
            return;
        }
        ThreadPoolExecutorFactory.h(new Runnable() { // from class: anet.channel.appmonitor.DefaultAppMonitor.1
            @Override // java.lang.Runnable
            public void run() {
                boolean unused = DefaultAppMonitor.g = true;
                ALog.e("awcn.DefaultAppMonitor", "[flushWaitingMonitor]", null, new Object[0]);
                for (StatObject statObject : DefaultAppMonitor.h) {
                    DefaultAppMonitor.this.commitStat(statObject);
                }
                for (g4 g4Var : DefaultAppMonitor.i) {
                    DefaultAppMonitor.this.commitAlarm(g4Var);
                }
                for (wo woVar : DefaultAppMonitor.j) {
                    DefaultAppMonitor.this.commitCount(woVar);
                }
            }
        });
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitAlarm(g4 g4Var) {
        if (!a || g4Var == null || TextUtils.isEmpty(g4Var.e) || TextUtils.isEmpty(g4Var.f)) {
            return;
        }
        if (!e()) {
            i.add(g4Var);
            return;
        }
        f();
        if (ALog.g(1)) {
            ALog.c("awcn.DefaultAppMonitor", "commit alarm: " + g4Var, null, new Object[0]);
        }
        if (!g4Var.a) {
            AppMonitor.Alarm.commitFail(g4Var.e, g4Var.f, zh2.j(g4Var.b), zh2.j(g4Var.c), zh2.j(g4Var.d));
        } else {
            AppMonitor.Alarm.commitSuccess(g4Var.e, g4Var.f, zh2.j(g4Var.b));
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitCount(wo woVar) {
        if (!a || woVar == null || TextUtils.isEmpty(woVar.c) || TextUtils.isEmpty(woVar.d)) {
            return;
        }
        if (!e()) {
            j.add(woVar);
            return;
        }
        f();
        if (ALog.g(2)) {
            ALog.f("awcn.DefaultAppMonitor", "commit count: " + woVar, null, new Object[0]);
        }
        AppMonitor.Counter.commit(woVar.c, woVar.d, zh2.j(woVar.a), woVar.b);
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    public void commitStat(StatObject statObject) {
        if (!a || statObject == null) {
            return;
        }
        if (!e()) {
            h.add(statObject);
            return;
        }
        f();
        Class<?> cls = statObject.getClass();
        Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
        if (monitor == null) {
            return;
        }
        if (!k.contains(cls)) {
            g(cls);
        }
        if (statObject.beforeCommit()) {
            if (monitor.monitorPoint().equals("network")) {
                int c2 = rj1.c();
                c2 = (c2 > 10000 || c2 < 0) ? 10000 : 10000;
                if (c2 != 10000 && e.nextInt(10000) >= c2) {
                    return;
                }
            }
            try {
                DimensionValueSet create = DimensionValueSet.create();
                MeasureValueSet create2 = MeasureValueSet.create();
                List<Field> list = b.get(cls);
                HashMap hashMap = ALog.g(1) ? new HashMap() : null;
                if (list != null) {
                    for (Field field : list) {
                        Object obj = field.get(statObject);
                        create.setValue(d.get(field), obj == null ? "" : obj.toString());
                    }
                    for (Field field2 : c.get(cls)) {
                        Double valueOf = Double.valueOf(field2.getDouble(statObject));
                        create2.setValue(d.get(field2), valueOf.doubleValue());
                        if (hashMap != null) {
                            hashMap.put(d.get(field2), valueOf);
                        }
                    }
                }
                AppMonitor.Stat.commit(monitor.module(), monitor.monitorPoint(), create, create2);
                if (ALog.g(1)) {
                    ALog.c("awcn.DefaultAppMonitor", "commit stat: " + monitor.monitorPoint(), null, "\nDimensions", create.getMap().toString(), "\nMeasures", hashMap.toString());
                }
            } catch (Throwable th) {
                ALog.d("awcn.DefaultAppMonitor", "commit monitor point failed", null, th, new Object[0]);
            }
        }
    }

    synchronized void g(Class<?> cls) {
        if (cls != null) {
            if (a) {
                try {
                } catch (Exception e2) {
                    ALog.d("awcn.DefaultAppMonitor", "register fail", null, e2, new Object[0]);
                }
                if (k.contains(cls)) {
                    return;
                }
                Monitor monitor = (Monitor) cls.getAnnotation(Monitor.class);
                if (monitor == null) {
                    return;
                }
                Field[] fields = cls.getFields();
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                DimensionSet create = DimensionSet.create();
                MeasureSet create2 = MeasureSet.create();
                for (Field field : fields) {
                    Dimension dimension = (Dimension) field.getAnnotation(Dimension.class);
                    if (dimension != null) {
                        field.setAccessible(true);
                        arrayList.add(field);
                        String name = dimension.name().equals("") ? field.getName() : dimension.name();
                        d.put(field, name);
                        create.addDimension(name);
                    } else {
                        Measure measure = (Measure) field.getAnnotation(Measure.class);
                        if (measure != null) {
                            field.setAccessible(true);
                            arrayList2.add(field);
                            String name2 = measure.name().equals("") ? field.getName() : measure.name();
                            d.put(field, name2);
                            if (measure.max() != Double.MAX_VALUE) {
                                create2.addMeasure(new com.alibaba.mtl.appmonitor.model.Measure(name2, Double.valueOf(measure.constantValue()), Double.valueOf(measure.min()), Double.valueOf(measure.max())));
                            } else {
                                create2.addMeasure(name2);
                            }
                        }
                    }
                }
                b.put(cls, arrayList);
                c.put(cls, arrayList2);
                AppMonitor.register(monitor.module(), monitor.monitorPoint(), create2, create);
                k.add(cls);
            }
        }
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register() {
    }

    @Override // anet.channel.appmonitor.IAppMonitor
    @Deprecated
    public void register(Class<?> cls) {
    }
}
