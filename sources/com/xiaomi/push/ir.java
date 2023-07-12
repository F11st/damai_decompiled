package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ir implements iu<ir, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f769a;

    /* renamed from: a  reason: collision with other field name */
    public String f770a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f771a;

    /* renamed from: b  reason: collision with other field name */
    public String f772b;

    /* renamed from: c  reason: collision with other field name */
    public String f773c;

    /* renamed from: d  reason: collision with other field name */
    public String f774d;

    /* renamed from: e  reason: collision with other field name */
    public String f775e;

    /* renamed from: f  reason: collision with other field name */
    public String f776f;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f768a = new jk("XmPushActionUnSubscription");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 15, 8);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ir irVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(irVar.getClass())) {
            int compareTo = Boolean.valueOf(m1081a()).compareTo(Boolean.valueOf(irVar.m1081a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1081a() || (a9 = iv.a(this.f770a, irVar.f770a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(irVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = iv.a(this.f769a, irVar.f769a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(irVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = iv.a(this.f772b, irVar.f772b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(irVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = iv.a(this.f773c, irVar.f773c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(irVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = iv.a(this.f774d, irVar.f774d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(irVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = iv.a(this.f775e, irVar.f775e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(irVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = iv.a(this.f776f, irVar.f776f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(irVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = iv.a(this.f771a, irVar.f771a)) == 0) {
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
        return getClass().getName().compareTo(irVar.getClass().getName());
    }

    public ir a(String str) {
        this.f772b = str;
        return this;
    }

    public void a() {
        if (this.f772b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f773c == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f774d != null) {
        } else {
            throw new jg("Required field 'topic' was not present! Struct: " + toString());
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
                        this.f770a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f769a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f772b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f773c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f774d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f775e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f776f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jd mo1103a = jfVar.mo1103a();
                        this.f771a = new ArrayList(mo1103a.f802a);
                        for (int i = 0; i < mo1103a.f802a; i++) {
                            this.f771a.add(jfVar.mo1107a());
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

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1081a() {
        return this.f770a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1082a(ir irVar) {
        if (irVar == null) {
            return false;
        }
        boolean m1081a = m1081a();
        boolean m1081a2 = irVar.m1081a();
        if ((m1081a || m1081a2) && !(m1081a && m1081a2 && this.f770a.equals(irVar.f770a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = irVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f769a.m1000a(irVar.f769a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = irVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f772b.equals(irVar.f772b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = irVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f773c.equals(irVar.f773c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = irVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f774d.equals(irVar.f774d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = irVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f775e.equals(irVar.f775e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = irVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f776f.equals(irVar.f776f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = irVar.h();
        if (h2 || h3) {
            return h2 && h3 && this.f771a.equals(irVar.f771a);
        }
        return true;
    }

    public ir b(String str) {
        this.f773c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f768a);
        if (this.f770a != null && m1081a()) {
            jfVar.a(a);
            jfVar.a(this.f770a);
            jfVar.b();
        }
        if (this.f769a != null && b()) {
            jfVar.a(b);
            this.f769a.b(jfVar);
            jfVar.b();
        }
        if (this.f772b != null) {
            jfVar.a(c);
            jfVar.a(this.f772b);
            jfVar.b();
        }
        if (this.f773c != null) {
            jfVar.a(d);
            jfVar.a(this.f773c);
            jfVar.b();
        }
        if (this.f774d != null) {
            jfVar.a(e);
            jfVar.a(this.f774d);
            jfVar.b();
        }
        if (this.f775e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f775e);
            jfVar.b();
        }
        if (this.f776f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f776f);
            jfVar.b();
        }
        if (this.f771a != null && h()) {
            jfVar.a(h);
            jfVar.a(new jd((byte) 11, this.f771a.size()));
            for (String str : this.f771a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean b() {
        return this.f769a != null;
    }

    public ir c(String str) {
        this.f774d = str;
        return this;
    }

    public boolean c() {
        return this.f772b != null;
    }

    public ir d(String str) {
        this.f775e = str;
        return this;
    }

    public boolean d() {
        return this.f773c != null;
    }

    public ir e(String str) {
        this.f776f = str;
        return this;
    }

    public boolean e() {
        return this.f774d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ir)) {
            return m1082a((ir) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f775e != null;
    }

    public boolean g() {
        return this.f776f != null;
    }

    public boolean h() {
        return this.f771a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionUnSubscription(");
        boolean z2 = false;
        if (m1081a()) {
            sb.append("debug:");
            String str = this.f770a;
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
            hy hyVar = this.f769a;
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
        String str2 = this.f772b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f773c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("topic:");
        String str4 = this.f774d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f775e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str6 = this.f776f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliases:");
            List<String> list = this.f771a;
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
