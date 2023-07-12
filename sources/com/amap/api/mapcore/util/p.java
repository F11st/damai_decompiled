package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.al;
import com.amap.api.mapcore.util.am;
import com.amap.api.mapcore.util.ao;
import com.amap.api.mapcore.util.ap;
import com.amap.api.maps.model.AMapGestureListener;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class p {
    IAMapDelegate a;
    Context b;
    GestureDetector c;
    public AMapGestureListener d;
    private ao e;
    private am f;
    private al g;
    private ap h;
    private int r;
    private int s;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private int n = 0;
    private boolean o = false;
    private boolean p = false;
    private boolean q = true;
    private Handler t = new Handler(Looper.getMainLooper());

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        private a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            p.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.d < motionEvent.getPointerCount()) {
                this.d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.d == 1) {
                try {
                    if (!p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                        return false;
                    }
                } catch (Throwable th) {
                    hd.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                    th.printStackTrace();
                }
                if (action == 0) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 9;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
                    this.a = motionEvent.getY();
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.b = SystemClock.uptimeMillis();
                    return true;
                } else if (action == 2) {
                    p.this.o = true;
                    float y = this.a - motionEvent.getY();
                    if (Math.abs(y) >= 20) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                        eAMapPlatformGestureInfo2.mGestureState = 2;
                        eAMapPlatformGestureInfo2.mGestureType = 9;
                        eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                        int engineIDWithGestureInfo2 = p.this.a.getEngineIDWithGestureInfo(this.e);
                        float mapHeight = (4.0f * y) / p.this.a.getMapHeight();
                        if (y > 0.0f) {
                            p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                        } else {
                            p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                        }
                        this.a = motionEvent.getY();
                        return true;
                    }
                    return true;
                } else {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.e;
                    eAMapPlatformGestureInfo3.mGestureState = 3;
                    eAMapPlatformGestureInfo3.mGestureType = 9;
                    eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                    int engineIDWithGestureInfo3 = p.this.a.getEngineIDWithGestureInfo(this.e);
                    p.this.c.setIsLongpressEnabled(true);
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo3, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action != 1) {
                        p.this.o = false;
                        return true;
                    }
                    p.this.a.setGestureStatus(engineIDWithGestureInfo3, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.b;
                    if (p.this.o && uptimeMillis >= 200) {
                        p.this.o = false;
                        return true;
                    }
                    return p.this.a.onDoubleTap(engineIDWithGestureInfo3, motionEvent);
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            p.this.o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled() && p.this.m <= 0 && p.this.k <= 0 && p.this.l == 0 && !p.this.q) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
                    p.this.a.onFling();
                    p.this.a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent motionEvent) {
            if (p.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                p.this.a.onLongPress(p.this.a.getEngineIDWithGestureInfo(this.e), motionEvent);
                AMapGestureListener aMapGestureListener = p.this.d;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onScroll(f, f2);
                return false;
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public void onShowPress(MotionEvent motionEvent) {
            try {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                p.this.a.getGLMapEngine().clearAnimations(p.this.a.getEngineIDWithGestureInfo(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (p.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 8;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.e);
                AMapGestureListener aMapGestureListener = p.this.d;
                if (aMapGestureListener != null) {
                    try {
                        aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return p.this.a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class b implements al.a {
        private EAMapPlatformGestureInfo b;

        private b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.al.a
        public boolean a(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (!p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo) && p.this.l <= 3) {
                        float f = alVar.d().x;
                        float f2 = alVar.d().y;
                        if (!p.this.i) {
                            PointF a = alVar.a(0);
                            PointF a2 = alVar.a(1);
                            float f3 = a.y;
                            if ((f3 > 10.0f && a2.y > 10.0f) || (f3 < -10.0f && a2.y < -10.0f)) {
                                z = true;
                            }
                            if (z) {
                                float f4 = 10;
                                if (Math.abs(f2) > f4 && Math.abs(f) < f4) {
                                    p.this.i = true;
                                }
                            }
                        }
                        if (p.this.i) {
                            p.this.i = true;
                            float f5 = f2 / 6.0f;
                            if (Math.abs(f5) > 1.0f) {
                                p.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f5));
                                p.m(p.this);
                            }
                        }
                        return true;
                    }
                    return false;
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.al.a
        public boolean b(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    IAMapDelegate iAMapDelegate = p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.al.a
        public void c(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (p.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && p.this.m > 0) {
                        p.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    p.this.i = false;
                    IAMapDelegate iAMapDelegate = p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class c implements am.a {
        private EAMapPlatformGestureInfo b;

        private c() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.am.a
        public boolean a(am amVar) {
            if (p.this.i) {
                return true;
            }
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!p.this.p) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                        int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                        PointF d = amVar.d();
                        float f = p.this.j == 0 ? 4.0f : 1.0f;
                        if (Math.abs(d.x) <= f && Math.abs(d.y) <= f) {
                            return false;
                        }
                        if (p.this.j == 0) {
                            p.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d.x, d.y));
                        p.l(p.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.a
        public boolean b(am amVar) {
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    p.this.a.addGestureMapMessage(p.this.a.getEngineIDWithGestureInfo(this.b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.a
        public void c(am amVar) {
            try {
                if (p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (p.this.j > 0) {
                        p.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class d extends ao.a {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private d() {
            this.b = false;
            this.c = false;
            this.d = false;
            this.e = new Point();
            this.f = new float[10];
            this.g = 0.0f;
            this.h = new float[10];
            this.i = 0.0f;
            this.j = new EAMapPlatformGestureInfo();
        }

        /* JADX WARN: Removed duplicated region for block: B:34:0x00f8 A[Catch: all -> 0x010a, TryCatch #2 {all -> 0x010a, blocks: (B:32:0x00d0, B:34:0x00f8, B:35:0x0100, B:24:0x00ba), top: B:83:0x00ba }] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x0100 A[Catch: all -> 0x010a, TRY_LEAVE, TryCatch #2 {all -> 0x010a, blocks: (B:32:0x00d0, B:34:0x00f8, B:35:0x0100, B:24:0x00ba), top: B:83:0x00ba }] */
        /* JADX WARN: Removed duplicated region for block: B:46:0x0128 A[Catch: all -> 0x01a1, TryCatch #1 {all -> 0x01a1, blocks: (B:44:0x011a, B:46:0x0128, B:48:0x0132, B:50:0x0136, B:52:0x0140, B:54:0x0148, B:55:0x014a, B:57:0x014e, B:69:0x0170, B:63:0x0160), top: B:81:0x011a }] */
        /* JADX WARN: Removed duplicated region for block: B:68:0x016f  */
        /* JADX WARN: Removed duplicated region for block: B:69:0x0170 A[Catch: all -> 0x01a1, TRY_LEAVE, TryCatch #1 {all -> 0x01a1, blocks: (B:44:0x011a, B:46:0x0128, B:48:0x0132, B:50:0x0136, B:52:0x0140, B:54:0x0148, B:55:0x014a, B:57:0x014e, B:69:0x0170, B:63:0x0160), top: B:81:0x011a }] */
        @Override // com.amap.api.mapcore.util.ao.a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(com.amap.api.mapcore.util.ao r18) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.p.d.a(com.amap.api.mapcore.util.ao):boolean");
        }

        @Override // com.amap.api.mapcore.util.ao.a
        public boolean b(ao aoVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.j);
            int b = (int) aoVar.b();
            int c = (int) aoVar.c();
            this.d = false;
            Point point = this.e;
            point.x = b;
            point.y = c;
            this.b = false;
            this.c = false;
            p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b, c));
            try {
                if (p.this.a.getUiSettings().isRotateGesturesEnabled() && !p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), b, c));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.ao.a
        public void c(ao aoVar) {
            float f;
            float f2;
            float f3;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.j);
            this.d = false;
            p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (p.this.k > 0) {
                int i = p.this.k > 10 ? 10 : p.this.k;
                float f4 = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    float[] fArr = this.f;
                    f4 += fArr[i2];
                    fArr[i2] = 0.0f;
                }
                float f5 = f4 / i;
                if (0.004f <= f5) {
                    float f6 = f5 * 300.0f;
                    if (f6 >= 1.5f) {
                        f6 = 1.5f;
                    }
                    if (this.g < 0.0f) {
                        f6 = -f6;
                    }
                    f3 = p.this.a.getPreciseLevel(engineIDWithGestureInfo) + f6;
                } else {
                    f3 = -9999.0f;
                }
                this.g = 0.0f;
                f = f3;
            } else {
                f = -9999.0f;
            }
            if (p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (p.this.a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = p.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    hd.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (p.this.l > 0) {
                    p.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i3 = p.this.l > 10 ? 10 : p.this.l;
                    float f7 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        float[] fArr2 = this.h;
                        f7 += fArr2[i4];
                        fArr2[i4] = 0.0f;
                    }
                    float f8 = f7 / i3;
                    if (0.1f <= f8) {
                        float f9 = f8 * 200.0f;
                        int mapAngle = ((int) p.this.a.getMapAngle(engineIDWithGestureInfo)) % 360;
                        if (f9 >= 60.0f) {
                            f9 = 60.0f;
                        }
                        if (this.i < 0.0f) {
                            f9 = -f9;
                        }
                        f2 = ((int) (mapAngle + f9)) % 360;
                        this.g = 0.0f;
                    }
                }
                f2 = -9999.0f;
                this.g = 0.0f;
            }
            if ((f == -9999.0f && f2 == -9999.0f) ? true : true) {
                p.this.a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.e, f, (int) f2, 500);
            }
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    private class e extends ap.b {
        EAMapPlatformGestureInfo a;

        private e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.ap.b, com.amap.api.mapcore.util.ap.a
        public void a(ap apVar) {
            try {
                if (p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    float f = 10;
                    if (Math.abs(apVar.d()) > f || Math.abs(apVar.e()) > f || apVar.b() >= 200) {
                        return;
                    }
                    p.this.q = true;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                    int engineIDWithGestureInfo = p.this.a.getEngineIDWithGestureInfo(this.a);
                    p.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                    p.this.a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public p(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate.getContext();
        this.a = iAMapDelegate;
        a aVar = new a();
        GestureDetector gestureDetector = new GestureDetector(this.b, aVar, this.t);
        this.c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.e = new ao(this.b, new d());
        this.f = new am(this.b, new c());
        this.g = new al(this.b, new b());
        this.h = new ap(this.b, new e());
    }

    static /* synthetic */ int g(p pVar) {
        int i = pVar.k;
        pVar.k = i + 1;
        return i;
    }

    static /* synthetic */ int h(p pVar) {
        int i = pVar.l;
        pVar.l = i + 1;
        return i;
    }

    static /* synthetic */ int l(p pVar) {
        int i = pVar.j;
        pVar.j = i + 1;
        return i;
    }

    static /* synthetic */ int m(p pVar) {
        int i = pVar.m;
        pVar.m = i + 1;
        return i;
    }

    public void d() {
        Handler handler = this.t;
        if (handler != null) {
            handler.removeCallbacks(null);
            this.t = null;
        }
    }

    public void a(AMapGestureListener aMapGestureListener) {
        this.d = aMapGestureListener;
    }

    public int b() {
        return this.r;
    }

    public int c() {
        return this.s;
    }

    public void a() {
        this.j = 0;
        this.l = 0;
        this.k = 0;
        this.m = 0;
        this.n = 0;
    }

    public void a(int i, int i2) {
        this.r = i;
        this.s = i2;
        ao aoVar = this.e;
        if (aoVar != null) {
            aoVar.a(i, i2);
        }
        am amVar = this.f;
        if (amVar != null) {
            amVar.a(i, i2);
        }
        al alVar = this.g;
        if (alVar != null) {
            alVar.a(i, i2);
        }
        ap apVar = this.h;
        if (apVar != null) {
            apVar.a(i, i2);
        }
    }

    public boolean a(MotionEvent motionEvent) {
        if (this.n < motionEvent.getPointerCount()) {
            this.n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.p = false;
            this.q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.p = true;
        }
        if (this.o && this.n >= 2) {
            this.o = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate != null && iAMapDelegate.getGLMapView() != null) {
                this.a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.d != null) {
                if (motionEvent.getAction() == 0) {
                    this.d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.c.onTouchEvent(motionEvent);
            boolean d2 = this.g.d(motionEvent, iArr[0], iArr[1]);
            if (!this.i || this.m <= 0) {
                this.h.d(motionEvent, iArr[0], iArr[1]);
                if (this.o) {
                    return d2;
                }
                this.e.a(motionEvent);
                return this.f.d(motionEvent, iArr[0], iArr[1]);
            }
            return d2;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
