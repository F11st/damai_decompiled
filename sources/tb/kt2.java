package tb;

import android.text.TextUtils;
import com.alibaba.android.umbrella.trace.UmbrellaInfo;
import com.taobao.orange.OrangeConfig;
import com.taobao.orange.OrangeConfigListenerV1;
import com.taobao.weex.annotation.JSMethod;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class kt2 {
    public static final double DEFAULT_FAIL_SAMPLE_RATING = 1.0d;
    public static final double DEFAULT_PERFORMANCE_SAMPLE_RATING = 0.005d;
    public static final double DEFAULT_SUCCESS_SAMPLE_RATING = 5.0E-5d;
    public static final String FORCE_CLOSE_FAILURE_KEY = "ForceCloseFailure";
    public static final String FORCE_CLOSE_PERFORMANCE_PAGE_KEY = "ForceClosePerformancePage";
    public static final String FORCE_CLOSE_PERFORMANCE_POINT_KEY = "ForceClosePerformancePoint";
    public static final String FORCE_CLOSE_SUCCESS_KEY = "ForceCloseSuccess";
    public static final String OPEN_CRASH_REPORT_KEY = "isPointReportToCrash";
    public static final String OPEN_GRAY_REPORT_KEY = "isGrayReport";
    public static final String ORANGE_GROUP_NAME = "umbrella_trace";
    private static HashMap<String, Double> a = new HashMap<>();
    private static HashMap<String, Double> b = new HashMap<>();
    private static HashMap<String, Double> c = new HashMap<>();
    private static boolean d = false;
    private static boolean e = false;
    private static boolean f = false;
    private static boolean g = false;
    private static boolean h = true;
    private static boolean i = false;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: tb.kt2$a */
    /* loaded from: classes6.dex */
    public static class C9378a implements OrangeConfigListenerV1 {
        C9378a() {
        }

        @Override // com.taobao.orange.OrangeConfigListenerV1
        public void onConfigUpdate(String str, boolean z) {
            if (kt2.ORANGE_GROUP_NAME.equals(str)) {
                for (String str2 : kt2.a.keySet()) {
                    try {
                        kt2.a.put(str2, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(kt2.ORANGE_GROUP_NAME, str2, String.valueOf(5.0E-5d)))));
                    } catch (NumberFormatException unused) {
                        kt2.a.put(str2, Double.valueOf(5.0E-5d));
                    }
                }
                for (String str3 : kt2.b.keySet()) {
                    try {
                        kt2.b.put(str3, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(kt2.ORANGE_GROUP_NAME, str3, String.valueOf(1.0d)))));
                    } catch (NumberFormatException unused2) {
                        kt2.b.put(str3, Double.valueOf(1.0d));
                    }
                }
                for (String str4 : kt2.c.keySet()) {
                    try {
                        kt2.b.put(str4, Double.valueOf(Double.parseDouble(OrangeConfig.getInstance().getConfig(kt2.ORANGE_GROUP_NAME, str4, String.valueOf(0.005d)))));
                    } catch (NumberFormatException unused3) {
                        kt2.b.put(str4, Double.valueOf(0.005d));
                    }
                }
                boolean unused4 = kt2.d = kt2.n(kt2.FORCE_CLOSE_SUCCESS_KEY);
                boolean unused5 = kt2.e = kt2.n(kt2.FORCE_CLOSE_FAILURE_KEY);
                boolean unused6 = kt2.f = kt2.n(kt2.FORCE_CLOSE_PERFORMANCE_POINT_KEY);
                boolean unused7 = kt2.g = kt2.n(kt2.FORCE_CLOSE_PERFORMANCE_PAGE_KEY);
                kt2.k(kt2.l());
                boolean unused8 = kt2.h = kt2.d();
            }
        }
    }

    static {
        x();
    }

    public static boolean A() {
        return f;
    }

    public static boolean B() {
        return d;
    }

    private static boolean C() {
        return false;
    }

    public static boolean D() {
        return h;
    }

    static /* synthetic */ boolean d() {
        return q();
    }

    static /* synthetic */ boolean k(boolean z) {
        return z;
    }

    static /* synthetic */ boolean l() {
        return p();
    }

    public static boolean m(UmbrellaInfo umbrellaInfo, String str) {
        if (umbrellaInfo != null && !TextUtils.isEmpty(umbrellaInfo.mainBizName) && !TextUtils.isEmpty(str)) {
            if (r(umbrellaInfo.mainBizName + '_' + str) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean n(String str) {
        return !TextUtils.isEmpty(str) && "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, "false"));
    }

    public static boolean o() {
        return i;
    }

    private static boolean p() {
        return "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, OPEN_CRASH_REPORT_KEY, "true"));
    }

    private static boolean q() {
        return "true".equals(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, OPEN_GRAY_REPORT_KEY, "true"));
    }

    public static double r(String str) {
        if (TextUtils.isEmpty(str)) {
            return 1.0d;
        }
        Double d2 = b.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(1.0d)));
            b.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            b.put(str, Double.valueOf(1.0d));
            return 1.0d;
        }
    }

    public static double s(String str) {
        if (TextUtils.isEmpty(str)) {
            return 5.0E-5d;
        }
        Double d2 = a.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(5.0E-5d)));
            a.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            a.put(str, Double.valueOf(5.0E-5d));
            return 5.0E-5d;
        }
    }

    public static double t(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0.005d;
        }
        Double d2 = c.get(str);
        if (d2 != null) {
            return d2.doubleValue();
        }
        try {
            double parseDouble = Double.parseDouble(OrangeConfig.getInstance().getConfig(ORANGE_GROUP_NAME, str, String.valueOf(0.005d)));
            c.put(str, Double.valueOf(parseDouble));
            return parseDouble;
        } catch (NumberFormatException unused) {
            c.put(str, Double.valueOf(0.005d));
            return 0.005d;
        }
    }

    public static boolean u(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Performance_Page_Load_");
        sb.append(str);
        return t(sb.toString()) > Math.random();
    }

    public static boolean v(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            if (t("Performance_" + str + JSMethod.NOT_SET + str2) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    public static boolean w(UmbrellaInfo umbrellaInfo) {
        if (umbrellaInfo != null && !TextUtils.isEmpty(umbrellaInfo.mainBizName) && !TextUtils.isEmpty(umbrellaInfo.tagId)) {
            if (s(umbrellaInfo.mainBizName + '_' + umbrellaInfo.tagId) > Math.random()) {
                return true;
            }
        }
        return false;
    }

    public static void x() {
        d = n(FORCE_CLOSE_SUCCESS_KEY);
        e = n(FORCE_CLOSE_FAILURE_KEY);
        p();
        f = n(FORCE_CLOSE_PERFORMANCE_POINT_KEY);
        g = n(FORCE_CLOSE_PERFORMANCE_PAGE_KEY);
        h = q();
        i = C();
        OrangeConfig.getInstance().registerListener(new String[]{ORANGE_GROUP_NAME}, new C9378a());
    }

    public static boolean y() {
        return e;
    }

    public static boolean z() {
        return g;
    }
}
