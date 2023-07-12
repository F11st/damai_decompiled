package com.taobao.monitor.impl.data.lifecycle;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;
import com.taobao.android.tlog.protocol.Constants;
import com.taobao.application.common.impl.C6674a;
import com.taobao.monitor.impl.common.Constants;
import com.taobao.monitor.impl.data.fps.FPSCollector;
import com.taobao.monitor.impl.data.windowevent.C6767a;
import com.taobao.monitor.impl.processor.launcher.LauncherProcessor;
import com.taobao.monitor.impl.trace.ActivityLifeCycleDispatcher;
import com.taobao.monitor.impl.trace.ApplicationBackgroundChangedDispatcher;
import com.taobao.monitor.impl.trace.IDispatcher;
import com.taobao.monitor.procedure.IPage;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.UUID;
import tb.C8934b0;
import tb.ca0;
import tb.d3;
import tb.e30;
import tb.fu0;
import tb.ho2;
import tb.jd0;
import tb.lu0;
import tb.m3;
import tb.rp1;
import tb.ud2;
import tb.uu1;
import tb.v6;
import tb.x52;
import tb.xu1;

/* compiled from: Taobao */
@TargetApi(14)
@UiThread
/* loaded from: classes11.dex */
public class ActivityLifecycle implements Application.ActivityLifecycleCallbacks, Observer {
    private static volatile boolean n;
    private static final List<String> o;
    private int a;
    private final Context g;
    private ActivityLifeCycleDispatcher h;
    private final d3 m;
    private final Map<Activity, C6767a> b = new HashMap();
    private final Map<Activity, ud2> c = new HashMap();
    private final Map<Activity, FPSCollector> d = new HashMap();
    private final Map<Activity, IPage> e = new HashMap();
    private WeakReference<Activity> f = new WeakReference<>(null);
    private final Application.ActivityLifecycleCallbacks i = C6674a.g().f();
    private final Application.ActivityLifecycleCallbacks j = C6674a.g().c();
    private final BackgroundForegroundEventImpl k = new BackgroundForegroundEventImpl();
    private int l = 0;

    static {
        ArrayList arrayList = new ArrayList();
        o = arrayList;
        arrayList.add("com.taobao.tao.welcome.Welcome");
        arrayList.add("com.taobao.browser.BrowserActivity");
        arrayList.add("com.taobao.tao.TBMainActivity");
    }

    public ActivityLifecycle(Application application) {
        this.h = null;
        d3 d3Var = new d3();
        this.m = d3Var;
        d3Var.a(this.l);
        this.g = application;
        IDispatcher a = C8934b0.a(C8934b0.ACTIVITY_LIFECYCLE_DISPATCHER);
        if (a instanceof ActivityLifeCycleDispatcher) {
            this.h = (ActivityLifeCycleDispatcher) a;
        }
    }

    private void b(final String str) {
        fu0.e().d().post(new Runnable() { // from class: com.taobao.monitor.impl.data.lifecycle.ActivityLifecycle.1
            @Override // java.lang.Runnable
            public void run() {
                SharedPreferences.Editor edit = fu0.e().a().getSharedPreferences(xu1.DEFAULT_SAVE_DIR, 0).edit();
                edit.putString(Constants.LAST_TOP_ACTIVITY, str);
                edit.commit();
            }
        });
    }

    public boolean a(String str) {
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.g.getSystemService("activity")).getRunningTasks(10);
            if (runningTasks == null || runningTasks.size() <= 0) {
                return false;
            }
            for (ActivityManager.RunningTaskInfo runningTaskInfo : runningTasks) {
                if (runningTaskInfo.topActivity.getPackageName().equals(this.g.getPackageName()) && runningTaskInfo.topActivity.getClassName().equals(str)) {
                    return true;
                }
            }
            return false;
        } catch (Exception unused) {
            return true;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        d3 d3Var = this.m;
        int i = this.l + 1;
        this.l = i;
        d3Var.a(i);
        lu0.f++;
        String replaceAll = UUID.randomUUID().toString().replaceAll("-", "");
        IPage a = new rp1().l(jd0.a).f(jd0.b || x52.b(m3.b(activity))).b(activity).j(activity.getWindow()).d(replaceAll).a();
        this.e.put(activity, a);
        a.getPageLifecycleCallback().onPageCreate(m3.d(activity), m3.c(activity), m3.a(activity));
        if (!ca0.c(this.h)) {
            this.h.f(activity, m3.a(activity), ho2.a());
        }
        if ((activity instanceof FragmentActivity) && (jd0.j || x52.b(m3.b(activity)))) {
            ((FragmentActivity) activity).getSupportFragmentManager().registerFragmentLifecycleCallbacks(new FragmentLifecycle(activity, replaceAll), true);
        }
        if (jd0.C && !this.b.containsKey(activity)) {
            this.b.put(activity, new C6767a(activity).a());
        }
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED, activity.getClass().getSimpleName());
        C6674a.g().i(activity);
        this.i.onActivityCreated(activity, bundle);
        this.j.onActivityCreated(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED, activity.getClass().getSimpleName());
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDestroy();
            this.e.remove(activity);
            uu1.PROCEDURE_MANAGER.p(iPage);
        }
        if (!ca0.c(this.h)) {
            this.h.g(activity, ho2.a());
        }
        if (this.a == 0) {
            b("");
            C6674a.g().i(null);
        }
        if (jd0.C && this.b.containsKey(activity)) {
            this.b.get(activity).b();
            this.b.remove(activity);
        }
        this.i.onActivityDestroyed(activity);
        this.j.onActivityDestroyed(activity);
        d3 d3Var = this.m;
        int i = this.l - 1;
        this.l = i;
        d3Var.a(i);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED, activity.getClass().getSimpleName());
        if (!ca0.c(this.h)) {
            this.h.h(activity, ho2.a());
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && this.c.containsKey(activity)) {
            this.c.get(activity).f();
            this.c.remove(activity);
        }
        if (jd0.B && i >= 16 && this.d.containsKey(activity)) {
            this.d.get(activity).c();
            this.c.remove(activity);
        }
        this.i.onActivityPaused(activity);
        this.j.onActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED, activity.getClass().getSimpleName());
        String name = activity.getClass().getName();
        if (o.contains(name) && n && this.f.get() == null) {
            n = false;
            if (!a(name)) {
                this.f = new WeakReference<>(activity);
                activity.finish();
                return;
            }
        }
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageAppear();
        }
        if (!ca0.c(this.h)) {
            this.h.i(activity, ho2.a());
        }
        if ((jd0.b || jd0.f) && jd0.w && !jd0.B && !this.c.containsKey(activity) && Build.VERSION.SDK_INT >= 16) {
            this.c.put(activity, new ud2(activity, iPage));
        } else if (jd0.w && jd0.B && Build.VERSION.SDK_INT >= 16 && !this.c.containsKey(activity)) {
            this.d.put(activity, new FPSCollector(activity));
        }
        C6674a.g().i(activity);
        this.i.onActivityResumed(activity);
        this.j.onActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.i.onActivitySaveInstanceState(activity, bundle);
        this.j.onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED, activity.getClass().getSimpleName());
        int i = this.a + 1;
        this.a = i;
        if (i == 1) {
            IDispatcher b = ca0.b(C8934b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
            if (b instanceof ApplicationBackgroundChangedDispatcher) {
                ((ApplicationBackgroundChangedDispatcher) b).f(0, ho2.a());
            }
            e30.a("ActivityLifeCycle", "background2Foreground");
            this.k.d();
        }
        lu0.a = false;
        if (!ca0.c(this.h)) {
            this.h.j(activity, ho2.a());
        }
        if (!jd0.C && !this.b.containsKey(activity)) {
            this.b.put(activity, new C6767a(activity).a());
        }
        C6674a.g().i(activity);
        this.i.onActivityStarted(activity);
        this.j.onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        e30.a("ActivityLifeCycle", Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED, activity.getClass().getSimpleName());
        if (!ca0.c(this.h)) {
            this.h.k(activity, ho2.a());
        }
        if (!jd0.C && this.b.containsKey(activity)) {
            this.b.get(activity).b();
            this.b.remove(activity);
        }
        int i = this.a - 1;
        this.a = i;
        if (i == 0) {
            lu0.a = true;
            uu1.PROCEDURE_MANAGER.b();
            IDispatcher b = ca0.b(C8934b0.APPLICATION_BACKGROUND_CHANGED_DISPATCHER);
            if (b instanceof ApplicationBackgroundChangedDispatcher) {
                ((ApplicationBackgroundChangedDispatcher) b).f(1, ho2.a());
            }
            e30.a("ActivityLifeCycle", "foreground2Background");
            lu0.p = "background";
            lu0.n = -1L;
            this.k.e();
            b(m3.b(activity));
            new v6().d(LauncherProcessor.S);
        }
        this.i.onActivityStopped(activity);
        this.j.onActivityStopped(activity);
        IPage iPage = this.e.get(activity);
        if (iPage != null) {
            iPage.getPageLifecycleCallback().onPageDisappear();
        }
    }

    @Override // java.util.Observer
    public void update(Observable observable, Object obj) {
        if (obj != null && (obj instanceof IllegalArgumentException) && ((IllegalArgumentException) obj).getMessage().contains("ActivityRecord not found")) {
            n = true;
        }
    }
}
