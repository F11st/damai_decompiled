package com.alipay.camera.base;

import com.alipay.camera.util.CameraLog;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraFocusPerformanceHelper {
    private long a = 0;
    private long b = 0;
    private float c = 0.0f;
    private float d = 0.0f;
    private float e = 0.0f;
    private float f = 0.0f;
    private int g;

    public String getString() {
        try {
            return "###CameraFocusPerf###focusTriggerCount=" + String.valueOf(this.g) + "###firstFocusDuration=" + String.valueOf(this.c) + "###firstFocusCount=" + String.valueOf(this.d) + "###avgFocusDuration=" + String.valueOf(this.e) + "###avgFocusCount=" + String.valueOf(this.f);
        } catch (Exception e) {
            CameraLog.e("CameraFocusPerformanceHelper", "toString with error" + e.toString());
            return "NULL";
        }
    }

    public void offerCamera1FocusState(boolean z, long j) {
        if (!z && this.a > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            long j2 = j - this.b;
            CameraLog.d("CameraFocusPerformanceHelper", "offerCamera1FocusState, consume:" + currentTimeMillis + ", frameCount:" + j2);
            if (this.c == 0.0f || this.d == 0.0f) {
                this.c = (float) currentTimeMillis;
                this.d = (float) j2;
            }
            float f = this.e;
            int i = this.g;
            this.e = ((f * i) + ((float) currentTimeMillis)) / (i + 1);
            this.f = ((this.f * i) + ((float) j2)) / (i + 1);
            this.g = i + 1;
            this.a = 0L;
            this.b = 0L;
        } else if (z && this.a == 0) {
            this.a = System.currentTimeMillis();
            this.b = j;
        }
    }

    public void offerCamera2FocusState(int i, long j) {
        if (i != 4 && i != 2) {
            if (this.a == 0) {
                this.a = System.currentTimeMillis();
                this.b = j;
            }
        } else if (this.a > 0) {
            long currentTimeMillis = System.currentTimeMillis() - this.a;
            long j2 = j - this.b;
            CameraLog.d("CameraFocusPerformanceHelper", "offerCamera2FocusState, consume:" + currentTimeMillis + ", frameCount:" + j2);
            if (this.c == 0.0f || this.d == 0.0f) {
                this.c = (float) currentTimeMillis;
                this.d = (float) j2;
            }
            float f = this.e;
            int i2 = this.g;
            this.e = ((f * i2) + ((float) currentTimeMillis)) / (i2 + 1);
            this.f = ((this.f * i2) + ((float) j2)) / (i2 + 1);
            this.g = i2 + 1;
            this.a = 0L;
            this.b = 0L;
        }
    }
}
