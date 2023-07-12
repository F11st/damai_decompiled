package com.ut.mini.module.appstatus;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTAnalytics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTAppBackgroundTimeoutDetector implements UTAppStatusCallbacks {
    private static final long TIMEOUT = 600000;
    private static UTAppBackgroundTimeoutDetector mInstance;
    private long mSwitchBackgroundTimestamp = 0;

    private UTAppBackgroundTimeoutDetector() {
    }

    public static UTAppBackgroundTimeoutDetector getInstance() {
        if (mInstance == null) {
            synchronized (UTAppBackgroundTimeoutDetector.class) {
                if (mInstance == null) {
                    mInstance = new UTAppBackgroundTimeoutDetector();
                }
            }
        }
        return mInstance;
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityStarted(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityStopped(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchBackground() {
        this.mSwitchBackgroundTimestamp = SystemClock.elapsedRealtime();
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchForeground() {
        if (0 != this.mSwitchBackgroundTimestamp && SystemClock.elapsedRealtime() - this.mSwitchBackgroundTimestamp > TIMEOUT) {
            Logger.f("", "sessionTimeout");
            UTAnalytics.getInstance().sessionTimeout();
        }
        this.mSwitchBackgroundTimestamp = 0L;
    }
}
