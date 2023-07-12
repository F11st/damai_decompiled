package com.alibaba.security.biometrics.jni;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public enum ABJniFailReason {
    FAIL_NONE(0),
    FAIL_NO_FACE_DETECT(20),
    FAIL_STILL_TIMEOUT(21),
    FAIL_ACTION_PITCH_GET_YAW(22),
    FAIL_ACTION_PITCH_GET_MOUTH(23),
    FAIL_ACTION_PITCH_TIMEOUT(24),
    FAIL_ACTION_PITCH_NOT_3D(25),
    FAIL_ACTION_PITCH_FACE_DISAPPEAR(26),
    FAIL_ACTION_PITCH_FACE_CHANGE(27),
    FAIL_ACTION_YAW_GET_PITCH(28),
    FAIL_ACTION_YAW_GET_MOUTH(29),
    FAIL_ACTION_YAW_TIMEOUT(30),
    FAIL_ACTION_YAW_NOT_3D(31),
    FAIL_ACTION_YAW_FACE_DISAPPEAR(32),
    FAIL_ACTION_YAW_FACE_CHANGE(33),
    FAIL_ACTION_MOUTH_GET_PITCH(34),
    FAIL_ACTION_MOUTH_GET_YAW(35),
    FAIL_ACTION_MOUTH_TIMEOUT(36),
    FAIL_ACTION_MOUTH_OCCLUSION(37),
    FAIL_ACTION_MOUTH_FACE_DISAPPEAR(38),
    FAIL_ACTION_MOUTH_FACE_CHANGE(39),
    FAIL_ACTION_BLINK_GET_PITCH(40),
    FAIL_ACTION_BLINK_GET_YAW(41),
    FAIL_ACTION_BLINK_GET_MOUTH(42),
    FAIL_ACTION_BLINK_TIMEOUT(43),
    FAIL_ACTION_BLINK_OCCLUSION(44),
    FAIL_ACTION_BLINK_FACE_DISAPPEAR(45),
    FAIL_ACTION_BLINK_FACE_CHANGE(46),
    FAIL_STILL_OUT_OF_REGION(47),
    FAIL_STILL_TOO_SMALL(48),
    FAIL_STILL_TOO_BIG(49),
    FAIL_STILL_NOT_STILL(50),
    FAIL_STILL_TOO_DARK(51),
    FAIL_STILL_LIGHT_UNEVEN(52),
    FAIL_STILL_PITCH_TOO_BIG(53),
    FAIL_STILL_YAW_TOO_BIG(54),
    FAIL_ACTION_PITCH_STILL_NO_IMAGE(55),
    FAIL_ACTION_YAW_STILL_NO_IMAGE(56),
    FAIL_ACTION_MOUTH_STILL_NO_IMAGE(57),
    FAIL_ACTION_BLINK_STILL_NO_IMAGE(58);
    
    private static String[] CHINESE_NAME = {"", "凝视时未检测到人脸", "凝视超时", "抬头时检测到摇头", "抬头时检测到张嘴", "抬头超时", "抬头时3D检测失败", "抬头时未检测到人脸", "抬头时人脸识别失败", "摇头时检测到抬头", "摇头时检测到张嘴", "摇头超时", "摇头时3D检测失败", "摇头时未检测到人脸", "摇头时人脸识别失败", "张嘴时检测到抬头", "张嘴时检测到摇头", "张嘴超时", "张嘴时发生遮挡", "张嘴时未检测到人脸", "张嘴时人脸识别失败", "眨眼时检测到抬头", "眨眼时检测到摇头", "眨眼时检测到张嘴", "眨眼超时", "眨眼时发生遮挡", "眨眼时未检测到人脸", "眨眼时人脸识别失败", "凝视时人脸在边框外", "凝视时人脸太小", "凝视时人脸太大", "凝视时非静止", "凝视时太暗", "凝视时脸部有阴影", "凝视时在抬头", "凝视时在侧脸", "抬头凝视无可用图像", "摇头凝视无可用图像", "张嘴凝视无可用图像", "眨眼凝视无可用图像"};
    private int value;

    ABJniFailReason(int i) {
        this.value = i;
    }

    public final String getMessage() {
        return CHINESE_NAME[ordinal()];
    }

    public final int getValue() {
        return this.value;
    }

    public static ABJniFailReason valueOf(int i) {
        return i < 20 ? FAIL_NONE : values()[i - 19];
    }
}
