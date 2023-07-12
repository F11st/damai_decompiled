package com.ali.user.mobile.ui;

import android.content.Context;
import android.text.TextUtils;
import com.ali.user.mobile.base.ui.BaseActivity;
import com.ali.user.mobile.service.UIService;
import com.ali.user.mobile.webview.WebViewActivity;
import com.alimm.xadsdk.base.expose.MonitorType;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class UIServiceImpl implements UIService {
    @Override // com.ali.user.mobile.service.UIService
    public boolean finishWebViewActivity(Context context) {
        if (context instanceof WebViewActivity) {
            ((WebViewActivity) context).finish();
            return true;
        }
        return false;
    }

    @Override // com.ali.user.mobile.service.UIService
    public boolean isWebViewActivity(Context context) {
        return context instanceof WebViewActivity;
    }

    protected void setVisible(boolean z, BaseActivity baseActivity) {
        if (baseActivity != null) {
            try {
                if (baseActivity.getSupportActionBar() != null) {
                    if (z) {
                        baseActivity.getSupportActionBar().show();
                    } else {
                        baseActivity.getSupportActionBar().hide();
                    }
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    @Override // com.ali.user.mobile.service.UIService
    public void setWebViewTitleBarVisibility(Context context, boolean z) {
        if (context instanceof WebViewActivity) {
            setVisible(z, (WebViewActivity) context);
        }
    }

    @Override // com.ali.user.mobile.service.UIService
    public void switchWebViewTitleBarRightButton(Context context, boolean z, String str) {
        if (context instanceof WebViewActivity) {
            WebViewActivity webViewActivity = (WebViewActivity) context;
            if (TextUtils.equals(str, MonitorType.SKIP)) {
                webViewActivity.switchSkipMenu(z);
            } else {
                webViewActivity.switchHelpMenu(z, str);
            }
        }
    }
}
