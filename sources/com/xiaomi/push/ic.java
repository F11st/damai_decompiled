package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ic implements iu<ic, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hr> f591a;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f590a = new jk("XmPushActionCollectData");
    private static final jc a = new jc("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ic icVar) {
        int a2;
        if (getClass().equals(icVar.getClass())) {
            int compareTo = Boolean.valueOf(m1010a()).compareTo(Boolean.valueOf(icVar.m1010a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1010a() || (a2 = iv.a(this.f591a, icVar.f591a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(icVar.getClass().getName());
    }

    public ic a(List<hr> list) {
        this.f591a = list;
        return this;
    }

    public void a() {
        if (this.f591a != null) {
            return;
        }
        throw new jg("Required field 'dataCollectionItems' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b = mo1102a.a;
            if (b == 0) {
                jfVar.f();
                a();
                return;
            }
            if (mo1102a.f801a == 1 && b == 15) {
                jd mo1103a = jfVar.mo1103a();
                this.f591a = new ArrayList(mo1103a.f802a);
                for (int i = 0; i < mo1103a.f802a; i++) {
                    hr hrVar = new hr();
                    hrVar.a(jfVar);
                    this.f591a.add(hrVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1010a() {
        return this.f591a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1011a(ic icVar) {
        if (icVar == null) {
            return false;
        }
        boolean m1010a = m1010a();
        boolean m1010a2 = icVar.m1010a();
        if (m1010a || m1010a2) {
            return m1010a && m1010a2 && this.f591a.equals(icVar.f591a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f590a);
        if (this.f591a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f591a.size()));
            for (hr hrVar : this.f591a) {
                hrVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ic)) {
            return m1011a((ic) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCollectData(");
        sb.append("dataCollectionItems:");
        List<hr> list = this.f591a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
