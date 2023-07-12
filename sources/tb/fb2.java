package tb;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.alibaba.wireless.security.aopsdk.replace.android.os.Build;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* compiled from: Taobao */
/* loaded from: classes4.dex */
public class fb2 {
    private static transient /* synthetic */ IpChange $ipChange = null;
    public static final int CODE_SETTING_REQUEST = 2168;
    private static final String a = Build.getMANUFACTURER().toLowerCase();

    private static Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1757444371")) {
            return (Intent) ipChange.ipc$dispatch("-1757444371", new Object[]{context});
        }
        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
        intent.setData(Uri.fromParts("package", context.getPackageName(), null));
        return intent;
    }

    public static String b(String str) {
        BufferedReader bufferedReader;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1465777791")) {
            return (String) ipChange.ipc$dispatch("-1465777791", new Object[]{str});
        }
        BufferedReader bufferedReader2 = null;
        try {
            Runtime runtime = Runtime.getRuntime();
            bufferedReader = new BufferedReader(new InputStreamReader(runtime.exec("getprop " + str).getInputStream()), 1024);
        } catch (IOException unused) {
        } catch (Throwable th) {
            th = th;
        }
        try {
            String readLine = bufferedReader.readLine();
            try {
                bufferedReader.close();
            } catch (IOException unused2) {
            }
            return readLine;
        } catch (IOException unused3) {
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused4) {
                }
            }
            return "";
        } catch (Throwable th2) {
            th = th2;
            bufferedReader2 = bufferedReader;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException unused5) {
                }
            }
            throw th;
        }
    }

    private static Intent c(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "878381447")) {
            return (Intent) ipChange.ipc$dispatch("878381447", new Object[]{context});
        }
        if (Build.VERSION.SDK_INT >= 23) {
            return a(context);
        }
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.huawei.systemmanager", "com.huawei.permissionmanager.ui.MainActivity"));
        return intent;
    }

    private static Intent d(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1109999800")) {
            return (Intent) ipChange.ipc$dispatch("1109999800", new Object[]{context});
        }
        if (Build.VERSION.SDK_INT >= 24) {
            return a(context);
        }
        Intent intent = new Intent("com.meizu.safe.security.SHOW_APPSEC");
        intent.putExtra("packageName", context.getPackageName());
        intent.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
        return intent;
    }

    public static void e(Activity activity) {
        Intent a2;
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "1147939764")) {
            ipChange.ipc$dispatch("1147939764", new Object[]{activity});
        } else if (activity == null) {
        } else {
            String str = a;
            if (str.contains("huawei")) {
                a2 = c(activity);
            } else if (str.contains("xiaomi")) {
                a2 = f(activity);
            } else if (str.contains("oppo")) {
                a2 = a(activity);
            } else if (str.contains("vivo")) {
                a2 = a(activity);
            } else if (str.contains("meizu")) {
                a2 = d(activity);
            } else {
                a2 = a(activity);
            }
            try {
                activity.startActivityForResult(a2, 2168);
            } catch (Exception unused) {
                try {
                    activity.startActivityForResult(a(activity), 2168);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static Intent f(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-1457228453")) {
            return (Intent) ipChange.ipc$dispatch("-1457228453", new Object[]{context});
        }
        String b = b("ro.miui.ui.version.name");
        if (!TextUtils.isEmpty(b) && !b.contains("7") && !b.contains("8")) {
            return a(context);
        }
        Intent intent = new Intent("miui.intent.action.APP_PERM_EDITOR");
        intent.putExtra("extra_pkgname", context.getPackageName());
        return intent;
    }
}
