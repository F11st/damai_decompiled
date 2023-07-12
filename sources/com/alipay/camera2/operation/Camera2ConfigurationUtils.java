package com.alipay.camera2.operation;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.os.Build;
import android.text.TextUtils;
import android.util.Range;
import com.alipay.camera2.Camera2Config;
import com.alipay.camera2.Camera2ParameterHelper;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.camera2.util.Camera2WhiteList;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes12.dex */
public class Camera2ConfigurationUtils {
    public static final int AF_REGION_BOX_DEFAULT_PROPORTION = 2;
    public static final float MAX_ZOOM_RATE = 0.5f;
    public static final float MIN_ZOOM_RATE = 0.0f;
    public static final String TAG = "Camera2ConfigurationUtils";
    private static int a = 2;
    private static boolean b = false;
    public static String sPipelineMode = "none";

    public static void setAfAeRegion(Camera2CharacteristicsCache camera2CharacteristicsCache, CaptureRequest.Builder builder, Point point, Rect rect, Rect rect2) {
        MPaasLogger.d(TAG, new Object[]{"setAfAeRegion sRegionBoxProportion:", Integer.valueOf(a)});
        int i = a;
        if (i > 0 && i <= 10 && rect2 != null) {
            int min = (int) (((Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(rect2)) * 0.5f) * a) / 10.0f);
            int centerX = rect.centerX();
            int centerY = rect.centerY();
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / 2;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) / 2;
            float f = (centerY - yVar) / yVar;
            int centerX2 = (int) (rect2.centerX() * (((centerX - xVar) / xVar) + 1.0f));
            int centerY2 = (int) (rect2.centerY() * (f + 1.0f));
            Rect rect3 = new Rect(centerX2 - min, centerY2 - min, centerX2 + min, centerY2 + min);
            rect3.left = Camera2Utils.clamp(rect3.left, rect2.left, rect2.right);
            rect3.top = Camera2Utils.clamp(rect3.top, rect2.top, rect2.bottom);
            rect3.right = Camera2Utils.clamp(rect3.right, rect2.left, rect2.right);
            rect3.bottom = Camera2Utils.clamp(rect3.bottom, rect2.top, rect2.bottom);
            MeteringRectangle[] meteringRectangleArr = {new MeteringRectangle(rect3, 1000)};
            boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
            int maxAfRegionNum = camera2CharacteristicsCache.getMaxAfRegionNum();
            int maxAeRegionNum = camera2CharacteristicsCache.getMaxAeRegionNum();
            boolean z = hasFocuser && maxAfRegionNum > 0;
            int intValue = ((Integer) builder.get(CaptureRequest.CONTROL_AF_MODE)).intValue();
            if (!(intValue == 2 || intValue == 1)) {
                z = z && !Camera2WhiteList.forceDisableFocusAreas();
            }
            MPaasLogger.d(TAG, new Object[]{"setAfAeRegion canSetAfRegion:", Boolean.valueOf(z)});
            if (z) {
                builder.set(CaptureRequest.CONTROL_AF_REGIONS, meteringRectangleArr);
            }
            boolean z2 = maxAeRegionNum > 0;
            if (z2) {
                builder.set(CaptureRequest.CONTROL_AE_REGIONS, meteringRectangleArr);
            }
            MPaasLogger.d(TAG, new Object[]{"setAfAeRegion canSetAfRegion:", Boolean.valueOf(z), ", canSetAeRegion:", Boolean.valueOf(z2), ", regions:", rect3});
            return;
        }
        MPaasLogger.d(TAG, new Object[]{"setAfAeRegion ignore focus areas."});
    }

    public static void setFocusDistanceSupportValue(String str) {
        MPaasLogger.d(TAG, new Object[]{"setFocusDistanceSupportValue, value:", str});
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void setPipelineMode(String str) {
        MPaasLogger.d(TAG, new Object[]{"setPipelineMode, value:", str});
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if ("fast".equalsIgnoreCase(str) || "high".equalsIgnoreCase(str)) {
            sPipelineMode = str;
        }
    }

    public static void setRegionBoxProportion(int i) {
        MPaasLogger.d(TAG, new Object[]{"setRegionBoxProportion:", Integer.valueOf(i)});
        if (i >= 0 && i <= 10) {
            a = i;
        } else {
            a = 2;
        }
    }

    public static boolean setTorchState(Camera2CharacteristicsCache camera2CharacteristicsCache, CaptureRequest.Builder builder, boolean z) {
        if (camera2CharacteristicsCache == null || builder == null || !camera2CharacteristicsCache.supportCamera2Torch()) {
            return false;
        }
        builder.set(CaptureRequest.FLASH_MODE, Integer.valueOf(z ? 2 : 0));
        return true;
    }

    public static Rect setZoom(Camera2CharacteristicsCache camera2CharacteristicsCache, CaptureRequest.Builder builder, int i) {
        MPaasLogger.d(TAG, new Object[]{"setZoom, objZoom:", Integer.valueOf(i)});
        if (camera2CharacteristicsCache == null) {
            MPaasLogger.e(TAG, new Object[]{"camera2CharacteristicsCahe is null."});
            return null;
        }
        float maxZoom = camera2CharacteristicsCache.getMaxZoom();
        Rect cropRegionForNonZoom = camera2CharacteristicsCache.getCropRegionForNonZoom();
        if (cropRegionForNonZoom == null) {
            return null;
        }
        if (maxZoom <= 1.0f) {
            return cropRegionForNonZoom;
        }
        if (i != 0) {
            int centerX = cropRegionForNonZoom.centerX();
            int centerY = cropRegionForNonZoom.centerY();
            float f = (((i * 1.0f) / 100.0f) * 0.5f * (maxZoom - 1.0f)) + 1.0f;
            MPaasLogger.d(TAG, new Object[]{"setZoom(oriRect): ", cropRegionForNonZoom.toString(), ",maxZoom:", Float.valueOf(maxZoom), ",objZoomRatio:", Float.valueOf(f)});
            int width = ((int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(cropRegionForNonZoom) / f)) / 2;
            int height = ((int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(cropRegionForNonZoom) / f)) / 2;
            cropRegionForNonZoom = new Rect(centerX - width, centerY - height, centerX + width, centerY + height);
        }
        MPaasLogger.d(TAG, new Object[]{"setZoom(objRect): " + cropRegionForNonZoom.toString()});
        builder.set(CaptureRequest.SCALER_CROP_REGION, cropRegionForNonZoom);
        return cropRegionForNonZoom;
    }

    public static void setup3AControlsLocked(Camera2CharacteristicsCache camera2CharacteristicsCache, Camera2Config camera2Config, CaptureRequest.Builder builder, int i, float f) {
        if (camera2CharacteristicsCache == null || builder == null) {
            return;
        }
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked, sSupportFocusDistance:", Boolean.valueOf(b), ", initFocusDistance:", Float.valueOf(f)});
        if (b && f >= 0.0f) {
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(f));
        }
        boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
        int[] availableAfModes = camera2CharacteristicsCache.getAvailableAfModes();
        if (hasFocuser && availableAfModes != null && availableAfModes.length > 0) {
            if (Camera2Utils.contains(availableAfModes, i)) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(i));
                MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init focus mode:", Integer.valueOf(i)});
            } else if (Camera2Utils.contains(availableAfModes, 4)) {
                builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            }
        }
        if (Camera2Utils.contains(camera2CharacteristicsCache.getAvailableAwbModes(), 1)) {
            MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init awb mode to auto."});
            builder.set(CaptureRequest.CONTROL_AWB_MODE, 1);
        }
        if (Camera2Utils.contains(camera2CharacteristicsCache.getAvailableFdModes(), 0)) {
            MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init fd mode to off."});
            builder.set(CaptureRequest.STATISTICS_FACE_DETECT_MODE, 0);
        }
        if (Camera2Utils.contains(camera2CharacteristicsCache.getAvailableLensShadingMapModes(), 0)) {
            MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init lens shading map mode to off."});
            builder.set(CaptureRequest.STATISTICS_LENS_SHADING_MAP_MODE, 0);
        }
        if (Build.VERSION.SDK_INT >= 28) {
            MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init ois data to off."});
            if (Camera2Utils.contains(camera2CharacteristicsCache.getAvailableOisDataModes(), 0)) {
                builder.set(CaptureRequest.STATISTICS_OIS_DATA_MODE, 0);
            }
        }
        if (Camera2Utils.contains(camera2CharacteristicsCache.getAvailableHotPixelMapModes(), false)) {
            builder.set(CaptureRequest.STATISTICS_HOT_PIXEL_MAP_MODE, Boolean.FALSE);
        }
        MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked init scene mode to disabled."});
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, 0);
        if (camera2Config != null) {
            Range<Integer> range = (Range) builder.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            Range<Integer> range2 = camera2Config.fpsRange;
            boolean isSessionKeys = camera2CharacteristicsCache.isSessionKeys(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
            MPaasLogger.d(TAG, new Object[]{"setup3AControlsLocked set fps range:", range2, ", defaultFpsRange:", range, ", fpsRangeIsSessionKey:", Boolean.valueOf(isSessionKeys)});
            WalletBury.addWalletBury("recordCameraFpsInfo", new Class[]{String.class, String.class, String.class}, new Object[]{String.valueOf(true), String.valueOf(range), String.valueOf(range2)});
            if (range2 != null && range2 != range && !isSessionKeys) {
                builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
            }
        }
        if (camera2CharacteristicsCache.getCropRegionForNonZoom() != null) {
            builder.set(CaptureRequest.SCALER_CROP_REGION, camera2CharacteristicsCache.getCropRegionForNonZoom());
        }
        if ("fast".equalsIgnoreCase(sPipelineMode)) {
            Camera2ParameterHelper.useFastMode(camera2CharacteristicsCache, builder);
        } else if ("high".equalsIgnoreCase(sPipelineMode)) {
            Camera2ParameterHelper.useHighQualityMode(camera2CharacteristicsCache, builder);
        }
    }
}
