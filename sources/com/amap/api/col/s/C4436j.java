package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.j */
/* loaded from: classes10.dex */
public final class C4436j extends AbstractC4379b<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String k;
    private final String l;
    private final String m;

    public C4436j(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.k = "/distance?";
        this.l = "|";
        this.m = ",";
    }

    private static DistanceResult c(String str) throws AMapException {
        return C4443q.i(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((AbstractC4370a) this).e));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i = 0; i < size; i++) {
                LatLonPoint latLonPoint = origins.get(i);
                if (latLonPoint != null) {
                    double a = C4435i.a(latLonPoint.getLatitude());
                    stringBuffer.append(C4435i.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a);
                    if (i < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getDestination();
        if (destination != null) {
            double a2 = C4435i.a(destination.getLatitude());
            double a3 = C4435i.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a3);
            stringBuffer.append(",");
            stringBuffer.append(a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getType());
        if (!TextUtils.isEmpty(((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((AbstractC4370a) this).b).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/distance?";
    }
}
