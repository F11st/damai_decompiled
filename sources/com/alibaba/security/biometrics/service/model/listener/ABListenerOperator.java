package com.alibaba.security.biometrics.service.model.listener;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.alibaba.security.biometrics.service.ALBiometricsService;
import com.alibaba.security.biometrics.service.ALBiometricsServiceEventListener;
import com.alibaba.security.biometrics.service.model.ABDetectFrame;
import com.alibaba.security.biometrics.service.model.result.ABImageResult;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ABListenerOperator implements ABListenerKeys {
    private static final String TAG = "ABListenerOperator";
    public ALBiometricsService mABService;
    private UiHandler mMainHandler = new UiHandler(this);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes8.dex */
    public static class UiHandler extends Handler {
        private final ABListenerOperator mService;

        public UiHandler(ABListenerOperator aBListenerOperator) {
            super(Looper.getMainLooper());
            this.mService = aBListenerOperator;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.mService.handleOnDetectStart(message);
                    return;
                case 2:
                    this.mService.handleOnDetectContinue(message);
                    return;
                case 3:
                    this.mService.handleOnAdjustStart(message);
                    return;
                case 4:
                    this.mService.handleOnAdjustEnd(message);
                    return;
                case 5:
                    this.mService.handleOnActionStart(message);
                    return;
                case 6:
                    this.mService.handleOnActionEnd(message);
                    return;
                case 7:
                    this.mService.handleOnRecognizeStart(message);
                    return;
                case 8:
                    this.mService.handleOnRecognizeEnd(message);
                    return;
                case 9:
                    this.mService.handleOnReflectStart(message);
                    return;
                case 10:
                    this.mService.handleOnReflectEnd(message);
                    return;
                case 11:
                    this.mService.handleOnFrameDetected(message);
                    return;
                case 12:
                    this.mService.handleOnMessage(message);
                    return;
                case 13:
                    this.mService.handleOnFinish(message);
                    return;
                case 14:
                    this.mService.handleOnLogRecord(message);
                    return;
                default:
                    super.handleMessage(message);
                    return;
            }
        }
    }

    public ABListenerOperator(ALBiometricsService aLBiometricsService) {
        this.mABService = aLBiometricsService;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnActionEnd(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            ParamActionResult paramActionResult = (ParamActionResult) message.obj;
            aBEventListener.onActionEnd(paramActionResult.detectType, paramActionResult.actionIndex, paramActionResult.actionTotal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnActionStart(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            ParamActionResult paramActionResult = (ParamActionResult) message.obj;
            aBEventListener.onActionStart(paramActionResult.detectType, paramActionResult.actionIndex, paramActionResult.actionTotal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdjustEnd(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnAdjustStart(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onAdjustStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDetectContinue(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectContinue((ABImageResult) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnDetectStart(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onDetectStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFinish(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            ParamBundleResult paramBundleResult = (ParamBundleResult) message.obj;
            aBEventListener.onFinish(paramBundleResult.code, paramBundleResult.bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnFrameDetected(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onFrameDetected((ABDetectFrame) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnLogRecord(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onOldLogRecord((Bundle) message.obj);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnMessage(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            ParamBundleResult paramBundleResult = (ParamBundleResult) message.obj;
            aBEventListener.onMessage(paramBundleResult.code, paramBundleResult.bundle);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnRecognizeEnd(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnRecognizeStart(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onRecognizeStart();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnReflectEnd(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectEnd();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void handleOnReflectStart(Message message) {
        ALBiometricsServiceEventListener aBEventListener = this.mABService.getABEventListener();
        if (aBEventListener != null) {
            aBEventListener.onReflectStart();
        }
    }

    public Message obtainMessage(int i) {
        return Message.obtain(this.mMainHandler, i);
    }

    public void sendEvent(Message message) {
        if (message != null) {
            this.mMainHandler.sendMessage(message);
        }
    }

    public Message obtainMessage(int i, Object obj) {
        return Message.obtain(this.mMainHandler, i, obj);
    }
}
