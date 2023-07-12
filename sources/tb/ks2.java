package tb;

import android.app.Application;
import android.util.Log;
import com.alibaba.ut.comm.ActivityLifecycleCB;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes8.dex */
public class ks2 {
    public static final String SDK_VERSION = "0.2.29";
    public static final String USER_AGENT = "UT4Aplus/0.2.29";
    private static volatile boolean a;

    public static void a(Application application) {
        b(application, null);
    }

    public static synchronized void b(Application application, Map map) {
        synchronized (ks2.class) {
            if (!a) {
                a = true;
                ActivityLifecycleCB.d().e(application);
                new mn().a();
                new up1().a();
                com.alibaba.ut.comm.a.a().b();
                Log.i("UT4Aplus", "ut4aplus init success. sdk_version:0.2.29");
            }
        }
    }
}
