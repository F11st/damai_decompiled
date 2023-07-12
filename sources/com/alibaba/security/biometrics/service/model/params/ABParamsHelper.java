package com.alibaba.security.biometrics.service.model.params;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.util.params.ParamsHelper;
import com.alibaba.security.common.c.C3800a;
import com.alibaba.security.common.d.C3822o;
import mtopsdk.common.util.SymbolExpUtil;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABParamsHelper extends ParamsHelper<ALBiometricsParams> implements ALBiometricsKeys {
    private static final String TAG = "ABParamsHelper";

    public ABParamsHelper(Bundle bundle) {
        super(bundle);
        initDefaults(bundle);
    }

    private void initBiometricsConfig(Bundle bundle) {
        ALBiometricsParams aLBiometricsParams;
        BiometricsConfig biometricsConfig;
        if (bundle == null || bundle.getString(ALBiometricsKeys.KEY_BIOMETRICS_CONFIG) == null || (aLBiometricsParams = (ALBiometricsParams) getParams()) == null || (biometricsConfig = aLBiometricsParams.biometricsConfig) == null) {
            return;
        }
        int i = biometricsConfig.adjustStep;
        if (i >= 0) {
            setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.valueOf(i == 1));
        }
        int i2 = biometricsConfig.actionCount;
        if (i2 >= 0) {
            setParam(ALBiometricsKeys.KEY_ACTION_COUNT, Integer.valueOf(i2));
        }
        String str = biometricsConfig.actions;
        if (str != null) {
            try {
                String[] split = str.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                int[] iArr = new int[split.length];
                for (int i3 = 0; i3 < split.length; i3++) {
                    iArr[i3] = Integer.parseInt(split[i3]);
                }
                setParam("strategy", iArr);
            } catch (Throwable unused) {
                C3800a.b();
            }
        }
        int i4 = biometricsConfig.lessImageMode;
        if (i4 >= 0) {
            setParam(ALBiometricsKeys.KEY_LESS_IMAGE_MODE, Boolean.valueOf(i4 == 1));
        }
        int i5 = biometricsConfig.bigImageSize;
        if (i5 >= 0) {
            setParam(ALBiometricsKeys.KEY_BIG_IMAGE_SIZE, Integer.valueOf(i5));
        }
        int i6 = biometricsConfig.detectWrongAction;
        if (i6 >= 0) {
            setParam(ALBiometricsKeys.KEY_DETECT_WRONG_ACTION, Boolean.valueOf(i6 == 1));
        }
        int i7 = biometricsConfig.detectOcclusion;
        if (i7 >= 0) {
            setParam(ALBiometricsKeys.KEY_DETECT_OCCLUSION, Boolean.valueOf(i7 == 1));
        }
        int i8 = biometricsConfig.imageCount;
        if (i8 >= 0) {
            setParam(ALBiometricsKeys.KEY_IMG_COUNT, Integer.valueOf(i8));
        }
        int i9 = biometricsConfig.imageIntervals;
        if (i9 >= 0) {
            setParam(ALBiometricsKeys.KEY_IMG_INTERVALS, Integer.valueOf(i9));
        }
        int i10 = biometricsConfig.enableRecap;
        if (i10 >= 0) {
            setParam(ALBiometricsKeys.KEY_RECAP_ENABLE, Boolean.valueOf(i10 == 1));
        }
        int i11 = biometricsConfig.recapMode;
        if (i11 >= 0) {
            setParam(ALBiometricsKeys.KEY_RECAP_MODE, Integer.valueOf(i11));
        }
        float f = biometricsConfig.recapThreshold;
        if (f > -1.0f) {
            setParam("recapThreshold", Float.valueOf(f));
        }
        String str2 = biometricsConfig.recognizeTargetData;
        String str3 = (str2 == null && (str2 = biometricsConfig.recognizeTemplateFeature) == null) ? null : str2;
        if (str3 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_TARGET_DATA, C3822o.a(str3));
            } catch (Throwable unused2) {
                C3800a.b();
            }
        }
        int i12 = biometricsConfig.displayWaitingView;
        if (i12 >= 0) {
            setParam(ALBiometricsKeys.KEY_NEED_DISPLAY_WAITING_VIEW, Boolean.valueOf(i12 == 1));
        }
        int i13 = biometricsConfig.reflectILThreshold;
        if (i13 >= 0) {
            setParam(ALBiometricsKeys.KEY_REFLECT_IL_THRESHOLD, Integer.valueOf(i13));
        }
        float f2 = biometricsConfig.reflectDistanceThreshold;
        if (f2 > -1.0f) {
            setParam(ALBiometricsKeys.KEY_REFLECT_DISTANCE_THRESHOLD, Float.valueOf(f2));
        }
        int i14 = biometricsConfig.reflectPrevFailThreshold;
        if (i14 >= 0) {
            setParam(ALBiometricsKeys.KEY_REFLECT_PREV_FAIL_THRESHOLD, Integer.valueOf(i14));
        }
        int i15 = biometricsConfig.actionWhileCheckFail;
        if (i15 >= 0) {
            setParam("actionWhileCheckFail", Integer.valueOf(i15));
        }
        String str4 = biometricsConfig.strategyWhileCheckFail;
        if (str4 != null) {
            try {
                String[] split2 = str4.split(SymbolExpUtil.SYMBOL_VERTICALBAR);
                int[] iArr2 = new int[split2.length];
                for (int i16 = 0; i16 < split2.length; i16++) {
                    iArr2[i16] = Integer.parseInt(split2[i16]);
                }
                setParam("strategyWhileCheckFail", iArr2);
            } catch (Throwable unused3) {
                C3800a.b();
            }
        }
        int i17 = biometricsConfig.bgDetectTimeIntervals;
        if (i17 >= 0) {
            setParam(ALBiometricsKeys.KEY_BG_DETECT_TIME_INTERVALS, Integer.valueOf(i17));
        }
        int i18 = biometricsConfig.bgDetectColorThreshold;
        if (i18 >= 0) {
            setParam(ALBiometricsKeys.KEY_BG_DETECT_COLOR_THRESHOLD, Integer.valueOf(i18));
        }
        int i19 = biometricsConfig.needSuccessVideo;
        if (i19 >= 0) {
            setParam("needSuccessVideo", Boolean.valueOf(i19 == 1));
        }
        int i20 = biometricsConfig.needFailVideo;
        if (i20 >= 0) {
            setParam("needFailVideo", Boolean.valueOf(i20 == 1));
        }
        String str5 = biometricsConfig.licenseData;
        if (str5 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_LICENSE_DATA, C3822o.a(str5));
            } catch (Throwable unused4) {
                C3800a.b();
            }
        }
        String str6 = biometricsConfig.licenseTimeData;
        if (str6 != null) {
            try {
                setParam(ALBiometricsKeys.KEY_LICENSE_TIME_DATA, C3822o.a(str6));
            } catch (Throwable unused5) {
                C3800a.b();
            }
        }
    }

    private void initDefaults(Bundle bundle) {
        if (bundle == null) {
            return;
        }
        ALBiometricsParams params = getParams();
        int i = params.actionCount;
        if (i == 1) {
            if (!bundle.containsKey(ALBiometricsKeys.KEY_STEP_ADJUST)) {
                setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.FALSE);
            }
        } else if (i == 0) {
            setParam(ALBiometricsKeys.KEY_STEP_ADJUST, Boolean.TRUE);
        }
        if (!bundle.containsKey(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE)) {
            if (params.actionCount > 0) {
                setParam(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE, Boolean.TRUE);
            } else {
                setParam(ALBiometricsKeys.KEY_FACE_IMG_CHECK_ENABLE, Boolean.FALSE);
            }
        }
        if (!bundle.containsKey(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY)) {
            if (params.actionCount > 0) {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY, Boolean.TRUE);
            } else {
                setParam(ALBiometricsKeys.KEY_FACE_RECOGNIZE_RETRY, Boolean.FALSE);
            }
        }
        initBiometricsConfig(bundle);
    }
}
