package com.alipay.camera2.operation;

import android.annotation.TargetApi;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.os.Message;
import android.text.TextUtils;
import com.alipay.camera2.Camera2FocusAbnormalChecker;
import com.alipay.camera2.operation.Camera2Manager;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes10.dex */
public class Camera2FocusManager implements CameraHandler.OnMessageHandleCallback {
    private static boolean i = false;
    private static int j = 8000;
    private final Camera2Operation a;
    private final Camera2FocusParameterConfig b;
    private final float c;
    private CameraHandler d;
    private boolean e;
    private boolean f = false;
    private Camera2Manager.OnCameraStateCallback g;
    private Camera2FocusAbnormalChecker h;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface Camera2Operation {
        boolean changeToSecondFocusMode();

        CameraCaptureSession.CaptureCallback getCaptureCallback();

        CameraCaptureSession getCaptureSession();

        CaptureRequest.Builder getRequestBuilder();
    }

    public Camera2FocusManager(CameraHandler cameraHandler, Camera2Operation camera2Operation, Camera2Manager.OnCameraStateCallback onCameraStateCallback, Camera2FocusParameterConfig camera2FocusParameterConfig, Camera2CharacteristicsCache camera2CharacteristicsCache) {
        this.a = camera2Operation;
        this.b = camera2FocusParameterConfig;
        this.c = camera2CharacteristicsCache.getMaxFocusDistance();
        this.d = cameraHandler;
        this.g = onCameraStateCallback;
        if (cameraHandler != null) {
            cameraHandler.addCallback(CameraHandler.AUTO_FOCUS_MESSAGE, this);
            this.d.addCallback(CameraHandler.AUTO_FOCUS_CHECK, this);
        }
        this.h = new Camera2FocusAbnormalChecker();
        this.e = false;
    }

    private void a(int i2) {
        CameraHandler cameraHandler = this.d;
        if (cameraHandler != null) {
            cameraHandler.clearMessages(i2);
        }
    }

    private void b() {
        CaptureRequest.Builder requestBuilder = this.a.getRequestBuilder();
        CameraCaptureSession captureSession = this.a.getCaptureSession();
        if (requestBuilder == null || captureSession == null) {
            return;
        }
        try {
            requestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 1);
            CaptureRequest build = requestBuilder.build();
            requestBuilder.set(CaptureRequest.CONTROL_AF_TRIGGER, 0);
            try {
                Camera2Operation camera2Operation = this.a;
                captureSession.capture(build, camera2Operation != null ? camera2Operation.getCaptureCallback() : null, this.d.getCameraHandler());
            } catch (CameraAccessException e) {
                MPaasLogger.e("Camera2FocusManager", new Object[]{"startAutoFocus with exception:"}, e);
                Camera2Manager.OnCameraStateCallback onCameraStateCallback = this.g;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onSetCaptureRequestError(e.getReason(), e.getMessage());
                }
            }
        } catch (Throwable th) {
            MPaasLogger.e("Camera2FocusManager", new Object[]{"doStartAutoFocusTrigger with exception:"}, th);
        }
    }

    private void c(float f, float f2, long j2, long j3, long j4, long j5, float f3, int i2, boolean z) {
        Camera2FocusParameterConfig camera2FocusParameterConfig;
        if (this.a == null || (camera2FocusParameterConfig = this.b) == null || !camera2FocusParameterConfig.secondFocusModeIsAuto()) {
            return;
        }
        boolean z2 = i2 == 1 || i2 == 2;
        if (this.e || z2) {
            return;
        }
        this.e = this.a.changeToSecondFocusMode();
        MPaasLogger.d("Camera2FocusManager", new Object[]{"Camera2AutoFocus changeToSecondFocusMode:", ", previewDuration:", Long.valueOf(j2), ", durationOfBlur:", Long.valueOf(j3), ", nonNeedCheckBlurDuration:", Long.valueOf(j4), ", frameCount:", Long.valueOf(j5), ", mMaxFocusDistance:", Float.valueOf(this.c), ", maxProportion:", Float.valueOf(f), ", maxProportionFocusDistance:", Float.valueOf(f2), ", mAutoFocusEnabled:", Boolean.valueOf(this.e), ", whetherFocusAbnormal:", Boolean.valueOf(z)});
        if (this.e) {
            WalletBury.addWalletBury("recordCamera2SecondFocusModeInfo", new Class[]{String.class}, new Object[]{"###secondFocusMode=" + String.valueOf(this.b.getSecondFocusMode()) + "###maxProportion=" + String.valueOf(f) + "###maxProportionFocusDistance=" + String.valueOf(f2) + "###currentFocusDistance=" + String.valueOf(f3) + "###previewDuration=" + String.valueOf(j2) + "###blurDuration=" + String.valueOf(j3) + "###nonNeedCheckBlurDuration=" + String.valueOf(j4) + "###frameCount=" + String.valueOf(j5) + "###whetherFocusAbnormal=" + String.valueOf(z)});
        }
    }

    private void d(int i2, long j2) {
        CameraHandler cameraHandler = this.d;
        if (cameraHandler != null) {
            cameraHandler.sendMessageDelayed(i2, j2);
        }
    }

    public static void setEnableSecondFocusModeSwitch(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        boolean equalsIgnoreCase = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
        i = equalsIgnoreCase;
        MPaasLogger.d("Camera2FocusManager", new Object[]{"sEnableSecondFocusModeSwitch:", Boolean.valueOf(equalsIgnoreCase)});
    }

    public static void updateThresholdSwitchToAutoDuration(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int parseInt = Integer.parseInt(str);
            j = parseInt;
            MPaasLogger.d("Camera2FocusManager", new Object[]{"sThresholdSwitchToAutoDuration:", Integer.valueOf(parseInt)});
        } catch (Throwable unused) {
        }
    }

    public void destroy() {
        MPaasLogger.d("Camera2FocusManager", new Object[]{Constants.Event.SLOT_LIFECYCLE.DESTORY});
        CameraHandler cameraHandler = this.d;
        if (cameraHandler != null) {
            Integer num = CameraHandler.AUTO_FOCUS_MESSAGE;
            cameraHandler.clearMessages(num.intValue());
            this.d.removeCallback(num);
            CameraHandler cameraHandler2 = this.d;
            Integer num2 = CameraHandler.AUTO_FOCUS_CHECK;
            cameraHandler2.clearMessages(num2.intValue());
            this.d.removeCallback(num2);
        }
        stopAutoFocusTrigger();
    }

    public Camera2FocusAbnormalChecker getCamera2FocusAbnormalChecker() {
        return this.h;
    }

    public float getInitFocusDistance() {
        Camera2FocusParameterConfig camera2FocusParameterConfig = this.b;
        if (camera2FocusParameterConfig != null) {
            return camera2FocusParameterConfig.getHistoryAvgFocusDistance();
        }
        return -1.0f;
    }

    public void offerFocusDistanceInfo(float f, float f2, float f3, long j2, int i2, long j3, long j4, long j5) {
        long currentTimeMillis = System.currentTimeMillis() - j2;
        boolean whetherFocusAbnormal = this.h.whetherFocusAbnormal(j4, j5, currentTimeMillis, f, f2);
        if (i) {
            if (whetherFocusAbnormal || currentTimeMillis > j) {
                c(f, f2, currentTimeMillis, j4, j5, j3, f3, i2, whetherFocusAbnormal);
            }
        }
    }

    public void offerFocusState(boolean z, int i2, int i3, int i4, int i5) {
        if (this.a == null || this.b == null || !this.e) {
            return;
        }
        if (!this.f && z) {
            this.f = true;
        }
        boolean z2 = i2 == 4 || i2 == 5;
        if (this.f) {
            if (z2 || i5 >= 60) {
                MPaasLogger.d("Camera2FocusManager", new Object[]{"Camera2AutoFocus offerFocusState send trigger af msg, inActiveFrameCount:", Integer.valueOf(i3), ", focusFailedFrameCount:", Integer.valueOf(i4), ", activeScanFrameCount:", Integer.valueOf(i5)});
                this.f = false;
                d(CameraHandler.AUTO_FOCUS_MESSAGE.intValue(), this.b.getDelayDuration());
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.CameraHandler.OnMessageHandleCallback
    public void onHandleMessage(Message message) {
        if (message == null || message.what != CameraHandler.AUTO_FOCUS_MESSAGE.intValue()) {
            return;
        }
        MPaasLogger.d("Camera2FocusManager", new Object[]{"onHandleMessage AUTO_FOCUS_MESSAGE"});
        if (this.e) {
            b();
        }
    }

    public void startAutoFocusTrigger() {
        this.e = true;
        b();
    }

    public void stopAutoFocusTrigger() {
        this.e = false;
        a(CameraHandler.AUTO_FOCUS_MESSAGE.intValue());
        a(CameraHandler.AUTO_FOCUS_CHECK.intValue());
    }
}
