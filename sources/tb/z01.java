package tb;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class z01 {
    private static boolean a = false;
    private static volatile boolean b = true;

    static {
        try {
            int i = AdapterForTLog.a;
            a = true;
        } catch (Exception unused) {
            a = false;
        }
    }

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(64);
        if (str != null) {
            sb.append(str);
        }
        if (objArr != null) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(" ");
                sb.append(objArr[i] != null ? objArr[i] : "");
                sb.append(":");
                sb.append(objArr[i2] != null ? objArr[i2] : "");
                i += 2;
            }
            if (i < objArr.length) {
                sb.append(" ");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        return "ARanger." + str;
    }

    public static void c(String str, String str2, Throwable th, Object... objArr) {
        if (a && b) {
            AdapterForTLog.loge(b(str), a(str2, objArr), th);
        } else {
            Log.e(b(str), a(str2, objArr), th);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (a && b) {
            AdapterForTLog.loge(b(str), a(str2, objArr));
        } else {
            Log.e(b(str), a(str2, objArr));
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a && b) {
            AdapterForTLog.logi(b(str), a(str2, objArr));
        } else {
            Log.i(b(str), a(str2, objArr));
        }
    }

    public static void f(boolean z) {
        b = z;
    }
}
