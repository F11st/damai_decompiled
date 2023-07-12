package tb;

import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class mb1 {
    private static String a = "Analytics.ut4aplus";
    private static String b = "Analytics.ut4aplus.";
    private static HashMap<String, Integer> c;
    private static boolean d;

    static {
        HashMap<String, Integer> hashMap = new HashMap<>();
        c = hashMap;
        hashMap.put("V", 5);
        c.put("D", 4);
        c.put("I", 3);
        c.put(ExifInterface.LONGITUDE_WEST, 2);
        c.put(ExifInterface.LONGITUDE_EAST, 1);
        c.put("L", 0);
        d = true;
    }

    static String a(String str, Object... objArr) {
        if (str == null && objArr == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        StackTraceElement g = g();
        int i = 0;
        sb.append(String.format("[%s]", g != null ? g.getMethodName() : ""));
        if (str != null) {
            sb.append(" ");
            sb.append(str);
        }
        if (objArr != null) {
            while (true) {
                int i2 = i + 1;
                if (i2 >= objArr.length) {
                    break;
                }
                sb.append(",");
                sb.append(f(objArr[i], objArr[i2]));
                i = i2 + 1;
            }
            if (i == objArr.length - 1) {
                sb.append(",");
                sb.append(objArr[i]);
            }
        }
        return sb.toString();
    }

    private static String b() {
        return c(b);
    }

    private static String c(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            str = a;
        }
        StackTraceElement g = g();
        if (g != null) {
            String className = g.getClassName();
            if (!TextUtils.isEmpty(className)) {
                str2 = className.substring(className.lastIndexOf(46) + 1);
                return str + str2 + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
            }
        }
        str2 = "";
        return str + str2 + "." + String.valueOf(Process.myPid()) + "." + (Thread.currentThread().getId() + "");
    }

    public static void d(String str, Object... objArr) {
        if (i()) {
            try {
                String a2 = a(str, objArr);
                if (!TextUtils.isEmpty(a2)) {
                    int i = 2048;
                    if (a2.length() > 2048) {
                        int i2 = 0;
                        int length = a2.length();
                        while (true) {
                            Log.d(b(), a2.substring(i2, i));
                            int i3 = i + 2048;
                            if (i3 > length) {
                                i3 = length;
                            }
                            if (i == i3) {
                                break;
                            }
                            int i4 = i;
                            i = i3;
                            i2 = i4;
                        }
                    }
                }
                Log.d(b(), a2);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public static void e(String str, Object... objArr) {
        if (i()) {
            Log.e(b(), a(str, objArr));
        }
    }

    private static String f(Object obj, Object obj2) {
        Object[] objArr = new Object[2];
        if (obj == null) {
            obj = "";
        }
        objArr[0] = obj;
        if (obj2 == null) {
            obj2 = "";
        }
        objArr[1] = obj2;
        return String.format("%s:%s", objArr);
    }

    private static StackTraceElement g() {
        StackTraceElement[] stackTrace;
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (!stackTraceElement.isNativeMethod() && !stackTraceElement.getClassName().equals(Thread.class.getName()) && !stackTraceElement.getClassName().equals(mb1.class.getName())) {
                return stackTraceElement;
            }
        }
        return null;
    }

    public static void h(String str, Object... objArr) {
        if (i()) {
            Log.i(b(), a(str, objArr));
        }
    }

    public static boolean i() {
        return d;
    }

    public static void j(String str, Throwable th, Object... objArr) {
        if (i()) {
            Log.w(b(), a(str, objArr), th);
        }
    }

    public static void k(String str, Object... objArr) {
        if (i()) {
            Log.w(b(), a(str, objArr));
        }
    }
}
