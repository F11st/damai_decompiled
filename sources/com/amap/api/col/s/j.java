package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.route.DistanceResult;
import com.amap.api.services.route.DistanceSearch;
import java.util.List;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class j extends b<DistanceSearch.DistanceQuery, DistanceResult> {
    private final String k;
    private final String l;
    private final String m;

    public j(Context context, DistanceSearch.DistanceQuery distanceQuery) {
        super(context, distanceQuery);
        this.k = "/distance?";
        this.l = "|";
        this.m = ",";
    }

    private static DistanceResult c(String str) throws AMapException {
        return q.i(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(((a) this).e));
        List<LatLonPoint> origins = ((DistanceSearch.DistanceQuery) ((a) this).b).getOrigins();
        if (origins != null && origins.size() > 0) {
            stringBuffer.append("&origins=");
            int size = origins.size();
            for (int i = 0; i < size; i++) {
                LatLonPoint latLonPoint = origins.get(i);
                if (latLonPoint != null) {
                    double a = i.a(latLonPoint.getLatitude());
                    stringBuffer.append(i.a(latLonPoint.getLongitude()));
                    stringBuffer.append(",");
                    stringBuffer.append(a);
                    if (i < size) {
                        stringBuffer.append("|");
                    }
                }
            }
        }
        LatLonPoint destination = ((DistanceSearch.DistanceQuery) ((a) this).b).getDestination();
        if (destination != null) {
            double a2 = i.a(destination.getLatitude());
            double a3 = i.a(destination.getLongitude());
            stringBuffer.append("&destination=");
            stringBuffer.append(a3);
            stringBuffer.append(",");
            stringBuffer.append(a2);
        }
        stringBuffer.append("&type=");
        stringBuffer.append(((DistanceSearch.DistanceQuery) ((a) this).b).getType());
        if (!TextUtils.isEmpty(((DistanceSearch.DistanceQuery) ((a) this).b).getExtensions())) {
            stringBuffer.append("&extensions=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((a) this).b).getExtensions());
        } else {
            stringBuffer.append("&extensions=base");
        }
        stringBuffer.append("&output=json");
        if (((DistanceSearch.DistanceQuery) ((a) this).b).getType() == 1) {
            stringBuffer.append("&strategy=");
            stringBuffer.append(((DistanceSearch.DistanceQuery) ((a) this).b).getMode());
        }
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/distance?";
    }
}
