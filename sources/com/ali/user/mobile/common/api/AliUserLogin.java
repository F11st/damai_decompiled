package com.ali.user.mobile.common.api;

import android.content.Context;
import android.content.SharedPreferences;
import com.ali.user.mobile.app.dataprovider.DataProviderFactory;
import com.ali.user.mobile.filter.LoginFilter;
import com.ali.user.mobile.filter.PreOpenLoginPageFilter;
import com.ali.user.mobile.login.model.LoginConstant;
import com.ali.user.mobile.ui.widget.WidgetExtension;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class AliUserLogin {
    private static volatile AliUserLogin aliUserLogin;
    public static LoginApprearanceExtensions mAppreanceExtentions;
    public static OnLoginCaller mLoginCaller;
    public static LoginFilter mLoginFilter;
    private static Map<Integer, LoginFilter> mLoginFilterMap = new HashMap();
    private PreOpenLoginPageFilter mPreOpenLoginPageFiler;
    private Class<?> mWebViewProxyClass;

    private AliUserLogin() {
    }

    public static void cleanCache() {
        clearCacheData(LoginConstant.FILE_NAME);
        clearCacheData(LoginConstant.FILE_NAME_HISTORY);
    }

    public static void clearCacheData(String str) {
        try {
            SharedPreferences sharedPreferences = DataProviderFactory.getApplicationContext().getSharedPreferences(str, 0);
            if (sharedPreferences != null) {
                sharedPreferences.edit().clear().apply();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static AliUserLogin getInstance() {
        if (aliUserLogin == null) {
            synchronized (AliUserLogin.class) {
                if (aliUserLogin == null) {
                    aliUserLogin = new AliUserLogin();
                }
            }
        }
        return aliUserLogin;
    }

    public static LoginFilter getLoginFilter(int i) {
        if (mLoginFilterMap.containsKey(Integer.valueOf(i))) {
            return mLoginFilterMap.get(Integer.valueOf(i));
        }
        return mLoginFilter;
    }

    public static void registOnLoginCaller(Context context, OnLoginCaller onLoginCaller) {
        if (mLoginCaller == null) {
            mLoginCaller = onLoginCaller;
        }
    }

    public static void setLoginAppreanceExtions(LoginApprearanceExtensions loginApprearanceExtensions) {
        mAppreanceExtentions = loginApprearanceExtensions;
        WidgetExtension.widgetExtension = loginApprearanceExtensions;
    }

    public static void setLoginFilter(LoginFilter loginFilter) {
        mLoginFilter = loginFilter;
    }

    public Class<?> getCustomWebViewClass() {
        return this.mWebViewProxyClass;
    }

    public PreOpenLoginPageFilter getPreOpenLoginPageFiler() {
        return this.mPreOpenLoginPageFiler;
    }

    public void setCustomWebViewClass(Class<?> cls) {
        this.mWebViewProxyClass = cls;
    }

    public void setPreOpenLoginPageFiler(PreOpenLoginPageFilter preOpenLoginPageFilter) {
        this.mPreOpenLoginPageFiler = preOpenLoginPageFilter;
    }

    public static void setLoginFilter(int i, LoginFilter loginFilter) {
        mLoginFilterMap.put(Integer.valueOf(i), loginFilter);
    }
}
