package tb;

import com.taobao.tcommon.log.FormatLog;
import java.util.Locale;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hh0 {
    private static FormatLog a;

    public static void a(String str, String str2, Object... objArr) {
        d();
        if (a.isLoggable(3)) {
            a.d(str, e(str2, objArr), objArr);
        }
    }

    public static void b(int i, String str, String str2) {
        d();
        if (a.isLoggable(6)) {
            a.e(6, str, str2);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        d();
        if (a.isLoggable(6)) {
            a.e(str, str2, objArr);
        }
    }

    private static void d() {
        if (a == null) {
            a = new r50();
        }
    }

    public static String e(String str, Object... objArr) {
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            int indexOf = str.indexOf(37, i);
            if (indexOf < 0 || indexOf >= length - 1) {
                break;
            }
            i = indexOf + 1;
            char charAt = str.charAt(i);
            if (Character.isLetter(charAt)) {
                if (charAt == 'K' && i2 < objArr.length) {
                    objArr[i2] = h(((Integer) objArr[i2]).intValue());
                    bytes[i] = 115;
                }
                i2++;
            }
        }
        return new String(bytes);
    }

    public static void f(String str, String str2, Object... objArr) {
        d();
        if (a.isLoggable(4)) {
            a.i(str, str2, objArr);
        }
    }

    public static boolean g(int i) {
        d();
        return a.isLoggable(i);
    }

    public static String h(long j) {
        String str;
        String format;
        if (j <= 0) {
            return String.valueOf(j);
        }
        float f = (float) j;
        if (f > 900.0f) {
            f /= 1024.0f;
            str = "KB";
        } else {
            str = "B";
        }
        if (f > 900.0f) {
            f /= 1024.0f;
            str = "MB";
        }
        if (f > 900.0f) {
            f /= 1024.0f;
            str = "GB";
        }
        if (f > 900.0f) {
            f /= 1024.0f;
            str = "TB";
        }
        if (f > 900.0f) {
            f /= 1024.0f;
            str = "PB";
        }
        if (f < 1.0f) {
            format = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
        } else if (f < 10.0f) {
            format = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
        } else if (f < 100.0f) {
            format = String.format(Locale.getDefault(), "%.2f", Float.valueOf(f));
        } else {
            format = String.format(Locale.getDefault(), "%.0f", Float.valueOf(f));
        }
        return format + str;
    }

    public static void i(String str, String str2, Object... objArr) {
        d();
        if (a.isLoggable(5)) {
            a.w(str, str2, objArr);
        }
    }
}
