package com.xiaomi.push;

import android.os.Bundle;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class gr {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private String f437a;

    /* renamed from: a  reason: collision with other field name */
    private List<gk> f438a;
    private String b;
    private String c;
    private String d;

    /* compiled from: Taobao */
    /* renamed from: com.xiaomi.push.gr$a */
    /* loaded from: classes11.dex */
    public static class C7666a {
        public static final C7666a a = new C7666a("internal-server-error");
        public static final C7666a b = new C7666a("forbidden");
        public static final C7666a c = new C7666a("bad-request");
        public static final C7666a d = new C7666a("conflict");
        public static final C7666a e = new C7666a("feature-not-implemented");
        public static final C7666a f = new C7666a("gone");
        public static final C7666a g = new C7666a("item-not-found");
        public static final C7666a h = new C7666a("jid-malformed");
        public static final C7666a i = new C7666a("not-acceptable");
        public static final C7666a j = new C7666a("not-allowed");
        public static final C7666a k = new C7666a("not-authorized");
        public static final C7666a l = new C7666a("payment-required");
        public static final C7666a m = new C7666a("recipient-unavailable");
        public static final C7666a n = new C7666a("redirect");
        public static final C7666a o = new C7666a("registration-required");
        public static final C7666a p = new C7666a("remote-server-error");
        public static final C7666a q = new C7666a("remote-server-not-found");
        public static final C7666a r = new C7666a("remote-server-timeout");
        public static final C7666a s = new C7666a("resource-constraint");
        public static final C7666a t = new C7666a("service-unavailable");
        public static final C7666a u = new C7666a("subscription-required");
        public static final C7666a v = new C7666a("undefined-condition");
        public static final C7666a w = new C7666a("unexpected-request");
        public static final C7666a x = new C7666a("request-timeout");

        /* renamed from: a  reason: collision with other field name */
        private String f439a;

        public C7666a(String str) {
            this.f439a = str;
        }

        public String toString() {
            return this.f439a;
        }
    }

    public gr(int i, String str, String str2, String str3, String str4, List<gk> list) {
        this.f438a = null;
        this.a = i;
        this.f437a = str;
        this.c = str2;
        this.b = str3;
        this.d = str4;
        this.f438a = list;
    }

    public gr(Bundle bundle) {
        this.f438a = null;
        this.a = bundle.getInt("ext_err_code");
        if (bundle.containsKey("ext_err_type")) {
            this.f437a = bundle.getString("ext_err_type");
        }
        this.b = bundle.getString("ext_err_cond");
        this.c = bundle.getString("ext_err_reason");
        this.d = bundle.getString("ext_err_msg");
        Parcelable[] parcelableArray = bundle.getParcelableArray("ext_exts");
        if (parcelableArray != null) {
            this.f438a = new ArrayList(parcelableArray.length);
            for (Parcelable parcelable : parcelableArray) {
                gk a = gk.a((Bundle) parcelable);
                if (a != null) {
                    this.f438a.add(a);
                }
            }
        }
    }

    public gr(C7666a c7666a) {
        this.f438a = null;
        a(c7666a);
        this.d = null;
    }

    private void a(C7666a c7666a) {
        this.b = c7666a.f439a;
    }

    public Bundle a() {
        Bundle bundle = new Bundle();
        String str = this.f437a;
        if (str != null) {
            bundle.putString("ext_err_type", str);
        }
        bundle.putInt("ext_err_code", this.a);
        String str2 = this.c;
        if (str2 != null) {
            bundle.putString("ext_err_reason", str2);
        }
        String str3 = this.b;
        if (str3 != null) {
            bundle.putString("ext_err_cond", str3);
        }
        String str4 = this.d;
        if (str4 != null) {
            bundle.putString("ext_err_msg", str4);
        }
        List<gk> list = this.f438a;
        if (list != null) {
            Bundle[] bundleArr = new Bundle[list.size()];
            int i = 0;
            for (gk gkVar : this.f438a) {
                Bundle a = gkVar.a();
                if (a != null) {
                    bundleArr[i] = a;
                    i++;
                }
            }
            bundle.putParcelableArray("ext_exts", bundleArr);
        }
        return bundle;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m930a() {
        StringBuilder sb = new StringBuilder();
        sb.append("<error code=\"");
        sb.append(this.a);
        sb.append("\"");
        if (this.f437a != null) {
            sb.append(" type=\"");
            sb.append(this.f437a);
            sb.append("\"");
        }
        if (this.c != null) {
            sb.append(" reason=\"");
            sb.append(this.c);
            sb.append("\"");
        }
        sb.append(jn1.G);
        if (this.b != null) {
            sb.append(jn1.L);
            sb.append(this.b);
            sb.append(" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\"/>");
        }
        if (this.d != null) {
            sb.append("<text xml:lang=\"en\" xmlns=\"urn:ietf:params:xml:ns:xmpp-stanzas\">");
            sb.append(this.d);
            sb.append("</text>");
        }
        for (gk gkVar : m931a()) {
            sb.append(gkVar.d());
        }
        sb.append("</error>");
        return sb.toString();
    }

    /* renamed from: a  reason: collision with other method in class */
    public synchronized List<gk> m931a() {
        List<gk> list = this.f438a;
        if (list == null) {
            return Collections.emptyList();
        }
        return Collections.unmodifiableList(list);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = this.b;
        if (str != null) {
            sb.append(str);
        }
        sb.append(jn1.BRACKET_START_STR);
        sb.append(this.a);
        sb.append(jn1.BRACKET_END_STR);
        if (this.d != null) {
            sb.append(" ");
            sb.append(this.d);
        }
        return sb.toString();
    }
}
