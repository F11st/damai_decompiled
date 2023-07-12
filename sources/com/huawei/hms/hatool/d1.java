package com.huawei.hms.hatool;

import android.util.Pair;
import com.huawei.secure.android.common.encrypt.hash.SHA;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class d1 extends C5649v {

    /* compiled from: Taobao */
    /* renamed from: com.huawei.hms.hatool.d1$a */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class C5613a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[y0.values().length];
            a = iArr;
            try {
                iArr[y0.SN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[y0.IMEI.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[y0.UDID.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static e1 a(String str, String str2) {
        e1 a = C5649v.a(str, str2);
        x0 c = z0.a().c(str, str2);
        a.g(z0.a().a(AbstractC5609c.c(str, str2)));
        a.f(AbstractC5609c.o(str, str2));
        a.c(z0.a().f(str, str2));
        int i = C5613a.a[c.a().ordinal()];
        if (i == 1) {
            a.d(c.b());
        } else if (i == 2) {
            a.b(c.b());
        } else if (i == 3) {
            a.e(c.b());
        }
        return a;
    }

    public static f1 a(String str, String str2, String str3, String str4) {
        f1 a = C5649v.a(str, str2, str3, str4);
        String a2 = z0.a().a(AbstractC5609c.c(str2, str3));
        long currentTimeMillis = System.currentTimeMillis();
        String sha256Encrypt = SHA.sha256Encrypt(AbstractC5607b.f() + a2 + currentTimeMillis);
        a.f(String.valueOf(currentTimeMillis));
        a.g(sha256Encrypt);
        return a;
    }

    public static g1 a(String str, String str2, String str3) {
        g1 a = C5649v.a(str, str2, str3);
        Pair<String, String> e = z0.a().e(str2, str);
        a.f((String) e.first);
        a.g((String) e.second);
        a.h(AbstractC5616f.b());
        a.d(z0.a().d(str2, str));
        return a;
    }

    public static C5644r a(List<C5642q> list, String str, String str2, String str3, String str4) {
        C5653y.c("hmsSdk", "generate UploadData");
        C5644r b = C5649v.b(str, str2);
        if (b == null) {
            return null;
        }
        b.a(a(C5651x.d().a(), str, str2, str3));
        b.a(a(str, str2));
        b.a(a(str2, str, str4));
        b.a(AbstractC5609c.g(str, str2));
        b.a(list);
        return b;
    }

    public static Map<String, String> b(String str, String str2, String str3) {
        Map<String, String> c = C5649v.c(str, str3);
        Map<String, String> i = AbstractC5609c.i(str, str2);
        if (i == null) {
            return c;
        }
        c.putAll(i);
        return c;
    }
}
