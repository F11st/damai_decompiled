package com.alibaba.verificationsdk.ui;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum VerifyType {
    SMS(1),
    CALL(2),
    NOCAPTCHA(3),
    MAIL(4),
    SHAKING(5),
    TILTBALL(6),
    LIVENESS(7);
    
    private int value;

    VerifyType(int i) {
        this.value = i;
    }

    public int getValue() {
        return this.value;
    }
}
