package com.ali.user.mobile.base.helper;

import android.content.Context;
import android.content.SharedPreferences;
import com.ali.user.mobile.login.model.LoginConstant;

/* compiled from: Taobao */
/* loaded from: classes17.dex */
public class CPHelper {
    public static final String NO_CLIENT_LOGIN = "no_client_login";
    private static SharedPreferences sPrefs;

    public static void delete(Context context, String str) {
        SharedPreferences.Editor edit = getPrefs(context).edit();
        edit.remove(str);
        edit.apply();
    }

    public static String getAccountInfo(Context context) {
        return getPrefs(context).getString(LoginConstant.ACCOUNT, "");
    }

    private static SharedPreferences getPrefs(Context context) {
        if (sPrefs == null) {
            sPrefs = context.getSharedPreferences(NO_CLIENT_LOGIN, 0);
        }
        return sPrefs;
    }

    public static void save(Context context, String str, String str2) {
        SharedPreferences.Editor edit = getPrefs(context).edit();
        edit.putString(str, str2);
        edit.apply();
    }
}
