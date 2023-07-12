package com.amap.api.mapcore.util;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import com.alibaba.wireless.security.aopsdk.replace.android.graphics.Point;
import com.amap.api.mapcore.util.de;
import com.amap.api.mapcore.util.dq;
import com.amap.api.mapcore.util.et;
import com.amap.api.mapcore.util.eu;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlayOptions;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.ITileOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.lang.ref.WeakReference;
import java.nio.Buffer;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class dc implements ITileOverlayDelegate {
    private static int h;
    de.g a;
    private ab b;
    private TileProvider c;
    private Float d;
    private boolean e;
    private boolean f;
    private IAMapDelegate g;
    private int i;
    private int j;
    private int k;
    private er l;
    private List<a> m = new ArrayList();
    private boolean n = false;
    private b o = null;
    private String p;
    private FloatBuffer q;

    public dc(TileOverlayOptions tileOverlayOptions, ab abVar, boolean z) {
        eu.a aVar;
        this.f = false;
        this.i = 256;
        this.j = 256;
        this.k = -1;
        this.p = null;
        this.q = null;
        this.b = abVar;
        TileProvider tileProvider = tileOverlayOptions.getTileProvider();
        this.c = tileProvider;
        this.i = tileProvider.getTileWidth();
        this.j = this.c.getTileHeight();
        this.q = eq.a(new float[]{0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 0.0f});
        this.d = Float.valueOf(tileOverlayOptions.getZIndex());
        this.e = tileOverlayOptions.isVisible();
        this.f = z;
        if (z) {
            this.p = "TileOverlay0";
        } else {
            this.p = getId();
        }
        this.g = this.b.a();
        this.k = Integer.parseInt(this.p.substring(11));
        try {
            if (z) {
                aVar = new eu.a(this.b.f(), this.p, abVar.a().getMapConfig().getMapLanguage());
            } else {
                aVar = new eu.a(this.b.f(), this.p);
            }
            aVar.a(tileOverlayOptions.getMemoryCacheEnabled());
            if (this.f) {
                aVar.i = false;
            }
            aVar.b(tileOverlayOptions.getDiskCacheEnabled());
            aVar.a(tileOverlayOptions.getMemCacheSize());
            aVar.a(tileOverlayOptions.getDiskCacheSize());
            String diskCacheDir = tileOverlayOptions.getDiskCacheDir();
            if (diskCacheDir != null && !"".equals(diskCacheDir)) {
                aVar.a(diskCacheDir);
            }
            er erVar = new er(this.b.f(), this.i, this.j);
            this.l = erVar;
            erVar.a(this.c);
            this.l.a(aVar);
            this.l.a(new et.c() { // from class: com.amap.api.mapcore.util.dc.1
                @Override // com.amap.api.mapcore.util.et.c
                public void a() {
                    dc.this.g.resetRenderTimeLongLong();
                }
            });
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static String b(String str) {
        h++;
        return str + h;
    }

    private void c() {
        ab abVar = this.b;
        if (abVar == null || abVar.a() == null) {
            return;
        }
        this.a = (de.g) this.b.a().getGLShader(0);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void clearTileCache() {
        er erVar = this.l;
        if (erVar != null) {
            erVar.f();
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void destroy(boolean z) {
        b();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                this.m.get(i).b();
            }
            this.m.clear();
        }
        er erVar = this.l;
        if (erVar != null) {
            erVar.d(z);
            this.l.b(true);
            this.l.a((TileProvider) null);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void drawTiles() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                if (this.m.size() == 0) {
                    return;
                }
                int size = this.m.size();
                for (int i = 0; i < size; i++) {
                    a aVar = this.m.get(i);
                    if (!aVar.g) {
                        IPoint iPoint = aVar.e;
                        Bitmap bitmap = aVar.i;
                        if (bitmap != null && !bitmap.isRecycled() && iPoint != null) {
                            int a2 = eq.a(aVar.i);
                            aVar.f = a2;
                            if (a2 != 0) {
                                aVar.g = true;
                            }
                            aVar.i = null;
                        }
                    }
                    if (aVar.g) {
                        a(aVar);
                        a(aVar.f, aVar.h, this.q);
                    }
                }
            }
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean equalsRemote(ITileOverlay iTileOverlay) {
        return equals(iTileOverlay) || iTileOverlay.getId().equals(getId());
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public String getId() {
        if (this.p == null) {
            this.p = b("TileOverlay");
        }
        return this.p;
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public float getZIndex() {
        return this.d.floatValue();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public int hashCodeRemote() {
        return super.hashCode();
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public boolean isVisible() {
        return this.e;
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onFling(boolean z) {
        if (this.n != z) {
            this.n = z;
            er erVar = this.l;
            if (erVar != null) {
                erVar.b(z);
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onPause() {
        b();
        synchronized (this.m) {
            int size = this.m.size();
            for (int i = 0; i < size; i++) {
                this.m.get(i).b();
            }
            this.m.clear();
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void onResume() {
        er erVar = this.l;
        if (erVar != null) {
            erVar.a(false);
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void reLoadTexture() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                if (this.m.size() == 0) {
                    return;
                }
                for (a aVar : this.m) {
                    aVar.g = false;
                    aVar.f = 0;
                }
            }
        }
    }

    @Override // com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate
    public void refresh(boolean z) {
        if (this.n) {
            return;
        }
        b();
        a(z);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void remove() {
        this.b.b(this);
        this.g.setRunLowFrame(false);
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setVisible(boolean z) {
        this.e = z;
        this.g.setRunLowFrame(false);
        if (z) {
            refresh(true);
        }
    }

    @Override // com.autonavi.amap.mapcore.interfaces.ITileOverlay
    public void setZIndex(float f) {
        this.d = Float.valueOf(f);
        this.b.d();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class b extends dq<Void, Void, List<a>> {
        private int d;
        private boolean e;
        private int f;
        private int g;
        private int h;
        private WeakReference<IAMapDelegate> i;
        private List<a> j;
        private boolean k;
        private WeakReference<ab> l;
        private WeakReference<er> m;

        public b(boolean z, IAMapDelegate iAMapDelegate, int i, int i2, int i3, List<a> list, boolean z2, ab abVar, er erVar) {
            this.f = 256;
            this.g = 256;
            this.h = 0;
            this.e = z;
            this.i = new WeakReference<>(iAMapDelegate);
            this.f = i;
            this.g = i2;
            this.h = i3;
            this.j = list;
            this.k = z2;
            this.l = new WeakReference<>(abVar);
            this.m = new WeakReference<>(erVar);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public List<a> a(Void... voidArr) {
            try {
                IAMapDelegate iAMapDelegate = this.i.get();
                if (iAMapDelegate == null) {
                    return null;
                }
                int mapWidth = iAMapDelegate.getMapWidth();
                int mapHeight = iAMapDelegate.getMapHeight();
                int zoomLevel = (int) iAMapDelegate.getZoomLevel();
                this.d = zoomLevel;
                if (mapWidth > 0 && mapHeight > 0) {
                    return dc.b(iAMapDelegate, zoomLevel, this.f, this.g, this.h, this.l.get(), this.m.get());
                }
                return null;
            } catch (Throwable th) {
                th.printStackTrace();
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.amap.api.mapcore.util.dq
        public void a(List<a> list) {
            if (list == null) {
                return;
            }
            try {
                if (list.size() <= 0) {
                    return;
                }
                dc.b(this.i.get(), list, this.d, this.e, this.j, this.k, this.l.get(), this.m.get());
                list.clear();
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:23:0x018b A[ADDED_TO_REGION] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.util.ArrayList<com.amap.api.mapcore.util.dc.a> b(com.autonavi.base.amap.api.mapcore.IAMapDelegate r26, int r27, int r28, int r29, int r30, com.amap.api.mapcore.util.ab r31, com.amap.api.mapcore.util.er r32) {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dc.b(com.autonavi.base.amap.api.mapcore.IAMapDelegate, int, int, int, int, com.amap.api.mapcore.util.ab, com.amap.api.mapcore.util.er):java.util.ArrayList");
    }

    private boolean a(a aVar) {
        int i = this.i;
        int i2 = this.j;
        IPoint iPoint = aVar.e;
        int xVar = Point.getx(iPoint);
        int i3 = 1 << (20 - aVar.c);
        int i4 = i2 * i3;
        int yVar = Point.gety(iPoint) + i4;
        MapConfig mapConfig = this.g.getMapConfig();
        double d = xVar;
        double d2 = yVar;
        double d3 = xVar + (i3 * i);
        double d4 = yVar - i4;
        float[] fArr = {(float) (d - mapConfig.getSX()), (float) (d2 - mapConfig.getSY()), 0.0f, (float) (d3 - mapConfig.getSX()), (float) (d2 - mapConfig.getSY()), 0.0f, (float) (d3 - mapConfig.getSX()), (float) (d4 - mapConfig.getSY()), 0.0f, (float) (d - mapConfig.getSX()), (float) (d4 - mapConfig.getSY()), 0.0f};
        FloatBuffer floatBuffer = aVar.h;
        if (floatBuffer == null) {
            aVar.h = eq.a(fArr);
            return true;
        }
        aVar.h = eq.a(fArr, floatBuffer);
        return true;
    }

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    public static class a implements Cloneable {
        public int a;
        public int b;
        public int c;
        public int d;
        public IPoint e;
        public int f;
        public boolean g;
        public FloatBuffer h;
        public Bitmap i;
        public et.a j;
        public int k;
        private IAMapDelegate l;
        private ab m;
        private er n;

        public a(int i, int i2, int i3, int i4, IAMapDelegate iAMapDelegate, ab abVar, er erVar) {
            this.f = 0;
            this.g = false;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = 0;
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.l = iAMapDelegate;
            this.m = abVar;
            this.n = erVar;
        }

        /* renamed from: a */
        public a clone() {
            try {
                a aVar = (a) super.clone();
                aVar.a = this.a;
                aVar.b = this.b;
                aVar.c = this.c;
                aVar.d = this.d;
                aVar.e = (IPoint) this.e.clone();
                aVar.h = this.h.asReadOnlyBuffer();
                this.k = 0;
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
            return new a(this);
        }

        public void b() {
            try {
                et.a(this);
                if (this.g) {
                    this.m.a(this.f);
                }
                this.g = false;
                this.f = 0;
                Bitmap bitmap = this.i;
                if (bitmap != null && !bitmap.isRecycled()) {
                    eq.b(this.i);
                }
                this.i = null;
                FloatBuffer floatBuffer = this.h;
                if (floatBuffer != null) {
                    floatBuffer.clear();
                }
                this.h = null;
                this.j = null;
                this.k = 0;
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj instanceof a) {
                a aVar = (a) obj;
                return this.a == aVar.a && this.b == aVar.b && this.c == aVar.c && this.d == aVar.d;
            }
            return false;
        }

        public int hashCode() {
            return (this.a * 7) + (this.b * 11) + (this.c * 13) + this.d;
        }

        public String toString() {
            return this.a + "-" + this.b + "-" + this.c + "-" + this.d;
        }

        public synchronized void a(Bitmap bitmap) {
            if (bitmap != null) {
                if (!bitmap.isRecycled()) {
                    this.j = null;
                    this.i = bitmap;
                    this.l.setRunLowFrame(false);
                }
            }
            int i = this.k;
            if (i < 3) {
                this.k = i + 1;
                er erVar = this.n;
                if (erVar != null) {
                    erVar.a(true, this);
                }
            }
        }

        public a(a aVar) {
            this.f = 0;
            this.g = false;
            this.h = null;
            this.i = null;
            this.j = null;
            this.k = 0;
            this.a = aVar.a;
            this.b = aVar.b;
            this.c = aVar.c;
            this.d = aVar.d;
            this.e = aVar.e;
            this.h = aVar.h;
            this.k = 0;
            this.m = aVar.m;
            this.l = aVar.l;
            this.n = aVar.n;
        }
    }

    public void a() {
        List<a> list = this.m;
        if (list != null) {
            synchronized (list) {
                this.m.clear();
            }
        }
    }

    private void a(boolean z) {
        b bVar = new b(z, this.g, this.i, this.j, this.k, this.m, this.f, this.b, this.l);
        this.o = bVar;
        bVar.c((Object[]) new Void[0]);
    }

    public void a(String str) {
        b();
        a();
        er erVar = this.l;
        if (erVar != null) {
            erVar.b(true);
            this.l.a(str);
            this.l.b(false);
        }
        a(true);
    }

    private void a(int i, FloatBuffer floatBuffer, FloatBuffer floatBuffer2) {
        if (floatBuffer == null || floatBuffer2 == null || i == 0) {
            return;
        }
        de.g gVar = this.a;
        if (gVar == null || gVar.c()) {
            c();
        }
        this.a.a();
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(1, 771);
        GLES20.glBlendColor(1.0f, 1.0f, 1.0f, 1.0f);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, i);
        GLES20.glEnableVertexAttribArray(this.a.b);
        GLES20.glVertexAttribPointer(this.a.b, 3, 5126, false, 12, (Buffer) floatBuffer);
        GLES20.glEnableVertexAttribArray(this.a.c);
        GLES20.glVertexAttribPointer(this.a.c, 2, 5126, false, 8, (Buffer) floatBuffer2);
        GLES20.glUniformMatrix4fv(this.a.a, 1, false, this.b.h(), 0);
        GLES20.glDrawArrays(6, 0, 4);
        GLES20.glDisableVertexAttribArray(this.a.b);
        GLES20.glDisableVertexAttribArray(this.a.c);
        GLES20.glBindTexture(3553, 0);
        GLES20.glUseProgram(0);
        GLES20.glDisable(3042);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean b(IAMapDelegate iAMapDelegate, List<a> list, int i, boolean z, List<a> list2, boolean z2, ab abVar, er erVar) {
        int i2;
        boolean z3;
        if (list == null || list2 == null) {
            return false;
        }
        synchronized (list2) {
            Iterator<a> it = list2.iterator();
            while (true) {
                boolean z4 = true;
                if (!it.hasNext()) {
                    break;
                }
                a next = it.next();
                Iterator<a> it2 = list.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        z4 = false;
                        break;
                    }
                    a next2 = it2.next();
                    if (next.equals(next2) && (z3 = next.g)) {
                        next2.g = z3;
                        next2.f = next.f;
                        break;
                    }
                }
                if (!z4) {
                    next.b();
                }
            }
            list2.clear();
            if (i <= ((int) iAMapDelegate.getMaxZoomLevel()) && i >= ((int) iAMapDelegate.getMinZoomLevel())) {
                int size = list.size();
                if (size <= 0) {
                    return false;
                }
                for (int i3 = 0; i3 < size; i3++) {
                    a aVar = list.get(i3);
                    if (aVar != null) {
                        if (z2) {
                            if (abVar.a().getMapConfig().getMapLanguage().equals("zh_cn")) {
                                if (MapsInitializer.isLoadWorldGridMap()) {
                                    int i4 = aVar.c;
                                    if (i4 >= 6) {
                                        if (ej.a(aVar.a, aVar.b, i4)) {
                                        }
                                    }
                                }
                            } else if (!MapsInitializer.isLoadWorldGridMap() && (i2 = aVar.c) >= 6 && !ej.a(aVar.a, aVar.b, i2)) {
                            }
                        }
                        list2.add(aVar);
                        if (!aVar.g && erVar != null) {
                            erVar.a(z, aVar);
                        }
                    }
                }
                return true;
            }
            return false;
        }
    }

    private void b() {
        b bVar = this.o;
        if (bVar == null || bVar.a() != dq.e.RUNNING) {
            return;
        }
        this.o.a(true);
    }
}
