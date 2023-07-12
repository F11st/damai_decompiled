package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ie implements iu<ie, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f605a;

    /* renamed from: a  reason: collision with other field name */
    public hy f606a;

    /* renamed from: a  reason: collision with other field name */
    public String f607a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f609a;

    /* renamed from: b  reason: collision with other field name */
    public String f611b;

    /* renamed from: c  reason: collision with other field name */
    public String f612c;

    /* renamed from: d  reason: collision with other field name */
    public String f613d;

    /* renamed from: e  reason: collision with other field name */
    public String f614e;

    /* renamed from: f  reason: collision with other field name */
    public String f615f;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f604a = new jk("XmPushActionCommandResult");
    private static final jc a = new jc("", (byte) 12, 2);
    private static final jc b = new jc("", (byte) 11, 3);
    private static final jc c = new jc("", (byte) 11, 4);
    private static final jc d = new jc("", (byte) 11, 5);
    private static final jc e = new jc("", (byte) 10, 7);
    private static final jc f = new jc("", (byte) 11, 8);
    private static final jc g = new jc("", (byte) 11, 9);
    private static final jc h = new jc("", (byte) 15, 10);
    private static final jc i = new jc("", (byte) 11, 12);
    private static final jc j = new jc("", (byte) 2, 13);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f608a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f610a = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ie ieVar) {
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
        if (getClass().equals(ieVar.getClass())) {
            int compareTo = Boolean.valueOf(m1018a()).compareTo(Boolean.valueOf(ieVar.m1018a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1018a() || (a11 = iv.a(this.f606a, ieVar.f606a)) == 0) {
                int compareTo2 = Boolean.valueOf(m1020b()).compareTo(Boolean.valueOf(ieVar.m1020b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m1020b() || (a10 = iv.a(this.f607a, ieVar.f607a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m1021c()).compareTo(Boolean.valueOf(ieVar.m1021c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m1021c() || (a9 = iv.a(this.f611b, ieVar.f611b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ieVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a8 = iv.a(this.f612c, ieVar.f612c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ieVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a7 = iv.a(this.f605a, ieVar.f605a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ieVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a6 = iv.a(this.f613d, ieVar.f613d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ieVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a5 = iv.a(this.f614e, ieVar.f614e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(ieVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a4 = iv.a(this.f609a, ieVar.f609a)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(ieVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a3 = iv.a(this.f615f, ieVar.f615f)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(ieVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a2 = iv.a(this.f610a, ieVar.f610a)) == 0) {
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
        return getClass().getName().compareTo(ieVar.getClass().getName());
    }

    public String a() {
        return this.f607a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public List<String> m1016a() {
        return this.f609a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1017a() {
        if (this.f607a == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f611b == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f612c != null) {
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
                if (e()) {
                    m1017a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f606a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f607a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f611b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f612c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 10) {
                        this.f605a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f613d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 9:
                    if (b2 == 11) {
                        this.f614e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 10:
                    if (b2 == 15) {
                        jd mo1103a = jfVar.mo1103a();
                        this.f609a = new ArrayList(mo1103a.f802a);
                        for (int i2 = 0; i2 < mo1103a.f802a; i2++) {
                            this.f609a.add(jfVar.mo1107a());
                        }
                        jfVar.i();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 12:
                    if (b2 == 11) {
                        this.f615f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 13:
                    if (b2 == 2) {
                        this.f610a = jfVar.mo1112a();
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
        this.f608a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1018a() {
        return this.f606a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1019a(ie ieVar) {
        if (ieVar == null) {
            return false;
        }
        boolean m1018a = m1018a();
        boolean m1018a2 = ieVar.m1018a();
        if ((m1018a || m1018a2) && !(m1018a && m1018a2 && this.f606a.m1000a(ieVar.f606a))) {
            return false;
        }
        boolean m1020b = m1020b();
        boolean m1020b2 = ieVar.m1020b();
        if ((m1020b || m1020b2) && !(m1020b && m1020b2 && this.f607a.equals(ieVar.f607a))) {
            return false;
        }
        boolean m1021c = m1021c();
        boolean m1021c2 = ieVar.m1021c();
        if ((m1021c || m1021c2) && !(m1021c && m1021c2 && this.f611b.equals(ieVar.f611b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ieVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f612c.equals(ieVar.f612c))) || this.f605a != ieVar.f605a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ieVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f613d.equals(ieVar.f613d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ieVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f614e.equals(ieVar.f614e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = ieVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f609a.equals(ieVar.f609a))) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = ieVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f615f.equals(ieVar.f615f))) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = ieVar.j();
        if (j2 || j3) {
            return j2 && j3 && this.f610a == ieVar.f610a;
        }
        return true;
    }

    public String b() {
        return this.f612c;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1017a();
        jfVar.a(f604a);
        if (this.f606a != null && m1018a()) {
            jfVar.a(a);
            this.f606a.b(jfVar);
            jfVar.b();
        }
        if (this.f607a != null) {
            jfVar.a(b);
            jfVar.a(this.f607a);
            jfVar.b();
        }
        if (this.f611b != null) {
            jfVar.a(c);
            jfVar.a(this.f611b);
            jfVar.b();
        }
        if (this.f612c != null) {
            jfVar.a(d);
            jfVar.a(this.f612c);
            jfVar.b();
        }
        jfVar.a(e);
        jfVar.a(this.f605a);
        jfVar.b();
        if (this.f613d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f613d);
            jfVar.b();
        }
        if (this.f614e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f614e);
            jfVar.b();
        }
        if (this.f609a != null && h()) {
            jfVar.a(h);
            jfVar.a(new jd((byte) 11, this.f609a.size()));
            for (String str : this.f609a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        if (this.f615f != null && i()) {
            jfVar.a(i);
            jfVar.a(this.f615f);
            jfVar.b();
        }
        if (j()) {
            jfVar.a(j);
            jfVar.a(this.f610a);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f608a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1020b() {
        return this.f607a != null;
    }

    public String c() {
        return this.f615f;
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m1021c() {
        return this.f611b != null;
    }

    public boolean d() {
        return this.f612c != null;
    }

    public boolean e() {
        return this.f608a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ie)) {
            return m1019a((ie) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f613d != null;
    }

    public boolean g() {
        return this.f614e != null;
    }

    public boolean h() {
        return this.f609a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f615f != null;
    }

    public boolean j() {
        return this.f608a.get(1);
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionCommandResult(");
        if (m1018a()) {
            sb.append("target:");
            hy hyVar = this.f606a;
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
        String str = this.f607a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str2 = this.f611b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("cmdName:");
        String str3 = this.f612c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("errorCode:");
        sb.append(this.f605a);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f613d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f614e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("cmdArgs:");
            List<String> list = this.f609a;
            if (list == null) {
                sb.append("null");
            } else {
                sb.append(list);
            }
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str6 = this.f615f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("response2Client:");
            sb.append(this.f610a);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
