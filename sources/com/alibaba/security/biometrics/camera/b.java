package com.alibaba.security.biometrics.camera;

import android.content.Context;
import android.graphics.Point;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.os.Build;
import android.util.Pair;
import android.view.WindowManager;
import com.alibaba.security.biometrics.service.constants.GlobalErrorCode;
import com.alibaba.security.biometrics.service.model.params.ALBiometricsParams;
import com.alibaba.security.biometrics.service.video.VideoRecorderService;
import com.alibaba.security.common.d.h;
import com.youku.live.dago.liveplayback.widget.plugins.resize.AntiShakeOrientationEventListener;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public final class b extends a {
    private Throwable A;
    private Throwable B;
    VideoRecorderService n;
    boolean o;
    private Camera p;
    private final int q;
    private int r;
    private Camera.CameraInfo s;
    private List<Camera.Size> t;
    private List<int[]> u;
    private int[] v;
    private Camera.Parameters w;
    private boolean x;
    private Throwable y;
    private boolean z;

    public b(Context context, ALBiometricsParams aLBiometricsParams) {
        super(context, aLBiometricsParams);
        this.q = 30;
    }

    private void o() {
        this.z = false;
        this.x = false;
        this.B = null;
        this.A = null;
        this.y = null;
    }

    private static Pair<Camera.CameraInfo, Integer> p() {
        if (Build.VERSION.SDK_INT > 8) {
            return a(1);
        }
        return null;
    }

    private static Pair<Camera.CameraInfo, Integer> q() {
        if (Build.VERSION.SDK_INT > 8) {
            return a(0);
        }
        return null;
    }

    @Override // com.alibaba.security.biometrics.camera.a
    protected final void c() {
        this.o = false;
    }

    @Override // com.alibaba.security.biometrics.camera.a, com.alibaba.security.biometrics.camera.c
    public final boolean j() {
        if (this.p != null && this.x) {
            return this.o;
        }
        return false;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final boolean k() {
        return this.p != null;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final void l() {
        if (this.o) {
            return;
        }
        if (this.n == null) {
            this.n = new VideoRecorderService(this.f);
        }
        VideoRecorderService videoRecorderService = this.n;
        Point point = this.e;
        int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point);
        int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point);
        int i = this.r;
        int i2 = this.j;
        ALBiometricsParams aLBiometricsParams = this.l;
        videoRecorderService.init(xVar, yVar, i, i2, aLBiometricsParams == null ? null : aLBiometricsParams.mVerifyToken);
        this.o = true;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final String m() {
        HashMap hashMap = new HashMap();
        hashMap.put("displayRate", Integer.valueOf(this.i));
        hashMap.put("frameRate", Integer.valueOf(this.r));
        hashMap.put("cameraRotate", Integer.valueOf(this.j));
        hashMap.put("cameraInfo", h.a(this.s));
        hashMap.put("previewSize", h.a(this.e));
        hashMap.put("supportPreviewSize", h.a(this.t));
        hashMap.put("supportPreviewFpsRange", h.a(this.u));
        hashMap.put("currentPreviewFpsRange", h.a(this.v));
        hashMap.put("cameraParameters", h.a(this.w));
        hashMap.put("startCameraTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("isCameraOpen", Boolean.valueOf(this.x));
        hashMap.put("openException", com.alibaba.security.common.d.b.a(this.y));
        return h.a((Object) hashMap);
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final String n() {
        HashMap hashMap = new HashMap();
        hashMap.put("previewNumber", Integer.valueOf(this.m));
        hashMap.put("finishCameraTime", Long.valueOf(System.currentTimeMillis()));
        hashMap.put("isCameraClose", Boolean.valueOf(this.z));
        hashMap.put("closeException", com.alibaba.security.common.d.b.a(this.A));
        hashMap.put("previewException", com.alibaba.security.common.d.b.a(this.B));
        return h.a((Object) hashMap);
    }

    private static boolean a(Camera camera) {
        try {
            Field declaredField = camera.getClass().getDeclaredField("mHasPermission");
            declaredField.setAccessible(true);
            return ((Boolean) declaredField.get(camera)).booleanValue();
        } catch (Exception unused) {
            return true;
        }
    }

    private int c(Camera.Parameters parameters) {
        this.u = parameters.getSupportedPreviewFpsRange();
        int[] iArr = new int[2];
        this.v = iArr;
        parameters.getPreviewFpsRange(iArr);
        for (int[] iArr2 : this.u) {
            if (iArr2[0] == iArr2[1] && iArr2[0] == 30000) {
                parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                return iArr2[0];
            }
        }
        int[] iArr3 = this.v;
        if (iArr3[0] == iArr3[1]) {
            return iArr3[0];
        }
        return iArr3[1] / 2;
    }

    @Override // com.alibaba.security.biometrics.camera.a
    protected final void b() {
        Camera camera = this.p;
        if (camera == null) {
            return;
        }
        try {
            camera.stopPreview();
            this.p.setOneShotPreviewCallback(null);
            this.p.setPreviewCallback(null);
            this.p.release();
            a((com.alibaba.security.common.e.b) null, false);
            this.z = true;
        } catch (Throwable th) {
            try {
                this.z = false;
                this.A = th;
            } finally {
                this.p = null;
            }
        }
    }

    @Override // com.alibaba.security.biometrics.camera.a
    protected final void a() {
        int i;
        int i2;
        List<String> supportedFocusModes;
        if (k()) {
            e();
            return;
        }
        this.z = false;
        this.x = false;
        Point point = null;
        this.B = null;
        this.A = null;
        this.y = null;
        try {
            Pair<Camera.CameraInfo, Integer> a = Build.VERSION.SDK_INT > 8 ? a(1) : null;
            int intValue = a == null ? -1 : ((Integer) a.second).intValue();
            if (intValue == -1) {
                a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "find camera id fail");
                return;
            }
            try {
                Camera open = Camera.open(intValue);
                this.p = open;
                if (open == null) {
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail by camera is null");
                    return;
                }
                Camera.Parameters parameters = open.getParameters();
                this.w = parameters;
                if (parameters == null) {
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "start preview fail by camera parameters get fail");
                    return;
                }
                try {
                    this.p.getParameters();
                    if (!a(this.p)) {
                        a(GlobalErrorCode.ERROR_DEVICE_CAMERA_NO_PERMISSION, "camera open fail by no permission");
                        return;
                    }
                    try {
                        this.w.setPictureFormat(256);
                        this.w.setPreviewFormat(17);
                        Camera.Parameters parameters2 = this.w;
                        this.u = parameters2.getSupportedPreviewFpsRange();
                        int[] iArr = new int[2];
                        this.v = iArr;
                        parameters2.getPreviewFpsRange(iArr);
                        Iterator<int[]> it = this.u.iterator();
                        while (true) {
                            if (it.hasNext()) {
                                int[] next = it.next();
                                if (next[0] == next[1] && next[0] == 30000) {
                                    parameters2.setPreviewFpsRange(next[0], next[1]);
                                    i = next[0];
                                    break;
                                }
                            } else {
                                int[] iArr2 = this.v;
                                if (iArr2[0] == iArr2[1]) {
                                    i = iArr2[0];
                                } else {
                                    i = iArr2[1] / 2;
                                }
                            }
                        }
                        this.r = i / 1000;
                        this.w.setRecordingHint(true);
                        Camera.Parameters parameters3 = this.w;
                        List<Point> b = b(parameters3.getSupportedPictureSizes());
                        if (b != null) {
                            Collections.sort(b, this.g);
                            int i3 = 0;
                            for (Point point2 : b) {
                                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                                if (xVar >= 600) {
                                    if (((double) Math.abs((((float) xVar) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2))) - 0.0f)) <= 0.05d) {
                                        break;
                                    }
                                }
                                i3++;
                            }
                            if (i3 == b.size()) {
                                i3 = 0;
                            }
                            point = b.get(i3);
                        }
                        this.d = point;
                        parameters3.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
                        Camera.Parameters parameters4 = this.w;
                        List<Camera.Size> supportedPreviewSizes = parameters4.getSupportedPreviewSizes();
                        this.t = supportedPreviewSizes;
                        Point a2 = a(b(supportedPreviewSizes));
                        this.e = a2;
                        parameters4.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(a2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(a2));
                        Context context = this.f;
                        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                        Camera.getCameraInfo(intValue, cameraInfo);
                        int rotation = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
                        if (rotation != 0) {
                            if (rotation == 1) {
                                i2 = 90;
                            } else if (rotation == 2) {
                                i2 = 180;
                            } else if (rotation == 3) {
                                i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
                            }
                            int i4 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                            this.i = i4;
                            this.p.setDisplayOrientation(i4);
                            supportedFocusModes = this.w.getSupportedFocusModes();
                            if (supportedFocusModes != null && supportedFocusModes.contains("continuous-video")) {
                                this.w.setFocusMode("continuous-video");
                            }
                            this.s = (Camera.CameraInfo) a.first;
                            this.p.setParameters(this.w);
                            this.j = this.s.orientation;
                            e();
                            this.o = false;
                            this.x = true;
                        }
                        i2 = 0;
                        int i42 = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
                        this.i = i42;
                        this.p.setDisplayOrientation(i42);
                        supportedFocusModes = this.w.getSupportedFocusModes();
                        if (supportedFocusModes != null) {
                            this.w.setFocusMode("continuous-video");
                        }
                        this.s = (Camera.CameraInfo) a.first;
                        this.p.setParameters(this.w);
                        this.j = this.s.orientation;
                        e();
                        this.o = false;
                        this.x = true;
                    } catch (Throwable th) {
                        this.y = th;
                        this.x = false;
                        d();
                        a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "start preview fail: " + com.alibaba.security.common.d.b.a(th));
                    }
                } catch (Throwable th2) {
                    this.y = th2;
                    this.x = false;
                    a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail by parameters fail");
                }
            } catch (Throwable th3) {
                this.y = th3;
                this.x = false;
                a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "camera open fail");
            }
        } catch (Exception unused) {
            a(GlobalErrorCode.ERROR_DEVICE_CAMERA_INIT, "find facing camera info fail");
        }
    }

    private void b(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        this.t = supportedPreviewSizes;
        Point a = a(b(supportedPreviewSizes));
        this.e = a;
        parameters.setPreviewSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(a), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(a));
    }

    private static List<Point> b(List<Camera.Size> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Camera.Size size : list) {
            Point point = new Point();
            point.x = size.width;
            point.y = size.height;
            arrayList.add(point);
        }
        return arrayList;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final void a(SurfaceTexture surfaceTexture) {
        if (this.p == null || this.k) {
            return;
        }
        try {
            final int i = this.s.orientation;
            this.p.setPreviewTexture(surfaceTexture);
            this.p.setPreviewCallback(new Camera.PreviewCallback() { // from class: com.alibaba.security.biometrics.camera.b.1
                @Override // android.hardware.Camera.PreviewCallback
                public final void onPreviewFrame(byte[] bArr, Camera camera) {
                    VideoRecorderService videoRecorderService;
                    b.this.a(bArr, i);
                    b bVar = b.this;
                    if (!bVar.o || (videoRecorderService = bVar.n) == null) {
                        return;
                    }
                    videoRecorderService.record(bArr);
                }
            });
            this.p.startPreview();
            this.k = true;
        } catch (Throwable th) {
            this.B = th;
        }
    }

    private void a(Camera.Parameters parameters) {
        Point point;
        List<Point> b = b(parameters.getSupportedPictureSizes());
        if (b == null) {
            point = null;
        } else {
            Collections.sort(b, this.g);
            int i = 0;
            for (Point point2 : b) {
                int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point2);
                if (xVar >= 600) {
                    if (((double) Math.abs((((float) xVar) / ((float) com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point2))) - 0.0f)) <= 0.05d) {
                        break;
                    }
                }
                i++;
            }
            point = b.get(i != b.size() ? i : 0);
        }
        this.d = point;
        parameters.setPictureSize(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(point), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(point));
    }

    private static Pair<Camera.CameraInfo, Integer> a(int i) {
        Camera.CameraInfo cameraInfo;
        int i2;
        if (Build.VERSION.SDK_INT > 8) {
            int numberOfCameras = Camera.getNumberOfCameras();
            i2 = 0;
            while (i2 < numberOfCameras) {
                cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i2, cameraInfo);
                if (cameraInfo.facing == i) {
                    break;
                }
                i2++;
            }
        }
        cameraInfo = null;
        i2 = -1;
        return new Pair<>(cameraInfo, Integer.valueOf(i2));
    }

    private void a(Context context, int i) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, cameraInfo);
        int rotation = ((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay().getRotation();
        int i2 = 0;
        if (rotation != 0) {
            if (rotation == 1) {
                i2 = 90;
            } else if (rotation == 2) {
                i2 = 180;
            } else if (rotation == 3) {
                i2 = AntiShakeOrientationEventListener.SCREEN_ORIENTATION_LANDSCAPE;
            }
        }
        this.i = (360 - ((cameraInfo.orientation + i2) % 360)) % 360;
    }

    @Override // com.alibaba.security.biometrics.camera.c
    public final void a(com.alibaba.security.common.e.b bVar, boolean z) {
        if (!this.o) {
            if (bVar != null) {
                bVar.onFinish(null, this.j);
                return;
            }
            return;
        }
        this.o = false;
        VideoRecorderService videoRecorderService = this.n;
        if (videoRecorderService != null) {
            videoRecorderService.release(bVar, z);
        }
        this.n = null;
    }
}
