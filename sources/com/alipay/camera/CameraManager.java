package com.alipay.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.CameraCharacteristics;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.SurfaceHolder;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.open.OpenCameraInterface;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera.util.CameraFocusParamConfig;
import com.alipay.camera2.util.SystraceWrapper;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.CameraHandler;
import com.alipay.mobile.bqcscanservice.Constants;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.MPaasScanService;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.impl.BQCScanController;
import com.alipay.mobile.bqcscanservice.monitor.ScanCodeState;
import com.alipay.mobile.bqcscanservice.monitor.ScanExceptionHandler;
import com.alipay.performance.ScanPerformanceConfig;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.youku.danmaku.engine.danmaku.model.android.DanmakuFactory;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class CameraManager implements CameraHandler.OnMessageHandleCallback, BQCScanController.FrameCallback {
    public static final float MAX_ZOOM_RATE = 0.6f;
    public static final float MIN_ZOOM_RATE = 0.0f;
    public static boolean sStatisticsCameraInfo;
    private final CameraConfigurationManager a;
    private AntCamera b;
    private Camera.Parameters c;
    private boolean d;
    private NewAutoFocusManager e;
    private boolean f;
    private int g;
    private Point h;
    private Point i;
    private Point j;
    private CameraHandler k;
    private boolean l;
    private boolean m;
    private AntCamera.AutoFocusCallbackProxy n;
    private BQCScanController o;
    private boolean p;
    private final CameraFocusStateMonitor q;
    private boolean r;
    private ScanCodeState s;
    private boolean t;

    public CameraManager(Context context, Camera.Parameters parameters, Point point, Point point2, CameraHandler cameraHandler, ScanCodeState scanCodeState) {
        this(context, parameters, point, point2, cameraHandler, null, scanCodeState);
    }

    private void o(final Context context) {
        new AsyncTask<Object, Object, Object>(this) { // from class: com.alipay.camera.CameraManager.1
            @Override // android.os.AsyncTask
            protected Object doInBackground(Object... objArr) {
                Context context2;
                String[] cameraIdList;
                if (Build.VERSION.SDK_INT >= 21 && (context2 = context) != null) {
                    try {
                        android.hardware.camera2.CameraManager cameraManager = (android.hardware.camera2.CameraManager) context2.getSystemService("camera");
                        if (cameraManager != null && (cameraIdList = cameraManager.getCameraIdList()) != null && cameraIdList.length > 0) {
                            WalletBury.addWalletBury("recordCamera2Support", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(((Integer) cameraManager.getCameraCharacteristics(cameraIdList[0]).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue())});
                        }
                        return null;
                    } catch (Exception e) {
                        MPaasLogger.e("CameraManager", new Object[]{"buryCameraInfo: "}, e);
                    }
                }
                return null;
            }
        }.execute(new Object[0]);
    }

    private void p(int i) {
        this.k.sendMessage(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(int i, long j) {
        this.k.sendMessageDelayed(i, j);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(String str) {
        CameraConfigurationManager cameraConfigurationManager;
        NewAutoFocusManager newAutoFocusManager = this.e;
        if (newAutoFocusManager != null) {
            newAutoFocusManager.destroy();
        }
        if (this.b != null && (cameraConfigurationManager = this.a) != null) {
            cameraConfigurationManager.setConfigFocusMode(str);
            this.c = this.a.invokeFocusParameters(this.b, this.c);
        }
        CameraFocusParamConfig focusParamConfig = this.a.getFocusParamConfig();
        if (focusParamConfig != null) {
            if (TextUtils.equals(focusParamConfig.getInitFocusMode(), "auto")) {
                NewAutoFocusManager newAutoFocusManager2 = new NewAutoFocusManager(this.b, this.k);
                this.e = newAutoFocusManager2;
                newAutoFocusManager2.startAutoFocus();
            }
            if (focusParamConfig.getSecondDuration() > 0) {
                q(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue(), focusParamConfig.getSecondDuration());
            }
        }
    }

    public void adjustExposureState(int i) {
        if (this.k != null) {
            Message obtain = Message.obtain();
            obtain.what = CameraHandler.ADJUST_EXPOSURE_STATE.intValue();
            obtain.arg1 = i;
            this.k.sendMessage(obtain);
        }
    }

    public void closeDriver() {
        ScanCodeState scanCodeState = this.s;
        if (scanCodeState != null) {
            scanCodeState.setCameraClosed();
        }
        AntCamera antCamera = this.b;
        if (antCamera != null) {
            antCamera.setErrorCallback((AntCamera.ErrorCallbackProxy) null);
            SystraceWrapper.beginTrace("cameraRelease");
            this.b.release();
            SystraceWrapper.endTrace();
            this.b = null;
        }
    }

    public void delayStartAutoFocus() {
        AntCamera antCamera = this.b;
        if (antCamera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = antCamera.getParameters();
            this.a.forceInvokeFocusRegion(this.b, parameters);
            if (CameraConfigurationUtils.setAutoFocus(parameters)) {
                this.b.setParameters(parameters);
                this.c = parameters;
                CameraConfigurationManager cameraConfigurationManager = this.a;
                if (cameraConfigurationManager != null) {
                    cameraConfigurationManager.updateFocusMode("auto");
                }
                NewAutoFocusManager newAutoFocusManager = this.e;
                if (newAutoFocusManager != null) {
                    newAutoFocusManager.stopAutoFocus();
                    this.e.destroy();
                }
                NewAutoFocusManager newAutoFocusManager2 = new NewAutoFocusManager(this.b, this.k);
                this.e = newAutoFocusManager2;
                newAutoFocusManager2.startAutoFocus();
                return;
            }
            MPaasLogger.d("CameraManager", new Object[]{"delayStartAutoFocus(): startAutoFocus error1"});
        } catch (Exception e) {
            MPaasLogger.e("CameraManager", new Object[]{"startAutoFocus error2, "}, e);
        }
    }

    public int getBackCameraIndex() {
        return OpenCameraInterface.sCameraId;
    }

    public AntCamera getCamera() {
        return this.b;
    }

    public int getCameraDisplayOrientation() {
        return this.g;
    }

    public String getCameraLatestErrorEventInfo() {
        try {
            AntCamera antCamera = this.b;
            if (antCamera != null) {
                return antCamera.getLatestErrorEventInfo();
            }
            return null;
        } catch (Throwable th) {
            MPaasLogger.e("CameraManager", new Object[]{"getCameraLatestErrorEventInfo with error:"}, th);
            return null;
        }
    }

    public Camera.Parameters getCameraParameters() {
        return this.c;
    }

    public Integer getCameraRotation() {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager == null) {
            return null;
        }
        return Integer.valueOf(cameraConfigurationManager.getCameraDisplayOrientation());
    }

    public boolean getCanInvokeManualFocus() {
        return this.l;
    }

    public String getDynamicBlockEvent() {
        try {
            AntCamera antCamera = this.b;
            if (antCamera != null) {
                return antCamera.getCameraPerformanceRecorder().getDynamicBlockEvent();
            }
            return null;
        } catch (Throwable th) {
            MPaasLogger.e("CameraManager", new Object[]{"getDynamicBlockEvent with error:"}, th);
            return null;
        }
    }

    public Integer getMaxExposureIndex() {
        Camera.Parameters parameters = this.c;
        if (parameters != null) {
            return Integer.valueOf(parameters.getMaxExposureCompensation());
        }
        return null;
    }

    public boolean getMaxPictureSizeValid() {
        Point pictureSize;
        CameraConfigurationManager cameraConfigurationManager = this.a;
        return cameraConfigurationManager != null && (pictureSize = cameraConfigurationManager.getPictureSize()) != null && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(pictureSize) > 1000 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(pictureSize) > 1000;
    }

    public int getMaxZoom() {
        return this.b.getParameters().getMaxZoom();
    }

    public Integer getMinExposureIndex() {
        Camera.Parameters parameters = this.c;
        if (parameters != null) {
            return Integer.valueOf(parameters.getMinExposureCompensation());
        }
        return null;
    }

    public int getPictureFormat() {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            return cameraConfigurationManager.getPreviewFmt();
        }
        return -1;
    }

    public int getPreviewHeight() {
        Point point = this.i;
        if (point == null) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
    }

    public Point getPreviewResolution() {
        return this.i;
    }

    public int getPreviewWidth() {
        Point point = this.i;
        if (point == null) {
            return -1;
        }
        return com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
    }

    public Point getScreenResolution() {
        return this.h;
    }

    public Runnable getWatchdogRunnable() {
        return null;
    }

    public float getZoomFactor() {
        AntCamera antCamera = this.b;
        if (antCamera != null) {
            List<Integer> zoomRatios = antCamera.getParameters().getZoomRatios();
            int zoomParameter = getZoomParameter();
            if (zoomRatios != null && zoomParameter >= 0 && zoomParameter < zoomRatios.size()) {
                return zoomRatios.get(zoomParameter).intValue() / 100.0f;
            }
        }
        return -1.0f;
    }

    public int getZoomParameter() {
        AntCamera antCamera = this.b;
        if (antCamera != null) {
            return antCamera.getParameters().getZoom();
        }
        return -1;
    }

    public boolean isOpen() {
        return this.b != null;
    }

    @Override // com.alipay.mobile.bqcscanservice.CameraHandler.OnMessageHandleCallback
    public void onHandleMessage(Message message) {
        CameraFocusParamConfig focusParamConfig;
        CameraConfigurationManager cameraConfigurationManager;
        Camera.Parameters parameters;
        CameraConfigurationManager cameraConfigurationManager2;
        Camera.Parameters parameters2;
        CameraConfigurationManager cameraConfigurationManager3;
        Camera.Parameters parameters3;
        CameraConfigurationManager cameraConfigurationManager4;
        Camera.Parameters parameters4;
        CameraConfigurationManager cameraConfigurationManager5;
        if (message != null) {
            int i = message.what;
            if (i == CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue()) {
                try {
                    CameraConfigurationManager cameraConfigurationManager6 = this.a;
                    if (cameraConfigurationManager6 == null || (focusParamConfig = cameraConfigurationManager6.getFocusParamConfig()) == null || !TextUtils.equals(focusParamConfig.getSecondFocusMode(), "auto")) {
                        return;
                    }
                    delayStartAutoFocus();
                } catch (Exception e) {
                    MPaasLogger.e("CameraManager", new Object[]{"onHandleMessage: ", Integer.valueOf(i)}, e);
                }
            } else if (i == CameraHandler.SET_FOCUS_AREA.intValue()) {
                try {
                    AntCamera antCamera = this.b;
                    if (antCamera == null || (cameraConfigurationManager = this.a) == null || (parameters = this.c) == null) {
                        return;
                    }
                    this.c = cameraConfigurationManager.invokeFocusRegion(antCamera, parameters);
                } catch (Exception e2) {
                    MPaasLogger.e("CameraManager", new Object[]{"onHandleMessage: ", Integer.valueOf(i)}, e2);
                }
            } else if (i == CameraHandler.SET_METERING_AREA.intValue()) {
                try {
                    AntCamera antCamera2 = this.b;
                    if (antCamera2 == null || (cameraConfigurationManager2 = this.a) == null || (parameters2 = this.c) == null) {
                        return;
                    }
                    this.c = cameraConfigurationManager2.invokeMeteringRegion(antCamera2, parameters2);
                } catch (Exception e3) {
                    MPaasLogger.e("CameraManager", new Object[]{"onHandleMessage: ", Integer.valueOf(i)}, e3);
                }
            } else if (i == CameraHandler.CLICK_FOCUS_AREA.intValue()) {
                if (this.b == null || this.c == null || (cameraConfigurationManager5 = this.a) == null || !cameraConfigurationManager5.getSupportFocusArea()) {
                    return;
                }
                this.c = this.a.invokeFocusRegion(this.b, this.c);
                r("auto");
            } else if (i == CameraHandler.SET_EXPOSURE_STATE.intValue()) {
                AntCamera antCamera3 = this.b;
                if (antCamera3 == null || (cameraConfigurationManager4 = this.a) == null || (parameters4 = this.c) == null) {
                    return;
                }
                this.c = cameraConfigurationManager4.invokeExposure(antCamera3, parameters4, message.arg1);
            } else if (i == CameraHandler.ADJUST_EXPOSURE_STATE.intValue()) {
                AntCamera antCamera4 = this.b;
                if (antCamera4 == null || (cameraConfigurationManager3 = this.a) == null || (parameters3 = this.c) == null) {
                    return;
                }
                this.c = cameraConfigurationManager3.adjustExposure(antCamera4, parameters3, message.arg1);
            } else if (i != CameraHandler.AUTO_MANUAL_FOCUS.intValue() || this.b == null) {
            } else {
                MPaasLogger.d("CameraManager", new Object[]{"Set: canInvokeManual = true"});
                this.l = true;
            }
        }
    }

    @Override // com.alipay.mobile.bqcscanservice.impl.BQCScanController.FrameCallback
    public void onPreviewFrame(AntCamera antCamera) {
        if (this.q == null || this.c == null || antCamera == null) {
            return;
        }
        try {
            BQCScanController bQCScanController = this.o;
            long durationOfBlur = bQCScanController == null ? -1L : bQCScanController.getDurationOfBlur();
            BQCScanController bQCScanController2 = this.o;
            boolean whetherFocusAbnormal = this.q.whetherFocusAbnormal(antCamera, durationOfBlur, bQCScanController2 == null ? -1L : bQCScanController2.getDurationOfNoNeedCheck());
            if (this.r && !"auto".equalsIgnoreCase(this.c.getFocusMode()) && whetherFocusAbnormal) {
                MPaasLogger.d("CameraManager", new Object[]{"focusAbnormal, switch to auto mode immediately"});
                this.a.updateAutoFocusConfig("auto", 0L);
                p(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue());
                Class cls = Integer.TYPE;
                WalletBury.addWalletBury("recordCameraSecondFocusModeInfo", new Class[]{String.class, cls, cls, String.class}, new Object[]{"auto", Integer.valueOf(antCamera.getFirstTriggerFrameCount()), Integer.valueOf(antCamera.getFocusNotStartedFrameCount()), this.q.getString()});
            }
        } catch (Throwable th) {
            MPaasLogger.e("CameraManager", new Object[]{"needSwitchToAutoMode with exception:"}, th);
        }
    }

    public void openDriver() throws RuntimeException {
        openDriver(0);
    }

    public void refocus() {
        NewAutoFocusManager newAutoFocusManager = this.e;
        if (newAutoFocusManager != null) {
            newAutoFocusManager.stopAutoFocus();
            this.e.startAutoFocus();
        }
    }

    public void requestPreviewFrameWithBuffer(AntCamera.PreviewCallbackProxy previewCallbackProxy) {
        AntCamera antCamera = this.b;
        if (antCamera != null) {
            try {
                SystraceWrapper.beginTrace("setPreviewCallbackWithBuffer");
                antCamera.setPreviewCallbackWithBuffer(previewCallbackProxy);
                SystraceWrapper.endTrace();
            } catch (Exception e) {
                MPaasLogger.e("CameraManager", new Object[]{e.getMessage()});
            }
        }
    }

    public void resetCurCameraParameters() {
        this.c = null;
    }

    public void sendOperationCameraInstructions(final BQCCameraParam.CameraOperationInstruction cameraOperationInstruction, final String str, final String str2) {
        MPaasLogger.d("CameraManager", new Object[]{"sendOperationCameraInstructions: ", cameraOperationInstruction, AVFSCacheConstants.COMMA_SEP, str, AVFSCacheConstants.COMMA_SEP, str2});
        if (str == null) {
            return;
        }
        this.k.post(new Runnable() { // from class: com.alipay.camera.CameraManager.6
            @Override // java.lang.Runnable
            public void run() {
                BQCCameraParam.CameraOperationInstruction cameraOperationInstruction2 = cameraOperationInstruction;
                if (cameraOperationInstruction2 == BQCCameraParam.CameraOperationInstruction.FOCUS_MODE) {
                    if (CameraManager.this.a == null) {
                        return;
                    }
                    CameraManager.this.r(str);
                } else if (cameraOperationInstruction2 == BQCCameraParam.CameraOperationInstruction.SCENE_MODE) {
                    if (CameraManager.this.a == null) {
                        return;
                    }
                    CameraManager cameraManager = CameraManager.this;
                    cameraManager.c = cameraManager.a.setCameraScene(CameraManager.this.c, str);
                    if (CameraManager.this.b != null) {
                        CameraManager.this.b.setParameters(CameraManager.this.c);
                    }
                } else if (cameraOperationInstruction2 == BQCCameraParam.CameraOperationInstruction.FOCUS_AREA) {
                    if (CameraManager.this.a == null) {
                        return;
                    }
                    if (TextUtils.equals(BQCCameraParam.FOCUS_AREA_RADIUS, str) && str2 != null) {
                        try {
                            CameraManager.this.a.setFocusRadius(Integer.parseInt(str2));
                            return;
                        } catch (Exception e) {
                            MPaasLogger.e("CameraManager", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    CameraManager.this.a.setSupportFocusArea(TextUtils.equals("open", str));
                } else if (cameraOperationInstruction2 == BQCCameraParam.CameraOperationInstruction.EXPOSURE_STATE) {
                    if (CameraManager.this.a == null) {
                        return;
                    }
                    if (TextUtils.equals("index", str) && str2 != null) {
                        try {
                            CameraManager.this.a.invokeExposure(CameraManager.this.b, CameraManager.this.c, Integer.parseInt(str2));
                            return;
                        } catch (Exception e2) {
                            MPaasLogger.e("CameraManager", new Object[]{e2.getMessage()});
                            return;
                        }
                    }
                    CameraManager.this.a.setSupportExposureState(TextUtils.equals("open", str));
                } else if (cameraOperationInstruction2 == BQCCameraParam.CameraOperationInstruction.FOCUS_MANUAL && TextUtils.equals(str, BQCCameraParam.FOCUS_ONCE) && CameraManager.this.a != null) {
                    try {
                        if (!TextUtils.equals(CameraManager.this.a.getFocusMode(), "auto") || CameraManager.this.e == null) {
                            MPaasLogger.d("CameraManager", new Object[]{"canInvokeManual: ", Boolean.valueOf(CameraManager.this.l)});
                            if (!CameraManager.this.l || CameraManager.this.b == null) {
                                return;
                            }
                            CameraManager.this.l = false;
                            if (CameraManager.this.n == null) {
                                CameraManager.this.n = new AntCamera.AutoFocusCallbackProxy() { // from class: com.alipay.camera.CameraManager.6.1
                                    @Override // com.alipay.camera.base.AntCamera.AutoFocusCallbackProxy
                                    public void onAutoFocusProxy(boolean z, AntCamera antCamera) {
                                        MPaasLogger.d("CameraManager", new Object[]{"callback: invokeManualFocusResult=", Boolean.valueOf(z)});
                                        try {
                                            if (CameraManager.this.o != null) {
                                                CameraManager.this.o.reportOnManualFocusResult(z);
                                            }
                                        } catch (Exception unused) {
                                            MPaasLogger.e("CameraManager", new Object[]{"onManualFocus: controller's callback exception"});
                                        }
                                        if (antCamera != null) {
                                            try {
                                                antCamera.cancelAutoFocus();
                                            } catch (Exception e3) {
                                                MPaasLogger.e("CameraManager", new Object[]{"callback: canInvokeManual"}, e3);
                                                return;
                                            }
                                        }
                                        CameraManager.this.q(CameraHandler.AUTO_MANUAL_FOCUS.intValue(), 1000L);
                                    }
                                };
                            }
                            if (CameraManager.this.p) {
                                CameraManager.this.b.cancelAutoFocus();
                            }
                            CameraManager.this.b.autoFocus(CameraManager.this.n);
                            return;
                        }
                        MPaasLogger.d("CameraManager", new Object[]{"Now is autoFocus mode"});
                    } catch (Exception e3) {
                        MPaasLogger.e("CameraManager", new Object[]{e3.getMessage()});
                    }
                }
            }
        });
    }

    public void setAbsoluteZoomParameter(final int i) {
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera.CameraManager.5
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (CameraManager.this.b == null) {
                            return;
                        }
                        Camera.Parameters parameters = CameraManager.this.b.getParameters();
                        int i2 = i;
                        float f = 0.0f;
                        if (i2 >= 0.0f) {
                            f = ((float) i2) >= 60.000004f ? 0.6f : (i2 * 1.0f) / 100.0f;
                        }
                        int maxZoom = (int) ((parameters.getMaxZoom() * f) + 0.5d);
                        MPaasLogger.d("CameraManager", new Object[]{"The object Zoom is ", Integer.valueOf(maxZoom)});
                        if (parameters.isZoomSupported()) {
                            parameters.setZoom(maxZoom);
                            CameraManager.this.b.setParameters(parameters);
                            if (CameraManager.this.o != null) {
                                CameraManager.this.o.setEngineExtInfo(Constants.EXT_INFO_KEY_ZOOM, Float.valueOf(maxZoom));
                            }
                            if (CameraManager.this.s != null) {
                                CameraManager.this.s.setZoom(maxZoom);
                            }
                        }
                    } catch (Exception e) {
                        WalletBury.addWalletBury("recordSetZoomException", new Class[]{Integer.TYPE}, new Object[]{Integer.valueOf(i)});
                        MPaasLogger.e("CameraManager", new Object[]{"SetZoomParameters : ", Integer.valueOf(i)}, e);
                    }
                }
            });
        }
    }

    public void setAutoFocusDelayTime(String str) {
        long j;
        try {
            j = Integer.parseInt(str);
            MPaasLogger.d("CameraManager", new Object[]{"setAutoFocusDelayTime is ", Long.valueOf(j)});
        } catch (Exception unused) {
            MPaasLogger.e("CameraManager", new Object[]{"setAutoFocusDelayTime is error"});
            j = DanmakuFactory.DEFAULT_DANMAKU_DURATION_V;
        }
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setConfigSecondAutoDelayDuration(j);
        }
    }

    public void setBqcScanController(BQCScanController bQCScanController) {
        this.o = bQCScanController;
    }

    public void setCameraOpened(AntCamera antCamera) {
        this.b = antCamera;
    }

    public void setConfigFocusMode(String str) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setConfigFocusMode(str);
        }
    }

    public void setConfigFocusRadius(String str) {
        MPaasLogger.d("CameraManager", new Object[]{"setConfigFocusRadius: ", str});
        try {
            int parseInt = Integer.parseInt(str);
            CameraConfigurationManager cameraConfigurationManager = this.a;
            if (cameraConfigurationManager == null || parseInt <= 0) {
                return;
            }
            cameraConfigurationManager.setFocusRadius(parseInt);
        } catch (Exception e) {
            MPaasLogger.e("CameraManager", new Object[]{"setConfigFocusRadius: "}, e);
        }
    }

    public void setConfigSupportExposure(boolean z) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setSupportExposureState(z);
        }
    }

    public void setConfigSupportMeteringArea(boolean z) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setSupportMeteringArea(z);
        }
    }

    public void setEnableAutoFocusQuickSwitch(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.r = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public void setExposureState(int i) {
        if (this.k != null) {
            Message obtain = Message.obtain();
            obtain.arg1 = i;
            obtain.what = CameraHandler.SET_EXPOSURE_STATE.intValue();
            this.k.sendMessage(obtain);
        }
    }

    public void setFocusPosition(int i, int i2) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setFocusPosition(i, i2);
        }
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.sendMessage(CameraHandler.CLICK_FOCUS_AREA.intValue());
        }
    }

    public void setFocusRegion(Rect rect) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setFocusRegion(rect);
        }
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.sendMessage(CameraHandler.SET_FOCUS_AREA.intValue());
        }
    }

    public void setInDebugMode(boolean z) {
        this.d = z;
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setDebugMode(z);
        }
    }

    public void setMeteringRegion(Rect rect) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setMeteringRegion(rect);
        }
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.sendMessage(CameraHandler.SET_METERING_AREA.intValue());
        }
    }

    public void setNeedCancelAutoFocus(boolean z) {
        this.p = z;
    }

    public void setNotRunStopPrev(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.t = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public void setPreviewDisplayNull() throws Exception {
        AntCamera antCamera = this.b;
        if (antCamera == null) {
            return;
        }
        antCamera.setPreviewDisplay(null);
        ScanCodeState scanCodeState = this.s;
        if (scanCodeState != null) {
            scanCodeState.setUseSurface(false);
        }
    }

    public void setPreviewParameters() {
        long currentTimeMillis = System.currentTimeMillis();
        ScanCodeState scanCodeState = this.s;
        if (scanCodeState != null) {
            scanCodeState.setCameraOpened();
        }
        AntCamera antCamera = this.b;
        Camera.Parameters parameters = this.c;
        boolean z = parameters == null;
        MPaasLogger.d("CameraManager", new Object[]{"setPreviewParameters: ", parameters});
        if (this.c == null || this.h == null || this.i == null) {
            this.c = this.a.initFromCameraParameters(antCamera, this.j);
            this.h = this.a.getScreenResolution();
            this.i = this.a.getPreviewSize();
        }
        try {
            MPaasLogger.d("CameraManager", new Object[]{"supportFocusArea: ", Boolean.valueOf(this.a.getSupportFocusArea()), ", supportMeteringArea: ", Boolean.valueOf(this.a.getSupportMeteringArea())});
            Camera.Parameters parameters2 = this.c;
            if (parameters2 != null) {
                if (!z && parameters2.getMaxNumFocusAreas() > 0) {
                    this.c.setFocusAreas(null);
                }
                if (!z && this.c.getMaxNumMeteringAreas() > 0) {
                    this.c.setMeteringAreas(null);
                }
                CameraConfigurationManager cameraConfigurationManager = this.a;
                if (cameraConfigurationManager != null && cameraConfigurationManager.getSupportExposure()) {
                    int minExposureCompensation = this.c.getMinExposureCompensation();
                    int maxExposureCompensation = this.c.getMaxExposureCompensation();
                    if (minExposureCompensation != 0 && maxExposureCompensation != 0) {
                        this.c.setExposureCompensation(0);
                    }
                }
            }
            this.c = this.a.setDesiredCameraParameters(antCamera, this.c, OpenCameraInterface.sCameraId);
            if (this.p) {
                MPaasLogger.d("CameraManager", new Object[]{"Need Cancel AutoFocus First"});
                this.b.cancelAutoFocus();
            }
        } catch (RuntimeException e) {
            WalletBury.addWalletBury("recordCameraParameterSetFail", new Class[]{Integer.TYPE, String.class}, new Object[]{1, e.getMessage()});
            MPaasLogger.e("CameraManager", new Object[]{"Camera rejected parameters. Setting only minimal safe-mode parameters, errormsg: "}, e);
            MPaasLogger.i("CameraManager", new Object[]{"Resetting to saved camera params"});
            try {
                BQCScanController bQCScanController = this.o;
                if (bQCScanController != null) {
                    bQCScanController.reportCameraParametersSetFailed();
                }
            } catch (Exception e2) {
                MPaasLogger.e("CameraManager", new Object[]{"SetPreviewParametersFailed"}, e2);
            }
            Camera.Parameters parameters3 = this.c;
            if (parameters3 != null) {
                try {
                    this.c = this.a.setDesiredCameraParameters(antCamera, parameters3, OpenCameraInterface.sCameraId);
                } catch (RuntimeException e3) {
                    MPaasLogger.e("CameraManager", new Object[]{"Camera rejected even safe-mode parameters! No configuration, errormsg: "}, e3);
                    WalletBury.addWalletBury("recordCameraParameterSetFail", new Class[]{Integer.TYPE, String.class}, new Object[]{2, e3.getMessage()});
                }
            }
        }
        this.g = this.a.getCameraDisplayOrientation();
        this.i = this.a.getPreviewSize();
        WalletBury.addWalletBury("recordSetCameraParamDuringTime", new Class[]{Long.TYPE}, new Object[]{Long.valueOf(System.currentTimeMillis() - currentTimeMillis)});
    }

    public void setPreviewTexture(SurfaceTexture surfaceTexture) throws Exception {
        AntCamera antCamera = this.b;
        if (antCamera == null) {
            return;
        }
        antCamera.setPreviewTexture(surfaceTexture);
    }

    public void setPreviewTextureNull() throws Exception {
        AntCamera antCamera = this.b;
        if (antCamera == null) {
            return;
        }
        antCamera.setPreviewTexture(null);
    }

    public void setStopCancelFocus(boolean z) {
        this.m = z;
    }

    public void setSupportFocusArea(boolean z) {
        CameraConfigurationManager cameraConfigurationManager = this.a;
        if (cameraConfigurationManager != null) {
            cameraConfigurationManager.setSupportFocusArea(z);
        }
    }

    public void setTorch(final boolean z) {
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera.CameraManager.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (z == CameraManager.this.a.getTorchState(CameraManager.this.b) || CameraManager.this.b == null) {
                            return;
                        }
                        if (CameraManager.this.e != null) {
                            CameraManager.this.e.stopAutoFocus();
                        }
                        CameraManager.this.a.setTorch(CameraManager.this.b, z);
                        if (CameraManager.this.e != null) {
                            CameraManager.this.e.startAutoFocus();
                        }
                        if (CameraManager.this.s != null) {
                            CameraManager.this.s.setTorchState(z);
                        }
                    } catch (ScanExceptionHandler.TorchException e) {
                        MPaasLogger.e("CameraManager", new Object[]{"setTorch: "}, e);
                    }
                }
            });
        }
    }

    public void setZoomParameter(final int i) {
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.post(new Runnable() { // from class: com.alipay.camera.CameraManager.4
                /* JADX WARN: Removed duplicated region for block: B:20:0x0072 A[Catch: Exception -> 0x00a8, TryCatch #0 {Exception -> 0x00a8, blocks: (B:3:0x0005, B:6:0x000e, B:8:0x0038, B:18:0x005d, B:20:0x0072, B:22:0x0086, B:23:0x0096, B:25:0x009e, B:12:0x0041), top: B:30:0x0005 }] */
                /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
                @Override // java.lang.Runnable
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public void run() {
                    /*
                        r13 = this;
                        java.lang.String r0 = "CameraManager"
                        r1 = 2
                        r2 = 0
                        r3 = 1
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.camera.base.AntCamera r4 = com.alipay.camera.CameraManager.a(r4)     // Catch: java.lang.Exception -> La8
                        if (r4 != 0) goto Le
                        return
                    Le:
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.camera.base.AntCamera r4 = com.alipay.camera.CameraManager.a(r4)     // Catch: java.lang.Exception -> La8
                        android.hardware.Camera$Parameters r4 = r4.getParameters()     // Catch: java.lang.Exception -> La8
                        int r5 = r4.getMaxZoom()     // Catch: java.lang.Exception -> La8
                        float r5 = (float) r5     // Catch: java.lang.Exception -> La8
                        r6 = 1058642330(0x3f19999a, float:0.6)
                        float r5 = r5 * r6
                        double r5 = (double) r5     // Catch: java.lang.Exception -> La8
                        r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
                        double r5 = r5 + r7
                        int r5 = (int) r5     // Catch: java.lang.Exception -> La8
                        int r6 = r4.getMaxZoom()     // Catch: java.lang.Exception -> La8
                        float r6 = (float) r6     // Catch: java.lang.Exception -> La8
                        r9 = 0
                        float r6 = r6 * r9
                        double r9 = (double) r6     // Catch: java.lang.Exception -> La8
                        double r9 = r9 + r7
                        int r6 = (int) r9     // Catch: java.lang.Exception -> La8
                        int r7 = r2     // Catch: java.lang.Exception -> La8
                        r8 = -2147483648(0xffffffff80000000, float:-0.0)
                        if (r7 != r8) goto L41
                        int r7 = r4.getZoom()     // Catch: java.lang.Exception -> La8
                        if (r7 > r6) goto L3f
                        goto L5d
                    L3f:
                        r5 = r6
                        goto L5d
                    L41:
                        int r7 = r4.getZoom()     // Catch: java.lang.Exception -> La8
                        double r7 = (double) r7     // Catch: java.lang.Exception -> La8
                        int r9 = r2     // Catch: java.lang.Exception -> La8
                        double r9 = (double) r9     // Catch: java.lang.Exception -> La8
                        r11 = 4576918229304087675(0x3f847ae147ae147b, double:0.01)
                        double r9 = r9 * r11
                        double r11 = (double) r5     // Catch: java.lang.Exception -> La8
                        double r9 = r9 * r11
                        double r7 = r7 + r9
                        int r7 = (int) r7     // Catch: java.lang.Exception -> La8
                        if (r7 >= r5) goto L58
                        r5 = r7
                    L58:
                        if (r5 >= r6) goto L5b
                        goto L3f
                    L5b:
                        r6 = r5
                        goto L3f
                    L5d:
                        java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch: java.lang.Exception -> La8
                        java.lang.String r7 = "The object Zoom is "
                        r6[r2] = r7     // Catch: java.lang.Exception -> La8
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r5)     // Catch: java.lang.Exception -> La8
                        r6[r3] = r7     // Catch: java.lang.Exception -> La8
                        com.alipay.mobile.bqcscanservice.MPaasLogger.d(r0, r6)     // Catch: java.lang.Exception -> La8
                        boolean r6 = r4.isZoomSupported()     // Catch: java.lang.Exception -> La8
                        if (r6 == 0) goto Lcf
                        r4.setZoom(r5)     // Catch: java.lang.Exception -> La8
                        com.alipay.camera.CameraManager r6 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.camera.base.AntCamera r6 = com.alipay.camera.CameraManager.a(r6)     // Catch: java.lang.Exception -> La8
                        r6.setParameters(r4)     // Catch: java.lang.Exception -> La8
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.mobile.bqcscanservice.impl.BQCScanController r4 = com.alipay.camera.CameraManager.f(r4)     // Catch: java.lang.Exception -> La8
                        if (r4 == 0) goto L96
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.mobile.bqcscanservice.impl.BQCScanController r4 = com.alipay.camera.CameraManager.f(r4)     // Catch: java.lang.Exception -> La8
                        java.lang.String r6 = "zoom"
                        float r7 = (float) r5     // Catch: java.lang.Exception -> La8
                        java.lang.Float r7 = java.lang.Float.valueOf(r7)     // Catch: java.lang.Exception -> La8
                        r4.setEngineExtInfo(r6, r7)     // Catch: java.lang.Exception -> La8
                    L96:
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.mobile.bqcscanservice.monitor.ScanCodeState r4 = com.alipay.camera.CameraManager.e(r4)     // Catch: java.lang.Exception -> La8
                        if (r4 == 0) goto Lcf
                        com.alipay.camera.CameraManager r4 = com.alipay.camera.CameraManager.this     // Catch: java.lang.Exception -> La8
                        com.alipay.mobile.bqcscanservice.monitor.ScanCodeState r4 = com.alipay.camera.CameraManager.e(r4)     // Catch: java.lang.Exception -> La8
                        r4.setZoom(r5)     // Catch: java.lang.Exception -> La8
                        goto Lcf
                    La8:
                        r4 = move-exception
                        java.lang.Class[] r5 = new java.lang.Class[r3]
                        java.lang.Class r6 = java.lang.Integer.TYPE
                        r5[r2] = r6
                        java.lang.Object[] r6 = new java.lang.Object[r3]
                        int r7 = r2
                        java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
                        r6[r2] = r7
                        java.lang.String r7 = "recordSetZoomException"
                        com.alipay.mobile.bqcscanservice.behavior.WalletBury.addWalletBury(r7, r5, r6)
                        java.lang.Object[] r1 = new java.lang.Object[r1]
                        java.lang.String r5 = "SetZoomParameters : "
                        r1[r2] = r5
                        int r2 = r2
                        java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
                        r1[r3] = r2
                        com.alipay.mobile.bqcscanservice.MPaasLogger.e(r0, r1, r4)
                    Lcf:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.alipay.camera.CameraManager.AnonymousClass4.run():void");
                }
            });
        }
    }

    public void startPreview() {
        CameraFocusParamConfig focusParamConfig;
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            cameraHandler.addCallback(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE, this);
            this.k.addCallback(CameraHandler.SET_FOCUS_AREA, this);
            this.k.addCallback(CameraHandler.SET_METERING_AREA, this);
            this.k.addCallback(CameraHandler.CLICK_FOCUS_AREA, this);
            this.k.addCallback(CameraHandler.SET_EXPOSURE_STATE, this);
            this.k.addCallback(CameraHandler.ADJUST_EXPOSURE_STATE, this);
            this.k.addCallback(CameraHandler.AUTO_MANUAL_FOCUS, this);
        }
        AntCamera antCamera = this.b;
        if (antCamera == null || this.f) {
            return;
        }
        try {
            CameraConfigurationManager cameraConfigurationManager = this.a;
            if (cameraConfigurationManager != null && "continuous-picture".equals(cameraConfigurationManager.getFocusMode())) {
                antCamera.setAutoFocusMoveCallback(new AntCamera.AutoFocusMoveCallbackProxy(this) { // from class: com.alipay.camera.CameraManager.2
                    @Override // com.alipay.camera.base.AntCamera.AutoFocusMoveCallbackProxy
                    public void onAutoFocusMovingProxy(boolean z, AntCamera antCamera2) {
                        MPaasLogger.d("CameraManager", new Object[]{"onAutoFocusMovingProxy start:", Boolean.valueOf(z)});
                    }
                });
            }
        } catch (Throwable th) {
            MPaasLogger.e("CameraManager", new Object[]{"setAutoFocusMoveCallback with exception:"}, th);
        }
        MPaasLogger.d("CameraManager", new Object[]{"start native startPreview()"});
        SystraceWrapper.beginTrace("startPreview");
        antCamera.startPreview();
        SystraceWrapper.endTrace();
        MPaasLogger.d("CameraManager", new Object[]{"end native startPreview()"});
        this.f = true;
        if (this.d) {
            return;
        }
        MPaasLogger.d("CameraManager", new Object[]{"startPreview(): focusMode: ", this.a.getFocusMode()});
        CameraConfigurationManager cameraConfigurationManager2 = this.a;
        if (cameraConfigurationManager2 == null || (focusParamConfig = cameraConfigurationManager2.getFocusParamConfig()) == null) {
            return;
        }
        if (TextUtils.equals(focusParamConfig.getInitFocusMode(), "auto")) {
            NewAutoFocusManager newAutoFocusManager = new NewAutoFocusManager(this.b, this.k);
            this.e = newAutoFocusManager;
            newAutoFocusManager.startAutoFocus();
        }
        if (focusParamConfig.getSecondDuration() > 0) {
            q(CameraHandler.SECOND_FOCUS_DELAY_MESSAGE.intValue(), focusParamConfig.getSecondDuration());
        }
    }

    public void stopAutoFocus() {
        NewAutoFocusManager newAutoFocusManager = this.e;
        if (newAutoFocusManager != null) {
            newAutoFocusManager.stopAutoFocus();
        }
    }

    public void stopPreview() {
        int[] iArr;
        if (this.c != null) {
            CameraFocusStateMonitor cameraFocusStateMonitor = this.q;
            WalletBury.addWalletBury("recordCameraParamsDetail", new Class[]{Camera.Parameters.class, String.class}, new Object[]{this.c, cameraFocusStateMonitor == null ? "NULL" : cameraFocusStateMonitor.getString()});
            this.c.getPreviewFpsRange(new int[2]);
            String str = jn1.ARRAY_START_STR + (iArr[0] / 1000) + AVFSCacheConstants.COMMA_SEP + (iArr[1] / 1000) + jn1.ARRAY_END_STR;
            WalletBury.addWalletBury("recordCameraFpsInfo", new Class[]{String.class, String.class, String.class}, new Object[]{String.valueOf(false), NetworkUtil.NETWORK_CLASS_UNKNOWN, str});
            MPaasLogger.d("CameraManager", new Object[]{"stopPreview fpsRangeStr:", str});
        }
        NewAutoFocusManager newAutoFocusManager = this.e;
        if (newAutoFocusManager != null) {
            newAutoFocusManager.stopAutoFocus();
            this.e = null;
        }
        CameraHandler cameraHandler = this.k;
        if (cameraHandler != null) {
            Integer num = CameraHandler.SECOND_FOCUS_DELAY_MESSAGE;
            cameraHandler.clearMessages(num.intValue());
            this.k.removeCallback(num);
            CameraHandler cameraHandler2 = this.k;
            Integer num2 = CameraHandler.SET_FOCUS_AREA;
            cameraHandler2.clearMessages(num2.intValue());
            this.k.removeCallback(num2);
            CameraHandler cameraHandler3 = this.k;
            Integer num3 = CameraHandler.CLICK_FOCUS_AREA;
            cameraHandler3.clearMessages(num3.intValue());
            this.k.removeCallback(num3);
            CameraHandler cameraHandler4 = this.k;
            Integer num4 = CameraHandler.SET_EXPOSURE_STATE;
            cameraHandler4.clearMessages(num4.intValue());
            this.k.removeCallback(num4);
            CameraHandler cameraHandler5 = this.k;
            Integer num5 = CameraHandler.ADJUST_EXPOSURE_STATE;
            cameraHandler5.clearMessages(num5.intValue());
            this.k.removeCallback(num5);
            CameraHandler cameraHandler6 = this.k;
            Integer num6 = CameraHandler.AUTO_MANUAL_FOCUS;
            cameraHandler6.clearMessages(num6.intValue());
            this.k.removeCallback(num6);
            CameraHandler cameraHandler7 = this.k;
            Integer num7 = CameraHandler.SET_METERING_AREA;
            cameraHandler7.clearMessages(num7.intValue());
            this.k.removeCallback(num7);
        }
        AntCamera antCamera = this.b;
        if (antCamera != null && this.f) {
            if (this.m) {
                antCamera.cancelAutoFocus();
            }
            if (!this.t) {
                SystraceWrapper.beginTrace("stopPreview");
                this.b.stopPreview();
                SystraceWrapper.endTrace();
            }
            this.f = false;
        }
        this.o = null;
    }

    public void takePicture(MPaasScanService.OnPictureTakenListener onPictureTakenListener) {
    }

    public CameraManager(Context context, Camera.Parameters parameters, Point point, Point point2, CameraHandler cameraHandler, Point point3, ScanCodeState scanCodeState) {
        this.j = null;
        this.l = true;
        this.m = false;
        this.t = false;
        this.h = point;
        this.i = point2;
        this.a = new CameraConfigurationManager(context, point, point2, ScanPerformanceConfig.needDowngradeCameraParams(), ScanPerformanceConfig.needCameraHighQuality());
        this.c = parameters;
        this.k = cameraHandler;
        this.j = point3;
        this.q = new CameraFocusStateMonitor();
        this.s = scanCodeState;
        if (sStatisticsCameraInfo) {
            o(context);
        }
    }

    public void openDriver(int i) {
        if (this.b == null) {
            this.b = OpenCameraInterface.open(i, false);
        }
    }

    public void setPreviewTexture(SurfaceHolder surfaceHolder) throws Exception {
        AntCamera antCamera = this.b;
        if (antCamera == null) {
            return;
        }
        antCamera.setPreviewDisplay(surfaceHolder);
        ScanCodeState scanCodeState = this.s;
        if (scanCodeState != null) {
            scanCodeState.setUseSurface(true);
        }
    }
}
