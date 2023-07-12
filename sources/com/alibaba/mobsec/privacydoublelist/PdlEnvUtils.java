package com.alibaba.mobsec.privacydoublelist;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;
import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class PdlEnvUtils {
    public static volatile boolean a = false;
    public static boolean b = true;
    public static boolean c = false;
    public static boolean d = true;
    @SuppressLint({"StaticFieldLeak"})
    public static Context e;
    public static String f;

    public static boolean a(Context context) {
        if (d) {
            try {
                if (f == null) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 28) {
                        f = Application.getProcessName();
                    } else {
                        f = (String) Class.forName("android.app.ActivityThread").getDeclaredMethod(i >= 18 ? "currentProcessName" : "currentPackageName", new Class[0]).invoke(null, new Object[0]);
                    }
                }
                String str = f;
                String packageName = context.getPackageName();
                if ("com.ali.money.shield".equals(packageName)) {
                    c = str.equals(packageName + ":fore");
                } else {
                    c = str.equals(packageName);
                }
                d = false;
            } catch (Exception e2) {
                if (a) {
                    e2.printStackTrace();
                }
            }
        }
        return c;
    }

    public static void setEnabled(boolean z) {
        if (z != b) {
            b = z;
            if (!z) {
                PrivacyDoubleList.getInstance().disableAll();
            } else {
                PrivacyDoubleList.getInstance().enableAll();
            }
        }
    }
}
