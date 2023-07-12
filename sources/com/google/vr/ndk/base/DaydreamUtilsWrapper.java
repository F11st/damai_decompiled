package com.google.vr.ndk.base;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import tb.co;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class DaydreamUtilsWrapper {
    public int getComponentDaydreamCompatibility(Context context) {
        ComponentName b = co.b(context);
        if (b != null) {
            return DaydreamUtils.getComponentDaydreamCompatibility(context, b);
        }
        return 1;
    }

    public boolean isDaydreamActivity(Activity activity) {
        return isDaydreamComponent(activity);
    }

    public boolean isDaydreamComponent(Context context) {
        return getComponentDaydreamCompatibility(context) != 1;
    }

    public boolean isDaydreamPhone(Context context) {
        return DaydreamUtils.isDaydreamPhone(context);
    }

    public boolean isDaydreamRequiredComponent(Context context) {
        return getComponentDaydreamCompatibility(context) == 3;
    }
}
