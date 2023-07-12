package com.google.vr.sdk.widgets.common;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class VrEventListener {
    private static final String TAG = "VrEventListener";

    public void onClick() {
    }

    public void onDisplayModeChanged(int i) {
    }

    public void onLoadError(String str) {
        String str2 = TAG;
        int hashCode = hashCode();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 25);
        sb.append(hashCode);
        sb.append(".onLoadError: ");
        sb.append(str);
        Log.e(str2, sb.toString());
    }

    public void onLoadSuccess() {
    }
}
