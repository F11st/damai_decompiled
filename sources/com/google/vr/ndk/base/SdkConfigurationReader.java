package com.google.vr.ndk.base;

import android.content.Context;
import android.util.Log;
import com.google.common.logging.nano.Vr$VREvent;
import com.google.vr.cardboard.VrParamsProvider;
import com.google.vr.vrcore.nano.C5450a;
import tb.az2;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SdkConfigurationReader {
    public static final Vr$VREvent.SdkConfigurationParams DEFAULT_PARAMS;
    static final Vr$VREvent.SdkConfigurationParams REQUESTED_PARAMS;
    static Vr$VREvent.SdkConfigurationParams sParams;

    static {
        Vr$VREvent.SdkConfigurationParams sdkConfigurationParams = new Vr$VREvent.SdkConfigurationParams();
        REQUESTED_PARAMS = sdkConfigurationParams;
        Boolean bool = Boolean.TRUE;
        sdkConfigurationParams.useSystemClockForSensorTimestamps = bool;
        sdkConfigurationParams.useMagnetometerInSensorFusion = bool;
        sdkConfigurationParams.allowDynamicLibraryLoading = bool;
        sdkConfigurationParams.cpuLateLatchingEnabled = bool;
        sdkConfigurationParams.daydreamImageAlignment = 1;
        sdkConfigurationParams.asyncReprojectionConfig = new Vr$VREvent.SdkConfigurationParams.AsyncReprojectionConfig();
        sdkConfigurationParams.useOnlineMagnetometerCalibration = bool;
        sdkConfigurationParams.useDeviceIdleDetection = bool;
        sdkConfigurationParams.allowDynamicJavaLibraryLoading = bool;
        sdkConfigurationParams.touchOverlayEnabled = bool;
        sdkConfigurationParams.enableForcedTrackingCompat = bool;
        sdkConfigurationParams.allowVrcoreHeadTracking = bool;
        sdkConfigurationParams.allowVrcoreCompositing = bool;
        Vr$VREvent.SdkConfigurationParams sdkConfigurationParams2 = new Vr$VREvent.SdkConfigurationParams();
        DEFAULT_PARAMS = sdkConfigurationParams2;
        Boolean bool2 = Boolean.FALSE;
        sdkConfigurationParams2.useSystemClockForSensorTimestamps = bool2;
        sdkConfigurationParams2.useMagnetometerInSensorFusion = bool2;
        sdkConfigurationParams2.allowDynamicLibraryLoading = bool2;
        sdkConfigurationParams2.cpuLateLatchingEnabled = bool2;
        sdkConfigurationParams2.daydreamImageAlignment = 3;
        sdkConfigurationParams2.asyncReprojectionConfig = null;
        sdkConfigurationParams2.useOnlineMagnetometerCalibration = bool2;
        sdkConfigurationParams2.useDeviceIdleDetection = bool2;
        sdkConfigurationParams2.allowDynamicJavaLibraryLoading = bool2;
        sdkConfigurationParams2.touchOverlayEnabled = bool2;
        sdkConfigurationParams2.enableForcedTrackingCompat = bool2;
        sdkConfigurationParams2.allowVrcoreHeadTracking = bool2;
        sdkConfigurationParams2.allowVrcoreCompositing = bool2;
    }

    public static Vr$VREvent.SdkConfigurationParams getParams(Context context) {
        synchronized (SdkConfigurationReader.class) {
            Vr$VREvent.SdkConfigurationParams sdkConfigurationParams = sParams;
            if (sdkConfigurationParams != null) {
                return sdkConfigurationParams;
            }
            VrParamsProvider a = az2.a(context);
            Vr$VREvent.SdkConfigurationParams readParamsFromProvider = readParamsFromProvider(a);
            synchronized (SdkConfigurationReader.class) {
                sParams = readParamsFromProvider;
            }
            a.close();
            return sParams;
        }
    }

    private static Vr$VREvent.SdkConfigurationParams readParamsFromProvider(VrParamsProvider vrParamsProvider) {
        Vr$VREvent.SdkConfigurationParams readSdkConfigurationParams = vrParamsProvider.readSdkConfigurationParams(new C5450a());
        if (readSdkConfigurationParams == null) {
            Log.w("SdkConfigurationReader", "VrParamsProvider returned null params, using defaults.");
            return DEFAULT_PARAMS;
        }
        String valueOf = String.valueOf(readSdkConfigurationParams);
        StringBuilder sb = new StringBuilder(valueOf.length() + 38);
        sb.append("Fetched params from VrParamsProvider: ");
        sb.append(valueOf);
        Log.d("SdkConfigurationReader", sb.toString());
        return readSdkConfigurationParams;
    }
}
