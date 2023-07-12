package me.ele.altriax.launcher.common;

import android.os.Trace;
import androidx.annotation.NonNull;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class AltriaXTrace {
    public static void beginSection(@NonNull String str) {
        if (AltriaXLaunchTime.isOpen()) {
            Trace.beginSection(str);
        }
    }

    public static void endSection() {
        if (AltriaXLaunchTime.isOpen()) {
            Trace.endSection();
        }
    }
}
