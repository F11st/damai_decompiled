package com.alipay.camera.util;

import android.os.Build;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class ManufacturerPermissionChecker {
    public static final int RESULT_PERMISSION_CAMERA_OPEN_ERROR = 1;
    public static final int RESULT_PERMISSION_OK = 0;
    public static final int RESULT_PERMISSION_RECEIVE_FRAME_OVERTIME = 2;
    public static final String TAG = "ManufacturerPermissionChecker";
    private static boolean a;

    private static boolean a() {
        boolean z = true;
        if (Build.VERSION.SDK_INT >= 23) {
            return true;
        }
        try {
            Class<?> cls = Class.forName("android.hsm.HwSystemManager");
            CameraLog.d(TAG, "huaweiCheckCameraPermission: classLoader=" + cls.getClassLoader());
            z = ((Boolean) cls.getMethod("allowOp", Integer.TYPE).invoke(null, 1024)).booleanValue();
        } catch (ClassNotFoundException e) {
            CameraLog.e(TAG, "huaweiCheckCameraPermission: " + e.getMessage());
        } catch (IllegalAccessException e2) {
            CameraLog.e(TAG, "huaweiCheckCameraPermission: " + e2.getMessage());
        } catch (NoSuchMethodException e3) {
            CameraLog.e(TAG, "huaweiCheckCameraPermission: " + e3.getMessage());
        } catch (InvocationTargetException e4) {
            CameraLog.e(TAG, "huaweiCheckCameraPermission: " + e4.getMessage());
        } catch (Throwable th) {
            CameraLog.e(TAG, "huaweiCheckCameraPermission: " + th.getMessage());
        }
        CameraLog.d(TAG, "huaweiCheckCameraPermission: " + z);
        return z;
    }

    private static boolean b(String str) {
        boolean z = true;
        try {
            z = ((Boolean) Class.forName("com.vivo.services.security.client.VivoPermissionManager").getMethod("checkCallingVivoPermission", String.class).invoke(null, str)).booleanValue();
        } catch (ClassNotFoundException e) {
            CameraLog.e(TAG, "vivoCheckPermission: " + e.getMessage());
        } catch (IllegalAccessException e2) {
            CameraLog.e(TAG, "vivoCheckPermission: " + e2.getMessage());
        } catch (NoSuchMethodException e3) {
            CameraLog.e(TAG, "vivoCheckPermission: " + e3.getMessage());
        } catch (InvocationTargetException e4) {
            CameraLog.e(TAG, "vivoCheckPermission: " + e4.getMessage());
        } catch (Throwable th) {
            CameraLog.e(TAG, "vivoCheckPermission: " + th.getMessage());
        }
        CameraLog.d(TAG, "vivoCheckPermission: " + z);
        return z;
    }

    public static void printClassFunctionsInfo(String str) {
        Method[] declaredMethods;
        try {
            int i = 1;
            for (Method method : Class.forName(str).getDeclaredMethods()) {
                CameraLog.d(TAG, "method idx: " + i + " method name:" + method);
                i++;
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static void setCheckerSwitcher(boolean z) {
        a = z;
    }

    public static int tryToFetchCameraPermissionStatus() {
        int i = 0;
        if (a) {
            String manufacturer = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER();
            if ("vivo".equalsIgnoreCase(manufacturer) && !b("android.permission.CAMERA")) {
                i = 2;
            }
            if ("huawei".equalsIgnoreCase(manufacturer) && !a()) {
                i = 1;
            }
            CameraLog.d(TAG, "tryToFetchCameraPermissionStatus result= " + i + " manufacture= " + manufacturer);
            return i;
        }
        return 0;
    }
}
