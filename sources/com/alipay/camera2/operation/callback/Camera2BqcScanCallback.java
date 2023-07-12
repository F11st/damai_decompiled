package com.alipay.camera2.operation.callback;

import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanError;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Camera2BqcScanCallback {
    private BQCScanCallback a;

    public Camera2BqcScanCallback(BQCScanCallback bQCScanCallback) {
        this.a = bQCScanCallback;
    }

    public void destroy() {
        this.a = null;
    }

    public void onCameraAutoFocus(boolean z) {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onCameraAutoFocus(z);
        }
    }

    public void onCameraClose() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onCameraClose();
        }
    }

    public void onCameraOpened() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onCameraOpened();
        }
    }

    public void onCameraReady() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onCameraReady();
        }
    }

    public void onEngineLoadSuccess() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onEngineLoadSuccess();
        }
    }

    public void onError(BQCScanError bQCScanError) {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onError(bQCScanError);
        }
    }

    public void onOuterEnvDetected(boolean z) {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onOuterEnvDetected(z);
        }
    }

    public void onParametersSetted(long j) {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onParametersSetted(j);
        }
    }

    public void onSetScanEngineEnable() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onSetEnable();
        }
    }

    public void onSurfaceAvaliable() {
        BQCScanCallback bQCScanCallback = this.a;
        if (bQCScanCallback != null) {
            bQCScanCallback.onSurfaceAvaliable();
        }
    }

    public void onTorchState(boolean z) {
    }
}
