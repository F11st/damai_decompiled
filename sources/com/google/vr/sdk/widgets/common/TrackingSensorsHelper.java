package com.google.vr.sdk.widgets.common;

import android.content.pm.PackageManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class TrackingSensorsHelper {
    public static boolean enableTouchTracking;
    public static boolean pretendSensorsAreAvailableForTesting;
    public static boolean showStereoModeButtonForTesting;
    PackageManager packageManager;

    public TrackingSensorsHelper(PackageManager packageManager) {
        this.packageManager = packageManager;
    }

    public boolean areTrackingSensorsAvailable() {
        if (pretendSensorsAreAvailableForTesting) {
            return true;
        }
        return !enableTouchTracking && this.packageManager.hasSystemFeature("android.hardware.sensor.gyroscope") && this.packageManager.hasSystemFeature("android.hardware.sensor.accelerometer");
    }

    public boolean showStereoModeButtonForTesting() {
        return showStereoModeButtonForTesting;
    }
}
