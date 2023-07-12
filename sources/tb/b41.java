package tb;

import java.util.Arrays;
import kotlin.KotlinNullPointerException;
import kotlin.SinceKotlin;
import kotlin.UninitializedPropertyAccessException;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class b41 {

    /* compiled from: Taobao */
    @SinceKotlin(version = "1.4")
    /* loaded from: classes3.dex */
    public static class a {
        private a() {
        }
    }

    private b41() {
    }

    public static void A(String str) {
        z("lateinit property " + str + " has not been initialized");
    }

    @SinceKotlin(version = "1.1")
    public static boolean a(Double d, double d2) {
        return d != null && d.doubleValue() == d2;
    }

    @SinceKotlin(version = "1.1")
    public static boolean b(Float f, float f2) {
        return f != null && f.floatValue() == f2;
    }

    @SinceKotlin(version = "1.1")
    public static boolean c(Float f, Float f2) {
        if (f == null) {
            if (f2 == null) {
                return true;
            }
        } else if (f2 != null && f.floatValue() == f2.floatValue()) {
            return true;
        }
        return false;
    }

    public static boolean d(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static void e(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((IllegalStateException) p(new IllegalStateException(str + " must not be null")));
    }

    public static void f(Object obj) {
        if (obj == null) {
            s();
        }
    }

    public static void g(Object obj, String str) {
        if (obj == null) {
            t(str);
        }
    }

    public static void h(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw ((NullPointerException) p(new NullPointerException(str + " must not be null")));
    }

    public static void i(Object obj, String str) {
        if (obj == null) {
            w(str);
        }
    }

    public static void j(Object obj, String str) {
        if (obj == null) {
            v(str);
        }
    }

    public static int k(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }

    public static int l(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }

    private static String m(String str) {
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[4];
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        return "Parameter specified as non-null is null: method " + className + "." + methodName + ", parameter " + str;
    }

    public static void n() {
        x();
    }

    public static void o(int i, String str) {
        x();
    }

    private static <T extends Throwable> T p(T t) {
        return (T) q(t, b41.class.getName());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static <T extends Throwable> T q(T t, String str) {
        StackTraceElement[] stackTrace = t.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (str.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        t.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return t;
    }

    public static String r(String str, Object obj) {
        return str + obj;
    }

    @SinceKotlin(version = "1.4")
    public static void s() {
        throw ((NullPointerException) p(new NullPointerException()));
    }

    @SinceKotlin(version = "1.4")
    public static void t(String str) {
        throw ((NullPointerException) p(new NullPointerException(str)));
    }

    public static void u() {
        throw ((KotlinNullPointerException) p(new KotlinNullPointerException()));
    }

    private static void v(String str) {
        throw ((IllegalArgumentException) p(new IllegalArgumentException(m(str))));
    }

    private static void w(String str) {
        throw ((NullPointerException) p(new NullPointerException(m(str))));
    }

    public static void x() {
        y("This function has a reified type parameter and thus can only be inlined at compilation time, not called directly.");
    }

    public static void y(String str) {
        throw new UnsupportedOperationException(str);
    }

    public static void z(String str) {
        throw ((UninitializedPropertyAccessException) p(new UninitializedPropertyAccessException(str)));
    }
}
