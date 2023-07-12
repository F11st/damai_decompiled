package com.loc;

import android.os.SystemClock;
import android.text.TextUtils;
import com.amap.api.maps.AMapException;
import com.loc.bl;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import tb.t43;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class bg {
    public static int a = 0;
    public static String b = "";
    public static HashMap<String, String> c;
    public static HashMap<String, String> d;
    public static HashMap<String, String> e;
    private static bg f;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public interface a {
        URLConnection a();
    }

    public bg() {
        m.K();
    }

    private static int a(bl blVar, long j) {
        try {
            k(blVar);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int w = blVar.w();
            if (blVar.y() != bl.a.FIX && blVar.y() != bl.a.SINGLE) {
                long j3 = w;
                if (j2 < j3) {
                    long j4 = j3 - j2;
                    if (j4 >= 1000) {
                        return (int) j4;
                    }
                }
                return Math.min(1000, blVar.w());
            }
            return w;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    public static bg b() {
        if (f == null) {
            f = new bg();
        }
        return f;
    }

    public static t43 c(bl blVar) throws k {
        return e(blVar, blVar.B());
    }

    private static t43 d(bl blVar, bl.b bVar, int i) throws k {
        try {
            k(blVar);
            blVar.e(bVar);
            blVar.o(i);
            return new bj().e(blVar);
        } catch (k e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new k(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    private static t43 e(bl blVar, boolean z) throws k {
        byte[] bArr;
        k(blVar);
        blVar.f(z ? bl.c.HTTPS : bl.c.HTTP);
        t43 t43Var = null;
        long j = 0;
        boolean z2 = false;
        if (g(blVar)) {
            boolean i = i(blVar);
            try {
                j = SystemClock.elapsedRealtime();
                t43Var = d(blVar, f(blVar, i), j(blVar, i));
            } catch (k e2) {
                if (e2.f() == 21 && blVar.y() == bl.a.INTERRUPT_IO) {
                    throw e2;
                }
                if (!i) {
                    throw e2;
                }
                z2 = true;
            }
        }
        if (t43Var == null || (bArr = t43Var.a) == null || bArr.length <= 0) {
            try {
                return d(blVar, h(blVar, z2), a(blVar, j));
            } catch (k e3) {
                throw e3;
            }
        }
        return t43Var;
    }

    private static bl.b f(bl blVar, boolean z) {
        if (blVar.y() == bl.a.FIX) {
            return bl.b.FIX_NONDEGRADE;
        }
        if (blVar.y() != bl.a.SINGLE && z) {
            return bl.b.FIRST_NONDEGRADE;
        }
        return bl.b.NEVER_GRADE;
    }

    private static boolean g(bl blVar) throws k {
        k(blVar);
        try {
            String m = blVar.m();
            if (TextUtils.isEmpty(m)) {
                return false;
            }
            String host = new URL(m).getHost();
            if (!TextUtils.isEmpty(blVar.s())) {
                host = blVar.s();
            }
            return m.J(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static bl.b h(bl blVar, boolean z) {
        return blVar.y() == bl.a.FIX ? z ? bl.b.FIX_DEGRADE_BYERROR : bl.b.FIX_DEGRADE_ONLY : z ? bl.b.DEGRADE_BYERROR : bl.b.DEGRADE_ONLY;
    }

    private static boolean i(bl blVar) throws k {
        k(blVar);
        if (g(blVar)) {
            if (blVar.j().equals(blVar.m()) || blVar.y() == bl.a.SINGLE) {
                return false;
            }
            return m.v;
        }
        return true;
    }

    private static int j(bl blVar, boolean z) {
        try {
            k(blVar);
            int w = blVar.w();
            int i = m.r;
            if (blVar.y() != bl.a.FIX) {
                if (blVar.y() != bl.a.SINGLE && w >= i && z) {
                    return i;
                }
            }
            return w;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    private static void k(bl blVar) throws k {
        if (blVar == null) {
            throw new k("requeust is null");
        }
        if (blVar.j() == null || "".equals(blVar.j())) {
            throw new k("request url is empty");
        }
    }
}
