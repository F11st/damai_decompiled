package com.alibaba.security.biometrics.service;

import com.alibaba.security.biometrics.jni.listener.OnSgProcessListener;
import com.alibaba.security.biometrics.service.listener.OnLogTrackListener;
import com.alibaba.security.biometrics.service.listener.OnSensorTrackListener;
import com.alibaba.security.biometrics.service.model.ALBiometricsEvents;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public interface ALBiometricsServiceEventListener extends OnSgProcessListener, OnLogTrackListener, OnSensorTrackListener, ALBiometricsEvents.OnActionEndListener, ALBiometricsEvents.OnActionStartListener, ALBiometricsEvents.OnAdjustEndListener, ALBiometricsEvents.OnAdjustStartListener, ALBiometricsEvents.OnBeforeRetryListener, ALBiometricsEvents.OnCancelListener, ALBiometricsEvents.OnDetectContinueListener, ALBiometricsEvents.OnDetectStartListener, ALBiometricsEvents.OnFinishListener, ALBiometricsEvents.OnFrameDetectedListener, ALBiometricsEvents.OnMessageListener, ALBiometricsEvents.OnRecognizeEndListener, ALBiometricsEvents.OnRecognizeStartListener, ALBiometricsEvents.OnReflectEndListener, ALBiometricsEvents.OnReflectStartListener {
}
