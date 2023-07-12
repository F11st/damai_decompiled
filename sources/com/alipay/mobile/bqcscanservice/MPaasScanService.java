package com.alipay.mobile.bqcscanservice;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceView;
import android.view.TextureView;
import com.alipay.camera2.CameraFocusStateDescription;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.BQCScanEngine;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.executor.ScanRecognizedExecutor;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.watchdog.BQCWatchCallback;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public interface MPaasScanService {

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public static class FrameMetaData {
        public byte[] data;
        public int format;
        public int height;
        public int stride;
        public int width;
    }

    /* compiled from: Taobao */
    /* loaded from: classes12.dex */
    public interface OnPictureTakenListener {
        void onTakenFailed();

        void onTakenSucceed(FrameMetaData frameMetaData);
    }

    void adjustExposureState(int i);

    void changeCameraFeature(BQCCameraParam.CameraConfigType cameraConfigType, Object... objArr);

    boolean checkEngineRegister(String str);

    void cleanup(long j);

    void enableCameraOpenWatcher(boolean z);

    Camera getCamera();

    int getCameraDisplayOrientation();

    CameraFocusStateDescription getCameraFocusStateDescription();

    CameraHandler getCameraHandler();

    Object getCameraParam(String str);

    Context getContext();

    String getCurCameraVitalParameters();

    boolean getCurrentWhetherUseManualFocus();

    int getCurrentZoom();

    Map<String, String> getEngineRunningInfo(String str);

    boolean getFirstSetup();

    long getFrameCountInCamera();

    int getMaxZoom();

    long[] getRecognizeResult();

    ScanCodeState getScanCodeState();

    Map<String, String> getSpecEngineExtInfo(String str);

    Runnable getWatchdogRunnable();

    boolean isCameraClosed();

    boolean isPreviewing();

    boolean isScanEnable();

    boolean isTorchOn();

    void needDowngrade(boolean z);

    void onMovementStatusChanged(boolean z);

    void onSurfaceAvailable();

    void postCloseCamera();

    void preOpenCamera();

    void processWhetherStopMaRecognize(boolean z, Runnable runnable);

    void reconnectCamera();

    void refocus();

    void regScanEngine(String str, Class<? extends BQCScanEngine> cls, BQCScanEngine.EngineCallback engineCallback);

    void registerExecutorCallback(ScanRecognizedExecutor.RecognizeExecutorCallback recognizeExecutorCallback);

    void release();

    void requestCameraPreviewWatcherDog(long j, BQCWatchCallback bQCWatchCallback);

    void sendOperationCameraInstructions(BQCCameraParam.CameraOperationInstruction cameraOperationInstruction, String str, String str2);

    void serviceInit(Bundle bundle);

    void serviceOut(Bundle bundle);

    void setCameraId(int i);

    void setCameraParam(String str, Object obj);

    void setContext(Context context);

    void setDisplay(SurfaceView surfaceView);

    void setDisplay(TextureView textureView);

    void setDisplay(TextureView textureView, boolean z);

    void setDisplayTexture(SurfaceTexture surfaceTexture);

    void setEngineExtInfo(String str, Object obj);

    void setEngineParameters(String str, Map<String, Object> map);

    void setEngineParameters(Map<String, Object> map);

    void setExposureState(int i);

    void setFocusArea(Rect rect);

    void setFocusPosition(int i, int i2);

    void setOpenRetryStopFlag(boolean z);

    void setPreviewCallback();

    void setScanEnable(boolean z);

    void setScanRegion(Rect rect);

    void setScanRegion(Rect rect, Point point);

    boolean setScanType(String str);

    boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType);

    boolean setScanType(String str, BQCCameraParam.MaEngineType maEngineType, String str2);

    void setServiceParameters(Map<String, String> map);

    void setTorch(boolean z);

    void setTraceLogger(MPaasLogger.BqcLogger bqcLogger);

    void setZoom(int i);

    void setZoomAbsoluteRatio(int i);

    void setup(Context context, BQCScanCallback bQCScanCallback);

    void setup(Context context, BQCScanCallback bQCScanCallback, int i);

    void startPreview();

    void startWatchDogMonitor();

    void stopAutoFocus();

    void stopPreview();

    void stopWatchDogMonitor();

    void takePicture(OnPictureTakenListener onPictureTakenListener);

    void tryPostCloseCamera();

    void tryPreOpenCamera();

    void updateServiceInitInfo(String str);

    boolean useAPI2();

    void useViewFrameToRecognize(Bitmap bitmap);
}
