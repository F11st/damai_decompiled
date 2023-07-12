package tb;

import android.content.Context;
import android.content.res.Configuration;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.taobao.android.dinamicx.DinamicXEngine;
import com.taobao.android.dinamicx.widget.DXTextViewWidgetNode;
import com.taobao.android.dinamicx.widget.DXWidgetNode;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class z00 {
    public static int a;
    private static boolean e;
    private static int f;
    public static final int DEFAULT_HEIGHT_SPEC = DXWidgetNode.DXMeasureSpec.c(8388607, 0);
    private static int b = -1;
    private static float c = -1.0f;
    private static Map<String, Integer> d = new ConcurrentHashMap();

    public static void a(int i) {
        if (e) {
            return;
        }
        f = i;
        e = true;
    }

    public static int b(Context context, float f2) {
        return Math.round(k(context) * (f2 / 375.0f));
    }

    public static int c(Context context, float f2) {
        return Math.round(f2 * h(context));
    }

    public static void d(boolean z) {
        int i = b;
        if (DinamicXEngine.i() != null) {
            if (i != l(DinamicXEngine.i(), true) || z) {
                g(true);
                i(DinamicXEngine.i(), true);
                d.clear();
                DXTextViewWidgetNode.d();
            }
        }
    }

    public static int e() {
        return DEFAULT_HEIGHT_SPEC;
    }

    public static int f() {
        return g(false);
    }

    static int g(boolean z) {
        if ((a == 0 || z) && DinamicXEngine.i() != null) {
            a = DXWidgetNode.DXMeasureSpec.c(k(DinamicXEngine.i()), 1073741824);
        }
        return a;
    }

    public static float h(Context context) {
        return i(context, false);
    }

    static float i(Context context, boolean z) {
        if (c < 0.0f || z) {
            c = context.getResources().getDisplayMetrics().density;
        }
        return c;
    }

    public static int j(Context context, String str, int i) {
        int b2;
        if (TextUtils.isEmpty(str)) {
            if (DinamicXEngine.x()) {
                nz.b(nz.TAG, "size属性为空字符串");
            }
            return i;
        } else if (d.containsKey(str)) {
            return d.get(str).intValue();
        } else {
            try {
                if (str.contains(d90.DIMEN_SUFFIX_NP)) {
                    b2 = c(context, Float.valueOf(Float.parseFloat(str.replace(d90.DIMEN_SUFFIX_NP, ""))).floatValue());
                } else if (str.contains("ap")) {
                    b2 = b(context, Float.valueOf(Float.parseFloat(str.replace("ap", ""))).floatValue());
                } else {
                    b2 = b(context, Float.parseFloat(str));
                }
                i = b2;
                d.put(str, Integer.valueOf(i));
                return i;
            } catch (NumberFormatException unused) {
                if (DinamicXEngine.x()) {
                    nz.u(nz.TAG, str, "写法错误，解析出错");
                    return i;
                }
                return i;
            }
        }
    }

    public static int k(Context context) {
        return l(context, false);
    }

    static int l(Context context, boolean z) {
        int i;
        if (b < 0 || z) {
            if (context == null || context.getResources() == null) {
                return 0;
            }
            Configuration configuration = context.getResources().getConfiguration();
            DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
            if (displayMetrics == null) {
                return 0;
            }
            if (!e || (i = f) == 3) {
                if (configuration != null && configuration.orientation == 1) {
                    b = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
                } else if (configuration != null && configuration.orientation == 2) {
                    b = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
                } else {
                    b = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
                }
            } else if (i == 1) {
                b = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            } else if (i == 2) {
                b = Math.max(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics), com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics));
            }
        }
        return b;
    }

    public static int m(Context context, float f2) {
        return Math.round((f2 * 375.0f) / k(context));
    }
}
