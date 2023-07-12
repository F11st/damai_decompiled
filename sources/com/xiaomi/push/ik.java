package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ik implements iu<ik, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f679a;

    /* renamed from: a  reason: collision with other field name */
    public long f680a;

    /* renamed from: a  reason: collision with other field name */
    public hy f681a;

    /* renamed from: a  reason: collision with other field name */
    public String f682a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f684a;

    /* renamed from: b  reason: collision with other field name */
    public int f686b;

    /* renamed from: b  reason: collision with other field name */
    public long f687b;

    /* renamed from: b  reason: collision with other field name */
    public String f688b;

    /* renamed from: c  reason: collision with other field name */
    public long f689c;

    /* renamed from: c  reason: collision with other field name */
    public String f690c;

    /* renamed from: d  reason: collision with other field name */
    public String f691d;

    /* renamed from: e  reason: collision with other field name */
    public String f692e;

    /* renamed from: f  reason: collision with other field name */
    public String f693f;

    /* renamed from: g  reason: collision with other field name */
    public String f694g;

    /* renamed from: h  reason: collision with other field name */
    public String f695h;

    /* renamed from: i  reason: collision with other field name */
    public String f696i;

    /* renamed from: j  reason: collision with other field name */
    public String f697j;

    /* renamed from: k  reason: collision with other field name */
    public String f698k;

    /* renamed from: l  reason: collision with other field name */
    public String f699l;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f678a = new jk("XmPushActionRegistrationResult");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 8);
    private static final jc h = new jc("", (byte) 11, 9);
    private static final jc i = new jc("", (byte) 11, 10);
    private static final jc j = new jc("", (byte) 10, 11);
    private static final jc k = new jc("", (byte) 11, 12);
    private static final jc l = new jc("", (byte) 11, 13);
    private static final jc m = new jc("", (byte) 10, 14);
    private static final jc n = new jc("", (byte) 11, 15);
    private static final jc o = new jc("", (byte) 8, 16);
    private static final jc p = new jc("", (byte) 11, 17);
    private static final jc q = new jc("", (byte) 8, 18);
    private static final jc r = new jc("", (byte) 11, 19);
    private static final jc s = new jc("", (byte) 2, 20);
    private static final jc t = new jc("", (byte) 15, 21);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f683a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f685a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ik ikVar) {
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
        int a20;
        int a21;
        if (getClass().equals(ikVar.getClass())) {
            int compareTo = Boolean.valueOf(m1054a()).compareTo(Boolean.valueOf(ikVar.m1054a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1054a() || (a21 = iv.a(this.f682a, ikVar.f682a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1056b()).compareTo(Boolean.valueOf(ikVar.m1056b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1056b() || (a20 = iv.a(this.f681a, ikVar.f681a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1057c()).compareTo(Boolean.valueOf(ikVar.m1057c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1057c() || (a19 = iv.a(this.f688b, ikVar.f688b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ikVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = iv.a(this.f690c, ikVar.f690c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ikVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = iv.a(this.f680a, ikVar.f680a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ikVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = iv.a(this.f691d, ikVar.f691d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ikVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = iv.a(this.f692e, ikVar.f692e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ikVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = iv.a(this.f693f, ikVar.f693f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ikVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = iv.a(this.f694g, ikVar.f694g)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ikVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = iv.a(this.f687b, ikVar.f687b)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ikVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = iv.a(this.f695h, ikVar.f695h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ikVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = iv.a(this.f696i, ikVar.f696i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ikVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = iv.a(this.f689c, ikVar.f689c)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ikVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = iv.a(this.f697j, ikVar.f697j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ikVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = iv.a(this.f679a, ikVar.f679a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ikVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = iv.a(this.f698k, ikVar.f698k)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ikVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = iv.a(this.f686b, ikVar.f686b)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ikVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = iv.a(this.f699l, ikVar.f699l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ikVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = iv.a(this.f685a, ikVar.f685a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ikVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = iv.a(this.f684a, ikVar.f684a)) == 0) {
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
                return a20;
            }
            return a21;
        }
        return getClass().getName().compareTo(ikVar.getClass().getName());
    }

    public long a() {
        return this.f680a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1051a() {
        return this.f688b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m1052a() {
        return this.f684a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1053a() {
        if (this.f688b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f690c != null) {
        } else {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        }
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                jfVar.f();
                if (e()) {
                    m1053a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f682a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f681a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f688b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f690c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f680a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f691d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f692e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f693f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f694g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 10) {
                        this.f687b = jfVar.mo1101a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f695h = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f696i = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 10) {
                        this.f689c = jfVar.mo1101a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f697j = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 8) {
                        this.f679a = jfVar.mo1100a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f698k = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 8) {
                        this.f686b = jfVar.mo1100a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 11) {
                        this.f699l = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f685a = jfVar.mo1112a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 15) {
                        jd mo1103a = jfVar.mo1103a();
                        this.f684a = new ArrayList(mo1103a.f802a);
                        for (int i2 = 0; i2 < mo1103a.f802a; i2++) {
                            this.f684a.add(jfVar.mo1107a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z) {
        this.f683a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1054a() {
        return this.f682a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1055a(ik ikVar) {
        if (ikVar == null) {
            return false;
        }
        boolean m1054a = m1054a();
        boolean m1054a2 = ikVar.m1054a();
        if ((m1054a || m1054a2) && !(m1054a && m1054a2 && this.f682a.equals(ikVar.f682a))) {
            return false;
        }
        boolean m1056b = m1056b();
        boolean m1056b2 = ikVar.m1056b();
        if ((m1056b || m1056b2) && !(m1056b && m1056b2 && this.f681a.m1000a(ikVar.f681a))) {
            return false;
        }
        boolean m1057c = m1057c();
        boolean m1057c2 = ikVar.m1057c();
        if ((m1057c || m1057c2) && !(m1057c && m1057c2 && this.f688b.equals(ikVar.f688b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ikVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f690c.equals(ikVar.f690c))) || this.f680a != ikVar.f680a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ikVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f691d.equals(ikVar.f691d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ikVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f692e.equals(ikVar.f692e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ikVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f693f.equals(ikVar.f693f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ikVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f694g.equals(ikVar.f694g))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ikVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f687b == ikVar.f687b)) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ikVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f695h.equals(ikVar.f695h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ikVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f696i.equals(ikVar.f696i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ikVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f689c == ikVar.f689c)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ikVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f697j.equals(ikVar.f697j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ikVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f679a == ikVar.f679a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ikVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f698k.equals(ikVar.f698k))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ikVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f686b == ikVar.f686b)) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ikVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f699l.equals(ikVar.f699l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ikVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f685a == ikVar.f685a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = ikVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f684a.equals(ikVar.f684a);
        }
        return true;
    }

    public String b() {
        return this.f693f;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1053a();
        jfVar.a(f678a);
        if (this.f682a != null && m1054a()) {
            jfVar.a(a);
            jfVar.a(this.f682a);
            jfVar.b();
        }
        if (this.f681a != null && m1056b()) {
            jfVar.a(b);
            this.f681a.b(jfVar);
            jfVar.b();
        }
        if (this.f688b != null) {
            jfVar.a(c);
            jfVar.a(this.f688b);
            jfVar.b();
        }
        if (this.f690c != null) {
            jfVar.a(d);
            jfVar.a(this.f690c);
            jfVar.b();
        }
        jfVar.a(e);
        jfVar.a(this.f680a);
        jfVar.b();
        if (this.f691d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f691d);
            jfVar.b();
        }
        if (this.f692e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f692e);
            jfVar.b();
        }
        if (this.f693f != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f693f);
            jfVar.b();
        }
        if (this.f694g != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f694g);
            jfVar.b();
        }
        if (j()) {
            jfVar.a(j);
            jfVar.a(this.f687b);
            jfVar.b();
        }
        if (this.f695h != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f695h);
            jfVar.b();
        }
        if (this.f696i != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f696i);
            jfVar.b();
        }
        if (m()) {
            jfVar.a(m);
            jfVar.a(this.f689c);
            jfVar.b();
        }
        if (this.f697j != null && n()) {
            jfVar.a(n);
            jfVar.a(this.f697j);
            jfVar.b();
        }
        if (o()) {
            jfVar.a(o);
            jfVar.mo1111a(this.f679a);
            jfVar.b();
        }
        if (this.f698k != null && p()) {
            jfVar.a(p);
            jfVar.a(this.f698k);
            jfVar.b();
        }
        if (q()) {
            jfVar.a(q);
            jfVar.mo1111a(this.f686b);
            jfVar.b();
        }
        if (this.f699l != null && r()) {
            jfVar.a(r);
            jfVar.a(this.f699l);
            jfVar.b();
        }
        if (s()) {
            jfVar.a(s);
            jfVar.a(this.f685a);
            jfVar.b();
        }
        if (this.f684a != null && t()) {
            jfVar.a(t);
            jfVar.a(new jd((byte) 11, this.f684a.size()));
            for (String str : this.f684a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f683a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1056b() {
        return this.f681a != null;
    }

    public String c() {
        return this.f694g;
    }

    public void c(boolean z) {
        this.f683a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1057c() {
        return this.f688b != null;
    }

    public void d(boolean z) {
        this.f683a.set(3, z);
    }

    public boolean d() {
        return this.f690c != null;
    }

    public void e(boolean z) {
        this.f683a.set(4, z);
    }

    public boolean e() {
        return this.f683a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ik)) {
            return m1055a((ik) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f683a.set(5, z);
    }

    public boolean f() {
        return this.f691d != null;
    }

    public boolean g() {
        return this.f692e != null;
    }

    public boolean h() {
        return this.f693f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f694g != null;
    }

    public boolean j() {
        return this.f683a.get(1);
    }

    public boolean k() {
        return this.f695h != null;
    }

    public boolean l() {
        return this.f696i != null;
    }

    public boolean m() {
        return this.f683a.get(2);
    }

    public boolean n() {
        return this.f697j != null;
    }

    public boolean o() {
        return this.f683a.get(3);
    }

    public boolean p() {
        return this.f698k != null;
    }

    public boolean q() {
        return this.f683a.get(4);
    }

    public boolean r() {
        return this.f699l != null;
    }

    public boolean s() {
        return this.f683a.get(5);
    }

    public boolean t() {
        return this.f684a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionRegistrationResult(");
        boolean z2 = false;
        if (m1054a()) {
            sb.append("debug:");
            String str = this.f682a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m1056b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f681a;
            if (hyVar == null) {
                sb.append("null");
            } else {
                sb.append(hyVar);
            }
        } else {
            z2 = z;
        }
        if (!z2) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append("id:");
        String str2 = this.f688b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f690c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("errorCode:");
        sb.append(this.f680a);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f691d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str5 = this.f692e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f694g;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("registeredAt:");
            sb.append(this.f687b);
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str7 = this.f695h;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("clientId:");
            String str8 = this.f696i;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("costTime:");
            sb.append(this.f689c);
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersion:");
            String str9 = this.f697j;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (o()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f679a);
        }
        if (p()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("hybridPushEndpoint:");
            String str10 = this.f698k;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (q()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersionCode:");
            sb.append(this.f686b);
        }
        if (r()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("region:");
            String str11 = this.f699l;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (s()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("isHybridFrame:");
            sb.append(this.f685a);
        }
        if (t()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("autoMarkPkgs:");
            List<String> list = this.f684a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
