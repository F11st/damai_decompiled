package com.amap.api.maps.model;

import com.amap.api.mapcore.util.du;
import com.autonavi.amap.mapcore.DPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.amap.api.maps.model.a */
/* loaded from: classes10.dex */
class C4651a {
    private final du a;
    private final int b;
    private List<WeightedLatLng> c;
    private List<C4651a> d;

    /* JADX INFO: Access modifiers changed from: protected */
    public C4651a(du duVar) {
        this(duVar, 0);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(WeightedLatLng weightedLatLng) {
        DPoint point = weightedLatLng.getPoint();
        if (this.a.a(point.x, point.y)) {
            a(point.x, point.y, weightedLatLng);
        }
    }

    private C4651a(double d, double d2, double d3, double d4, int i) {
        this(new du(d, d2, d3, d4), i);
    }

    private C4651a(du duVar, int i) {
        this.d = null;
        this.a = duVar;
        this.b = i;
    }

    private void a(double d, double d2, WeightedLatLng weightedLatLng) {
        List<C4651a> list = this.d;
        if (list != null) {
            du duVar = this.a;
            if (d2 < duVar.f) {
                if (d < duVar.e) {
                    list.get(0).a(d, d2, weightedLatLng);
                    return;
                } else {
                    list.get(1).a(d, d2, weightedLatLng);
                    return;
                }
            } else if (d < duVar.e) {
                list.get(2).a(d, d2, weightedLatLng);
                return;
            } else {
                list.get(3).a(d, d2, weightedLatLng);
                return;
            }
        }
        if (this.c == null) {
            this.c = new ArrayList();
        }
        this.c.add(weightedLatLng);
        if (this.c.size() <= 50 || this.b >= 40) {
            return;
        }
        a();
    }

    private void a() {
        ArrayList arrayList = new ArrayList(4);
        this.d = arrayList;
        du duVar = this.a;
        arrayList.add(new C4651a(duVar.a, duVar.e, duVar.b, duVar.f, this.b + 1));
        List<C4651a> list = this.d;
        du duVar2 = this.a;
        list.add(new C4651a(duVar2.e, duVar2.c, duVar2.b, duVar2.f, this.b + 1));
        List<C4651a> list2 = this.d;
        du duVar3 = this.a;
        list2.add(new C4651a(duVar3.a, duVar3.e, duVar3.f, duVar3.d, this.b + 1));
        List<C4651a> list3 = this.d;
        du duVar4 = this.a;
        list3.add(new C4651a(duVar4.e, duVar4.c, duVar4.f, duVar4.d, this.b + 1));
        List<WeightedLatLng> list4 = this.c;
        this.c = null;
        for (WeightedLatLng weightedLatLng : list4) {
            a(weightedLatLng.getPoint().x, weightedLatLng.getPoint().y, weightedLatLng);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public Collection<WeightedLatLng> a(du duVar) {
        ArrayList arrayList = new ArrayList();
        a(duVar, arrayList);
        return arrayList;
    }

    private void a(du duVar, Collection<WeightedLatLng> collection) {
        if (this.a.a(duVar)) {
            List<C4651a> list = this.d;
            if (list != null) {
                for (C4651a c4651a : list) {
                    c4651a.a(duVar, collection);
                }
            } else if (this.c != null) {
                if (duVar.b(this.a)) {
                    collection.addAll(this.c);
                    return;
                }
                for (WeightedLatLng weightedLatLng : this.c) {
                    if (duVar.a(weightedLatLng.getPoint())) {
                        collection.add(weightedLatLng);
                    }
                }
            }
        }
    }
}
