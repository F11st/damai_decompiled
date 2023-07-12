package tb;

import android.os.Handler;
import android.os.Looper;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class xc1 {
    private static Handler a;

    public static void execute(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
            return;
        }
        if (a == null) {
            a = new Handler(Looper.getMainLooper());
        }
        a.post(runnable);
    }
}
