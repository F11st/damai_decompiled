package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.mapcore.util.fb;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.GL3DModel;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class fd extends ViewGroup implements IInfoWindowAction {
    fe a;
    C4479ar b;
    private IAMapDelegate c;
    private Context d;
    private fg e;
    private C4541fc f;
    private fa g;
    private ff h;
    private ez i;
    private fb j;
    private fh k;
    private View l;
    private BaseOverlayImp m;
    private Drawable n;
    private boolean o;
    private View p;
    private boolean q;
    private boolean r;
    private boolean s;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.fd$a */
    /* loaded from: classes10.dex */
    public static class C4542a extends ViewGroup.LayoutParams {
        public FPoint a;
        public int b;
        public int c;
        public int d;

        public C4542a(int i, int i2, FPoint fPoint, int i3, int i4, int i5) {
            super(i, i2);
            this.a = null;
            this.b = 0;
            this.c = 0;
            this.d = 51;
            this.a = fPoint;
            this.b = i3;
            this.c = i4;
            this.d = i5;
        }
    }

    public fd(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.n = null;
        int i = 1;
        this.o = true;
        this.r = true;
        this.s = true;
        try {
            this.c = iAMapDelegate;
            this.d = context;
            this.a = new fe();
            this.i = new ez(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.c.getGLMapView() != null) {
                addView(this.c.getGLMapView(), 0, layoutParams);
            } else {
                i = 0;
            }
            addView(this.i, i, layoutParams);
            if (this.r) {
                return;
            }
            a(context);
        } catch (Throwable th) {
            th.printStackTrace();
            eq.a(th);
        }
    }

    private void m() {
        ff ffVar = this.h;
        if (ffVar == null) {
            this.a.a(this, new Object[0]);
        } else if (ffVar == null || ffVar.getVisibility() != 0) {
        } else {
            this.h.postInvalidate();
        }
    }

    public void f(Boolean bool) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, bool);
        } else {
            fgVar.setVisibility(bool.booleanValue() ? 0 : 8);
        }
    }

    public void g(Boolean bool) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, bool);
        } else if (fgVar != null && bool.booleanValue()) {
            this.e.a(true);
        } else {
            fg fgVar2 = this.e;
            if (fgVar2 != null) {
                fgVar2.a(false);
            }
        }
    }

    public void h() {
        fh fhVar = this.k;
        if (fhVar != null) {
            fhVar.a();
        }
        ff ffVar = this.h;
        if (ffVar != null) {
            ffVar.a();
        }
        fg fgVar = this.e;
        if (fgVar != null) {
            fgVar.a();
        }
        C4541fc c4541fc = this.f;
        if (c4541fc != null) {
            c4541fc.a();
        }
        fa faVar = this.g;
        if (faVar != null) {
            faVar.a();
        }
        fb fbVar = this.j;
        if (fbVar != null) {
            fbVar.b();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void hideInfoWindow() {
        IAMapDelegate iAMapDelegate = this.c;
        if (iAMapDelegate == null || iAMapDelegate.getMainHandler() == null) {
            return;
        }
        this.c.getMainHandler().post(new Runnable() { // from class: com.amap.api.mapcore.util.fd.2
            @Override // java.lang.Runnable
            public void run() {
                if (fd.this.l != null) {
                    fd.this.l.clearFocus();
                    fd fdVar = fd.this;
                    fdVar.removeView(fdVar.l);
                    eq.a(fd.this.l.getBackground());
                    eq.a(fd.this.n);
                    fd.this.l = null;
                }
            }
        });
        BaseOverlayImp baseOverlayImp = this.m;
        if (baseOverlayImp != null) {
            baseOverlayImp.setInfoWindowShown(false);
        }
        this.m = null;
    }

    public void i() {
        hideInfoWindow();
        eq.a(this.n);
        h();
        removeAllViews();
        this.p = null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean isInfoWindowShown() {
        return false;
    }

    public void j() {
    }

    public void j(Boolean bool) {
        if (this.e == null) {
            this.a.a(this, bool);
            return;
        }
        bool.booleanValue();
        this.e.setVisibility(4);
    }

    public void k() {
        fa faVar = this.g;
        if (faVar == null) {
            this.a.a(this, new Object[0]);
        } else {
            faVar.b();
        }
    }

    public void l() {
        Context context;
        if (!this.r || (context = this.d) == null) {
            return;
        }
        a(context);
        fe feVar = this.a;
        if (feVar != null) {
            feVar.a();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.l == null || this.m == null || !eq.a(new Rect(this.l.getLeft(), this.l.getTop(), this.l.getRight(), this.l.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        try {
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                View childAt = getChildAt(i5);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof C4542a) {
                        a(childAt, (C4542a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            fg fgVar = this.e;
            if (fgVar != null) {
                fgVar.d();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void redrawInfoWindow() {
        try {
            BaseOverlayImp baseOverlayImp = this.m;
            if (baseOverlayImp != null && baseOverlayImp.checkInBounds()) {
                if (this.o) {
                    int realInfoWindowOffsetX = this.m.getRealInfoWindowOffsetX() + this.m.getInfoWindowOffsetX();
                    int realInfoWindowOffsetY = this.m.getRealInfoWindowOffsetY() + this.m.getInfoWindowOffsetY() + 2;
                    View a = a(this.m);
                    if (a == null) {
                        return;
                    }
                    a(a, realInfoWindowOffsetX, realInfoWindowOffsetY);
                    View view = this.l;
                    if (view != null) {
                        C4542a c4542a = (C4542a) view.getLayoutParams();
                        if (c4542a != null) {
                            c4542a.a = FPoint.obtain(((PointF) this.m.getGeoPosition()).x, ((PointF) this.m.getGeoPosition()).y);
                            c4542a.b = realInfoWindowOffsetX;
                            c4542a.c = realInfoWindowOffsetY;
                        }
                        onLayout(false, 0, 0, 0, 0);
                        if (this.b.a()) {
                            this.b.a(this.m.getTitle(), this.m.getSnippet());
                        }
                        if (this.l.getVisibility() == 8) {
                            this.l.setVisibility(0);
                            return;
                        }
                        return;
                    }
                    return;
                }
                return;
            }
            View view2 = this.l;
            if (view2 == null || view2.getVisibility() != 0) {
                return;
            }
            this.l.setVisibility(8);
        } catch (Throwable th) {
            hd.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void setInfoWindowAdapterManager(C4479ar c4479ar) {
        this.b = c4479ar;
    }

    @Override // com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction
    public void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp == null) {
            return;
        }
        try {
            C4479ar c4479ar = this.b;
            if (!(c4479ar != null && c4479ar.a() && baseOverlayImp.getTitle() == null && baseOverlayImp.getSnippet() == null) && baseOverlayImp.isInfoWindowEnable()) {
                BaseOverlayImp baseOverlayImp2 = this.m;
                if (baseOverlayImp2 != null && !baseOverlayImp2.getId().equals(baseOverlayImp.getId())) {
                    hideInfoWindow();
                }
                if (this.b != null) {
                    this.m = baseOverlayImp;
                    baseOverlayImp.setInfoWindowShown(true);
                    this.q = true;
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void b(Boolean bool) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, bool);
        } else {
            fhVar.a(bool.booleanValue());
        }
    }

    public void c(Boolean bool) {
        if (this.f == null) {
            this.a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.f.setVisibility(0);
        } else {
            this.f.setVisibility(8);
        }
    }

    public void d(Boolean bool) {
        fa faVar = this.g;
        if (faVar == null) {
            this.a.a(this, bool);
        } else {
            faVar.a(bool.booleanValue());
        }
    }

    public void e(Boolean bool) {
        ff ffVar = this.h;
        if (ffVar == null) {
            this.a.a(this, bool);
        } else {
            ffVar.a(bool.booleanValue());
        }
    }

    private void a(Context context) {
        fg fgVar = new fg(context, this.c);
        this.e = fgVar;
        fgVar.c(this.s);
        this.h = new ff(context, this.c);
        this.j = new fb(context);
        this.k = new fh(context, this.c);
        this.f = new C4541fc(context, this.c);
        this.g = new fa(context, this.c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.e, layoutParams);
        addView(this.h, layoutParams);
        addView(this.j, new ViewGroup.LayoutParams(-2, -2));
        addView(this.k, new C4542a(-2, -2, new FPoint(0.0f, 0.0f), 0, 0, 83));
        addView(this.f, new C4542a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 83));
        addView(this.g, new C4542a(-2, -2, FPoint.obtain(0.0f, 0.0f), 0, 0, 51));
        this.g.setVisibility(8);
        this.c.setMapWidgetListener(new AMapWidgetListener() { // from class: com.amap.api.mapcore.util.fd.1
            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateCompassView() {
                if (fd.this.g == null) {
                    return;
                }
                fd.this.g.post(new Runnable() { // from class: com.amap.api.mapcore.util.fd.1.2
                    @Override // java.lang.Runnable
                    public void run() {
                        fd.this.g.b();
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateScaleView() {
                if (fd.this.h == null) {
                    return;
                }
                fd.this.h.post(new Runnable() { // from class: com.amap.api.mapcore.util.fd.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        fd.this.h.b();
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void invalidateZoomController(final float f) {
                if (fd.this.k == null) {
                    return;
                }
                fd.this.k.post(new Runnable() { // from class: com.amap.api.mapcore.util.fd.1.3
                    @Override // java.lang.Runnable
                    public void run() {
                        fd.this.k.a(f);
                    }
                });
            }

            @Override // com.autonavi.base.ae.gmap.listener.AMapWidgetListener
            public void setFrontViewVisibility(boolean z) {
            }
        });
        try {
            if (this.c.getUiSettings().isMyLocationButtonEnabled()) {
                return;
            }
            this.f.setVisibility(8);
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    public C4541fc f() {
        return this.f;
    }

    public void b(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.a(num.intValue());
            this.e.postInvalidate();
            m();
        }
    }

    public void d(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.c(num.intValue());
            m();
        }
    }

    public fb e() {
        return this.j;
    }

    public void i(Boolean bool) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, bool);
        } else {
            fbVar.a(bool.booleanValue());
        }
    }

    public void c(Integer num) {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, num);
        } else if (fgVar != null) {
            fgVar.b(num.intValue());
            m();
        }
    }

    public fg g() {
        return this.e;
    }

    public ez d() {
        return this.i;
    }

    public boolean b() {
        fg fgVar = this.e;
        if (fgVar != null) {
            return fgVar.e();
        }
        return false;
    }

    public void c() {
        fg fgVar = this.e;
        if (fgVar == null) {
            this.a.a(this, new Object[0]);
        } else if (fgVar != null) {
            fgVar.d();
        }
    }

    public void h(Boolean bool) {
        C4541fc c4541fc = this.f;
        if (c4541fc == null) {
            this.a.a(this, bool);
        } else {
            c4541fc.a(bool.booleanValue());
        }
    }

    public void a(Boolean bool) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, bool);
        } else if (fbVar != null && bool.booleanValue() && this.c.canShowIndoorSwitch()) {
            this.j.a(true);
        }
    }

    public void a(String str, Boolean bool, Integer num) {
        if (this.e == null) {
            this.a.a(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.e.b(bool.booleanValue());
        } else if (TextUtils.isEmpty(str)) {
        } else {
            this.e.a(str, num.intValue());
            this.e.d(bool.booleanValue());
        }
    }

    public void a(Float f) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, f);
        } else if (fhVar != null) {
            fhVar.a(f.floatValue());
        }
    }

    public void a(Integer num) {
        fh fhVar = this.k;
        if (fhVar == null) {
            this.a.a(this, num);
        } else if (fhVar != null) {
            fhVar.a(num.intValue());
        }
    }

    public float a(int i) {
        if (this.e != null) {
            m();
            return this.e.d(i);
        }
        return 0.0f;
    }

    public void a(Integer num, Float f) {
        fg fgVar = this.e;
        if (fgVar != null) {
            this.a.a(this, num, f);
        } else if (fgVar != null) {
            fgVar.a(num.intValue(), f.floatValue());
            m();
        }
    }

    public Point a() {
        fg fgVar = this.e;
        if (fgVar == null) {
            return null;
        }
        return fgVar.c();
    }

    public void a(CameraPosition cameraPosition) {
        if (this.e == null) {
            this.a.a(this, cameraPosition);
        } else if (this.c.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f) {
                LatLng latLng = cameraPosition.target;
                if (!ej.a(latLng.latitude, latLng.longitude)) {
                    this.e.setVisibility(8);
                    return;
                }
            }
            if (this.c.getMaskLayerType() == -1) {
                this.e.setVisibility(0);
            }
        }
    }

    public void a(boolean z) {
        fg fgVar = this.e;
        if (fgVar != null) {
            fgVar.c(z);
        }
        this.s = z;
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof fb) {
            a(view, iArr[0], iArr[1], 20, (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(this.c.getWaterMarkerPositon()) - 80) - iArr[1], 51);
        } else {
            a(view, iArr[0], iArr[1], 0, 0, 51);
        }
    }

    private void a(View view, C4542a c4542a) {
        int[] iArr = new int[2];
        a(view, ((ViewGroup.LayoutParams) c4542a).width, ((ViewGroup.LayoutParams) c4542a).height, iArr);
        if (view instanceof fh) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], getHeight(), c4542a.d);
        } else if (view instanceof C4541fc) {
            a(view, iArr[0], iArr[1], getWidth() - iArr[0], iArr[1], c4542a.d);
        } else if (view instanceof fa) {
            a(view, iArr[0], iArr[1], 0, 0, c4542a.d);
        } else if (c4542a.a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.c.getMapConfig();
            GLMapState mapProjection = this.c.getMapProjection();
            if (mapConfig != null && mapProjection != null) {
                FPoint obtain2 = FPoint.obtain();
                FPoint fPoint = c4542a.a;
                mapProjection.p20ToScreenPoint((int) ((PointF) fPoint).x, (int) ((PointF) fPoint).y, obtain2);
                ((Point) obtain).x = (int) ((PointF) obtain2).x;
                ((Point) obtain).y = (int) ((PointF) obtain2).y;
                obtain2.recycle();
            }
            int xVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain) + c4542a.b;
            ((Point) obtain).x = xVar;
            int yVar = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain) + c4542a.c;
            ((Point) obtain).y = yVar;
            a(view, iArr[0], iArr[1], xVar, yVar, c4542a.d);
            obtain.recycle();
        }
    }

    private View a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        View view;
        View view2;
        View view3;
        View view4;
        View view5 = null;
        if (baseOverlayImp instanceof cu) {
            Marker marker = new Marker((cu) baseOverlayImp);
            try {
                if (this.n == null) {
                    this.n = ef.a(this.d, "infowindow_bg.9.png");
                }
            } catch (Throwable th) {
                hd.c(th, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            try {
                if (this.q) {
                    view3 = this.b.a((BasePointOverlay) marker);
                    if (view3 == null) {
                        try {
                            view3 = this.b.b((BasePointOverlay) marker);
                        } catch (Throwable th2) {
                            th = th2;
                            view5 = view4;
                            hd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view5;
                        }
                    }
                    this.p = view3;
                    this.q = false;
                } else {
                    view3 = this.p;
                }
                if (view3 == null) {
                    if (!this.b.a()) {
                        return null;
                    }
                    view3 = this.b.a((BasePointOverlay) marker);
                }
                view5 = view3;
                if (view5 != null && view5.getBackground() == null) {
                    view5.setBackground(this.n);
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            try {
                if (this.n == null) {
                    this.n = ef.a(this.d, "infowindow_bg.9.png");
                }
            } catch (Throwable th4) {
                hd.c(th4, "MapOverlayViewGroup", "showInfoWindow decodeDrawableFromAsset");
                th4.printStackTrace();
            }
            try {
                GL3DModel gL3DModel = new GL3DModel((cr) baseOverlayImp);
                if (this.q) {
                    view = this.b.a(gL3DModel);
                    if (view == null) {
                        try {
                            view = this.b.b(gL3DModel);
                        } catch (Throwable th5) {
                            th = th5;
                            view5 = view2;
                            hd.c(th, "MapOverlayViewGroup", "getInfoWindow or getInfoContents");
                            th.printStackTrace();
                            return view5;
                        }
                    }
                    this.p = view;
                    this.q = false;
                } else {
                    view = this.p;
                }
                if (view == null) {
                    if (!this.b.a()) {
                        return null;
                    }
                    view = this.b.a(gL3DModel);
                }
                view5 = view;
                if (view5.getBackground() == null) {
                    view5.setBackground(this.n);
                }
                return view5;
            } catch (Throwable th6) {
                th = th6;
            }
        }
        return view5;
    }

    private void a(View view, int i, int i2) throws RemoteException {
        int i3;
        int i4;
        if (view == null) {
            return;
        }
        View view2 = this.l;
        if (view2 != null) {
            if (view == view2) {
                return;
            }
            view2.clearFocus();
            removeView(this.l);
        }
        this.l = view;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        this.l.setDrawingCacheEnabled(true);
        this.l.setDrawingCacheQuality(0);
        this.m.getRect();
        if (layoutParams != null) {
            int i5 = layoutParams.width;
            i4 = layoutParams.height;
            i3 = i5;
        } else {
            i3 = -2;
            i4 = -2;
        }
        addView(this.l, new C4542a(i3, i4, this.m.getGeoPosition(), i, i2, 81));
    }

    private void a(View view, int i, int i2, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i <= 0 || i2 <= 0) {
            view.measure(0, 0);
        }
        if (i == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i;
        }
        if (i2 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i2 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i2;
        }
    }

    private void a(View view, int i, int i2, int i3, int i4, int i5) {
        int i6;
        int i7 = i5 & 7;
        int i8 = i5 & 112;
        if (i7 == 5) {
            i3 -= i;
        } else if (i7 == 1) {
            i3 -= i / 2;
        }
        if (i8 == 80) {
            i4 -= i2;
        } else {
            if (i8 == 17) {
                i6 = i2 / 2;
            } else if (i8 == 16) {
                i4 /= 2;
                i6 = i2 / 2;
            }
            i4 -= i6;
        }
        view.layout(i3, i4, i3 + i, i4 + i2);
        if (view instanceof IGLSurfaceView) {
            this.c.changeSize(i, i2);
        }
    }

    public void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.l;
        if (view == null || this.m == null || (drawingCache = view.getDrawingCache(true)) == null) {
            return;
        }
        canvas.drawBitmap(drawingCache, this.l.getLeft(), this.l.getTop(), new Paint());
    }

    public void a(fb.InterfaceC4540a interfaceC4540a) {
        fb fbVar = this.j;
        if (fbVar == null) {
            this.a.a(this, interfaceC4540a);
            return;
        }
        fbVar.a(interfaceC4540a);
        Log.d("MapOverlayViewGroup", "setOnIndoorFloorSwitchListener");
    }
}
