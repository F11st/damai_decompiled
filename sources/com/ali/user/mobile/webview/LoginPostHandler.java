package com.ali.user.mobile.webview;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.ali.user.mobile.filter.LoginFilterCallback;
import com.ali.user.mobile.ui.WebConstant;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class LoginPostHandler {
    public static LoginFilterCallback sCallback;

    public static void openPostPage(Context context, String str, LoginFilterCallback loginFilterCallback) {
        sCallback = loginFilterCallback;
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        intent.putExtra(WebConstant.WEB_POST_LOGIN, true);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
