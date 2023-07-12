package tb;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import android.text.TextUtils;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xt2 extends hh0 {
    public static void a(String str, String str2, Object... objArr) {
        if (hh0.g(3)) {
            hh0.a("RxPhenix", v(str2, str), objArr);
        }
    }

    public static void c(String str, String str2, Object... objArr) {
        if (hh0.g(6)) {
            hh0.c("RxPhenix", v(str2, str), objArr);
        }
    }

    public static void f(String str, String str2, Object... objArr) {
        if (hh0.g(4)) {
            hh0.f("RxPhenix", v(str2, str), objArr);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (hh0.g(5)) {
            hh0.i("RxPhenix", v(str2, str), objArr);
        }
    }

    private static void j(StringBuilder sb, String str, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (z && str.startsWith(WVUtils.URL_SEPARATOR)) {
            sb.append("http:");
            sb.append(str.replace("%", "%%"));
            sb.append("?complete=prefix");
            return;
        }
        sb.append(str.replace("%", "%%"));
    }

    public static void k(String str, com.taobao.phenix.request.a aVar, String str2, Object... objArr) {
        if (hh0.g(3)) {
            hh0.a("RxPhenix", u(str2, aVar, str, true), objArr);
        }
    }

    public static void l(String str, String str2, String str3, Object... objArr) {
        if (hh0.g(3)) {
            hh0.a("RxPhenix", w(str, str3, str2, true), objArr);
        }
    }

    public static void m(String str, com.taobao.phenix.request.a aVar, String str2, Object... objArr) {
        if (hh0.g(6)) {
            hh0.c("RxPhenix", u(str2, aVar, str, false), objArr);
        }
    }

    public static void n(String str, String str2, com.taobao.phenix.request.a aVar) {
        o(str, str2, aVar, false);
    }

    public static void o(String str, String str2, com.taobao.phenix.request.a aVar, boolean z) {
        if (hh0.g(6)) {
            StringBuilder sb = new StringBuilder();
            sb.append("[traceId:");
            sb.append(aVar.U().q);
            sb.append("] | ");
            sb.append("[requestId:");
            sb.append(aVar.d());
            sb.append("] |");
            sb.append(str2);
            if (z) {
                sb.append("| ");
                sb.append(aVar.N());
            }
            hh0.b(6, str, sb.toString());
        }
    }

    public static void p(String str, String str2, String str3, Object... objArr) {
        if (hh0.g(6)) {
            hh0.c("RxPhenix", w(str, str3, str2, false), objArr);
        }
    }

    public static void q(String str, com.taobao.phenix.request.a aVar, String str2, Object... objArr) {
        if (hh0.g(4)) {
            hh0.f("RxPhenix", u(str2, aVar, str, true), objArr);
        }
    }

    public static void r(String str, String str2, String str3, Object... objArr) {
        if (hh0.g(4)) {
            hh0.f("RxPhenix", w(str, str3, str2, true), objArr);
        }
    }

    private static int s(String str, int i, String str2, String str3, String str4, boolean z) {
        int length = str != null ? 5 + str.length() : 5;
        if (str4 != null) {
            length += str4.length() + 2;
        }
        if (i > 0) {
            length += 11;
        }
        if (str2 != null) {
            length += str2.length() + 8;
        }
        if (str3 != null) {
            int length2 = length + str3.length() + 7;
            return z ? length2 + 21 : length2;
        }
        return length;
    }

    private static String t(String str, int i, String str2, String str3, String str4, boolean z) {
        StringBuilder sb = new StringBuilder(s(str, i, str2, str3, str4, z));
        sb.append(jn1.ARRAY_START);
        sb.append(str4);
        sb.append(jn1.ARRAY_END);
        if (i > 0) {
            sb.append(" ID=");
            sb.append(i);
        }
        if (str2 != null) {
            sb.append(" MODULE=");
            sb.append(str2);
        }
        if (i <= 0 && str2 == null) {
            sb.append(' ');
        } else {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append(str);
        if (str3 != null) {
            sb.append(", PATH=");
            j(sb, str3, z);
        }
        return sb.substring(0);
    }

    private static String u(String str, com.taobao.phenix.request.a aVar, String str2, boolean z) {
        if (aVar != null) {
            return t(str, aVar.d(), aVar.M(), aVar.N(), str2, z);
        }
        return t(str, -1, null, null, str2, false);
    }

    private static String v(String str, String str2) {
        return t(str, -1, null, null, str2, false);
    }

    private static String w(String str, String str2, String str3, boolean z) {
        return t(str2, -1, null, str3, str, z);
    }

    public static void x(String str, com.taobao.phenix.request.a aVar, String str2, Object... objArr) {
        if (hh0.g(5)) {
            hh0.i("RxPhenix", u(str2, aVar, str, false), objArr);
        }
    }

    public static void y(String str, String str2, String str3, Object... objArr) {
        if (hh0.g(5)) {
            hh0.i("RxPhenix", w(str, str3, str2, false), objArr);
        }
    }
}
