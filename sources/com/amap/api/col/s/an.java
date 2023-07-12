package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class an {
    static dl a;

    public static void a(Context context, String str, long j, boolean z) {
        try {
            String a2 = a(str, j, z);
            if (a2 != null && a2.length() > 0) {
                if (a == null) {
                    a = new dl(context, "sea", "9.2.0", "O002");
                }
                a.a(a2);
                dm.a(a, context);
            }
        } catch (Throwable th) {
            C4435i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, long j, boolean z) {
        try {
            return jn1.BLOCK_START_STR + "\"RequestPath\":\"" + str + "\",\"ResponseTime\":" + j + ",\"Success\":" + z + "}";
        } catch (Throwable th) {
            C4435i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }

    public static void a(String str, String str2, AMapException aMapException) {
        if (str != null) {
            String errorType = aMapException.getErrorType();
            String a2 = a(aMapException);
            if (a2 == null || a2.length() <= 0) {
                return;
            }
            cl.a(C4434h.a(true), str, errorType, str2, a2);
        }
    }

    private static String a(AMapException aMapException) {
        if (aMapException != null) {
            if (aMapException.getErrorLevel() == 0) {
                int errorCode = aMapException.getErrorCode();
                if (errorCode == 0) {
                    return "4";
                }
                int pow = (int) Math.pow(10.0d, Math.floor(Math.log10(errorCode)));
                return String.valueOf((errorCode % pow) + (pow * 4));
            }
            StringBuilder sb = new StringBuilder();
            sb.append(aMapException.getErrorCode());
            return sb.toString();
        }
        return null;
    }

    public static void a(Context context, String str, boolean z) {
        try {
            String a2 = a(str, z);
            if (a2 != null && a2.length() > 0) {
                dl dlVar = new dl(context, "sea", "9.2.0", "O006");
                dlVar.a(a2);
                dm.a(dlVar, context);
            }
        } catch (Throwable th) {
            C4435i.a(th, "StatisticsUtil", "recordResponseAction");
        }
    }

    private static String a(String str, boolean z) {
        String str2;
        try {
            str2 = "";
            int indexOf = str.indexOf("?");
            int length = str.length();
            if (indexOf > 0) {
                String substring = str.substring(0, indexOf);
                int i = indexOf + 1;
                str2 = i < length ? str.substring(i) : "";
                str = substring;
            }
            return jn1.BLOCK_START_STR + "\"RequestPath\":\"" + str + "\",\"RequestParm\":\"" + str2 + "\",\"IsCacheRequest\":" + z + "}";
        } catch (Throwable th) {
            C4435i.a(th, "StatisticsUtil", "generateNetWorkResponseStatisticsEntity");
            return null;
        }
    }
}
