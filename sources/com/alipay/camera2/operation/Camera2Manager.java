package com.alipay.camera2.operation;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import android.view.Display;
import android.view.Surface;
import android.view.WindowManager;
import com.alipay.camera.base.CameraPerformanceRecorder;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera2.Camera2Config;
import com.alipay.camera2.Camera2FocusAbnormalChecker;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.camera2.operation.Camera2FocusManager;
import com.alipay.camera2.operation.callback.Camera2CaptureCallback;
import com.alipay.camera2.operation.callback.OnReadImageListener;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.performance.ScanPerformanceConfig;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import tb.C9796v;

/* compiled from: Taobao */
@TargetApi(26)
/* loaded from: classes10.dex */
public class Camera2Manager implements Camera2FocusManager.Camera2Operation, Camera2CaptureCallback.Camera2CaptureCallbackListener, CameraHandler.OnMessageHandleCallback {
    public static final int DEFAULT_MAX_RETRY_NUM = 4;
    private static int G = 4;
    private static int H = 4;
    private static boolean I = true;
    private long C;
    private ScanCodeState E;
    private final boolean F;
    private Context a;
    private CameraHandler b;
    private CameraManager c;
    private Camera2Config d;
    private CameraDevice.StateCallback e;
    private OnCameraStateCallback f;
    private Camera2CaptureCallback g;
    private CameraDevice h;
    private CaptureRequest.Builder i;
    private CameraCaptureSession j;
    private CameraCaptureSession.StateCallback k;
    private OnReadImageListener l;
    private volatile int m;
    private Rect n;
    private Rect o;
    private Camera2FocusManager p;
    private Camera2FocusParameterConfig q;
    private Surface r;
    private OutputConfiguration s;
    private OutputConfiguration t;
    private OutputConfiguration u;
    private Camera2CharacteristicsCache v;
    private long y;
    private CameraOpenStates w = CameraOpenStates.IDLE;
    private int z = 0;
    private int A = 0;
    private boolean B = false;
    private int D = 0;
    private final CameraPerformanceRecorder x = new CameraPerformanceRecorder(true, "Scan2");

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum Camera2RetryFlag {
        OPEN_EXCEPTION_RETRY,
        OPEN_CALLBACK_RETRY,
        CREATE_SESSION_FAIL_RETRY
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public enum CameraOpenStates {
        IDLE,
        OPENING,
        OPENED,
        DISCONNECTED,
        CALL_CLOSED
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnCameraStateCallback {
        void onCamera2Closed();

        void onCamera2Opened();

        void onCaptureSessionConfigureFailed();

        void onCaptureSessionConfigured();

        void onCreateCaptureSessionError(int i, String str);

        void onError(CameraDevice cameraDevice, int i, boolean z);

        void onFinalizeOutputConfigurationsError(int i, String str);

        void onRetryOpenCameraError(int i, String str);

        void onSetCaptureRequestError(int i, String str);

        void onTorchModeChanged(boolean z);

        void showRetryInfoToUser(String str);
    }

    public Camera2Manager(Context context, CameraHandler cameraHandler, Camera2Config camera2Config, OnReadImageListener onReadImageListener, Camera2CharacteristicsCache camera2CharacteristicsCache, ScanCodeState scanCodeState) {
        this.a = context;
        this.b = cameraHandler;
        this.l = onReadImageListener;
        this.d = camera2Config == null ? new Camera2Config() : camera2Config;
        this.q = new Camera2FocusParameterConfig(camera2CharacteristicsCache);
        this.v = camera2CharacteristicsCache;
        this.p = new Camera2FocusManager(this.b, this, this.f, this.q, this.v);
        this.g = new Camera2CaptureCallback(camera2CharacteristicsCache, this.p, this);
        this.c = this.v.getSystemCameraManager();
        this.E = scanCodeState;
        this.F = ScanPerformanceConfig.needDowngradeCameraParams();
        F();
        this.e = new CameraDevice.StateCallback() { // from class: com.alipay.camera2.operation.Camera2Manager.1
            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onClosed(CameraDevice cameraDevice) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onClosed"});
                if (Camera2Manager.this.E != null) {
                    Camera2Manager.this.E.setCameraClosed();
                }
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onDisconnected(CameraDevice cameraDevice) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onDisconnected:", cameraDevice.getId()});
                if (Camera2Manager.this.h != null) {
                    cameraDevice.close();
                    if (cameraDevice.toString().equalsIgnoreCase(Camera2Manager.this.h.toString())) {
                        Camera2Manager.this.w = CameraOpenStates.DISCONNECTED;
                        Camera2Manager.this.h = null;
                        Camera2Manager.this.j = null;
                        return;
                    }
                    return;
                }
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice onDisconnected ignored."});
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onError(CameraDevice cameraDevice, int i) {
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError, errorCode:", Integer.valueOf(i), ", mOpenCameraExceptionRetryCount:", Integer.valueOf(Camera2Manager.this.D)});
                CameraStateTracer.recordOnErrorEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.ON_ERROR, i);
                if (Camera2Manager.this.h == null || cameraDevice == null || Camera2Manager.this.h.toString().equalsIgnoreCase(cameraDevice.toString())) {
                    Camera2Manager.this.w = CameraOpenStates.IDLE;
                    if (Camera2Manager.this.h == null) {
                        if (Camera2Manager.this.D <= 0) {
                            boolean E = Camera2Manager.this.E();
                            MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError, retry open camera, canContinueRetry:", Boolean.valueOf(E), ", errorCode:", Integer.valueOf(i), ", mRetryStopFlag:", Boolean.valueOf(Camera2Manager.this.B)});
                            if (E) {
                                return;
                            }
                            Camera2Manager.this.z(false, String.valueOf(i));
                            if (Camera2Manager.this.B || Camera2Manager.this.f == null) {
                                return;
                            }
                            Camera2Manager.this.f.onError(cameraDevice, i, true);
                            return;
                        }
                        MPaasLogger.d("Camera2Manager", new Object[]{"CameraDevice.StateCallback.onError ignore."});
                        return;
                    }
                    Camera2Manager.this.h = null;
                    Camera2Manager.this.j = null;
                    if (Camera2Manager.this.f != null) {
                        Camera2Manager.this.f.onError(cameraDevice, i, false);
                        return;
                    }
                    return;
                }
                MPaasLogger.w("Camera2Manager", new Object[]{"ignore previous camera device error, device!=mCameraDevice"});
            }

            @Override // android.hardware.camera2.CameraDevice.StateCallback
            public void onOpened(CameraDevice cameraDevice) {
                Object[] objArr = new Object[4];
                objArr[0] = "CameraDevice.StateCallback.onOpened: camera != null?";
                objArr[1] = Boolean.valueOf(cameraDevice != null);
                objArr[2] = ",retry start preview num:";
                objArr[3] = Integer.valueOf(Camera2Manager.this.z);
                MPaasLogger.d("Camera2Manager", objArr);
                Camera2Manager.this.z(true, "NULL");
                if (Camera2Manager.this.w != CameraOpenStates.CALL_CLOSED) {
                    Camera2Manager.this.x.setEndOpenCamera(System.currentTimeMillis());
                    SystraceWrapper.beginTrace("onOpened");
                    Camera2Manager.this.h = cameraDevice;
                    Camera2Manager.this.w = CameraOpenStates.OPENED;
                    if (Camera2Manager.this.z <= 0) {
                        if (Camera2Manager.this.f != null) {
                            Camera2Manager.this.f.onCamera2Opened();
                        }
                    } else {
                        Camera2Manager camera2Manager = Camera2Manager.this;
                        camera2Manager.createCameraPreviewSession(camera2Manager.r);
                    }
                    Camera2Manager.this.D = 0;
                    SystraceWrapper.endTrace();
                    if (Camera2Manager.this.E != null) {
                        Camera2Manager.this.E.setCameraOpened();
                        return;
                    }
                    return;
                }
                cameraDevice.close();
                Camera2Manager.this.w = CameraOpenStates.IDLE;
            }
        };
        this.k = new CameraCaptureSession.StateCallback() { // from class: com.alipay.camera2.operation.Camera2Manager.2
            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                MPaasLogger.e("Camera2Manager", new Object[]{"CameraCaptureSession onConfigureFailed, retry start preview num:", Integer.valueOf(Camera2Manager.this.z)});
                if (Camera2Manager.this.z > 0 || Camera2Manager.this.f == null) {
                    return;
                }
                Camera2Manager.this.f.onCaptureSessionConfigureFailed();
            }

            @Override // android.hardware.camera2.CameraCaptureSession.StateCallback
            public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                boolean z;
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraCaptureSession onConfigured"});
                if (Camera2Manager.this.h == null) {
                    return;
                }
                SystraceWrapper.beginTrace("onConfigured");
                Camera2Manager.this.j = cameraCaptureSession;
                if (Camera2Manager.this.v == null || Camera2Manager.this.i == null) {
                    return;
                }
                Camera2ConfigurationUtils.setup3AControlsLocked(Camera2Manager.this.v, Camera2Manager.this.d, Camera2Manager.this.i, Camera2Manager.this.q.getInitFocusMode(), Camera2Manager.this.q.getHistoryAvgFocusDistance());
                if (Camera2Manager.this.s != null) {
                    z = Camera2Manager.this.s.getSurface() != null ? Camera2Manager.this.C() : false;
                } else {
                    z = true;
                }
                if (z && Camera2Manager.this.K()) {
                    Camera2Manager.this.L();
                }
                Camera2Manager.this.x.setEndStartPreview(System.currentTimeMillis());
                if (Camera2Manager.this.f != null) {
                    Camera2Manager.this.f.onCaptureSessionConfigured();
                }
                MPaasLogger.d("Camera2Manager", new Object[]{"CameraCaptureSession onConfigured end"});
                SystraceWrapper.endTrace();
            }
        };
    }

    private boolean A() {
        if (!G()) {
            MPaasLogger.e("Camera2Manager", new Object[]{"doChangeFocusModeInRepeating, but device is invalid."});
            return false;
        }
        this.i.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(this.q.getSecondFocusMode()));
        if (this.q.secondFocusModeIsAuto()) {
            Camera2ConfigurationUtils.setAfAeRegion(this.v, this.i, this.d.previewSize, this.o, this.n);
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"autofocus change af mode to auto."});
        return K();
    }

    private boolean B() {
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache != null && this.q != null && this.b != null && this.o != null) {
            boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
            boolean secondFocusModeIsAuto = this.q.secondFocusModeIsAuto();
            if (hasFocuser && secondFocusModeIsAuto) {
                this.b.sendMessage(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue());
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean C() {
        if (this.j != null && this.s != null && this.i != null) {
            MPaasLogger.d("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration"});
            SystraceWrapper.beginTrace("Finalize-OutputConfiguration");
            ArrayList arrayList = new ArrayList();
            arrayList.add(this.s);
            try {
                this.j.finalizeOutputConfigurations(arrayList);
                this.i.addTarget(this.s.getSurface());
                SystraceWrapper.endTrace();
                return true;
            } catch (CameraAccessException e) {
                MPaasLogger.e("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration:"}, e);
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onFinalizeOutputConfigurationsError(e.getReason(), e.getMessage());
                }
                return false;
            } catch (IllegalArgumentException e2) {
                MPaasLogger.e("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration"}, e2);
                OnCameraStateCallback onCameraStateCallback2 = this.f;
                if (onCameraStateCallback2 != null) {
                    onCameraStateCallback2.onFinalizeOutputConfigurationsError(-888, e2.getMessage());
                }
                return false;
            }
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"doFinalizePreviewOutputConfiguration return false."});
        return false;
    }

    private boolean D() {
        int i;
        MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera, mRetryStopFlag:", Boolean.valueOf(this.B), ",mCurrentStartPreviewRetryNum:", Integer.valueOf(this.z)});
        if (!this.B && (i = this.z) < H - 1) {
            if (i == 0) {
                try {
                    this.C = SystemClock.elapsedRealtime();
                } catch (Exception e) {
                    MPaasLogger.e("Camera2Manager", new Object[]{"doRestartCamera fail:"}, e);
                    this.z = 0;
                    OnCameraStateCallback onCameraStateCallback = this.f;
                    if (onCameraStateCallback != null) {
                        onCameraStateCallback.onRetryOpenCameraError(1204, e.getMessage());
                    }
                    return false;
                }
            }
            CameraDevice cameraDevice = this.h;
            if (cameraDevice != null) {
                cameraDevice.close();
                this.h = null;
                this.w = CameraOpenStates.IDLE;
            }
            OnCameraStateCallback onCameraStateCallback2 = this.f;
            if (onCameraStateCallback2 != null && this.z == 3) {
                onCameraStateCallback2.showRetryInfoToUser("Preview");
            }
            Thread.sleep(1000L);
            if (this.B) {
                MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera retry canceled."});
                return false;
            }
            this.z++;
            openCamera();
            return true;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"doRestartCamera return false."});
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean E() {
        int i;
        MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError, mRetryStopFlag:", Boolean.valueOf(this.B), ", mCurrentOpenRetryNum:", Integer.valueOf(this.A), ", MAX_RETRY_NUM:", Integer.valueOf(G)});
        if (!this.B && (i = this.A) < G - 1) {
            if (i == 0) {
                try {
                    this.C = SystemClock.elapsedRealtime();
                } catch (Exception e) {
                    MPaasLogger.e("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError fail:"}, e);
                    OnCameraStateCallback onCameraStateCallback = this.f;
                    if (onCameraStateCallback != null) {
                        onCameraStateCallback.onRetryOpenCameraError(1205, e.getMessage());
                    }
                    return true;
                }
            }
            OnCameraStateCallback onCameraStateCallback2 = this.f;
            if (onCameraStateCallback2 != null && this.A == 3) {
                onCameraStateCallback2.showRetryInfoToUser("Camera");
            }
            Thread.sleep(1000L);
            if (this.B) {
                MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError retry canceled."});
                return false;
            }
            this.A++;
            openCamera();
            return true;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"doRetryOpenCameraForCallbackError return false."});
        return false;
    }

    private void F() {
        Camera2CharacteristicsCache camera2CharacteristicsCache;
        Object[] objArr = new Object[4];
        objArr[0] = "init, camera2CharacteristicsCache==null?";
        objArr[1] = Boolean.valueOf(this.v == null);
        objArr[2] = ",sChooseBestForRecognizeYUV:";
        objArr[3] = Boolean.valueOf(I);
        MPaasLogger.d("Camera2Manager", objArr);
        if (this.d != null && (camera2CharacteristicsCache = this.v) != null && this.a != null && this.b != null && camera2CharacteristicsCache.valid()) {
            if (H()) {
                Display defaultDisplay = ((WindowManager) this.a.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
                Point point = new Point();
                com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
                Camera2Config camera2Config = this.d;
                camera2Config.screenResolution = point;
                camera2Config.needDowngradeCameraParams = this.F;
                if (I) {
                    camera2Config.previewSize = Camera2Utils.findBestForScanPreviewSize(this.v.getOrderedOutputYuvSizeList(), point, this.d.needDowngradeCameraParams);
                }
                if (this.d.previewSize == null) {
                    MPaasLogger.d("Camera2Manager", new Object[]{"Best for recognize not found, try find preview size again."});
                    this.d.previewSize = CameraConfigurationUtils.findBestPreviewSizeValue(this.v.getOrderedOutputYuvSizeList(), point, this.d.needDowngradeCameraParams);
                }
                Camera2Config camera2Config2 = this.d;
                List<Point> orderedOutputYuvSizeList = this.v.getOrderedOutputYuvSizeList();
                Camera2Config camera2Config3 = this.d;
                camera2Config2.downgradePreviewSize = Camera2Utils.findCloseToScreenPreviewSize(orderedOutputYuvSizeList, camera2Config3.screenResolution, camera2Config3.previewSize);
                this.d.pictureSize = Camera2Utils.findBestJpegSize(this.v.getOrderedOutputYuvSizeList().get(0), this.v.getOrderedOutputJpegSizeList(), this.d.previewSize);
            }
            Object[] objArr2 = new Object[12];
            objArr2[0] = "init preview size:";
            objArr2[1] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize));
            objArr2[2] = Constants.Name.X;
            objArr2[3] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize));
            objArr2[4] = ", picture size:";
            objArr2[5] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.pictureSize));
            objArr2[6] = Constants.Name.X;
            objArr2[7] = Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.pictureSize));
            objArr2[8] = ", downgrade preview size:";
            Point point2 = this.d.downgradePreviewSize;
            objArr2[9] = point2 == null ? "null" : point2.toString();
            objArr2[10] = ", support picture size:";
            objArr2[11] = Boolean.valueOf(this.d.supportPictureSize());
            MPaasLogger.d("Camera2Manager", objArr2);
            this.n = this.v.getCropRegionForNonZoom();
            this.d.objCameraId = this.v.getCameraIdStr();
            this.d.previewFormat = this.v.getYuvFormat();
            Camera2Config camera2Config4 = this.d;
            Camera2CharacteristicsCache camera2CharacteristicsCache2 = this.v;
            Point point3 = this.d.previewSize;
            camera2Config4.fpsRange = camera2CharacteristicsCache2.getFpsRange(new Size(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3)));
            this.d.initImageReader();
            this.d.yuvImageReader.setOnImageAvailableListener(this.l, this.b.getCameraHandler());
            return;
        }
        MPaasLogger.e("Camera2Manager", new Object[]{"init, Camera2Manager may destroy, ignore this."});
    }

    private boolean G() {
        return (this.h == null || this.i == null || this.j == null) ? false : true;
    }

    private boolean H() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || this.a == null) {
            return false;
        }
        if (camera2Config.valid()) {
            Display defaultDisplay = ((WindowManager) this.a.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
            Point point = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
            return (this.d.screenResolution.equals(point) && (this.d.needDowngradeCameraParams ^ true) == this.F) ? false : true;
        }
        return true;
    }

    private void I() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            Integer num = CameraHandler.SECOND_FOCUS_DELAY_MESSAGE;
            cameraHandler.clearMessages(num.intValue());
            this.b.removeCallback(num);
        }
    }

    private void J(int i) {
        CaptureRequest.Builder builder;
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache != null && (builder = this.i) != null) {
            Rect zoom = Camera2ConfigurationUtils.setZoom(camera2CharacteristicsCache, builder, i);
            this.n = zoom;
            if (this.o != null && zoom != null && this.d.valid()) {
                Camera2ConfigurationUtils.setAfAeRegion(this.v, this.i, this.d.previewSize, this.o, this.n);
            }
            K();
            this.m = i;
            ScanCodeState scanCodeState = this.E;
            if (scanCodeState != null) {
                scanCodeState.setZoom(i);
                return;
            }
            return;
        }
        MPaasLogger.e("Camera2Manager", new Object[]{"setZoomParameter status error."});
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean K() {
        CameraCaptureSession cameraCaptureSession;
        MPaasLogger.d("Camera2Manager", new Object[]{"setRepeatingRequest"});
        if (MPaasLogger.isDebuggable()) {
            SystraceWrapper.beginTrace("setRepeatingRequest");
        }
        try {
            CaptureRequest.Builder builder = this.i;
            if (builder != null && (cameraCaptureSession = this.j) != null) {
                cameraCaptureSession.setRepeatingRequest(builder.build(), this.g, this.b.getCameraHandler());
            }
            SystraceWrapper.endTrace();
            MPaasLogger.d("Camera2Manager", new Object[]{"setRepeatingRequest end"});
            return true;
        } catch (CameraAccessException e) {
            MPaasLogger.e("Camera2Manager", new Object[]{"setRepeatingRequest exception:"}, e);
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onSetCaptureRequestError(e.getReason(), e.getMessage());
            }
            return false;
        } catch (Exception e2) {
            MPaasLogger.e("Camera2Manager", new Object[]{"setRepeatingRequest exception:"}, e2);
            OnCameraStateCallback onCameraStateCallback2 = this.f;
            if (onCameraStateCallback2 != null) {
                onCameraStateCallback2.onSetCaptureRequestError(1402, e2.getMessage());
            }
            return false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void L() {
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache == null || this.q == null || this.b == null || this.p == null) {
            return;
        }
        boolean hasFocuser = camera2CharacteristicsCache.hasFocuser();
        boolean initFocusModeIsAuto = this.q.initFocusModeIsAuto();
        if (hasFocuser && initFocusModeIsAuto) {
            MPaasLogger.d("Camera2Manager", new Object[]{"startAutoFocusTriggerForInitAutoMode"});
            this.p.startAutoFocusTrigger();
        }
    }

    public static void setEnableChooseBestForRecognizeYUV(String str) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setEnableChooseBestForRecognizeYUV:", str});
        if (TextUtils.isEmpty(str)) {
            return;
        }
        I = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public static void setEnableSecondFocusModeSwitch(String str) {
        Camera2FocusManager.setEnableSecondFocusModeSwitch(str);
    }

    public static void setMaxRetryNum(int i) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setMaxRetryNum:", Integer.valueOf(i)});
        G = i;
    }

    public static void setMaxRetryStartPreviewNum(int i) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setMaxRetryStartPreviewNum:", Integer.valueOf(i)});
        H = i;
    }

    private void x() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.addCallback(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE, this);
        }
    }

    private void y() {
        Camera2FocusAbnormalChecker camera2FocusAbnormalChecker;
        try {
            StringBuilder sb = new StringBuilder();
            Camera2Config camera2Config = this.d;
            if (camera2Config != null) {
                if (camera2Config.previewSize != null) {
                    sb.append("###yuvSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize));
                    sb.append("###yuvSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize));
                }
                if (this.d.downgradePreviewSize != null) {
                    sb.append("###downgradePreviewSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.downgradePreviewSize));
                    sb.append("###downgradePreviewSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.downgradePreviewSize));
                }
                if (this.d.pictureSize != null) {
                    sb.append("###jpegSizeWidth=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.pictureSize));
                    sb.append("###jpegSizeHeight=" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.pictureSize));
                }
                sb.append("###useJpegStream=" + this.d.supportPictureSize());
            }
            Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
            if (camera2CharacteristicsCache != null) {
                List<Point> orderedOutputYuvSizeList = camera2CharacteristicsCache.getOrderedOutputYuvSizeList();
                List<Point> orderedOutputJpegSizeList = this.v.getOrderedOutputJpegSizeList();
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(orderedOutputJpegSizeList.get(0)) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(orderedOutputJpegSizeList.get(0));
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(orderedOutputYuvSizeList.get(0)) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(orderedOutputYuvSizeList.get(0));
                sb.append("###cameraid=" + this.v.getCameraIdStr());
                sb.append("###hardwareLevel=" + this.v.getHardwareLevel());
                List<CaptureRequest.Key<?>> availableSessionKeys = this.v.getAvailableSessionKeys();
                if (availableSessionKeys != null && availableSessionKeys.size() > 0) {
                    sb.append("###sessionKeySize=" + String.valueOf(availableSessionKeys.size()));
                    sb.append("###availableSessionKeys=" + availableSessionKeys);
                }
                sb.append("###availableFpsRanges=" + Camera2Utils.rangeArrayToString(this.v.getAvailableFpsRangeList()));
                sb.append("###availableAFModes=" + Arrays.toString(this.v.getAvailableAfModes()));
                sb.append("###availableYuvSizes=" + orderedOutputYuvSizeList);
                sb.append("###availableJpegSize=" + orderedOutputJpegSizeList);
                StringBuilder sb2 = new StringBuilder();
                sb2.append("###maxJpegLargerMaxYuv=");
                sb2.append(xVar > xVar2);
                sb.append(sb2.toString());
                sb.append("###afSceneChangeDetection=" + String.valueOf(this.v.isSupportAfSceneChangedDetection()));
                sb.append("###activeArraySize=");
                sb.append(String.valueOf(this.v.getActiveArraySize()));
            }
            if (this.q != null) {
                sb.append("###firstFocusMode=" + this.q.getInitFocusMode());
                sb.append("###secondFocusMode=" + this.q.getSecondFocusMode());
            }
            CaptureRequest.Builder builder = this.i;
            if (builder != null) {
                Integer num = (Integer) builder.get(CaptureRequest.CONTROL_AF_MODE);
                if (num != null) {
                    sb.append("###lastFocusMode=" + num);
                }
                Range range = (Range) this.i.get(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE);
                if (range != null) {
                    sb.append("###fpsRange=" + range);
                }
                MeteringRectangle[] meteringRectangleArr = (MeteringRectangle[]) this.i.get(CaptureRequest.CONTROL_AF_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    sb.append("###afRegion=" + meteringRectangleArr[0].toString());
                }
                MeteringRectangle[] meteringRectangleArr2 = (MeteringRectangle[]) this.i.get(CaptureRequest.CONTROL_AE_REGIONS);
                if (meteringRectangleArr != null && meteringRectangleArr.length > 0) {
                    sb.append("###aeRegions=" + meteringRectangleArr2[0].toString());
                }
            }
            sb.append("###currentCropRegion=");
            sb.append(String.valueOf(this.n));
            Camera2FocusManager camera2FocusManager = this.p;
            if (camera2FocusManager != null && (camera2FocusAbnormalChecker = camera2FocusManager.getCamera2FocusAbnormalChecker()) != null) {
                sb.append(camera2FocusAbnormalChecker.toString());
            }
            sb.append("###pipelineMode=");
            sb.append(String.valueOf(Camera2ConfigurationUtils.sPipelineMode));
            if (sb.length() > 0) {
                if (MPaasLogger.isDebuggable()) {
                    MPaasLogger.d("Camera2Manager", new Object[]{"buryCamera2Params:", sb.toString()});
                }
                WalletBury.addWalletBury("recordCamera2ParamsDetail", new Class[]{String.class}, new Object[]{sb.toString()});
            }
        } catch (Throwable th) {
            MPaasLogger.e("Camera2Manager", new Object[]{"buryCamera2Params error:"}, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void z(boolean z, String str) {
        MPaasLogger.d("Camera2Manager", new Object[]{"buryRetryOpenCameraForCallback, retry num:", Integer.valueOf(this.A), ",mRetryStopFlag:", Boolean.valueOf(this.B), ",retrySuccess:", Boolean.valueOf(z)});
        if (this.A > 0) {
            Class cls = Boolean.TYPE;
            WalletBury.addWalletBury("recordCamera2RetryInfo", new Class[]{String.class, cls, Integer.TYPE, Long.TYPE, cls, String.class}, new Object[]{String.valueOf(Camera2RetryFlag.OPEN_CALLBACK_RETRY), Boolean.valueOf(z), Integer.valueOf(this.A), Long.valueOf(SystemClock.elapsedRealtime() - this.C), Boolean.valueOf(this.B), str});
            this.A = 0;
        }
    }

    public void addCameraStateCallback(OnCameraStateCallback onCameraStateCallback) {
        MPaasLogger.d("Camera2Manager", new Object[]{"addCameraStateCallback"});
        this.f = onCameraStateCallback;
        x();
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public boolean changeToSecondFocusMode() {
        return B();
    }

    public void closeCamera() {
        MPaasLogger.d("Camera2Manager", new Object[]{"start to closeCamera"});
        y();
        try {
            if (this.w == CameraOpenStates.OPENING) {
                this.w = CameraOpenStates.CALL_CLOSED;
            }
            this.d.yuvImageReader.setOnImageAvailableListener(null, null);
            Camera2FocusManager camera2FocusManager = this.p;
            if (camera2FocusManager != null) {
                camera2FocusManager.stopAutoFocusTrigger();
            }
            if (this.j != null) {
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.STOP_PREVIEW);
                this.x.setBeginStopPreview(System.currentTimeMillis());
                this.j.abortCaptures();
                this.x.setEndStopPreview(System.currentTimeMillis());
                this.j = null;
            }
            if (this.h != null) {
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.RELEASE);
                this.x.setBeginCloseCamera(System.currentTimeMillis());
                this.h.close();
                Camera2CaptureCallback camera2CaptureCallback = this.g;
                if (camera2CaptureCallback != null) {
                    this.x.setFirstTriggerFrameCount(camera2CaptureCallback.getFocusFirstTriggerFrameCount());
                }
                this.x.setEndCloseCamera(System.currentTimeMillis());
                this.h = null;
                this.w = CameraOpenStates.IDLE;
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null) {
                    onCameraStateCallback.onCamera2Closed();
                }
            }
            this.r = null;
            this.s = null;
            this.t = null;
            this.u = null;
            this.d.yuvImageReader.close();
            this.d.jpegImageReader.close();
            this.v = null;
            this.i = null;
            MPaasLogger.d("Camera2Manager", new Object[]{"end to closeCamera"});
        } catch (Exception unused) {
        }
    }

    public void createCameraPreviewSession(Surface surface) {
        if (surface != null && surface.isValid()) {
            if (this.h == null) {
                MPaasLogger.w("Camera2Manager", new Object[]{"createCameraPreviewSession with mCameraDevice == null."});
                if (this.w == CameraOpenStates.DISCONNECTED) {
                    D();
                    return;
                }
                return;
            }
            Exception exc = null;
            try {
                MPaasLogger.d("Camera2Manager", new Object[]{"doCreateCameraPreviewSession begin, max retry num:", Integer.valueOf(H)});
                SystraceWrapper.beginTrace("createCaptureRequest");
                this.r = surface;
                this.i = this.h.createCaptureRequest(1);
                SystraceWrapper.endTrace();
                ArrayList arrayList = new ArrayList();
                this.i.addTarget(surface);
                arrayList.add(surface);
                if (this.d != null && Camera2Config.supportYuvStream()) {
                    this.i.addTarget(this.d.yuvImageReader.getSurface());
                    arrayList.add(this.d.yuvImageReader.getSurface());
                }
                Camera2Config camera2Config = this.d;
                if (camera2Config != null && camera2Config.supportPictureSize()) {
                    arrayList.add(this.d.jpegImageReader.getSurface());
                }
                SystraceWrapper.beginTrace("createCaptureSession");
                CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.START_PREVIEW);
                this.x.setBeginStartPreview(System.currentTimeMillis());
                MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSession surface size:", Integer.valueOf(arrayList.size())});
                this.h.createCaptureSession(arrayList, this.k, this.b.getCameraHandler());
                SystraceWrapper.endTrace();
            } catch (Exception e) {
                exc = e;
                MPaasLogger.e("Camera2Manager", new Object[]{"doCreateCameraPreviewSession Exception, retry start preview num:", Integer.valueOf(this.z)}, exc);
                if (D()) {
                    return;
                }
                OnCameraStateCallback onCameraStateCallback = this.f;
                if (onCameraStateCallback != null && !this.B) {
                    onCameraStateCallback.onCreateCaptureSessionError(1400, exc.getMessage());
                }
            }
            int i = this.z;
            if (i > 0) {
                Object[] objArr = new Object[6];
                objArr[0] = "createCameraPreviewSession with retry, retry start preview num:";
                objArr[1] = Integer.valueOf(i);
                objArr[2] = ",mRetryStopFlag:";
                objArr[3] = Boolean.valueOf(this.B);
                objArr[4] = ",sessionException:";
                objArr[5] = exc == null ? "null" : exc.getMessage();
                MPaasLogger.d("Camera2Manager", objArr);
                Class cls = Boolean.TYPE;
                Class[] clsArr = {String.class, cls, Integer.TYPE, Long.TYPE, cls, String.class};
                Object[] objArr2 = new Object[6];
                objArr2[0] = String.valueOf(Camera2RetryFlag.CREATE_SESSION_FAIL_RETRY);
                objArr2[1] = Boolean.valueOf(exc == null);
                objArr2[2] = Integer.valueOf(this.z);
                objArr2[3] = Long.valueOf(SystemClock.elapsedRealtime() - this.C);
                objArr2[4] = Boolean.valueOf(this.B);
                objArr2[5] = exc == null ? "Null" : exc.getMessage();
                WalletBury.addWalletBury("recordCamera2RetryInfo", clsArr, objArr2);
                this.z = 0;
                return;
            }
            return;
        }
        MPaasLogger.e("Camera2Manager", new Object[]{"createCameraPreviewSession with surface status invalid."});
    }

    public void createCameraPreviewSessionByOutputConfiguration(OutputConfiguration outputConfiguration) {
        MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration"});
        if (this.h == null) {
            MPaasLogger.w("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration with mCameraDevice == null."});
            if (this.w == CameraOpenStates.DISCONNECTED) {
                D();
                return;
            }
            return;
        }
        try {
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("createCaptureRequest");
            }
            this.i = this.h.createCaptureRequest(1);
            SystraceWrapper.endTrace();
            ArrayList arrayList = new ArrayList();
            this.s = outputConfiguration;
            arrayList.add(outputConfiguration);
            if (this.d != null && Camera2Config.supportYuvStream()) {
                Surface surface = this.d.yuvImageReader.getSurface();
                this.i.addTarget(surface);
                OutputConfiguration outputConfiguration2 = new OutputConfiguration(surface);
                this.t = outputConfiguration2;
                arrayList.add(outputConfiguration2);
            }
            Camera2Config camera2Config = this.d;
            if (camera2Config != null && camera2Config.supportPictureSize()) {
                OutputConfiguration outputConfiguration3 = new OutputConfiguration(this.d.jpegImageReader.getSurface());
                this.u = outputConfiguration3;
                arrayList.add(outputConfiguration3);
            }
            if (MPaasLogger.isDebuggable()) {
                SystraceWrapper.beginTrace("createCaptureSession");
            }
            MPaasLogger.d("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration surface size:", Integer.valueOf(arrayList.size())});
            CameraStateTracer.recordEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.START_PREVIEW);
            this.x.setBeginStartPreview(System.currentTimeMillis());
            this.h.createCaptureSessionByOutputConfigurations(arrayList, this.k, this.b.getCameraHandler());
            SystraceWrapper.endTrace();
        } catch (CameraAccessException e) {
            MPaasLogger.e("Camera2Manager", new Object[]{"createCameraPreviewSessionByOutputConfiguration"}, e);
            OnCameraStateCallback onCameraStateCallback = this.f;
            if (onCameraStateCallback != null) {
                onCameraStateCallback.onCreateCaptureSessionError(e.getReason(), e.getMessage());
            }
        }
    }

    public void destroy() {
        this.a = null;
        this.f = null;
        this.e = null;
        this.v = null;
        this.i = null;
        this.j = null;
        Camera2FocusManager camera2FocusManager = this.p;
        if (camera2FocusManager != null) {
            camera2FocusManager.destroy();
            this.p = null;
        }
        if (this.g != null && MPaasLogger.isDebuggable()) {
            MPaasLogger.d("Camera2Manager", new Object[]{"destroy camera arrived frame num:", this.x.toString(), ", CameraFocusStateDescription:", String.valueOf(getCameraFocusStateDescription())});
        }
        I();
    }

    public void finalizePreviewOutputConfiguration(Surface surface) {
        OutputConfiguration outputConfiguration;
        if (surface == null || this.h == null || (outputConfiguration = this.s) == null || outputConfiguration.getSurface() != null) {
            return;
        }
        this.s.addSurface(surface);
        if (this.j != null && C()) {
            K();
            L();
        }
    }

    public String getAfStateHistory() {
        try {
            Camera2CaptureCallback camera2CaptureCallback = this.g;
            return camera2CaptureCallback != null ? camera2CaptureCallback.getAfState() : "NULL";
        } catch (Exception e) {
            MPaasLogger.d("Camera2Manager", new Object[]{"getAfStateHistory error:", e});
            return "NULL";
        }
    }

    public Camera2Config getCameraConfig() {
        return this.d;
    }

    public CameraFocusStateDescription getCameraFocusStateDescription() {
        Camera2FocusAbnormalChecker camera2FocusAbnormalChecker;
        try {
            Camera2CaptureCallback camera2CaptureCallback = this.g;
            if (camera2CaptureCallback != null) {
                CameraFocusStateDescription cameraFocusStateDescription = camera2CaptureCallback.getCameraFocusStateDescription();
                Camera2FocusParameterConfig camera2FocusParameterConfig = this.q;
                if (camera2FocusParameterConfig != null) {
                    cameraFocusStateDescription.setHistorySuccessfulFocusDistanceCount(camera2FocusParameterConfig.getHistorySuccessfulFocusDistanceCount());
                    cameraFocusStateDescription.setHistoryAvgSuccessfulFocusDistance(this.q.getHistoryAvgFocusDistance());
                }
                Camera2FocusManager camera2FocusManager = this.p;
                if (camera2FocusManager != null && (camera2FocusAbnormalChecker = camera2FocusManager.getCamera2FocusAbnormalChecker()) != null) {
                    cameraFocusStateDescription.setMaxProportionForFirstSecond(camera2FocusAbnormalChecker.getFirstStageLargestProportion());
                    cameraFocusStateDescription.setMaxProportionFocusDistanceForFirstSecond(camera2FocusAbnormalChecker.getFirstStageLargestProportionDistance());
                }
                return cameraFocusStateDescription;
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public CameraPerformanceRecorder getCameraPerformanceRecorder() {
        return this.x;
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CameraCaptureSession.CaptureCallback getCaptureCallback() {
        return this.g;
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CameraCaptureSession getCaptureSession() {
        return this.j;
    }

    public int getCurZoom() {
        return this.m;
    }

    @Override // com.alipay.camera2.operation.callback.Camera2CaptureCallback.Camera2CaptureCallbackListener
    public long getDurationOfBlur() {
        OnReadImageListener onReadImageListener = this.l;
        if (onReadImageListener != null) {
            return onReadImageListener.getDurationOfBlur();
        }
        return -1L;
    }

    @Override // com.alipay.camera2.operation.callback.Camera2CaptureCallback.Camera2CaptureCallbackListener
    public long getDurationOfNonNeedCheckBlur() {
        OnReadImageListener onReadImageListener = this.l;
        if (onReadImageListener != null) {
            return onReadImageListener.getDurationOfNonNeedCheckBlur();
        }
        return 0L;
    }

    public String getDynamicBlockEvent() {
        CameraPerformanceRecorder cameraPerformanceRecorder = this.x;
        if (cameraPerformanceRecorder != null) {
            return cameraPerformanceRecorder.getDynamicBlockEvent();
        }
        return null;
    }

    public long getOpenCameraExecuteDuration() {
        return this.y;
    }

    public int getPreviewHeight() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || !camera2Config.valid()) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.d.previewSize);
    }

    public int getPreviewWidth() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null || !camera2Config.valid()) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.d.previewSize);
    }

    @Override // com.alipay.camera2.operation.Camera2FocusManager.Camera2Operation
    public CaptureRequest.Builder getRequestBuilder() {
        return this.i;
    }

    public void onFirstFrameArrived(long j) {
        this.x.setEndFirstPreviewFrame(j);
    }

    @Override // com.alipay.mobile.bqcscanservice.CameraHandler.OnMessageHandleCallback
    public void onHandleMessage(Message message) {
        int i;
        if (message == null || (i = message.what) != CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue()) {
            return;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"autofocus SECOND_FOCUS_DELAY_MESSAGE received."});
        try {
            if (this.q.secondFocusModeIsAuto()) {
                boolean A = A();
                MPaasLogger.d("Camera2Manager", new Object[]{"autofocus repeatingChangeToAuto:", Boolean.valueOf(A)});
                if (A) {
                    MPaasLogger.d("Camera2Manager", new Object[]{"autofocus trigger"});
                    this.p.startAutoFocusTrigger();
                }
            }
        } catch (Exception e) {
            MPaasLogger.e("Camera2Manager", new Object[]{"onHandleMessage: ", Integer.valueOf(i)}, e);
        }
    }

    public void onMovementStatusChanged(boolean z) {
        Camera2CaptureCallback camera2CaptureCallback = this.g;
        if (camera2CaptureCallback != null) {
            camera2CaptureCallback.onMovementStatusChanged(z);
        }
    }

    public void openCamera() throws CameraAccessException, SecurityException {
        CameraOpenStates cameraOpenStates = this.w;
        CameraOpenStates cameraOpenStates2 = CameraOpenStates.OPENING;
        if (cameraOpenStates != cameraOpenStates2 && cameraOpenStates != CameraOpenStates.OPENED) {
            MPaasLogger.d("Camera2Manager", new Object[]{"openCamera"});
            SystraceWrapper.beginTrace("openCamera");
            try {
                CameraStateTracer.recordOpenEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.OPEN);
                this.x.setBeginOpenCamera(System.currentTimeMillis());
                long currentTimeMillis = System.currentTimeMillis();
                this.h = null;
                this.c.openCamera(this.d.objCameraId, this.e, this.b.getCameraHandler());
                this.y = System.currentTimeMillis() - currentTimeMillis;
                this.w = cameraOpenStates2;
                SystraceWrapper.endTrace();
            } catch (Exception e) {
                MPaasLogger.e("Camera2Manager", new Object[]{"openCamera with exception"}, e);
                throw e;
            }
        } else if (this.h == null || this.f == null) {
        } else {
            MPaasLogger.d("Camera2Manager", new Object[]{"openCamera onCamera2Opened"});
            this.f.onCamera2Opened();
        }
    }

    public void preOpenCamera() {
        CameraOpenStates cameraOpenStates = this.w;
        CameraOpenStates cameraOpenStates2 = CameraOpenStates.OPENING;
        if (cameraOpenStates == cameraOpenStates2 || cameraOpenStates == CameraOpenStates.OPENED) {
            return;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"preOpenCamera"});
        if (MPaasLogger.isDebuggable()) {
            SystraceWrapper.beginTrace("preOpenCamera");
        }
        try {
            CameraStateTracer.recordOpenEvent("Camera2Manager", "Scan2", CameraStateTracer.CameraEvent.OPEN);
            this.x.setBeginOpenCamera(System.currentTimeMillis());
            long currentTimeMillis = System.currentTimeMillis();
            this.h = null;
            this.c.openCamera(this.d.objCameraId, this.e, this.b.getCameraHandler());
            this.y = System.currentTimeMillis() - currentTimeMillis;
            this.w = cameraOpenStates2;
        } catch (SecurityException e) {
            MPaasLogger.e("Camera2Manager", new Object[]{"preOpenCamera securityException"}, e);
        } catch (Exception e2) {
            MPaasLogger.e("Camera2Manager", new Object[]{"preOpenCamera exception"}, e2);
        }
        SystraceWrapper.endTrace();
    }

    public void setAbsoluteZoomParameter(int i) {
        if (i < 0) {
            i = 0;
        } else if (i >= 100) {
            i = 100;
        }
        J(i);
    }

    public void setCurTorchState(boolean z) {
        CaptureRequest.Builder builder;
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.v;
        if (camera2CharacteristicsCache == null || (builder = this.i) == null || !Camera2ConfigurationUtils.setTorchState(camera2CharacteristicsCache, builder, z)) {
            return;
        }
        K();
        OnCameraStateCallback onCameraStateCallback = this.f;
        if (onCameraStateCallback != null) {
            onCameraStateCallback.onTorchModeChanged(z);
        }
        ScanCodeState scanCodeState = this.E;
        if (scanCodeState != null) {
            scanCodeState.setTorchState(z);
        }
    }

    public void setOpenCameraRetryCount(int i) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setOpenCameraRetryCount:", Integer.valueOf(i)});
        this.D = i;
    }

    public void setRetryStopFlag(boolean z) {
        MPaasLogger.d("Camera2Manager", new Object[]{"setRetryStopFlag, flag:", Boolean.valueOf(z)});
        this.B = z;
    }

    public void setScanRegion(Rect rect) {
        CaptureRequest.Builder builder;
        if (rect == null || this.n == null || !this.d.valid()) {
            return;
        }
        MPaasLogger.d("Camera2Manager", new Object[]{"setScanRegion scanRegion:", rect.toString()});
        this.o = rect;
        if (!this.d.valid() || (builder = this.i) == null) {
            return;
        }
        Camera2ConfigurationUtils.setAfAeRegion(this.v, builder, this.d.previewSize, this.o, this.n);
        K();
    }

    /* JADX WARN: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r3.m < 100) goto L8;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setZoomParameter(int r4) {
        /*
            r3 = this;
            r0 = 0
            r1 = 100
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != r2) goto Lc
            int r4 = r3.m
            if (r4 >= r1) goto L18
            goto L14
        Lc:
            int r2 = r3.m
            int r2 = r2 + r4
            if (r2 >= 0) goto L12
            goto L18
        L12:
            if (r2 <= r1) goto L17
        L14:
            r0 = 100
            goto L18
        L17:
            r0 = r2
        L18:
            r3.J(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.camera2.operation.Camera2Manager.setZoomParameter(int):void");
    }

    public boolean valid() {
        Camera2Config camera2Config = this.d;
        if (camera2Config == null) {
            return false;
        }
        return camera2Config.valid();
    }
}
