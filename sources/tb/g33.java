package tb;

import com.efs.sdk.base.IConfigRefreshAction;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class g33 implements IConfigRefreshAction {

    /* compiled from: Taobao */
    /* renamed from: tb.g33$a */
    /* loaded from: classes10.dex */
    static class C9155a {
        private static final g33 a = new g33();
    }

    public static g33 a() {
        return C9155a.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x00b3, code lost:
        r0 = "config request succ, config is:\n ".concat(java.lang.String.valueOf(r4));
     */
    @Override // com.efs.sdk.base.IConfigRefreshAction
    @androidx.annotation.NonNull
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.String refresh() {
        /*
            r10 = this;
            tb.f33 r0 = com.efs.sdk.base.a.d.C4786a.a()
            android.content.Context r0 = r0.c
            android.net.NetworkInfo r0 = tb.m73.a(r0)
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L1e
            boolean r3 = r0.isConnected()
            if (r3 == 0) goto L1e
            android.net.NetworkInfo$State r0 = r0.getState()
            android.net.NetworkInfo$State r3 = android.net.NetworkInfo.State.CONNECTED
            if (r0 != r3) goto L1e
            r0 = 1
            goto L1f
        L1e:
            r0 = 0
        L1f:
            java.lang.String r3 = "efs.config"
            java.lang.String r4 = ""
            if (r0 != 0) goto L2b
            java.lang.String r0 = "Config refresh fail, network is disconnected."
        L27:
            tb.w63.a(r3, r0)
            return r4
        L2b:
            com.efs.sdk.base.a.c.a.c r0 = com.efs.sdk.base.a.c.a.C4783c.a()
            java.lang.String r0 = r0.b(r2)
            tb.e53 r5 = tb.e53.a()
        L37:
            r6 = 3
            if (r1 >= r6) goto Lb3
            tb.u23 r6 = tb.u23.c()
            java.lang.String r7 = r5.b()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            r8.append(r0)
            java.lang.String r9 = "/api/v1/config"
            r8.append(r9)
            java.lang.String r8 = r8.toString()
            boolean r6 = r6.a
            if (r6 == 0) goto L66
            java.lang.String r6 = java.lang.String.valueOf(r8)
            java.lang.String r9 = "get config from server, url is "
            java.lang.String r6 = r9.concat(r6)
            java.lang.String r9 = "efs.px.api"
            tb.w63.a(r9, r6)
        L66:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>(r2)
            java.lang.String r9 = "wpk-header"
            r6.put(r9, r7)
            com.efs.sdk.base.a.h.b.b r7 = new com.efs.sdk.base.a.h.b.b
            r7.<init>(r8)
            com.efs.sdk.base.a.h.b.b r6 = r7.c(r6)
            tb.c43 r7 = tb.c43.d()
            com.efs.sdk.base.a.h.b.b r6 = r6.d(r7)
            com.efs.sdk.base.a.h.b.c r6 = r6.a()
            com.efs.sdk.base.a.h.b.a r7 = r6.a
            java.lang.String r8 = "get"
            r7.e = r8
            java.lang.Object r6 = r6.a()
            tb.l01 r6 = (tb.l01) r6
            boolean r7 = r6.a
            if (r7 == 0) goto L98
            java.lang.String r4 = r6.c
            goto Lb3
        L98:
            java.lang.String r7 = r6.a()
            boolean r7 = android.text.TextUtils.isEmpty(r7)
            if (r7 != 0) goto Lb2
            java.lang.String r6 = r6.a()
            java.lang.String r7 = "1000"
            boolean r6 = r7.equals(r6)
            if (r6 != 0) goto Laf
            goto Lb2
        Laf:
            int r1 = r1 + 1
            goto L37
        Lb2:
            return r4
        Lb3:
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "config request succ, config is:\n "
            java.lang.String r0 = r1.concat(r0)
            goto L27
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.g33.refresh():java.lang.String");
    }
}
