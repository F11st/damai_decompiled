package com.ali.user.open.jsbridge;

import android.taobao.windvane.jsbridge.WVApiPlugin;
import android.taobao.windvane.jsbridge.WVCallBackContext;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.UserTrackerService;
import com.ut.mini.UTHitBuilders;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONObject;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UserTrackBridge extends WVApiPlugin {
    private void commitEvent(String str, WVCallBackContext wVCallBackContext) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            String optString = jSONObject.optString("page");
            int optInt = jSONObject.optInt("eventID");
            String optString2 = jSONObject.optString("arg1");
            String optString3 = jSONObject.optString("arg2");
            String optString4 = jSONObject.optString("args");
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(optString3)) {
                hashMap.put(UTHitBuilders.UTHitBuilder.FIELD_ARG2, optString3);
            }
            if (!TextUtils.isEmpty(optString4)) {
                try {
                    JSONObject jSONObject2 = new JSONObject(optString4);
                    Iterator<String> keys = jSONObject2.keys();
                    while (keys.hasNext()) {
                        String next = keys.next();
                        hashMap.put(next, jSONObject2.optString(next));
                    }
                } catch (Throwable unused) {
                }
            }
            if (optInt == 19999) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send(optString, optString2, hashMap);
            } else if (optInt == 2101) {
                ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).sendControl(optString, optString2, optString3, hashMap);
            }
        } catch (Throwable unused2) {
        }
    }

    @Override // android.taobao.windvane.jsbridge.WVApiPlugin
    public boolean execute(String str, String str2, WVCallBackContext wVCallBackContext) {
        if ("commitEvent".equals(str)) {
            commitEvent(str2, wVCallBackContext);
            return true;
        }
        wVCallBackContext.error();
        return false;
    }
}
