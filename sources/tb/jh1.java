package tb;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class jh1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TYPE_JPG_DOWNLOAD = "jpg_download";
    public static final String TYPE_PRE_LOCK_RATE = "pre_lock_success_rate";
    public static final String TYPE_QL_SVG_ACTIVITY_SHOW = "v1_svg_page_show";
    public static final String TYPE_SEAT_PB_DOWNLOAD = "seat_pb_download";
    public static final String TYPE_SEAT_PB_PARSE = "seat_pb_parse";
    public static final String TYPE_SEAT_STATE_DECOMPRESS = "seat_state_decompress";
    public static final String TYPE_SEAT_ZIP_DOWNLOAD = "seat_zip_download";
    public static final String TYPE_SEAT_ZIP_PARSE = "seat_zip_parse";
    public static final String TYPE_SVG_DOWNLOAD = "svg_download";
    public static final String TYPE_SVG_PARSE = "svg_parse";
    public static final String TYPE_VIEW_DRAW = "svg_view_draw";
    private static boolean c;
    private long a;
    private boolean b = false;

    public jh1() {
    }

    public static void d(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-868676794")) {
            ipChange.ipc$dispatch("-868676794", new Object[]{str, str2, str3});
        } else {
            AppMonitor.Alarm.commitFail("damai_trade", "qilin_biz_success_rate", str, str2, str3);
        }
    }

    public static void e(String str, String str2, String str3) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1807159774")) {
            ipChange.ipc$dispatch("1807159774", new Object[]{str, str2, str3});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            d(j(str), str2, str3);
        }
    }

    public static void f(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-2008357613")) {
            ipChange.ipc$dispatch("-2008357613", new Object[]{str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            g(j(str));
        }
    }

    public static void g(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "150765227")) {
            ipChange.ipc$dispatch("150765227", new Object[]{str});
        } else {
            AppMonitor.Alarm.commitSuccess("damai_trade", "qilin_biz_success_rate", str);
        }
    }

    private static String j(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1253711701")) {
            return (String) ipChange.ipc$dispatch("1253711701", new Object[]{str});
        }
        String[] split = str.split("\\.");
        return split.length > 0 ? split[split.length - 1].toLowerCase() : str;
    }

    public void a(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1421590576")) {
            ipChange.ipc$dispatch("1421590576", new Object[]{this, str});
        } else if (TextUtils.isEmpty(str)) {
        } else {
            c(j(str), 0L);
        }
    }

    public void b(String str, double d, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "349737590")) {
            ipChange.ipc$dispatch("349737590", new Object[]{this, str, Double.valueOf(d), Long.valueOf(j)});
        } else if (this.b || TextUtils.isEmpty(str) || d > 30000.0d) {
        } else {
            if (!c) {
                c = true;
                AppMonitor.register("damai_trade", "qilin_time_consuming", MeasureSet.create().addMeasure("loadTime").addMeasure("size"), DimensionSet.create().addDimension("type"));
            }
            this.b = true;
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("type", str);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("loadTime", d);
            create2.setValue("size", j);
            AppMonitor.Stat.commit("damai_trade", "qilin_time_consuming", create, create2);
        }
    }

    public void c(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1119665300")) {
            ipChange.ipc$dispatch("1119665300", new Object[]{this, str, Long.valueOf(j)});
        } else {
            b(str, System.currentTimeMillis() - this.a, j);
        }
    }

    public boolean h() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-1659942721") ? ((Boolean) ipChange.ipc$dispatch("-1659942721", new Object[]{this})).booleanValue() : this.b;
    }

    public void i() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1546823536")) {
            ipChange.ipc$dispatch("-1546823536", new Object[]{this});
        } else {
            this.a = System.currentTimeMillis();
        }
    }

    public jh1(boolean z) {
        if (z) {
            i();
        }
    }
}
