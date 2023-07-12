package com.alipay.camera;

import com.alipay.camera.base.AntCamera;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraFocusStateMonitor {
    private static float h = 0.7f;
    private static float i = 0.6f;
    private long b;
    private long c;
    private float d;
    private float e;
    private boolean g;
    private long a = 0;
    private long f = 0;

    public String getString() {
        return "###mTotalBlurDuration=" + String.valueOf(this.b) + "###mTotalScanDuration=" + String.valueOf(this.c) + "###mTotalBlurRatio=" + String.valueOf(this.d) + "###checkFocusAbnormalDuration=" + String.valueOf(this.f) + "###mFocusAbnormal=" + String.valueOf(this.g) + "###mFirstStageBlurRatio=" + String.valueOf(this.e) + "###sFirstStageBlurRatioThreshold=" + String.valueOf(h) + "###sTotalBlurRatioThreshold=" + String.valueOf(i);
    }

    public boolean whetherFocusAbnormal(AntCamera antCamera, long j, long j2) {
        if (antCamera == null) {
            return false;
        }
        if (this.a <= 0) {
            this.a = System.currentTimeMillis();
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis() - this.a;
        if (currentTimeMillis >= 1000 && currentTimeMillis > 0) {
            long j3 = currentTimeMillis - j2;
            if (j3 <= 0) {
                return false;
            }
            float f = ((float) j) / ((float) j3);
            this.b = j;
            this.c = currentTimeMillis;
            this.d = f;
            if (currentTimeMillis < 2000) {
                this.e = f;
                r0 = f >= h;
                if (r0 && this.f <= 0) {
                    this.f = currentTimeMillis;
                    this.g = r0;
                }
                return r0;
            }
            r0 = f >= i;
            if (r0 && this.f <= 0) {
                this.f = currentTimeMillis;
                this.g = r0;
            }
        }
        return r0;
    }
}
