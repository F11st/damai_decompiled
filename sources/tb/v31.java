package tb;

import anet.channel.util.ALog;
import anetwork.channel.interceptor.Interceptor;
import java.util.concurrent.CopyOnWriteArrayList;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class v31 {
    private static final CopyOnWriteArrayList<Interceptor> a = new CopyOnWriteArrayList<>();
    public static final /* synthetic */ int b = 0;

    public static void a(Interceptor interceptor) {
        CopyOnWriteArrayList<Interceptor> copyOnWriteArrayList = a;
        if (copyOnWriteArrayList.contains(interceptor)) {
            return;
        }
        copyOnWriteArrayList.add(interceptor);
        ALog.f("anet.InterceptorManager", "[addInterceptor]", null, "interceptors", copyOnWriteArrayList.toString());
    }

    public static Interceptor b(int i) {
        return a.get(i);
    }

    public static int c() {
        return a.size();
    }
}
