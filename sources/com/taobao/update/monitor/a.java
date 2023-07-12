package com.taobao.update.monitor;

import android.text.TextUtils;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;
import java.util.HashMap;
import java.util.Map;
import tb.iu2;
import tb.pu2;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a {
    private Map<String, Boolean> a = new HashMap(2);

    private synchronized void a(String str) {
        if (this.a.get(str) != null) {
            return;
        }
        this.a.put(str, Boolean.TRUE);
        AppMonitor.register("update", str, MeasureSet.create().addMeasure("elapsed_time"), DimensionSet.create().addDimension("fromVersion").addDimension("toVersion").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("success").addDimension("error_code").addDimension("error_msg").addDimension("url").addDimension("disk_size"));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void b(String str, iu2 iu2Var) {
        if (iu2Var == null) {
            return;
        }
        a(str);
        AppMonitor.Stat.commit("update", str, DimensionValueSet.create().setValue("fromVersion", TextUtils.isEmpty(iu2Var.fromVersion) ? pu2.getVersionName() : iu2Var.fromVersion).setValue("toVersion", iu2Var.toVersion).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, iu2Var.arg).setValue("success", iu2Var.success ? "true" : "false").setValue("error_code", iu2Var.errorCode).setValue("error_msg", iu2Var.errorMsg).setValue("url", iu2Var.url).setValue("disk_size", iu2Var.disk_size), MeasureValueSet.create().setValue("elapsed_time", iu2Var.elapsed_time));
    }
}
