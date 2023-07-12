package com.alibaba.security.realidentity.b;

import android.hardware.Camera;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class c {
    public static final int a = -1;
    private static final String b = "com.alibaba.security.realidentity.b.c";

    private c() {
    }

    public static Camera a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            com.alibaba.security.common.c.a.e(b, "No cameras!");
            return null;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        if (i < numberOfCameras) {
            com.alibaba.security.common.c.a.b(b, "Opening camera #".concat(String.valueOf(i)));
            return Camera.open(i);
        } else if (z) {
            com.alibaba.security.common.c.a.e(b, "Requested camera does not exist: ".concat(String.valueOf(i)));
            return null;
        } else {
            com.alibaba.security.common.c.a.b(b, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
    }
}
