package com.youku.vpm.utils;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes3.dex */
public class TrackUtil {
    public static final String TAG = "TrackUtil";
    private static String mCpuName = "";

    public static String encode(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return str;
        }
    }

    public static String getCpuName(Context context) {
        StringBuilder sb;
        String str;
        if (TextUtils.isEmpty(mCpuName)) {
            mCpuName = getPropString(context, "ro.board.platform");
            sb = new StringBuilder();
            str = "get ro.board.platform --> ";
        } else {
            sb = new StringBuilder();
            str = "cup name is saved :";
        }
        sb.append(str);
        sb.append(mCpuName);
        Logger.d("TrackUtil", sb.toString());
        return mCpuName;
    }

    public static double getDoubleValue(String str) {
        try {
            return Double.valueOf(str).doubleValue();
        } catch (Exception e) {
            e.getStackTrace();
            return -1.0d;
        }
    }

    public static String getFileFormatByUrl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return (str.contains(".mp4") || str.contains(".m5v")) ? "0" : (str.contains(".m3u8") || str.contains(".ts")) ? "1" : str.contains(".flv") ? "3" : str.contains(".mp5") ? "4" : str.contains("artp://") ? "7" : "-1";
    }

    public static String getKeyValue(@NonNull String str, String str2, String str3, @NonNull String str4) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str4)) {
            for (String str5 : str.split(str2)) {
                String[] split = str5.split(str3);
                if (split.length >= 2 && str4.equals(split[0])) {
                    return split[1];
                }
            }
        }
        return null;
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

    public static String getValueByKeyFromUrl(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Uri.parse(str).getQueryParameter(str2);
    }

    private static <T> void printlog(String str, Map<String, T> map) {
        for (Map.Entry<String, T> entry : map.entrySet()) {
            String key = entry.getKey();
            T value = entry.getValue();
            if (key != null) {
                Logger.d(str, key + "=" + value);
            }
        }
    }

    public static boolean printlog(Context context, String str, String str2, Map<String, String> map, Map<String, Double> map2) {
        if (!SystemUtil.isDebug(context) || str == null || map == null || map2 == null) {
            return false;
        }
        Logger.d(str, "#################################开始 " + str2 + " #####################################");
        printlog(str, map);
        printlog(str, map2);
        Logger.d(str, "##################################结束 " + str2 + " ####################################");
        return true;
    }
}
