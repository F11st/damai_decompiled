package com.loc;

import android.content.Context;
import android.net.Proxy;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class t1 {
    private static String a() {
        String str;
        try {
            str = Proxy.getDefaultHost();
        } catch (Throwable th) {
            an.m(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static String b(String str) {
        return v1.v(str);
    }

    public static java.net.Proxy c(Context context) {
        try {
            return Build.VERSION.SDK_INT >= 11 ? d(context, new URI("http://restsdk.amap.com")) : f(context);
        } catch (Throwable th) {
            an.m(th, "pu", "gp");
            return null;
        }
    }

    private static java.net.Proxy d(Context context, URI uri) {
        java.net.Proxy proxy;
        if (g(context)) {
            try {
                List<java.net.Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                an.m(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int e() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            an.m(th, "pu", "gdp");
            return -1;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r10 == (-1)) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0075, code lost:
        r18 = 80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0078, code lost:
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a9, code lost:
        if (r10 == (-1)) goto L48;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0155 A[Catch: all -> 0x0151, TRY_LEAVE, TryCatch #6 {all -> 0x0151, blocks: (B:107:0x0146, B:114:0x0155), top: B:127:0x0146 }] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0146 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:131:0x00d2 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:133:0x00b7 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:135:0x013a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00eb A[Catch: all -> 0x016a, TryCatch #1 {all -> 0x016a, blocks: (B:65:0x00c8, B:74:0x00e0, B:76:0x00eb, B:78:0x00ff, B:80:0x0105, B:85:0x0111, B:88:0x0118, B:90:0x011e, B:92:0x0124, B:97:0x0130), top: B:126:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0137  */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy f(android.content.Context r19) {
        /*
            Method dump skipped, instructions count: 377
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.loc.t1.f(android.content.Context):java.net.Proxy");
    }

    private static boolean g(Context context) {
        return o.a0(context) == 0;
    }
}
