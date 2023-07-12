package tb;

import android.text.TextUtils;
import java.math.BigDecimal;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class uz {
    public static boolean a(Number number, Number number2) {
        return number.doubleValue() == number2.doubleValue();
    }

    public static boolean b(String str) {
        return (TextUtils.isEmpty(str) || str.indexOf(".") == -1) ? false : true;
    }

    public static boolean c(Object obj) {
        return (obj instanceof Double) || (obj instanceof Float) || (obj instanceof BigDecimal);
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0025, code lost:
        if (((com.alibaba.fastjson.JSONArray) r3).size() > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:15:0x0027, code lost:
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0034, code lost:
        if (((com.alibaba.fastjson.JSONObject) r3).size() > 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0041, code lost:
        if (((java.lang.Number) r3).intValue() != 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:?, code lost:
        return r0;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean d(java.lang.Object r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            boolean r1 = r3 instanceof java.lang.Boolean
            r2 = 1
            if (r1 == 0) goto L10
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r2 = r3.booleanValue()
            goto L44
        L10:
            boolean r1 = r3 instanceof java.lang.String
            if (r1 == 0) goto L1b
            java.lang.String r3 = (java.lang.String) r3
            boolean r2 = i(r3)
            goto L44
        L1b:
            boolean r1 = r3 instanceof com.alibaba.fastjson.JSONArray
            if (r1 == 0) goto L2a
            com.alibaba.fastjson.JSONArray r3 = (com.alibaba.fastjson.JSONArray) r3
            int r3 = r3.size()
            if (r3 <= 0) goto L28
        L27:
            r0 = 1
        L28:
            r2 = r0
            goto L44
        L2a:
            boolean r1 = r3 instanceof com.alibaba.fastjson.JSONObject
            if (r1 == 0) goto L37
            com.alibaba.fastjson.JSONObject r3 = (com.alibaba.fastjson.JSONObject) r3
            int r3 = r3.size()
            if (r3 <= 0) goto L28
            goto L27
        L37:
            boolean r1 = r3 instanceof java.lang.Number
            if (r1 == 0) goto L44
            java.lang.Number r3 = (java.lang.Number) r3
            int r3 = r3.intValue()
            if (r3 == 0) goto L28
            goto L27
        L44:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.uz.d(java.lang.Object):boolean");
    }

    public static double e(String str) {
        try {
            return Double.parseDouble(str);
        } catch (Throwable unused) {
            return 0.0d;
        }
    }

    public static int f(String str) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    public static long g(String str) {
        try {
            return Long.parseLong(str);
        } catch (Throwable unused) {
            return 0L;
        }
    }

    public static Number h(Object obj) {
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            String str = (String) obj;
            if (b(str)) {
                return Double.valueOf(e(str));
            }
            return Long.valueOf(g(str));
        } else if (c(obj)) {
            return Double.valueOf(((Number) obj).doubleValue());
        } else {
            if (!(obj instanceof Integer) && !(obj instanceof Long)) {
                return 0L;
            }
            return Long.valueOf(((Number) obj).longValue());
        }
    }

    private static boolean i(String str) {
        return (str == null || str.equals("false") || str.equalsIgnoreCase("0") || str.isEmpty()) ? false : true;
    }
}
