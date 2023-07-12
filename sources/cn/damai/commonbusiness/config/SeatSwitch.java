package cn.damai.commonbusiness.config;

import cn.damai.common.AppConfig;
import cn.damai.common.OrangeConfigCenter;
import cn.damai.tool2.bufferkit.BufferSwitch;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import tb.t92;
import tb.td;
import tb.wh2;
import tb.z20;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class SeatSwitch {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int BY_NEW = 1;
    public static final int BY_OLD = 2;
    public static final int BY_ORANGE = 0;
    public static final String SEAT_QILIN_SEAT_REFACTOR_KEY = "match_user_code_suffix";
    @Deprecated
    public static final String SEAT_QILIN_SEAT_REFACTOR_SWITCH = "damai_qilin_seat_refactor_switch";
    public static final String SEAT_STATUS_COMPRESS_API_KEY = "is_use_seat_status_compress_api";
    public static final String SWITCH_MTOP_API_PRELOAD = "damai_mtop_api_preload_switch";
    public static final String SWITCH_MTOP_API_PRELOAD_KEY = "mtop_api_preload_close_group";
    @Deprecated
    public static final String SWITCH_SEAT_STATUS_COMPRESS_API = "damai_seat_status_compress_switch";

    static {
        try {
            String B = z20.B("sp_use_seat_page");
            if (wh2.h(B)) {
                Integer.parseInt(B);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0043, code lost:
        if (java.util.Arrays.asList(r0.split(",")).contains(r6) != false) goto L13;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean a(java.lang.String r6) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = cn.damai.commonbusiness.config.SeatSwitch.$ipChange
            java.lang.String r1 = "-211070401"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r6
            java.lang.Object r6 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r6 = (java.lang.Boolean) r6
            boolean r6 = r6.booleanValue()
            return r6
        L1b:
            cn.damai.common.OrangeConfigCenter r0 = cn.damai.common.OrangeConfigCenter.c()     // Catch: java.lang.Exception -> L77
            java.lang.String r1 = "damai_mtop_api_preload_switch"
            java.lang.String r2 = "mtop_api_preload_close_group"
            java.lang.String r5 = ""
            java.lang.String r0 = r0.b(r1, r2, r5)     // Catch: java.lang.Exception -> L77
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L46
            boolean r1 = android.text.TextUtils.isEmpty(r6)     // Catch: java.lang.Exception -> L77
            if (r1 != 0) goto L46
            java.lang.String r1 = ","
            java.lang.String[] r1 = r0.split(r1)     // Catch: java.lang.Exception -> L77
            java.util.List r1 = java.util.Arrays.asList(r1)     // Catch: java.lang.Exception -> L77
            boolean r1 = r1.contains(r6)     // Catch: java.lang.Exception -> L77
            if (r1 == 0) goto L46
            goto L47
        L46:
            r3 = 1
        L47:
            boolean r1 = cn.damai.common.AppConfig.v()     // Catch: java.lang.Exception -> L74
            if (r1 == 0) goto L7c
            java.lang.String r1 = "ApiPreload"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L74
            r2.<init>()     // Catch: java.lang.Exception -> L74
            java.lang.String r4 = "orange config="
            r2.append(r4)     // Catch: java.lang.Exception -> L74
            r2.append(r0)     // Catch: java.lang.Exception -> L74
            java.lang.String r0 = " groupType="
            r2.append(r0)     // Catch: java.lang.Exception -> L74
            r2.append(r6)     // Catch: java.lang.Exception -> L74
            java.lang.String r6 = " isSupport="
            r2.append(r6)     // Catch: java.lang.Exception -> L74
            r2.append(r3)     // Catch: java.lang.Exception -> L74
            java.lang.String r6 = r2.toString()     // Catch: java.lang.Exception -> L74
            tb.cb1.c(r1, r6)     // Catch: java.lang.Exception -> L74
            goto L7c
        L74:
            r6 = move-exception
            r4 = r3
            goto L78
        L77:
            r6 = move-exception
        L78:
            r6.printStackTrace()
            r3 = r4
        L7c:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.damai.commonbusiness.config.SeatSwitch.a(java.lang.String):boolean");
    }

    public static void b(boolean z) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1042337892")) {
            ipChange.ipc$dispatch("1042337892", new Object[]{Boolean.valueOf(z)});
            return;
        }
        try {
            if (z) {
                td.f(new BufferSwitch() { // from class: cn.damai.commonbusiness.config.SeatSwitch.1
                    private static transient /* synthetic */ IpChange $ipChange;

                    @Override // cn.damai.tool2.bufferkit.BufferSwitch
                    public boolean isGroupTypeSupport(String str) {
                        IpChange ipChange2 = $ipChange;
                        return AndroidInstantRuntime.support(ipChange2, "-1098717515") ? ((Boolean) ipChange2.ipc$dispatch("-1098717515", new Object[]{this, str})).booleanValue() : SeatSwitch.a(str);
                    }
                }, AppConfig.v());
                OrangeConfigCenter.c().e(SWITCH_MTOP_API_PRELOAD);
            } else {
                OrangeConfigCenter.c().g(SWITCH_MTOP_API_PRELOAD);
            }
            t92.g(z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
