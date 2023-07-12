package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Build;
import android.os.RemoteException;
import android.util.Log;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolylineOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IOverlay;
import com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate;
import com.autonavi.base.amap.mapcore.AMapNativePolyline;
import com.autonavi.base.amap.mapcore.AMapNativeRenderer;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FPoint3;
import com.autonavi.base.amap.mapcore.FPointBounds;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.autonavi.base.amap.mapcore.Rectangle;
import com.taobao.weex.common.Constants;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class cz implements IPolylineDelegate {
    private float K;
    private float L;
    private float M;
    private float N;
    private float[] Q;
    private int[] R;
    private int[] S;
    private PolylineOptions V;
    private C4505de Z;
    private C4637r e;
    private String f;
    private FloatBuffer p;
    private List<IPoint> g = new ArrayList();
    private List<FPoint> h = new ArrayList();
    private List<LatLng> i = new ArrayList();
    private List<BitmapDescriptor> j = new ArrayList();
    private List<C4645x> k = new ArrayList();
    private List<Integer> l = new ArrayList();
    private List<Integer> m = new ArrayList();
    private List<Integer> n = new ArrayList();
    private List<Integer> o = new ArrayList();
    private BitmapDescriptor q = null;
    private Object r = new Object();
    private boolean s = true;
    private boolean t = true;
    private boolean u = false;
    private boolean v = false;
    private boolean w = false;
    private boolean x = true;
    private boolean y = false;
    private boolean z = false;
    private boolean A = true;
    private int B = 0;
    private int C = 0;
    private float D = 1.0f;
    private int E = -16777216;
    private int F = 0;
    private int G = 0;
    private float H = 10.0f;
    private float I = 0.0f;
    private float J = 0.0f;
    private float O = 1.0f;
    private float P = 0.0f;
    private boolean T = false;
    private FPointBounds U = null;
    Rect a = null;
    private int W = 0;
    private PolylineOptions.LineJoinType X = PolylineOptions.LineJoinType.LineJoinBevel;
    private PolylineOptions.LineCapType Y = PolylineOptions.LineCapType.LineCapRound;
    private long aa = 0;
    private boolean ab = false;
    private float ac = -1.0f;
    private float ad = -1.0f;
    private float ae = -1.0f;
    private int af = -1;
    private List<IPoint> ag = new ArrayList();
    private boolean ah = false;
    int b = 0;
    ArrayList<FPoint> c = new ArrayList<>();
    long d = 0;

    public cz(C4637r c4637r, PolylineOptions polylineOptions) {
        this.e = c4637r;
        setOptions(polylineOptions);
        try {
            this.f = getId();
        } catch (RemoteException e) {
            hd.c(e, "PolylineDelegateImp", "create");
            e.printStackTrace();
        }
    }

    private void c(List<FPoint> list) throws RemoteException {
        int i;
        this.c.clear();
        int size = list.size();
        if (size < 2) {
            return;
        }
        int i2 = 0;
        FPoint fPoint = list.get(0);
        this.c.add(fPoint);
        int i3 = 1;
        while (true) {
            i = size - 1;
            if (i3 >= i) {
                break;
            }
            FPoint fPoint2 = list.get(i3);
            if (i3 != 1 && !a(fPoint, fPoint2)) {
                ArrayList<FPoint> arrayList = this.c;
                arrayList.set(arrayList.size() - 1, fPoint2);
            } else {
                this.c.add(fPoint2);
                fPoint = fPoint2;
            }
            i3++;
        }
        this.c.add(list.get(i));
        int size2 = this.c.size() * 3;
        this.b = size2;
        float[] fArr = this.Q;
        if (fArr == null || fArr.length < size2) {
            this.Q = new float[size2];
        }
        int i4 = this.B;
        if (i4 != 5 && i4 != 3 && i4 != 4) {
            Iterator<FPoint> it = this.c.iterator();
            while (it.hasNext()) {
                FPoint next = it.next();
                float[] fArr2 = this.Q;
                int i5 = i2 * 3;
                fArr2[i5] = ((PointF) next).x;
                fArr2[i5 + 1] = ((PointF) next).y;
                fArr2[i5 + 2] = 0.0f;
                i2++;
            }
            return;
        }
        int[] iArr = new int[this.c.size()];
        ArrayList arrayList2 = new ArrayList();
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < size2 / 3; i8++) {
            FPoint3 fPoint3 = (FPoint3) this.c.get(i8);
            float[] fArr3 = this.Q;
            int i9 = i8 * 3;
            fArr3[i9] = ((PointF) fPoint3).x;
            fArr3[i9 + 1] = ((PointF) fPoint3).y;
            fArr3[i9 + 2] = 0.0f;
            int i10 = fPoint3.colorIndex;
            if (i8 == 0) {
                arrayList2.add(Integer.valueOf(i10));
                i6 = i10;
            } else if (i10 != i6) {
                if (i10 != -1) {
                    i6 = i10;
                }
                arrayList2.add(Integer.valueOf(i6));
            }
            iArr[i7] = i8;
            i7++;
        }
        int[] iArr2 = new int[arrayList2.size()];
        this.R = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        this.n = arrayList2;
        this.o = arrayList2;
    }

    private void d(float f, MapConfig mapConfig) {
        List<FPoint> a;
        float[] fArr;
        int i;
        if (!this.w) {
            synchronized (this) {
                BitmapDescriptor bitmapDescriptor = this.q;
                if (bitmapDescriptor != null) {
                    C4645x a2 = a(Build.VERSION.SDK_INT >= 12, bitmapDescriptor, true);
                    if (a2 != null) {
                        i = a2.k();
                        this.D = a2.l();
                    } else {
                        i = 0;
                    }
                    this.C = i;
                    this.w = true;
                }
            }
        }
        try {
            if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                int i2 = this.W + 1;
                this.W = i2;
                if (i2 > 2) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f, this.C, this.D, this.L, this.M, this.N, this.K, 1.0f - this.O, false, false, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    return;
                }
            }
            this.W = 0;
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    a = eq.a(clipMapRect, this.h, false);
                }
                list = a;
            }
            if (list.size() >= 2) {
                c(list);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f, this.C, this.D, this.L, this.M, this.N, this.K, 1.0f - this.O, false, false, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
            }
        } catch (Throwable unused) {
        }
    }

    private void e(float f, MapConfig mapConfig) {
        float[] fArr;
        int i;
        if (!this.w) {
            synchronized (this) {
                BitmapDescriptor bitmapDescriptor = this.q;
                if (bitmapDescriptor != null) {
                    C4645x a = a(Build.VERSION.SDK_INT >= 12, bitmapDescriptor, true);
                    if (a != null) {
                        i = a.k();
                        this.D = a.l();
                    } else {
                        i = 0;
                    }
                    this.C = i;
                    this.w = true;
                }
            }
        }
        try {
            List<FPoint> list = this.h;
            if (this.e.g() == null) {
                return;
            }
            if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                int i2 = this.W + 1;
                this.W = i2;
                if (i2 > 2) {
                    AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f, this.e.g().getDottedLineTextureID(this.G), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, true, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                    return;
                }
            }
            this.W = 0;
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    list = eq.a(clipMapRect, this.h, false);
                }
            }
            if (list.size() >= 2) {
                c(list);
                AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f, this.e.g().getDottedLineTextureID(this.G), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, true, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
            }
        } catch (Throwable unused) {
        }
    }

    private void f(float f, MapConfig mapConfig) {
        float[] fArr;
        try {
            List<FPoint> list = this.h;
            if (this.e.g() == null) {
                return;
            }
            if (mapConfig.getChangeRatio() == 1.0d && (fArr = this.Q) != null) {
                int i = this.W + 1;
                this.W = i;
                if (i > 2) {
                    long j = this.aa;
                    if (j != 0 && this.Z != null) {
                        AMapNativePolyline.nativeDrawLineByTextureID(j, fArr, this.b, f, this.e.g().getLineTextureID(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                        return;
                    } else {
                        AMapNativeRenderer.nativeDrawLineByTextureID(fArr, this.b, f, this.e.g().getLineTextureID(), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                        return;
                    }
                }
            }
            this.W = 0;
            FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    list = eq.a(clipMapRect, this.h, false);
                }
            }
            if (list.size() >= 2) {
                c(list);
                long j2 = this.aa;
                if (j2 != 0 && this.Z != null) {
                    AMapNativePolyline.nativeDrawLineByTextureID(j2, this.Q, this.b, f, this.e.g().getLineTextureID(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                } else {
                    AMapNativeRenderer.nativeDrawLineByTextureID(this.Q, this.b, f, this.e.g().getLineTextureID(), this.e.g().getLineTextureRatio(), this.L, this.M, this.N, this.K, 0.0f, false, true, false, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void a(boolean z) {
        this.A = z;
        this.e.g().setRunLowFrame(false);
    }

    public boolean b(List<IPoint> list) {
        List<Integer> list2;
        synchronized (this.r) {
            FPointBounds.Builder builder = new FPointBounds.Builder();
            this.h.clear();
            this.z = false;
            float[] fArr = new float[list.size() * 3];
            this.Q = fArr;
            this.b = fArr.length;
            Iterator<IPoint> it = list.iterator();
            int i = 0;
            while (true) {
                boolean z = true;
                if (!it.hasNext()) {
                    break;
                }
                IPoint next = it.next();
                FPoint3 fPoint3 = new FPoint3();
                this.e.g().geo2Map(Point.getx(next), Point.gety(next), fPoint3);
                float[] fArr2 = this.Q;
                int i2 = i * 3;
                fArr2[i2] = ((PointF) fPoint3).x;
                fArr2[i2 + 1] = ((PointF) fPoint3).y;
                fArr2[i2 + 2] = 0.0f;
                List<Integer> list3 = this.l;
                if (list3 != null) {
                    synchronized (list3) {
                        List<Integer> list4 = this.l;
                        if (list4 == null || list4.size() <= i) {
                            z = false;
                        } else {
                            int i3 = this.af;
                            if (i3 <= 0) {
                                fPoint3.setColorIndex(this.l.get(i).intValue());
                            } else if (i3 + i < this.l.size()) {
                                fPoint3.setColorIndex(this.l.get(this.af + i).intValue());
                            }
                        }
                    }
                    synchronized (this.m) {
                        if (!z && (list2 = this.m) != null && list2.size() > i) {
                            int i4 = this.af;
                            if (i4 <= 0) {
                                fPoint3.setColorIndex(this.m.get(i).intValue());
                            } else if (i4 + i < this.m.size()) {
                                fPoint3.setColorIndex(this.m.get(this.af + i).intValue());
                            }
                        }
                    }
                }
                this.h.add(fPoint3);
                builder.include(fPoint3);
                i++;
            }
            this.U = builder.build();
            if (!this.A) {
                this.p = eq.a(this.Q);
            }
            this.F = list.size();
            a();
        }
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean calMapFPoint() throws RemoteException {
        if (this.ac == -1.0f && this.ad == -1.0f && this.ae == -1.0f) {
            b(this.g);
            return true;
        }
        b(this.ag);
        return true;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean checkInBounds() {
        if (this.ab) {
            return true;
        }
        Rectangle geoRectangle = this.e.g().getMapConfig().getGeoRectangle();
        Rect rect = this.a;
        return rect == null || geoRectangle == null || geoRectangle.isOverlap(rect);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public boolean contains(LatLng latLng) {
        float[] fArr = this.Q;
        int length = fArr.length;
        System.arraycopy(fArr, 0, new float[length], 0, fArr.length);
        if (length / 3 < 2) {
            return false;
        }
        try {
            ArrayList<FPoint> d = d();
            if (d != null) {
                if (d.size() >= 1) {
                    double mapLenWithWin = this.e.g().getMapProjection().getMapLenWithWin(((int) this.H) / 4);
                    double mapLenWithWin2 = this.e.g().getMapProjection().getMapLenWithWin(5);
                    FPoint a = a(latLng);
                    FPoint fPoint = null;
                    int i = 0;
                    while (i < d.size() - 1) {
                        if (i == 0) {
                            fPoint = d.get(i);
                        }
                        i++;
                        FPoint fPoint2 = d.get(i);
                        if ((mapLenWithWin2 + mapLenWithWin) - a(a, fPoint, fPoint2) >= 0.0d) {
                            d.clear();
                            return true;
                        }
                        fPoint = fPoint2;
                    }
                    d.clear();
                }
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void destroy() {
        try {
            remove();
            List<C4645x> list = this.k;
            if (list != null && list.size() > 0) {
                for (int i = 0; i < this.k.size(); i++) {
                    C4645x c4645x = this.k.get(i);
                    if (c4645x != null) {
                        this.e.a(c4645x);
                        this.e.g().removeTextureItem(c4645x.p());
                    }
                }
                this.k.clear();
            }
            if (this.Q != null) {
                this.Q = null;
            }
            FloatBuffer floatBuffer = this.p;
            if (floatBuffer != null) {
                floatBuffer.clear();
                this.p = null;
            }
            List<BitmapDescriptor> list2 = this.j;
            if (list2 != null && list2.size() > 0) {
                for (BitmapDescriptor bitmapDescriptor : this.j) {
                    bitmapDescriptor.recycle();
                }
            }
            synchronized (this) {
                BitmapDescriptor bitmapDescriptor2 = this.q;
                if (bitmapDescriptor2 != null) {
                    bitmapDescriptor2.recycle();
                }
            }
            synchronized (this.m) {
                List<Integer> list3 = this.m;
                if (list3 != null) {
                    list3.clear();
                }
            }
            List<Integer> list4 = this.l;
            if (list4 != null) {
                synchronized (list4) {
                    this.l.clear();
                    this.l = null;
                }
            }
            List<LatLng> list5 = this.i;
            if (list5 != null) {
                list5.clear();
                this.i = null;
            }
            this.V = null;
            long j = this.aa;
            if (j != 0) {
                AMapNativePolyline.nativeDestroy(j);
            }
        } catch (Throwable th) {
            hd.c(th, "PolylineDelegateImp", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("destroy erro", "PolylineDelegateImp destroy");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x005a A[Catch: all -> 0x01dc, DONT_GENERATE, TryCatch #2 {, blocks: (B:14:0x0027, B:16:0x002f, B:18:0x0035, B:21:0x003c, B:24:0x0043, B:26:0x0049, B:29:0x0052, B:31:0x005a, B:33:0x005c, B:37:0x0081, B:40:0x00a5, B:42:0x00ad, B:43:0x00b2, B:77:0x014f, B:44:0x00b5, B:46:0x00be, B:48:0x00cd, B:66:0x010f, B:69:0x0125, B:74:0x0135, B:76:0x0141, B:114:0x01da, B:22:0x003f, B:49:0x00ce, B:51:0x00d2, B:53:0x00d6, B:55:0x00dc, B:61:0x010a, B:56:0x00ec, B:58:0x00f0, B:60:0x00fa), top: B:119:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005c A[Catch: all -> 0x01dc, TryCatch #2 {, blocks: (B:14:0x0027, B:16:0x002f, B:18:0x0035, B:21:0x003c, B:24:0x0043, B:26:0x0049, B:29:0x0052, B:31:0x005a, B:33:0x005c, B:37:0x0081, B:40:0x00a5, B:42:0x00ad, B:43:0x00b2, B:77:0x014f, B:44:0x00b5, B:46:0x00be, B:48:0x00cd, B:66:0x010f, B:69:0x0125, B:74:0x0135, B:76:0x0141, B:114:0x01da, B:22:0x003f, B:49:0x00ce, B:51:0x00d2, B:53:0x00d6, B:55:0x00dc, B:61:0x010a, B:56:0x00ec, B:58:0x00f0, B:60:0x00fa), top: B:119:0x0027 }] */
    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void draw(com.autonavi.base.amap.mapcore.MapConfig r17) throws android.os.RemoteException {
        /*
            Method dump skipped, instructions count: 479
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cz.draw(com.autonavi.base.amap.mapcore.MapConfig):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean equalsRemote(IOverlay iOverlay) throws RemoteException {
        return equals(iOverlay) || iOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public int getColor() throws RemoteException {
        return this.E;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public String getId() throws RemoteException {
        if (this.f == null) {
            this.f = this.e.a("Polyline");
        }
        return this.f;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public LatLng getNearestLatLng(LatLng latLng) {
        List<LatLng> list;
        if (latLng != null && (list = this.i) != null && list.size() != 0) {
            float f = 0.0f;
            int i = 0;
            for (int i2 = 0; i2 < this.i.size(); i2++) {
                try {
                    if (i2 == 0) {
                        f = AMapUtils.calculateLineDistance(latLng, this.i.get(i2));
                    } else {
                        float calculateLineDistance = AMapUtils.calculateLineDistance(latLng, this.i.get(i2));
                        if (f > calculateLineDistance) {
                            i = i2;
                            f = calculateLineDistance;
                        }
                    }
                } catch (Throwable th) {
                    hd.c(th, "PolylineDelegateImp", "getNearestLatLng");
                    th.printStackTrace();
                }
            }
            return this.i.get(i);
        }
        return null;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public PolylineOptions getOptions() {
        return this.V;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public List<LatLng> getPoints() throws RemoteException {
        return this.i;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public float getShownRatio() {
        return this.ac;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public float getWidth() throws RemoteException {
        return this.H;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public float getZIndex() throws RemoteException {
        return this.I;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public int hashCodeRemote() throws RemoteException {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isAboveMaskLayer() {
        return this.T;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isDottedLine() {
        return this.v;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IOverlayDelegate
    public boolean isDrawFinish() {
        return this.z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public boolean isGeodesic() {
        return this.u;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public boolean isVisible() throws RemoteException {
        return this.s;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void reLoadTexture() {
        this.w = false;
        this.C = 0;
        this.D = 1.0f;
        int[] iArr = this.S;
        if (iArr != null) {
            Arrays.fill(iArr, 0);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void remove() throws RemoteException {
        this.ah = true;
        this.e.removeOverlay(getId());
        setVisible(false);
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setAboveMaskLayer(boolean z) {
        this.T = z;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setColor(int i) {
        int i2 = this.B;
        if (i2 == 0 || i2 == 2) {
            this.E = i;
            this.K = Color.alpha(i) / 255.0f;
            this.L = Color.red(i) / 255.0f;
            this.M = Color.green(i) / 255.0f;
            this.N = Color.blue(i) / 255.0f;
            if (this.t) {
                if (this.v) {
                    this.B = 2;
                } else {
                    this.B = 0;
                }
            }
            this.e.g().setRunLowFrame(false);
        }
        this.V.color(i);
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void setColorValues(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            synchronized (this.m) {
                this.m.clear();
                this.m.addAll(list);
            }
        } catch (Throwable unused) {
        }
        if (list.size() > 1) {
            this.t = false;
            this.o = e(list);
            this.B = 3;
            this.e.g().setRunLowFrame(false);
            return;
        }
        setColor(list.get(0).intValue());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustemTextureIndex(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        try {
            synchronized (this.l) {
                this.l.clear();
                this.l.addAll(list);
                this.n = e(list);
                this.y = true;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustomTexture(BitmapDescriptor bitmapDescriptor) {
        long nanoTime = System.nanoTime();
        if (nanoTime - this.d < 16) {
            return;
        }
        this.d = nanoTime;
        if (bitmapDescriptor == null) {
            return;
        }
        synchronized (this) {
            if (bitmapDescriptor.equals(this.q)) {
                return;
            }
            this.t = false;
            this.w = false;
            this.B = 1;
            this.q = bitmapDescriptor;
            this.e.g().setRunLowFrame(false);
            PolylineOptions polylineOptions = this.V;
            if (polylineOptions != null) {
                polylineOptions.setCustomTexture(bitmapDescriptor);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate, com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setCustomTextureList(List<BitmapDescriptor> list) {
        d(list);
        setCustemTextureIndex(this.V.getCustomTextureIndex());
        reLoadTexture();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setDottedLine(boolean z) {
        int i = this.B;
        if (i == 2 || i == 0) {
            this.v = z;
            if (z && this.t) {
                this.B = 2;
            } else if (!z && this.t) {
                this.B = 0;
            }
            this.e.g().setRunLowFrame(false);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setGeodesic(boolean z) throws RemoteException {
        this.u = z;
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setOptions(PolylineOptions polylineOptions) {
        if (polylineOptions == null) {
            return;
        }
        this.V = polylineOptions;
        try {
            setColor(polylineOptions.getColor());
            setGeodesic(polylineOptions.isGeodesic());
            setDottedLine(polylineOptions.isDottedLine());
            a(polylineOptions.getDottedLineType());
            setAboveMaskLayer(polylineOptions.isAboveMaskLayer());
            setVisible(polylineOptions.isVisible());
            setWidth(polylineOptions.getWidth());
            setZIndex(polylineOptions.getZIndex());
            a(polylineOptions.isUseTexture());
            setTransparency(polylineOptions.getTransparency());
            a(polylineOptions.getLineCapType());
            a(polylineOptions.getLineJoinType());
            if (polylineOptions.getColorValues() != null) {
                setColorValues(polylineOptions.getColorValues());
                useGradient(polylineOptions.isUseGradient());
            }
            if (polylineOptions.getCustomTexture() != null) {
                setCustomTexture(polylineOptions.getCustomTexture());
                reLoadTexture();
            }
            if (polylineOptions.getCustomTextureList() != null) {
                d(polylineOptions.getCustomTextureList());
                setCustemTextureIndex(polylineOptions.getCustomTextureIndex());
                reLoadTexture();
            }
            setPoints(polylineOptions.getPoints());
            setShownRatio(polylineOptions.getShownRatio());
            setShowRange(polylineOptions.getShownRangeBegin(), polylineOptions.getShownRangeEnd());
        } catch (RemoteException e) {
            hd.c(e, "PolylineDelegateImp", "setOptions");
            e.printStackTrace();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setPoints(List<LatLng> list) throws RemoteException {
        try {
            this.i = list;
            synchronized (this.r) {
                a(list);
            }
            this.x = true;
            this.e.g().setRunLowFrame(false);
            this.V.setPoints(list);
            setShownRatio(this.V.getShownRatio());
            setShowRange(this.V.getShownRangeBegin(), this.V.getShownRangeEnd());
        } catch (Throwable th) {
            hd.c(th, "PolylineDelegateImp", "setPoints");
            this.g.clear();
            th.printStackTrace();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0049  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:7:0x001b, B:11:0x0021, B:12:0x002d, B:16:0x0034, B:19:0x003b, B:21:0x0040, B:31:0x0059, B:33:0x005e, B:35:0x0066, B:36:0x006d, B:38:0x006f, B:39:0x007a, B:41:0x0096, B:58:0x014e, B:45:0x00a9, B:47:0x00ad, B:49:0x00de, B:50:0x010b, B:54:0x0118, B:57:0x0121, B:60:0x0158, B:61:0x015a, B:26:0x004b, B:28:0x0050, B:30:0x0056), top: B:67:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x005e A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:7:0x001b, B:11:0x0021, B:12:0x002d, B:16:0x0034, B:19:0x003b, B:21:0x0040, B:31:0x0059, B:33:0x005e, B:35:0x0066, B:36:0x006d, B:38:0x006f, B:39:0x007a, B:41:0x0096, B:58:0x014e, B:45:0x00a9, B:47:0x00ad, B:49:0x00de, B:50:0x010b, B:54:0x0118, B:57:0x0121, B:60:0x0158, B:61:0x015a, B:26:0x004b, B:28:0x0050, B:30:0x0056), top: B:67:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0096 A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:7:0x001b, B:11:0x0021, B:12:0x002d, B:16:0x0034, B:19:0x003b, B:21:0x0040, B:31:0x0059, B:33:0x005e, B:35:0x0066, B:36:0x006d, B:38:0x006f, B:39:0x007a, B:41:0x0096, B:58:0x014e, B:45:0x00a9, B:47:0x00ad, B:49:0x00de, B:50:0x010b, B:54:0x0118, B:57:0x0121, B:60:0x0158, B:61:0x015a, B:26:0x004b, B:28:0x0050, B:30:0x0056), top: B:67:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0158 A[Catch: all -> 0x0172, TryCatch #0 {, blocks: (B:4:0x000d, B:6:0x0016, B:7:0x001b, B:11:0x0021, B:12:0x002d, B:16:0x0034, B:19:0x003b, B:21:0x0040, B:31:0x0059, B:33:0x005e, B:35:0x0066, B:36:0x006d, B:38:0x006f, B:39:0x007a, B:41:0x0096, B:58:0x014e, B:45:0x00a9, B:47:0x00ad, B:49:0x00de, B:50:0x010b, B:54:0x0118, B:57:0x0121, B:60:0x0158, B:61:0x015a, B:26:0x004b, B:28:0x0050, B:30:0x0056), top: B:67:0x000d }] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0156 A[EDGE_INSN: B:68:0x0156->B:59:0x0156 ?: BREAK  , SYNTHETIC] */
    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void setShowRange(float r20, float r21) {
        /*
            Method dump skipped, instructions count: 373
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.cz.setShowRange(float, float):void");
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setShownRatio(float f) {
        int xVar;
        int yVar;
        int size;
        this.ac = f;
        synchronized (this.r) {
            int size2 = this.g.size();
            if (size2 < 2) {
                this.ag.clear();
                return;
            }
            float f2 = this.ac;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            } else if (f2 >= size2) {
                f2 = size2 - 1;
            }
            if (this.u) {
                if (this.i.size() < 2) {
                    return;
                }
                f2 = (f2 / (size - 1)) * (size2 - 1);
            }
            this.ag.clear();
            int floor = (int) Math.floor(f2);
            IPoint iPoint = null;
            int i = 0;
            while (true) {
                if (i >= size2) {
                    break;
                }
                IPoint iPoint2 = this.g.get(i);
                if (i > floor) {
                    float f3 = f2 - floor;
                    if (f != 0.0f && iPoint != null) {
                        IPoint iPoint3 = new IPoint();
                        ((android.graphics.Point) iPoint3).x = (int) (Point.getx(iPoint) + ((Point.getx(iPoint2) - xVar) * f3));
                        ((android.graphics.Point) iPoint3).y = (int) (Point.gety(iPoint) + ((Point.gety(iPoint2) - yVar) * f3));
                        this.ag.add(iPoint3);
                    }
                } else {
                    this.ag.add(iPoint2);
                    i++;
                    iPoint = iPoint2;
                }
            }
            this.x = true;
            this.e.g().setRunLowFrame(false);
            this.V.setShownRatio(f);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setTransparency(float f) {
        this.O = (float) Math.min(1.0d, Math.max(0.0d, f));
        this.e.g().setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setVisible(boolean z) throws RemoteException {
        this.s = z;
        this.e.g().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.V;
        if (polylineOptions != null) {
            polylineOptions.visible(z);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IPolyline
    public void setWidth(float f) throws RemoteException {
        this.H = f;
        this.e.g().setRunLowFrame(false);
        this.V.width(f);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.IOverlay
    public void setZIndex(float f) throws RemoteException {
        this.I = f;
        this.e.e();
        this.e.g().setRunLowFrame(false);
        PolylineOptions polylineOptions = this.V;
        if (polylineOptions != null) {
            polylineOptions.zIndex(f);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.IPolylineDelegate
    public void useGradient(boolean z) {
        List<Integer> list;
        if (!z || (list = this.m) == null || list.size() <= 1) {
            return;
        }
        this.B = 4;
        this.e.g().setRunLowFrame(false);
    }

    public void a(int i) {
        this.G = i;
    }

    void a(List<LatLng> list) throws RemoteException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        LatLngBounds.Builder builder = LatLngBounds.builder();
        if (list != null) {
            LatLng latLng = null;
            z = false;
            for (LatLng latLng2 : list) {
                if (!this.u) {
                    IPoint obtain = IPoint.obtain();
                    this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain);
                    arrayList.add(obtain);
                    builder.include(latLng2);
                } else if (latLng != null) {
                    if (Math.abs(latLng2.longitude - latLng.longitude) < 0.01d) {
                        IPoint obtain2 = IPoint.obtain();
                        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain2);
                        arrayList.add(obtain2);
                        builder.include(latLng);
                        IPoint obtain3 = IPoint.obtain();
                        this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain3);
                        arrayList.add(obtain3);
                        builder.include(latLng2);
                    } else {
                        a(latLng, latLng2, arrayList, builder);
                    }
                }
                if (latLng2 != null) {
                    if (!z && latLng2.longitude < -180.0d) {
                        this.ab = true;
                        z = true;
                    }
                    if (!this.ab && latLng2.longitude > 180.0d) {
                        this.ab = true;
                    }
                }
                latLng = latLng2;
            }
        } else {
            z = false;
        }
        this.g = arrayList;
        this.F = 0;
        if (this.a == null) {
            this.a = new Rect();
        }
        eq.a(this.a);
        for (IPoint iPoint : this.g) {
            if (z) {
                ((android.graphics.Point) iPoint).x = Point.getx(iPoint) + 268435456;
            }
            eq.b(this.a, Point.getx(iPoint), Point.gety(iPoint));
        }
        this.a.sort();
        this.e.g().setRunLowFrame(false);
    }

    private ArrayList<FPoint> d() {
        ArrayList<FPoint> arrayList = new ArrayList<>();
        int i = 0;
        while (true) {
            float[] fArr = this.Q;
            if (i >= fArr.length) {
                return arrayList;
            }
            float f = fArr[i];
            int i2 = i + 1;
            arrayList.add(FPoint.obtain(f, fArr[i2]));
            i = i2 + 1 + 1;
        }
    }

    private void c(float f, MapConfig mapConfig) {
        List<FPoint> b;
        synchronized (this.m) {
            int[] iArr = new int[this.m.size()];
            for (int i = 0; i < this.m.size(); i++) {
                iArr[i] = this.m.get(i).intValue();
            }
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    b = eq.b(clipMapRect, this.h, false);
                }
                list = b;
            }
            if (list.size() >= 2) {
                c(list);
                int size = this.o.size();
                int[] iArr2 = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr2[i2] = this.o.get(i2).intValue();
                }
                if (true && (this.R != null)) {
                    float[] fArr = this.Q;
                    int i3 = this.b;
                    int lineTextureID = this.e.g().getLineTextureID();
                    int[] iArr3 = this.R;
                    AMapNativeRenderer.nativeDrawLineByMultiColor(fArr, i3, f, lineTextureID, iArr2, size, iArr3, iArr3.length, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private List<Integer> e(List<Integer> list) {
        int[] iArr = new int[list.size()];
        ArrayList arrayList = new ArrayList();
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < list.size(); i3++) {
            int intValue = list.get(i3).intValue();
            if (i3 == 0) {
                arrayList.add(Integer.valueOf(intValue));
            } else if (intValue != i) {
                arrayList.add(Integer.valueOf(intValue));
            }
            iArr[i2] = i3;
            i2++;
            i = intValue;
        }
        int[] iArr2 = new int[arrayList.size()];
        this.R = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
        return arrayList;
    }

    private void b() {
        C4637r c4637r;
        List<C4645x> list = this.k;
        if (list != null) {
            for (C4645x c4645x : list) {
                if (c4645x != null && (c4637r = this.e) != null) {
                    c4637r.a(c4645x);
                }
            }
            this.k.clear();
        }
    }

    private void d(List<BitmapDescriptor> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        if (list.size() > 1) {
            this.t = false;
            this.B = 5;
            this.j = list;
            this.e.g().setRunLowFrame(false);
            return;
        }
        setCustomTexture(list.get(0));
    }

    IPoint a(IPoint iPoint, IPoint iPoint2, IPoint iPoint3, double d, int i) {
        int sqrt;
        IPoint obtain = IPoint.obtain();
        double xVar = Point.getx(iPoint2) - Point.getx(iPoint);
        double yVar = Point.gety(iPoint2) - Point.gety(iPoint);
        ((android.graphics.Point) obtain).y = (int) (((i * d) / Math.sqrt(((yVar * yVar) / (xVar * xVar)) + 1.0d)) + Point.gety(iPoint3));
        ((android.graphics.Point) obtain).x = (int) ((((Point.gety(iPoint3) - sqrt) * yVar) / xVar) + Point.getx(iPoint3));
        return obtain;
    }

    private void b(float f, MapConfig mapConfig) {
        List<FPoint> b;
        synchronized (this.m) {
            int[] iArr = new int[this.m.size()];
            for (int i = 0; i < this.m.size(); i++) {
                iArr[i] = this.m.get(i).intValue();
            }
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    b = eq.b(clipMapRect, this.h, false);
                }
                list = b;
            }
            if (list.size() >= 2) {
                c(list);
                int size = this.o.size();
                int[] iArr2 = new int[size];
                for (int i2 = 0; i2 < size; i2++) {
                    iArr2[i2] = this.o.get(i2).intValue();
                }
                int[] iArr3 = this.R;
                if (true && (iArr3 != null)) {
                    AMapNativeRenderer.nativeDrawGradientColorLine(this.Q, this.b, f, iArr2, size, iArr3, iArr3.length, this.e.g().getLineTextureID(), this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    void a(List<IPoint> list, List<IPoint> list2, double d) {
        float f;
        if (list.size() != 3) {
            return;
        }
        int i = 10;
        int i2 = 0;
        int i3 = 0;
        while (i3 <= i) {
            float f2 = i3;
            float f3 = f2 / 10.0f;
            IPoint obtain = IPoint.obtain();
            double d2 = 1.0d - f3;
            double d3 = d2 * d2;
            double d4 = 2.0f * f3 * d2;
            double xVar = (Point.getx(list.get(i2)) * d3) + (Point.getx(list.get(1)) * d4 * d) + (Point.getx(list.get(2)) * f);
            double yVar = (Point.gety(list.get(i2)) * d3) + (Point.gety(list.get(1)) * d4 * d) + (Point.gety(list.get(2)) * f);
            double d5 = d3 + (d4 * d) + (f3 * f3);
            ((android.graphics.Point) obtain).x = (int) (xVar / d5);
            ((android.graphics.Point) obtain).y = (int) (yVar / d5);
            list2.add(obtain);
            i3 = (int) (f2 + 1.0f);
            i = 10;
            i2 = 0;
        }
    }

    void a(LatLng latLng, LatLng latLng2, List<IPoint> list, LatLngBounds.Builder builder) {
        double abs = (Math.abs(latLng.longitude - latLng2.longitude) * 3.141592653589793d) / 180.0d;
        LatLng latLng3 = new LatLng((latLng2.latitude + latLng.latitude) / 2.0d, (latLng2.longitude + latLng.longitude) / 2.0d, false);
        builder.include(latLng).include(latLng3).include(latLng2);
        int i = latLng3.latitude > 0.0d ? -1 : 1;
        IPoint obtain = IPoint.obtain();
        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        IPoint obtain2 = IPoint.obtain();
        this.e.g().latlon2Geo(latLng2.latitude, latLng2.longitude, obtain2);
        IPoint obtain3 = IPoint.obtain();
        this.e.g().latlon2Geo(latLng3.latitude, latLng3.longitude, obtain3);
        double d = abs * 0.5d;
        double cos = Math.cos(d);
        IPoint a = a(obtain, obtain2, obtain3, Math.hypot(Point.getx(obtain) - Point.getx(obtain2), Point.gety(obtain) - Point.gety(obtain2)) * 0.5d * Math.tan(d), i);
        ArrayList arrayList = new ArrayList();
        arrayList.add(obtain);
        arrayList.add(a);
        arrayList.add(obtain2);
        a(arrayList, list, cos);
        obtain.recycle();
        a.recycle();
        obtain2.recycle();
    }

    private int c() {
        int[] iArr = {0};
        GLES20.glGenTextures(1, iArr, 0);
        return iArr[0];
    }

    private void a() {
        float mapPerPixelUnitLength = this.e.g().getMapConfig().getMapPerPixelUnitLength();
        if (this.F > 5000) {
            float f = this.J;
            if (f <= 12) {
                float f2 = (this.H / 2.0f) + (f / 2.0f);
                if (f2 > 200.0f) {
                    f2 = 200.0f;
                }
                this.P = mapPerPixelUnitLength * f2;
                return;
            }
            this.P = mapPerPixelUnitLength * 10.0f;
            return;
        }
        this.P = mapPerPixelUnitLength * 2.0f;
    }

    private boolean a(FPoint fPoint, FPoint fPoint2) {
        return ((fPoint instanceof FPoint3) && (fPoint2 instanceof FPoint3) && ((FPoint3) fPoint).colorIndex != ((FPoint3) fPoint2).colorIndex) || Math.abs(((PointF) fPoint2).x - ((PointF) fPoint).x) >= this.P || Math.abs(((PointF) fPoint2).y - ((PointF) fPoint).y) >= this.P;
    }

    private void a(MapConfig mapConfig) {
        float mapLenWithWin = this.e.g().getMapProjection().getMapLenWithWin((int) this.H);
        int i = this.B;
        if (i == 0) {
            f(mapLenWithWin, mapConfig);
        } else if (i == 1) {
            if (this.A) {
                d(mapLenWithWin, mapConfig);
            } else {
                f(mapLenWithWin, mapConfig);
            }
        } else if (i == 2) {
            if (this.G == -1) {
                f(mapLenWithWin, mapConfig);
            } else {
                e(mapLenWithWin, mapConfig);
            }
        } else if (i == 3) {
            c(mapLenWithWin, mapConfig);
        } else if (i == 4) {
            b(mapLenWithWin, mapConfig);
        } else if (i != 5) {
        } else {
            if (this.A) {
                a(mapLenWithWin, mapConfig);
            } else {
                c(mapLenWithWin, mapConfig);
            }
        }
    }

    private void a(float f, MapConfig mapConfig) {
        int size;
        int[] iArr;
        List<FPoint> b;
        if (this.ah) {
            return;
        }
        if (!this.w) {
            try {
                List<BitmapDescriptor> list = this.j;
                if (list != null) {
                    this.S = new int[list.size()];
                    boolean z = Build.VERSION.SDK_INT >= 12;
                    b();
                    int i = 0;
                    int i2 = 0;
                    for (BitmapDescriptor bitmapDescriptor : this.j) {
                        C4645x a = a(z, bitmapDescriptor, false);
                        if (a != null) {
                            i2 = a.k();
                            this.D = a.l();
                        }
                        this.S[i] = i2;
                        i++;
                    }
                    this.w = true;
                }
            } catch (Throwable th) {
                hd.c(th, "MarkerDelegateImp", "loadtexture");
                return;
            }
        }
        FPoint[] clipMapRect = mapConfig.getGeoRectangle().getClipMapRect();
        try {
            List<FPoint> list2 = this.h;
            if (a(clipMapRect)) {
                synchronized (this.r) {
                    b = eq.b(clipMapRect, this.h, false);
                }
                list2 = b;
            }
            if (list2.size() >= 2) {
                c(list2);
                synchronized (this.n) {
                    size = this.n.size();
                    iArr = new int[size];
                    for (int i3 = 0; i3 < size; i3++) {
                        int intValue = this.n.get(i3).intValue();
                        if (intValue < 0) {
                            intValue = 0;
                        }
                        iArr[i3] = this.S[intValue];
                    }
                }
                int[] iArr2 = this.R;
                if (true && (iArr2 != null)) {
                    AMapNativeRenderer.nativeDrawLineByMultiTextureID(this.Q, this.b, f, iArr, this.D, size, iArr2, iArr2.length, 1.0f - this.O, this.e.h(), this.Y.getTypeValue(), this.X.getTypeValue());
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(C4645x c4645x) {
        if (c4645x != null) {
            this.k.add(c4645x);
            c4645x.m();
        }
    }

    private C4645x a(boolean z, BitmapDescriptor bitmapDescriptor, boolean z2) {
        if (z2) {
            b();
        }
        C4645x c4645x = null;
        if (z && (c4645x = this.e.a(bitmapDescriptor)) != null && c4645x.k() > 0) {
            c4645x.k();
            a(c4645x);
            return c4645x;
        }
        if (c4645x == null) {
            c4645x = new C4645x(bitmapDescriptor, 0);
        }
        Bitmap bitmap = bitmapDescriptor.getBitmap();
        if (bitmap != null && !bitmap.isRecycled()) {
            int c = c();
            if (z) {
                c4645x.a(c);
                this.e.g().addTextureItem(c4645x);
            }
            a(c4645x);
            eq.b(c, bitmap, true);
        }
        return c4645x;
    }

    private boolean a(FPoint[] fPointArr) {
        this.J = this.e.g().getZoomLevel();
        a();
        if (this.J <= (this.g.size() > 10000 ? 7 : 3)) {
            return false;
        }
        try {
            if (this.e.g() != null) {
                if (eq.a(this.U.northeast, fPointArr)) {
                    return !eq.a(this.U.southwest, fPointArr);
                }
                return true;
            }
        } catch (Throwable unused) {
        }
        return false;
    }

    private double a(FPoint fPoint, FPoint fPoint2, FPoint fPoint3) {
        return a(((PointF) fPoint).x, ((PointF) fPoint).y, ((PointF) fPoint2).x, ((PointF) fPoint2).y, ((PointF) fPoint3).x, ((PointF) fPoint3).y);
    }

    private FPoint a(LatLng latLng) {
        IPoint obtain = IPoint.obtain();
        this.e.g().latlon2Geo(latLng.latitude, latLng.longitude, obtain);
        FPoint obtain2 = FPoint.obtain();
        this.e.g().geo2Map(Point.getx(obtain), Point.gety(obtain), obtain2);
        obtain.recycle();
        return obtain2;
    }

    private double a(double d, double d2, double d3, double d4, double d5, double d6) {
        double d7 = d5 - d3;
        double d8 = d - d3;
        double d9 = d6 - d4;
        double d10 = d2 - d4;
        double d11 = (d7 * d8) + (d9 * d10);
        if (d11 <= 0.0d) {
            return Math.sqrt((d8 * d8) + (d10 * d10));
        }
        double d12 = (d7 * d7) + (d9 * d9);
        if (d11 >= d12) {
            double d13 = d - d5;
            double d14 = d2 - d6;
            return Math.sqrt((d13 * d13) + (d14 * d14));
        }
        double d15 = d11 / d12;
        double d16 = d - (d3 + (d7 * d15));
        double d17 = (d4 + (d9 * d15)) - d2;
        return Math.sqrt((d16 * d16) + (d17 * d17));
    }

    public void a(PolylineOptions.LineJoinType lineJoinType) {
        this.X = lineJoinType;
    }

    public void a(PolylineOptions.LineCapType lineCapType) {
        this.Y = lineCapType;
    }

    public void a(C4505de c4505de) {
        this.Z = c4505de;
    }
}
