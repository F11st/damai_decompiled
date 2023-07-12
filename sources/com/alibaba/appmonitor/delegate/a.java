package com.alibaba.appmonitor.delegate;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.alibaba.analytics.core.Variables;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.core.selfmonitor.exception.AppMonitorException;
import com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.appmonitor.event.EventRepo;
import com.alibaba.appmonitor.event.EventType;
import com.alibaba.appmonitor.offline.TempEventMgr;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.Measure;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.ut.mini.core.sign.IUTRequestAuthentication;
import com.ut.mini.core.sign.UTBaseRequestAuthentication;
import com.ut.mini.core.sign.UTSecurityThridRequestAuthentication;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import tb.nf1;
import tb.nl2;
import tb.of1;
import tb.ol2;
import tb.x9;
import tb.yh2;

/* compiled from: Taobao */
/* loaded from: classes15.dex */
public final class a {
    public static boolean a;
    private static Application b;
    static volatile boolean c;
    private static Map<String, String> d = new ConcurrentHashMap();

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.appmonitor.delegate.a$a  reason: collision with other inner class name */
    /* loaded from: classes15.dex */
    public static class C0136a {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.TRUE, null);
        }

        public static void b(String str, String str2, String str3, String str4) {
            c(str, str2, null, str3, str4);
        }

        public static void c(String str, String str2, String str3, String str4, String str5) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("_status", "0");
                    if (a.c && Variables.L()) {
                        EventType eventType = EventType.ALARM;
                        if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.FALSE, hashMap))) {
                            Logger.f("commitFail ", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                            if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                Context j = Variables.n().j();
                                TempEventMgr.t().e(eventType, new nl2(str, str2, str3, str4, str5, false, NetworkUtil.c(j), NetworkUtil.d(j)));
                                return;
                            }
                            EventRepo.s().a(eventType.getEventId(), str, str2, str3, str4, str5);
                            return;
                        }
                    }
                    Logger.r("log discard !", "module", str, "monitorPoint", str2, "errorCode:", str4, "errorMsg:", str5);
                    return;
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void d(String str, String str2) {
            e(str, str2, null);
        }

        public static void e(String str, String str2, String str3) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.c && Variables.L()) {
                        EventType eventType = EventType.ALARM;
                        if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().e(str, str2, Boolean.TRUE, null))) {
                            Logger.f("commitSuccess", "module", str, "monitorPoint", str2, "arg", str3);
                            if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                Context j = Variables.n().j();
                                TempEventMgr.t().e(eventType, new nl2(str, str2, str3, null, null, true, NetworkUtil.c(j), NetworkUtil.d(j)));
                                return;
                            }
                            EventRepo.s().c(eventType.getEventId(), str, str2, str3);
                            return;
                        }
                    }
                    Logger.r("log discard !", "module", str, "monitorPoint", str2, "arg", str3);
                    return;
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void f(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.ALARM, i);
        }

        public static void g(int i) {
            EventType eventType = EventType.ALARM;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class b {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d) {
            c(str, str2, null, d);
        }

        public static void c(String str, String str2, String str3, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.c && Variables.L()) {
                        EventType eventType = EventType.COUNTER;
                        if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                            Logger.f("commitCount", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                            if (com.alibaba.appmonitor.sample.a.h().k(eventType, str, str2)) {
                                Context j = Variables.n().j();
                                TempEventMgr.t().e(eventType, new ol2(str, str2, str3, d, NetworkUtil.c(j), NetworkUtil.d(j)));
                                return;
                            }
                            EventRepo.s().l(eventType.getEventId(), str, str2, str3, d);
                            return;
                        }
                    }
                    Logger.r("log discard !", "module", str, "monitorPoint", str2, "args", str3, "value", Double.valueOf(d));
                    return;
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void d(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.COUNTER, i);
        }

        public static void e(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class c {
        @Deprecated
        public static boolean a(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.COUNTER, str, str2);
        }

        public static void b(String str, String str2, double d) {
            try {
                if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                    if (a.c && Variables.L()) {
                        EventType eventType = EventType.COUNTER;
                        if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                            Logger.f("commitOffLineCount", "module", str, "monitorPoint", str2, "value", Double.valueOf(d));
                            EventRepo.s().l(eventType.getEventId(), str, str2, null, d);
                            return;
                        }
                    }
                    Logger.r("log discard !", "module", str, "monitorPoint", str2);
                    return;
                }
                Logger.v("AppMonitorDelegate", "module & monitorPoint must not null");
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void c(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.COUNTER, i);
        }

        public static void d(int i) {
            EventType eventType = EventType.COUNTER;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes15.dex */
    public static class d {
        public static void a(String str, String str2, String str3) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                        Logger.f("AppMonitorDelegate", "statEvent begin. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.s().e(Integer.valueOf(eventType.getEventId()), str, str2, str3);
                        return;
                    }
                }
                Logger.r("log discard !", "module", str, "monitorPoint", str2);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        @Deprecated
        public static boolean b(String str, String str2) {
            return com.alibaba.appmonitor.sample.a.h().f(EventType.STAT, str, str2);
        }

        public static void c(String str, String str2, double d) {
            d(str, str2, null, d);
        }

        /* JADX WARN: Code restructure failed: missing block: B:15:0x002d, code lost:
            if (com.alibaba.appmonitor.sample.a.h().g(r0, r8, r9, r10 != null ? r10.getMap() : null) != false) goto L16;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void d(java.lang.String r8, java.lang.String r9, com.alibaba.mtl.appmonitor.model.DimensionValueSet r10, double r11) {
            /*
                boolean r0 = com.alibaba.appmonitor.delegate.a.c     // Catch: java.lang.Throwable -> L8e
                r1 = 3
                r2 = 2
                r3 = 4
                r4 = 1
                r5 = 0
                if (r0 == 0) goto L7a
                boolean r0 = com.alibaba.analytics.core.Variables.L()     // Catch: java.lang.Throwable -> L8e
                if (r0 == 0) goto L7a
                com.alibaba.appmonitor.event.EventType r0 = com.alibaba.appmonitor.event.EventType.STAT     // Catch: java.lang.Throwable -> L8e
                boolean r6 = r0.isOpen()     // Catch: java.lang.Throwable -> L8e
                if (r6 == 0) goto L7a
                boolean r6 = com.alibaba.appmonitor.delegate.a.e()     // Catch: java.lang.Throwable -> L8e
                if (r6 != 0) goto L2f
                com.alibaba.appmonitor.sample.a r6 = com.alibaba.appmonitor.sample.a.h()     // Catch: java.lang.Throwable -> L8e
                if (r10 == 0) goto L28
                java.util.Map r7 = r10.getMap()     // Catch: java.lang.Throwable -> L8e
                goto L29
            L28:
                r7 = 0
            L29:
                boolean r0 = r6.g(r0, r8, r9, r7)     // Catch: java.lang.Throwable -> L8e
                if (r0 == 0) goto L7a
            L2f:
                java.lang.String r0 = "AppMonitorDelegate"
                java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L8e
                java.lang.String r6 = "statEvent commit. module: "
                r3[r5] = r6     // Catch: java.lang.Throwable -> L8e
                r3[r4] = r8     // Catch: java.lang.Throwable -> L8e
                java.lang.String r6 = " monitorPoint: "
                r3[r2] = r6     // Catch: java.lang.Throwable -> L8e
                r3[r1] = r9     // Catch: java.lang.Throwable -> L8e
                com.alibaba.analytics.utils.Logger.f(r0, r3)     // Catch: java.lang.Throwable -> L8e
                tb.of1 r0 = tb.of1.c()     // Catch: java.lang.Throwable -> L8e
                tb.nf1 r0 = r0.b(r8, r9)     // Catch: java.lang.Throwable -> L8e
                if (r0 == 0) goto L94
                com.alibaba.mtl.appmonitor.model.MeasureSet r0 = r0.b()     // Catch: java.lang.Throwable -> L8e
                java.util.List r0 = r0.getMeasures()     // Catch: java.lang.Throwable -> L8e
                int r1 = r0.size()     // Catch: java.lang.Throwable -> L8e
                if (r1 != r4) goto L94
                java.lang.Object r0 = r0.get(r5)     // Catch: java.lang.Throwable -> L8e
                com.alibaba.mtl.appmonitor.model.Measure r0 = (com.alibaba.mtl.appmonitor.model.Measure) r0     // Catch: java.lang.Throwable -> L8e
                java.lang.String r0 = r0.getName()     // Catch: java.lang.Throwable -> L8e
                com.alibaba.appmonitor.pool.a r1 = com.alibaba.appmonitor.pool.a.a()     // Catch: java.lang.Throwable -> L8e
                java.lang.Class<com.alibaba.mtl.appmonitor.model.MeasureValueSet> r2 = com.alibaba.mtl.appmonitor.model.MeasureValueSet.class
                java.lang.Object[] r3 = new java.lang.Object[r5]     // Catch: java.lang.Throwable -> L8e
                com.alibaba.appmonitor.pool.Reusable r1 = r1.poll(r2, r3)     // Catch: java.lang.Throwable -> L8e
                com.alibaba.mtl.appmonitor.model.MeasureValueSet r1 = (com.alibaba.mtl.appmonitor.model.MeasureValueSet) r1     // Catch: java.lang.Throwable -> L8e
                com.alibaba.mtl.appmonitor.model.MeasureValueSet r11 = r1.setValue(r0, r11)     // Catch: java.lang.Throwable -> L8e
                e(r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L8e
                goto L94
            L7a:
                java.lang.String r10 = "log discard !"
                java.lang.Object[] r11 = new java.lang.Object[r3]     // Catch: java.lang.Throwable -> L8e
                java.lang.String r12 = "module"
                r11[r5] = r12     // Catch: java.lang.Throwable -> L8e
                r11[r4] = r8     // Catch: java.lang.Throwable -> L8e
                java.lang.String r8 = "monitorPoint"
                r11[r2] = r8     // Catch: java.lang.Throwable -> L8e
                r11[r1] = r9     // Catch: java.lang.Throwable -> L8e
                com.alibaba.analytics.utils.Logger.r(r10, r11)     // Catch: java.lang.Throwable -> L8e
                goto L94
            L8e:
                r8 = move-exception
                com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder$ExceptionType r9 = com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder.ExceptionType.AP
                com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder.c(r9, r8)
            L94:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.appmonitor.delegate.a.d.d(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, double):void");
        }

        /* JADX WARN: Code restructure failed: missing block: B:16:0x0031, code lost:
            if (com.alibaba.appmonitor.sample.a.h().g(r0, r11, r12, r13 != null ? r13.getMap() : null) != false) goto L17;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public static void e(java.lang.String r11, java.lang.String r12, com.alibaba.mtl.appmonitor.model.DimensionValueSet r13, com.alibaba.mtl.appmonitor.model.MeasureValueSet r14) {
            /*
                boolean r0 = com.alibaba.appmonitor.delegate.a.c     // Catch: java.lang.Throwable -> L90
                r1 = 3
                java.lang.String r2 = "monitorPoint"
                r3 = 2
                r4 = 1
                java.lang.String r5 = "module"
                r6 = 0
                r7 = 4
                if (r0 == 0) goto L80
                boolean r0 = com.alibaba.analytics.core.Variables.L()     // Catch: java.lang.Throwable -> L90
                if (r0 == 0) goto L80
                com.alibaba.appmonitor.event.EventType r0 = com.alibaba.appmonitor.event.EventType.STAT     // Catch: java.lang.Throwable -> L90
                boolean r8 = r0.isOpen()     // Catch: java.lang.Throwable -> L90
                if (r8 == 0) goto L80
                boolean r8 = com.alibaba.appmonitor.delegate.a.e()     // Catch: java.lang.Throwable -> L90
                if (r8 != 0) goto L33
                com.alibaba.appmonitor.sample.a r8 = com.alibaba.appmonitor.sample.a.h()     // Catch: java.lang.Throwable -> L90
                if (r13 == 0) goto L2c
                java.util.Map r9 = r13.getMap()     // Catch: java.lang.Throwable -> L90
                goto L2d
            L2c:
                r9 = 0
            L2d:
                boolean r8 = r8.g(r0, r11, r12, r9)     // Catch: java.lang.Throwable -> L90
                if (r8 == 0) goto L80
            L33:
                java.lang.String r8 = "statEvent commit"
                java.lang.Object[] r7 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L90
                r7[r6] = r5     // Catch: java.lang.Throwable -> L90
                r7[r4] = r11     // Catch: java.lang.Throwable -> L90
                r7[r3] = r2     // Catch: java.lang.Throwable -> L90
                r7[r1] = r12     // Catch: java.lang.Throwable -> L90
                com.alibaba.analytics.utils.Logger.f(r8, r7)     // Catch: java.lang.Throwable -> L90
                com.alibaba.appmonitor.sample.a r1 = com.alibaba.appmonitor.sample.a.h()     // Catch: java.lang.Throwable -> L90
                boolean r1 = r1.k(r0, r11, r12)     // Catch: java.lang.Throwable -> L90
                if (r1 == 0) goto L6e
                com.alibaba.analytics.core.Variables r1 = com.alibaba.analytics.core.Variables.n()     // Catch: java.lang.Throwable -> L90
                android.content.Context r1 = r1.j()     // Catch: java.lang.Throwable -> L90
                com.alibaba.appmonitor.offline.TempEventMgr r2 = com.alibaba.appmonitor.offline.TempEventMgr.t()     // Catch: java.lang.Throwable -> L90
                tb.ql2 r10 = new tb.ql2     // Catch: java.lang.Throwable -> L90
                java.lang.String r8 = com.alibaba.analytics.core.network.NetworkUtil.c(r1)     // Catch: java.lang.Throwable -> L90
                java.lang.String r9 = com.alibaba.analytics.core.network.NetworkUtil.d(r1)     // Catch: java.lang.Throwable -> L90
                r3 = r10
                r4 = r11
                r5 = r12
                r6 = r13
                r7 = r14
                r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch: java.lang.Throwable -> L90
                r2.e(r0, r10)     // Catch: java.lang.Throwable -> L90
                goto L96
            L6e:
                com.alibaba.appmonitor.event.EventRepo r1 = com.alibaba.appmonitor.event.EventRepo.s()     // Catch: java.lang.Throwable -> L90
                int r2 = r0.getEventId()     // Catch: java.lang.Throwable -> L90
                r0 = r1
                r1 = r2
                r2 = r11
                r3 = r12
                r4 = r14
                r5 = r13
                r0.j(r1, r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L90
                goto L96
            L80:
                java.lang.String r13 = "log discard !"
                java.lang.Object[] r14 = new java.lang.Object[r7]     // Catch: java.lang.Throwable -> L90
                r14[r6] = r5     // Catch: java.lang.Throwable -> L90
                r14[r4] = r11     // Catch: java.lang.Throwable -> L90
                r14[r3] = r2     // Catch: java.lang.Throwable -> L90
                r14[r1] = r12     // Catch: java.lang.Throwable -> L90
                com.alibaba.analytics.utils.Logger.r(r13, r14)     // Catch: java.lang.Throwable -> L90
                goto L96
            L90:
                r11 = move-exception
                com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder$ExceptionType r12 = com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder.ExceptionType.AP
                com.alibaba.analytics.core.selfmonitor.exception.ExceptionEventBuilder.c(r12, r11)
            L96:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.alibaba.appmonitor.delegate.a.d.e(java.lang.String, java.lang.String, com.alibaba.mtl.appmonitor.model.DimensionValueSet, com.alibaba.mtl.appmonitor.model.MeasureValueSet):void");
        }

        public static void f(String str, String str2, String str3) {
            try {
                if (a.c && Variables.L()) {
                    EventType eventType = EventType.STAT;
                    if (eventType.isOpen() && (a.e() || com.alibaba.appmonitor.sample.a.h().f(eventType, str, str2))) {
                        Logger.f("statEvent end. module: ", str, " monitorPoint: ", str2, " measureName: ", str3);
                        EventRepo.s().n(str, str2, str3);
                        return;
                    }
                }
                Logger.r("log discard !", " module ", str, "monitorPoint", str2, " measureName", str3);
            } catch (Throwable th) {
                ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
            }
        }

        public static void g(int i) {
            com.alibaba.appmonitor.sample.a.h().o(EventType.STAT, i);
        }

        public static void h(int i) {
            EventType eventType = EventType.STAT;
            eventType.setStatisticsInterval(i);
            a.o(eventType, i);
        }
    }

    public static synchronized void a() {
        synchronized (a.class) {
            try {
                Logger.f("AppMonitorDelegate", "start destory");
                if (c) {
                    CommitTask.uploadAllEvent();
                    CommitTask.destroy();
                    CleanTask.destroy();
                    Application application = b;
                    if (application != null) {
                        NetworkUtil.s(application.getApplicationContext());
                    }
                    c = false;
                }
            } finally {
            }
        }
    }

    public static void b(boolean z) {
        Logger.f("AppMonitorDelegate", "[enableLog]");
        Logger.s(z);
    }

    public static Map<String, String> c() {
        return d;
    }

    public static synchronized void d(Application application) {
        synchronized (a.class) {
            Logger.f("AppMonitorDelegate", "start init");
            if (!c) {
                b = application;
                CleanTask.init();
                CommitTask.init();
                x9.a();
                c = true;
            }
        }
    }

    public static boolean e() {
        if (com.alibaba.analytics.core.config.b.a()) {
            return false;
        }
        return a;
    }

    public static void f(String str, String str2, MeasureSet measureSet) {
        g(str, str2, measureSet, null);
    }

    public static void g(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        h(str, str2, measureSet, dimensionSet, false);
    }

    public static void h(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet, boolean z) {
        try {
            if (c) {
                if (!yh2.e(str) && !yh2.e(str2)) {
                    nf1 nf1Var = new nf1(str, str2, measureSet, dimensionSet, z);
                    of1.c().a(nf1Var);
                    TempEventMgr.t().f(nf1Var);
                    return;
                }
                Logger.f("AppMonitorDelegate", "register stat event. module: ", str, " monitorPoint: ", str2);
                if (e()) {
                    throw new AppMonitorException("register error. module and monitorPoint can't be null");
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static void i(String str, String str2, MeasureSet measureSet, boolean z) {
        h(str, str2, measureSet, null, z);
    }

    public static void j(String str) {
        d.remove(str);
    }

    public static void k(String str, String str2) {
        if (yh2.f(str) || str2 == null) {
            return;
        }
        d.put(str, str2);
    }

    public static void l(boolean z, boolean z2, String str, String str2) {
        IUTRequestAuthentication uTBaseRequestAuthentication;
        if (z) {
            uTBaseRequestAuthentication = new UTSecurityThridRequestAuthentication(str, str2);
        } else {
            uTBaseRequestAuthentication = new UTBaseRequestAuthentication(str, str2, z2);
        }
        Variables.n().c0(uTBaseRequestAuthentication);
    }

    public static void m(int i) {
        EventType[] values;
        Logger.f("AppMonitorDelegate", "[setSampling]");
        for (EventType eventType : EventType.values()) {
            eventType.setDefaultSampling(i);
            com.alibaba.appmonitor.sample.a.h().o(eventType, i);
        }
    }

    public static void n(int i) {
        EventType[] values;
        for (EventType eventType : EventType.values()) {
            eventType.setStatisticsInterval(i);
            o(eventType, i);
        }
    }

    public static void o(EventType eventType, int i) {
        try {
            if (c && eventType != null) {
                CommitTask.setStatisticsInterval(eventType.getEventId(), i);
                if (i > 0) {
                    eventType.setOpen(true);
                } else {
                    eventType.setOpen(false);
                }
            }
        } catch (Throwable th) {
            ExceptionEventBuilder.c(ExceptionEventBuilder.ExceptionType.AP, th);
        }
    }

    public static synchronized void p() {
        synchronized (a.class) {
            try {
                Logger.f("AppMonitorDelegate", "triggerUpload");
                if (c && Variables.L()) {
                    CommitTask.uploadAllEvent();
                }
            } finally {
            }
        }
    }

    public static void q(String str, String str2, String str3, double d2, double d3, double d4) {
        nf1 b2;
        Logger.f("AppMonitorDelegate", "[updateMeasure]");
        try {
            if (!c || yh2.e(str) || yh2.e(str2) || (b2 = of1.c().b(str, str2)) == null || b2.b() == null) {
                return;
            }
            b2.b().upateMeasure(new Measure(str3, Double.valueOf(d4), Double.valueOf(d2), Double.valueOf(d3)));
        } catch (Exception unused) {
        }
    }
}
