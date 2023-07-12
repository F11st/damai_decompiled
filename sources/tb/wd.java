package tb;

import android.os.Build;

/* compiled from: Taobao */
/* loaded from: classes5.dex */
public class wd {
    public static boolean a() {
        if (Build.VERSION.SDK_INT < 29) {
            String str = Build.VERSION.CODENAME;
            return str.length() == 1 && str.charAt(0) >= 'Q' && str.charAt(0) <= 'Z';
        }
        return true;
    }
}
