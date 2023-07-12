package com.ut.mini.anti_cheat;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.UTAnalytics;
import com.ut.mini.UTHitBuilders;
import com.ut.mini.UTPageHitHelper;
import com.ut.mini.anti_cheat.ScreenshotDetector;
import com.ut.mini.extend.UTExtendSwitch;
import com.ut.mini.module.appstatus.UTAppStatusDelayCallbacks;
import com.ut.mini.module.appstatus.UTAppStatusRegHelper;
import tb.wd;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AntiCheatTracker implements ScreenshotDetector.ScreenshotListener, UTAppStatusDelayCallbacks {
    private static AntiCheatTracker instance;
    private boolean init = false;
    private ScreenshotDetector mDetector = null;
    private String mContainName = null;

    public static AntiCheatTracker getInstance() {
        if (instance == null) {
            synchronized (AntiCheatTracker.class) {
                if (instance == null) {
                    instance = new AntiCheatTracker();
                }
            }
        }
        return instance;
    }

    public void init(Application application) {
        if (UTExtendSwitch.bAntiCheat && !wd.a()) {
            Logger.l();
            if (this.init) {
                return;
            }
            this.init = true;
            this.mDetector = new ScreenshotDetector(application.getBaseContext());
            UTAppStatusRegHelper.registerAppStatusCallbacks(this);
        }
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityCreated(Activity activity, Bundle bundle) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityDestroyed(Activity activity) {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityPaused(Activity activity) {
        this.mContainName = null;
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onActivityResumed(Activity activity) {
        if (activity != null) {
            this.mContainName = activity.getClass().getCanonicalName();
        }
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

    @Override // com.ut.mini.anti_cheat.ScreenshotDetector.ScreenshotListener
    public void onScreenCaptured(String str) {
        Logger.l();
        try {
            String currentPageName = UTPageHitHelper.getInstance().getCurrentPageName();
            String str2 = this.mContainName;
            UTHitBuilders.UTCustomHitBuilder uTCustomHitBuilder = new UTHitBuilders.UTCustomHitBuilder("screen_capture");
            uTCustomHitBuilder.setEventPage("anti_cheat");
            uTCustomHitBuilder.setProperty("page_name", currentPageName);
            uTCustomHitBuilder.setProperty("contain_name", str2);
            uTCustomHitBuilder.setProperty("current_time", System.currentTimeMillis() + "");
            UTAnalytics.getInstance().getDefaultTracker().send(uTCustomHitBuilder.build());
        } catch (Throwable unused) {
        }
    }

    @Override // com.ut.mini.anti_cheat.ScreenshotDetector.ScreenshotListener
    public void onScreenCapturedWithDeniedPermission() {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchBackground() {
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusDelayCallbacks
    public void onSwitchBackgroundDelay() {
        ScreenshotDetector screenshotDetector = this.mDetector;
        if (screenshotDetector != null) {
            screenshotDetector.stop();
        }
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchForeground() {
        ScreenshotDetector screenshotDetector = this.mDetector;
        if (screenshotDetector != null) {
            screenshotDetector.start(this);
        }
    }
}
