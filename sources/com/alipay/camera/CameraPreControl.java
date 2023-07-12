package com.alipay.camera;

import com.alipay.camera.base.AntCamera;
import com.alipay.camera.open.OpenCameraInterface;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class CameraPreControl extends AntCamera.ErrorCallbackProxy {
    public static final String TAG = "CameraPreControl";
    private AntCamera a;
    private boolean b;
    private long c;

    public void closeCamera() {
        AntCamera antCamera = this.a;
        if (antCamera != null) {
            antCamera.release();
            this.a = null;
        }
    }

    public AntCamera getTheCamera() {
        this.b = true;
        return this.a;
    }

    @Override // com.alipay.camera.base.AntCamera.ErrorCallbackProxy
    public void onErrorProxy(int i, AntCamera antCamera) {
        if (this.b) {
            return;
        }
        MPaasLogger.d(TAG, new Object[]{"onError:", Integer.valueOf(i)});
        this.a = null;
        WalletBury.addWalletBury("recordErrorBeforeTakeOver", new Class[]{Integer.TYPE, Long.TYPE}, new Object[]{Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - this.c)});
    }

    public void openCamera() {
        MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_0 start to preOpenCamera()"});
        try {
            this.b = false;
            this.c = System.currentTimeMillis();
            this.a = OpenCameraInterface.open(0, true);
            long currentTimeMillis = System.currentTimeMillis() - this.c;
            MPaasLogger.d(TAG, new Object[]{"end of preOpenCamera()"});
            Class[] clsArr = {Boolean.TYPE, Long.TYPE};
            Object[] objArr = new Object[2];
            objArr[0] = Boolean.valueOf(this.a != null);
            objArr[1] = Long.valueOf(currentTimeMillis);
            WalletBury.addWalletBury("recordPreCameraOpenResult", clsArr, objArr);
            this.a.setErrorCallback((AntCamera.ErrorCallbackProxy) this);
        } catch (RuntimeException e) {
            MPaasLogger.e(TAG, new Object[]{"open Camera error: "}, e);
            this.a = null;
        }
    }
}
