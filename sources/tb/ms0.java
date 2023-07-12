package tb;

import android.annotation.SuppressLint;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public final class ms0 {
    @NotNull
    public static final ms0 INSTANCE = new ms0();
    @Nullable
    private static Class<?> a;
    @Nullable
    private static Method b;

    private ms0() {
    }

    @SuppressLint({"PrivateApi"})
    private final void b() {
        try {
            if (a == null) {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                a = cls;
                cls.getDeclaredMethod("set", String.class, String.class);
                Class<?> cls2 = a;
                b = cls2 == null ? null : cls2.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Nullable
    public final String a(@NotNull String str, @NotNull String str2) {
        b41.i(str, "key");
        b41.i(str2, "value");
        b();
        try {
            Method method = b;
            Object invoke = method == null ? null : method.invoke(a, str, str2);
            if (invoke instanceof String) {
                return (String) invoke;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return str2;
        }
    }
}
