package cn.damai.wxapi.sinamodel;

import com.amap.api.services.district.DistrictSearchQuery;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.tencent.open.SocialConstants;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class User {
    private static transient /* synthetic */ IpChange $ipChange;
    public boolean allow_all_act_msg;
    public boolean allow_all_comment;
    public String avatar_hd;
    public String avatar_large;
    public int bi_followers_count;
    public String block_word;
    public int city;
    public String created_at;
    public String description;
    public String domain;
    public int favourites_count;
    public boolean follow_me;
    public int followers_count;
    public boolean following;
    public int friends_count;
    public String gender;
    public boolean geo_enabled;
    public String id;
    public String idstr;
    public String lang;
    public String location;
    public String mbrank;
    public String mbtype;
    public String name;
    public int online_status;
    public String profile_image_url;
    public String profile_url;
    public int province;
    public String remark;
    public String screen_name;
    public String star;
    public Status status;
    public int statuses_count;
    public String url;
    public boolean verified;
    public String verified_reason;
    public int verified_type;
    public String weihao;

    public static User parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1683082367")) {
            return (User) ipChange.ipc$dispatch("1683082367", new Object[]{str});
        }
        try {
            return parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static User parse(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2024117621")) {
            return (User) ipChange.ipc$dispatch("2024117621", new Object[]{jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        User user = new User();
        user.id = jSONObject.optString("id", "");
        user.idstr = jSONObject.optString("idstr", "");
        user.screen_name = jSONObject.optString("screen_name", "");
        user.name = jSONObject.optString("name", "");
        user.province = jSONObject.optInt(DistrictSearchQuery.KEYWORDS_PROVINCE, -1);
        user.city = jSONObject.optInt("city", -1);
        user.location = jSONObject.optString("location", "");
        user.description = jSONObject.optString(SocialConstants.PARAM_COMMENT, "");
        user.url = jSONObject.optString("url", "");
        user.profile_image_url = jSONObject.optString("profile_image_url", "");
        user.profile_url = jSONObject.optString("profile_url", "");
        user.domain = jSONObject.optString("domain", "");
        user.weihao = jSONObject.optString("weihao", "");
        user.gender = jSONObject.optString("gender", "");
        user.followers_count = jSONObject.optInt("followers_count", 0);
        user.friends_count = jSONObject.optInt("friends_count", 0);
        user.statuses_count = jSONObject.optInt("statuses_count", 0);
        user.favourites_count = jSONObject.optInt("favourites_count", 0);
        user.created_at = jSONObject.optString("created_at", "");
        user.following = jSONObject.optBoolean("following", false);
        user.allow_all_act_msg = jSONObject.optBoolean("allow_all_act_msg", false);
        user.geo_enabled = jSONObject.optBoolean("geo_enabled", false);
        user.verified = jSONObject.optBoolean("verified", false);
        user.verified_type = jSONObject.optInt("verified_type", -1);
        user.remark = jSONObject.optString("remark", "");
        user.allow_all_comment = jSONObject.optBoolean("allow_all_comment", true);
        user.avatar_large = jSONObject.optString("avatar_large", "");
        user.avatar_hd = jSONObject.optString("avatar_hd", "");
        user.verified_reason = jSONObject.optString("verified_reason", "");
        user.follow_me = jSONObject.optBoolean("follow_me", false);
        user.online_status = jSONObject.optInt("online_status", 0);
        user.bi_followers_count = jSONObject.optInt("bi_followers_count", 0);
        user.lang = jSONObject.optString("lang", "");
        user.star = jSONObject.optString("star", "");
        user.mbtype = jSONObject.optString("mbtype", "");
        user.mbrank = jSONObject.optString("mbrank", "");
        user.block_word = jSONObject.optString("block_word", "");
        return user;
    }
}
