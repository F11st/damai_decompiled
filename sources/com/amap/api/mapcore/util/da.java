package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.interfaces.IInfoWindowManager;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.youku.live.livesdk.monitor.performance.AbsPerformance;
import java.nio.Buffer;
import java.nio.FloatBuffer;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class da implements IInfoWindowManager, IInfoWindowAction, IOverlayDelegate {
    private GLAnimation H;
    private GLAnimation I;
    IAMapDelegate a;
    a c;
    ar f;
    private Context g;
    private BaseOverlayImp h;
    private FPoint n;
    private FloatBuffer r;
    private boolean u;
    private Bitmap v;
    private Bitmap w;
    private int z;
    private boolean i = false;
    private int j = 0;
    private int k = 0;
    private int l = 0;
    private int m = 0;
    private FloatBuffer o = null;
    private boolean q = true;
    private float s = 0.5f;
    private float t = 1.0f;
    private Rect x = new Rect();
    private float y = 0.0f;
    private boolean A = true;
    private Bitmap B = null;
    private Bitmap C = null;
    private Bitmap D = null;
    private Bitmap E = null;
    private boolean F = false;
    private boolean G = false;
    float[] b = new float[12];
    float[] d = {1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    long e = 0;
    private boolean J = false;
    private boolean K = true;
    private String p = getId();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a extends dd {
        int a;
        int b;
        int c;

        a(String str) {
            if (a(str)) {
                this.a = c("aMVP");
                this.b = b("aVertex");
                this.c = b("aTextureCoord");
            }
        }
    }

    public da(IAMapDelegate iAMapDelegate, Context context) {
        this.a = null;
        this.g = context;
        this.a = iAMapDelegate;
    }

    private synchronized void c(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                eq.b(bitmap);
            }
        }
    }

    private synchronized void d(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.C);
                this.C = bitmap;
            }
        }
    }

    private synchronized void e(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.D);
                this.D = bitmap;
            }
        }
    }

    private synchronized void f(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                c(this.E);
                this.E = bitmap;
            }
        }
    }

    private boolean g(Bitmap bitmap) {
        if (this.B == null || bitmap.hashCode() != this.B.hashCode()) {
            if (this.D == null || bitmap.hashCode() != this.D.hashCode()) {
                if (this.C == null || bitmap.hashCode() != this.C.hashCode()) {
                    return this.E != null && bitmap.hashCode() == this.E.hashCode();
                }
                return true;
            }
            return true;
        }
        return true;
    }

    private synchronized Bitmap h() {
        return this.B;
    }

    private synchronized Bitmap i() {
        return this.D;
    }

    private void j() {
        GLAnimation gLAnimation;
        if (!this.K && (gLAnimation = this.I) != null && !gLAnimation.hasEnded()) {
            this.J = true;
            GLTransformation gLTransformation = new GLTransformation();
            this.I.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation);
            if (Double.isNaN(gLTransformation.scaleX) || Double.isNaN(gLTransformation.scaleY)) {
                return;
            }
            this.y = (float) gLTransformation.scaleX;
            return;
        }
        GLAnimation gLAnimation2 = this.H;
        if (gLAnimation2 != null && !gLAnimation2.hasEnded()) {
            this.K = false;
            this.J = true;
            this.j = this.l;
            this.k = this.m;
            GLTransformation gLTransformation2 = new GLTransformation();
            this.H.getTransformation(AnimationUtils.currentAnimationTimeMillis(), gLTransformation2);
            if (Double.isNaN(gLTransformation2.scaleX) || Double.isNaN(gLTransformation2.scaleY)) {
                return;
            }
            this.y = (float) gLTransformation2.scaleX;
            return;
        }
        this.y = 1.0f;
        this.J = false;
    }

    private int k() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void l() {
        if (this.A && this.v != null) {
            c(false);
        } else {
            b(i());
        }
        a(false);
    }

    private void m() {
        if (!this.A && this.v != null) {
            c(true);
        } else {
            b(h());
        }
        a(true);
    }

    private synchronized void n() {
        Bitmap bitmap = this.v;
        if (bitmap != null && bitmap != null) {
            eq.b(bitmap);
            this.v = null;
        }
        Bitmap bitmap2 = this.w;
        if (bitmap2 != null && !bitmap2.isRecycled()) {
            eq.b(this.w);
            this.w = null;
        }
        Bitmap bitmap3 = this.B;
        if (bitmap3 != null && !bitmap3.isRecycled()) {
            eq.b(this.B);
            this.B = null;
        }
        Bitmap bitmap4 = this.C;
        if (bitmap4 != null && !bitmap4.isRecycled()) {
            eq.b(this.C);
            this.C = null;
        }
        Bitmap bitmap5 = this.D;
        if (bitmap5 != null && !bitmap5.isRecycled()) {
            eq.b(this.D);
            this.D = null;
        }
        Bitmap bitmap6 = this.E;
        if (bitmap6 != null && !bitmap6.isRecycled()) {
            eq.b(this.E);
            this.E = null;
        }
    }

    private void o() {
    }

    private Rect p() {
        Rect rect = this.x;
        int i = rect.left;
        int i2 = rect.top;
        return new Rect(i, i2, rect.right, r() + i2);
    }

    private Rect q() {
        Rect rect = this.x;
        int i = rect.left;
        int i2 = rect.top;
        return new Rect(i, i2, rect.right, s() + i2);
    }

    private int r() {
        Bitmap bitmap = this.B;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.B.getHeight();
    }

    private int s() {
        Bitmap bitmap = this.D;
        if (bitmap == null || bitmap.isRecycled()) {
            return 0;
        }
        return this.D.getHeight();
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        if (this.i) {
            try {
                remove();
                n();
                FloatBuffer floatBuffer = this.r;
                if (floatBuffer != null) {
                    floatBuffer.clear();
                    this.r = null;
                }
                FloatBuffer floatBuffer2 = this.o;
                if (floatBuffer2 != null) {
                    floatBuffer2.clear();
                    this.o = null;
                }
                this.n = null;
                this.z = 0;
            } catch (Throwable th) {
                hd.c(th, "PopupOverlay", "realDestroy");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() {
        if (this.p == null) {
            this.p = "PopupOverlay";
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() {
        return 0.0f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void hideInfoWindow() {
        setVisible(false);
        n();
        this.F = false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() {
        return this.q;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        return this.q && this.h != null && this.F && eq.a(this.x, (int) motionEvent.getX(), (int) motionEvent.getY());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0054 A[Catch: all -> 0x00f6, TryCatch #2 {all -> 0x0132, blocks: (B:2:0x0000, B:10:0x0010, B:12:0x003b, B:56:0x00f9, B:58:0x00ff, B:60:0x0103, B:62:0x0107, B:64:0x010b, B:66:0x0113, B:68:0x0117, B:13:0x003c, B:15:0x0042, B:17:0x0046, B:19:0x004a, B:25:0x0054, B:27:0x005e, B:29:0x0064, B:30:0x0067, B:32:0x0069, B:34:0x006e, B:36:0x0074, B:38:0x0082, B:40:0x00a0, B:47:0x00b7, B:49:0x00d8, B:48:0x00d5, B:39:0x0091, B:50:0x00e5, B:51:0x00f4, B:3:0x0001, B:5:0x0006, B:8:0x000e, B:70:0x012a, B:71:0x012d), top: B:79:0x0000 }] */
    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void redrawInfoWindow() {
        /*
            Method dump skipped, instructions count: 311
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.da.redrawInfoWindow():void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(ar arVar) {
        synchronized (this) {
            this.f = arVar;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAnimation(Animation animation, Animation.AnimationListener animationListener) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowAppearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.I;
        if (gLAnimation != null && gLAnimation.equals(animation.glAnimation)) {
            try {
                this.H = animation.glAnimation.mo242clone();
                return;
            } catch (Throwable th) {
                hd.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
                return;
            }
        }
        this.H = animation.glAnimation;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackColor(int i) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackEnable(boolean z) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowBackScale(float f, float f2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowDisappearAnimation(Animation animation) {
        GLAnimation gLAnimation = this.H;
        if (gLAnimation != null && gLAnimation.equals(animation.glAnimation)) {
            try {
                this.I = animation.glAnimation.mo242clone();
                return;
            } catch (Throwable th) {
                hd.c(th, "PopupOverlay", "setInfoWindowDisappearAnimation");
                return;
            }
        }
        this.I = animation.glAnimation;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void setInfoWindowMovingAnimation(Animation animation) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) {
        if (!this.q && z) {
            this.u = true;
        }
        this.q = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public synchronized void showInfoWindow(BaseOverlayImp baseOverlayImp) throws RemoteException {
        if (baseOverlayImp == null) {
            return;
        }
        if (baseOverlayImp.isInfoWindowEnable()) {
            BaseOverlayImp baseOverlayImp2 = this.h;
            if (baseOverlayImp2 != null && !baseOverlayImp2.getId().equals(baseOverlayImp.getId())) {
                hideInfoWindow();
            }
            if (this.f != null) {
                this.h = baseOverlayImp;
                baseOverlayImp.setInfoWindowShown(true);
                setVisible(true);
                g();
            }
            this.F = true;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IInfoWindowManager
    public void startAnimation() {
    }

    public int b() {
        try {
            synchronized (this) {
                Bitmap bitmap = this.v;
                if (bitmap == null || bitmap.isRecycled()) {
                    return 0;
                }
                return this.v.getWidth();
            }
        } catch (Throwable unused) {
            return 0;
        }
    }

    public boolean a() {
        return this.A;
    }

    public void a(boolean z) {
        this.A = z;
    }

    public int c() {
        try {
            Bitmap bitmap = this.v;
            if (bitmap == null || bitmap.isRecycled()) {
                return 0;
            }
            return this.v.getHeight();
        } catch (Throwable unused) {
            return 0;
        }
    }

    public synchronized void a(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                this.B = bitmap;
            }
        }
    }

    public void d() {
        this.c = new a("texture.glsl");
    }

    protected void e() {
        long j;
        long c;
        synchronized (this) {
            j = 100;
            if (this.f != null) {
                BaseOverlayImp baseOverlayImp = this.h;
                if (baseOverlayImp instanceof cu) {
                    c = this.f.c((BasePointOverlay) new Marker((IMarker) baseOverlayImp));
                } else {
                    c = this.f.c(new GL3DModel((cr) baseOverlayImp));
                }
                if (c <= 0) {
                    j = AbsPerformance.LONG_NIL;
                } else if (c > 100) {
                    j = c;
                }
            } else {
                j = 0;
            }
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.e;
        if (currentTimeMillis - j2 > j) {
            if (j2 != 0) {
                try {
                    showInfoWindow(this.h);
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
            }
            this.e = currentTimeMillis;
        }
    }

    public boolean f() {
        return this.J;
    }

    protected void g() {
        View b;
        View b2;
        try {
            BaseOverlayImp baseOverlayImp = this.h;
            if (baseOverlayImp instanceof cu) {
                Marker marker = new Marker((IMarker) baseOverlayImp);
                ar arVar = this.f;
                if (arVar != null) {
                    Bitmap a2 = a(arVar.a((BasePointOverlay) marker));
                    if (a2 == null && (b2 = this.f.b((BasePointOverlay) marker)) != null) {
                        if (b2.getBackground() == null) {
                            b2.setBackground(this.f.g());
                        }
                        a2 = a(b2);
                    }
                    a(a2);
                    d(a(this.f.a(marker)));
                    e(a(this.f.b(marker)));
                    f(a(this.f.c(marker)));
                }
            } else if (this.f != null) {
                GL3DModel gL3DModel = new GL3DModel((cr) baseOverlayImp);
                Bitmap a3 = a(this.f.a(gL3DModel));
                if (a3 == null && (b = this.f.b(gL3DModel)) != null) {
                    if (b.getBackground() == null) {
                        b.setBackground(this.f.g());
                    }
                    a3 = a(b);
                }
                a(a3);
            }
        } catch (Throwable th) {
            hd.c(th, "PopupOverlay", "getInfoWindow");
            th.printStackTrace();
        }
    }

    public synchronized void b(Bitmap bitmap) {
        if (bitmap != null) {
            if (!bitmap.isRecycled()) {
                Bitmap bitmap2 = this.v;
                if (bitmap2 == null || bitmap2.hashCode() != bitmap.hashCode()) {
                    Bitmap bitmap3 = this.v;
                    if (bitmap3 != null) {
                        if (this.B == null && this.C == null && this.D == null && this.E == null) {
                            c(this.w);
                            this.w = this.v;
                        } else if (!g(bitmap3)) {
                            c(this.w);
                            this.w = this.v;
                        }
                    }
                    this.G = false;
                    this.v = bitmap;
                }
            }
        }
    }

    public void c(int i, int i2) throws RemoteException {
        if (this.J) {
            this.l = i;
            this.m = i2;
            return;
        }
        this.j = i;
        this.k = i2;
        this.l = i;
        this.m = i2;
    }

    public boolean a(int i, int i2) {
        Bitmap bitmap;
        GLMapState mapProjection = this.a.getMapProjection();
        if (this.n != null && mapProjection != null) {
            IPoint obtain = IPoint.obtain();
            if (this.a.getMapConfig() != null) {
                FPoint obtain2 = FPoint.obtain();
                FPoint fPoint = this.n;
                mapProjection.p20ToScreenPoint((int) ((PointF) fPoint).x, (int) ((PointF) fPoint).y, obtain2);
                ((Point) obtain).x = (int) ((PointF) obtain2).x;
                ((Point) obtain).y = (int) ((PointF) obtain2).y;
                obtain2.recycle();
            }
            int b = b();
            int c = c();
            int xVar = (int) ((com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain) + this.j) - (b * this.s));
            int yVar = (int) (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) + this.k + (c * (1.0f - this.t)));
            obtain.recycle();
            if (xVar - b > i || xVar < (-b) * 2 || yVar < (-c) * 2 || yVar - c > i2 || (bitmap = this.v) == null) {
                return false;
            }
            int width = bitmap.getWidth();
            int height = this.v.getHeight();
            if (this.r == null) {
                this.r = eq.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
            }
            int i3 = (int) ((1.0f - this.y) * 0.5d * width);
            float[] fArr = this.b;
            int i4 = xVar + i3;
            float f = i4;
            fArr[0] = f;
            Rect rect = this.x;
            rect.left = i4;
            int i5 = i2 - yVar;
            float f2 = i5;
            fArr[1] = f2;
            fArr[2] = 0.0f;
            int i6 = xVar + width;
            float f3 = i6 - i3;
            fArr[3] = f3;
            fArr[4] = f2;
            rect.top = yVar - height;
            fArr[5] = 0.0f;
            fArr[6] = f3;
            rect.right = i6;
            float f4 = i5 + height;
            fArr[7] = f4;
            rect.bottom = yVar;
            fArr[8] = 0.0f;
            fArr[9] = f;
            fArr[10] = f4;
            fArr[11] = 0.0f;
            FloatBuffer floatBuffer = this.o;
            if (floatBuffer == null) {
                this.o = eq.a(fArr);
            } else {
                this.o = eq.a(fArr, floatBuffer);
            }
            return true;
        }
        return false;
    }

    private void c(final boolean z) {
        GLAnimation gLAnimation = this.I;
        if (gLAnimation != null) {
            this.K = false;
            this.J = true;
            gLAnimation.startNow();
            this.I.setAnimationListener(new Animation.AnimationListener() { // from class: com.amap.api.mapcore.util.da.1
                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationEnd() {
                    if (da.this.H != null) {
                        da.this.J = true;
                        da.this.H.startNow();
                        da.this.b(z);
                    }
                }

                @Override // com.amap.api.maps.model.animation.Animation.AnimationListener
                public void onAnimationStart() {
                }
            });
            return;
        }
        GLAnimation gLAnimation2 = this.H;
        if (gLAnimation2 != null) {
            this.J = true;
            gLAnimation2.startNow();
            b(z);
            return;
        }
        b(z);
    }

    public void b(int i, int i2) {
        if (!this.q || this.n == null || this.v == null) {
            return;
        }
        e();
        this.v.isRecycled();
        if (!this.G && !this.v.isRecycled()) {
            try {
                int i3 = this.z;
                if (i3 != 0) {
                    GLES20.glDeleteTextures(1, new int[]{i3}, 0);
                } else {
                    this.z = k();
                }
                synchronized (this) {
                    Bitmap bitmap = this.v;
                    if (bitmap != null && !bitmap.isRecycled()) {
                        eq.b(this.z, this.v, false);
                        this.G = true;
                    }
                }
            } catch (Throwable th) {
                hd.c(th, "PopupOverlay", "drawMarker");
                th.printStackTrace();
                return;
            }
        }
        j();
        if (a(i, i2)) {
            Matrix.setIdentityM(this.d, 0);
            Matrix.orthoM(this.d, 0, 0.0f, i, 0.0f, i2, 1.0f, -1.0f);
            a(this.z, this.o, this.r);
            if (this.u) {
                this.u = false;
                o();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(boolean z) {
        if (z) {
            b(h());
        } else {
            b(i());
        }
    }

    private void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null || i == 0) {
            return;
        }
        if (this.c == null) {
            d();
        }
        this.c.a();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glEnableVertexAttribArray(this.c.b);
        GLES20.glVertexAttribPointer(this.c.b, 3, 5126, false, 12, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.c.c);
        GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
        GLES20.glUniformMatrix4fv(this.c.a, 1, false, this.d, 0);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glDisableVertexAttribArray(this.c.b);
        GLES20.glDisableVertexAttribArray(this.c.c);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        GLES20.glDisable(3042);
    }

    public void a(FPoint fPoint) {
        this.n = fPoint;
    }

    private Bitmap a(View view) {
        if (view == null) {
            return null;
        }
        if ((view instanceof RelativeLayout) && this.g != null) {
            LinearLayout linearLayout = new LinearLayout(this.g);
            linearLayout.setOrientation(1);
            linearLayout.addView(view);
            view = linearLayout;
        }
        view.setDrawingCacheEnabled(true);
        view.setDrawingCacheQuality(0);
        return eq.a(view);
    }
}
