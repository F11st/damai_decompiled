package com.youku.live.dago.widgetlib.ailpbaselib.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.taobao.windvane.util.PhoneInfo;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import com.youku.live.dsl.Dsl;
import com.youku.live.dsl.log.ILog;
import com.youku.live.livesdk.wkit.component.common.utils.StorageTools;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class DeviceUtils {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final String TAG = "DeviceUtils";

    private DeviceUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean checkPermission(Context context, String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1977238925")) {
            return ((Boolean) ipChange.ipc$dispatch("1977238925", new Object[]{context, str})).booleanValue();
        }
        try {
            if (context.checkCallingOrSelfPermission(str) != 0) {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, "no permission");
                return false;
            }
            return true;
        } catch (Exception e) {
            String str2 = TAG;
            ((ILog) Dsl.getService(ILog.class)).e(str2, "exception occured in checkPermission method:" + e.toString());
            return false;
        }
    }

    @SuppressLint({"HardwareIds"})
    public static String getAndroidID() {
        IpChange ipChange = $ipChange;
        return AndroidInstantRuntime.support(ipChange, "386625770") ? (String) ipChange.ipc$dispatch("386625770", new Object[0]) : Settings.Secure.getString(AppContextUtils.getApp().getContentResolver(), "android_id");
    }

    public static String getGUID(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "2051961625")) {
            return (String) ipChange.ipc$dispatch("2051961625", new Object[]{context});
        }
        String headerPreference = StorageTools.getHeaderPreference(context, "guid");
        if (headerPreference == null || headerPreference.length() <= 0) {
            String macAddress = getMacAddress(context);
            String imei = getIMEI(context);
            headerPreference = md5(macAddress + "&" + imei + "&&");
            if (headerPreference == null || headerPreference.length() <= 0) {
                return "";
            }
            StorageTools.savePreference(context, "guid", headerPreference);
        }
        return headerPreference;
    }

    public static String getIMEI(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1954136890")) {
            return (String) ipChange.ipc$dispatch("1954136890", new Object[]{context});
        }
        String headerPreference = StorageTools.getHeaderPreference(context, "imei");
        if (TextUtils.isEmpty(headerPreference)) {
            try {
                String deviceId = TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getApplicationContext().getSystemService("phone"));
                if (deviceId == null || deviceId.length() <= 0) {
                    return "";
                }
                StorageTools.savePreference(context, "imei", deviceId);
                return deviceId;
            } catch (Exception e) {
                ((ILog) Dsl.getService(ILog.class)).e(TAG, e.toString());
                return "";
            }
        }
        return headerPreference;
    }

    public static String getMacAddress(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1834212451")) {
            return (String) ipChange.ipc$dispatch("-1834212451", new Object[]{context});
        }
        String headerPreference = StorageTools.getHeaderPreference(context, PhoneInfo.MACADDRESS);
        if (TextUtils.isEmpty(headerPreference)) {
            try {
                WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
                if (checkPermission(context, "android.permission.ACCESS_WIFI_STATE")) {
                    WifiInfo connectionInfo = wifiManager == null ? null : wifiManager.getConnectionInfo();
                    if (connectionInfo != null) {
                        headerPreference = com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo.getMacAddress(connectionInfo);
                        if (headerPreference != null && headerPreference.length() > 0) {
                            StorageTools.savePreference(context, PhoneInfo.MACADDRESS, headerPreference);
                        }
                        ((ILog) Dsl.getService(ILog.class)).e(TAG, "获取到的mac address为null.");
                        return "";
                    }
                } else {
                    ((ILog) Dsl.getService(ILog.class)).e(TAG, "Could not get mac address.[no permission android.permission.ACCESS_WIFI_STATE");
                }
            } catch (Exception e) {
                String str = TAG;
                ((ILog) Dsl.getService(ILog.class)).e(str, "Could not get mac address：" + e.toString());
            }
            return headerPreference;
        }
        return headerPreference;
    }

    public static String md5(String str) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1437584428")) {
            return (String) ipChange.ipc$dispatch("-1437584428", new Object[]{str});
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
            messageDigest.update(str.getBytes("UTF-8"));
            byte[] digest = messageDigest.digest();
            StringBuffer stringBuffer = new StringBuffer();
            for (byte b : digest) {
                String hexString = Integer.toHexString(b & 255);
                while (hexString.length() < 2) {
                    hexString = "0" + hexString;
                }
                stringBuffer.append(hexString);
            }
            return stringBuffer.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException unused) {
            return "";
        }
    }
}
