package com.ut.mini;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import com.alibaba.analytics.AnalyticsMgr;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.motu.tbrest.rest.RestConstants;
import com.ut.mini.module.appstatus.UTAppStatusDelayCallbacks;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.sj;

/* JADX INFO: Access modifiers changed from: package-private */
/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTMI1010_2001Event implements UTAppStatusDelayCallbacks {
    private static UTMI1010_2001Event mInstance;
    private long mToForegroundTimestamp = 0;
    private long mToBackgroundTimestamp = 0;

    private UTMI1010_2001Event() {
    }

    private void _send1010Hit(long j) {
        if (sj.c().g()) {
            return;
        }
        if (j > 0) {
            UTAppLaunchHitBuilder uTAppLaunchHitBuilder = new UTAppLaunchHitBuilder(BizTime.UT, 1010, "" + j, "" + (0 != this.mToBackgroundTimestamp ? SystemClock.elapsedRealtime() - this.mToBackgroundTimestamp : 0L), null, null);
            uTAppLaunchHitBuilder.setProperty(RestConstants.LogContentKeys.PRIORITY, "5");
            UTTracker defaultTracker = UTAnalytics.getInstance().getDefaultTracker();
            if (defaultTracker != null) {
                defaultTracker.send(uTAppLaunchHitBuilder.build());
            } else {
                Logger.f("Record app display event error", "Fatal Error,must call setRequestAuthentication method first.");
            }
        }
    }

    public static UTMI1010_2001Event getInstance() {
        if (mInstance == null) {
            synchronized (UTMI1010_2001Event.class) {
                if (mInstance == null) {
                    mInstance = new UTMI1010_2001Event();
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
        UTPageHitHelper.getInstance().pageDestroyed(activity);
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        UTPageHitHelper.getInstance().pageDisAppearByAuto(activity);
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        UTPageHitHelper.getInstance().pageAppearByAuto(activity);
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
        UTPageHitHelper.getInstance().pageSwitchBackground();
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusDelayCallbacks
    public void onSwitchBackgroundDelay() {
        _send1010Hit(SystemClock.elapsedRealtime() - this.mToForegroundTimestamp);
        this.mToBackgroundTimestamp = SystemClock.elapsedRealtime();
        AnalyticsMgr.G();
        AnalyticsMgr.O();
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchForeground() {
        this.mToForegroundTimestamp = SystemClock.elapsedRealtime();
        AnalyticsMgr.P();
    }
}
