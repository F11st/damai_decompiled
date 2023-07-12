package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.RemoteException;
import android.util.Log;
import android.view.animation.AnimationUtils;
import com.amap.api.maps.AMapException;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.animation.GLAnimation;
import com.autonavi.amap.mapcore.animation.GLAnimationSet;
import com.autonavi.amap.mapcore.animation.GLTransformation;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.amap.mapcore.interfaces.IMarkerAction;
import com.autonavi.amap.mapcore.interfaces.IOverlayImage;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.autonavi.base.amap.mapcore.interfaces.IAnimation;
import com.taobao.weex.common.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cu extends BaseOverlayImp implements IMarkerAction, IMarkerDelegate, IAnimation {
    private static int i;
    private MarkerOptions D;
    private float P;
    private float Q;
    private x T;
    private String W;
    private LatLng X;
    private LatLng Y;
    private String Z;
    float[] a;
    private String aa;
    private u af;
    private Object ag;
    private int aq;
    private int ar;
    float[] b;
    GLAnimation f;
    GLAnimation g;
    private boolean j;
    private float k;
    private int v;
    private int w;
    private boolean l = false;
    private boolean m = false;
    private boolean n = false;
    private float o = 0.0f;
    private float p = 0.0f;
    private boolean q = false;
    private int r = 0;
    private int s = 0;
    private int t = 0;
    private int u = 0;
    private FPoint x = FPoint.obtain();
    private float[] y = {-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    private float z = 0.0f;
    private float A = 1.0f;
    private float B = 1.0f;
    private float C = 1.0f;
    private boolean E = false;
    private boolean F = true;
    private int G = 5;
    private boolean H = true;
    private boolean I = true;
    private boolean J = false;
    private boolean K = false;
    private boolean L = false;
    private boolean M = true;
    private FPoint N = FPoint.obtain();
    private Point O = new Point();
    private int R = 0;
    private int S = 0;
    private x[] U = null;
    Rect c = new Rect(0, 0, 0, 0);
    private boolean V = false;
    private float ab = 0.5f;
    private float ac = 1.0f;
    private boolean ad = false;
    private boolean ae = true;
    private boolean ah = false;
    private List<BitmapDescriptor> ai = new CopyOnWriteArrayList();
    private boolean aj = false;
    private boolean ak = false;
    GLTransformation d = null;
    GLTransformation e = null;
    private boolean al = false;
    private boolean am = true;
    private int an = 0;
    private int ao = 20;
    private boolean ap = false;
    private long as = 0;
    Object h = new Object();
    private float at = Float.MAX_VALUE;
    private float au = Float.MIN_VALUE;
    private float av = Float.MIN_VALUE;
    private float aw = Float.MAX_VALUE;

    public cu(MarkerOptions markerOptions, u uVar) {
        this.af = uVar;
        setMarkerOptions(markerOptions);
    }

    private static String a(String str) {
        i++;
        return str + i;
    }

    private void c() {
        if (this.af.c() != null) {
            this.af.c().setRunLowFrame(false);
        }
    }

    private void d() {
        try {
            if (this.T.a()) {
                this.y[4] = this.T.d();
                this.y[5] = this.T.c();
                this.y[13] = this.T.b();
                this.y[14] = this.T.c();
                this.y[22] = this.T.b();
                this.y[23] = this.T.e();
                this.y[31] = this.T.d();
                this.y[32] = this.T.e();
            } else {
                this.y[4] = this.T.g();
                this.y[5] = this.T.i();
                this.y[13] = this.T.h();
                this.y[14] = this.T.i();
                this.y[22] = this.T.h();
                this.y[23] = this.T.f();
                this.y[31] = this.T.g();
                this.y[32] = this.T.f();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void e() {
        GLTransformation gLTransformation;
        GLAnimation gLAnimation;
        if (!this.M && (gLAnimation = this.f) != null && !gLAnimation.hasEnded()) {
            c();
            synchronized (this.h) {
                if (this.e == null || this.al) {
                    GLTransformation gLTransformation2 = new GLTransformation();
                    this.e = gLTransformation2;
                    gLTransformation2.scaleX = this.A;
                    gLTransformation2.scaleY = this.B;
                    gLTransformation2.rotate = this.o;
                    gLTransformation2.y = this.w;
                    gLTransformation2.x = this.v;
                    gLTransformation2.alpha = this.C;
                    this.al = false;
                }
                if (this.d == null) {
                    this.d = new GLTransformation();
                }
                this.d.clear();
                this.f.getTransformation(AnimationUtils.currentAnimationTimeMillis(), this.d);
                GLTransformation gLTransformation3 = this.d;
                if (gLTransformation3 != null) {
                    if (!Double.isNaN(gLTransformation3.scaleX) && !Double.isNaN(this.d.scaleY)) {
                        GLTransformation gLTransformation4 = this.d;
                        this.A = (float) gLTransformation4.scaleX;
                        this.B = (float) gLTransformation4.scaleY;
                    }
                    if (!Double.isNaN(this.d.rotate)) {
                        setRotateAngle((float) this.d.rotate);
                    }
                    if (!Double.isNaN(this.d.x) && !Double.isNaN(this.d.y)) {
                        GLTransformation gLTransformation5 = this.d;
                        a(gLTransformation5.x, gLTransformation5.y);
                    }
                    if (!Double.isNaN(this.d.alpha)) {
                        this.C = (float) this.d.alpha;
                    }
                }
            }
            this.n = true;
            this.am = false;
            return;
        }
        if (this.f != null && ((gLTransformation = this.d) != null || this.e != null)) {
            if (gLTransformation != null && !Double.isNaN(gLTransformation.scaleX) && !Double.isNaN(this.d.scaleY)) {
                GLTransformation gLTransformation6 = this.d;
                this.A = (float) gLTransformation6.scaleX;
                this.B = (float) gLTransformation6.scaleY;
            } else {
                GLTransformation gLTransformation7 = this.e;
                if (gLTransformation7 != null && !Double.isNaN(gLTransformation7.scaleX) && !Double.isNaN(this.e.scaleY)) {
                    double d = this.A;
                    GLTransformation gLTransformation8 = this.e;
                    double d2 = gLTransformation8.scaleX;
                    if (d != d2 || this.B != gLTransformation8.scaleY) {
                        this.A = (float) d2;
                        this.B = (float) gLTransformation8.scaleY;
                    }
                }
            }
            GLTransformation gLTransformation9 = this.d;
            if (gLTransformation9 != null && !Double.isNaN(gLTransformation9.rotate)) {
                setRotateAngle((float) this.d.rotate);
            } else {
                GLTransformation gLTransformation10 = this.e;
                if (gLTransformation10 != null && !Double.isNaN(gLTransformation10.rotate)) {
                    double d3 = this.o;
                    double d4 = this.e.rotate;
                    if (d3 != d4) {
                        setRotateAngle((float) d4);
                    }
                }
            }
            GLTransformation gLTransformation11 = this.d;
            if (gLTransformation11 != null && !Double.isNaN(gLTransformation11.x) && !Double.isNaN(this.d.y)) {
                GLTransformation gLTransformation12 = this.d;
                a(gLTransformation12.x, gLTransformation12.y);
            } else {
                GLTransformation gLTransformation13 = this.e;
                if (gLTransformation13 != null && !Double.isNaN(gLTransformation13.x) && !Double.isNaN(this.e.y)) {
                    double d5 = this.v;
                    GLTransformation gLTransformation14 = this.e;
                    double d6 = gLTransformation14.x;
                    if (d5 != d6 || this.w != gLTransformation14.y) {
                        a(d6, gLTransformation14.y);
                    }
                }
            }
            GLTransformation gLTransformation15 = this.d;
            if (gLTransformation15 != null && !Double.isNaN(gLTransformation15.alpha)) {
                this.C = (float) this.d.alpha;
            } else {
                GLTransformation gLTransformation16 = this.e;
                if (gLTransformation16 != null && !Double.isNaN(gLTransformation16.alpha)) {
                    double d7 = this.C;
                    double d8 = this.e.alpha;
                    if (d7 != d8) {
                        this.C = (float) d8;
                    }
                }
            }
        }
        this.M = true;
        this.d = null;
        this.e = null;
        List<BitmapDescriptor> list = this.ai;
        if (list == null || list.size() != 1) {
            return;
        }
        this.am = true;
    }

    private int f() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void g() {
        if (this.af.c() == null || this.af.c().getMapConfig() == null) {
            return;
        }
        this.P = this.af.c().getMapConfig().getMapPerPixelUnitLength() * getWidth();
        this.Q = this.af.c().getMapConfig().getMapPerPixelUnitLength() * getHeight();
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate
    public FPoint anchorUVoff() {
        FPoint obtain = FPoint.obtain();
        List<BitmapDescriptor> list = this.ai;
        if (list != null && list.size() != 0) {
            ((PointF) obtain).x = getWidth() * this.ab;
            ((PointF) obtain).y = getHeight() * this.ac;
        }
        return obtain;
    }

    public IPoint b() {
        if (this.X != null || this.ap) {
            FPoint obtain = FPoint.obtain();
            this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, obtain);
            return IPoint.obtain((int) ((PointF) obtain).x, (int) ((PointF) obtain).y);
        }
        return null;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean calFPoint() {
        try {
            u uVar = this.af;
            if (uVar != null && uVar.c() != null && this.af.c().getMapProjection() != null) {
                if (this.x == null) {
                    this.x = FPoint.obtain();
                }
                if (this.ap) {
                    IPoint obtain = IPoint.obtain();
                    this.af.c().getPixel2Geo(this.aq, this.ar, obtain);
                    this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                    this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                    obtain.recycle();
                    this.af.c().geo2Map(this.v, this.w, this.x);
                } else {
                    this.af.c().geo2Map(this.v, this.w, this.x);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean checkInBounds() {
        if (this.ap) {
            return true;
        }
        try {
            if (this.x != null) {
                if (this.M) {
                    Point point = this.O;
                    point.x = this.v;
                    point.y = this.w;
                    Rectangle geoRectangle = this.af.c().getMapConfig().getGeoRectangle();
                    if (geoRectangle.contains(this.v, this.w)) {
                        return true;
                    }
                    g();
                    int i2 = (int) (this.A * this.P);
                    int i3 = (int) (this.B * this.Q);
                    int i4 = (int) (this.v - (i2 * this.ab));
                    int i5 = (int) (this.w - (i3 * this.ac));
                    if (geoRectangle.contains(i4, i5)) {
                        return true;
                    }
                    return geoRectangle.isOverlap(i4, i5, i2, i3);
                }
                return true;
            }
            return false;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "checkInBounds");
            return false;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void destroy(boolean z) {
        try {
            this.V = true;
            if (z) {
                remove();
            }
            int i2 = 0;
            if (this.af != null) {
                int i3 = 0;
                while (true) {
                    x[] xVarArr = this.U;
                    if (xVarArr == null || i3 >= xVarArr.length) {
                        break;
                    }
                    x xVar = xVarArr[i3];
                    if (xVar != null) {
                        this.af.a(xVar);
                        this.af.c().removeTextureItem(xVar.p());
                    }
                    i3++;
                }
            }
            while (true) {
                List<BitmapDescriptor> list = this.ai;
                if (list == null || i2 >= list.size()) {
                    break;
                }
                this.ai.get(i2).recycle();
                i2++;
            }
            this.X = null;
            this.ag = null;
            this.U = null;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "MarkerDelegateImp destroy");
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void drawMarker(IAMapDelegate iAMapDelegate, float[] fArr, int i2, float f) {
        if (this.V || (this.X == null && !this.ap) || this.ai == null) {
            return;
        }
        try {
            if (!this.l) {
                this.as = System.currentTimeMillis();
                this.l = true;
            }
            if (this.ap && this.I) {
                IPoint obtain = IPoint.obtain();
                iAMapDelegate.getPixel2Geo(this.aq, this.ar, obtain);
                this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                obtain.recycle();
            }
            ((PointF) this.x).x = this.v - ((int) iAMapDelegate.getMapConfig().getSX());
            FPoint fPoint = this.x;
            float f2 = ((PointF) fPoint).x;
            if (f2 > 1.3421773E8f) {
                ((PointF) fPoint).x = f2 - 2.6843546E8f;
            } else if (f2 < -1.3421773E8f) {
                ((PointF) fPoint).x = f2 + 2.6843546E8f;
            }
            ((PointF) fPoint).y = this.w - ((int) iAMapDelegate.getMapConfig().getSY());
            int width = getWidth();
            int height = getHeight();
            e();
            a(iAMapDelegate, f, width, height);
            if (!this.J || !this.am) {
                d();
                this.J = true;
            }
            a(fArr, i2);
            if (this.n && isInfoWindowShown()) {
                this.af.c().redrawInfoWindow();
                if (System.currentTimeMillis() - this.as > 1000) {
                    this.n = false;
                }
            }
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "drawMarker");
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public boolean equalsRemote(IOverlayImage iOverlayImage) throws RemoteException {
        return equals(iOverlayImage) || iOverlayImage.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public float getAlpha() {
        return this.C;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public IPoint getAnchor() {
        IPoint b = b();
        if (b == null) {
            return null;
        }
        return b;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorU() {
        return this.ab;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getAnchorV() {
        return this.ac;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public synchronized BitmapDescriptor getBitmapDescriptor() {
        try {
            List<BitmapDescriptor> list = this.ai;
            if (list == null) {
                return null;
            }
            if (list.size() == 0) {
                a();
                this.ai.add(BitmapDescriptorFactory.defaultMarker());
            } else if (this.ai.get(0) == null) {
                this.ai.clear();
                return getBitmapDescriptor();
            }
            return this.ai.get(0);
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getBitmapDescriptor");
            th.printStackTrace();
            return null;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public int getDisplayLevel() {
        return this.G;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public IPoint getGeoPoint() {
        IPoint obtain = IPoint.obtain();
        if (this.ap) {
            this.af.c().getPixel2Geo(this.aq, this.ar, obtain);
            return obtain;
        }
        obtain.set(this.v, this.w);
        return obtain;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public FPoint getGeoPosition() {
        IPoint geoPoint = getGeoPoint();
        return FPoint.obtain(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(geoPoint), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(geoPoint));
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getHeight() {
        try {
            return this.S;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public IAnimation getIAnimation() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public IMarkerAction getIMarkerAction() {
        return this;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized ArrayList<BitmapDescriptor> getIcons() {
        List<BitmapDescriptor> list = this.ai;
        if (list == null || list.size() <= 0) {
            return null;
        }
        ArrayList<BitmapDescriptor> arrayList = new ArrayList<>();
        for (BitmapDescriptor bitmapDescriptor : this.ai) {
            arrayList.add(bitmapDescriptor);
        }
        return arrayList;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getId() {
        if (this.W == null) {
            this.W = a("Marker");
        }
        return this.W;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getInfoWindowOffsetX() {
        return this.r;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getInfoWindowOffsetY() {
        return this.s;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public Object getObject() {
        return this.ag;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public MarkerOptions getOptions() {
        return this.D;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public int getPeriod() {
        return this.ao;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public LatLng getPosition() {
        if (this.ap && this.x != null) {
            DPoint obtain = DPoint.obtain();
            IPoint obtain2 = IPoint.obtain();
            calFPoint();
            if (this.af.c() == null) {
                return this.X;
            }
            IAMapDelegate c = this.af.c();
            FPoint fPoint = this.x;
            c.map2Geo(((PointF) fPoint).x, ((PointF) fPoint).y, obtain2);
            GLMapState.geo2LonLat(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2), obtain);
            LatLng latLng = new LatLng(obtain.y, obtain.x);
            obtain2.recycle();
            obtain.recycle();
            return latLng;
        }
        return this.X;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getRealInfoWindowOffsetX() {
        return this.t;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getRealInfoWindowOffsetY() {
        return this.u;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public LatLng getRealPosition() {
        try {
            if (!this.ap) {
                return this.aj ? this.Y : this.X;
            }
            DPoint obtain = DPoint.obtain();
            this.af.c().getPixel2LatLng(this.aq, this.ar, obtain);
            double d = obtain.y;
            LatLng latLng = new LatLng(d, d);
            obtain.recycle();
            return latLng;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getRealPosition");
            return null;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public Rect getRect() {
        if (this.y == null) {
            this.c.set(0, 0, 0, 0);
            return this.c;
        }
        try {
            GLMapState mapProjection = this.af.c().getMapProjection();
            if (mapProjection == null) {
                return new Rect(0, 0, 0, 0);
            }
            int width = getWidth();
            int height = getHeight();
            FPoint obtain = FPoint.obtain();
            if (this.ap) {
                ((PointF) obtain).x = this.aq;
                ((PointF) obtain).y = this.ar;
            } else {
                mapProjection.p20ToScreenPoint(this.v, this.w, obtain);
            }
            Matrix.setIdentityM(this.a, 0);
            Matrix.rotateM(this.a, 0, -this.o, 0.0f, 0.0f, 1.0f);
            if (this.q) {
                Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSC(), 1.0f, 0.0f, 0.0f);
                Matrix.rotateM(this.a, 0, this.af.c().getMapConfig().getSR(), 0.0f, 0.0f, 1.0f);
            }
            float[] fArr = new float[4];
            float[] fArr2 = this.b;
            float f = -width;
            fArr2[0] = this.ab * f;
            float f2 = height;
            fArr2[1] = this.ac * f2;
            fArr2[2] = 0.0f;
            fArr2[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr2, 0);
            Rect rect = this.c;
            float f3 = ((PointF) obtain).x;
            float f4 = ((PointF) obtain).y;
            rect.set((int) (fArr[0] + f3), (int) (f4 - fArr[1]), (int) (f3 + fArr[0]), (int) (f4 - fArr[1]));
            float[] fArr3 = this.b;
            float f5 = width;
            fArr3[0] = (1.0f - this.ab) * f5;
            fArr3[1] = f2 * this.ac;
            fArr3[2] = 0.0f;
            fArr3[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr3, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr4 = this.b;
            fArr4[0] = f5 * (1.0f - this.ab);
            float f6 = -height;
            fArr4[1] = (1.0f - this.ac) * f6;
            fArr4[2] = 0.0f;
            fArr4[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr4, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            float[] fArr5 = this.b;
            fArr5[0] = f * this.ab;
            fArr5[1] = f6 * (1.0f - this.ac);
            fArr5[2] = 0.0f;
            fArr5[3] = 1.0f;
            Matrix.multiplyMV(fArr, 0, this.a, 0, fArr5, 0);
            this.c.union((int) (((PointF) obtain).x + fArr[0]), (int) (((PointF) obtain).y - fArr[1]));
            this.t = (int) (this.c.centerX() - ((PointF) obtain).x);
            this.u = (int) (this.c.top - ((PointF) obtain).y);
            obtain.recycle();
            return this.c;
        } catch (Throwable th) {
            hd.c(th, "MarkerDelegateImp", "getRect");
            th.printStackTrace();
            return new Rect(0, 0, 0, 0);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public float getRotateAngle() {
        c();
        return this.p;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getSnippet() {
        return this.aa;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public int getTextureId() {
        try {
            List<BitmapDescriptor> list = this.ai;
            if (list != null && list.size() > 0) {
                return this.T.k();
            }
            return 0;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public String getTitle() {
        return this.Z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public int getWidth() {
        try {
            return this.R;
        } catch (Throwable unused) {
            return 0;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public float getZIndex() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void hideInfoWindow() {
        if (isInfoWindowShown()) {
            this.af.b(this);
            c();
            this.m = false;
        }
        this.n = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isAllowLow() {
        return this.am;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isBelowMaskLayer() {
        return this.K;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isClickable() {
        return this.H;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isContains() {
        return this.af.c(this);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isDestory() {
        return this.V;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isDraggable() {
        return this.ad;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isFlat() {
        return this.q;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public boolean isInfoWindowAutoOverturn() {
        return this.E;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isInfoWindowEnable() {
        return this.F;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isInfoWindowShown() {
        return this.m;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public boolean isOnTap() {
        return this.L;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isPerspective() {
        return this.ah;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public boolean isRemoved() {
        try {
            return !this.af.c(this);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public boolean isViewMode() {
        return this.ap;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public boolean isVisible() {
        return this.ae;
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x0057 A[Catch: all -> 0x00e7, TryCatch #2 {, blocks: (B:54:0x00e2, B:55:0x00e5, B:5:0x0005, B:7:0x000a, B:9:0x000e, B:11:0x0012, B:12:0x0017, B:13:0x001a, B:15:0x0021, B:19:0x0033, B:20:0x003a, B:22:0x0040, B:24:0x0048, B:26:0x004e, B:30:0x0057, B:32:0x005e, B:34:0x0064, B:36:0x006a, B:38:0x0082, B:40:0x008b, B:41:0x008e, B:42:0x0092, B:44:0x009a, B:47:0x00c3, B:45:0x00b7, B:48:0x00c6, B:49:0x00d1, B:51:0x00d9, B:53:0x00de, B:52:0x00dc), top: B:65:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0082 A[Catch: all -> 0x00e7, TryCatch #2 {, blocks: (B:54:0x00e2, B:55:0x00e5, B:5:0x0005, B:7:0x000a, B:9:0x000e, B:11:0x0012, B:12:0x0017, B:13:0x001a, B:15:0x0021, B:19:0x0033, B:20:0x003a, B:22:0x0040, B:24:0x0048, B:26:0x004e, B:30:0x0057, B:32:0x005e, B:34:0x0064, B:36:0x006a, B:38:0x0082, B:40:0x008b, B:41:0x008e, B:42:0x0092, B:44:0x009a, B:47:0x00c3, B:45:0x00b7, B:48:0x00c6, B:49:0x00d1, B:51:0x00d9, B:53:0x00de, B:52:0x00dc), top: B:65:0x0005 }] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0092 A[Catch: all -> 0x00e7, TryCatch #2 {, blocks: (B:54:0x00e2, B:55:0x00e5, B:5:0x0005, B:7:0x000a, B:9:0x000e, B:11:0x0012, B:12:0x0017, B:13:0x001a, B:15:0x0021, B:19:0x0033, B:20:0x003a, B:22:0x0040, B:24:0x0048, B:26:0x004e, B:30:0x0057, B:32:0x005e, B:34:0x0064, B:36:0x006a, B:38:0x0082, B:40:0x008b, B:41:0x008e, B:42:0x0092, B:44:0x009a, B:47:0x00c3, B:45:0x00b7, B:48:0x00c6, B:49:0x00d1, B:51:0x00d9, B:53:0x00de, B:52:0x00dc), top: B:65:0x0005 }] */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void loadTexture(com.autonavi.base.amap.api.mapcore.IAMapDelegate r13) {
        /*
            Method dump skipped, instructions count: 245
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cu.loadTexture(com.autonavi.base.amap.api.mapcore.IAMapDelegate):void");
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public synchronized void reLoadTexture() {
        this.ak = false;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public boolean remove() {
        c();
        this.ae = false;
        u uVar = this.af;
        if (uVar != null) {
            return uVar.a((IOverlayImageDelegate) this);
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void set2Top() {
        this.af.a((IMarkerDelegate) this);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAlpha(float f) {
        this.C = f;
        this.D.alpha(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setAnchor(float f, float f2) {
        if (this.ab == f && this.ac == f2) {
            return;
        }
        this.D.anchor(f, f2);
        this.ab = f;
        this.ac = f2;
        this.n = true;
        c();
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setAnimation(Animation animation) {
        IAnimation iAnimation = getIAnimation();
        if (iAnimation != null) {
            iAnimation.setAnimation(animation == null ? null : animation.glAnimation);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.base.amap.mapcore.interfaces.IAnimation
    public void setAnimationListener(Animation.AnimationListener animationListener) {
        GLAnimation gLAnimation = this.g;
        if (gLAnimation != null) {
            gLAnimation.setAnimationListener(animationListener);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setAutoOverturnInfoWindow(boolean z) {
        this.E = z;
        this.D.autoOverturnInfoWindow(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setBelowMaskLayer(boolean z) {
        this.K = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setClickable(boolean z) {
        this.H = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setDisplayLevel(int i2) {
        this.G = i2;
        this.D.displayLevel(i2);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setDraggable(boolean z) {
        this.ad = z;
        this.D.draggable(z);
        c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setFixingPointEnable(boolean z) {
        this.I = z;
        if (!z) {
            boolean z2 = this.ap;
            LatLng position = getPosition();
            this.X = position;
            setPosition(position);
            if (z2) {
                this.ap = true;
            }
        } else if (!this.ap || this.X == null) {
        } else {
            FPoint obtain = FPoint.obtain();
            this.af.c().getMapProjection().p20ToScreenPoint(this.v, this.w, obtain);
            this.aq = (int) ((PointF) obtain).x;
            this.ar = (int) ((PointF) obtain).y;
            obtain.recycle();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setFlat(boolean z) throws RemoteException {
        this.q = z;
        c();
        this.D.setFlat(z);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setGeoPoint(IPoint iPoint) {
        this.ap = false;
        a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(iPoint), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(iPoint));
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setIcon(BitmapDescriptor bitmapDescriptor) {
        if (bitmapDescriptor != null) {
            try {
                if (this.ai == null) {
                    return;
                }
                synchronized (this) {
                    this.j = false;
                    this.ai.clear();
                    this.ai.add(bitmapDescriptor);
                    this.J = false;
                    this.ak = false;
                    this.l = false;
                    c();
                    this.n = true;
                    this.R = bitmapDescriptor.getWidth();
                    this.S = bitmapDescriptor.getHeight();
                }
            } catch (Throwable th) {
                hd.c(th, "MarkerDelegateImp", "setIcon");
                th.printStackTrace();
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public synchronized void setIcons(ArrayList<BitmapDescriptor> arrayList) {
        if (arrayList != null) {
            try {
            } finally {
            }
            if (this.ai != null) {
                this.j = false;
                a(arrayList);
                this.ak = false;
                this.l = false;
                this.J = false;
                c();
                this.n = true;
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setInfoWindowEnable(boolean z) {
        this.F = z;
        if (!z) {
            hideInfoWindow();
        }
        this.D.infoWindowEnable(z);
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public void setInfoWindowOffset(int i2, int i3) throws RemoteException {
        this.r = i2;
        this.s = i3;
    }

    @Override // com.autonavi.base.amap.api.mapcore.InfoWindowCalculate
    public void setInfoWindowShown(boolean z) {
        this.m = z;
        this.n = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setMarkerOptions(MarkerOptions markerOptions) {
        if (markerOptions == null) {
            return;
        }
        this.D = markerOptions;
        this.X = markerOptions.getPosition();
        IPoint obtain = IPoint.obtain();
        this.aj = this.D.isGps();
        if (this.D.getPosition() != null) {
            if (this.aj) {
                try {
                    double[] a = jq.a(this.D.getPosition().longitude, this.D.getPosition().latitude);
                    this.Y = new LatLng(a[1], a[0]);
                    GLMapState.lonlat2Geo(a[0], a[1], obtain);
                } catch (Throwable th) {
                    hd.c(th, "MarkerDelegateImp", "create");
                    this.Y = this.D.getPosition();
                }
            } else {
                LatLng latLng = this.X;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
            }
        }
        this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
        this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
        this.ab = this.D.getAnchorU();
        this.ac = this.D.getAnchorV();
        this.r = this.D.getInfoWindowOffsetX();
        this.s = this.D.getInfoWindowOffsetY();
        this.ao = this.D.getPeriod();
        this.z = this.D.getZIndex();
        this.K = this.D.isBelowMaskLayer();
        calFPoint();
        setIcons(this.D.getIcons());
        this.j = this.D.isRotatingMode();
        this.k = this.D.getAngleOffset();
        this.ae = this.D.isVisible();
        this.aa = this.D.getSnippet();
        this.Z = this.D.getTitle();
        this.ad = this.D.isDraggable();
        this.W = getId();
        this.ah = this.D.isPerspective();
        this.q = this.D.isFlat();
        this.K = this.D.isBelowMaskLayer();
        this.C = this.D.getAlpha();
        setRotateAngle(this.D.getRotateAngle());
        this.G = this.D.getDisplayLevel();
        this.E = this.D.isInfoWindowAutoOverturn();
        this.F = this.D.isInfoWindowEnable();
        this.a = new float[16];
        this.b = new float[4];
        obtain.recycle();
        ea.a().a(this.X, this.Z, this.aa);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setObject(Object obj) {
        this.ag = obj;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate
    public void setOnTap(boolean z) {
        this.L = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPeriod(int i2) {
        if (i2 <= 1) {
            this.ao = 1;
        } else {
            this.ao = i2;
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPerspective(boolean z) {
        this.ah = z;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setPosition(LatLng latLng) {
        if (latLng == null) {
            hd.c(new AMapException("非法坐标值 latlng is null"), "setPosition", "Marker");
            return;
        }
        this.X = latLng;
        IPoint obtain = IPoint.obtain();
        if (this.aj) {
            try {
                double[] a = jq.a(latLng.longitude, latLng.latitude);
                this.Y = new LatLng(a[1], a[0]);
                GLMapState.lonlat2Geo(a[0], a[1], obtain);
            } catch (Throwable unused) {
                this.Y = latLng;
            }
        } else {
            GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
        }
        this.v = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
        this.w = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
        this.ap = false;
        calFPoint();
        c();
        this.n = true;
        obtain.recycle();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void setPositionByPixels(int i2, int i3) {
        this.aq = i2;
        this.ar = i3;
        this.ap = true;
        calFPoint();
        c();
        this.n = true;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setPositionNotUpdate(LatLng latLng) {
        setPosition(latLng);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setRotateAngle(float f) {
        this.D.rotateAngle(f);
        this.p = f;
        this.o = (((-f) % 360.0f) + 360.0f) % 360.0f;
        this.n = true;
        c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarkerAction
    public void setRotateAngleNotUpdate(float f) {
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setSnippet(String str) {
        this.aa = str;
        c();
        this.D.snippet(str);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setTitle(String str) {
        this.Z = str;
        c();
        this.D.title(str);
        ea.a().a(this.X, this.Z, this.aa);
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void setVisible(boolean z) {
        if (this.ae == z) {
            return;
        }
        this.D.visible(z);
        this.ae = z;
        if (!z) {
            this.L = false;
            if (isInfoWindowShown()) {
                this.af.b(this);
            }
        }
        c();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlayImage
    public void setZIndex(float f) {
        this.z = f;
        this.D.zIndex(f);
        if (this.L) {
            this.L = false;
            this.af.a();
        }
        this.af.f();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker
    public void showInfoWindow() {
        if (this.ae && isContains() && !isRemoved() && isInfoWindowEnable()) {
            this.af.a((BaseOverlayImp) this);
            c();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IMarker, com.autonavi.base.amap.mapcore.interfaces.IAnimation
    public boolean startAnimation() {
        if (this.g != null) {
            synchronized (this.h) {
                GLAnimation gLAnimation = this.g;
                if (gLAnimation instanceof GLAnimationSet) {
                    GLAnimationSet gLAnimationSet = (GLAnimationSet) gLAnimation;
                    for (GLAnimation gLAnimation2 : gLAnimationSet.getAnimations()) {
                        a(gLAnimation2);
                        gLAnimation2.setDuration(gLAnimationSet.getDuration());
                    }
                } else {
                    a(gLAnimation);
                }
                this.M = false;
                GLAnimation gLAnimation3 = this.g;
                this.f = gLAnimation3;
                this.al = true;
                gLAnimation3.start();
            }
            c();
        }
        return false;
    }

    synchronized void a() {
        List<BitmapDescriptor> list = this.ai;
        if (list != null) {
            list.clear();
        }
    }

    @Override // com.autonavi.base.amap.mapcore.interfaces.IAnimation
    public void setAnimation(GLAnimation gLAnimation) {
        if (gLAnimation == null) {
            return;
        }
        this.g = gLAnimation;
    }

    public synchronized void a(ArrayList<BitmapDescriptor> arrayList) {
        BitmapDescriptor bitmapDescriptor;
        a();
        if (arrayList != null) {
            Iterator<BitmapDescriptor> it = arrayList.iterator();
            while (it.hasNext()) {
                BitmapDescriptor next = it.next();
                if (next != null) {
                    this.ai.add(next);
                }
            }
        }
        if (this.ai.size() == 0) {
            this.ai.add(BitmapDescriptorFactory.defaultMarker());
        }
        if (this.ai.size() > 0 && (bitmapDescriptor = this.ai.get(0)) != null) {
            this.R = bitmapDescriptor.getWidth();
            this.S = bitmapDescriptor.getHeight();
        }
    }

    private void a(IAMapDelegate iAMapDelegate, float f, int i2, int i3) throws RemoteException {
        float f2 = ((int) (this.A * i2)) * f;
        float f3 = ((int) (this.B * i3)) * f;
        FPoint fPoint = this.x;
        float f4 = ((PointF) fPoint).x;
        float f5 = ((PointF) fPoint).y;
        float sc = iAMapDelegate.getMapConfig().getSC();
        float f6 = this.o;
        List<BitmapDescriptor> list = this.ai;
        if (list != null && list.size() > 0) {
            if (this.j) {
                x[] xVarArr = this.U;
                int length = xVarArr.length;
                float f7 = this.o;
                float f8 = this.k;
                int i4 = (int) (f7 / f8);
                if (i4 > length) {
                    i4 = 0;
                } else {
                    f6 = f7 % f8;
                }
                this.T = xVarArr[(i4 + length) % length];
            } else {
                this.an++;
                if (this.an >= this.ao * this.ai.size()) {
                    this.an = 0;
                }
                if (this.ao == 0) {
                    this.ao = 1;
                }
                this.T = this.U[this.an / this.ao];
                if (!this.am) {
                    c();
                }
            }
        }
        if (this.q) {
            f6 -= iAMapDelegate.getMapConfig().getSR();
            sc = 0.0f;
        }
        float f9 = this.C;
        float f10 = f9 >= 0.0f ? f9 : 0.0f;
        if (f10 > 1.0f) {
            f10 = 1.0f;
        }
        float[] fArr = this.y;
        float f11 = this.ab;
        fArr[0] = f4 - (f2 * f11);
        float f12 = this.ac;
        fArr[1] = ((1.0f - f12) * f3) + f5;
        fArr[2] = f4;
        fArr[3] = f5;
        fArr[6] = f6;
        fArr[7] = sc;
        fArr[8] = f10;
        fArr[9] = ((1.0f - f11) * f2) + f4;
        fArr[10] = ((1.0f - f12) * f3) + f5;
        fArr[11] = f4;
        fArr[12] = f5;
        fArr[15] = f6;
        fArr[16] = sc;
        fArr[17] = f10;
        fArr[18] = ((1.0f - f11) * f2) + f4;
        fArr[19] = f5 - (f3 * f12);
        fArr[20] = f4;
        fArr[21] = f5;
        fArr[24] = f6;
        fArr[25] = sc;
        fArr[26] = f10;
        fArr[27] = f4 - (f2 * f11);
        fArr[28] = f5 - (f3 * f12);
        fArr[29] = f4;
        fArr[30] = f5;
        fArr[33] = f6;
        fArr[34] = sc;
        fArr[35] = f10;
    }

    @Override // com.autonavi.base.amap.api.mapcore.BaseOverlayImp, com.autonavi.amap.mapcore.interfaces.IglModel
    public void destroy() {
        destroy(true);
    }

    private void a(float[] fArr, int i2) {
        x[] xVarArr = this.U;
        if (xVarArr == null || xVarArr.length <= 0) {
            return;
        }
        float[] fArr2 = this.y;
        System.arraycopy(fArr2, 0, fArr, i2, fArr2.length);
    }

    private void a(double d, double d2) {
        if (this.ap) {
            IPoint obtain = IPoint.obtain();
            this.af.c().getPixel2Geo((int) d, (int) d2, obtain);
            a(com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain), com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain));
            obtain.recycle();
            this.ap = true;
            return;
        }
        a((int) d, (int) d2);
    }

    private void a(int i2, int i3) {
        this.v = i2;
        this.w = i3;
        DPoint obtain = DPoint.obtain();
        GLMapState.geo2LonLat(this.v, this.w, obtain);
        this.X = new LatLng(obtain.y, obtain.x, false);
        u uVar = this.af;
        if (uVar != null && uVar.c() != null) {
            ((PointF) this.x).x = this.v - ((int) this.af.c().getMapConfig().getSX());
            ((PointF) this.x).y = this.w - ((int) this.af.c().getMapConfig().getSY());
        }
        obtain.recycle();
        c();
    }

    private void a(GLAnimation gLAnimation) {
        if (gLAnimation instanceof GLTranslateAnimation) {
            if (this.ap) {
                LatLng position = getPosition();
                this.X = position;
                setPosition(position);
                this.ap = true;
            }
            if (this.ap) {
                GLTranslateAnimation gLTranslateAnimation = (GLTranslateAnimation) gLAnimation;
                gLTranslateAnimation.mFromXDelta = this.aq;
                gLTranslateAnimation.mFromYDelta = this.ar;
                IPoint obtain = IPoint.obtain();
                this.af.c().getLatLng2Pixel(gLTranslateAnimation.mToYDelta, gLTranslateAnimation.mToXDelta, obtain);
                gLTranslateAnimation.mToXDelta = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain);
                gLTranslateAnimation.mToYDelta = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain);
                obtain.recycle();
                return;
            }
            GLTranslateAnimation gLTranslateAnimation2 = (GLTranslateAnimation) gLAnimation;
            gLTranslateAnimation2.mFromXDelta = this.v;
            gLTranslateAnimation2.mFromYDelta = this.w;
            IPoint obtain2 = IPoint.obtain();
            GLMapState.lonlat2Geo(gLTranslateAnimation2.mToXDelta, gLTranslateAnimation2.mToYDelta, obtain2);
            gLTranslateAnimation2.mToXDelta = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.getx(obtain2);
            gLTranslateAnimation2.mToYDelta = com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point.gety(obtain2);
            obtain2.recycle();
        }
    }

    private Bitmap a(Bitmap bitmap) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap.Config config = bitmap.getConfig();
        Bitmap.Config config2 = Bitmap.Config.ARGB_8888;
        return config != config2 ? bitmap.copy(config2, true) : bitmap;
    }
}
