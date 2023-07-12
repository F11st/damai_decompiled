package com.youku.css.dto;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Css implements Serializable {
    public String backgroundColor;
    public Border border;
    public String color;
    public Gradient gradient;

    /* renamed from: clone */
    public Css m1257clone() {
        Css css = new Css();
        css.color = this.color;
        css.backgroundColor = this.backgroundColor;
        Border border = this.border;
        if (border != null) {
            css.border = border.m1256clone();
        }
        Gradient gradient = this.gradient;
        if (gradient != null) {
            css.gradient = gradient.m1258clone();
        }
        return css;
    }
}
