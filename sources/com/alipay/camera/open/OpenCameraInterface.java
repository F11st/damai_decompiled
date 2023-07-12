package com.alipay.camera.open;

import android.hardware.Camera;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.base.CameraConfig;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class OpenCameraInterface {
    public static final int NO_REQUESTED_CAMERA = -1;
    private static boolean a = false;
    public static int sCameraId = -1;
    public static int sCameraIdBackup = -1;

    private OpenCameraInterface() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v0 */
    /* JADX WARN: Type inference failed for: r8v1 */
    /* JADX WARN: Type inference failed for: r8v10 */
    /* JADX WARN: Type inference failed for: r8v11 */
    /* JADX WARN: Type inference failed for: r8v12 */
    /* JADX WARN: Type inference failed for: r8v2, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r8v9 */
    public static AntCamera open(int i, boolean z) throws RuntimeException {
        if (a && !z && i == 0) {
            Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
            AntCamera.getCameraInfo(0, cameraInfo, "Scan");
            if (cameraInfo.facing == i) {
                CameraConfig build = new CameraConfig.Builder("Scan").setCameraId(0).build();
                SystraceWrapper.beginTrace("openCamera");
                AntCamera openOptimized = AntCamera.openOptimized(build);
                SystraceWrapper.endTrace();
                if (openOptimized != null) {
                    return openOptimized;
                }
                throw new RuntimeException("openCamera is failed and camera is null");
            }
        }
        int numberOfCameras = AntCamera.getNumberOfCameras("Scan");
        if (numberOfCameras > 0) {
            int i2 = 0;
            ?? r8 = 0;
            while (true) {
                if (i2 >= numberOfCameras) {
                    break;
                }
                Camera.CameraInfo cameraInfo2 = new Camera.CameraInfo();
                AntCamera.getCameraInfo(i2, cameraInfo2, "Scan");
                int i3 = cameraInfo2.facing;
                r8 = r8;
                if (i3 == 1) {
                    r8 = 1;
                }
                if (i3 == i) {
                    MPaasLogger.d("OpenCameraInterface", new Object[]{"The original orientation of camera is ", Integer.valueOf(cameraInfo2.orientation)});
                    break;
                }
                i2++;
                r8 = r8;
            }
            MPaasLogger.d("OpenCameraInterface", new Object[]{"numCameras=", Integer.valueOf(numberOfCameras), "^indexOfBack=", Integer.valueOf(i2), "^advancedOpen=", Boolean.valueOf(z), "^sCameraIdBackup=", Integer.valueOf(sCameraIdBackup), "^hasFrontCamera=", Boolean.valueOf((boolean) r8), "cameraFacing=", Integer.valueOf(i), "^enableCameraDefaultTolerant=", Boolean.valueOf(a)});
            if (i2 >= numberOfCameras) {
                MPaasLogger.d("OpenCameraInterface", new Object[]{"Requested camera does not exist,indexOfBack= ", Integer.valueOf(i2)});
                sCameraId = -1;
                if (i == 0 && r8 != 0) {
                    throw new RuntimeException("Requested camera does not exist");
                }
                Class cls = Integer.TYPE;
                WalletBury.addWalletBury("recordOpenCameraFaultTolerant", new Class[]{cls, cls}, new Object[]{1, Integer.valueOf((int) r8)});
                throw new RuntimeException("Requested Front Camera not exit");
            }
            sCameraId = i2;
            MPaasLogger.d("OpenCameraInterface", new Object[]{"#2 Opening camera #", Integer.valueOf(i2), " sCameraId=", Integer.valueOf(sCameraId), " cameraFacing=", Integer.valueOf(i)});
            CameraConfig build2 = new CameraConfig.Builder("Scan").setCameraId(i2).build();
            SystraceWrapper.beginTrace("openCamera");
            AntCamera openOptimized2 = AntCamera.openOptimized(build2);
            SystraceWrapper.endTrace();
            if (openOptimized2 == null) {
                sCameraId = -1;
                sCameraIdBackup = -1;
                if (a) {
                    MPaasLogger.d("OpenCameraInterface", new Object[]{"#3 Opening camera"});
                    openOptimized2 = AntCamera.open("Scan");
                    int i4 = openOptimized2 == null ? 0 : 1;
                    Class cls2 = Integer.TYPE;
                    WalletBury.addWalletBury("recordOpenCameraFaultTolerant", new Class[]{cls2, cls2}, new Object[]{3, Integer.valueOf(i4)});
                }
                if (openOptimized2 == null) {
                    throw new RuntimeException("openCamera is failed and camera is null");
                }
            }
            MPaasLogger.d("OpenCameraInterface", new Object[]{"The object camera Id is ", Integer.valueOf(sCameraId)});
            return openOptimized2;
        }
        sCameraId = -1;
        throw new RuntimeException("No Cameras");
    }

    public static void setCameraIdBackup(String str) {
        MPaasLogger.d("OpenCameraInterface", new Object[]{"setCameraIdBackup: ", str});
        try {
            if (str == null) {
                sCameraIdBackup = -1;
            } else {
                sCameraIdBackup = Integer.parseInt(str);
            }
        } catch (Exception e) {
            MPaasLogger.e("OpenCameraInterface", new Object[]{"setCameraIdBackup: "}, e);
            sCameraIdBackup = -1;
        }
    }

    public static void setEnableCameraDefaultTolerant(boolean z) {
        a = z;
        MPaasLogger.d("OpenCameraInterface", new Object[]{"setEnableCameraDefaultTolerant enable= ", Boolean.valueOf(z)});
    }
}
