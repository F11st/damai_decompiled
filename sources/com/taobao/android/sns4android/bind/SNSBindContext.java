package com.taobao.android.sns4android.bind;

import android.app.Activity;
import android.content.Intent;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.taobao.android.sns4android.AuthCallback;
import com.taobao.android.sns4android.jsbridge.SNSJsbridge;
import java.lang.ref.WeakReference;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class SNSBindContext {
    public static int OPEN_TAOBAO = 59995;
    public static volatile WeakReference<Activity> activity;
    public static volatile Object loginCallback;
    public static volatile Object sBindCallback;

    public static void onActivityResult(Activity activity2, int i, int i2, Intent intent) {
        AuthCallback authCallback = (AuthCallback) loginCallback;
        if (i != OPEN_TAOBAO || authCallback == null) {
            return;
        }
        if (i2 == -1 && intent != null) {
            SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
            sNSSignInAccount.token = intent.getStringExtra("result");
            authCallback.onSuccess(sNSSignInAccount);
        } else if (i2 == 0) {
            onLoginFailure("用户取消", authCallback, 1007);
        } else {
            onLoginFailure(SNSJsbridge.TAOBAO_ERROR_MESSAGE, authCallback, 1008);
        }
    }

    private static void onLoginFailure(String str, AuthCallback authCallback, int i) {
        if (authCallback != null) {
            authCallback.onFail(i, str);
        }
    }

    public static void setActivity(Activity activity2) {
        activity = new WeakReference<>(activity2);
    }
}
