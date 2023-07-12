package com.alipay.ma.statistics.classification;

import android.text.TextUtils;
import com.alipay.ma.MaLogger;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class BlurSVM {
    public static final String KEY_BLUR_SVM_PARAMS = "key_blur_svm_params";
    public static final String KEY_ENABLE_BLUR_SVM = "key_enable_blur_svm";
    public static final String TAG = "BlurSVM";
    private static float i = 2.0f;
    private static float j = 0.3f;
    private static float k = 0.1f;
    private static boolean l = true;
    private static float m = 5.426211f;
    private static float n = 3.4279332f;
    private static float o = 7.310401f;
    private static float p = 6.2331066f;
    private static float q = 1.6728085f;
    private static float r = -5.1614676f;
    private static float s = 8.0f;
    private static float t;
    private float a = 0.0f;
    private float b = 0.0f;
    private float c = 0.0f;
    private long d = 0;
    private float e = 0.0f;
    private long f = 0;
    private boolean g = false;
    private int h = 0;

    private void a(float f) {
        float f2 = this.e;
        long j2 = this.d;
        this.e = ((f2 * ((float) j2)) + f) / ((float) (j2 + 1));
        this.d = j2 + 1;
    }

    public static boolean getEnableBlur() {
        return l;
    }

    public static void setBlurParams(String str) {
        if (!TextUtils.isEmpty(str) && str.indexOf(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX) >= 0) {
            try {
                String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
                if (split != null && split.length >= 9) {
                    m = Float.valueOf(split[0]).floatValue();
                    n = Float.valueOf(split[1]).floatValue();
                    o = Float.valueOf(split[2]).floatValue();
                    p = Float.valueOf(split[3]).floatValue();
                    q = Float.valueOf(split[4]).floatValue();
                    r = Float.valueOf(split[5]).floatValue();
                    s = Float.valueOf(split[6]).floatValue();
                    t = Float.valueOf(split[7]).floatValue();
                    j = Float.valueOf(split[8]).floatValue();
                    StringBuilder sb = new StringBuilder(256);
                    sb.append("setBlurParams: sNormalMean_1=");
                    sb.append(m);
                    sb.append(",sNormalStd_1:");
                    sb.append(n);
                    sb.append(",sNormalMean_2:");
                    sb.append(o);
                    sb.append(",sNormalStd_2:");
                    sb.append(p);
                    sb.append(",sCoef1:");
                    sb.append(q);
                    sb.append(",sCoef2:");
                    sb.append(r);
                    sb.append(",sClearThresholdStd:");
                    sb.append(s);
                    sb.append(",sMargin:");
                    sb.append(t);
                    sb.append(",sSingleColorThresholdMaxGray:");
                    sb.append(j);
                    MaLogger.d(TAG, sb.toString());
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void setEnableBlur(boolean z) {
        StringBuilder sb = new StringBuilder(32);
        sb.append("setEnableBlur: ");
        sb.append(z);
        MaLogger.d(TAG, sb.toString());
        l = z;
    }

    public boolean checkBlur(float f, float f2, float f3, float f4, long j2) {
        MaLogger.d(TAG, "checkBlur: laplaceMean:" + f + ", laplaceStd:" + f2 + ", laplaceDuration:" + f3 + ", maxGrayRatio:" + f4 + ", mNoNeedCheckBlurDuration:" + this.f);
        if (f > 0.0f && f2 > 0.0f && f3 > 0.0f) {
            if (this.a == 0.0f) {
                this.a = f;
            }
            if (this.b == 0.0f) {
                this.b = f2;
            }
            if (Math.abs(this.a - f) <= 1.0E-5f && Math.abs(this.b - f2) <= 1.0E-5f) {
                int i2 = this.h + 1;
                this.h = i2;
                if (i2 > 1) {
                    this.f += j2;
                    this.g = true;
                    MaLogger.d(TAG, "checkBlur: false return. with same laplace mean & std.");
                } else {
                    MaLogger.d(TAG, "checkBlur: false return. first no care.");
                }
                return false;
            } else if (f2 > s) {
                this.c = Math.abs(this.a - f) / this.a;
                this.a = f;
                this.b = f2;
                MaLogger.d(TAG, "checkBlur: false return. > sClearThresholdStd:" + s);
                return false;
            } else {
                a(f3);
                float abs = Math.abs(this.a - f) / this.a;
                this.a = f;
                this.b = f2;
                MaLogger.d(TAG, "checkBlur: laplaceMeanDiffRatio:" + abs + ", lastLaplaceMeanDiffRatio:" + this.c);
                if (f >= i && f4 < j) {
                    float f5 = k;
                    boolean z = abs > f5 || this.c > f5;
                    this.c = abs;
                    if (z) {
                        this.f += j2;
                        MaLogger.d(TAG, "checkBlur: false return. isMoving");
                        return false;
                    }
                    float f6 = (((f - m) / n) * q) + (((f2 - o) / p) * r) + t;
                    StringBuilder sb = new StringBuilder();
                    sb.append("checkBlur: result:");
                    int i3 = (f6 > 0.0f ? 1 : (f6 == 0.0f ? 0 : -1));
                    sb.append(i3 > 0);
                    MaLogger.d(TAG, sb.toString());
                    return i3 > 0;
                }
                this.c = abs;
                this.f += j2;
                MaLogger.d(TAG, "checkBlur: singleColor return. laplaceMean:" + f + ", maxGrayRatio:" + f4);
            }
        }
        return false;
    }

    public float getAvgLaplaceDetectDuration() {
        return this.e;
    }

    public long getBlurCheckFrameCount() {
        return this.d;
    }

    public long getNoNeedCheckBlurDuration() {
        return this.f;
    }

    public int getTheSameLaplaceValueCount() {
        return this.h;
    }

    public boolean isWhetherGetTheSameLaplaceValue() {
        return this.g;
    }
}
