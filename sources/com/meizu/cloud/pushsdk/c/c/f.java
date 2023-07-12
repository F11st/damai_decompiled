package com.meizu.cloud.pushsdk.c.c;

import com.youku.upsplayer.util.YKUpsConvert;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import tb.jg1;
import tb.jn1;
import tb.qb1;
import tb.r10;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class f {
    private static final char[] a = {YKUpsConvert.CHAR_ZERO, '1', '2', '3', '4', '5', '6', '7', '8', YKUpsConvert.CHAR_NINE, YKUpsConvert.CHAR_A, 'B', 'C', qb1.LEVEL_D, qb1.LEVEL_E, YKUpsConvert.CHAR_F};
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final int f;
    private final List<String> g;
    private final List<String> h;
    private final String i;
    private final String j;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.meizu.cloud.pushsdk.c.c.f$1  reason: invalid class name */
    /* loaded from: classes10.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[a.EnumC0260a.values().length];
            a = iArr;
            try {
                iArr[a.EnumC0260a.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[a.EnumC0260a.INVALID_HOST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[a.EnumC0260a.UNSUPPORTED_SCHEME.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[a.EnumC0260a.MISSING_SCHEME.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[a.EnumC0260a.INVALID_PORT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static final class a {
        String a;
        String d;
        final List<String> f;
        List<String> g;
        String h;
        String b = "";
        String c = "";
        int e = -1;

        /* JADX INFO: Access modifiers changed from: package-private */
        /* compiled from: Taobao */
        /* renamed from: com.meizu.cloud.pushsdk.c.c.f$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public enum EnumC0260a {
            SUCCESS,
            MISSING_SCHEME,
            UNSUPPORTED_SCHEME,
            INVALID_PORT,
            INVALID_HOST
        }

        public a() {
            ArrayList arrayList = new ArrayList();
            this.f = arrayList;
            arrayList.add("");
        }

        private static String a(byte[] bArr) {
            int i = 0;
            int i2 = -1;
            int i3 = 0;
            int i4 = 0;
            while (i3 < bArr.length) {
                int i5 = i3;
                while (i5 < 16 && bArr[i5] == 0 && bArr[i5 + 1] == 0) {
                    i5 += 2;
                }
                int i6 = i5 - i3;
                if (i6 > i4) {
                    i2 = i3;
                    i4 = i6;
                }
                i3 = i5 + 2;
            }
            com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
            while (i < bArr.length) {
                if (i == i2) {
                    bVar.b(58);
                    i += i4;
                    if (i == 16) {
                        bVar.b(58);
                    }
                } else {
                    if (i > 0) {
                        bVar.b(58);
                    }
                    bVar.d(((bArr[i] & 255) << 8) | (bArr[i + 1] & 255));
                    i += 2;
                }
            }
            return bVar.h();
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
        private void a(java.lang.String r11, int r12, int r13) {
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
                int r12 = com.meizu.cloud.pushsdk.c.c.m.a(r11, r6, r13, r12)
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
                r4.a(r5, r6, r7, r8, r9)
                if (r0 == 0) goto L29
            L41:
                int r12 = r12 + 1
                goto L29
            L44:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.a(java.lang.String, int, int):void");
        }

        private void a(String str, int i, int i2, boolean z, boolean z2) {
            String b = f.b(str, i, i2, " \"<>^`{}|/\\?#", z2, false, false, true);
            if (b(b)) {
                return;
            }
            if (c(b)) {
                c();
                return;
            }
            List<String> list = this.f;
            if (list.get(list.size() - 1).isEmpty()) {
                List<String> list2 = this.f;
                list2.set(list2.size() - 1, b);
            } else {
                this.f.add(b);
            }
            if (z) {
                this.f.add("");
            }
        }

        private static boolean a(String str, int i, int i2, byte[] bArr, int i3) {
            int i4 = i3;
            while (i < i2) {
                if (i4 == bArr.length) {
                    return false;
                }
                if (i4 != i3) {
                    if (str.charAt(i) != '.') {
                        return false;
                    }
                    i++;
                }
                int i5 = i;
                int i6 = 0;
                while (i5 < i2) {
                    char charAt = str.charAt(i5);
                    if (charAt < '0' || charAt > '9') {
                        break;
                    } else if ((i6 == 0 && i != i5) || (i6 = ((i6 * 10) + charAt) - 48) > 255) {
                        return false;
                    } else {
                        i5++;
                    }
                }
                if (i5 - i == 0) {
                    return false;
                }
                bArr[i4] = (byte) i6;
                i4++;
                i = i5;
            }
            return i4 == i3 + 4;
        }

        private static int b(String str, int i, int i2) {
            if (i2 - i < 2) {
                return -1;
            }
            char charAt = str.charAt(i);
            boolean z = false;
            boolean z2 = charAt < 'a' || charAt > 'z';
            z = (charAt < 'A' || charAt > 'Z') ? true : true;
            if (z2 && z) {
                return -1;
            }
            for (int i3 = i + 1; i3 < i2; i3++) {
                char charAt2 = str.charAt(i3);
                if ((charAt2 < 'a' || charAt2 > 'z') && ((charAt2 < 'A' || charAt2 > 'Z') && !((charAt2 >= '0' && charAt2 <= '9') || charAt2 == '+' || charAt2 == '-' || charAt2 == '.'))) {
                    if (charAt2 == ':') {
                        return i3;
                    }
                    return -1;
                }
            }
            return -1;
        }

        private boolean b(String str) {
            return ".".equals(str) || "%2e".equalsIgnoreCase(str);
        }

        private static int c(String str, int i, int i2) {
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

        private void c() {
            List<String> list = this.f;
            if (!list.remove(list.size() - 1).isEmpty() || this.f.isEmpty()) {
                this.f.add("");
                return;
            }
            List<String> list2 = this.f;
            list2.set(list2.size() - 1, "");
        }

        private boolean c(String str) {
            return "..".equals(str) || "%2e.".equalsIgnoreCase(str) || ".%2e".equalsIgnoreCase(str) || "%2e%2e".equalsIgnoreCase(str);
        }

        private static int d(String str, int i, int i2) {
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

        private static String e(String str, int i, int i2) {
            String b = f.b(str, i, i2, false);
            if (b.contains(":")) {
                InetAddress f = (b.startsWith(jn1.ARRAY_START_STR) && b.endsWith(jn1.ARRAY_END_STR)) ? f(b, 1, b.length() - 1) : f(b, 0, b.length());
                if (f == null) {
                    return null;
                }
                byte[] address = f.getAddress();
                if (address.length == 16) {
                    return a(address);
                }
                throw new AssertionError();
            }
            return m.a(b);
        }

        /* JADX WARN: Code restructure failed: missing block: B:41:0x0079, code lost:
            return null;
         */
        /* JADX WARN: Removed duplicated region for block: B:31:0x004f  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        private static java.net.InetAddress f(java.lang.String r11, int r12, int r13) {
            /*
                r0 = 16
                byte[] r1 = new byte[r0]
                r2 = -1
                r3 = 0
                r4 = 0
                r5 = -1
                r6 = -1
            L9:
                r7 = 0
                if (r12 >= r13) goto L7a
                if (r4 != r0) goto Lf
                return r7
            Lf:
                int r8 = r12 + 2
                if (r8 > r13) goto L27
                java.lang.String r9 = "::"
                r10 = 2
                boolean r9 = r11.regionMatches(r12, r9, r3, r10)
                if (r9 == 0) goto L27
                if (r5 == r2) goto L1f
                return r7
            L1f:
                int r4 = r4 + 2
                r5 = r4
                if (r8 != r13) goto L25
                goto L7a
            L25:
                r6 = r8
                goto L4b
            L27:
                if (r4 == 0) goto L4a
                java.lang.String r8 = ":"
                r9 = 1
                boolean r8 = r11.regionMatches(r12, r8, r3, r9)
                if (r8 == 0) goto L35
                int r12 = r12 + 1
                goto L4a
            L35:
                java.lang.String r8 = "."
                boolean r12 = r11.regionMatches(r12, r8, r3, r9)
                if (r12 == 0) goto L49
                int r12 = r4 + (-2)
                boolean r11 = a(r11, r6, r13, r1, r12)
                if (r11 != 0) goto L46
                return r7
            L46:
                int r4 = r4 + 2
                goto L7a
            L49:
                return r7
            L4a:
                r6 = r12
            L4b:
                r12 = r6
                r8 = 0
            L4d:
                if (r12 >= r13) goto L60
                char r9 = r11.charAt(r12)
                int r9 = com.meizu.cloud.pushsdk.c.c.f.a(r9)
                if (r9 != r2) goto L5a
                goto L60
            L5a:
                int r8 = r8 << 4
                int r8 = r8 + r9
                int r12 = r12 + 1
                goto L4d
            L60:
                int r9 = r12 - r6
                if (r9 == 0) goto L79
                r10 = 4
                if (r9 <= r10) goto L68
                goto L79
            L68:
                int r7 = r4 + 1
                int r9 = r8 >>> 8
                r9 = r9 & 255(0xff, float:3.57E-43)
                byte r9 = (byte) r9
                r1[r4] = r9
                int r4 = r7 + 1
                r8 = r8 & 255(0xff, float:3.57E-43)
                byte r8 = (byte) r8
                r1[r7] = r8
                goto L9
            L79:
                return r7
            L7a:
                if (r4 == r0) goto L8b
                if (r5 != r2) goto L7f
                return r7
            L7f:
                int r11 = r4 - r5
                int r12 = 16 - r11
                java.lang.System.arraycopy(r1, r5, r1, r12, r11)
                int r0 = r0 - r4
                int r0 = r0 + r5
                java.util.Arrays.fill(r1, r5, r0, r3)
            L8b:
                java.net.InetAddress r11 = java.net.InetAddress.getByAddress(r1)     // Catch: java.net.UnknownHostException -> L90
                return r11
            L90:
                java.lang.AssertionError r11 = new java.lang.AssertionError
                r11.<init>()
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.meizu.cloud.pushsdk.c.c.f.a.f(java.lang.String, int, int):java.net.InetAddress");
        }

        private static int g(String str, int i, int i2) {
            int parseInt;
            try {
                parseInt = Integer.parseInt(f.b(str, i, i2, "", false, false, false, true));
            } catch (NumberFormatException unused) {
            }
            if (parseInt <= 0 || parseInt > 65535) {
                return -1;
            }
            return parseInt;
        }

        int a() {
            int i = this.e;
            return i != -1 ? i : f.a(this.a);
        }

        EnumC0260a a(f fVar, String str) {
            int a;
            int i;
            int a2 = m.a(str, 0, str.length());
            int b = m.b(str, a2, str.length());
            if (b(str, a2, b) != -1) {
                if (str.regionMatches(true, a2, "https:", 0, 6)) {
                    this.a = "https";
                    a2 += 6;
                } else if (!str.regionMatches(true, a2, "http:", 0, 5)) {
                    return EnumC0260a.UNSUPPORTED_SCHEME;
                } else {
                    this.a = "http";
                    a2 += 5;
                }
            } else if (fVar == null) {
                return EnumC0260a.MISSING_SCHEME;
            } else {
                this.a = fVar.b;
            }
            int c = c(str, a2, b);
            char c2 = jn1.CONDITION_IF;
            char c3 = '#';
            if (c >= 2 || fVar == null || !fVar.b.equals(this.a)) {
                int i2 = a2 + c;
                boolean z = false;
                boolean z2 = false;
                while (true) {
                    a = m.a(str, i2, b, "@/\\?#");
                    char charAt = a != b ? str.charAt(a) : (char) 65535;
                    if (charAt == 65535 || charAt == c3 || charAt == '/' || charAt == '\\' || charAt == c2) {
                        break;
                    }
                    if (charAt == '@') {
                        if (z) {
                            i = a;
                            this.c += "%40" + f.b(str, i2, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                        } else {
                            int a3 = m.a(str, i2, a, (char) jn1.CONDITION_IF_MIDDLE);
                            i = a;
                            String b2 = f.b(str, i2, a3, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                            if (z2) {
                                b2 = this.b + "%40" + b2;
                            }
                            this.b = b2;
                            if (a3 != i) {
                                this.c = f.b(str, a3 + 1, i, " \"':;<=>@[]^`{}|/\\?#", true, false, false, true);
                                z = true;
                            }
                            z2 = true;
                        }
                        i2 = i + 1;
                    }
                    c2 = jn1.CONDITION_IF;
                    c3 = '#';
                }
                int d = d(str, i2, a);
                int i3 = d + 1;
                this.d = e(str, i2, d);
                if (i3 < a) {
                    int g = g(str, i3, a);
                    this.e = g;
                    if (g == -1) {
                        return EnumC0260a.INVALID_PORT;
                    }
                } else {
                    this.e = f.a(this.a);
                }
                if (this.d == null) {
                    return EnumC0260a.INVALID_HOST;
                }
                a2 = a;
            } else {
                this.b = fVar.a();
                this.c = fVar.b();
                this.d = fVar.e;
                this.e = fVar.f;
                this.f.clear();
                this.f.addAll(fVar.c());
                if (a2 == b || str.charAt(a2) == '#') {
                    a(fVar.d());
                }
            }
            int a4 = m.a(str, a2, b, "?#");
            a(str, a2, a4);
            if (a4 < b && str.charAt(a4) == '?') {
                int a5 = m.a(str, a4, b, '#');
                this.g = f.b(f.b(str, a4 + 1, a5, " \"'<>#", true, false, true, true));
                a4 = a5;
            }
            if (a4 < b && str.charAt(a4) == '#') {
                this.h = f.b(str, 1 + a4, b, "", true, false, false, false);
            }
            return EnumC0260a.SUCCESS;
        }

        public a a(String str) {
            this.g = str != null ? f.b(f.a(str, " \"'<>#", true, false, true, true)) : null;
            return this;
        }

        public a a(String str, String str2) {
            if (str != null) {
                if (this.g == null) {
                    this.g = new ArrayList();
                }
                this.g.add(f.a(str, " \"'<>#&=", false, false, true, true));
                this.g.add(str2 != null ? f.a(str2, " \"'<>#&=", false, false, true, true) : null);
                return this;
            }
            throw new IllegalArgumentException("name == null");
        }

        public f b() {
            if (this.a != null) {
                if (this.d != null) {
                    return new f(this, null);
                }
                throw new IllegalStateException("host == null");
            }
            throw new IllegalStateException("scheme == null");
        }

        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(this.a);
            sb.append(jg1.SCHEME_SLASH);
            if (!this.b.isEmpty() || !this.c.isEmpty()) {
                sb.append(this.b);
                if (!this.c.isEmpty()) {
                    sb.append(jn1.CONDITION_IF_MIDDLE);
                    sb.append(this.c);
                }
                sb.append('@');
            }
            if (this.d.indexOf(58) != -1) {
                sb.append(jn1.ARRAY_START);
                sb.append(this.d);
                sb.append(jn1.ARRAY_END);
            } else {
                sb.append(this.d);
            }
            int a = a();
            if (a != f.a(this.a)) {
                sb.append(jn1.CONDITION_IF_MIDDLE);
                sb.append(a);
            }
            f.a(sb, this.f);
            if (this.g != null) {
                sb.append(jn1.CONDITION_IF);
                f.b(sb, this.g);
            }
            if (this.h != null) {
                sb.append('#');
                sb.append(this.h);
            }
            return sb.toString();
        }
    }

    private f(a aVar) {
        this.b = aVar.a;
        this.c = a(aVar.b, false);
        this.d = a(aVar.c, false);
        this.e = aVar.d;
        this.f = aVar.a();
        this.g = a(aVar.f, false);
        List<String> list = aVar.g;
        this.h = list != null ? a(list, true) : null;
        String str = aVar.h;
        this.i = str != null ? a(str, false) : null;
        this.j = aVar.toString();
    }

    /* synthetic */ f(a aVar, AnonymousClass1 anonymousClass1) {
        this(aVar);
    }

    public static int a(String str) {
        if ("http".equals(str)) {
            return 80;
        }
        return "https".equals(str) ? 443 : -1;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        return b(str, 0, str.length(), str2, z, z2, z3, z4);
    }

    static String a(String str, boolean z) {
        return b(str, 0, str.length(), z);
    }

    private List<String> a(List<String> list, boolean z) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String next = it.next();
            arrayList.add(next != null ? a(next, z) : null);
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        com.meizu.cloud.pushsdk.c.g.b bVar2 = null;
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (codePointAt == 43 && z3) {
                bVar.b(z ? jn1.PLUS : "%2B");
            } else if (a(codePointAt, i3, str, i2, str2, z, z2, z3, z4)) {
                if (bVar2 == null) {
                    bVar2 = new com.meizu.cloud.pushsdk.c.g.b();
                }
                bVar2.a(codePointAt);
                while (!bVar2.c()) {
                    int f = bVar2.f() & 255;
                    bVar.b(37);
                    char[] cArr = a;
                    bVar.b((int) cArr[(f >> 4) & 15]);
                    bVar.b((int) cArr[f & 15]);
                }
            } else {
                bVar.a(codePointAt);
            }
            i3 += Character.charCount(codePointAt);
        }
    }

    private static void a(com.meizu.cloud.pushsdk.c.g.b bVar, String str, int i, int i2, boolean z) {
        int i3;
        while (i < i2) {
            int codePointAt = str.codePointAt(i);
            if (codePointAt != 37 || (i3 = i + 2) >= i2) {
                if (codePointAt == 43 && z) {
                    bVar.b(32);
                }
                bVar.a(codePointAt);
            } else {
                int b = b(str.charAt(i + 1));
                int b2 = b(str.charAt(i3));
                if (b != -1 && b2 != -1) {
                    bVar.b((b << 4) + b2);
                    i = i3;
                }
                bVar.a(codePointAt);
            }
            i += Character.charCount(codePointAt);
        }
    }

    static void a(StringBuilder sb, List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(r10.DIR);
            sb.append(list.get(i));
        }
    }

    private static boolean a(int i, int i2, String str, int i3, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        if (i < 32 || i == 127) {
            return true;
        }
        if ((i < 128 || !z4) && str2.indexOf(i) == -1) {
            boolean z5 = !z || (z2 && !a(str, i2, i3));
            if (i == 37 && z5) {
                return true;
            }
            return i == 43 && z3;
        }
        return true;
    }

    private static boolean a(String str, int i, int i2) {
        int i3 = i + 2;
        return i3 < i2 && str.charAt(i) == '%' && b(str.charAt(i + 1)) != -1 && b(str.charAt(i3)) != -1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static int b(char c) {
        if (c < '0' || c > '9') {
            char c2 = 'a';
            if (c < 'a' || c > 'f') {
                c2 = YKUpsConvert.CHAR_A;
                if (c < 'A' || c > 'F') {
                    return -1;
                }
            }
            return (c - c2) + 10;
        }
        return c - YKUpsConvert.CHAR_ZERO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, int i, int i2, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        int i3 = i;
        while (i3 < i2) {
            int codePointAt = str.codePointAt(i3);
            if (a(codePointAt, i3, str, i2, str2, z, z2, z3, z4)) {
                com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, str2, z, z2, z3, z4);
                return bVar.h();
            }
            i3 += Character.charCount(codePointAt);
        }
        return str.substring(i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String b(String str, int i, int i2, boolean z) {
        for (int i3 = i; i3 < i2; i3++) {
            char charAt = str.charAt(i3);
            boolean z2 = false;
            boolean z3 = charAt == '%';
            if (charAt == '+' && z) {
                z2 = true;
            }
            if (z3 || z2) {
                com.meizu.cloud.pushsdk.c.g.b bVar = new com.meizu.cloud.pushsdk.c.g.b();
                bVar.a(str, i, i3);
                a(bVar, str, i3, i2, z);
                return bVar.h();
            }
        }
        return str.substring(i, i2);
    }

    static List<String> b(String str) {
        String str2;
        ArrayList arrayList = new ArrayList();
        int i = 0;
        while (i <= str.length()) {
            int indexOf = str.indexOf(38, i);
            if (indexOf == -1) {
                indexOf = str.length();
            }
            int indexOf2 = str.indexOf(61, i);
            if (indexOf2 == -1 || indexOf2 > indexOf) {
                arrayList.add(str.substring(i, indexOf));
                str2 = null;
            } else {
                arrayList.add(str.substring(i, indexOf2));
                str2 = str.substring(indexOf2 + 1, indexOf);
            }
            arrayList.add(str2);
            i = indexOf + 1;
        }
        return arrayList;
    }

    static void b(StringBuilder sb, List<String> list) {
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

    public static f c(String str) {
        a aVar = new a();
        if (aVar.a((f) null, str) == a.EnumC0260a.SUCCESS) {
            return aVar.b();
        }
        return null;
    }

    public String a() {
        if (this.c.isEmpty()) {
            return "";
        }
        int length = this.b.length() + 3;
        String str = this.j;
        return this.j.substring(length, m.a(str, length, str.length(), ":@"));
    }

    public String b() {
        if (this.d.isEmpty()) {
            return "";
        }
        int indexOf = this.j.indexOf(64);
        return this.j.substring(this.j.indexOf(58, this.b.length() + 3) + 1, indexOf);
    }

    public List<String> c() {
        int indexOf = this.j.indexOf(47, this.b.length() + 3);
        String str = this.j;
        int a2 = m.a(str, indexOf, str.length(), "?#");
        ArrayList arrayList = new ArrayList();
        while (indexOf < a2) {
            int i = indexOf + 1;
            int a3 = m.a(this.j, i, a2, (char) r10.DIR);
            arrayList.add(this.j.substring(i, a3));
            indexOf = a3;
        }
        return arrayList;
    }

    public String d() {
        if (this.h == null) {
            return null;
        }
        int indexOf = this.j.indexOf(63) + 1;
        String str = this.j;
        return this.j.substring(indexOf, m.a(str, indexOf + 1, str.length(), '#'));
    }

    public String e() {
        if (this.i == null) {
            return null;
        }
        return this.j.substring(this.j.indexOf(35) + 1);
    }

    public boolean equals(Object obj) {
        return (obj instanceof f) && ((f) obj).j.equals(this.j);
    }

    public a f() {
        a aVar = new a();
        aVar.a = this.b;
        aVar.b = a();
        aVar.c = b();
        aVar.d = this.e;
        aVar.e = this.f != a(this.b) ? this.f : -1;
        aVar.f.clear();
        aVar.f.addAll(c());
        aVar.a(d());
        aVar.h = e();
        return aVar;
    }

    public int hashCode() {
        return this.j.hashCode();
    }

    public String toString() {
        return this.j;
    }
}
