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
    /* renamed from: tb.pz0$a */
    /* loaded from: classes11.dex */
    public static class C9582a {
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

    public static void a(C9582a c9582a) {
        if (c9582a == null) {
            return;
        }
        AppMonitor.Stat.commit("hotpatch", "efficiency", DimensionValueSet.create().setValue("fromVersion", c9582a.e).setValue("toVersion", c9582a.f).setValue(TLogEventConst.PARAM_UPLOAD_STAGE, c9582a.b).setValue("success", c9582a.a ? "true" : "false").setValue("error_code", c9582a.c).setValue("error_msg", c9582a.d).setValue("url", c9582a.g).setValue("disk_size", c9582a.h), MeasureValueSet.create().setValue("elapsed_time", 0.0d));
    }

    public static void b(boolean z, String str, String str2, String str3, String str4, String str5, String str6) {
        C9582a c9582a = new C9582a();
        c9582a.a = z;
        c9582a.b = str;
        c9582a.c = str2;
        c9582a.d = str3;
        c9582a.e = str4;
        c9582a.f = str5;
        c9582a.g = str6;
        a(c9582a);
    }
}
