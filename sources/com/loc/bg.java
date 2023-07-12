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
    /* renamed from: com.loc.bg$a */
    /* loaded from: classes10.dex */
    public interface InterfaceC5793a {
        URLConnection a();
    }

    public bg() {
        C5849m.K();
    }

    private static int a(bl blVar, long j) {
        try {
            k(blVar);
            long j2 = 0;
            if (j != 0) {
                j2 = SystemClock.elapsedRealtime() - j;
            }
            int w = blVar.w();
            if (blVar.y() != bl.EnumC5800a.FIX && blVar.y() != bl.EnumC5800a.SINGLE) {
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

    public static t43 c(bl blVar) throws C5844k {
        return e(blVar, blVar.B());
    }

    private static t43 d(bl blVar, bl.EnumC5801b enumC5801b, int i) throws C5844k {
        try {
            k(blVar);
            blVar.e(enumC5801b);
            blVar.o(i);
            return new bj().e(blVar);
        } catch (C5844k e2) {
            throw e2;
        } catch (Throwable th) {
            th.printStackTrace();
            throw new C5844k(AMapException.ERROR_UNKNOWN);
        }
    }

    @Deprecated
    private static t43 e(bl blVar, boolean z) throws C5844k {
        byte[] bArr;
        k(blVar);
        blVar.f(z ? bl.EnumC5802c.HTTPS : bl.EnumC5802c.HTTP);
        t43 t43Var = null;
        long j = 0;
        boolean z2 = false;
        if (g(blVar)) {
            boolean i = i(blVar);
            try {
                j = SystemClock.elapsedRealtime();
                t43Var = d(blVar, f(blVar, i), j(blVar, i));
            } catch (C5844k e2) {
                if (e2.f() == 21 && blVar.y() == bl.EnumC5800a.INTERRUPT_IO) {
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
            } catch (C5844k e3) {
                throw e3;
            }
        }
        return t43Var;
    }

    private static bl.EnumC5801b f(bl blVar, boolean z) {
        if (blVar.y() == bl.EnumC5800a.FIX) {
            return bl.EnumC5801b.FIX_NONDEGRADE;
        }
        if (blVar.y() != bl.EnumC5800a.SINGLE && z) {
            return bl.EnumC5801b.FIRST_NONDEGRADE;
        }
        return bl.EnumC5801b.NEVER_GRADE;
    }

    private static boolean g(bl blVar) throws C5844k {
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
            return C5849m.J(host);
        } catch (Throwable unused) {
            return true;
        }
    }

    private static bl.EnumC5801b h(bl blVar, boolean z) {
        return blVar.y() == bl.EnumC5800a.FIX ? z ? bl.EnumC5801b.FIX_DEGRADE_BYERROR : bl.EnumC5801b.FIX_DEGRADE_ONLY : z ? bl.EnumC5801b.DEGRADE_BYERROR : bl.EnumC5801b.DEGRADE_ONLY;
    }

    private static boolean i(bl blVar) throws C5844k {
        k(blVar);
        if (g(blVar)) {
            if (blVar.j().equals(blVar.m()) || blVar.y() == bl.EnumC5800a.SINGLE) {
                return false;
            }
            return C5849m.v;
        }
        return true;
    }

    private static int j(bl blVar, boolean z) {
        try {
            k(blVar);
            int w = blVar.w();
            int i = C5849m.r;
            if (blVar.y() != bl.EnumC5800a.FIX) {
                if (blVar.y() != bl.EnumC5800a.SINGLE && w >= i && z) {
                    return i;
                }
            }
            return w;
        } catch (Throwable unused) {
            return 5000;
        }
    }

    private static void k(bl blVar) throws C5844k {
        if (blVar == null) {
            throw new C5844k("requeust is null");
        }
        if (blVar.j() == null || "".equals(blVar.j())) {
            throw new C5844k("request url is empty");
        }
    }
}
