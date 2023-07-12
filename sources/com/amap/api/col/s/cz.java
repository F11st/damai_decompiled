package com.amap.api.col.s;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.col.s.df;
import com.amap.api.maps.AMapException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cz {
    public static int a = 0;
    public static String b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static cz f;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        URLConnection a();
    }

    public cz() {
        bl.d();
    }

    public static cz a() {
        if (f == null) {
            f = new cz();
        }
        return f;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static df.b b(df dfVar, boolean z) {
        return dfVar.o() == df.a.FIX ? z ? df.b.FIX_DEGRADE_BYERROR : df.b.FIX_DEGRADE_ONLY : z ? df.b.DEGRADE_BYERROR : df.b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean c(df dfVar) throws bj {
        d(dfVar);
        if (b(dfVar)) {
            if (dfVar.h().equals(dfVar.a()) || dfVar.o() == df.a.SINGLE) {
                return false;
            }
            return bl.h;
        }
        return true;
    }

    @Deprecated
    private static dg d(df dfVar, boolean z) throws bj {
        byte[] bArr;
        d(dfVar);
        dfVar.a(z ? df.c.HTTPS : df.c.HTTP);
        dg dgVar = null;
        long j = 0;
        boolean z2 = false;
        if (b(dfVar)) {
            boolean c2 = c(dfVar);
            try {
                j = SystemClock.elapsedRealtime();
                dgVar = a(dfVar, a(dfVar, c2), c(dfVar, c2));
            } catch (bj e2) {
                if (e2.f() == 21 && dfVar.o() == df.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!c2) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (dgVar == null || (bArr = dgVar.a) == null || bArr.length <= 0) {
            try {
                return a(dfVar, b(dfVar, z2), a(dfVar, j));
            } catch (bj e3) {
                throw e3;
            }
        }
        return dgVar;
    }

    public static dg a(df dfVar) throws bj {
        return d(dfVar, dfVar.r());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean b(df dfVar) throws bj {
        d(dfVar);
        try {
            String a2 = dfVar.a();
            if (TextUtils.isEmpty(a2)) {
                return false;
            }
            String host = new URL(a2).getHost();
            if (!TextUtils.isEmpty(dfVar.i())) {
                host = dfVar.i();
            }
            return bl.d(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static dg a(df dfVar, df.b bVar, int i) throws bj {
        try {
            d(dfVar);
            dfVar.a(bVar);
            dfVar.c(i);
            return new dc().b(dfVar);
        } catch (bj e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new bj(AMapException.ERROR_UNKNOWN);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int c(df dfVar, boolean z) {
        try {
            d(dfVar);
            int m = dfVar.m();
            int i = bl.e;
            if (dfVar.o() != df.a.FIX) {
                if (dfVar.o() != df.a.SINGLE && m >= i && z) {
                    return i;
                }
            }
            return m;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static df.b a(df dfVar, boolean z) {
        if (dfVar.o() == df.a.FIX) {
            return df.b.FIX_NONDEGRADE;
        }
        if (dfVar.o() == df.a.SINGLE) {
            return df.b.NEVER_GRADE;
        }
        return z ? df.b.FIRST_NONDEGRADE : df.b.NEVER_GRADE;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void d(df dfVar) throws bj {
        if (dfVar != null) {
            if (dfVar.h() == null || "".equals(dfVar.h())) {
                throw new bj("request url is empty");
            }
            return;
        }
        throw new bj("requeust is null");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int a(df dfVar, long j) {
        try {
            d(dfVar);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int m = dfVar.m();
            if (dfVar.o() != df.a.FIX && dfVar.o() != df.a.SINGLE) {
                long j3 = m;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return Math.min(1000, dfVar.m());
            }
            return m;
        } catch (Throwable unused) {
            return 5000;
        }
    }
}
