package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.col.s.C4373ae;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.ServiceSettings;
import com.amap.api.services.geocoder.GeocodeAddress;
import com.amap.api.services.geocoder.GeocodeQuery;
import java.util.ArrayList;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.o */
/* loaded from: classes10.dex */
public final class C4441o extends AbstractC4379b<GeocodeQuery, ArrayList<GeocodeAddress>> {
    public C4441o(Context context, GeocodeQuery geocodeQuery) {
        super(context, geocodeQuery);
    }

    private static ArrayList<GeocodeAddress> c(String str) throws AMapException {
        ArrayList<GeocodeAddress> arrayList = new ArrayList<>();
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has(AdUtConstants.XAD_UT_ARG_COUNT) && jSONObject.getInt(AdUtConstants.XAD_UT_ARG_COUNT) > 0) ? C4443q.g(jSONObject) : arrayList;
        } catch (JSONException e) {
            C4435i.a(e, "GeocodingHandler", "paseJSONJSONException");
            return arrayList;
        } catch (Exception e2) {
            C4435i.a(e2, "GeocodingHandler", "paseJSONException");
            return arrayList;
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    public final /* synthetic */ Object a(String str) throws AMapException {
        return c(str);
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json&address=");
        stringBuffer.append(AbstractC4379b.b(((GeocodeQuery) ((AbstractC4370a) this).b).getLocationName()));
        String city = ((GeocodeQuery) ((AbstractC4370a) this).b).getCity();
        if (!C4443q.g(city)) {
            String b = AbstractC4379b.b(city);
            stringBuffer.append("&city=");
            stringBuffer.append(b);
        }
        if (!C4443q.g(((GeocodeQuery) ((AbstractC4370a) this).b).getCountry())) {
            stringBuffer.append("&country=");
            stringBuffer.append(AbstractC4379b.b(((GeocodeQuery) ((AbstractC4370a) this).b).getCountry()));
        }
        stringBuffer.append("&key=" + bk.f(((AbstractC4370a) this).e));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.AbstractC4370a
    protected final C4373ae.C4375b d() {
        C4373ae.C4375b c4375b = new C4373ae.C4375b();
        c4375b.a = h() + a_() + "language=" + ServiceSettings.getInstance().getLanguage();
        return c4375b;
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/geocode/geo?";
    }
}
