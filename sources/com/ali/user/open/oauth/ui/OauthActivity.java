package com.ali.user.open.oauth.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.OauthPlatformConfig;
import com.ali.user.open.oauth.OauthServiceProviderFactory;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OauthActivity extends Activity {
    public static final String TAG = "UccActivity";
    public static OauthCallback mOauthCallback;
    LinearLayout hiddenLayout;
    private String targetSite;

    protected void auth() {
        Intent intent = getIntent();
        if (intent == null) {
            finish();
            return;
        }
        String stringExtra = intent.getStringExtra("targetSite");
        this.targetSite = stringExtra;
        if (TextUtils.isEmpty(stringExtra)) {
            finish();
            return;
        }
        String stringExtra2 = intent.getStringExtra("params");
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(stringExtra2)) {
            for (Map.Entry<String, Object> entry : JSON.parseObject(stringExtra2).entrySet()) {
                if (entry != null) {
                    StringBuilder sb = new StringBuilder();
                    Map.Entry<String, Object> entry2 = entry;
                    sb.append((Object) entry2.getKey());
                    sb.append("");
                    String sb2 = sb.toString();
                    hashMap.put(sb2, entry2.getValue() + "");
                }
            }
        }
        AppCredential oauthConfigByPlatform = OauthPlatformConfig.getOauthConfigByPlatform(this.targetSite);
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(this.targetSite) == null) {
            finish();
            return;
        }
        OauthServiceProviderFactory.getInstance().getOauthServiceProvider(this.targetSite).oauth(this, this.targetSite, oauthConfigByPlatform, hashMap, mOauthCallback);
        this.hiddenLayout.setClickable(true);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        SDKLogger.d("UccActivity", "onActivityResult requestCode = " + i + " resultCode=" + i2);
        if (!TextUtils.equals(Site.QQ, this.targetSite) && !TextUtils.equals(Site.WEIBO, this.targetSite) && !TextUtils.equals("jiuyou", this.targetSite)) {
            if (!KernelContext.checkServiceValid()) {
                finish();
                return;
            }
            this.hiddenLayout.setClickable(true);
            this.hiddenLayout.setLongClickable(true);
            super.onActivityResult(i, i2, intent);
            return;
        }
        OauthServiceProviderFactory.getInstance().getOauthServiceProvider(this.targetSite).onActivityResult(i, i2, intent);
        finish();
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        LinearLayout linearLayout = new LinearLayout(this);
        this.hiddenLayout = linearLayout;
        linearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        setContentView(this.hiddenLayout);
        if (KernelContext.applicationContext == null) {
            KernelContext.applicationContext = getApplicationContext();
        }
        this.hiddenLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.open.oauth.ui.OauthActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                SDKLogger.e("UccActivity", "click to destroy");
                OauthActivity.this.finish();
            }
        });
        this.hiddenLayout.setClickable(true);
        this.hiddenLayout.setLongClickable(true);
        if (!KernelContext.checkServiceValid()) {
            SDKLogger.d("UccActivity", "static field null");
            finish();
            return;
        }
        SDKLogger.e("UccActivity", "before mtop call showLogin");
        auth();
    }

    @Override // android.app.Activity
    protected void onDestroy() {
        mOauthCallback = null;
        super.onDestroy();
    }

    @Override // android.app.Activity
    protected void onPause() {
        overridePendingTransition(0, 0);
        super.onPause();
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        if (KernelContext.checkServiceValid()) {
            return;
        }
        finish();
    }
}
