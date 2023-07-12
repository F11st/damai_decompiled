package tb;

import kotlin.jvm.JvmField;
import kotlin.jvm.JvmStatic;
import kotlin.text.C8604o;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class n61 {
    @NotNull
    public static final n61 INSTANCE = new n61();
    @JvmField
    @NotNull
    public static final hp0 JVM_FIELD_ANNOTATION_FQ_NAME = new hp0("kotlin.jvm.JvmField");

    static {
        b41.h(hj.m(new hp0("kotlin.reflect.jvm.internal.ReflectionFactoryImpl")), "topLevel(FqName(\"kotlin.….ReflectionFactoryImpl\"))");
    }

    private n61() {
    }

    @JvmStatic
    @NotNull
    public static final String a(@NotNull String str) {
        b41.i(str, "propertyName");
        return e(str) ? str : b41.r(gn1.TYPE_OPEN_URL_METHOD_GET, jg.a(str));
    }

    @JvmStatic
    public static final boolean b(@NotNull String str) {
        boolean F;
        boolean F2;
        b41.i(str, "name");
        F = C8604o.F(str, gn1.TYPE_OPEN_URL_METHOD_GET, false, 2, null);
        if (!F) {
            F2 = C8604o.F(str, "is", false, 2, null);
            if (!F2) {
                return false;
            }
        }
        return true;
    }

    @JvmStatic
    public static final boolean c(@NotNull String str) {
        boolean F;
        b41.i(str, "name");
        F = C8604o.F(str, "set", false, 2, null);
        return F;
    }

    @JvmStatic
    @NotNull
    public static final String d(@NotNull String str) {
        String a;
        b41.i(str, "propertyName");
        if (e(str)) {
            a = str.substring(2);
            b41.h(a, "(this as java.lang.String).substring(startIndex)");
        } else {
            a = jg.a(str);
        }
        return b41.r("set", a);
    }

    @JvmStatic
    public static final boolean e(@NotNull String str) {
        boolean F;
        b41.i(str, "name");
        F = C8604o.F(str, "is", false, 2, null);
        if (F && str.length() != 2) {
            char charAt = str.charAt(2);
            return b41.k(97, charAt) > 0 || b41.k(charAt, 122) > 0;
        }
        return false;
    }
}
