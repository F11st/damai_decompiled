package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.mapcore.util.C4505de;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.taobao.weex.common.Constants;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cs implements IGroundOverlayDelegate {
    float[] a;
    C4505de.C4508c b;
    private IAMapDelegate c;
    private BitmapDescriptor d;
    private LatLng e;
    private float f;
    private float g;
    private LatLngBounds h;
    private float i;
    private float j;
    private boolean k;
    private float l;
    private float m;
    private float n;
    private float o;
    private String p;
    private FloatBuffer q;
    private FloatBuffer r;
    private int s;
    private boolean t;
    private boolean u;
    private List<C4645x> v;
    private C4637r w;

    public cs(IAMapDelegate iAMapDelegate, C4637r c4637r) {
        this(iAMapDelegate);
        this.w = c4637r;
    }

    private void a() {
        LatLng latLng = this.e;
        if (latLng == null) {
            return;
        }
        double cos = this.f / ((Math.cos(latLng.latitude * 0.01745329251994329d) * 6371000.79d) * 0.01745329251994329d);
        double d = this.g / 111194.94043265979d;
        try {
            LatLng latLng2 = this.e;
            LatLng latLng3 = new LatLng(latLng2.latitude - ((1.0f - this.o) * d), latLng2.longitude - (this.n * cos));
            LatLng latLng4 = this.e;
            this.h = new LatLngBounds(latLng3, new LatLng(latLng4.latitude + (this.o * d), latLng4.longitude + ((1.0f - this.n) * cos)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    private synchronized void b() {
        LatLngBounds latLngBounds = this.h;
        if (latLngBounds == null) {
            return;
        }
        LatLng latLng = latLngBounds.southwest;
        LatLng latLng2 = latLngBounds.northeast;
        double d = latLng.latitude;
        double d2 = d + ((1.0f - this.o) * (latLng2.latitude - d));
        double d3 = latLng.longitude;
        LatLng latLng3 = new LatLng(d2, d3 + (this.n * (latLng2.longitude - d3)));
        this.e = latLng3;
        this.f = (float) (Math.cos(latLng3.latitude * 0.01745329251994329d) * 6371000.79d * (latLng2.longitude - latLng.longitude) * 0.01745329251994329d);
        this.g = (float) ((latLng2.latitude - latLng.latitude) * 6371000.79d * 0.01745329251994329d);
        c();
    }

    private synchronized void c() {
        if (this.h == null) {
            return;
        }
        this.a = new float[16];
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        IPoint obtain3 = IPoint.obtain();
        IPoint obtain4 = IPoint.obtain();
        LatLng latLng = this.h.southwest;
        GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        LatLngBounds latLngBounds = this.h;
        GLMapState.lonlat2Geo(latLngBounds.northeast.longitude, latLngBounds.southwest.latitude, obtain2);
        LatLng latLng2 = this.h.northeast;
        GLMapState.lonlat2Geo(latLng2.longitude, latLng2.latitude, obtain3);
        LatLngBounds latLngBounds2 = this.h;
        GLMapState.lonlat2Geo(latLngBounds2.southwest.longitude, latLngBounds2.northeast.latitude, obtain4);
        if (this.i != 0.0f) {
            double xVar = Point.getx(obtain2) - Point.getx(obtain);
            double yVar = Point.gety(obtain2) - Point.gety(obtain3);
            DPoint obtain5 = DPoint.obtain();
            obtain5.x = Point.getx(obtain) + (this.n * xVar);
            obtain5.y = Point.gety(obtain) - ((1.0f - this.o) * yVar);
            a(obtain5, 0.0d, 0.0d, xVar, yVar, obtain);
            a(obtain5, xVar, 0.0d, xVar, yVar, obtain2);
            a(obtain5, xVar, yVar, xVar, yVar, obtain3);
            a(obtain5, 0.0d, yVar, xVar, yVar, obtain4);
            obtain5.recycle();
        }
        float[] fArr = this.a;
        int xVar2 = Point.getx(obtain);
        fArr[0] = xVar2 / 10000;
        int yVar2 = Point.gety(obtain);
        fArr[1] = yVar2 / 10000;
        fArr[2] = xVar2 % 10000;
        fArr[3] = yVar2 % 10000;
        int xVar3 = Point.getx(obtain2);
        fArr[4] = xVar3 / 10000;
        int yVar3 = Point.gety(obtain2);
        fArr[5] = yVar3 / 10000;
        fArr[6] = xVar3 % 10000;
        fArr[7] = yVar3 % 10000;
        int xVar4 = Point.getx(obtain3);
        fArr[8] = xVar4 / 10000;
        int yVar4 = Point.gety(obtain3);
        fArr[9] = yVar4 / 10000;
        fArr[10] = xVar4 % 10000;
        fArr[11] = yVar4 % 10000;
        int xVar5 = Point.getx(obtain4);
        fArr[12] = xVar5 / 10000;
        int yVar5 = Point.gety(obtain4);
        fArr[13] = yVar5 / 10000;
        fArr[14] = xVar5 % 10000;
        fArr[15] = yVar5 % 10000;
        FloatBuffer floatBuffer = this.q;
        if (floatBuffer == null) {
            this.q = eq.a(fArr);
        } else {
            this.q = eq.a(fArr, floatBuffer);
        }
        obtain4.recycle();
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
    }

    private void d() {
        BitmapDescriptor bitmapDescriptor = this.d;
        if (bitmapDescriptor == null && (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null)) {
            return;
        }
        int width = this.d.getWidth();
        int height = this.d.getHeight();
        int height2 = this.d.getBitmap().getHeight();
        float width2 = width / this.d.getBitmap().getWidth();
        float f = height / height2;
        this.r = eq.a(new float[]{0.0f, f, width2, f, width2, 0.0f, 0.0f, 0.0f});
    }

    private void e() {
        C4637r c4637r;
        List<C4645x> list = this.v;
        if (list != null) {
            for (C4645x c4645x : list) {
                if (c4645x != null && (c4637r = this.w) != null) {
                    c4637r.a(c4645x);
                }
            }
            this.v.clear();
        }
    }

    private int f() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void g() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate != null) {
            this.b = (C4505de.C4508c) iAMapDelegate.getGLShader(2);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        synchronized (this) {
            if (this.a != null) {
                return false;
            }
            this.u = false;
            if (this.e == null) {
                b();
                return true;
            } else if (this.h == null) {
                a();
                return true;
            } else {
                c();
                return true;
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        Bitmap bitmap;
        try {
            remove();
            List<C4645x> list = this.v;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.v.size(); i++) {
                    C4645x c4645x = this.v.get(i);
                    if (c4645x != null) {
                        C4637r c4637r = this.w;
                        if (c4637r != null) {
                            c4637r.a(c4645x);
                        }
                        IAMapDelegate iAMapDelegate = this.c;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.removeTextureItem(c4645x.p());
                        }
                    }
                }
                this.v.clear();
            }
            BitmapDescriptor bitmapDescriptor = this.d;
            if (bitmapDescriptor != null && (bitmap = bitmapDescriptor.getBitmap()) != null) {
                eq.b(bitmap);
                this.d = null;
            }
            FloatBuffer floatBuffer = this.r;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.r = null;
            }
            synchronized (this) {
                FloatBuffer floatBuffer2 = this.q;
                if (floatBuffer2 != null) {
                    floatBuffer2.clear();
                    this.q = null;
                }
                this.h = null;
            }
            this.e = null;
        } catch (Throwable th) {
            hd.c(th, "GroundOverlayDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x0019 A[Catch: all -> 0x0053, DONT_GENERATE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:9:0x000f, B:15:0x0019, B:17:0x001b), top: B:42:0x0001 }] */
    /* JADX WARN: Removed duplicated region for block: B:17:0x001b A[Catch: all -> 0x0053, DONT_GENERATE, TRY_LEAVE, TryCatch #1 {, blocks: (B:3:0x0001, B:5:0x0007, B:7:0x000b, B:9:0x000f, B:15:0x0019, B:17:0x001b), top: B:42:0x0001 }] */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(com.autonavi.base.amap.mapcore.MapConfig r4) throws android.os.RemoteException {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r4 = r3.k     // Catch: java.lang.Throwable -> L53
            r0 = 0
            r1 = 1
            if (r4 == 0) goto L16
            com.amap.api.maps.model.LatLng r4 = r3.e     // Catch: java.lang.Throwable -> L53
            if (r4 != 0) goto Lf
            com.amap.api.maps.model.LatLngBounds r4 = r3.h     // Catch: java.lang.Throwable -> L53
            if (r4 == 0) goto L16
        Lf:
            com.amap.api.maps.model.BitmapDescriptor r4 = r3.d     // Catch: java.lang.Throwable -> L53
            if (r4 != 0) goto L14
            goto L16
        L14:
            r4 = 0
            goto L17
        L16:
            r4 = 1
        L17:
            if (r4 == 0) goto L1b
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L53
            return
        L1b:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L53
            r3.calMapFPoint()
            boolean r4 = r3.t
            if (r4 != 0) goto L34
            int r4 = android.os.Build.VERSION.SDK_INT
            r2 = 12
            if (r4 < r2) goto L2a
            r0 = 1
        L2a:
            com.amap.api.maps.model.BitmapDescriptor r4 = r3.d
            int r4 = r3.a(r0, r4)
            r3.s = r4
            r3.t = r1
        L34:
            float r4 = r3.f
            r0 = 0
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L42
            float r4 = r3.g
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L42
            return
        L42:
            monitor-enter(r3)
            int r4 = r3.s     // Catch: java.lang.Throwable -> L50
            java.nio.FloatBuffer r0 = r3.q     // Catch: java.lang.Throwable -> L50
            java.nio.FloatBuffer r2 = r3.r     // Catch: java.lang.Throwable -> L50
            r3.a(r4, r0, r2)     // Catch: java.lang.Throwable -> L50
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L50
            r3.u = r1
            return
        L50:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L50
            throw r4
        L53:
            r4 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L53
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cs.draw(com.autonavi.base.amap.mapcore.MapConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getBearing() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLngBounds getBounds() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getHeight() throws RemoteException {
        return this.g;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.p == null) {
            this.p = this.c.createId("GroundOverlay");
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public LatLng getPosition() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getTransparency() throws RemoteException {
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public float getWidth() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate
    public void reLoadTexture() {
        this.t = false;
        this.s = 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.c.removeGLOverlay(getId());
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate
    public void setAnchor(float f, float f2) throws RemoteException {
        this.n = f;
        this.o = f2;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setBearing(float f) throws RemoteException {
        float f2 = ((f % 360.0f) + 360.0f) % 360.0f;
        if (Math.abs(this.i - f2) > 1.0E-7d) {
            this.i = f2;
            c();
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f) throws RemoteException {
        if (f <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width must be non-negative");
        }
        if (this.t && this.f != f) {
            this.f = f;
            this.g = f;
            a();
        } else {
            this.f = f;
            this.g = f;
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setImage(BitmapDescriptor bitmapDescriptor) throws RemoteException {
        if (bitmapDescriptor == null || bitmapDescriptor.getBitmap() == null || bitmapDescriptor.getBitmap().isRecycled()) {
            return;
        }
        this.d = bitmapDescriptor;
        d();
        if (this.t) {
            this.t = false;
        }
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPosition(LatLng latLng) throws RemoteException {
        this.e = latLng;
        a();
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setPositionFromBounds(LatLngBounds latLngBounds) throws RemoteException {
        if (latLngBounds == null) {
            return;
        }
        this.h = latLngBounds;
        b();
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setTransparency(float f) throws RemoteException {
        this.l = (float) Math.min(1.0d, Math.max(0.0d, f));
        this.m = 1.0f - f;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.c.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) throws RemoteException {
        this.j = f;
        this.c.changeGLOverlayIndex();
        this.c.setRunLowFrame(false);
    }

    private cs(IAMapDelegate iAMapDelegate) {
        this.k = true;
        this.l = 0.0f;
        this.m = 1.0f;
        this.n = 0.5f;
        this.o = 0.5f;
        this.q = null;
        this.t = false;
        this.u = false;
        this.v = new ArrayList();
        this.a = null;
        this.c = iAMapDelegate;
        try {
            this.p = getId();
        } catch (RemoteException e) {
            hd.c(e, "GroundOverlayDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private void a(DPoint dPoint, double d, double d2, double d3, double d4, IPoint iPoint) {
        double d5 = d - (d3 * this.n);
        double d6 = (d4 * (1.0f - this.o)) - d2;
        double d7 = (-this.i) * 0.01745329251994329d;
        ((android.graphics.Point) iPoint).x = (int) (dPoint.x + (Math.cos(d7) * d5) + (Math.sin(d7) * d6));
        ((android.graphics.Point) iPoint).y = (int) (dPoint.y + ((d6 * Math.cos(d7)) - (d5 * Math.sin(d7))));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IGroundOverlay
    public void setDimensions(float f, float f2) throws RemoteException {
        if (f <= 0.0f || f2 <= 0.0f) {
            Log.w("GroundOverlayDelegateImp", "Width and Height must be non-negative");
        }
        if (this.t && this.f != f && this.g != f2) {
            this.f = f;
            this.g = f2;
            a();
        } else {
            this.f = f;
            this.g = f2;
        }
        this.c.setRunLowFrame(false);
    }

    private void a(C4645x c4645x) {
        if (c4645x != null) {
            this.v.add(c4645x);
            c4645x.m();
        }
    }

    private int a(boolean z, BitmapDescriptor bitmapDescriptor) {
        C4645x c4645x;
        e();
        if (z) {
            c4645x = this.w.a(bitmapDescriptor);
            if (c4645x != null) {
                int k = c4645x.k();
                a(c4645x);
                return k;
            }
        } else {
            c4645x = null;
        }
        int i = 0;
        if (c4645x == null) {
            c4645x = new C4645x(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            i = f();
            c4645x.a(i);
            if (z) {
                this.c.addTextureItem(c4645x);
            }
            a(c4645x);
            eq.b(i, bitmap, true);
        }
        return i;
    }

    private void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null) {
            return;
        }
        C4505de.C4508c c4508c = this.b;
        if (c4508c == null || c4508c.c()) {
            g();
        }
        this.b.a();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        float f = this.m;
        GLES20.glBlendColor(f * 1.0f, f * 1.0f, f * 1.0f, f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glEnableVertexAttribArray(this.b.b);
        GLES20.glVertexAttribPointer(this.b.b, 4, 5126, false, 16, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.b.c);
        GLES20.glVertexAttribPointer(this.b.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
        GLES20.glUniform4f(this.b.g, ((int) this.c.getMapConfig().getSX()) / 10000, ((int) this.c.getMapConfig().getSY()) / 10000, ((int) this.c.getMapConfig().getSX()) % 10000, ((int) this.c.getMapConfig().getSY()) % 10000);
        int i2 = this.b.h;
        float f2 = this.m;
        GLES20.glUniform4f(i2, f2 * 1.0f, f2 * 1.0f, 1.0f * f2, f2);
        GLES20.glUniformMatrix4fv(this.b.a, 1, false, this.c.getFinalMatrix(), 0);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisableVertexAttribArray(this.b.b);
        GLES20.glDisableVertexAttribArray(this.b.c);
        GLES20.glDisable(3042);
        GLES20.glUseProgram(0);
    }
}
