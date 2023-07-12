package com.alipay.camera2;

import android.text.TextUtils;
import com.youku.live.livesdk.wkit.component.Constants;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Camera2FocusAbnormalChecker {
    private static float l = 0.7f;
    private static float m = 0.9f;
    private static float n = 0.6f;
    private static float o = 0.7f;
    private long a;
    private long b;
    private long c;
    private float d;
    private float e;
    private float f;
    private boolean g = false;
    private long h = 0;
    private float i;
    private float j;
    private float k;

    public static void updateFocusAbnormalCheckParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split(Constants.TYPE_LIVE_ROOM_BG_COLOR_PREFFIX);
            if (split != null && split.length >= 4) {
                l = Float.valueOf(split[0]).floatValue();
                m = Float.valueOf(split[1]).floatValue();
                n = Float.valueOf(split[2]).floatValue();
                o = Float.valueOf(split[3]).floatValue();
            }
        } catch (Throwable unused) {
        }
    }

    public float getFirstStageBlurRatio() {
        return this.i;
    }

    public float getFirstStageLargestProportion() {
        return this.j;
    }

    public float getFirstStageLargestProportionDistance() {
        return this.k;
    }

    public long getTotalBlurDuration() {
        return this.a;
    }

    public float getTotalBlurRatio() {
        return this.d;
    }

    public float getTotalLargestProportion() {
        return this.e;
    }

    public float getTotalLargestProportionDistance() {
        return this.f;
    }

    public long getTotalScanDuratioin() {
        return this.b;
    }

    public String toString() {
        return "###mTotalBlurDuration=" + String.valueOf(this.a) + "###mNonNeedCheckBlurDuration=" + String.valueOf(this.c) + "###mTotalScanDuration=" + String.valueOf(this.b) + "###mTotalBlurRatio=" + String.valueOf(this.d) + "###mFocusAbnormal=" + String.valueOf(this.g) + "###checkFocusAbnormalDuration=" + String.valueOf(this.h) + "###mTotalLargestProportion=" + String.valueOf(this.e) + "###mTotalLargestProportionDistance=" + String.valueOf(this.f) + "###mFirstStageBlurRatio=" + String.valueOf(this.i) + "###mFirstStageLargestProportion=" + String.valueOf(this.j) + "###mFirstStageLargestProportionDistance=" + String.valueOf(this.k) + "###sFirstStageBlurRatioThreshold=" + String.valueOf(l) + "###sFirstStageProportionRatioThreshold=" + String.valueOf(m) + "###sTotalBlurRatioThreshold=" + String.valueOf(n) + "###sTotalProportionRatioThreshold=" + String.valueOf(o);
    }

    public boolean whetherFocusAbnormal(long j, long j2, long j3, float f, float f2) {
        if (j3 >= 1000 && j3 > 0 && f > 0.0f) {
            long j4 = j3 - j2;
            if (j4 <= 0) {
                return false;
            }
            float f3 = ((float) j) / ((float) j4);
            this.c = j2;
            this.a = j;
            this.b = j3;
            this.d = f3;
            this.e = f;
            this.f = f2;
            if (j3 < 2000) {
                this.i = f3;
                this.j = f;
                this.k = f2;
                if (f3 >= 0.0f && f3 <= 1.0f) {
                    if (f3 >= l && f >= m) {
                        r0 = true;
                    }
                    if (r0 && this.h <= 0) {
                        this.h = j3;
                        this.g = r0;
                    }
                    return r0;
                }
                r0 = f >= m;
                if (r0 && this.h <= 0) {
                    this.h = j3;
                    this.g = r0;
                }
                return r0;
            } else if (f3 >= 0.0f && f3 <= 1.0f) {
                if (f3 >= n && f >= o) {
                    r0 = true;
                }
                if (r0 && this.h <= 0) {
                    this.h = j3;
                    this.g = r0;
                }
                return r0;
            } else {
                r0 = f >= o;
                if (r0 && this.h <= 0) {
                    this.h = j3;
                    this.g = r0;
                }
            }
        }
        return r0;
    }
}
