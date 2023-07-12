package com.youku.passport.result;

import android.text.TextUtils;
import com.youku.usercenter.passport.api.result.Result;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class UnionTokenInfo extends Result {
    public String mExpiredTime;
    public String mUnionToken;

    public static UnionTokenInfo deserialize(String str) throws JSONException {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return deserialize(new JSONObject(str));
    }

    public void parseFrom(JSONObject jSONObject) {
        String optString;
        if (jSONObject == null) {
            return;
        }
        try {
            if (jSONObject.isNull("content") || (optString = jSONObject.optString("content")) == null || optString.isEmpty()) {
                return;
            }
            JSONObject jSONObject2 = new JSONObject(optString);
            if (!jSONObject2.isNull("unionToken")) {
                this.mUnionToken = jSONObject2.optString("unionToken");
            }
            if (jSONObject.isNull("expiredTime")) {
                return;
            }
            this.mExpiredTime = jSONObject2.optString("expiredTime");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.youku.passport.result.AbsResult
    public JSONObject toJson() {
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson();
        } catch (Throwable th) {
            th = th;
            jSONObject = null;
        }
        try {
            JSONObject jSONObject2 = new JSONObject();
            if (!TextUtils.isEmpty(this.mUnionToken)) {
                jSONObject2.put("unionToken", this.mUnionToken);
            }
            if (!TextUtils.isEmpty(this.mExpiredTime)) {
                jSONObject2.put("expiredTime", this.mExpiredTime);
            }
            jSONObject.put("content", jSONObject2);
        } catch (Throwable th2) {
            th = th2;
            th.printStackTrace();
            return jSONObject;
        }
        return jSONObject;
    }

    public static UnionTokenInfo deserialize(JSONObject jSONObject) throws JSONException {
        String optString;
        if (jSONObject == null || jSONObject == JSONObject.NULL || jSONObject.length() <= 0) {
            return null;
        }
        UnionTokenInfo unionTokenInfo = new UnionTokenInfo();
        if (!jSONObject.isNull("content") && (optString = jSONObject.optString("content")) != null && !optString.isEmpty()) {
            JSONObject jSONObject2 = new JSONObject(optString);
            if (!jSONObject.isNull("unionToken")) {
                unionTokenInfo.mUnionToken = jSONObject2.optString("unionToken");
            }
            if (!jSONObject.isNull("expiredTime")) {
                unionTokenInfo.mExpiredTime = jSONObject2.optString("expiredTime");
            }
        }
        return unionTokenInfo;
    }
}
