package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hy implements iu<hy, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f546a;

    /* renamed from: d  reason: collision with other field name */
    public String f551d;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f544a = new jk("Target");
    private static final jc a = new jc("", (byte) 10, 1);
    private static final jc b = new jc("", (byte) 11, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 2, 5);
    private static final jc f = new jc("", (byte) 11, 7);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f547a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public long f545a = 5;

    /* renamed from: b  reason: collision with other field name */
    public String f549b = "xiaomi.com";

    /* renamed from: c  reason: collision with other field name */
    public String f550c = "";

    /* renamed from: a  reason: collision with other field name */
    public boolean f548a = false;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hy hyVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        if (getClass().equals(hyVar.getClass())) {
            int compareTo = Boolean.valueOf(m999a()).compareTo(Boolean.valueOf(hyVar.m999a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m999a() || (a7 = iv.a(this.f545a, hyVar.f545a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hyVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a6 = iv.a(this.f546a, hyVar.f546a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hyVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a5 = iv.a(this.f549b, hyVar.f549b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(hyVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a4 = iv.a(this.f550c, hyVar.f550c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hyVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a3 = iv.a(this.f548a, hyVar.f548a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hyVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a2 = iv.a(this.f551d, hyVar.f551d)) == 0) {
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
        return getClass().getName().compareTo(hyVar.getClass().getName());
    }

    public void a() {
        if (this.f546a != null) {
            return;
        }
        throw new jg("Required field 'userId' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                break;
            }
            short s = mo1102a.f801a;
            if (s == 1) {
                if (b2 == 10) {
                    this.f545a = jfVar.mo1101a();
                    a(true);
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s == 2) {
                if (b2 == 11) {
                    this.f546a = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s == 3) {
                if (b2 == 11) {
                    this.f549b = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s == 4) {
                if (b2 == 11) {
                    this.f550c = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 5) {
                if (s == 7 && b2 == 11) {
                    this.f551d = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else {
                if (b2 == 2) {
                    this.f548a = jfVar.mo1112a();
                    b(true);
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
        jfVar.f();
        if (m999a()) {
            a();
            return;
        }
        throw new jg("Required field 'channelId' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f547a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m999a() {
        return this.f547a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1000a(hy hyVar) {
        if (hyVar != null && this.f545a == hyVar.f545a) {
            boolean b2 = b();
            boolean b3 = hyVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f546a.equals(hyVar.f546a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hyVar.c();
            if ((c2 || c3) && !(c2 && c3 && this.f549b.equals(hyVar.f549b))) {
                return false;
            }
            boolean d2 = d();
            boolean d3 = hyVar.d();
            if ((d2 || d3) && !(d2 && d3 && this.f550c.equals(hyVar.f550c))) {
                return false;
            }
            boolean e2 = e();
            boolean e3 = hyVar.e();
            if ((e2 || e3) && !(e2 && e3 && this.f548a == hyVar.f548a)) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = hyVar.f();
            if (f2 || f3) {
                return f2 && f3 && this.f551d.equals(hyVar.f551d);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f544a);
        jfVar.a(a);
        jfVar.a(this.f545a);
        jfVar.b();
        if (this.f546a != null) {
            jfVar.a(b);
            jfVar.a(this.f546a);
            jfVar.b();
        }
        if (this.f549b != null && c()) {
            jfVar.a(c);
            jfVar.a(this.f549b);
            jfVar.b();
        }
        if (this.f550c != null && d()) {
            jfVar.a(d);
            jfVar.a(this.f550c);
            jfVar.b();
        }
        if (e()) {
            jfVar.a(e);
            jfVar.a(this.f548a);
            jfVar.b();
        }
        if (this.f551d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f551d);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f547a.set(1, z);
    }

    public boolean b() {
        return this.f546a != null;
    }

    public boolean c() {
        return this.f549b != null;
    }

    public boolean d() {
        return this.f550c != null;
    }

    public boolean e() {
        return this.f547a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hy)) {
            return m1000a((hy) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f551d != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Target(");
        sb.append("channelId:");
        sb.append(this.f545a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("userId:");
        String str = this.f546a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (c()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("server:");
            String str2 = this.f549b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("resource:");
            String str3 = this.f550c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("isPreview:");
            sb.append(this.f548a);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("token:");
            String str4 = this.f551d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
