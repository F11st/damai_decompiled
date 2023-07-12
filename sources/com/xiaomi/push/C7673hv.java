package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.hv */
/* loaded from: classes11.dex */
public class C7673hv implements iu<C7673hv, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f508a;

    /* renamed from: a  reason: collision with other field name */
    public hw f509a;

    /* renamed from: a  reason: collision with other field name */
    public hy f510a;

    /* renamed from: a  reason: collision with other field name */
    public String f511a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f512a = new BitSet(4);

    /* renamed from: a  reason: collision with other field name */
    public boolean f513a = false;

    /* renamed from: b  reason: collision with other field name */
    public long f514b;

    /* renamed from: b  reason: collision with other field name */
    public String f515b;

    /* renamed from: c  reason: collision with other field name */
    public long f516c;

    /* renamed from: c  reason: collision with other field name */
    public String f517c;

    /* renamed from: d  reason: collision with other field name */
    public String f518d;

    /* renamed from: e  reason: collision with other field name */
    public String f519e;

    /* renamed from: f  reason: collision with other field name */
    public String f520f;

    /* renamed from: g  reason: collision with other field name */
    public String f521g;

    /* renamed from: h  reason: collision with other field name */
    public String f522h;

    /* renamed from: i  reason: collision with other field name */
    public String f523i;

    /* renamed from: j  reason: collision with other field name */
    public String f524j;

    /* renamed from: k  reason: collision with other field name */
    public String f525k;

    /* renamed from: l  reason: collision with other field name */
    public String f526l;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f507a = new jk("PushMessage");
    private static final jc a = new jc("", (byte) 12, 1);
    private static final jc b = new jc("", (byte) 11, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 5);
    private static final jc f = new jc("", (byte) 10, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 11, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 11, 10);
    private static final jc k = new jc("", (byte) 11, 11);
    private static final jc l = new jc("", (byte) 12, 12);
    private static final jc m = new jc("", (byte) 11, 13);
    private static final jc n = new jc("", (byte) 2, 14);
    private static final jc o = new jc("", (byte) 11, 15);
    private static final jc p = new jc("", (byte) 10, 16);
    private static final jc q = new jc("", (byte) 11, 20);
    private static final jc r = new jc("", (byte) 11, 21);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C7673hv c7673hv) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        int a11;
        int a12;
        int a13;
        int a14;
        int a15;
        int a16;
        int a17;
        int a18;
        int a19;
        if (getClass().equals(c7673hv.getClass())) {
            int compareTo = Boolean.valueOf(m982a()).compareTo(Boolean.valueOf(c7673hv.m982a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m982a() || (a19 = iv.a(this.f510a, c7673hv.f510a)) == 0) {
                int compareTo2 = Boolean.valueOf(m984b()).compareTo(Boolean.valueOf(c7673hv.m984b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m984b() || (a18 = iv.a(this.f511a, c7673hv.f511a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m985c()).compareTo(Boolean.valueOf(c7673hv.m985c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m985c() || (a17 = iv.a(this.f515b, c7673hv.f515b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c7673hv.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a16 = iv.a(this.f517c, c7673hv.f517c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c7673hv.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a15 = iv.a(this.f508a, c7673hv.f508a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c7673hv.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a14 = iv.a(this.f514b, c7673hv.f514b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c7673hv.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a13 = iv.a(this.f518d, c7673hv.f518d)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c7673hv.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a12 = iv.a(this.f519e, c7673hv.f519e)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c7673hv.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a11 = iv.a(this.f520f, c7673hv.f520f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(c7673hv.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a10 = iv.a(this.f521g, c7673hv.f521g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c7673hv.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a9 = iv.a(this.f522h, c7673hv.f522h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(c7673hv.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a8 = iv.a(this.f509a, c7673hv.f509a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(c7673hv.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a7 = iv.a(this.f523i, c7673hv.f523i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(c7673hv.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a6 = iv.a(this.f513a, c7673hv.f513a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(c7673hv.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a5 = iv.a(this.f524j, c7673hv.f524j)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(c7673hv.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a4 = iv.a(this.f516c, c7673hv.f516c)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(c7673hv.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a3 = iv.a(this.f525k, c7673hv.f525k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(c7673hv.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a2 = iv.a(this.f526l, c7673hv.f526l)) == 0) {
                                                                                    return 0;
                                                                                }
                                                                                return a2;
                                                                            }
                                                                            return a3;
                                                                        }
                                                                        return a4;
                                                                    }
                                                                    return a5;
                                                                }
                                                                return a6;
                                                            }
                                                            return a7;
                                                        }
                                                        return a8;
                                                    }
                                                    return a9;
                                                }
                                                return a10;
                                            }
                                            return a11;
                                        }
                                        return a12;
                                    }
                                    return a13;
                                }
                                return a14;
                            }
                            return a15;
                        }
                        return a16;
                    }
                    return a17;
                }
                return a18;
            }
            return a19;
        }
        return getClass().getName().compareTo(c7673hv.getClass().getName());
    }

    public long a() {
        return this.f508a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m980a() {
        return this.f511a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m981a() {
        if (this.f511a == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f515b == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f517c != null) {
        } else {
            throw new jg("Required field 'payload' was not present! Struct: " + toString());
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                jfVar.f();
                m981a();
                return;
            }
            short s = mo1102a.f801a;
            if (s == 20) {
                if (b2 == 11) {
                    this.f525k = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 21) {
                switch (s) {
                    case 1:
                        if (b2 == 12) {
                            hy hyVar = new hy();
                            this.f510a = hyVar;
                            hyVar.a(jfVar);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 2:
                        if (b2 == 11) {
                            this.f511a = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 3:
                        if (b2 == 11) {
                            this.f515b = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 4:
                        if (b2 == 11) {
                            this.f517c = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 5:
                        if (b2 == 10) {
                            this.f508a = jfVar.mo1101a();
                            a(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 6:
                        if (b2 == 10) {
                            this.f514b = jfVar.mo1101a();
                            b(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 7:
                        if (b2 == 11) {
                            this.f518d = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 8:
                        if (b2 == 11) {
                            this.f519e = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 9:
                        if (b2 == 11) {
                            this.f520f = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 10:
                        if (b2 == 11) {
                            this.f521g = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 11:
                        if (b2 == 11) {
                            this.f522h = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 12:
                        if (b2 == 12) {
                            hw hwVar = new hw();
                            this.f509a = hwVar;
                            hwVar.a(jfVar);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 13:
                        if (b2 == 11) {
                            this.f523i = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 14:
                        if (b2 == 2) {
                            this.f513a = jfVar.mo1112a();
                            c(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 15:
                        if (b2 == 11) {
                            this.f524j = jfVar.mo1107a();
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    case 16:
                        if (b2 == 10) {
                            this.f516c = jfVar.mo1101a();
                            d(true);
                            break;
                        }
                        ji.a(jfVar, b2);
                        break;
                    default:
                        ji.a(jfVar, b2);
                        break;
                }
                jfVar.g();
            } else {
                if (b2 == 11) {
                    this.f526l = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
    }

    public void a(boolean z) {
        this.f512a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m982a() {
        return this.f510a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m983a(C7673hv c7673hv) {
        if (c7673hv == null) {
            return false;
        }
        boolean m982a = m982a();
        boolean m982a2 = c7673hv.m982a();
        if ((m982a || m982a2) && !(m982a && m982a2 && this.f510a.m1000a(c7673hv.f510a))) {
            return false;
        }
        boolean m984b = m984b();
        boolean m984b2 = c7673hv.m984b();
        if ((m984b || m984b2) && !(m984b && m984b2 && this.f511a.equals(c7673hv.f511a))) {
            return false;
        }
        boolean m985c = m985c();
        boolean m985c2 = c7673hv.m985c();
        if ((m985c || m985c2) && !(m985c && m985c2 && this.f515b.equals(c7673hv.f515b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = c7673hv.d();
        if ((d2 || d3) && !(d2 && d3 && this.f517c.equals(c7673hv.f517c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = c7673hv.e();
        if ((e2 || e3) && !(e2 && e3 && this.f508a == c7673hv.f508a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = c7673hv.f();
        if ((f2 || f3) && !(f2 && f3 && this.f514b == c7673hv.f514b)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = c7673hv.g();
        if ((g2 || g3) && !(g2 && g3 && this.f518d.equals(c7673hv.f518d))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = c7673hv.h();
        if ((h2 || h3) && !(h2 && h3 && this.f519e.equals(c7673hv.f519e))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = c7673hv.i();
        if ((i2 || i3) && !(i2 && i3 && this.f520f.equals(c7673hv.f520f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = c7673hv.j();
        if ((j2 || j3) && !(j2 && j3 && this.f521g.equals(c7673hv.f521g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = c7673hv.k();
        if ((k2 || k3) && !(k2 && k3 && this.f522h.equals(c7673hv.f522h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = c7673hv.l();
        if ((l2 || l3) && !(l2 && l3 && this.f509a.m992a(c7673hv.f509a))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = c7673hv.m();
        if ((m2 || m3) && !(m2 && m3 && this.f523i.equals(c7673hv.f523i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = c7673hv.n();
        if ((n2 || n3) && !(n2 && n3 && this.f513a == c7673hv.f513a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = c7673hv.o();
        if ((o2 || o3) && !(o2 && o3 && this.f524j.equals(c7673hv.f524j))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = c7673hv.p();
        if ((p2 || p3) && !(p2 && p3 && this.f516c == c7673hv.f516c)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = c7673hv.q();
        if ((q2 || q3) && !(q2 && q3 && this.f525k.equals(c7673hv.f525k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = c7673hv.r();
        if (r2 || r3) {
            return r2 && r3 && this.f526l.equals(c7673hv.f526l);
        }
        return true;
    }

    public String b() {
        return this.f515b;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m981a();
        jfVar.a(f507a);
        if (this.f510a != null && m982a()) {
            jfVar.a(a);
            this.f510a.b(jfVar);
            jfVar.b();
        }
        if (this.f511a != null) {
            jfVar.a(b);
            jfVar.a(this.f511a);
            jfVar.b();
        }
        if (this.f515b != null) {
            jfVar.a(c);
            jfVar.a(this.f515b);
            jfVar.b();
        }
        if (this.f517c != null) {
            jfVar.a(d);
            jfVar.a(this.f517c);
            jfVar.b();
        }
        if (e()) {
            jfVar.a(e);
            jfVar.a(this.f508a);
            jfVar.b();
        }
        if (f()) {
            jfVar.a(f);
            jfVar.a(this.f514b);
            jfVar.b();
        }
        if (this.f518d != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f518d);
            jfVar.b();
        }
        if (this.f519e != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f519e);
            jfVar.b();
        }
        if (this.f520f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f520f);
            jfVar.b();
        }
        if (this.f521g != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f521g);
            jfVar.b();
        }
        if (this.f522h != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f522h);
            jfVar.b();
        }
        if (this.f509a != null && l()) {
            jfVar.a(l);
            this.f509a.b(jfVar);
            jfVar.b();
        }
        if (this.f523i != null && m()) {
            jfVar.a(m);
            jfVar.a(this.f523i);
            jfVar.b();
        }
        if (n()) {
            jfVar.a(n);
            jfVar.a(this.f513a);
            jfVar.b();
        }
        if (this.f524j != null && o()) {
            jfVar.a(o);
            jfVar.a(this.f524j);
            jfVar.b();
        }
        if (p()) {
            jfVar.a(p);
            jfVar.a(this.f516c);
            jfVar.b();
        }
        if (this.f525k != null && q()) {
            jfVar.a(q);
            jfVar.a(this.f525k);
            jfVar.b();
        }
        if (this.f526l != null && r()) {
            jfVar.a(r);
            jfVar.a(this.f526l);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f512a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m984b() {
        return this.f511a != null;
    }

    public String c() {
        return this.f517c;
    }

    public void c(boolean z) {
        this.f512a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m985c() {
        return this.f515b != null;
    }

    public void d(boolean z) {
        this.f512a.set(3, z);
    }

    public boolean d() {
        return this.f517c != null;
    }

    public boolean e() {
        return this.f512a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C7673hv)) {
            return m983a((C7673hv) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f512a.get(1);
    }

    public boolean g() {
        return this.f518d != null;
    }

    public boolean h() {
        return this.f519e != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f520f != null;
    }

    public boolean j() {
        return this.f521g != null;
    }

    public boolean k() {
        return this.f522h != null;
    }

    public boolean l() {
        return this.f509a != null;
    }

    public boolean m() {
        return this.f523i != null;
    }

    public boolean n() {
        return this.f512a.get(2);
    }

    public boolean o() {
        return this.f524j != null;
    }

    public boolean p() {
        return this.f512a.get(3);
    }

    public boolean q() {
        return this.f525k != null;
    }

    public boolean r() {
        return this.f526l != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("PushMessage(");
        if (m982a()) {
            sb.append("to:");
            hy hyVar = this.f510a;
            if (hyVar == null) {
                sb.append("null");
            } else {
                sb.append(hyVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append("id:");
        String str = this.f511a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str2 = this.f515b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("payload:");
        String str3 = this.f517c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createAt:");
            sb.append(this.f508a);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("ttl:");
            sb.append(this.f514b);
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("collapseKey:");
            String str4 = this.f518d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f519e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str6 = this.f520f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f521g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str8 = this.f522h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("metaInfo:");
            hw hwVar = this.f509a;
            if (hwVar == null) {
                sb.append("null");
            } else {
                sb.append(hwVar);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str9 = this.f523i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("isOnline:");
            sb.append(this.f513a);
        }
        if (o()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("userAccount:");
            String str10 = this.f524j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (p()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("miid:");
            sb.append(this.f516c);
        }
        if (q()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("imeiMd5:");
            String str11 = this.f525k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceId:");
            String str12 = this.f526l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
