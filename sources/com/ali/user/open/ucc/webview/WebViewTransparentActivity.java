package com.ali.user.open.ucc.webview;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.callback.CallbackManager;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.WebViewOption;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.service.StatusBarService;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.core.util.CommonUtils;
import com.ali.user.open.ucc.R;
import com.ali.user.open.ucc.UccCallback;
import com.ali.user.open.ucc.model.UccParams;
import com.ali.user.open.ucc.util.UTHitConstants;
import com.ali.user.open.ucc.util.UTHitUtils;
import com.ali.user.open.ucc.util.UccConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class WebViewTransparentActivity extends UccWebViewActivity {
    public static final String TAG = "ucc.webdialog";
    private String page = "page_usercenterbind";

    @Override // com.ali.user.open.ucc.webview.UccWebViewActivity, com.ali.user.open.core.webview.BaseWebViewActivity
    protected int getLayout() {
        if (AliMemberSDK.getService(StatusBarService.class) != null && ((StatusBarService) AliMemberSDK.getService(StatusBarService.class)).getTransparentWebLayout() > 0) {
            return ((StatusBarService) AliMemberSDK.getService(StatusBarService.class)).getTransparentWebLayout();
        }
        return R.C2996layout.member_sdk_ucc_pop_layout;
    }

    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    protected void initViews(Bundle bundle) {
        Uri data;
        setContentView(getLayout());
        setActionBar();
        String stringExtra = getIntent().getStringExtra("url");
        if (TextUtils.isEmpty(stringExtra) && (data = getIntent().getData()) != null) {
            stringExtra = data.getQueryParameter("url");
            this.forceUcWebView = true;
            SDKLogger.e("ucc.webdialog", "read url fomr uri:");
        }
        if (getIntent() != null && TextUtils.equals(WebViewOption.UC.name(), getIntent().getStringExtra("webviewOption"))) {
            this.forceUcWebView = true;
        }
        this.memberWebView = createWebView();
        getResources().getDisplayMetrics();
        ((FrameLayout) findViewById(R.id.ali_user_webview_container)).addView(this.memberWebView.getWebView(), new FrameLayout.LayoutParams(-1, -1));
        this.memberWebView.getWebView().setBackgroundColor(0);
        if (this.memberWebView.getWebView().getBackground() != null) {
            this.memberWebView.getWebView().getBackground().setAlpha(0);
        }
        ((ImageView) findViewById(R.id.ali_ucc_close)).setOnClickListener(new View.OnClickListener() { // from class: com.ali.user.open.ucc.webview.WebViewTransparentActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                WebViewTransparentActivity.this.onBackHistory();
            }
        });
        TextView textView = (TextView) findViewById(R.id.ali_ucc_bind_title);
        if (!TextUtils.isEmpty(ConfigManager.getInstance().getBindTitle())) {
            textView.setText(ConfigManager.getInstance().getBindTitle());
        }
        SDKLogger.d("ucc.webdialog", "onCreate url=" + stringExtra);
        if (KernelContext.checkServiceValid() && !TextUtils.isEmpty(stringExtra)) {
            if (!CommonUtils.isNetworkAvailable()) {
                CommonUtils.toast("member_sdk_network_not_available_message");
                return;
            }
            try {
                this.memberWebView.resumeTimers();
                this.memberWebView.onResume();
            } catch (Exception unused) {
            }
            loadUrl(stringExtra);
            return;
        }
        finish();
    }

    @Override // com.ali.user.open.ucc.webview.UccWebViewActivity, com.ali.user.open.core.webview.BaseWebViewActivity
    public void onBackHistory() {
        if (this.memberWebView.canGoBack() && (this.memberWebView.getUrl().contains("authorization-notice") || this.memberWebView.getUrl().contains("agreement"))) {
            this.memberWebView.goBack();
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("spm", "a2h21.13789771.close.1");
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).sendControl(this.page, "close", "", hashMap);
        UTHitUtils.send(UTHitConstants.PageUccBind, "UccBind_Cancel", this.mUccParams, new HashMap());
        UccCallback uccCallback = (UccCallback) CallbackManager.getCallback(Integer.valueOf(UccConstants.UCC_H5_CALLBACK_TYPE));
        if (uccCallback != null) {
            if (this.mUccParams == null) {
                this.mUccParams = new UccParams();
            }
            uccCallback.onFail(this.mUccParams.bindSite, 1403, getResources().getString(R.string.member_sdk_cancel));
            CallbackManager.unregisterCallback(UccConstants.UCC_H5_CALLBACK_TYPE);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.ali.user.open.core.webview.BaseWebViewActivity
    public void setActionBar() {
    }

    @Override // com.ali.user.open.ucc.webview.UccWebViewActivity
    protected void showTitleBar(Uri uri) {
    }
}
