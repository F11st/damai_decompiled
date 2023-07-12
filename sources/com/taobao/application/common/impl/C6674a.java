package com.taobao.application.common.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.taobao.application.common.Apm;
import com.taobao.application.common.IApmEventListener;
import com.taobao.application.common.IAppLaunchListener;
import com.taobao.application.common.IAppPreferences;
import com.taobao.application.common.IApplicationMonitor;
import com.taobao.application.common.IPageListener;
import com.uc.webview.export.extension.UCCore;
import java.util.concurrent.ConcurrentHashMap;
import tb.a7;
import tb.pb1;
import tb.vm2;

/* compiled from: Taobao */
/* renamed from: com.taobao.application.common.impl.a */
/* loaded from: classes11.dex */
public class C6674a implements Apm, IApplicationMonitor {
    private final ICallbackGroup<Application.ActivityLifecycleCallbacks> a;
    private final ICallbackGroup<Application.ActivityLifecycleCallbacks> b;
    private final IListenerGroup<IPageListener> c;
    private final IListenerGroup<IAppLaunchListener> d;
    private final IListenerGroup<IApmEventListener> e;
    private final Handler f;
    private volatile Activity g;
    private ConcurrentHashMap<Application.ActivityLifecycleCallbacks, Boolean> h;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.taobao.application.common.impl.a$b */
    /* loaded from: classes12.dex */
    public static class C6676b {
        static final C6674a a = new C6674a();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private <T> T a(Object obj) {
        return obj;
    }

    public static C6674a g() {
        return C6676b.a;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    @TargetApi(14)
    public void addActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, boolean z) {
        if (activityLifecycleCallbacks != null) {
            if (this.h.put(activityLifecycleCallbacks, Boolean.valueOf(z)) != null) {
                throw new IllegalArgumentException();
            }
            if (z) {
                this.a.addCallback(activityLifecycleCallbacks);
                return;
            } else {
                this.b.addCallback(activityLifecycleCallbacks);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addApmEventListener(IApmEventListener iApmEventListener) {
        this.e.addListener(iApmEventListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addAppLaunchListener(IAppLaunchListener iAppLaunchListener) {
        this.d.addListener(iAppLaunchListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void addPageListener(IPageListener iPageListener) {
        this.c.addListener(iPageListener);
    }

    public IApmEventListener b() {
        return (IApmEventListener) a(this.e);
    }

    @TargetApi(14)
    public Application.ActivityLifecycleCallbacks c() {
        return (Application.ActivityLifecycleCallbacks) a(this.b);
    }

    public IAppLaunchListener d() {
        return (IAppLaunchListener) a(this.d);
    }

    public IPageListener e() {
        return (IPageListener) a(this.c);
    }

    @TargetApi(14)
    public Application.ActivityLifecycleCallbacks f() {
        return (Application.ActivityLifecycleCallbacks) a(this.a);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public IAppPreferences getAppPreferences() {
        return a7.b();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Handler getAsyncHandler() {
        return this.f;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Looper getAsyncLooper() {
        return this.f.getLooper();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public Activity getTopActivity() {
        return this.g;
    }

    public void h(Runnable runnable) {
        this.f.post(runnable);
    }

    public void i(Activity activity) {
        this.g = activity;
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            Boolean bool = this.h.get(activityLifecycleCallbacks);
            if (bool != null) {
                boolean booleanValue = bool.booleanValue();
                this.h.remove(activityLifecycleCallbacks);
                if (booleanValue) {
                    this.a.removeCallback(activityLifecycleCallbacks);
                    return;
                } else {
                    this.b.removeCallback(activityLifecycleCallbacks);
                    return;
                }
            }
            throw new IllegalArgumentException();
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeApmEventListener(IApmEventListener iApmEventListener) {
        this.e.removeListener(iApmEventListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removeAppLaunchListener(IAppLaunchListener iAppLaunchListener) {
        this.d.removeListener(iAppLaunchListener);
    }

    @Override // com.taobao.application.common.IApplicationMonitor
    public void removePageListener(IPageListener iPageListener) {
        this.c.removeListener(iPageListener);
    }

    private C6674a() {
        this.a = new C6677b();
        this.b = new ApplicationCallbackGroup();
        this.c = new PageListenerGroup();
        this.d = new AppLaunchListenerGroup();
        this.e = new ApmEventListenerGroup();
        this.h = new ConcurrentHashMap<>();
        HandlerThread a = vm2.a("Apm-Sec");
        a.start();
        this.f = new Handler(a.getLooper());
        pb1.b("ApmImpl", UCCore.LEGACY_EVENT_INIT);
    }
}
