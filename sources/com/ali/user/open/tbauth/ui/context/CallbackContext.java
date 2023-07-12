package com.ali.user.open.tbauth.ui.context;

import android.app.Activity;
import android.content.Intent;
import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.tbauth.ui.support.ActivityResultHandler;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class CallbackContext {
    private static final String TAG = "CallbackContext";
    public static volatile WeakReference<Activity> activity;
    public static volatile Object loginCallback;
    public static LoginCallback mGlobalLoginCallback;

    public static boolean onActivityResult(Activity activity2, int i, int i2, Intent intent) {
        String str = TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("onActivityResult requestCode=");
        sb.append(i);
        sb.append(" resultCode = ");
        sb.append(i2);
        sb.append(" authCode = ");
        sb.append(intent == null ? "" : intent.getStringExtra("result"));
        SDKLogger.d(str, sb.toString());
        ActivityResultHandler activityResultHandler = (ActivityResultHandler) KernelContext.getService(ActivityResultHandler.class);
        if (activityResultHandler == null) {
            SDKLogger.i(str, "No ActivityResultHandler handler to support the request code " + i);
            return false;
        } else if (activity2 == null) {
            SDKLogger.e(str, "No active activity is set, ignore post " + activityResultHandler);
            return false;
        } else {
            activityResultHandler.onActivityResult(1, i, i2, intent, activity2, null, null);
            return true;
        }
    }

    public static void setActivity(Activity activity2) {
        activity = new WeakReference<>(activity2);
    }

    public static boolean onActivityResult(int i, int i2, Intent intent) {
        return onActivityResult(activity != null ? activity.get() : null, i, i2, intent);
    }
}
