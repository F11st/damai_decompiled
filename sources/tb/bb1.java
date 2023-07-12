package tb;

import android.util.Log;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public final class bb1 {
    public static boolean a;

    public static void a(String str) {
        if (a) {
            Log.d("BindingX", str);
        }
    }

    public static void b(String str) {
        if (a) {
            Log.e("BindingX", str);
        }
    }

    public static void c(String str, Throwable th) {
        if (a) {
            Log.e("BindingX", str, th);
        }
    }

    public static void d(Map<String, Object> map) {
        Object obj;
        if (map == null || (obj = map.get("debug")) == null) {
            return;
        }
        boolean z = false;
        if (obj instanceof Boolean) {
            z = ((Boolean) obj).booleanValue();
        } else if (obj instanceof String) {
            z = "true".equals((String) obj);
        }
        a = z;
    }

    public static void e(String str) {
        if (a) {
            Log.v("BindingX", str);
        }
    }

    public static void f(String str) {
        if (a) {
            Log.w("BindingX", str);
        }
    }
}
