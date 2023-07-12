package me.ele.altriax.launcher.common;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Locale;
import java.util.concurrent.CopyOnWriteArrayList;
import me.ele.altriax.launcher.common.model.AltriaXTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXLog {
    public static final String ALTRIAX = "AltriaX";
    private static final String ALTRIAX_LOGGABLE_REFUSE = "AltriaX loggable refuse";
    public static final String ALTRIAX_LOG_FORMAT = "%-55s  %-1s  %-11s  %s\n\n";
    private static final CopyOnWriteArrayList<AltriaXTLog> ALTRIAX_T_LOG = new CopyOnWriteArrayList<>();
    private static final String FOURTH_PARAMETER_PLACEHOLDER = "";
    private static final String SECOND_PARAMETER_PLACEHOLDER = "N";
    public static final int VERBOSE = 2;

    public static void clearAltriaXTLog() {
        ALTRIAX_T_LOG.clear();
    }

    public static String formatLog(@NonNull String str, @NonNull String str2, @Nullable String str3, @Nullable String str4) {
        ALTRIAX_T_LOG.add(new AltriaXTLog(str, str2, str3, str4));
        if (isLoggable(str, 2)) {
            if (TextUtils.isEmpty(str3)) {
                str3 = "N";
            }
            if (TextUtils.isEmpty(str4)) {
                str4 = "";
            }
            return String.format(Locale.getDefault(), ALTRIAX_LOG_FORMAT, str2, str3, Thread.currentThread().getName(), str4);
        }
        return ALTRIAX_LOGGABLE_REFUSE;
    }

    public static CopyOnWriteArrayList<AltriaXTLog> getAltriaXTLog() {
        return ALTRIAX_T_LOG;
    }

    private static boolean isLoggable(@NonNull String str, int i) {
        return Log.isLoggable(str, i);
    }

    public static void v(@NonNull String str, @NonNull String str2) {
        verbose(str, str2);
    }

    private static void verbose(@NonNull String str, @NonNull String str2) {
        if (isLoggable(str, 2)) {
            Log.e(str, str2);
        }
    }
}
