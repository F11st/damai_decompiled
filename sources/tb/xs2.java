package tb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.alibaba.analytics.core.model.LogField;
import com.alibaba.analytics.core.model.UTMCLogFields;
import com.alibaba.analytics.core.network.NetworkOperatorUtil;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.analytics.utils.Logger;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.taobao.weex.common.Constants;
import com.ut.device.UTDevice;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class xs2 {
    private static Map<String, String> a;
    private static boolean b;
    private static boolean c;

    private static String a() {
        try {
            Field declaredField = Build.class.getDeclaredField("YUNOS_BUILD_VERSION");
            if (declaredField != null) {
                declaredField.setAccessible(true);
                return (String) declaredField.get(new String());
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static synchronized Map<String, String> b(Context context) {
        synchronized (xs2.class) {
            Map<String, String> map = a;
            if (map != null) {
                return map;
            }
            if (context != null) {
                HashMap hashMap = new HashMap();
                try {
                    try {
                        hashMap.put(LogField.UTDID.toString(), UTDevice.getUtdid(context));
                    } catch (Exception unused) {
                        return null;
                    }
                } catch (Exception unused2) {
                    Log.e("", "utdid4all jar doesn't exist");
                }
                hashMap.put(LogField.IMEI.toString(), fs1.b(context));
                hashMap.put(LogField.IMSI.toString(), fs1.d(context));
                hashMap.put(LogField.DEVICE_MODEL.toString(), com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getMODEL());
                hashMap.put(LogField.BRAND.toString(), com.alibaba.wireless.security.aopsdk.replace.android.os.Build.getBRAND());
                hashMap.put(LogField.OSVERSION.toString(), Build.VERSION.getRELEASE());
                hashMap.put(LogField.OS.toString(), "a");
                try {
                    hashMap.put(LogField.APPVERSION.toString(), context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName);
                } catch (PackageManager.NameNotFoundException unused3) {
                    hashMap.put(LogField.APPVERSION.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
                }
                if (h()) {
                    hashMap.put(LogField.OS.toString(), Constants.Name.Y);
                    String c2 = c();
                    if (!yh2.f(c2)) {
                        hashMap.put(UTMCLogFields.DEVICE_ID.toString(), c2);
                    }
                    String property = System.getProperty("ro.yunos.version");
                    if (!yh2.f(property)) {
                        hashMap.put(LogField.OSVERSION.toString(), property);
                    }
                    String a2 = a();
                    if (!yh2.f(a2)) {
                        hashMap.put(LogField.OSVERSION.toString(), a2);
                    }
                }
                if (i()) {
                    hashMap.put(LogField.OS.toString(), "a");
                }
                try {
                    Configuration configuration = new Configuration();
                    Settings.System.getConfiguration(context.getContentResolver(), configuration);
                    if (configuration.locale != null) {
                        hashMap.put(LogField.LANGUAGE.toString(), configuration.locale.toString());
                    } else {
                        hashMap.put(LogField.LANGUAGE.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
                    }
                    DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
                    int i = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                    int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                    if (i2 > i) {
                        String str = LogField.RESOLUTION.toString();
                        hashMap.put(str, i2 + jn1.MUL + i);
                    } else {
                        String str2 = LogField.RESOLUTION.toString();
                        hashMap.put(str2, i + jn1.MUL + i2);
                    }
                } catch (Exception unused4) {
                    hashMap.put(LogField.RESOLUTION.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
                }
                j(context, hashMap);
                a = hashMap;
                return hashMap;
            }
            return null;
        }
    }

    private static String c() {
        String a2 = mj2.a("ro.aliyun.clouduuid");
        if (yh2.f(a2)) {
            a2 = mj2.a("ro.sys.aliyun.clouduuid");
        }
        return yh2.f(a2) ? d() : a2;
    }

    private static String d() {
        try {
            return (String) Class.forName("com.yunos.baseservice.clouduuid.CloudUUID").getMethod("getCloudUUID", new Class[0]).invoke(null, new Object[0]);
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean e(Context context) {
        if (c) {
            return b;
        }
        boolean z = false;
        if (context == null) {
            return false;
        }
        z = (f(context) || g(context)) ? true : true;
        b = z;
        c = true;
        return z;
    }

    private static boolean f(Context context) {
        try {
            return ((TelephonyManager) context.getSystemService("phone")).getPhoneType() == 0;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean g(Context context) {
        try {
            return (context.getResources().getConfiguration().screenLayout & 15) >= 3;
        } catch (Throwable unused) {
            return false;
        }
    }

    private static boolean h() {
        if ((System.getProperty("java.vm.name") == null || !System.getProperty("java.vm.name").toLowerCase().contains("lemur")) && TextUtils.isEmpty(System.getProperty("ro.yunos.version")) && TextUtils.isEmpty(mj2.a("ro.yunos.build.version"))) {
            return i();
        }
        return true;
    }

    private static boolean i() {
        return (TextUtils.isEmpty(mj2.a("ro.yunos.product.chip")) && TextUtils.isEmpty(mj2.a("ro.yunos.hardware"))) ? false : true;
    }

    private static void j(Context context, Map<String, String> map) {
        if (context == null || map == null) {
            return;
        }
        Logger.f("UTMCDevice", "updateDeviceNetworkStatus");
        try {
            String[] f = NetworkUtil.f(context);
            map.put(LogField.ACCESS.toString(), f[0]);
            if (f[0].equals(NetworkUtil.NETWORK_CLASS_2_3_G)) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), f[1]);
            } else if (f[1].equals("5G")) {
                map.put(LogField.ACCESS_SUBTYPE.toString(), "5G");
            } else {
                map.put(LogField.ACCESS_SUBTYPE.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
            }
        } catch (Exception unused) {
            map.put(LogField.ACCESS.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
            map.put(LogField.ACCESS_SUBTYPE.toString(), NetworkUtil.NETWORK_CLASS_UNKNOWN);
        }
        map.put(LogField.CARRIER.toString(), NetworkOperatorUtil.c());
    }

    public static synchronized void k(Context context) {
        synchronized (xs2.class) {
            j(context, a);
        }
    }
}
