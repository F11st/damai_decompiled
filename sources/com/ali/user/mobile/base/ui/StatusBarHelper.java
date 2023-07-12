package com.ali.user.mobile.base.ui;

import android.app.Activity;
import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class StatusBarHelper {
    public static void setStatusBarMode(Activity activity, boolean z) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (z) {
                activity.getWindow().getDecorView().setSystemUiVisibility(8192);
            } else {
                activity.getWindow().getDecorView().setSystemUiVisibility(0);
            }
        }
    }
}
