package com.xiaomi.push;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hm implements iu<hm, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public List<C7672hn> f466a;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f465a = new jk("ClientUploadData");
    private static final jc a = new jc("", (byte) 15, 1);

    public int a() {
        List<C7672hn> list = this.f466a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hm hmVar) {
        int a2;
        if (getClass().equals(hmVar.getClass())) {
            int compareTo = Boolean.valueOf(m954a()).compareTo(Boolean.valueOf(hmVar.m954a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m954a() || (a2 = iv.a(this.f466a, hmVar.f466a)) == 0) {
                return 0;
            }
            return a2;
        }
        return getClass().getName().compareTo(hmVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m953a() {
        if (this.f466a != null) {
            return;
        }
        throw new jg("Required field 'uploadDataItems' was not present! Struct: " + toString());
    }

    public void a(C7672hn c7672hn) {
        if (this.f466a == null) {
            this.f466a = new ArrayList();
        }
        this.f466a.add(c7672hn);
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b = mo1102a.a;
            if (b == 0) {
                jfVar.f();
                m953a();
                return;
            }
            if (mo1102a.f801a == 1 && b == 15) {
                jd mo1103a = jfVar.mo1103a();
                this.f466a = new ArrayList(mo1103a.f802a);
                for (int i = 0; i < mo1103a.f802a; i++) {
                    C7672hn c7672hn = new C7672hn();
                    c7672hn.a(jfVar);
                    this.f466a.add(c7672hn);
                }
                jfVar.i();
            } else {
                ji.a(jfVar, b);
            }
            jfVar.g();
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m954a() {
        return this.f466a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m955a(hm hmVar) {
        if (hmVar == null) {
            return false;
        }
        boolean m954a = m954a();
        boolean m954a2 = hmVar.m954a();
        if (m954a || m954a2) {
            return m954a && m954a2 && this.f466a.equals(hmVar.f466a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m953a();
        jfVar.a(f465a);
        if (this.f466a != null) {
            jfVar.a(a);
            jfVar.a(new jd((byte) 12, this.f466a.size()));
            for (C7672hn c7672hn : this.f466a) {
                c7672hn.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hm)) {
            return m955a((hm) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ClientUploadData(");
        sb.append("uploadDataItems:");
        List<C7672hn> list = this.f466a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
