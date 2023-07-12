package tb;

import android.util.Log;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public final class w63 {
    public static void a(String str, String str2) {
        if (com.efs.sdk.base.a.d.a.a().d()) {
            Log.i(str, str2);
        }
    }

    public static void b(String str, String str2, Throwable th) {
        if (com.efs.sdk.base.a.d.a.a().d()) {
            if (th == null) {
                Log.w(str, str2);
            } else {
                Log.w(str, str2, th);
            }
        }
    }

    public static void c(String str, String str2, Throwable th) {
        if (com.efs.sdk.base.a.d.a.a().d()) {
            if (th == null) {
                Log.e(str, str2);
            } else {
                Log.e(str, str2, th);
            }
        }
    }
}
