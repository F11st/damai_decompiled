package com.ali.user.open.tbauth.ui;

import android.app.Activity;
import android.content.Intent;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.core.config.Environment;
import com.ali.user.open.core.service.StorageService;
import com.ali.user.open.core.trace.SDKLogger;
import com.ali.user.open.tbauth.RequestCode;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class ICBUAuthActivity extends TbAuthActivity {
    @Override // com.ali.user.open.tbauth.ui.TbAuthActivity
    protected void auth() {
        showH5Login(this);
    }

    public void showH5Login(Activity activity) {
        SDKLogger.d(TbAuthActivity.TAG, "open H5 login");
        Intent intent = new Intent(activity, TbAuthWebViewActivity.class);
        StringBuilder sb = new StringBuilder();
        if (ConfigManager.getInstance().getEnvironment().equals(Environment.TEST)) {
            sb.append(ConfigManager.ICBU_LOGIN_HOST_DAILY);
        } else {
            sb.append(ConfigManager.ICBU_LOGIN_HOST);
        }
        sb.append(((StorageService) AliMemberSDK.getService(StorageService.class)).getAppKey());
        if (ConfigManager.getInstance().getCurrentLanguage() != null) {
            sb.append("&lang=");
            sb.append(ConfigManager.getInstance().getCurrentLanguage().toString());
        }
        intent.putExtra("url", sb.toString());
        intent.putExtra("title", activity.getString(R.string.member_sdk_authorize_title));
        activity.startActivityForResult(intent, RequestCode.OPEN_ICBU_H5_LOGIN);
    }
}
