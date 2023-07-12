package tb;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;
import org.checkerframework.checker.nullness.compatqual.NonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* compiled from: Taobao */
@GwtCompatible
/* loaded from: classes10.dex */
public final class du1 {
    public static void A(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(com.google.common.base.h.b(str, obj));
        }
    }

    private static String a(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return com.google.common.base.h.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return com.google.common.base.h.b("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    private static String b(int i, int i2, @NullableDecl String str) {
        if (i < 0) {
            return com.google.common.base.h.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return com.google.common.base.h.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }

    private static String c(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return b(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : com.google.common.base.h.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void e(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    public static void f(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, Integer.valueOf(i)));
        }
    }

    public static void g(boolean z, @NullableDecl String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void h(boolean z, @NullableDecl String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, Long.valueOf(j)));
        }
    }

    public static void i(boolean z, @NullableDecl String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void j(boolean z, @NullableDecl String str, long j, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, Long.valueOf(j), obj));
        }
    }

    public static void k(boolean z, @NullableDecl String str, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, obj));
        }
    }

    public static void l(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, obj, obj2));
        }
    }

    public static void m(boolean z, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2, @NullableDecl Object obj3, @NullableDecl Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(com.google.common.base.h.b(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static int n(int i, int i2) {
        return o(i, i2, "index");
    }

    @CanIgnoreReturnValue
    public static int o(int i, int i2, @NullableDecl String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(a(i, i2, str));
        }
        return i;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T p(@NonNullDecl T t) {
        Objects.requireNonNull(t);
        return t;
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T q(@NonNullDecl T t, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T r(@NonNullDecl T t, @NullableDecl String str, @NullableDecl Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(com.google.common.base.h.b(str, obj));
    }

    @CanIgnoreReturnValue
    @NonNullDecl
    public static <T> T s(@NonNullDecl T t, @NullableDecl String str, @NullableDecl Object obj, @NullableDecl Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(com.google.common.base.h.b(str, obj, obj2));
    }

    @CanIgnoreReturnValue
    public static int t(int i, int i2) {
        return u(i, i2, "index");
    }

    @CanIgnoreReturnValue
    public static int u(int i, int i2, @NullableDecl String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    public static void v(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void w(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void x(boolean z, @NullableDecl Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void y(boolean z, @NullableDecl String str, int i) {
        if (!z) {
            throw new IllegalStateException(com.google.common.base.h.b(str, Integer.valueOf(i)));
        }
    }

    public static void z(boolean z, @NullableDecl String str, long j) {
        if (!z) {
            throw new IllegalStateException(com.google.common.base.h.b(str, Long.valueOf(j)));
        }
    }
}
