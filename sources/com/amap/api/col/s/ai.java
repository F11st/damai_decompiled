package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.ae;
import com.amap.api.col.s.ag;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.RegeocodeAddress;
import com.amap.api.services.geocoder.RegeocodeQuery;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class ai extends b<RegeocodeQuery, RegeocodeAddress> {
    public ai(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e) {
            i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(q.a(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            q.a(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(q.c(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            q.b(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            q.a(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            q.c(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    private static ag j() {
        af a = ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        return a(true);
    }

    @Override // com.amap.api.col.s.a
    protected final ae.b d() {
        ag j = j();
        double a = j != null ? j.a() : 0.0d;
        ae.b bVar = new ae.b();
        bVar.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t = ((a) this).b;
        if (t != 0 && ((RegeocodeQuery) t).getPoint() != null) {
            bVar.b = new ag.a(((RegeocodeQuery) ((a) this).b).getPoint().getLatitude(), ((RegeocodeQuery) ((a) this).b).getPoint().getLongitude(), a);
        }
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/geocode/regeo?";
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(i.a(((RegeocodeQuery) ((a) this).b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(i.a(((RegeocodeQuery) ((a) this).b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((a) this).b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) ((a) this).b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((a) this).b).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) ((a) this).b).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((a) this).b).getExtensions())) {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) ((a) this).b).getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) ((a) this).b).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) ((a) this).b).getLatLonType());
        sb.append("&key=");
        sb.append(bk.f(((a) this).e));
        return sb.toString();
    }
}
