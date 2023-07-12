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
class ApplicationCallbackGroup implements Application.ActivityLifecycleCallbacks, ICallbackGroup<Application.ActivityLifecycleCallbacks> {
    private final ArrayList<Application.ActivityLifecycleCallbacks> a = new ArrayList<>();

    private void c(Runnable runnable) {
        a.g().h(runnable);
    }

    @Override // com.taobao.application.common.impl.ICallbackGroup
    /* renamed from: b */
    public void addCallback(final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.8
                @Override // java.lang.Runnable
                public void run() {
                    if (ApplicationCallbackGroup.this.a.contains(activityLifecycleCallbacks)) {
                        return;
                    }
                    ApplicationCallbackGroup.this.a.add(activityLifecycleCallbacks);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // com.taobao.application.common.impl.ICallbackGroup
    /* renamed from: d */
    public void removeCallback(final Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        if (activityLifecycleCallbacks != null) {
            c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.9
                @Override // java.lang.Runnable
                public void run() {
                    ApplicationCallbackGroup.this.a.remove(activityLifecycleCallbacks);
                }
            });
            return;
        }
        throw new IllegalArgumentException();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(final Activity activity, final Bundle bundle) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.1
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityCreated(activity, bundle);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(final Activity activity) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.7
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityDestroyed(activity);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(final Activity activity) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.4
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityPaused(activity);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(final Activity activity) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.3
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityResumed(activity);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(final Activity activity, final Bundle bundle) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.6
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivitySaveInstanceState(activity, bundle);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(final Activity activity) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.2
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStarted(activity);
                }
            }
        });
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(final Activity activity) {
        c(new Runnable() { // from class: com.taobao.application.common.impl.ApplicationCallbackGroup.5
            @Override // java.lang.Runnable
            public void run() {
                Iterator it = ApplicationCallbackGroup.this.a.iterator();
                while (it.hasNext()) {
                    ((Application.ActivityLifecycleCallbacks) it.next()).onActivityStopped(activity);
                }
            }
        });
    }
}
