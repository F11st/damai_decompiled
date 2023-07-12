package com.amap.api.maps.model;

import com.autonavi.amap.mapcore.interfaces.IMultiPointOverlay;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class MultiPointOverlay {
    IMultiPointOverlay a;

    public MultiPointOverlay(IMultiPointOverlay iMultiPointOverlay) {
        this.a = iMultiPointOverlay;
    }

    public void destroy() {
        IMultiPointOverlay iMultiPointOverlay = this.a;
        if (iMultiPointOverlay != null) {
            iMultiPointOverlay.destroy(true);
        }
    }

    public void remove() {
        IMultiPointOverlay iMultiPointOverlay = this.a;
        if (iMultiPointOverlay != null) {
            iMultiPointOverlay.remove(true);
        }
    }

    public void setAnchor(float f, float f2) {
        IMultiPointOverlay iMultiPointOverlay = this.a;
        if (iMultiPointOverlay != null) {
            iMultiPointOverlay.setAnchor(f, f2);
        }
    }

    public void setEnable(boolean z) {
        IMultiPointOverlay iMultiPointOverlay = this.a;
        if (iMultiPointOverlay != null) {
            iMultiPointOverlay.setVisible(z);
        }
    }

    public void setItems(List<MultiPointItem> list) {
        IMultiPointOverlay iMultiPointOverlay = this.a;
        if (iMultiPointOverlay != null) {
            iMultiPointOverlay.addItems(list);
        }
    }
}
