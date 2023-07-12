package com.youku.live.livesdk.widgets.helper;

import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BizConfigHelper {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0037 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean shouldDowngradeToOldContainer(android.net.Uri r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.live.livesdk.widgets.helper.BizConfigHelper.$ipChange
            java.lang.String r1 = "235504135"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r3]
            r2[r4] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L1b:
            if (r5 == 0) goto L46
            java.lang.String r0 = "debug"
            java.lang.String r0 = r5.getQueryParameter(r0)
            if (r0 == 0) goto L2e
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch: java.lang.Throwable -> L2e
            boolean r0 = r0.booleanValue()     // Catch: java.lang.Throwable -> L2e
            goto L2f
        L2e:
            r0 = 0
        L2f:
            java.lang.String r1 = "dt2019"
            java.lang.String r5 = r5.getQueryParameter(r1)
            if (r5 == 0) goto L40
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r5)     // Catch: java.lang.Throwable -> L40
            boolean r5 = r5.booleanValue()     // Catch: java.lang.Throwable -> L40
            goto L41
        L40:
            r5 = 0
        L41:
            if (r0 == 0) goto L46
            if (r5 == 0) goto L46
            return r3
        L46:
            java.lang.String r5 = "live_platform_widget"
            java.lang.String r0 = "downgrade_to_old_container"
            boolean r5 = com.youku.live.livesdk.widgets.helper.ConfigHelper.getBoolean(r5, r0, r4)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.live.livesdk.widgets.helper.BizConfigHelper.shouldDowngradeToOldContainer(android.net.Uri):boolean");
    }
}
