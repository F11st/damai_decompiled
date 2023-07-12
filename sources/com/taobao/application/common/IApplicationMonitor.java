package com.taobao.application.common;

import android.app.Activity;
import android.app.Application;
import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface IApplicationMonitor {
    void addActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks, boolean z);

    void addApmEventListener(IApmEventListener iApmEventListener);

    void addAppLaunchListener(IAppLaunchListener iAppLaunchListener);

    void addPageListener(IPageListener iPageListener);

    IAppPreferences getAppPreferences();

    Handler getAsyncHandler();

    Looper getAsyncLooper();

    Activity getTopActivity();

    void removeActivityLifecycle(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks);

    void removeApmEventListener(IApmEventListener iApmEventListener);

    void removeAppLaunchListener(IAppLaunchListener iAppLaunchListener);

    void removePageListener(IPageListener iPageListener);
}
