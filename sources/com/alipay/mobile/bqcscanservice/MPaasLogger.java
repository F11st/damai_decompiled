package com.alipay.mobile.bqcscanservice;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class MPaasLogger {
    private static volatile BqcLogger a;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface BqcLogger {
        boolean checkStringBuilderValid(StringBuilder sb);

        void d(String str, StringBuilder sb);

        void e(String str, StringBuilder sb);

        void e(String str, StringBuilder sb, Throwable th);

        StringBuilder getLocalStringBuilder();

        void i(String str, StringBuilder sb);

        boolean isDebuggable();

        void v(String str, StringBuilder sb);

        void w(String str, StringBuilder sb);
    }

    public static void a(char c, String str, Object[] objArr) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        a(c, str, g);
    }

    private static void b(String str, StringBuilder sb) {
        if (a != null) {
            try {
                if (a.checkStringBuilderValid(sb)) {
                    a.d(str, sb);
                }
            } catch (Exception unused) {
            }
        }
    }

    private static void c(String str, StringBuilder sb) {
        if (a != null) {
            try {
                if (a.checkStringBuilderValid(sb)) {
                    a.e(str, sb);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void d(String str, Object[] objArr) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        b(str, g);
    }

    public static void e(String str, Object[] objArr) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        c(str, g);
    }

    private static void f(String str, StringBuilder sb) {
        if (a != null) {
            try {
                if (a.checkStringBuilderValid(sb)) {
                    a.i(str, sb);
                }
            } catch (Exception unused) {
            }
        }
    }

    private static StringBuilder g(Object[] objArr) {
        try {
            StringBuilder localStringBuilder = getLocalStringBuilder();
            if (localStringBuilder != null) {
                for (Object obj : objArr) {
                    if (obj instanceof CharSequence) {
                        localStringBuilder.append((CharSequence) obj);
                    } else if (obj instanceof Integer) {
                        localStringBuilder.append(((Integer) obj).intValue());
                    } else if (obj instanceof Long) {
                        localStringBuilder.append(((Long) obj).longValue());
                    } else if (obj instanceof Float) {
                        localStringBuilder.append(((Float) obj).floatValue());
                    } else if (obj instanceof Double) {
                        localStringBuilder.append(((Double) obj).doubleValue());
                    } else if (obj instanceof Boolean) {
                        localStringBuilder.append(((Boolean) obj).booleanValue());
                    }
                }
            }
            return localStringBuilder;
        } catch (Exception unused) {
            return null;
        }
    }

    public static StringBuilder getLocalStringBuilder() {
        if (a != null) {
            try {
                return a.getLocalStringBuilder();
            } catch (Exception unused) {
            }
        }
        return null;
    }

    private static void h(String str, StringBuilder sb) {
        if (a != null) {
            try {
                if (a.checkStringBuilderValid(sb)) {
                    a.w(str, sb);
                }
            } catch (Exception unused) {
            }
        }
    }

    public static void i(String str, Object[] objArr) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        f(str, g);
    }

    public static boolean isDebuggable() {
        if (a != null) {
            try {
                return a.isDebuggable();
            } catch (Exception unused) {
                return false;
            }
        }
        return false;
    }

    public static void registerBqcLogger(BqcLogger bqcLogger) {
        a = bqcLogger;
    }

    public static void unRegisterBqcLogger() {
        a = null;
    }

    public static void w(String str, Object[] objArr) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        h(str, g);
    }

    public static void a(char c, String str, StringBuilder sb) {
        if (c == 'd') {
            b(str, sb);
        } else if (c == 'e') {
            c(str, sb);
        }
    }

    public static void e(String str, Object[] objArr, Throwable th) {
        StringBuilder g;
        if (objArr == null || objArr.length == 0 || (g = g(objArr)) == null) {
            return;
        }
        e(str, g, th);
    }

    private static void e(String str, StringBuilder sb, Throwable th) {
        if (a != null) {
            try {
                if (a.checkStringBuilderValid(sb)) {
                    a.e(str, sb, th);
                }
            } catch (Exception unused) {
            }
        }
    }
}
