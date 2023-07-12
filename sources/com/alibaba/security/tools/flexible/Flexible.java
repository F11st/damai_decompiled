package com.alibaba.security.tools.flexible;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class Flexible {
    private static final String TAG = "Flexible";

    public static void setContentView(Activity activity, int i) {
        new FlexibleContext(activity, activity).addView(LayoutInflater.from(activity).inflate(i, (ViewGroup) null), null);
    }

    public static void setContentView(Activity activity, View view) {
        new FlexibleContext(activity, activity).addView(view, null);
    }
}
