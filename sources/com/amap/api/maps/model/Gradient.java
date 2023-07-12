package com.amap.api.maps.model;

import android.graphics.Color;
import android.util.Log;
import com.amap.api.maps.AMapException;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Gradient {
    private static final int DEFAULT_COLOR_MAP_SIZE = 1000;
    private boolean isAvailable;
    private int mColorMapSize;
    private int[] mColors;
    private float[] mStartPoints;

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.maps.model.Gradient$a */
    /* loaded from: classes10.dex */
    public static class C4650a {
        private final int a;
        private final int b;
        private final float c;

        private C4650a(int i, int i2, float f) {
            this.a = i;
            this.b = i2;
            this.c = f;
        }
    }

    public Gradient(int[] iArr, float[] fArr) {
        this(iArr, fArr, 1000);
    }

    private HashMap<Integer, C4650a> a() {
        HashMap<Integer, C4650a> hashMap = new HashMap<>(32);
        if (this.mStartPoints[0] != 0.0f) {
            hashMap.put(0, new C4650a(Color.argb(0, Color.red(this.mColors[0]), Color.green(this.mColors[0]), Color.blue(this.mColors[0])), this.mColors[0], this.mColorMapSize * this.mStartPoints[0]));
        }
        for (int i = 1; i < this.mColors.length; i++) {
            int i2 = i - 1;
            Integer valueOf = Integer.valueOf((int) (this.mColorMapSize * this.mStartPoints[i2]));
            int[] iArr = this.mColors;
            int i3 = iArr[i2];
            int i4 = iArr[i];
            float[] fArr = this.mStartPoints;
            hashMap.put(valueOf, new C4650a(i3, i4, this.mColorMapSize * (fArr[i] - fArr[i2])));
        }
        float[] fArr2 = this.mStartPoints;
        if (fArr2[fArr2.length - 1] != 1.0f) {
            int length = fArr2.length - 1;
            Integer valueOf2 = Integer.valueOf((int) (this.mColorMapSize * fArr2[length]));
            int[] iArr2 = this.mColors;
            hashMap.put(valueOf2, new C4650a(iArr2[length], iArr2[length], this.mColorMapSize * (1.0f - this.mStartPoints[length])));
        }
        return hashMap;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int[] generateColorMap(double d) {
        HashMap<Integer, C4650a> a = a();
        int[] iArr = new int[this.mColorMapSize];
        C4650a c4650a = a.get(0);
        int i = 0;
        for (int i2 = 0; i2 < this.mColorMapSize; i2++) {
            if (a.containsKey(Integer.valueOf(i2))) {
                c4650a = a.get(Integer.valueOf(i2));
                i = i2;
            }
            iArr[i2] = a(c4650a.a, c4650a.b, (i2 - i) / c4650a.c);
        }
        if (d != 1.0d) {
            for (int i3 = 0; i3 < this.mColorMapSize; i3++) {
                int i4 = iArr[i3];
                iArr[i3] = Color.argb((int) (Color.alpha(i4) * d), Color.red(i4), Color.green(i4), Color.blue(i4));
            }
        }
        return iArr;
    }

    public int[] getColors() {
        return this.mColors;
    }

    public float[] getStartPoints() {
        return this.mStartPoints;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean isAvailable() {
        return this.isAvailable;
    }

    private Gradient(int[] iArr, float[] fArr, int i) {
        this.isAvailable = true;
        try {
            if (iArr != null && fArr != null) {
                if (iArr.length == fArr.length) {
                    if (iArr.length != 0) {
                        for (int i2 = 1; i2 < fArr.length; i2++) {
                            if (fArr[i2] < fArr[i2 - 1]) {
                                throw new AMapException("startPoints should be in increasing order");
                            }
                        }
                        this.mColorMapSize = i;
                        int[] iArr2 = new int[iArr.length];
                        this.mColors = iArr2;
                        this.mStartPoints = new float[fArr.length];
                        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
                        System.arraycopy(fArr, 0, this.mStartPoints, 0, fArr.length);
                        this.isAvailable = true;
                        return;
                    }
                    throw new AMapException("No colors have been defined");
                }
                throw new AMapException("colors and startPoints should be same length");
            }
            throw new AMapException("colors and startPoints should not be null");
        } catch (AMapException e) {
            this.isAvailable = false;
            Log.e("amap", e.getErrorMessage());
            e.printStackTrace();
        }
    }

    static int a(int i, int i2, float f) {
        int alpha = (int) (((Color.alpha(i2) - Color.alpha(i)) * f) + Color.alpha(i));
        float[] fArr = new float[3];
        Color.RGBToHSV(Color.red(i), Color.green(i), Color.blue(i), fArr);
        float[] fArr2 = new float[3];
        Color.RGBToHSV(Color.red(i2), Color.green(i2), Color.blue(i2), fArr2);
        float f2 = 180;
        if (fArr[0] - fArr2[0] > f2) {
            fArr2[0] = fArr2[0] + 360;
        } else if (fArr2[0] - fArr[0] > f2) {
            fArr[0] = fArr[0] + 360;
        }
        float[] fArr3 = new float[3];
        for (int i3 = 0; i3 < 3; i3++) {
            fArr3[i3] = ((fArr2[i3] - fArr[i3]) * f) + fArr[i3];
        }
        return Color.HSVToColor(alpha, fArr3);
    }
}
