package com.ali.user.open.oauth.base;

import android.content.Context;
import android.content.Intent;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthServiceProvider;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public abstract class BaseOauthServiceProviderImpl implements OauthServiceProvider {
    public static final String TAG = "oa.DamaiOauthServiceProviderImpl";

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void cleanUp() {
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isAppAuthSurpport(Context context) {
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void refreshWhenLogin(String str, boolean z) {
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void tokenLogin(String str, String str2, String str3, Map<String, String> map, OauthCallback oauthCallback) {
    }
}
