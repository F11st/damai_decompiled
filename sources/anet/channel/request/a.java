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
import tb.jn1;
import tb.lw2;
import tb.o01;
import tb.t9;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {
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
    /* loaded from: classes.dex */
    public static class b {
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

        public b I(String str, String str2) {
            this.d.put(str, str2);
            return this;
        }

        public a J() {
            if (this.g == null && this.e == null && c.b(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " must have a request body", null, new Object[0]);
            }
            if (this.g != null && !c.a(this.c)) {
                ALog.e("awcn.Request", "method " + this.c + " should not have a request body", null, new Object[0]);
                this.g = null;
            }
            BodyEntry bodyEntry = this.g;
            if (bodyEntry != null && bodyEntry.getContentType() != null) {
                I("Content-Type", this.g.getContentType());
            }
            return new a(this);
        }

        public b K(boolean z) {
            this.q = z;
            return this;
        }

        public b L(String str) {
            this.l = str;
            return this;
        }

        public b M(BodyEntry bodyEntry) {
            this.g = bodyEntry;
            return this;
        }

        public b N(String str) {
            this.f = str;
            this.b = null;
            return this;
        }

        public b O(int i) {
            if (i > 0) {
                this.n = i;
            }
            return this;
        }

        public b P(Map<String, String> map) {
            this.d.clear();
            if (map != null) {
                this.d.putAll(map);
            }
            return this;
        }

        public b Q(HostnameVerifier hostnameVerifier) {
            this.j = hostnameVerifier;
            return this;
        }

        public b R(String str) {
            if (!TextUtils.isEmpty(str)) {
                if ("GET".equalsIgnoreCase(str)) {
                    this.c = "GET";
                } else if ("POST".equalsIgnoreCase(str)) {
                    this.c = "POST";
                } else if (c.OPTION.equalsIgnoreCase(str)) {
                    this.c = c.OPTION;
                } else if (c.HEAD.equalsIgnoreCase(str)) {
                    this.c = c.HEAD;
                } else if (c.PUT.equalsIgnoreCase(str)) {
                    this.c = c.PUT;
                } else if (c.DELETE.equalsIgnoreCase(str)) {
                    this.c = c.DELETE;
                } else {
                    this.c = "GET";
                }
                return this;
            }
            throw new IllegalArgumentException("method is null or empty");
        }

        public b S(Map<String, String> map) {
            this.e = map;
            this.b = null;
            return this;
        }

        public b T(int i) {
            if (i > 0) {
                this.o = i;
            }
            return this;
        }

        public b U(boolean z) {
            this.h = z;
            return this;
        }

        public b V(int i) {
            this.i = i;
            return this;
        }

        public b W(RequestStatistic requestStatistic) {
            this.p = requestStatistic;
            return this;
        }

        public b X(String str) {
            this.m = str;
            return this;
        }

        public b Y(SSLSocketFactory sSLSocketFactory) {
            this.k = sSLSocketFactory;
            return this;
        }

        public b Z(String str) {
            o01 g = o01.g(str);
            this.a = g;
            this.b = null;
            if (g != null) {
                return this;
            }
            throw new IllegalArgumentException("toURL is invalid! toURL = " + str);
        }

        public b a0(o01 o01Var) {
            this.a = o01Var;
            this.b = null;
            return this;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    public static final class c {
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
        String b2 = lw2.b(this.g, f());
        if (!TextUtils.isEmpty(b2)) {
            if (c.b(this.e) && this.i == null) {
                try {
                    this.i = new ByteArrayEntry(b2.getBytes(f()));
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
                sb.append(b2);
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
        if (t9.q()) {
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

    public b u() {
        b bVar = new b();
        bVar.c = this.e;
        bVar.d = t();
        bVar.e = this.g;
        bVar.g = this.i;
        bVar.f = this.h;
        bVar.h = this.j;
        bVar.i = this.m;
        bVar.j = this.p;
        bVar.k = this.q;
        bVar.a = this.a;
        bVar.b = this.b;
        bVar.l = this.k;
        bVar.m = this.l;
        bVar.n = this.n;
        bVar.o = this.o;
        bVar.p = this.r;
        bVar.q = this.s;
        return bVar;
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

    private a(b bVar) {
        this.e = "GET";
        this.j = true;
        this.m = 0;
        this.n = 10000;
        this.o = 10000;
        this.e = bVar.c;
        this.f = bVar.d;
        this.g = bVar.e;
        this.i = bVar.g;
        this.h = bVar.f;
        this.j = bVar.h;
        this.m = bVar.i;
        this.p = bVar.j;
        this.q = bVar.k;
        this.k = bVar.l;
        this.l = bVar.m;
        this.n = bVar.n;
        this.o = bVar.o;
        this.a = bVar.a;
        o01 o01Var = bVar.b;
        this.b = o01Var;
        if (o01Var == null) {
            b();
        }
        this.r = bVar.p != null ? bVar.p : new RequestStatistic(h(), this.k);
        this.s = bVar.q;
    }
}
