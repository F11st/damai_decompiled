package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.in */
/* loaded from: classes11.dex */
public class C7676in implements iu<C7676in, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hy f724a;

    /* renamed from: a  reason: collision with other field name */
    public String f725a;

    /* renamed from: a  reason: collision with other field name */
    public List<String> f726a;

    /* renamed from: b  reason: collision with other field name */
    public String f727b;

    /* renamed from: c  reason: collision with other field name */
    public String f728c;

    /* renamed from: d  reason: collision with other field name */
    public String f729d;

    /* renamed from: e  reason: collision with other field name */
    public String f730e;

    /* renamed from: f  reason: collision with other field name */
    public String f731f;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f723a = new jk("XmPushActionSubscription");
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
    public int compareTo(C7676in c7676in) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(c7676in.getClass())) {
            int compareTo = Boolean.valueOf(m1069a()).compareTo(Boolean.valueOf(c7676in.m1069a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1069a() || (a9 = iv.a(this.f725a, c7676in.f725a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(c7676in.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a8 = iv.a(this.f724a, c7676in.f724a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(c7676in.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a7 = iv.a(this.f727b, c7676in.f727b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(c7676in.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a6 = iv.a(this.f728c, c7676in.f728c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(c7676in.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a5 = iv.a(this.f729d, c7676in.f729d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(c7676in.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a4 = iv.a(this.f730e, c7676in.f730e)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(c7676in.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a3 = iv.a(this.f731f, c7676in.f731f)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(c7676in.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a2 = iv.a(this.f726a, c7676in.f726a)) == 0) {
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
        return getClass().getName().compareTo(c7676in.getClass().getName());
    }

    public C7676in a(String str) {
        this.f727b = str;
        return this;
    }

    public void a() {
        if (this.f727b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f728c == null) {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
        } else if (this.f729d != null) {
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
                        this.f725a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f724a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f727b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f728c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f729d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f730e = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f731f = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 15) {
                        jd mo1103a = jfVar.mo1103a();
                        this.f726a = new ArrayList(mo1103a.f802a);
                        for (int i = 0; i < mo1103a.f802a; i++) {
                            this.f726a.add(jfVar.mo1107a());
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
    public boolean m1069a() {
        return this.f725a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1070a(C7676in c7676in) {
        if (c7676in == null) {
            return false;
        }
        boolean m1069a = m1069a();
        boolean m1069a2 = c7676in.m1069a();
        if ((m1069a || m1069a2) && !(m1069a && m1069a2 && this.f725a.equals(c7676in.f725a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = c7676in.b();
        if ((b2 || b3) && !(b2 && b3 && this.f724a.m1000a(c7676in.f724a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = c7676in.c();
        if ((c2 || c3) && !(c2 && c3 && this.f727b.equals(c7676in.f727b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = c7676in.d();
        if ((d2 || d3) && !(d2 && d3 && this.f728c.equals(c7676in.f728c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = c7676in.e();
        if ((e2 || e3) && !(e2 && e3 && this.f729d.equals(c7676in.f729d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = c7676in.f();
        if ((f2 || f3) && !(f2 && f3 && this.f730e.equals(c7676in.f730e))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = c7676in.g();
        if ((g2 || g3) && !(g2 && g3 && this.f731f.equals(c7676in.f731f))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = c7676in.h();
        if (h2 || h3) {
            return h2 && h3 && this.f726a.equals(c7676in.f726a);
        }
        return true;
    }

    public C7676in b(String str) {
        this.f728c = str;
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f723a);
        if (this.f725a != null && m1069a()) {
            jfVar.a(a);
            jfVar.a(this.f725a);
            jfVar.b();
        }
        if (this.f724a != null && b()) {
            jfVar.a(b);
            this.f724a.b(jfVar);
            jfVar.b();
        }
        if (this.f727b != null) {
            jfVar.a(c);
            jfVar.a(this.f727b);
            jfVar.b();
        }
        if (this.f728c != null) {
            jfVar.a(d);
            jfVar.a(this.f728c);
            jfVar.b();
        }
        if (this.f729d != null) {
            jfVar.a(e);
            jfVar.a(this.f729d);
            jfVar.b();
        }
        if (this.f730e != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f730e);
            jfVar.b();
        }
        if (this.f731f != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f731f);
            jfVar.b();
        }
        if (this.f726a != null && h()) {
            jfVar.a(h);
            jfVar.a(new jd((byte) 11, this.f726a.size()));
            for (String str : this.f726a) {
                jfVar.a(str);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean b() {
        return this.f724a != null;
    }

    public C7676in c(String str) {
        this.f729d = str;
        return this;
    }

    public boolean c() {
        return this.f727b != null;
    }

    public C7676in d(String str) {
        this.f730e = str;
        return this;
    }

    public boolean d() {
        return this.f728c != null;
    }

    public C7676in e(String str) {
        this.f731f = str;
        return this;
    }

    public boolean e() {
        return this.f729d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof C7676in)) {
            return m1070a((C7676in) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f730e != null;
    }

    public boolean g() {
        return this.f731f != null;
    }

    public boolean h() {
        return this.f726a != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSubscription(");
        boolean z2 = false;
        if (m1069a()) {
            sb.append("debug:");
            String str = this.f725a;
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
            hy hyVar = this.f724a;
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
        String str2 = this.f727b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f728c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("topic:");
        String str4 = this.f729d;
        if (str4 == null) {
            sb.append("null");
        } else {
            sb.append(str4);
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str5 = this.f730e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str6 = this.f731f;
            if (str6 == null) {
                sb.append("null");
            } else {
                sb.append(str6);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("aliases:");
            List<String> list = this.f726a;
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
