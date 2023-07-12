package com.autonavi.amap.mapcore.interfaces;

import com.amap.api.maps.model.CrossOverlay;
import com.autonavi.ae.gmap.gloverlay.AVectorCrossAttr;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public interface ICrossVectorOverlay {
    void remove();

    void setAttribute(AVectorCrossAttr aVectorCrossAttr);

    int setData(byte[] bArr);

    void setGenerateCrossImageListener(CrossOverlay.GenerateCrossImageListener generateCrossImageListener);

    void setImageMode(boolean z);

    void setVisible(boolean z);
}
