package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class io implements iu<io, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f733a;

    /* renamed from: a  reason: collision with other field name */
    public hy f734a;

    /* renamed from: a  reason: collision with other field name */
    public String f735a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f736a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f737b;

    /* renamed from: c  reason: collision with other field name */
    public String f738c;

    /* renamed from: d  reason: collision with other field name */
    public String f739d;

    /* renamed from: e  reason: collision with other field name */
    public String f740e;

    /* renamed from: f  reason: collision with other field name */
    public String f741f;

    /* renamed from: g  reason: collision with other field name */
    public String f742g;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f732a = new jk("XmPushActionSubscriptionResult");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 8);
    private static final jc h = new jc("", (byte) 11, 9);
    private static final jc i = new jc("", (byte) 11, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(io ioVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(ioVar.getClass())) {
            int compareTo = Boolean.valueOf(m1072a()).compareTo(Boolean.valueOf(ioVar.m1072a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1072a() || (a10 = iv.a(this.f735a, ioVar.f735a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1074b()).compareTo(Boolean.valueOf(ioVar.m1074b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1074b() || (a9 = iv.a(this.f734a, ioVar.f734a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1075c()).compareTo(Boolean.valueOf(ioVar.m1075c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1075c() || (a8 = iv.a(this.f737b, ioVar.f737b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ioVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = iv.a(this.f738c, ioVar.f738c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ioVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = iv.a(this.f733a, ioVar.f733a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ioVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = iv.a(this.f739d, ioVar.f739d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ioVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = iv.a(this.f740e, ioVar.f740e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ioVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = iv.a(this.f741f, ioVar.f741f)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ioVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = iv.a(this.f742g, ioVar.f742g)) == 0) {
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
        return getClass().getName().compareTo(ioVar.getClass().getName());
    }

    public String a() {
        return this.f737b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1071a() {
        if (this.f737b != null) {
            return;
        }
        throw new jg("Required field 'id' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                jfVar.f();
                m1071a();
                return;
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f735a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f734a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f737b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f738c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f733a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f739d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f740e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f741f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f742g = jfVar.mo1107a();
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
        this.f736a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1072a() {
        return this.f735a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1073a(io ioVar) {
        if (ioVar == null) {
            return false;
        }
        boolean m1072a = m1072a();
        boolean m1072a2 = ioVar.m1072a();
        if ((m1072a || m1072a2) && !(m1072a && m1072a2 && this.f735a.equals(ioVar.f735a))) {
            return false;
        }
        boolean m1074b = m1074b();
        boolean m1074b2 = ioVar.m1074b();
        if ((m1074b || m1074b2) && !(m1074b && m1074b2 && this.f734a.m1000a(ioVar.f734a))) {
            return false;
        }
        boolean m1075c = m1075c();
        boolean m1075c2 = ioVar.m1075c();
        if ((m1075c || m1075c2) && !(m1075c && m1075c2 && this.f737b.equals(ioVar.f737b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ioVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f738c.equals(ioVar.f738c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ioVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f733a == ioVar.f733a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ioVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f739d.equals(ioVar.f739d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ioVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f740e.equals(ioVar.f740e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ioVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f741f.equals(ioVar.f741f))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ioVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f742g.equals(ioVar.f742g);
        }
        return true;
    }

    public String b() {
        return this.f740e;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1071a();
        jfVar.a(f732a);
        if (this.f735a != null && m1072a()) {
            jfVar.a(a);
            jfVar.a(this.f735a);
            jfVar.b();
        }
        if (this.f734a != null && m1074b()) {
            jfVar.a(b);
            this.f734a.b(jfVar);
            jfVar.b();
        }
        if (this.f737b != null) {
            jfVar.a(c);
            jfVar.a(this.f737b);
            jfVar.b();
        }
        if (this.f738c != null && d()) {
            jfVar.a(d);
            jfVar.a(this.f738c);
            jfVar.b();
        }
        if (e()) {
            jfVar.a(e);
            jfVar.a(this.f733a);
            jfVar.b();
        }
        if (this.f739d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f739d);
            jfVar.b();
        }
        if (this.f740e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f740e);
            jfVar.b();
        }
        if (this.f741f != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f741f);
            jfVar.b();
        }
        if (this.f742g != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f742g);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1074b() {
        return this.f734a != null;
    }

    public String c() {
        return this.f742g;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1075c() {
        return this.f737b != null;
    }

    public boolean d() {
        return this.f738c != null;
    }

    public boolean e() {
        return this.f736a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof io)) {
            return m1073a((io) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f739d != null;
    }

    public boolean g() {
        return this.f740e != null;
    }

    public boolean h() {
        return this.f741f != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f742g != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscriptionResult(");
        boolean z2 = false;
        if (m1072a()) {
            sb.append("debug:");
            String str = this.f735a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m1074b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f734a;
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
        String str2 = this.f737b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appId:");
            String str3 = this.f738c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("errorCode:");
            sb.append(this.f733a);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f739d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str5 = this.f740e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f741f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f742g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
