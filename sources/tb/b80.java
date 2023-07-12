package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.responsive.IConfig;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class b80 {
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;

    public static void a() {
        if (d != -1) {
            return;
        }
        d = i() ? 1 : 0;
    }

    public static double b(Context context) {
        WindowManager windowManager;
        Display defaultDisplay;
        if (context == null || (windowManager = (WindowManager) context.getSystemService(C9796v.ATTACH_MODE_WINDOW)) == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
            return 0.0d;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getMetrics(defaultDisplay, displayMetrics);
        float f = displayMetrics.xdpi;
        if (f <= 0.0f || displayMetrics.ydpi <= 0.0f) {
            return 0.0d;
        }
        return Math.sqrt(Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics) / f, 2.0d) + Math.pow(com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics) / displayMetrics.ydpi, 2.0d));
    }

    public static boolean c() {
        return k() || d();
    }

    public static boolean d() {
        if (d == -1) {
            a();
        }
        return d == 1;
    }

    public static boolean e(Activity activity) {
        if (activity == null) {
            return false;
        }
        return f(activity.getResources().getConfiguration());
    }

    public static boolean f(Configuration configuration) {
        if (configuration == null) {
            return false;
        }
        String configuration2 = configuration.toString();
        return configuration2.contains("hwMultiwindow-magic") || configuration2.contains("hw-magic-windows");
    }

    public static boolean g(Context context) {
        if (a == -1) {
            if (!h(context)) {
                IConfig a2 = v22.c().a();
                if (a2 != null && a2.hitFold()) {
                    a = 1;
                } else {
                    a = 0;
                }
            } else {
                a = 1;
            }
        }
        return a == 1;
    }

    private static boolean h(Context context) {
        return j(context) || r(context) || t() || l(context) || s(context);
    }

    public static boolean i() {
        try {
            Class<?> cls = Class.forName("com.youku.phone.BuildConfig");
            return TextUtils.equals((String) cls.getDeclaredField("multiAppType").get(cls), "hw-car");
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00a4, code lost:
        if (r6.equals("HWTAH-C") == false) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean j(android.content.Context r6) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.b80.j(android.content.Context):boolean");
    }

    public static boolean k() {
        return c == 1;
    }

    public static boolean l(Context context) {
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0) {
            return context.getResources().getBoolean(identifier);
        }
        return false;
    }

    public static boolean m(Context context) {
        if (b == -1) {
            boolean q = q();
            if (!q) {
                q = o(context);
            }
            if (!q) {
                q = p(context);
            }
            if (q && g(context)) {
                q = false;
            }
            if (!q) {
                IConfig a2 = v22.c().a();
                if (a2 != null && a2.hitPad()) {
                    b = 1;
                } else {
                    b = 0;
                }
            } else {
                b = 1;
            }
        }
        return b == 1;
    }

    public static boolean n(Context context) {
        IConfig a2 = v22.c().a();
        return !(a2 == null || a2.isUsePadOpt()) || (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public static boolean o(Context context) {
        IConfig a2 = v22.c().a();
        return (a2 == null || a2.isUsePadOpt()) && ((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0;
    }

    private static boolean p(Context context) {
        if (n(context)) {
            double b2 = b(context);
            if (b2 > 0.0d) {
                IConfig a2 = v22.c().a();
                double d2 = 8.0d;
                if (a2 != null && a2.getPhoneScreenInches() > 0.0d) {
                    d2 = a2.getPhoneScreenInches();
                }
                return b2 >= d2;
            }
            return false;
        }
        return false;
    }

    public static boolean q() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.build.characteristics");
            if (str != null) {
                return str.equalsIgnoreCase("tablet");
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private static boolean r(Context context) {
        if ("samsung".equalsIgnoreCase(Build.getBRAND()) && "winner".equalsIgnoreCase(android.os.Build.DEVICE)) {
            return true;
        }
        String model = Build.getMODEL();
        if (TextUtils.isEmpty(model)) {
            return false;
        }
        return model.startsWith("SM-F9") || model.startsWith("SM-W202");
    }

    public static boolean s(Context context) {
        if ("vivo".equalsIgnoreCase(Build.getMANUFACTURER())) {
            try {
                Class<?> cls = Class.forName("android.util.FtDeviceInfo");
                String str = (String) cls.getMethod("getDeviceType", String.class).invoke(cls, new Object[0]);
                if (str != null) {
                    return str.equalsIgnoreCase("foldable");
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }

    public static boolean t() {
        if ("Xiaomi".equalsIgnoreCase(Build.getMANUFACTURER())) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                String str = (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "persist.sys.muiltdisplay_type");
                if (str != null) {
                    return str.equalsIgnoreCase("2");
                }
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
        return false;
    }
}
