package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Binder;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.alibaba.analytics.utils.Logger;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class fs1 {
    private static final Random a = new Random();
    private static String b = "";
    private static String c = "";
    private static boolean d = false;
    private static boolean e = false;

    private static boolean a(Context context, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                return context.checkPermission(str, Binder.getCallingPid(), Binder.getCallingUid()) == 0;
            } catch (Exception unused) {
                return true;
            }
        }
        return true;
    }

    public static String b(Context context) {
        String c2;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_ie", "");
                if (!yh2.f(string)) {
                    String str = new String(ga.a(string.getBytes(), 2), "UTF-8");
                    if (!yh2.f(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
            c2 = c(context);
        } else {
            c2 = null;
        }
        if (yh2.f(c2)) {
            c2 = f();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_ie", new String(ga.c(c2.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e2) {
                e2.printStackTrace();
            }
        }
        return c2;
    }

    public static synchronized String c(Context context) {
        synchronized (fs1.class) {
            if (d) {
                return b;
            } else if (context == null) {
                return null;
            } else {
                try {
                    if (!a(context, "android.permission.READ_PHONE_STATE")) {
                        return null;
                    }
                } catch (Throwable unused) {
                }
                try {
                    Logger.f("PhoneInfoUtils", "getImei");
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        b = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getDeviceId(telephonyManager);
                    }
                } catch (Throwable unused2) {
                }
                d = true;
                return b;
            }
        }
    }

    public static String d(Context context) {
        String e2;
        if (context != null) {
            try {
                String string = context.getSharedPreferences("UTCommon", 0).getString("_is", "");
                if (!yh2.f(string)) {
                    String str = new String(ga.a(string.getBytes(), 2), "UTF-8");
                    if (!yh2.f(str)) {
                        return str;
                    }
                }
            } catch (Exception unused) {
            }
            e2 = e(context);
        } else {
            e2 = null;
        }
        if (yh2.f(e2)) {
            e2 = f();
        }
        if (context != null) {
            try {
                SharedPreferences.Editor edit = context.getSharedPreferences("UTCommon", 0).edit();
                edit.putString("_is", new String(ga.c(e2.getBytes("UTF-8"), 2)));
                edit.commit();
            } catch (UnsupportedEncodingException e3) {
                e3.printStackTrace();
            }
        }
        return e2;
    }

    public static synchronized String e(Context context) {
        synchronized (fs1.class) {
            if (e) {
                return c;
            } else if (context == null) {
                return null;
            } else {
                try {
                    if (!a(context, "android.permission.READ_PHONE_STATE")) {
                        return null;
                    }
                } catch (Throwable unused) {
                }
                try {
                    Logger.f("PhoneInfoUtils", "getImsi");
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    if (telephonyManager != null) {
                        c = com.alibaba.wireless.security.aopsdk.replace.android.telephony.TelephonyManager.getSubscriberId(telephonyManager);
                    }
                } catch (Throwable unused2) {
                }
                e = true;
                return c;
            }
        }
    }

    public static final String f() {
        int currentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int nanoTime = (int) System.nanoTime();
        Random random = a;
        int nextInt = random.nextInt();
        int nextInt2 = random.nextInt();
        byte[] a2 = p31.a(currentTimeMillis);
        byte[] a3 = p31.a(nanoTime);
        byte[] a4 = p31.a(nextInt);
        byte[] a5 = p31.a(nextInt2);
        byte[] bArr = new byte[16];
        System.arraycopy(a2, 0, bArr, 0, 4);
        System.arraycopy(a3, 0, bArr, 4, 4);
        System.arraycopy(a4, 0, bArr, 8, 4);
        System.arraycopy(a5, 0, bArr, 12, 4);
        return ga.e(bArr, 2);
    }
}
