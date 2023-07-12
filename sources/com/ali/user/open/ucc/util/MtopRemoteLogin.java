package com.ali.user.open.ucc.util;

import com.ali.user.open.callback.LoginCallback;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.InitResultCallback;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.session.Session;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.UccService;
import com.ali.user.open.ucc.data.DefaultDataProvider;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class MtopRemoteLogin {
    private static final String TAG = "MtopRemoteLogin";

    public static Session getSession(String str) {
        try {
            return ((UccService) AliMemberSDK.getService(UccService.class)).getSession(str);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static void login(LoginCallback loginCallback) {
        login("taobao", loginCallback);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void sendUT(String str) {
        try {
            ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_UccMtopRemoteLogin", str, null);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void login(final String str, LoginCallback loginCallback) {
        SDKLogger.e(TAG, "TRUSTLOGIN_ENTER");
        if (System.currentTimeMillis() - UccStatus.getLastLoginTime(str) > 3000) {
            UccStatus.resetLoginFlag(str);
        }
        if (UccStatus.isLogining(str) && System.currentTimeMillis() - UccStatus.getLastLoginTime(str) < 180000) {
            UccCallbackManager.registerTrustLoginUccCallback(str, loginCallback);
            return;
        }
        UccStatus.compareAndSetLogining(str, false, true);
        UccCallbackManager.registerTrustLoginUccCallback(str, loginCallback);
        AliMemberSDK.init(KernelContext.getApplicationContext(), new InitResultCallback() { // from class: com.ali.user.open.ucc.util.MtopRemoteLogin.1
            @Override // com.ali.user.open.core.callback.FailureCallback
            public void onFailure(int i, String str2) {
            }

            @Override // com.ali.user.open.core.callback.InitResultCallback
            public void onSuccess() {
                if (((UccService) AliMemberSDK.getService(UccService.class)).getUccDataProvider() == null) {
                    ((UccService) AliMemberSDK.getService(UccService.class)).setUccDataProvider(new DefaultDataProvider());
                }
                ((UccService) AliMemberSDK.getService(UccService.class)).trustLogin(str, (Map<String, String>) null, new UccCallback() { // from class: com.ali.user.open.ucc.util.MtopRemoteLogin.1.1
                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onFail(String str2, int i, String str3) {
                        SDKLogger.e(MtopRemoteLogin.TAG, "TRUSTLOGIN_FAIL site=" + str2 + ";code=" + i);
                        MtopRemoteLogin.sendUT("TRUSTLOGIN_FAIL");
                        UccStatus.resetLoginFlag(str2);
                        if (UccCallbackManager.getTrustLoginCallbackWithSite(str2) != null) {
                            for (LoginCallback loginCallback2 : UccCallbackManager.getTrustLoginCallbackWithSite(str2)) {
                                if (loginCallback2 != null) {
                                    loginCallback2.onFailure(i, str3);
                                }
                            }
                            UccCallbackManager.unregisterTrustLoginCallback(str2);
                        }
                    }

                    @Override // com.ali.user.open.ucc.UccCallback
                    public void onSuccess(String str2, Map map) {
                        SDKLogger.e(MtopRemoteLogin.TAG, "TRUSTLOGIN_SUCCESS");
                        MtopRemoteLogin.sendUT("TRUSTLOGIN_SUCCESS");
                        UccStatus.resetLoginFlag(str2);
                        if (UccCallbackManager.getTrustLoginCallbackWithSite(str2) != null) {
                            for (LoginCallback loginCallback2 : UccCallbackManager.getTrustLoginCallbackWithSite(str2)) {
                                if (loginCallback2 != null) {
                                    loginCallback2.onSuccess(null);
                                }
                            }
                            UccCallbackManager.unregisterTrustLoginCallback(str2);
                        }
                    }
                });
            }
        });
    }
}
