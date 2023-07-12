package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hs implements iu<hs, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f492a;

    /* renamed from: a  reason: collision with other field name */
    public hp f493a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f494a = new BitSet(1);

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f495a;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f491a = new jk("NormalConfig");
    private static final jc a = new jc("", (byte) 8, 1);
    private static final jc b = new jc("", (byte) 15, 2);
    private static final jc c = new jc("", (byte) 8, 3);

    public int a() {
        return this.f492a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hs hsVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(hsVar.getClass())) {
            int compareTo = Boolean.valueOf(m971a()).compareTo(Boolean.valueOf(hsVar.m971a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m971a() || (a4 = iv.a(this.f492a, hsVar.f492a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(hsVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = iv.a(this.f495a, hsVar.f495a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(hsVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = iv.a(this.f493a, hsVar.f493a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return getClass().getName().compareTo(hsVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public hp m969a() {
        return this.f493a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m970a() {
        if (this.f495a != null) {
            return;
        }
        throw new jg("Required field 'configItems' was not present! Struct: " + toString());
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
                if (b2 == 8) {
                    this.f492a = jfVar.mo1100a();
                    a(true);
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 8) {
                    this.f493a = hp.a(jfVar.mo1100a());
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else {
                if (b2 == 15) {
                    jd mo1103a = jfVar.mo1103a();
                    this.f495a = new ArrayList(mo1103a.f802a);
                    for (int i = 0; i < mo1103a.f802a; i++) {
                        hu huVar = new hu();
                        huVar.a(jfVar);
                        this.f495a.add(huVar);
                    }
                    jfVar.i();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
        jfVar.f();
        if (m971a()) {
            m970a();
            return;
        }
        throw new jg("Required field 'version' was not found in serialized data! Struct: " + toString());
    }

    public void a(boolean z) {
        this.f494a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m971a() {
        return this.f494a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m972a(hs hsVar) {
        if (hsVar != null && this.f492a == hsVar.f492a) {
            boolean b2 = b();
            boolean b3 = hsVar.b();
            if ((b2 || b3) && !(b2 && b3 && this.f495a.equals(hsVar.f495a))) {
                return false;
            }
            boolean c2 = c();
            boolean c3 = hsVar.c();
            if (c2 || c3) {
                return c2 && c3 && this.f493a.equals(hsVar.f493a);
            }
            return true;
        }
        return false;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m970a();
        jfVar.a(f491a);
        jfVar.a(a);
        jfVar.mo1111a(this.f492a);
        jfVar.b();
        if (this.f495a != null) {
            jfVar.a(b);
            jfVar.a(new jd((byte) 12, this.f495a.size()));
            for (hu huVar : this.f495a) {
                huVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        if (this.f493a != null && c()) {
            jfVar.a(c);
            jfVar.mo1111a(this.f493a.a());
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean b() {
        return this.f495a != null;
    }

    public boolean c() {
        return this.f493a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hs)) {
            return m972a((hs) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("NormalConfig(");
        sb.append("version:");
        sb.append(this.f492a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("configItems:");
        List<hu> list = this.f495a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        if (c()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("type:");
            hp hpVar = this.f493a;
            if (hpVar == null) {
                sb.append("null");
            } else {
                sb.append(hpVar);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
