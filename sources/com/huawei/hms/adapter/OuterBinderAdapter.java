package com.huawei.hms.adapter;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class OuterBinderAdapter extends BinderAdapter {
    private static final Object LOCK_OBJECT_INIT = new Object();
    private static final int MSG_CONN_TIMEOUT = 1001;
    private static final int MSG_DELAY_DISCONNECT = 1002;
    private static final String TAG = "OuterBinderAdapter";
    private static BinderAdapter adapter;
    private static String sActionName;
    private static String sServiceName;

    private OuterBinderAdapter(Context context, String str, String str2) {
        super(context, str, str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0030 A[Catch: all -> 0x004b, TryCatch #0 {, blocks: (B:4:0x000a, B:6:0x000e, B:16:0x0047, B:17:0x0049, B:7:0x001a, B:9:0x0022, B:15:0x0030), top: B:22:0x000a }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.huawei.hms.adapter.BinderAdapter getInstance(android.content.Context r3, java.lang.String r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "OuterBinderAdapter"
            java.lang.String r1 = "OuterBinderAdapter getInstance."
            com.huawei.hms.support.log.HMSLog.i(r0, r1)
            java.lang.Object r0 = com.huawei.hms.adapter.OuterBinderAdapter.LOCK_OBJECT_INIT
            monitor-enter(r0)
            com.huawei.hms.adapter.BinderAdapter r1 = com.huawei.hms.adapter.OuterBinderAdapter.adapter     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L1a
            com.huawei.hms.adapter.OuterBinderAdapter.sActionName = r4     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.OuterBinderAdapter.sServiceName = r5     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.BinderAdapter r1 = new com.huawei.hms.adapter.BinderAdapter     // Catch: java.lang.Throwable -> L4b
            r1.<init>(r3, r4, r5)     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.OuterBinderAdapter.adapter = r1     // Catch: java.lang.Throwable -> L4b
            goto L47
        L1a:
            java.lang.String r1 = com.huawei.hms.adapter.OuterBinderAdapter.sActionName     // Catch: java.lang.Throwable -> L4b
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r4)     // Catch: java.lang.Throwable -> L4b
            if (r1 == 0) goto L2d
            java.lang.String r1 = com.huawei.hms.adapter.OuterBinderAdapter.sServiceName     // Catch: java.lang.Throwable -> L4b
            boolean r1 = com.huawei.hms.common.internal.Objects.equal(r1, r5)     // Catch: java.lang.Throwable -> L4b
            if (r1 != 0) goto L2b
            goto L2d
        L2b:
            r1 = 0
            goto L2e
        L2d:
            r1 = 1
        L2e:
            if (r1 == 0) goto L47
            java.lang.String r1 = "OuterBinderAdapter"
            java.lang.String r2 = "OuterBinderAdapter getInstance refresh adapter"
            com.huawei.hms.support.log.HMSLog.i(r1, r2)     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.OuterBinderAdapter.sActionName = r4     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.OuterBinderAdapter.sServiceName = r5     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.BinderAdapter r1 = com.huawei.hms.adapter.OuterBinderAdapter.adapter     // Catch: java.lang.Throwable -> L4b
            r1.unBind()     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.BinderAdapter r1 = new com.huawei.hms.adapter.BinderAdapter     // Catch: java.lang.Throwable -> L4b
            r1.<init>(r3, r4, r5)     // Catch: java.lang.Throwable -> L4b
            com.huawei.hms.adapter.OuterBinderAdapter.adapter = r1     // Catch: java.lang.Throwable -> L4b
        L47:
            com.huawei.hms.adapter.BinderAdapter r3 = com.huawei.hms.adapter.OuterBinderAdapter.adapter     // Catch: java.lang.Throwable -> L4b
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
            return r3
        L4b:
            r3 = move-exception
            monitor-exit(r0)     // Catch: java.lang.Throwable -> L4b
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.adapter.OuterBinderAdapter.getInstance(android.content.Context, java.lang.String, java.lang.String):com.huawei.hms.adapter.BinderAdapter");
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getConnTimeOut() {
        return 1001;
    }

    @Override // com.huawei.hms.adapter.BinderAdapter
    protected int getMsgDelayDisconnect() {
        return 1002;
    }
}
