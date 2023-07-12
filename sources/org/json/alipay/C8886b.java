package org.json.alipay;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: org.json.alipay.b */
/* loaded from: classes2.dex */
public class C8886b {
    public static final Object a = new C8887a((byte) 0);
    public Map b;

    /* compiled from: Taobao */
    /* renamed from: org.json.alipay.b$a */
    /* loaded from: classes2.dex */
    public static final class C8887a {
        public C8887a() {
        }

        public /* synthetic */ C8887a(byte b) {
            this();
        }

        public final Object clone() {
            return this;
        }

        public final boolean equals(Object obj) {
            return obj == null || obj == this;
        }

        public final String toString() {
            return "null";
        }
    }

    public C8886b() {
        this.b = new HashMap();
    }

    public C8886b(String str) {
        this(new C8888c(str));
    }

    public C8886b(Map map) {
        this.b = map == null ? new HashMap() : map;
    }

    public C8886b(C8888c c8888c) {
        this();
        if (c8888c.c() != '{') {
            throw c8888c.a("A JSONObject text must begin with '{'");
        }
        while (true) {
            char c = c8888c.c();
            if (c == 0) {
                throw c8888c.a("A JSONObject text must end with '}'");
            }
            if (c == '}') {
                return;
            }
            c8888c.a();
            String obj = c8888c.d().toString();
            char c2 = c8888c.c();
            if (c2 == '=') {
                if (c8888c.b() != '>') {
                    c8888c.a();
                }
            } else if (c2 != ':') {
                throw c8888c.a("Expected a ':' after a key");
            }
            Object d = c8888c.d();
            if (obj == null) {
                throw new JSONException("Null key.");
            }
            if (d != null) {
                b(d);
                this.b.put(obj, d);
            } else {
                this.b.remove(obj);
            }
            char c3 = c8888c.c();
            if (c3 != ',' && c3 != ';') {
                if (c3 != '}') {
                    throw c8888c.a("Expected a ',' or '}'");
                }
                return;
            } else if (c8888c.c() == '}') {
                return;
            } else {
                c8888c.a();
            }
        }
    }

    public static String a(Object obj) {
        if (obj == null || obj.equals(null)) {
            return "null";
        }
        if (!(obj instanceof Number)) {
            return ((obj instanceof Boolean) || (obj instanceof C8886b) || (obj instanceof C8885a)) ? obj.toString() : obj instanceof Map ? new C8886b((Map) obj).toString() : obj instanceof Collection ? new C8885a((Collection) obj).toString() : obj.getClass().isArray() ? new C8885a(obj).toString() : c(obj.toString());
        }
        Number number = (Number) obj;
        b(number);
        String obj2 = number.toString();
        if (obj2.indexOf(46) <= 0 || obj2.indexOf(101) >= 0 || obj2.indexOf(69) >= 0) {
            return obj2;
        }
        while (obj2.endsWith("0")) {
            obj2 = obj2.substring(0, obj2.length() - 1);
        }
        return obj2.endsWith(".") ? obj2.substring(0, obj2.length() - 1) : obj2;
    }

    public static void b(Object obj) {
        if (obj != null) {
            if (obj instanceof Double) {
                Double d = (Double) obj;
                if (d.isInfinite() || d.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            } else if (obj instanceof Float) {
                Float f = (Float) obj;
                if (f.isInfinite() || f.isNaN()) {
                    throw new JSONException("JSON does not allow non-finite numbers.");
                }
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:34:0x0084, code lost:
        if (r4 == '<') goto L37;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String c(java.lang.String r8) {
        /*
            if (r8 == 0) goto La0
            int r0 = r8.length()
            if (r0 != 0) goto La
            goto La0
        La:
            int r0 = r8.length()
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            int r2 = r0 + 4
            r1.<init>(r2)
            r2 = 34
            r1.append(r2)
            r3 = 0
            r4 = 0
        L1c:
            if (r3 >= r0) goto L98
            char r5 = r8.charAt(r3)
            r6 = 12
            if (r5 == r6) goto L90
            r6 = 13
            if (r5 == r6) goto L8d
            r6 = 92
            if (r5 == r2) goto L86
            r7 = 47
            if (r5 == r7) goto L82
            if (r5 == r6) goto L86
            switch(r5) {
                case 8: goto L7c;
                case 9: goto L79;
                case 10: goto L76;
                default: goto L37;
            }
        L37:
            r4 = 32
            if (r5 < r4) goto L4b
            r4 = 128(0x80, float:1.8E-43)
            if (r5 < r4) goto L43
            r4 = 160(0xa0, float:2.24E-43)
            if (r5 < r4) goto L4b
        L43:
            r4 = 8192(0x2000, float:1.148E-41)
            if (r5 < r4) goto L89
            r4 = 8448(0x2100, float:1.1838E-41)
            if (r5 >= r4) goto L89
        L4b:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r6 = "000"
            r4.<init>(r6)
            java.lang.String r6 = java.lang.Integer.toHexString(r5)
            r4.append(r6)
            java.lang.String r4 = r4.toString()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "\\u"
            r6.<init>(r7)
            int r7 = r4.length()
            int r7 = r7 + (-4)
            java.lang.String r4 = r4.substring(r7)
            r6.append(r4)
            java.lang.String r4 = r6.toString()
            goto L7e
        L76:
            java.lang.String r4 = "\\n"
            goto L7e
        L79:
            java.lang.String r4 = "\\t"
            goto L7e
        L7c:
            java.lang.String r4 = "\\b"
        L7e:
            r1.append(r4)
            goto L93
        L82:
            r7 = 60
            if (r4 != r7) goto L89
        L86:
            r1.append(r6)
        L89:
            r1.append(r5)
            goto L93
        L8d:
            java.lang.String r4 = "\\r"
            goto L7e
        L90:
            java.lang.String r4 = "\\f"
            goto L7e
        L93:
            int r3 = r3 + 1
            r4 = r5
            goto L1c
        L98:
            r1.append(r2)
            java.lang.String r8 = r1.toString()
            return r8
        La0:
            java.lang.String r8 = "\"\""
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.json.alipay.C8886b.c(java.lang.String):java.lang.String");
    }

    public final Object a(String str) {
        Object obj = str == null ? null : this.b.get(str);
        if (obj != null) {
            return obj;
        }
        throw new JSONException("JSONObject[" + c(str) + "] not found.");
    }

    public final Iterator a() {
        return this.b.keySet().iterator();
    }

    public final boolean b(String str) {
        return this.b.containsKey(str);
    }

    public String toString() {
        try {
            Iterator a2 = a();
            StringBuffer stringBuffer = new StringBuffer(jn1.BLOCK_START_STR);
            while (a2.hasNext()) {
                if (stringBuffer.length() > 1) {
                    stringBuffer.append(',');
                }
                Object next = a2.next();
                stringBuffer.append(c(next.toString()));
                stringBuffer.append(jn1.CONDITION_IF_MIDDLE);
                stringBuffer.append(a(this.b.get(next)));
            }
            stringBuffer.append('}');
            return stringBuffer.toString();
        } catch (Exception unused) {
            return null;
        }
    }
}
