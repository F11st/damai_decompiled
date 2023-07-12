package tb;

import anet.channel.request.a;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import mtopsdk.network.util.Constants;
import okhttp3.CookieJar;
import okhttp3.l;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class g01 {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long a(okhttp3.l lVar) {
        return j(lVar.c(Constants.Protocol.CONTENT_LENGTH));
    }

    public static long b(okhttp3.q qVar) {
        return a(qVar.j());
    }

    public static boolean c(okhttp3.q qVar) {
        if (qVar.q().g().equals(a.c.HEAD)) {
            return false;
        }
        int e = qVar.e();
        return (((e >= 100 && e < 200) || e == 204 || e == 304) && b(qVar) == -1 && !"chunked".equalsIgnoreCase(qVar.g("Transfer-Encoding"))) ? false : true;
    }

    public static boolean d(okhttp3.l lVar) {
        return k(lVar).contains(jn1.MUL);
    }

    public static boolean e(okhttp3.q qVar) {
        return d(qVar.j());
    }

    public static int f(String str, int i) {
        try {
            long parseLong = Long.parseLong(str);
            if (parseLong > 2147483647L) {
                return Integer.MAX_VALUE;
            }
            if (parseLong < 0) {
                return 0;
            }
            return (int) parseLong;
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static void g(CookieJar cookieJar, okhttp3.m mVar, okhttp3.l lVar) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<go> f = go.f(mVar, lVar);
        if (f.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(mVar, f);
    }

    public static int h(String str, int i, String str2) {
        while (i < str.length() && str2.indexOf(str.charAt(i)) == -1) {
            i++;
        }
        return i;
    }

    public static int i(String str, int i) {
        char charAt;
        while (i < str.length() && ((charAt = str.charAt(i)) == ' ' || charAt == '\t')) {
            i++;
        }
        return i;
    }

    private static long j(String str) {
        if (str == null) {
            return -1L;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1L;
        }
    }

    public static Set<String> k(okhttp3.l lVar) {
        Set<String> emptySet = Collections.emptySet();
        int h = lVar.h();
        for (int i = 0; i < h; i++) {
            if ("Vary".equalsIgnoreCase(lVar.e(i))) {
                String j = lVar.j(i);
                if (emptySet.isEmpty()) {
                    emptySet = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
                }
                for (String str : j.split(",")) {
                    emptySet.add(str.trim());
                }
            }
        }
        return emptySet;
    }

    private static Set<String> l(okhttp3.q qVar) {
        return k(qVar.j());
    }

    public static okhttp3.l m(okhttp3.l lVar, okhttp3.l lVar2) {
        Set<String> k = k(lVar2);
        if (k.isEmpty()) {
            return okhttp3.internal.a.EMPTY_HEADERS;
        }
        l.a aVar = new l.a();
        int h = lVar.h();
        for (int i = 0; i < h; i++) {
            String e = lVar.e(i);
            if (k.contains(e)) {
                aVar.a(e, lVar.j(i));
            }
        }
        return aVar.e();
    }

    public static okhttp3.l n(okhttp3.q qVar) {
        return m(qVar.l().q().e(), qVar.j());
    }

    public static boolean o(okhttp3.q qVar, okhttp3.l lVar, okhttp3.o oVar) {
        for (String str : l(qVar)) {
            if (!Objects.equals(lVar.k(str), oVar.d(str))) {
                return false;
            }
        }
        return true;
    }
}
