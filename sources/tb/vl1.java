package tb;

import android.annotation.SuppressLint;
import android.app.AppOpsManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationManagerCompat;
import com.android.alibaba.ip.runtime.AndroidInstantRuntime;
import com.android.alibaba.ip.runtime.IpChange;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class vl1 {
    private static transient /* synthetic */ IpChange $ipChange;

    public static Intent a(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "588826906")) {
            return (Intent) ipChange.ipc$dispatch("588826906", new Object[]{context});
        }
        Intent intent = new Intent();
        StringBuilder sb = new StringBuilder();
        sb.append("sdk:");
        int i = Build.VERSION.SDK_INT;
        sb.append(i);
        Log.d("wxq", sb.toString());
        if (i >= 26) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (context != null) {
                intent.putExtra("android.provider.extra.APP_PACKAGE", context.getPackageName());
            }
        } else if (i >= 21) {
            intent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");
            if (context != null) {
                intent.putExtra("app_package", context.getPackageName());
                intent.putExtra("app_uid", context.getApplicationInfo().uid);
            }
        } else if (i >= 19) {
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.addCategory("android.intent.category.DEFAULT");
            if (context != null) {
                intent.setData(Uri.parse("package:" + context.getPackageName()));
            }
        } else if (i > 15) {
            intent.addFlags(268435456);
            intent.setAction("android.intent.action.VIEW");
            intent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
            if (context != null) {
                intent.setData(Uri.fromParts("package", context.getPackageName(), null));
            }
        }
        return intent;
    }

    @SuppressLint({"NewApi"})
    public static boolean b(Context context) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "820133148")) {
            return ((Boolean) ipChange.ipc$dispatch("820133148", new Object[]{context})).booleanValue();
        }
        if (Build.VERSION.SDK_INT >= 19) {
            return NotificationManagerCompat.from(context).areNotificationsEnabled();
        }
        AppOpsManager appOpsManager = (AppOpsManager) context.getSystemService("appops");
        ApplicationInfo applicationInfo = context.getApplicationInfo();
        String packageName = context.getApplicationContext().getPackageName();
        int i = applicationInfo.uid;
        try {
            Class<?> cls = Class.forName(AppOpsManager.class.getName());
            Class<?> cls2 = Integer.TYPE;
            return ((Integer) cls.getMethod("checkOpNoThrow", cls2, cls2, String.class).invoke(appOpsManager, Integer.valueOf(((Integer) cls.getDeclaredField("OP_POST_NOTIFICATION").get(Integer.class)).intValue()), Integer.valueOf(i), packageName)).intValue() == 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean c(Intent intent) {
        IpChange ipChange = $ipChange;
        if (AndroidInstantRuntime.support(ipChange, "-354723454")) {
            return ((Boolean) ipChange.ipc$dispatch("-354723454", new Object[]{intent})).booleanValue();
        }
        ComponentName componentName = null;
        try {
            componentName = intent.resolveActivity(mu0.a().getPackageManager());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentName != null;
    }
}
