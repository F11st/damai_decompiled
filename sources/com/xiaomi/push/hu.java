package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hu implements iu<hu, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f499a;

    /* renamed from: a  reason: collision with other field name */
    public long f500a;

    /* renamed from: a  reason: collision with other field name */
    public String f501a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f502a = new BitSet(6);

    /* renamed from: a  reason: collision with other field name */
    public boolean f503a;

    /* renamed from: b  reason: collision with other field name */
    public int f504b;

    /* renamed from: b  reason: collision with other field name */
    public boolean f505b;

    /* renamed from: c  reason: collision with other field name */
    public int f506c;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f498a = new jk("OnlineConfigItem");
    private static final jc a = new jc("", (byte) 8, 1);
    private static final jc b = new jc("", (byte) 8, 2);
    private static final jc c = new jc("", (byte) 2, 3);
    private static final jc d = new jc("", (byte) 8, 4);
    private static final jc e = new jc("", (byte) 10, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 2, 7);

    public int a() {
        return this.f499a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hu huVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(huVar.getClass())) {
            int compareTo = Boolean.valueOf(m976a()).compareTo(Boolean.valueOf(huVar.m976a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m976a() || (a8 = iv.a(this.f499a, huVar.f499a)) == 0) {
                int compareTo2 = Boolean.valueOf(m978b()).compareTo(Boolean.valueOf(huVar.m978b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m978b() || (a7 = iv.a(this.f504b, huVar.f504b)) == 0) {
                    int compareTo3 = Boolean.valueOf(m979c()).compareTo(Boolean.valueOf(huVar.m979c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m979c() || (a6 = iv.a(this.f503a, huVar.f503a)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(huVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = iv.a(this.f506c, huVar.f506c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(huVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = iv.a(this.f500a, huVar.f500a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(huVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = iv.a(this.f501a, huVar.f501a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(huVar.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a2 = iv.a(this.f505b, huVar.f505b)) == 0) {
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
        return getClass().getName().compareTo(huVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m973a() {
        return this.f500a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m974a() {
        return this.f501a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m975a() {
    }

    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                jfVar.f();
                m975a();
                return;
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 8) {
                        this.f499a = jfVar.mo1100a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 8) {
                        this.f504b = jfVar.mo1100a();
                        b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f503a = jfVar.mo1112a();
                        c(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 8) {
                        this.f506c = jfVar.mo1100a();
                        d(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 10) {
                        this.f500a = jfVar.mo1101a();
                        e(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f501a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 2) {
                        this.f505b = jfVar.mo1112a();
                        f(true);
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
        this.f502a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m976a() {
        return this.f502a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m977a(hu huVar) {
        if (huVar == null) {
            return false;
        }
        boolean m976a = m976a();
        boolean m976a2 = huVar.m976a();
        if ((m976a || m976a2) && !(m976a && m976a2 && this.f499a == huVar.f499a)) {
            return false;
        }
        boolean m978b = m978b();
        boolean m978b2 = huVar.m978b();
        if ((m978b || m978b2) && !(m978b && m978b2 && this.f504b == huVar.f504b)) {
            return false;
        }
        boolean m979c = m979c();
        boolean m979c2 = huVar.m979c();
        if ((m979c || m979c2) && !(m979c && m979c2 && this.f503a == huVar.f503a)) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = huVar.d();
        if ((d2 || d3) && !(d2 && d3 && this.f506c == huVar.f506c)) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = huVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f500a == huVar.f500a)) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = huVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f501a.equals(huVar.f501a))) {
            return false;
        }
        boolean h = h();
        boolean h2 = huVar.h();
        if (h || h2) {
            return h && h2 && this.f505b == huVar.f505b;
        }
        return true;
    }

    public int b() {
        return this.f504b;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m975a();
        jfVar.a(f498a);
        if (m976a()) {
            jfVar.a(a);
            jfVar.mo1111a(this.f499a);
            jfVar.b();
        }
        if (m978b()) {
            jfVar.a(b);
            jfVar.mo1111a(this.f504b);
            jfVar.b();
        }
        if (m979c()) {
            jfVar.a(c);
            jfVar.a(this.f503a);
            jfVar.b();
        }
        if (d()) {
            jfVar.a(d);
            jfVar.mo1111a(this.f506c);
            jfVar.b();
        }
        if (e()) {
            jfVar.a(e);
            jfVar.a(this.f500a);
            jfVar.b();
        }
        if (this.f501a != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f501a);
            jfVar.b();
        }
        if (h()) {
            jfVar.a(g);
            jfVar.a(this.f505b);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f502a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m978b() {
        return this.f502a.get(1);
    }

    public int c() {
        return this.f506c;
    }

    public void c(boolean z) {
        this.f502a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m979c() {
        return this.f502a.get(2);
    }

    public void d(boolean z) {
        this.f502a.set(3, z);
    }

    public boolean d() {
        return this.f502a.get(3);
    }

    public void e(boolean z) {
        this.f502a.set(4, z);
    }

    public boolean e() {
        return this.f502a.get(4);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hu)) {
            return m977a((hu) obj);
        }
        return false;
    }

    public void f(boolean z) {
        this.f502a.set(5, z);
    }

    public boolean f() {
        return this.f501a != null;
    }

    public boolean g() {
        return this.f505b;
    }

    public boolean h() {
        return this.f502a.get(5);
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("OnlineConfigItem(");
        boolean z2 = false;
        if (m976a()) {
            sb.append("key:");
            sb.append(this.f499a);
            z = false;
        } else {
            z = true;
        }
        if (m978b()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("type:");
            sb.append(this.f504b);
            z = false;
        }
        if (m979c()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("clear:");
            sb.append(this.f503a);
            z = false;
        }
        if (d()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("intValue:");
            sb.append(this.f506c);
            z = false;
        }
        if (e()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("longValue:");
            sb.append(this.f500a);
            z = false;
        }
        if (f()) {
            if (!z) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("stringValue:");
            String str = this.f501a;
            if (str == null) {
                str = "null";
            }
            sb.append(str);
        } else {
            z2 = z;
        }
        if (h()) {
            if (!z2) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
            sb.append("boolValue:");
            sb.append(this.f505b);
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
