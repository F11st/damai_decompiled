package tb;

import android.text.TextUtils;
import com.taobao.monitor.procedure.IProcedure;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class yu1 {
    public static void a(IProcedure iProcedure, String str, long j) {
        if (iProcedure == null || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        iProcedure.addProperty(str, Long.valueOf(j));
    }

    public static void b(IProcedure iProcedure, String str, Object obj) {
        if (iProcedure == null || TextUtils.isEmpty(str) || obj == null) {
            return;
        }
        iProcedure.addProperty(str, obj);
    }

    public static void c(IProcedure iProcedure, String str, Object obj) {
        if (iProcedure == null || TextUtils.isEmpty(str) || obj == null || TextUtils.isEmpty(obj.toString())) {
            return;
        }
        iProcedure.addProperty(str, obj);
    }

    public static void d(IProcedure iProcedure, String str, long j) {
        if (iProcedure == null || TextUtils.isEmpty(str) || j <= 0) {
            return;
        }
        iProcedure.stage(str, j);
    }
}
