package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.b.a;
import com.sina.weibo.sdk.b.c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.h;
import com.sina.weibo.sdk.web.WebActivity;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public final class a {
    public WbAuthListener d;

    public final void a(Activity activity) {
        c.a("WBSsoTag", "startClientAuth()");
        try {
            a.C0273a e = com.sina.weibo.sdk.b.a.e(activity);
            Intent intent = new Intent();
            if (e == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(e.packageName, e.ag);
            }
            AuthInfo a = com.sina.weibo.sdk.a.a();
            intent.putExtra("appKey", a.getAppKey());
            intent.putExtra("redirectUri", a.getRedirectUrl());
            intent.putExtra("scope", a.getScope());
            intent.putExtra("packagename", a.getPackageName());
            intent.putExtra("key_hash", a.getHash());
            intent.putExtra("_weibo_command_type", 3);
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            intent.putExtra("_weibo_transaction", sb.toString());
            if (activity == null) {
                this.d.onError(new UiError(-1, "activity is null", ""));
            } else if (com.sina.weibo.sdk.b.a.a(activity, intent)) {
                activity.startActivityForResult(intent, 32973);
                c.a("WBSsoTag", "start SsoActivity ");
            } else {
                this.d.onError(new UiError(-2, "your app is illegal", ""));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            c.b("WBSsoTag", e2.getMessage());
            this.d.onError(new UiError(-3, "occur exception", e2.getMessage()));
        }
    }

    public final void b(Activity activity) {
        h hVar = new h();
        AuthInfo a = com.sina.weibo.sdk.a.a();
        if (a == null) {
            return;
        }
        hVar.put("client_id", a.getAppKey());
        hVar.put("redirect_uri", a.getRedirectUrl());
        hVar.put("scope", a.getScope());
        hVar.put("packagename", a.getPackageName());
        hVar.put("key_hash", a.getHash());
        hVar.put("response_type", "code");
        hVar.put("version", "0041005000");
        hVar.put("luicode", "10000360");
        hVar.put("lfid", "OP_" + a.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                hVar.put("trans_token", accessToken);
                hVar.put("trans_access_token", accessToken);
            }
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + hVar.g();
        if (this.d != null) {
            b b = b.b();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            b.a(sb2, this.d);
            Intent intent = new Intent(activity, WebActivity.class);
            com.sina.weibo.sdk.web.b.a aVar = new com.sina.weibo.sdk.web.b.a(a, str, sb2);
            Bundle bundle = new Bundle();
            aVar.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
