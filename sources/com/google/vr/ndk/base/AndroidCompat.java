package com.google.vr.ndk.base;

import android.app.Activity;
import com.google.vr.cardboard.annotations.UsedByReflection;
import tb.C9201h5;

/* compiled from: Taobao */
@UsedByReflection("Unity")
/* loaded from: classes10.dex */
public final class AndroidCompat {
    private AndroidCompat() {
    }

    @UsedByReflection("Unity")
    public static void setSustainedPerformanceMode(Activity activity, boolean z) {
        C9201h5.g(activity, z);
    }

    @UsedByReflection("Unity")
    public static boolean setVrModeEnabled(Activity activity, boolean z) {
        return C9201h5.h(activity, z);
    }
}
