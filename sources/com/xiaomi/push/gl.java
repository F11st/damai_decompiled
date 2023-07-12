package com.xiaomi.push;

import android.os.Bundle;
import java.util.HashMap;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gl extends gn {
    private C7663a a;

    /* renamed from: a  reason: collision with other field name */
    private final Map<String, String> f425a;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.gl$a */
    /* loaded from: classes11.dex */
    public static class C7663a {
        public static final C7663a a = new C7663a(gn1.TYPE_OPEN_URL_METHOD_GET);
        public static final C7663a b = new C7663a("set");
        public static final C7663a c = new C7663a("result");
        public static final C7663a d = new C7663a("error");
        public static final C7663a e = new C7663a("command");

        /* renamed from: a  reason: collision with other field name */
        private String f426a;

        private C7663a(String str) {
            this.f426a = str;
        }

        public static C7663a a(String str) {
            if (str == null) {
                return null;
            }
            String lowerCase = str.toLowerCase();
            C7663a c7663a = a;
            if (c7663a.toString().equals(lowerCase)) {
                return c7663a;
            }
            C7663a c7663a2 = b;
            if (c7663a2.toString().equals(lowerCase)) {
                return c7663a2;
            }
            C7663a c7663a3 = d;
            if (c7663a3.toString().equals(lowerCase)) {
                return c7663a3;
            }
            C7663a c7663a4 = c;
            if (c7663a4.toString().equals(lowerCase)) {
                return c7663a4;
            }
            C7663a c7663a5 = e;
            if (c7663a5.toString().equals(lowerCase)) {
                return c7663a5;
            }
            return null;
        }

        public String toString() {
            return this.f426a;
        }
    }

    public gl() {
        this.a = C7663a.a;
        this.f425a = new HashMap();
    }

    public gl(Bundle bundle) {
        super(bundle);
        this.a = C7663a.a;
        this.f425a = new HashMap();
        if (bundle.containsKey("ext_iq_type")) {
            this.a = C7663a.a(bundle.getString("ext_iq_type"));
        }
    }

    @Override // com.xiaomi.push.gn
    public Bundle a() {
        Bundle a = super.a();
        C7663a c7663a = this.a;
        if (c7663a != null) {
            a.putString("ext_iq_type", c7663a.toString());
        }
        return a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public C7663a m925a() {
        return this.a;
    }

    @Override // com.xiaomi.push.gn
    /* renamed from: a  reason: collision with other method in class */
    public String mo926a() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("<iq ");
        if (j() != null) {
            sb.append("id=\"" + j() + "\" ");
        }
        if (l() != null) {
            sb.append("to=\"");
            sb.append(gy.a(l()));
            sb.append("\" ");
        }
        if (m() != null) {
            sb.append("from=\"");
            sb.append(gy.a(m()));
            sb.append("\" ");
        }
        if (k() != null) {
            sb.append("chid=\"");
            sb.append(gy.a(k()));
            sb.append("\" ");
        }
        for (Map.Entry<String, String> entry : this.f425a.entrySet()) {
            sb.append(gy.a(entry.getKey()));
            sb.append("=\"");
            sb.append(gy.a(entry.getValue()));
            sb.append("\" ");
        }
        if (this.a == null) {
            str = "type=\"get\">";
        } else {
            sb.append("type=\"");
            sb.append(m925a());
            str = "\">";
        }
        sb.append(str);
        String b = b();
        if (b != null) {
            sb.append(b);
        }
        sb.append(o());
        gr m927a = m927a();
        if (m927a != null) {
            sb.append(m927a.m930a());
        }
        sb.append("</iq>");
        return sb.toString();
    }

    public void a(C7663a c7663a) {
        if (c7663a == null) {
            c7663a = C7663a.a;
        }
        this.a = c7663a;
    }

    public synchronized void a(Map<String, String> map) {
        this.f425a.putAll(map);
    }

    public String b() {
        return null;
    }
}
