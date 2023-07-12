package com.alibaba.security.realidentity.b;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Point;
import android.hardware.Camera;
import android.os.Build;
import android.preference.PreferenceManager;
import android.view.Display;
import android.view.WindowManager;
import com.ali.user.mobile.login.model.LoginConstant;
import com.alibaba.security.realidentity.utils.FrontLightMode;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
final class a {
    private static final String g = "a";
    final Context a;
    Point b;
    Point c;
    int d = 90;
    Point e;
    Map<String, Integer> f;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(Context context) {
        this.a = context;
    }

    private void b(Camera camera) {
        Camera.Parameters parameters = camera.getParameters();
        Display defaultDisplay = ((WindowManager) this.a.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            com.alibaba.wireless.security.aopsdk.replace.android.view.Display.getSize(defaultDisplay, point);
        }
        this.b = point;
        this.c = com.alibaba.security.realidentity.utils.b.a(parameters, point);
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
        this.e = com.alibaba.security.realidentity.utils.b.a(parameters, this.d);
        if (model.contains("ASUS_Z00ADB")) {
            this.e = new Point(1280, LoginConstant.RESULT_WINDWANE_CLOSEW);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Camera camera, boolean z) {
        Integer num;
        Camera.Parameters parameters = camera.getParameters();
        if (parameters == null) {
            com.alibaba.security.common.c.a.e(g, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        int i = 0;
        a(parameters, FrontLightMode.readPref(defaultSharedPreferences) == FrontLightMode.ON, z);
        com.alibaba.security.realidentity.utils.b.a(parameters, defaultSharedPreferences.getBoolean("preferences_auto_focus", true), defaultSharedPreferences.getBoolean("preferences_disable_continuous_focus", true), z);
        if (!z) {
            if (defaultSharedPreferences.getBoolean("preferences_invert_scan", false)) {
                com.alibaba.security.realidentity.utils.b.e(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_barcode_scene_mode", true)) {
                com.alibaba.security.realidentity.utils.b.d(parameters);
            }
            if (!defaultSharedPreferences.getBoolean("preferences_disable_metering", true)) {
                com.alibaba.security.realidentity.utils.b.c(parameters);
                com.alibaba.security.realidentity.utils.b.a(parameters);
                com.alibaba.security.realidentity.utils.b.b(parameters);
            }
        }
        try {
            String model = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
            if (model != null) {
                if (model.contains("M9") && com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND().contains("Meizu")) {
                    this.d += 90;
                } else {
                    String replace = model.toLowerCase(Locale.US).replace(" ", "");
                    if (replace.contains("nexus5x")) {
                        this.d += 180;
                    }
                    Map<String, Integer> map = this.f;
                    if (map != null && map.containsKey(replace) && (num = this.f.get(replace)) != null) {
                        this.d += num.intValue();
                    }
                    this.d %= 360;
                }
            }
            camera.setDisplayOrientation(this.d);
        } catch (Exception e) {
            parameters.setRotation(90);
            com.alibaba.security.common.c.a.e(g, "method error" + e.getLocalizedMessage());
        } catch (NoSuchMethodError e2) {
            parameters.setRotation(90);
            com.alibaba.security.common.c.a.e(g, "method error" + e2.getLocalizedMessage());
        }
        List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
        int i2 = 17;
        if (supportedPictureFormats.contains(256)) {
            i = 256;
        } else if (supportedPictureFormats.contains(4)) {
            i = 4;
        } else if (supportedPictureFormats.contains(17)) {
            i = 17;
        }
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (!supportedPreviewFormats.contains(17)) {
            i2 = supportedPreviewFormats.contains(842094169) ? 842094169 : -1;
        }
        if (i2 >= 0) {
            parameters.setPreviewFormat(i2);
        }
        String model2 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL();
        if (model2.contains("HTC") && model2.contains("801e") && model2.contains("One")) {
            parameters.setZoom(30);
        } else if (model2.contains("GT-I9300")) {
            parameters.setZoom(20);
        }
        parameters.setPictureFormat(i);
        Point point = this.e;
        parameters.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        Point point2 = this.c;
        parameters.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2));
        camera.setParameters(parameters);
        Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (previewSize != null) {
            Point point3 = this.c;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
            int i3 = previewSize.width;
            if (xVar == i3 && com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3) == previewSize.height) {
                return;
            }
            point3.x = i3;
            point3.y = previewSize.height;
        }
    }

    private static int b(Camera.Parameters parameters) {
        List<Integer> supportedPreviewFormats = parameters.getSupportedPreviewFormats();
        if (supportedPreviewFormats.contains(17)) {
            return 17;
        }
        return supportedPreviewFormats.contains(842094169) ? 842094169 : -1;
    }

    private Point b() {
        return this.b;
    }

    private void b(Camera camera, boolean z) {
        Camera.Parameters parameters = camera.getParameters();
        a(parameters, z, false);
        camera.setParameters(parameters);
    }

    private static int a(Camera.Parameters parameters) {
        List<Integer> supportedPictureFormats = parameters.getSupportedPictureFormats();
        if (supportedPictureFormats.contains(256)) {
            return 256;
        }
        if (supportedPictureFormats.contains(4)) {
            return 4;
        }
        return supportedPictureFormats.contains(17) ? 17 : 0;
    }

    private Point a() {
        return this.c;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean a(Camera camera) {
        Camera.Parameters parameters;
        String flashMode;
        return (camera == null || (parameters = camera.getParameters()) == null || (flashMode = parameters.getFlashMode()) == null || (!"on".equals(flashMode) && !"torch".equals(flashMode))) ? false : true;
    }

    private void a(Camera.Parameters parameters, SharedPreferences sharedPreferences, boolean z) {
        a(parameters, FrontLightMode.readPref(sharedPreferences) == FrontLightMode.ON, z);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(Camera.Parameters parameters, boolean z, boolean z2) {
        com.alibaba.security.realidentity.utils.b.a(parameters, z);
        SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(this.a);
        if (z2 || defaultSharedPreferences.getBoolean("preferences_disable_exposure", true)) {
            return;
        }
        com.alibaba.security.realidentity.utils.b.b(parameters, z);
    }

    private void a(Map<String, Integer> map) {
        this.f = map;
    }
}
