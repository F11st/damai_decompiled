package anet.channel.request;

import android.text.TextUtils;
import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import tb.C9708t9;
import tb.jn1;
import tb.lw2;
import tb.o01;

/* compiled from: Taobao */
/* renamed from: anet.channel.request.a */
/* loaded from: classes.dex */
public class C0193a {
    public static final String DEFAULT_CHARSET = "UTF-8";
    private o01 a;
    private o01 b;
    private o01 c;
    private URL d;
    private String e;
    private Map<String, String> f;
    private Map<String, String> g;
    private String h;
    private BodyEntry i;
    private boolean j;
    private String k;
    private String l;
    private int m;
    private int n;
    private int o;
    private HostnameVerifier p;
    private SSLSocketFactory q;
    public final RequestStatistic r;
    private boolean s;

    /* compiled from: Taobao */
    /* renamed from: anet.channel.request.a$b */
    /* loaded from: classes.dex */
    public static class C0195b {
        private o01 a;
        private o01 b;
        private Map<String, String> e;
        private String f;
        private BodyEntry g;
        private HostnameVerifier j;
        private SSLSocketFactory k;
        private String l;
        private String m;
        private boolean q;
        private String c = "GET";
        private Map<String, String> d = new HashMap();
        private boolean h = true;
        private int i = 0;
        private int n = 10000;
        private int o = 10000;
        private RequestStatistic p = null;

        public C0195b I(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public C0193a J() {
            if (this.g == null && this.e == null && C0196c.b(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " must have a request body", null, new Object[0]);
            }
            if (this.g != null && !C0196c.a(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " should not have a request body", null, new Object[0]);
                this.g = null;
            }
            BodyEntry bodyEntry = this.g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                I("Content-Type", this.g.getContentType());
            }
            return new C0193a(this);
        }

        public C0195b K(boolean z) {
            this.q = z;
            return this;
        }

        public C0195b L(String str) {
            this.l = str;
            return this;
        }

        public C0195b M(BodyEntry bodyEntry) {
            this.g = bodyEntry;
            return this;
        }

        public C0195b N(String str) {
            this.f = str;
            this.b = null;
            return this;
        }

        public C0195b O(int i) {
            if (i > 0) {
                this.n = i;
            }
            return this;
        }

        public C0195b P(Map<String, String> map) {
            this.d.clear();
            if (map != null) {
                this.d.putAll(map);
            }
            return this;
        }

        public C0195b Q(HostnameVerifier hostnameVerifier) {
            this.j = hostnameVerifier;
            return this;
        }

        public C0195b R(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("GET".equalsIgnoreCase(str)) {
                    this.c = "GET";
                } else if ("POST".equalsIgnoreCase(str)) {
                    this.c = "POST";
                } else if (C0196c.OPTION.equalsIgnoreCase(str)) {
                    this.c = C0196c.OPTION;
                } else if (C0196c.HEAD.equalsIgnoreCase(str)) {
                    this.c = C0196c.HEAD;
                } else if (C0196c.PUT.equalsIgnoreCase(str)) {
                    this.c = C0196c.PUT;
                } else if (C0196c.DELETE.equalsIgnoreCase(str)) {
                    this.c = C0196c.DELETE;
                } else {
                    this.c = "GET";
                }
                return this;
            }
            throw new IllegalArgumentException("method is null or empty");
        }

        public C0195b S(Map<String, String> map) {
            this.e = map;
            this.b = null;
            return this;
        }

        public C0195b T(int i) {
            if (i > 0) {
                this.o = i;
            }
            return this;
        }

        public C0195b U(boolean z) {
            this.h = z;
            return this;
        }

        public C0195b V(int i) {
            this.i = i;
            return this;
        }

        public C0195b W(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public C0195b X(String str) {
            this.m = str;
            return this;
        }

        public C0195b Y(SSLSocketFactory sSLSocketFactory) {
            this.k = sSLSocketFactory;
            return this;
        }

        public C0195b Z(String str) {
            o01 g = o01.g(str);
            this.a = g;
            this.b = null;
            if (g != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }

        public C0195b a0(o01 o01Var) {
            this.a = o01Var;
            this.b = null;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: anet.channel.request.a$c */
    /* loaded from: classes.dex */
    public static final class C0196c {
        public static final String DELETE = "DELETE";
        public static final String GET = "GET";
        public static final String HEAD = "HEAD";
        public static final String OPTION = "OPTIONS";
        public static final String POST = "POST";
        public static final String PUT = "PUT";

        static boolean a(String str) {
            return b(str) || str.equals(DELETE) || str.equals(OPTION);
        }

        static boolean b(String str) {
            return str.equals("POST") || str.equals(PUT);
        }
    }

    private void b() {
        String b = lw2.b(this.g, f());
        if (!TextUtils.isEmpty(b)) {
            if (C0196c.b(this.e) && this.i == null) {
                try {
                    this.i = new ByteArrayEntry(b.getBytes(f()));
                    Map<String, String> map = this.f;
                    map.put("Content-Type", "application/x-www-form-urlencoded; charset=" + f());
                } catch (UnsupportedEncodingException unused) {
                }
            } else {
                String n = this.a.n();
                StringBuilder sb = new StringBuilder(n);
                if (sb.indexOf("?") == -1) {
                    sb.append(jn1.CONDITION_IF);
                } else if (n.charAt(n.length() - 1) != '&') {
                    sb.append('&');
                }
                sb.append(b);
                o01 g = o01.g(sb.toString());
                if (g != null) {
                    this.b = g;
                }
            }
        }
        if (this.b == null) {
            this.b = this.a;
        }
    }

    private Map<String, String> t() {
        if (C9708t9.q()) {
            return new HashMap(this.f);
        }
        return this.f;
    }

    public boolean a() {
        return this.i != null;
    }

    public String c() {
        return this.k;
    }

    public byte[] d() {
        if (this.i != null) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(128);
            try {
                v(byteArrayOutputStream);
            } catch (IOException unused) {
            }
            return byteArrayOutputStream.toByteArray();
        }
        return null;
    }

    public int e() {
        return this.n;
    }

    public String f() {
        String str = this.h;
        return str != null ? str : "UTF-8";
    }

    public Map<String, String> g() {
        return Collections.unmodifiableMap(this.f);
    }

    public String h() {
        return this.b.d();
    }

    public HostnameVerifier i() {
        return this.p;
    }

    public o01 j() {
        return this.b;
    }

    public String k() {
        return this.e;
    }

    public int l() {
        return this.o;
    }

    public int m() {
        return this.m;
    }

    public String n() {
        return this.l;
    }

    public SSLSocketFactory o() {
        return this.q;
    }

    public URL p() {
        if (this.d == null) {
            o01 o01Var = this.c;
            if (o01Var == null) {
                o01Var = this.b;
            }
            this.d = o01Var.m();
        }
        return this.d;
    }

    public String q() {
        return this.b.n();
    }

    public boolean r() {
        return this.s;
    }

    public boolean s() {
        return this.j;
    }

    public C0195b u() {
        C0195b c0195b = new C0195b();
        c0195b.c = this.e;
        c0195b.d = t();
        c0195b.e = this.g;
        c0195b.g = this.i;
        c0195b.f = this.h;
        c0195b.h = this.j;
        c0195b.i = this.m;
        c0195b.j = this.p;
        c0195b.k = this.q;
        c0195b.a = this.a;
        c0195b.b = this.b;
        c0195b.l = this.k;
        c0195b.m = this.l;
        c0195b.n = this.n;
        c0195b.o = this.o;
        c0195b.p = this.r;
        c0195b.q = this.s;
        return c0195b;
    }

    public int v(OutputStream outputStream) throws IOException {
        BodyEntry bodyEntry = this.i;
        if (bodyEntry != null) {
            return bodyEntry.writeTo(outputStream);
        }
        return 0;
    }

    public void w(String str, int i) {
        if (str != null) {
            if (this.c == null) {
                this.c = new o01(this.b);
            }
            this.c.i(str, i);
        } else {
            this.c = null;
        }
        this.d = null;
        this.r.setIPAndPort(str, i);
    }

    public void x(boolean z) {
        if (this.c == null) {
            this.c = new o01(this.b);
        }
        this.c.k(z ? "https" : "http");
        this.d = null;
    }

    private C0193a(C0195b c0195b) {
        this.e = "GET";
        this.j = true;
        this.m = 0;
        this.n = 10000;
        this.o = 10000;
        this.e = c0195b.c;
        this.f = c0195b.d;
        this.g = c0195b.e;
        this.i = c0195b.g;
        this.h = c0195b.f;
        this.j = c0195b.h;
        this.m = c0195b.i;
        this.p = c0195b.j;
        this.q = c0195b.k;
        this.k = c0195b.l;
        this.l = c0195b.m;
        this.n = c0195b.n;
        this.o = c0195b.o;
        this.a = c0195b.a;
        o01 o01Var = c0195b.b;
        this.b = o01Var;
        if (o01Var == null) {
            b();
        }
        this.r = c0195b.p != null ? c0195b.p : new RequestStatistic(h(), this.k);
        this.s = c0195b.q;
    }
}
