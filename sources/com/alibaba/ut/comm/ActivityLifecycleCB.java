package com.alibaba.ut.comm;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import tb.mb1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ActivityLifecycleCB {
    public static ActivityLifecycleCB d = new ActivityLifecycleCB();
    public ArrayList<ActivityResumedCallBack> a = new ArrayList<>();
    public ArrayList<ActivityPausedCallBack> b = new ArrayList<>();
    public ArrayList<ActivityDestroyCallBack> c = new ArrayList<>();

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ActivityDestroyCallBack {
        void onActivityDestroyed(Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ActivityPausedCallBack {
        void onActivityPaused(Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface ActivityResumedCallBack {
        void onActivityResumed(Activity activity);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    class a implements Application.ActivityLifecycleCallbacks {
        a() {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Iterator<ActivityDestroyCallBack> it = ActivityLifecycleCB.this.c.iterator();
            while (it.hasNext()) {
                it.next().onActivityDestroyed(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            mb1.e(null, "activity", activity);
            Iterator<ActivityPausedCallBack> it = ActivityLifecycleCB.this.b.iterator();
            while (it.hasNext()) {
                it.next().onActivityPaused(activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            mb1.e(null, "activity", activity);
            Iterator<ActivityResumedCallBack> it = ActivityLifecycleCB.this.a.iterator();
            while (it.hasNext()) {
                it.next().onActivityResumed(activity);
            }
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

    public static ActivityLifecycleCB d() {
        return d;
    }

    public void a(ActivityDestroyCallBack activityDestroyCallBack) {
        if (this.c.contains(activityDestroyCallBack)) {
            return;
        }
        this.c.add(activityDestroyCallBack);
    }

    public void b(ActivityPausedCallBack activityPausedCallBack) {
        if (this.b.contains(activityPausedCallBack)) {
            return;
        }
        this.b.add(activityPausedCallBack);
    }

    public void c(ActivityResumedCallBack activityResumedCallBack) {
        if (this.a.contains(activityResumedCallBack)) {
            return;
        }
        this.a.add(activityResumedCallBack);
    }

    public void e(Application application) {
        application.registerActivityLifecycleCallbacks(new a());
    }
}
