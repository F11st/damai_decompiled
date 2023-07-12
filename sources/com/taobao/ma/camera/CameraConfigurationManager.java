package com.taobao.ma.camera;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.taobao.ma.camera.util.CameraConfigurationUtils;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.C9796v;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
final class CameraConfigurationManager {
    private static final String TAG = "CameraConfiguration";
    private int cameraDisplayOrientation = 90;
    private Point cameraResolution;
    private Map<String, Integer> compatibleRotation;
    private final Context context;
    private Point pictureResolution;
    private Point screenResolution;

    /* JADX INFO: Access modifiers changed from: package-private */
    public CameraConfigurationManager(Context context) {
        this.context = context;
    }

    private void doSetTorch(Camera.Parameters parameters, boolean z, boolean z2) {
        CameraConfigurationUtils.setTorch(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        if (z2 || defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            return;
        }
        CameraConfigurationUtils.setBestExposure(parameters, z);
    }

    private int getBestSupportImageFormat(Camera.Parameters parameters) {
        List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
        if (supportedPictureFormats.contains(256)) {
            return 256;
        }
        if (supportedPictureFormats.contains(4)) {
            return 4;
        }
        return supportedPictureFormats.contains(17) ? 17 : 0;
    }

    private int getBestSupportPreviewImageFormat(Camera.Parameters parameters) {
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats.contains(17)) {
            return 17;
        }
        return supportedPreviewFormats.contains(842094169) ? 842094169 : -1;
    }

    private void initializeTorch(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        doSetTorch(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point getCameraResolution() {
        return this.cameraResolution;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point getScreenResolution() {
        return this.screenResolution;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean getTorchState(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        if (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void initFromCameraParameters(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.context.getSystemService(C9796v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        Point point = new Point();
        com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
        this.screenResolution = point;
        Log.i(TAG, "Screen resolution: " + this.screenResolution);
        this.cameraResolution = CameraConfigurationUtils.findBestPreviewSizeValue(parameters, this.screenResolution);
        String model = Build.getMODEL();
        if ((!model.contains("HTC") || !model.contains("One")) && !model.contains("GT-N7100") && !model.contains("GT-I9300")) {
            if (model.equals("u8800")) {
                this.cameraResolution = new Point(LoginConstant.RESULT_WINDWANE_CLOSEW, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
            } else if (model.equals("MI PAD")) {
                this.cameraResolution = new Point(2048, 1536);
            }
        } else {
            this.cameraResolution = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
        }
        Log.i(TAG, "Camera resolution: " + this.cameraResolution);
        this.pictureResolution = CameraConfigurationUtils.findBestPictureSizeValue(parameters, this.cameraDisplayOrientation);
    }

    public void setCompatibleRotation(Map<String, Integer> map) {
        this.compatibleRotation = map;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setDesiredCameraParameters(Camera camera, boolean z) {
        Integer num;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            Log.w(TAG, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        Log.i(TAG, "Initial camera parameters: " + parameters.flatten());
        if (z) {
            Log.w(TAG, "In camera config safe mode -- most settings will not be honored");
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.context);
        initializeTorch(parameters, defaultSharedPreferences, z);
        CameraConfigurationUtils.setFocus(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                CameraConfigurationUtils.setInvertColor(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                CameraConfigurationUtils.setBarcodeSceneMode(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                CameraConfigurationUtils.setVideoStabilization(parameters);
                CameraConfigurationUtils.setFocusArea(parameters);
                CameraConfigurationUtils.setMetering(parameters);
            }
        }
        try {
            String model = Build.getMODEL();
            if (model != null) {
                if (model.contains("M9") && Build.getBRAND().contains("Meizu")) {
                    this.cameraDisplayOrientation += 90;
                } else {
                    String replace = model.toLowerCase(Locale.US).replace(" ", "");
                    if (replace.contains("nexus5x")) {
                        this.cameraDisplayOrientation += 180;
                    }
                    Map<String, Integer> map = this.compatibleRotation;
                    if (map != null && map.containsKey(replace) && (num = this.compatibleRotation.get(replace)) != null) {
                        this.cameraDisplayOrientation += num.intValue();
                    }
                    this.cameraDisplayOrientation %= 360;
                }
            }
            camera.setDisplayOrientation(this.cameraDisplayOrientation);
        } catch (Exception e) {
            parameters.setRotation(90);
            Log.w(TAG, "method error" + e.getLocalizedMessage());
        } catch (NoSuchMethodError e2) {
            parameters.setRotation(90);
            Log.w(TAG, "method error" + e2.getLocalizedMessage());
        }
        int bestSupportImageFormat = getBestSupportImageFormat(parameters);
        int bestSupportPreviewImageFormat = getBestSupportPreviewImageFormat(parameters);
        if (bestSupportPreviewImageFormat >= 0) {
            parameters.setPreviewFormat(bestSupportPreviewImageFormat);
        }
        String model2 = Build.getMODEL();
        if (model2.contains("HTC") && model2.contains("801e") && model2.contains("One")) {
            parameters.setZoom(30);
        } else if (model2.contains("GT-I9300")) {
            parameters.setZoom(20);
        }
        Log.i(TAG, "SQY: before set Camera parameters , now ScreenSize is " + this.screenResolution + ", previewSize to set  is " + this.cameraResolution);
        parameters.setPictureFormat(bestSupportImageFormat);
        Point point = this.pictureResolution;
        parameters.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        Point point2 = this.cameraResolution;
        parameters.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        Log.i(TAG, "Final camera parameters: " + parameters.flatten());
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point3 = this.cameraResolution;
            if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3) == previewSize.width && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3) == previewSize.height) {
                return;
            }
            Log.w(TAG, "Camera said it supported preview size " + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(this.cameraResolution) + 'x' + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.cameraResolution) + ", but after setting it, preview size is " + previewSize.width + 'x' + previewSize.height);
            Point point4 = this.cameraResolution;
            point4.x = previewSize.width;
            point4.y = previewSize.height;
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setTorch(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        doSetTorch(parameters, z, false);
        camera.setParameters(parameters);
    }
}
