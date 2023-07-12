package com.alibaba.wireless.security.aopsdk;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/* compiled from: ActivityListener.java */
/* loaded from: classes.dex */
public class a implements Application.ActivityLifecycleCallbacks {
    private static final String c = "ActivityListener";
    public static String d;
    private int a;
    private boolean b;

    public boolean a(Context context, Activity activity) {
        try {
            return d.a(context, activity);
        } catch (Throwable th) {
            return this.a > 0;
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
        if (activity == null) {
            return;
        }
        com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityCreated " + activity.getClass().getName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity == null) {
            return;
        }
        com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityResumed " + activity.getClass().getName());
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityPaused(Activity activity) {
        if (activity != null) {
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityPaused " + activity.getClass().getName());
            int i = this.a - 1;
            this.a = i;
            this.b = false;
            if (i <= 0) {
                this.a = 0;
            }
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStarted(Activity activity) {
        if (activity != null) {
            this.a++;
            Intent intent = activity.getIntent();
            String dataString = intent != null ? intent.getDataString() : null;
            if (dataString == null) {
                dataString = "null";
            }
            com.alibaba.wireless.security.aopsdk.h.a.b(dataString);
            com.alibaba.wireless.security.aopsdk.h.a.a(activity.getClass().getName());
            if (!this.b) {
                this.b = true;
                com.alibaba.wireless.security.aopsdk.h.a.a(true);
            }
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityStarted " + activity.getClass().getName() + "; StartCount=" + this.a + "; foreground=" + this.b);
        }
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public void onActivityStopped(Activity activity) {
        if (activity != null) {
            if (d.d() && a(activity, activity)) {
                this.b = true;
                com.alibaba.wireless.security.aopsdk.i.a.b(c, "Reflect foreground detected");
            } else {
                com.alibaba.wireless.security.aopsdk.h.a.a(false);
                com.alibaba.wireless.security.aopsdk.h.a.a((String) null);
                com.alibaba.wireless.security.aopsdk.h.a.b((String) null);
                this.b = false;
            }
            com.alibaba.wireless.security.aopsdk.i.a.b(c, "onActivityStopped " + activity.getClass().getName() + "; StartCount=" + this.a + "; foreground=" + this.b);
        }
    }
}
