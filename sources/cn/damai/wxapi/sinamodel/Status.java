package cn.damai.wxapi.sinamodel;

import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class Status {
    private static transient /* synthetic */ IpChange $ipChange;
    public int attitudes_count;
    public String bmiddle_pic;
    public int comments_count;
    public String created_at;
    public boolean favorited;
    public Geo geo;
    public String id;
    public String idstr;
    public String in_reply_to_screen_name;
    public String in_reply_to_status_id;
    public String in_reply_to_user_id;
    public String mid;
    public int mlevel;
    public String original_pic;
    public ArrayList<String> pic_urls;
    public int reposts_count;
    public Status retweeted_status;
    public String source;
    public String text;
    public String thumbnail_pic;
    public boolean truncated;
    public User user;
    public Visible visible;

    public static Status parse(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "539619249")) {
            return (Status) ipChange.ipc$dispatch("539619249", new Object[]{str});
        }
        try {
            return parse(new JSONObject(str));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Status parse(JSONObject jSONObject) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-227731435")) {
            return (Status) ipChange.ipc$dispatch("-227731435", new Object[]{jSONObject});
        }
        if (jSONObject == null) {
            return null;
        }
        Status status = new Status();
        status.created_at = jSONObject.optString("created_at");
        status.id = jSONObject.optString("id");
        status.mid = jSONObject.optString("mid");
        status.idstr = jSONObject.optString("idstr");
        status.text = jSONObject.optString("text");
        status.source = jSONObject.optString("source");
        status.favorited = jSONObject.optBoolean("favorited", false);
        status.truncated = jSONObject.optBoolean("truncated", false);
        status.in_reply_to_status_id = jSONObject.optString("in_reply_to_status_id");
        status.in_reply_to_user_id = jSONObject.optString("in_reply_to_user_id");
        status.in_reply_to_screen_name = jSONObject.optString("in_reply_to_screen_name");
        status.thumbnail_pic = jSONObject.optString("thumbnail_pic");
        status.bmiddle_pic = jSONObject.optString("bmiddle_pic");
        status.original_pic = jSONObject.optString("original_pic");
        status.geo = Geo.parse(jSONObject.optJSONObject("geo"));
        status.user = User.parse(jSONObject.optJSONObject("user"));
        status.retweeted_status = parse(jSONObject.optJSONObject("retweeted_status"));
        status.reposts_count = jSONObject.optInt("reposts_count");
        status.comments_count = jSONObject.optInt("comments_count");
        status.attitudes_count = jSONObject.optInt("attitudes_count");
        status.mlevel = jSONObject.optInt("mlevel", -1);
        status.visible = Visible.parse(jSONObject.optJSONObject("visible"));
        JSONArray optJSONArray = jSONObject.optJSONArray("pic_urls");
        if (optJSONArray != null && optJSONArray.length() > 0) {
            int length = optJSONArray.length();
            status.pic_urls = new ArrayList<>(length);
            for (int i = 0; i < length; i++) {
                JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                if (optJSONObject != null) {
                    status.pic_urls.add(optJSONObject.optString("thumbnail_pic"));
                }
            }
        }
        return status;
    }
}
