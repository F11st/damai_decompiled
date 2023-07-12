package com.alipay.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.os.SystemClock;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.camera.base.AntCamera;
import com.alipay.camera.compatible.CompatibleManager;
import com.alipay.camera.util.CameraConfigurationUtils;
import com.alipay.camera.util.CameraFocusParamConfig;
import com.alipay.camera.util.CameraSceneParamConfig;
import com.alipay.camera.util.FocusWhiteList;
import com.alipay.camera.util.FpsWhiteList;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.alipay.mobile.bqcscanservice.MPaasLogger;
import com.alipay.mobile.bqcscanservice.behavior.WalletBury;
import com.alipay.mobile.bqcscanservice.monitor.ScanExceptionHandler;
import com.alipay.util.ScanDeviceProperty;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import java.util.List;
import tb.jn1;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public final class CameraConfigurationManager {
    private static boolean t;
    private final Context a;
    private Point b;
    private Point c;
    private Point d;
    private int e;
    private String f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private CameraFocusParamConfig k;
    private CameraSceneParamConfig l;
    private boolean m;
    private Rect n;
    private int o;
    private Rect p;
    private final boolean q;
    private final boolean r;
    private int s;

    public CameraConfigurationManager(Context context, Point point, Point point2, boolean z, boolean z2) {
        this.e = 90;
        this.o = 50;
        this.s = 0;
        this.a = context;
        this.b = point;
        this.c = point2;
        this.k = new CameraFocusParamConfig();
        this.l = new CameraSceneParamConfig();
        this.q = z;
        this.r = z2;
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0072  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private int a(int r8) {
        /*
            r7 = this;
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo
            r0.<init>()
            java.lang.String r1 = "Scan"
            com.alipay.camera.base.AntCamera.getCameraInfo(r8, r0, r1)
            java.lang.String r8 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()
            java.lang.String r1 = "MIX 2"
            boolean r8 = android.text.TextUtils.equals(r1, r8)
            r1 = 3
            r2 = 2
            r3 = 1
            r4 = 0
            if (r8 == 0) goto L40
            android.content.Context r8 = r7.a
            java.lang.String r5 = "window"
            java.lang.Object r8 = r8.getSystemService(r5)
            android.view.WindowManager r8 = (android.view.WindowManager) r8
            android.view.Display r8 = r8.getDefaultDisplay()
            int r8 = r8.getRotation()
            r7.s = r8
            if (r8 == 0) goto L40
            if (r8 == r3) goto L3d
            if (r8 == r2) goto L3a
            if (r8 == r1) goto L37
            goto L40
        L37:
            r8 = 270(0x10e, float:3.78E-43)
            goto L41
        L3a:
            r8 = 180(0xb4, float:2.52E-43)
            goto L41
        L3d:
            r8 = 90
            goto L41
        L40:
            r8 = 0
        L41:
            r5 = 5
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.String r6 = "getCameraPreviewOrientation(orientation : "
            r5[r4] = r6
            int r4 = r0.orientation
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5[r3] = r4
            java.lang.String r4 = " degrees :"
            r5[r2] = r4
            java.lang.Integer r2 = java.lang.Integer.valueOf(r8)
            r5[r1] = r2
            r1 = 4
            java.lang.String r2 = ")"
            r5[r1] = r2
            java.lang.String r1 = "CameraConfiguration"
            com.alipay.mobile.bqcscanservice.MPaasLogger.d(r1, r5)
            int r1 = r0.facing
            if (r1 != r3) goto L72
            int r0 = r0.orientation
            int r0 = r0 + r8
            int r0 = r0 % 360
            int r8 = 360 - r0
            int r8 = r8 % 360
            goto L79
        L72:
            int r0 = r0.orientation
            int r0 = r0 - r8
            int r0 = r0 + 360
            int r8 = r0 % 360
        L79:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alipay.camera.CameraConfigurationManager.a(int):int");
    }

    private void b(int i) {
        StringBuilder sb = new StringBuilder();
        String brand = Build.getBRAND();
        sb.append(brand);
        sb.append("|");
        String model = Build.getMODEL();
        sb.append(model);
        sb.append("|");
        sb.append(android.os.Build.DISPLAY);
        String sb2 = sb.toString();
        int a = a(i);
        this.e = a;
        if (a != 90 && a != 270) {
            WalletBury.addWalletBury("recordPreviewOrientationOld", new Class[]{String.class, Integer.TYPE}, new Object[]{sb2, Integer.valueOf(a)});
            if (model != null) {
                MPaasLogger.d("CameraConfiguration", new Object[]{"The device is ", brand, AVFSCacheConstants.COMMA_SEP, model});
                if (model.contains("M9") && brand.contains("Meizu")) {
                    this.e = 180;
                    return;
                } else {
                    this.e = 90;
                    return;
                }
            }
            return;
        }
        WalletBury.addWalletBury("recordPreviewOrientationNewCal", new Class[]{String.class, Integer.TYPE}, new Object[]{sb2, Integer.valueOf(a)});
    }

    private Camera.Parameters c(Camera camera, Camera.Parameters parameters) {
        try {
            CameraConfigurationUtils.setFocusArea(parameters, this.b, this.n, this.e);
            camera.setParameters(parameters);
            MPaasLogger.d("CameraConfiguration", new Object[]{"invokeFocusRegion succeed"});
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"focus-area", "true"});
        } catch (Exception e) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeFocusRegion failed"}, e);
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"focus-area", "false"});
        }
        return camera.getParameters();
    }

    private void d(Camera.Parameters parameters, boolean z) {
        CameraConfigurationUtils.setTorch(parameters, z);
    }

    private int e(Camera.Parameters parameters) {
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats.contains(17)) {
            return 17;
        }
        return supportedPreviewFormats.contains(842094169) ? 842094169 : -1;
    }

    private void f(Camera.Parameters parameters) {
        d(parameters, false);
    }

    private boolean g() {
        return "xiaomi".equalsIgnoreCase(Build.getBRAND()) && Build.VERSION.SDK_INT >= 17 && Settings.Global.getInt(this.a.getContentResolver(), "force_fsg_nav_bar", 0) != 0;
    }

    public static void setEnableInitFocusToAuto(String str) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"setEnableInitFocusToAuto:", str});
        if (TextUtils.isEmpty(str)) {
            return;
        }
        t = BQCCameraParam.VALUE_YES.equalsIgnoreCase(str);
    }

    public Camera.Parameters adjustExposure(AntCamera antCamera, Camera.Parameters parameters, int i) {
        return antCamera == null ? parameters : adjustExposure(antCamera.getCamera(), parameters, i);
    }

    public Camera.Parameters forceInvokeFocusRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return (antCamera == null || parameters == null) ? parameters : c(antCamera.getCamera(), parameters);
    }

    public int getCameraDisplayOrientation() {
        return this.e;
    }

    public String getFocusMode() {
        MPaasLogger.d("CameraConfiguration", new Object[]{"The focus mode is ", this.f});
        return this.f;
    }

    public CameraFocusParamConfig getFocusParamConfig() {
        return this.k;
    }

    public Point getPictureSize() {
        return this.d;
    }

    public int getPreviewFmt() {
        return this.g;
    }

    public Point getPreviewResolution() {
        return this.c;
    }

    public Point getPreviewSize() {
        return this.c;
    }

    public Point getScreenResolution() {
        return this.b;
    }

    public boolean getSupportExposure() {
        return this.j;
    }

    public boolean getSupportFocusArea() {
        return this.h;
    }

    public boolean getSupportMeteringArea() {
        return this.i;
    }

    public boolean getTorchState(AntCamera antCamera) {
        if (antCamera == null) {
            return false;
        }
        return getTorchState(antCamera.getCamera());
    }

    public Camera.Parameters initFromCameraParameters(AntCamera antCamera) {
        if (antCamera == null) {
            return null;
        }
        return initFromCameraParameters(antCamera.getCamera(), (Point) null);
    }

    public Camera.Parameters invokeExposure(AntCamera antCamera, Camera.Parameters parameters, int i) {
        return antCamera == null ? parameters : invokeExposure(antCamera.getCamera(), parameters, i);
    }

    public Camera.Parameters invokeFocusParameters(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeFocusParameters(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters invokeFocusRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeFocusRegion(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters invokeMeteringRegion(AntCamera antCamera, Camera.Parameters parameters) {
        return antCamera == null ? parameters : invokeMeteringRegion(antCamera.getCamera(), parameters);
    }

    public Camera.Parameters setCameraScene(Camera.Parameters parameters, String str) {
        CameraSceneParamConfig cameraSceneParamConfig = this.l;
        if (cameraSceneParamConfig != null) {
            cameraSceneParamConfig.updateScene(str);
            if (this.l.getCurCameraScene() != null) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters, str);
            }
        }
        return parameters;
    }

    public void setConfigFocusMode(String str) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.updateFocusMode(str);
        }
    }

    public void setConfigSecondAutoDelayDuration(long j) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.setSecondDelayDuration(j);
        }
    }

    public void setDebugMode(boolean z) {
        this.m = z;
        if (z) {
            this.k.updateFocusMode("debug");
        }
    }

    public Camera.Parameters setDesiredCameraParameters(AntCamera antCamera, Camera.Parameters parameters, int i) {
        return antCamera == null ? parameters : setDesiredCameraParameters(antCamera.getCamera(), parameters, i);
    }

    public void setFocusPosition(int i, int i2) {
        if (this.b == null || this.c == null) {
            return;
        }
        int i3 = this.o;
        int i4 = i - i3 < 0 ? 0 : i - i3;
        int i5 = i2 - i3 >= 0 ? i2 - i3 : 0;
        int i6 = i + i3;
        Point point = this.b;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        if (i6 <= xVar) {
            xVar = i + i3;
        }
        int i7 = i2 + i3;
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        if (i7 <= yVar) {
            yVar = i2 + i3;
        }
        Rect rect = new Rect(i4, i5, xVar, yVar);
        Rect rect2 = new Rect();
        int i8 = this.e;
        if (i8 == 90) {
            Point point2 = this.c;
            int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
            Point point3 = this.b;
            int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3);
            rect2.left = (rect.top * xVar2) / yVar2;
            int yVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
            int xVar3 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
            rect2.top = ((xVar3 - rect.right) * yVar3) / xVar3;
            rect2.right = (xVar2 * rect.bottom) / yVar2;
            rect2.bottom = (yVar3 * (xVar3 - rect.left)) / xVar3;
        } else if (i8 != 270) {
            return;
        } else {
            Point point4 = this.c;
            int xVar4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4);
            Point point5 = this.b;
            int yVar4 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point5);
            rect2.left = ((yVar4 - rect.bottom) * xVar4) / yVar4;
            int yVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4);
            int xVar5 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point5);
            rect2.top = (rect.left * yVar5) / xVar5;
            rect2.right = (xVar4 * (yVar4 - rect.top)) / yVar4;
            rect2.bottom = (yVar5 * rect.right) / xVar5;
        }
        int i9 = rect2.right;
        int i10 = rect2.left;
        int i11 = i9 - i10;
        int i12 = rect2.bottom;
        int i13 = rect2.top;
        int i14 = i12 - i13;
        if (i11 < i14) {
            rect2.right = i10 + i14;
        } else {
            rect2.bottom = i13 + i11;
        }
        this.n = rect2;
    }

    public void setFocusRadius(int i) {
        this.o = i;
    }

    public void setFocusRegion(Rect rect) {
        this.n = rect;
    }

    public void setMeteringRegion(Rect rect) {
        this.p = rect;
    }

    public void setSupportExposureState(boolean z) {
        this.j = z;
    }

    public void setSupportFocusArea(boolean z) {
        this.h = z;
    }

    public void setSupportMeteringArea(boolean z) {
        this.i = z;
    }

    public void setTorch(AntCamera antCamera, boolean z) throws ScanExceptionHandler.TorchException {
        if (antCamera != null) {
            setTorch(antCamera.getCamera(), z);
        }
    }

    public void updateAutoFocusConfig(String str, long j) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            cameraFocusParamConfig.setSecondDelayDuration(j);
            this.k.setSecondFocusMode(str);
        }
    }

    public void updateFocusMode(String str) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"The origin focus mode is ", this.f, ", the input focus mode is ", str});
        this.f = str;
    }

    public Camera.Parameters adjustExposure(Camera camera, Camera.Parameters parameters, int i) {
        int minExposureCompensation;
        int maxExposureCompensation;
        if (!this.j || camera == null || parameters == null) {
            return parameters;
        }
        try {
            minExposureCompensation = parameters.getMinExposureCompensation();
            maxExposureCompensation = parameters.getMaxExposureCompensation();
        } catch (Exception e) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeExposure failed"}, e);
        }
        if (minExposureCompensation != 0 && maxExposureCompensation != 0) {
            int exposureCompensation = parameters.getExposureCompensation();
            MPaasLogger.d("CameraConfiguration", new Object[]{"Old Exposure State: ", Integer.valueOf(exposureCompensation), ", difference: ", Integer.valueOf(i)});
            int i2 = exposureCompensation + i;
            if (i2 >= minExposureCompensation) {
                minExposureCompensation = i2;
            }
            if (minExposureCompensation <= maxExposureCompensation) {
                maxExposureCompensation = minExposureCompensation;
            }
            CameraConfigurationUtils.setExposureState(parameters, maxExposureCompensation);
            camera.setParameters(parameters);
            return camera.getParameters();
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"did not support exposure"});
        return parameters;
    }

    public boolean getTorchState(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        if (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public Camera.Parameters initFromCameraParameters(Camera camera) {
        return initFromCameraParameters(camera, (Point) null);
    }

    public Camera.Parameters invokeExposure(Camera camera, Camera.Parameters parameters, int i) {
        if (!this.j || camera == null || parameters == null) {
            return parameters;
        }
        try {
            CameraConfigurationUtils.setExposureState(parameters, i);
            camera.setParameters(parameters);
        } catch (Exception e) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeExposure failed"}, e);
        }
        return camera.getParameters();
    }

    public Camera.Parameters invokeFocusParameters(Camera camera, Camera.Parameters parameters) {
        CameraFocusParamConfig cameraFocusParamConfig = this.k;
        if (cameraFocusParamConfig != null) {
            CameraConfigurationUtils.setFocus(parameters, cameraFocusParamConfig.getInitFocusMode(), this.k.getInitFocusAuto());
            camera.setParameters(parameters);
            Camera.Parameters parameters2 = camera.getParameters();
            String focusMode = parameters2.getFocusMode();
            this.f = focusMode;
            this.k.confirmInitFocusMode(focusMode);
            return parameters2;
        }
        return parameters;
    }

    public Camera.Parameters invokeFocusRegion(Camera camera, Camera.Parameters parameters) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"invokeFocusRegion: ", this.n, ", mSupportFocusArea:" + this.h});
        return (this.n == null || !this.h || camera == null || parameters == null) ? parameters : c(camera, parameters);
    }

    public Camera.Parameters invokeMeteringRegion(Camera camera, Camera.Parameters parameters) {
        MPaasLogger.d("CameraConfiguration", new Object[]{"invokeMeteringRegion: ", this.p});
        if (this.p == null || !this.i || camera == null || parameters == null) {
            return parameters;
        }
        try {
            CameraConfigurationUtils.setMetering(parameters, this.b, this.n, this.e);
            camera.setParameters(parameters);
            MPaasLogger.d("CameraConfiguration", new Object[]{"invokeMeteringRegion succeed"});
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"metering-area", "true"});
        } catch (Exception e) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"invokeMeteringRegion failed"}, e);
            WalletBury.addWalletBury("recordCameraParametersSet", new Class[]{String.class, String.class}, new String[]{"metering-area", "false"});
        }
        return camera.getParameters();
    }

    public Camera.Parameters setDesiredCameraParameters(Camera camera, Camera.Parameters parameters, int i) {
        Point point;
        int xVar;
        if (camera == null) {
            return parameters;
        }
        if (parameters == null) {
            parameters = camera.getParameters();
        }
        if (FpsWhiteList.inWhiteList(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND(), com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL())) {
            CameraConfigurationUtils.setBestPreviewFPS(parameters, 20, 30);
        }
        f(parameters);
        try {
            try {
                b(i);
                camera.setDisplayOrientation(this.e);
                MPaasLogger.d("CameraConfiguration", new Object[]{"setDisplayOrientation: ", Integer.valueOf(this.e)});
            } catch (Exception unused) {
                camera.setDisplayOrientation(this.e);
                MPaasLogger.d("CameraConfiguration", new Object[]{"setDisplayOrientation again: ", Integer.valueOf(this.e)});
            } catch (NoSuchMethodError e) {
                parameters.setRotation(this.e);
                MPaasLogger.e("CameraConfiguration", new Object[]{"method error"}, e);
            }
        } catch (Exception e2) {
            MPaasLogger.e("CameraConfiguration", new Object[]{"method error again "}, e2);
            parameters.setRotation(90);
        }
        int e3 = e(parameters);
        this.g = e3;
        if (e3 >= 0) {
            parameters.setPreviewFormat(e3);
        }
        Point point2 = this.c;
        parameters.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        Point findPictureSizeByTimes = CameraConfigurationUtils.findPictureSizeByTimes(parameters, this.c, this.q);
        this.d = findPictureSizeByTimes;
        boolean z = this.r || this.q;
        MPaasLogger.d("CameraConfiguration", new Object[]{"setDesiredCameraParameters, setPicSizeAndZsl: ", Boolean.valueOf(z)});
        if (z && findPictureSizeByTimes != null) {
            parameters.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(findPictureSizeByTimes), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(findPictureSizeByTimes));
        }
        if (parameters.isZoomSupported()) {
            parameters.setZoom((int) ((parameters.getMaxZoom() * 0.0f) + 0.5d));
        }
        if (findPictureSizeByTimes != null) {
            String postValidFocusMode = FocusWhiteList.postValidFocusMode("" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(findPictureSizeByTimes) + jn1.MUL + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(findPictureSizeByTimes));
            MPaasLogger.d("CameraConfiguration", new Object[]{"setDesiredParameters: postFocusType=", postValidFocusMode});
            if (this.k != null && !TextUtils.isEmpty(postValidFocusMode)) {
                this.k.postValidFocusMode(postValidFocusMode);
            }
        }
        if (t && ScanDeviceProperty.isXiaomiDevDevice() && this.k != null) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"xiaomi dev device, switch to auto mode"});
            this.k.postValidFocusMode("auto");
            WalletBury.addWalletBury("recordForceSwitchToAutoFocusMode", new Class[]{Boolean.TYPE, String.class}, new Object[]{Boolean.FALSE, String.valueOf(ScanDeviceProperty.getRomVersion())});
        }
        if (!this.m) {
            CameraFocusParamConfig cameraFocusParamConfig = this.k;
            boolean initFocusAuto = cameraFocusParamConfig != null ? cameraFocusParamConfig.getInitFocusAuto() : true;
            CameraFocusParamConfig cameraFocusParamConfig2 = this.k;
            CameraConfigurationUtils.setFocus(parameters, cameraFocusParamConfig2 != null ? cameraFocusParamConfig2.getInitFocusMode() : null, initFocusAuto);
            String focusMode = parameters.getFocusMode();
            this.f = focusMode;
            this.k.confirmInitFocusMode(focusMode);
        } else {
            CameraConfigurationUtils.setBarcodeSceneMode(parameters, "auto");
            CameraConfigurationUtils.setFocus(parameters, null, true);
            String focusMode2 = parameters.getFocusMode();
            this.f = focusMode2;
            this.k.confirmInitFocusMode(focusMode2);
        }
        if (z) {
            CompatibleManager.enableSetZSLValue(true);
            CompatibleManager.setZslValue(parameters, !this.q);
        }
        MPaasLogger.d("CameraConfiguration", new Object[]{"The Object focusMode is ", this.f});
        long elapsedRealtime = SystemClock.elapsedRealtime();
        CompatibleManager.optimizeParameters(parameters);
        camera.setParameters(parameters);
        Camera.Parameters parameters2 = camera.getParameters();
        MPaasLogger.i("CameraConfiguration", new Object[]{"duringSetParam2 =", Long.valueOf(SystemClock.elapsedRealtime() - elapsedRealtime)});
        Camera.Size previewSize = parameters2.getPreviewSize();
        if (previewSize != null && ((xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx((point = this.c))) != previewSize.width || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) != previewSize.height)) {
            Class cls = Integer.TYPE;
            WalletBury.addWalletBury("recordCameraPreviewParametersNotEqual", new Class[]{cls, cls, cls, cls}, new Object[]{Integer.valueOf(xVar), Integer.valueOf(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.c)), Integer.valueOf(previewSize.width), Integer.valueOf(previewSize.height)});
            Point point3 = this.c;
            point3.x = previewSize.width;
            point3.y = previewSize.height;
        }
        return parameters2;
    }

    public void setTorch(Camera camera, boolean z) throws ScanExceptionHandler.TorchException {
        Camera.Parameters parameters = camera.getParameters();
        d(parameters, z);
        try {
            camera.setParameters(parameters);
        } catch (Exception e) {
            Log.d("CameraConfiguration", "Toggle Torch Error");
            throw new ScanExceptionHandler.TorchException(z, 4001, e.getMessage());
        }
    }

    public Camera.Parameters initFromCameraParameters(AntCamera antCamera, Point point) {
        if (antCamera == null) {
            return null;
        }
        return initFromCameraParameters(antCamera.getCamera(), point);
    }

    public Camera.Parameters initFromCameraParameters(Camera camera, Point point) {
        if (camera == null) {
            return null;
        }
        Camera.Parameters parameters = camera.getParameters();
        MPaasLogger.d("CameraConfiguration", new Object[]{"The first time to get parameters"});
        Display defaultDisplay = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        if (CameraConfigurationUtils.getPreviewOptimize()) {
            Point point2 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point2);
            this.b = point2;
        } else if (g() && CameraConfigurationUtils.getEnableDynamicPreviewSize()) {
            MPaasLogger.d("CameraConfiguration", new Object[]{"needFetchRealSize"});
            Point point3 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getRealSize(defaultDisplay, point3);
            this.b = point3;
        } else {
            Point point4 = new Point();
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point4);
            this.b = point4;
        }
        if (point == null || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) < 480 || com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) < 800) {
            point = this.b;
        }
        this.c = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, point, this.q);
        String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        if ((!model.contains("HTC") || !model.contains("One")) && !model.contains("GT-N7100") && !model.contains("GT-I9300")) {
            if (model.equals("u8800")) {
                this.c = new Point(LoginConstant.RESULT_WINDWANE_CLOSEW, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
            } else if (model.equals("MI PAD")) {
                this.c = new Point(2048, 1536);
            }
        } else {
            this.c = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
        }
        return parameters;
    }

    public CameraConfigurationManager(Context context, Point point, Point point2) {
        this.e = 90;
        this.o = 50;
        this.s = 0;
        this.a = context;
        this.b = point;
        this.c = point2;
        this.k = new CameraFocusParamConfig();
        this.l = new CameraSceneParamConfig();
        this.q = false;
        this.r = false;
    }

    public CameraConfigurationManager(Context context, Point point, Point point2, Point point3) {
        this(context, point, point2);
        MPaasLogger.d("CameraConfiguration", new Object[]{"pictureResolution: ", point3});
    }
}
