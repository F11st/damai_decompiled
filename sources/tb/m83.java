package tb;

import com.ali.user.open.tbauth.TbAuthConstants;
import com.alibaba.fastjson.JSON;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tlog.adapter.AdapterForTLog;
import com.youku.vpm.constants.TableField;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class m83 {
    private static volatile boolean a;

    public static void a(l83 l83Var) {
        String str;
        String str2;
        String str3;
        if (a) {
            str = "networkType";
            str2 = "videoformat";
            str3 = "speed_test";
        } else {
            a = true;
            str2 = "videoformat";
            str = "networkType";
            str3 = "speed_test";
            AppMonitor.register("vpm", str3, MeasureSet.create().addMeasure("bandwidth").addMeasure("duration").addMeasure("impairmentOrder").addMeasure("cmdConnectionTime").addMeasure("networkType"), DimensionSet.create().addDimension("id").addDimension("ruleId").addDimension("task_id").addDimension("url").addDimension("detail").addDimension("error_code").addDimension(TableField.PS_ID).addDimension("vvId").addDimension("videoformat"));
        }
        DimensionValueSet create = DimensionValueSet.create();
        create.setValue("id", l83Var.b);
        create.setValue("ruleId", l83Var.c);
        create.setValue("task_id", "" + l83Var.d);
        create.setValue("url", l83Var.e);
        create.setValue(TbAuthConstants.IP, l83Var.f);
        create.setValue("detail", JSON.toJSONString(l83Var.i));
        create.setValue("error_code", "" + l83Var.a);
        create.setValue(TableField.PS_ID, l83Var.j);
        create.setValue("vvId", l83Var.l);
        create.setValue(str2, l83Var.m);
        create.setValue("triggerType", l83Var.o);
        MeasureValueSet create2 = MeasureValueSet.create();
        create2.setValue("bandwidth", l83Var.h);
        create2.setValue("duration", l83Var.g);
        create2.setValue("impairmentOrder", l83Var.k);
        create2.setValue("cmdConnectionTime", l83Var.n);
        create2.setValue(str, l83Var.p);
        AppMonitor.Stat.commit("vpm", str3, create, create2);
        AdapterForTLog.loge("SpeedTest", "stat:bandwidth=" + l83Var.h + ",task_id=" + l83Var.d + ",url=" + l83Var.e + ",error_code=" + l83Var.a + ",networkType=" + l83Var.p);
    }
}
