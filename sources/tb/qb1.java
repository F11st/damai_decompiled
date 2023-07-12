package tb;

import android.text.TextUtils;
import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;
import java.util.Formatter;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qb1 {
    public static final String COMMON_TAG = "STRATEGY.ALL";
    private static Integer a;
    private static StringBuilder d;
    private static Formatter e;
    public static final char LEVEL_V = 'V';
    public static final char LEVEL_D = 'D';
    public static final char LEVEL_I = 'I';
    public static final char LEVEL_W = 'W';
    public static final char LEVEL_E = 'E';
    public static final char LEVEL_L = 'L';
    public static final char[] sLogTypes = {LEVEL_V, LEVEL_D, LEVEL_I, LEVEL_W, LEVEL_E, LEVEL_L};
    private static boolean b = AdapterForTLog.isValid();
    private static final Object c = new Object();

    public static void a(String str, String str2, Object... objArr) {
        if (f(LEVEL_D)) {
            if (b) {
                AdapterForTLog.logd(str, c(str2, objArr));
            } else {
                Log.d(str, c(str2, objArr));
            }
        }
    }

    public static void b(String str, String str2, Object... objArr) {
        if (f(LEVEL_E)) {
            if (b) {
                AdapterForTLog.loge(str, c(str2, objArr));
            } else {
                Log.e(str, c(str2, objArr));
            }
        }
    }

    private static String c(String str, Object... objArr) {
        String substring;
        synchronized (c) {
            StringBuilder sb = d;
            if (sb == null) {
                d = new StringBuilder(250);
            } else {
                sb.setLength(0);
            }
            if (e == null) {
                e = new Formatter(d, Locale.getDefault());
            }
            e.format(str, objArr);
            substring = d.substring(0);
        }
        return substring;
    }

    private static int d(char c2) {
        int i = 0;
        while (true) {
            char[] cArr = sLogTypes;
            if (i >= cArr.length) {
                return -1;
            }
            if (cArr[i] == c2) {
                return i;
            }
            i++;
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (f(LEVEL_I)) {
            if (b) {
                AdapterForTLog.logi(str, c(str2, objArr));
            } else {
                Log.i(str, c(str2, objArr));
            }
        }
    }

    public static boolean f(char c2) {
        if (a == null) {
            if (b) {
                String logLevel = AdapterForTLog.getLogLevel();
                a = Integer.valueOf(d(TextUtils.isEmpty(logLevel) ? LEVEL_L : logLevel.charAt(0)));
            } else {
                a = Integer.valueOf(d(LEVEL_V));
            }
        }
        return d(c2) >= a.intValue();
    }

    public static void g(String str, String str2, Object... objArr) {
        if (f(LEVEL_W)) {
            if (b) {
                AdapterForTLog.logw(str, c(str2, objArr));
            } else {
                Log.w(str, c(str2, objArr));
            }
        }
    }
}
