package com.amap.api.services.geocoder;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RegeocodeResult {
    private RegeocodeQuery a;
    private RegeocodeAddress b;

    public RegeocodeResult(RegeocodeQuery regeocodeQuery, RegeocodeAddress regeocodeAddress) {
        this.a = regeocodeQuery;
        this.b = regeocodeAddress;
    }

    public RegeocodeAddress getRegeocodeAddress() {
        return this.b;
    }

    public RegeocodeQuery getRegeocodeQuery() {
        return this.a;
    }

    public void setRegeocodeAddress(RegeocodeAddress regeocodeAddress) {
        this.b = regeocodeAddress;
    }

    public void setRegeocodeQuery(RegeocodeQuery regeocodeQuery) {
        this.a = regeocodeQuery;
    }
}
