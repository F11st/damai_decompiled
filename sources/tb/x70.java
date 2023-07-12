package tb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.res.Configuration;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;
import com.alibaba.analytics.core.network.NetworkUtil;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.alibaba.wireless.security.aopsdk.replace.android.view.Display;
import com.ut.device.UTDevice;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class x70 {
    private static z70 a;

    private static void a(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("Alvin3", 0);
        SharedPreferences sharedPreferences2 = context.getSharedPreferences("UTCommon", 0);
        if (sharedPreferences2 == null || sharedPreferences == null) {
            return;
        }
        String string = sharedPreferences.getString("EI", null);
        String string2 = sharedPreferences.getString("SI", null);
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2)) {
            return;
        }
        String string3 = sharedPreferences2.getString("EI", null);
        String string4 = sharedPreferences2.getString("SI", null);
        if (!string.equals(string3)) {
            SharedPreferences.Editor edit = sharedPreferences2.edit();
            edit.putString("EI", string);
            edit.commit();
        }
        if (string2.equals(string4)) {
            return;
        }
        SharedPreferences.Editor edit2 = sharedPreferences2.edit();
        edit2.putString("SI", string2);
        edit2.commit();
    }

    private static z70 b(Context context) {
        if (context != null) {
            z70 d = d(context);
            d.v(UTDevice.getUtdid(context));
            if (yh2.f(d.b())) {
                d.m(es1.a(context));
            }
            if (yh2.f(d.c())) {
                d.n(es1.b(context));
            }
            return d;
        }
        return null;
    }

    public static synchronized z70 c(Context context) {
        synchronized (x70.class) {
            z70 z70Var = a;
            if (z70Var != null) {
                return z70Var;
            }
            if (context != null) {
                z70 b = b(context);
                if (b != null) {
                    try {
                        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                        if (telephonyManager == null) {
                            return null;
                        }
                        b.l(Build.getMODEL());
                        try {
                            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                            String str = packageInfo.versionName;
                            int i = packageInfo.versionCode;
                            b.w("" + i);
                            b.g(str);
                        } catch (Exception unused) {
                            b.w(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                            b.g(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                        }
                        b.h(Build.getBRAND());
                        b.p("Android");
                        if (e()) {
                            b.p("aliyunos");
                        }
                        b.q(Build.VERSION.getRELEASE());
                        Configuration configuration = new Configuration();
                        Settings.System.getConfiguration(context.getContentResolver(), configuration);
                        Locale locale = configuration.locale;
                        if (locale != null) {
                            b.j(locale.getCountry());
                            b.o(configuration.locale.toString());
                            Calendar calendar = Calendar.getInstance(configuration.locale);
                            if (calendar != null) {
                                TimeZone timeZone = calendar.getTimeZone();
                                if (timeZone != null) {
                                    b.u("" + (timeZone.getRawOffset() / 3600000));
                                } else {
                                    b.u("8");
                                }
                            } else {
                                b.u("8");
                            }
                        } else {
                            b.j(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                            b.o(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                            b.u("8");
                        }
                        try {
                            DisplayMetrics displayMetrics = new DisplayMetrics();
                            Display.getMetrics(((WindowManager) context.getSystemService(v.ATTACH_MODE_WINDOW)).getDefaultDisplay(), displayMetrics);
                            int i2 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getwidthPixels(displayMetrics);
                            int i3 = com.alibaba.wireless.security.aopsdk.replace.android.util.DisplayMetrics.getheightPixels(displayMetrics);
                            b.t(i2);
                            b.s(i3);
                            if (i2 > i3) {
                                int i4 = i2 ^ i3;
                                i3 ^= i4;
                                i2 = i4 ^ i3;
                            }
                            b.r(i3 + jn1.MUL + i2);
                        } catch (Exception unused2) {
                            b.r(NetworkUtil.NETWORK_CLASS_UNKNOWN);
                        }
                        b.e(NetworkUtil.c(context));
                        b.f(NetworkUtil.c(context));
                        String networkOperatorName = telephonyManager.getNetworkOperatorName();
                        if (yh2.f(networkOperatorName)) {
                            networkOperatorName = "";
                        }
                        b.i(networkOperatorName);
                    } catch (Exception unused3) {
                        return null;
                    }
                }
                a = b;
                return b;
            }
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:32:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0093  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static tb.z70 d(android.content.Context r8) {
        /*
            Method dump skipped, instructions count: 260
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: tb.x70.d(android.content.Context):tb.z70");
    }

    private static boolean e() {
        String property = System.getProperty("java.vm.name");
        return (property != null && property.toLowerCase().contains("lemur")) || System.getProperty("ro.yunos.version") != null;
    }

    static void f(Context context, String str, String str2) {
        nr1 b;
        String str3;
        if (context == null || yh2.f(str) || yh2.f(str2) || (b = mv0.b(context)) == null) {
            return;
        }
        String str4 = null;
        try {
            str3 = com.alibaba.analytics.utils.a.i(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e = e;
            str3 = null;
        }
        try {
            str4 = com.alibaba.analytics.utils.a.i(str2.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            e.printStackTrace();
            if (yh2.f(str3)) {
                return;
            }
            return;
        }
        if (yh2.f(str3) || yh2.f(str4)) {
            return;
        }
        b.d("EI", str3);
        b.d("SI", str4);
        b.a();
    }
}
