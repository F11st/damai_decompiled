package com.alibaba.security.biometrics.c.a;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.security.biometrics.jni.ALBiometricsJni;
import com.alibaba.security.biometrics.service.common.GetCacheDataManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.common.d.d;
import com.alibaba.security.common.d.p;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import tv.cjump.jni.DeviceUtils;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class a implements b {
    private static final String a = "CommonInspector";
    private int b;
    private final Context c;

    public a(Context context) {
        this.c = context;
    }

    private boolean b(boolean z) {
        this.b = 0;
        if (!p.g()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON;
            return false;
        }
        String cpu_abi = Build.getCPU_ABI();
        if (!"armeabi-v7a".equalsIgnoreCase(cpu_abi) && !"armeabi".equalsIgnoreCase(cpu_abi) && !DeviceUtils.ABI_X86.equalsIgnoreCase(cpu_abi) && !"arm64-v8a".equalsIgnoreCase(cpu_abi)) {
            this.b = GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT;
            return false;
        } else if (!z && p.f()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86;
            return false;
        } else if (!ALBiometricsJni.isLoaded()) {
            this.b = GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL;
            return false;
        } else if (!b()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NO_CAMERA;
            return false;
        } else if (GetCacheDataManager.getInstance().getUseHwMagicWindow() && d.d(this.c)) {
            this.b = GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW;
            return false;
        } else {
            return true;
        }
    }

    @Override // com.alibaba.security.biometrics.c.a.b
    public final int a() {
        return this.b;
    }

    @Override // com.alibaba.security.biometrics.c.a.b
    public final boolean a(boolean z) {
        this.b = 0;
        if (!p.g()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_NEON;
            return false;
        }
        String cpu_abi = Build.getCPU_ABI();
        if (!"armeabi-v7a".equalsIgnoreCase(cpu_abi) && !"armeabi".equalsIgnoreCase(cpu_abi) && !DeviceUtils.ABI_X86.equalsIgnoreCase(cpu_abi) && !"arm64-v8a".equalsIgnoreCase(cpu_abi)) {
            this.b = GlobalErrorCode.ERROR_DEVICE_CPU_NOT_SUPPORT;
            return false;
        } else if (!z && p.f()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NOT_SUPPORT_X86;
            return false;
        } else if (!ALBiometricsJni.isLoaded()) {
            this.b = GlobalErrorCode.ERROR_ALGO_SO_LOAD_FAIL;
            return false;
        } else if (!b()) {
            this.b = GlobalErrorCode.ERROR_DEVICE_NO_CAMERA;
            return false;
        } else if (GetCacheDataManager.getInstance().getUseHwMagicWindow() && d.d(this.c)) {
            this.b = GlobalErrorCode.ERROR_DEVICE_HW_MAGIC_WINDOW;
            return false;
        } else {
            return true;
        }
    }

    private static boolean b() {
        Camera.CameraInfo cameraInfo;
        try {
            int numberOfCameras = Integer.parseInt(Build.VERSION.SDK) > 8 ? Camera.getNumberOfCameras() : 0;
            for (int i = 0; i < numberOfCameras; i++) {
                try {
                    cameraInfo = new Camera.CameraInfo();
                    Camera.getCameraInfo(i, cameraInfo);
                } catch (Throwable unused) {
                }
                if (cameraInfo.facing == 1) {
                    return true;
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }
}
