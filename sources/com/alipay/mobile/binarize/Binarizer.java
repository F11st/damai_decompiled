package com.alipay.mobile.binarize;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public abstract class Binarizer {
    private boolean a;

    public void destroy() {
        this.a = false;
    }

    public abstract BinarizeResult getBinarizedData(byte[] bArr);

    public void initialize(int i, int i2) {
        this.a = true;
    }

    public boolean isInitialized() {
        return this.a;
    }

    public void setInitialized(boolean z) {
        this.a = z;
    }
}
