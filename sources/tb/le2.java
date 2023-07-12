package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class le2 {
    static {
        AppMonitor.register("update_sopatch", lu2.SOPATCH, MeasureSet.create(), DimensionSet.create().addDimension("toVersion").addDimension("mode").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("cost").addDimension("success").addDimension("error_code").addDimension("error_msg"));
    }

    public static void a(boolean z, String str, String str2, long j, int i, String str3, long j2) {
        AppMonitor.Stat.commit("update_sopatch", lu2.SOPATCH, DimensionValueSet.create().setValue("toVersion", String.valueOf(j2)).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, str2).setValue("mode", str).setValue("cost", String.valueOf(j)).setValue("success", z ? "true" : "false").setValue("error_code", String.valueOf(i)).setValue("error_msg", str3), MeasureValueSet.create());
    }
}
