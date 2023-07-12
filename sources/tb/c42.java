package tb;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Looper;
import android.text.TextUtils;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class c42 {
    private static Boolean a;

    static {
        Looper.getMainLooper().getThread();
    }

    public static boolean a(Context context) {
        if (a == null) {
            try {
                a = Boolean.valueOf(TextUtils.isEmpty(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).sharedUserId) ? false : true);
            } catch (PackageManager.NameNotFoundException unused) {
                a = Boolean.FALSE;
            }
        }
        return a.booleanValue();
    }
}
