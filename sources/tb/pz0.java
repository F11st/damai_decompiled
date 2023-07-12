package tb;

import com.alibaba.mtl.appmonitor.AppMonitor;
import com.alibaba.mtl.appmonitor.model.DimensionSet;
import com.alibaba.mtl.appmonitor.model.DimensionValueSet;
import com.alibaba.mtl.appmonitor.model.MeasureSet;
import com.alibaba.mtl.appmonitor.model.MeasureValueSet;
import com.taobao.tao.log.statistics.TLogEventConst;
import com.taobao.updatecenter.hotpatch.HotPatchManager;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class pz0 {
    public static final String ANDFIX_COPY = "copyFile";
    public static final String ANDFIX_DOWNLOAD = "hotpatch_download";
    public static final String ANDFIX_FRIST_LOAD = "hotpatch_andfix_frist_load";
    public static final String ANDFIX_LOAD = "hotpatch_andfix_load";
    public static final String ANDFIX_UPDATE = "hotpatch_update_info";

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    public static class a {
        public boolean a;
        public String b;
        public String c;
        public String d;
        public String f;
        public String g;
        public String e = HotPatchManager.getInstance().getMainVersion();
        public String h = "0";
    }

    static {
        AppMonitor.register("hotpatch", "efficiency", MeasureSet.create().addMeasure("elapsed_time"), DimensionSet.create().addDimension("fromVersion").addDimension("toVersion").addDimension(TLogEventConst.PARAM_UPLOAD_STAGE).addDimension("success").addDimension("error_code").addDimension("error_msg").addDimension("url").addDimension("disk_size"));
    }

    public static void a(a aVar) {
        if (aVar == null) {
            return;
        }
        AppMonitor.Stat.commit("hotpatch", "efficiency", DimensionValueSet.create().setValue("fromVersion", aVar.e).setValue("toVersion", aVar.f).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, aVar.b).setValue("success", aVar.a ? "true" : "false").setValue("error_code", aVar.c).setValue("error_msg", aVar.d).setValue("url", aVar.g).setValue("disk_size", aVar.h), MeasureValueSet.create().setValue("elapsed_time", 0.0d));
    }

    public static void b(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        a aVar = new a();
        aVar.a = z;
        aVar.b = str;
        aVar.c = str2;
        aVar.d = str3;
        aVar.e = str4;
        aVar.f = str5;
        aVar.g = str6;
        a(aVar);
    }
}
