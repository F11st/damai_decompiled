package com.taobao.login4android.utils;

import android.text.TextUtils;
import com.taobao.login4android.log.LoginTLogAdapter;
import com.taobao.orange.OrangeConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class LoginSwitch {
    public static final String CONFIG_GROUP_LOGIN = "login4android";
    public static final String SGCOOKIE = "sgcookie";
    public static final String SWITCH_VALUE_FALSE = "false";
    public static final String SWITCH_VALUE_TRUE = "true";
    public static final String TAG = "loginsession.LoginSwitch";

    public static boolean getSwitch(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String config = OrangeConfig.getInstance().getConfig("login4android", str, str2);
            if (TextUtils.equals("useHttpsDomain", str)) {
                LoginTLogAdapter.d(TAG, "switch=" + str + "," + config);
            } else {
                LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str + ", value=" + config);
            }
            return Boolean.parseBoolean(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static int getSwitch(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return i;
        }
        try {
            OrangeConfig orangeConfig = OrangeConfig.getInstance();
            String config = orangeConfig.getConfig("login4android", str, i + "");
            LoginTLogAdapter.e(TAG, "LoginSwitch:getSwitch, switchName=" + str + ", value=" + config);
            return Integer.parseInt(config);
        } catch (Throwable th) {
            th.printStackTrace();
            return i;
        }
    }
}
