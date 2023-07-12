package com.youku.passport.result;

import android.text.TextUtils;
import com.youku.usercenter.passport.api.result.Result;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class ModifyNicknameResult extends Result {
    public String mModifySuccessedNickname;

    public void parseFrom(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            if (!jSONObject.isNull("content")) {
                String optString = jSONObject.optString("content");
                if (!TextUtils.isEmpty(optString)) {
                    JSONObject jSONObject2 = new JSONObject(optString);
                    if (!jSONObject2.isNull("nickname")) {
                        this.mModifySuccessedNickname = jSONObject2.optString("nickname");
                    }
                }
            }
            if (!jSONObject.isNull("resultCode")) {
                setResultCode(jSONObject.optInt("resultCode"));
            }
            if (jSONObject.isNull("resultMsg")) {
                return;
            }
            setResultMsg(jSONObject.optString("resultMsg"));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.youku.passport.result.AbsResult
    public JSONObject toJson() {
        JSONObject jSONObject;
        try {
            jSONObject = super.toJson();
            try {
                JSONObject jSONObject2 = new JSONObject();
                if (!TextUtils.isEmpty(this.mModifySuccessedNickname)) {
                    jSONObject2.put("nickname", this.mModifySuccessedNickname);
                }
                jSONObject.put("content", jSONObject2);
            } catch (Throwable th) {
                th = th;
                th.printStackTrace();
                return jSONObject;
            }
        } catch (Throwable th2) {
            th = th2;
            jSONObject = null;
        }
        return jSONObject;
    }
}
