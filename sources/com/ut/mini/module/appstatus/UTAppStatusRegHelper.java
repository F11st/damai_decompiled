package com.ut.mini.module.appstatus;

import android.annotation.TargetApi;
import android.app.Application;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class UTAppStatusRegHelper {
    @TargetApi(14)
    public static void registeActivityLifecycleCallbacks(Application application) {
        if (application != null) {
            application.registerActivityLifecycleCallbacks(UTActivityLifecycleCallbacks.getInstance());
        }
    }

    @TargetApi(14)
    public static void registerAppStatusCallbacks(UTAppStatusCallbacks uTAppStatusCallbacks) {
        if (uTAppStatusCallbacks != null) {
            UTAppStatusMonitor.getInstance().registerAppStatusCallbacks(uTAppStatusCallbacks);
        }
    }

    @TargetApi(14)
    public static void unRegisterAppStatusCallbacks(UTAppStatusCallbacks uTAppStatusCallbacks) {
        if (uTAppStatusCallbacks != null) {
            UTAppStatusMonitor.getInstance().unregisterAppStatusCallbacks(uTAppStatusCallbacks);
        }
    }

    @TargetApi(14)
    public static void unregisterActivityLifecycleCallbacks(Application application) {
        if (application != null) {
            application.unregisterActivityLifecycleCallbacks(UTActivityLifecycleCallbacks.getInstance());
        }
    }
}
