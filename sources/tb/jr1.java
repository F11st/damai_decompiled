package tb;

import android.content.Context;
import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes6.dex */
public class jr1 {
    public static boolean a(Context context, String str) {
        return Build.VERSION.SDK_INT < 23 || context.getPackageManager().checkPermission(str, context.getPackageName()) == 0;
    }
}
