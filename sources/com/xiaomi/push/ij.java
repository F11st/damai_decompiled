package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ij implements iu<ij, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f648a;

    /* renamed from: a  reason: collision with other field name */
    public long f649a;

    /* renamed from: a  reason: collision with other field name */
    public hx f650a;

    /* renamed from: a  reason: collision with other field name */
    public hy f651a;

    /* renamed from: a  reason: collision with other field name */
    public String f652a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f654a;

    /* renamed from: b  reason: collision with other field name */
    public int f656b;

    /* renamed from: b  reason: collision with other field name */
    public long f657b;

    /* renamed from: b  reason: collision with other field name */
    public String f658b;

    /* renamed from: c  reason: collision with other field name */
    public int f660c;

    /* renamed from: c  reason: collision with other field name */
    public String f661c;

    /* renamed from: d  reason: collision with other field name */
    public String f663d;

    /* renamed from: e  reason: collision with other field name */
    public String f664e;

    /* renamed from: f  reason: collision with other field name */
    public String f665f;

    /* renamed from: g  reason: collision with other field name */
    public String f666g;

    /* renamed from: h  reason: collision with other field name */
    public String f667h;

    /* renamed from: i  reason: collision with other field name */
    public String f668i;

    /* renamed from: j  reason: collision with other field name */
    public String f669j;

    /* renamed from: k  reason: collision with other field name */
    public String f670k;

    /* renamed from: l  reason: collision with other field name */
    public String f671l;

    /* renamed from: m  reason: collision with other field name */
    public String f672m;

    /* renamed from: n  reason: collision with other field name */
    public String f673n;

    /* renamed from: o  reason: collision with other field name */
    public String f674o;

    /* renamed from: p  reason: collision with other field name */
    public String f675p;

    /* renamed from: q  reason: collision with other field name */
    public String f676q;

    /* renamed from: r  reason: collision with other field name */
    public String f677r;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f647a = new jk("XmPushActionRegistration");
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
    private static final jc k = new jc("", (byte) 11, 11);
    private static final jc l = new jc("", (byte) 11, 12);
    private static final jc m = new jc("", (byte) 8, 13);
    private static final jc n = new jc("", (byte) 8, 14);
    private static final jc o = new jc("", (byte) 11, 15);
    private static final jc p = new jc("", (byte) 11, 16);
    private static final jc q = new jc("", (byte) 11, 17);
    private static final jc r = new jc("", (byte) 11, 18);
    private static final jc s = new jc("", (byte) 8, 19);
    private static final jc t = new jc("", (byte) 8, 20);
    private static final jc u = new jc("", (byte) 2, 21);
    private static final jc v = new jc("", (byte) 10, 22);
    private static final jc w = new jc("", (byte) 10, 23);
    private static final jc x = new jc("", (byte) 11, 24);
    private static final jc y = new jc("", (byte) 11, 25);
    private static final jc z = new jc("", (byte) 2, 26);
    private static final jc A = new jc("", (byte) 13, 100);
    private static final jc B = new jc("", (byte) 2, 101);
    private static final jc C = new jc("", (byte) 11, 102);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f653a = new BitSet(8);

    /* renamed from: a  reason: collision with other field name */
    public boolean f655a = true;

    /* renamed from: c  reason: collision with other field name */
    public boolean f662c = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f659b = false;

    public boolean A() {
        return this.f654a != null;
    }

    public boolean B() {
        return this.f653a.get(7);
    }

    public boolean C() {
        return this.f677r != null;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ij ijVar) {
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
        int a22;
        int a23;
        int a24;
        int a25;
        int a26;
        int a27;
        int a28;
        int a29;
        int a30;
        if (getClass().equals(ijVar.getClass())) {
            int compareTo = Boolean.valueOf(m1047a()).compareTo(Boolean.valueOf(ijVar.m1047a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1047a() || (a30 = iv.a(this.f652a, ijVar.f652a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1049b()).compareTo(Boolean.valueOf(ijVar.m1049b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1049b() || (a29 = iv.a(this.f651a, ijVar.f651a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1050c()).compareTo(Boolean.valueOf(ijVar.m1050c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1050c() || (a28 = iv.a(this.f658b, ijVar.f658b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ijVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a27 = iv.a(this.f661c, ijVar.f661c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ijVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a26 = iv.a(this.f663d, ijVar.f663d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ijVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a25 = iv.a(this.f664e, ijVar.f664e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ijVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a24 = iv.a(this.f665f, ijVar.f665f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ijVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a23 = iv.a(this.f666g, ijVar.f666g)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ijVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a22 = iv.a(this.f667h, ijVar.f667h)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ijVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a21 = iv.a(this.f668i, ijVar.f668i)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(ijVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a20 = iv.a(this.f669j, ijVar.f669j)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(ijVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a19 = iv.a(this.f670k, ijVar.f670k)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(ijVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a18 = iv.a(this.f648a, ijVar.f648a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(ijVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a17 = iv.a(this.f656b, ijVar.f656b)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(ijVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a16 = iv.a(this.f671l, ijVar.f671l)) == 0) {
                                                                        int compareTo16 = Boolean.valueOf(p()).compareTo(Boolean.valueOf(ijVar.p()));
                                                                        if (compareTo16 != 0) {
                                                                            return compareTo16;
                                                                        }
                                                                        if (!p() || (a15 = iv.a(this.f672m, ijVar.f672m)) == 0) {
                                                                            int compareTo17 = Boolean.valueOf(q()).compareTo(Boolean.valueOf(ijVar.q()));
                                                                            if (compareTo17 != 0) {
                                                                                return compareTo17;
                                                                            }
                                                                            if (!q() || (a14 = iv.a(this.f673n, ijVar.f673n)) == 0) {
                                                                                int compareTo18 = Boolean.valueOf(r()).compareTo(Boolean.valueOf(ijVar.r()));
                                                                                if (compareTo18 != 0) {
                                                                                    return compareTo18;
                                                                                }
                                                                                if (!r() || (a13 = iv.a(this.f674o, ijVar.f674o)) == 0) {
                                                                                    int compareTo19 = Boolean.valueOf(s()).compareTo(Boolean.valueOf(ijVar.s()));
                                                                                    if (compareTo19 != 0) {
                                                                                        return compareTo19;
                                                                                    }
                                                                                    if (!s() || (a12 = iv.a(this.f660c, ijVar.f660c)) == 0) {
                                                                                        int compareTo20 = Boolean.valueOf(t()).compareTo(Boolean.valueOf(ijVar.t()));
                                                                                        if (compareTo20 != 0) {
                                                                                            return compareTo20;
                                                                                        }
                                                                                        if (!t() || (a11 = iv.a(this.f650a, ijVar.f650a)) == 0) {
                                                                                            int compareTo21 = Boolean.valueOf(u()).compareTo(Boolean.valueOf(ijVar.u()));
                                                                                            if (compareTo21 != 0) {
                                                                                                return compareTo21;
                                                                                            }
                                                                                            if (!u() || (a10 = iv.a(this.f655a, ijVar.f655a)) == 0) {
                                                                                                int compareTo22 = Boolean.valueOf(v()).compareTo(Boolean.valueOf(ijVar.v()));
                                                                                                if (compareTo22 != 0) {
                                                                                                    return compareTo22;
                                                                                                }
                                                                                                if (!v() || (a9 = iv.a(this.f649a, ijVar.f649a)) == 0) {
                                                                                                    int compareTo23 = Boolean.valueOf(w()).compareTo(Boolean.valueOf(ijVar.w()));
                                                                                                    if (compareTo23 != 0) {
                                                                                                        return compareTo23;
                                                                                                    }
                                                                                                    if (!w() || (a8 = iv.a(this.f657b, ijVar.f657b)) == 0) {
                                                                                                        int compareTo24 = Boolean.valueOf(x()).compareTo(Boolean.valueOf(ijVar.x()));
                                                                                                        if (compareTo24 != 0) {
                                                                                                            return compareTo24;
                                                                                                        }
                                                                                                        if (!x() || (a7 = iv.a(this.f675p, ijVar.f675p)) == 0) {
                                                                                                            int compareTo25 = Boolean.valueOf(y()).compareTo(Boolean.valueOf(ijVar.y()));
                                                                                                            if (compareTo25 != 0) {
                                                                                                                return compareTo25;
                                                                                                            }
                                                                                                            if (!y() || (a6 = iv.a(this.f676q, ijVar.f676q)) == 0) {
                                                                                                                int compareTo26 = Boolean.valueOf(z()).compareTo(Boolean.valueOf(ijVar.z()));
                                                                                                                if (compareTo26 != 0) {
                                                                                                                    return compareTo26;
                                                                                                                }
                                                                                                                if (!z() || (a5 = iv.a(this.f659b, ijVar.f659b)) == 0) {
                                                                                                                    int compareTo27 = Boolean.valueOf(A()).compareTo(Boolean.valueOf(ijVar.A()));
                                                                                                                    if (compareTo27 != 0) {
                                                                                                                        return compareTo27;
                                                                                                                    }
                                                                                                                    if (!A() || (a4 = iv.a(this.f654a, ijVar.f654a)) == 0) {
                                                                                                                        int compareTo28 = Boolean.valueOf(B()).compareTo(Boolean.valueOf(ijVar.B()));
                                                                                                                        if (compareTo28 != 0) {
                                                                                                                            return compareTo28;
                                                                                                                        }
                                                                                                                        if (!B() || (a3 = iv.a(this.f662c, ijVar.f662c)) == 0) {
                                                                                                                            int compareTo29 = Boolean.valueOf(C()).compareTo(Boolean.valueOf(ijVar.C()));
                                                                                                                            if (compareTo29 != 0) {
                                                                                                                                return compareTo29;
                                                                                                                            }
                                                                                                                            if (!C() || (a2 = iv.a(this.f677r, ijVar.f677r)) == 0) {
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
                                            return a22;
                                        }
                                        return a23;
                                    }
                                    return a24;
                                }
                                return a25;
                            }
                            return a26;
                        }
                        return a27;
                    }
                    return a28;
                }
                return a29;
            }
            return a30;
        }
        return getClass().getName().compareTo(ijVar.getClass().getName());
    }

    public ij a(int i2) {
        this.f648a = i2;
        a(true);
        return this;
    }

    public ij a(hx hxVar) {
        this.f650a = hxVar;
        return this;
    }

    public ij a(String str) {
        this.f658b = str;
        return this;
    }

    public String a() {
        return this.f658b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1046a() {
        if (this.f658b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f661c == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f665f != null) {
        } else {
            throw new jg("Required field 'token' was not present! Struct: " + toString());
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
                m1046a();
                return;
            }
            short s2 = mo1102a.f801a;
            switch (s2) {
                case 1:
                    if (b2 == 11) {
                        this.f652a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f651a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f658b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f661c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f663d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f664e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f665f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f666g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f667h = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f668i = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f669j = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f670k = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 8) {
                        this.f648a = jfVar.mo1100a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 8) {
                        this.f656b = jfVar.mo1100a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 11) {
                        this.f671l = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 16:
                    if (b2 == 11) {
                        this.f672m = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 17:
                    if (b2 == 11) {
                        this.f673n = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 18:
                    if (b2 == 11) {
                        this.f674o = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 19:
                    if (b2 == 8) {
                        this.f660c = jfVar.mo1100a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 8) {
                        this.f650a = hx.a(jfVar.mo1100a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 21:
                    if (b2 == 2) {
                        this.f655a = jfVar.mo1112a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 22:
                    if (b2 == 10) {
                        this.f649a = jfVar.mo1101a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 23:
                    if (b2 == 10) {
                        this.f657b = jfVar.mo1101a();
                        f(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 24:
                    if (b2 == 11) {
                        this.f675p = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 25:
                    if (b2 == 11) {
                        this.f676q = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 26:
                    if (b2 == 2) {
                        this.f659b = jfVar.mo1112a();
                        g(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                default:
                    switch (s2) {
                        case 100:
                            if (b2 == 13) {
                                je mo1104a = jfVar.mo1104a();
                                this.f654a = new HashMap(mo1104a.f803a * 2);
                                for (int i2 = 0; i2 < mo1104a.f803a; i2++) {
                                    this.f654a.put(jfVar.mo1107a(), jfVar.mo1107a());
                                }
                                jfVar.h();
                                break;
                            }
                            break;
                        case 101:
                            if (b2 == 2) {
                                this.f662c = jfVar.mo1112a();
                                h(true);
                                break;
                            }
                            break;
                        case 102:
                            if (b2 == 11) {
                                this.f677r = jfVar.mo1107a();
                                continue;
                            }
                            break;
                    }
                    jfVar.g();
                    break;
            }
            ji.a(jfVar, b2);
            jfVar.g();
        }
    }

    public void a(boolean z2) {
        this.f653a.set(0, z2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1047a() {
        return this.f652a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1048a(ij ijVar) {
        if (ijVar == null) {
            return false;
        }
        boolean m1047a = m1047a();
        boolean m1047a2 = ijVar.m1047a();
        if ((m1047a || m1047a2) && !(m1047a && m1047a2 && this.f652a.equals(ijVar.f652a))) {
            return false;
        }
        boolean m1049b = m1049b();
        boolean m1049b2 = ijVar.m1049b();
        if ((m1049b || m1049b2) && !(m1049b && m1049b2 && this.f651a.m1000a(ijVar.f651a))) {
            return false;
        }
        boolean m1050c = m1050c();
        boolean m1050c2 = ijVar.m1050c();
        if ((m1050c || m1050c2) && !(m1050c && m1050c2 && this.f658b.equals(ijVar.f658b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ijVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f661c.equals(ijVar.f661c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = ijVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f663d.equals(ijVar.f663d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ijVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f664e.equals(ijVar.f664e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ijVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f665f.equals(ijVar.f665f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ijVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f666g.equals(ijVar.f666g))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ijVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f667h.equals(ijVar.f667h))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ijVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f668i.equals(ijVar.f668i))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = ijVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f669j.equals(ijVar.f669j))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = ijVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f670k.equals(ijVar.f670k))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = ijVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f648a == ijVar.f648a)) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = ijVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f656b == ijVar.f656b)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = ijVar.o();
        if ((o2 || o3) && !(o2 && o3 && this.f671l.equals(ijVar.f671l))) {
            return false;
        }
        boolean p2 = p();
        boolean p3 = ijVar.p();
        if ((p2 || p3) && !(p2 && p3 && this.f672m.equals(ijVar.f672m))) {
            return false;
        }
        boolean q2 = q();
        boolean q3 = ijVar.q();
        if ((q2 || q3) && !(q2 && q3 && this.f673n.equals(ijVar.f673n))) {
            return false;
        }
        boolean r2 = r();
        boolean r3 = ijVar.r();
        if ((r2 || r3) && !(r2 && r3 && this.f674o.equals(ijVar.f674o))) {
            return false;
        }
        boolean s2 = s();
        boolean s3 = ijVar.s();
        if ((s2 || s3) && !(s2 && s3 && this.f660c == ijVar.f660c)) {
            return false;
        }
        boolean t2 = t();
        boolean t3 = ijVar.t();
        if ((t2 || t3) && !(t2 && t3 && this.f650a.equals(ijVar.f650a))) {
            return false;
        }
        boolean u2 = u();
        boolean u3 = ijVar.u();
        if ((u2 || u3) && !(u2 && u3 && this.f655a == ijVar.f655a)) {
            return false;
        }
        boolean v2 = v();
        boolean v3 = ijVar.v();
        if ((v2 || v3) && !(v2 && v3 && this.f649a == ijVar.f649a)) {
            return false;
        }
        boolean w2 = w();
        boolean w3 = ijVar.w();
        if ((w2 || w3) && !(w2 && w3 && this.f657b == ijVar.f657b)) {
            return false;
        }
        boolean x2 = x();
        boolean x3 = ijVar.x();
        if ((x2 || x3) && !(x2 && x3 && this.f675p.equals(ijVar.f675p))) {
            return false;
        }
        boolean y2 = y();
        boolean y3 = ijVar.y();
        if ((y2 || y3) && !(y2 && y3 && this.f676q.equals(ijVar.f676q))) {
            return false;
        }
        boolean z2 = z();
        boolean z3 = ijVar.z();
        if ((z2 || z3) && !(z2 && z3 && this.f659b == ijVar.f659b)) {
            return false;
        }
        boolean A2 = A();
        boolean A3 = ijVar.A();
        if ((A2 || A3) && !(A2 && A3 && this.f654a.equals(ijVar.f654a))) {
            return false;
        }
        boolean B2 = B();
        boolean B3 = ijVar.B();
        if ((B2 || B3) && !(B2 && B3 && this.f662c == ijVar.f662c)) {
            return false;
        }
        boolean C2 = C();
        boolean C3 = ijVar.C();
        if (C2 || C3) {
            return C2 && C3 && this.f677r.equals(ijVar.f677r);
        }
        return true;
    }

    public ij b(int i2) {
        this.f656b = i2;
        b(true);
        return this;
    }

    public ij b(String str) {
        this.f661c = str;
        return this;
    }

    public String b() {
        return this.f661c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1046a();
        jfVar.a(f647a);
        if (this.f652a != null && m1047a()) {
            jfVar.a(a);
            jfVar.a(this.f652a);
            jfVar.b();
        }
        if (this.f651a != null && m1049b()) {
            jfVar.a(b);
            this.f651a.b(jfVar);
            jfVar.b();
        }
        if (this.f658b != null) {
            jfVar.a(c);
            jfVar.a(this.f658b);
            jfVar.b();
        }
        if (this.f661c != null) {
            jfVar.a(d);
            jfVar.a(this.f661c);
            jfVar.b();
        }
        if (this.f663d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f663d);
            jfVar.b();
        }
        if (this.f664e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f664e);
            jfVar.b();
        }
        if (this.f665f != null) {
            jfVar.a(g);
            jfVar.a(this.f665f);
            jfVar.b();
        }
        if (this.f666g != null && h()) {
            jfVar.a(h);
            jfVar.a(this.f666g);
            jfVar.b();
        }
        if (this.f667h != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f667h);
            jfVar.b();
        }
        if (this.f668i != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f668i);
            jfVar.b();
        }
        if (this.f669j != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f669j);
            jfVar.b();
        }
        if (this.f670k != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f670k);
            jfVar.b();
        }
        if (m()) {
            jfVar.a(m);
            jfVar.mo1111a(this.f648a);
            jfVar.b();
        }
        if (n()) {
            jfVar.a(n);
            jfVar.mo1111a(this.f656b);
            jfVar.b();
        }
        if (this.f671l != null && o()) {
            jfVar.a(o);
            jfVar.a(this.f671l);
            jfVar.b();
        }
        if (this.f672m != null && p()) {
            jfVar.a(p);
            jfVar.a(this.f672m);
            jfVar.b();
        }
        if (this.f673n != null && q()) {
            jfVar.a(q);
            jfVar.a(this.f673n);
            jfVar.b();
        }
        if (this.f674o != null && r()) {
            jfVar.a(r);
            jfVar.a(this.f674o);
            jfVar.b();
        }
        if (s()) {
            jfVar.a(s);
            jfVar.mo1111a(this.f660c);
            jfVar.b();
        }
        if (this.f650a != null && t()) {
            jfVar.a(t);
            jfVar.mo1111a(this.f650a.a());
            jfVar.b();
        }
        if (u()) {
            jfVar.a(u);
            jfVar.a(this.f655a);
            jfVar.b();
        }
        if (v()) {
            jfVar.a(v);
            jfVar.a(this.f649a);
            jfVar.b();
        }
        if (w()) {
            jfVar.a(w);
            jfVar.a(this.f657b);
            jfVar.b();
        }
        if (this.f675p != null && x()) {
            jfVar.a(x);
            jfVar.a(this.f675p);
            jfVar.b();
        }
        if (this.f676q != null && y()) {
            jfVar.a(y);
            jfVar.a(this.f676q);
            jfVar.b();
        }
        if (z()) {
            jfVar.a(z);
            jfVar.a(this.f659b);
            jfVar.b();
        }
        if (this.f654a != null && A()) {
            jfVar.a(A);
            jfVar.a(new je((byte) 11, (byte) 11, this.f654a.size()));
            for (Map.Entry<String, String> entry : this.f654a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (B()) {
            jfVar.a(B);
            jfVar.a(this.f662c);
            jfVar.b();
        }
        if (this.f677r != null && C()) {
            jfVar.a(C);
            jfVar.a(this.f677r);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z2) {
        this.f653a.set(1, z2);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1049b() {
        return this.f651a != null;
    }

    public ij c(int i2) {
        this.f660c = i2;
        c(true);
        return this;
    }

    public ij c(String str) {
        this.f663d = str;
        return this;
    }

    public String c() {
        return this.f665f;
    }

    public void c(boolean z2) {
        this.f653a.set(2, z2);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1050c() {
        return this.f658b != null;
    }

    public ij d(String str) {
        this.f664e = str;
        return this;
    }

    public void d(boolean z2) {
        this.f653a.set(3, z2);
    }

    public boolean d() {
        return this.f661c != null;
    }

    public ij e(String str) {
        this.f665f = str;
        return this;
    }

    public void e(boolean z2) {
        this.f653a.set(4, z2);
    }

    public boolean e() {
        return this.f663d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ij)) {
            return m1048a((ij) obj);
        }
        return false;
    }

    public ij f(String str) {
        this.f666g = str;
        return this;
    }

    public void f(boolean z2) {
        this.f653a.set(5, z2);
    }

    public boolean f() {
        return this.f664e != null;
    }

    public ij g(String str) {
        this.f667h = str;
        return this;
    }

    public void g(boolean z2) {
        this.f653a.set(6, z2);
    }

    public boolean g() {
        return this.f665f != null;
    }

    public ij h(String str) {
        this.f670k = str;
        return this;
    }

    public void h(boolean z2) {
        this.f653a.set(7, z2);
    }

    public boolean h() {
        return this.f666g != null;
    }

    public int hashCode() {
        return 0;
    }

    public ij i(String str) {
        this.f674o = str;
        return this;
    }

    public boolean i() {
        return this.f667h != null;
    }

    public boolean j() {
        return this.f668i != null;
    }

    public boolean k() {
        return this.f669j != null;
    }

    public boolean l() {
        return this.f670k != null;
    }

    public boolean m() {
        return this.f653a.get(0);
    }

    public boolean n() {
        return this.f653a.get(1);
    }

    public boolean o() {
        return this.f671l != null;
    }

    public boolean p() {
        return this.f672m != null;
    }

    public boolean q() {
        return this.f673n != null;
    }

    public boolean r() {
        return this.f674o != null;
    }

    public boolean s() {
        return this.f653a.get(2);
    }

    public boolean t() {
        return this.f650a != null;
    }

    public String toString() {
        boolean z2;
        StringBuilder sb = new StringBuilder("XmPushActionRegistration(");
        boolean z3 = false;
        if (m1047a()) {
            sb.append("debug:");
            String str = this.f652a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z2 = false;
        } else {
            z2 = true;
        }
        if (m1049b()) {
            if (!z2) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f651a;
            if (hyVar == null) {
                sb.append("null");
            } else {
                sb.append(hyVar);
            }
        } else {
            z3 = z2;
        }
        if (!z3) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append("id:");
        String str2 = this.f658b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str2));
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f661c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersion:");
            String str4 = this.f663d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f664e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("token:");
        String str6 = this.f665f;
        if (str6 == null) {
            sb.append("null");
        } else {
            sb.append(str6);
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("deviceId:");
            String str7 = this.f666g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str8 = this.f667h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("sdkVersion:");
            String str9 = this.f668i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str10 = this.f669j;
            if (str10 == null) {
                sb.append("null");
            } else {
                sb.append(str10);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("pushSdkVersionName:");
            String str11 = this.f670k;
            if (str11 == null) {
                sb.append("null");
            } else {
                sb.append(str11);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("pushSdkVersionCode:");
            sb.append(this.f648a);
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appVersionCode:");
            sb.append(this.f656b);
        }
        if (o()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("androidId:");
            String str12 = this.f671l;
            if (str12 == null) {
                sb.append("null");
            } else {
                sb.append(str12);
            }
        }
        if (p()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("imei:");
            String str13 = this.f672m;
            if (str13 == null) {
                sb.append("null");
            } else {
                sb.append(str13);
            }
        }
        if (q()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("serial:");
            String str14 = this.f673n;
            if (str14 == null) {
                sb.append("null");
            } else {
                sb.append(str14);
            }
        }
        if (r()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("imeiMd5:");
            String str15 = this.f674o;
            if (str15 == null) {
                sb.append("null");
            } else {
                sb.append(str15);
            }
        }
        if (s()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("spaceId:");
            sb.append(this.f660c);
        }
        if (t()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            hx hxVar = this.f650a;
            if (hxVar == null) {
                sb.append("null");
            } else {
                sb.append(hxVar);
            }
        }
        if (u()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("validateToken:");
            sb.append(this.f655a);
        }
        if (v()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("miid:");
            sb.append(this.f649a);
        }
        if (w()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createdTs:");
            sb.append(this.f657b);
        }
        if (x()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("subImei:");
            String str16 = this.f675p;
            if (str16 == null) {
                sb.append("null");
            } else {
                sb.append(str16);
            }
        }
        if (y()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("subImeiMd5:");
            String str17 = this.f676q;
            if (str17 == null) {
                sb.append("null");
            } else {
                sb.append(str17);
            }
        }
        if (z()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("isHybridFrame:");
            sb.append(this.f659b);
        }
        if (A()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("connectionAttrs:");
            Map<String, String> map = this.f654a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (B()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("cleanOldRegInfo:");
            sb.append(this.f662c);
        }
        if (C()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("oldRegId:");
            String str18 = this.f677r;
            if (str18 == null) {
                sb.append("null");
            } else {
                sb.append(str18);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }

    public boolean u() {
        return this.f653a.get(3);
    }

    public boolean v() {
        return this.f653a.get(4);
    }

    public boolean w() {
        return this.f653a.get(5);
    }

    public boolean x() {
        return this.f675p != null;
    }

    public boolean y() {
        return this.f676q != null;
    }

    public boolean z() {
        return this.f653a.get(6);
    }
}
