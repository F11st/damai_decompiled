package com.ali.user.mobile.webview;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.ali.user.mobile.app.constant.UTConstant;
import com.ali.user.mobile.base.UIBaseConstants;
import com.ali.user.mobile.log.UserTrackAdapter;
import com.ali.user.mobile.model.LoginParam;
import com.ali.user.mobile.register.ui.AliUserRegisterActivity;
import com.ali.user.mobile.ui.WebConstant;
import com.ali.user.mobile.utils.UTConstans;
import com.alibaba.fastjson.JSON;
import com.youku.media.arch.instruments.statistics.ConfigReporter;
import java.util.Properties;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class AliUserRegisterWebviewActivity extends WebViewActivity {
    public static final String page = "Page_RegH5";
    public static final String spm = "a21et.b95736722";
    private String active_url = "_ap_action=registerActive";
    private Properties mUTProperties = new Properties();
    private String mPageFrom = "";
    private String mPageType = "";

    public static Intent getCallingIntent(Context context, String str, String str2, LoginParam loginParam) {
        Intent intent = new Intent(context, AliUserRegisterWebviewActivity.class);
        intent.putExtra(WebConstant.WEBURL, str);
        intent.putExtra("pageFrom", str2);
        if (loginParam != null) {
            intent.putExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM, JSON.toJSONString(loginParam));
        }
        return intent;
    }

    private void goRegister() {
        Intent callingIntent = AliUserRegisterActivity.getCallingIntent(this);
        callingIntent.addFlags(ConfigReporter.BIT_GETTER_IMP);
        callingIntent.addFlags(536870912);
        finish();
        startActivity(callingIntent);
    }

    private void loginAfterRegisterUT(String str, String str2) {
        try {
            Properties properties = new Properties();
            properties.setProperty("monitor", "T");
            UserTrackAdapter.sendUT(this.mPageFrom, "single_register_success", "", this.mPageType, properties);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private void regH5Hit(String str) {
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(this.mPageFrom, str, "", this.mPageType, properties);
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity
    protected boolean needToolbar() {
        return true;
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        regH5Hit("reg_h5_handle_cancel");
        Properties properties = new Properties();
        properties.setProperty("monitor", "T");
        UserTrackAdapter.sendUT(this.mPageFrom, "single_register_cancel", "", this.mPageType, properties);
        super.onBackPressed();
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        this.isLoginObserver = true;
        super.onCreate(bundle);
        if (getIntent() != null) {
            this.mPageFrom = getIntent().getStringExtra("pageFrom");
            this.mPageType = getIntent().getStringExtra(WebConstant.REG_TYPE);
            this.mOriginalLoginParam = getIntent().getStringExtra(UIBaseConstants.IntentExtrasNamesConstants.PARAM_LOGIN_PARAM);
            if (!TextUtils.isEmpty(this.mPageFrom)) {
                this.mUTProperties.put("scene", this.mPageFrom);
            }
        }
        try {
            if (getSupportActionBar() != null) {
                getSupportActionBar().show();
            }
            if (TextUtils.equals(this.mPageFrom, UTConstans.PageName.UT_PAGE_ONEKEY_REG_NEW)) {
                this.mPageType = "oneKeyRegister";
            } else {
                this.mPageType = UTConstant.Args.UT_MOBILE_REG;
            }
            regH5Hit("reg_h5_handle_commit");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onPause() {
        super.onPause();
        UserTrackAdapter.pageDisAppear(this);
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity, com.ali.user.mobile.base.ui.BaseActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onResume() {
        super.onResume();
        UserTrackAdapter.updatePageName(this, page, spm);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r16.contains(r14.active_url) == false) goto L5;
     */
    @Override // com.ali.user.mobile.webview.WebViewActivity
    @android.annotation.SuppressLint({"NewApi"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean overrideUrlLoading(com.uc.webview.export.WebView r15, java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 381
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ali.user.mobile.webview.AliUserRegisterWebviewActivity.overrideUrlLoading(com.uc.webview.export.WebView, java.lang.String):boolean");
    }

    @Override // com.ali.user.mobile.webview.WebViewActivity
    protected void sendCancelBroadcast() {
    }
}
