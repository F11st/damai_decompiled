package com.youku.live.livesdk.util;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.util.Log;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class DebugHelp {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static final String TAG = "DebugHelp";
    public static Boolean sDebug;

    public static boolean isDebugBuild() {
        ApplicationInfo applicationInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1814747821")) {
            return ((Boolean) ipChange.ipc$dispatch("-1814747821", new Object[0])).booleanValue();
        }
        Boolean bool = sDebug;
        if (bool != null) {
            return bool.booleanValue();
        }
        Log.i(TAG, "sDebug = " + sDebug);
        try {
            Context context = Dsl.getContext();
            Application application = null;
            if (context != null) {
                if (context instanceof Activity) {
                    application = ((Activity) context).getApplication();
                } else if (context instanceof Application) {
                    application = (Application) context;
                }
                if (application != null && (applicationInfo = application.getApplicationInfo()) != null) {
                    sDebug = new Boolean((applicationInfo.flags & 2) != 0);
                }
            }
            if (sDebug == null) {
                sDebug = Boolean.FALSE;
            }
            Log.i(TAG, "debug : " + sDebug);
        } catch (Throwable th) {
            String message = th.getMessage();
            Log.i(TAG, "debug help exeption message : " + message);
            sDebug = Boolean.FALSE;
        }
        return sDebug.booleanValue();
    }
}
