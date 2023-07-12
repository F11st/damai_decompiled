package android.taobao.windvane.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.wifi.WifiManager;
import com.alibaba.wireless.security.aopsdk.replace.android.net.wifi.WifiInfo;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager;
import com.youku.upsplayer.util.YKUpsConvert;
import java.util.Random;
import tb.gn1;

/* compiled from: Taobao */
/* loaded from: classes12.dex */
public class PhoneInfo {
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String MACADDRESS = "mac_address";

    private static String generateImei() {
        try {
            StringBuilder sb = new StringBuilder();
            long currentTimeMillis = System.currentTimeMillis();
            String l = Long.toString(currentTimeMillis);
            sb.append(l.substring(l.length() - 5));
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Build.getMODEL().replaceAll(" ", ""));
            while (sb2.length() < 6) {
                sb2.append(YKUpsConvert.CHAR_ZERO);
            }
            sb.append(sb2.substring(0, 6));
            Random random = new Random(currentTimeMillis);
            long j = 0;
            while (j < 4096) {
                j = random.nextLong();
            }
            sb.append(Long.toHexString(j).substring(0, 4));
            return sb.toString();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getAndroidId(Context context) {
        return Settings.Secure.getString(context.getContentResolver(), "android_id");
    }

    public static String getImei(Context context) {
        try {
            SharedPreferences sharedPreferences = context.getSharedPreferences("imei", 0);
            String string = sharedPreferences.getString("imei", null);
            if (string == null || string.length() == 0) {
                string = generateImei().replaceAll(" ", "").trim();
                while (string.length() < 15) {
                    string = "0" + string;
                }
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("imei", string);
                edit.commit();
            }
            return string.trim();
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String getImsi(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("imei", 0);
        String string = sharedPreferences.getString("imsi", null);
        if (string == null || string.length() == 0) {
            string = generateImei().replaceAll(" ", "").trim();
            while (string.length() < 15) {
                string = "0" + string;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putString("imsi", string);
            edit.commit();
        }
        return string;
    }

    public static String getLocalMacAddress(Context context) {
        String macAddress = WifiInfo.getMacAddress(((WifiManager) context.getSystemService("wifi")).getConnectionInfo());
        if (macAddress != null && !"".equals(macAddress)) {
            SharedPreferences.Editor edit = context.getSharedPreferences(MACADDRESS, 0).edit();
            edit.putString(MACADDRESS, macAddress);
            edit.commit();
            return macAddress;
        }
        return context.getSharedPreferences(MACADDRESS, 0).getString(MACADDRESS, "");
    }

    public static String getOriginalImei(Context context) {
        String str;
        try {
            str = TelephonyManager.getDeviceId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Throwable unused) {
            str = null;
        }
        return str != null ? str.trim() : str;
    }

    public static String getOriginalImsi(Context context) {
        String str;
        try {
            str = TelephonyManager.getSubscriberId((android.telephony.TelephonyManager) context.getSystemService("phone"));
        } catch (Exception unused) {
            str = null;
        }
        return str != null ? str.trim() : str;
    }

    public static String getSerialNum() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(gn1.TYPE_OPEN_URL_METHOD_GET, String.class, String.class).invoke(cls, "ro.serialno", "unknown");
        } catch (Exception unused) {
            return null;
        }
    }
}
