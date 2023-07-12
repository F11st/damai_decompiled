package com.amap.api.mapcore.util;

import android.content.Context;
import android.os.RemoteException;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.overlays.ITileOverlayDelegate;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.ab */
/* loaded from: classes10.dex */
public class C4469ab {
    dc d;
    private IAMapDelegate f;
    private Context g;
    List<ITileOverlayDelegate> a = new ArrayList();
    C4470a b = new C4470a();
    List<Integer> c = new ArrayList();
    float[] e = new float[16];

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: com.amap.api.mapcore.util.ab$a */
    /* loaded from: classes10.dex */
    public static class C4470a implements Serializable, Comparator<Object> {
        C4470a() {
        }

        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            ITileOverlayDelegate iTileOverlayDelegate = (ITileOverlayDelegate) obj;
            ITileOverlayDelegate iTileOverlayDelegate2 = (ITileOverlayDelegate) obj2;
            if (iTileOverlayDelegate == null || iTileOverlayDelegate2 == null) {
                return 0;
            }
            try {
                return Float.compare(iTileOverlayDelegate.getZIndex(), iTileOverlayDelegate2.getZIndex());
            } catch (Throwable th) {
                hd.c(th, "TileOverlayView", "compare");
                th.printStackTrace();
                return 0;
            }
        }
    }

    public C4469ab(Context context, IAMapDelegate iAMapDelegate) {
        this.d = null;
        this.f = iAMapDelegate;
        this.g = context;
        TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new dt(256, 256, iAMapDelegate.getMapConfig()));
        tileProvider.memCacheSize(10485760);
        tileProvider.diskCacheSize(20480);
        this.d = new dc(tileProvider, this, true);
    }

    private boolean j() {
        if (this.f == null) {
            return false;
        }
        return MapsInitializer.isLoadWorldGridMap() || this.f.getMapConfig().getMapLanguage().equals("en");
    }

    public IAMapDelegate a() {
        return this.f;
    }

    public void b() {
        dc dcVar;
        try {
            for (Integer num : this.c) {
                eq.b(num.intValue());
            }
            this.c.clear();
            if (j() && (dcVar = this.d) != null) {
                dcVar.drawTiles();
            }
            synchronized (this.a) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                    if (iTileOverlayDelegate.isVisible()) {
                        iTileOverlayDelegate.drawTiles();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    public void c() {
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                if (iTileOverlayDelegate != null) {
                    iTileOverlayDelegate.destroy(true);
                }
            }
            this.a.clear();
        }
    }

    public void d() {
        synchronized (this.a) {
            Collections.sort(this.a, this.b);
        }
    }

    public void e() {
        dc dcVar = this.d;
        if (dcVar != null) {
            dcVar.onResume();
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                if (iTileOverlayDelegate != null) {
                    iTileOverlayDelegate.onResume();
                }
            }
        }
    }

    public Context f() {
        return this.g;
    }

    public void g() {
        c();
        dc dcVar = this.d;
        if (dcVar != null) {
            dcVar.onPause();
            this.d.destroy(false);
        }
        this.d = null;
    }

    public float[] h() {
        IAMapDelegate iAMapDelegate = this.f;
        if (iAMapDelegate != null) {
            return iAMapDelegate.getFinalMatrix();
        }
        return this.e;
    }

    public void i() {
        dc dcVar = this.d;
        if (dcVar != null) {
            dcVar.clearTileCache();
            eg.a(this.g, "Map3DCache", "time", (Object) Long.valueOf(System.currentTimeMillis()));
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                if (iTileOverlayDelegate != null) {
                    iTileOverlayDelegate.clearTileCache();
                }
            }
        }
    }

    public TileOverlay a(TileOverlayOptions tileOverlayOptions) throws RemoteException {
        if (tileOverlayOptions != null && tileOverlayOptions.getTileProvider() != null) {
            try {
                dc dcVar = new dc(tileOverlayOptions, this, false);
                a(dcVar);
                dcVar.refresh(true);
                this.f.setRunLowFrame(false);
                return new TileOverlay(dcVar);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        return null;
    }

    public void a(ITileOverlayDelegate iTileOverlayDelegate) {
        synchronized (this.a) {
            b(iTileOverlayDelegate);
            this.a.add(iTileOverlayDelegate);
        }
        d();
    }

    public boolean b(ITileOverlayDelegate iTileOverlayDelegate) {
        boolean remove;
        synchronized (this.a) {
            remove = this.a.remove(iTileOverlayDelegate);
        }
        return remove;
    }

    public void a(boolean z) {
        try {
            if (j()) {
                CameraPosition cameraPosition = this.f.getCameraPosition();
                if (cameraPosition == null) {
                    return;
                }
                if (cameraPosition.isAbroad && cameraPosition.zoom > 6.0f) {
                    if (this.f.getMapType() == 1) {
                        dc dcVar = this.d;
                        if (dcVar != null) {
                            dcVar.refresh(z);
                        }
                    } else {
                        dc dcVar2 = this.d;
                        if (dcVar2 != null) {
                            dcVar2.a();
                        }
                    }
                } else if (this.d != null) {
                    if (this.f.getMapConfig().getMapLanguage().equals("en")) {
                        this.d.refresh(z);
                    } else {
                        this.d.a();
                    }
                }
            }
            synchronized (this.a) {
                int size = this.a.size();
                for (int i = 0; i < size; i++) {
                    ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                    if (iTileOverlayDelegate != null && iTileOverlayDelegate.isVisible()) {
                        iTileOverlayDelegate.refresh(z);
                    }
                }
            }
        } catch (Throwable th) {
            hd.c(th, "TileOverlayView", "refresh");
        }
    }

    public void b(boolean z) {
        dc dcVar = this.d;
        if (dcVar != null) {
            dcVar.onFling(z);
        }
        synchronized (this.a) {
            int size = this.a.size();
            for (int i = 0; i < size; i++) {
                ITileOverlayDelegate iTileOverlayDelegate = this.a.get(i);
                if (iTileOverlayDelegate != null) {
                    iTileOverlayDelegate.onFling(z);
                }
            }
        }
    }

    public void a(int i) {
        this.c.add(Integer.valueOf(i));
    }

    public void a(String str) {
        dc dcVar = this.d;
        if (dcVar != null) {
            dcVar.a(str);
        }
    }
}
