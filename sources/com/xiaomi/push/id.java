package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class id implements iu<id, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f593a;

    /* renamed from: a  reason: collision with other field name */
    public hy f594a;

    /* renamed from: a  reason: collision with other field name */
    public String f595a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f597a;

    /* renamed from: b  reason: collision with other field name */
    public String f599b;

    /* renamed from: c  reason: collision with other field name */
    public String f601c;

    /* renamed from: d  reason: collision with other field name */
    public String f602d;

    /* renamed from: e  reason: collision with other field name */
    public String f603e;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f592a = new jk("XmPushActionCommand");
    private static final jc a = new jc("", (byte) 12, 2);
    private static final jc b = new jc("", (byte) 11, 3);
    private static final jc c = new jc("", (byte) 11, 4);
    private static final jc d = new jc("", (byte) 11, 5);
    private static final jc e = new jc("", (byte) 15, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 9);
    private static final jc h = new jc("", (byte) 2, 10);
    private static final jc i = new jc("", (byte) 2, 11);
    private static final jc j = new jc("", (byte) 10, 12);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f596a = new BitSet(3);

    /* renamed from: a  reason: collision with other field name */
    public boolean f598a = false;

    /* renamed from: b  reason: collision with other field name */
    public boolean f600b = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(id idVar) {
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
        if (getClass().equals(idVar.getClass())) {
            int compareTo = Boolean.valueOf(m1014a()).compareTo(Boolean.valueOf(idVar.m1014a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1014a() || (a11 = iv.a(this.f594a, idVar.f594a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(idVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a10 = iv.a(this.f595a, idVar.f595a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(idVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a9 = iv.a(this.f599b, idVar.f599b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(idVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = iv.a(this.f601c, idVar.f601c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(idVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = iv.a(this.f597a, idVar.f597a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(idVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = iv.a(this.f602d, idVar.f602d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(idVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = iv.a(this.f603e, idVar.f603e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(idVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = iv.a(this.f598a, idVar.f598a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(idVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = iv.a(this.f600b, idVar.f600b)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(idVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = iv.a(this.f593a, idVar.f593a)) == 0) {
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
        return getClass().getName().compareTo(idVar.getClass().getName());
    }

    public id a(String str) {
        this.f595a = str;
        return this;
    }

    public String a() {
        return this.f601c;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1012a() {
        if (this.f595a == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f599b == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f601c != null) {
        } else {
            throw new jg("Required field 'cmdName' was not present! Struct: " + toString());
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
                m1012a();
                return;
            }
            switch (mo1102a.f801a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f594a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f595a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f599b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f601c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 15) {
                        jd mo1103a = jfVar.mo1103a();
                        this.f597a = new ArrayList(mo1103a.f802a);
                        for (int i2 = 0; i2 < mo1103a.f802a; i2++) {
                            this.f597a.add(jfVar.mo1107a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f602d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f603e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 2) {
                        this.f598a = jfVar.mo1112a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 11:
                    if (b2 == 2) {
                        this.f600b = jfVar.mo1112a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 10) {
                        this.f593a = jfVar.mo1101a();
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

    /* renamed from: a  reason: collision with other method in class */
    public void m1013a(String str) {
        if (this.f597a == null) {
            this.f597a = new ArrayList();
        }
        this.f597a.add(str);
    }

    public void a(boolean z) {
        this.f596a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1014a() {
        return this.f594a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1015a(id idVar) {
        if (idVar == null) {
            return false;
        }
        boolean m1014a = m1014a();
        boolean m1014a2 = idVar.m1014a();
        if ((m1014a || m1014a2) && !(m1014a && m1014a2 && this.f594a.m1000a(idVar.f594a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = idVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f595a.equals(idVar.f595a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = idVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f599b.equals(idVar.f599b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = idVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f601c.equals(idVar.f601c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = idVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f597a.equals(idVar.f597a))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = idVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f602d.equals(idVar.f602d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = idVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f603e.equals(idVar.f603e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = idVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f598a == idVar.f598a)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = idVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f600b == idVar.f600b)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = idVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f593a == idVar.f593a;
        }
        return true;
    }

    public id b(String str) {
        this.f599b = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1012a();
        jfVar.a(f592a);
        if (this.f594a != null && m1014a()) {
            jfVar.a(a);
            this.f594a.b(jfVar);
            jfVar.b();
        }
        if (this.f595a != null) {
            jfVar.a(b);
            jfVar.a(this.f595a);
            jfVar.b();
        }
        if (this.f599b != null) {
            jfVar.a(c);
            jfVar.a(this.f599b);
            jfVar.b();
        }
        if (this.f601c != null) {
            jfVar.a(d);
            jfVar.a(this.f601c);
            jfVar.b();
        }
        if (this.f597a != null && e()) {
            jfVar.a(e);
            jfVar.a(new jd((byte) 11, this.f597a.size()));
            for (String str : this.f597a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        if (this.f602d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f602d);
            jfVar.b();
        }
        if (this.f603e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f603e);
            jfVar.b();
        }
        if (h()) {
            jfVar.a(h);
            jfVar.a(this.f598a);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.a(this.f600b);
            jfVar.b();
        }
        if (j()) {
            jfVar.a(j);
            jfVar.a(this.f593a);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f596a.set(1, z);
    }

    public boolean b() {
        return this.f595a != null;
    }

    public id c(String str) {
        this.f601c = str;
        return this;
    }

    public void c(boolean z) {
        this.f596a.set(2, z);
    }

    public boolean c() {
        return this.f599b != null;
    }

    public id d(String str) {
        this.f602d = str;
        return this;
    }

    public boolean d() {
        return this.f601c != null;
    }

    public id e(String str) {
        this.f603e = str;
        return this;
    }

    public boolean e() {
        return this.f597a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof id)) {
            return m1015a((id) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f602d != null;
    }

    public boolean g() {
        return this.f603e != null;
    }

    public boolean h() {
        return this.f596a.get(0);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f596a.get(1);
    }

    public boolean j() {
        return this.f596a.get(2);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommand(");
        if (m1014a()) {
            sb.append("target:");
            hy hyVar = this.f594a;
            if (hyVar == null) {
                sb.append("null");
            } else {
                sb.append(hyVar);
            }
            z = false;
        } else {
            z = true;
        }
        if (!z) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
        }
        sb.append("id:");
        String str = this.f595a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str2 = this.f599b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("cmdName:");
        String str3 = this.f601c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("cmdArgs:");
            List<String> list = this.f597a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str4 = this.f602d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str5 = this.f603e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("updateCache:");
            sb.append(this.f598a);
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("response2Client:");
            sb.append(this.f600b);
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("createdTs:");
            sb.append(this.f593a);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
