package com.amap.api.mapcore.util;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cv {
    ValueAnimator b;
    private IAMapDelegate e;
    private Marker f;
    private Circle g;
    private LatLng i;
    private double j;
    private Context k;
    private aa l;
    private MyLocationStyle h = new MyLocationStyle();
    private int m = 4;
    private boolean n = false;
    private boolean o = false;
    private boolean p = false;
    private boolean q = false;
    private boolean r = false;
    private boolean s = false;
    a a = null;
    Animator.AnimatorListener c = new Animator.AnimatorListener() { // from class: com.amap.api.mapcore.util.cv.1
        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            cv.this.j();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    };
    ValueAnimator.AnimatorUpdateListener d = new ValueAnimator.AnimatorUpdateListener() { // from class: com.amap.api.mapcore.util.cv.2
        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (cv.this.g != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    cv.this.g.setCenter(latLng);
                    cv.this.f.setPosition(latLng);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    };

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d = latLng.latitude;
            double d2 = f;
            double d3 = latLng.longitude;
            return new LatLng(d + ((latLng2.latitude - d) * d2), d3 + (d2 * (latLng2.longitude - d3)));
        }
    }

    public cv(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.k = applicationContext;
        this.e = iAMapDelegate;
        this.l = new aa(applicationContext, iAMapDelegate);
        a(4, true);
    }

    private void d(float f) {
        if (this.q) {
            float f2 = f % 360.0f;
            if (f2 > 180.0f) {
                f2 -= 360.0f;
            } else if (f2 < -180.0f) {
                f2 += 360.0f;
            }
            Marker marker = this.f;
            if (marker != null) {
                marker.setRotateAngle(-f2);
            }
        }
    }

    private void g() {
        this.l.b();
    }

    private void h() {
        b(0.0f);
    }

    private void i() {
        c(0.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        if (this.i != null && this.o) {
            if (this.p && this.n) {
                return;
            }
            this.n = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.i;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.e.animateCamera(ah.a(obtain));
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "moveMapToLocation");
                th.printStackTrace();
            }
        }
    }

    private void k() {
        MyLocationStyle myLocationStyle = this.h;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.h = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            m();
            return;
        }
        if (myLocationStyle.getMyLocationIcon() == null || this.h.getMyLocationIcon().getBitmap() == null) {
            this.h.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        m();
    }

    private void l() {
        Circle circle = this.g;
        if (circle != null) {
            try {
                this.e.removeGLOverlay(circle.getId());
            } catch (Throwable th) {
                hd.c(th, "MyLocationOverlay", "locationIconRemove");
                th.printStackTrace();
            }
            this.g = null;
        }
        Marker marker = this.f;
        if (marker != null) {
            marker.remove();
            this.f = null;
            this.l.a((Marker) null);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:43:0x0115 A[Catch: all -> 0x012a, TryCatch #0 {all -> 0x012a, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x0017, B:7:0x001c, B:9:0x002a, B:10:0x0035, B:12:0x0043, B:13:0x004e, B:15:0x005c, B:16:0x0067, B:18:0x006b, B:19:0x0070, B:20:0x007c, B:22:0x0081, B:23:0x0092, B:25:0x0096, B:27:0x00a4, B:30:0x00c5, B:32:0x00cd, B:35:0x00da, B:37:0x00e2, B:39:0x00fa, B:41:0x0111, B:43:0x0115, B:40:0x0106, B:29:0x00b4, B:44:0x011f), top: B:49:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void m() {
        /*
            Method dump skipped, instructions count: 310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cv.m():void");
    }

    public String e() throws RemoteException {
        Circle circle = this.g;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    public void f() {
        this.g = null;
        this.f = null;
    }

    private void c(float f) {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(ah.d(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public void a(MyLocationStyle myLocationStyle) {
        try {
            this.h = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.h.isMyLocationShowing()) {
                this.l.a(false);
                this.m = this.h.getMyLocationType();
                return;
            }
            k();
            Marker marker = this.f;
            if (marker == null && this.g == null) {
                return;
            }
            this.l.a(marker);
            a(this.h.getMyLocationType());
        } catch (Throwable th) {
            hd.c(th, "MyLocationOverlay", "setMyLocationStyle");
            th.printStackTrace();
        }
    }

    public void b() {
        aa aaVar;
        if (this.m != 3 || (aaVar = this.l) == null) {
            return;
        }
        aaVar.a();
    }

    private void b(float f) {
        IAMapDelegate iAMapDelegate = this.e;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            iAMapDelegate.moveCamera(ah.c(f));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public String d() {
        Marker marker = this.f;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public void c() throws RemoteException {
        l();
        if (this.l != null) {
            g();
            this.l = null;
        }
    }

    public MyLocationStyle a() {
        return this.h;
    }

    public void a(int i) {
        a(i, false);
    }

    private void a(int i, boolean z) {
        this.m = i;
        this.n = false;
        this.p = false;
        this.o = false;
        this.r = false;
        this.s = false;
        if (i == 1) {
            this.o = true;
            this.p = true;
            this.q = true;
        } else if (i == 2) {
            this.o = true;
            this.q = true;
        } else if (i == 3) {
            this.o = true;
            this.s = true;
        } else if (i == 4) {
            this.o = true;
            this.r = true;
        } else if (i == 5) {
            this.r = true;
        } else if (i == 7) {
            this.s = true;
        }
        if (!this.r && !this.s) {
            Marker marker = this.f;
            if (marker != null) {
                marker.setFlat(false);
            }
            i();
            h();
            g();
            return;
        }
        if (this.s) {
            this.l.a(true);
            if (!z) {
                try {
                    this.e.moveCamera(ah.a(17.0f));
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            b(45.0f);
        } else {
            this.l.a(false);
        }
        this.l.a();
        Marker marker2 = this.f;
        if (marker2 != null) {
            marker2.setFlat(true);
        }
    }

    public void a(Location location) {
        if (location == null) {
            return;
        }
        a(this.h.isMyLocationShowing());
        if (this.h.isMyLocationShowing()) {
            this.i = new LatLng(com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLatitude(location), com.alibaba.wireless.security.aopsdk.replace.android.location.Location.getLongitude(location));
            this.j = location.getAccuracy();
            if (this.f == null && this.g == null) {
                k();
            }
            Circle circle = this.g;
            if (circle != null) {
                try {
                    double d = this.j;
                    if (d != -1.0d) {
                        circle.setRadius(d);
                    }
                } catch (Throwable th) {
                    hd.c(th, "MyLocationOverlay", "setCentAndRadius");
                    th.printStackTrace();
                }
            }
            d(location.getBearing());
            if (!this.i.equals(this.f.getPosition())) {
                a(this.i);
            } else {
                j();
            }
        }
    }

    public void a(boolean z) {
        Circle circle = this.g;
        if (circle != null && circle.isVisible() != z) {
            this.g.setVisible(z);
        }
        Marker marker = this.f;
        if (marker == null || marker.isVisible() == z) {
            return;
        }
        this.f.setVisible(z);
    }

    public void a(float f) {
        Marker marker = this.f;
        if (marker != null) {
            marker.setRotateAngle(f);
        }
    }

    private void a(LatLng latLng) {
        LatLng position = this.f.getPosition();
        if (position == null) {
            position = new LatLng(0.0d, 0.0d);
        }
        if (this.a == null) {
            this.a = new a();
        }
        ValueAnimator valueAnimator = this.b;
        if (valueAnimator == null) {
            ValueAnimator ofObject = ValueAnimator.ofObject(new a(), position, latLng);
            this.b = ofObject;
            ofObject.addListener(this.c);
            this.b.addUpdateListener(this.d);
        } else {
            valueAnimator.setObjectValues(position, latLng);
            this.b.setEvaluator(this.a);
        }
        if (position.latitude == 0.0d && position.longitude == 0.0d) {
            this.b.setDuration(1L);
        } else {
            this.b.setDuration(1000L);
        }
        this.b.start();
    }
}
