package com.ali.user.mobile.webview;

import com.ali.user.mobile.ui.R;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserWebLoginTransparent extends WebViewActivity {
    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    protected int getLayoutContent() {
        return R.C2965layout.aliuser_login_web_trans;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    public void initViews() {
        super.initViews();
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
    }
}
