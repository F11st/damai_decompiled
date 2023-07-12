package com.ali.user.open.ucc.util;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthService;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MtopRemoteAuth {
    public static void login(final LoginCallback loginCallback) {
        sendUT("OAUTH_LOGIN_ENTER");
        HashMap hashMap = new HashMap();
        hashMap.put("needSession", "1");
        ((OauthService) AliMemberSDK.getService(OauthService.class)).oauth(null, "taobao", hashMap, new OauthCallback() { // from class: com.ali.user.open.ucc.util.MtopRemoteAuth.1
            @Override // com.ali.user.open.oauth.OauthCallback
            public void onFail(String str, int i, String str2) {
                MtopRemoteAuth.sendUT("OAUTH_LOGIN_FAIL");
                LoginCallback loginCallback2 = LoginCallback.this;
                if (loginCallback2 != null) {
                    loginCallback2.onFailure(i, str2);
                }
            }

            @Override // com.ali.user.open.oauth.OauthCallback
            public void onSuccess(String str, Map map) {
                MtopRemoteAuth.sendUT("OAUTH_LOGIN_SUCCESS");
                LoginCallback loginCallback2 = LoginCallback.this;
                if (loginCallback2 != null) {
                    loginCallback2.onSuccess(null);
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendUT(String str) {
        try {
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_UccMtopAuthLogin", str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
