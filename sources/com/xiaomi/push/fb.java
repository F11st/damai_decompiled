package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class fb implements iu<fb, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public String f341a;

    /* renamed from: a  reason: collision with other field name */
    public List<fa> f342a;

    /* renamed from: b  reason: collision with other field name */
    public String f343b;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f340a = new jk("StatsEvents");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 11, 2);
    private static final jc c = new jc("", (byte) 15, 3);

    public fb() {
    }

    public fb(String str, List<fa> list) {
        this();
        this.f341a = str;
        this.f342a = list;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(fb fbVar) {
        int a2;
        int a3;
        int a4;
        if (getClass().equals(fbVar.getClass())) {
            int compareTo = Boolean.valueOf(m876a()).compareTo(Boolean.valueOf(fbVar.m876a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m876a() || (a4 = iv.a(this.f341a, fbVar.f341a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(fbVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a3 = iv.a(this.f343b, fbVar.f343b)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(fbVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a2 = iv.a(this.f342a, fbVar.f342a)) == 0) {
                        return 0;
                    }
                    return a2;
                }
                return a3;
            }
            return a4;
        }
        return getClass().getName().compareTo(fbVar.getClass().getName());
    }

    public fb a(String str) {
        this.f343b = str;
        return this;
    }

    public void a() {
        if (this.f341a == null) {
            throw new jg("Required field 'uuid' was not present! Struct: " + toString());
        } else if (this.f342a != null) {
        } else {
            throw new jg("Required field 'events' was not present! Struct: " + toString());
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
            short s = mo1102a.f801a;
            if (s == 1) {
                if (b2 == 11) {
                    this.f341a = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else if (s != 2) {
                if (s == 3 && b2 == 15) {
                    jd mo1103a = jfVar.mo1103a();
                    this.f342a = new ArrayList(mo1103a.f802a);
                    for (int i = 0; i < mo1103a.f802a; i++) {
                        fa faVar = new fa();
                        faVar.a(jfVar);
                        this.f342a.add(faVar);
                    }
                    jfVar.i();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else {
                if (b2 == 11) {
                    this.f343b = jfVar.mo1107a();
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m876a() {
        return this.f341a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m877a(fb fbVar) {
        if (fbVar == null) {
            return false;
        }
        boolean m876a = m876a();
        boolean m876a2 = fbVar.m876a();
        if ((m876a || m876a2) && !(m876a && m876a2 && this.f341a.equals(fbVar.f341a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = fbVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f343b.equals(fbVar.f343b))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = fbVar.c();
        if (c2 || c3) {
            return c2 && c3 && this.f342a.equals(fbVar.f342a);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f340a);
        if (this.f341a != null) {
            jfVar.a(a);
            jfVar.a(this.f341a);
            jfVar.b();
        }
        if (this.f343b != null && b()) {
            jfVar.a(b);
            jfVar.a(this.f343b);
            jfVar.b();
        }
        if (this.f342a != null) {
            jfVar.a(c);
            jfVar.a(new jd((byte) 12, this.f342a.size()));
            for (fa faVar : this.f342a) {
                faVar.b(jfVar);
            }
            jfVar.e();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean b() {
        return this.f343b != null;
    }

    public boolean c() {
        return this.f342a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof fb)) {
            return m877a((fb) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("StatsEvents(");
        sb.append("uuid:");
        String str = this.f341a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(str);
        }
        if (b()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("operator:");
            String str2 = this.f343b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("events:");
        List<fa> list = this.f342a;
        if (list == null) {
            sb.append("null");
        } else {
            sb.append(list);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
