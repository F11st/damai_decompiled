package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class hw implements iu<hw, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f528a;

    /* renamed from: a  reason: collision with other field name */
    public long f529a;

    /* renamed from: a  reason: collision with other field name */
    public String f530a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f531a;

    /* renamed from: a  reason: collision with other field name */
    public Map<String, String> f532a;

    /* renamed from: a  reason: collision with other field name */
    public boolean f533a;

    /* renamed from: b  reason: collision with other field name */
    public int f534b;

    /* renamed from: b  reason: collision with other field name */
    public String f535b;

    /* renamed from: b  reason: collision with other field name */
    public Map<String, String> f536b;

    /* renamed from: c  reason: collision with other field name */
    public int f537c;

    /* renamed from: c  reason: collision with other field name */
    public String f538c;

    /* renamed from: c  reason: collision with other field name */
    public Map<String, String> f539c;

    /* renamed from: d  reason: collision with other field name */
    public String f540d;

    /* renamed from: e  reason: collision with other field name */
    public String f541e;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f527a = new jk("PushMetaInfo");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 10, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 8, 6);
    private static final jc g = new jc("", (byte) 11, 7);
    private static final jc h = new jc("", (byte) 8, 8);
    private static final jc i = new jc("", (byte) 8, 9);
    private static final jc j = new jc("", (byte) 13, 10);
    private static final jc k = new jc("", (byte) 13, 11);
    private static final jc l = new jc("", (byte) 2, 12);
    private static final jc m = new jc("", (byte) 13, 13);

    public hw() {
        this.f531a = new BitSet(5);
        this.f533a = false;
    }

    public hw(hw hwVar) {
        BitSet bitSet = new BitSet(5);
        this.f531a = bitSet;
        bitSet.clear();
        this.f531a.or(hwVar.f531a);
        if (hwVar.m991a()) {
            this.f530a = hwVar.f530a;
        }
        this.f529a = hwVar.f529a;
        if (hwVar.m997c()) {
            this.f535b = hwVar.f535b;
        }
        if (hwVar.m998d()) {
            this.f538c = hwVar.f538c;
        }
        if (hwVar.e()) {
            this.f540d = hwVar.f540d;
        }
        this.f528a = hwVar.f528a;
        if (hwVar.g()) {
            this.f541e = hwVar.f541e;
        }
        this.f534b = hwVar.f534b;
        this.f537c = hwVar.f537c;
        if (hwVar.j()) {
            HashMap hashMap = new HashMap();
            for (Map.Entry<String, String> entry : hwVar.f532a.entrySet()) {
                hashMap.put(entry.getKey(), entry.getValue());
            }
            this.f532a = hashMap;
        }
        if (hwVar.k()) {
            HashMap hashMap2 = new HashMap();
            for (Map.Entry<String, String> entry2 : hwVar.f536b.entrySet()) {
                hashMap2.put(entry2.getKey(), entry2.getValue());
            }
            this.f536b = hashMap2;
        }
        this.f533a = hwVar.f533a;
        if (hwVar.n()) {
            HashMap hashMap3 = new HashMap();
            for (Map.Entry<String, String> entry3 : hwVar.f539c.entrySet()) {
                hashMap3.put(entry3.getKey(), entry3.getValue());
            }
            this.f539c = hashMap3;
        }
    }

    public int a() {
        return this.f528a;
    }

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(hw hwVar) {
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
        int a12;
        int a13;
        int a14;
        if (getClass().equals(hwVar.getClass())) {
            int compareTo = Boolean.valueOf(m991a()).compareTo(Boolean.valueOf(hwVar.m991a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m991a() || (a14 = iv.a(this.f530a, hwVar.f530a)) == 0) {
                int compareTo2 = Boolean.valueOf(m995b()).compareTo(Boolean.valueOf(hwVar.m995b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!m995b() || (a13 = iv.a(this.f529a, hwVar.f529a)) == 0) {
                    int compareTo3 = Boolean.valueOf(m997c()).compareTo(Boolean.valueOf(hwVar.m997c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!m997c() || (a12 = iv.a(this.f535b, hwVar.f535b)) == 0) {
                        int compareTo4 = Boolean.valueOf(m998d()).compareTo(Boolean.valueOf(hwVar.m998d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!m998d() || (a11 = iv.a(this.f538c, hwVar.f538c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(hwVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a10 = iv.a(this.f540d, hwVar.f540d)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(hwVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a9 = iv.a(this.f528a, hwVar.f528a)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(hwVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a8 = iv.a(this.f541e, hwVar.f541e)) == 0) {
                                        int compareTo8 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(hwVar.h()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!h() || (a7 = iv.a(this.f534b, hwVar.f534b)) == 0) {
                                            int compareTo9 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(hwVar.i()));
                                            if (compareTo9 != 0) {
                                                return compareTo9;
                                            }
                                            if (!i() || (a6 = iv.a(this.f537c, hwVar.f537c)) == 0) {
                                                int compareTo10 = Boolean.valueOf(j()).compareTo(Boolean.valueOf(hwVar.j()));
                                                if (compareTo10 != 0) {
                                                    return compareTo10;
                                                }
                                                if (!j() || (a5 = iv.a(this.f532a, hwVar.f532a)) == 0) {
                                                    int compareTo11 = Boolean.valueOf(k()).compareTo(Boolean.valueOf(hwVar.k()));
                                                    if (compareTo11 != 0) {
                                                        return compareTo11;
                                                    }
                                                    if (!k() || (a4 = iv.a(this.f536b, hwVar.f536b)) == 0) {
                                                        int compareTo12 = Boolean.valueOf(m()).compareTo(Boolean.valueOf(hwVar.m()));
                                                        if (compareTo12 != 0) {
                                                            return compareTo12;
                                                        }
                                                        if (!m() || (a3 = iv.a(this.f533a, hwVar.f533a)) == 0) {
                                                            int compareTo13 = Boolean.valueOf(n()).compareTo(Boolean.valueOf(hwVar.n()));
                                                            if (compareTo13 != 0) {
                                                                return compareTo13;
                                                            }
                                                            if (!n() || (a2 = iv.a(this.f539c, hwVar.f539c)) == 0) {
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
                    return a12;
                }
                return a13;
            }
            return a14;
        }
        return getClass().getName().compareTo(hwVar.getClass().getName());
    }

    /* renamed from: a  reason: collision with other method in class */
    public long m986a() {
        return this.f529a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m987a() {
        return new hw(this);
    }

    public hw a(int i2) {
        this.f528a = i2;
        b(true);
        return this;
    }

    public hw a(String str) {
        this.f530a = str;
        return this;
    }

    public hw a(Map<String, String> map) {
        this.f532a = map;
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m988a() {
        return this.f530a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public Map<String, String> m989a() {
        return this.f532a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m990a() {
        if (this.f530a != null) {
            return;
        }
        throw new jg("Required field 'id' was not present! Struct: " + toString());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.xiaomi.push.iu
    public void a(jf jfVar) {
        jfVar.mo1106a();
        while (true) {
            jc mo1102a = jfVar.mo1102a();
            byte b2 = mo1102a.a;
            if (b2 == 0) {
                jfVar.f();
                if (m995b()) {
                    m990a();
                    return;
                }
                throw new jg("Required field 'messageTs' was not found in serialized data! Struct: " + toString());
            }
            int i2 = 0;
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f530a = jfVar.mo1107a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 2:
                    if (b2 == 10) {
                        this.f529a = jfVar.mo1101a();
                        a(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f535b = jfVar.mo1107a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f538c = jfVar.mo1107a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f540d = jfVar.mo1107a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 6:
                    if (b2 == 8) {
                        this.f528a = jfVar.mo1100a();
                        b(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f541e = jfVar.mo1107a();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 8:
                    if (b2 == 8) {
                        this.f534b = jfVar.mo1100a();
                        c(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 9:
                    if (b2 == 8) {
                        this.f537c = jfVar.mo1100a();
                        d(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 10:
                    if (b2 == 13) {
                        je mo1104a = jfVar.mo1104a();
                        this.f532a = new HashMap(mo1104a.f803a * 2);
                        while (i2 < mo1104a.f803a) {
                            this.f532a.put(jfVar.mo1107a(), jfVar.mo1107a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 11:
                    if (b2 == 13) {
                        je mo1104a2 = jfVar.mo1104a();
                        this.f536b = new HashMap(mo1104a2.f803a * 2);
                        while (i2 < mo1104a2.f803a) {
                            this.f536b.put(jfVar.mo1107a(), jfVar.mo1107a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 12:
                    if (b2 == 2) {
                        this.f533a = jfVar.mo1112a();
                        e(true);
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                case 13:
                    if (b2 == 13) {
                        je mo1104a3 = jfVar.mo1104a();
                        this.f539c = new HashMap(mo1104a3.f803a * 2);
                        while (i2 < mo1104a3.f803a) {
                            this.f539c.put(jfVar.mo1107a(), jfVar.mo1107a());
                            i2++;
                        }
                        jfVar.h();
                        break;
                    }
                    ji.a(jfVar, b2);
                    break;
                default:
                    ji.a(jfVar, b2);
                    break;
            }
            jfVar.g();
        }
    }

    public void a(String str, String str2) {
        if (this.f532a == null) {
            this.f532a = new HashMap();
        }
        this.f532a.put(str, str2);
    }

    public void a(boolean z) {
        this.f531a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m991a() {
        return this.f530a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m992a(hw hwVar) {
        if (hwVar == null) {
            return false;
        }
        boolean m991a = m991a();
        boolean m991a2 = hwVar.m991a();
        if (((m991a || m991a2) && !(m991a && m991a2 && this.f530a.equals(hwVar.f530a))) || this.f529a != hwVar.f529a) {
            return false;
        }
        boolean m997c = m997c();
        boolean m997c2 = hwVar.m997c();
        if ((m997c || m997c2) && !(m997c && m997c2 && this.f535b.equals(hwVar.f535b))) {
            return false;
        }
        boolean m998d = m998d();
        boolean m998d2 = hwVar.m998d();
        if ((m998d || m998d2) && !(m998d && m998d2 && this.f538c.equals(hwVar.f538c))) {
            return false;
        }
        boolean e2 = e();
        boolean e3 = hwVar.e();
        if ((e2 || e3) && !(e2 && e3 && this.f540d.equals(hwVar.f540d))) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = hwVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f528a == hwVar.f528a)) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = hwVar.g();
        if ((g2 || g3) && !(g2 && g3 && this.f541e.equals(hwVar.f541e))) {
            return false;
        }
        boolean h2 = h();
        boolean h3 = hwVar.h();
        if ((h2 || h3) && !(h2 && h3 && this.f534b == hwVar.f534b)) {
            return false;
        }
        boolean i2 = i();
        boolean i3 = hwVar.i();
        if ((i2 || i3) && !(i2 && i3 && this.f537c == hwVar.f537c)) {
            return false;
        }
        boolean j2 = j();
        boolean j3 = hwVar.j();
        if ((j2 || j3) && !(j2 && j3 && this.f532a.equals(hwVar.f532a))) {
            return false;
        }
        boolean k2 = k();
        boolean k3 = hwVar.k();
        if ((k2 || k3) && !(k2 && k3 && this.f536b.equals(hwVar.f536b))) {
            return false;
        }
        boolean m2 = m();
        boolean m3 = hwVar.m();
        if ((m2 || m3) && !(m2 && m3 && this.f533a == hwVar.f533a)) {
            return false;
        }
        boolean n = n();
        boolean n2 = hwVar.n();
        if (n || n2) {
            return n && n2 && this.f539c.equals(hwVar.f539c);
        }
        return true;
    }

    public int b() {
        return this.f534b;
    }

    public hw b(int i2) {
        this.f534b = i2;
        c(true);
        return this;
    }

    public hw b(String str) {
        this.f535b = str;
        return this;
    }

    /* renamed from: b  reason: collision with other method in class */
    public String m993b() {
        return this.f535b;
    }

    /* renamed from: b  reason: collision with other method in class */
    public Map<String, String> m994b() {
        return this.f536b;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m990a();
        jfVar.a(f527a);
        if (this.f530a != null) {
            jfVar.a(a);
            jfVar.a(this.f530a);
            jfVar.b();
        }
        jfVar.a(b);
        jfVar.a(this.f529a);
        jfVar.b();
        if (this.f535b != null && m997c()) {
            jfVar.a(c);
            jfVar.a(this.f535b);
            jfVar.b();
        }
        if (this.f538c != null && m998d()) {
            jfVar.a(d);
            jfVar.a(this.f538c);
            jfVar.b();
        }
        if (this.f540d != null && e()) {
            jfVar.a(e);
            jfVar.a(this.f540d);
            jfVar.b();
        }
        if (f()) {
            jfVar.a(f);
            jfVar.mo1111a(this.f528a);
            jfVar.b();
        }
        if (this.f541e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f541e);
            jfVar.b();
        }
        if (h()) {
            jfVar.a(h);
            jfVar.mo1111a(this.f534b);
            jfVar.b();
        }
        if (i()) {
            jfVar.a(i);
            jfVar.mo1111a(this.f537c);
            jfVar.b();
        }
        if (this.f532a != null && j()) {
            jfVar.a(j);
            jfVar.a(new je((byte) 11, (byte) 11, this.f532a.size()));
            for (Map.Entry<String, String> entry : this.f532a.entrySet()) {
                jfVar.a(entry.getKey());
                jfVar.a(entry.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (this.f536b != null && k()) {
            jfVar.a(k);
            jfVar.a(new je((byte) 11, (byte) 11, this.f536b.size()));
            for (Map.Entry<String, String> entry2 : this.f536b.entrySet()) {
                jfVar.a(entry2.getKey());
                jfVar.a(entry2.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        if (m()) {
            jfVar.a(l);
            jfVar.a(this.f533a);
            jfVar.b();
        }
        if (this.f539c != null && n()) {
            jfVar.a(m);
            jfVar.a(new je((byte) 11, (byte) 11, this.f539c.size()));
            for (Map.Entry<String, String> entry3 : this.f539c.entrySet()) {
                jfVar.a(entry3.getKey());
                jfVar.a(entry3.getValue());
            }
            jfVar.d();
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(String str, String str2) {
        if (this.f536b == null) {
            this.f536b = new HashMap();
        }
        this.f536b.put(str, str2);
    }

    public void b(boolean z) {
        this.f531a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m995b() {
        return this.f531a.get(0);
    }

    public int c() {
        return this.f537c;
    }

    public hw c(int i2) {
        this.f537c = i2;
        d(true);
        return this;
    }

    public hw c(String str) {
        this.f538c = str;
        return this;
    }

    /* renamed from: c  reason: collision with other method in class */
    public String m996c() {
        return this.f538c;
    }

    public void c(boolean z) {
        this.f531a.set(2, z);
    }

    /* renamed from: c  reason: collision with other method in class */
    public boolean m997c() {
        return this.f535b != null;
    }

    public hw d(String str) {
        this.f540d = str;
        return this;
    }

    public String d() {
        return this.f540d;
    }

    public void d(boolean z) {
        this.f531a.set(3, z);
    }

    /* renamed from: d  reason: collision with other method in class */
    public boolean m998d() {
        return this.f538c != null;
    }

    public void e(boolean z) {
        this.f531a.set(4, z);
    }

    public boolean e() {
        return this.f540d != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof hw)) {
            return m992a((hw) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f531a.get(1);
    }

    public boolean g() {
        return this.f541e != null;
    }

    public boolean h() {
        return this.f531a.get(2);
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f531a.get(3);
    }

    public boolean j() {
        return this.f532a != null;
    }

    public boolean k() {
        return this.f536b != null;
    }

    public boolean l() {
        return this.f533a;
    }

    public boolean m() {
        return this.f531a.get(4);
    }

    public boolean n() {
        return this.f539c != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("PushMetaInfo(");
        sb.append("id:");
        String str = this.f530a;
        if (str == null) {
            sb.append("null");
        } else {
            sb.append(com.xiaomi.push.service.bd.a(str));
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("messageTs:");
        sb.append(this.f529a);
        if (m997c()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("topic:");
            String str2 = this.f535b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        if (m998d()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("title:");
            String str3 = this.f538c;
            if (str3 == null) {
                sb.append("null");
            } else {
                sb.append(str3);
            }
        }
        if (e()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("description:");
            String str4 = this.f540d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("notifyType:");
            sb.append(this.f528a);
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("url:");
            String str5 = this.f541e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        if (h()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("passThrough:");
            sb.append(this.f534b);
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("notifyId:");
            sb.append(this.f537c);
        }
        if (j()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("extra:");
            Map<String, String> map = this.f532a;
            if (map == null) {
                sb.append("null");
            } else {
                sb.append(map);
            }
        }
        if (k()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("internal:");
            Map<String, String> map2 = this.f536b;
            if (map2 == null) {
                sb.append("null");
            } else {
                sb.append(map2);
            }
        }
        if (m()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("ignoreRegInfo:");
            sb.append(this.f533a);
        }
        if (n()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("apsProperFields:");
            Map<String, String> map3 = this.f539c;
            if (map3 == null) {
                sb.append("null");
            } else {
                sb.append(map3);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
