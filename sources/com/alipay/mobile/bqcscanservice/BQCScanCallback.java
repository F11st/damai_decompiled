package com.alipay.mobile.bqcscanservice;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface BQCScanCallback {
    void onCameraAutoFocus(boolean z);

    void onCameraClose();

    void onCameraErrorResult(int i);

    void onCameraFrameRecognized(boolean z, long j);

    void onCameraManualFocusResult(boolean z);

    void onCameraOpened();

    void onCameraParametersSetFailed();

    void onCameraReady();

    void onEngineLoadSuccess();

    void onError(BQCScanError bQCScanError);

    void onFirstFrameRecognized();

    void onOuterEnvDetected(boolean z);

    void onParametersSetted(long j);

    void onPreOpenCamera();

    void onPreviewFrameShow();

    void onSetEnable();

    void onStartingPreview();

    void onSurfaceAvaliable();

    void onSurfaceUpdated();
}
