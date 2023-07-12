package tb;

import cn.damai.common.OrangeConfigCenter;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class gj2 {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Removed duplicated region for block: B:16:0x0043 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a() {
        /*
            java.lang.String r0 = "useDecryptApiLevel"
            com.android.alibaba.ip.runtime.IpChange r1 = tb.gj2.$ipChange
            java.lang.String r2 = "1233102534"
            boolean r3 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r1, r2)
            r4 = 0
            if (r3 == 0) goto L1a
            java.lang.Object[] r0 = new java.lang.Object[r4]
            java.lang.Object r0 = r1.ipc$dispatch(r2, r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            return r0
        L1a:
            r1 = 1
            cn.damai.common.OrangeConfigCenter r2 = cn.damai.common.OrangeConfigCenter.c()     // Catch: java.lang.Exception -> L3c
            java.lang.String r3 = "damai_svg_protect_api_level_switch"
            int r2 = r2.a(r3, r0, r1)     // Catch: java.lang.Exception -> L3c
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L3a
            r3.<init>()     // Catch: java.lang.Exception -> L3a
            java.lang.String r5 = "useDecryptApiLevel_"
            r3.append(r5)     // Catch: java.lang.Exception -> L3a
            r3.append(r2)     // Catch: java.lang.Exception -> L3a
            java.lang.String r3 = r3.toString()     // Catch: java.lang.Exception -> L3a
            tb.cb1.b(r0, r3)     // Catch: java.lang.Exception -> L3a
            goto L41
        L3a:
            r0 = move-exception
            goto L3e
        L3c:
            r0 = move-exception
            r2 = 1
        L3e:
            r0.printStackTrace()
        L41:
            if (r2 != r1) goto L44
            r4 = 1
        L44:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.gj2.a():boolean");
    }

    public static void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1987874535")) {
            ipChange.ipc$dispatch("-1987874535", new Object[]{Boolean.valueOf(z)});
        } else if (z) {
            OrangeConfigCenter.c().e("damai_svg_protect_api_level_switch");
        } else {
            OrangeConfigCenter.c().g("damai_svg_protect_api_level_switch");
        }
    }
}
