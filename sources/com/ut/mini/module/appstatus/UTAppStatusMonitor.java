package com.ut.mini.module.appstatus;

import android.app.Activity;
import android.os.Bundle;
import com.alibaba.analytics.utils.Logger;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ScheduledFuture;
import tb.hl2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTAppStatusMonitor {
    private static UTAppStatusMonitor mInstance = new UTAppStatusMonitor();
    private int mActivitiesActive = 0;
    private boolean mIsInForeground = false;
    private ScheduledFuture<?> mApplicationStatusScheduledFuture = null;
    private List<UTAppStatusCallbacks> mAppStatusCallbacksList = new LinkedList();
    private final Object mAppStatusCallbacksLockObj = new Object();

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    private class NotInForegroundRunnable implements Runnable {
        @Override // java.lang.Runnable
        public void run() {
            synchronized (UTAppStatusMonitor.this.mAppStatusCallbacksLockObj) {
                for (int i = 0; i < UTAppStatusMonitor.this.mAppStatusCallbacksList.size(); i++) {
                    UTAppStatusCallbacks uTAppStatusCallbacks = (UTAppStatusCallbacks) UTAppStatusMonitor.this.mAppStatusCallbacksList.get(i);
                    if (uTAppStatusCallbacks instanceof UTAppStatusDelayCallbacks) {
                        ((UTAppStatusDelayCallbacks) uTAppStatusCallbacks).onSwitchBackgroundDelay();
                    }
                }
            }
        }

        private NotInForegroundRunnable() {
        }
    }

    private UTAppStatusMonitor() {
    }

    private synchronized void clearApplicationStatusCheckExistingTimer() {
        ScheduledFuture<?> scheduledFuture = this.mApplicationStatusScheduledFuture;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(true);
        }
    }

    public static UTAppStatusMonitor getInstance() {
        return mInstance;
    }

    public boolean isInForeground() {
        return this.mIsInForeground;
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onActivityCreated(activity, bundle);
            }
        }
    }

    public void onActivityDestroyed(Activity activity) {
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onActivityDestroyed(activity);
            }
        }
    }

    public void onActivityPaused(Activity activity) {
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onActivityPaused(activity);
            }
        }
    }

    public void onActivityResumed(Activity activity) {
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onActivityResumed(activity);
            }
        }
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onActivitySaveInstanceState(activity, bundle);
            }
        }
    }

    public void onActivityStarted(Activity activity) {
        clearApplicationStatusCheckExistingTimer();
        this.mActivitiesActive++;
        if (this.mIsInForeground) {
            return;
        }
        Logger.f("UTAppStatusMonitor", "onSwitchForeground");
        synchronized (this.mAppStatusCallbacksLockObj) {
            for (int i = 0; i < this.mAppStatusCallbacksList.size(); i++) {
                this.mAppStatusCallbacksList.get(i).onSwitchForeground();
            }
            this.mIsInForeground = true;
        }
    }

    public void onActivityStopped(Activity activity) {
        int i = this.mActivitiesActive - 1;
        this.mActivitiesActive = i;
        if (i == 0) {
            Logger.f("UTAppStatusMonitor", "onSwitchBackground");
            synchronized (this.mAppStatusCallbacksLockObj) {
                for (int i2 = 0; i2 < this.mAppStatusCallbacksList.size(); i2++) {
                    this.mAppStatusCallbacksList.get(i2).onSwitchBackground();
                }
                this.mIsInForeground = false;
            }
            clearApplicationStatusCheckExistingTimer();
            this.mApplicationStatusScheduledFuture = hl2.c().d(null, new NotInForegroundRunnable(), 500L);
        }
    }

    public void registerAppStatusCallbacks(UTAppStatusCallbacks uTAppStatusCallbacks) {
        if (uTAppStatusCallbacks != null) {
            synchronized (this.mAppStatusCallbacksLockObj) {
                this.mAppStatusCallbacksList.add(uTAppStatusCallbacks);
            }
        }
    }

    public void unregisterAppStatusCallbacks(UTAppStatusCallbacks uTAppStatusCallbacks) {
        if (uTAppStatusCallbacks != null) {
            synchronized (this.mAppStatusCallbacksLockObj) {
                this.mAppStatusCallbacksList.remove(uTAppStatusCallbacks);
            }
        }
    }
}
