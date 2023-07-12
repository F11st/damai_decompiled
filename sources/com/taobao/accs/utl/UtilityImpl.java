package com.taobao.accs.utl;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.NetworkInfo;
import android.net.Proxy;
import android.os.Build;
import android.os.Process;
import android.provider.Settings;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.net.ConnectivityManager;
import com.alibaba.wireless.security.open.SecurityGuardManager;
import com.alibaba.wireless.security.open.SecurityGuardParamContext;
import com.alibaba.wireless.security.open.dynamicdatastore.IDynamicDataStoreComponent;
import com.alibaba.wireless.security.open.securesignature.ISecureSignatureComponent;
import com.alibaba.wireless.security.open.staticdataencrypt.IStaticDataEncryptComponent;
import com.alimm.xadsdk.base.expose.RetryMonitorDbHelper;
import com.alipay.sdk.m.c.a;
import com.taobao.accs.ACCSManager;
import com.taobao.accs.AccsClientConfig;
import com.taobao.accs.asp.APreferencesManager;
import com.taobao.accs.client.AdapterGlobalClientInfo;
import com.taobao.accs.client.GlobalClientInfo;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.login4android.session.SessionManager;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.NetworkInterface;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;
import org.android.spdy.SpdyProtocol;
import tb.fv0;
import tb.gn1;
import tb.jn1;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class UtilityImpl {
    private static final int LEN_INDEX = 2;
    private static final int LEN_IP = 12;
    private static final int LEN_IP_TRUE = 6;
    private static final int LEN_TIMESTAMP = 14;
    private static final long MIN = 1609430400001L;
    public static final String NET_TYPE_2G = "2g";
    public static final String NET_TYPE_3G = "3g";
    public static final String NET_TYPE_4G = "4g";
    public static final String NET_TYPE_UNKNOWN = "unknown";
    public static final String NET_TYPE_WIFI = "wifi";
    private static final char PADDING = '0';
    private static final String PADDING_DIGITS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String REG_ID_PREFIX = "reg0";
    private static final String SSL_TIKET_KEY = "accs_ssl_ticket_key";
    private static final String SSL_TIKET_KEY2 = "accs_ssl_key2_";
    private static final String TAG = "UtilityImpl";
    private static String aaid;
    public static File file;
    static Boolean isDual;
    static Boolean isHarmonyOs;
    private static String macAddress;
    private static final byte[] mLock = new byte[0];
    private static final Random PADDING_RANDOM = new Random();

    public static byte[] SecurityGuardGetSslTicket2(Context context, String str, String str2, String str3) {
        SecurityGuardManager securityGuardManager;
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (context != null && !TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str2)) {
            try {
                if (isSecurityOff(str) || (securityGuardManager = SecurityGuardManager.getInstance(context)) == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                    return null;
                }
                return dynamicDataStoreComp.getByteArray(SSL_TIKET_KEY2 + str3);
            } catch (Throwable th) {
                ALog.e(TAG, "SecurityGuardGetSslTicket2", th, new Object[0]);
                return null;
            }
        }
        ALog.i(TAG, "get sslticket input null", new Object[0]);
        return null;
    }

    public static int SecurityGuardPutSslTicket2(Context context, String str, String str2, String str3, byte[] bArr) {
        SecurityGuardManager securityGuardManager;
        IDynamicDataStoreComponent dynamicDataStoreComp;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3) || context == null || bArr == null) {
            return -1;
        }
        try {
            if (isSecurityOff(str) || (securityGuardManager = SecurityGuardManager.getInstance(context)) == null || (dynamicDataStoreComp = securityGuardManager.getDynamicDataStoreComp()) == null) {
                return -1;
            }
            return dynamicDataStoreComp.putByteArray(SSL_TIKET_KEY2 + str3, bArr);
        } catch (Throwable th) {
            ALog.e(TAG, "SecurityGuardPutSslTicket2", th, new Object[0]);
            return -1;
        }
    }

    public static int String2Int(String str) {
        try {
            return Integer.valueOf(str).intValue();
        } catch (Exception e) {
            ALog.e(TAG, "String2Int", e, new Object[0]);
            return 0;
        }
    }

    public static boolean appVersionChanged(Context context) {
        String str;
        int i;
        synchronized (mLock) {
            PackageInfo packageInfo = GlobalClientInfo.getInstance(context).getPackageInfo();
            int i2 = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getInt(Constants.KEY_APP_VERSION_CODE, -1);
            String string = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getString(Constants.KEY_APP_VERSION_NAME, "");
            if (packageInfo != null) {
                i = packageInfo.versionCode;
                str = packageInfo.versionName;
            } else {
                str = null;
                i = 0;
            }
            if (i2 == i && string.equals(str)) {
                return false;
            }
            saveAppVersion(context);
            ALog.i(TAG, "appVersionChanged", "oldV", Integer.valueOf(i2), "nowV", Integer.valueOf(i), "oldN", string, "nowN", str);
            return true;
        }
    }

    public static void clearCookie(Context context) {
        try {
            GlobalClientInfo.mCookieSec = null;
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.clear();
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "clearCookie fail", th, new Object[0]);
        }
    }

    public static void clearSharePreferences(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences sharedPreferences = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0);
                String string = sharedPreferences.getString("appkey", null);
                String string2 = sharedPreferences.getString("app_sercet", null);
                String string3 = sharedPreferences.getString(Constants.KEY_PROXY_HOST, null);
                int i = sharedPreferences.getInt(Constants.KEY_PROXY_PORT, -1);
                int i2 = sharedPreferences.getInt("version", -1);
                int i3 = sharedPreferences.getInt(Constants.SP_KEY_DEBUG_MODE, 0);
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.clear();
                if (!TextUtils.isEmpty(string)) {
                    edit.putString("appkey", string);
                }
                if (!TextUtils.isEmpty(string2)) {
                    edit.putString("app_sercet", string2);
                }
                if (!TextUtils.isEmpty(string3)) {
                    edit.putString(Constants.KEY_PROXY_HOST, string3);
                }
                if (i > 0) {
                    edit.putInt(Constants.KEY_PROXY_PORT, i);
                }
                if (i2 > 0) {
                    edit.putInt("version", i2);
                }
                if (i3 == 2 || i3 == 1) {
                    edit.putInt(Constants.SP_KEY_DEBUG_MODE, i3);
                }
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e(TAG, "clearSharePreferences", th, new Object[0]);
        }
    }

    public static synchronized String createRegId() {
        String sb;
        synchronized (UtilityImpl.class) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(REG_ID_PREFIX);
            Random random = PADDING_RANDOM;
            sb2.append(leftPadding(Base62Utils.encode(random.nextInt(Integer.MAX_VALUE) + MIN), true, 14));
            sb2.append(leftPadding(leftPadding(Base62Utils.encode(ipToLong(random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256) + "." + random.nextInt(256))), false, 6), true, 12));
            sb2.append(leftPadding(Base62Utils.encode((long) random.nextInt(3844)), false, 2));
            sb = sb2.toString();
        }
        return sb;
    }

    public static boolean debug(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                ALog.isUseTlog = false;
                anet.channel.util.ALog.i(false);
                return true;
            }
        } catch (Throwable th) {
            ALog.e(TAG, "enable debug err", th, new Object[0]);
        }
        return false;
    }

    public static void disableService(Context context) {
        ComponentName componentName = new ComponentName(context, AdapterUtilityImpl.channelService);
        PackageManager packageManager = context.getPackageManager();
        try {
            ALog.d(TAG, "disableService,comptName=" + componentName.toString(), new Object[0]);
            if (packageManager.getServiceInfo(componentName, 128).enabled) {
                packageManager.setComponentEnabledSetting(componentName, 2, 1);
                killService(context);
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void enableService(Context context) {
        enableService(context, new ComponentName(context, AdapterUtilityImpl.channelService));
    }

    public static void focusDisableService(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, true);
                edit.apply();
                disableService(context);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "focusDisableService", th, new Object[0]);
        }
    }

    public static void focusEnableService(Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
                edit.putBoolean(Constants.KEY_FOUCE_DISABLE, false);
                edit.apply();
                enableService(context);
            }
        } catch (Throwable th) {
            ALog.e(TAG, "focusEnableService", th, new Object[0]);
        }
    }

    public static String formatDay(long j) {
        try {
            return new SimpleDateFormat(RetryMonitorDbHelper.DATE_FORMAT, Locale.US).format(Long.valueOf(j));
        } catch (Throwable th) {
            ALog.e(TAG, "formatDay", th, new Object[0]);
            return "";
        }
    }

    public static String getAaid(Context context) {
        try {
            if (TextUtils.isEmpty(aaid)) {
                aaid = Settings.System.getString(context.getContentResolver(), "android_id");
            }
            return aaid;
        } catch (Throwable th) {
            ALog.w(TAG, "getAaid error", th.getMessage());
            return aaid;
        }
    }

    public static boolean getAgooServiceEnabled(Context context) {
        ComponentName componentName = new ComponentName(context, AdapterGlobalClientInfo.getAgooCustomServiceName(context.getPackageName()));
        PackageManager packageManager = context.getPackageManager();
        if (!componentName.getPackageName().equals(jn1.AND_NOT)) {
            return packageManager.getServiceInfo(componentName, 128).enabled;
        }
        ALog.e(TAG, "getAgooServiceEnabled,exception,comptName.getPackageName()=" + componentName.getPackageName(), new Object[0]);
        return false;
    }

    public static String getAppVersion(Context context) {
        try {
            return GlobalClientInfo.getInstance(context).getPackageInfo().versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String[] getAppkey(Context context) {
        String[] appkey;
        synchronized (mLock) {
            appkey = ACCSManager.getAppkey(context);
        }
        return appkey;
    }

    public static String getAppsign(Context context, String str, String str2, String str3, String str4, int i) {
        String str5;
        String str6;
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getAppsign appkey null", new Object[0]);
            return null;
        }
        try {
            if (isSecurityOff(str4)) {
                if (!TextUtils.isEmpty(str2)) {
                    byte[] bytes = str2.getBytes();
                    if (OrangeAdapter.isRegIdSwitchEnableAndValid(context)) {
                        str6 = "2&" + str + "&" + OrangeAdapter.getRegId(context) + "&" + i;
                    } else {
                        str6 = str + str3;
                    }
                    return fv0.b(bytes, str6.getBytes());
                }
                ALog.e(TAG, "getAppsign secret null", new Object[0]);
                return null;
            }
            SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
            if (securityGuardManager != null) {
                ALog.d(TAG, "getAppsign SecurityGuardManager not null!", new Object[0]);
                ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
                SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                securityGuardParamContext.appKey = str;
                Map<String, String> map = securityGuardParamContext.paramMap;
                if (OrangeAdapter.isRegIdSwitchEnableAndValid(context)) {
                    str5 = "2&" + OrangeAdapter.getRegId(context) + "&" + str + "&" + i;
                } else {
                    str5 = str3 + str;
                }
                map.put("INPUT", str5);
                securityGuardParamContext.requestType = 3;
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str4);
                return secureSignatureComp.signRequest(securityGuardParamContext, configByTag != null ? configByTag.getAuthCode() : null);
            }
            ALog.d(TAG, "getAppsign SecurityGuardManager is null", new Object[0]);
            return null;
        } catch (Throwable th) {
            ALog.e(TAG, "getAppsign", th, new Object[0]);
            return null;
        }
    }

    public static int getByteLen(String str) {
        if (str == null) {
            return 0;
        }
        try {
            return str.getBytes("utf-8").length;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getChannelProcessName(Context context) {
        return context.getPackageName() + SessionManager.CHANNEL_PROCESS;
    }

    public static String getCreateRegIdAppSign(Context context, String str, String str2, String str3, String str4, int i) {
        String signRequest;
        if (TextUtils.isEmpty(str)) {
            ALog.e(TAG, "getCreateRegIdAppSign appkey null", new Object[0]);
            return null;
        }
        try {
            if (isSecurityOff(str4)) {
                if (!TextUtils.isEmpty(str2)) {
                    byte[] bytes = str2.getBytes();
                    signRequest = fv0.b(bytes, ("1&" + str + "&" + str3 + "&" + i).getBytes());
                } else {
                    ALog.e(TAG, "getCreateRegIdAppSign secret null", new Object[0]);
                    return null;
                }
            } else {
                SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
                if (securityGuardManager != null) {
                    ALog.d(TAG, "getCreateRegIdAppSign SecurityGuardManager not null!", new Object[0]);
                    ISecureSignatureComponent secureSignatureComp = securityGuardManager.getSecureSignatureComp();
                    SecurityGuardParamContext securityGuardParamContext = new SecurityGuardParamContext();
                    securityGuardParamContext.appKey = str;
                    Map<String, String> map = securityGuardParamContext.paramMap;
                    map.put("INPUT", "1&" + str3 + "&" + str + "&" + i);
                    securityGuardParamContext.requestType = 3;
                    AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str4);
                    signRequest = secureSignatureComp.signRequest(securityGuardParamContext, configByTag != null ? configByTag.getAuthCode() : null);
                } else {
                    ALog.d(TAG, "getCreateRegIdAppSign SecurityGuardManager is null", new Object[0]);
                    return null;
                }
            }
            return signRequest;
        } catch (Throwable th) {
            ALog.e(TAG, "getCreateRegIdAppSign", th, new Object[0]);
            return null;
        }
    }

    public static String getDeviceId(Context context) {
        return AdapterUtilityImpl.getDeviceId(context);
    }

    public static String getEmuiVersion() {
        Class<?>[] clsArr = {String.class};
        Object[] objArr = {a.a};
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            String str = (String) cls.getDeclaredMethod(gn1.TYPE_OPEN_URL_METHOD_GET, clsArr).invoke(cls, objArr);
            ALog.d(TAG, "getEmuiVersion", "result", str);
            return !TextUtils.isEmpty(str) ? str : "";
        } catch (Exception e) {
            ALog.e(TAG, "getEmuiVersion", e, new Object[0]);
            return "";
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v5 */
    public static boolean getFocusDisableStatus(Context context) {
        if (context == 0) {
            return false;
        }
        try {
            try {
            } catch (Throwable th) {
                th = th;
            }
        } catch (Exception e) {
            e = e;
            context = false;
        }
        synchronized (mLock) {
            try {
                context = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).getBoolean(Constants.KEY_FOUCE_DISABLE, false);
                return context;
            } catch (Throwable th2) {
                th = th2;
                context = 0;
                try {
                    throw th;
                } catch (Exception e2) {
                    e = e2;
                    ALog.e(TAG, "getFocusDisableStatus", e, new Object[0]);
                    return context;
                }
            }
        }
    }

    public static final Map<String, String> getHeader(Map<String, List<String>> map) {
        HashMap hashMap = new HashMap();
        try {
            for (Map.Entry<String, List<String>> entry : map.entrySet()) {
                String key = entry.getKey();
                if (!TextUtils.isEmpty(key)) {
                    String list2String = list2String(entry.getValue());
                    if (!TextUtils.isEmpty(list2String)) {
                        if (!key.startsWith(":")) {
                            key = key.toLowerCase(Locale.US);
                        }
                        hashMap.put(key, list2String);
                    }
                }
            }
        } catch (Throwable unused) {
        }
        return hashMap;
    }

    public static String getMacAddress() {
        try {
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (TextUtils.isEmpty(macAddress)) {
            for (NetworkInterface networkInterface : Collections.list(NetworkInterface.getNetworkInterfaces())) {
                if (networkInterface.getName().equalsIgnoreCase("wlan0")) {
                    byte[] hardwareAddress = com.alibaba.wireless.security.aopsdk.replace.java.net.NetworkInterface.getHardwareAddress(networkInterface);
                    if (hardwareAddress == null) {
                        return null;
                    }
                    StringBuilder sb = new StringBuilder();
                    int length = hardwareAddress.length;
                    for (int i = 0; i < length; i++) {
                        sb.append(String.format("%02X:", Byte.valueOf(hardwareAddress[i])));
                    }
                    if (sb.length() > 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    String sb2 = sb.toString();
                    macAddress = sb2;
                    return sb2;
                }
            }
            return macAddress;
        }
        return macAddress;
    }

    public static String getMainProcessName(Context context) {
        return context.getPackageName();
    }

    public static String getNetworkType(Context context) {
        NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
        if (activeNetworkInfo == null) {
            return "unknown";
        }
        if (activeNetworkInfo.getType() == 1) {
            return "wifi";
        }
        String subtypeName = activeNetworkInfo.getSubtypeName();
        return !TextUtils.isEmpty(subtypeName) ? subtypeName.replaceAll(" ", "") : "";
    }

    public static String getNetworkTypeExt(Context context) {
        try {
            NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo((android.net.ConnectivityManager) context.getSystemService("connectivity"));
            if (activeNetworkInfo == null) {
                return "unknown";
            }
            if (activeNetworkInfo.getType() == 1) {
                return "wifi";
            }
            switch (activeNetworkInfo.getSubtype()) {
                case 1:
                case 2:
                case 4:
                case 7:
                case 11:
                    return "2g";
                case 3:
                case 5:
                case 6:
                case 8:
                case 9:
                case 10:
                case 12:
                case 14:
                case 15:
                    return "3g";
                case 13:
                    return "4g";
                default:
                    String subtypeName = activeNetworkInfo.getSubtypeName();
                    if (TextUtils.isEmpty(subtypeName)) {
                        return "unknown";
                    }
                    if (!subtypeName.equalsIgnoreCase("td-scdma") && !subtypeName.equalsIgnoreCase("td_scdma")) {
                        if (!subtypeName.equalsIgnoreCase("tds_hsdpa")) {
                            return "unknown";
                        }
                    }
                    return "3g";
            }
        } catch (Exception e) {
            ALog.e(TAG, "getNetworkTypeExt", e, new Object[0]);
            return null;
        }
    }

    public static String getProxy() {
        String str = getProxyIp() + ":" + getProxyPort();
        if (ALog.isPrintLog(ALog.Level.D)) {
            ALog.d(TAG, "getProxy:" + str, new Object[0]);
        }
        return str;
    }

    public static String getProxyHost(Context context) {
        String string = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 4).getString(Constants.KEY_PROXY_HOST, null);
        if (TextUtils.isEmpty(string)) {
            String proxyIp = getProxyIp();
            if (TextUtils.isEmpty(proxyIp)) {
                return null;
            }
            return proxyIp;
        }
        return string;
    }

    public static String getProxyIp() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultHost();
        }
        return System.getProperty("http.proxyHost");
    }

    public static int getProxyPort(Context context) {
        int i = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 4).getInt(Constants.KEY_PROXY_PORT, -1);
        if (i > 0) {
            return i;
        }
        if (getProxyHost(context) == null) {
            return -1;
        }
        try {
            return getProxyPort();
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long getServiceAliveTime(Context context) {
        SharedPreferences sharedPreferences;
        long j;
        long j2 = 0;
        try {
            sharedPreferences = APreferencesManager.getSharedPreferences(context, Constants.SP_CHANNEL_FILE_NAME, 0);
            long j3 = sharedPreferences.getLong(Constants.SP_KEY_SERVICE_START, 0L);
            j = j3 > 0 ? sharedPreferences.getLong(Constants.SP_KEY_SERVICE_END, 0L) - j3 : 0L;
        } catch (Throwable th) {
            th = th;
        }
        try {
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong(Constants.SP_KEY_SERVICE_START, 0L);
            edit.putLong(Constants.SP_KEY_SERVICE_END, 0L);
            edit.apply();
            return j;
        } catch (Throwable th2) {
            th = th2;
            j2 = j;
            ALog.e(TAG, "getServiceAliveTime:", th, new Object[0]);
            return j2;
        }
    }

    public static boolean getServiceEnabled(Context context) {
        return getServiceEnabled(context, new ComponentName(context, AdapterUtilityImpl.channelService));
    }

    public static String getStackMsg(Throwable th) {
        return AdapterUtilityImpl.getStackMsg(th);
    }

    public static long getUsableSpace() {
        return AdapterUtilityImpl.getUsableSpace();
    }

    public static String getUtdid(String str, Context context) {
        String string;
        try {
            synchronized (mLock) {
                string = APreferencesManager.getSharedPreferences(context, str, 0).getString("utdid", getDeviceId(context));
            }
            return string;
        } catch (Throwable th) {
            ALog.e(TAG, "getUtdid", th, new Object[0]);
            return "";
        }
    }

    public static String int2String(int i) {
        try {
            return String.valueOf(i);
        } catch (Exception e) {
            ALog.e(TAG, "int2String", e, new Object[0]);
            return null;
        }
    }

    private static long ipToLong(String str) {
        String[] split = str.split("\\.");
        if (split.length != 4) {
            return 0L;
        }
        return ((Long.parseLong(split[0]) & 255) << 24) | ((Long.parseLong(split[1]) & 255) << 16) | ((Long.parseLong(split[2]) & 255) << 8) | (255 & Long.parseLong(split[3]));
    }

    public static boolean isChannelProcess(Context context) {
        return AdapterUtilityImpl.isChannelProcess(context);
    }

    public static boolean isChannelProcessAlive(Context context) {
        return AdapterUtilityImpl.isProcessAlive(context, getChannelProcessName(context));
    }

    public static boolean isDualApp(Context context) {
        Boolean bool = isDual;
        if (bool == null) {
            try {
                try {
                    if (file == null) {
                        StringBuilder sb = new StringBuilder();
                        sb.append(context.getFilesDir().getAbsolutePath());
                        String str = File.separator;
                        sb.append(str);
                        sb.append("..");
                        sb.append(str);
                        sb.append("..");
                        file = new File(sb.toString());
                    }
                    Boolean valueOf = Boolean.valueOf(file.canRead());
                    isDual = valueOf;
                    boolean booleanValue = valueOf.booleanValue();
                    ALog.e(TAG, "isDualApp: " + isDual, new Object[0]);
                    return booleanValue;
                } catch (Throwable unused) {
                    Boolean bool2 = Boolean.FALSE;
                    isDual = bool2;
                    boolean booleanValue2 = bool2.booleanValue();
                    ALog.e(TAG, "isDualApp: " + isDual, new Object[0]);
                    return booleanValue2;
                }
            } catch (Throwable th) {
                ALog.e(TAG, "isDualApp: " + isDual, new Object[0]);
                throw th;
            }
        }
        return bool.booleanValue();
    }

    public static boolean isForeground(Context context) {
        return isForegroundByProcess(context);
    }

    public static boolean isForegroundByProcess(Context context) {
        try {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : GlobalClientInfo.getInstance(context).getActivityManager().getRunningAppProcesses()) {
                if (runningAppProcessInfo.importance == 100 && runningAppProcessInfo.processName.startsWith(context.getPackageName())) {
                    ALog.d(TAG, "isForegroundByProcess isRunningForeGround", new Object[0]);
                    return true;
                }
            }
        } catch (Exception e) {
            ALog.e(TAG, "isForegroundByProcess error ", e, new Object[0]);
        }
        ALog.d(TAG, "isForegroundByProcess isRunningBackGround", new Object[0]);
        return false;
    }

    public static boolean isHarmonyOs() {
        if (isHarmonyOs == null) {
            try {
                Class.forName("ohos.utils.system.SystemCapability");
                isHarmonyOs = Boolean.TRUE;
            } catch (Exception unused) {
                isHarmonyOs = Boolean.FALSE;
            }
        }
        return isHarmonyOs.booleanValue();
    }

    public static boolean isMainProcess(Context context) {
        return AdapterUtilityImpl.isMainProcess(context);
    }

    public static boolean isMainProcessAlive(Context context) {
        return AdapterUtilityImpl.isProcessAlive(context, context.getPackageName());
    }

    public static boolean isNetworkConnected(Context context) {
        if (context != null) {
            try {
                NetworkInfo activeNetworkInfo = ConnectivityManager.getActiveNetworkInfo(GlobalClientInfo.getInstance(context).getConnectivityManager());
                if (activeNetworkInfo != null) {
                    return activeNetworkInfo.isConnected();
                }
            } catch (Exception e) {
                ALog.e(TAG, "isNetworkConnected", e, new Object[0]);
            }
        }
        return false;
    }

    public static String isNotificationEnabled(Context context) {
        return AdapterUtilityImpl.isNotificationEnabled(context);
    }

    public static boolean isSameDay(long j, long j2) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date(j));
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(new Date(j2));
        return calendar.get(1) == calendar2.get(1) && calendar.get(2) == calendar2.get(2) && calendar.get(5) == calendar2.get(5);
    }

    private static boolean isSecurityOff(String str) {
        AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
        return (configByTag == null ? 0 : configByTag.getSecurity()) == 2;
    }

    public static boolean isServiceRunning(Context context) {
        for (ActivityManager.RunningServiceInfo runningServiceInfo : GlobalClientInfo.getInstance(context).getActivityManager().getRunningServices(Integer.MAX_VALUE)) {
            if (runningServiceInfo.service.getClassName().equals(AdapterUtilityImpl.channelService)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isTestMode() {
        return ALog.isPrintLog(ALog.Level.I);
    }

    public static void killService(Context context) {
        try {
            int myUid = Process.myUid();
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : GlobalClientInfo.getInstance(context).getActivityManager().getRunningAppProcesses()) {
                if (runningAppProcessInfo.uid == myUid) {
                    if (!TextUtils.isEmpty(AdapterGlobalClientInfo.mChannelProcessName) && AdapterGlobalClientInfo.mChannelProcessName.equals(runningAppProcessInfo.processName)) {
                        ALog.e(TAG, "killService", com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    } else if (runningAppProcessInfo.processName.endsWith(SessionManager.CHANNEL_PROCESS)) {
                        ALog.e(TAG, "killService", com.taobao.aranger.constant.Constants.PARAM_PROCESS_NAME, runningAppProcessInfo.processName);
                        Process.killProcess(runningAppProcessInfo.pid);
                        return;
                    }
                }
            }
            ALog.e(TAG, "kill nothing", new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "killService", th, new Object[0]);
        }
    }

    private static String leftPadding(String str, boolean z, int i) {
        int length = TextUtils.isEmpty(str) ? 0 : str.length();
        if (length >= i) {
            return str;
        }
        int i2 = i - length;
        StringBuilder sb = new StringBuilder();
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(z ? PADDING_DIGITS.charAt(PADDING_RANDOM.nextInt(62)) : '0');
        }
        sb.append(str);
        return sb.toString();
    }

    public static final String list2String(List<String> list) {
        StringBuffer stringBuffer = new StringBuffer();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            stringBuffer.append(list.get(i));
            if (i < size - 1) {
                stringBuffer.append(",");
            }
        }
        return stringBuffer.toString();
    }

    public static boolean notificationStateChanged(String str, Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str = false;
        }
        try {
            synchronized (mLock) {
                try {
                    String isNotificationEnabled = isNotificationEnabled(context);
                    z = !APreferencesManager.getSharedPreferences(context, str, 0).getString("notification_state", isNotificationEnabled).equals(isNotificationEnabled);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e(TAG, "notificationStateChanged", th, new Object[0]);
                        z = str;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static boolean packageExist(Context context, String str) {
        try {
            context.getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            ALog.e(TAG, "package not exist", "pkg", str);
            return false;
        }
    }

    public static String restoreCookie(Context context) {
        try {
            return APreferencesManager.getSharedPreferences(context, Constants.SP_COOKIE_FILE_NAME, 4).getString(Constants.SP_KEY_COOKIE_SEC, null);
        } catch (Exception e) {
            ALog.e(TAG, "reStoreCookie fail", e, new Object[0]);
            return null;
        }
    }

    public static void saveAppKey(Context context, String str) {
        try {
            synchronized (mLock) {
                SharedPreferences sharedPreferences = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0);
                String string = sharedPreferences.getString("appkey", "");
                if (!TextUtils.isEmpty(str) && !string.equals(str) && !string.contains(str)) {
                    if (!TextUtils.isEmpty(string)) {
                        str = string + "|" + str;
                    }
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putString("appkey", str);
                    edit.apply();
                }
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    private static void saveAppVersion(Context context) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_FILE_NAME, 0).edit();
            edit.putInt(Constants.KEY_APP_VERSION_CODE, GlobalClientInfo.getInstance(context).getPackageInfo().versionCode);
            edit.putString(Constants.KEY_APP_VERSION_NAME, GlobalClientInfo.getInstance(context).getPackageInfo().versionName);
            edit.apply();
        } catch (Throwable th) {
            ALog.e(TAG, "saveAppVersion", th, new Object[0]);
        }
    }

    public static void saveNotificationState(Context context, String str, String str2) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, str, 4).edit();
            edit.putString("notification_state", str2);
            edit.apply();
        } catch (Exception e) {
            ALog.e(TAG, "saveNotificationState fail", e, new Object[0]);
        }
    }

    public static void saveUtdid(String str, Context context) {
        try {
            synchronized (mLock) {
                SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, str, 0).edit();
                edit.putString("utdid", getDeviceId(context));
                edit.apply();
            }
        } catch (Throwable th) {
            ALog.e(TAG, "saveUtdid", th, new Object[0]);
        }
    }

    public static void setServiceTime(Context context, String str, long j) {
        try {
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_CHANNEL_FILE_NAME, 0).edit();
            edit.putLong(str, j);
            edit.apply();
            ALog.d(TAG, "setServiceTime:" + j, new Object[0]);
        } catch (Throwable th) {
            ALog.e(TAG, "setServiceTime:", th, new Object[0]);
        }
    }

    public static byte[] staticBinarySafeDecryptNoB64(Context context, String str, String str2, byte[] bArr) {
        IStaticDataEncryptComponent staticDataEncryptComp;
        byte[] bArr2 = null;
        if (isSecurityOff(str)) {
            return null;
        }
        if (context != null && bArr != null) {
            try {
                AccsClientConfig configByTag = AccsClientConfig.getConfigByTag(str);
                String authCode = configByTag != null ? configByTag.getAuthCode() : null;
                ALog.i(TAG, "staticBinarySafeDecryptNoB64", "appkey", str2, "authcode", authCode);
                SecurityGuardManager securityGuardManager = SecurityGuardManager.getInstance(context);
                if (securityGuardManager != null && (staticDataEncryptComp = securityGuardManager.getStaticDataEncryptComp()) != null) {
                    bArr2 = staticDataEncryptComp.staticBinarySafeDecryptNoB64(16, SpdyProtocol.TNET_PUBKEY_SG_KEY, bArr, authCode);
                }
                if (bArr2 == null) {
                    ALog.e(TAG, "staticBinarySafeDecryptNoB64 null", new Object[0]);
                }
            } catch (Throwable th) {
                ALog.e(TAG, "staticBinarySafeDecryptNoB64", th, new Object[0]);
            }
            return bArr2;
        }
        ALog.e(TAG, "staticBinarySafeDecryptNoB64 input null!", new Object[0]);
        return null;
    }

    public static void storeCookie(Context context, String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            GlobalClientInfo.mCookieSec = str;
            SharedPreferences.Editor edit = APreferencesManager.getSharedPreferences(context, Constants.SP_COOKIE_FILE_NAME, 0).edit();
            edit.putString(Constants.SP_KEY_COOKIE_SEC, str);
            edit.apply();
        } catch (Exception e) {
            ALog.e(TAG, "storeCookie fail", e, new Object[0]);
        }
    }

    public static String urlEncode(String str) {
        try {
            return URLEncoder.encode(str, "utf-8");
        } catch (UnsupportedEncodingException unused) {
            return str;
        }
    }

    public static boolean utdidChanged(String str, Context context) {
        boolean z;
        try {
        } catch (Throwable th) {
            th = th;
            str = false;
        }
        try {
            synchronized (mLock) {
                try {
                    String deviceId = getDeviceId(context);
                    z = !APreferencesManager.getSharedPreferences(context, str, 0).getString("utdid", deviceId).equals(deviceId);
                    return z;
                } catch (Throwable th2) {
                    th = th2;
                    str = null;
                    try {
                        throw th;
                    } catch (Throwable th3) {
                        th = th3;
                        ALog.e(TAG, "utdidChanged", th, new Object[0]);
                        z = str;
                        return z;
                    }
                }
            }
        } catch (Throwable th4) {
            th = th4;
        }
    }

    public static void enableService(Context context, ComponentName componentName) {
        if (context == null || componentName == null) {
            return;
        }
        ALog.d(TAG, "enableService", "comptName", componentName);
        try {
            context.getPackageManager().setComponentEnabledSetting(componentName, 1, 1);
        } catch (Throwable th) {
            ALog.w(TAG, "enableService", th, new Object[0]);
        }
    }

    public static boolean getServiceEnabled(Context context, ComponentName componentName) {
        if (context != null && componentName != null) {
            try {
                if (context.getPackageManager().getServiceInfo(componentName, 128).enabled) {
                    return true;
                }
            } catch (Throwable th) {
                th.printStackTrace();
                ALog.e(TAG, getStackMsg(th), new Object[0]);
            }
        }
        return false;
    }

    public static int getProxyPort() {
        if (Build.VERSION.SDK_INT < 11) {
            return Proxy.getDefaultPort();
        }
        try {
            return Integer.parseInt(System.getProperty("http.proxyPort"));
        } catch (NumberFormatException unused) {
            return -1;
        }
    }
}
