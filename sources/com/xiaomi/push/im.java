package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class im implements iu<im, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hv f710a;

    /* renamed from: a  reason: collision with other field name */
    public hy f711a;

    /* renamed from: a  reason: collision with other field name */
    public String f712a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f714a;

    /* renamed from: b  reason: collision with other field name */
    public String f716b;

    /* renamed from: c  reason: collision with other field name */
    public String f717c;

    /* renamed from: d  reason: collision with other field name */
    public String f718d;

    /* renamed from: e  reason: collision with other field name */
    public String f719e;

    /* renamed from: f  reason: collision with other field name */
    public String f720f;

    /* renamed from: g  reason: collision with other field name */
    public String f721g;

    /* renamed from: h  reason: collision with other field name */
    public String f722h;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f709a = new jk("XmPushActionSendMessage");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 12, 8);
    private static final jc i = new jc("", (byte) 2, 9);
    private static final jc j = new jc("", (byte) 13, 10);
    private static final jc k = new jc("", (byte) 11, 11);
    private static final jc l = new jc("", (byte) 11, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f713a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public boolean f715a = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(im imVar) {
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
        if (getClass().equals(imVar.getClass())) {
            int compareTo = Boolean.valueOf(m1062a()).compareTo(Boolean.valueOf(imVar.m1062a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1062a() || (a13 = iv.a(this.f712a, imVar.f712a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1064b()).compareTo(Boolean.valueOf(imVar.m1064b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1064b() || (a12 = iv.a(this.f711a, imVar.f711a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1065c()).compareTo(Boolean.valueOf(imVar.m1065c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1065c() || (a11 = iv.a(this.f716b, imVar.f716b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m1066d()).compareTo(Boolean.valueOf(imVar.m1066d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m1066d() || (a10 = iv.a(this.f717c, imVar.f717c)) == 0) {
                            int compareTo5 = Boolean.valueOf(m1067e()).compareTo(Boolean.valueOf(imVar.m1067e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!m1067e() || (a9 = iv.a(this.f718d, imVar.f718d)) == 0) {
                                int compareTo6 = Boolean.valueOf(m1068f()).compareTo(Boolean.valueOf(imVar.m1068f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!m1068f() || (a8 = iv.a(this.f719e, imVar.f719e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(imVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a7 = iv.a(this.f720f, imVar.f720f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(imVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a6 = iv.a(this.f710a, imVar.f710a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(imVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a5 = iv.a(this.f715a, imVar.f715a)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(imVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a4 = iv.a(this.f714a, imVar.f714a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(imVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a3 = iv.a(this.f721g, imVar.f721g)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(imVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a2 = iv.a(this.f722h, imVar.f722h)) == 0) {
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
        return getClass().getName().compareTo(imVar.getClass().getName());
    }

    public hv a() {
        return this.f710a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1060a() {
        return this.f716b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1061a() {
        if (this.f716b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f717c != null) {
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
                m1061a();
                return;
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f712a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f711a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f716b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f717c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f718d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f719e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f720f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hv hvVar = new hv();
                        this.f710a = hvVar;
                        hvVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 2) {
                        this.f715a = jfVar.mo1112a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 13) {
                        je mo1104a = jfVar.mo1104a();
                        this.f714a = new HashMap(mo1104a.f803a * 2);
                        for (int i2 = 0; i2 < mo1104a.f803a; i2++) {
                            this.f714a.put(jfVar.mo1107a(), jfVar.mo1107a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 11) {
                        this.f721g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f722h = jfVar.mo1107a();
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
        this.f713a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1062a() {
        return this.f712a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1063a(im imVar) {
        if (imVar == null) {
            return false;
        }
        boolean m1062a = m1062a();
        boolean m1062a2 = imVar.m1062a();
        if ((m1062a || m1062a2) && !(m1062a && m1062a2 && this.f712a.equals(imVar.f712a))) {
            return false;
        }
        boolean m1064b = m1064b();
        boolean m1064b2 = imVar.m1064b();
        if ((m1064b || m1064b2) && !(m1064b && m1064b2 && this.f711a.m1000a(imVar.f711a))) {
            return false;
        }
        boolean m1065c = m1065c();
        boolean m1065c2 = imVar.m1065c();
        if ((m1065c || m1065c2) && !(m1065c && m1065c2 && this.f716b.equals(imVar.f716b))) {
            return false;
        }
        boolean m1066d = m1066d();
        boolean m1066d2 = imVar.m1066d();
        if ((m1066d || m1066d2) && !(m1066d && m1066d2 && this.f717c.equals(imVar.f717c))) {
            return false;
        }
        boolean m1067e = m1067e();
        boolean m1067e2 = imVar.m1067e();
        if ((m1067e || m1067e2) && !(m1067e && m1067e2 && this.f718d.equals(imVar.f718d))) {
            return false;
        }
        boolean m1068f = m1068f();
        boolean m1068f2 = imVar.m1068f();
        if ((m1068f || m1068f2) && !(m1068f && m1068f2 && this.f719e.equals(imVar.f719e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = imVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f720f.equals(imVar.f720f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = imVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f710a.m983a(imVar.f710a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = imVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f715a == imVar.f715a)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = imVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f714a.equals(imVar.f714a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = imVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f721g.equals(imVar.f721g))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = imVar.l();
        if (l2 || l3) {
            return l2 && l3 && this.f722h.equals(imVar.f722h);
        }
        return true;
    }

    public String b() {
        return this.f717c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1061a();
        jfVar.a(f709a);
        if (this.f712a != null && m1062a()) {
            jfVar.a(a);
            jfVar.a(this.f712a);
            jfVar.b();
        }
        if (this.f711a != null && m1064b()) {
            jfVar.a(b);
            this.f711a.b(jfVar);
            jfVar.b();
        }
        if (this.f716b != null) {
            jfVar.a(c);
            jfVar.a(this.f716b);
            jfVar.b();
        }
        if (this.f717c != null) {
            jfVar.a(d);
            jfVar.a(this.f717c);
            jfVar.b();
        }
        if (this.f718d != null && m1067e()) {
            jfVar.a(e);
            jfVar.a(this.f718d);
            jfVar.b();
        }
        if (this.f719e != null && m1068f()) {
            jfVar.a(f);
            jfVar.a(this.f719e);
            jfVar.b();
        }
        if (this.f720f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f720f);
            jfVar.b();
        }
        if (this.f710a != null && h()) {
            jfVar.a(h);
            this.f710a.b(jfVar);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.a(this.f715a);
            jfVar.b();
        }
        if (this.f714a != null && j()) {
            jfVar.a(j);
            jfVar.a(new je((byte) 11, (byte) 11, this.f714a.size()));
            for (Map.Entry<String, String> entry : this.f714a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f721g != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f721g);
            jfVar.b();
        }
        if (this.f722h != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f722h);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1064b() {
        return this.f711a != null;
    }

    public String c() {
        return this.f719e;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1065c() {
        return this.f716b != null;
    }

    public String d() {
        return this.f720f;
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m1066d() {
        return this.f717c != null;
    }

    public String e() {
        return this.f721g;
    }

    /* renamed from: e  reason: collision with other method in class */
    public boolean m1067e() {
        return this.f718d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof im)) {
            return m1063a((im) obj);
        }
        return false;
    }

    public String f() {
        return this.f722h;
    }

    /* renamed from: f  reason: collision with other method in class */
    public boolean m1068f() {
        return this.f719e != null;
    }

    public boolean g() {
        return this.f720f != null;
    }

    public boolean h() {
        return this.f710a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f713a.get(0);
    }

    public boolean j() {
        return this.f714a != null;
    }

    public boolean k() {
        return this.f721g != null;
    }

    public boolean l() {
        return this.f722h != null;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendMessage(");
        boolean z2 = false;
        if (m1062a()) {
            sb.append("debug:");
            String str = this.f712a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m1064b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f711a;
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
        String str2 = this.f716b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f717c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (m1067e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str4 = this.f718d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (m1068f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str5 = this.f719e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str6 = this.f720f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("message:");
            hv hvVar = this.f710a;
            if (hvVar == null) {
                sb.append("null");
            } else {
                sb.append(hvVar);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("needAck:");
            sb.append(this.f715a);
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("params:");
            Map<String, String> map = this.f714a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f721g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("userAccount:");
            String str8 = this.f722h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
