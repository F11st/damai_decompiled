package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.model.MultiPointItem;
import com.amap.api.maps.model.MultiPointOverlayOptions;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.util.ArrayList;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class ax {
    C4505de a;
    private List<av> b = new ArrayList();
    private AMap.OnMultiPointClickListener c;
    private IAMapDelegate d;

    public ax(IAMapDelegate iAMapDelegate) {
        this.d = iAMapDelegate;
    }

    public C4505de a() {
        C4505de gLShaderManager = this.d.getGLShaderManager();
        this.a = gLShaderManager;
        return gLShaderManager;
    }

    public synchronized void b() {
        this.c = null;
        synchronized (this.b) {
            for (av avVar : this.b) {
                avVar.destroy(false);
            }
            this.b.clear();
        }
    }

    public synchronized void c() {
        try {
            synchronized (this.b) {
                this.b.clear();
            }
        } finally {
        }
    }

    public void d() {
        IAMapDelegate iAMapDelegate = this.d;
        if (iAMapDelegate != null) {
            iAMapDelegate.setRunLowFrame(false);
        }
    }

    public synchronized IMultiPointOverlay a(MultiPointOverlayOptions multiPointOverlayOptions) throws RemoteException {
        if (multiPointOverlayOptions == null) {
            return null;
        }
        aw awVar = new aw(multiPointOverlayOptions, this);
        a((av) awVar);
        return awVar;
    }

    private void a(av avVar) throws RemoteException {
        synchronized (this.b) {
            this.b.add(avVar);
        }
    }

    public void a(MapConfig mapConfig, float[] fArr, float[] fArr2) {
        try {
            synchronized (this.b) {
                for (av avVar : this.b) {
                    avVar.a(mapConfig, fArr, fArr2);
                }
            }
        } catch (Throwable th) {
            hd.c(th, "MultiPointOverlayManagerLayer", "draw");
            th.printStackTrace();
        }
    }

    public boolean a(IPoint iPoint) {
        MultiPointItem onClick;
        if (this.c == null) {
            return false;
        }
        synchronized (this.b) {
            for (av avVar : this.b) {
                if (avVar != null && (onClick = avVar.onClick(iPoint)) != null) {
                    AMap.OnMultiPointClickListener onMultiPointClickListener = this.c;
                    return onMultiPointClickListener != null ? onMultiPointClickListener.onPointClick(onClick) : false;
                }
            }
            return false;
        }
    }

    public void a(AMap.OnMultiPointClickListener onMultiPointClickListener) {
        this.c = onMultiPointClickListener;
    }

    public void a(aw awVar) {
        this.b.remove(awVar);
    }
}
