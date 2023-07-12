package tb;

import android.app.Application;
import javax.annotation.NonNullByDefault;

/* compiled from: Taobao */
@NonNullByDefault
/* loaded from: classes11.dex */
public class s40 {
    private static boolean a;

    public static void a(Application application) {
        try {
            a = (application.getApplicationInfo().flags & 2) != 0;
        } catch (Exception unused) {
        }
    }

    public static boolean b() {
        return a;
    }
}
