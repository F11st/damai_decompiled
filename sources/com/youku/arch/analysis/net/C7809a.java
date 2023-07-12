package com.youku.arch.analysis.net;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* renamed from: com.youku.arch.analysis.net.a */
/* loaded from: classes11.dex */
public class C7809a {
    private static transient /* synthetic */ IpChange $ipChange;
    public int a;
    public int b;
    public int c;
    public int d;
    public int e;
    public boolean f;
    private int g;

    public int a() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "-2059168322") ? ((Integer) ipChange.ipc$dispatch("-2059168322", new Object[]{this})).intValue() : this.g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Removed duplicated region for block: B:18:0x002f  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0051  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x005c  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x006d  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x007b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b() {
        /*
            r8 = this;
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.analysis.net.C7809a.$ipChange
            java.lang.String r1 = "-2059138518"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L14
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r8
            r0.ipc$dispatch(r1, r2)
            return
        L14:
            int r0 = r8.a
            r1 = 3
            r2 = 2
            if (r0 == r4) goto L29
            if (r0 == r2) goto L26
            if (r0 == r1) goto L22
            r0 = 0
        L1f:
            r5 = 0
        L20:
            r6 = 0
            goto L2b
        L22:
            r0 = 0
            r5 = 0
            r6 = 1
            goto L2b
        L26:
            r0 = 0
            r5 = 1
            goto L20
        L29:
            r0 = 1
            goto L1f
        L2b:
            int r7 = r8.b
            if (r7 == r4) goto L3a
            if (r7 == r2) goto L37
            if (r7 == r1) goto L34
            goto L3c
        L34:
            int r6 = r6 + 1
            goto L3c
        L37:
            int r5 = r5 + 1
            goto L3c
        L3a:
            int r0 = r0 + 1
        L3c:
            int r7 = r8.c
            if (r7 == r4) goto L4b
            if (r7 == r2) goto L48
            if (r7 == r1) goto L45
            goto L4d
        L45:
            int r6 = r6 + 1
            goto L4d
        L48:
            int r5 = r5 + 1
            goto L4d
        L4b:
            int r0 = r0 + 1
        L4d:
            int r7 = r8.d
            if (r7 == r4) goto L5c
            if (r7 == r2) goto L59
            if (r7 == r1) goto L56
            goto L5e
        L56:
            int r6 = r6 + 1
            goto L5e
        L59:
            int r5 = r5 + 1
            goto L5e
        L5c:
            int r0 = r0 + 1
        L5e:
            int r7 = r8.e
            if (r7 == r4) goto L6d
            if (r7 == r2) goto L6a
            if (r7 == r1) goto L67
            goto L6f
        L67:
            int r6 = r6 + 1
            goto L6f
        L6a:
            int r5 = r5 + 1
            goto L6f
        L6d:
            int r0 = r0 + 1
        L6f:
            java.lang.String r7 = "NetQualityInfo"
            if (r0 < r4) goto L7b
            java.lang.String r0 = "get final network quality:1"
            com.youku.b.a.C7892a.a(r7, r0)
            r8.g = r4
            return
        L7b:
            if (r6 <= r5) goto L87
            if (r0 != 0) goto L87
            java.lang.String r0 = "get final network quality:3"
            com.youku.b.a.C7892a.a(r7, r0)
            r8.g = r1
            return
        L87:
            int r6 = r6 + r5
            int r6 = r6 + r0
            if (r6 != 0) goto L93
            java.lang.String r0 = "get final network quality:0"
            com.youku.b.a.C7892a.a(r7, r0)
            r8.g = r3
            return
        L93:
            java.lang.String r0 = "get final network quality:2"
            com.youku.b.a.C7892a.a(r7, r0)
            r8.g = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.analysis.net.C7809a.b():void");
    }

    public String toString() {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "629867406")) {
            return (String) ipChange.ipc$dispatch("629867406", new Object[]{this});
        }
        return this.a + this.b + this.c + this.d + this.e + ",netscore:" + this.g;
    }
}
