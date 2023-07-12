package com.alipay.camera.base;

import com.alipay.camera.base.CameraStateTracer;
import com.alipay.camera.util.CameraLog;
import com.alipay.camera.util.WalletBehaviorBury;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class CameraPerformanceRecorder {
    private static String u;
    private static long v;
    private static long w;
    private static long x;
    private static long y;
    private static boolean z;
    private final boolean a;
    private final String b;
    private long e;
    private long f;
    private long h;
    private long i;
    private long k;
    private long l;
    private long m;
    private long o;
    private long p;
    private long r;
    private long s;
    private String t;
    private long c = 0;
    private long d = 0;
    private long g = 0;
    private long j = 0;
    private long n = 0;
    private long q = 0;

    public CameraPerformanceRecorder(boolean z2, String str) {
        this.b = str;
        this.a = z2;
    }

    private void a() {
        CameraLog.d("CameraPerfRecorder", this.b + ", buryPerformanceData:" + toString());
        WalletBehaviorBury.bury("recordCameraNativePerformance", new Class[]{String.class, String.class, String.class}, new Object[]{this.b, String.valueOf(this.a), toString()});
    }

    public static String getStaticBlockEvent() {
        CameraStateTracer.CameraEvent cameraEvent;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (y - x < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.GET_NUMBER_OF_CAMERAS;
            j = currentTimeMillis - x;
        } else {
            cameraEvent = null;
            j = 0;
        }
        if (w - v < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.GET_CAMERA_INFO;
            j = currentTimeMillis - v;
        }
        if (cameraEvent != null) {
            return "###blockCameraEvent=" + String.valueOf(cameraEvent) + "###blockDuration=" + String.valueOf(j);
        }
        return null;
    }

    public static void setBeginGetCameraInfo(long j) {
        v = j;
        w = 0L;
    }

    public static void setBeginGetNumberOfCameras(long j) {
        x = j;
        y = 0L;
    }

    public static void setEndGetCameraInfo(long j) {
        w = j;
    }

    public static void setEndGetNumberOfCameras(long j) {
        y = j;
    }

    public static void setPreviewUseSurfaceView(boolean z2) {
        z = z2;
    }

    public static void updateServiceInitInfo(String str) {
        u = str;
    }

    public float getCurrentAvgFps() {
        if (this.k <= 0) {
            return -1.0f;
        }
        long j = this.m;
        if (j <= 0) {
            j = System.currentTimeMillis();
        }
        long j2 = j - this.k;
        long j3 = this.r;
        if (j3 <= 0 || j2 <= 0) {
            return -1.0f;
        }
        return (1000.0f / ((float) j2)) * ((float) j3);
    }

    public String getDynamicBlockEvent() {
        CameraStateTracer.CameraEvent cameraEvent;
        long j;
        long currentTimeMillis = System.currentTimeMillis();
        if (this.g < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.OPEN;
            j = currentTimeMillis - this.e;
        } else {
            cameraEvent = null;
            j = 0;
        }
        if (this.j < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.START_PREVIEW;
            j = currentTimeMillis - this.h;
        }
        if (this.n < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.STOP_PREVIEW;
            j = currentTimeMillis - this.l;
        }
        if (this.q < 0) {
            cameraEvent = CameraStateTracer.CameraEvent.RELEASE;
            j = currentTimeMillis - this.o;
        }
        if (cameraEvent != null) {
            return "###blockCameraEvent=" + String.valueOf(cameraEvent) + "###blockDuration=" + String.valueOf(j);
        }
        return null;
    }

    public long getEndOpenCamera() {
        return this.f;
    }

    public void setBeginCloseCamera(long j) {
        this.o = j;
        this.q = -1L;
        this.p = 0L;
    }

    public void setBeginOpenCamera(long j) {
        this.e = j;
        this.g = -1L;
        this.f = 0L;
        long j2 = v;
        if (j2 > 0) {
            long j3 = w;
            if (j3 >= j2) {
                this.c = j3 - j2;
                w = 0L;
                v = 0L;
            }
        }
        long j4 = x;
        if (j4 > 0) {
            long j5 = y;
            if (j5 >= j4) {
                this.d = j5 - j4;
                y = 0L;
                x = 0L;
            }
        }
    }

    public void setBeginStartPreview(long j) {
        this.h = j;
        this.j = -1L;
        this.i = 0L;
    }

    public void setBeginStopPreview(long j) {
        this.l = j;
        this.n = -1L;
        this.m = 0L;
    }

    public void setEndCloseCamera(long j) {
        this.p = j;
        if (this.k <= 0) {
            this.k = j;
        }
        this.q = j - this.o;
    }

    public void setEndFirstPreviewFrame(long j) {
        if (this.h <= 0 || this.i <= 0) {
            long j2 = this.f;
            this.h = j2;
            this.i = j2;
        }
        this.k = j;
    }

    public void setEndOpenCamera(long j) {
        this.f = j;
        this.g = j - this.e;
    }

    public void setEndStartPreview(long j) {
        this.i = j;
        this.j = j - this.h;
    }

    public void setEndStopPreview(long j) {
        this.m = j;
        this.n = j - this.l;
    }

    public void setFirstTriggerFrameCount(int i) {
        this.s = i;
    }

    public void setFocusTriggerRecord(String str) {
        this.t = str;
    }

    public void setFrameCountAndBuryPerfData(long j) {
        this.r = j;
        a();
    }

    public String toString() {
        return String.valueOf(u) + "###isCamera2=" + this.a + "###beginOpenCamera=" + String.valueOf(this.e) + "###endOpenCamera=" + String.valueOf(this.f) + "###beginStartPreview=" + String.valueOf(this.h) + "###endStartPreview=" + String.valueOf(this.i) + "###getCameraInfoDuration=" + String.valueOf(this.c) + "###getNumberOfDuration=" + String.valueOf(this.d) + "###OpenDuration=" + String.valueOf(this.g) + "###OpenedToStartPreview=" + String.valueOf(this.h - this.f) + "###startPreviewDuration=" + String.valueOf(this.j) + "###startedPreviewToFirstFrame=" + String.valueOf(this.k - this.i) + "###previewDuration=" + String.valueOf(this.m - this.k) + "###avgFps=" + String.valueOf(getCurrentAvgFps()) + "###stopPreviewDuration=" + String.valueOf(this.n) + "###closeCameraDuration=" + String.valueOf(this.q) + "###firstFocusTriggerFrameCount=" + String.valueOf(this.s) + "###frameCount=" + String.valueOf(this.r) + "###previewUseSurfaceView=" + String.valueOf(z) + "###focusTriggerRecord=" + String.valueOf(this.t);
    }
}
