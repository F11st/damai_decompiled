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
/* renamed from: com.amap.api.mapcore.util.p */
/* loaded from: classes10.dex */
public class C4630p {
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
    /* renamed from: com.amap.api.mapcore.util.p$a */
    /* loaded from: classes10.dex */
    private class GestureDetector$OnDoubleTapListenerC4631a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {
        float a;
        long b;
        private int d;
        private EAMapPlatformGestureInfo e;

        private GestureDetector$OnDoubleTapListenerC4631a() {
            this.d = 0;
            this.a = 0.0f;
            this.e = new EAMapPlatformGestureInfo();
            this.b = 0L;
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onDoubleTap(MotionEvent motionEvent) {
            C4630p.this.c.setIsLongpressEnabled(false);
            this.d = motionEvent.getPointerCount();
            AMapGestureListener aMapGestureListener = C4630p.this.d;
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
                    if (!C4630p.this.a.getUiSettings().isZoomGesturesEnabled()) {
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
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.e);
                    this.a = motionEvent.getY();
                    C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                    this.b = SystemClock.uptimeMillis();
                    return true;
                } else if (action == 2) {
                    C4630p.this.o = true;
                    float y = this.a - motionEvent.getY();
                    if (Math.abs(y) >= 20) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.e;
                        eAMapPlatformGestureInfo2.mGestureState = 2;
                        eAMapPlatformGestureInfo2.mGestureType = 9;
                        eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                        int engineIDWithGestureInfo2 = C4630p.this.a.getEngineIDWithGestureInfo(this.e);
                        float mapHeight = (4.0f * y) / C4630p.this.a.getMapHeight();
                        if (y > 0.0f) {
                            C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
                        } else {
                            C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(101, mapHeight, 0, 0));
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
                    int engineIDWithGestureInfo3 = C4630p.this.a.getEngineIDWithGestureInfo(this.e);
                    C4630p.this.c.setIsLongpressEnabled(true);
                    C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo3, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                    if (action != 1) {
                        C4630p.this.o = false;
                        return true;
                    }
                    C4630p.this.a.setGestureStatus(engineIDWithGestureInfo3, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.b;
                    if (C4630p.this.o && uptimeMillis >= 200) {
                        C4630p.this.o = false;
                        return true;
                    }
                    return C4630p.this.a.onDoubleTap(engineIDWithGestureInfo3, motionEvent);
                }
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onDown(MotionEvent motionEvent) {
            C4630p.this.o = false;
            return true;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = C4630p.this.d;
            if (aMapGestureListener != null) {
                aMapGestureListener.onFling(f, f2);
            }
            try {
                if (C4630p.this.a.getUiSettings().isScrollGesturesEnabled() && C4630p.this.m <= 0 && C4630p.this.k <= 0 && C4630p.this.l == 0 && !C4630p.this.q) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.e);
                    C4630p.this.a.onFling();
                    C4630p.this.a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f, f2);
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
            if (C4630p.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 7;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                C4630p.this.a.onLongPress(C4630p.this.a.getEngineIDWithGestureInfo(this.e), motionEvent);
                AMapGestureListener aMapGestureListener = C4630p.this.d;
                if (aMapGestureListener != null) {
                    aMapGestureListener.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            AMapGestureListener aMapGestureListener = C4630p.this.d;
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
                C4630p.this.a.getGLMapEngine().clearAnimations(C4630p.this.a.getEngineIDWithGestureInfo(this.e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        @Override // android.view.GestureDetector.OnDoubleTapListener
        public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (C4630p.this.n == 1) {
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.e;
                eAMapPlatformGestureInfo.mGestureState = 3;
                eAMapPlatformGestureInfo.mGestureType = 8;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.e);
                AMapGestureListener aMapGestureListener = C4630p.this.d;
                if (aMapGestureListener != null) {
                    try {
                        aMapGestureListener.onSingleTap(motionEvent.getX(), motionEvent.getY());
                    } catch (Throwable th) {
                        th.printStackTrace();
                    }
                }
                return C4630p.this.a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
            }
            return false;
        }

        @Override // android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.p$b */
    /* loaded from: classes10.dex */
    private class C4632b implements al.InterfaceC4473a {
        private EAMapPlatformGestureInfo b;

        private C4632b() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.al.InterfaceC4473a
        public boolean a(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 2;
            eAMapPlatformGestureInfo.mGestureType = 6;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (C4630p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (!C4630p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo) && C4630p.this.l <= 3) {
                        float f = alVar.d().x;
                        float f2 = alVar.d().y;
                        if (!C4630p.this.i) {
                            PointF a = alVar.a(0);
                            PointF a2 = alVar.a(1);
                            float f3 = a.y;
                            if ((f3 > 10.0f && a2.y > 10.0f) || (f3 < -10.0f && a2.y < -10.0f)) {
                                z = true;
                            }
                            if (z) {
                                float f4 = 10;
                                if (Math.abs(f2) > f4 && Math.abs(f) < f4) {
                                    C4630p.this.i = true;
                                }
                            }
                        }
                        if (C4630p.this.i) {
                            C4630p.this.i = true;
                            float f5 = f2 / 6.0f;
                            if (Math.abs(f5) > 1.0f) {
                                C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f5));
                                C4630p.m(C4630p.this);
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

        @Override // com.amap.api.mapcore.util.al.InterfaceC4473a
        public boolean b(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (C4630p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (C4630p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return false;
                    }
                    IAMapDelegate iAMapDelegate = C4630p.this.a;
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

        @Override // com.amap.api.mapcore.util.al.InterfaceC4473a
        public void c(al alVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 6;
            eAMapPlatformGestureInfo.mLocation = new float[]{alVar.c().getX(), alVar.c().getY()};
            try {
                if (C4630p.this.a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (C4630p.this.a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        return;
                    }
                    if (C4630p.this.a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && C4630p.this.m > 0) {
                        C4630p.this.a.setGestureStatus(engineIDWithGestureInfo, 7);
                    }
                    C4630p.this.i = false;
                    IAMapDelegate iAMapDelegate = C4630p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, iAMapDelegate.getCameraDegree(engineIDWithGestureInfo)));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.p$c */
    /* loaded from: classes10.dex */
    private class C4633c implements am.InterfaceC4474a {
        private EAMapPlatformGestureInfo b;

        private C4633c() {
            this.b = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.am.InterfaceC4474a
        public boolean a(am amVar) {
            if (C4630p.this.i) {
                return true;
            }
            try {
                if (C4630p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    if (!C4630p.this.p) {
                        EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                        eAMapPlatformGestureInfo.mGestureState = 2;
                        eAMapPlatformGestureInfo.mGestureType = 3;
                        eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                        int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.b);
                        PointF d = amVar.d();
                        float f = C4630p.this.j == 0 ? 4.0f : 1.0f;
                        if (Math.abs(d.x) <= f && Math.abs(d.y) <= f) {
                            return false;
                        }
                        if (C4630p.this.j == 0) {
                            C4630p.this.a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                        }
                        C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d.x, d.y));
                        C4630p.l(C4630p.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.InterfaceC4474a
        public boolean b(am amVar) {
            try {
                if (C4630p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 1;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    C4630p.this.a.addGestureMapMessage(C4630p.this.a.getEngineIDWithGestureInfo(this.b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                    return true;
                }
                return true;
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        @Override // com.amap.api.mapcore.util.am.InterfaceC4474a
        public void c(am amVar) {
            try {
                if (C4630p.this.a.getUiSettings().isScrollGesturesEnabled()) {
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.b;
                    eAMapPlatformGestureInfo.mGestureState = 3;
                    eAMapPlatformGestureInfo.mGestureType = 3;
                    eAMapPlatformGestureInfo.mLocation = new float[]{amVar.c().getX(), amVar.c().getY()};
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.b);
                    if (C4630p.this.j > 0) {
                        C4630p.this.a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.p$d */
    /* loaded from: classes10.dex */
    private class C4634d extends ao.AbstractC4476a {
        private boolean b;
        private boolean c;
        private boolean d;
        private Point e;
        private float[] f;
        private float g;
        private float[] h;
        private float i;
        private EAMapPlatformGestureInfo j;

        private C4634d() {
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
        @Override // com.amap.api.mapcore.util.ao.AbstractC4476a
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(com.amap.api.mapcore.util.ao r18) {
            /*
                Method dump skipped, instructions count: 426
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.C4630p.C4634d.a(com.amap.api.mapcore.util.ao):boolean");
        }

        @Override // com.amap.api.mapcore.util.ao.AbstractC4476a
        public boolean b(ao aoVar) {
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 1;
            eAMapPlatformGestureInfo.mGestureType = 4;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.j);
            int b = (int) aoVar.b();
            int c = (int) aoVar.c();
            this.d = false;
            Point point = this.e;
            point.x = b;
            point.y = c;
            this.b = false;
            this.c = false;
            C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b, c));
            try {
                if (C4630p.this.a.getUiSettings().isRotateGesturesEnabled() && !C4630p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                    IAMapDelegate iAMapDelegate = C4630p.this.a;
                    iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), b, c));
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        @Override // com.amap.api.mapcore.util.ao.AbstractC4476a
        public void c(ao aoVar) {
            float f;
            float f2;
            float f3;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.j;
            eAMapPlatformGestureInfo.mGestureState = 3;
            eAMapPlatformGestureInfo.mGestureType = 4;
            boolean z = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{aoVar.a().getX(), aoVar.a().getY()};
            int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.j);
            this.d = false;
            C4630p.this.a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (C4630p.this.k > 0) {
                int i = C4630p.this.k > 10 ? 10 : C4630p.this.k;
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
                    f3 = C4630p.this.a.getPreciseLevel(engineIDWithGestureInfo) + f6;
                } else {
                    f3 = -9999.0f;
                }
                this.g = 0.0f;
                f = f3;
            } else {
                f = -9999.0f;
            }
            if (C4630p.this.a.isLockMapAngle(engineIDWithGestureInfo)) {
                f2 = -9999.0f;
            } else {
                try {
                    if (C4630p.this.a.getUiSettings().isRotateGesturesEnabled()) {
                        IAMapDelegate iAMapDelegate = C4630p.this.a;
                        iAMapDelegate.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, iAMapDelegate.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    hd.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (C4630p.this.l > 0) {
                    C4630p.this.a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int i3 = C4630p.this.l > 10 ? 10 : C4630p.this.l;
                    float f7 = 0.0f;
                    for (int i4 = 0; i4 < 10; i4++) {
                        float[] fArr2 = this.h;
                        f7 += fArr2[i4];
                        fArr2[i4] = 0.0f;
                    }
                    float f8 = f7 / i3;
                    if (0.1f <= f8) {
                        float f9 = f8 * 200.0f;
                        int mapAngle = ((int) C4630p.this.a.getMapAngle(engineIDWithGestureInfo)) % 360;
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
                C4630p.this.a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.e, f, (int) f2, 500);
            }
        }
    }

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.p$e */
    /* loaded from: classes10.dex */
    private class C4635e extends ap.C4478b {
        EAMapPlatformGestureInfo a;

        private C4635e() {
            this.a = new EAMapPlatformGestureInfo();
        }

        @Override // com.amap.api.mapcore.util.ap.C4478b, com.amap.api.mapcore.util.ap.InterfaceC4477a
        public void a(ap apVar) {
            try {
                if (C4630p.this.a.getUiSettings().isZoomGesturesEnabled()) {
                    float f = 10;
                    if (Math.abs(apVar.d()) > f || Math.abs(apVar.e()) > f || apVar.b() >= 200) {
                        return;
                    }
                    C4630p.this.q = true;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.a;
                    eAMapPlatformGestureInfo.mGestureState = 2;
                    eAMapPlatformGestureInfo.mGestureType = 2;
                    eAMapPlatformGestureInfo.mLocation = new float[]{apVar.c().getX(), apVar.c().getY()};
                    int engineIDWithGestureInfo = C4630p.this.a.getEngineIDWithGestureInfo(this.a);
                    C4630p.this.a.setGestureStatus(engineIDWithGestureInfo, 4);
                    C4630p.this.a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                hd.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public C4630p(IAMapDelegate iAMapDelegate) {
        this.b = iAMapDelegate.getContext();
        this.a = iAMapDelegate;
        GestureDetector$OnDoubleTapListenerC4631a gestureDetector$OnDoubleTapListenerC4631a = new GestureDetector$OnDoubleTapListenerC4631a();
        GestureDetector gestureDetector = new GestureDetector(this.b, gestureDetector$OnDoubleTapListenerC4631a, this.t);
        this.c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(gestureDetector$OnDoubleTapListenerC4631a);
        this.e = new ao(this.b, new C4634d());
        this.f = new am(this.b, new C4633c());
        this.g = new al(this.b, new C4632b());
        this.h = new ap(this.b, new C4635e());
    }

    static /* synthetic */ int g(C4630p c4630p) {
        int i = c4630p.k;
        c4630p.k = i + 1;
        return i;
    }

    static /* synthetic */ int h(C4630p c4630p) {
        int i = c4630p.l;
        c4630p.l = i + 1;
        return i;
    }

    static /* synthetic */ int l(C4630p c4630p) {
        int i = c4630p.j;
        c4630p.j = i + 1;
        return i;
    }

    static /* synthetic */ int m(C4630p c4630p) {
        int i = c4630p.m;
        c4630p.m = i + 1;
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
            boolean d = this.g.d(motionEvent, iArr[0], iArr[1]);
            if (!this.i || this.m <= 0) {
                this.h.d(motionEvent, iArr[0], iArr[1]);
                if (this.o) {
                    return d;
                }
                this.e.a(motionEvent);
                return this.f.d(motionEvent, iArr[0], iArr[1]);
            }
            return d;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }
}
