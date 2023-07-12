package com.taobao.android.sns4android.netease;

import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.eventbus.Event;
import com.ali.user.mobile.eventbus.EventBus;
import com.ali.user.mobile.eventbus.EventListener;
import com.ali.user.mobile.model.SNSSignInAccount;
import com.ali.user.mobile.ui.WebConstant;
import com.taobao.android.sns4android.SNSPlatform;
import com.taobao.android.sns4android.SNSSignInListener;
import java.util.Map;
import tb.hh1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class NeteaseAuth {

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class a implements EventListener {
        final /* synthetic */ SNSSignInListener a;

        a(SNSSignInListener sNSSignInListener) {
            this.a = sNSSignInListener;
        }

        @Override // com.ali.user.mobile.eventbus.EventListener
        public void onEvent(Event event) {
            EventBus.getDefault().unregisterEventListener("neteaseH5", this);
            Map<String, Object> map = event.params;
            if (map == null || this.a == null) {
                return;
            }
            String str = (String) map.get("result");
            if (TextUtils.equals(str, "success")) {
                SNSSignInAccount sNSSignInAccount = new SNSSignInAccount();
                sNSSignInAccount.token = (String) event.params.get("token");
                sNSSignInAccount.snsType = SNSPlatform.PLATFORM_NETEASE.getPlatform();
                this.a.onSucceed(null, sNSSignInAccount);
            } else if (TextUtils.equals(str, "cancel")) {
                this.a.onCancel(null, SNSPlatform.PLATFORM_NETEASE.getPlatform());
            } else if (TextUtils.equals(str, "fail")) {
                try {
                    this.a.onError(null, SNSPlatform.PLATFORM_NETEASE.getPlatform(), ((Integer) event.params.get("errorCode")).intValue(), (String) event.params.get(hh1.DIMEN_MESSAGE));
                } catch (Throwable unused) {
                }
            }
        }
    }

    public static void auth(String str, String str2, SNSSignInListener sNSSignInListener) {
        if ((TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) && sNSSignInListener != null) {
            sNSSignInListener.onError(null, SNSPlatform.PLATFORM_NETEASE.getPlatform(), -1, "");
        }
        EventBus.getDefault().registerEventListener("neteaseH5", new a(sNSSignInListener));
        Intent intent = new Intent();
        intent.putExtra(WebConstant.WEBURL, "https://reg.163.com/open/oauth2/authorize.do?response_type=code&client_id=" + str + "&redirect_uri=" + str2);
        intent.putExtra("redirectUri", str2);
        intent.setAction("com.aliuser.netease.auth");
        intent.setPackage(DataProviderFactory.getApplicationContext().getPackageName());
        intent.setFlags(268435456);
        DataProviderFactory.getApplicationContext().startActivity(intent);
    }
}
