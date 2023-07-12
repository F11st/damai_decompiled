package anet.channel.util;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import anet.channel.thread.ThreadPoolExecutorFactory;
import com.taobao.android.tlog.protocol.model.joint.point.ForegroundJointPoint;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import tb.hu0;
import tb.t9;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class AppLifecycle {
    private static CopyOnWriteArraySet<AppLifecycleListener> a = new CopyOnWriteArraySet<>();
    public static volatile long b = 0;
    public static volatile boolean c = false;
    private static Application.ActivityLifecycleCallbacks d = new a();
    private static ComponentCallbacks2 e = new b();

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public interface AppLifecycleListener {
        void background();

        void forground();
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
            if (hu0.i()) {
                AppLifecycle.c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            AppLifecycle.e();
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            if (hu0.i()) {
                AppLifecycle.c = true;
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class b implements ComponentCallbacks2 {
        b() {
        }

        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
        }

        @Override // android.content.ComponentCallbacks2
        public void onTrimMemory(int i) {
            ALog.f("awcn.AppLifeCycle", "onTrimMemory", null, "level", Integer.valueOf(i));
            if (i == 20) {
                AppLifecycle.d();
            }
        }
    }

    public static void b() {
        if (Build.VERSION.SDK_INT < 14 || !t9.m()) {
            return;
        }
        ((Application) hu0.c().getApplicationContext()).registerActivityLifecycleCallbacks(d);
        hu0.c().registerComponentCallbacks(e);
    }

    private static void c(final boolean z) {
        ALog.f("awcn.AppLifeCycle", "notifyListener", null, ForegroundJointPoint.TYPE, Boolean.valueOf(z));
        ThreadPoolExecutorFactory.i(new Runnable() { // from class: anet.channel.util.AppLifecycle.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = AppLifecycle.a.iterator();
                while (it.hasNext()) {
                    AppLifecycleListener appLifecycleListener = (AppLifecycleListener) it.next();
                    try {
                        if (z) {
                            appLifecycleListener.forground();
                        } else {
                            appLifecycleListener.background();
                        }
                    } catch (Exception e2) {
                        ALog.d("awcn.AppLifeCycle", "notifyListener exception.", null, e2, new Object[0]);
                    }
                }
            }
        });
    }

    public static void d() {
        if (hu0.i()) {
            return;
        }
        hu0.k(true);
        b = System.currentTimeMillis();
        c(false);
    }

    public static void e() {
        if (hu0.i()) {
            hu0.k(false);
            c = false;
            c(true);
        }
    }

    public static void f(AppLifecycleListener appLifecycleListener) {
        if (appLifecycleListener != null) {
            a.add(appLifecycleListener);
        }
    }

    public static void g(AppLifecycleListener appLifecycleListener) {
        a.remove(appLifecycleListener);
    }
}
