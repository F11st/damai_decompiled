package com.tencent.open.utils;

/* compiled from: Taobao */
/* renamed from: com.tencent.open.utils.n */
/* loaded from: classes11.dex */
public final class C7127n implements Cloneable {
    private long a;

    public C7127n(long j) {
        this.a = j;
    }

    public byte[] a() {
        long j = this.a;
        return new byte[]{(byte) (255 & j), (byte) ((65280 & j) >> 8), (byte) ((16711680 & j) >> 16), (byte) ((j & 4278190080L) >> 24)};
    }

    public long b() {
        return this.a;
    }

    public boolean equals(Object obj) {
        return obj != null && (obj instanceof C7127n) && this.a == ((C7127n) obj).b();
    }

    public int hashCode() {
        return (int) this.a;
    }
}
