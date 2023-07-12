package com.amap.api.col.s;

import android.content.Context;
import com.alibaba.aliweex.adapter.module.location.ILocatable;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.alimm.xadsdk.request.builder.IRequestConst;
import com.amap.api.services.cloud.CloudItem;
import com.amap.api.services.cloud.CloudItemDetail;
import com.amap.api.services.core.AMapException;
import com.amap.api.services.core.LatLonPoint;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public abstract class e<T, V> extends b<T, V> {
    public e(Context context, T t) {
        super(context, t);
        ((a) this).a = false;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static JSONArray a(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("data");
        if (optJSONObject != null) {
            return optJSONObject.optJSONArray("list");
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static int b(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("data");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("info")) == null) {
            return 0;
        }
        return optJSONObject.optInt(AdUtConstants.XAD_UT_ARG_COUNT);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static CloudItemDetail c(JSONObject jSONObject) throws JSONException {
        CloudItemDetail cloudItemDetail = new CloudItemDetail(q.a(jSONObject, "id"), new LatLonPoint(jSONObject.optDouble("point_y"), jSONObject.optDouble("point_x")), q.a(jSONObject, "title"), q.a(jSONObject, ILocatable.ADDRESS));
        cloudItemDetail.setCreatetime(q.a(jSONObject, "gmt_create"));
        cloudItemDetail.setUpdatetime(q.a(jSONObject, "gmt_modified"));
        if (jSONObject.has("_distance")) {
            String optString = jSONObject.optString("_distance");
            if (!c(optString)) {
                cloudItemDetail.setDistance(Integer.parseInt(optString));
            }
        }
        return cloudItemDetail;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.a, com.amap.api.col.s.df
    public final Map<String, String> f() {
        HashMap hashMap = new HashMap();
        hashMap.put("Content-Type", IRequestConst.CONTENT_TYPE_POST);
        hashMap.put("Accept-Encoding", "gzip");
        hashMap.put(IRequestConst.USER_AGENT, "AMAP SDK Android Search 9.2.0");
        hashMap.put("X-INFO", bn.a(((a) this).e));
        hashMap.put("platinfo", String.format("platform=Android&sdkversion=%s&product=%s", "9.2.0", "cloud"));
        hashMap.put("logversion", "2.1");
        return hashMap;
    }

    @Override // com.amap.api.col.s.b, com.amap.api.col.s.df
    public final byte[] g() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static void a(CloudItem cloudItem, JSONObject jSONObject) {
        Iterator<String> keys = jSONObject.keys();
        HashMap<String, String> hashMap = new HashMap<>();
        if (keys == null) {
            return;
        }
        while (keys.hasNext()) {
            String next = keys.next();
            if (next != null) {
                hashMap.put(next.toString(), jSONObject.optString(next.toString()));
            }
        }
        cloudItem.setCustomfield(hashMap);
    }

    @Override // com.amap.api.col.s.a
    protected final V a(byte[] bArr) throws AMapException {
        String str;
        try {
            str = new String(bArr, "utf-8");
        } catch (Exception e) {
            i.a(e, "ProtocalHandler", "loadData");
            str = null;
        }
        if (str == null || str.equals("")) {
            return null;
        }
        i.c(str);
        return a(str);
    }

    private static boolean c(String str) {
        return str == null || str.equals("") || str.equals("[]");
    }
}
