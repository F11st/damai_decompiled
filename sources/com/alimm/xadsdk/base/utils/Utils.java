package com.alimm.xadsdk.base.utils;

import android.content.Context;
import android.net.NetworkInfo;
import android.os.Build;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alimm.xadsdk.base.model.BidInfo;
import com.alimm.xadsdk.base.ut.AdUtConstants;
import com.ut.device.UTDevice;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Map;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import tb.gn1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class Utils {
    private static final int NETWORK_TYPE_WIFI = 1000;
    private static final String PREF_KEY_AD_COOKIE = "ad_cookie";
    private static final String TAG = "Utils";
    private static String sAdvCookie;

    public static void addCommonInfo(Map<String, String> map, BidInfo bidInfo) {
        if (map == null || bidInfo == null) {
            return;
        }
        map.put("ad_type", String.valueOf(bidInfo.getType()));
        map.put(AdUtConstants.XAD_UT_ARG_AD_INDEX, String.valueOf(bidInfo.getIndex()));
        map.put("rs", bidInfo.getCreativeUrl());
        map.put("rst", bidInfo.getCreativeType());
        map.put(AdUtConstants.XAD_UT_ARG_IMP_ID, bidInfo.getImpressionId());
        map.put(AdUtConstants.XAD_UT_ARG_IE, bidInfo.getCreativeId());
        map.put(AdUtConstants.XAD_UT_ARG_CA, bidInfo.getGroupId());
        map.put(AdUtConstants.XAD_UT_ARG_PST, String.valueOf(bidInfo.getSspId()));
        map.put("template_id", String.valueOf(bidInfo.getTemplateId()));
    }

    public static String formatTimeInMillis(long j, String str) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j);
        return new SimpleDateFormat(str).format(calendar.getTime());
    }

    public static String getCookie(@NonNull Context context) {
        if (TextUtils.isEmpty(sAdvCookie)) {
            sAdvCookie = PreferenceManager.getDefaultSharedPreferences(context).getString(PREF_KEY_AD_COOKIE, "");
        }
        return sAdvCookie;
    }

    public static String getDefaultUserAgent() {
        String str;
        int i = Build.VERSION.SDK_INT;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Mozilla/5.0");
        stringBuffer.append(" (Linux;");
        if (i < 19) {
            stringBuffer.append(" U;");
        }
        stringBuffer.append(" Android ");
        stringBuffer.append(Build.VERSION.getRELEASE());
        stringBuffer.append(";");
        if (i < 19) {
            stringBuffer.append(" zh-cn;");
        }
        stringBuffer.append(" ");
        stringBuffer.append(com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
        stringBuffer.append(" Build/");
        stringBuffer.append(android.os.Build.ID);
        if (i < 19) {
            stringBuffer.append(jn1.BRACKET_END_STR);
            str = " AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Safari/534.30";
        } else if (i < 19 || i > 21) {
            stringBuffer.append("; wv)");
            str = " AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.65 Mobile Safari/537.36";
        } else {
            stringBuffer.append(jn1.BRACKET_END_STR);
            str = " AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36";
        }
        stringBuffer.append(str);
        return stringBuffer.toString();
    }

    public static int getNetworkType(Context context) {
        if (context == null) {
            return 0;
        }
        NetworkInfo networkInfo = null;
        try {
            networkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        } catch (Exception e) {
            LogUtils.i("Utils", "getNetworkType exception", e);
        }
        if (networkInfo != null) {
            if (networkInfo.getType() == 1) {
                return 1000;
            }
            if (networkInfo.getType() == 0) {
                return networkInfo.getSubtype();
            }
            if (networkInfo.getType() == 9) {
                return 9;
            }
        }
        return 0;
    }

    public static String getOaid(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            str = (String) Class.forName("com.alibaba.openid.OpenDeviceId").getMethod("getOAID", Context.class).invoke(null, context);
        } catch (Throwable th) {
            LogUtils.d("Utils", "getOaid exception.", th);
        }
        if (LogUtils.DEBUG) {
            LogUtils.d("Utils", "getOaid: oaid = " + str);
        }
        return str;
    }

    public static String getSystemProperty(String str, String str2) {
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(null, str, str2);
        } catch (Exception e) {
            LogUtils.d("Utils", "getSystemProperty: exception" + e.getMessage());
            return str2;
        }
    }

    public static String getUtdid(Context context) {
        String str = "";
        if (context == null) {
            return "";
        }
        try {
            str = (String) UTDevice.class.getMethod("getUtdid", Context.class).invoke(null, context);
        } catch (Throwable th) {
            LogUtils.d("Utils", "getUtdid exception.", th);
        }
        if (LogUtils.DEBUG) {
            LogUtils.d("Utils", "getUtdid: utdid = ", str);
        }
        return str;
    }

    public static String getUuid() {
        try {
            String str = (String) Class.forName("com.yunos.tvtaobao.uuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
            return !TextUtils.isEmpty(str) ? !"false".equalsIgnoreCase(str) ? str : "" : "";
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String getVersionName(@NonNull Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            LogUtils.d("Utils", "getVersionName: exception" + e.getMessage());
            return "";
        }
    }

    public static String md5(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                if (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (Exception unused) {
            return "";
        }
    }

    public static void setCookie(@NonNull Context context, String str) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(sAdvCookie, str)) {
            return;
        }
        PreferenceManager.getDefaultSharedPreferences(context).edit().putString(PREF_KEY_AD_COOKIE, str).apply();
        sAdvCookie = str;
        LogUtils.d("Utils", "setCookie " + str);
    }

    public static int toInt(String str, int i) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException e) {
                LogUtils.d("Utils", "toInt exception: input = " + str, e);
            }
        }
        return i;
    }

    public static long toLong(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            try {
                return Long.parseLong(str);
            } catch (NumberFormatException e) {
                LogUtils.d("Utils", "toLong exception: input = " + str, e);
            }
        }
        return j;
    }

    public static String urlEncode(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (Exception unused) {
            return "";
        }
    }
}
