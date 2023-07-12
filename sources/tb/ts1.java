package tb;

import kotlin.jvm.JvmField;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public final class ts1 {
    @JvmField
    @NotNull
    public static final ss1 IMPLEMENTATIONS;

    static {
        ss1 ss1Var;
        Object newInstance;
        Object newInstance2;
        int a = a();
        if (a >= 65544 || a < 65536) {
            try {
                newInstance = r41.class.newInstance();
                b41.h(newInstance, "forName(\"kotlin.internal…entations\").newInstance()");
            } catch (ClassNotFoundException unused) {
                Object newInstance3 = Class.forName("kotlin.internal.JRE8PlatformImplementations").newInstance();
                b41.h(newInstance3, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance3 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    ss1Var = (ss1) newInstance3;
                } catch (ClassCastException e) {
                    ClassLoader classLoader = newInstance3.getClass().getClassLoader();
                    ClassLoader classLoader2 = ss1.class.getClassLoader();
                    if (b41.d(classLoader, classLoader2)) {
                        throw e;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader + ", base type classloader: " + classLoader2, e);
                }
            }
            try {
                if (newInstance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                }
                ss1Var = (ss1) newInstance;
                IMPLEMENTATIONS = ss1Var;
            } catch (ClassCastException e2) {
                ClassLoader classLoader3 = newInstance.getClass().getClassLoader();
                ClassLoader classLoader4 = ss1.class.getClassLoader();
                if (b41.d(classLoader3, classLoader4)) {
                    throw e2;
                }
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader3 + ", base type classloader: " + classLoader4, e2);
            }
        }
        if (a >= 65543 || a < 65536) {
            try {
                try {
                    newInstance2 = q41.class.newInstance();
                    b41.h(newInstance2, "forName(\"kotlin.internal…entations\").newInstance()");
                    try {
                    } catch (ClassCastException e3) {
                        ClassLoader classLoader5 = newInstance2.getClass().getClassLoader();
                        ClassLoader classLoader6 = ss1.class.getClassLoader();
                        if (b41.d(classLoader5, classLoader6)) {
                            throw e3;
                        }
                        throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader5 + ", base type classloader: " + classLoader6, e3);
                    }
                } catch (ClassNotFoundException unused2) {
                }
            } catch (ClassNotFoundException unused3) {
                Object newInstance4 = Class.forName("kotlin.internal.JRE7PlatformImplementations").newInstance();
                b41.h(newInstance4, "forName(\"kotlin.internal…entations\").newInstance()");
                try {
                    if (newInstance4 == null) {
                        throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
                    }
                    ss1Var = (ss1) newInstance4;
                } catch (ClassCastException e4) {
                    ClassLoader classLoader7 = newInstance4.getClass().getClassLoader();
                    ClassLoader classLoader8 = ss1.class.getClassLoader();
                    if (b41.d(classLoader7, classLoader8)) {
                        throw e4;
                    }
                    throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + classLoader7 + ", base type classloader: " + classLoader8, e4);
                }
            }
            if (newInstance2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.internal.PlatformImplementations");
            }
            ss1Var = (ss1) newInstance2;
            IMPLEMENTATIONS = ss1Var;
        }
        ss1Var = new ss1();
        IMPLEMENTATIONS = ss1Var;
    }

    private static final int a() {
        int Y;
        int Y2;
        String property = System.getProperty("java.specification.version");
        if (property == null) {
            return 65542;
        }
        Y = StringsKt__StringsKt.Y(property, '.', 0, false, 6, null);
        if (Y < 0) {
            try {
                return Integer.parseInt(property) * 65536;
            } catch (NumberFormatException unused) {
                return 65542;
            }
        }
        int i = Y + 1;
        Y2 = StringsKt__StringsKt.Y(property, '.', i, false, 4, null);
        if (Y2 < 0) {
            Y2 = property.length();
        }
        String substring = property.substring(0, Y);
        b41.h(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        String substring2 = property.substring(i, Y2);
        b41.h(substring2, "this as java.lang.String…ing(startIndex, endIndex)");
        try {
            return (Integer.parseInt(substring) * 65536) + Integer.parseInt(substring2);
        } catch (NumberFormatException unused2) {
            return 65542;
        }
    }
}
