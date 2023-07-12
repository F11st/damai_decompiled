package com.alibaba.security.biometrics.camera.size;

import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.camera.size.a */
/* loaded from: classes8.dex */
public final class C3766a implements Comparable<C3766a> {
    public final int a;
    public final int b;

    public C3766a(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    private int a() {
        return this.a;
    }

    private int b() {
        return this.b;
    }

    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(C3766a c3766a) {
        C3766a c3766a2 = c3766a;
        return (c3766a2.a * c3766a2.b) - (this.a * this.b);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof C3766a) {
            C3766a c3766a = (C3766a) obj;
            if (this.a == c3766a.a && this.b == c3766a.b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.b;
        int i2 = this.a;
        return i ^ ((i2 >>> 16) | (i2 << 16));
    }

    public final String toString() {
        return this.a + Constants.Name.X + this.b;
    }

    private int a(C3766a c3766a) {
        return (c3766a.a * c3766a.b) - (this.a * this.b);
    }
}
