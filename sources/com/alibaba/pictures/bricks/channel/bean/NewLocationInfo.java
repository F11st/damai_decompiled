package com.alibaba.pictures.bricks.channel.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class NewLocationInfo implements Serializable {
    public long cityDamaiId;
    public double locationLat;
    public double locationLng;
    public String locationgname;

    public NewLocationInfo() {
    }

    public NewLocationInfo(long j, String str, double d, double d2) {
        this.cityDamaiId = j;
        this.locationgname = str;
        this.locationLat = d;
        this.locationLng = d2;
    }
}
