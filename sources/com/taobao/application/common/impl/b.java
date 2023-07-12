package com.taobao.application.common.impl;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;

/* compiled from: Taobao */
@TargetApi(14)
/* loaded from: classes11.dex */
class b implements Application.ActivityLifecycleCallbacks, ICallbackGroup<Application.ActivityLifecycleCallbacks> {
    private final ArrayList<Application.ActivityLifecycleCallbacks> a = new ArrayList<>();

    @Override // com.taobao.application.common.impl.ICallbackGroup
    /* renamed from: a */
    public void addCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            synchronized (this.a) {
                if (!this.a.contains(activityLifecycleCallbacks)) {
                    this.a.add(activityLifecycleCallbacks);
                }
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.impl.ICallbackGroup
    /* renamed from: b */
    public void removeCallback(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            synchronized (this.a) {
                this.a.remove(activityLifecycleCallbacks);
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityCreated(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStarted(activity);
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        synchronized (this.a) {
            Iterator<Application.ActivityLifecycleCallbacks> it = this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityStopped(activity);
            }
        }
    }
}
