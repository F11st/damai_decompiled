package com.youku.gaiax.js.utils;

import android.os.SystemClock;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0006\u0010\u0003\u001a\u00020\u0002R\"\u0010\u0005\u001a\u00020\u00048\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/youku/gaiax/js/utils/TimeUtils;", "", "", "elapsedRealtime", "", "DEBUG", "Z", "getDEBUG", "()Z", "setDEBUG", "(Z)V", "<init>", "()V", "GaiaX-Android-JS"}, k = 1, mv = {1, 5, 1})
/* loaded from: classes2.dex */
public final class TimeUtils {
    private static boolean DEBUG;
    @NotNull
    public static final TimeUtils INSTANCE = new TimeUtils();

    private TimeUtils() {
    }

    public final long elapsedRealtime() {
        if (DEBUG) {
            return 0L;
        }
        return SystemClock.elapsedRealtime();
    }

    public final boolean getDEBUG() {
        return DEBUG;
    }

    public final void setDEBUG(boolean z) {
        DEBUG = z;
    }
}
