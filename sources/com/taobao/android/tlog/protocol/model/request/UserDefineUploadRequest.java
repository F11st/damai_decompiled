package com.taobao.android.tlog.protocol.model.request;

import android.util.Log;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.taobao.android.tlog.protocol.model.CommandInfo;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class UserDefineUploadRequest {
    private String TAG = "TLOG.Protocol.UserDefineUploadRequest";
    public String bizCode;
    public String bizType;
    public Map<String, String> extraInfo;

    public void parse(JSON json, CommandInfo commandInfo) throws Exception {
        JSONObject jSONObject;
        JSONObject jSONObject2 = (JSONObject) json;
        if (jSONObject2.containsKey("bizType")) {
            this.bizType = jSONObject2.getString("bizType");
        }
        if (jSONObject2.containsKey("bizCode")) {
            this.bizCode = jSONObject2.getString("bizCode");
        }
        if (!jSONObject2.containsKey("extraInfo") || (jSONObject = jSONObject2.getJSONObject("extraInfo")) == null) {
            return;
        }
        try {
            if (jSONObject.size() > 0) {
                this.extraInfo = new HashMap();
                for (Map.Entry<String, Object> entry : jSONObject.entrySet()) {
                    this.extraInfo.put(entry.getKey(), (String) entry.getValue());
                }
            }
        } catch (Exception e) {
            Log.e(this.TAG, "user define upload error", e);
        }
    }
}
