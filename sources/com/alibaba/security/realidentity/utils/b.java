package com.alibaba.security.realidentity.utils;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import tb.jn1;

/* compiled from: Taobao */
@TargetApi(15)
/* loaded from: classes8.dex */
public final class b {
    private static final String a = "CameraConfiguration";
    private static final int c = 153600;
    private static final int d = 1024000;
    private static final int e = 307200;
    private static final int f = 384000;
    private static final float i = 1.5f;
    private static final float j = 0.0f;
    private static final double k = 0.15d;
    private static final int l = 10;
    private static final int m = 20;
    private static final int n = 400;
    private static final Pattern b = Pattern.compile(";");
    private static int g = -1;
    private static int h = -1;

    private b() {
    }

    public static void a(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        String str;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z) {
            str = null;
        } else if (!z3 && !z2) {
            str = a(supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        } else {
            str = a(supportedFocusModes, "auto");
        }
        if (!z3 && str == null) {
            str = a(supportedFocusModes, BQCCameraParam.FOCUS_TYPE_MACRO, BQCCameraParam.FOCUS_TYPE_EDOF);
        }
        if (str != null) {
            if (str.equals(parameters.getFocusMode())) {
                com.alibaba.security.common.c.a.b(a, "Focus mode already set to ".concat(str));
            } else {
                parameters.setFocusMode(str);
            }
        }
    }

    public static void b(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f2 = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    com.alibaba.security.common.c.a.b(a, "Exposure compensation already set to " + max + " / " + f2);
                    return;
                }
                com.alibaba.security.common.c.a.b(a, "Setting exposure compensation to " + max + " / " + f2);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        com.alibaba.security.common.c.a.b(a, "Camera does not support exposure compensation");
    }

    public static void c(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (parameters.getVideoStabilization()) {
                com.alibaba.security.common.c.a.b(a, "Video stabilization already enabled");
                return;
            }
            com.alibaba.security.common.c.a.b(a, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
            return;
        }
        com.alibaba.security.common.c.a.b(a, "This device does not support video stabilization");
    }

    public static void d(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            com.alibaba.security.common.c.a.b(a, "Barcode scene mode already set");
            return;
        }
        String a2 = a(parameters.getSupportedSceneModes(), "barcode");
        if (a2 != null) {
            parameters.setSceneMode(a2);
        }
    }

    public static void e(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            com.alibaba.security.common.c.a.b(a, "Negative effect already set");
            return;
        }
        String a2 = a(parameters.getSupportedColorEffects(), "negative");
        if (a2 != null) {
            parameters.setColorEffect(a2);
        }
    }

    private static void f(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        com.alibaba.security.common.c.a.b(a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i2 = next[0];
            int i3 = next[1];
            if (i2 >= 10000 && i3 <= 20000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            com.alibaba.security.common.c.a.b(a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            com.alibaba.security.common.c.a.b(a, "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        com.alibaba.security.common.c.a.b(a, "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    private static void g(Camera.Parameters parameters) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        com.alibaba.security.common.c.a.b(a, "Supported FPS ranges: " + a((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        int[] iArr = null;
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            int[] next = it.next();
            int i2 = next[0];
            int i3 = next[1];
            if (i2 >= 10000 && i3 <= 20000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            com.alibaba.security.common.c.a.b(a, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            com.alibaba.security.common.c.a.b(a, "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        com.alibaba.security.common.c.a.b(a, "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    private static String h(Camera.Parameters parameters) {
        String flatten = parameters.flatten();
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND());
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI());
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT());
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.getRELEASE());
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (flatten != null) {
            String[] split = b.split(flatten);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    private static int c() {
        int i2 = g;
        return i2 > 0 ? i2 : e;
    }

    public static void a(Camera.Parameters parameters, boolean z) {
        String a2;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            a2 = a(supportedFlashModes, "torch", "on");
        } else {
            a2 = a(supportedFlashModes, "off");
        }
        if (a2 != null) {
            if (a2.equals(parameters.getFlashMode())) {
                com.alibaba.security.common.c.a.b(a, "Flash mode already set to ".concat(a2));
                return;
            }
            com.alibaba.security.common.c.a.b(a, "Setting flash mode to ".concat(a2));
            parameters.setFlashMode(a2);
        }
    }

    public static void b(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            com.alibaba.security.common.c.a.b(a, "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> a2 = a();
            com.alibaba.security.common.c.a.b(a, "Setting metering area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setMeteringAreas(a2);
            return;
        }
        com.alibaba.security.common.c.a.b(a, "Device does not support metering areas");
    }

    public static void a(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            com.alibaba.security.common.c.a.b(a, "Old focus areas: " + a((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> a2 = a();
            com.alibaba.security.common.c.a.b(a, "Setting focus area to : " + a((Iterable<Camera.Area>) a2));
            parameters.setFocusAreas(a2);
            return;
        }
        com.alibaba.security.common.c.a.b(a, "Device does not support focus areas");
    }

    private static int b() {
        int i2 = h;
        return i2 > 0 ? i2 : f;
    }

    private static Integer b(Camera.Parameters parameters, double d2) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        com.alibaba.security.common.c.a.b(a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios != null && !zoomRatios.isEmpty() && zoomRatios.size() == maxZoom + 1) {
            double d3 = d2 * 100.0d;
            double d4 = Double.POSITIVE_INFINITY;
            int i2 = 0;
            for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
                double abs = Math.abs(zoomRatios.get(i3).intValue() - d3);
                if (abs < d4) {
                    i2 = i3;
                    d4 = abs;
                }
            }
            com.alibaba.security.common.c.a.b(a, "Chose zoom ratio of " + (zoomRatios.get(i2).intValue() / 100.0d));
            return Integer.valueOf(i2);
        }
        com.alibaba.security.common.c.a.e(a, "Invalid zoom ratios!");
        return null;
    }

    private static List<Camera.Area> a() {
        return Collections.singletonList(new Camera.Area(new Rect(-400, -400, 400, 400), 1));
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.graphics.Point a(android.hardware.Camera.Parameters r5, int r6) {
        /*
            java.util.List r5 = r5.getSupportedPictureSizes()
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>(r5)
            com.alibaba.security.realidentity.utils.b$1 r5 = new com.alibaba.security.realidentity.utils.b$1
            r5.<init>()
            java.util.Collections.sort(r0, r5)
            java.util.Iterator r5 = r0.iterator()
        L15:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L43
            java.lang.Object r1 = r5.next()
            android.hardware.Camera$Size r1 = (android.hardware.Camera.Size) r1
            int r2 = r1.width
            int r1 = r1.height
            int r3 = r2 * r1
            int r4 = com.alibaba.security.realidentity.utils.b.h
            if (r4 <= 0) goto L2c
            goto L2f
        L2c:
            r4 = 384000(0x5dc00, float:5.38099E-40)
        L2f:
            if (r3 <= r4) goto L3d
            java.lang.String r3 = com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL()
            java.lang.String r4 = "LA6-L"
            boolean r3 = r4.equals(r3)
            if (r3 == 0) goto L15
        L3d:
            android.graphics.Point r5 = new android.graphics.Point
            r5.<init>(r2, r1)
            return r5
        L43:
            r5 = 0
            java.lang.Object r5 = r0.get(r5)
            android.hardware.Camera$Size r5 = (android.hardware.Camera.Size) r5
            int r6 = r6 % 180
            if (r6 != 0) goto L53
            int r6 = r5.width
            int r5 = r5.height
            goto L57
        L53:
            int r6 = r5.height
            int r5 = r5.width
        L57:
            android.graphics.Point r0 = new android.graphics.Point
            r0.<init>(r6, r5)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.utils.b.a(android.hardware.Camera$Parameters, int):android.graphics.Point");
    }

    private static void a(Camera.Parameters parameters, double d2) {
        Integer num;
        if (parameters.isZoomSupported()) {
            List<Integer> zoomRatios = parameters.getZoomRatios();
            com.alibaba.security.common.c.a.b(a, "Zoom ratios: ".concat(String.valueOf(zoomRatios)));
            int maxZoom = parameters.getMaxZoom();
            if (zoomRatios != null && !zoomRatios.isEmpty() && zoomRatios.size() == maxZoom + 1) {
                double d3 = d2 * 100.0d;
                double d4 = Double.POSITIVE_INFINITY;
                int i2 = 0;
                for (int i3 = 0; i3 < zoomRatios.size(); i3++) {
                    double abs = Math.abs(zoomRatios.get(i3).intValue() - d3);
                    if (abs < d4) {
                        i2 = i3;
                        d4 = abs;
                    }
                }
                com.alibaba.security.common.c.a.b(a, "Chose zoom ratio of " + (zoomRatios.get(i2).intValue() / 100.0d));
                num = Integer.valueOf(i2);
            } else {
                com.alibaba.security.common.c.a.e(a, "Invalid zoom ratios!");
                num = null;
            }
            if (num == null) {
                return;
            }
            if (parameters.getZoom() == num.intValue()) {
                com.alibaba.security.common.c.a.b(a, "Zoom is already set to ".concat(String.valueOf(num)));
                return;
            }
            com.alibaba.security.common.c.a.b(a, "Setting zoom to ".concat(String.valueOf(num)));
            parameters.setZoom(num.intValue());
            return;
        }
        com.alibaba.security.common.c.a.b(a, "Zoom is not supported");
    }

    public static Point a(Camera.Parameters parameters, Point point) {
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            com.alibaba.security.common.c.a.e(a, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.alibaba.security.realidentity.utils.b.2
            private static int a(Camera.Size size, Camera.Size size2) {
                int i2 = size.height * size.width;
                int i3 = size2.height * size2.width;
                if (i3 < i2) {
                    return -1;
                }
                return i3 > i2 ? 1 : 0;
            }

            @Override // java.util.Comparator
            public final /* bridge */ /* synthetic */ int compare(Camera.Size size, Camera.Size size2) {
                Camera.Size size3 = size;
                Camera.Size size4 = size2;
                int i2 = size3.height * size3.width;
                int i3 = size4.height * size4.width;
                if (i3 < i2) {
                    return -1;
                }
                return i3 > i2 ? 1 : 0;
            }
        });
        if (com.alibaba.security.common.c.a.a()) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            com.alibaba.security.common.c.a.b(a, "Supported preview sizes: ".concat(String.valueOf(sb)));
        }
        double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        if (!(xVar < 1.0d)) {
            xVar = 1.0d / xVar;
        }
        com.alibaba.security.common.c.a.b(a, "SQY:" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) + Constants.Name.X + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        Point point2 = null;
        double d2 = Double.POSITIVE_INFINITY;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i2 = size2.width;
            int i3 = size2.height;
            int i4 = i2 * i3;
            if (i4 >= c && i4 <= d) {
                boolean z = i2 > i3;
                int i5 = z ? i3 : i2;
                int i6 = z ? i2 : i3;
                if (i5 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && i6 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) {
                    return new Point(i2, i3);
                }
                str = str2;
                double abs = Math.abs((i5 / i6) - xVar);
                if (abs < d2) {
                    point2 = new Point(i2, i3);
                    d2 = abs;
                }
            } else {
                str = str2;
                it.remove();
            }
            str2 = str;
        }
        String str3 = str2;
        if (point2 == null) {
            Camera.Size previewSize2 = parameters.getPreviewSize();
            if (previewSize2 != null) {
                return new Point(previewSize2.width, previewSize2.height);
            }
            throw new IllegalStateException(str3);
        }
        return point2;
    }

    private static void a(List<Camera.Size> list) {
        String str = "";
        for (Camera.Size size : list) {
            str = str + size.width + Constants.Name.X + size.height + StringUtils.LF;
        }
    }

    private static String a(Collection<String> collection, String... strArr) {
        if (collection != null) {
            for (String str : strArr) {
                if (collection.contains(str)) {
                    return str;
                }
            }
            return null;
        }
        return null;
    }

    private static String a(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START);
        Iterator<int[]> it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString(it.next()));
            if (it.hasNext()) {
                sb.append(AVFSCacheConstants.COMMA_SEP);
            }
        }
        sb.append(jn1.ARRAY_END);
        return sb.toString();
    }

    private static String a(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Camera.Area area : iterable) {
            sb.append(area.rect);
            sb.append(jn1.CONDITION_IF_MIDDLE);
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    private static String a(CharSequence charSequence) {
        StringBuilder sb = new StringBuilder(1000);
        sb.append("BOARD=");
        sb.append(android.os.Build.BOARD);
        sb.append('\n');
        sb.append("BRAND=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND());
        sb.append('\n');
        sb.append("CPU_ABI=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getCPU_ABI());
        sb.append('\n');
        sb.append("DEVICE=");
        sb.append(android.os.Build.DEVICE);
        sb.append('\n');
        sb.append("DISPLAY=");
        sb.append(android.os.Build.DISPLAY);
        sb.append('\n');
        sb.append("FINGERPRINT=");
        sb.append(android.os.Build.FINGERPRINT);
        sb.append('\n');
        sb.append("HOST=");
        sb.append(android.os.Build.HOST);
        sb.append('\n');
        sb.append("ID=");
        sb.append(android.os.Build.ID);
        sb.append('\n');
        sb.append("MANUFACTURER=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMANUFACTURER());
        sb.append('\n');
        sb.append("MODEL=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        sb.append('\n');
        sb.append("PRODUCT=");
        sb.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getPRODUCT());
        sb.append('\n');
        sb.append("TAGS=");
        sb.append(android.os.Build.TAGS);
        sb.append('\n');
        sb.append("TIME=");
        sb.append(android.os.Build.TIME);
        sb.append('\n');
        sb.append("TYPE=");
        sb.append(android.os.Build.TYPE);
        sb.append('\n');
        sb.append("USER=");
        sb.append(android.os.Build.USER);
        sb.append('\n');
        sb.append("VERSION.CODENAME=");
        sb.append(Build.VERSION.CODENAME);
        sb.append('\n');
        sb.append("VERSION.INCREMENTAL=");
        sb.append(Build.VERSION.INCREMENTAL);
        sb.append('\n');
        sb.append("VERSION.RELEASE=");
        sb.append(Build.VERSION.getRELEASE());
        sb.append('\n');
        sb.append("VERSION.SDK_INT=");
        sb.append(Build.VERSION.SDK_INT);
        sb.append('\n');
        if (charSequence != null) {
            String[] split = b.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }
}
