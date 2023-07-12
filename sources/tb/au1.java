package tb;

import android.text.TextUtils;
import java.util.Objects;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class au1 {
    public static void a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void b(String str) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException();
        }
    }

    public static void c(String str, Object obj) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static <T> void d(T t) {
        Objects.requireNonNull(t);
    }

    public static <T> void e(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException(String.valueOf(obj));
        }
    }
}
