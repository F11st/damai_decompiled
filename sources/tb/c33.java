package tb;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c33 {
    private static String a;
    private static String b;

    public static String a(Context context) {
        if (TextUtils.isEmpty(a)) {
            a = context.getPackageName();
        }
        return a;
    }

    public static String b(Context context) {
        if (TextUtils.isEmpty(b) && context != null) {
            try {
                PackageInfo packageInfo = context.getPackageManager().getPackageInfo("com.taobao.taobao", 0);
                if (packageInfo != null) {
                    b = packageInfo.versionName;
                }
            } catch (PackageManager.NameNotFoundException e) {
                Log.d(uj2.TAG, e.toString());
            }
        }
        return b;
    }
}
