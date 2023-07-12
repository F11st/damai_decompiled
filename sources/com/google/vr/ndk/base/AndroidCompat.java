package com.google.vr.ndk.base;

import android.app.Activity;
import com.google.vr.cardboard.annotations.UsedByReflection;
import tb.h5;

/* compiled from: Taobao */
@UsedByReflection("Unity")
/* loaded from: classes10.dex */
public final class AndroidCompat {
    private AndroidCompat() {
    }

    @UsedByReflection("Unity")
    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        h5.g(activity, z);
    }

    @UsedByReflection("Unity")
    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return h5.h(activity, z);
    }
}
