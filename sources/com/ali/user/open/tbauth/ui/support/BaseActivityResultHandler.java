package com.ali.user.open.tbauth.ui.support;

import android.app.Activity;
import android.content.Intent;
import android.webkit.WebView;
import com.ali.user.open.core.trace.SDKLogger;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class BaseActivityResultHandler implements ActivityResultHandler {
    private static final String TAG = "system";

    @Override // com.ali.user.open.tbauth.ui.support.ActivityResultHandler
    public void onActivityResult(int i, int i2, int i3, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView) {
        if (i == 1) {
            onCallbackContext(i2, i3, intent, activity, map, webView);
            return;
        }
        SDKLogger.e(TAG, "Unrecognized source " + i);
    }

    protected abstract void onCallbackContext(int i, int i2, Intent intent, Activity activity, Map<Class<?>, Object> map, WebView webView);
}
