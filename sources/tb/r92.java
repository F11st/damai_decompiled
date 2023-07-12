package tb;

import android.os.Looper;
import android.text.TextUtils;
import android.widget.TextView;
import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionData;
import cn.damai.commonbusiness.seatbiz.seat.common.bean.region.RegionInfo;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class r92 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static long a;

    public static boolean a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "903279131") ? ((Boolean) ipChange.ipc$dispatch("903279131", new Object[0])).booleanValue() : Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public static boolean b(RegionData regionData) {
        RegionInfo regionInfo;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2109974509")) {
            return ((Boolean) ipChange.ipc$dispatch("2109974509", new Object[]{regionData})).booleanValue();
        }
        if (regionData == null || (regionInfo = regionData.ri) == null || regionInfo.seatStyle != 3 || regionData.isJPG()) {
            return false;
        }
        return d();
    }

    public static boolean c() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "583267491")) {
            return ((Boolean) ipChange.ipc$dispatch("583267491", new Object[0])).booleanValue();
        }
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - a <= 300;
        if (!z) {
            a = currentTimeMillis;
        }
        return z;
    }

    private static boolean d() {
        int i;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1902834710")) {
            return ((Boolean) ipChange.ipc$dispatch("1902834710", new Object[0])).booleanValue();
        }
        try {
            i = OrangeConfigCenter.c().a("damai_seat_sofa_style_offset_switch", "damai_seat_sofa_style_offset_key", 1);
        } catch (Exception e) {
            e.printStackTrace();
            i = 0;
        }
        return i == 1;
    }

    public static void e(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-841187678")) {
            ipChange.ipc$dispatch("-841187678", new Object[]{Boolean.valueOf(z)});
            return;
        }
        try {
            if (z) {
                OrangeConfigCenter.c().e("damai_seat_sofa_style_offset_switch");
            } else {
                OrangeConfigCenter.c().g("damai_seat_sofa_style_offset_switch");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "520118545")) {
            ipChange.ipc$dispatch("520118545", new Object[]{str});
        } else if (AppConfig.v()) {
            cb1.c("SeatLog", (jn1.ARRAY_START_STR + Thread.currentThread().getName() + "] ") + str);
        }
    }

    public static void g(TextView textView, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "85968361")) {
            ipChange.ipc$dispatch("85968361", new Object[]{textView, str});
        } else if (TextUtils.isEmpty(str)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str);
            textView.setVisibility(0);
        }
    }

    public static long h(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "738809735")) {
            return ((Long) ipChange.ipc$dispatch("738809735", new Object[]{str, Long.valueOf(j)})).longValue();
        }
        try {
            return Long.parseLong(str);
        } catch (Exception unused) {
            return j;
        }
    }
}
