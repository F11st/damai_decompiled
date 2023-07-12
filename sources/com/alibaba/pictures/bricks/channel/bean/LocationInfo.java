package com.alibaba.pictures.bricks.channel.bean;

import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class LocationInfo implements Serializable {
    public long cityDamaiId;
    public double locationLat;
    public double locationLng;
    public String locationadd;
    public String locationgname;

    public LocationInfo() {
    }

    public LocationInfo(long j, double d, double d2, String str, String str2) {
        this.cityDamaiId = j;
        this.locationLat = d;
        this.locationLng = d2;
        this.locationadd = str;
        this.locationgname = str2;
    }
}
