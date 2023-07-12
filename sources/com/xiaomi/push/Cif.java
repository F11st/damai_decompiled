package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.nio.ByteBuffer;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* renamed from: com.xiaomi.push.if  reason: invalid class name */
/* loaded from: classes11.dex */
public class Cif implements iu<Cif, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public hj f617a;

    /* renamed from: a  reason: collision with other field name */
    public hw f618a;

    /* renamed from: a  reason: collision with other field name */
    public hy f619a;

    /* renamed from: a  reason: collision with other field name */
    public String f620a;

    /* renamed from: a  reason: collision with other field name */
    public ByteBuffer f621a;

    /* renamed from: b  reason: collision with other field name */
    public String f624b;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f616a = new jk("XmPushActionContainer");
    private static final jc a = new jc("", (byte) 8, 1);
    private static final jc b = new jc("", (byte) 2, 2);
    private static final jc c = new jc("", (byte) 2, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 11, 5);
    private static final jc f = new jc("", (byte) 11, 6);
    private static final jc g = new jc("", (byte) 12, 7);
    private static final jc h = new jc("", (byte) 12, 8);

    /* renamed from: a  reason: collision with other field name */
    private BitSet f622a = new BitSet(2);

    /* renamed from: a  reason: collision with other field name */
    public boolean f623a = true;

    /* renamed from: b  reason: collision with other field name */
    public boolean f625b = true;

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(Cif cif) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        int a9;
        if (getClass().equals(cif.getClass())) {
            int compareTo = Boolean.valueOf(m1026a()).compareTo(Boolean.valueOf(cif.m1026a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1026a() || (a9 = iv.a(this.f617a, cif.f617a)) == 0) {
                int compareTo2 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(cif.c()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!c() || (a8 = iv.a(this.f623a, cif.f623a)) == 0) {
                    int compareTo3 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(cif.d()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!d() || (a7 = iv.a(this.f625b, cif.f625b)) == 0) {
                        int compareTo4 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(cif.e()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!e() || (a6 = iv.a(this.f621a, cif.f621a)) == 0) {
                            int compareTo5 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(cif.f()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!f() || (a5 = iv.a(this.f620a, cif.f620a)) == 0) {
                                int compareTo6 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(cif.g()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!g() || (a4 = iv.a(this.f624b, cif.f624b)) == 0) {
                                    int compareTo7 = Boolean.valueOf(h()).compareTo(Boolean.valueOf(cif.h()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!h() || (a3 = iv.a(this.f619a, cif.f619a)) == 0) {
                                        int compareTo8 = Boolean.valueOf(i()).compareTo(Boolean.valueOf(cif.i()));
                                        if (compareTo8 != 0) {
                                            return compareTo8;
                                        }
                                        if (!i() || (a2 = iv.a(this.f618a, cif.f618a)) == 0) {
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
        return getClass().getName().compareTo(cif.getClass().getName());
    }

    public hj a() {
        return this.f617a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public hw m1022a() {
        return this.f618a;
    }

    public Cif a(hj hjVar) {
        this.f617a = hjVar;
        return this;
    }

    public Cif a(hw hwVar) {
        this.f618a = hwVar;
        return this;
    }

    public Cif a(hy hyVar) {
        this.f619a = hyVar;
        return this;
    }

    public Cif a(String str) {
        this.f620a = str;
        return this;
    }

    public Cif a(ByteBuffer byteBuffer) {
        this.f621a = byteBuffer;
        return this;
    }

    public Cif a(boolean z) {
        this.f623a = z;
        m1025a(true);
        return this;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m1023a() {
        return this.f620a;
    }

    /* renamed from: a  reason: collision with other method in class */
    public void m1024a() {
        if (this.f617a == null) {
            throw new jg("Required field 'action' was not present! Struct: " + toString());
        } else if (this.f621a == null) {
            throw new jg("Required field 'pushAction' was not present! Struct: " + toString());
        } else if (this.f619a != null) {
        } else {
            throw new jg("Required field 'target' was not present! Struct: " + toString());
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
                if (!c()) {
                    throw new jg("Required field 'encryptAction' was not found in serialized data! Struct: " + toString());
                } else if (d()) {
                    m1024a();
                    return;
                } else {
                    throw new jg("Required field 'isRequest' was not found in serialized data! Struct: " + toString());
                }
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 8) {
                        this.f617a = hj.a(jfVar.mo1100a());
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 2) {
                        this.f623a = jfVar.mo1112a();
                        m1025a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 2) {
                        this.f625b = jfVar.mo1112a();
                        m1029b(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f621a = jfVar.mo1108a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 5:
                    if (b2 == 11) {
                        this.f620a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 11) {
                        this.f624b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f619a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 12) {
                        hw hwVar = new hw();
                        this.f618a = hwVar;
                        hwVar.a(jfVar);
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
    public void m1025a(boolean z) {
        this.f622a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1026a() {
        return this.f617a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1027a(Cif cif) {
        if (cif == null) {
            return false;
        }
        boolean m1026a = m1026a();
        boolean m1026a2 = cif.m1026a();
        if (((!m1026a && !m1026a2) || (m1026a && m1026a2 && this.f617a.equals(cif.f617a))) && this.f623a == cif.f623a && this.f625b == cif.f625b) {
            boolean e2 = e();
            boolean e3 = cif.e();
            if ((e2 || e3) && !(e2 && e3 && this.f621a.equals(cif.f621a))) {
                return false;
            }
            boolean f2 = f();
            boolean f3 = cif.f();
            if ((f2 || f3) && !(f2 && f3 && this.f620a.equals(cif.f620a))) {
                return false;
            }
            boolean g2 = g();
            boolean g3 = cif.g();
            if ((g2 || g3) && !(g2 && g3 && this.f624b.equals(cif.f624b))) {
                return false;
            }
            boolean h2 = h();
            boolean h3 = cif.h();
            if ((h2 || h3) && !(h2 && h3 && this.f619a.m1000a(cif.f619a))) {
                return false;
            }
            boolean i = i();
            boolean i2 = cif.i();
            if (i || i2) {
                return i && i2 && this.f618a.m992a(cif.f618a);
            }
            return true;
        }
        return false;
    }

    /* renamed from: a  reason: collision with other method in class */
    public byte[] m1028a() {
        a(iv.a(this.f621a));
        return this.f621a.array();
    }

    public Cif b(String str) {
        this.f624b = str;
        return this;
    }

    public Cif b(boolean z) {
        this.f625b = z;
        m1029b(true);
        return this;
    }

    public String b() {
        return this.f624b;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        m1024a();
        jfVar.a(f616a);
        if (this.f617a != null) {
            jfVar.a(a);
            jfVar.mo1111a(this.f617a.a());
            jfVar.b();
        }
        jfVar.a(b);
        jfVar.a(this.f623a);
        jfVar.b();
        jfVar.a(c);
        jfVar.a(this.f625b);
        jfVar.b();
        if (this.f621a != null) {
            jfVar.a(d);
            jfVar.a(this.f621a);
            jfVar.b();
        }
        if (this.f620a != null && f()) {
            jfVar.a(e);
            jfVar.a(this.f620a);
            jfVar.b();
        }
        if (this.f624b != null && g()) {
            jfVar.a(f);
            jfVar.a(this.f624b);
            jfVar.b();
        }
        if (this.f619a != null) {
            jfVar.a(g);
            this.f619a.b(jfVar);
            jfVar.b();
        }
        if (this.f618a != null && i()) {
            jfVar.a(h);
            this.f618a.b(jfVar);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    /* renamed from: b  reason: collision with other method in class */
    public void m1029b(boolean z) {
        this.f622a.set(1, z);
    }

    /* renamed from: b  reason: collision with other method in class */
    public boolean m1030b() {
        return this.f623a;
    }

    public boolean c() {
        return this.f622a.get(0);
    }

    public boolean d() {
        return this.f622a.get(1);
    }

    public boolean e() {
        return this.f621a != null;
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof Cif)) {
            return m1027a((Cif) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f620a != null;
    }

    public boolean g() {
        return this.f624b != null;
    }

    public boolean h() {
        return this.f619a != null;
    }

    public int hashCode() {
        return 0;
    }

    public boolean i() {
        return this.f618a != null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("XmPushActionContainer(");
        sb.append("action:");
        hj hjVar = this.f617a;
        if (hjVar == null) {
            sb.append("null");
        } else {
            sb.append(hjVar);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("encryptAction:");
        sb.append(this.f623a);
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("isRequest:");
        sb.append(this.f625b);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("appid:");
            String str = this.f620a;
            if (str == null) {
                sb.append("null");
            } else {
                sb.append(str);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("packageName:");
            String str2 = this.f624b;
            if (str2 == null) {
                sb.append("null");
            } else {
                sb.append(str2);
            }
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("target:");
        hy hyVar = this.f619a;
        if (hyVar == null) {
            sb.append("null");
        } else {
            sb.append(hyVar);
        }
        if (i()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("metaInfo:");
            hw hwVar = this.f618a;
            if (hwVar == null) {
                sb.append("null");
            } else {
                sb.append(hwVar);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
