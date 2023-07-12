package tb;

import cn.damai.common.AppConfig;
import cn.damai.ticklet.ui.fragment.TicketDetailExtFragment;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class oe1 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static String d = "member_activity_perform_time";
    public static String e = "member_activity_detail_time";
    public static String f = "member_fragment_float_layer_local_time";
    public static String g = "member_accs_update_ticklet";
    private boolean a = false;
    private boolean b = false;
    private String c;

    public oe1(int i) {
        this.c = "";
        if (i == 0) {
            this.c = d;
        } else if (i == 1) {
            this.c = e;
        } else if (i == 2) {
            this.c = g;
        } else if (i == 3) {
            this.c = f;
        }
    }

    public void a(String str, long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "859317671")) {
            ipChange.ipc$dispatch("859317671", new Object[]{this, str, Long.valueOf(j)});
        } else if (AppConfig.v()) {
        } else {
            if (!this.a) {
                this.a = true;
                AppMonitor.register("damai_member", this.c, MeasureSet.create().addMeasure("loadTime"), DimensionSet.create().addDimension("type"));
            }
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("type", str);
            MeasureValueSet create2 = MeasureValueSet.create();
            create2.setValue("loadTime", j);
            AppMonitor.Stat.commit("damai_member", this.c, create, create2);
            cb1.b("damai_member", "type= " + str + " loadTime = " + j);
        }
    }

    public void b(String str, String str2) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-18319887")) {
            ipChange.ipc$dispatch("-18319887", new Object[]{this, str, str2});
        } else if (AppConfig.v()) {
        } else {
            this.c = g;
            if (!this.b) {
                this.b = true;
                AppMonitor.register("damai_member", "member_accs_update_ticklet", (MeasureSet) null, DimensionSet.create().addDimension("type").addDimension(TicketDetailExtFragment.PERFORM_ID));
            }
            DimensionValueSet create = DimensionValueSet.create();
            create.setValue("type", str);
            create.setValue(TicketDetailExtFragment.PERFORM_ID, str2);
            AppMonitor.Stat.commit("damai_member", "member_accs_update_ticklet", create, (MeasureValueSet) null);
        }
    }
}
