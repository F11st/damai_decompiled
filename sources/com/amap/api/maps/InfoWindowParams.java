package com.amap.api.maps;

import android.view.View;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InfoWindowParams {
    public static final int INFOWINDOW_TYPE_IMAGE = 1;
    public static final int INFOWINDOW_TYPE_VIEW = 2;
    private int a = 2;
    private int b;
    private View c;
    private View d;

    public View getInfoContents() {
        return this.d;
    }

    public View getInfoWindow() {
        return this.c;
    }

    public int getInfoWindowType() {
        return this.a;
    }

    public long getInfoWindowUpdateTime() {
        return this.b;
    }

    public void setInfoContent(View view) {
        this.d = view;
    }

    public void setInfoWindow(View view) {
        this.c = view;
    }

    public void setInfoWindowType(int i) {
        this.a = i;
    }

    public void setInfoWindowUpdateTime(int i) {
        this.b = i;
    }
}
