package com.youku.upsplayer.module;

import cn.damai.user.userprofile.FeedsViewModel;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.annotation.JSONField;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.youku.upsplayer.util.Logger;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Video {
    @JSONField(name = "audioOnly")
    public int audioOnly;
    @JSONField(name = "category_id")
    public int category_id;
    @JSONField(name = "category_letter_id")
    public String category_letter_id;
    @JSONField(name = "ctype")
    public String ctype;
    @JSONField(name = "encodeid")
    public String encodeid;
    @JSONField(name = "id")
    public int id;
    @JSONField(name = "logo")
    public String logo;
    @JSONField(name = "privacy")
    public String privacy;
    @JSONField(name = "seconds")
    public float seconds;
    @JSONField(name = "share_type")
    public String[] share_type;
    @JSONField(name = "smart_tile")
    public String smart_tile;
    @JSONField(name = "st_sorted")
    public String st_sorted;
    @JSONField(name = "stream_ext")
    public JSONObject stream_ext;
    @JSONField(name = "stream_types")
    public JSONObject stream_types;
    @JSONField(name = "subcategories")
    public SubCategories[] subcategories;
    @JSONField(name = IRequestConst.TAGS)
    public String[] tags;
    @JSONField(name = "title")
    public String title;
    @JSONField(name = "transfer_mode")
    public String transfer_mode;
    @JSONField(name = "type")
    public String[] type;
    @JSONField(name = FeedsViewModel.ARG_USERID)
    public int userid;
    @JSONField(name = "username")
    public String username;
    @JSONField(name = "vrType")
    public String vrType;
    @JSONField(name = "weburl")
    public String weburl;

    public List<String> getStreamByLanguage(String str) {
        JSONObject jSONObject = this.stream_types;
        if (jSONObject == null || str == null || jSONObject.get(str) == null || this.stream_types.get(str).toString() == null) {
            return null;
        }
        try {
            return JSON.parseArray(this.stream_types.get(str).toString(), String.class);
        } catch (JSONException e) {
            Logger.e("Video", e.toString());
            e.printStackTrace();
            return null;
        } catch (Exception e2) {
            Logger.e("Video", e2.toString());
            e2.printStackTrace();
            return null;
        }
    }

    public void getStreamExtInfoByLanguage(Map<String, String> map, String str, String str2) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        if (map == null || str == null || (jSONObject = this.stream_ext) == null || (jSONObject2 = jSONObject.getJSONObject(str)) == null) {
            return;
        }
        for (String str3 : jSONObject2.keySet()) {
            JSONObject jSONObject3 = jSONObject2.getJSONObject(str3);
            if (jSONObject3 != null) {
                map.put(str3, jSONObject3.getString(str2));
            }
        }
    }

    public String getStreamExtProperty(String str, String str2, String str3) {
        JSONObject jSONObject;
        JSONObject jSONObject2;
        JSONObject jSONObject3;
        if (str3 == null || str2 == null || str == null || (jSONObject = this.stream_ext) == null || (jSONObject2 = jSONObject.getJSONObject(str)) == null || (jSONObject3 = jSONObject2.getJSONObject(str2)) == null) {
            return null;
        }
        return jSONObject3.getString(str3);
    }

    public Map<String, List<String>> getStreamTypes() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        JSONObject jSONObject = this.stream_types;
        if (jSONObject == null) {
            return linkedHashMap;
        }
        for (String str : jSONObject.keySet()) {
            ArrayList arrayList = new ArrayList();
            JSONArray jSONArray = jSONObject.getJSONArray(str);
            for (int i = 0; i < jSONArray.size(); i++) {
                arrayList.add(jSONArray.getString(i));
            }
            linkedHashMap.put(str, arrayList);
        }
        return linkedHashMap;
    }
}
