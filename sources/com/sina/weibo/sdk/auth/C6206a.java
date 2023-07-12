package com.sina.weibo.sdk.auth;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.sina.weibo.sdk.C6195a;
import com.sina.weibo.sdk.b.C6209a;
import com.sina.weibo.sdk.b.C6212c;
import com.sina.weibo.sdk.common.UiError;
import com.sina.weibo.sdk.net.C6225h;
import com.sina.weibo.sdk.web.WebActivity;
import com.sina.weibo.sdk.web.b.C6237a;

/* compiled from: Taobao */
/* renamed from: com.sina.weibo.sdk.auth.a */
/* loaded from: classes7.dex */
public final class C6206a {
    public WbAuthListener d;

    public final void a(Activity activity) {
        C6212c.a("WBSsoTag", "startClientAuth()");
        try {
            C6209a.C6210a e = C6209a.e(activity);
            Intent intent = new Intent();
            if (e == null) {
                intent.setClassName("com.sina.weibo", "com.sina.weibo.SSOActivity");
            } else {
                intent.setClassName(e.packageName, e.ag);
            }
            AuthInfo a = C6195a.a();
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
            } else if (C6209a.a(activity, intent)) {
                activity.startActivityForResult(intent, 32973);
                C6212c.a("WBSsoTag", "start SsoActivity ");
            } else {
                this.d.onError(new UiError(-2, "your app is illegal", ""));
            }
        } catch (Exception e2) {
            e2.printStackTrace();
            C6212c.b("WBSsoTag", e2.getMessage());
            this.d.onError(new UiError(-3, "occur exception", e2.getMessage()));
        }
    }

    public final void b(Activity activity) {
        C6225h c6225h = new C6225h();
        AuthInfo a = C6195a.a();
        if (a == null) {
            return;
        }
        c6225h.put("client_id", a.getAppKey());
        c6225h.put("redirect_uri", a.getRedirectUrl());
        c6225h.put("scope", a.getScope());
        c6225h.put("packagename", a.getPackageName());
        c6225h.put("key_hash", a.getHash());
        c6225h.put("response_type", "code");
        c6225h.put("version", "0041005000");
        c6225h.put("luicode", "10000360");
        c6225h.put("lfid", "OP_" + a.getAppKey());
        Oauth2AccessToken readAccessToken = AccessTokenHelper.readAccessToken(activity);
        if (readAccessToken != null) {
            String accessToken = readAccessToken.getAccessToken();
            if (!TextUtils.isEmpty(readAccessToken.getAccessToken())) {
                c6225h.put("trans_token", accessToken);
                c6225h.put("trans_access_token", accessToken);
            }
        }
        String str = "https://open.weibo.cn/oauth2/authorize?" + c6225h.g();
        if (this.d != null) {
            C6207b b = C6207b.b();
            StringBuilder sb = new StringBuilder();
            sb.append(System.currentTimeMillis());
            String sb2 = sb.toString();
            b.a(sb2, this.d);
            Intent intent = new Intent(activity, WebActivity.class);
            C6237a c6237a = new C6237a(a, str, sb2);
            Bundle bundle = new Bundle();
            c6237a.writeToBundle(bundle);
            intent.putExtras(bundle);
            activity.startActivity(intent);
        }
    }
}
