package com.amap.api.col.s;

import com.amap.api.col.s.C4373ae;
import com.amap.api.services.core.LatLonPoint;
import java.util.Iterator;
import java.util.LinkedHashMap;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
final class ag extends af {
    private double a;

    /* compiled from: Taobao */
    /* renamed from: com.amap.api.col.s.ag$a */
    /* loaded from: classes10.dex */
    static class C4377a {
        LatLonPoint a;
        double b;

        public C4377a(double d, double d2, double d3) {
            this.a = null;
            this.b = 0.0d;
            this.a = new LatLonPoint(d, d2);
            this.b = d3;
        }

        public final boolean a(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && C4377a.class == obj.getClass()) {
                LatLonPoint latLonPoint = this.a;
                C4377a c4377a = (C4377a) obj;
                LatLonPoint latLonPoint2 = c4377a.a;
                if (latLonPoint == latLonPoint2) {
                    return true;
                }
                if (latLonPoint != null && C4435i.a(latLonPoint, latLonPoint2) <= c4377a.b) {
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
    public final boolean a(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        String str;
        if (linkedHashMap != null && c4375b != null) {
            if (c4375b.b == null) {
                return super.a(linkedHashMap, c4375b);
            }
            for (C4373ae.C4375b c4375b2 : linkedHashMap.keySet()) {
                if (c4375b2 != null && (str = c4375b2.a) != null && str.equals(c4375b.a)) {
                    Object obj = c4375b2.b;
                    if ((obj instanceof C4377a) && ((C4377a) obj).a(c4375b.b)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.af
    public final Object b(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        String str;
        if (linkedHashMap != null && c4375b != null) {
            if (c4375b.b == null) {
                return super.b(linkedHashMap, c4375b);
            }
            for (C4373ae.C4375b c4375b2 : linkedHashMap.keySet()) {
                if (c4375b2 != null && (str = c4375b2.a) != null && str.equals(c4375b.a)) {
                    Object obj = c4375b2.b;
                    if ((obj instanceof C4377a) && ((C4377a) obj).a(c4375b.b)) {
                        return linkedHashMap.get(c4375b2);
                    }
                }
            }
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.af
    public final Object c(LinkedHashMap<C4373ae.C4375b, Object> linkedHashMap, C4373ae.C4375b c4375b) {
        C4373ae.C4375b c4375b2;
        String str;
        if (linkedHashMap != null && c4375b != null) {
            if (c4375b.b == null) {
                return super.c(linkedHashMap, c4375b);
            }
            Iterator<C4373ae.C4375b> it = linkedHashMap.keySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    c4375b2 = null;
                    break;
                }
                c4375b2 = it.next();
                if (c4375b2 != null && (str = c4375b2.a) != null && str.equals(c4375b.a)) {
                    Object obj = c4375b2.b;
                    if ((obj instanceof C4377a) && ((C4377a) obj).a(c4375b.b)) {
                        break;
                    }
                }
            }
            if (c4375b2 != null) {
                return linkedHashMap.remove(c4375b2);
            }
        }
        return null;
    }

    public final double a() {
        return this.a;
    }

    @Override // com.amap.api.col.s.af
    public final void a(C4373ae.C4374a c4374a) {
        super.a(c4374a);
        if (c4374a != null) {
            this.a = c4374a.d();
        }
    }
}
