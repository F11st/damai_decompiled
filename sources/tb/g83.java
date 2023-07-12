package tb;

import android.content.Context;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class g83 {
    public static String a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionName;
        } catch (Throwable th) {
            w63.b("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }

    public static String b(Context context) {
        try {
            return String.valueOf(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
        } catch (Throwable th) {
            w63.b("efs.util.pkg", "get version name error", th);
            return "unknown";
        }
    }
}
