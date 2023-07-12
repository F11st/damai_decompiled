package tb;

import android.text.TextUtils;
import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.taobao.android.dinamicx.DinamicXEngine;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class nz {
    public static final String TAG = "DinamicX";
    public static final String TAG_BASELINE = "DinamicX_Baseline";
    public static final String TAG_SCRIPT_EXPR = "DinamicX_ScriptExpr";
    public static boolean a;

    public static void a(String str) {
        if (a || DinamicXEngine.x()) {
            Log.d(TAG, k(str));
        }
    }

    public static void b(String str, String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.d(str, k(strArr));
        }
    }

    public static void c(String str) {
        if (a || DinamicXEngine.x()) {
            Log.e(TAG, k(str));
        }
    }

    public static void d(String str, String str2, Throwable th) {
        if (a || DinamicXEngine.x()) {
            Log.e(str, str2, th);
        }
    }

    public static void e(String str, Throwable th, String... strArr) {
        Log.e(str, k(strArr), th);
    }

    public static void f(String str, Object... objArr) {
        if (a || DinamicXEngine.x()) {
            String j = j(objArr);
            if (TextUtils.isEmpty(str)) {
                Log.e(TAG, j);
            } else {
                Log.e(str, j);
            }
        }
    }

    public static void g(String str, String... strArr) {
        if (a || DinamicXEngine.x()) {
            String k = k(strArr);
            if (TextUtils.isEmpty(str)) {
                Log.e(TAG, k);
            } else {
                Log.e(str, k);
            }
        }
    }

    public static void h(String str) {
        if (a || DinamicXEngine.x()) {
            Log.e(TAG_SCRIPT_EXPR, k(str));
        }
    }

    public static void i(String str, String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.i(str, k(strArr));
        }
    }

    private static String j(Object... objArr) {
        if (objArr == null || objArr.length == 0) {
            return "";
        }
        if (objArr.length == 1) {
            return JSON.toJSONString(objArr[0]);
        }
        StringBuilder sb = new StringBuilder();
        for (Object obj : objArr) {
            sb.append(JSON.toJSONString(obj));
            sb.append(" ");
        }
        return sb.toString();
    }

    private static String k(String... strArr) {
        if (strArr == null || strArr.length == 0) {
            return "";
        }
        if (strArr.length == 1) {
            return strArr[0];
        }
        StringBuilder sb = new StringBuilder();
        for (String str : strArr) {
            sb.append(str);
        }
        return sb.toString();
    }

    public static void l(String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.d(TAG_BASELINE, k(strArr));
        }
    }

    public static void m(String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.d("DXAnimationProcess", k(strArr));
        }
    }

    public static void n(String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.d("DXAnimationUpdate", k(strArr));
        }
    }

    public static void o(String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.e("DXAnimationProcess", k(strArr));
        }
    }

    public static void p(String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            return;
        }
        if (str2.length() <= 3072) {
            Log.e(str, str2);
            return;
        }
        while (str2.length() > 3072) {
            String substring = str2.substring(0, 3072);
            str2 = str2.replace(substring, "");
            Log.e(str, substring);
        }
        Log.e(str, str2);
    }

    public static void q(Object... objArr) {
        if (DinamicXEngine.x() || a) {
            p("DinamicX_perform", TextUtils.join(" ", objArr));
        }
    }

    public static void r(String str, String str2) {
        if (DinamicXEngine.x() || a) {
            if (!TextUtils.isEmpty(str)) {
                Log.i("DinamicX_perform_" + str, str2);
                return;
            }
            Log.i("DinamicX_perform", str2);
        }
    }

    public static void s(String str) {
        if (a || DinamicXEngine.x()) {
            b(TAG, str);
        }
    }

    public static void t(String str) {
        if (a || DinamicXEngine.x()) {
            g(TAG, str);
        }
    }

    public static void u(String str, String... strArr) {
        if (a || DinamicXEngine.x()) {
            Log.w(str, k(strArr));
        }
    }
}
