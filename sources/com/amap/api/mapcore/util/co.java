package com.amap.api.mapcore.util;

import android.graphics.Color;
import android.graphics.PointF;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class co implements IArcDelegate {
    float a;
    float b;
    float c;
    float d;
    private LatLng e;
    private LatLng f;
    private LatLng g;
    private String l;
    private IAMapDelegate m;
    private float[] n;
    private float h = 10.0f;
    private int i = -16777216;
    private float j = 0.0f;
    private boolean k = true;
    private int o = 0;
    private boolean p = false;
    private double q = 0.0d;
    private double r = 0.0d;
    private double s = 0.0d;
    private double t = 0.0d;
    private double u = 0.0d;

    public co(IAMapDelegate iAMapDelegate) {
        this.m = iAMapDelegate;
        try {
            this.l = getId();
        } catch (RemoteException e) {
            hd.c(e, "ArcDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private FPoint a(GLMapState gLMapState, double d, double d2, double d3) {
        int cos = (int) (d2 + (Math.cos(d) * this.q));
        int i = (int) (d3 + ((-Math.sin(d)) * this.q));
        FPoint obtain = FPoint.obtain();
        MapConfig mapConfig = this.m.getMapConfig();
        if (mapConfig != null) {
            ((PointF) obtain).x = cos - ((int) mapConfig.getSX());
            ((PointF) obtain).y = i - ((int) mapConfig.getSY());
        }
        return obtain;
    }

    private void b() {
        this.n = new float[9];
        FPoint obtain = FPoint.obtain();
        IAMapDelegate iAMapDelegate = this.m;
        LatLng latLng = this.e;
        iAMapDelegate.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        FPoint obtain2 = FPoint.obtain();
        IAMapDelegate iAMapDelegate2 = this.m;
        LatLng latLng2 = this.f;
        iAMapDelegate2.getLatLng2Map(latLng2.latitude, latLng2.longitude, obtain2);
        FPoint obtain3 = FPoint.obtain();
        IAMapDelegate iAMapDelegate3 = this.m;
        LatLng latLng3 = this.g;
        iAMapDelegate3.getLatLng2Map(latLng3.latitude, latLng3.longitude, obtain3);
        FPoint[] fPointArr = {obtain, obtain2, obtain3};
        for (int i = 0; i < 3; i++) {
            float[] fArr = this.n;
            int i2 = i * 3;
            fArr[i2] = ((PointF) fPointArr[i]).x;
            fArr[i2 + 1] = ((PointF) fPointArr[i]).y;
            fArr[i2 + 2] = 0.0f;
        }
        this.o = 3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        int i;
        int i2;
        int i3;
        FPoint[] fPointArr;
        if (this.e == null || this.f == null || this.g == null || !this.k) {
            return false;
        }
        try {
            this.p = false;
            GLMapState mapProjection = this.m.getMapProjection();
            if (!a()) {
                b();
                return true;
            }
            DPoint obtain = DPoint.obtain(this.t, this.u);
            int abs = (int) ((Math.abs(this.s - this.r) * 180.0d) / 3.141592653589793d);
            if (abs == 0) {
                b();
                return true;
            }
            double d = (this.s - this.r) / abs;
            int i4 = abs + 1;
            FPoint[] fPointArr2 = new FPoint[i4];
            this.n = new float[i4 * 3];
            int i5 = 0;
            while (i5 <= abs) {
                if (i5 == abs) {
                    FPoint obtain2 = FPoint.obtain();
                    IAMapDelegate iAMapDelegate = this.m;
                    LatLng latLng = this.g;
                    iAMapDelegate.getLatLng2Map(latLng.latitude, latLng.longitude, obtain2);
                    fPointArr2[i5] = obtain2;
                    i3 = i4;
                    fPointArr = fPointArr2;
                    i = abs;
                    i2 = i5;
                } else {
                    i = abs;
                    i2 = i5;
                    i3 = i4;
                    fPointArr = fPointArr2;
                    fPointArr[i2] = a(mapProjection, (i5 * d) + this.r, obtain.x, obtain.y);
                }
                fPointArr[i2] = a(mapProjection, (i2 * d) + this.r, obtain.x, obtain.y);
                float[] fArr = this.n;
                int i6 = i2 * 3;
                fArr[i6] = ((PointF) fPointArr[i2]).x;
                fArr[i6 + 1] = ((PointF) fPointArr[i2]).y;
                fArr[i6 + 2] = 0.0f;
                i5 = i2 + 1;
                i4 = i3;
                fPointArr2 = fPointArr;
                abs = i;
            }
            obtain.recycle();
            this.o = i4;
            return true;
        } catch (Throwable th) {
            hd.c(th, "ArcDelegateImp", "calMapFPoint");
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.e = null;
            this.f = null;
            this.g = null;
        } catch (Throwable th) {
            hd.c(th, "ArcDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "ArcDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        if (this.e == null || this.f == null || this.g == null || !this.k) {
            return;
        }
        calMapFPoint();
        if (this.n != null && this.o > 0) {
            float mapLenWithWin = this.m.getMapProjection().getMapLenWithWin((int) this.h);
            this.m.getMapProjection().getMapLenWithWin(1);
            float[] fArr = this.n;
            AMapNativeRenderer.nativeDrawLineByTextureID(fArr, fArr.length, mapLenWithWin, this.m.getLineTextureID(), this.m.getLineTextureRatio(), this.b, this.c, this.d, this.a, 0.0f, false, true, false, this.m.getFinalMatrix(), 3, 0);
        }
        this.p = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.l == null) {
            this.l = this.m.createId("Arc");
        }
        return this.l;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public int getStrokeColor() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public float getStrokeWidth() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.j;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return 0;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.k;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.m.removeGLOverlay(getId());
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setEnd(LatLng latLng) {
        this.g = latLng;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setPassed(LatLng latLng) {
        this.f = latLng;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate
    public void setStart(LatLng latLng) {
        this.e = latLng;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeColor(int i) throws RemoteException {
        this.i = i;
        this.a = Color.alpha(i) / 255.0f;
        this.b = Color.red(i) / 255.0f;
        this.c = Color.green(i) / 255.0f;
        this.d = Color.blue(i) / 255.0f;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IArc
    public void setStrokeWidth(float f) throws RemoteException {
        this.h = f;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.k = z;
        this.m.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) throws RemoteException {
        this.j = f;
        this.m.changeGLOverlayIndex();
        this.m.setRunLowFrame(false);
    }

    private boolean a() {
        IPoint obtain = IPoint.obtain();
        IAMapDelegate iAMapDelegate = this.m;
        LatLng latLng = this.e;
        iAMapDelegate.latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        IAMapDelegate iAMapDelegate2 = this.m;
        LatLng latLng2 = this.f;
        iAMapDelegate2.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        IAMapDelegate iAMapDelegate3 = this.m;
        LatLng latLng3 = this.g;
        iAMapDelegate3.latlon2Geo(latLng3.latitude, latLng3.longitude, obtain3);
        double xVar = Point.getx(obtain);
        double yVar = Point.gety(obtain);
        double xVar2 = Point.getx(obtain2);
        double yVar2 = Point.gety(obtain2);
        double xVar3 = Point.getx(obtain3);
        double yVar3 = Point.gety(obtain3);
        double d = xVar2 - xVar;
        double d2 = yVar3 - yVar;
        double d3 = xVar3 - xVar;
        double d4 = yVar2 - yVar;
        double d5 = ((d * 2.0d) * d2) - ((d3 * 2.0d) * d4);
        double d6 = ((d4 * 2.0d) * d3) - ((2.0d * d2) * d);
        if (d5 == 0.0d || d6 == 0.0d) {
            return false;
        }
        double d7 = yVar2 * yVar2;
        double d8 = yVar * yVar;
        double d9 = xVar2 * xVar2;
        double d10 = xVar * xVar;
        double d11 = yVar3 * yVar3;
        double d12 = xVar3 * xVar3;
        double d13 = ((d2 * (((d7 - d8) + d9) - d10)) + (d4 * (((d8 - d11) + d10) - d12))) / d5;
        this.t = d13;
        this.u = ((d3 * (((d9 - d10) + d7) - d8)) + (d * (((d10 - d12) + d8) - d11))) / d6;
        if (Double.isNaN(d13) || Double.isNaN(this.u) || Double.isInfinite(this.t) || Double.isInfinite(this.u)) {
            return false;
        }
        double d14 = this.t;
        double d15 = (xVar - d14) * (xVar - d14);
        double d16 = this.u;
        this.q = Math.sqrt(d15 + ((yVar - d16) * (yVar - d16)));
        this.r = a(this.t, this.u, xVar, yVar);
        double a = a(this.t, this.u, xVar2, yVar2);
        double a2 = a(this.t, this.u, xVar3, yVar3);
        this.s = a2;
        double d17 = this.r;
        if (d17 < a2) {
            if (a <= d17 || a >= a2) {
                this.s = a2 - 6.283185307179586d;
            }
        } else if (a <= a2 || a >= d17) {
            this.s = a2 + 6.283185307179586d;
        }
        obtain.recycle();
        obtain2.recycle();
        obtain3.recycle();
        return true;
    }

    private double a(double d, double d2, double d3, double d4) {
        double d5 = (d2 - d4) / this.q;
        if (Math.abs(d5) > 1.0d) {
            d5 = Math.signum(d5);
        }
        double asin = Math.asin(d5);
        return asin >= 0.0d ? d3 < d ? 3.141592653589793d - Math.abs(asin) : asin : d3 < d ? 3.141592653589793d - asin : asin + 6.283185307179586d;
    }
}
