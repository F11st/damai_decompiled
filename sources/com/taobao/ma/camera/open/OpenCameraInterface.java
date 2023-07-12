package com.taobao.ma.camera.open;

import android.hardware.Camera;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;
    private static final String TAG = "com.taobao.ma.camera.open.OpenCameraInterface";

    private OpenCameraInterface() {
    }

    public static Camera open(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(TAG, "No cameras!");
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
            String str = TAG;
            Log.i(str, "Opening camera #" + i);
            return Camera.open(i);
        } else if (z) {
            String str2 = TAG;
            Log.w(str2, "Requested camera does not exist: " + i);
            return null;
        } else {
            Log.i(TAG, "No camera facing back; returning camera #0");
            return Camera.open(0);
        }
    }
}
