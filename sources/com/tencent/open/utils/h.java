package com.tencent.open.utils;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.vivo.push.PushClientConstants;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class h {
    public static String a(Context context, String str, String str2) {
        if (context != null && str2 != null && str != null) {
            if ("com.tencent.mobileqq".equals(str2)) {
                return b(context, str, "com.tencent.mobileqq");
            }
            if (Constants.PACKAGE_TIM.equals(str2)) {
                return b(context, str, Constants.PACKAGE_TIM);
            }
        }
        return null;
    }

    private static String b(Context context, String str, String str2) {
        try {
            Cursor c = c(context, str, str2);
            if (c == null) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion null");
                return null;
            } else if (c.getCount() <= 0) {
                SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion empty");
                return null;
            } else {
                c.moveToFirst();
                String string = c.getString(0);
                c.close();
                SLog.i("openSDK_LOG.OpenApiProviderUtils", "AppVersion: " + string);
                return a(string) ? string : "UNKNOWN";
            }
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "queryTargetAppVersion exception: ", e);
            return null;
        }
    }

    private static Cursor c(Context context, String str, String str2) {
        if (context == null) {
            return null;
        }
        try {
            ContentResolver contentResolver = context.getContentResolver();
            return contentResolver.query(Uri.parse("content://" + str2 + ".openapi.provider/query_app_version?appid=" + str + "&" + PushClientConstants.TAG_PKG_NAME + "=" + context.getPackageName()), new String[0], null, null, null);
        } catch (Exception e) {
            SLog.e("openSDK_LOG.OpenApiProviderUtils", "query exception: ", e);
            return null;
        }
    }

    private static boolean a(String str) {
        if (str == null || str.isEmpty()) {
            return false;
        }
        String[] split = str.split("\\.");
        if (split.length < 3) {
            return false;
        }
        for (String str2 : split) {
            try {
                Integer.parseInt(str2);
            } catch (NumberFormatException unused) {
                return false;
            }
        }
        return true;
    }
}
