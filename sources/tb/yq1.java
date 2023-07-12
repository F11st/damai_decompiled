package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.update.instantpatch.InstantPatchUpdater;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yq1 {
    public static final String ARG_DOWNLOAD = "download";
    public static final String ARG_INSTALL = "install";
    public static final String ARG_REVUPDATE = "revupdate";
    public static Context context;
    public static SharedPreferences preferences;

    static {
        AppMonitor.register("update_instantpatch", lu2.HOTPATCH, MeasureSet.create(), DimensionSet.create().addDimension("toVersion").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("cost").addDimension("success").addDimension("error_code").addDimension("error_msg"));
        Context context2 = InstantPatchUpdater.instance().getContext();
        context = context2;
        preferences = context2.getSharedPreferences(lu2.HOTPATCH, 0);
    }

    public static void stat(boolean z, String str, long j, int i, String str2, long j2) {
        AppMonitor.Stat.commit("update_instantpatch", lu2.HOTPATCH, DimensionValueSet.create().setValue("toVersion", String.valueOf(j2)).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, str).setValue("cost", String.valueOf(j)).setValue("success", z ? "true" : "false").setValue("error_code", String.valueOf(i)).setValue("error_msg", str2), MeasureValueSet.create());
    }
}
