package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ABJniDetectState {
    DETECT_STATE_DETECTING(0),
    DETECT_STATE_SUC(1),
    DETECT_STATE_FAIL(2);
    
    private static String[] CHINESE_NAME = {"", "通过", "失败"};
    private int value;

    ABJniDetectState(int i) {
        this.value = i;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }
}
