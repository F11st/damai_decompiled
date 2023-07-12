package tb;

import android.content.Context;
import android.content.SharedPreferences;
import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.updatecenter.hotpatch.HotPatchManager;
import com.taobao.weex.annotation.JSMethod;
import tb.pz0;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class rz0 {
    public static final String ARG_COPY = "copy";
    public static final String ARG_DOWNLOAD = "download";
    public static final String ARG_LOAD = "load";
    public static final String ARG_REVUPDATE = "revupdate";
    public static boolean a = true;
    public static Context b;
    public static SharedPreferences c;

    static {
        AppMonitor.register("hotpatch_unique", "efficiency", MeasureSet.create().addMeasure("elapsed_time"), DimensionSet.create().addDimension("fromVersion").addDimension("toVersion").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("success").addDimension("error_code").addDimension("error_msg").addDimension("url").addDimension("disk_size"));
        a = HotPatchManager.getInstance().isMainProcess();
        Context context = HotPatchManager.getInstance().getContext();
        b = context;
        SharedPreferences sharedPreferences = context.getSharedPreferences("hotpatch_unique", 0);
        c = sharedPreferences;
        sharedPreferences.edit();
    }

    private static boolean a(String str, String str2, boolean z) {
        if (HotPatchManager.getInstance().isMainProcess()) {
            String str3 = str + JSMethod.NOT_SET + str2 + JSMethod.NOT_SET + z;
            boolean z2 = c.getBoolean(str3, false);
            if (!z2) {
                c.edit().putBoolean(str3, true).apply();
            }
            return z2;
        }
        return true;
    }

    public static void b() {
        c.edit().clear();
    }

    private static void c(pz0.a aVar) {
        if (aVar == null) {
            return;
        }
        AppMonitor.Stat.commit("hotpatch_unique", "efficiency", DimensionValueSet.create().setValue("fromVersion", aVar.e).setValue("toVersion", aVar.f).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, aVar.b).setValue("success", aVar.a ? "true" : "false").setValue("error_code", aVar.c).setValue("error_msg", aVar.d).setValue("url", aVar.g).setValue("disk_size", aVar.h), MeasureValueSet.create().setValue("elapsed_time", 0.0d));
    }

    public static void d(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (a && !a(str5, str, z)) {
            pz0.a aVar = new pz0.a();
            aVar.a = z;
            aVar.b = str;
            aVar.c = str2;
            aVar.d = str3;
            aVar.e = str4;
            aVar.f = str5;
            aVar.g = str6;
            c(aVar);
        }
    }
}
