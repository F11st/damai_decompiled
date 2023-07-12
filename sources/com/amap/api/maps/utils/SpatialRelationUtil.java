package com.amap.api.maps.utils;

import android.util.Pair;
import com.amap.api.mapcore.util.eq;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class SpatialRelationUtil {
    public static final int A_CIRCLE_DEGREE = 360;
    public static final int A_HALF_CIRCLE_DEGREE = 180;
    public static final int MIN_OFFSET_DEGREE = 50;
    public static final int MIN_POLYLINE_POINT_SIZE = 2;

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng, float f, double d) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude), f);
                    if (calShortestDistancePoint != null) {
                        DPoint dPoint = (DPoint) calShortestDistancePoint.second;
                        if (AMapUtils.calculateLineDistance(new LatLng(dPoint.x, dPoint.y), latLng) < d) {
                            Object obj = calShortestDistancePoint.first;
                            Object obj2 = calShortestDistancePoint.second;
                            return new Pair<>(obj, new LatLng(((DPoint) obj2).x, ((DPoint) obj2).y));
                        }
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    private static boolean checkRotateIsMatch(DPoint dPoint, DPoint dPoint2, float f) {
        if (f == -1.0f) {
            return true;
        }
        if (dPoint != null && dPoint2 != null) {
            float abs = Math.abs((eq.a(dPoint, dPoint2) + 360.0f) - f) % 360.0f;
            if (abs > 180.0f) {
                abs = 360.0f - abs;
            }
            if (abs < 50.0f) {
                return true;
            }
        }
        return false;
    }

    private static Pair<Double, DPoint> pointToSegDist(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return new Pair<>(Double.valueOf(Math.sqrt((d8 * d8) + (d10 * d10))), new DPoint(d3, d4));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return new Pair<>(Double.valueOf(Math.sqrt((d13 * d13) + (d14 * d14))), new DPoint(d5, d6));
        }
        double d15 = d11 / d12;
        double d16 = d3 + (d7 * d15);
        double d17 = d4 + (d9 * d15);
        double d18 = d - d16;
        double d19 = d17 - d2;
        return new Pair<>(Double.valueOf(Math.sqrt((d18 * d18) + (d19 * d19))), new DPoint(d16, d17));
    }

    public static Pair<Integer, LatLng> calShortestDistancePoint(List<LatLng> list, LatLng latLng) {
        if (list != null && latLng != null) {
            try {
                if (list.size() != 0) {
                    ArrayList arrayList = new ArrayList();
                    int i = 0;
                    for (LatLng latLng2 : list) {
                        arrayList.add(DPoint.obtain(latLng2.latitude, latLng2.longitude));
                        if (latLng2.equals(latLng)) {
                            return new Pair<>(Integer.valueOf(i), latLng);
                        }
                        i++;
                    }
                    Pair<Integer, DPoint> calShortestDistancePoint = calShortestDistancePoint(arrayList, DPoint.obtain(latLng.latitude, latLng.longitude));
                    if (calShortestDistancePoint != null) {
                        Object obj = calShortestDistancePoint.first;
                        Object obj2 = calShortestDistancePoint.second;
                        return new Pair<>(obj, new LatLng(((DPoint) obj2).x, ((DPoint) obj2).y));
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint) {
        return calShortestDistancePoint(list, dPoint, -1.0f);
    }

    public static Pair<Integer, DPoint> calShortestDistancePoint(List<DPoint> list, DPoint dPoint, float f) {
        int i;
        int i2;
        List<DPoint> list2 = list;
        DPoint dPoint2 = dPoint;
        Pair<Integer, DPoint> pair = null;
        if (list2 != null && dPoint2 != null && list.size() != 0) {
            if (list.size() >= 2) {
                DPoint dPoint3 = list2.get(0);
                double d = 0.0d;
                int size = list.size();
                int i3 = 1;
                int i4 = 1;
                while (true) {
                    int i5 = size - 1;
                    if (i4 > i5) {
                        break;
                    }
                    DPoint dPoint4 = list2.get(i4);
                    if (i4 == i5 && dPoint4.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i4), dPoint2);
                    }
                    if (!checkRotateIsMatch(dPoint3, dPoint4, f)) {
                        i2 = size;
                        i = i4;
                    } else if (dPoint3.equals(dPoint2)) {
                        return new Pair<>(Integer.valueOf(i4 - i3), dPoint2);
                    } else {
                        i = i4;
                        double d2 = d;
                        i2 = size;
                        Pair<Double, DPoint> pointToSegDist = pointToSegDist(dPoint2.x, dPoint2.y, dPoint3.x, dPoint3.y, dPoint4.x, dPoint4.y);
                        if (pair == null) {
                            d = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i - 1), pointToSegDist.second);
                        } else if (d2 > ((Double) pointToSegDist.first).doubleValue()) {
                            d = ((Double) pointToSegDist.first).doubleValue();
                            pair = new Pair<>(Integer.valueOf(i - 1), pointToSegDist.second);
                        } else {
                            d = d2;
                        }
                    }
                    i4 = i + 1;
                    list2 = list;
                    dPoint2 = dPoint;
                    dPoint3 = dPoint4;
                    size = i2;
                    i3 = 1;
                }
            } else {
                return null;
            }
        }
        return pair;
    }
}
