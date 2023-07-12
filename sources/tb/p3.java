package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class p3 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    private static boolean a = true;

    public static void a(String str, String str2, String str3, String str4) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2026729214")) {
            ipChange.ipc$dispatch("2026729214", new Object[]{str, str2, str3, str4});
        } else if (a) {
            AppMonitor.Alarm.commitFail(str, str2, str3, str4);
        }
    }

    public static void b(String str, String str2, DimensionValueSet dimensionValueSet, MeasureValueSet measureValueSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1274960142")) {
            ipChange.ipc$dispatch("1274960142", new Object[]{str, str2, dimensionValueSet, measureValueSet});
        } else if (a) {
            AppMonitor.Stat.commit(str, str2, dimensionValueSet, measureValueSet);
        }
    }

    public static void c(String str, String str2, MeasureSet measureSet, DimensionSet dimensionSet) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1365239684")) {
            ipChange.ipc$dispatch("1365239684", new Object[]{str, str2, measureSet, dimensionSet});
        } else if (a) {
            AppMonitor.register(str, str2, measureSet, dimensionSet);
        }
    }
}
