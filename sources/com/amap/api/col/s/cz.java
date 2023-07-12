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
    /* renamed from: com.amap.api.col.s.cz$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC4409a {
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
    public static df.EnumC4424b b(df dfVar, boolean z) {
        return dfVar.o() == df.EnumC4423a.FIX ? z ? df.EnumC4424b.FIX_DEGRADE_BYERROR : df.EnumC4424b.FIX_DEGRADE_ONLY : z ? df.EnumC4424b.DEGRADE_BYERROR : df.EnumC4424b.DEGRADE_ONLY;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static boolean c(df dfVar) throws bj {
        d(dfVar);
        if (b(dfVar)) {
            if (dfVar.h().equals(dfVar.a()) || dfVar.o() == df.EnumC4423a.SINGLE) {
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
        dfVar.a(z ? df.EnumC4425c.HTTPS : df.EnumC4425c.HTTP);
        dg dgVar = null;
        long j = 0;
        boolean z2 = false;
        if (b(dfVar)) {
            boolean c2 = c(dfVar);
            try {
                j = SystemClock.elapsedRealtime();
                dgVar = a(dfVar, a(dfVar, c2), c(dfVar, c2));
            } catch (bj e2) {
                if (e2.f() == 21 && dfVar.o() == df.EnumC4423a.INTERRUPT_IO) {
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

    private static dg a(df dfVar, df.EnumC4424b enumC4424b, int i) throws bj {
        try {
            d(dfVar);
            dfVar.a(enumC4424b);
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
            if (dfVar.o() != df.EnumC4423a.FIX) {
                if (dfVar.o() != df.EnumC4423a.SINGLE && m >= i && z) {
                    return i;
                }
            }
            return m;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static df.EnumC4424b a(df dfVar, boolean z) {
        if (dfVar.o() == df.EnumC4423a.FIX) {
            return df.EnumC4424b.FIX_NONDEGRADE;
        }
        if (dfVar.o() == df.EnumC4423a.SINGLE) {
            return df.EnumC4424b.NEVER_GRADE;
        }
        return z ? df.EnumC4424b.FIRST_NONDEGRADE : df.EnumC4424b.NEVER_GRADE;
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
            if (dfVar.o() != df.EnumC4423a.FIX && dfVar.o() != df.EnumC4423a.SINGLE) {
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
