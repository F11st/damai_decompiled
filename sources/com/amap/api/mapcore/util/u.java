package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.opengl.GLES20;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.RemoteException;
import android.util.Log;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.ew;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.Text;
import com.amap.api.maps.model.TextOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMarker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import com.taobao.weex.common.Constants;
import java.io.Serializable;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class u {
    IAMapDelegate a;
    public de.d c;
    private IPoint k;
    private BaseOverlayImp l;
    private IMarkerDelegate m;
    private FloatBuffer p;
    private HandlerThread q;
    private Handler r;
    private List<IOverlayImageDelegate> f = new ArrayList(500);
    private List<x> g = new ArrayList();
    private List<IOverlayImageDelegate> h = new ArrayList();
    private a i = new a();
    private boolean j = true;
    private int[] s = new int[1];
    float[] b = new float[180000];
    int d = 0;
    int e = 0;
    private Runnable t = new Runnable() { // from class: com.amap.api.mapcore.util.u.2
        @Override // java.lang.Runnable
        public void run() {
            synchronized (u.this.f) {
                u.this.j();
            }
        }
    };
    private ew n = new ew(512, 1024);
    private ee o = new ee();

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements Serializable, Comparator<Object> {
        a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            IOverlayImageDelegate iOverlayImageDelegate = (IOverlayImageDelegate) obj;
            IOverlayImageDelegate iOverlayImageDelegate2 = (IOverlayImageDelegate) obj2;
            if (iOverlayImageDelegate == null || iOverlayImageDelegate2 == null) {
                return 0;
            }
            try {
                return Float.compare(iOverlayImageDelegate.getZIndex(), iOverlayImageDelegate2.getZIndex());
            } catch (Throwable th) {
                hd.c(th, "MapOverlayImageView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public u(Context context, IAMapDelegate iAMapDelegate) {
        this.a = iAMapDelegate;
        HandlerThread handlerThread = new HandlerThread("AMapZindexSortThread");
        this.q = handlerThread;
        handlerThread.start();
        this.r = new Handler(this.q.getLooper());
    }

    private void d(IOverlayImageDelegate iOverlayImageDelegate) {
        try {
            this.f.add(iOverlayImageDelegate);
            f();
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "addMarker");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j() {
        try {
            Collections.sort(this.f, this.i);
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "changeOverlayIndex");
        }
    }

    private void k() {
        IAMapDelegate iAMapDelegate;
        if (this.c != null || (iAMapDelegate = this.a) == null) {
            return;
        }
        this.c = (de.d) iAMapDelegate.getGLShader(1);
    }

    public IAMapDelegate c() {
        return this.a;
    }

    public List<Marker> e() {
        ArrayList arrayList;
        synchronized (this.f) {
            arrayList = new ArrayList();
            for (IOverlayImageDelegate iOverlayImageDelegate : this.f) {
                if ((iOverlayImageDelegate instanceof cu) && iOverlayImageDelegate.checkInBounds()) {
                    arrayList.add(new Marker((IMarker) iOverlayImageDelegate));
                }
            }
        }
        return arrayList;
    }

    public void f() {
        Handler handler = this.r;
        if (handler != null) {
            handler.removeCallbacks(this.t);
            this.r.postDelayed(this.t, 10L);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public int g() {
        int size;
        synchronized (this.f) {
            size = this.f.size();
        }
        return size;
    }

    public void h() {
        synchronized (this.g) {
            int baseOverlayTextureID = this.a.getBaseOverlayTextureID();
            for (int i = 0; i < this.g.size(); i++) {
                x xVar = this.g.get(i);
                if (xVar != null) {
                    xVar.n();
                    if (xVar.o() <= 0) {
                        if (xVar.k() == baseOverlayTextureID) {
                            this.n.a(xVar.p());
                        } else {
                            this.s[0] = xVar.k();
                            GLES20.glDeleteTextures(1, this.s, 0);
                            xVar.a(0);
                        }
                        IAMapDelegate iAMapDelegate = this.a;
                        if (iAMapDelegate != null) {
                            iAMapDelegate.removeTextureItem(xVar.p());
                        }
                    }
                }
            }
            this.g.clear();
        }
    }

    public void i() {
        try {
            for (IOverlayImageDelegate iOverlayImageDelegate : this.f) {
                if (iOverlayImageDelegate != null) {
                    iOverlayImageDelegate.destroy(false);
                }
            }
            b((String) null);
            HandlerThread handlerThread = this.q;
            if (handlerThread != null) {
                handlerThread.quit();
            }
            this.r = null;
            this.a = null;
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", Constants.Event.SLOT_LIFECYCLE.DESTORY);
            th.printStackTrace();
            Log.d("amapApi", "MapOverlayImageView clear erro" + th.getMessage());
        }
    }

    public Marker a(MarkerOptions markerOptions) throws RemoteException {
        Marker marker;
        if (markerOptions == null) {
            return null;
        }
        cu cuVar = new cu(markerOptions, this);
        synchronized (this.f) {
            d(cuVar);
            ea.a(this.f.size());
            marker = new Marker(cuVar);
        }
        return marker;
    }

    public void b(IOverlayImageDelegate iOverlayImageDelegate) {
        if (iOverlayImageDelegate != null) {
            try {
                if (iOverlayImageDelegate.isInfoWindowShown()) {
                    this.a.hideInfoWindow();
                    this.l = null;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                return;
            }
        }
        BaseOverlayImp baseOverlayImp = this.l;
        if (baseOverlayImp != null && baseOverlayImp.getId().equals(iOverlayImageDelegate.getId())) {
            this.l = null;
        }
    }

    public boolean c(IOverlayImageDelegate iOverlayImageDelegate) {
        boolean contains;
        synchronized (this.f) {
            contains = this.f.contains(iOverlayImageDelegate);
        }
        return contains;
    }

    public BaseOverlayImp d() {
        return this.l;
    }

    public ArrayList<Marker> a(ArrayList<MarkerOptions> arrayList, boolean z) throws RemoteException {
        MarkerOptions markerOptions;
        if (arrayList == null || arrayList.size() == 0) {
            return null;
        }
        ArrayList<Marker> arrayList2 = new ArrayList<>();
        try {
            if (arrayList.size() == 1 && (markerOptions = arrayList.get(0)) != null) {
                arrayList2.add(a(markerOptions));
                if (z && markerOptions.getPosition() != null) {
                    this.a.moveCamera(ah.a(markerOptions.getPosition(), 18.0f));
                }
            } else {
                final LatLngBounds.Builder builder = LatLngBounds.builder();
                for (int i = 0; i < arrayList.size(); i++) {
                    MarkerOptions markerOptions2 = arrayList.get(i);
                    if (arrayList.get(i) != null) {
                        arrayList2.add(a(markerOptions2));
                        if (markerOptions2.getPosition() != null) {
                            builder.include(markerOptions2.getPosition());
                        }
                    }
                }
                if (z && arrayList2.size() > 0) {
                    this.a.getMainHandler().postDelayed(new Runnable() { // from class: com.amap.api.mapcore.util.u.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                u.this.a.moveCamera(ah.a(builder.build(), 50));
                            } catch (Throwable unused) {
                            }
                        }
                    }, 50L);
                }
            }
            return arrayList2;
        } catch (Throwable th) {
            hd.c(th, "AMapDelegateImpGLSurfaceView", "addMarkers");
            th.printStackTrace();
            return arrayList2;
        }
    }

    public float[] b() {
        IAMapDelegate iAMapDelegate = this.a;
        return iAMapDelegate != null ? iAMapDelegate.getFinalMatrix() : new float[16];
    }

    public boolean b(MotionEvent motionEvent) throws RemoteException {
        boolean z;
        Rect rect;
        boolean a2;
        synchronized (this.f) {
            z = false;
            int size = this.f.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                }
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(size);
                if ((iOverlayImageDelegate instanceof cu) && iOverlayImageDelegate.isVisible() && ((cu) iOverlayImageDelegate).isClickable() && (a2 = eq.a((rect = iOverlayImageDelegate.getRect()), (int) motionEvent.getX(), (int) motionEvent.getY()))) {
                    this.k = IPoint.obtain(rect.left + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2), rect.top);
                    this.l = (cu) iOverlayImageDelegate;
                    z = a2;
                    break;
                }
                size--;
            }
        }
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x001d A[Catch: all -> 0x0065, TRY_ENTER, TryCatch #2 {all -> 0x0010, blocks: (B:4:0x0003, B:11:0x0013, B:12:0x001c, B:13:0x001d, B:15:0x0024, B:29:0x0063, B:16:0x002a, B:18:0x0032, B:21:0x0046, B:22:0x0049, B:24:0x0050, B:26:0x005b, B:28:0x005f), top: B:36:0x0003 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void b(java.lang.String r7) {
        /*
            r6 = this;
            r0 = 0
            if (r7 == 0) goto L12
            java.lang.String r1 = r7.trim()     // Catch: java.lang.Throwable -> L10
            int r1 = r1.length()     // Catch: java.lang.Throwable -> L10
            if (r1 != 0) goto Le
            goto L12
        Le:
            r1 = 0
            goto L13
        L10:
            r7 = move-exception
            goto L68
        L12:
            r1 = 1
        L13:
            r2 = 0
            r6.l = r2     // Catch: java.lang.Throwable -> L10
            r6.k = r2     // Catch: java.lang.Throwable -> L10
            r6.m = r2     // Catch: java.lang.Throwable -> L10
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r3 = r6.f     // Catch: java.lang.Throwable -> L10
            monitor-enter(r3)     // Catch: java.lang.Throwable -> L10
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r4 = r6.h     // Catch: java.lang.Throwable -> L65
            r4.clear()     // Catch: java.lang.Throwable -> L65
            if (r1 == 0) goto L2a
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r7 = r6.f     // Catch: java.lang.Throwable -> L65
            r7.clear()     // Catch: java.lang.Throwable -> L65
            goto L63
        L2a:
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r1 = r6.f     // Catch: java.lang.Throwable -> L65
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L65
        L30:
            if (r0 >= r1) goto L49
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r4 = r6.f     // Catch: java.lang.Throwable -> L65
            java.lang.Object r4 = r4.get(r0)     // Catch: java.lang.Throwable -> L65
            com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate r4 = (com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate) r4     // Catch: java.lang.Throwable -> L65
            java.lang.String r5 = r4.getId()     // Catch: java.lang.Throwable -> L65
            boolean r5 = r7.equals(r5)     // Catch: java.lang.Throwable -> L65
            if (r5 == 0) goto L46
            r2 = r4
            goto L49
        L46:
            int r0 = r0 + 1
            goto L30
        L49:
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r7 = r6.f     // Catch: java.lang.Throwable -> L65
            r7.clear()     // Catch: java.lang.Throwable -> L65
            if (r2 == 0) goto L63
            java.util.List<com.autonavi.base.amap.api.mapcore.overlays.IOverlayImageDelegate> r7 = r6.f     // Catch: java.lang.Throwable -> L65
            r7.add(r2)     // Catch: java.lang.Throwable -> L65
            boolean r7 = r2.isOnTap()     // Catch: java.lang.Throwable -> L65
            if (r7 == 0) goto L63
            boolean r7 = r2 instanceof com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate     // Catch: java.lang.Throwable -> L65
            if (r7 == 0) goto L63
            com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate r2 = (com.autonavi.base.amap.api.mapcore.overlays.IMarkerDelegate) r2     // Catch: java.lang.Throwable -> L65
            r6.m = r2     // Catch: java.lang.Throwable -> L65
        L63:
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L65
            goto L72
        L65:
            r7 = move-exception
            monitor-exit(r3)     // Catch: java.lang.Throwable -> L65
            throw r7     // Catch: java.lang.Throwable -> L10
        L68:
            java.lang.String r0 = "MapOverlayImageView"
            java.lang.String r1 = "clear"
            com.amap.api.mapcore.util.hd.c(r7, r0, r1)
            r7.printStackTrace()
        L72:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.u.b(java.lang.String):void");
    }

    public Text a(TextOptions textOptions) throws RemoteException {
        Text text;
        if (textOptions == null) {
            return null;
        }
        synchronized (this.f) {
            db dbVar = new db(textOptions, this);
            d(dbVar);
            text = new Text(dbVar);
        }
        return text;
    }

    public boolean a(IOverlayImageDelegate iOverlayImageDelegate) {
        boolean remove;
        synchronized (this.f) {
            try {
                IMarkerDelegate iMarkerDelegate = this.m;
                if (iMarkerDelegate != null && iMarkerDelegate.getId().equals(iOverlayImageDelegate.getId())) {
                    this.m = null;
                }
                b(iOverlayImageDelegate);
                remove = this.f.remove(iOverlayImageDelegate);
            }
        }
        return remove;
    }

    public void a(IMarkerDelegate iMarkerDelegate) {
        try {
            if (this.m != null) {
                if (iMarkerDelegate != null && iMarkerDelegate.getId().equals(this.m.getId())) {
                    return;
                }
                this.m.setOnTap(false);
            }
            if (this.f.contains(iMarkerDelegate)) {
                if (iMarkerDelegate != null) {
                    iMarkerDelegate.setOnTap(true);
                }
                this.m = iMarkerDelegate;
            }
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "set2Top");
        }
    }

    public void a() {
        this.m = null;
    }

    public void a(BaseOverlayImp baseOverlayImp) {
        if (this.k == null) {
            this.k = IPoint.obtain();
        }
        Rect rect = baseOverlayImp.getRect();
        this.k = IPoint.obtain(rect.left + (com.alibaba.wireless.security.aopsdk.replace.android.graphics.Rect.width(rect) / 2), rect.top);
        this.l = baseOverlayImp;
        try {
            this.a.showInfoWindow(baseOverlayImp);
        } catch (Throwable th) {
            hd.c(th, "MapOverlayImageView", "showInfoWindow");
            th.printStackTrace();
        }
    }

    public void a(boolean z) {
        int i;
        try {
            IAMapDelegate iAMapDelegate = this.a;
            if (iAMapDelegate == null) {
                return;
            }
            float mapPerPixelUnitLength = iAMapDelegate.getMapConfig().getMapPerPixelUnitLength();
            synchronized (this.f) {
                h();
                if (this.f.size() == 0) {
                    return;
                }
                this.h.clear();
                int size = this.f.size();
                while (i < size) {
                    IOverlayImageDelegate iOverlayImageDelegate = this.f.get(i);
                    if (!z) {
                        i = iOverlayImageDelegate.getZIndex() == 2.1474836E9f ? i + 1 : 0;
                    } else if (iOverlayImageDelegate.getZIndex() != 2.1474836E9f) {
                    }
                    if (iOverlayImageDelegate.isVisible() && !iOverlayImageDelegate.isOnTap()) {
                        this.j = iOverlayImageDelegate.isAllowLow();
                        if (iOverlayImageDelegate.checkInBounds() || iOverlayImageDelegate.isInfoWindowShown()) {
                            try {
                                this.h.add(iOverlayImageDelegate);
                            } catch (Throwable th) {
                                th.printStackTrace();
                            }
                        }
                    }
                }
                IMarkerDelegate iMarkerDelegate = this.m;
                if (iMarkerDelegate != null && iMarkerDelegate.isVisible()) {
                    this.h.add(this.m);
                }
                if (this.h.size() > 0) {
                    int size2 = this.h.size();
                    int i2 = 0;
                    int i3 = 0;
                    int i4 = 0;
                    int i5 = 0;
                    for (int i6 = 0; i6 < size2; i6++) {
                        IOverlayImageDelegate iOverlayImageDelegate2 = this.h.get(i6);
                        synchronized (iOverlayImageDelegate2) {
                            iOverlayImageDelegate2.loadTexture(this.a);
                            if (i6 == 0) {
                                i3 = iOverlayImageDelegate2.getTextureId();
                            } else {
                                int textureId = iOverlayImageDelegate2.getTextureId();
                                if (textureId != i3) {
                                    a(i3, i2, i4, i5);
                                    i3 = textureId;
                                    i2 = 0;
                                    i4 = 0;
                                    i5 = 0;
                                }
                            }
                            iOverlayImageDelegate2.drawMarker(this.a, this.b, i5, mapPerPixelUnitLength);
                            int textureId2 = iOverlayImageDelegate2.getTextureId();
                            if (textureId2 != i3) {
                                a(i3, i2, i4, i5);
                                i4 = i5;
                                i3 = textureId2;
                                i2 = 0;
                                i5 = 0;
                            }
                            i5 += 36;
                            i2++;
                            if (i2 == 5000) {
                                a(i3, i2, i4, i5);
                                i2 = 0;
                                i4 = 0;
                                i5 = 0;
                            }
                        }
                    }
                    if (i2 > 0) {
                        a(i3, i2, i4, i5);
                    }
                }
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    private void a(int i, int i2, int i3, int i4) {
        if (i2 == 0 || i == 0) {
            return;
        }
        FloatBuffer c = this.o.c(i2 * 36);
        this.p = c;
        c.put(this.b, i3, i4);
        this.p.flip();
        a(i2);
        a(i, i4, i2, this.p, this.a.getMapConfig());
        this.o.a();
    }

    private void a(int i) {
        if (i > 5000) {
            i = 5000;
        }
        if (this.d == 0) {
            int[] iArr = new int[2];
            GLES20.glGenBuffers(2, iArr, 0);
            this.d = iArr[0];
            this.e = iArr[1];
            ShortBuffer b = this.o.b(30000);
            short[] sArr = new short[30000];
            for (int i2 = 0; i2 < 5000; i2++) {
                int i3 = i2 * 6;
                int i4 = i2 * 4;
                short s = (short) (i4 + 0);
                sArr[i3 + 0] = s;
                sArr[i3 + 1] = (short) (i4 + 1);
                short s2 = (short) (i4 + 2);
                sArr[i3 + 2] = s2;
                sArr[i3 + 3] = s;
                sArr[i3 + 4] = s2;
                sArr[i3 + 5] = (short) (i4 + 3);
            }
            b.put(sArr);
            b.flip();
            GLES20.glBindBuffer(34963, this.e);
            GLES20.glBufferData(34963, 60000, b, 35044);
        }
        GLES20.glBindBuffer(34962, this.d);
        GLES20.glBufferData(34962, i * 36 * 4, this.p, 35044);
    }

    private void a(int i, int i2, int i3, FloatBuffer floatBuffer, MapConfig mapConfig) {
        if (i == 0 || floatBuffer == null || i3 == 0) {
            return;
        }
        de.d dVar = this.c;
        if (dVar == null || dVar.c()) {
            k();
        }
        de.d dVar2 = this.c;
        if (dVar2 == null || this.d == 0 || dVar2.c < 0 || this.e == 0) {
            return;
        }
        dVar2.a();
        GLES20.glUniform1f(this.c.h, mapConfig.getSR());
        GLES20.glEnableVertexAttribArray(this.c.b);
        GLES20.glBindBuffer(34962, this.d);
        GLES20.glVertexAttribPointer(this.c.b, 4, 5126, false, 36, 0);
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glEnableVertexAttribArray(this.c.c);
        GLES20.glBindBuffer(34962, this.d);
        GLES20.glVertexAttribPointer(this.c.c, 2, 5126, false, 36, 16);
        GLES20.glEnableVertexAttribArray(this.c.g);
        GLES20.glBindBuffer(34962, this.d);
        GLES20.glVertexAttribPointer(this.c.g, 3, 5126, false, 36, 24);
        GLES20.glUniformMatrix4fv(this.c.a, 1, false, b(), 0);
        GLES20.glBindBuffer(34963, this.e);
        GLES20.glDrawElements(4, i3 * 6, 5123, 0);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34963, 0);
        GLES20.glBindTexture(3553, 0);
        GLES20.glDisableVertexAttribArray(this.c.b);
        GLES20.glDisableVertexAttribArray(this.c.c);
        GLES20.glDisable(3042);
        GLES20.glUseProgram(0);
    }

    public synchronized boolean a(Bitmap bitmap, x xVar) {
        ew.c a2 = this.n.a(bitmap.getWidth() + 1, bitmap.getHeight() + 1, xVar.p());
        if (a2 != null) {
            xVar.f(a2.a / this.n.a());
            xVar.e(a2.b / this.n.b());
            xVar.g(((a2.a + a2.c) - 1) / this.n.a());
            xVar.h(((a2.b + a2.d) - 1) / this.n.b());
            xVar.c((a2.a + 0.5f) / this.n.a());
            xVar.d((a2.b + 0.5f) / this.n.b());
            xVar.a((((a2.a + a2.c) - 1) - 0.5f) / this.n.a());
            xVar.b((((a2.b + a2.d) - 1) - 0.5f) / this.n.b());
            xVar.a(true);
            return true;
        }
        return false;
    }

    public IOverlayImageDelegate a(String str) throws RemoteException {
        synchronized (this.f) {
            int size = this.f.size();
            for (int i = 0; i < size; i++) {
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(i);
                if (iOverlayImageDelegate != null && iOverlayImageDelegate.getId().equals(str)) {
                    return iOverlayImageDelegate;
                }
            }
            return null;
        }
    }

    public BaseOverlayImp a(MotionEvent motionEvent) {
        synchronized (this.f) {
            for (int size = this.f.size() - 1; size >= 0; size--) {
                IOverlayImageDelegate iOverlayImageDelegate = this.f.get(size);
                if ((iOverlayImageDelegate instanceof cu) && eq.a(iOverlayImageDelegate.getRect(), (int) motionEvent.getX(), (int) motionEvent.getY())) {
                    cu cuVar = (cu) iOverlayImageDelegate;
                    this.l = cuVar;
                    return cuVar;
                }
            }
            return null;
        }
    }

    public void a(x xVar) {
        synchronized (this.g) {
            if (xVar != null) {
                this.g.add(xVar);
            }
        }
    }
}
