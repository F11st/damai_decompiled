package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hz implements iu<hz, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f553a;

    /* renamed from: a  reason: collision with other field name */
    public long f554a;

    /* renamed from: a  reason: collision with other field name */
    public hy f555a;

    /* renamed from: a  reason: collision with other field name */
    public C7675im f556a;

    /* renamed from: a  reason: collision with other field name */
    public String f557a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f559a;

    /* renamed from: a  reason: collision with other field name */
    public short f560a;

    /* renamed from: b  reason: collision with other field name */
    public String f562b;

    /* renamed from: b  reason: collision with other field name */
    public short f563b;

    /* renamed from: c  reason: collision with other field name */
    public String f564c;

    /* renamed from: d  reason: collision with other field name */
    public String f565d;

    /* renamed from: e  reason: collision with other field name */
    public String f566e;

    /* renamed from: f  reason: collision with other field name */
    public String f567f;

    /* renamed from: g  reason: collision with other field name */
    public String f568g;

    /* renamed from: h  reason: collision with other field name */
    public String f569h;

    /* renamed from: i  reason: collision with other field name */
    public String f570i;

    /* renamed from: j  reason: collision with other field name */
    public String f571j;

    /* renamed from: k  reason: collision with other field name */
    public String f572k;

    /* renamed from: l  reason: collision with other field name */
    public String f573l;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f552a = new jk("XmPushActionAckMessage");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 12, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 11, 10);
    private static final jc k = new jc("", (byte) 2, 11);
    private static final jc l = new jc("", (byte) 11, 12);
    private static final jc m = new jc("", (byte) 11, 13);
    private static final jc n = new jc("", (byte) 11, 14);
    private static final jc o = new jc("", (byte) 6, 15);
    private static final jc p = new jc("", (byte) 6, 16);
    private static final jc q = new jc("", (byte) 11, 20);
    private static final jc r = new jc("", (byte) 11, 21);
    private static final jc s = new jc("", (byte) 8, 22);
    private static final jc t = new jc("", (byte) 13, 23);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f558a = new BitSet(5);

    /* renamed from: a  reason: collision with other field name */
    public boolean f561a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hz hzVar) {
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
        if (getClass().equals(hzVar.getClass())) {
            int compareTo = Boolean.valueOf(m1001a()).compareTo(Boolean.valueOf(hzVar.m1001a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1001a() || (a21 = iv.a(this.f557a, hzVar.f557a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hzVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a20 = iv.a(this.f555a, hzVar.f555a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hzVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a19 = iv.a(this.f562b, hzVar.f562b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hzVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a18 = iv.a(this.f564c, hzVar.f564c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hzVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a17 = iv.a(this.f554a, hzVar.f554a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hzVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a16 = iv.a(this.f565d, hzVar.f565d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hzVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a15 = iv.a(this.f566e, hzVar.f566e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hzVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a14 = iv.a(this.f556a, hzVar.f556a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hzVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a13 = iv.a(this.f567f, hzVar.f567f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hzVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a12 = iv.a(this.f568g, hzVar.f568g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hzVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a11 = iv.a(this.f561a, hzVar.f561a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(hzVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a10 = iv.a(this.f569h, hzVar.f569h)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hzVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a9 = iv.a(this.f570i, hzVar.f570i)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hzVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a8 = iv.a(this.f571j, hzVar.f571j)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(hzVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a7 = iv.a(this.f560a, hzVar.f560a)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(hzVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a6 = iv.a(this.f563b, hzVar.f563b)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(hzVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a5 = iv.a(this.f572k, hzVar.f572k)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(hzVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a4 = iv.a(this.f573l, hzVar.f573l)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(hzVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a3 = iv.a(this.f553a, hzVar.f553a)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(hzVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a2 = iv.a(this.f559a, hzVar.f559a)) == 0) {
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
        return getClass().getName().compareTo(hzVar.getClass().getName());
    }

    public hz a(long j2) {
        this.f554a = j2;
        a(true);
        return this;
    }

    public hz a(String str) {
        this.f562b = str;
        return this;
    }

    public hz a(short s2) {
        this.f560a = s2;
        c(true);
        return this;
    }

    public void a() {
        if (this.f562b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f564c != null) {
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
                    a();
                    return;
                }
                throw new jg("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f557a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f555a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f562b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f564c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f554a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f565d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f566e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        C7675im c7675im = new C7675im();
                        this.f556a = c7675im;
                        c7675im.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f567f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f568g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f561a = jfVar.mo1112a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f569h = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f570i = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f571j = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 6) {
                        this.f560a = jfVar.mo1109a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 6) {
                        this.f563b = jfVar.mo1109a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 11) {
                        this.f572k = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 11) {
                        this.f573l = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 8) {
                        this.f553a = jfVar.mo1100a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 13) {
                        je mo1104a = jfVar.mo1104a();
                        this.f559a = new HashMap(mo1104a.f803a * 2);
                        for (int i2 = 0; i2 < mo1104a.f803a; i2++) {
                            this.f559a.put(jfVar.mo1107a(), jfVar.mo1107a());
                        }
                        jfVar.h();
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
        this.f558a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1001a() {
        return this.f557a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1002a(hz hzVar) {
        if (hzVar == null) {
            return false;
        }
        boolean m1001a = m1001a();
        boolean m1001a2 = hzVar.m1001a();
        if ((m1001a || m1001a2) && !(m1001a && m1001a2 && this.f557a.equals(hzVar.f557a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = hzVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f555a.m1000a(hzVar.f555a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = hzVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f562b.equals(hzVar.f562b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = hzVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f564c.equals(hzVar.f564c))) || this.f554a != hzVar.f554a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hzVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f565d.equals(hzVar.f565d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hzVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f566e.equals(hzVar.f566e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hzVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f556a.m1063a(hzVar.f556a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hzVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f567f.equals(hzVar.f567f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hzVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f568g.equals(hzVar.f568g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hzVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f561a == hzVar.f561a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = hzVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f569h.equals(hzVar.f569h))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hzVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f570i.equals(hzVar.f570i))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = hzVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f571j.equals(hzVar.f571j))) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = hzVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f560a == hzVar.f560a)) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = hzVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f563b == hzVar.f563b)) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = hzVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f572k.equals(hzVar.f572k))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = hzVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f573l.equals(hzVar.f573l))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = hzVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f553a == hzVar.f553a)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = hzVar.t();
        if (t2 || t3) {
            return t2 && t3 && this.f559a.equals(hzVar.f559a);
        }
        return true;
    }

    public hz b(String str) {
        this.f564c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f552a);
        if (this.f557a != null && m1001a()) {
            jfVar.a(a);
            jfVar.a(this.f557a);
            jfVar.b();
        }
        if (this.f555a != null && b()) {
            jfVar.a(b);
            this.f555a.b(jfVar);
            jfVar.b();
        }
        if (this.f562b != null) {
            jfVar.a(c);
            jfVar.a(this.f562b);
            jfVar.b();
        }
        if (this.f564c != null) {
            jfVar.a(d);
            jfVar.a(this.f564c);
            jfVar.b();
        }
        jfVar.a(e);
        jfVar.a(this.f554a);
        jfVar.b();
        if (this.f565d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f565d);
            jfVar.b();
        }
        if (this.f566e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f566e);
            jfVar.b();
        }
        if (this.f556a != null && h()) {
            jfVar.a(h);
            this.f556a.b(jfVar);
            jfVar.b();
        }
        if (this.f567f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f567f);
            jfVar.b();
        }
        if (this.f568g != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f568g);
            jfVar.b();
        }
        if (k()) {
            jfVar.a(k);
            jfVar.a(this.f561a);
            jfVar.b();
        }
        if (this.f569h != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f569h);
            jfVar.b();
        }
        if (this.f570i != null && m()) {
            jfVar.a(m);
            jfVar.a(this.f570i);
            jfVar.b();
        }
        if (this.f571j != null && n()) {
            jfVar.a(n);
            jfVar.a(this.f571j);
            jfVar.b();
        }
        if (o()) {
            jfVar.a(o);
            jfVar.a(this.f560a);
            jfVar.b();
        }
        if (p()) {
            jfVar.a(p);
            jfVar.a(this.f563b);
            jfVar.b();
        }
        if (this.f572k != null && q()) {
            jfVar.a(q);
            jfVar.a(this.f572k);
            jfVar.b();
        }
        if (this.f573l != null && r()) {
            jfVar.a(r);
            jfVar.a(this.f573l);
            jfVar.b();
        }
        if (s()) {
            jfVar.a(s);
            jfVar.mo1111a(this.f553a);
            jfVar.b();
        }
        if (this.f559a != null && t()) {
            jfVar.a(t);
            jfVar.a(new je((byte) 11, (byte) 11, this.f559a.size()));
            for (Map.Entry<String, String> entry : this.f559a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f558a.set(1, z);
    }

    public boolean b() {
        return this.f555a != null;
    }

    public hz c(String str) {
        this.f565d = str;
        return this;
    }

    public void c(boolean z) {
        this.f558a.set(2, z);
    }

    public boolean c() {
        return this.f562b != null;
    }

    public hz d(String str) {
        this.f566e = str;
        return this;
    }

    public void d(boolean z) {
        this.f558a.set(3, z);
    }

    public boolean d() {
        return this.f564c != null;
    }

    public void e(boolean z) {
        this.f558a.set(4, z);
    }

    public boolean e() {
        return this.f558a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hz)) {
            return m1002a((hz) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f565d != null;
    }

    public boolean g() {
        return this.f566e != null;
    }

    public boolean h() {
        return this.f556a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f567f != null;
    }

    public boolean j() {
        return this.f568g != null;
    }

    public boolean k() {
        return this.f558a.get(1);
    }

    public boolean l() {
        return this.f569h != null;
    }

    public boolean m() {
        return this.f570i != null;
    }

    public boolean n() {
        return this.f571j != null;
    }

    public boolean o() {
        return this.f558a.get(2);
    }

    public boolean p() {
        return this.f558a.get(3);
    }

    public boolean q() {
        return this.f572k != null;
    }

    public boolean r() {
        return this.f573l != null;
    }

    public boolean s() {
        return this.f558a.get(4);
    }

    public boolean t() {
        return this.f559a != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionAckMessage(");
        boolean z2 = false;
        if (m1001a()) {
            sb.append("debug:");
            String str = this.f557a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f555a;
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
        String str2 = this.f562b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f564c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("messageTs:");
        sb.append(this.f554a);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str4 = this.f565d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str5 = this.f566e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("request:");
            C7675im c7675im = this.f556a;
            if (c7675im == null) {
                sb.append("null");
            } else {
                sb.append(c7675im);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f567f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f568g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("isOnline:");
            sb.append(this.f561a);
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str8 = this.f569h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("callbackUrl:");
            String str9 = this.f570i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("userAccount:");
            String str10 = this.f571j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (o()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceStatus:");
            sb.append((int) this.f560a);
        }
        if (p()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("geoMsgStatus:");
            sb.append((int) this.f563b);
        }
        if (q()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("imeiMd5:");
            String str11 = this.f572k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (r()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceId:");
            String str12 = this.f573l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (s()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("passThrough:");
            sb.append(this.f553a);
        }
        if (t()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("extra:");
            Map<String, String> map = this.f559a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
