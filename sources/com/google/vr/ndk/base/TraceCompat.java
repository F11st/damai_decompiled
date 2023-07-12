package com.google.vr.ndk.base;

import android.os.Build;
import android.os.Trace;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
class TraceCompat {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static void beginSection(String str) {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.beginSection(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void endSection() {
        if (Build.VERSION.SDK_INT >= 18) {
            Trace.endSection();
        }
    }
}
