package tb;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class op1 {
    public static boolean a(String str) {
        return str != null && str.startsWith("com.google.");
    }

    public static boolean b(Context context, String str) {
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(str, 0);
            int i = applicationInfo != null ? applicationInfo.flags : 0;
            return ((i & 1) == 0 && (i & 128) == 0) ? false : true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
