package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Gradient implements Serializable {
    public String endColor;
    public String startColor;

    /* renamed from: clone */
    public Gradient m1258clone() {
        Gradient gradient = new Gradient();
        gradient.startColor = this.startColor;
        gradient.endColor = this.endColor;
        return gradient;
    }
}
