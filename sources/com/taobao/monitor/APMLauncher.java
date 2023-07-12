package com.taobao.monitor;

import android.app.Application;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.os.SystemClock;
import com.taobao.application.common.a;
import com.taobao.monitor.impl.common.ThreadSwitcher;
import com.taobao.monitor.impl.data.lifecycle.ActivityLifecycle;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.ApplicationGCDispatcher;
import com.taobao.monitor.impl.trace.ApplicationLowMemoryDispatcher;
import com.taobao.monitor.impl.trace.CustomPageLifecycleDispatcher;
import com.taobao.monitor.impl.trace.FPSDispatcher;
import com.taobao.monitor.impl.trace.FragmentLifecycleDispatcher;
import com.taobao.monitor.impl.trace.ImageStageDispatcher;
import com.taobao.monitor.impl.trace.NetworkStageDispatcher;
import com.taobao.monitor.impl.trace.PageLeaveDispatcher;
import com.taobao.monitor.impl.trace.RenderDispatcher;
import com.taobao.monitor.impl.trace.WindowEventDispatcher;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Observer;
import tb.a0;
import tb.as1;
import tb.b0;
import tb.bs1;
import tb.bv1;
import tb.ca0;
import tb.fu0;
import tb.ho2;
import tb.i81;
import tb.jd0;
import tb.l13;
import tb.lu0;
import tb.rh1;
import tb.tj1;
import tb.uj1;
import tb.v6;
import tb.wy2;
import tb.yp1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class APMLauncher {
    private static boolean a;
    static List<Observer> b = new ArrayList();
    private static final v6 c = new v6();

    private static void f() {
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.APMLauncher.3
            @Override // java.lang.Runnable
            public void run() {
                APMLauncher.m();
                APMLauncher.i();
                APMLauncher.p();
                APMLauncher.o();
            }
        });
    }

    public static void g(Application application, Map<String, Object> map) {
        if (a) {
            return;
        }
        a = true;
        n(application, map);
        k();
        h();
        f();
        b.add(l(application));
        j(b);
        a.a();
    }

    private static void h() {
        ca0.a(b0.APPLICATION_LOW_MEMORY_DISPATCHER, new ApplicationLowMemoryDispatcher());
        ca0.a(b0.APPLICATION_GC_DISPATCHER, new ApplicationGCDispatcher());
        ca0.a(b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER, new ApplicationBackgroundChangedDispatcher());
        FPSDispatcher fPSDispatcher = new FPSDispatcher();
        ca0.a(b0.ACTIVITY_FPS_DISPATCHER, fPSDispatcher);
        ThreadSwitcher.a().e(fPSDispatcher);
        ca0.a(b0.WINDOW_EVENT_DISPATCHER, new WindowEventDispatcher());
        ca0.a(b0.PAGE_RENDER_DISPATCHER, new RenderDispatcher());
        ca0.a(b0.PAGE_LEAVE_DISPATCHER, new PageLeaveDispatcher());
        ActivityLifeCycleDispatcher activityLifeCycleDispatcher = new ActivityLifeCycleDispatcher();
        activityLifeCycleDispatcher.addListener(new i81());
        ca0.a(b0.ACTIVITY_LIFECYCLE_DISPATCHER, activityLifeCycleDispatcher);
        ca0.a(b0.FRAGMENT_LIFECYCLE_DISPATCHER, new FragmentLifecycleDispatcher());
        ca0.a(b0.FRAGMENT_LIFECYCLE_FUNCTION_DISPATCHER, new com.taobao.monitor.impl.trace.a());
        CustomPageLifecycleDispatcher customPageLifecycleDispatcher = new CustomPageLifecycleDispatcher();
        customPageLifecycleDispatcher.addListener(new yp1());
        customPageLifecycleDispatcher.addListener(new wy2());
        ca0.a(b0.CUSTOM_PAGE_LIFECYCLE_DISPATCHER, customPageLifecycleDispatcher);
        ca0.a(b0.IMAGE_STAGE_DISPATCHER, new ImageStageDispatcher());
        bs1.b().a(new as1());
        ca0.a(b0.NETWORK_STAGE_DISPATCHER, new NetworkStageDispatcher());
        uj1.a().c(new tj1());
        rh1.a().c(new tj1());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i() {
    }

    private static void j(final List<Observer> list) {
        if (Build.VERSION.SDK_INT <= 28) {
            q(new Runnable() { // from class: com.taobao.monitor.APMLauncher.2
                @Override // java.lang.Runnable
                public void run() {
                    com.taobao.monitor.impl.common.a.a(list);
                }
            });
        }
    }

    private static void k() {
        fu0.e().d().postDelayed(new Runnable() { // from class: com.taobao.monitor.APMLauncher.1

            /* compiled from: Taobao */
            /* renamed from: com.taobao.monitor.APMLauncher$1$a */
            /* loaded from: classes11.dex */
            class a implements MessageQueue.IdleHandler {
                a(AnonymousClass1 anonymousClass1) {
                }

                @Override // android.os.MessageQueue.IdleHandler
                public boolean queueIdle() {
                    if (lu0.f == 0) {
                        LauncherProcessor.S = LauncherProcessor.WARM;
                        LauncherProcessor.T = true;
                        APMLauncher.c.d(LauncherProcessor.WARM);
                        return false;
                    }
                    return false;
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                Looper.getMainLooper();
                Looper.myQueue().addIdleHandler(new a(this));
            }
        }, 3000L);
    }

    private static Observer l(Application application) {
        ActivityLifecycle activityLifecycle = new ActivityLifecycle(application);
        application.registerActivityLifecycleCallbacks(activityLifecycle);
        return activityLifecycle;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void m() {
        lu0.l = System.getProperty("oppoCPUResource", "false");
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00d4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static void n(android.app.Application r6, java.util.Map<java.lang.String, java.lang.Object> r7) {
        /*
            long r0 = tb.ho2.a()
            tb.lu0.j = r0
            tb.v6 r0 = com.taobao.monitor.APMLauncher.c
            java.lang.String r1 = "COLD"
            r0.d(r1)
            long r1 = android.os.SystemClock.uptimeMillis()
            r0.e(r1)
            long r1 = java.lang.System.currentTimeMillis()
            r0.f(r1)
            java.lang.String r0 = "appVersion"
            if (r7 == 0) goto L54
            java.lang.Object r1 = r7.get(r0)
            java.lang.String r2 = "unknown"
            java.lang.String r1 = tb.t52.b(r1, r2)
            tb.lu0.h = r1
            java.lang.String r1 = "deviceId"
            java.lang.Object r7 = r7.get(r1)
            boolean r1 = r7 instanceof java.lang.String
            if (r1 == 0) goto L54
            java.lang.String r7 = (java.lang.String) r7
            java.lang.String r1 = "UTF-8"
            java.lang.String r7 = java.net.URLEncoder.encode(r7, r1)     // Catch: java.lang.Exception -> L3d
        L3d:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "ALI_APM/"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = "/monitor/procedure"
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            goto L56
        L54:
            java.lang.String r7 = "ALI_APM/device-id/monitor/procedure"
        L56:
            com.taobao.monitor.impl.common.ThreadSwitcher r1 = com.taobao.monitor.impl.common.ThreadSwitcher.a()
            tb.uu1 r2 = tb.uu1.d()
            android.os.HandlerThread r2 = r2.c()
            r1.f(r2)
            tb.fu0 r1 = tb.fu0.e()
            tb.fu0 r6 = r1.f(r6)
            r6.h(r7)
            com.taobao.monitor.network.UploadStorage r6 = com.taobao.monitor.network.UploadStorage.a()
            r6.d(r7)
            tb.fu0 r6 = tb.fu0.e()
            android.content.Context r6 = r6.a()
            java.lang.String r7 = "apm"
            r1 = 0
            android.content.SharedPreferences r6 = r6.getSharedPreferences(r7, r1)
            java.lang.String r7 = ""
            java.lang.String r2 = r6.getString(r0, r7)
            android.content.SharedPreferences$Editor r3 = r6.edit()
            boolean r4 = android.text.TextUtils.isEmpty(r2)
            r5 = 1
            if (r4 == 0) goto La6
            tb.lu0.b = r5
            tb.lu0.d = r5
            java.lang.String r1 = "NEW"
            tb.lu0.g = r1
            java.lang.String r1 = tb.lu0.h
            r3.putString(r0, r1)
        La4:
            r1 = 1
            goto Lbf
        La6:
            tb.lu0.b = r1
            java.lang.String r4 = tb.lu0.h
            boolean r2 = r2.equals(r4)
            r2 = r2 ^ r5
            tb.lu0.d = r2
            java.lang.String r2 = "UPDATE"
            tb.lu0.g = r2
            boolean r2 = tb.lu0.d
            if (r2 == 0) goto Lbf
            java.lang.String r1 = tb.lu0.h
            r3.putString(r0, r1)
            goto La4
        Lbf:
            java.lang.String r0 = "LAST_TOP_ACTIVITY"
            java.lang.String r6 = r6.getString(r0, r7)
            tb.lu0.e = r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto Ld1
            r3.putString(r0, r7)
            goto Ld2
        Ld1:
            r5 = r1
        Ld2:
            if (r5 == 0) goto Ld7
            r3.apply()
        Ld7:
            long r6 = tb.v6.a.a()
            tb.lu0.k = r6
            tb.v6 r6 = com.taobao.monitor.APMLauncher.c
            boolean r7 = tb.lu0.d
            r6.a(r7)
            boolean r7 = tb.lu0.b
            r6.b(r7)
            long r0 = tb.lu0.k
            r6.c(r0)
            tb.y70 r6 = new tb.y70
            r6.<init>()
            java.lang.String r7 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()
            r6.a(r7)
            tb.wp1 r6 = tb.wp1.a()
            tb.vp1 r7 = new tb.vp1
            r7.<init>()
            r6.b(r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.taobao.monitor.APMLauncher.n(android.app.Application, java.util.Map):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void o() {
        if (Build.VERSION.SDK_INT >= 24) {
            lu0.i = (ho2.a() + Process.getStartUptimeMillis()) - SystemClock.uptimeMillis();
            c.h(System.currentTimeMillis() - (SystemClock.uptimeMillis() - lu0.i));
        } else {
            long a2 = bv1.a();
            c.h(a2);
            if (a2 != -1) {
                lu0.i = ho2.a() - (System.currentTimeMillis() - a2);
            } else {
                lu0.i = ho2.a() - Process.getElapsedCpuTime();
            }
        }
        c.g(lu0.i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void p() {
        if (jd0.f) {
            a0.a().b(new l13());
        }
    }

    private static void q(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
