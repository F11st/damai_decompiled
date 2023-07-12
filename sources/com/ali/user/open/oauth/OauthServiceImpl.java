package com.ali.user.open.oauth;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.ali.user.open.core.AliMemberSDK;
import com.ali.user.open.core.Site;
import com.ali.user.open.core.context.KernelContext;
import com.ali.user.open.core.device.DeviceInfo;
import com.ali.user.open.core.service.UserTrackerService;
import com.ali.user.open.core.util.ParamsConstants;
import com.ali.user.open.oauth.ui.OauthActivity;
import com.alibaba.fastjson.JSON;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class OauthServiceImpl implements OauthService {
    @Override // com.ali.user.open.oauth.OauthService
    public void cleanUp() {
        OauthServiceProviderFactory.getInstance().cleanUp();
    }

    @Override // com.ali.user.open.oauth.OauthService
    public boolean isAppAuthSurpport(Context context, String str) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            return OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).isAppAuthSurpport(context);
        }
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthService
    public boolean isLoginUrl(String str, String str2) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            return OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).isLoginUrl(str2);
        }
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void logout(Context context, String str) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).logout(context, str);
        }
    }

    @Override // com.ali.user.open.oauth.OauthService
    public List<String> logoutAll(Context context) {
        return OauthServiceProviderFactory.getInstance().logoutAll(context);
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void oauth(Activity activity, String str, OauthCallback oauthCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put(ParamsConstants.Key.PARAM_NEED_AUTOLOGIN, "0");
        hashMap.put("needSession", "0");
        oauth(activity, str, hashMap, oauthCallback);
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void onActivityResult(String str, int i, int i2, Intent intent) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).onActivityResult(i, i2, intent);
        }
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void refreshWhenLogin(String str, String str2, boolean z) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).refreshWhenLogin(str2, z);
        }
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void tokenLogin(String str, String str2, String str3, String str4, Map<String, String> map, OauthCallback oauthCallback) {
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).tokenLogin(str2, str3, str4, map, oauthCallback);
        }
    }

    @Override // com.ali.user.open.oauth.OauthService
    public void oauth(Activity activity, String str, Map<String, String> map, OauthCallback oauthCallback) {
        HashMap hashMap = new HashMap();
        hashMap.put("oauthsite", str);
        if (map != null && !TextUtils.isEmpty(map.get(ParamsConstants.Key.PARAM_TRACE_ID))) {
            hashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, map.get(ParamsConstants.Key.PARAM_TRACE_ID));
        } else {
            String str2 = "oauth" + DeviceInfo.deviceId + (System.currentTimeMillis() / 1000);
            hashMap.put(ParamsConstants.Key.PARAM_TRACE_ID, str2);
            if (map == null) {
                map = new HashMap<>();
            }
            map.put(ParamsConstants.Key.PARAM_TRACE_ID, str2);
        }
        Map<String, String> map2 = map;
        ((UserTrackerService) AliMemberSDK.getService(UserTrackerService.class)).send("Page_UccOauth", "Page_UccOauth_Invoke", hashMap);
        AppCredential oauthConfigByPlatform = OauthPlatformConfig.getOauthConfigByPlatform(str);
        if (OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str) != null) {
            if (!TextUtils.equals(str, Site.QQ) && !TextUtils.equals(str, Site.WEIBO) && !TextUtils.equals(str, "jiuyou")) {
                OauthServiceProviderFactory.getInstance().getOauthServiceProvider(str).oauth(activity, str, oauthConfigByPlatform, map2, oauthCallback);
                return;
            }
            OauthActivity.mOauthCallback = oauthCallback;
            Intent intent = new Intent();
            intent.putExtra("targetSite", str);
            intent.putExtra("params", JSON.toJSONString(map2));
            intent.setClass(KernelContext.getApplicationContext(), OauthActivity.class);
            intent.setFlags(268435456);
            KernelContext.getApplicationContext().startActivity(intent);
        }
    }
}
