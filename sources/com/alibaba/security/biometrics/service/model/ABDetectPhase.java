package com.alibaba.security.biometrics.service.model;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ABDetectPhase {
    INIT(0),
    ADJUST_BEGIN(1),
    ADJUST_END(2),
    ACTION_BEGIN(3),
    ACTION_END(4),
    FACE_DETECT(100),
    FINISH(10000);
    
    private int value;

    ABDetectPhase(int i) {
        this.value = -1;
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }
}
