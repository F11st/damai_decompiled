package com.ta.utdid2.android.utils;

import android.content.Context;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.provider.Settings;
import com.ta.audid.permission.PermissionUtils;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes7.dex */
public class PhoneInfoUtils {
    private static boolean mPrivacyMode;

    private static String getCheckAndroidID(Context context) {
        String string;
        String str = "";
        try {
            string = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } catch (Throwable unused) {
        }
        try {
            if (!TextUtils.isEmpty(string) && !string.equalsIgnoreCase("a5f5faddde9e9f02") && !string.equalsIgnoreCase("8e17f7422b35fbea") && !string.equalsIgnoreCase("ece1e988e8bf71f2") && !string.equalsIgnoreCase("9e3ecdf2be3b9a69")) {
                if (!string.equalsIgnoreCase("0000000000000000")) {
                    return string;
                }
            }
            return "";
        } catch (Throwable unused2) {
            str = string;
            return str;
        }
    }

    public static String getImei(Context context) {
        TelephonyManager telephonyManager;
        String str = null;
        if (!mPrivacyMode && !BuildCompatUtils.isAtLeastQ() && context != null) {
            try {
                if (PermissionUtils.checkReadPhoneStatePermissionGranted(context) && (telephonyManager = (TelephonyManager) context.getSystemService("phone")) != null) {
                    str = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                }
            } catch (Exception unused) {
            }
        }
        if (StringUtils.isEmpty(str)) {
            str = getYunOSUuid();
        }
        if (!mPrivacyMode && StringUtils.isEmpty(str)) {
            str = getCheckAndroidID(context);
        }
        return StringUtils.isEmpty(str) ? getUniqueID() : str;
    }

    @Deprecated
    public static String getImsi(Context context) {
        return "";
    }

    public static String getUniqueID() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        int nextInt = new Random().nextInt();
        int nextInt2 = new Random().nextInt();
        byte[] bytes = IntUtils.getBytes(currentTimeMillis);
        byte[] bytes2 = IntUtils.getBytes(nanoTime);
        byte[] bytes3 = IntUtils.getBytes(nextInt);
        byte[] bytes4 = IntUtils.getBytes(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(bytes, 0, bArr, 0, 4);
        System.arraycopy(bytes2, 0, bArr, 4, 4);
        System.arraycopy(bytes3, 0, bArr, 8, 4);
        System.arraycopy(bytes4, 0, bArr, 12, 4);
        return Base64.encodeToString(bArr, 2);
    }

    private static String getYunOSTVUuid() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String getYunOSUuid() {
        String str = SystemProperties.get("ro.aliyun.clouduuid", "");
        if (TextUtils.isEmpty(str)) {
            str = SystemProperties.get("ro.sys.aliyun.clouduuid", "");
        }
        return TextUtils.isEmpty(str) ? getYunOSTVUuid() : str;
    }

    public static boolean isPrivacyMode() {
        return mPrivacyMode;
    }

    public static void setPrivacyMode(boolean z) {
        mPrivacyMode = z;
    }
}
