package com.taobao.login4android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.alibaba.fastjson.JSONObject;
import com.taobao.login4android.jsbridge.SDKJSBridgeService;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginTestBroadcastReceiver extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        try {
            String action = intent.getAction();
            if (!TextUtils.isEmpty(action) && "com.ali.user.sdk.login.TEST_ACCOUNT_SSO".equals(action)) {
                String stringExtra = intent.getStringExtra("token");
                if (TextUtils.isEmpty(stringExtra)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("action", (Object) "testAccountSso");
                jSONObject.put("token", (Object) stringExtra);
                new SDKJSBridgeService().testSsoLogin(null, jSONObject.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
