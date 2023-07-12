package tb;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class sz {
    public static final int TYPE_ADD = 1;
    public static final int TYPE_DIV = 4;
    public static final int TYPE_MOD = 5;
    public static final int TYPE_MUL = 3;
    public static final int TYPE_SUB = 2;
    public static long a;

    public static Object a(Object[] objArr, int i) {
        double doubleValue;
        long longValue;
        if (objArr != null) {
            try {
                if (objArr.length != 0) {
                    int length = objArr.length;
                    long j = 0;
                    boolean z = false;
                    double d = 0.0d;
                    for (int i2 = 0; i2 < length; i2++) {
                        Object obj = objArr[i2];
                        if (obj instanceof String) {
                            String str = (String) obj;
                            if (!z && !uz.b(str)) {
                                longValue = uz.g(str);
                                doubleValue = 0.0d;
                            }
                            doubleValue = uz.e(str);
                            longValue = 0;
                            z = true;
                        } else {
                            if (!z && !uz.c(obj)) {
                                if (!(obj instanceof Integer) && !(obj instanceof Long)) {
                                    longValue = a;
                                    doubleValue = 0.0d;
                                }
                                longValue = ((Number) obj).longValue();
                                doubleValue = 0.0d;
                            }
                            doubleValue = ((Number) obj).doubleValue();
                            longValue = 0;
                            z = true;
                        }
                        if (z) {
                            if (j != 0) {
                                d = j;
                                j = 0;
                            }
                            if (i2 == 0) {
                                d = doubleValue;
                            } else if (i == 1) {
                                d += doubleValue;
                            } else if (i == 2) {
                                d -= doubleValue;
                            } else if (i == 3) {
                                d *= doubleValue;
                            } else if (i != 4) {
                                if (i == 5) {
                                    if (doubleValue == 0.0d) {
                                        return Long.valueOf(a);
                                    }
                                    d %= doubleValue;
                                }
                            } else if (doubleValue == 0.0d) {
                                return Long.valueOf(a);
                            } else {
                                d /= doubleValue;
                            }
                        } else if (i2 == 0) {
                            j = longValue;
                        } else if (i == 1) {
                            j += longValue;
                        } else if (i == 2) {
                            j -= longValue;
                        } else if (i == 3) {
                            j *= longValue;
                        } else if (i != 4) {
                            if (i == 5) {
                                if (longValue == 0) {
                                    return Long.valueOf(a);
                                }
                                j %= longValue;
                            }
                        } else if (longValue == 0) {
                            return Long.valueOf(a);
                        } else {
                            j /= longValue;
                        }
                        if (z && (d == Double.POSITIVE_INFINITY || d == Double.NEGATIVE_INFINITY || Double.NaN == d)) {
                            return Double.valueOf(0.0d);
                        }
                    }
                    if (z) {
                        return Double.valueOf(d);
                    }
                    return Long.valueOf(j);
                }
            } catch (Throwable unused) {
                return Long.valueOf(a);
            }
        }
        return Long.valueOf(a);
    }
}
