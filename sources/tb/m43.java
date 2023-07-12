package tb;

import android.util.Log;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class m43 {
    public static String a(String str) {
        return "debug.crs.".concat(String.valueOf(str));
    }

    public static boolean b(String str) {
        try {
            Method declaredMethod = Class.forName("android.os.SystemProperties").getDeclaredMethod("getBoolean", String.class, Boolean.TYPE);
            if (declaredMethod != null) {
                declaredMethod.setAccessible(true);
                return ((Boolean) declaredMethod.invoke(null, str, Boolean.FALSE)).booleanValue();
            }
        } catch (Throwable th) {
            Log.e("efs.debug", "get prop error", th);
        }
        return false;
    }
}
