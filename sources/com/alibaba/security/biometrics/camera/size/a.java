package com.alibaba.security.biometrics.camera.size;

import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements Comparable<a> {
    public final int a;
    public final int b;

    public a(int i, int i2) {
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
    public final /* bridge */ /* synthetic */ int compareTo(a aVar) {
        a aVar2 = aVar;
        return (aVar2.a * aVar2.b) - (this.a * this.b);
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (obj instanceof a) {
            a aVar = (a) obj;
            if (this.a == aVar.a && this.b == aVar.b) {
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

    private int a(a aVar) {
        return (aVar.a * aVar.b) - (this.a * this.b);
    }
}
