package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.ae;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class o extends b<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public o(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has(AdUtConstants.XAD_UT_ARG_COUNT) && jSONObject.getInt(AdUtConstants.XAD_UT_ARG_COUNT) > 0) ? q.g(jSONObject) : arrayList;
        } catch (JSONException e) {
            i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(b.b(((GeocodeQuery) ((a) this).b).getLocationName()));
        String city = ((GeocodeQuery) ((a) this).b).getCity();
        if (!q.g(city)) {
            String b = b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!q.g(((GeocodeQuery) ((a) this).b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(b.b(((GeocodeQuery) ((a) this).b).getCountry()));
        }
        stringBuffer.append("&key=" + bk.f(((a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.a
    protected final ae.b d() {
        ae.b bVar = new ae.b();
        bVar.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return bVar;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return h.a() + "/geocode/geo?";
    }
}
