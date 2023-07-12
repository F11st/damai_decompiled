package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ii implements iu<ii, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f631a;

    /* renamed from: a  reason: collision with other field name */
    public hy f632a;

    /* renamed from: a  reason: collision with other field name */
    public String f633a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f634a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f635a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f636a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f637a;

    /* renamed from: b  reason: collision with other field name */
    public String f638b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f639b;

    /* renamed from: c  reason: collision with other field name */
    public String f640c;

    /* renamed from: d  reason: collision with other field name */
    public String f641d;

    /* renamed from: e  reason: collision with other field name */
    public String f642e;

    /* renamed from: f  reason: collision with other field name */
    public String f643f;

    /* renamed from: g  reason: collision with other field name */
    public String f644g;

    /* renamed from: h  reason: collision with other field name */
    public String f645h;

    /* renamed from: i  reason: collision with other field name */
    public String f646i;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f630a = new jk("XmPushActionNotification");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 2, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 13, 8);
    private static final jc i = new jc("", (byte) 11, 9);
    private static final jc j = new jc("", (byte) 11, 10);
    private static final jc k = new jc("", (byte) 11, 12);
    private static final jc l = new jc("", (byte) 11, 13);
    private static final jc m = new jc("", (byte) 11, 14);
    private static final jc n = new jc("", (byte) 10, 15);
    private static final jc o = new jc("", (byte) 2, 20);

    public ii() {
        this.f635a = new BitSet(3);
        this.f637a = true;
        this.f639b = false;
    }

    public ii(String str, boolean z) {
        this();
        this.f638b = str;
        this.f637a = z;
        m1040a(true);
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ii iiVar) {
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
        if (getClass().equals(iiVar.getClass())) {
            int compareTo = Boolean.valueOf(m1041a()).compareTo(Boolean.valueOf(iiVar.m1041a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1041a() || (a16 = iv.a(this.f633a, iiVar.f633a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1044b()).compareTo(Boolean.valueOf(iiVar.m1044b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1044b() || (a15 = iv.a(this.f632a, iiVar.f632a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1045c()).compareTo(Boolean.valueOf(iiVar.m1045c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1045c() || (a14 = iv.a(this.f638b, iiVar.f638b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(iiVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a13 = iv.a(this.f640c, iiVar.f640c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(iiVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a12 = iv.a(this.f641d, iiVar.f641d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(iiVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a11 = iv.a(this.f637a, iiVar.f637a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(iiVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a10 = iv.a(this.f642e, iiVar.f642e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(iiVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a9 = iv.a(this.f636a, iiVar.f636a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(iiVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a8 = iv.a(this.f643f, iiVar.f643f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(iiVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a7 = iv.a(this.f644g, iiVar.f644g)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(iiVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a6 = iv.a(this.f645h, iiVar.f645h)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(l()).compareTo(Boolean.valueOf(iiVar.l()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!l() || (a5 = iv.a(this.f646i, iiVar.f646i)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(iiVar.m()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!m() || (a4 = iv.a(this.f634a, iiVar.f634a)) == 0) {
                                                                int compareTo14 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(iiVar.n()));
                                                                if (compareTo14 != 0) {
                                                                    return compareTo14;
                                                                }
                                                                if (!n() || (a3 = iv.a(this.f631a, iiVar.f631a)) == 0) {
                                                                    int compareTo15 = Boolean.valueOf(o()).compareTo(Boolean.valueOf(iiVar.o()));
                                                                    if (compareTo15 != 0) {
                                                                        return compareTo15;
                                                                    }
                                                                    if (!o() || (a2 = iv.a(this.f639b, iiVar.f639b)) == 0) {
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
        return getClass().getName().compareTo(iiVar.getClass().getName());
    }

    public hy a() {
        return this.f632a;
    }

    public ii a(String str) {
        this.f638b = str;
        return this;
    }

    public ii a(ByteBuffer byteBuffer) {
        this.f634a = byteBuffer;
        return this;
    }

    public ii a(Map<String, String> map) {
        this.f636a = map;
        return this;
    }

    public ii a(boolean z) {
        this.f637a = z;
        m1040a(true);
        return this;
    }

    public ii a(byte[] bArr) {
        a(ByteBuffer.wrap(bArr));
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1037a() {
        return this.f638b;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m1038a() {
        return this.f636a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1039a() {
        if (this.f638b != null) {
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
                if (f()) {
                    m1039a();
                    return;
                }
                throw new jg("Required field 'requireAck' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f633a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f632a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f638b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f640c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f641d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 2) {
                        this.f637a = jfVar.mo1112a();
                        m1040a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f642e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 13) {
                        je mo1104a = jfVar.mo1104a();
                        this.f636a = new HashMap(mo1104a.f803a * 2);
                        for (int i2 = 0; i2 < mo1104a.f803a; i2++) {
                            this.f636a.put(jfVar.mo1107a(), jfVar.mo1107a());
                        }
                        jfVar.h();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f643f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 11) {
                        this.f644g = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f645h = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 11) {
                        this.f646i = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 14:
                    if (b2 == 11) {
                        this.f634a = jfVar.mo1108a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 15:
                    if (b2 == 10) {
                        this.f631a = jfVar.mo1101a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 20:
                    if (b2 == 2) {
                        this.f639b = jfVar.mo1112a();
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

    public void a(String str, String str2) {
        if (this.f636a == null) {
            this.f636a = new HashMap();
        }
        this.f636a.put(str, str2);
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1040a(boolean z) {
        this.f635a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1041a() {
        return this.f633a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1042a(ii iiVar) {
        if (iiVar == null) {
            return false;
        }
        boolean m1041a = m1041a();
        boolean m1041a2 = iiVar.m1041a();
        if ((m1041a || m1041a2) && !(m1041a && m1041a2 && this.f633a.equals(iiVar.f633a))) {
            return false;
        }
        boolean m1044b = m1044b();
        boolean m1044b2 = iiVar.m1044b();
        if ((m1044b || m1044b2) && !(m1044b && m1044b2 && this.f632a.m1000a(iiVar.f632a))) {
            return false;
        }
        boolean m1045c = m1045c();
        boolean m1045c2 = iiVar.m1045c();
        if ((m1045c || m1045c2) && !(m1045c && m1045c2 && this.f638b.equals(iiVar.f638b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = iiVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f640c.equals(iiVar.f640c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = iiVar.e();
        if (((e2 || e3) && !(e2 && e3 && this.f641d.equals(iiVar.f641d))) || this.f637a != iiVar.f637a) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = iiVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f642e.equals(iiVar.f642e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = iiVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f636a.equals(iiVar.f636a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = iiVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f643f.equals(iiVar.f643f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = iiVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f644g.equals(iiVar.f644g))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = iiVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f645h.equals(iiVar.f645h))) {
            return false;
        }
        boolean l2 = l();
        boolean l3 = iiVar.l();
        if ((l2 || l3) && !(l2 && l3 && this.f646i.equals(iiVar.f646i))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = iiVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f634a.equals(iiVar.f634a))) {
            return false;
        }
        boolean n2 = n();
        boolean n3 = iiVar.n();
        if ((n2 || n3) && !(n2 && n3 && this.f631a == iiVar.f631a)) {
            return false;
        }
        boolean o2 = o();
        boolean o3 = iiVar.o();
        if (o2 || o3) {
            return o2 && o3 && this.f639b == iiVar.f639b;
        }
        return true;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1043a() {
        a(iv.a(this.f634a));
        return this.f634a.array();
    }

    public ii b(String str) {
        this.f640c = str;
        return this;
    }

    public String b() {
        return this.f640c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1039a();
        jfVar.a(f630a);
        if (this.f633a != null && m1041a()) {
            jfVar.a(a);
            jfVar.a(this.f633a);
            jfVar.b();
        }
        if (this.f632a != null && m1044b()) {
            jfVar.a(b);
            this.f632a.b(jfVar);
            jfVar.b();
        }
        if (this.f638b != null) {
            jfVar.a(c);
            jfVar.a(this.f638b);
            jfVar.b();
        }
        if (this.f640c != null && d()) {
            jfVar.a(d);
            jfVar.a(this.f640c);
            jfVar.b();
        }
        if (this.f641d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f641d);
            jfVar.b();
        }
        jfVar.a(f);
        jfVar.a(this.f637a);
        jfVar.b();
        if (this.f642e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f642e);
            jfVar.b();
        }
        if (this.f636a != null && h()) {
            jfVar.a(h);
            jfVar.a(new je((byte) 11, (byte) 11, this.f636a.size()));
            for (Map.Entry<String, String> entry : this.f636a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f643f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f643f);
            jfVar.b();
        }
        if (this.f644g != null && j()) {
            jfVar.a(j);
            jfVar.a(this.f644g);
            jfVar.b();
        }
        if (this.f645h != null && k()) {
            jfVar.a(k);
            jfVar.a(this.f645h);
            jfVar.b();
        }
        if (this.f646i != null && l()) {
            jfVar.a(l);
            jfVar.a(this.f646i);
            jfVar.b();
        }
        if (this.f634a != null && m()) {
            jfVar.a(m);
            jfVar.a(this.f634a);
            jfVar.b();
        }
        if (n()) {
            jfVar.a(n);
            jfVar.a(this.f631a);
            jfVar.b();
        }
        if (o()) {
            jfVar.a(o);
            jfVar.a(this.f639b);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f635a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1044b() {
        return this.f632a != null;
    }

    public ii c(String str) {
        this.f641d = str;
        return this;
    }

    public String c() {
        return this.f643f;
    }

    public void c(boolean z) {
        this.f635a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1045c() {
        return this.f638b != null;
    }

    public ii d(String str) {
        this.f643f = str;
        return this;
    }

    public boolean d() {
        return this.f640c != null;
    }

    public boolean e() {
        return this.f641d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ii)) {
            return m1042a((ii) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f635a.get(0);
    }

    public boolean g() {
        return this.f642e != null;
    }

    public boolean h() {
        return this.f636a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f643f != null;
    }

    public boolean j() {
        return this.f644g != null;
    }

    public boolean k() {
        return this.f645h != null;
    }

    public boolean l() {
        return this.f646i != null;
    }

    public boolean m() {
        return this.f634a != null;
    }

    public boolean n() {
        return this.f635a.get(1);
    }

    public boolean o() {
        return this.f635a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionNotification(");
        boolean z2 = false;
        if (m1041a()) {
            sb.append("debug:");
            String str = this.f633a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
            z = false;
        } else {
            z = true;
        }
        if (m1044b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("target:");
            hy hyVar = this.f632a;
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
        String str2 = this.f638b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        if (d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appId:");
            String str3 = this.f640c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("type:");
            String str4 = this.f641d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("requireAck:");
        sb.append(this.f637a);
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("payload:");
            String str5 = this.f642e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("extra:");
            Map<String, String> map = this.f636a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str6 = this.f643f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str7 = this.f644g;
            if (str7 == null) {
                sb.append("null");
            } else {
                sb.append(str7);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("regId:");
            String str8 = this.f645h;
            if (str8 == null) {
                sb.append("null");
            } else {
                sb.append(str8);
            }
        }
        if (l()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliasName:");
            String str9 = this.f646i;
            if (str9 == null) {
                sb.append("null");
            } else {
                sb.append(str9);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("binaryExtra:");
            ByteBuffer byteBuffer = this.f634a;
            if (byteBuffer == null) {
                sb.append("null");
            } else {
                iv.a(byteBuffer, sb);
            }
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createdTs:");
            sb.append(this.f631a);
        }
        if (o()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("alreadyLogClickInXmq:");
            sb.append(this.f639b);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
