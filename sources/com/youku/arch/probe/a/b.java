package com.youku.arch.probe.a;

import android.content.Context;
import android.net.NetworkInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class b {
    private static transient /* synthetic */ IpChange $ipChange;

    /* JADX WARN: Code restructure failed: missing block: B:10:0x002f, code lost:
        if (r5.getType() != 0) goto L7;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int a(android.content.Context r5) {
        /*
            com.android.alibaba.ip.runtime.IpChange r0 = com.youku.arch.probe.a.b.$ipChange
            java.lang.String r1 = "-880137961"
            boolean r2 = com.android.alibaba.ip.runtime.AndroidInstantRuntime.support(r0, r1)
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L1b
            java.lang.Object[] r2 = new java.lang.Object[r4]
            r2[r3] = r5
            java.lang.Object r5 = r0.ipc$dispatch(r1, r2)
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r5 = r5.intValue()
            return r5
        L1b:
            if (r5 == 0) goto L37
            java.lang.String r0 = "connectivity"
            java.lang.Object r5 = r5.getSystemService(r0)     // Catch: java.lang.Throwable -> L32
            android.net.ConnectivityManager r5 = (android.net.ConnectivityManager) r5     // Catch: java.lang.Throwable -> L32
            android.net.NetworkInfo r5 = com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager.getActiveNetworkInfo(r5)     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L37
            int r5 = r5.getType()     // Catch: java.lang.Throwable -> L32
            if (r5 == 0) goto L38
            goto L37
        L32:
            r5 = move-exception
            r5.printStackTrace()
            goto L39
        L37:
            r3 = 1
        L38:
            r4 = r3
        L39:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.probe.a.b.a(android.content.Context):int");
    }

    public static String a(long j) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1330655104")) {
            return (String) ipChange.ipc$dispatch("-1330655104", new Object[]{Long.valueOf(j)});
        }
        int[] iArr = {(int) ((j >> 24) & 255), (int) ((j >> 16) & 255), (int) ((j >> 8) & 255), (int) (j & 255)};
        for (int i = 0; i < 4; i++) {
            if (iArr[i] < 0 || iArr[i] > 255) {
                return null;
            }
        }
        return Integer.toString(iArr[3]) + "." + Integer.toString(iArr[2]) + "." + Integer.toString(iArr[1]) + "." + Integer.toString(iArr[0]);
    }

    public static boolean a(String str) {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "743414770") ? ((Boolean) ipChange.ipc$dispatch("743414770", new Object[]{str})).booleanValue() : (str == null || str.equals("") || !str.matches("([A-Fa-f0-9]{2}[-,:]){5}[A-Fa-f0-9]{2}")) ? false : true;
    }

    public static String b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2116175259")) {
            return (String) ipChange.ipc$dispatch("2116175259", new Object[]{context});
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        return activeNetworkInfo == null ? "unknown" : activeNetworkInfo.getType() == 1 ? c(context) : activeNetworkInfo.getType() == 0 ? "4G" : "unknown";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:105:0x00bc A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00b2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x00a8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r0v8, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v0, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13 */
    /* JADX WARN: Type inference failed for: r1v14 */
    /* JADX WARN: Type inference failed for: r1v6, types: [java.io.InputStream] */
    /* JADX WARN: Type inference failed for: r2v0, types: [boolean] */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v6, types: [java.io.InputStreamReader] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 230
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.youku.arch.probe.a.b.c(android.content.Context):java.lang.String");
    }
}
