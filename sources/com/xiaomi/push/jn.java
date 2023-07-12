package com.xiaomi.push;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class jn extends jp {
    private int a;

    /* renamed from: a  reason: collision with other field name */
    private ix f806a;

    public jn(int i) {
        this.f806a = new ix(i);
    }

    @Override // com.xiaomi.push.jp
    public int a(byte[] bArr, int i, int i2) {
        byte[] m1090a = this.f806a.m1090a();
        if (i2 > this.f806a.a() - this.a) {
            i2 = this.f806a.a() - this.a;
        }
        if (i2 > 0) {
            System.arraycopy(m1090a, this.a, bArr, i, i2);
            this.a += i2;
        }
        return i2;
    }

    @Override // com.xiaomi.push.jp
    /* renamed from: a */
    public void mo1113a(byte[] bArr, int i, int i2) {
        this.f806a.write(bArr, i, i2);
    }

    public int a_() {
        return this.f806a.size();
    }
}
