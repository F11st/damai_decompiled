package com.alipay.performance;

import android.text.TextUtils;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.performance.memory.ScanMemoryMonitor;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ScanPerformanceConfig {
    public static final String KEY_DOWN_GRADE_CAMERA_PARAMS = "down_grade_camera_params";
    public static final String KEY_ENABLE_CAMERA_HIGH_QUALITY = "enable_camera_high_quality";
    public static final String KEY_FORCE_ENABLE_DOWN_GRADE_CAMERA_PARAMS = "force_enable_down_grade_camera_params";
    private static boolean a = false;
    private static boolean b = false;
    private static boolean c = false;
    private static float d = -1.0f;
    private static float e = -1.0f;
    private static long f = -1;
    private static boolean g;

    private static boolean a() {
        MPaasLogger.d("ScanPerformanceConfig", new Object[]{"isLowLevelDevice, sTotalMemoryGB:", Float.valueOf(d), ", sCpuMaxFrequencyGHz:", Float.valueOf(e), ", sNumCpuCores:", Long.valueOf(f)});
        float f2 = d;
        if (f2 >= 0.0f && e >= 0.0f) {
            long j = f;
            if (j >= 0) {
                if (f2 <= 2.0f) {
                    return true;
                }
                if (f2 <= 4.0f && j <= 4) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean needCameraHighQuality() {
        MPaasLogger.d("ScanPerformanceConfig", new Object[]{"needCameraHighQuality:", Boolean.valueOf(b)});
        return (!b || needDowngradeCameraParams() || ScanMemoryMonitor.inLowMemory()) ? false : true;
    }

    public static boolean needDowngradeCameraParams() {
        MPaasLogger.d("ScanPerformanceConfig", new Object[]{"needDowngradeCameraParams, sForceEnableDowngradeCameraParams:", Boolean.valueOf(c), ", sEnableDowngradeCameraParams:", Boolean.valueOf(a), ", sRuntimeNeedDowngrade:", Boolean.valueOf(g)});
        if (c) {
            return true;
        }
        if (a) {
            return g || a() || ScanMemoryMonitor.inLowMemory();
        }
        return false;
    }

    public static boolean needGetDeviceInfo() {
        return b || a;
    }

    public static void setEnableCameraHighQuality(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        b = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void setEnableDowngradeCameraParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        a = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void setForceEnableDowngradeCameraParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        c = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void setHwDeviceInfo(long j, int i, int i2) {
        d = ((((float) j) / 1024.0f) / 1024.0f) / 1024.0f;
        e = (i / 1024.0f) / 1024.0f;
        f = i2;
    }

    public static void updateRuntimeNeedDowngrade(boolean z) {
        MPaasLogger.d("ScanPerformanceConfig", new Object[]{"updateRuntimeNeedDowngrade:", Boolean.valueOf(z)});
        g = z;
    }
}
