package com.tencent.stat.common;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.zip.GZIPInputStream;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.http.HttpHost;
import org.json.JSONException;
import org.json.JSONObject;
import tb.v;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class StatCommonHelper {
    private static String appkey;
    private static String deviceModel;
    private static StatLogger logger;
    private static String macId;
    private static Random random;
    private static String userId;

    /* compiled from: Taobao */
    /* loaded from: classes11.dex */
    static class RootCmd {
        private static int systemRootState = -1;

        public static boolean isRootSystem() {
            int i = systemRootState;
            if (i == 1) {
                return true;
            }
            if (i == 0) {
                return false;
            }
            String[] strArr = {"/bin", "/system/bin/", "/system/xbin/", "/system/sbin/", "/sbin/", "/vendor/bin/"};
            for (int i2 = 0; i2 < 6; i2++) {
                try {
                    if (new File(strArr[i2] + "su").exists()) {
                        systemRootState = 1;
                        return true;
                    }
                } catch (Exception unused) {
                }
            }
            systemRootState = 0;
            return false;
        }
    }

    public static boolean checkPermission(Context context, String str) {
        return context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }

    public static boolean checkPhoneState(Context context) {
        return context.getPackageManager().checkPermission("android.permission.READ_PHONE_STATE", context.getPackageName()) == 0;
    }

    public static Long convertStringToLong(String str, String str2, int i, int i2, Long l) {
        if (str != null && str2 != null) {
            if (str2.equalsIgnoreCase(".") || str2.equalsIgnoreCase("|")) {
                str2 = "\\" + str2;
            }
            String[] split = str.split(str2);
            if (split.length == i2) {
                try {
                    Long l2 = 0L;
                    for (String str3 : split) {
                        l2 = Long.valueOf(i * (l2.longValue() + Long.valueOf(str3).longValue()));
                    }
                    return l2;
                } catch (NumberFormatException unused) {
                }
            }
        }
        return l;
    }

    public static String decode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(RC4.decrypt(StatBase64.decode(str.getBytes("UTF-8"), 0)), "UTF-8");
        } catch (Throwable th) {
            logger.e(th);
            return str;
        }
    }

    public static byte[] deocdeGZipContent(byte[] bArr) throws IOException {
        GZIPInputStream gZIPInputStream = new GZIPInputStream(new ByteArrayInputStream(bArr));
        byte[] bArr2 = new byte[4096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(bArr.length * 2);
        while (true) {
            int read = gZIPInputStream.read(bArr2);
            if (read == -1) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr2, 0, read);
        }
    }

    public static String encode(String str) {
        if (str == null) {
            return null;
        }
        if (Build.VERSION.SDK_INT < 8) {
            return str;
        }
        try {
            return new String(StatBase64.encode(RC4.encrypt(str.getBytes("UTF-8")), 0), "UTF-8");
        } catch (Throwable th) {
            logger.e(th);
            return str;
        }
    }

    public static String getActivityName(Context context) {
        if (context == null) {
            return null;
        }
        return context.getClass().getName();
    }

    public static String getAppKey(Context context) {
        String str = appkey;
        if (str != null) {
            return str;
        }
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                String string = applicationInfo.metaData.getString("TA_APPKEY");
                if (string != null) {
                    appkey = string;
                    return string;
                }
                logger.w("Could not read APPKEY meta-data from AndroidManifest.xml");
                return null;
            }
            return null;
        } catch (Exception unused) {
            logger.w("Could not read APPKEY meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String getAppVersion(Context context) {
        String str = "";
        try {
            str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            logger.e(e);
        }
        return str != null ? str.length() == 0 ? "unknown" : str : "unknown";
    }

    public static String getCurAppVersion(Context context) {
        try {
            String str = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
            return str == null ? "" : str;
        } catch (Exception e) {
            logger.e(e);
            return "";
        }
    }

    public static String getDateFormat(long j) {
        return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
    }

    public static String getDeviceID(Context context) {
        if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            logger.e("Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        }
        String deviceId = checkPhoneState(context) ? TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone")) : "";
        if (deviceId != null) {
            return deviceId;
        }
        logger.error("deviceId is null");
        return null;
    }

    public static DisplayMetrics getDisplayMetrics(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Display.getMetrics(((WindowManager) context.getApplicationContext().getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
        return displayMetrics;
    }

    public static String getExternalStorageInfo(Context context) {
        String path;
        try {
            if (checkPermission(context, "android.permission.WRITE_EXTERNAL_STORAGE")) {
                if (!Environment.getExternalStorageState().equals("mounted") || (path = Environment.getExternalStorageDirectory().getPath()) == null) {
                    return null;
                }
                StatFs statFs = new StatFs(path);
                return String.valueOf((statFs.getAvailableBlocks() * statFs.getBlockSize()) / 1000000) + "/" + String.valueOf((statFs.getBlockCount() * statFs.getBlockSize()) / 1000000);
            }
            logger.warn("can not get the permission of android.permission.WRITE_EXTERNAL_STORAGE");
        } catch (Throwable unused) {
        }
        return null;
    }

    public static HttpHost getHttpProxy(Context context) {
        NetworkInfo activeNetworkInfo;
        String extraInfo;
        if (context != null && context.getPackageManager().checkPermission("android.permission.ACCESS_NETWORK_STATE", context.getPackageName()) == 0) {
            try {
                activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            } catch (Exception e) {
                logger.e(e);
            }
            if (activeNetworkInfo == null) {
                return null;
            }
            if ((activeNetworkInfo.getTypeName() == null || !activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI")) && (extraInfo = activeNetworkInfo.getExtraInfo()) != null) {
                if (!extraInfo.equals("cmwap") && !extraInfo.equals("3gwap") && !extraInfo.equals("uniwap")) {
                    if (extraInfo.equals("ctwap")) {
                        return new HttpHost("10.0.0.200", 80);
                    }
                    return null;
                }
                return new HttpHost("10.0.0.172", 80);
            }
            return null;
        }
        return null;
    }

    public static String getInstallChannel(Context context) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 128);
            if (applicationInfo != null) {
                Object obj = applicationInfo.metaData.get("InstallChannel");
                if (obj != null) {
                    return obj.toString();
                }
                logger.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
                return null;
            }
            return null;
        } catch (Exception unused) {
            logger.e("Could not read InstallChannel meta-data from AndroidManifest.xml");
            return null;
        }
    }

    public static String getLinkedWay(Context context) {
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            logger.e("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return null;
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return null;
        }
        String typeName = activeNetworkInfo.getTypeName();
        String extraInfo = activeNetworkInfo.getExtraInfo();
        if (typeName != null) {
            if (typeName.equalsIgnoreCase("WIFI")) {
                return "WIFI";
            }
            if (typeName.equalsIgnoreCase("MOBILE")) {
                if (extraInfo == null) {
                    return "MOBILE";
                }
            } else if (extraInfo == null) {
                return typeName;
            }
            return extraInfo;
        }
        return null;
    }

    public static StatLogger getLogger() {
        if (logger == null) {
            StatLogger statLogger = new StatLogger("MtaSDK");
            logger = statLogger;
            statLogger.setDebugEnable(false);
        }
        return logger;
    }

    public static String getMacId(Context context) {
        String str = macId;
        if (str == null || "" == str) {
            macId = getWifiMacAddress(context);
        }
        return macId;
    }

    public static int getNextSessionID() {
        return getRandom().nextInt(Integer.MAX_VALUE);
    }

    private static Random getRandom() {
        if (random == null) {
            random = new Random();
        }
        return random;
    }

    public static long getSDKLongVersion(String str) {
        return convertStringToLong(str, ".", 100, 3, 0L).longValue();
    }

    public static String getSimOperator(Context context) {
        if (!checkPermission(context, "android.permission.READ_PHONE_STATE")) {
            logger.e("Could not get permission of android.permission.READ_PHONE_STATE");
            return null;
        } else if (checkPhoneState(context)) {
            try {
                return TelephonyManager.getSimOperator((android.telephony.TelephonyManager) context.getSystemService("phone"));
            } catch (Exception e) {
                logger.e(e);
                return null;
            }
        } else {
            return null;
        }
    }

    public static Integer getTelephonyNetworkType(Context context) {
        android.telephony.TelephonyManager telephonyManager = (android.telephony.TelephonyManager) context.getSystemService("phone");
        if (telephonyManager != null) {
            return Integer.valueOf(TelephonyManager.getNetworkType(telephonyManager));
        }
        return null;
    }

    public static long getTomorrowStartMilliseconds() {
        Calendar calendar = Calendar.getInstance();
        calendar.set(11, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(14, 0);
        return calendar.getTimeInMillis() + 86400000;
    }

    public static String getUserID(Context context) {
        String str = userId;
        if (str == null || str.trim().length() == 0) {
            String deviceID = getDeviceID(context);
            userId = deviceID;
            if (deviceID == null || deviceID.trim().length() == 0) {
                userId = Integer.toString(getRandom().nextInt(Integer.MAX_VALUE));
            }
            return userId;
        }
        return userId;
    }

    public static String getWifiMacAddress(Context context) {
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            logger.e("Could not get permission of android.permission.ACCESS_WIFI_STATE");
            return "";
        }
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            return wifiManager == null ? "" : WifiInfo.getMacAddress(wifiManager.getConnectionInfo());
        } catch (Exception e) {
            logger.e(e);
            return "";
        }
    }

    public static int hasRootAccess(Context context) {
        return RootCmd.isRootSystem() ? 1 : 0;
    }

    public static boolean isNetworkAvailable(Context context) {
        if (!checkPermission(context, "android.permission.INTERNET")) {
            logger.warn("can not get the permisson of android.permission.INTERNET");
            return false;
        }
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null || !activeNetworkInfo.isAvailable()) {
            logger.w("Network error");
            return false;
        }
        return true;
    }

    public static boolean isWiFiActive(Context context) {
        NetworkInfo[] allNetworkInfo;
        if (!checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
            logger.warn("can not get the permission of android.permission.ACCESS_WIFI_STATE");
            return false;
        }
        android.net.ConnectivityManager connectivityManager = (android.net.ConnectivityManager) context.getApplicationContext().getSystemService("connectivity");
        if (connectivityManager != null && (allNetworkInfo = connectivityManager.getAllNetworkInfo()) != null) {
            for (int i = 0; i < allNetworkInfo.length; i++) {
                if (allNetworkInfo[i].getTypeName().equalsIgnoreCase("WIFI") && allNetworkInfo[i].isConnected()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isWifiNet(Context context) {
        if (checkPermission(context, "android.permission.INTERNET")) {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            return activeNetworkInfo != null && activeNetworkInfo.isAvailable() && activeNetworkInfo.getTypeName().equalsIgnoreCase("WIFI");
        }
        logger.warn("can not get the permisson of android.permission.INTERNET");
        return false;
    }

    public static void jsonPut(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (str2 == null || str2.length() <= 0) {
            return;
        }
        jSONObject.put(str, str2);
    }

    public static String md5sum(String str) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes());
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                int i = b & 255;
                if (i < 16) {
                    stringBuffer.append("0");
                }
                stringBuffer.append(Integer.toHexString(i));
            }
            return stringBuffer.toString();
        } catch (NoSuchAlgorithmException e) {
            logger.e((Exception) e);
            return "0";
        }
    }
}
