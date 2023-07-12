package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class o implements Cloneable {
    private int a;

    public o(byte[] bArr) {
        this(bArr, 0);
    }

    public byte[] a() {
        int i = this.a;
        return new byte[]{(byte) (i & 255), (byte) ((i & MotionEventCompat.ACTION_POINTER_INDEX_MASK) >> 8)};
    }

    public int b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof o) && this.a == ((o) obj).b();
    }

    public int hashCode() {
        return this.a;
    }

    public o(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.a = i2;
        this.a = i2 + (bArr[i] & 255);
    }

    public o(int i) {
        this.a = i;
    }
}
