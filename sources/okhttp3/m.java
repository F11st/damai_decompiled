package okhttp3;

import android.taobao.windvane.jsbridge.utils.WVUtils;
import com.youku.upsplayer.util.YKUpsConvert;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import javax.annotation.Nullable;
import okio.Buffer;
import tb.jg1;
import tb.jn1;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class m {
    private static final char[] j = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
    final String a;
    private final String b;
    private final String c;
    final String d;
    final int e;
    private final List<String> f;
    @Nullable
    private final List<String> g;
    @Nullable
    private final String h;
    private final String i;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class a {
        @Nullable
        String a;
        @Nullable
        String d;
        final List<String> f;
        @Nullable
        List<String> g;
        @Nullable
        String h;
        String b = "";
        String c = "";
        int e = -1;

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        @Nullable
        private static String b(String str, int i, int i2) {
            return okhttp3.internal.a.d(m.s(str, i, i2, false));
        }

        private boolean f(String str) {
            return str.equals(".") || str.equalsIgnoreCase("%2e");
        }

        private boolean g(String str) {
            return str.equals("..") || str.equalsIgnoreCase("%2e.") || str.equalsIgnoreCase(".%2e") || str.equalsIgnoreCase("%2e%2e");
        }

        private static int i(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(m.a(str, i, i2, "", false, false, false, true, null));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        private void k() {
            List<String> list = this.f;
            if (list.remove(list.size() - 1).isEmpty() && !this.f.isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, "");
                return;
            }
            this.f.add("");
        }

        private static int m(String str, int i, int i2) {
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt == ':') {
                    return i;
                }
                if (charAt == '[') {
                    do {
                        i++;
                        if (i < i2) {
                        }
                    } while (str.charAt(i) != ']');
                }
                i++;
            }
            return i2;
        }

        private void n(String str, int i, int i2, boolean z, boolean z2) {
            String a = m.a(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true, null);
            if (f(a)) {
                return;
            }
            if (g(a)) {
                k();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, a);
            } else {
                this.f.add(a);
            }
            if (z) {
                this.f.add("");
            }
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:56)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:30)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:18)
            */
        /* JADX WARN: Removed duplicated region for block: B:13:0x002c  */
        /* JADX WARN: Removed duplicated region for block: B:21:0x0044 A[SYNTHETIC] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x0041 -> B:11:0x0029). Please submit an issue!!! */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private void p(java.lang.String r11, int r12, int r13) {
            /*
                r10 = this;
                if (r12 != r13) goto L3
                return
            L3:
                char r0 = r11.charAt(r12)
                r1 = 47
                java.lang.String r2 = ""
                r3 = 1
                if (r0 == r1) goto L1e
                r1 = 92
                if (r0 != r1) goto L13
                goto L1e
            L13:
                java.util.List<java.lang.String> r0 = r10.f
                int r1 = r0.size()
                int r1 = r1 - r3
                r0.set(r1, r2)
                goto L29
            L1e:
                java.util.List<java.lang.String> r0 = r10.f
                r0.clear()
                java.util.List<java.lang.String> r0 = r10.f
                r0.add(r2)
                goto L41
            L29:
                r6 = r12
                if (r6 >= r13) goto L44
                java.lang.String r12 = "/\\"
                int r12 = okhttp3.internal.a.o(r11, r6, r13, r12)
                if (r12 >= r13) goto L36
                r0 = 1
                goto L37
            L36:
                r0 = 0
            L37:
                r9 = 1
                r4 = r10
                r5 = r11
                r7 = r12
                r8 = r0
                r4.n(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: okhttp3.m.a.p(java.lang.String, int, int):void");
        }

        private static int r(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            if ((charAt >= 'a' && charAt <= 'z') || (charAt >= 'A' && charAt <= 'Z')) {
                while (true) {
                    i++;
                    if (i >= i2) {
                        break;
                    }
                    char charAt2 = str.charAt(i);
                    if (charAt2 < 'a' || charAt2 > 'z') {
                        if (charAt2 < 'A' || charAt2 > 'Z') {
                            if (charAt2 < '0' || charAt2 > '9') {
                                if (charAt2 != '+' && charAt2 != '-' && charAt2 != '.') {
                                    if (charAt2 == ':') {
                                        return i;
                                    }
                                }
                            }
                        }
                    }
                }
            }
            return -1;
        }

        private static int s(String str, int i, int i2) {
            int i3 = 0;
            while (i < i2) {
                char charAt = str.charAt(i);
                if (charAt != '\\' && charAt != '/') {
                    break;
                }
                i3++;
                i++;
            }
            return i3;
        }

        public m a() {
            if (this.a != null) {
                if (this.d != null) {
                    return new m(this);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        int c() {
            int i = this.e;
            return i != -1 ? i : m.e(this.a);
        }

        public a d(@Nullable String str) {
            this.g = str != null ? m.z(m.b(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a e(String str) {
            Objects.requireNonNull(str, "host == null");
            String b = b(str, 0, str.length());
            if (b != null) {
                this.d = b;
                return this;
            }
            throw new IllegalArgumentException("unexpected host: " + str);
        }

        a h(@Nullable m mVar, String str) {
            int r;
            int o;
            int i;
            int G = okhttp3.internal.a.G(str, 0, str.length());
            int H = okhttp3.internal.a.H(str, G, str.length());
            if (r(str, G, H) != -1) {
                if (str.regionMatches(true, G, "https:", 0, 6)) {
                    this.a = "https";
                    G += 6;
                } else if (str.regionMatches(true, G, "http:", 0, 5)) {
                    this.a = "http";
                    G += 5;
                } else {
                    throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but was '" + str.substring(0, r) + "'");
                }
            } else if (mVar != null) {
                this.a = mVar.a;
            } else {
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no colon was found");
            }
            int s = s(str, G, H);
            char c = jn1.CONDITION_IF;
            char c2 = '#';
            if (s < 2 && mVar != null && mVar.a.equals(this.a)) {
                this.b = mVar.k();
                this.c = mVar.g();
                this.d = mVar.d;
                this.e = mVar.e;
                this.f.clear();
                this.f.addAll(mVar.i());
                if (G == H || str.charAt(G) == '#') {
                    d(mVar.j());
                }
            } else {
                int i2 = G + s;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    o = okhttp3.internal.a.o(str, i2, H, "@/\\?#");
                    char charAt = o != H ? str.charAt(o) : (char) 65535;
                    if (charAt == 65535 || charAt == c2 || charAt == '/' || charAt == '\\' || charAt == c) {
                        break;
                    }
                    if (charAt == '@') {
                        if (!z) {
                            int n = okhttp3.internal.a.n(str, i2, o, jn1.CONDITION_IF_MIDDLE);
                            i = o;
                            String a = m.a(str, i2, n, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                            if (z2) {
                                a = this.b + "%40" + a;
                            }
                            this.b = a;
                            if (n != i) {
                                this.c = m.a(str, n + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                                z = true;
                            }
                            z2 = true;
                        } else {
                            i = o;
                            this.c += "%40" + m.a(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true, null);
                        }
                        i2 = i + 1;
                    }
                    c = jn1.CONDITION_IF;
                    c2 = '#';
                }
                int m = m(str, i2, o);
                int i3 = m + 1;
                if (i3 < o) {
                    this.d = b(str, i2, m);
                    int i4 = i(str, i3, o);
                    this.e = i4;
                    if (i4 == -1) {
                        throw new IllegalArgumentException("Invalid URL port: \"" + str.substring(i3, o) + jn1.QUOTE);
                    }
                } else {
                    this.d = b(str, i2, m);
                    this.e = m.e(this.a);
                }
                if (this.d == null) {
                    throw new IllegalArgumentException("Invalid URL host: \"" + str.substring(i2, m) + jn1.QUOTE);
                }
                G = o;
            }
            int o2 = okhttp3.internal.a.o(str, G, H, "?#");
            p(str, G, o2);
            if (o2 < H && str.charAt(o2) == '?') {
                int n2 = okhttp3.internal.a.n(str, o2, H, '#');
                this.g = m.z(m.a(str, o2 + 1, n2, " \"'<>#", true, false, true, true, null));
                o2 = n2;
            }
            if (o2 < H && str.charAt(o2) == '#') {
                this.h = m.a(str, 1 + o2, H, "", true, false, false, false, null);
            }
            return this;
        }

        public a j(String str) {
            Objects.requireNonNull(str, "password == null");
            this.c = m.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public a l(int i) {
            if (i > 0 && i <= 65535) {
                this.e = i;
                return this;
            }
            throw new IllegalArgumentException("unexpected port: " + i);
        }

        a o() {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                this.f.set(i, m.b(this.f.get(i), "[]", true, true, false, true));
            }
            List<String> list = this.g;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str = this.g.get(i2);
                    if (str != null) {
                        this.g.set(i2, m.b(str, "\\^`{|}", true, true, true, true));
                    }
                }
            }
            String str2 = this.h;
            if (str2 != null) {
                this.h = m.b(str2, " \"#<>\\^`{|}", true, true, false, false);
            }
            return this;
        }

        public a q(String str) {
            Objects.requireNonNull(str, "scheme == null");
            if (str.equalsIgnoreCase("http")) {
                this.a = "http";
            } else if (str.equalsIgnoreCase("https")) {
                this.a = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + str);
            }
            return this;
        }

        public a t(String str) {
            Objects.requireNonNull(str, "username == null");
            this.b = m.b(str, " \"':;<=>@[]^`{}|/\\?#", false, false, false, true);
            return this;
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            String str = this.a;
            if (str != null) {
                sb.append(str);
                sb.append(jg1.SCHEME_SLASH);
            } else {
                sb.append(WVUtils.URL_SEPARATOR);
            }
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(jn1.CONDITION_IF_MIDDLE);
                    sb.append(this.c);
                }
                sb.append('@');
            }
            String str2 = this.d;
            if (str2 != null) {
                if (str2.indexOf(58) != -1) {
                    sb.append(jn1.ARRAY_START);
                    sb.append(this.d);
                    sb.append(jn1.ARRAY_END);
                } else {
                    sb.append(this.d);
                }
            }
            if (this.e != -1 || this.a != null) {
                int c = c();
                String str3 = this.a;
                if (str3 == null || c != m.e(str3)) {
                    sb.append(jn1.CONDITION_IF_MIDDLE);
                    sb.append(c);
                }
            }
            m.r(sb, this.f);
            if (this.g != null) {
                sb.append(jn1.CONDITION_IF);
                m.o(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    m(a aVar) {
        this.a = aVar.a;
        this.b = t(aVar.b, false);
        this.c = t(aVar.c, false);
        this.d = aVar.d;
        this.e = aVar.c();
        this.f = u(aVar.f, false);
        List<String> list = aVar.g;
        this.g = list != null ? u(list, true) : null;
        String str = aVar.h;
        this.h = str != null ? t(str, false) : null;
        this.i = aVar.toString();
    }

    static String a(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt >= 32 && codePointAt != 127 && (codePointAt < 128 || !z4)) {
                if (str2.indexOf(codePointAt) == -1 && ((codePointAt != 37 || (z && (!z2 || w(str, i3, i2)))) && (codePointAt != 43 || !z3))) {
                    i3 += Character.charCount(codePointAt);
                }
            }
            Buffer buffer = new Buffer();
            buffer.writeUtf8(str, i, i3);
            d(buffer, str, i3, i2, str2, z, z2, z3, z4, charset);
            return buffer.readUtf8();
        }
        return str.substring(i, i2);
    }

    static String b(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, null);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String c(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        return a(str, 0, str.length(), str2, z, z2, z3, z4, charset);
    }

    static void d(Buffer buffer, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Charset charset) {
        Buffer buffer2 = null;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (!z || (codePointAt != 9 && codePointAt != 10 && codePointAt != 12 && codePointAt != 13)) {
                if (codePointAt == 43 && z3) {
                    buffer.writeUtf8(z ? jn1.PLUS : "%2B");
                } else if (codePointAt >= 32 && codePointAt != 127 && ((codePointAt < 128 || !z4) && str2.indexOf(codePointAt) == -1 && (codePointAt != 37 || (z && (!z2 || w(str, i, i2)))))) {
                    buffer.writeUtf8CodePoint(codePointAt);
                } else {
                    if (buffer2 == null) {
                        buffer2 = new Buffer();
                    }
                    if (charset != null && !charset.equals(StandardCharsets.UTF_8)) {
                        buffer2.writeString(str, i, Character.charCount(codePointAt) + i, charset);
                    } else {
                        buffer2.writeUtf8CodePoint(codePointAt);
                    }
                    while (!buffer2.exhausted()) {
                        int readByte = buffer2.readByte() & 255;
                        buffer.writeByte(37);
                        char[] cArr = j;
                        buffer.writeByte((int) cArr[(readByte >> 4) & 15]);
                        buffer.writeByte((int) cArr[readByte & 15]);
                    }
                }
            }
            i += Character.charCount(codePointAt);
        }
    }

    public static int e(String str) {
        if (str.equals("http")) {
            return 80;
        }
        return str.equals("https") ? 443 : -1;
    }

    public static m l(String str) {
        return new a().h(null, str).a();
    }

    static void o(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i += 2) {
            String str = list.get(i);
            String str2 = list.get(i + 1);
            if (i > 0) {
                sb.append('&');
            }
            sb.append(str);
            if (str2 != null) {
                sb.append(com.alipay.sdk.m.n.a.h);
                sb.append(str2);
            }
        }
    }

    static void r(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(r10.DIR);
            sb.append(list.get(i));
        }
    }

    static String s(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            if (charAt == '%' || (charAt == '+' && z)) {
                Buffer buffer = new Buffer();
                buffer.writeUtf8(str, i, i3);
                v(buffer, str, i3, i2, z);
                return buffer.readUtf8();
            }
        }
        return str.substring(i, i2);
    }

    static String t(String str, boolean z) {
        return s(str, 0, str.length(), z);
    }

    private List<String> u(List<String> list, boolean z) {
        int size = list.size();
        ArrayList arrayList = new ArrayList(size);
        for (int i = 0; i < size; i++) {
            String str = list.get(i);
            arrayList.add(str != null ? t(str, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    static void v(Buffer buffer, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt == 37 && (i3 = i + 2) < i2) {
                int k = okhttp3.internal.a.k(str.charAt(i + 1));
                int k2 = okhttp3.internal.a.k(str.charAt(i3));
                if (k != -1 && k2 != -1) {
                    buffer.writeByte((k << 4) + k2);
                    i = i3;
                }
                buffer.writeUtf8CodePoint(codePointAt);
            } else {
                if (codePointAt == 43 && z) {
                    buffer.writeByte(32);
                }
                buffer.writeUtf8CodePoint(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static boolean w(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && okhttp3.internal.a.k(str.charAt(i + 1)) != -1 && okhttp3.internal.a.k(str.charAt(i3)) != -1;
    }

    static List<String> z(String str) {
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 != -1 && indexOf2 <= indexOf) {
                arrayList.add(str.substring(i, indexOf2));
                arrayList.add(str.substring(indexOf2 + 1, indexOf));
            } else {
                arrayList.add(str.substring(i, indexOf));
                arrayList.add(null);
            }
            i = indexOf + 1;
        }
        return arrayList;
    }

    public String A() {
        return q("/...").t("").j("").a().toString();
    }

    @Nullable
    public m B(String str) {
        a q = q(str);
        if (q != null) {
            return q.a();
        }
        return null;
    }

    public String C() {
        return this.a;
    }

    public URI D() {
        String aVar = p().o().toString();
        try {
            return new URI(aVar);
        } catch (URISyntaxException e) {
            try {
                return URI.create(aVar.replaceAll("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]", ""));
            } catch (Exception unused) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean equals(@Nullable Object obj) {
        return (obj instanceof m) && ((m) obj).i.equals(this.i);
    }

    @Nullable
    public String f() {
        if (this.h == null) {
            return null;
        }
        return this.i.substring(this.i.indexOf(35) + 1);
    }

    public String g() {
        if (this.c.isEmpty()) {
            return "";
        }
        int indexOf = this.i.indexOf(64);
        return this.i.substring(this.i.indexOf(58, this.a.length() + 3) + 1, indexOf);
    }

    public String h() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.a.o(str, indexOf, str.length(), "?#"));
    }

    public int hashCode() {
        return this.i.hashCode();
    }

    public List<String> i() {
        int indexOf = this.i.indexOf(47, this.a.length() + 3);
        String str = this.i;
        int o = okhttp3.internal.a.o(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < o) {
            int i = indexOf + 1;
            int n = okhttp3.internal.a.n(this.i, i, o, r10.DIR);
            arrayList.add(this.i.substring(i, n));
            indexOf = n;
        }
        return arrayList;
    }

    @Nullable
    public String j() {
        if (this.g == null) {
            return null;
        }
        int indexOf = this.i.indexOf(63) + 1;
        String str = this.i;
        return this.i.substring(indexOf, okhttp3.internal.a.n(str, indexOf, str.length(), '#'));
    }

    public String k() {
        if (this.b.isEmpty()) {
            return "";
        }
        int length = this.a.length() + 3;
        String str = this.i;
        return this.i.substring(length, okhttp3.internal.a.o(str, length, str.length(), ":@"));
    }

    public String m() {
        return this.d;
    }

    public boolean n() {
        return this.a.equals("https");
    }

    public a p() {
        a aVar = new a();
        aVar.a = this.a;
        aVar.b = k();
        aVar.c = g();
        aVar.d = this.d;
        aVar.e = this.e != e(this.a) ? this.e : -1;
        aVar.f.clear();
        aVar.f.addAll(i());
        aVar.d(j());
        aVar.h = f();
        return aVar;
    }

    @Nullable
    public a q(String str) {
        try {
            return new a().h(this, str);
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }

    public String toString() {
        return this.i;
    }

    public int x() {
        return this.e;
    }

    @Nullable
    public String y() {
        if (this.g == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        o(sb, this.g);
        return sb.toString();
    }
}
