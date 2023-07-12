package cn.damai.wxapi.sinamodel;

import android.text.TextUtils;
import cn.damai.common.app.ShareperfenceConstants;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.amap.api.services.district.DistrictSearchQuery;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Geo {
    private static transient /* synthetic */ IpChange $ipChange;
    public String address;
    public String city;
    public String city_name;
    public String latitude;
    public String longitude;
    public String more;
    public String pinyin;
    public String province;
    public String province_name;

    public static Geo parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1949630425")) {
            return (Geo) ipChange.ipc$dispatch("1949630425", new Object[]{str});
        }
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Geo parse(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1386213543")) {
            return (Geo) ipChange.ipc$dispatch("1386213543", new Object[]{jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        Geo geo = new Geo();
        geo.longitude = jSONObject.optString("longitude");
        geo.latitude = jSONObject.optString("latitude");
        geo.city = jSONObject.optString("city");
        geo.province = jSONObject.optString(DistrictSearchQuery.KEYWORDS_PROVINCE);
        geo.city_name = jSONObject.optString(ShareperfenceConstants.CITY_NAME);
        geo.province_name = jSONObject.optString("province_name");
        geo.address = jSONObject.optString(ILocatable.ADDRESS);
        geo.pinyin = jSONObject.optString("pinyin");
        geo.more = jSONObject.optString("more");
        return geo;
    }
}
