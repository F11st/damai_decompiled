package com.taobao.android.sso.v2.result;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.info.AlipayInfo;
import com.alipay.auth.mobile.api.IAlipayAuthEventHandler;
import com.taobao.android.sso.v2.launch.SsoLogin;
import com.youku.android.utils.OPRUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ResultActivity extends Activity implements IAlipayAuthEventHandler {
    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
    public void alipayAuthDidCancel() {
        alipayAuthFailure("1001");
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
    public void alipayAuthFailure() {
        alipayAuthFailure(OPRUtils.OPRPhoneLevel.OPR_PHONE_LEVEL_MEDIUM);
    }

    @Override // com.alipay.auth.mobile.api.IAlipayAuthEventHandler
    public void alipayAuthSuccess(String str) {
        String alipaySsoDesKey = DataProviderFactory.getDataProvider().getAlipaySsoDesKey();
        Intent intent = new Intent("alipay_sso_token");
        intent.putExtra("result", true);
        intent.putExtra("ssoToken", str);
        intent.putExtra("desKey", alipaySsoDesKey);
        intent.putExtra("uuid", AlipayInfo.getInstance().getApdidToken());
        LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).sendBroadcast(intent);
        finish();
    }

    @Override // android.app.Activity
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    @Override // android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ColorDrawable colorDrawable = new ColorDrawable(-1);
        colorDrawable.setAlpha(160);
        getWindow().setBackgroundDrawable(colorDrawable);
        if (SsoLogin.isAlipayAuthCallBack(getIntent())) {
            SsoLogin.handleAlipaySSOIntent(getIntent(), this);
        } else {
            finish();
        }
    }

    private void alipayAuthFailure(String str) {
        Intent intent = new Intent("alipay_sso_token");
        intent.putExtra("result", false);
        intent.putExtra("errorCode", str);
        LocalBroadcastManager.getInstance(DataProviderFactory.getApplicationContext()).sendBroadcast(intent);
        finish();
    }
}
