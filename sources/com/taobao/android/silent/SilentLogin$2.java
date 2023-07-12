package com.taobao.android.silent;

import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.base.helper.BroadCastHelper;
import com.ali.user.mobile.login.action.LoginResActions;
import com.taobao.login4android.constants.LoginStatus;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
final class SilentLogin$2 implements Runnable {
    final /* synthetic */ String val$message;

    SilentLogin$2(String str) {
        this.val$message = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        LoginStatus.setLastRefreshCookieTime(0L);
        Intent intent = new Intent(LoginResActions.LOGIN_NETWORK_ERROR);
        if (!TextUtils.isEmpty(this.val$message)) {
            intent.putExtra("message", this.val$message);
        }
        BroadCastHelper.sendLocalBroadCast(intent);
    }
}
