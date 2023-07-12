package com.alibaba.security.realidentity.b;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import com.alipay.mobile.bqcscanservice.BQCCameraParam;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b {
    private static final String b = "b";
    private static final int c = 240;
    private static final int d = 240;
    private static final int e = 1200;
    private static final int f = 675;
    public Camera a;
    private final Context g;
    private final a h;
    private Rect i;
    private Rect j;
    private boolean k;
    private boolean l;
    private int n;
    private int o;
    private int m = -1;
    private long p = 0;
    private long q = 2000;

    public b(Context context) {
        this.g = context;
        this.h = new a(context);
    }

    public static int d() {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras < 0) {
            return -1;
        }
        for (int i = 0; i < numberOfCameras; i++) {
            Camera.getCameraInfo(i, cameraInfo);
            if (cameraInfo.facing == 0) {
                return i;
            }
        }
        return -1;
    }

    private synchronized boolean e() {
        return this.a != null;
    }

    private synchronized Rect f() {
        if (this.i == null) {
            if (this.a == null) {
                return null;
            }
            Point point = this.h.b;
            if (point == null) {
                return null;
            }
            int a = a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), 1200);
            int a2 = a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point), (int) f);
            int xVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point) - a) / 2;
            int yVar = (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point) - a2) / 2;
            this.i = new Rect(xVar, yVar, a + xVar, a2 + yVar);
        }
        return this.i;
    }

    private synchronized Rect g() {
        if (this.j == null) {
            Rect f2 = f();
            if (f2 == null) {
                return null;
            }
            Rect rect = new Rect(f2);
            a aVar = this.h;
            Point point = aVar.c;
            Point point2 = aVar.b;
            if (point != null && point2 != null) {
                int i = rect.left;
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
                int xVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                rect.left = (i * xVar) / xVar2;
                rect.right = (rect.right * xVar) / xVar2;
                int i2 = rect.top;
                int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
                int yVar2 = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2);
                rect.top = (i2 * yVar) / yVar2;
                rect.bottom = (rect.bottom * yVar) / yVar2;
                this.j = rect;
            }
            return null;
        }
        return this.j;
    }

    private int h() {
        return this.a.getParameters().getZoom();
    }

    private int i() {
        return this.a.getParameters().getMaxZoom();
    }

    private Camera j() {
        return this.a;
    }

    private void k() {
        this.a.cancelAutoFocus();
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x00b1 A[Catch: all -> 0x00f7, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0005, B:7:0x000d, B:8:0x0010, B:9:0x0015, B:10:0x0016, B:12:0x001f, B:14:0x0040, B:15:0x0043, B:17:0x005b, B:30:0x009a, B:31:0x00a1, B:33:0x00b1, B:34:0x00b8, B:36:0x00bc, B:38:0x00c0, B:19:0x0063, B:21:0x006b, B:24:0x0074, B:26:0x007c, B:27:0x0086, B:29:0x008e, B:39:0x00c7, B:43:0x00d3, B:48:0x00dd, B:49:0x00e4, B:52:0x00ee, B:42:0x00cf), top: B:58:0x0001, inners: #1, #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void a(android.view.SurfaceHolder r11) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 250
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.alibaba.security.realidentity.b.b.a(android.view.SurfaceHolder):void");
    }

    public final synchronized void b() {
        long currentTimeMillis = System.currentTimeMillis();
        Camera camera = this.a;
        if (camera != null && !this.l) {
            camera.startPreview();
            String str = b;
            com.alibaba.security.common.c.a.b(str, "SQY: startPreview.theCamera.startPreview Costs" + (System.currentTimeMillis() - currentTimeMillis));
            this.l = true;
            com.alibaba.security.common.c.a.b(str, "SQY: startPreview new AutoFocusManager Costs" + (System.currentTimeMillis() - currentTimeMillis));
        }
    }

    public final synchronized void c() {
        Camera camera = this.a;
        if (camera != null && this.l) {
            camera.stopPreview();
            this.l = false;
        }
    }

    private synchronized void b(int i, int i2) {
        if (this.k) {
            Point point = this.h.b;
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
            if (i > xVar) {
                i = xVar;
            }
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
            if (i2 > yVar) {
                i2 = yVar;
            }
            int i3 = (xVar - i) / 2;
            int i4 = (yVar - i2) / 2;
            this.i = new Rect(i3, i4, i + i3, i2 + i4);
            this.j = null;
            return;
        }
        this.n = i;
        this.o = i2;
    }

    private void b(int i) {
        Camera.Parameters parameters = this.a.getParameters();
        parameters.setZoom(i);
        this.a.setParameters(parameters);
    }

    private void b(long j) {
        this.q = j;
    }

    public final synchronized void a() {
        try {
            Camera camera = this.a;
            if (camera != null) {
                camera.release();
                this.a = null;
                this.i = null;
                this.j = null;
            }
        } catch (Throwable unused) {
        }
    }

    private synchronized void a(boolean z) {
        Camera camera;
        try {
            if (z != a.a(this.a) && (camera = this.a) != null) {
                a aVar = this.h;
                Camera.Parameters parameters = camera.getParameters();
                aVar.a(parameters, z, false);
                camera.setParameters(parameters);
            }
        } catch (Exception unused) {
        }
    }

    private synchronized void a(Camera.PreviewCallback previewCallback) {
        Camera camera = this.a;
        if (camera != null && this.l) {
            camera.setPreviewCallback(previewCallback);
        }
    }

    private static int a(int i, int i2) {
        int i3 = (i * 5) / 8;
        return i3 < 240 ? GlMapUtil.DEVICE_DISPLAY_DPI_MEDIAN : i3 > i2 ? i2 : i3;
    }

    public final synchronized void a(int i) {
        this.m = i;
    }

    private void a(long j) {
        this.p = j;
    }

    private void a(Map<String, Integer> map) {
        this.h.f = map;
    }

    private void a(Camera.ShutterCallback shutterCallback, Camera.PictureCallback pictureCallback) {
        Camera camera = this.a;
        if (camera != null) {
            camera.takePicture(shutterCallback, null, pictureCallback);
        }
    }

    public final void a(Camera.AutoFocusCallback autoFocusCallback) {
        Camera camera = this.a;
        if (camera == null) {
            return;
        }
        String focusMode = camera.getParameters().getFocusMode();
        if (focusMode.equals("auto") || focusMode.equals(BQCCameraParam.FOCUS_TYPE_MACRO)) {
            this.a.autoFocus(autoFocusCallback);
        }
    }
}
