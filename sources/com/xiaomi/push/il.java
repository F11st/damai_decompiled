package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class il implements iu<il, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public long f701a;

    /* renamed from: a  reason: collision with other field name */
    public hy f702a;

    /* renamed from: a  reason: collision with other field name */
    public String f703a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f704a = new BitSet(1);

    /* renamed from: b  reason: collision with other field name */
    public String f705b;

    /* renamed from: c  reason: collision with other field name */
    public String f706c;

    /* renamed from: d  reason: collision with other field name */
    public String f707d;

    /* renamed from: e  reason: collision with other field name */
    public String f708e;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f700a = new jk("XmPushActionSendFeedbackResult");
    private static final jc a = new jc("", (byte) 11, 1);
    private static final jc b = new jc("", (byte) 12, 2);
    private static final jc c = new jc("", (byte) 11, 3);
    private static final jc d = new jc("", (byte) 11, 4);
    private static final jc e = new jc("", (byte) 10, 6);
    private static final jc f = new jc("", (byte) 11, 7);
    private static final jc g = new jc("", (byte) 11, 8);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(il ilVar) {
        int a2;
        int a3;
        int a4;
        int a5;
        int a6;
        int a7;
        int a8;
        if (getClass().equals(ilVar.getClass())) {
            int compareTo = Boolean.valueOf(m1058a()).compareTo(Boolean.valueOf(ilVar.m1058a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1058a() || (a8 = iv.a(this.f703a, ilVar.f703a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ilVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a7 = iv.a(this.f702a, ilVar.f702a)) == 0) {
                    int compareTo3 = Boolean.valueOf(c()).compareTo(Boolean.valueOf(ilVar.c()));
                    if (compareTo3 != 0) {
                        return compareTo3;
                    }
                    if (!c() || (a6 = iv.a(this.f705b, ilVar.f705b)) == 0) {
                        int compareTo4 = Boolean.valueOf(d()).compareTo(Boolean.valueOf(ilVar.d()));
                        if (compareTo4 != 0) {
                            return compareTo4;
                        }
                        if (!d() || (a5 = iv.a(this.f706c, ilVar.f706c)) == 0) {
                            int compareTo5 = Boolean.valueOf(e()).compareTo(Boolean.valueOf(ilVar.e()));
                            if (compareTo5 != 0) {
                                return compareTo5;
                            }
                            if (!e() || (a4 = iv.a(this.f701a, ilVar.f701a)) == 0) {
                                int compareTo6 = Boolean.valueOf(f()).compareTo(Boolean.valueOf(ilVar.f()));
                                if (compareTo6 != 0) {
                                    return compareTo6;
                                }
                                if (!f() || (a3 = iv.a(this.f707d, ilVar.f707d)) == 0) {
                                    int compareTo7 = Boolean.valueOf(g()).compareTo(Boolean.valueOf(ilVar.g()));
                                    if (compareTo7 != 0) {
                                        return compareTo7;
                                    }
                                    if (!g() || (a2 = iv.a(this.f708e, ilVar.f708e)) == 0) {
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
        return getClass().getName().compareTo(ilVar.getClass().getName());
    }

    public void a() {
        if (this.f705b == null) {
            throw new jg("Required field 'id' was not present! Struct: " + toString());
        } else if (this.f706c != null) {
        } else {
            throw new jg("Required field 'appId' was not present! Struct: " + toString());
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
                if (e()) {
                    a();
                    return;
                }
                throw new jg("Required field 'errorCode' was not found in serialized data! Struct: " + toString());
            }
            switch (mo1102a.f801a) {
                case 1:
                    if (b2 == 11) {
                        this.f703a = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 2:
                    if (b2 == 12) {
                        hy hyVar = new hy();
                        this.f702a = hyVar;
                        hyVar.a(jfVar);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 3:
                    if (b2 == 11) {
                        this.f705b = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 4:
                    if (b2 == 11) {
                        this.f706c = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 6:
                    if (b2 == 10) {
                        this.f701a = jfVar.mo1101a();
                        a(true);
                        continue;
                        jfVar.g();
                    }
                    break;
                case 7:
                    if (b2 == 11) {
                        this.f707d = jfVar.mo1107a();
                        continue;
                        jfVar.g();
                    }
                    break;
                case 8:
                    if (b2 == 11) {
                        this.f708e = jfVar.mo1107a();
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
        this.f704a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1058a() {
        return this.f703a != null;
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1059a(il ilVar) {
        if (ilVar == null) {
            return false;
        }
        boolean m1058a = m1058a();
        boolean m1058a2 = ilVar.m1058a();
        if ((m1058a || m1058a2) && !(m1058a && m1058a2 && this.f703a.equals(ilVar.f703a))) {
            return false;
        }
        boolean b2 = b();
        boolean b3 = ilVar.b();
        if ((b2 || b3) && !(b2 && b3 && this.f702a.m1000a(ilVar.f702a))) {
            return false;
        }
        boolean c2 = c();
        boolean c3 = ilVar.c();
        if ((c2 || c3) && !(c2 && c3 && this.f705b.equals(ilVar.f705b))) {
            return false;
        }
        boolean d2 = d();
        boolean d3 = ilVar.d();
        if (((d2 || d3) && !(d2 && d3 && this.f706c.equals(ilVar.f706c))) || this.f701a != ilVar.f701a) {
            return false;
        }
        boolean f2 = f();
        boolean f3 = ilVar.f();
        if ((f2 || f3) && !(f2 && f3 && this.f707d.equals(ilVar.f707d))) {
            return false;
        }
        boolean g2 = g();
        boolean g3 = ilVar.g();
        if (g2 || g3) {
            return g2 && g3 && this.f708e.equals(ilVar.f708e);
        }
        return true;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f700a);
        if (this.f703a != null && m1058a()) {
            jfVar.a(a);
            jfVar.a(this.f703a);
            jfVar.b();
        }
        if (this.f702a != null && b()) {
            jfVar.a(b);
            this.f702a.b(jfVar);
            jfVar.b();
        }
        if (this.f705b != null) {
            jfVar.a(c);
            jfVar.a(this.f705b);
            jfVar.b();
        }
        if (this.f706c != null) {
            jfVar.a(d);
            jfVar.a(this.f706c);
            jfVar.b();
        }
        jfVar.a(e);
        jfVar.a(this.f701a);
        jfVar.b();
        if (this.f707d != null && f()) {
            jfVar.a(f);
            jfVar.a(this.f707d);
            jfVar.b();
        }
        if (this.f708e != null && g()) {
            jfVar.a(g);
            jfVar.a(this.f708e);
            jfVar.b();
        }
        jfVar.c();
        jfVar.mo1110a();
    }

    public boolean b() {
        return this.f702a != null;
    }

    public boolean c() {
        return this.f705b != null;
    }

    public boolean d() {
        return this.f706c != null;
    }

    public boolean e() {
        return this.f704a.get(0);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof il)) {
            return m1059a((il) obj);
        }
        return false;
    }

    public boolean f() {
        return this.f707d != null;
    }

    public boolean g() {
        return this.f708e != null;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("XmPushActionSendFeedbackResult(");
        boolean z2 = false;
        if (m1058a()) {
            sb.append("debug:");
            String str = this.f703a;
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
            hy hyVar = this.f702a;
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
        String str2 = this.f705b;
        if (str2 == null) {
            sb.append("null");
        } else {
            sb.append(str2);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("appId:");
        String str3 = this.f706c;
        if (str3 == null) {
            sb.append("null");
        } else {
            sb.append(str3);
        }
        sb.append(AVFSCacheConstants.COMMA_SEP);
        sb.append("errorCode:");
        sb.append(this.f701a);
        if (f()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("reason:");
            String str4 = this.f707d;
            if (str4 == null) {
                sb.append("null");
            } else {
                sb.append(str4);
            }
        }
        if (g()) {
            sb.append(AVFSCacheConstants.COMMA_SEP);
            sb.append("category:");
            String str5 = this.f708e;
            if (str5 == null) {
                sb.append("null");
            } else {
                sb.append(str5);
            }
        }
        sb.append(jn1.BRACKET_END_STR);
        return sb.toString();
    }
}
