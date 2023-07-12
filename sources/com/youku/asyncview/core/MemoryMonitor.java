package com.youku.asyncview.core;

import android.app.Activity;
import android.app.Application;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class MemoryMonitor {
    private Context mContext;
    private MemoryStateListener mMemStateListener;
    private final long mDalvikMax = (long) ((Runtime.getRuntime().maxMemory() >> 20) * 0.8d);
    private ComponentCallbacks mComponentCallbacks = new ComponentCallbacks() { // from class: com.youku.asyncview.core.MemoryMonitor.1
        @Override // android.content.ComponentCallbacks
        public void onConfigurationChanged(Configuration configuration) {
        }

        @Override // android.content.ComponentCallbacks
        public void onLowMemory() {
            if (MemoryMonitor.this.mMemStateListener != null) {
                MemoryMonitor.this.mMemStateListener.onLowMemory();
            }
        }
    };
    private Application.ActivityLifecycleCallbacks mActivityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.youku.asyncview.core.MemoryMonitor.2
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            if (MemoryMonitor.this.mMemStateListener == null || !MemoryMonitor.this.isLowMem()) {
                return;
            }
            MemoryMonitor.this.mMemStateListener.onLowMemory();
        }
    };

    public MemoryMonitor(Context context) {
        this.mContext = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLowMem() {
        return ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) >> 20) > this.mDalvikMax;
    }

    public void setMemoryStateListener(MemoryStateListener memoryStateListener) {
        this.mMemStateListener = memoryStateListener;
    }

    public void start() {
        this.mContext.getApplicationContext().registerComponentCallbacks(this.mComponentCallbacks);
        ((Application) this.mContext.getApplicationContext()).registerActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    }

    public void stop() {
        this.mContext.getApplicationContext().unregisterComponentCallbacks(this.mComponentCallbacks);
        ((Application) this.mContext.getApplicationContext()).unregisterActivityLifecycleCallbacks(this.mActivityLifecycleCallbacks);
    }
}
