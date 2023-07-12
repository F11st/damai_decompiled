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

    private static void c(pz0.C9582a c9582a) {
        if (c9582a == null) {
            return;
        }
        AppMonitor.Stat.commit("hotpatch_unique", "efficiency", DimensionValueSet.create().setValue("fromVersion", c9582a.e).setValue("toVersion", c9582a.f).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, c9582a.b).setValue("success", c9582a.a ? "true" : "false").setValue("error_code", c9582a.c).setValue("error_msg", c9582a.d).setValue("url", c9582a.g).setValue("disk_size", c9582a.h), MeasureValueSet.create().setValue("elapsed_time", 0.0d));
    }

    public static void d(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        if (a && !a(str5, str, z)) {
            pz0.C9582a c9582a = new pz0.C9582a();
            c9582a.a = z;
            c9582a.b = str;
            c9582a.c = str2;
            c9582a.d = str3;
            c9582a.e = str4;
            c9582a.f = str5;
            c9582a.g = str6;
            c(c9582a);
        }
    }
}
