package com.alipay.camera.base;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.SystemClock;
import android.view.SurfaceHolder;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraLog;
import com.alipay.camera.util.ManufacturerPermissionChecker;
import java.io.IOException;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class AntCamera implements Camera.ErrorCallback {
    private final String a;
    private final Camera b;
    private int c;
    private int d;
    private Camera.ErrorCallback e;
    private final CameraPerformanceRecorder f;
    private final CameraFocusPerformanceHelper g;
    private StringBuilder h;
    private int i = Integer.MAX_VALUE;
    private String j = null;

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class AutoFocusCallbackProxy implements Camera.AutoFocusCallback {
        @Override // android.hardware.Camera.AutoFocusCallback
        public void onAutoFocus(boolean z, Camera camera) {
        }

        public abstract void onAutoFocusProxy(boolean z, AntCamera antCamera);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class AutoFocusMoveCallbackProxy implements Camera.AutoFocusMoveCallback {
        @Override // android.hardware.Camera.AutoFocusMoveCallback
        public void onAutoFocusMoving(boolean z, Camera camera) {
        }

        public abstract void onAutoFocusMovingProxy(boolean z, AntCamera antCamera);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class ErrorCallbackProxy implements Camera.ErrorCallback {
        @Override // android.hardware.Camera.ErrorCallback
        public void onError(int i, Camera camera) {
        }

        public abstract void onErrorProxy(int i, AntCamera antCamera);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class OnZoomChangeListenerProxy implements Camera.OnZoomChangeListener {
        @Override // android.hardware.Camera.OnZoomChangeListener
        public void onZoomChange(int i, boolean z, Camera camera) {
        }

        public abstract void onZoomChangeProxy(int i, boolean z, AntCamera antCamera);
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static abstract class PreviewCallbackProxy implements Camera.PreviewCallback {
        @Override // android.hardware.Camera.PreviewCallback
        public void onPreviewFrame(byte[] bArr, Camera camera) {
        }

        public abstract void onPreviewFrameProxy(byte[] bArr, AntCamera antCamera);
    }

    protected AntCamera(Camera camera, String str, long j) {
        if (camera == null) {
            throw new RuntimeException("AntCamera construct, but camera is null");
        }
        if (str != null) {
            this.b = camera;
            camera.setErrorCallback(this);
            this.c = 0;
            this.d = 0;
            this.a = str;
            long currentTimeMillis = System.currentTimeMillis();
            CameraPerformanceRecorder cameraPerformanceRecorder = new CameraPerformanceRecorder(false, str);
            this.f = cameraPerformanceRecorder;
            this.g = new CameraFocusPerformanceHelper();
            cameraPerformanceRecorder.setBeginOpenCamera(j);
            cameraPerformanceRecorder.setEndOpenCamera(currentTimeMillis);
            this.h = new StringBuilder();
            return;
        }
        throw new IllegalArgumentException("AntCamera construct, but from is not specified.");
    }

    static /* synthetic */ int b(AntCamera antCamera) {
        int i = antCamera.d;
        antCamera.d = i + 1;
        return i;
    }

    static /* synthetic */ int e(AntCamera antCamera) {
        int i = antCamera.c;
        antCamera.c = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(String str, boolean z) {
        if (this.h.length() == 0) {
            this.i = this.c;
        }
        this.g.offerCamera1FocusState(z, this.c);
        StringBuilder sb = this.h;
        sb.append(this.c + "-" + str);
        this.h.append("##");
    }

    public static void getCameraInfo(int i, Camera.CameraInfo cameraInfo) {
        Camera.getCameraInfo(i, cameraInfo);
    }

    public static int getNumberOfCameras() {
        return Camera.getNumberOfCameras();
    }

    private static Camera h(Class[] clsArr, Object[] objArr) {
        try {
            return (Camera) Class.forName("android.hardware.Camera").getMethod("openLegacy", clsArr).invoke(null, objArr);
        } catch (Throwable th) {
            CameraLog.d("AntCamera", "openLegacy exception:" + th.toString());
            return null;
        }
    }

    private static Camera i(int i, String str) {
        Class cls = Integer.TYPE;
        Camera h = h(new Class[]{cls, cls}, new Object[]{Integer.valueOf(i), 256});
        if (h == null) {
            h = Camera.open(i);
        }
        CameraLog.d("AntCamera", "openLegacy from: " + str);
        return h;
    }

    private void j(CameraStateTracer.CameraEvent cameraEvent, String str) {
        this.j = "###errorEvent=" + cameraEvent + "###errorInfo=" + str + "-" + System.currentTimeMillis();
        CameraStateTracer.recordRuntimeExceptionEvent("AntCamera", this.a, cameraEvent, str);
    }

    public static AntCamera open(String str) {
        CameraStateTracer.recordOpenEvent("AntCamera", str, CameraStateTracer.CameraEvent.OPEN);
        if (str != null) {
            return new AntCamera(Camera.open(), str, System.currentTimeMillis());
        }
        throw new RuntimeException("from is illegal.");
    }

    public static AntCamera openOptimized(CameraConfig cameraConfig) {
        int retryNum;
        if (cameraConfig != null) {
            if (cameraConfig.getCameraId() >= 0 && cameraConfig.getFromTag() != null) {
                if (cameraConfig.isCheckManuPermission() && ManufacturerPermissionChecker.tryToFetchCameraPermissionStatus() != 0) {
                    throw new RuntimeException("Manufacturer Camera Permission is denied");
                }
                CameraStateTracer.recordOpenEvent("AntCamera", cameraConfig.getFromTag(), CameraStateTracer.CameraEvent.OPEN);
                Camera camera = null;
                long currentTimeMillis = System.currentTimeMillis();
                if (cameraConfig.getRetryNum() <= 0) {
                    if (cameraConfig.isOpenLegacy()) {
                        camera = i(cameraConfig.getCameraId(), cameraConfig.getFromTag());
                    } else {
                        camera = Camera.open(cameraConfig.getCameraId());
                    }
                } else {
                    long elapsedRealtime = SystemClock.elapsedRealtime();
                    int retryNum2 = cameraConfig.getRetryNum();
                    String str = "";
                    while (retryNum2 > 0) {
                        boolean z = false;
                        try {
                            CameraLog.d("AntCamera", "retry open camera Num:#" + ((retryNum - retryNum2) + 1));
                            if (cameraConfig.isOpenLegacy()) {
                                camera = i(cameraConfig.getCameraId(), cameraConfig.getFromTag());
                            } else {
                                camera = Camera.open(cameraConfig.getCameraId());
                            }
                        } catch (Exception e) {
                            str = e.getMessage();
                            z = true;
                        }
                        if (!z) {
                            break;
                        }
                        try {
                            Thread.sleep(1000L);
                        } catch (Throwable th) {
                            CameraLog.e("AntCamera", "retry sleep error:" + th.getMessage());
                        }
                        retryNum2--;
                    }
                    CameraLog.d("AntCamera", "openOptimized cost time: " + (SystemClock.elapsedRealtime() - elapsedRealtime));
                    if (retryNum2 > 0) {
                        CameraLog.d("AntCamera", "open Retry success, use times: " + (retryNum - retryNum2));
                    } else {
                        throw new RuntimeException(str);
                    }
                }
                return new AntCamera(camera, cameraConfig.getFromTag(), currentTimeMillis);
            }
            throw new IllegalArgumentException("configBuilder cameraId or tag is illegal.");
        }
        throw new IllegalArgumentException("CameraConfig.Builder is null");
    }

    public void addCallbackBuffer(byte[] bArr) {
        this.b.addCallbackBuffer(bArr);
    }

    public void autoFocus(Camera.AutoFocusCallback autoFocusCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.AUTO_FOCUS);
        this.d = 0;
        try {
            this.b.autoFocus(autoFocusCallback);
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.AUTO_FOCUS_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void cancelAutoFocus() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.CANCEL_AUTO_FOCUS);
        try {
            this.b.cancelAutoFocus();
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.CANCEL_AUTO_FOCUS_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public boolean enableShutterSound(boolean z) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.ENABLE_SHUTTER_SOUND);
        return this.b.enableShutterSound(z);
    }

    public Camera getCamera() {
        return this.b;
    }

    public CameraPerformanceRecorder getCameraPerformanceRecorder() {
        return this.f;
    }

    public int getFirstTriggerFrameCount() {
        return this.i;
    }

    public int getFocusNotStartedFrameCount() {
        return this.d;
    }

    public String getFocusTriggerHistory() {
        return this.h.toString();
    }

    public int getFrameCount() {
        return this.c;
    }

    public String getLatestErrorEventInfo() {
        return this.j;
    }

    public Camera.Parameters getParameters() {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.GET_PARAMETERS);
            return this.b.getParameters();
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.GET_PARAMETERS_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void lock() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.LOCK);
        this.b.lock();
    }

    @Override // android.hardware.Camera.ErrorCallback
    public void onError(int i, Camera camera) {
        CameraStateTracer.recordOnErrorEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.ON_ERROR, i);
        Camera.ErrorCallback errorCallback = this.e;
        if (errorCallback != null) {
            if (errorCallback instanceof ErrorCallbackProxy) {
                ((ErrorCallbackProxy) errorCallback).onErrorProxy(i, camera != null ? this : null);
            } else {
                errorCallback.onError(i, camera);
            }
        }
    }

    public void reconnect() throws IOException {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.RECONNECT);
        this.b.reconnect();
    }

    public void release() {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.RELEASE);
            this.f.setBeginCloseCamera(System.currentTimeMillis());
            this.b.release();
            this.f.setEndCloseCamera(System.currentTimeMillis());
            this.f.setFirstTriggerFrameCount(this.i);
            CameraPerformanceRecorder cameraPerformanceRecorder = this.f;
            StringBuilder sb = this.h;
            sb.append(this.g.getString());
            cameraPerformanceRecorder.setFocusTriggerRecord(sb.toString());
            this.f.setFrameCountAndBuryPerfData(this.c);
        } catch (Exception e) {
            j(CameraStateTracer.CameraEvent.CLOSE_CAMERA_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void setAutoFocusMoveCallback(Camera.AutoFocusMoveCallback autoFocusMoveCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_AUTO_FOCUS_MOVE_CALLBACK);
        this.b.setAutoFocusMoveCallback(autoFocusMoveCallback);
    }

    public void setDisplayOrientation(int i) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_DISPLAY_ORIENTATION);
        this.b.setDisplayOrientation(i);
    }

    public void setErrorCallback(Camera.ErrorCallback errorCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ERROR_CALLBACK);
        this.e = errorCallback;
    }

    public void setFaceDetectionListener(Camera.FaceDetectionListener faceDetectionListener) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_FACE_DETECTION_LISTENER);
        this.b.setFaceDetectionListener(faceDetectionListener);
    }

    public void setOneShotPreviewCallback(Camera.PreviewCallback previewCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ONE_SHOT_PREVIEW_CALLBACK);
        this.b.setOneShotPreviewCallback(previewCallback);
    }

    public void setParameters(Camera.Parameters parameters) {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PARAMETERS);
            this.b.setParameters(parameters);
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.SET_PARAMETERS_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void setPreviewCallback(Camera.PreviewCallback previewCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PREVIEW_CALLBACK);
        this.b.setPreviewCallback(previewCallback);
    }

    public void setPreviewCallbackWithBuffer(Camera.PreviewCallback previewCallback) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PREVIEW_CALLBACK_WITH_BUFFER);
        this.b.setPreviewCallbackWithBuffer(previewCallback);
    }

    public void setPreviewDisplay(SurfaceHolder surfaceHolder) throws IOException {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PREVIEW_DISPLAY);
            this.b.setPreviewDisplay(surfaceHolder);
        } catch (IOException e) {
            j(CameraStateTracer.CameraEvent.SET_PREVIEW_DISPLAY_EXCEPTION, e.getMessage());
            throw e;
        } catch (RuntimeException e2) {
            j(CameraStateTracer.CameraEvent.SET_PREVIEW_DISPLAY_EXCEPTION, e2.getMessage());
            throw e2;
        }
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) throws IOException {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PREVIEW_TEXTURE);
            this.b.setPreviewTexture(surfaceTexture);
        } catch (IOException e) {
            j(CameraStateTracer.CameraEvent.SET_PREVIEW_TEXTURE_EXCEPTION, e.getMessage());
            throw e;
        } catch (RuntimeException e2) {
            j(CameraStateTracer.CameraEvent.SET_PREVIEW_TEXTURE_EXCEPTION, e2.getMessage());
            throw e2;
        }
    }

    public void setZoomChangeListener(Camera.OnZoomChangeListener onZoomChangeListener) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ZOOM_CHANGE_LISTENER);
        this.b.setZoomChangeListener(onZoomChangeListener);
    }

    public void startFaceDetection() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.START_FACE_DETECTION);
        this.b.startFaceDetection();
    }

    public void startPreview() {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.START_PREVIEW);
            this.f.setBeginStartPreview(System.currentTimeMillis());
            this.b.startPreview();
            this.f.setEndStartPreview(System.currentTimeMillis());
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.START_PREVIEW_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void startSmoothZoom(int i) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.START_SMOOTH_ZOOM);
        this.b.startSmoothZoom(i);
    }

    public void stopFaceDetection() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.STOP_FACE_DETECTION);
        this.b.stopFaceDetection();
    }

    public void stopPreview() {
        try {
            CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.STOP_PREVIEW);
            this.f.setBeginStopPreview(System.currentTimeMillis());
            this.b.stopPreview();
            this.f.setEndStopPreview(System.currentTimeMillis());
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.STOP_PREVIEW_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void stopSmoothZoom() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.STOP_SMOOTH_ZOOM);
        this.b.stopSmoothZoom();
    }

    public void takePicture(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2, Camera.PictureCallback pictureCallback3) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.TAKE_PICTURE);
        this.b.takePicture(shutterCallback, pictureCallback, pictureCallback2, pictureCallback3);
    }

    public void unlock() {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.UNLOCK);
        this.b.unlock();
    }

    public static void getCameraInfo(int i, Camera.CameraInfo cameraInfo, String str) {
        try {
            CameraPerformanceRecorder.setBeginGetCameraInfo(System.currentTimeMillis());
            Camera.getCameraInfo(i, cameraInfo);
            CameraPerformanceRecorder.setEndGetCameraInfo(System.currentTimeMillis());
        } catch (Exception e) {
            CameraStateTracer.recordRuntimeExceptionEvent("AntCamera", str, CameraStateTracer.CameraEvent.GET_CAMERA_INFO_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public static int getNumberOfCameras(String str) {
        try {
            CameraPerformanceRecorder.setBeginGetNumberOfCameras(System.currentTimeMillis());
            int numberOfCameras = Camera.getNumberOfCameras();
            CameraPerformanceRecorder.setEndGetNumberOfCameras(System.currentTimeMillis());
            return numberOfCameras;
        } catch (Exception e) {
            CameraStateTracer.recordRuntimeExceptionEvent("AntCamera", str, CameraStateTracer.CameraEvent.GET_NUMBER_OF_CAMERAS_EXCEPTION, e.getMessage());
            throw e;
        }
    }

    public void setAutoFocusMoveCallback(final AutoFocusMoveCallbackProxy autoFocusMoveCallbackProxy) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_AUTO_FOCUS_MOVE_CALLBACK);
        this.b.setAutoFocusMoveCallback(autoFocusMoveCallbackProxy != null ? new Camera.AutoFocusMoveCallback() { // from class: com.alipay.camera.base.AntCamera.3
            @Override // android.hardware.Camera.AutoFocusMoveCallback
            public void onAutoFocusMoving(boolean z, Camera camera) {
                AntCamera.this.d = 0;
                AntCamera antCamera = AntCamera.this;
                antCamera.g("onAutoFocusMoving-" + z, z);
                autoFocusMoveCallbackProxy.onAutoFocusMovingProxy(z, camera != null ? AntCamera.this : null);
            }
        } : null);
    }

    public void setErrorCallback(ErrorCallbackProxy errorCallbackProxy) throws RuntimeException {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ERROR_CALLBACK);
        this.e = errorCallbackProxy;
    }

    public void setOneShotPreviewCallback(final PreviewCallbackProxy previewCallbackProxy) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ONE_SHOT_PREVIEW_CALLBACK);
        this.b.setOneShotPreviewCallback(previewCallbackProxy != null ? new Camera.PreviewCallback() { // from class: com.alipay.camera.base.AntCamera.4
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                previewCallbackProxy.onPreviewFrameProxy(bArr, camera != null ? AntCamera.this : null);
            }
        } : null);
    }

    public void setPreviewCallbackWithBuffer(final PreviewCallbackProxy previewCallbackProxy) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_PREVIEW_CALLBACK_WITH_BUFFER);
        this.b.setPreviewCallbackWithBuffer(previewCallbackProxy != null ? new Camera.PreviewCallback() { // from class: com.alipay.camera.base.AntCamera.2
            @Override // android.hardware.Camera.PreviewCallback
            public void onPreviewFrame(byte[] bArr, Camera camera) {
                AntCamera.e(AntCamera.this);
                AntCamera.b(AntCamera.this);
                if (AntCamera.this.c == 1) {
                    AntCamera.this.f.setEndFirstPreviewFrame(System.currentTimeMillis());
                }
                previewCallbackProxy.onPreviewFrameProxy(bArr, camera != null ? AntCamera.this : null);
            }
        } : null);
    }

    public void setZoomChangeListener(final OnZoomChangeListenerProxy onZoomChangeListenerProxy) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.SET_ZOOM_CHANGE_LISTENER);
        this.b.setZoomChangeListener(onZoomChangeListenerProxy != null ? new Camera.OnZoomChangeListener() { // from class: com.alipay.camera.base.AntCamera.5
            @Override // android.hardware.Camera.OnZoomChangeListener
            public void onZoomChange(int i, boolean z, Camera camera) {
                onZoomChangeListenerProxy.onZoomChangeProxy(i, z, camera != null ? AntCamera.this : null);
            }
        } : null);
    }

    public void takePicture(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback, Camera.PictureCallback pictureCallback2) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.TAKE_PICTURE);
        this.b.takePicture(shutterCallback, pictureCallback, pictureCallback2);
    }

    public static AntCamera open(int i, String str) {
        CameraStateTracer.recordOpenEvent("AntCamera", str, CameraStateTracer.CameraEvent.OPEN);
        return new AntCamera(Camera.open(i), str, System.currentTimeMillis());
    }

    public void autoFocus(final AutoFocusCallbackProxy autoFocusCallbackProxy) {
        CameraStateTracer.recordEvent("AntCamera", this.a, CameraStateTracer.CameraEvent.AUTO_FOCUS);
        this.d = 0;
        g("autoFocus", true);
        try {
            this.b.autoFocus(autoFocusCallbackProxy != null ? new Camera.AutoFocusCallback() { // from class: com.alipay.camera.base.AntCamera.1
                @Override // android.hardware.Camera.AutoFocusCallback
                public void onAutoFocus(boolean z, Camera camera) {
                    AntCamera.this.d = 0;
                    AntCamera antCamera = AntCamera.this;
                    antCamera.g("onAutoFocus-" + z, false);
                    autoFocusCallbackProxy.onAutoFocusProxy(z, camera != null ? AntCamera.this : null);
                }
            } : null);
        } catch (RuntimeException e) {
            j(CameraStateTracer.CameraEvent.AUTO_FOCUS_EXCEPTION, e.getMessage());
            throw e;
        }
    }
}
