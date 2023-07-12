package com.amap.api.col.s;

import com.amap.api.col.s.ae;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class ag extends af {
    private double a;

    /* compiled from: Taobao */
    /* loaded from: classes10.dex */
    static class a {
        LatLonPoint a;
        double b;

        public a(double d, double d2, double d3) {
            this.a = null;
            this.b = 0.0d;
            this.a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.a;
                a aVar = (a) obj;
                LatLonPoint latLonPoint2 = aVar.a;
                if (latLonPoint == latLonPoint2) {
                    return true;
                }
                if (latLonPoint != null && i.a(latLonPoint, latLonPoint2) <= aVar.b) {
                    return true;
                }
            }
            return false;
        }
    }

    public ag(String... strArr) {
        super(strArr);
        this.a = 0.0d;
        this.a = 0.0d;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.af
    public final boolean a(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.a(linkedHashMap, bVar);
            }
            for (ae.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    Object obj = bVar2.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.af
    public final Object b(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.b(linkedHashMap, bVar);
            }
            for (ae.b bVar2 : linkedHashMap.keySet()) {
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    Object obj = bVar2.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        return linkedHashMap.get(bVar2);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.af
    public final Object c(LinkedHashMap<ae.b, Object> linkedHashMap, ae.b bVar) {
        ae.b bVar2;
        String str;
        if (linkedHashMap != null && bVar != null) {
            if (bVar.b == null) {
                return super.c(linkedHashMap, bVar);
            }
            Iterator<ae.b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    bVar2 = null;
                    break;
                }
                bVar2 = it.next();
                if (bVar2 != null && (str = bVar2.a) != null && str.equals(bVar.a)) {
                    Object obj = bVar2.b;
                    if ((obj instanceof a) && ((a) obj).a(bVar.b)) {
                        break;
                    }
                }
            }
            if (bVar2 != null) {
                return linkedHashMap.remove(bVar2);
            }
        }
        return null;
    }

    public final double a() {
        return this.a;
    }

    @Override // com.amap.api.col.s.af
    public final void a(ae.a aVar) {
        super.a(aVar);
        if (aVar != null) {
            this.a = aVar.d();
        }
    }
}
