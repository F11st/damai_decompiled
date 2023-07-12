package cn.damai.commonbusiness.dynamicx.customwidget.textview;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes14.dex */
public class GradientBean implements Serializable {
    public float angle;
    public int endColor;
    public int startColor;

    public GradientBean(int i, int i2, float f) {
        this.startColor = i;
        this.endColor = i2;
        this.angle = f;
    }
}
