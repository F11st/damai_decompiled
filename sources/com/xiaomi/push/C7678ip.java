package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.ip */
/* loaded from: classes11.dex */
public class C7678ip implements iu<C7678ip, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f744a;

    /* renamed from: a  reason: collision with other field name */
    public hy f745a;

    /* renamed from: a  reason: collision with other field name */
    public String f746a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f747a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f748a = true;

    /* renamed from: b  reason: collision with other field name */
    public String f749b;

    /* renamed from: c  reason: collision with other field name */
    public String f750c;

    /* renamed from: d  reason: collision with other field name */
    public String f751d;

    /* renamed from: e  reason: collision with other field name */
    public String f752e;

    /* renamed from: f  reason: collision with other field name */
    public String f753f;

    /* renamed from: g  reason: collision with other field name */
    public String f754g;

    /* renamed from: h  reason: collision with other field name */
    public String f755h;

    /* renamed from: i  reason: collision with other field name */
    public String f756i;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f743a = new jk("XmPushActionUnRegistration");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 11, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 11, 10);
    private static final jc k = new jc("", (byte) 2, 11);
    private static final jc l = new jc("", (byte) 10, 12);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(C7678ip c7678ip) {
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
        if (getClass().equals(c7678ip.getClass())) {
            int compareTo = Boolean.valueOf(m1076a()).compareTo(Boolean.valueOf(c7678ip.m1076a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1076a() || (a13 = iv.a(this.f746a, c7678ip.f746a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c7678ip.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a12 = iv.a(this.f745a, c7678ip.f745a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c7678ip.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a11 = iv.a(this.f749b, c7678ip.f749b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c7678ip.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a10 = iv.a(this.f750c, c7678ip.f750c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c7678ip.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a9 = iv.a(this.f751d, c7678ip.f751d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c7678ip.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a8 = iv.a(this.f752e, c7678ip.f752e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c7678ip.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = iv.a(this.f753f, c7678ip.f753f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c7678ip.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = iv.a(this.f754g, c7678ip.f754g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(c7678ip.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = iv.a(this.f755h, c7678ip.f755h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(c7678ip.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = iv.a(this.f756i, c7678ip.f756i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(c7678ip.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = iv.a(this.f748a, c7678ip.f748a)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(c7678ip.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = iv.a(this.f744a, c7678ip.f744a)) == 0) {
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
        return getClass().getName().compareTo(c7678ip.getClass().getName());
    }

    public C7678ip a(String str) {
        this.f749b = str;
        return this;
    }

    public void a() {
        if (this.f749b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f750c != null) {
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
                a();
                return;
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f746a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f745a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f749b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f750c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f751d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f752e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f753f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f754g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f755h = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f756i = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f748a = jfVar.mo1112a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f744a = jfVar.mo1101a();
                        b(true);
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
        this.f747a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1076a() {
        return this.f746a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1077a(C7678ip c7678ip) {
        if (c7678ip == null) {
            return false;
        }
        boolean m1076a = m1076a();
        boolean m1076a2 = c7678ip.m1076a();
        if ((m1076a || m1076a2) && !(m1076a && m1076a2 && this.f746a.equals(c7678ip.f746a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = c7678ip.b();
        if ((b2 || b3) && !(b2 && b3 && this.f745a.m1000a(c7678ip.f745a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = c7678ip.c();
        if ((c2 || c3) && !(c2 && c3 && this.f749b.equals(c7678ip.f749b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = c7678ip.d();
        if ((d2 || d3) && !(d2 && d3 && this.f750c.equals(c7678ip.f750c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = c7678ip.e();
        if ((e2 || e3) && !(e2 && e3 && this.f751d.equals(c7678ip.f751d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = c7678ip.f();
        if ((f2 || f3) && !(f2 && f3 && this.f752e.equals(c7678ip.f752e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = c7678ip.g();
        if ((g2 || g3) && !(g2 && g3 && this.f753f.equals(c7678ip.f753f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = c7678ip.h();
        if ((h2 || h3) && !(h2 && h3 && this.f754g.equals(c7678ip.f754g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = c7678ip.i();
        if ((i2 || i3) && !(i2 && i3 && this.f755h.equals(c7678ip.f755h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = c7678ip.j();
        if ((j2 || j3) && !(j2 && j3 && this.f756i.equals(c7678ip.f756i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = c7678ip.k();
        if ((k2 || k3) && !(k2 && k3 && this.f748a == c7678ip.f748a)) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = c7678ip.l();
        if (l2 || l3) {
            return l2 && l3 && this.f744a == c7678ip.f744a;
        }
        return true;
    }

    public C7678ip b(String str) {
        this.f750c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f743a);
        if (this.f746a != null && m1076a()) {
            jfVar.a(a);
            jfVar.a(this.f746a);
            jfVar.b();
        }
        if (this.f745a != null && b()) {
            jfVar.a(b);
            this.f745a.b(jfVar);
            jfVar.b();
        }
        if (this.f749b != null) {
            jfVar.a(c);
            jfVar.a(this.f749b);
            jfVar.b();
        }
        if (this.f750c != null) {
            jfVar.a(d);
            jfVar.a(this.f750c);
            jfVar.b();
        }
        if (this.f751d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f751d);
            jfVar.b();
        }
        if (this.f752e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f752e);
            jfVar.b();
        }
        if (this.f753f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f753f);
            jfVar.b();
        }
        if (this.f754g != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f754g);
            jfVar.b();
        }
        if (this.f755h != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f755h);
            jfVar.b();
        }
        if (this.f756i != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f756i);
            jfVar.b();
        }
        if (k()) {
            jfVar.a(k);
            jfVar.a(this.f748a);
            jfVar.b();
        }
        if (l()) {
            jfVar.a(l);
            jfVar.a(this.f744a);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f747a.set(1, z);
    }

    public boolean b() {
        return this.f745a != null;
    }

    public C7678ip c(String str) {
        this.f751d = str;
        return this;
    }

    public boolean c() {
        return this.f749b != null;
    }

    public C7678ip d(String str) {
        this.f753f = str;
        return this;
    }

    public boolean d() {
        return this.f750c != null;
    }

    public C7678ip e(String str) {
        this.f754g = str;
        return this;
    }

    public boolean e() {
        return this.f751d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C7678ip)) {
            return m1077a((C7678ip) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f752e != null;
    }

    public boolean g() {
        return this.f753f != null;
    }

    public boolean h() {
        return this.f754g != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f755h != null;
    }

    public boolean j() {
        return this.f756i != null;
    }

    public boolean k() {
        return this.f747a.get(0);
    }

    public boolean l() {
        return this.f747a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistration(");
        boolean z2 = false;
        if (m1076a()) {
            sb.append("debug:");
            String str = this.f746a;
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
            hy hyVar = this.f745a;
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
        String str2 = this.f749b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f750c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str4 = this.f751d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersion:");
            String str5 = this.f752e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f753f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("token:");
            String str7 = this.f754g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceId:");
            String str8 = this.f755h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str9 = this.f756i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("needAck:");
            sb.append(this.f748a);
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createdTs:");
            sb.append(this.f744a);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
