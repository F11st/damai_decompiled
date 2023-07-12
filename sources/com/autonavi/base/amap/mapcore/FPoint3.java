package com.autonavi.base.amap.mapcore;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class FPoint3 extends FPoint {
    public int colorIndex;

    public FPoint3() {
        this.colorIndex = -1;
    }

    public void setColorIndex(int i) {
        this.colorIndex = i;
    }

    public FPoint3(float f, float f2, int i) {
        super(f, f2);
        this.colorIndex = -1;
        this.colorIndex = i;
    }
}
