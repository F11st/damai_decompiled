package com.ta.utdid2.device;

import android.content.Context;
import android.text.TextUtils;
import com.ta.audid.Variables;
import com.ta.audid.upload.UtdidKeyFile;
import com.ta.audid.utils.UtdidLogger;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
class BizResponse {
    private static final String TAG_AUDID = "audid";
    private static final String TAG_CODE = "code";
    private static final String TAG_DATA = "data";
    private static final String TAG_UTDID = "utdid";
    int code = -1;

    BizResponse() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static boolean isSuccess(int i) {
        return i >= 0 && i != 10012;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static BizResponse parseResult(String str) {
        JSONObject jSONObject;
        BizResponse bizResponse = new BizResponse();
        try {
            JSONObject jSONObject2 = new JSONObject(str);
            if (jSONObject2.has("code")) {
                bizResponse.code = jSONObject2.getInt("code");
            }
            if (jSONObject2.has("data") && (jSONObject = jSONObject2.getJSONObject("data")) != null) {
                if (jSONObject.has("audid")) {
                    String string = jSONObject.getString("audid");
                    if (!TextUtils.isEmpty(string)) {
                        UtdidKeyFile.writeAudidFile(string);
                    }
                }
                if (jSONObject.has("utdid")) {
                    String string2 = jSONObject.getString("utdid");
                    if (UTUtdid.isValidUtdid(string2)) {
                        Context context = Variables.getInstance().getContext();
                        UtdidKeyFile.writeAppUtdidFile(string2);
                        UtdidKeyFile.writeUtdidToSettings(context, string2);
                        UtdidKeyFile.writeSdcardUtdidFile(string2);
                    }
                }
            }
            UtdidLogger.d("BizResponse", "content", str);
        } catch (JSONException e) {
            UtdidLogger.d("", e.toString());
        }
        return bizResponse;
    }
}
