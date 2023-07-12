package com.taobao.application.common;

import com.taobao.application.common.Apm;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class b {
    private static IApplicationMonitor a;
    private static final Map<Apm.OnActivityLifecycleCallbacks, Boolean> b = new ConcurrentHashMap();
    private static final List<Apm.OnActivityLifecycleCallbacks> c = new CopyOnWriteArrayList();
    private static final List<Apm.OnPageListener> d = new CopyOnWriteArrayList();
    private static final List<Apm.OnPageListener> e = new CopyOnWriteArrayList();
    private static final List<Apm.OnAppLaunchListener> f = new CopyOnWriteArrayList();
    private static final List<Apm.OnAppLaunchListener> g = new CopyOnWriteArrayList();
    private static final List<IApmEventListener> h = new CopyOnWriteArrayList();
    private static final List<IApmEventListener> i = new CopyOnWriteArrayList();

    public static void a(IApmEventListener iApmEventListener) {
        IApplicationMonitor iApplicationMonitor = a;
        if (iApplicationMonitor != null) {
            iApplicationMonitor.addApmEventListener(iApmEventListener);
            return;
        }
        h.add(iApmEventListener);
        i.remove(iApmEventListener);
    }

    public static void b(Apm.OnAppLaunchListener onAppLaunchListener) {
        IApplicationMonitor iApplicationMonitor = a;
        if (iApplicationMonitor != null) {
            iApplicationMonitor.addAppLaunchListener(onAppLaunchListener);
            return;
        }
        f.add(onAppLaunchListener);
        g.remove(onAppLaunchListener);
    }

    public static void c(Apm.OnPageListener onPageListener) {
        IApplicationMonitor iApplicationMonitor = a;
        if (iApplicationMonitor != null) {
            iApplicationMonitor.addPageListener(onPageListener);
            return;
        }
        d.add(onPageListener);
        e.remove(onPageListener);
    }

    public static IAppPreferences d() {
        IApplicationMonitor iApplicationMonitor = a;
        if (iApplicationMonitor != null) {
            return iApplicationMonitor.getAppPreferences();
        }
        return IAppPreferences.DEFAULT;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void e(IApplicationMonitor iApplicationMonitor) {
        a = iApplicationMonitor;
        for (Map.Entry<Apm.OnActivityLifecycleCallbacks, Boolean> entry : b.entrySet()) {
            iApplicationMonitor.addActivityLifecycle(entry.getKey(), entry.getValue().booleanValue());
        }
        b.clear();
        for (Apm.OnActivityLifecycleCallbacks onActivityLifecycleCallbacks : c) {
            iApplicationMonitor.removeActivityLifecycle(onActivityLifecycleCallbacks);
        }
        c.clear();
        for (Apm.OnPageListener onPageListener : d) {
            iApplicationMonitor.addPageListener(onPageListener);
        }
        d.clear();
        for (Apm.OnPageListener onPageListener2 : e) {
            iApplicationMonitor.removePageListener(onPageListener2);
        }
        e.clear();
        for (Apm.OnAppLaunchListener onAppLaunchListener : f) {
            iApplicationMonitor.addAppLaunchListener(onAppLaunchListener);
        }
        f.clear();
        for (Apm.OnAppLaunchListener onAppLaunchListener2 : g) {
            iApplicationMonitor.removeAppLaunchListener(onAppLaunchListener2);
        }
        g.clear();
        for (IApmEventListener iApmEventListener : h) {
            iApplicationMonitor.addApmEventListener(iApmEventListener);
        }
        h.clear();
        for (IApmEventListener iApmEventListener2 : i) {
            iApplicationMonitor.removeApmEventListener(iApmEventListener2);
        }
        i.clear();
    }
}
