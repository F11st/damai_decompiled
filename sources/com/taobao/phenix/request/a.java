package com.taobao.phenix.request;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.taobao.pexode.PexodeOptions;
import com.taobao.phenix.bitmap.BitmapProcessor;
import com.taobao.phenix.chain.PhenixProduceListener;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.Future;
import tb.a22;
import tb.ds1;
import tb.h62;
import tb.op0;
import tb.ye;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class a extends a22 {
    private int A;
    private int B;
    private boolean C;
    private BitmapProcessor[] D;
    private int E;
    private String F;
    private boolean G;
    private boolean H;
    private final ds1 k;
    private String l;
    private b m;
    private long n;
    private ImageStatistics o;
    private long p;
    private boolean q;
    private b r;
    private String s;
    private int t;
    private int u;
    private int v;
    private int w;
    private Map<String, String> x;
    private Future<?> y;
    private PexodeOptions z;

    public a(String str, ye yeVar, boolean z) {
        super(z);
        this.A = 17;
        this.B = 17;
        this.E = 0;
        b bVar = new b(str, yeVar);
        this.m = bVar;
        this.o = new ImageStatistics(bVar);
        this.k = new ds1(this);
        this.n = System.currentTimeMillis();
        this.t = 1;
        op0.f(U());
        this.o.x(this.A);
    }

    public static boolean W(int i, int i2) {
        return (i & i2) > 0;
    }

    private synchronized void g0() {
        if (this.s != null) {
            this.s = null;
        }
    }

    private synchronized void u(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (this.F == null) {
            this.F = str;
        } else {
            this.F += str;
        }
        g0();
    }

    public BitmapProcessor[] A() {
        return this.D;
    }

    public Future<?> B() {
        return this.y;
    }

    public int C() {
        return this.m.e();
    }

    public String D() {
        return this.m.f();
    }

    public int E() {
        return this.A;
    }

    public String F() {
        return this.m.g();
    }

    public b G() {
        return this.m;
    }

    public Map<String, String> H() {
        return this.x;
    }

    public int I() {
        return this.w;
    }

    public int J() {
        return this.v;
    }

    public String K() {
        return this.m.j();
    }

    public int L() {
        return this.B;
    }

    public String M() {
        return this.l;
    }

    public String N() {
        return this.m.k();
    }

    public PexodeOptions O() {
        return this.z;
    }

    public synchronized ds1 P() {
        return this.k;
    }

    public Map<String, Long> Q() {
        if (g() == null) {
            return new HashMap();
        }
        return ((PhenixProduceListener) g()).e();
    }

    public int R() {
        return this.u;
    }

    public long S() {
        return this.n;
    }

    public b T() {
        return this.r;
    }

    public synchronized ImageStatistics U() {
        return this.o;
    }

    public long V() {
        return this.p;
    }

    public boolean X() {
        return this.G;
    }

    public boolean Y() {
        return this.H;
    }

    public boolean Z() {
        return (this.E & 4) > 0;
    }

    public boolean a0() {
        return (this.E & 2) > 0;
    }

    public boolean b0() {
        return this.C;
    }

    public boolean c0() {
        return this.q;
    }

    public boolean d0() {
        return (this.E & 1) > 0;
    }

    @Override // tb.a22
    public synchronized String e() {
        if (this.s == null) {
            String f = this.m.f();
            StringBuilder sb = new StringBuilder(f.length() + 30);
            sb.append("#SLEVEL$");
            sb.append(this.t);
            sb.append("#FLAGS$");
            sb.append(this.E);
            sb.append("#MAXW$");
            sb.append(this.v);
            sb.append("#MAXH$");
            sb.append(this.w);
            sb.append("#SPRIOR$");
            sb.append(h());
            sb.append("#DPRIOR$");
            sb.append(this.A);
            sb.append("#CATALOG$");
            sb.append(f);
            sb.append(this.m.e());
            if (this.r != null) {
                sb.append("#SECOND$");
                sb.append(this.r.f());
                sb.append('$');
                sb.append(this.r.e());
            }
            String str = this.F;
            if (str != null) {
                sb.append(str);
            }
            this.s = sb.substring(0);
        }
        return this.s;
    }

    public void e0(boolean z) {
        if (z) {
            this.E |= 4;
        } else {
            this.E &= -5;
        }
        g0();
    }

    public void f0(boolean z) {
        if (z) {
            this.E |= 2;
        } else {
            this.E &= -3;
        }
        g0();
    }

    public void h0(boolean z) {
        this.C = z;
    }

    public synchronized void i0(String str) {
        super.m();
        this.q = true;
        this.n = System.currentTimeMillis();
        this.r = null;
        this.y = null;
        if (!str.equals(this.m.k())) {
            this.m = new b(str, this.m.d());
            this.s = null;
        }
        ImageStatistics imageStatistics = this.o;
        String str2 = imageStatistics != null ? imageStatistics.q : "";
        this.o = new ImageStatistics(this.m, true);
        if (!TextUtils.isEmpty(str2)) {
            this.o.q = str2;
        }
        op0.f(this.o);
        Map<String, String> map = this.x;
        if (map != null) {
            map.remove("inner_is_async_http");
            this.o.y(this.x);
        }
        this.o.x(this.A);
    }

    public void j0(@NonNull BitmapProcessor[] bitmapProcessorArr) {
        String str = "";
        for (BitmapProcessor bitmapProcessor : bitmapProcessorArr) {
            str = str + "#PROCESSOR_" + bitmapProcessor.getClass().hashCode();
            String id = bitmapProcessor.getId();
            if (!TextUtils.isEmpty(id)) {
                str = str + "$" + id;
            }
        }
        this.D = bitmapProcessorArr;
        G().a(str);
        u(str);
    }

    public void k0(Future<?> future) {
        this.y = future;
    }

    public void l0(int i) {
        if (this.A != i) {
            this.A = i;
            this.o.x(i);
            g0();
        }
    }

    public void m0(int i) {
        if (this.w != i) {
            this.w = i;
            this.m.o(this.v, i);
            g0();
        }
    }

    public void n0(int i) {
        if (this.v != i) {
            this.v = i;
            this.m.o(i, this.w);
            g0();
        }
    }

    public void o0(int i) {
        this.B = i;
    }

    public void p0(PexodeOptions pexodeOptions) {
        this.z = pexodeOptions;
    }

    public void q0(String str) {
        this.r = new b(str, this.m.d());
    }

    @Override // tb.a22
    public void r(a22 a22Var) {
        a aVar = (a) a22Var;
        ImageStatistics U = aVar.U();
        this.o.a(true);
        this.o.b(U.k());
        this.o.v(U.j());
        this.o.A(U.o());
        Map<String, Long> Q = Q();
        for (Map.Entry<String, Long> entry : aVar.Q().entrySet()) {
            if (!Q.containsKey(entry.getKey())) {
                Q.put(entry.getKey(), entry.getValue());
            }
        }
    }

    public void r0(long j) {
        this.p = j;
    }

    public void s0() {
        this.E |= 1;
        g0();
    }

    public synchronized void t(String str, String str2) {
        if (this.x == null) {
            HashMap hashMap = new HashMap();
            this.x = hashMap;
            this.o.y(hashMap);
        }
        this.x.put(str, str2);
    }

    public void v(boolean z, int i) {
        if (z) {
            this.t |= i;
        } else {
            this.t &= ~i;
        }
        g0();
    }

    public void w(int i, boolean z) {
        h62 l = G().l();
        l.l = i;
        l.m = z;
        StringBuilder sb = new StringBuilder();
        sb.append("#THUMBNAIL$");
        if (z) {
            i *= 10000;
        }
        sb.append(i);
        String sb2 = sb.toString();
        G().a(sb2);
        u(sb2);
    }

    public void x() {
        this.r = null;
    }

    public void y(boolean z) {
        this.G = z;
        if (z) {
            G().a("#FSTATIC");
            u("#FSTATIC");
        }
    }

    public int z() {
        return this.t;
    }
}
