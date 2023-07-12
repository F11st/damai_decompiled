package tb;

import anet.channel.request.C0193a;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import mtopsdk.network.util.Constants;
import okhttp3.C8816l;
import okhttp3.C8818m;
import okhttp3.C8823o;
import okhttp3.C8827q;
import okhttp3.CookieJar;
import okhttp3.internal.C8753a;
import okio.ByteString;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class g01 {
    static {
        ByteString.encodeUtf8("\"\\");
        ByteString.encodeUtf8("\t ,=");
    }

    public static long a(C8816l c8816l) {
        return j(c8816l.c(Constants.Protocol.CONTENT_LENGTH));
    }

    public static long b(C8827q c8827q) {
        return a(c8827q.j());
    }

    public static boolean c(C8827q c8827q) {
        if (c8827q.q().g().equals(C0193a.C0196c.HEAD)) {
            return false;
        }
        int e = c8827q.e();
        return (((e >= 100 && e < 200) || e == 204 || e == 304) && b(c8827q) == -1 && !"chunked".equalsIgnoreCase(c8827q.g("Transfer-Encoding"))) ? false : true;
    }

    public static boolean d(C8816l c8816l) {
        return k(c8816l).contains(jn1.MUL);
    }

    public static boolean e(C8827q c8827q) {
        return d(c8827q.j());
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

    public static void g(CookieJar cookieJar, C8818m c8818m, C8816l c8816l) {
        if (cookieJar == CookieJar.NO_COOKIES) {
            return;
        }
        List<go> f = go.f(c8818m, c8816l);
        if (f.isEmpty()) {
            return;
        }
        cookieJar.saveFromResponse(c8818m, f);
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

    public static Set<String> k(C8816l c8816l) {
        Set<String> emptySet = Collections.emptySet();
        int h = c8816l.h();
        for (int i = 0; i < h; i++) {
            if ("Vary".equalsIgnoreCase(c8816l.e(i))) {
                String j = c8816l.j(i);
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

    private static Set<String> l(C8827q c8827q) {
        return k(c8827q.j());
    }

    public static C8816l m(C8816l c8816l, C8816l c8816l2) {
        Set<String> k = k(c8816l2);
        if (k.isEmpty()) {
            return C8753a.EMPTY_HEADERS;
        }
        C8816l.C8817a c8817a = new C8816l.C8817a();
        int h = c8816l.h();
        for (int i = 0; i < h; i++) {
            String e = c8816l.e(i);
            if (k.contains(e)) {
                c8817a.a(e, c8816l.j(i));
            }
        }
        return c8817a.e();
    }

    public static C8816l n(C8827q c8827q) {
        return m(c8827q.l().q().e(), c8827q.j());
    }

    public static boolean o(C8827q c8827q, C8816l c8816l, C8823o c8823o) {
        for (String str : l(c8827q)) {
            if (!Objects.equals(c8816l.k(str), c8823o.d(str))) {
                return false;
            }
        }
        return true;
    }
}
