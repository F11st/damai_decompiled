package tb;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.alibaba.pictures.responsive.IConfig;
import com.alibaba.pictures.responsive.ResponsiveManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import io.flutter.wpkbridge.WPKFactory;
import java.util.Objects;
import kotlin.jvm.JvmStatic;
import kotlin.text.StringsKt__StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class c80 {
    private static transient /* synthetic */ IpChange $ipChange;
    @NotNull
    public static final c80 INSTANCE = new c80();
    private static int a = -1;
    private static int b = -1;
    private static int c = -1;
    private static int d = -1;

    private c80() {
    }

    private final wt2 a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "447252594")) {
            return (wt2) ipChange.ipc$dispatch("447252594", new Object[]{this});
        }
        if (d != -1) {
            return wt2.INSTANCE;
        }
        d = j() ? 1 : 0;
        return wt2.INSTANCE;
    }

    @JvmStatic
    public static final boolean g(@NotNull Context context) {
        IConfig b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1767977699")) {
            return ((Boolean) ipChange.ipc$dispatch("1767977699", new Object[]{context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (a == -1) {
            a = (INSTANCE.h(context) || ((b2 = ResponsiveManager.Companion.a().b()) != null && b2.hitFold())) ? 1 : 0;
        }
        return a == 1;
    }

    private final boolean h(Context context) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "815992592") ? ((Boolean) ipChange.ipc$dispatch("815992592", new Object[]{this, context})).booleanValue() : k(context) || i(context) || t(context) || v() || n(context) || m() || u(context);
    }

    private final boolean i(Context context) {
        boolean q;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1436284401")) {
            return ((Boolean) ipChange.ipc$dispatch("-1436284401", new Object[]{this, context})).booleanValue();
        }
        q = kotlin.text.o.q("HONOR", Build.getMANUFACTURER(), true);
        return q && context != null && context.getPackageManager() != null && context.getPackageManager().hasSystemFeature("com.hihonor.hardware.sensor.posture");
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        if (r6.equals("RLI-AN00") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x005c, code lost:
        if (r6.equals("RLI-N29") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0065, code lost:
        if (r6.equals("RHA-AN00m") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006e, code lost:
        if (r6.equals("TAH-AN00m") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0077, code lost:
        if (r6.equals("TAH-N29m") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0080, code lost:
        if (r6.equals("TAH-AN00") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0089, code lost:
        if (r6.equals("TAH-N29") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0092, code lost:
        if (r6.equals("RHA-N29m") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x0095, code lost:
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00c6 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final boolean k(android.content.Context r6) {
        /*
            r5 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = tb.c80.$ipChange
            java.lang.String r1 = "1130839314"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1e
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r5
            r2[r4] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1e:
            java.lang.String r0 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER()
            java.lang.String r1 = "HUAWEI"
            boolean r0 = kotlin.text.g.q(r1, r0, r4)
            if (r0 == 0) goto Lc7
            if (r6 == 0) goto L3f
            android.content.pm.PackageManager r0 = r6.getPackageManager()
            if (r0 == 0) goto L3f
            android.content.pm.PackageManager r6 = r6.getPackageManager()
            java.lang.String r0 = "com.huawei.hardware.sensor.posture"
            boolean r6 = r6.hasSystemFeature(r0)
            if (r6 == 0) goto L3f
            return r4
        L3f:
            java.lang.String r6 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()
            if (r6 == 0) goto L96
            int r0 = r6.hashCode()
            switch(r0) {
                case -1737858118: goto L8c;
                case -830296637: goto L83;
                case 30247423: goto L7a;
                case 30608138: goto L71;
                case 937670222: goto L68;
                case 1949791134: goto L5f;
                case 2005507479: goto L56;
                case 2040829099: goto L4d;
                default: goto L4c;
            }
        L4c:
            goto L96
        L4d:
            java.lang.String r0 = "RLI-AN00"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L56:
            java.lang.String r0 = "RLI-N29"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L5f:
            java.lang.String r0 = "RHA-AN00m"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L68:
            java.lang.String r0 = "TAH-AN00m"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L71:
            java.lang.String r0 = "TAH-N29m"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L7a:
            java.lang.String r0 = "TAH-AN00"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L83:
            java.lang.String r0 = "TAH-N29"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L8c:
            java.lang.String r0 = "RHA-N29m"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto L95
            goto L96
        L95:
            return r4
        L96:
            java.lang.String r6 = android.os.Build.DEVICE
            if (r6 == 0) goto Lc7
            int r0 = r6.hashCode()
            switch(r0) {
                case 69168140: goto Lbd;
                case 1160623169: goto Lb4;
                case 1160623301: goto Lab;
                case 2046074562: goto La2;
                default: goto La1;
            }
        La1:
            goto Lc7
        La2:
            java.lang.String r0 = "HWTAH-C"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto Lc6
            goto Lc7
        Lab:
            java.lang.String r0 = "unknownRLI"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto Lc6
            goto Lc7
        Lb4:
            java.lang.String r0 = "unknownRHA"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto Lc6
            goto Lc7
        Lbd:
            java.lang.String r0 = "HWTAH"
            boolean r6 = r6.equals(r0)
            if (r6 != 0) goto Lc6
            goto Lc7
        Lc6:
            return r4
        Lc7:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.c80.k(android.content.Context):boolean");
    }

    private final boolean r(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "608831587")) {
            return ((Boolean) ipChange.ipc$dispatch("608831587", new Object[]{this, context})).booleanValue();
        }
        if (p(context)) {
            double b2 = b(context);
            if (b2 > 0.0d) {
                IConfig b3 = ResponsiveManager.Companion.a().b();
                double d2 = 8.0d;
                if (b3 != null && b3.getPhoneScreenInches() > 0.0d) {
                    d2 = b3.getPhoneScreenInches();
                }
                return b2 >= d2;
            }
        }
        return false;
    }

    private final boolean t(Context context) {
        boolean q;
        boolean F;
        boolean F2;
        boolean F3;
        boolean q2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "665251357")) {
            return ((Boolean) ipChange.ipc$dispatch("665251357", new Object[]{this, context})).booleanValue();
        }
        q = kotlin.text.o.q("samsung", Build.getBRAND(), true);
        if (q) {
            q2 = kotlin.text.o.q("winner", android.os.Build.DEVICE, true);
            if (q2) {
                return true;
            }
        }
        String model = Build.getMODEL();
        if (!TextUtils.isEmpty(model)) {
            b41.h(model, "model");
            F = kotlin.text.o.F(model, "SM-F9", false, 2, null);
            if (!F) {
                F2 = kotlin.text.o.F(model, "SM-W202", false, 2, null);
                if (!F2) {
                    F3 = kotlin.text.o.F(model, "SM-W90", false, 2, null);
                    if (F3) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public final double b(@Nullable Context context) {
        Display defaultDisplay;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-269345178")) {
            return ((Double) ipChange.ipc$dispatch("-269345178", new Object[]{this, context})).doubleValue();
        }
        if (context != null) {
            Object systemService = context.getSystemService(v.ATTACH_MODE_WINDOW);
            WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
            if (windowManager == null || (defaultDisplay = windowManager.getDefaultDisplay()) == null) {
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
        return 0.0d;
    }

    public final boolean c() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-867578428") ? ((Boolean) ipChange.ipc$dispatch("-867578428", new Object[]{this})).booleanValue() : l() || d();
    }

    public final boolean d() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-481463083")) {
            return ((Boolean) ipChange.ipc$dispatch("-481463083", new Object[]{this})).booleanValue();
        }
        if (d == -1) {
            a();
        }
        return d == 1;
    }

    public final boolean e(@Nullable Activity activity) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-275600602")) {
            return ((Boolean) ipChange.ipc$dispatch("-275600602", new Object[]{this, activity})).booleanValue();
        }
        if (activity == null) {
            return false;
        }
        return f(activity.getResources().getConfiguration());
    }

    public final boolean f(@Nullable Configuration configuration) {
        boolean K;
        boolean K2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1356945444")) {
            return ((Boolean) ipChange.ipc$dispatch("1356945444", new Object[]{this, configuration})).booleanValue();
        }
        if (configuration == null) {
            return false;
        }
        String configuration2 = configuration.toString();
        b41.h(configuration2, "configuration.toString()");
        K = StringsKt__StringsKt.K(configuration2, "hwMultiwindow-magic", false, 2, null);
        if (K) {
            return true;
        }
        K2 = StringsKt__StringsKt.K(configuration2, "hw-magic-windows", false, 2, null);
        return K2;
    }

    public final boolean j() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1820360755")) {
            return ((Boolean) ipChange.ipc$dispatch("1820360755", new Object[]{this})).booleanValue();
        }
        try {
            Class<?> cls = Class.forName("com.youku.phone.BuildConfig");
            Object obj = cls.getDeclaredField("multiAppType").get(cls);
            if (obj != null) {
                return TextUtils.equals((String) obj, "hw-car");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return false;
        }
    }

    public final boolean l() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-416363308") ? ((Boolean) ipChange.ipc$dispatch("-416363308", new Object[]{this})).booleanValue() : c == 1;
    }

    public final boolean m() {
        boolean q;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1212154795")) {
            return ((Boolean) ipChange.ipc$dispatch("1212154795", new Object[]{this})).booleanValue();
        }
        q = kotlin.text.o.q("oppo", Build.getMANUFACTURER(), true);
        if (q) {
            try {
                Class<?> cls = Class.forName("com.oplus.content.OplusFeatureConfigManager");
                Object invoke = cls.getDeclaredMethod("hasFeature", String.class).invoke(cls.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]), "oplus.hardware.type.fold");
                if (invoke instanceof Boolean) {
                    return ((Boolean) invoke).booleanValue();
                }
                return false;
            } catch (Throwable unused) {
                return false;
            }
        }
        return false;
    }

    public final boolean n(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1679599395")) {
            return ((Boolean) ipChange.ipc$dispatch("1679599395", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        int identifier = context.getResources().getIdentifier("config_lidControlsDisplayFold", "bool", "android");
        if (identifier > 0) {
            return context.getResources().getBoolean(identifier);
        }
        return false;
    }

    public final boolean o(@NotNull Context context) {
        IConfig b2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "579297867")) {
            return ((Boolean) ipChange.ipc$dispatch("579297867", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        if (b == -1) {
            boolean s = s();
            if (!s) {
                s = q(context);
            }
            if (!s) {
                s = r(context);
            }
            if (s && g(context)) {
                s = false;
            }
            b = (s || ((b2 = ResponsiveManager.Companion.a().b()) != null && b2.hitPad())) ? 1 : 0;
        }
        return b == 1;
    }

    public final boolean p(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-189615141")) {
            return ((Boolean) ipChange.ipc$dispatch("-189615141", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        IConfig b2 = ResponsiveManager.Companion.a().b();
        return !(b2 == null || b2.isUsePadOpt()) || (context.getResources().getConfiguration().screenLayout & 15) >= 3;
    }

    public final boolean q(@NotNull Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "238039220")) {
            return ((Boolean) ipChange.ipc$dispatch("238039220", new Object[]{this, context})).booleanValue();
        }
        b41.i(context, WPKFactory.INIT_KEY_CONTEXT);
        IConfig b2 = ResponsiveManager.Companion.a().b();
        if (b2 == null || b2.isUsePadOpt()) {
            Object systemService = context.getSystemService("phone");
            Objects.requireNonNull(systemService, "null cannot be cast to non-null type android.telephony.TelephonyManager");
            return ((TelephonyManager) systemService).getPhoneType() == 0;
        }
        return false;
    }

    public final boolean s() {
        boolean q;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-533207124")) {
            return ((Boolean) ipChange.ipc$dispatch("-533207124", new Object[]{this})).booleanValue();
        }
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            Object invoke = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "ro.build.characteristics");
            String str = invoke instanceof String ? (String) invoke : null;
            if (str != null) {
                q = kotlin.text.o.q(str, "tablet", true);
                return q;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public final boolean u(@Nullable Context context) {
        boolean q;
        boolean q2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-902589649")) {
            return ((Boolean) ipChange.ipc$dispatch("-902589649", new Object[]{this, context})).booleanValue();
        }
        q = kotlin.text.o.q("vivo", Build.getMANUFACTURER(), true);
        if (q) {
            try {
                Class<?> cls = Class.forName("android.util.FtDeviceInfo");
                Object invoke = cls.getMethod("getDeviceType", new Class[0]).invoke(cls, new Object[0]);
                String str = invoke instanceof String ? (String) invoke : null;
                if (str != null) {
                    q2 = kotlin.text.o.q(str, "foldable", true);
                    if (q2) {
                        return true;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    public final boolean v() {
        boolean q;
        boolean q2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1451410258")) {
            return ((Boolean) ipChange.ipc$dispatch("1451410258", new Object[]{this})).booleanValue();
        }
        q = kotlin.text.o.q("Xiaomi", Build.getMANUFACTURER(), true);
        if (q) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                Object invoke = cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(cls, "persist.sys.muiltdisplay_type");
                String str = invoke instanceof String ? (String) invoke : null;
                if (str != null) {
                    q2 = kotlin.text.o.q(str, "2", true);
                    return q2;
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
