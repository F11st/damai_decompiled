package com.alipay.camera2;

import android.annotation.TargetApi;
import android.hardware.camera2.CaptureRequest;
import android.os.Build;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.mobile.bqcscanservice.MPaasLogger;

/* compiled from: Taobao */
@TargetApi(26)
/* loaded from: classes12.dex */
public class Camera2ParameterHelper {
    public static void useFastMode(Camera2CharacteristicsCache camera2CharacteristicsCache, CaptureRequest.Builder builder) {
        MPaasLogger.d("Camera2ParameterHelper", new Object[]{"useFastMode"});
        if (camera2CharacteristicsCache == null || builder == null) {
            return;
        }
        try {
            if (camera2CharacteristicsCache.isHotPixelSupport() && camera2CharacteristicsCache.isSupportHotPixelMode(1)) {
                builder.set(CaptureRequest.HOT_PIXEL_MODE, 1);
            }
            if (camera2CharacteristicsCache.isEdgeSupport() && camera2CharacteristicsCache.isSupportEdgeMode(1)) {
                builder.set(CaptureRequest.EDGE_MODE, 1);
            }
            if (camera2CharacteristicsCache.isToneMapSupport() && camera2CharacteristicsCache.isSupportToneMapMode(1)) {
                builder.set(CaptureRequest.TONEMAP_MODE, 1);
            }
            if (camera2CharacteristicsCache.isNoiseReductionSupport() && camera2CharacteristicsCache.isSupportNoiseReductionMode(1)) {
                builder.set(CaptureRequest.NOISE_REDUCTION_MODE, 1);
            }
            if (camera2CharacteristicsCache.isShadingSupport() && camera2CharacteristicsCache.isSupportShadingMode(1)) {
                builder.set(CaptureRequest.SHADING_MODE, 1);
            }
            if (Build.VERSION.SDK_INT >= 28 && camera2CharacteristicsCache.isDistortionCorrectionSupport() && camera2CharacteristicsCache.isSupportDistortionCorrectionMode(1)) {
                builder.set(CaptureRequest.DISTORTION_CORRECTION_MODE, 1);
            }
        } catch (Throwable th) {
            MPaasLogger.e("Camera2ParameterHelper", new Object[]{"useFastMode with exception:" + th.toString()});
        }
    }

    public static void useHighQualityMode(Camera2CharacteristicsCache camera2CharacteristicsCache, CaptureRequest.Builder builder) {
        MPaasLogger.d("Camera2ParameterHelper", new Object[]{"useHighQualityMode"});
        if (camera2CharacteristicsCache == null || builder == null) {
            return;
        }
        try {
            if (camera2CharacteristicsCache.isHotPixelSupport() && camera2CharacteristicsCache.isSupportHotPixelMode(2)) {
                builder.set(CaptureRequest.HOT_PIXEL_MODE, 2);
            }
            if (camera2CharacteristicsCache.isEdgeSupport() && camera2CharacteristicsCache.isSupportEdgeMode(2)) {
                builder.set(CaptureRequest.EDGE_MODE, 2);
            }
            if (camera2CharacteristicsCache.isToneMapSupport() && camera2CharacteristicsCache.isSupportToneMapMode(2)) {
                builder.set(CaptureRequest.TONEMAP_MODE, 2);
            }
            if (camera2CharacteristicsCache.isNoiseReductionSupport() && camera2CharacteristicsCache.isSupportNoiseReductionMode(2)) {
                builder.set(CaptureRequest.NOISE_REDUCTION_MODE, 2);
            }
            if (camera2CharacteristicsCache.isShadingSupport() && camera2CharacteristicsCache.isSupportShadingMode(2)) {
                builder.set(CaptureRequest.SHADING_MODE, 2);
            }
            if (Build.VERSION.SDK_INT >= 28 && camera2CharacteristicsCache.isDistortionCorrectionSupport() && camera2CharacteristicsCache.isSupportDistortionCorrectionMode(2)) {
                builder.set(CaptureRequest.DISTORTION_CORRECTION_MODE, 2);
            }
        } catch (Throwable th) {
            MPaasLogger.e("Camera2ParameterHelper", new Object[]{"useHighQualityMode with exception:" + th.toString()});
        }
    }
}
