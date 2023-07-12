package com.alibaba.poplayer.layermanager.view.app;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.view.Window;
import com.alibaba.poplayer.PopLayer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import tb.dt1;
import tb.fw2;

/* compiled from: Taobao */
/* renamed from: com.alibaba.poplayer.layermanager.view.app.b */
/* loaded from: classes8.dex */
public class C3674b implements Application.ActivityLifecycleCallbacks {
    C3673a a;
    private boolean c = false;
    private ArrayList<C3675a> b = new ArrayList<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.alibaba.poplayer.layermanager.view.app.b$a */
    /* loaded from: classes8.dex */
    public static class C3675a {
        WeakReference<Activity> a;
        Window$CallbackC3676c b;

        public C3675a(WeakReference<Activity> weakReference, Window$CallbackC3676c window$CallbackC3676c) {
            this.a = weakReference;
            this.b = window$CallbackC3676c;
        }

        public void a() {
            Activity activity = (Activity) fw2.c(this.a);
            if (activity != null) {
                Window.Callback callback = activity.getWindow().getCallback();
                if (callback instanceof Window$CallbackC3676c) {
                    return;
                }
                this.b.a = callback;
                activity.getWindow().setCallback(this.b);
            }
        }

        public void b() {
            Activity activity = (Activity) fw2.c(this.a);
            if (activity != null) {
                activity.getWindow().setCallback(this.b.a);
            }
        }
    }

    public C3674b(C3673a c3673a) {
        this.a = c3673a;
    }

    private C3675a a(Activity activity) {
        Iterator<C3675a> it = this.b.iterator();
        while (it.hasNext()) {
            C3675a next = it.next();
            if (activity == fw2.c(next.a)) {
                return next;
            }
        }
        return null;
    }

    private void c(Activity activity) {
        C3675a a = a(activity);
        if (a != null) {
            a.b();
            this.b.remove(a);
        }
    }

    public void b(Activity activity) {
        C3675a a = a(activity);
        if (a == null) {
            a = new C3675a(new WeakReference(activity), new Window$CallbackC3676c(this.a, activity.getWindow().getCallback()));
            this.b.add(a);
        }
        a.a();
        if (this.c) {
            return;
        }
        dt1.b("App registerActivityLifecycleCallback.", new Object[0]);
        PopLayer.getReference().getApp().registerActivityLifecycleCallbacks(this);
        this.c = true;
    }

    public void d() {
        Iterator<C3675a> it = this.b.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
        this.b.clear();
        if (this.c) {
            dt1.b("App unregisterActivityLifecycleCallback.", new Object[0]);
            PopLayer.getReference().getApp().unregisterActivityLifecycleCallbacks(this);
            this.c = false;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity.isChild() && (activity.getParent() instanceof Activity)) {
            return;
        }
        if (!this.c) {
            dt1.b("App Service,bad onPause event " + activity.getClass().getSimpleName(), new Object[0]);
            return;
        }
        this.a.i(activity.getApplicationContext());
        dt1.b("App Service.onPause : " + activity.getClass().getSimpleName(), new Object[0]);
        c(activity);
        this.a.d(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity.isChild() && (activity.getParent() instanceof Activity)) {
            return;
        }
        if (!this.c) {
            dt1.b("App Service,bad onResume event " + activity.getClass().getSimpleName(), new Object[0]);
            return;
        }
        this.a.i(activity);
        dt1.b("App Service,onResume : " + activity.getClass().getSimpleName(), new Object[0]);
        this.a.e(activity);
        b(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
    }
}
