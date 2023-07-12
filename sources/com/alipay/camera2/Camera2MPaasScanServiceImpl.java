package com.alipay.camera2;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.params.OutputConfiguration;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.annotation.RequiresPermission;
import com.alipay.camera.base.CameraPerformanceRecorder;
import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera2.operation.Camera2ConfigurationUtils;
import com.alipay.camera2.operation.Camera2FocusManager;
import com.alipay.camera2.operation.Camera2FocusParameterConfig;
import com.alipay.camera2.operation.Camera2Manager;
import com.alipay.camera2.operation.callback.Camera2BqcScanCallback;
import com.alipay.camera2.operation.callback.OnReadImageListener;
import com.alipay.camera2.util.Camera2CharacteristicsCache;
import com.alipay.camera2.util.Camera2Utils;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.BQCScanError;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.watchdog.BQCWatchCallback;
import com.alipay.performance.ScanPerformanceConfig;
import com.alipay.util.CameraFrameWatchdog;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.HashMap;
import java.util.Map;
import tb.jn1;

/* compiled from: Taobao */
@TargetApi(26)
/* loaded from: classes10.dex */
public class Camera2MPaasScanServiceImpl implements Camera2Manager.OnCameraStateCallback, OnReadImageListener.FirstFrameCallback, MPaasScanService {
    private CameraFrameWatchdog A;
    private Context a;
    private Context b;
    private CameraHandler e;
    private Camera2Config f;
    private Camera2CharacteristicsCache g;
    private Camera2AvailabilityCallback h;
    private OnReadImageListener j;
    private Camera2Manager k;
    private Camera2BqcScanCallback n;
    private Camera2SurfaceTextureCallback o;
    private TextureView p;
    private SurfaceTexture q;
    private boolean r;
    private SurfaceHolder s;
    private boolean t;
    private boolean u;
    private Point v;
    private volatile boolean w;
    private ScanCodeState z;
    private boolean c = false;
    private int d = 0;
    private Map<String, Map<String, Object>> i = new HashMap();
    private int l = 4;
    private long m = 1000;
    private int x = 0;
    private boolean y = false;
    private Runnable B = new Runnable() { // from class: com.alipay.camera2.Camera2MPaasScanServiceImpl.1
        @Override // java.lang.Runnable
        public void run() {
            String dynamicBlockEvent;
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2Watchdog run..."});
            try {
                if (Camera2MPaasScanServiceImpl.this.j == null || Camera2MPaasScanServiceImpl.this.j.getFrameCountInCamera() <= 0) {
                    Camera2MPaasScanServiceImpl.this.o(CameraFrameWatchdog.WatcherState.TIMEOUT);
                    String str = "";
                    if (Camera2MPaasScanServiceImpl.this.e != null) {
                        str = "###cameraHandlerStacktrace=" + Camera2MPaasScanServiceImpl.this.e.getStackTrace();
                    }
                    if (Camera2MPaasScanServiceImpl.this.k == null || (dynamicBlockEvent = Camera2MPaasScanServiceImpl.this.k.getDynamicBlockEvent()) == null) {
                        if (Camera2MPaasScanServiceImpl.this.x == 0) {
                            Camera2MPaasScanServiceImpl.this.A.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_HAL_NOT_PRODUCE_FRAME, str, true);
                            Camera2MPaasScanServiceImpl.this.A.postCameraPreviewTimeOut(true, str);
                            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2Watchdog camera hal not produce frame."});
                            return;
                        }
                        String str2 = str + "###errorCode=" + Camera2MPaasScanServiceImpl.this.x;
                        Camera2MPaasScanServiceImpl.this.A.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_ERROR, str2, true);
                        Camera2MPaasScanServiceImpl.this.k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_RUNTIME, Camera2MPaasScanServiceImpl.this.n(str2, 1403), 1403, BQCScanError.CameraAPIType.API2));
                        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2Watchdog camera with error:", str2});
                        return;
                    }
                    String str3 = str + dynamicBlockEvent;
                    Camera2MPaasScanServiceImpl.this.A.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_METHOD_BLOCK, str3, true);
                    Camera2MPaasScanServiceImpl.this.A.postCameraPreviewTimeOut(true, str3);
                    MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2Watchdog camera method block:", str3});
                    return;
                }
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2Watchdog preview frame arrived."});
            } catch (Exception unused) {
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class Camera2SurfaceTextureCallback implements TextureView.SurfaceTextureListener {
        protected Camera2SurfaceTextureCallback() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"Camera2SurfaceTextureCallback:onSurfaceTextureAvailable()", ", width: ", Integer.valueOf(i), ", height: ", Integer.valueOf(i2)});
            try {
                Camera2MPaasScanServiceImpl.this.q(surfaceTexture);
                if (Camera2MPaasScanServiceImpl.this.n != null) {
                    Camera2MPaasScanServiceImpl.this.n.onSurfaceAvaliable();
                }
            } catch (Exception e) {
                MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"onSurfaceTextureAvailable: "}, e);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onSurfaceTextureDestroyed"});
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onSurfaceTextureSizeChanged: new size:", i + Constants.Name.X, Integer.valueOf(i2)});
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public Camera2MPaasScanServiceImpl(Camera2CharacteristicsCache camera2CharacteristicsCache) {
        this.g = camera2CharacteristicsCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void k(BQCScanError bQCScanError) {
        if (bQCScanError == null) {
            return;
        }
        boolean z = BQCScanError.ErrorType.ERROR_CAMERA_CALLBACK == bQCScanError.type;
        this.x = bQCScanError.errorCode;
        Camera2BqcScanCallback camera2BqcScanCallback = this.n;
        if (camera2BqcScanCallback != null) {
            camera2BqcScanCallback.onError(bQCScanError);
        }
        if (z) {
            return;
        }
        stopWatchDogMonitor();
    }

    private void l(String str) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"cameraFailRetryNotice, scene:", str});
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.A;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.postCameraFailRetryNotice(str, true);
            }
        } catch (Throwable unused) {
        }
    }

    private boolean m(int i, String str) {
        return i == 1 && str != null && Camera2Utils.contanisIgnoreCase(str, " disabled by policy");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String n(String str, int i) {
        long currentTimeMillis = this.k != null ? System.currentTimeMillis() - this.k.getCameraPerformanceRecorder().getEndOpenCamera() : -1L;
        if (i != 1200) {
            if (i != 1201) {
                if (i == 1301) {
                    Camera2Manager camera2Manager = this.k;
                    if (camera2Manager != null && camera2Manager.getOpenCameraExecuteDuration() >= 3000) {
                        i = BQCScanError.CameraErrorAPI2.ERROR_CALLBACK_MAX_CAMERA_IN_USE_OPEN_CAMERA_3000MS_TIMEOUT;
                    }
                } else if (i != 1400 && i != 1402) {
                    switch (i) {
                        case 1001:
                            if (!Camera2Utils.contanisIgnoreCase(str, "Unknown camera ID")) {
                                if (Camera2Utils.contanisIgnoreCase(str, "Illegal argument to HAL module for camera")) {
                                    i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_ILLEGALARGUMENT_TO_HAL;
                                    break;
                                }
                            } else {
                                i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_DISABLE_CAMERA_SERVICE_UNKNOWN_CAMERA_ID;
                                break;
                            }
                            break;
                        case 1002:
                            if (!Camera2Utils.contanisIgnoreCase(str, "are not currently allowed to connect to camera")) {
                                if (Camera2Utils.contanisIgnoreCase(str, "without camera permission") || Camera2Utils.contanisIgnoreCase(str, "No permission to open camera")) {
                                    i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_NO_PERMISSION_NO_CAMERA_PERMISSION;
                                    break;
                                }
                            } else {
                                i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_NO_PERMISSION_NOT_ACTIVE_USER_USE_CAMERA;
                                break;
                            }
                            break;
                        case 1003:
                            if (!Camera2Utils.contanisIgnoreCase(str, " disabled by policy")) {
                                if (!Camera2Utils.contanisIgnoreCase(str, " from background")) {
                                    if (!Camera2Utils.contanisIgnoreCase(str, "Camera Function is disabled")) {
                                        if (Camera2Utils.contanisIgnoreCase(str, " privacy ")) {
                                            i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_DISABLE_CAMERA_POLICY_SENSOR_PRIVACY;
                                            break;
                                        }
                                    } else {
                                        i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_DISABLE_CAMERA_POLICY_CAMERA_FUNCTION_DISABLED;
                                        break;
                                    }
                                } else {
                                    i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_DISABLE_CAMERA_POLICY_OPEN_FROM_BACKGROUND;
                                    break;
                                }
                            } else {
                                i = BQCScanError.CameraErrorAPI2.ERROR_DEFAULT_DISABLE_CAMERA_POLICY_DISABLE_BY_POLICY;
                                break;
                            }
                            break;
                    }
                } else if (Camera2Utils.contanisIgnoreCase(str, "The camera device has been disconnected") || Camera2Utils.contanisIgnoreCase(str, "Camera device no longer alive")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_DEVICE_DISCONNECTED;
                } else if (Camera2Utils.contanisIgnoreCase(str, "Camera service has died unexpectedly")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_SERVICE_DIED_UNEXPECTEDLY;
                } else if (Camera2Utils.contanisIgnoreCase(str, "Function not implemented") || Camera2Utils.contanisIgnoreCase(str, "Broken pipe ")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_FUNCTION_NOT_IMPLEMENTED;
                } else if (Camera2Utils.contanisIgnoreCase(str, "Error creating default request for template")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_CREATE_DEFAULT_TEMPLATE_REQUEST_FAIL;
                } else if (Camera2Utils.contanisIgnoreCase(str, "The camera device has encountered a serious error")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_CAMERA_DEVICE_IN_ERROR;
                } else if (Camera2Utils.contanisIgnoreCase(str, "Each request must have at least one Surface target")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_EACH_REQUEST_MUST_HAS_ONE_SURFACE_AT_LEAST;
                } else if (Camera2Utils.contanisIgnoreCase(str, "Surface was abandoned")) {
                    i = BQCScanError.CameraErrorAPI2.ERROR_RUNTIME_SESSION_CREATE_EXCEPTION_SURFACE_ABANDONED;
                }
            } else if (Camera2Utils.contanisIgnoreCase(str, "Higher-priority client using camera")) {
                i = BQCScanError.CameraErrorAPI2.ERROR_OPEN_CAMERA_IN_USE_HIGH_PRIORITY_USING;
            } else if (Camera2Utils.contanisIgnoreCase(str, " is already open")) {
                i = BQCScanError.CameraErrorAPI2.ERROR_OPEN_CAMERA_IN_USE_IS_ALREADY_OPEN;
            }
        } else if (Camera2Utils.contanisIgnoreCase(str, "Camera service is currently unavailable")) {
            i = BQCScanError.CameraErrorAPI2.ERROR_OPEN_CAMERA_DISCONNECTED_SERVICE_UNAVAILABLE;
        } else if (Camera2Utils.contanisIgnoreCase(str, "No camera device with ID ")) {
            i = BQCScanError.CameraErrorAPI2.ERROR_OPEN_CAMERA_DISCONNECTED_CAMERA_DEVICE_UNAVAILABLE;
        }
        String str2 = "###ErrorMsg=" + String.valueOf(str) + "###SubErrorCode=" + String.valueOf(i) + "###ErrorTime=" + Camera2Utils.getCurrentTime() + "###LastErrorCode=" + String.valueOf(this.x) + "###LatestEvictOwner=" + String.valueOf(CameraStateTracer.getLatestEvictOwner()) + "###AllCameraUnAvailable=" + String.valueOf(CameraStateTracer.isAllCameraUnAvailable()) + "###CameraAvailableStatusHistory=" + String.valueOf(CameraStateTracer.getCameraAvailableStatusMap()) + "###FromOpenedDuration=" + String.valueOf(currentTimeMillis);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"processErrorMsg:", str2});
        return str2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(CameraFrameWatchdog.WatcherState watcherState) {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.A;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.setWatcherState(watcherState);
            }
        } catch (Throwable unused) {
        }
    }

    @RequiresPermission("android.permission.CAMERA")
    private void p() throws CameraAccessException {
        CameraAccessException cameraAccessException;
        boolean z;
        int i = this.l;
        if (i <= 0 || this.k == null) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int i2 = i;
        CameraAccessException cameraAccessException2 = null;
        boolean z2 = false;
        while (i2 > 0) {
            try {
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"retry open camera, mRetryStopFlag:", Boolean.valueOf(this.y), " Num:#", Integer.valueOf((this.l - i2) + 1)});
                this.k.openCamera();
                cameraAccessException = null;
                z = false;
            } catch (CameraAccessException e) {
                MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"retryOpenCamera failed:"}, e);
                cameraAccessException = e;
                z = true;
            }
            if (z && !this.y) {
                if ((this.l - i2) + 1 == 3) {
                    l("Camera");
                }
                try {
                    Thread.sleep(this.m);
                } catch (Throwable th) {
                    MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"retry sleep error:"}, th);
                }
                if (!this.y) {
                    i2--;
                    cameraAccessException2 = cameraAccessException;
                    z2 = z;
                }
            }
            cameraAccessException2 = cameraAccessException;
            z2 = z;
        }
        this.k.setOpenCameraRetryCount(this.l - i2);
        String message = cameraAccessException2 == null ? "Null" : cameraAccessException2.getMessage();
        Class cls = Boolean.TYPE;
        WalletBury.addWalletBury("recordCamera2RetryInfo", new Class[]{String.class, cls, Integer.TYPE, Long.TYPE, cls, String.class}, new Object[]{String.valueOf(Camera2Manager.Camera2RetryFlag.OPEN_EXCEPTION_RETRY), Boolean.valueOf(!z2), Integer.valueOf(this.l - i2), Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime), Boolean.valueOf(this.y), message});
        boolean z3 = this.y;
        if (!z3 && z2) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"retry open camera finally failed, retry count:", Integer.valueOf(this.l - i2)});
            throw cameraAccessException2;
        } else {
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"retry open camera end, mRetryStopFlag:", Boolean.valueOf(z3), ", isRetryFailed:", Boolean.valueOf(z2)});
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(SurfaceTexture surfaceTexture) {
        if (surfaceTexture != null) {
            this.q = surfaceTexture;
            if (this.f.valid()) {
                SurfaceTexture surfaceTexture2 = this.q;
                Point point = this.f.downgradePreviewSize;
                surfaceTexture2.setDefaultBufferSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void adjustExposureState(int i) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"adjustExposureState:", Integer.valueOf(i)});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void changeCameraFeature(BQCCameraParam.CameraConfigType cameraConfigType, Object... objArr) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean checkEngineRegister(String str) {
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener == null) {
            return false;
        }
        return onReadImageListener.checkEngineRegister(str);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void cleanup(long j) {
        this.b = null;
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager != null) {
            camera2Manager.destroy();
            this.k = null;
        }
        Camera2BqcScanCallback camera2BqcScanCallback = this.n;
        if (camera2BqcScanCallback != null) {
            camera2BqcScanCallback.destroy();
        }
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            onReadImageListener.cleanUp();
            this.j = null;
        }
        ScanRecognizedExecutor.close();
        this.c = false;
        TextureView textureView = this.p;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.p = null;
        }
        this.q = null;
        this.r = false;
        if (this.t) {
            this.s = null;
        }
        this.w = false;
        this.x = 0;
        this.d = 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void enableCameraOpenWatcher(boolean z) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"enableCameraOpenWatcher enabled:", Boolean.valueOf(z)});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Camera getCamera() {
        return null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCameraDisplayOrientation() {
        return 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraFocusStateDescription getCameraFocusStateDescription() {
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager != null) {
            return camera2Manager.getCameraFocusStateDescription();
        }
        return null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraHandler getCameraHandler() {
        return this.e;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Object getCameraParam(String str) {
        Camera2CharacteristicsCache camera2CharacteristicsCache;
        if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_HEIGHT)) {
            Camera2Manager camera2Manager = this.k;
            if (camera2Manager != null && camera2Manager.valid()) {
                try {
                    return Integer.valueOf(this.k.getPreviewHeight());
                } catch (Exception unused) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_WIDTH)) {
            Camera2Manager camera2Manager2 = this.k;
            if (camera2Manager2 != null && camera2Manager2.valid()) {
                try {
                    return Integer.valueOf(this.k.getPreviewWidth());
                } catch (Exception unused2) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_SIZE)) {
            Camera2Manager camera2Manager3 = this.k;
            if (camera2Manager3 != null) {
                try {
                    int previewWidth = camera2Manager3.getPreviewWidth();
                    int previewHeight = this.k.getPreviewHeight();
                    if (previewWidth > 0 && previewHeight > 0) {
                        return new Point(previewWidth, previewHeight);
                    }
                } catch (Exception unused3) {
                }
            }
            return null;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_FACING)) {
            return Integer.valueOf(this.d);
        } else {
            if (!TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_ROTATE_ORIENTATION) || (camera2CharacteristicsCache = this.g) == null) {
                return null;
            }
            return camera2CharacteristicsCache.getSensorOrientation();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Context getContext() {
        return this.b;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public String getCurCameraVitalParameters() {
        return null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getCurrentWhetherUseManualFocus() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"getCurrentWhetherUseManualFocus"});
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCurrentZoom() {
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager == null || !camera2Manager.valid()) {
            return 0;
        }
        return this.k.getCurZoom();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getEngineRunningInfo(String str) {
        try {
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                return onReadImageListener.getEngineRunningInfo(str);
            }
            return null;
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"getSpecEngineExtInfo: "}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getFirstSetup() {
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long getFrameCountInCamera() {
        try {
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                return onReadImageListener.getFrameCountInCamera();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getMaxZoom() {
        return 100;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long[] getRecognizeResult() {
        try {
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                return onReadImageListener.getRecognizeResult();
            }
            return null;
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"getRecognizeResult()"}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public ScanCodeState getScanCodeState() {
        return this.z;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getSpecEngineExtInfo(String str) {
        try {
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                return onReadImageListener.getSpecEngineExtInfo(str);
            }
            return null;
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"getSpecEngineExtInfo: "}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Runnable getWatchdogRunnable() {
        return this.B;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isCameraClosed() {
        return this.k == null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isPreviewing() {
        throw new UnsupportedOperationException("Do not use this");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isScanEnable() {
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener == null) {
            return false;
        }
        return onReadImageListener.isScanEnable();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isTorchOn() {
        return this.w;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void needDowngrade(boolean z) {
        try {
            ScanPerformanceConfig.updateRuntimeNeedDowngrade(z);
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                onReadImageListener.needDowngrade(z);
            }
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"needDowngrade: "}, e);
        }
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onCamera2Closed() {
        this.c = false;
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            onReadImageListener.setCameraValid(false);
        }
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onCamera2Opened() {
        OutputConfiguration outputConfiguration;
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onCamera2Opened"});
        this.c = true;
        o(CameraFrameWatchdog.WatcherState.CAMERA_END);
        Camera2BqcScanCallback camera2BqcScanCallback = this.n;
        if (camera2BqcScanCallback != null) {
            camera2BqcScanCallback.onCameraOpened();
        }
        o(CameraFrameWatchdog.WatcherState.PREVIEW_START);
        boolean z = this.s == null && this.q == null;
        boolean z2 = Camera2ConfigManager.sUseDeferredPreviewSurface && z;
        this.u = z2;
        if (z2) {
            if (this.t) {
                Point point = this.f.previewSize;
                outputConfiguration = new OutputConfiguration(new Size(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)), SurfaceHolder.class);
            } else {
                Point point2 = this.f.downgradePreviewSize;
                outputConfiguration = new OutputConfiguration(new Size(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2)), SurfaceTexture.class);
            }
            Camera2Manager camera2Manager = this.k;
            if (camera2Manager != null) {
                camera2Manager.createCameraPreviewSessionByOutputConfiguration(outputConfiguration);
            }
        }
        if (!z) {
            onSurfaceAvailable();
        }
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            onReadImageListener.setCameraValid(true);
            this.j.setNeedReportPreviewGot(true);
        }
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onCamera2Opened end, surfaceNotReady:", Boolean.valueOf(z)});
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onCaptureSessionConfigureFailed() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onCaptureSessionConfigureFailed"});
        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_CALLBACK, n("Session Configured Fail", BQCScanError.CameraErrorAPI2.ERROR_CALLBACK_SESSION_CONFIG_FAIL), BQCScanError.CameraErrorAPI2.ERROR_CALLBACK_SESSION_CONFIG_FAIL, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onCaptureSessionConfigured() {
        o(CameraFrameWatchdog.WatcherState.PREVIEW_END);
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onCreateCaptureSessionError(int i, String str) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onCreateCaptureSessionError errCode:", Integer.valueOf(i), ", errMsg:", str});
        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_RUNTIME, n(str, 1400), 1400, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onError(CameraDevice cameraDevice, int i, boolean z) {
        int callbackErrorToInternalErrorCode;
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onError:", Integer.valueOf(i), ", whetherOpenError:", Boolean.valueOf(z)});
        if (cameraDevice == null) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"onError but camera is null."});
            return;
        }
        this.c = false;
        if (z) {
            callbackErrorToInternalErrorCode = BQCScanError.callbackErrorToOpenErrorCode(i);
        } else {
            callbackErrorToInternalErrorCode = BQCScanError.callbackErrorToInternalErrorCode(i);
        }
        BQCScanError.ErrorType errorType = z ? BQCScanError.ErrorType.ERROR_CAMERA_OPEN : BQCScanError.ErrorType.ERROR_CAMERA_CALLBACK;
        k(new BQCScanError(errorType, n("CameraDevice.onError id:" + cameraDevice.getId(), callbackErrorToInternalErrorCode), callbackErrorToInternalErrorCode, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onFinalizeOutputConfigurationsError(int i, String str) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onFinalizeOutputConfigurationsError erroCode:", Integer.valueOf(i), ", errMsg:", str});
        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_RUNTIME, n(str, 1401), 1401, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.camera2.operation.callback.OnReadImageListener.FirstFrameCallback
    public void onFirstFrameArrived(long j) {
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager != null) {
            camera2Manager.onFirstFrameArrived(j);
        }
        stopWatchDogMonitor();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void onMovementStatusChanged(boolean z) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onMovementStatusChanged:", Boolean.valueOf(z)});
        try {
            Camera2Manager camera2Manager = this.k;
            if (camera2Manager != null) {
                camera2Manager.onMovementStatusChanged(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onRetryOpenCameraError(int i, String str) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onRetryOpenCameraError errCode:", Integer.valueOf(i), ", errMsg:", str});
        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(str, i), i, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onSetCaptureRequestError(int i, String str) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onSetCaptureRequestError erroCode:", Integer.valueOf(i), ", errMsg:", str});
        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_RUNTIME, n(str, 1402), 1402, BQCScanError.CameraAPIType.API2));
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void onSurfaceAvailable() {
        SurfaceTexture surfaceTexture;
        SurfaceHolder surfaceHolder;
        Object[] objArr = new Object[10];
        objArr[0] = "onSurfaceAvailable:surfaceTexture==null?";
        objArr[1] = Boolean.valueOf(this.q == null);
        objArr[2] = ", mUseDeferredSurface:";
        objArr[3] = Boolean.valueOf(this.u);
        objArr[4] = ", surfaceHolder=null?:";
        objArr[5] = Boolean.valueOf(this.s == null);
        objArr[6] = ", surfaceAlreadySet:";
        objArr[7] = Boolean.valueOf(this.r);
        objArr[8] = ", mPreviewUseSurfaceView:";
        objArr[9] = Boolean.valueOf(this.t);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        if (this.c && this.k != null && !this.r) {
            SurfaceHolder surfaceHolder2 = this.s;
            if ((surfaceHolder2 != null && surfaceHolder2.getSurface().isValid()) || ((surfaceTexture = this.q) != null && !surfaceTexture.isReleased())) {
                this.r = true;
                Surface surface = null;
                if (this.t && (surfaceHolder = this.s) != null) {
                    surface = surfaceHolder.getSurface();
                    ScanCodeState scanCodeState = this.z;
                    if (scanCodeState != null) {
                        scanCodeState.setUseSurface(true);
                    }
                } else {
                    SurfaceTexture surfaceTexture2 = this.q;
                    if (surfaceTexture2 != null) {
                        Point point = this.f.downgradePreviewSize;
                        surfaceTexture2.setDefaultBufferSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                        surface = new Surface(this.q);
                        ScanCodeState scanCodeState2 = this.z;
                        if (scanCodeState2 != null) {
                            scanCodeState2.setUseSurface(false);
                        }
                    }
                }
                if (this.u) {
                    this.k.finalizePreviewOutputConfiguration(surface);
                } else {
                    this.k.createCameraPreviewSession(surface);
                }
                Camera2BqcScanCallback camera2BqcScanCallback = this.n;
                if (camera2BqcScanCallback != null) {
                    camera2BqcScanCallback.onCameraReady();
                    return;
                }
                return;
            }
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"onSurfaceAvailable surface status error."});
            return;
        }
        MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"onSurfaceAvailable ignore."});
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void onTorchModeChanged(boolean z) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"onTorchModeChanged : ", Boolean.valueOf(z)});
        this.w = z;
        Camera2BqcScanCallback camera2BqcScanCallback = this.n;
        if (camera2BqcScanCallback != null) {
            camera2BqcScanCallback.onTorchState(z);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void postCloseCamera() {
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.postCloseCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void preOpenCamera() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"preOpenCamera"});
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.preOpenCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void processWhetherStopMaRecognize(boolean z, Runnable runnable) {
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            onReadImageListener.processWhetherStopMaRecognize(z, runnable);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void reconnectCamera() {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void refocus() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"refocus"});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"regScanEngine()"});
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            onReadImageListener.regScanEngine(str, cls, engineCallback);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void registerExecutorCallback(ScanRecognizedExecutor.RecognizeExecutorCallback recognizeExecutorCallback) {
        ScanRecognizedExecutor.registerRecognizeCallback(recognizeExecutorCallback);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void release() {
        this.v = null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void requestCameraPreviewWatcherDog(long j, BQCWatchCallback bQCWatchCallback) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"requestCameraPreviewWatcherDog camera2"});
        try {
            if (this.A == null) {
                this.A = new CameraFrameWatchdog(bQCWatchCallback, j, getWatchdogRunnable());
            }
            o(CameraFrameWatchdog.WatcherState.INIT);
            startWatchDogMonitor();
        } catch (Exception unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void sendOperationCameraInstructions(BQCCameraParam.CameraOperationInstruction cameraOperationInstruction, String str, String str2) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceInit(Bundle bundle) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"serviceInit"});
        CameraHandler cameraHandler = new CameraHandler();
        this.e = cameraHandler;
        cameraHandler.setBqcScanService(this);
        this.h = new Camera2AvailabilityCallback(this.a, this.e.getCameraHandler());
        String string = bundle != null ? bundle.getString(BQCCameraParam.ServicePropertyParam.NOT_SELF_DIAGNOSE, null) : null;
        ScanCodeState scanCodeState = new ScanCodeState(2);
        this.z = scanCodeState;
        scanCodeState.setEnable(true ^ TextUtils.equals(string, BQCCameraParam.VALUE_YES));
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceOut(Bundle bundle) {
        this.e.destroy();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraId(int i) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraParam(String str, Object obj) {
        int i;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            int i2 = 4;
            if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_MAX_RETRY_OPEN_NUM) && (obj instanceof String)) {
                try {
                    this.l = Integer.parseInt((String) obj);
                } catch (Exception unused) {
                    this.l = 4;
                }
                Camera2Manager.setMaxRetryNum(this.l);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"mMaxRetryNum = ", Integer.valueOf(this.l)});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_SERVICE_CONFIG_PREVIEW_SIZE_RULE) && (obj instanceof String)) {
                CameraConfigurationUtils.setPreviewSizeRule((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"previewSizeRule = ", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_DYNAMICAL_PREVIEWSIZE) && (obj instanceof String)) {
                CameraConfigurationUtils.setEnableDynamicPreviewSize((String) obj);
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_MAX_RETRY_START_PREVIEW_NUM) && (obj instanceof String)) {
                try {
                    i2 = Integer.parseInt((String) obj);
                } catch (Exception unused2) {
                }
                Camera2Manager.setMaxRetryStartPreviewNum(i2);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"mMaxRetryPreviewNum = ", Integer.valueOf(i2)});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_ENABLE_BEST_RECOGNIZE_PREVIEW_SIZE) && (obj instanceof String)) {
                Camera2Manager.setEnableChooseBestForRecognizeYUV((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"bestRecognizeEnable = ", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_AE_AF_REGION_BOX_PROPORTION) && (obj instanceof String)) {
                try {
                    i = Integer.parseInt((String) obj);
                } catch (Exception unused3) {
                    i = 2;
                }
                Camera2ConfigurationUtils.setRegionBoxProportion(i);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"AEAFRegionBoxProportion = ", Integer.valueOf(i)});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_SECOND_FOCUS_MODE_SUPPORT) && (obj instanceof String)) {
                Camera2Manager.setEnableSecondFocusModeSwitch((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setEnableSecondFocusModeSwitch = ", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_SUPPORT_INIT_FOCUS_DISTANCE) && (obj instanceof String)) {
                Camera2ConfigurationUtils.setFocusDistanceSupportValue((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setFocusDistanceSupportValue = ", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_FOCUS_DISTANCE_INFO) && (obj instanceof String)) {
                Camera2FocusParameterConfig.updateInitFocusDistance((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"updateInitFocusDistance = ", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_PICTURE_SIZE_TIMES) && (obj instanceof String)) {
                Camera2Utils.setPictureSizeTimes((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setPictureSizeTimes =", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_FOCUS_ABNORMAL_CHECK_PARAMS) && (obj instanceof String)) {
                Camera2FocusAbnormalChecker.updateFocusAbnormalCheckParams((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"updateFocusAbnormalCheckParams =", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_THRESHOLD_SWITCH_TO_AUTO_DURATION) && (obj instanceof String)) {
                Camera2FocusManager.updateThresholdSwitchToAutoDuration((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"updateThresholdSwitchToAutoDuration =", obj});
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA2_PIPELINE_MODE) && (obj instanceof String)) {
                Camera2ConfigurationUtils.setPipelineMode((String) obj);
                MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setPipelineMode =", obj});
            }
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"setCameraParam: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setContext(Context context) {
        Object[] objArr = new Object[2];
        objArr[0] = "setContext:context==null?";
        objArr[1] = Boolean.valueOf(context == null);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        this.a = context;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView) {
        if (textureView == null) {
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay(): view = null"});
            TextureView textureView2 = this.p;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "setDisplay():surfaceCallback is null:";
        objArr[1] = Boolean.valueOf(this.o == null);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        textureView.setSurfaceTextureListener(this.o);
        if (textureView.isAvailable()) {
            q(textureView.getSurfaceTexture());
            Object[] objArr2 = new Object[2];
            objArr2[0] = "setDisplay: surfaceTexture is null:";
            objArr2[1] = Boolean.valueOf(this.q == null);
            MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr2);
        } else {
            this.q = null;
        }
        this.p = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplayTexture(SurfaceTexture surfaceTexture) {
        Object[] objArr = new Object[2];
        objArr[0] = "setDisplayTexture==null?";
        objArr[1] = Boolean.valueOf(surfaceTexture == null);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        if (surfaceTexture == null) {
            return;
        }
        q(surfaceTexture);
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineExtInfo(String str, Object obj) {
        try {
            OnReadImageListener onReadImageListener = this.j;
            if (onReadImageListener != null) {
                onReadImageListener.setEngineExtInfo(str, obj);
            }
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"setSpecEngineExtInfo: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(Map<String, Object> map) {
        setEngineParameters("MA", map);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setExposureState(int i) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setExposureState:", Integer.valueOf(i)});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusArea(final Rect rect) {
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera2.Camera2MPaasScanServiceImpl.5
                @Override // java.lang.Runnable
                public void run() {
                    Object[] objArr = new Object[2];
                    objArr[0] = "setFocusArea rect: ";
                    Rect rect2 = rect;
                    objArr[1] = rect2 == null ? "null" : rect2.toString();
                    MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
                    if (Camera2MPaasScanServiceImpl.this.k == null || !Camera2MPaasScanServiceImpl.this.k.valid()) {
                        return;
                    }
                    Camera2MPaasScanServiceImpl.this.k.setScanRegion(rect);
                }
            });
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusPosition(int i, int i2) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setFocusPosition:(", Integer.valueOf(i), ",", Integer.valueOf(i2), jn1.BRACKET_END_STR});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setOpenRetryStopFlag(boolean z) {
        try {
            this.y = z;
            Camera2Manager camera2Manager = this.k;
            if (camera2Manager != null) {
                camera2Manager.setRetryStopFlag(z);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setPreviewCallback() {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanEnable(boolean z) {
        Camera2BqcScanCallback camera2BqcScanCallback;
        OnReadImageListener onReadImageListener;
        try {
            Camera2Manager camera2Manager = this.k;
            if (camera2Manager != null && camera2Manager.valid() && (onReadImageListener = this.j) != null) {
                onReadImageListener.setScanEnable(z);
            }
            if (!z || (camera2BqcScanCallback = this.n) == null) {
                return;
            }
            camera2BqcScanCallback.onSetScanEngineEnable();
        } catch (Exception e) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{e.getMessage()});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect) {
        setScanRegion(rect, this.v);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str) {
        return setScanType(str, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setServiceParameters(Map<String, String> map) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setServiceParameters"});
        if (map == null) {
            return;
        }
        if (TextUtils.equals(map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SCAN_EXECUTOR), BQCCameraParam.VALUE_YES)) {
            ScanRecognizedExecutor.sUseNewExecutor = true;
        } else {
            ScanRecognizedExecutor.sUseNewExecutor = false;
        }
        String str = map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SURFACE);
        if (str != null) {
            if (TextUtils.equals(str, BQCCameraParam.VALUE_YES)) {
                this.t = true;
            } else {
                this.t = false;
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setTorch(final boolean z) {
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera2.Camera2MPaasScanServiceImpl.2
                @Override // java.lang.Runnable
                public void run() {
                    if (Camera2MPaasScanServiceImpl.this.k != null) {
                        Camera2MPaasScanServiceImpl.this.k.setCurTorchState(z);
                    }
                }
            });
            this.w = z;
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setTorch mTorchState:", Boolean.valueOf(this.w)});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setTraceLogger(MPaasLogger.BqcLogger bqcLogger) {
        if (bqcLogger != null) {
            MPaasLogger.registerBqcLogger(bqcLogger);
        } else {
            MPaasLogger.unRegisterBqcLogger();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setZoom(final int i) {
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera2.Camera2MPaasScanServiceImpl.3
                @Override // java.lang.Runnable
                public void run() {
                    MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setZoom: ", Integer.valueOf(i)});
                    if (Camera2MPaasScanServiceImpl.this.k == null || !Camera2MPaasScanServiceImpl.this.k.valid()) {
                        return;
                    }
                    Camera2MPaasScanServiceImpl.this.k.setZoomParameter(i);
                }
            });
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setZoomAbsoluteRatio(final int i) {
        CameraHandler cameraHandler = this.e;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera2.Camera2MPaasScanServiceImpl.4
                @Override // java.lang.Runnable
                public void run() {
                    MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setAbsoluteZoom: ", Integer.valueOf(i)});
                    if (Camera2MPaasScanServiceImpl.this.k == null || !Camera2MPaasScanServiceImpl.this.k.valid()) {
                        return;
                    }
                    Camera2MPaasScanServiceImpl.this.k.setAbsoluteZoomParameter(i);
                }
            });
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback) {
        setup(context, bQCScanCallback, 0);
    }

    @Override // com.alipay.camera2.operation.Camera2Manager.OnCameraStateCallback
    public void showRetryInfoToUser(String str) {
        l(str);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void startPreview() {
        Camera2CharacteristicsCache camera2CharacteristicsCache;
        try {
            Object[] objArr = new Object[2];
            objArr[0] = "startPreview,";
            Camera2AvailabilityCallback camera2AvailabilityCallback = this.h;
            objArr[1] = camera2AvailabilityCallback == null ? "null" : camera2AvailabilityCallback.getCameraAvailableInfo();
            MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
            if (this.k != null && (camera2CharacteristicsCache = this.g) != null) {
                if (camera2CharacteristicsCache.valid() && this.k.valid()) {
                    try {
                        try {
                            this.k.addCameraStateCallback(this);
                            o(CameraFrameWatchdog.WatcherState.CAMERA_START);
                            this.k.openCamera();
                            this.k.setOpenCameraRetryCount(0);
                            return;
                        } catch (CameraAccessException e) {
                            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"openCamera with exception:"}, e);
                            if (m(e.getReason(), e.getMessage())) {
                                MPaasLogger.w("Camera2MPaasScanServiceImpl", new Object[]{"Camera disabled by policy, no need retry."});
                                this.k.setOpenCameraRetryCount(this.l);
                                k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e.getMessage(), BQCScanError.openErrorToInternalErrorCode(e.getReason())), e.getReason(), BQCScanError.CameraAPIType.API2));
                                return;
                            } else if (this.l > 0) {
                                try {
                                    p();
                                    return;
                                } catch (CameraAccessException e2) {
                                    MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"retryOpenCamera with exception:"}, e2);
                                    k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e2.getMessage(), BQCScanError.openErrorToInternalErrorCode(e2.getReason())), e2.getReason(), BQCScanError.CameraAPIType.API2));
                                    return;
                                }
                            } else {
                                k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e.getMessage(), BQCScanError.openErrorToInternalErrorCode(e.getReason())), e.getReason(), BQCScanError.CameraAPIType.API2));
                                return;
                            }
                        } catch (SecurityException e3) {
                            k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e3.getMessage(), 1002), 1002, BQCScanError.CameraAPIType.API2));
                            return;
                        }
                    } catch (IllegalArgumentException e4) {
                        k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e4.getMessage(), 1001), 1001, BQCScanError.CameraAPIType.API2));
                        return;
                    }
                }
                BQCScanError bQCScanError = this.g.getBQCScanError();
                if (bQCScanError != null) {
                    k(bQCScanError);
                }
                Object[] objArr2 = new Object[5];
                objArr2[0] = "startPreview init error";
                objArr2[1] = ", mCamera2BqcScanCallback==null?";
                objArr2[2] = Boolean.valueOf(this.n == null);
                objArr2[3] = ", cache:";
                objArr2[4] = this.g.toString();
                MPaasLogger.e("Camera2MPaasScanServiceImpl", objArr2);
                return;
            }
            MPaasLogger.w("Camera2MPaasScanServiceImpl", new Object[]{"startPreview status not ready, ignore."});
        } catch (Exception e5) {
            MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"start preview error"}, e5);
            k(new BQCScanError(BQCScanError.ErrorType.ERROR_CAMERA_OPEN, n(e5.getMessage(), 1000), 1000, BQCScanError.CameraAPIType.API2));
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void startWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.A;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.startWatch();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopAutoFocus() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"stopAutoFocus"});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopPreview() {
        long j;
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"stopPreview"});
        setScanEnable(false);
        OnReadImageListener onReadImageListener = this.j;
        if (onReadImageListener != null) {
            j = onReadImageListener.getFrameCountInCamera();
            this.j.cleanUp();
            this.j = null;
        } else {
            j = 0;
        }
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager != null && camera2Manager.valid()) {
            this.k.closeCamera();
            this.k.getCameraPerformanceRecorder().setFocusTriggerRecord(this.k.getAfStateHistory());
            this.k.getCameraPerformanceRecorder().setFrameCountAndBuryPerfData(j);
            this.c = false;
        }
        this.r = false;
        Camera2BqcScanCallback camera2BqcScanCallback = this.n;
        if (camera2BqcScanCallback != null) {
            camera2BqcScanCallback.onCameraClose();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.A;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.stopWatch();
                this.A = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void takePicture(MPaasScanService.OnPictureTakenListener onPictureTakenListener) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPostCloseCamera() {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPreOpenCamera() {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"tryPreOpenCamera, ", this.h.getCameraAvailableInfo()});
        if (this.g == null) {
            this.g = new Camera2CharacteristicsCache(this.a, true);
        }
        if (this.j == null) {
            this.j = new OnReadImageListener(this.a, this.i, true, this, this.z);
        }
        if (this.k == null) {
            Camera2Manager camera2Manager = new Camera2Manager(this.a, this.e, this.f, this.j, this.g, this.z);
            this.k = camera2Manager;
            this.f = camera2Manager.getCameraConfig();
        }
        this.k.preOpenCamera();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void updateServiceInitInfo(String str) {
        CameraPerformanceRecorder.updateServiceInitInfo(str);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean useAPI2() {
        return true;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void useViewFrameToRecognize(Bitmap bitmap) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(String str, Map<String, Object> map) {
        OnReadImageListener onReadImageListener;
        if (str == null || (onReadImageListener = this.j) == null) {
            return;
        }
        onReadImageListener.setEngineParams(str, map);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect, Point point) {
        OnReadImageListener onReadImageListener;
        this.v = point;
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager == null || !camera2Manager.valid() || (onReadImageListener = this.j) == null) {
            return;
        }
        onReadImageListener.setScanRegion(rect);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType) {
        return setScanType(str, maEngineType, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback, int i) {
        Object[] objArr = new Object[4];
        objArr[0] = "setup() ctx=null?";
        objArr[1] = Boolean.valueOf(context == null);
        objArr[2] = ", cameraFacingType:";
        objArr[3] = Integer.valueOf(i);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        SystraceWrapper.beginTrace("Camera2MPaasScanServiceImpl.setup");
        if (context == null) {
            return;
        }
        this.b = context;
        this.d = i;
        this.o = new Camera2SurfaceTextureCallback();
        this.n = new Camera2BqcScanCallback(bQCScanCallback);
        if (this.j == null) {
            this.j = new OnReadImageListener(context, this.i, true, this, this.z);
        }
        this.j.setResultCallback(bQCScanCallback);
        Camera2CharacteristicsCache camera2CharacteristicsCache = this.g;
        if (camera2CharacteristicsCache == null || this.d != camera2CharacteristicsCache.getAPI1Facing()) {
            this.g = new Camera2CharacteristicsCache(this.a, this.d, true);
        }
        this.g.initCamera2CharacteristicsCache();
        if (this.k == null) {
            Camera2Manager camera2Manager = new Camera2Manager(context, this.e, this.f, this.j, this.g, this.z);
            this.k = camera2Manager;
            this.f = camera2Manager.getCameraConfig();
        }
        this.n.onParametersSetted(0L);
        ScanRecognizedExecutor.open();
        SystraceWrapper.endTrace();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2) {
        boolean z;
        OnReadImageListener onReadImageListener;
        Camera2BqcScanCallback camera2BqcScanCallback;
        Camera2Manager camera2Manager = this.k;
        if (camera2Manager == null || !camera2Manager.valid() || (onReadImageListener = this.j) == null) {
            z = false;
        } else {
            z = onReadImageListener.setScanType(str, maEngineType, str2);
            if (z && (camera2BqcScanCallback = this.n) != null) {
                camera2BqcScanCallback.onEngineLoadSuccess();
            }
        }
        Object[] objArr = new Object[9];
        objArr[0] = "setScanType result:";
        objArr[1] = Boolean.valueOf(z);
        objArr[2] = ",(";
        objArr[3] = str;
        objArr[4] = AVFSCacheConstants.COMMA_SEP;
        objArr[5] = maEngineType == null ? "null" : maEngineType.name();
        objArr[6] = AVFSCacheConstants.COMMA_SEP;
        objArr[7] = str2;
        objArr[8] = jn1.BRACKET_END_STR;
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        return z;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView, boolean z) {
        MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay():TextureView, surfaceTextureSet:", Boolean.valueOf(z)});
        if (textureView == null) {
            TextureView textureView2 = this.p;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "setDisplay():TextureView setSurfaceTextureListener=null?";
        objArr[1] = Boolean.valueOf(this.o == null);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        textureView.setSurfaceTextureListener(this.o);
        if (!z) {
            boolean isAvailable = textureView.isAvailable();
            if (isAvailable) {
                q(textureView.getSurfaceTexture());
            } else {
                this.q = null;
            }
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay():TextureView.isAvailable():", Boolean.valueOf(isAvailable), ", surfaceTexture is ", this.q});
        }
        this.p = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(SurfaceView surfaceView) {
        Camera2Config camera2Config;
        Object[] objArr = new Object[3];
        objArr[0] = "setDisplay SurfaceView mPreviewUseSurfaceView:";
        objArr[1] = Boolean.valueOf(this.t);
        StringBuilder sb = new StringBuilder();
        sb.append(", mCamera2Config=null?");
        sb.append(this.f);
        objArr[2] = Boolean.valueOf(sb.toString() == null);
        MPaasLogger.d("Camera2MPaasScanServiceImpl", objArr);
        if (this.t && (camera2Config = this.f) != null && camera2Config.valid()) {
            SurfaceHolder holder = surfaceView.getHolder();
            Rect surfaceFrame = holder.getSurfaceFrame();
            if (surfaceFrame == null) {
                MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay surfaceRect == null"});
                return;
            }
            Point point = this.f.previewSize;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (xVar == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(surfaceFrame) && yVar == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.height(surfaceFrame)) {
                MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay SurfaceView previewWidth=", Integer.valueOf(xVar), ",previewHeight=", Integer.valueOf(yVar)});
                this.s = holder;
                Camera2BqcScanCallback camera2BqcScanCallback = this.n;
                if (camera2BqcScanCallback != null) {
                    camera2BqcScanCallback.onSurfaceAvaliable();
                }
                CameraPerformanceRecorder.setPreviewUseSurfaceView(true);
                return;
            }
            holder.setFixedSize(xVar, yVar);
            MPaasLogger.d("Camera2MPaasScanServiceImpl", new Object[]{"setFixedSize surfaceRect:", surfaceFrame.toString(), ", but preview size:", Integer.valueOf(xVar), Constants.Name.X, Integer.valueOf(yVar)});
            return;
        }
        MPaasLogger.e("Camera2MPaasScanServiceImpl", new Object[]{"setDisplay status error."});
    }
}
