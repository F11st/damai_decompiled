package tb;

import android.text.TextUtils;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class t92 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String DEPEND_ON_ORANGE = "hw_by_orange";
    public static final String DEPEND_ON_POPCORN_CLOSED = "hw_by_popcorn_closed";
    public static final String DEPEND_ON_POPCORN_ENABLE = "hw_by_popcorn_enable";

    private static long a() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1129333523")) {
            return ((Long) ipChange.ipc$dispatch("1129333523", new Object[0])).longValue();
        }
        long k = jm1.k(z20.E(), -1L);
        if (k != -1) {
            return k % 100;
        }
        return -1L;
    }

    public static String b() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2025570042")) {
            return (String) ipChange.ipc$dispatch("2025570042", new Object[0]);
        }
        String B = z20.B("sp_hw_popcorn_key");
        return TextUtils.isEmpty(B) ? DEPEND_ON_ORANGE : B;
    }

    public static boolean c(long j, boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1765560114")) {
            return ((Boolean) ipChange.ipc$dispatch("-1765560114", new Object[]{Long.valueOf(j), Boolean.valueOf(z)})).booleanValue();
        }
        try {
            return d(j, z);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static boolean d(long r11, boolean r13) {
        /*
            Method dump skipped, instructions count: 287
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.t92.d(long, boolean):boolean");
    }

    private static boolean e() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "662531147") ? ((Boolean) ipChange.ipc$dispatch("662531147", new Object[0])).booleanValue() : !TextUtils.equals(DEPEND_ON_ORANGE, b());
    }

    private static void f(boolean z, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1359108490")) {
            ipChange.ipc$dispatch("1359108490", new Object[]{Boolean.valueOf(z), str});
        } else if (AppConfig.v() && z) {
            r92.f(str);
        }
    }

    public static void g(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1130979614")) {
            ipChange.ipc$dispatch("-1130979614", new Object[]{Boolean.valueOf(z)});
            return;
        }
        try {
            if (z) {
                OrangeConfigCenter.c().e("damai_svg_seat_view_hw_accelerate_switch");
            } else {
                OrangeConfigCenter.c().g("damai_svg_seat_view_hw_accelerate_switch");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
