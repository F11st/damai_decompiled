package com.youku.network;

import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.Map;
import mtopsdk.common.util.StringUtils;
import mtopsdk.mtop.domain.MethodEnum;
import mtopsdk.mtop.domain.ProtocolEnum;
import mtopsdk.mtop.intf.Mtop;

/* compiled from: Taobao */
/* loaded from: classes13.dex */
public class c {
    private ProtocolEnum D;
    private String E;
    private String F;
    private String G;
    private String I;
    private String J;
    private boolean K;
    private boolean L;
    private String a;
    private String b;
    private String c;
    private String d;
    private String m;
    private f n;
    private Mtop p;
    private String q;
    private String r;
    @Deprecated
    private boolean t;
    private boolean u;
    private boolean v;
    private Map<String, String> w;
    private int e = 10000;
    private int f = 10000;
    private String g = "GET";
    private String h = "UTF-8";
    private boolean i = true;
    private int j = 2;
    private Map<String, String> k = new HashMap();
    private Map<String, String> l = new HashMap();
    private String o = Constants.Name.UNDEFINED;
    private String s = "{}";
    private Map<String, String> x = new HashMap();
    private Map<String, String> y = new HashMap();
    private int z = 2;
    private int A = 10000;
    private int B = 10000;
    private MethodEnum C = MethodEnum.GET;
    private int H = -1;
    private boolean M = true;
    private boolean N = true;

    public static c a() {
        return new c();
    }

    public String A() {
        return this.J;
    }

    public boolean B() {
        return this.L;
    }

    public boolean C() {
        return this.K;
    }

    public Mtop D() {
        return this.p;
    }

    public String E() {
        if (StringUtils.isBlank(this.q) || StringUtils.isBlank(this.r)) {
            return null;
        }
        return StringUtils.concatStr2LowerCase(this.q, this.r);
    }

    public Map<String, String> F() {
        return this.x;
    }

    public Map<String, String> G() {
        return this.y;
    }

    public int H() {
        return this.z;
    }

    public int I() {
        return this.A;
    }

    public int J() {
        return this.B;
    }

    public MethodEnum K() {
        return this.C;
    }

    public f L() {
        return this.n;
    }

    public boolean M() {
        return this.M;
    }

    public boolean N() {
        return this.N;
    }

    public String O() {
        return this.o;
    }

    public void a(int i) {
        this.e = i;
    }

    public void a(String str) {
        this.a = str;
    }

    public void a(String str, String str2) {
        this.k.put(str, str2);
    }

    public void a(MethodEnum methodEnum) {
        this.C = methodEnum;
    }

    public void a(boolean z) {
        this.i = z;
    }

    public String b() {
        return this.a;
    }

    public void b(int i) {
        this.f = i;
    }

    public void b(String str) {
        this.c = str;
    }

    public void b(String str, String str2) {
        this.x.put(str, str2);
    }

    @Deprecated
    public void b(boolean z) {
        this.t = z;
    }

    public String c() {
        return this.c;
    }

    public void c(int i) {
        this.H = i;
    }

    public void c(String str) {
        this.d = str;
    }

    public String d() {
        return this.d;
    }

    public void d(int i) {
        this.A = i;
    }

    public void d(String str) {
        this.b = str;
    }

    public String e() {
        return this.b;
    }

    public void e(int i) {
        this.B = i;
    }

    public void e(String str) {
        this.g = str;
    }

    public int f() {
        return this.e;
    }

    public void f(String str) {
        this.q = str;
    }

    public int g() {
        return this.f;
    }

    public void g(String str) {
        this.r = str;
    }

    public String h() {
        return this.g;
    }

    public void h(String str) {
        this.s = str;
    }

    public void i(String str) {
        this.E = str;
    }

    public boolean i() {
        return this.i;
    }

    public int j() {
        return this.j;
    }

    public Map<String, String> k() {
        return this.k;
    }

    public Map<String, String> l() {
        return this.l;
    }

    public String m() {
        return this.m;
    }

    public String n() {
        return this.h;
    }

    public String o() {
        return this.q;
    }

    public String p() {
        return this.r;
    }

    public String q() {
        return this.s;
    }

    public boolean r() {
        return this.u;
    }

    public boolean s() {
        return this.v;
    }

    public Map<String, String> t() {
        return this.w;
    }

    public ProtocolEnum u() {
        return this.D;
    }

    public String v() {
        return this.E;
    }

    public String w() {
        return this.F;
    }

    public String x() {
        return this.G;
    }

    public int y() {
        return this.H;
    }

    public String z() {
        return this.I;
    }
}
