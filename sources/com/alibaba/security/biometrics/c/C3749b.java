package com.alibaba.security.biometrics.c;

import android.view.View;
import com.alibaba.security.biometrics.R;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;

/* compiled from: Taobao */
/* renamed from: com.alibaba.security.biometrics.c.b */
/* loaded from: classes8.dex */
public final class C3749b {

    /* compiled from: Taobao */
    /* renamed from: com.alibaba.security.biometrics.c.b$1  reason: invalid class name */
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[ABDetectType.values().length];
            a = iArr;
            try {
                iArr[ABDetectType.BLINK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ABDetectType.BLINK_STILL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ABDetectType.MOUTH.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ABDetectType.MOUTH_STILL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ABDetectType.POS_PITCH_UP.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[ABDetectType.PITCH_STILL.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[ABDetectType.POS_PITCH_DOWN.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[ABDetectType.POS_YAW_RIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[ABDetectType.POS_YAW_LEFT.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[ABDetectType.POS_YAW.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[ABDetectType.YAW_STILL.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[ABDetectType.NONE.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    private static String a(View view, ABDetectType aBDetectType) {
        if (aBDetectType != null) {
            switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
                case 1:
                case 2:
                    return view.getResources().getString(R.string.face_detect_action_blink);
                case 3:
                case 4:
                    return view.getResources().getString(R.string.face_detect_action_mounth);
                case 5:
                case 6:
                    return view.getResources().getString(R.string.face_detect_action_raise_head);
                case 7:
                    return view.getResources().getString(R.string.face_detect_action_pitch_down_head);
                case 8:
                    return view.getResources().getString(R.string.face_detect_action_turn_right);
                case 9:
                    return view.getResources().getString(R.string.face_detect_action_turn_left);
                case 10:
                case 11:
                    return view.getResources().getString(R.string.face_detect_action_turn_right_or_left);
                case 12:
                default:
                    return "";
            }
        }
        return "";
    }

    private static int a(ABDetectType aBDetectType) {
        if (aBDetectType != null) {
            switch (AnonymousClass1.a[aBDetectType.ordinal()]) {
                case 1:
                case 2:
                    return R.C3735drawable.rp_face_guide_blink_anim;
                case 3:
                case 4:
                    return R.C3735drawable.rp_face_guide_mouth_anim;
                case 5:
                case 6:
                case 7:
                    return R.C3735drawable.rp_face_guide_pitch_anim;
                case 8:
                case 9:
                case 10:
                case 11:
                    return R.C3735drawable.rp_face_guide_yaw_anim;
                default:
                    return -1;
            }
        }
        return -1;
    }
}
