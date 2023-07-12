package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ig implements iu<ig, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<hu> f627a;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f626a = new jk("XmPushActionCustomConfig");
    private static final jc a = new jc("", (byte) 15, 1);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ig igVar) {
        int a2;
        if (getClass().equals(igVar.getClass())) {
            int compareTo = Boolean.valueOf(m1032a()).compareTo(Boolean.valueOf(igVar.m1032a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1032a() || (a2 = iv.a(this.f627a, igVar.f627a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(igVar.getClass().getName());
    }

    public List<hu> a() {
        return this.f627a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1031a() {
        if (this.f627a != null) {
            return;
        }
        throw new jg("Required field 'customConfigs' was not present! Struct: " + toString());
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b = mo1102a.a;
            if (b == 0) {
                jfVar.f();
                m1031a();
                return;
            }
            if (mo1102a.f801a == 1 && b == 15) {
                jd mo1103a = jfVar.mo1103a();
                this.f627a = new ArrayList(mo1103a.f802a);
                for (int i = 0; i < mo1103a.f802a; i++) {
                    hu huVar = new hu();
                    huVar.a(jfVar);
                    this.f627a.add(huVar);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1032a() {
        return this.f627a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1033a(ig igVar) {
        if (igVar == null) {
            return false;
        }
        boolean m1032a = m1032a();
        boolean m1032a2 = igVar.m1032a();
        if (m1032a || m1032a2) {
            return m1032a && m1032a2 && this.f627a.equals(igVar.f627a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1031a();
        jfVar.a(f626a);
        if (this.f627a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f627a.size()));
            for (hu huVar : this.f627a) {
                huVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ig)) {
            return m1033a((ig) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionCustomConfig(");
        sb.append("customConfigs:");
        List<hu> list = this.f627a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
