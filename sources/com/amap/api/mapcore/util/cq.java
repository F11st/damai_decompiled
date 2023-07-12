package com.amap.api.mapcore.util;

import android.graphics.PointF;
import android.opengl.GLES20;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.alimm.xadsdk.base.constant.AdConstants;
import com.amap.api.mapcore.util.de;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cq implements ICircleDelegate {
    private static int A = 256;
    private static int B = 20;
    private static double C = 1.0E10d;
    private static Object v = new Object();
    private static float z = 4.0075016E7f;
    private String i;
    private IAMapDelegate j;
    private FloatBuffer k;
    private List<BaseHoleOptions> p;
    private List<BaseHoleOptions> q;
    private int r;
    private int s;
    private FloatBuffer t;
    private FloatBuffer u;
    private de.e y;
    private LatLng b = null;
    private double c = 0.0d;
    private float d = 10.0f;
    private int e = -16777216;
    private int f = 0;
    private float g = 0.0f;
    private boolean h = true;
    private int l = 0;
    private boolean m = false;
    private IPoint n = IPoint.obtain();
    private FPoint o = FPoint.obtain();
    private int w = -1;
    float a = 0.0f;
    private boolean x = false;

    public cq(IAMapDelegate iAMapDelegate) {
        this.j = iAMapDelegate;
        try {
            this.i = getId();
        } catch (RemoteException e) {
            hd.c(e, "CircleDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private void b() {
        IAMapDelegate iAMapDelegate = this.j;
        if (iAMapDelegate != null) {
            this.y = (de.e) iAMapDelegate.getGLShader(3);
        }
    }

    private void c() throws RemoteException {
        MapConfig mapConfig = this.j.getMapConfig();
        List<BaseHoleOptions> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        GLES20.glClearStencil(0);
        GLES20.glStencilMask(255);
        GLES20.glClear(1024);
        GLES20.glFlush();
        GLES20.glEnable(2960);
        GLES20.glColorMask(false, false, false, false);
        GLES20.glStencilFunc(512, 1, 255);
        GLES20.glStencilOp(7681, 7680, 7680);
        for (int i = 0; i < this.p.size(); i++) {
            BaseHoleOptions baseHoleOptions = this.p.get(i);
            boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
            if (z2) {
                a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                this.j.changeGLOverlayIndex();
                a((CircleHoleOptions) baseHoleOptions);
            }
            if (this.t != null && this.r > 0) {
                de.e eVar = this.y;
                if (eVar == null || eVar.c()) {
                    b();
                }
                if (z2) {
                    dy.a(this.y, -1, this.f, this.t, getStrokeWidth(), this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), 3, 0, this.x, false);
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    dy.a(this.y, -1, -1, this.t, 10.0f, this.r, this.j.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), this.x, false);
                }
            }
        }
        GLES20.glColorMask(true, true, true, true);
        GLES20.glStencilFunc(517, 1, 255);
        GLES20.glStencilMask(0);
    }

    private void d() throws RemoteException {
        GLES20.glClearStencil(0);
        GLES20.glClear(1024);
        GLES20.glDisable(2960);
        MapConfig mapConfig = this.j.getMapConfig();
        List<BaseHoleOptions> list = this.p;
        if (list == null || list.size() <= 0) {
            return;
        }
        for (int i = 0; i < this.p.size(); i++) {
            BaseHoleOptions baseHoleOptions = this.p.get(i);
            boolean z2 = baseHoleOptions instanceof PolygonHoleOptions;
            if (z2) {
                a(a(((PolygonHoleOptions) baseHoleOptions).getPoints()), (int) mapConfig.getSX(), (int) mapConfig.getSY());
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                this.j.changeGLOverlayIndex();
                a((CircleHoleOptions) baseHoleOptions);
            }
            if (this.t != null && this.r > 0) {
                de.e eVar = this.y;
                if (eVar == null || eVar.c()) {
                    b();
                }
                if (z2) {
                    dy.a(this.y, 0, this.e, this.t, this.d, this.u, this.r, this.s, this.j.getFinalMatrix(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), mapConfig.getMapPerPixelUnitLength(), 3, 0, this.x);
                } else if (baseHoleOptions instanceof CircleHoleOptions) {
                    dy.a(this.y, 0, this.e, this.t, this.d, this.r, this.j.getFinalMatrix(), mapConfig.getMapPerPixelUnitLength(), this.j.getLineTextureID(), this.j.getLineTextureRatio(), this.x);
                }
            }
        }
    }

    void a() {
        this.l = 0;
        FloatBuffer floatBuffer = this.k;
        if (floatBuffer != null) {
            floatBuffer.clear();
        }
        this.j.setRunLowFrame(false);
        setHoleOptions(this.q);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        double d;
        IPoint iPoint;
        synchronized (v) {
            int i = 0;
            this.m = false;
            LatLng latLng = this.b;
            if (latLng != null) {
                float[] fArr = new float[1086];
                double b = b(latLng.latitude) * this.c;
                this.j.getMapProjection();
                ((PointF) this.o).x = Point.getx(this.n) - ((int) this.j.getMapConfig().getSX());
                ((PointF) this.o).y = Point.gety(this.n) - ((int) this.j.getMapConfig().getSY());
                FPoint fPoint = this.o;
                fArr[0] = ((PointF) fPoint).x;
                fArr[1] = ((PointF) fPoint).y;
                fArr[2] = 0.0f;
                while (i < 361) {
                    double xVar = Point.getx(this.n);
                    int yVar = (int) (Point.gety(iPoint) + (Math.cos((i * 3.141592653589793d) / 180.0d) * b));
                    ((PointF) this.o).x = ((int) (xVar + (Math.sin(d) * b))) - ((int) this.j.getMapConfig().getSX());
                    ((PointF) this.o).y = yVar - ((int) this.j.getMapConfig().getSY());
                    i++;
                    int i2 = i * 3;
                    FPoint fPoint2 = this.o;
                    fArr[i2] = ((PointF) fPoint2).x;
                    fArr[i2 + 1] = ((PointF) fPoint2).y;
                    fArr[i2 + 2] = 0.0f;
                }
                this.l = AdConstants.TEMPLATE_VIDEO_TOP_VIEW;
                this.k = eq.a(fArr);
            }
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        return true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public boolean contains(LatLng latLng) throws RemoteException {
        List<BaseHoleOptions> list = this.p;
        if (list != null && list.size() > 0) {
            for (BaseHoleOptions baseHoleOptions : this.p) {
                if (eq.a(baseHoleOptions, latLng)) {
                    return false;
                }
            }
        }
        return this.c >= ((double) AMapUtils.calculateLineDistance(this.b, latLng));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            this.b = null;
            FloatBuffer floatBuffer = this.k;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.k = null;
            }
            FloatBuffer floatBuffer2 = this.t;
            if (floatBuffer2 != null) {
                floatBuffer2.clear();
                this.t = null;
            }
            FloatBuffer floatBuffer3 = this.u;
            if (floatBuffer3 != null) {
                floatBuffer3.clear();
                this.u = null;
            }
            List<BaseHoleOptions> list = this.p;
            if (list != null) {
                list.clear();
            }
            List<BaseHoleOptions> list2 = this.q;
            if (list2 != null) {
                list2.clear();
            }
            this.p = null;
            this.q = null;
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "CircleDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public void draw(MapConfig mapConfig) throws RemoteException {
        if (this.b == null || this.c <= 0.0d || !this.h) {
            return;
        }
        calMapFPoint();
        c();
        if (this.k != null && this.l > 0) {
            de.e eVar = this.y;
            if (eVar == null || eVar.c()) {
                b();
            }
            this.a = this.j.getMapConfig().getMapPerPixelUnitLength();
            int dottedLineTextureID = this.j.getDottedLineTextureID(this.w);
            if (dottedLineTextureID == -1) {
                dottedLineTextureID = this.j.getLineTextureID();
            }
            dy.a(this.y, this.f, this.e, this.k, this.d, this.l, this.j.getFinalMatrix(), this.a, dottedLineTextureID, this.j.getLineTextureRatio(), this.x || (this.w != -1), true);
        }
        d();
        this.m = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public LatLng getCenter() throws RemoteException {
        return this.b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getDottedLineType() {
        return this.w;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getFillColor() throws RemoteException {
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public List<BaseHoleOptions> getHoleOptions() throws RemoteException {
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.i == null) {
            this.i = this.j.createId("Circle");
        }
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public double getRadius() throws RemoteException {
        return this.c;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public int getStrokeColor() throws RemoteException {
        return this.e;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public float getStrokeWidth() throws RemoteException {
        return this.d;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.g;
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
        return this.m;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.h;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.j.removeGLOverlay(getId());
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z2) {
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setCenter(LatLng latLng) throws RemoteException {
        synchronized (v) {
            if (latLng != null) {
                this.b = latLng;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, this.n);
                a();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setDottedLineType(int i) {
        this.w = i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setFillColor(int i) throws RemoteException {
        this.f = i;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setHoleOptions(List<BaseHoleOptions> list) {
        try {
            this.q = list;
            List<BaseHoleOptions> list2 = this.p;
            if (list2 == null) {
                this.p = new ArrayList();
            } else {
                list2.clear();
            }
            if (list != null) {
                for (int i = 0; i < list.size(); i++) {
                    BaseHoleOptions baseHoleOptions = list.get(i);
                    if (baseHoleOptions instanceof PolygonHoleOptions) {
                        PolygonHoleOptions polygonHoleOptions = (PolygonHoleOptions) baseHoleOptions;
                        if (a(polygonHoleOptions) && !eq.a(this.p, polygonHoleOptions)) {
                            this.p.add(polygonHoleOptions);
                        }
                    } else if (baseHoleOptions instanceof CircleHoleOptions) {
                        CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
                        if (b(circleHoleOptions) && !eq.a(this.p, circleHoleOptions)) {
                            this.p.add(circleHoleOptions);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "PolygonDelegateImp", "setHoleOptions");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setRadius(double d) throws RemoteException {
        this.c = d;
        a();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeColor(int i) throws RemoteException {
        this.e = i;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ICircle
    public void setStrokeWidth(float f) throws RemoteException {
        this.d = f;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z2) throws RemoteException {
        this.h = z2;
        this.j.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) throws RemoteException {
        this.g = f;
        this.j.changeGLOverlayIndex();
        this.j.setRunLowFrame(false);
    }

    private double b(double d) {
        return 1.0d / a(d);
    }

    private boolean b(CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), getCenter())) <= getRadius() - circleHoleOptions.getRadius();
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", "isCircleInCircle");
            th.printStackTrace();
            return true;
        }
    }

    private float a(double d) {
        return (float) ((Math.cos((d * 3.141592653589793d) / 180.0d) * z) / (A << B));
    }

    public void a(boolean z2) {
        this.x = z2;
    }

    private boolean a(PolygonHoleOptions polygonHoleOptions) {
        boolean z2 = true;
        try {
            List<LatLng> points = polygonHoleOptions.getPoints();
            for (int i = 0; i < points.size() && (z2 = contains(points.get(i))); i++) {
            }
        } catch (Throwable th) {
            hd.c(th, "CircleDelegateImp", "isPolygonInCircle");
            th.printStackTrace();
        }
        return z2;
    }

    static IPoint[] a(IPoint[] iPointArr) {
        int length = iPointArr.length;
        double[] dArr = new double[length * 2];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            double d = C;
            dArr[i2] = Point.getx(iPointArr[i]) * d;
            dArr[i2 + 1] = Point.gety(iPointArr[i]) * d;
        }
        em a = new dv().a(dArr);
        int i3 = a.b;
        IPoint[] iPointArr2 = new IPoint[i3];
        for (int i4 = 0; i4 < i3; i4++) {
            iPointArr2[i4] = new IPoint();
            ((android.graphics.Point) iPointArr2[i4]).x = (int) (dArr[a.a(i4) * 2] / C);
            ((android.graphics.Point) iPointArr2[i4]).y = (int) (dArr[(a.a(i4) * 2) + 1] / C);
        }
        return iPointArr2;
    }

    private void a(List<IPoint> list, int i, int i2) throws RemoteException {
        if (list.size() < 2) {
            return;
        }
        float[] fArr = new float[list.size() * 3];
        int size = list.size();
        IPoint[] iPointArr = new IPoint[size];
        int i3 = 0;
        for (IPoint iPoint : list) {
            int i4 = i3 * 3;
            fArr[i4] = Point.getx(iPoint) - i;
            fArr[i4 + 1] = Point.gety(iPoint) - i2;
            fArr[i4 + 2] = 0.0f;
            iPointArr[i3] = iPoint;
            i3++;
        }
        IPoint[] a = a(iPointArr);
        if (a.length == 0) {
            if (C == 1.0E10d) {
                C = 1.0E8d;
            } else {
                C = 1.0E10d;
            }
            a = a(iPointArr);
        }
        float[] fArr2 = new float[a.length * 3];
        int i5 = 0;
        for (IPoint iPoint2 : a) {
            int i6 = i5 * 3;
            fArr2[i6] = Point.getx(iPoint2) - i;
            fArr2[i6 + 1] = Point.gety(iPoint2) - i2;
            fArr2[i6 + 2] = 0.0f;
            i5++;
        }
        this.r = size;
        this.s = a.length;
        this.t = eq.a(fArr);
        this.u = eq.a(fArr2);
    }

    private List<IPoint> a(List<LatLng> list) throws RemoteException {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            LatLng latLng = null;
            for (LatLng latLng2 : list) {
                if (!latLng2.equals(latLng)) {
                    IPoint obtain = IPoint.obtain();
                    this.j.latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    latLng = latLng2;
                }
            }
            int size = arrayList.size();
            if (size > 1) {
                IPoint iPoint = (IPoint) arrayList.get(0);
                int i = size - 1;
                IPoint iPoint2 = (IPoint) arrayList.get(i);
                if (Point.getx(iPoint) == Point.getx(iPoint2) && Point.gety(iPoint) == Point.gety(iPoint2)) {
                    arrayList.remove(i);
                }
            }
        }
        if (eq.a(arrayList, 0, arrayList.size())) {
            Collections.reverse(arrayList);
        }
        return arrayList;
    }

    public void a(CircleHoleOptions circleHoleOptions) throws RemoteException {
        double d;
        if (circleHoleOptions.getCenter() != null) {
            IPoint obtain = IPoint.obtain();
            FPoint obtain2 = FPoint.obtain();
            GLMapState.lonlat2Geo(circleHoleOptions.getCenter().longitude, circleHoleOptions.getCenter().latitude, obtain);
            float[] fArr = new float[1086];
            double b = b(circleHoleOptions.getCenter().latitude) * circleHoleOptions.getRadius();
            ((PointF) obtain2).x = Point.getx(obtain) - ((int) this.j.getMapConfig().getSX());
            float yVar = Point.gety(obtain) - ((int) this.j.getMapConfig().getSY());
            ((PointF) obtain2).y = yVar;
            int i = 0;
            fArr[0] = ((PointF) obtain2).x;
            fArr[1] = yVar;
            fArr[2] = 0.0f;
            while (i < 361) {
                double xVar = Point.getx(obtain);
                int yVar2 = (int) (Point.gety(obtain) + (Math.cos((i * 3.141592653589793d) / 180.0d) * b));
                ((PointF) obtain2).x = ((int) (xVar + (Math.sin(d) * b))) - ((int) this.j.getMapConfig().getSX());
                float sy = yVar2 - ((int) this.j.getMapConfig().getSY());
                ((PointF) obtain2).y = sy;
                i++;
                int i2 = i * 3;
                fArr[i2] = ((PointF) obtain2).x;
                fArr[i2 + 1] = sy;
                fArr[i2 + 2] = 0.0f;
            }
            this.r = AdConstants.TEMPLATE_VIDEO_TOP_VIEW;
            this.t = eq.a(fArr);
            obtain.recycle();
            obtain2.recycle();
        }
    }
}
