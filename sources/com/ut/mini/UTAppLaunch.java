package com.ut.mini;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.alibaba.analytics.utils.Logger;
import com.ut.mini.module.appstatus.UTAppStatusCallbacks;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import me.ele.altriax.launcher.real.time.data.biz.BizTime;
import tb.hl2;
import tb.sj;
import tb.u6;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTAppLaunch implements UTAppStatusCallbacks {
    private static final String IS_FIRST_TIME_LAUNCH = "_is_ft";
    private static final String IS_HOT_LAUNCH = "_is_hl";
    private static final String TAG = "UTAppLaunch";
    private static final String UT_DATABASE_NAME = "ut.db";
    private static boolean bCheckedFirstAppLaunch = false;
    private static boolean bEnable = true;
    private static boolean bFirstAppLaunch;
    private static UTAppLaunch mInstance;
    private boolean bFirstSend = true;
    private boolean bMainProcess = false;

    private UTAppLaunch() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void checkFirstLaunch(Context context) {
        if (!bEnable || bCheckedFirstAppLaunch) {
            return;
        }
        boolean z = true;
        bCheckedFirstAppLaunch = true;
        File databasePath = context.getDatabasePath(UT_DATABASE_NAME);
        if (databasePath != null && databasePath.exists()) {
            z = false;
        }
        bFirstAppLaunch = z;
    }

    public static UTAppLaunch getInstance() {
        if (mInstance == null) {
            synchronized (UTAppLaunch.class) {
                if (mInstance == null) {
                    mInstance = new UTAppLaunch();
                }
            }
        }
        return mInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void send(Map<String, String> map) {
        UTAnalytics.getInstance().getDefaultTracker().send(new UTAppLaunchHitBuilder(BizTime.UT, 1023, "/tracking.init.rdy", null, null, map).build());
    }

    private void sendFirstLaunch(final Context context) {
        hl2.c().f(new Runnable() { // from class: com.ut.mini.UTAppLaunch.1
            @Override // java.lang.Runnable
            public void run() {
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    if (UTAppLaunch.bFirstAppLaunch) {
                        hashMap.put(UTAppLaunch.IS_FIRST_TIME_LAUNCH, "1");
                    } else {
                        hashMap.put(UTAppLaunch.IS_FIRST_TIME_LAUNCH, "0");
                    }
                    hashMap.put(UTAppLaunch.IS_HOT_LAUNCH, "0");
                    UTAppLaunch.this.send(hashMap);
                    Logger.f(UTAppLaunch.TAG, "sendAppLaunch _is_ft", Boolean.valueOf(UTAppLaunch.bFirstAppLaunch));
                }
            }
        });
    }

    private void sendHotLaunch() {
        HashMap hashMap = new HashMap();
        hashMap.put(IS_HOT_LAUNCH, "1");
        send(hashMap);
        Logger.f(TAG, "sendHotLaunch _is_hl", 1);
    }

    private void sendLaunch(Context context) {
        if (!bEnable || context == null) {
            return;
        }
        if (this.bFirstSend) {
            this.bMainProcess = u6.h(context);
            sendFirstLaunch(context);
            this.bFirstSend = false;
        } else if (this.bMainProcess) {
            sendHotLaunch();
        }
    }

    public static void setEnable(boolean z) {
        bEnable = z;
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
    }

    @Override // com.ut.mini.module.appstatus.UTAppStatusCallbacks
    public void onSwitchForeground() {
        sendLaunch(sj.c().b());
    }
}
