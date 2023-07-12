package com.xiaomi.push;

import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.io.Serializable;
import java.util.BitSet;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ib implements iu<ib, Object>, Serializable, Cloneable {

    /* renamed from: a  reason: collision with other field name */
    public int f587a;

    /* renamed from: a  reason: collision with other field name */
    private BitSet f588a = new BitSet(2);

    /* renamed from: b  reason: collision with other field name */
    public int f589b;

    /* renamed from: a  reason: collision with other field name */
    private static final jk f586a = new jk("XmPushActionCheckClientInfo");
    private static final jc a = new jc("", (byte) 8, 1);
    private static final jc b = new jc("", (byte) 8, 2);

    @Override // java.lang.Comparable
    /* renamed from: a */
    public int compareTo(ib ibVar) {
        int a2;
        int a3;
        if (getClass().equals(ibVar.getClass())) {
            int compareTo = Boolean.valueOf(m1008a()).compareTo(Boolean.valueOf(ibVar.m1008a()));
            if (compareTo != 0) {
                return compareTo;
            }
            if (!m1008a() || (a3 = iv.a(this.f587a, ibVar.f587a)) == 0) {
                int compareTo2 = Boolean.valueOf(b()).compareTo(Boolean.valueOf(ibVar.b()));
                if (compareTo2 != 0) {
                    return compareTo2;
                }
                if (!b() || (a2 = iv.a(this.f589b, ibVar.f589b)) == 0) {
                    return 0;
                }
                return a2;
            }
            return a3;
        }
        return getClass().getName().compareTo(ibVar.getClass().getName());
    }

    public ib a(int i) {
        this.f587a = i;
        a(true);
        return this;
    }

    public void a() {
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
            if (s != 1) {
                if (s == 2 && b2 == 8) {
                    this.f589b = jfVar.mo1100a();
                    b(true);
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            } else {
                if (b2 == 8) {
                    this.f587a = jfVar.mo1100a();
                    a(true);
                    jfVar.g();
                }
                ji.a(jfVar, b2);
                jfVar.g();
            }
        }
        jfVar.f();
        if (!m1008a()) {
            throw new jg("Required field 'miscConfigVersion' was not found in serialized data! Struct: " + toString());
        } else if (b()) {
            a();
        } else {
            throw new jg("Required field 'pluginConfigVersion' was not found in serialized data! Struct: " + toString());
        }
    }

    public void a(boolean z) {
        this.f588a.set(0, z);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1008a() {
        return this.f588a.get(0);
    }

    /* renamed from: a  reason: collision with other method in class */
    public boolean m1009a(ib ibVar) {
        return ibVar != null && this.f587a == ibVar.f587a && this.f589b == ibVar.f589b;
    }

    public ib b(int i) {
        this.f589b = i;
        b(true);
        return this;
    }

    @Override // com.xiaomi.push.iu
    public void b(jf jfVar) {
        a();
        jfVar.a(f586a);
        jfVar.a(a);
        jfVar.mo1111a(this.f587a);
        jfVar.b();
        jfVar.a(b);
        jfVar.mo1111a(this.f589b);
        jfVar.b();
        jfVar.c();
        jfVar.mo1110a();
    }

    public void b(boolean z) {
        this.f588a.set(1, z);
    }

    public boolean b() {
        return this.f588a.get(1);
    }

    public boolean equals(Object obj) {
        if (obj != null && (obj instanceof ib)) {
            return m1009a((ib) obj);
        }
        return false;
    }

    public int hashCode() {
        return 0;
    }

    public String toString() {
        return "XmPushActionCheckClientInfo(miscConfigVersion:" + this.f587a + AVFSCacheConstants.COMMA_SEP + "pluginConfigVersion:" + this.f589b + jn1.BRACKET_END_STR;
    }
}
