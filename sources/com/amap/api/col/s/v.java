package com.amap.api.col.s;

import android.content.Context;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.nearby.NearbyInfo;
import com.amap.api.services.nearby.NearbySearch;
import com.amap.api.services.nearby.NearbySearchResult;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class v extends b<NearbySearch.NearbyQuery, NearbySearchResult> {
    private Context k;
    private NearbySearch.NearbyQuery l;

    public v(Context context, NearbySearch.NearbyQuery nearbyQuery) {
        super(context, nearbyQuery);
        this.k = context;
        this.l = nearbyQuery;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    /* renamed from: c */
    public NearbySearchResult a(String str) throws AMapException {
        try {
            JSONObject jSONObject = new JSONObject(str);
            boolean z = true;
            if (this.l.getType() != 1) {
                z = false;
            }
            ArrayList<NearbyInfo> a = q.a(jSONObject, z);
            NearbySearchResult nearbySearchResult = new NearbySearchResult();
            nearbySearchResult.setNearbyInfoList(a);
            return nearbySearchResult;
        } catch (JSONException e) {
            i.a(e, "NearbySearchHandler", "paseJSON");
            return null;
        }
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("key=");
        stringBuffer.append(bk.f(this.k));
        LatLonPoint centerPoint = this.l.getCenterPoint();
        if (centerPoint != null) {
            stringBuffer.append("&center=");
            stringBuffer.append(centerPoint.getLongitude());
            stringBuffer.append(",");
            stringBuffer.append(centerPoint.getLatitude());
        }
        stringBuffer.append("&radius=");
        stringBuffer.append(this.l.getRadius());
        stringBuffer.append("&limit=30");
        stringBuffer.append("&searchtype=");
        stringBuffer.append(this.l.getType());
        stringBuffer.append("&timerange=");
        stringBuffer.append(this.l.getTimeRange());
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.d() + "/nearby/around";
    }
}
