package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.Build;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class gl {
    public static Proxy a(Context context) {
        Proxy b;
        try {
            if (Build.VERSION.SDK_INT >= 11) {
                b = a(context, new URI("http://restapi.amap.com"));
            } else {
                b = b(context);
            }
            return b;
        } catch (Throwable th) {
            hd.c(th, "pu", "gp");
            return null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0073, code lost:
        if (r10 == (-1)) goto L8;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0076, code lost:
        r17 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
        if (r10 == (-1)) goto L8;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:101:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x014a A[Catch: all -> 0x0156, TRY_LEAVE, TryCatch #9 {all -> 0x0156, blocks: (B:107:0x0144, B:109:0x014a), top: B:129:0x0144 }] */
    /* JADX WARN: Removed duplicated region for block: B:122:0x013b A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:127:0x00d0 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00ea A[Catch: all -> 0x0160, TryCatch #1 {all -> 0x0160, blocks: (B:66:0x00c6, B:75:0x00df, B:77:0x00ea, B:79:0x00fe, B:81:0x0104, B:86:0x0110, B:89:0x0117, B:91:0x011d, B:93:0x0123, B:98:0x012f), top: B:124:0x0028 }] */
    /* JADX WARN: Type inference failed for: r10v11 */
    /* JADX WARN: Type inference failed for: r10v12 */
    /* JADX WARN: Type inference failed for: r10v5 */
    /* JADX WARN: Type inference failed for: r9v0, types: [android.content.ContentResolver, android.database.Cursor] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.net.Proxy b(android.content.Context r18) {
        /*
            Method dump skipped, instructions count: 367
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.gl.b(android.content.Context):java.net.Proxy");
    }

    private static boolean c(Context context) {
        return gg.r(context) == 0;
    }

    public static String a(String str) {
        return gn.c(str);
    }

    private static boolean a(String str, int i) {
        return (str == null || str.length() <= 0 || i == -1) ? false : true;
    }

    private static String a() {
        String str;
        try {
            str = android.net.Proxy.getDefaultHost();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdh");
            str = null;
        }
        return str == null ? "null" : str;
    }

    private static Proxy a(Context context, URI uri) {
        Proxy proxy;
        if (c(context)) {
            try {
                List<Proxy> select = ProxySelector.getDefault().select(uri);
                if (select == null || select.isEmpty() || (proxy = select.get(0)) == null) {
                    return null;
                }
                if (proxy.type() == Proxy.Type.DIRECT) {
                    return null;
                }
                return proxy;
            } catch (Throwable th) {
                hd.c(th, "pu", "gpsc");
            }
        }
        return null;
    }

    private static int b() {
        try {
            return android.net.Proxy.getDefaultPort();
        } catch (Throwable th) {
            hd.c(th, "pu", "gdp");
            return -1;
        }
    }
}
