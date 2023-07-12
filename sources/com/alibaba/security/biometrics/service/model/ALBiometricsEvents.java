package com.alibaba.security.biometrics.service.model;

import android.os.Bundle;
import com.alibaba.security.biometrics.service.listener.OnRetryListener;
import com.alibaba.security.biometrics.service.model.detector.ABDetectType;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ALBiometricsEvents {

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnActionEndListener {
        void onActionEnd(ABDetectType aBDetectType, int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnActionStartListener {
        void onActionStart(ABDetectType aBDetectType, int i, int i2);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnAdjustEndListener {
        void onAdjustEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnAdjustStartListener {
        void onAdjustStart();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnBeforeRetryListener {
        void onBeforeRetry(OnRetryListener onRetryListener, String str);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnCancelListener {
        void onCancel(int i);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnDetectContinueListener {
        void onDetectContinue(ABImageResult aBImageResult);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnDetectStartListener {
        void onDetectStart();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnFinishListener {
        void onFinish(int i, Bundle bundle);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnFrameDetectedListener {
        void onFrameDetected(ABDetectFrame aBDetectFrame);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnMessageListener {
        void onMessage(int i, Bundle bundle);
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnRecognizeEndListener {
        void onRecognizeEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnRecognizeStartListener {
        void onRecognizeStart();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnReflectEndListener {
        void onReflectEnd();
    }

    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public interface OnReflectStartListener {
        void onReflectStart();
    }
}
