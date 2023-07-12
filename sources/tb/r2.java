package tb;

import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class r2 {
    private static transient /* synthetic */ IpChange $ipChange;
    private static boolean a;

    public static void a(String str, String str2, long j, double d) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "928216706")) {
            ipChange.ipc$dispatch("928216706", new Object[]{str, str2, Long.valueOf(j), Double.valueOf(d)});
            return;
        }
        if (!a) {
            a = true;
            p3.c("damai_member", "ticklet_accs_exchange_stat", MeasureSet.create().addMeasure("loadTime").addMeasure("userCode"), DimensionSet.create().addDimension("result").addDimension("baseType"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("result", str);
        create.setValue("baseType", str2);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("loadTime", j);
        create2.setValue("userCode", d);
        p3.b("damai_member", "ticklet_accs_exchange_stat", create, create2);
    }
}
