package com.amap.api.mapcore.util;

import com.amap.api.maps.AMapException;
import java.net.Proxy;
import java.net.URL;
import java.net.URLConnection;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class id {
    public static int a = 0;
    public static String b = "";
    private static id c;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        URLConnection a(Proxy proxy, URL url);
    }

    public static id a() {
        if (c == null) {
            c = new id();
        }
        return c;
    }

    public byte[] b(ii iiVar) throws gb {
        try {
            ik a2 = a(iiVar, false);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (gb e) {
            throw e;
        } catch (Throwable th) {
            ha.a(th, "bm", com.alipay.sdk.m.o.a.a);
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void c(ii iiVar) throws gb {
        if (iiVar != null) {
            if (iiVar.getURL() == null || "".equals(iiVar.getURL())) {
                throw new gb("request url is empty");
            }
            return;
        }
        throw new gb("requeust is null");
    }

    public byte[] a(ii iiVar) throws gb {
        try {
            ik a2 = a(iiVar, true);
            if (a2 != null) {
                return a2.a;
            }
            return null;
        } catch (gb e) {
            throw e;
        }
    }

    public ik a(ii iiVar, boolean z) throws gb {
        ik ikVar;
        byte[] bArr;
        int a2 = ig.a(2, iiVar);
        try {
            ikVar = a(iiVar, z, a2);
        } catch (gb e) {
            if (!ig.a(a2)) {
                throw e;
            }
            ikVar = null;
        }
        if ((ikVar == null || (bArr = ikVar.a) == null || bArr.length <= 0) && ig.a(a2)) {
            try {
                return a(iiVar, z, 3);
            } catch (gb e2) {
                throw e2;
            }
        }
        return ikVar;
    }

    public ik a(ii iiVar, boolean z, int i) throws gb {
        try {
            c(iiVar);
            Proxy proxy = iiVar.c;
            if (proxy == null) {
                proxy = null;
            }
            return new ig(iiVar.a, iiVar.b, proxy, z).a(iiVar.b(), iiVar.c(), iiVar.isIPRequest(), iiVar.getIPDNSName(), iiVar.getRequestHead(), iiVar.d(), iiVar.isIgnoreGZip(), i);
        } catch (gb e) {
            throw e;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new gb(AMapException.ERROR_UNKNOWN);
        }
    }
}
