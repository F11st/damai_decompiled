package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class jo extends jp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private byte[] f807a;
    private int b;

    @Override // com.xiaomi.push.jp
    public int a() {
        return this.a;
    }

    @Override // com.xiaomi.push.jp
    public int a(byte[] bArr, int i, int i2) {
        int b = b();
        if (i2 > b) {
            i2 = b;
        }
        if (i2 > 0) {
            System.arraycopy(this.f807a, this.a, bArr, i, i2);
            a(i2);
        }
        return i2;
    }

    @Override // com.xiaomi.push.jp
    public void a(int i) {
        this.a += i;
    }

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.jp
    /* renamed from: a */
    public void mo1113a(byte[] bArr, int i, int i2) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.jp
    /* renamed from: a  reason: collision with other method in class */
    public byte[] mo1114a() {
        return this.f807a;
    }

    @Override // com.xiaomi.push.jp
    public int b() {
        return this.b - this.a;
    }

    public void b(byte[] bArr, int i, int i2) {
        this.f807a = bArr;
        this.a = i;
        this.b = i + i2;
    }
}
