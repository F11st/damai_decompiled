package com.alibaba.security.biometrics;

import android.os.Bundle;
import com.alibaba.security.biometrics.jni.listener.OnSgProcessListener;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.listener.OnSensorTrackListener;
import com.alibaba.security.biometrics.service.model.result.ALBiometricsResult;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ALBiometricsEventListener extends OnSgProcessListener, OnLogTrackListener, OnSensorTrackListener {
    void onBeforeRetry(OnRetryListener onRetryListener, String str, String str2);

    void onBiometricsFinish(int i);

    void onBiometricsStart();

    void onBusinessOk();

    void onCancel(int i, String str, String str2);

    void onError(int i, Bundle bundle);

    void onFinish(int i, boolean z);

    void onFrameResult(byte[] bArr, int i, int i2);

    void onSuccess(ALBiometricsResult aLBiometricsResult);
}
