package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ih implements iu<ih, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hs> f629a;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f628a = new jk("XmPushActionNormalConfig");
    private static final jc a = new jc("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ih ihVar) {
        int a2;
        if (getClass().equals(ihVar.getClass())) {
            int compareTo = Boolean.valueOf(m1035a()).compareTo(Boolean.valueOf(ihVar.m1035a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1035a() || (a2 = iv.a(this.f629a, ihVar.f629a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(ihVar.getClass().getName());
    }

    public List<hs> a() {
        return this.f629a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1034a() {
        if (this.f629a != null) {
            return;
        }
        throw new jg("Required field 'normalConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b = mo1102a.a;
            if (b == 0) {
                jfVar.f();
                m1034a();
                return;
            }
            if (mo1102a.f801a == 1 && b == 15) {
                jd mo1103a = jfVar.mo1103a();
                this.f629a = new ArrayList(mo1103a.f802a);
                for (int i = 0; i < mo1103a.f802a; i++) {
                    hs hsVar = new hs();
                    hsVar.a(jfVar);
                    this.f629a.add(hsVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1035a() {
        return this.f629a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1036a(ih ihVar) {
        if (ihVar == null) {
            return false;
        }
        boolean m1035a = m1035a();
        boolean m1035a2 = ihVar.m1035a();
        if (m1035a || m1035a2) {
            return m1035a && m1035a2 && this.f629a.equals(ihVar.f629a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1034a();
        jfVar.a(f628a);
        if (this.f629a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f629a.size()));
            for (hs hsVar : this.f629a) {
                hsVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ih)) {
            return m1036a((ih) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionNormalConfig(");
        sb.append("normalConfigs:");
        List<hs> list = this.f629a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
