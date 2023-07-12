package com.amap.api.mapcore.util;

import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import javax.microedition.khronos.opengles.GL10;

/* compiled from: Taobao */
/* renamed from: com.amap.api.mapcore.util.cn */
/* loaded from: classes10.dex */
public abstract class AbstractC4498cn {
    private IAMapDelegate map;

    public void destroy() {
    }

    public abstract int getZIndex();

    public abstract void onDrawFrame(GL10 gl10);
}
