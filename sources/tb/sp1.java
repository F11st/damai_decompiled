package tb;

import android.text.TextUtils;
import com.taobao.weex.annotation.JSMethod;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sp1 {
    private static Map<String, Float> a = new ConcurrentHashMap();

    private static void a(String str, float f) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("pageName must not null");
        }
        if (f > 1.0f || f < 0.0f) {
            throw new IllegalArgumentException("percent must in [0,1]");
        }
    }

    public static float b(String str) {
        return c(str, null);
    }

    public static float c(String str, String str2) {
        if (str2 != null) {
            str = str + JSMethod.NOT_SET + str2;
        }
        Float f = a.get(str);
        if (f == null) {
            return 1.0f;
        }
        return f.floatValue();
    }

    public static void d(String str, float f) {
        e(str, null, f);
    }

    public static void e(String str, String str2, float f) {
        a(str, f);
        if (str2 != null) {
            str = str + JSMethod.NOT_SET + str2;
        }
        a.put(str, Float.valueOf(f));
    }
}
