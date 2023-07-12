package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Border implements Serializable {
    public String color;
    public String radius;
    public String width;

    /* renamed from: clone */
    public Border m1256clone() {
        Border border = new Border();
        border.width = this.width;
        border.color = this.color;
        border.radius = this.radius;
        return border;
    }
}
