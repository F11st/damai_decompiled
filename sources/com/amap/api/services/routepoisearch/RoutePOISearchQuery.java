package com.amap.api.services.routepoisearch;

import com.amap.api.col.s.C4435i;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.routepoisearch.RoutePOISearch;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class RoutePOISearchQuery implements Cloneable {
    private LatLonPoint a;
    private LatLonPoint b;
    private int c;
    private RoutePOISearch.RoutePOISearchType d;
    private int e;
    private List<LatLonPoint> f;

    public RoutePOISearchQuery(LatLonPoint latLonPoint, LatLonPoint latLonPoint2, int i, RoutePOISearch.RoutePOISearchType routePOISearchType, int i2) {
        this.e = 250;
        this.a = latLonPoint;
        this.b = latLonPoint2;
        this.c = i;
        this.d = routePOISearchType;
        this.e = i2;
    }

    public LatLonPoint getFrom() {
        return this.a;
    }

    public int getMode() {
        return this.c;
    }

    public List<LatLonPoint> getPolylines() {
        return this.f;
    }

    public int getRange() {
        return this.e;
    }

    public RoutePOISearch.RoutePOISearchType getSearchType() {
        return this.d;
    }

    public LatLonPoint getTo() {
        return this.b;
    }

    /* renamed from: clone */
    public RoutePOISearchQuery m238clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            C4435i.a(e, "RoutePOISearchQuery", "RoutePOISearchQueryclone");
        }
        List<LatLonPoint> list = this.f;
        if (list != null && list.size() > 0) {
            return new RoutePOISearchQuery(this.f, this.d, this.e);
        }
        return new RoutePOISearchQuery(this.a, this.b, this.c, this.d, this.e);
    }

    public RoutePOISearchQuery(List<LatLonPoint> list, RoutePOISearch.RoutePOISearchType routePOISearchType, int i) {
        this.e = 250;
        this.f = list;
        this.d = routePOISearchType;
        this.e = i;
    }
}
