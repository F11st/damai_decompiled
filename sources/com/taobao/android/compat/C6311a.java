package com.taobao.android.compat;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import android.os.Debug;
import android.util.Log;
import com.taobao.android.compat.ApplicationCompat;
import com.taobao.android.tlog.protocol.Constants;
import javax.annotation.Nullable;
import tb.s40;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
@TargetApi(14)
/* renamed from: com.taobao.android.compat.a */
/* loaded from: classes5.dex */
public class C6311a implements Application.ActivityLifecycleCallbacks {
    private final ApplicationCompat.ActivityLifecycleCallbacksCompat a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public C6311a(ApplicationCompat.ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat) {
        this.a = activityLifecycleCallbacksCompat;
    }

    private static void a(ApplicationCompat.ActivityLifecycleCallbacksCompat activityLifecycleCallbacksCompat, Activity activity, Bundle bundle, String str) {
        long nanoTime = System.nanoTime();
        long threadCpuTimeNanos = Debug.threadCpuTimeNanos();
        if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityCreated(activity, bundle);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityStarted(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityResumed(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityPaused(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityStopped(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED.equals(str)) {
            activityLifecycleCallbacksCompat.onActivityDestroyed(activity);
        } else if (Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE.equals(str)) {
            activityLifecycleCallbacksCompat.onActivitySaveInstanceState(activity, bundle);
        }
        Log.i("Coord", "LifeTiming - " + activityLifecycleCallbacksCompat.getClass().getName() + " " + str + " " + ((Debug.threadCpuTimeNanos() - threadCpuTimeNanos) / 1000000) + "ms (cpu) / " + ((System.nanoTime() - nanoTime) / 1000000) + "ms (real)");
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof C6311a) {
            return this.a.equals(((C6311a) obj).a);
        }
        return false;
    }

    public int hashCode() {
        return this.a.hashCode();
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, @Nullable Bundle bundle) {
        if (s40.b()) {
            a(this.a, activity, bundle, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_CREATED);
        } else {
            this.a.onActivityCreated(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
        if (s40.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_DESTROYED);
        } else {
            this.a.onActivityDestroyed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (s40.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_PAUSED);
        } else {
            this.a.onActivityPaused(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (s40.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_RESUMED);
        } else {
            this.a.onActivityResumed(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        if (s40.b()) {
            a(this.a, activity, bundle, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_SAVEINSTANCESTATE);
        } else {
            this.a.onActivitySaveInstanceState(activity, bundle);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (s40.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STARTED);
        } else {
            this.a.onActivityStarted(activity);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (s40.b()) {
            a(this.a, activity, null, Constants.AndroidJointPointKey.LIFECYCLE_KEY_ACTIVITY_STOPPED);
        } else {
            this.a.onActivityStopped(activity);
        }
    }
}
