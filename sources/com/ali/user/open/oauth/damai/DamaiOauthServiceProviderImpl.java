package com.ali.user.open.oauth.damai;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ali.user.open.core.config.ConfigManager;
import com.ali.user.open.oauth.AppCredential;
import com.ali.user.open.oauth.OauthCallback;
import com.ali.user.open.oauth.base.BaseOauthServiceProviderImpl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.regex.Pattern;

/* compiled from: Taobao */
/* loaded from: classes9.dex */
public class DamaiOauthServiceProviderImpl extends BaseOauthServiceProviderImpl {
    public static final String TAG = "oa.DamaiOauthServiceProviderImpl";
    private transient Pattern[] mLoginPatterns;

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public boolean isLoginUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (this.mLoginPatterns == null && !TextUtils.isEmpty(ConfigManager.DAMAI_LOGIN_URLS)) {
                String[] split = ConfigManager.DAMAI_LOGIN_URLS.split("[,]");
                Pattern[] patternArr = new Pattern[split.length];
                this.mLoginPatterns = patternArr;
                int length = patternArr.length;
                for (int i = 0; i < length; i++) {
                    this.mLoginPatterns[i] = Pattern.compile(split[i]);
                }
            }
            for (Pattern pattern : this.mLoginPatterns) {
                if (pattern.matcher(str).matches()) {
                    return true;
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        return false;
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void logout(Context context, String str) {
        String[] split;
        try {
            for (String str2 : new ArrayList<String>() { // from class: com.ali.user.open.oauth.damai.DamaiOauthServiceProviderImpl.1
                {
                    add("damai.cn");
                }
            }) {
                String cookie = CookieManager.getInstance().getCookie(str2);
                if (!TextUtils.isEmpty(cookie) && (split = cookie.split(";")) != null && split.length > 0) {
                    for (String str3 : split) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("EEE, dd-MMM-yyyy HH:mm:ss 'GMT'", Locale.ENGLISH);
                        simpleDateFormat.setTimeZone(TimeZone.getTimeZone("GMT+8"));
                        CookieManager.getInstance().setCookie("http://" + str2, str3 + "; Domain=." + str2 + "; Expires=" + simpleDateFormat.format((Object) 1000));
                    }
                    if (Build.VERSION.SDK_INT >= 21) {
                        CookieManager.getInstance().flush();
                    } else {
                        CookieSyncManager.createInstance(context).sync();
                    }
                }
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.ali.user.open.oauth.OauthServiceProvider
    public void oauth(Activity activity, String str, AppCredential appCredential, Map<String, String> map, OauthCallback oauthCallback) {
    }
}
