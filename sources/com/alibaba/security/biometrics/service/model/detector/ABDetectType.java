package com.alibaba.security.biometrics.service.model.detector;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ABDetectType {
    NONE(0),
    BLINK(1),
    MOUTH(2),
    POS_YAW(3),
    POS_PITCH(4),
    POS_YAW_LEFT(7),
    POS_YAW_RIGHT(8),
    DONE(6),
    POS_PITCH_UP(9),
    POS_PITCH_DOWN(10),
    KEEP_STILL(11),
    MOVEMENT_3D(12),
    AIMLESS(-1),
    BLINK_STILL(21),
    MOUTH_STILL(22),
    YAW_STILL(23),
    PITCH_STILL(24);
    
    private static String[] CHINESE_NAME = {"", "请眨眼", "请张嘴", "请左右摇头", "请上下点头", "请向左摇头", "请向右摇头", "动作结束", "请向上抬头", "请向下点头", "请注视屏幕", "", "", "请眨眼", "请张嘴", "请左右摇头", "请上下点头"};
    private int value;

    ABDetectType(int i) {
        this.value = -1;
        this.value = i;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }

    public static ABDetectType valueOf(int i) {
        switch (i) {
            case -1:
                return AIMLESS;
            case 0:
                return NONE;
            case 1:
                return BLINK;
            case 2:
                return MOUTH;
            case 3:
                return POS_YAW;
            case 4:
                return POS_PITCH;
            case 5:
            default:
                return null;
            case 6:
                return DONE;
            case 7:
                return POS_YAW_LEFT;
            case 8:
                return POS_YAW_RIGHT;
            case 9:
                return POS_PITCH_UP;
            case 10:
                return POS_PITCH_DOWN;
            case 11:
                return KEEP_STILL;
            case 12:
                return MOVEMENT_3D;
        }
    }
}
