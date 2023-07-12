package me.ele.altriax.launcher.common;

import android.os.Looper;
import android.os.SystemClock;
import android.util.Log;
import android.util.Printer;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class AltriaXMessageQueueLog {
    private static final String ALTRIAX_MESSAGE_QUEUE_LOG_FORMAT = "[cost] %-6s %s\n";
    private static final String END = "<<<<< Finished to";
    private static final String MS = "ms";
    private static final String START = ">>>>> Dispatching to";
    private static final String TAG = "AltriaXMessageQueueLog";
    private static int threshold;

    public static void attachLooperListener() {
        if (AltriaXLaunchTime.isOpen()) {
            Looper.getMainLooper().setMessageLogging(new Printer() { // from class: me.ele.altriax.launcher.common.AltriaXMessageQueueLog.1
                long startTime;

                @Override // android.util.Printer
                public void println(String str) {
                    if (str.startsWith(AltriaXMessageQueueLog.START)) {
                        this.startTime = SystemClock.uptimeMillis();
                    } else if (!str.startsWith(AltriaXMessageQueueLog.END) || this.startTime <= 0) {
                    } else {
                        long uptimeMillis = SystemClock.uptimeMillis() - this.startTime;
                        if (uptimeMillis >= AltriaXMessageQueueLog.threshold) {
                            Locale locale = Locale.getDefault();
                            Log.e(AltriaXMessageQueueLog.TAG, String.format(locale, AltriaXMessageQueueLog.ALTRIAX_MESSAGE_QUEUE_LOG_FORMAT, uptimeMillis + AltriaXMessageQueueLog.MS, str));
                        }
                    }
                }
            });
        }
    }

    public static void setThreshold(int i) {
        threshold = i;
    }
}
