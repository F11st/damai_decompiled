package com.amap.api.mapcore.util;

import android.opengl.GLES20;
import android.os.Handler;
import android.os.Looper;
import android.os.RemoteException;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.ArcOptions;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CircleOptions;
import com.amap.api.maps.model.GroundOverlayOptions;
import com.amap.api.maps.model.HeatMapLayerOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NavigateArrowOptions;
import com.amap.api.maps.model.PolygonOptions;
import com.amap.api.maps.model.PolylineOptions;
import com.amap.api.maps.model.particle.ParticleOverlayOptions;
import com.autonavi.amap.api.mapcore.overlays.IBuildingDelegate;
import com.autonavi.amap.api.mapcore.overlays.IParticleLatyer;
import com.autonavi.amap.mapcore.interfaces.IHeatMapLayer;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IArcDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ICircleDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IGroundOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.INavigateArrowDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolygonDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.youku.live.livesdk.wkit.component.Constants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class r implements IGlOverlayLayer {
    IAMapDelegate a;
    private de c;
    private int d = 0;
    private List<IOverlayDelegate> e = new Vector(500);
    private List<x> f = new ArrayList();
    private int[] g = new int[1];
    private volatile boolean h = false;
    private Handler i = new Handler(Looper.getMainLooper());
    private Runnable j = new Runnable() { // from class: com.amap.api.mapcore.util.r.1
        @Override // java.lang.Runnable
        public synchronized void run() {
            try {
                synchronized (r.this) {
                    if (r.this.e != null && r.this.e.size() > 0) {
                        Collections.sort(r.this.e, r.this.b);
                    }
                }
            } finally {
            }
        }
    };
    a b = new a();

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IOverlayDelegate iOverlayDelegate = (IOverlayDelegate) obj;
            IOverlayDelegate iOverlayDelegate2 = (IOverlayDelegate) obj2;
            if (iOverlayDelegate == null || iOverlayDelegate2 == null) {
                return 0;
            }
            try {
                if (iOverlayDelegate.getZIndex() > iOverlayDelegate2.getZIndex()) {
                    return 1;
                }
                return iOverlayDelegate.getZIndex() < iOverlayDelegate2.getZIndex() ? -1 : 0;
            } catch (Throwable th) {
                hd.c(th, "GlOverlayLayer", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public r(IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
    }

    private void i() {
        for (IOverlayDelegate iOverlayDelegate : this.e) {
            if (iOverlayDelegate != null && ((iOverlayDelegate instanceof cp) || (iOverlayDelegate instanceof ct))) {
                iOverlayDelegate.destroy();
            }
        }
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public boolean IsCircleContainPoint(CircleOptions circleOptions, LatLng latLng) {
        return false;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public boolean IsPolygonContainsPoint(PolygonOptions polygonOptions, LatLng latLng) {
        return false;
    }

    public de b() {
        return this.c;
    }

    public synchronized void c() {
        this.d = 0;
    }

    public synchronized void d() {
        try {
            for (IOverlayDelegate iOverlayDelegate : this.e) {
                iOverlayDelegate.destroy();
            }
            b(null);
        } finally {
        }
    }

    public synchronized void e() {
        this.h = true;
    }

    public void f() {
        synchronized (this.f) {
            for (int i = 0; i < this.f.size(); i++) {
                x xVar = this.f.get(i);
                if (xVar != null) {
                    xVar.n();
                    if (xVar.o() <= 0) {
                        this.g[0] = xVar.k();
                        GLES20.glDeleteTextures(1, this.g, 0);
                        xVar.a(0);
                        IAMapDelegate iAMapDelegate = this.a;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.removeTextureItem(xVar.p());
                        }
                    }
                }
            }
            this.f.clear();
        }
    }

    public IAMapDelegate g() {
        return this.a;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public int getCurrentParticleNum(String str) {
        return 0;
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public LatLng getNearestLatLng(PolylineOptions polylineOptions, LatLng latLng) {
        return null;
    }

    public float[] h() {
        IAMapDelegate iAMapDelegate = this.a;
        return iAMapDelegate != null ? iAMapDelegate.getFinalMatrix() : new float[16];
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public void prepareIcon(Object obj) {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public void processCircleHoleOption(CircleOptions circleOptions) {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public void processPolygonHoleOption(PolygonOptions polygonOptions) {
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public boolean removeOverlay(String str) throws RemoteException {
        return a(str, false);
    }

    @Override // com.amap.api.maps.interfaces.IGlOverlayLayer
    public void updateOption(String str, Object obj) {
    }

    public synchronized String a(String str) {
        this.d++;
        return str + this.d;
    }

    public synchronized void b(String str) {
        try {
            i();
        } catch (Throwable th) {
            hd.c(th, "GlOverlayLayer", Constants.TAG_CLEAR_STRING);
            th.printStackTrace();
        }
        if (str != null && str.trim().length() != 0) {
            IOverlayDelegate iOverlayDelegate = null;
            Iterator<IOverlayDelegate> it = this.e.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                IOverlayDelegate next = it.next();
                if (str.equals(next.getId())) {
                    iOverlayDelegate = next;
                    break;
                }
            }
            this.e.clear();
            if (iOverlayDelegate != null) {
                this.e.add(iOverlayDelegate);
            }
        }
        this.e.clear();
        c();
    }

    synchronized IOverlayDelegate c(String str) throws RemoteException {
        for (IOverlayDelegate iOverlayDelegate : this.e) {
            if (iOverlayDelegate != null && iOverlayDelegate.getId().equals(str)) {
                return iOverlayDelegate;
            }
        }
        return null;
    }

    public synchronized IBuildingDelegate a() throws RemoteException {
        cp cpVar;
        cpVar = new cp(this);
        cpVar.a(this.c);
        a(cpVar);
        return cpVar;
    }

    public synchronized IHeatMapLayer a(HeatMapLayerOptions heatMapLayerOptions) throws RemoteException {
        ct ctVar;
        ctVar = new ct(this);
        ctVar.a(this.c);
        ctVar.setOptions(heatMapLayerOptions);
        a(ctVar);
        return ctVar;
    }

    public void a(de deVar) {
        this.c = deVar;
    }

    public synchronized IPolylineDelegate a(PolylineOptions polylineOptions) throws RemoteException {
        if (polylineOptions == null) {
            return null;
        }
        cz czVar = new cz(this, polylineOptions);
        de deVar = this.c;
        if (deVar != null) {
            czVar.a(deVar);
        }
        a(czVar);
        return czVar;
    }

    public synchronized INavigateArrowDelegate a(NavigateArrowOptions navigateArrowOptions) throws RemoteException {
        if (navigateArrowOptions == null) {
            return null;
        }
        cw cwVar = new cw(this.a);
        cwVar.setTopColor(navigateArrowOptions.getTopColor());
        cwVar.setSideColor(navigateArrowOptions.getSideColor());
        cwVar.setPoints(navigateArrowOptions.getPoints());
        cwVar.setVisible(navigateArrowOptions.isVisible());
        cwVar.setWidth(navigateArrowOptions.getWidth());
        cwVar.setZIndex(navigateArrowOptions.getZIndex());
        cwVar.set3DModel(navigateArrowOptions.is3DModel());
        a(cwVar);
        return cwVar;
    }

    public synchronized IPolygonDelegate a(PolygonOptions polygonOptions) throws RemoteException {
        if (polygonOptions == null) {
            return null;
        }
        cy cyVar = new cy(this.a);
        cyVar.setFillColor(polygonOptions.getFillColor());
        cyVar.setPoints(polygonOptions.getPoints());
        cyVar.setHoleOptions(polygonOptions.getHoleOptions());
        cyVar.setVisible(polygonOptions.isVisible());
        cyVar.setStrokeWidth(polygonOptions.getStrokeWidth());
        cyVar.setStrokeColor(polygonOptions.getStrokeColor());
        cyVar.setZIndex(polygonOptions.getZIndex());
        cyVar.a(polygonOptions.getLineJoinType());
        cyVar.a(polygonOptions.isUsePolylineStroke());
        a(cyVar);
        return cyVar;
    }

    public synchronized ICircleDelegate a(CircleOptions circleOptions) throws RemoteException {
        if (circleOptions == null) {
            return null;
        }
        cq cqVar = new cq(this.a);
        cqVar.setFillColor(circleOptions.getFillColor());
        cqVar.setCenter(circleOptions.getCenter());
        cqVar.setVisible(circleOptions.isVisible());
        cqVar.setHoleOptions(circleOptions.getHoleOptions());
        cqVar.setStrokeWidth(circleOptions.getStrokeWidth());
        cqVar.setZIndex(circleOptions.getZIndex());
        cqVar.setStrokeColor(circleOptions.getStrokeColor());
        cqVar.setRadius(circleOptions.getRadius());
        cqVar.setDottedLineType(circleOptions.getStrokeDottedLineType());
        cqVar.a(circleOptions.isUsePolylineStroke());
        a(cqVar);
        return cqVar;
    }

    public synchronized IArcDelegate a(ArcOptions arcOptions) throws RemoteException {
        if (arcOptions == null) {
            return null;
        }
        co coVar = new co(this.a);
        coVar.setStrokeColor(arcOptions.getStrokeColor());
        coVar.setStart(arcOptions.getStart());
        coVar.setPassed(arcOptions.getPassed());
        coVar.setEnd(arcOptions.getEnd());
        coVar.setVisible(arcOptions.isVisible());
        coVar.setStrokeWidth(arcOptions.getStrokeWidth());
        coVar.setZIndex(arcOptions.getZIndex());
        a(coVar);
        return coVar;
    }

    public synchronized IGroundOverlayDelegate a(GroundOverlayOptions groundOverlayOptions) throws RemoteException {
        if (groundOverlayOptions == null) {
            return null;
        }
        cs csVar = new cs(this.a, this);
        csVar.setAnchor(groundOverlayOptions.getAnchorU(), groundOverlayOptions.getAnchorV());
        csVar.setDimensions(groundOverlayOptions.getWidth(), groundOverlayOptions.getHeight());
        csVar.setImage(groundOverlayOptions.getImage());
        csVar.setPosition(groundOverlayOptions.getLocation());
        csVar.setPositionFromBounds(groundOverlayOptions.getBounds());
        csVar.setBearing(groundOverlayOptions.getBearing());
        csVar.setTransparency(groundOverlayOptions.getTransparency());
        csVar.setVisible(groundOverlayOptions.isVisible());
        csVar.setZIndex(groundOverlayOptions.getZIndex());
        a(csVar);
        return csVar;
    }

    public synchronized IParticleLatyer a(ParticleOverlayOptions particleOverlayOptions) throws RemoteException {
        if (particleOverlayOptions == null) {
            return null;
        }
        cx cxVar = new cx(this);
        cxVar.a(particleOverlayOptions);
        a(cxVar);
        return cxVar;
    }

    private void a(IOverlayDelegate iOverlayDelegate) throws RemoteException {
        this.e.add(iOverlayDelegate);
        e();
    }

    public synchronized boolean a(String str, boolean z) throws RemoteException {
        IOverlayDelegate c = c(str);
        if (c != null) {
            if (z) {
                c.destroy();
            }
            return this.e.remove(c);
        }
        return false;
    }

    public synchronized void a(boolean z, int i) {
        MapConfig mapConfig;
        try {
            f();
            mapConfig = this.a.getMapConfig();
        } catch (Throwable th) {
            hd.c(th, "GlOverlayLayer", "draw");
        }
        if (mapConfig == null) {
            return;
        }
        if (this.h) {
            this.j.run();
            this.h = false;
        }
        int size = this.e.size();
        for (IOverlayDelegate iOverlayDelegate : this.e) {
            if (iOverlayDelegate.isVisible()) {
                if (size > 20) {
                    if (iOverlayDelegate.checkInBounds()) {
                        if (z) {
                            if (iOverlayDelegate.getZIndex() <= i) {
                                iOverlayDelegate.draw(mapConfig);
                            }
                        } else if (iOverlayDelegate.getZIndex() > i) {
                            iOverlayDelegate.draw(mapConfig);
                        }
                    }
                } else if (z) {
                    if (iOverlayDelegate.getZIndex() <= i) {
                        iOverlayDelegate.draw(mapConfig);
                    }
                } else if (iOverlayDelegate.getZIndex() > i) {
                    iOverlayDelegate.draw(mapConfig);
                }
            }
        }
    }

    public void a(x xVar) {
        synchronized (this.f) {
            if (xVar != null) {
                this.f.add(xVar);
            }
        }
    }

    public x a(BitmapDescriptor bitmapDescriptor) {
        IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate != null) {
            return iAMapDelegate.getTextureItem(bitmapDescriptor, true);
        }
        return null;
    }

    public synchronized IOverlayDelegate a(LatLng latLng) {
        for (IOverlayDelegate iOverlayDelegate : this.e) {
            if (iOverlayDelegate != null && iOverlayDelegate.isDrawFinish() && (iOverlayDelegate instanceof IPolylineDelegate) && ((IPolylineDelegate) iOverlayDelegate).contains(latLng)) {
                return iOverlayDelegate;
            }
        }
        return null;
    }

    public void a(boolean z) {
        IAMapDelegate iAMapDelegate = this.a;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(z);
        }
    }
}
