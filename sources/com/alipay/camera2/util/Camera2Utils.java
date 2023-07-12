package com.alipay.camera2.util;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.text.TextUtils;
import android.util.Range;
import android.util.Size;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import tb.jn1;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes12.dex */
public class Camera2Utils {
    public static int DOWNGRADE_PREVIEW_HEIGHT = 1080;
    public static int DOWNGRADE_PREVIEW_WIDTH = 1440;
    public static int MAX_PREVIEW_HEIGHT = 1240;
    public static int MAX_PREVIEW_WIDTH = 2480;
    private static int a = 768000;
    private static int b = 2480 * 1240;
    private static float c = 4.0f;

    private static String a(int i) {
        switch (i) {
            case 0:
                return "BackwardCompatible";
            case 1:
                return "ManualSensor";
            case 2:
                return "PostProcessing";
            case 3:
                return "Raw";
            case 4:
                return "PrivateReprocessing";
            case 5:
                return "ReadSensorSettings";
            case 6:
                return "BurstCapture";
            case 7:
                return "YuvReprocessing";
            case 8:
                return "DepthOutput";
            case 9:
                return "HighSpeedVideo";
            case 10:
                return "MotionTracking";
            case 11:
                return "LogicalMultiCamera";
            case 12:
                return "MonoChrome";
            default:
                return "UnKnown-" + i;
        }
    }

    public static String cameraFacingToString(int i) {
        return i == 0 ? "FRONT" : "BACK";
    }

    public static String capabilitiesToString(int[] iArr) {
        if (iArr == null || iArr.length == 0) {
            return "Null";
        }
        int length = iArr.length;
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.ARRAY_START_STR);
        sb.append(a(iArr[0]));
        for (int i = 1; i < length; i++) {
            sb.append(",");
            sb.append(a(iArr[i]));
        }
        sb.append(jn1.ARRAY_END_STR);
        return sb.toString();
    }

    public static int clamp(int i, int i2, int i3) {
        return i > i3 ? i3 : i < i2 ? i2 : i;
    }

    public static boolean contains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    public static boolean contanisIgnoreCase(String str, String str2) {
        if (str == null || str2 == null) {
            return false;
        }
        return str.toLowerCase().contains(str2.toLowerCase());
    }

    public static Point findBestForScanPreviewSize(List<Point> list, Point point, boolean z) {
        if (list != null && list.size() != 0 && point != null) {
            Point point2 = z ? new Point(DOWNGRADE_PREVIEW_WIDTH, DOWNGRADE_PREVIEW_HEIGHT) : new Point(MAX_PREVIEW_WIDTH, MAX_PREVIEW_HEIGHT);
            double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (xVar < 1.0d) {
                xVar = 1.0d / xVar;
            }
            if (Math.abs((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2)) - xVar) >= 0.5d) {
                return null;
            }
            for (Point point3 : list) {
                if (point2.equals(point3)) {
                    return point2;
                }
            }
        }
        return null;
    }

    public static Point findBestJpegSize(Point point, List<Point> list, Point point2) {
        if (list == null || list.size() == 0) {
            return null;
        }
        if (point != null && point2 != null) {
            float min = Math.min(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2) * c);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                Point point3 = list.get(i);
                if (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3) <= min) {
                    return point3;
                }
            }
            return list.get(0);
        }
        return list.get(0);
    }

    public static Point findCloseToScreenPreviewSize(List<Point> list, Point point, Point point2) {
        if (point != null && list != null && list.size() != 0) {
            double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (xVar < 1.0d) {
                xVar = 1.0d / xVar;
            }
            double d = Double.POSITIVE_INFINITY;
            Point point3 = null;
            for (Point point4 : list) {
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point4);
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point4);
                int i = xVar2 * yVar;
                if (i >= a && i <= b && xVar2 <= MAX_PREVIEW_WIDTH && xVar2 >= yVar) {
                    double d2 = xVar2 / yVar;
                    if (d2 < 1.0d) {
                        d2 = 1.0d / d2;
                    }
                    double abs = Math.abs(d2 - xVar);
                    if (abs < d || Math.abs(abs - d) < 0.06d) {
                        point3 = new Point(xVar2, yVar);
                        d = abs;
                    }
                }
            }
            return point3 == null ? new Point(point2) : point3;
        }
        return new Point(point2);
    }

    public static Point findDowngradePreviewSize(List<Point> list, Point point) {
        if (point != null && list != null && list.size() != 0) {
            Point point2 = null;
            double xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) / com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            for (Point point3 : list) {
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point3);
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point3);
                int i = xVar2 * yVar;
                if (i >= a && i <= b && Math.abs((xVar2 / yVar) - xVar) < 0.06d) {
                    point2 = new Point(xVar2, yVar);
                }
            }
            return point2 == null ? new Point(point) : point2;
        }
        return new Point(point);
    }

    public static String focusDistanceCalibrationToString(int i) {
        return i != 1 ? i != 2 ? "UnCalibrated" : "Calibrated" : "Approximate";
    }

    public static String focusStateToString(int i) {
        switch (i) {
            case 0:
                return "INACTIVE";
            case 1:
                return "P-SCAN";
            case 2:
                return "P-FOCUSED";
            case 3:
                return "A-SCAN";
            case 4:
                return "FOCUSED";
            case 5:
                return "NOT-FOCUSED";
            case 6:
                return "P-UNFOCUSED";
            default:
                return "Unknown:" + i;
        }
    }

    public static String getCurrentTime() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
    }

    public static String hardwareLevelToString(int i) {
        if (i != 0) {
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        return "Unknown:" + i;
                    }
                    return "HARDWARE_LEVEL_3";
                }
                return "HARDWARE_LEVEL_LEGACY";
            }
            return "HARDWARE_LEVEL_FULL";
        }
        return "HARDWARE_LEVEL_LIMITED";
    }

    public static int normalizeFocusDistance(float f) {
        if (f <= 0.0f) {
            return 0;
        }
        int i = (int) f;
        int i2 = ((int) (10.0f * f)) - (i * 10);
        int i3 = i * 100;
        int i4 = i2 * 10;
        return i3 + i4 + ((((int) (f * 100.0f)) - i3) - i4 < 5 ? 5 : 10);
    }

    public static String rangeArrayToString(Range<Integer>[] rangeArr) {
        if (rangeArr == null || rangeArr.length == 0) {
            return "Null";
        }
        int length = rangeArr.length;
        StringBuilder sb = new StringBuilder();
        sb.append(jn1.BLOCK_START_STR);
        sb.append(rangeArr[0]);
        for (int i = 1; i < length; i++) {
            sb.append(",");
            sb.append(rangeArr[i]);
        }
        sb.append("}");
        return sb.toString();
    }

    public static void setPictureSizeTimes(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            c = Float.parseFloat(str);
        } catch (Throwable unused) {
        }
    }

    public static List<Point> sortedByDesc(Size[] sizeArr) {
        ArrayList arrayList = new ArrayList();
        if (sizeArr != null && sizeArr.length != 0) {
            for (int i = 0; i < sizeArr.length; i++) {
                arrayList.add(new Point(sizeArr[i].getWidth(), sizeArr[i].getHeight()));
            }
            Collections.sort(arrayList, new Comparator<Point>() { // from class: com.alipay.camera2.util.Camera2Utils.1
                @Override // java.util.Comparator
                public int compare(Point point, Point point2) {
                    int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                    int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2) * com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
                    if (xVar2 < xVar) {
                        return -1;
                    }
                    return xVar2 > xVar ? 1 : 0;
                }
            });
        }
        return arrayList;
    }

    public static boolean contains(boolean[] zArr, boolean z) {
        if (zArr == null) {
            return false;
        }
        for (boolean z2 : zArr) {
            if (z2 == z) {
                return true;
            }
        }
        return false;
    }
}
