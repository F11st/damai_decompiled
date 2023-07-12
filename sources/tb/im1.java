package tb;

import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class im1 {
    public static boolean a(Object obj) {
        if ((obj instanceof Float) || (obj instanceof Double)) {
            return true;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            return (str.indexOf(46) == -1 && str.indexOf(101) == -1 && str.indexOf(69) == -1) ? false : true;
        }
        return false;
    }

    public static boolean b(String str) {
        return (str == null || str.equals("false") || str.equalsIgnoreCase("0") || str.isEmpty()) ? false : true;
    }

    public static BigDecimal c(Object obj) {
        if (obj instanceof BigDecimal) {
            return (BigDecimal) obj;
        }
        if (obj != null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if ("".equals(str.trim())) {
                    return BigDecimal.valueOf(0L);
                }
                return new BigDecimal(str);
            } else if (obj instanceof Number) {
                return new BigDecimal(obj.toString());
            } else {
                if (obj instanceof Character) {
                    return new BigDecimal((int) ((Character) obj).charValue());
                }
                return null;
            }
        }
        throw new IllegalArgumentException("BigDecimal coercion exception. arg is null");
    }

    public static double d(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                String str = (String) obj;
                if ("".equals(str.trim())) {
                    return 0.0d;
                }
                return Double.parseDouble(str);
            } else if (obj instanceof Character) {
                return ((Character) obj).charValue();
            } else {
                if (obj instanceof Number) {
                    return d(obj);
                }
                if (obj instanceof Boolean) {
                    throw new IllegalArgumentException("Boolean->Double coercion exception");
                }
            }
        }
        return 0.0d;
    }

    public static int e(Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                if ("".equals(obj)) {
                    return 0;
                }
                return Integer.parseInt((String) obj);
            } else if (obj instanceof Character) {
                return ((Character) obj).charValue();
            } else {
                if (!(obj instanceof Boolean)) {
                    if (obj instanceof Number) {
                        return ((Number) obj).intValue();
                    }
                } else {
                    throw new IllegalArgumentException("Boolean->Integer coercion exception");
                }
            }
        }
        return 0;
    }

    public static long f(Object obj) {
        if (obj == null) {
            return 0L;
        }
        if (obj instanceof String) {
            if ("".equals(obj)) {
                return 0L;
            }
            return Long.parseLong((String) obj);
        } else if (obj instanceof Character) {
            return ((Character) obj).charValue();
        } else {
            if (!(obj instanceof Boolean) && (obj instanceof Number)) {
                return ((Number) obj).longValue();
            }
            return 0L;
        }
    }
}
