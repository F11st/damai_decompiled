package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class iq implements iu<iq, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f758a;

    /* renamed from: a  reason: collision with other field name */
    public hy f759a;

    /* renamed from: a  reason: collision with other field name */
    public String f760a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f761a = new BitSet(3);

    /* renamed from: b  reason: collision with other field name */
    public long f762b;

    /* renamed from: b  reason: collision with other field name */
    public String f763b;

    /* renamed from: c  reason: collision with other field name */
    public long f764c;

    /* renamed from: c  reason: collision with other field name */
    public String f765c;

    /* renamed from: d  reason: collision with other field name */
    public String f766d;

    /* renamed from: e  reason: collision with other field name */
    public String f767e;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f757a = new jk("XmPushActionUnRegistrationResult");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 8);
    private static final jc h = new jc("", (byte) 10, 9);
    private static final jc i = new jc("", (byte) 10, 10);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(iq iqVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        int a10;
        if (getClass().equals(iqVar.getClass())) {
            int compareTo = Boolean.valueOf(m1079a()).compareTo(Boolean.valueOf(iqVar.m1079a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1079a() || (a10 = iv.a(this.f760a, iqVar.f760a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(iqVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a9 = iv.a(this.f759a, iqVar.f759a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(iqVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a8 = iv.a(this.f763b, iqVar.f763b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iqVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a7 = iv.a(this.f765c, iqVar.f765c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iqVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a6 = iv.a(this.f758a, iqVar.f758a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iqVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a5 = iv.a(this.f766d, iqVar.f766d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iqVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a4 = iv.a(this.f767e, iqVar.f767e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iqVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a3 = iv.a(this.f762b, iqVar.f762b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iqVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a2 = iv.a(this.f764c, iqVar.f764c)) == 0) {
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
        return getClass().getName().compareTo(iqVar.getClass().getName());
    }

    public String a() {
        return this.f767e;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1078a() {
        if (this.f763b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f765c != null) {
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
                    m1078a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f760a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f759a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f763b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f765c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f758a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f766d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f767e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 10) {
                        this.f762b = jfVar.mo1101a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 10) {
                        this.f764c = jfVar.mo1101a();
                        c(true);
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
        this.f761a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1079a() {
        return this.f760a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1080a(iq iqVar) {
        if (iqVar == null) {
            return false;
        }
        boolean m1079a = m1079a();
        boolean m1079a2 = iqVar.m1079a();
        if ((m1079a || m1079a2) && !(m1079a && m1079a2 && this.f760a.equals(iqVar.f760a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = iqVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f759a.m1000a(iqVar.f759a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = iqVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f763b.equals(iqVar.f763b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iqVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f765c.equals(iqVar.f765c))) || this.f758a != iqVar.f758a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = iqVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f766d.equals(iqVar.f766d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iqVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f767e.equals(iqVar.f767e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iqVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f762b == iqVar.f762b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iqVar.i();
        if (i2 || i3) {
            return i2 && i3 && this.f764c == iqVar.f764c;
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1078a();
        jfVar.a(f757a);
        if (this.f760a != null && m1079a()) {
            jfVar.a(a);
            jfVar.a(this.f760a);
            jfVar.b();
        }
        if (this.f759a != null && b()) {
            jfVar.a(b);
            this.f759a.b(jfVar);
            jfVar.b();
        }
        if (this.f763b != null) {
            jfVar.a(c);
            jfVar.a(this.f763b);
            jfVar.b();
        }
        if (this.f765c != null) {
            jfVar.a(d);
            jfVar.a(this.f765c);
            jfVar.b();
        }
        jfVar.a(e);
        jfVar.a(this.f758a);
        jfVar.b();
        if (this.f766d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f766d);
            jfVar.b();
        }
        if (this.f767e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f767e);
            jfVar.b();
        }
        if (h()) {
            jfVar.a(h);
            jfVar.a(this.f762b);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.a(this.f764c);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f761a.set(1, z);
    }

    public boolean b() {
        return this.f759a != null;
    }

    public void c(boolean z) {
        this.f761a.set(2, z);
    }

    public boolean c() {
        return this.f763b != null;
    }

    public boolean d() {
        return this.f765c != null;
    }

    public boolean e() {
        return this.f761a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof iq)) {
            return m1080a((iq) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f766d != null;
    }

    public boolean g() {
        return this.f767e != null;
    }

    public boolean h() {
        return this.f761a.get(1);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f761a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnRegistrationResult(");
        boolean z2 = false;
        if (m1079a()) {
            sb.append("debug:");
            String str = this.f760a;
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
            hy hyVar = this.f759a;
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
        String str2 = this.f763b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f765c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("errorCode:");
        sb.append(this.f758a);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f766d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f767e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("unRegisteredAt:");
            sb.append(this.f762b);
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("costTime:");
            sb.append(this.f764c);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
