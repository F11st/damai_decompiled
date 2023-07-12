package com.amap.api.services.cloud;

import com.amap.api.services.cloud.CloudSearch;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class CloudResult {
    private int a;
    private ArrayList<CloudItem> b;
    private int c;
    private int d;
    private CloudSearch.Query e;
    private CloudSearch.SearchBound f;

    private CloudResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        this.e = query;
        this.c = i;
        this.d = i2;
        this.a = a(i);
        this.b = arrayList;
        this.f = searchBound;
    }

    private int a(int i) {
        int i2 = this.d;
        return ((i + i2) - 1) / i2;
    }

    public static CloudResult createPagedResult(CloudSearch.Query query, int i, CloudSearch.SearchBound searchBound, int i2, ArrayList<CloudItem> arrayList) {
        return new CloudResult(query, i, searchBound, i2, arrayList);
    }

    public final CloudSearch.SearchBound getBound() {
        return this.f;
    }

    public final ArrayList<CloudItem> getClouds() {
        return this.b;
    }

    public final int getPageCount() {
        return this.a;
    }

    public final CloudSearch.Query getQuery() {
        return this.e;
    }

    public final int getTotalCount() {
        return this.c;
    }
}
