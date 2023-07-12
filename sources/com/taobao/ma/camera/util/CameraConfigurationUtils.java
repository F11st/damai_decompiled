package com.taobao.ma.camera.util;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.taobao.alivfssdk.utils.AVFSCacheConstants;
import com.taobao.ma.common.log.MaLogger;
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
/* loaded from: classes11.dex */
public final class CameraConfigurationUtils {
    private static final int AREA_PER_1000 = 400;
    private static final double MAX_ASPECT_DISTORTION = 0.15d;
    private static final float MAX_EXPOSURE_COMPENSATION = 1.5f;
    private static final int MAX_FPS = 20;
    private static final int MAX_PICTURE_PIXELS = 384000;
    private static final int MAX_PREVIEW_PIXELS = 1024000;
    private static final float MIN_EXPOSURE_COMPENSATION = 0.0f;
    private static final int MIN_FPS = 10;
    private static final int MIN_PICTURE_PIXELS = 307200;
    private static final int MIN_PREVIEW_PIXELS = 153600;
    private static final String TAG = "CameraConfiguration";
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static int minPicturePixels = -1;
    private static int maxPicturePixels = -1;

    private CameraConfigurationUtils() {
    }

    private static List<Camera.Area> buildMiddleArea(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static String collectStats(Camera.Parameters parameters) {
        return collectStats(parameters.flatten());
    }

    public static Point findBestPictureSizeValue(Camera.Parameters parameters, int i) {
        int i2;
        int i3;
        ArrayList<Camera.Size> arrayList = new ArrayList(parameters.getSupportedPictureSizes());
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.taobao.ma.camera.util.CameraConfigurationUtils.1
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i4 = size.height * size.width;
                int i5 = size2.height * size2.width;
                if (i5 < i4) {
                    return -1;
                }
                return i5 > i4 ? 1 : 0;
            }
        });
        for (Camera.Size size : arrayList) {
            int i4 = size.width;
            int i5 = size.height;
            if (i4 * i5 <= getMaxPicturePixels()) {
                return new Point(i4, i5);
            }
        }
        Camera.Size size2 = (Camera.Size) arrayList.get(0);
        if (i % 180 == 0) {
            i2 = size2.width;
            i3 = size2.height;
        } else {
            i2 = size2.height;
            i3 = size2.width;
        }
        return new Point(i2, i3);
    }

    public static Point findBestPreviewSizeValue(Camera.Parameters parameters, Point point) {
        String str;
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        String str2 = "Parameters contained no preview size!";
        if (supportedPreviewSizes == null) {
            Log.w(TAG, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() { // from class: com.taobao.ma.camera.util.CameraConfigurationUtils.2
            @Override // java.util.Comparator
            public int compare(Camera.Size size, Camera.Size size2) {
                int i = size.height * size.width;
                int i2 = size2.height * size2.width;
                if (i2 < i) {
                    return -1;
                }
                return i2 > i ? 1 : 0;
            }
        });
        if (Log.isLoggable(TAG, 4)) {
            StringBuilder sb = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb.append(size.width);
                sb.append('x');
                sb.append(size.height);
                sb.append(' ');
            }
            MaLogger.i("Supported preview sizes: " + ((Object) sb));
        }
        double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        if (!(xVar < 1.0d)) {
            xVar = 1.0d / xVar;
        }
        MaLogger.i("SQY:" + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) + Constants.Name.X + com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
        Point point2 = null;
        double d = Double.POSITIVE_INFINITY;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            Camera.Size size2 = (Camera.Size) it.next();
            int i = size2.width;
            int i2 = size2.height;
            int i3 = i * i2;
            if (i3 >= MIN_PREVIEW_PIXELS && i3 <= MAX_PREVIEW_PIXELS) {
                boolean z = i > i2;
                int i4 = z ? i2 : i;
                int i5 = z ? i : i2;
                if (i4 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) && i5 == com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point)) {
                    Point point3 = new Point(i, i2);
                    MaLogger.i("SQY:Found preview size exactly matching screen size: " + point3);
                    return point3;
                }
                str = str2;
                double abs = Math.abs((i4 / i5) - xVar);
                if (abs < d) {
                    point2 = new Point(i, i2);
                    MaLogger.i("SQY: new update bestSize: " + point2 + " --- diff = " + d + " --- newDiff= " + abs);
                    d = abs;
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
                Point point4 = new Point(previewSize2.width, previewSize2.height);
                MaLogger.i("SQY:No suitable preview sizes, using default: " + point4);
                MaLogger.i("SQY: default previewSize: " + parameters.getPreviewSize().width + "," + parameters.getPreviewSize().height);
                return point4;
            }
            throw new IllegalStateException(str3);
        }
        MaLogger.i("SQY: bestSize is not null: " + point2);
        return point2;
    }

    private static String findSettableValue(String str, Collection<String> collection, String... strArr) {
        MaLogger.i("Requesting " + str + " value from among: " + Arrays.toString(strArr));
        MaLogger.i("Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    MaLogger.i("Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        MaLogger.i("No supported values match");
        return null;
    }

    private static int getMaxPicturePixels() {
        int i = maxPicturePixels;
        return i > 0 ? i : MAX_PICTURE_PIXELS;
    }

    private static int getMinPicturePixels() {
        int i = minPicturePixels;
        return i > 0 ? i : MIN_PICTURE_PIXELS;
    }

    private static Integer indexOfClosestZoom(Camera.Parameters parameters, double d) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i(TAG, "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios != null && !zoomRatios.isEmpty() && zoomRatios.size() == maxZoom + 1) {
            double d2 = d * 100.0d;
            double d3 = Double.POSITIVE_INFINITY;
            int i = 0;
            for (int i2 = 0; i2 < zoomRatios.size(); i2++) {
                double abs = Math.abs(zoomRatios.get(i2).intValue() - d2);
                if (abs < d3) {
                    i = i2;
                    d3 = abs;
                }
            }
            Log.i(TAG, "Chose zoom ratio of " + (zoomRatios.get(i).intValue() / 100.0d));
            return Integer.valueOf(i);
        }
        Log.w(TAG, "Invalid zoom ratios!");
        return null;
    }

    private static void printfSupportedPreviewSizes(List<Camera.Size> list) {
        String str = "";
        for (Camera.Size size : list) {
            str = str + size.width + Constants.Name.X + size.height + StringUtils.LF;
        }
        MaLogger.i("SQY:" + str);
    }

    public static void setBarcodeSceneMode(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i(TAG, "Barcode scene mode already set");
            return;
        }
        String findSettableValue = findSettableValue("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (findSettableValue != null) {
            parameters.setSceneMode(findSettableValue);
        }
    }

    public static void setBestExposure(Camera.Parameters parameters, boolean z) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (minExposureCompensation != 0 || maxExposureCompensation != 0) {
            if (exposureCompensationStep > 0.0f) {
                int round = Math.round((z ? 0.0f : 1.5f) / exposureCompensationStep);
                float f = exposureCompensationStep * round;
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    Log.i(TAG, "Exposure compensation already set to " + max + " / " + f);
                    return;
                }
                Log.i(TAG, "Setting exposure compensation to " + max + " / " + f);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        Log.i(TAG, "Camera does not support exposure compensation");
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters) {
        setBestPreviewFPS(parameters, 10, 20);
    }

    public static void setFocus(Camera.Parameters parameters, boolean z, boolean z2, boolean z3) {
        String str;
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (!z) {
            str = null;
        } else if (!z3 && !z2) {
            str = findSettableValue("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto");
        } else {
            str = findSettableValue("focus mode", supportedFocusModes, "auto");
        }
        if (!z3 && str == null) {
            str = findSettableValue("focus mode", supportedFocusModes, BQCCameraParam.FOCUS_TYPE_MACRO, BQCCameraParam.FOCUS_TYPE_EDOF);
        }
        if (str != null) {
            if (str.equals(parameters.getFocusMode())) {
                Log.i(TAG, "Focus mode already set to " + str);
                return;
            }
            parameters.setFocusMode(str);
        }
    }

    public static void setFocusArea(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i(TAG, "Old focus areas: " + toString((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> buildMiddleArea = buildMiddleArea(400);
            Log.i(TAG, "Setting focus area to : " + toString((Iterable<Camera.Area>) buildMiddleArea));
            parameters.setFocusAreas(buildMiddleArea);
            return;
        }
        Log.i(TAG, "Device does not support focus areas");
    }

    public static void setInvertColor(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i(TAG, "Negative effect already set");
            return;
        }
        String findSettableValue = findSettableValue("color effect", parameters.getSupportedColorEffects(), "negative");
        if (findSettableValue != null) {
            parameters.setColorEffect(findSettableValue);
        }
    }

    public static void setMetering(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i(TAG, "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> buildMiddleArea = buildMiddleArea(400);
            Log.i(TAG, "Setting metering area to : " + toString((Iterable<Camera.Area>) buildMiddleArea));
            parameters.setMeteringAreas(buildMiddleArea);
            return;
        }
        Log.i(TAG, "Device does not support metering areas");
    }

    public static void setTorch(Camera.Parameters parameters, boolean z) {
        String findSettableValue;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z) {
            findSettableValue = findSettableValue("flash mode", supportedFlashModes, "torch", "on");
        } else {
            findSettableValue = findSettableValue("flash mode", supportedFlashModes, "off");
        }
        if (findSettableValue != null) {
            if (findSettableValue.equals(parameters.getFlashMode())) {
                Log.i(TAG, "Flash mode already set to " + findSettableValue);
                return;
            }
            Log.i(TAG, "Setting flash mode to " + findSettableValue);
            parameters.setFlashMode(findSettableValue);
        }
    }

    public static void setVideoStabilization(Camera.Parameters parameters) {
        if (parameters.isVideoStabilizationSupported()) {
            if (parameters.getVideoStabilization()) {
                Log.i(TAG, "Video stabilization already enabled");
                return;
            }
            Log.i(TAG, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
            return;
        }
        Log.i(TAG, "This device does not support video stabilization");
    }

    public static void setZoom(Camera.Parameters parameters, double d) {
        if (parameters.isZoomSupported()) {
            Integer indexOfClosestZoom = indexOfClosestZoom(parameters, d);
            if (indexOfClosestZoom == null) {
                return;
            }
            if (parameters.getZoom() == indexOfClosestZoom.intValue()) {
                Log.i(TAG, "Zoom is already set to " + indexOfClosestZoom);
                return;
            }
            Log.i(TAG, "Setting zoom to " + indexOfClosestZoom);
            parameters.setZoom(indexOfClosestZoom.intValue());
            return;
        }
        Log.i(TAG, "Zoom is not supported");
    }

    private static String toString(Collection<int[]> collection) {
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

    public static String collectStats(CharSequence charSequence) {
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
        if (charSequence != null) {
            String[] split = SEMICOLON.split(charSequence);
            Arrays.sort(split);
            for (String str : split) {
                sb.append(str);
                sb.append('\n');
            }
        }
        return sb.toString();
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters, int i, int i2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i(TAG, "Supported FPS ranges: " + toString((Collection<int[]>) supportedPreviewFpsRange));
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
            int i3 = next[0];
            int i4 = next[1];
            if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                iArr = next;
                break;
            }
        }
        if (iArr == null) {
            Log.i(TAG, "No suitable FPS range?");
            return;
        }
        int[] iArr2 = new int[2];
        parameters.getPreviewFpsRange(iArr2);
        if (Arrays.equals(iArr2, iArr)) {
            Log.i(TAG, "FPS range already set to " + Arrays.toString(iArr));
            return;
        }
        Log.i(TAG, "Setting FPS range to " + Arrays.toString(iArr));
        parameters.setPreviewFpsRange(iArr[0], iArr[1]);
    }

    private static String toString(Iterable<Camera.Area> iterable) {
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
}
