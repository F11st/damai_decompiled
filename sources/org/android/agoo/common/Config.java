package org.android.agoo.common;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.OrangeAdapter;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class Config {
    public static final String AGOO_CLEAR_TIME = "agoo_clear_time";
    public static final String AGOO_UNREPORT_TIMES = "agoo_UnReport_times";
    private static String DEVICETOKEN = null;
    private static String DEVICETOKENV2 = null;
    public static final String KEY_DEVICE_TOKEN = "deviceId";
    public static final String KEY_DEVICE_TOKEN_V2 = "deviceIdV2";
    public static final String PREFERENCES = "Agoo_AppStore";
    public static final String PROPERTY_APP_KEY = "agoo_app_key";
    public static final String PROPERTY_APP_VERSION = "app_version";
    public static final String PROPERTY_DEVICE_TOKEN = "app_device_token";
    public static final String PROPERTY_PUSH_USER_TOKEN = "app_push_user_token";
    public static final String PROPERTY_TT_ID = "app_tt_id";
    public static final String TAG = "Config";
    public static String mAccsConfigTag;
    private static String mAgooAppkey;

    public static void clear(Context context) {
        try {
            SharedPreferences.Editor edit = getAgooPreferences(context).edit();
            edit.putInt("app_version", Integer.MIN_VALUE);
            edit.remove(PROPERTY_DEVICE_TOKEN);
            edit.remove(PROPERTY_APP_KEY);
            edit.remove(PROPERTY_TT_ID);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void clearReportTimes(Context context) {
        try {
            SharedPreferences.Editor edit = getAgooPreferences(context).edit();
            edit.putInt(AGOO_UNREPORT_TIMES, 0);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static String getAccsConfigTag(Context context) {
        if (TextUtils.isEmpty(mAccsConfigTag)) {
            return ACCSManager.getDefaultConfig(context);
        }
        return mAccsConfigTag;
    }

    public static String getAgooAppKey(Context context) {
        String str = mAgooAppkey;
        try {
            str = getAgooPreferences(context).getString(PROPERTY_APP_KEY, mAgooAppkey);
        } catch (Throwable th) {
            ALog.e(TAG, "getAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getAgooAppKey null!!", new Object[0]);
        }
        ALog.d(TAG, "getAgooAppKey", "appkey", str);
        return str;
    }

    private static SharedPreferences getAgooPreferences(Context context) {
        return APreferencesManager.getSharedPreferences(context, PREFERENCES, 4);
    }

    public static String getDeviceToken(Context context) {
        boolean isRegIdSwitchEnableAndValid = OrangeAdapter.isRegIdSwitchEnableAndValid(context);
        String str = isRegIdSwitchEnableAndValid ? KEY_DEVICE_TOKEN_V2 : "deviceId";
        String str2 = isRegIdSwitchEnableAndValid ? DEVICETOKENV2 : DEVICETOKEN;
        try {
            str2 = getAgooPreferences(context).getString(str, str2);
        } catch (Throwable th) {
            ALog.e(TAG, "getDeviceToken", th, new Object[0]);
        }
        ALog.i(TAG, "getDeviceToken", "token", str2, "isRegIdValid", Boolean.valueOf(isRegIdSwitchEnableAndValid));
        return str2;
    }

    public static String getPushAliasToken(Context context) {
        try {
            return getAgooPreferences(context).getString(PROPERTY_PUSH_USER_TOKEN, "");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static int getReportCacheMsg(Context context) {
        try {
            return getAgooPreferences(context).getInt(AGOO_UNREPORT_TIMES, 0);
        } catch (Throwable unused) {
            return 0;
        }
    }

    public static boolean isClearTime(Context context, long j) {
        try {
            long j2 = getAgooPreferences(context).getLong(AGOO_CLEAR_TIME, 0L);
            StringBuilder sb = new StringBuilder();
            sb.append("now=");
            sb.append(j);
            sb.append(",now - lastTime=");
            long j3 = j - j2;
            sb.append(j3);
            sb.append(",istrue=");
            int i = (j3 > 86400000L ? 1 : (j3 == 86400000L ? 0 : -1));
            sb.append(i > 0);
            ALog.d("isClearTime", sb.toString(), new Object[0]);
            return j != 0 && i > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean isReportCacheMsg(Context context) {
        try {
            return getAgooPreferences(context).getInt(AGOO_UNREPORT_TIMES, 0) > 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static void setAgooAppKey(Context context, String str) {
        try {
        } catch (Throwable th) {
            ALog.e(TAG, "setAgooAppKey", th, new Object[0]);
        }
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "setAgooAppKey appkey null", new Object[0]);
            return;
        }
        mAgooAppkey = str;
        SharedPreferences.Editor edit = getAgooPreferences(context).edit();
        edit.putString(PROPERTY_APP_KEY, str);
        edit.apply();
        ALog.d(TAG, "setAgooAppKey", "appkey", str);
    }

    public static void setClearTimes(Context context, long j) {
        try {
            SharedPreferences.Editor edit = getAgooPreferences(context).edit();
            edit.putLong(AGOO_CLEAR_TIME, j);
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void setDeviceToken(Context context, String str) {
        boolean isRegIdSwitchEnableAndValid = OrangeAdapter.isRegIdSwitchEnableAndValid(context);
        ALog.i(TAG, "setDeviceToken", "token", str, "isRegIdValid", Boolean.valueOf(isRegIdSwitchEnableAndValid));
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (isRegIdSwitchEnableAndValid) {
            DEVICETOKENV2 = str;
        } else {
            DEVICETOKEN = str;
        }
        try {
            SharedPreferences.Editor edit = getAgooPreferences(context).edit();
            edit.putString(isRegIdSwitchEnableAndValid ? KEY_DEVICE_TOKEN_V2 : "deviceId", str);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "setDeviceToken", th, new Object[0]);
        }
    }

    public static void setPushAliasToken(Context context, String str) {
        try {
            SharedPreferences.Editor edit = getAgooPreferences(context).edit();
            if (!TextUtils.isEmpty(str)) {
                edit.putString(PROPERTY_PUSH_USER_TOKEN, str);
            }
            edit.apply();
        } catch (Throwable unused) {
        }
    }

    public static void setReportTimes(Context context, int i) {
        try {
            SharedPreferences agooPreferences = getAgooPreferences(context);
            SharedPreferences.Editor edit = agooPreferences.edit();
            edit.putInt(AGOO_UNREPORT_TIMES, agooPreferences.getInt(AGOO_UNREPORT_TIMES, 0) + i);
            edit.apply();
        } catch (Throwable unused) {
        }
    }
}
