package com.youku.playerservice.axp.utils;

import android.content.Context;
import android.text.TextUtils;
import com.youku.alixplayer.opensdk.AXPParamsProvider;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class Utils {
    public static final String TAG = "Utils";
    private static String mCpuName = "";

    public static ClientType getClientType(Context context) {
        String str = context.getApplicationInfo().packageName;
        return AXPParamsProvider.ClientType.YOUKU.equals(str) ? ClientType.YOUKU : AXPParamsProvider.ClientType.LAIFENG.equals(str) ? ClientType.LAIFENG : AXPParamsProvider.ClientType.YOUKU_HWBAIPAI.equals(str) ? ClientType.YOUKU_HWBAIPAI : "cn.damai".equals(str) ? ClientType.DAMAI : ClientType.OTHER;
    }

    public static String getCpuName(Context context) {
        if (TextUtils.isEmpty(mCpuName)) {
            mCpuName = getPropString(context, "ro.board.platform");
            String str = TAG;
            Logger.d(str, "get ro.board.platform --> " + mCpuName);
        } else {
            String str2 = TAG;
            com.baseproject.utils.Logger.d(str2, "cup name is saved :" + mCpuName);
        }
        return mCpuName;
    }

    private static String getPropString(Context context, String str) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return (String) loadClass.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class).invoke(loadClass, new String(str));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static synchronized String getVersionName(Context context) {
        String str;
        synchronized (Utils.class) {
            try {
                str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return str;
    }

    public static boolean isAXPSurport() {
        return true;
    }

    public static boolean isYoukuOrHuaweiBaipai(Context context) {
        return getClientType(context) == ClientType.YOUKU || getClientType(context) == ClientType.YOUKU_HWBAIPAI;
    }

    public static int parseInt(String str, int i) {
        return (TextUtils.isEmpty(str) || !TextUtils.isDigitsOnly(str)) ? i : Integer.parseInt(str);
    }
}
