package com.alipay.mobile.bqcscanservice.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageFormat;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import com.alipay.camera.CameraConfigurationManager;
import com.alipay.camera.CameraManager;
import com.alipay.camera.CameraPreControl;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.base.CameraPerformanceRecorder;
import com.alipay.camera.compatible.CompatibleManager;
import com.alipay.camera.open.OpenCameraInterface;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera.util.CameraFocusParamConfig;
import com.alipay.camera.util.FocusWhiteList;
import com.alipay.camera.util.FpsWhiteList;
import com.alipay.camera.util.ManufacturerPermissionChecker;
import com.alipay.camera2.Camera2AvailabilityCallback;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanCallback;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.watchdog.BQCWatchCallback;
import com.alipay.performance.memory.DeviceMemoryUtils;
import com.alipay.util.CameraFrameWatchdog;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MPaasScanServiceImpl implements MPaasScanService {
    public static final String TAG = "MPaasScanServiceImpl";
    private SurfaceView B;
    private SurfaceHolder C;
    private boolean D;
    private boolean E;
    private long J;
    private CameraFrameWatchdog M;
    protected CameraHandler b;
    private Camera2AvailabilityCallback c;
    private TextureView.SurfaceTextureListener h;
    private Camera.Parameters k;
    private Point l;
    private Point m;
    private ScanCodeState n;
    private CameraPreControl o;
    private Point p;
    private boolean q;
    private Context r;
    private Context s;
    private Camera.Parameters u;
    protected boolean a = true;
    private CameraManager d = null;
    private BQCScanController e = null;
    private TextureView f = null;
    private SurfaceTexture g = null;
    private volatile long i = 0;
    private volatile long j = 0;
    private volatile boolean t = true;
    private boolean v = false;
    private boolean w = false;
    private boolean x = false;
    private boolean y = false;
    protected Map<String, Map<String, Object>> z = new HashMap();
    private int A = 0;
    private boolean F = false;
    private boolean G = false;
    private long H = 0;
    private long I = 0;
    private int K = 0;
    private boolean L = false;
    public int startPreviewRetryNum = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public class BQCSurfaceCallback implements TextureView.SurfaceTextureListener {
        private BQCSurfaceCallback() {
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"BQCSurfaceCallback:onSurfaceTextureAvailable():width: ", Integer.valueOf(i), ", height: ", Integer.valueOf(i2)});
            try {
                MPaasScanServiceImpl.this.g = surfaceTexture;
                if (MPaasScanServiceImpl.this.e != null) {
                    MPaasScanServiceImpl.this.e.reportSurfaceViewAvailable();
                }
            } catch (Exception e) {
                MPaasLogger.e(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureAvailable: "}, e);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureDestroyed"});
            return true;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureSizeChanged: width=", Integer.valueOf(i), ", height=", Integer.valueOf(i2)});
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
            if (MPaasScanServiceImpl.this.I == 0) {
                MPaasScanServiceImpl.this.H = SystemClock.elapsedRealtime();
                try {
                    if (MPaasScanServiceImpl.this.e != null) {
                        MPaasScanServiceImpl.this.e.reportSurfaceTextureUpdated();
                    }
                } catch (Exception e) {
                    MPaasLogger.e(MPaasScanServiceImpl.TAG, new Object[]{"onSurfaceTextureUpdated"}, e);
                }
            }
            MPaasScanServiceImpl.l(MPaasScanServiceImpl.this);
            MPaasScanServiceImpl.this.i += 10;
        }
    }

    static /* synthetic */ long l(MPaasScanServiceImpl mPaasScanServiceImpl) {
        long j = mPaasScanServiceImpl.I;
        mPaasScanServiceImpl.I = 1 + j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("###cameraHandlerStacktrace=");
        sb.append(str);
        String staticBlockEvent = CameraPerformanceRecorder.getStaticBlockEvent();
        CameraManager cameraManager = this.d;
        String dynamicBlockEvent = cameraManager == null ? null : cameraManager.getDynamicBlockEvent();
        if (staticBlockEvent == null && dynamicBlockEvent == null) {
            CameraManager cameraManager2 = this.d;
            String cameraLatestErrorEventInfo = cameraManager2 != null ? cameraManager2.getCameraLatestErrorEventInfo() : null;
            if (cameraLatestErrorEventInfo != null) {
                sb.append(cameraLatestErrorEventInfo);
                this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_ERROR, sb.toString(), false);
                return;
            }
            this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_HAL_NOT_PRODUCE_FRAME, sb.toString(), false);
            return;
        }
        sb.append(String.valueOf(staticBlockEvent));
        sb.append(String.valueOf(dynamicBlockEvent));
        this.M.buryWatchDogErrorDetails(CameraFrameWatchdog.NoFrameReason.CAMERA_METHOD_BLOCK, sb.toString(), false);
    }

    private void n(String str) {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.postCameraFailRetryNotice(str, false);
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(CameraFrameWatchdog.WatcherState watcherState) {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.setWatcherState(watcherState);
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void adjustExposureState(int i) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.adjustExposureState(i);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"adjustExposureState: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void changeCameraFeature(BQCCameraParam.CameraConfigType cameraConfigType, Object... objArr) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean checkEngineRegister(String str) {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            return bQCScanController.checkEngineRegister(str);
        }
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void cleanup(long j) {
        MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_5 cleanup"});
        this.r = null;
        this.a = false;
        this.o = null;
        this.d = null;
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.setResultCallback(null);
            this.e.setmPaasScanService(null);
            this.e.destroy();
            this.e = null;
        }
        TextureView textureView = this.f;
        if (textureView != null) {
            textureView.setSurfaceTextureListener(null);
            this.f = null;
        }
        if (this.D) {
            this.C = null;
            this.B = null;
        }
        this.g = null;
        if (this.B != null) {
            this.B = null;
        }
        this.y = false;
        this.h = null;
        this.v = false;
        this.w = false;
        this.x = false;
        ScanRecognizedExecutor.close();
        this.A = 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void enableCameraOpenWatcher(boolean z) {
        MPaasLogger.d(TAG, new Object[]{"enableCameraOpenWatcher: enabled=", Boolean.valueOf(z)});
        this.t = z;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Camera getCamera() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager == null || cameraManager.getCamera() == null) {
                return null;
            }
            return this.d.getCamera().getCamera();
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getCamera(): "}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCameraDisplayOrientation() {
        CameraManager cameraManager = this.d;
        if (cameraManager != null) {
            try {
                return cameraManager.getCameraDisplayOrientation();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraFocusStateDescription getCameraFocusStateDescription() {
        CameraManager cameraManager = this.d;
        if (cameraManager == null || cameraManager.getCamera() == null) {
            return null;
        }
        AntCamera camera = this.d.getCamera();
        return new CameraFocusStateDescription(camera.getFrameCount(), false, -1.0f, -1.0f, camera.getFocusNotStartedFrameCount(), -1, String.valueOf(camera.getFocusTriggerHistory()), -1, -1, -1, false, "UNKNOWN");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public CameraHandler getCameraHandler() {
        return this.b;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Object getCameraParam(String str) {
        CameraManager cameraManager;
        if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_HEIGHT)) {
            CameraManager cameraManager2 = this.d;
            if (cameraManager2 != null) {
                try {
                    return Integer.valueOf(cameraManager2.getPreviewHeight());
                } catch (Exception unused) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_WIDTH)) {
            CameraManager cameraManager3 = this.d;
            if (cameraManager3 != null) {
                try {
                    return Integer.valueOf(cameraManager3.getPreviewWidth());
                } catch (Exception unused2) {
                }
            }
            return -1;
        } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.PREVIEW_SIZE)) {
            CameraManager cameraManager4 = this.d;
            if (cameraManager4 != null) {
                try {
                    int previewWidth = cameraManager4.getPreviewWidth();
                    int previewHeight = this.d.getPreviewHeight();
                    if (previewWidth > 0 && previewHeight > 0) {
                        return new Point(previewWidth, previewHeight);
                    }
                } catch (Exception unused3) {
                }
            }
            return null;
        } else {
            if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MAX_EXPOSURE_INDEX)) {
                CameraManager cameraManager5 = this.d;
                if (cameraManager5 != null) {
                    try {
                        return cameraManager5.getMaxExposureIndex();
                    } catch (Exception unused4) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MIN_EXPOSURE_INDEX)) {
                CameraManager cameraManager6 = this.d;
                if (cameraManager6 != null) {
                    try {
                        return cameraManager6.getMinExposureIndex();
                    } catch (Exception unused5) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.BACK_CAMERA_INDEX)) {
                CameraManager cameraManager7 = this.d;
                if (cameraManager7 != null) {
                    try {
                        return Integer.valueOf(cameraManager7.getBackCameraIndex());
                    } catch (Exception unused6) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.MAX_PICTURE_SIZE_VALID)) {
                CameraManager cameraManager8 = this.d;
                if (cameraManager8 != null) {
                    try {
                        return Boolean.valueOf(cameraManager8.getMaxPictureSizeValid());
                    } catch (Exception unused7) {
                        return null;
                    }
                }
            } else if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_FACING)) {
                return Integer.valueOf(this.A);
            } else {
                if (TextUtils.equals(str, BQCCameraParam.CameraPropertyParam.CAMERA_ROTATE_ORIENTATION) && (cameraManager = this.d) != null) {
                    try {
                        return cameraManager.getCameraRotation();
                    } catch (Exception unused8) {
                    }
                }
            }
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Context getContext() {
        return this.r;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public String getCurCameraVitalParameters() {
        Rect rect;
        Rect rect2;
        if (this.u != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("focusMode", this.u.getFocusMode());
                List<Camera.Area> focusAreas = this.u.getFocusAreas();
                if (focusAreas != null && focusAreas.size() > 0 && (rect2 = focusAreas.get(0).rect) != null) {
                    jSONObject.put("focusArea", jn1.ARRAY_START_STR + rect2.left + AVFSCacheConstants.COMMA_SEP + rect2.top + AVFSCacheConstants.COMMA_SEP + rect2.right + AVFSCacheConstants.COMMA_SEP + rect2.bottom + jn1.ARRAY_END_STR);
                }
                List<Camera.Area> meteringAreas = this.u.getMeteringAreas();
                if (meteringAreas != null && meteringAreas.size() > 0 && (rect = meteringAreas.get(0).rect) != null) {
                    jSONObject.put("meteringArea", jn1.ARRAY_START_STR + rect.left + AVFSCacheConstants.COMMA_SEP + rect.top + AVFSCacheConstants.COMMA_SEP + rect.right + AVFSCacheConstants.COMMA_SEP + rect.bottom + jn1.ARRAY_END_STR);
                }
                Camera.Size previewSize = this.u.getPreviewSize();
                if (previewSize != null) {
                    jSONObject.put("previewSize", "" + previewSize.width + jn1.MUL + previewSize.height);
                }
                Camera.Size pictureSize = this.u.getPictureSize();
                if (pictureSize != null) {
                    jSONObject.put("pictureSize", "" + pictureSize.width + jn1.MUL + pictureSize.height);
                }
                long j = this.J;
                if (j > 0) {
                    jSONObject.put("inFrameRate", String.valueOf((int) (1000 / j)));
                }
                jSONObject.put("zsl", CompatibleManager.sOpenZsl ? BQCCameraParam.VALUE_YES : "no");
                jSONObject.put("paramDetail", this.u.flatten());
                return jSONObject.toString();
            } catch (Exception e) {
                MPaasLogger.e(TAG, new Object[]{"getCurCameraVitalParameters:"}, e);
                return null;
            }
        }
        MPaasLogger.e(TAG, new Object[]{"getCurCameraVitalParameters: this.parameters=null"});
        return null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getCurrentWhetherUseManualFocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                return cameraManager.getCanInvokeManualFocus();
            }
            return false;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getCurrentWhetherUseManualFocus"}, e);
            return false;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getCurrentZoom() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager == null || !cameraManager.isOpen()) {
                return -1;
            }
            return this.d.getZoomParameter();
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getCurrentZoom: "}, e);
            return -1;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getEngineRunningInfo(String str) {
        try {
            if (this.e != null) {
                MPaasLogger.d(TAG, new Object[]{"getEngineRunningInfo: ", str, ", scanController!=null"});
                return this.e.getEngineRunningInfo(str);
            }
            MPaasLogger.d(TAG, new Object[]{"getEngineRunningInfo: ", str, ", scanController=null"});
            return null;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getSpecEngineExtInfo: "}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean getFirstSetup() {
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long getFrameCountInCamera() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getFrameCountInCamera();
            }
            return -1L;
        } catch (Exception unused) {
            return -1L;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public int getMaxZoom() {
        CameraManager cameraManager = this.d;
        if (cameraManager != null && cameraManager.isOpen()) {
            try {
                return this.d.getMaxZoom();
            } catch (Exception unused) {
                MPaasLogger.e(TAG, new Object[]{"getMaxZoom exception"});
            }
        }
        return -1;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public long[] getRecognizeResult() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getRecognizeResult();
            }
            return null;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getRecognizeResult()"}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public ScanCodeState getScanCodeState() {
        return this.n;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Map<String, String> getSpecEngineExtInfo(String str) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.getSpecEngineExtInfo(str);
            }
            return null;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"getSpecEngineExtInfo: "}, e);
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public Runnable getWatchdogRunnable() {
        try {
            return new Runnable() { // from class: com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.1
                @Override // java.lang.Runnable
                public void run() {
                    MPaasLogger.d(MPaasScanServiceImpl.TAG, new Object[]{"watchDogRunnable start, Camera1"});
                    try {
                        if (MPaasScanServiceImpl.this.M != null) {
                            MPaasScanServiceImpl.this.o(CameraFrameWatchdog.WatcherState.TIMEOUT);
                            String str = "stackTrace=null";
                            if (MPaasScanServiceImpl.this.b != null) {
                                str = "stackTrace=" + MPaasScanServiceImpl.this.b.getStackTrace();
                            }
                            MPaasScanServiceImpl.this.M.postCameraPreviewTimeOut(false, str);
                            MPaasScanServiceImpl.this.m(str);
                        }
                    } catch (Throwable unused) {
                    }
                }
            };
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isCameraClosed() {
        return getCamera() == null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isPreviewing() {
        throw new UnsupportedOperationException("Do not use this");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isScanEnable() {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                return bQCScanController.isScanEnable();
            }
            return false;
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"isScanEnable()"}, e);
            return false;
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean isTorchOn() {
        return this.x;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void needDowngrade(boolean z) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.needDowngrade(z);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"needDowngrade: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void onMovementStatusChanged(boolean z) {
        MPaasLogger.d(TAG, new Object[]{"onMovementStatusChanged:", Boolean.valueOf(z)});
    }

    /* JADX WARN: Removed duplicated region for block: B:157:0x03c1 A[Catch: Exception -> 0x0483, TryCatch #13 {Exception -> 0x0483, blocks: (B:111:0x02bb, B:113:0x02bf, B:114:0x02cb, B:164:0x0476, B:166:0x047a, B:167:0x047d, B:118:0x02df, B:120:0x02e7, B:155:0x0397, B:157:0x03c1, B:161:0x0459, B:163:0x0469, B:158:0x0410, B:148:0x0385, B:147:0x037b, B:132:0x0358, B:115:0x02d7), top: B:198:0x02bb, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0410 A[Catch: Exception -> 0x0483, TryCatch #13 {Exception -> 0x0483, blocks: (B:111:0x02bb, B:113:0x02bf, B:114:0x02cb, B:164:0x0476, B:166:0x047a, B:167:0x047d, B:118:0x02df, B:120:0x02e7, B:155:0x0397, B:157:0x03c1, B:161:0x0459, B:163:0x0469, B:158:0x0410, B:148:0x0385, B:147:0x037b, B:132:0x0358, B:115:0x02d7), top: B:198:0x02bb, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0459 A[Catch: Exception -> 0x0483, TryCatch #13 {Exception -> 0x0483, blocks: (B:111:0x02bb, B:113:0x02bf, B:114:0x02cb, B:164:0x0476, B:166:0x047a, B:167:0x047d, B:118:0x02df, B:120:0x02e7, B:155:0x0397, B:157:0x03c1, B:161:0x0459, B:163:0x0469, B:158:0x0410, B:148:0x0385, B:147:0x037b, B:132:0x0358, B:115:0x02d7), top: B:198:0x02bb, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:166:0x047a A[Catch: Exception -> 0x0483, TryCatch #13 {Exception -> 0x0483, blocks: (B:111:0x02bb, B:113:0x02bf, B:114:0x02cb, B:164:0x0476, B:166:0x047a, B:167:0x047d, B:118:0x02df, B:120:0x02e7, B:155:0x0397, B:157:0x03c1, B:161:0x0459, B:163:0x0469, B:158:0x0410, B:148:0x0385, B:147:0x037b, B:132:0x0358, B:115:0x02d7), top: B:198:0x02bb, inners: #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0117 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:190:0x0366 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:200:0x0149 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0361 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0152 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x0182 A[Catch: Exception -> 0x0247, TryCatch #11 {Exception -> 0x0247, blocks: (B:21:0x006f, B:23:0x007a, B:81:0x0237, B:83:0x023b, B:85:0x0240, B:27:0x008f, B:29:0x0097, B:72:0x0158, B:74:0x0182, B:78:0x021a, B:80:0x022a, B:75:0x01d1, B:64:0x0141, B:63:0x0137, B:47:0x010e, B:24:0x0086), top: B:194:0x006f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01d1 A[Catch: Exception -> 0x0247, TryCatch #11 {Exception -> 0x0247, blocks: (B:21:0x006f, B:23:0x007a, B:81:0x0237, B:83:0x023b, B:85:0x0240, B:27:0x008f, B:29:0x0097, B:72:0x0158, B:74:0x0182, B:78:0x021a, B:80:0x022a, B:75:0x01d1, B:64:0x0141, B:63:0x0137, B:47:0x010e, B:24:0x0086), top: B:194:0x006f, inners: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:78:0x021a A[Catch: Exception -> 0x0247, TryCatch #11 {Exception -> 0x0247, blocks: (B:21:0x006f, B:23:0x007a, B:81:0x0237, B:83:0x023b, B:85:0x0240, B:27:0x008f, B:29:0x0097, B:72:0x0158, B:74:0x0182, B:78:0x021a, B:80:0x022a, B:75:0x01d1, B:64:0x0141, B:63:0x0137, B:47:0x010e, B:24:0x0086), top: B:194:0x006f, inners: #0 }] */
    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onSurfaceAvailable() {
        /*
            Method dump skipped, instructions count: 1166
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.onSurfaceAvailable():void");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void postCloseCamera() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.postCloseCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void preOpenCamera() {
        CameraHandler cameraHandler = this.b;
        if (cameraHandler != null) {
            cameraHandler.preOpenCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void processWhetherStopMaRecognize(boolean z, Runnable runnable) {
        if (this.e != null) {
            MPaasLogger.d(TAG, new Object[]{"ScanNetworkChangeMonitor processWhetherStopMaRecognize stopRecognize=", Boolean.valueOf(z)});
            this.e.processWhetherStopMaRecognize(z, runnable);
            return;
        }
        MPaasLogger.d(TAG, new Object[]{"ScanNetworkChangeMonitor processWhetherStopMaRecognize error,scanController=null"});
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void reconnectCamera() {
        if (this.g != null) {
            Camera camera = getCamera();
            if (this.d == null || camera == null) {
                return;
            }
            MPaasLogger.d(TAG, new Object[]{"reconnectCamera"});
            try {
                this.d.setPreviewTexture(this.g);
                setPreviewCallback();
                camera.startPreview();
            } catch (Exception e) {
                MPaasLogger.e(TAG, new Object[]{"reconnectCamera Exception : "}, e);
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void refocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.refocus();
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"refocus: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback) {
        MPaasLogger.d(TAG, new Object[]{"regScanEngine()"});
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.regScanEngine(str, cls, engineCallback);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void registerExecutorCallback(ScanRecognizedExecutor.RecognizeExecutorCallback recognizeExecutorCallback) {
        ScanRecognizedExecutor.registerRecognizeCallback(recognizeExecutorCallback);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void release() {
        this.p = null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void requestCameraPreviewWatcherDog(long j, BQCWatchCallback bQCWatchCallback) {
        try {
            if (this.M == null) {
                if (j <= 0) {
                    j = 10000;
                }
                this.M = new CameraFrameWatchdog(bQCWatchCallback, j, getWatchdogRunnable());
            }
            MPaasLogger.d(TAG, new Object[]{"requestCameraPreviewWatcherDog camera1"});
            startWatchDogMonitor();
            o(CameraFrameWatchdog.WatcherState.INIT);
        } catch (Exception unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void sendOperationCameraInstructions(BQCCameraParam.CameraOperationInstruction cameraOperationInstruction, String str, String str2) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.sendOperationCameraInstructions(cameraOperationInstruction, str, str2);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"sendOperationCameraInstructions: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceInit(Bundle bundle) {
        CameraHandler cameraHandler = new CameraHandler();
        this.b = cameraHandler;
        cameraHandler.setBqcScanService(this);
        this.k = null;
        this.l = null;
        this.m = null;
        String string = bundle != null ? bundle.getString(BQCCameraParam.ServicePropertyParam.NOT_SELF_DIAGNOSE, null) : null;
        ScanCodeState scanCodeState = new ScanCodeState(1);
        this.n = scanCodeState;
        scanCodeState.setEnable(!TextUtils.equals(string, BQCCameraParam.VALUE_YES));
        if (Build.VERSION.SDK_INT >= 21) {
            this.c = new Camera2AvailabilityCallback(this.s, getCameraHandler().getCameraHandler());
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void serviceOut(Bundle bundle) {
        this.b.destroy();
        this.k = null;
        this.l = null;
        this.m = null;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraId(int i) {
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setCameraParam(String str, Object obj) {
        int i;
        String[] split;
        CameraManager cameraManager;
        CameraManager cameraManager2;
        CameraManager cameraManager3;
        CameraManager cameraManager4;
        CameraManager cameraManager5;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setCameraParam: "}, e);
        }
        if (!this.E && str.equalsIgnoreCase(BQCCameraParam.ConfigParam.KEY_MERGE_CAMERA_PARAM)) {
            if (obj == null || !(obj instanceof String) || (split = ((String) obj).split(",")) == null) {
                return;
            }
            if (split.length >= 1) {
                FpsWhiteList.refreshCurrentDeviceInList(split[0]);
            }
            if (split.length >= 4) {
                CameraConfigurationUtils.reducePreviewSize(split[3]);
            }
            if (split.length >= 6) {
                CameraConfigurationUtils.setPreviewOptimize(split[5]);
            }
            CameraManager cameraManager6 = this.d;
            if (cameraManager6 != null) {
                if (split.length >= 3) {
                    cameraManager6.setAutoFocusDelayTime(split[2]);
                }
                if (split.length >= 5 && (cameraManager5 = this.d) != null) {
                    cameraManager5.setSupportFocusArea(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[4]));
                }
                if (split.length >= 7 && (cameraManager4 = this.d) != null) {
                    cameraManager4.setConfigSupportMeteringArea(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[6]));
                }
                if (split.length >= 8 && (cameraManager3 = this.d) != null) {
                    cameraManager3.setConfigFocusMode(split[7]);
                }
                if (split.length >= 9 && (cameraManager2 = this.d) != null) {
                    cameraManager2.setConfigFocusRadius(split[8]);
                }
                if (split.length >= 10 && (cameraManager = this.d) != null) {
                    cameraManager.setConfigSupportExposure(BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[9]));
                }
            }
            if (split.length >= 11) {
                this.F = BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[10]);
            }
            if (split.length >= 12 && BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[11])) {
                this.G = true;
                MPaasLogger.d(TAG, new Object[]{"mUseCameraParamsCache is true"});
            }
            if (split.length >= 13) {
                boolean equalsIgnoreCase = BQCCameraParam.VALUE_YES.equalsIgnoreCase(split[12]);
                CameraManager cameraManager7 = this.d;
                if (cameraManager7 != null) {
                    cameraManager7.setNeedCancelAutoFocus(equalsIgnoreCase);
                }
            }
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_SUPPORT_FRAME_CALLBACK) && (obj instanceof String)) {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.setSupportFrameCallback(TextUtils.equals(BQCCameraParam.VALUE_YES, (String) obj));
            }
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_PERMISSION_DETECT) && (obj instanceof String)) {
            ManufacturerPermissionChecker.setCheckerSwitcher(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_STOP_CANCEL_FOCUS) && (obj instanceof String)) {
            CameraManager cameraManager8 = this.d;
            if (cameraManager8 != null) {
                cameraManager8.setStopCancelFocus(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
            }
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_OPEN_CAMERA_FAULT_TOLERANT) && (obj instanceof String)) {
            OpenCameraInterface.setEnableCameraDefaultTolerant(BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj));
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_ID_BACKUP) && (obj instanceof String)) {
            OpenCameraInterface.setCameraIdBackup((String) obj);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_DYNAMICAL_PREVIEWSIZE) && (obj instanceof String)) {
            CameraConfigurationUtils.setEnableDynamicPreviewSize((String) obj);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_MIN_PREVIEW) && (obj instanceof String)) {
            CameraConfigurationUtils.setPreviewSize(null, (String) obj);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_MAX_PREVIEW) && (obj instanceof String)) {
            CameraConfigurationUtils.setPreviewSize((String) obj, null);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_NEW_FOCUS_CONFIG) && (obj instanceof String)) {
            FocusWhiteList.useNewFocusWhiteList = BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.LOCAL_MAX_PICTURE_VALID) && (obj instanceof String)) {
            FocusWhiteList.maxPictureSizeValid = BQCCameraParam.VALUE_YES.equalsIgnoreCase((String) obj);
        } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_CAMERA_FINGERPRINT) && (obj instanceof String)) {
            FocusWhiteList.updateDeviceFingerPrint((String) obj);
        } else {
            if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_OPEN_CAMERA_RETRY_TIME) && (obj instanceof String)) {
                try {
                    this.K = Integer.parseInt((String) obj);
                } catch (Exception unused) {
                    this.K = 0;
                }
                MPaasLogger.d(TAG, new Object[]{"retryNum =", Integer.valueOf(this.K)});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_START_PREVIEW_RETRY_TIME) && (obj instanceof String)) {
                try {
                    this.startPreviewRetryNum = Integer.parseInt((String) obj);
                } catch (Exception unused2) {
                    this.startPreviewRetryNum = 0;
                }
                MPaasLogger.d(TAG, new Object[]{"startPreview retryNum =", Integer.valueOf(this.startPreviewRetryNum)});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_SERVICE_CONFIG_PREVIEW_SIZE_RULE) && (obj instanceof String)) {
                CameraConfigurationUtils.setPreviewSizeRule((String) obj);
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_AE_AF_REGION_BOX_PROPORTION) && (obj instanceof String)) {
                try {
                    i = Integer.parseInt((String) obj);
                } catch (Exception unused3) {
                    i = 0;
                }
                CameraConfigurationUtils.setRegionBoxProportion(i);
                MPaasLogger.d(TAG, new Object[]{"RegionBoxProportion =", Integer.valueOf(this.K)});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_PICTURE_SIZE_TIMES) && (obj instanceof String)) {
                CameraConfigurationUtils.setPictureSizeTimes((String) obj);
                MPaasLogger.d(TAG, new Object[]{"setPictureSizeTimes =", obj});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_AUTO_FOCUS_QUICK_SWITCH) && (obj instanceof String)) {
                CameraManager cameraManager9 = this.d;
                if (cameraManager9 != null) {
                    cameraManager9.setEnableAutoFocusQuickSwitch((String) obj);
                }
                MPaasLogger.d(TAG, new Object[]{"setEnableAutoFocusQuickSwitch:", obj});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_INIT_FOCUS_TO_AUTO) && (obj instanceof String)) {
                CameraConfigurationManager.setEnableInitFocusToAuto((String) obj);
                MPaasLogger.d(TAG, new Object[]{"setEnableInitFocusToAuto =", obj});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_NOT_RUN_STOP_PREVIEW) && (obj instanceof String)) {
                CameraManager cameraManager10 = this.d;
                if (cameraManager10 != null) {
                    cameraManager10.setNotRunStopPrev((String) obj);
                }
                MPaasLogger.d(TAG, new Object[]{"setNotRunStopPrev =", obj});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_ENABLE_OPTIMIZE_PARAMETERS) && (obj instanceof String)) {
                CompatibleManager.enableOptimizeParameters((String) obj);
                MPaasLogger.d(TAG, new Object[]{"enableOptimizeParameters =", obj});
                return;
            } else if (TextUtils.equals(str, BQCCameraParam.ConfigParam.KEY_THRESHOLD_SWITCH_TO_AUTO_DURATION) && (obj instanceof String)) {
                CameraFocusParamConfig.updateThresholdSwitchToAutoDuration((String) obj);
                MPaasLogger.d(TAG, new Object[]{"updateThresholdSwitchToAutoDuration =", obj});
                return;
            } else {
                return;
            }
            MPaasLogger.e(TAG, new Object[]{"setCameraParam: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setContext(Context context) {
        this.s = context;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView) {
        if (textureView == null) {
            MPaasLogger.d(TAG, new Object[]{"setDisplay(): view = null"});
            TextureView textureView2 = this.f;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr = new Object[2];
        objArr[0] = "CAMERA_STEP setDisplay():surfaceCallback is null:";
        objArr[1] = Boolean.valueOf(this.h == null);
        MPaasLogger.d(TAG, objArr);
        textureView.setSurfaceTextureListener(this.h);
        if (textureView.isAvailable()) {
            SurfaceTexture surfaceTexture = textureView.getSurfaceTexture();
            this.g = surfaceTexture;
            Object[] objArr2 = new Object[2];
            objArr2[0] = "setDisplay: surfaceTexture is null : ";
            objArr2[1] = Boolean.valueOf(surfaceTexture == null);
            MPaasLogger.d(TAG, objArr2);
        } else {
            this.g = null;
        }
        this.f = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplayTexture(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            return;
        }
        this.g = surfaceTexture;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineExtInfo(String str, Object obj) {
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.setEngineExtInfo(str, obj);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setSpecEngineExtInfo: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(Map<String, Object> map) {
        setEngineParameters("MA", map);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setExposureState(int i) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setExposureState(i);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setExposureState: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusArea(Rect rect) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setFocusRegion(rect);
            }
            CameraManager cameraManager2 = this.d;
            if (cameraManager2 != null) {
                cameraManager2.setMeteringRegion(rect);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setFocusArea: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setFocusPosition(int i, int i2) {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.setFocusPosition(i, i2);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setFocusPosition: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setOpenRetryStopFlag(boolean z) {
        MPaasLogger.d(TAG, new Object[]{"setOpenRetryStopFlag flag=", Boolean.valueOf(z)});
        this.L = z;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setPreviewCallback() {
        MPaasLogger.d(TAG, new Object[]{"setPreviewCallback()"});
        CameraManager cameraManager = this.d;
        if (cameraManager == null || cameraManager.getCamera() == null) {
            return;
        }
        int previewWidth = this.d.getPreviewWidth();
        int previewHeight = this.d.getPreviewHeight();
        int pictureFormat = this.d.getPictureFormat();
        if (previewWidth == -1 || previewHeight == -1 || pictureFormat == -1) {
            return;
        }
        try {
            int bitsPerPixel = ((previewWidth * previewHeight) * ImageFormat.getBitsPerPixel(pictureFormat)) / 8;
            byte[] bArr = new byte[bitsPerPixel];
            this.d.getCamera().addCallbackBuffer(bArr);
            this.e.setCameraBuffers(bArr, this.e.getDoubleBufferEnable() ? new byte[bitsPerPixel] : null);
            MPaasLogger.d(TAG, new Object[]{"requestPreviewFrameWithBuffer"});
            this.d.requestPreviewFrameWithBuffer(this.e);
        } catch (Throwable th) {
            MPaasLogger.e(TAG, new Object[]{"setPreviewCallback error: "}, th);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanEnable(boolean z) {
        BQCScanController bQCScanController;
        try {
            Object[] objArr = new Object[6];
            objArr[0] = "setScanEnable(enable=";
            objArr[1] = Boolean.valueOf(z);
            objArr[2] = ", cameraManager=null?";
            objArr[3] = Boolean.valueOf(this.d == null);
            objArr[4] = ", scanController=null?";
            objArr[5] = Boolean.valueOf(this.e == null);
            MPaasLogger.d(TAG, objArr);
            if (this.d == null || (bQCScanController = this.e) == null) {
                return;
            }
            bQCScanController.setScanEnable(z);
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{e.getMessage()});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect) {
        setScanRegion(rect, this.p);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str) {
        return setScanType(str, null, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setServiceParameters(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String str = map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SCAN_EXECUTOR);
        if (str != null) {
            if (TextUtils.equals(str, BQCCameraParam.VALUE_YES)) {
                ScanRecognizedExecutor.sUseNewExecutor = true;
            } else {
                ScanRecognizedExecutor.sUseNewExecutor = false;
            }
        }
        String str2 = map.get(BQCCameraParam.ServicePropertyParam.SERVICE_OPERATION_CONFIG);
        if (str2 != null) {
            byte[] bytes = str2.getBytes();
            if (str2.length() >= 1 && bytes[0] == 49) {
                this.q = true;
            } else {
                this.q = false;
            }
            if (str2.length() >= 2 && bytes[1] == 49) {
                BQCScanController.gcFirstFrame = true;
            } else {
                BQCScanController.gcFirstFrame = false;
            }
            if (str2.length() >= 4 && bytes[3] == 49) {
                CameraHandler.mConsiderContext = true;
            } else {
                CameraHandler.mConsiderContext = false;
            }
        } else {
            this.q = false;
            BQCScanController.gcFirstFrame = false;
            CameraHandler.mConsiderContext = false;
        }
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get("debug"))) {
            this.E = true;
        } else {
            this.E = false;
        }
        String str3 = map.get(BQCCameraParam.ServicePropertyParam.USE_NEW_SURFACE);
        if (str3 != null) {
            if (TextUtils.equals(str3, BQCCameraParam.VALUE_YES)) {
                this.D = true;
            } else {
                this.D = false;
            }
        }
        String str4 = map.get(BQCCameraParam.ServicePropertyParam.CAMERA_FRAME_DELAY);
        if (TextUtils.isEmpty(str4)) {
            BQCScanController.cameraFrameDelay = 0;
        } else {
            try {
                BQCScanController.cameraFrameDelay = Integer.parseInt(str4);
            } catch (Exception unused) {
                BQCScanController.cameraFrameDelay = 0;
                MPaasLogger.d(TAG, new Object[]{"exception occurred on getValue(", BQCCameraParam.ServicePropertyParam.CAMERA_FRAME_DELAY, jn1.BRACKET_END_STR, str4});
            }
        }
        if (BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get(BQCCameraParam.ServicePropertyParam.SERVICE_STATISTICS_CAMERA))) {
            CameraManager.sStatisticsCameraInfo = true;
        } else {
            CameraManager.sStatisticsCameraInfo = false;
        }
        DeviceMemoryUtils.needMemoryStatistics = BQCCameraParam.VALUE_YES.equalsIgnoreCase(map.get(DeviceMemoryUtils.KEY_MEMORY_STATISTICS));
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setTorch(boolean z) {
        CameraManager cameraManager = this.d;
        if (cameraManager == null || !cameraManager.isOpen()) {
            return;
        }
        this.d.setTorch(z);
        this.x = z;
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
    public void setZoom(int i) {
        CameraManager cameraManager = this.d;
        if (cameraManager == null || !cameraManager.isOpen()) {
            return;
        }
        try {
            this.d.setZoomParameter(i);
        } catch (Exception unused) {
            MPaasLogger.e(TAG, new Object[]{"setZoom exception"});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setZoomAbsoluteRatio(int i) {
        CameraManager cameraManager = this.d;
        if (cameraManager == null || !cameraManager.isOpen()) {
            return;
        }
        try {
            this.d.setAbsoluteZoomParameter(i);
        } catch (Exception unused) {
            MPaasLogger.e(TAG, new Object[]{"setZoom exception"});
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback, int i) {
        MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_1 setup()"});
        if (context == null) {
            return;
        }
        this.r = context;
        Context context2 = this.s;
        if (context2 != null) {
            context = context2;
        }
        this.d = new CameraManager(context, this.k, this.l, this.m, this.b, this.p, this.n);
        CameraPreControl cameraPreControl = this.o;
        if (cameraPreControl != null && cameraPreControl.getTheCamera() != null) {
            MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_1_0 use pre Camera"});
            this.d.setCameraOpened(this.o.getTheCamera());
        }
        BQCScanController bQCScanController = new BQCScanController(context, this.z, this.b, this.a, this.q, this.d, this.n);
        this.e = bQCScanController;
        bQCScanController.setResultCallback(bQCScanCallback);
        this.e.setmPaasScanService(this);
        if (!this.D) {
            this.h = new BQCSurfaceCallback();
        }
        this.f = null;
        this.g = null;
        this.B = null;
        this.C = null;
        ScanRecognizedExecutor.open();
        this.e.reportParametersSet(0L);
        this.A = i;
    }

    /* JADX WARN: Finally extract failed */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:140:0x02d7 A[Catch: all -> 0x0322, TRY_ENTER, TryCatch #2 {all -> 0x0322, blocks: (B:19:0x0077, B:58:0x010c, B:61:0x0113, B:96:0x01f4, B:98:0x01f8, B:100:0x01fe, B:101:0x020c, B:103:0x0210, B:104:0x0218, B:106:0x0221, B:107:0x022f, B:111:0x025e, B:113:0x0272, B:115:0x0276, B:119:0x0281, B:121:0x0285, B:123:0x0289, B:127:0x0292, B:116:0x027a, B:118:0x027e, B:65:0x0120, B:69:0x012c, B:85:0x017d, B:92:0x018b, B:95:0x01b6, B:140:0x02d7, B:141:0x0321, B:72:0x0156, B:75:0x015e, B:78:0x0163, B:80:0x0168, B:81:0x016d), top: B:181:0x0077, inners: #5 }] */
    /* JADX WARN: Removed duplicated region for block: B:152:0x034a  */
    /* JADX WARN: Removed duplicated region for block: B:203:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01b6 A[Catch: all -> 0x0322, TRY_ENTER, TryCatch #2 {all -> 0x0322, blocks: (B:19:0x0077, B:58:0x010c, B:61:0x0113, B:96:0x01f4, B:98:0x01f8, B:100:0x01fe, B:101:0x020c, B:103:0x0210, B:104:0x0218, B:106:0x0221, B:107:0x022f, B:111:0x025e, B:113:0x0272, B:115:0x0276, B:119:0x0281, B:121:0x0285, B:123:0x0289, B:127:0x0292, B:116:0x027a, B:118:0x027e, B:65:0x0120, B:69:0x012c, B:85:0x017d, B:92:0x018b, B:95:0x01b6, B:140:0x02d7, B:141:0x0321, B:72:0x0156, B:75:0x015e, B:78:0x0163, B:80:0x0168, B:81:0x016d), top: B:181:0x0077, inners: #5 }] */
    /* JADX WARN: Type inference failed for: r2v0, types: [java.lang.Class<java.lang.String>] */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2 */
    /* JADX WARN: Type inference failed for: r2v3 */
    /* JADX WARN: Type inference failed for: r2v7 */
    /* JADX WARN: Type inference failed for: r5v12, types: [java.lang.Class[]] */
    /* JADX WARN: Type inference failed for: r5v13, types: [java.lang.Class[]] */
    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    @android.annotation.TargetApi(19)
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void startPreview() {
        /*
            Method dump skipped, instructions count: 938
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.mobile.bqcscanservice.impl.MPaasScanServiceImpl.startPreview():void");
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void startWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.startWatch();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopAutoFocus() {
        try {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.stopAutoFocus();
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"stopAutoFocus: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopPreview() {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.setScanEnable(false);
            this.e.setCameraValid(false);
        }
        CameraManager cameraManager = this.d;
        if (cameraManager != null) {
            this.u = cameraManager.getCameraParameters();
            try {
                MPaasLogger.d(TAG, new Object[]{"CAMERA_STEP_4 stopPreview() start"});
                this.d.setBqcScanController(null);
                if (this.F) {
                    MPaasLogger.d(TAG, new Object[]{"先关闭TextureView"});
                    if (!this.D) {
                        this.d.setPreviewTextureNull();
                    } else {
                        this.d.setPreviewDisplayNull();
                    }
                }
                this.d.requestPreviewFrameWithBuffer(null);
                this.d.stopPreview();
                this.y = false;
                if (!this.D) {
                    this.g = null;
                    this.f = null;
                } else {
                    this.C = null;
                    this.B = null;
                }
                this.d.closeDriver();
                MPaasLogger.d(TAG, new Object[]{"stopPreview(), surfaceTexture = null; textureView=null"});
            } catch (Throwable th) {
                MPaasLogger.e(TAG, new Object[]{"camera stopPreview error: "}, th);
            }
        }
        this.v = false;
        this.w = false;
        this.x = false;
        this.i = 0L;
        BQCScanController bQCScanController2 = this.e;
        if (bQCScanController2 != null) {
            bQCScanController2.reportCameraClosed();
            this.e.destroy();
        }
        if (this.H != 0 && this.I != 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime() - this.H;
            long j = this.I;
            this.J = elapsedRealtime / j;
            MPaasLogger.d(TAG, new Object[]{"The Camera FrameRate: mFrameNum=", Long.valueOf(j), ", duration=", Long.valueOf(elapsedRealtime), ", frame(ms)=", Long.valueOf(this.J)});
            WalletBury.addWalletBury("recordCameraFrameRate", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf((int) this.J)});
        } else {
            MPaasLogger.d(TAG, new Object[]{"Cannot get the Camera Frame Rate"});
            this.J = 0L;
        }
        this.H = 0L;
        this.I = 0L;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void stopWatchDogMonitor() {
        try {
            CameraFrameWatchdog cameraFrameWatchdog = this.M;
            if (cameraFrameWatchdog != null) {
                cameraFrameWatchdog.stopWatch();
                this.M = null;
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void takePicture(MPaasScanService.OnPictureTakenListener onPictureTakenListener) {
        if (onPictureTakenListener != null) {
            CameraManager cameraManager = this.d;
            if (cameraManager != null) {
                cameraManager.takePicture(onPictureTakenListener);
            } else {
                onPictureTakenListener.onTakenFailed();
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPostCloseCamera() {
        CameraPreControl cameraPreControl = this.o;
        if (cameraPreControl != null) {
            cameraPreControl.closeCamera();
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void tryPreOpenCamera() {
        Object[] objArr = new Object[2];
        objArr[0] = "tryPreOpenCamera, mCamera2AvailabilityCallback == null?";
        objArr[1] = Boolean.valueOf(this.c == null);
        MPaasLogger.d(TAG, objArr);
        if (this.o != null) {
            MPaasLogger.d(TAG, new Object[]{"cameraPreControl is not null"});
            return;
        }
        CameraPreControl cameraPreControl = new CameraPreControl();
        this.o = cameraPreControl;
        cameraPreControl.openCamera();
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void updateServiceInitInfo(String str) {
        CameraPerformanceRecorder.updateServiceInitInfo(str);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean useAPI2() {
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void useViewFrameToRecognize(Bitmap bitmap) {
        BQCScanController bQCScanController = this.e;
        if (bQCScanController != null) {
            bQCScanController.useViewFrameToRecognize(bitmap);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setEngineParameters(String str, Map<String, Object> map) {
        if (str == null) {
            return;
        }
        try {
            BQCScanController bQCScanController = this.e;
            if (bQCScanController != null) {
                bQCScanController.setEngineParams(str, map);
            }
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setEngineParameters: "}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setScanRegion(Rect rect, Point point) {
        BQCScanController bQCScanController;
        try {
            this.p = point;
            if (this.d == null || (bQCScanController = this.e) == null) {
                return;
            }
            bQCScanController.setScanRegion(rect);
        } catch (Exception e) {
            MPaasLogger.e(TAG, new Object[]{"setScanRegion()"}, e);
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType) {
        return setScanType(str, maEngineType, null);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2) {
        BQCScanController bQCScanController;
        MPaasLogger.d(TAG, new Object[]{"setScanType(", str, AVFSCacheConstants.COMMA_SEP + maEngineType, AVFSCacheConstants.COMMA_SEP, str2, jn1.BRACKET_END_STR});
        if (this.d != null && (bQCScanController = this.e) != null) {
            try {
                return bQCScanController.setScanType(str, maEngineType, str2);
            } catch (Exception e) {
                MPaasLogger.e(TAG, new Object[]{"setScanType error:"}, e);
            }
        }
        return false;
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(TextureView textureView, boolean z) {
        Object[] objArr = new Object[4];
        objArr[0] = "CAMERA_STEP setDisplay(): view != null?";
        objArr[1] = Boolean.valueOf(textureView != null);
        objArr[2] = ", surfaceTextureSet:";
        objArr[3] = Boolean.valueOf(z);
        MPaasLogger.d(TAG, objArr);
        if (textureView == null) {
            TextureView textureView2 = this.f;
            if (textureView2 != null) {
                textureView2.setSurfaceTextureListener(null);
                return;
            }
            return;
        }
        Object[] objArr2 = new Object[2];
        objArr2[0] = "setDisplay():surfaceCallback==null?";
        objArr2[1] = Boolean.valueOf(this.h == null);
        MPaasLogger.d(TAG, objArr2);
        textureView.setSurfaceTextureListener(this.h);
        if (!z) {
            boolean isAvailable = textureView.isAvailable();
            if (isAvailable) {
                this.g = textureView.getSurfaceTexture();
            } else {
                this.g = null;
            }
            Object[] objArr3 = new Object[4];
            objArr3[0] = "setDisplay():texture.isAvailable()";
            objArr3[1] = Boolean.valueOf(isAvailable);
            objArr3[2] = "surfaceTexture==null?";
            objArr3[3] = Boolean.valueOf(this.g == null);
            MPaasLogger.d(TAG, objArr3);
        }
        this.f = textureView;
        CameraPerformanceRecorder.setPreviewUseSurfaceView(false);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setup(Context context, BQCScanCallback bQCScanCallback) {
        setup(context, bQCScanCallback, 0);
    }

    @Override // com.alipay.mobile.bqcscanservice.MPaasScanService
    public void setDisplay(SurfaceView surfaceView) {
        Object[] objArr = new Object[2];
        objArr[0] = "CAMERA_STEP setDisplay(): view==null?";
        objArr[1] = Boolean.valueOf(surfaceView == null);
        MPaasLogger.d(TAG, objArr);
        if (this.D) {
            this.B = surfaceView;
            this.C = surfaceView.getHolder();
            CameraPerformanceRecorder.setPreviewUseSurfaceView(true);
        }
    }
}
