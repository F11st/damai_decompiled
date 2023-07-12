package com.alipay.share.sdk.openapi.ui;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class Ui implements Serializable {
    private static final long serialVersionUID = 2077101865739221146L;
    public String skin;
    public Style style;

    public String getSkin() {
        return this.skin;
    }

    public Style getStyle() {
        return this.style;
    }

    public void setSkin(String str) {
        this.skin = str;
    }

    public void setStyle(Style style) {
        this.style = style;
    }
}
