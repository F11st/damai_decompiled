package tb;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes10.dex */
public class wm2 {
    private static final Handler a = new Handler(Looper.getMainLooper());

    public static void a(Runnable runnable) {
        if (b()) {
            runnable.run();
        } else {
            a.post(runnable);
        }
    }

    public static boolean b() {
        return a.getLooper() == Looper.myLooper();
    }
}
