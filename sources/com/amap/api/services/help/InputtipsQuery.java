package com.amap.api.services.help;

import com.amap.api.services.core.LatLonPoint;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class InputtipsQuery implements Cloneable {
    private String a;
    private String b;
    private boolean c = false;
    private String d = null;
    private LatLonPoint e;

    public InputtipsQuery(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public String getCity() {
        return this.b;
    }

    public boolean getCityLimit() {
        return this.c;
    }

    public String getKeyword() {
        return this.a;
    }

    public LatLonPoint getLocation() {
        return this.e;
    }

    public String getType() {
        return this.d;
    }

    public void setCityLimit(boolean z) {
        this.c = z;
    }

    public void setLocation(LatLonPoint latLonPoint) {
        this.e = latLonPoint;
    }

    public void setType(String str) {
        this.d = str;
    }
}
