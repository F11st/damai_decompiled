package com.amap.api.col.s;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.col.s.C4373ae;
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
public final class ai extends AbstractC4379b<RegeocodeQuery, RegeocodeAddress> {
    public ai(Context context, RegeocodeQuery regeocodeQuery) {
        super(context, regeocodeQuery);
    }

    private static RegeocodeAddress c(String str) throws AMapException {
        JSONObject optJSONObject;
        RegeocodeAddress regeocodeAddress = new RegeocodeAddress();
        try {
            optJSONObject = new JSONObject(str).optJSONObject("regeocode");
        } catch (JSONException e) {
            C4435i.a(e, "ReverseGeocodingHandler", "paseJSON");
        }
        if (optJSONObject == null) {
            return regeocodeAddress;
        }
        regeocodeAddress.setFormatAddress(C4443q.a(optJSONObject, "formatted_address"));
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("addressComponent");
        if (optJSONObject2 != null) {
            C4443q.a(optJSONObject2, regeocodeAddress);
        }
        regeocodeAddress.setPois(C4443q.c(optJSONObject));
        JSONArray optJSONArray = optJSONObject.optJSONArray("roads");
        if (optJSONArray != null) {
            C4443q.b(optJSONArray, regeocodeAddress);
        }
        JSONArray optJSONArray2 = optJSONObject.optJSONArray("roadinters");
        if (optJSONArray2 != null) {
            C4443q.a(optJSONArray2, regeocodeAddress);
        }
        JSONArray optJSONArray3 = optJSONObject.optJSONArray("aois");
        if (optJSONArray3 != null) {
            C4443q.c(optJSONArray3, regeocodeAddress);
        }
        return regeocodeAddress;
    }

    private static ag j() {
        af a = C4373ae.a().a("regeo");
        if (a == null) {
            return null;
        }
        return (ag) a;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        return a(true);
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final C4373ae.C4375b d() {
        ag j = j();
        double a = j != null ? j.a() : 0.0d;
        C4373ae.C4375b c4375b = new C4373ae.C4375b();
        c4375b.a = h() + a(false) + "language=" + ServiceSettings.getInstance().getLanguage();
        T t = ((AbstractC4370a) this).b;
        if (t != 0 && ((RegeocodeQuery) t).getPoint() != null) {
            c4375b.b = new ag.C4377a(((RegeocodeQuery) ((AbstractC4370a) this).b).getPoint().getLatitude(), ((RegeocodeQuery) ((AbstractC4370a) this).b).getPoint().getLongitude(), a);
        }
        return c4375b;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/geocode/regeo?";
    }

    private String a(boolean z) {
        StringBuilder sb = new StringBuilder();
        sb.append("output=json&location=");
        if (z) {
            sb.append(C4435i.a(((RegeocodeQuery) ((AbstractC4370a) this).b).getPoint().getLongitude()));
            sb.append(",");
            sb.append(C4435i.a(((RegeocodeQuery) ((AbstractC4370a) this).b).getPoint().getLatitude()));
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((AbstractC4370a) this).b).getPoiType())) {
            sb.append("&poitype=");
            sb.append(((RegeocodeQuery) ((AbstractC4370a) this).b).getPoiType());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((AbstractC4370a) this).b).getMode())) {
            sb.append("&mode=");
            sb.append(((RegeocodeQuery) ((AbstractC4370a) this).b).getMode());
        }
        if (!TextUtils.isEmpty(((RegeocodeQuery) ((AbstractC4370a) this).b).getExtensions())) {
            sb.append("&extensions=");
            sb.append(((RegeocodeQuery) ((AbstractC4370a) this).b).getExtensions());
        } else {
            sb.append("&extensions=base");
        }
        sb.append("&radius=");
        sb.append((int) ((RegeocodeQuery) ((AbstractC4370a) this).b).getRadius());
        sb.append("&coordsys=");
        sb.append(((RegeocodeQuery) ((AbstractC4370a) this).b).getLatLonType());
        sb.append("&key=");
        sb.append(bk.f(((AbstractC4370a) this).e));
        return sb.toString();
    }
}
