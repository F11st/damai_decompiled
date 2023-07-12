package tb;

import android.util.Log;
import com.taobao.tlog.adapter.AdapterForTLog;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class m42 {
    private static volatile boolean a;

    private static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(" ");
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
                sb.append(f(objArr[i], objArr[i2]));
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(" ");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String b(String str) {
        return "NSlide." + str;
    }

    public static void c(String str, String str2, Object... objArr) {
        if (a) {
            AdapterForTLog.logd(b(str), a(str2, objArr));
        } else {
            Log.d(b(str), a(str2, objArr));
        }
    }

    public static void d(String str, String str2, Throwable th, Object... objArr) {
        if (a) {
            AdapterForTLog.loge(b(str), a(str2, objArr), th);
        } else {
            Log.e(b(str), a(str2, objArr), th);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (a) {
            AdapterForTLog.loge(b(str), a(str2, objArr));
        } else {
            Log.e(b(str), a(str2, objArr));
        }
    }

    private static String f(Object obj, Object obj2) {
        StringBuilder sb = new StringBuilder();
        if (obj == null) {
            obj = "";
        }
        sb.append(obj);
        sb.append(":");
        if (obj2 == null) {
            obj2 = "";
        }
        sb.append(obj2);
        return sb.toString();
    }

    public static void g(String str, String str2, Object... objArr) {
        if (a) {
            AdapterForTLog.logi(b(str), a(str2, objArr));
        } else {
            Log.i(b(str), a(str2, objArr));
        }
    }

    public static void h(boolean z) {
        if (z) {
            try {
                int i = AdapterForTLog.a;
            } catch (Throwable unused) {
                return;
            }
        }
        a = z;
    }

    public static void i(String str, String str2, Object... objArr) {
        if (a) {
            AdapterForTLog.logv(b(str), a(str2, objArr));
        } else {
            Log.v(b(str), a(str2, objArr));
        }
    }

    public static void j(String str, String str2, Throwable th, Object... objArr) {
        if (a) {
            AdapterForTLog.logw(b(str), a(str2, objArr), th);
        } else {
            Log.w(b(str), a(str2, objArr), th);
        }
    }

    public static void k(String str, String str2, Object... objArr) {
        if (a) {
            AdapterForTLog.logw(b(str), a(str2, objArr));
        } else {
            Log.w(b(str), a(str2, objArr));
        }
    }
}
