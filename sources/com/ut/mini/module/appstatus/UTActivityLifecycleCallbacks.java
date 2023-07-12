package com.ut.mini.module.appstatus;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTActivityLifecycleCallbacks implements Application.ActivityLifecycleCallbacks {
    private static UTActivityLifecycleCallbacks mInstance;

    private UTActivityLifecycleCallbacks() {
    }

    public static UTActivityLifecycleCallbacks getInstance() {
        if (mInstance == null) {
            synchronized (UTActivityLifecycleCallbacks.class) {
                if (mInstance == null) {
                    mInstance = new UTActivityLifecycleCallbacks();
                }
            }
        }
        return mInstance;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        UTAppStatusMonitor.getInstance().onActivityCreated(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityDestroyed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityPaused(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityResumed(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        UTAppStatusMonitor.getInstance().onActivitySaveInstanceState(activity, bundle);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityStarted(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        UTAppStatusMonitor.getInstance().onActivityStopped(activity);
    }
}
