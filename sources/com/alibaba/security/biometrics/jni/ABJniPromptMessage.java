package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ABJniPromptMessage {
    PROMPT_EMPTY(0),
    PROMPT_PUT_FACE_IN_REGION(1),
    PROMPT_MOVE_CLOSE(2),
    PROMPT_FACE_YAW_TOO_BIG(3),
    PROMPT_TOO_DARK(4),
    PROMPT_KEEP_STILL(5),
    PROMPT_MOVE_FAR(6),
    PROMPT_GESTURE_SMALL(7),
    PROMPT_FACE_PITCH_TOO_BIG(8),
    PROMPT_FACE_UNEVEN(9);
    
    private static String[] CHINESE_NAME = {"", "请将面部移入框内", "靠近点", "请正对屏幕", "太暗了", "请保持静止", "离远点", "动作大一点", "手机拿高点", "脸部有阴影"};
    private int value;

    ABJniPromptMessage(int i) {
        this.value = i;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }
}
