package com.tencent.open.utils;

import androidx.core.view.MotionEventCompat;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.utils.o */
/* loaded from: classes11.dex */
public final class C7128o implements Cloneable {
    private int a;

    public C7128o(byte[] bArr) {
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
        return obj != null && (obj instanceof C7128o) && this.a == ((C7128o) obj).b();
    }

    public int hashCode() {
        return this.a;
    }

    public C7128o(byte[] bArr, int i) {
        int i2 = (bArr[i + 1] << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK;
        this.a = i2;
        this.a = i2 + (bArr[i] & 255);
    }

    public C7128o(int i) {
        this.a = i;
    }
}
