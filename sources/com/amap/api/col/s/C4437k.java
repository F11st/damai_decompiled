package com.amap.api.col.s;

import android.content.Context;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.district.DistrictResult;
import com.amap.api.services.district.DistrictSearchQuery;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.amap.api.col.s.k */
/* loaded from: classes10.dex */
public final class C4437k extends AbstractC4379b<DistrictSearchQuery, DistrictResult> {
    public C4437k(Context context, DistrictSearchQuery districtSearchQuery) {
        super(context, districtSearchQuery);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    /* renamed from: c */
    public DistrictResult a(String str) throws AMapException {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        DistrictResult districtResult = new DistrictResult((DistrictSearchQuery) ((AbstractC4370a) this).b, arrayList);
        try {
            JSONObject jSONObject = new JSONObject(str);
            districtResult.setPageCount(jSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT));
            optJSONArray = jSONObject.optJSONArray("districts");
        } catch (JSONException e) {
            C4435i.a(e, "DistrictServerHandler", "paseJSONJSONException");
        } catch (Exception e2) {
            C4435i.a(e2, "DistrictServerHandler", "paseJSONException");
        }
        if (optJSONArray == null) {
            return districtResult;
        }
        C4443q.a(optJSONArray, arrayList, null);
        return districtResult;
    }

    @Override // com.amap.api.col.s.AbstractC4379b, com.amap.api.col.s.AbstractC4370a
    protected final String a_() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("output=json");
        stringBuffer.append("&page=");
        stringBuffer.append(((DistrictSearchQuery) ((AbstractC4370a) this).b).getPageNum());
        stringBuffer.append("&offset=");
        stringBuffer.append(((DistrictSearchQuery) ((AbstractC4370a) this).b).getPageSize());
        if (((DistrictSearchQuery) ((AbstractC4370a) this).b).isShowBoundary()) {
            stringBuffer.append("&extensions=all");
        } else {
            stringBuffer.append("&extensions=base");
        }
        if (((DistrictSearchQuery) ((AbstractC4370a) this).b).checkKeyWords()) {
            String b = AbstractC4379b.b(((DistrictSearchQuery) ((AbstractC4370a) this).b).getKeywords());
            stringBuffer.append("&keywords=");
            stringBuffer.append(b);
        }
        stringBuffer.append("&key=" + bk.f(((AbstractC4370a) this).e));
        stringBuffer.append("&subdistrict=" + String.valueOf(((DistrictSearchQuery) ((AbstractC4370a) this).b).getSubDistrict()));
        return stringBuffer.toString();
    }

    @Override // com.amap.api.col.s.df
    public final String h() {
        return C4434h.a() + "/config/district?";
    }
}
