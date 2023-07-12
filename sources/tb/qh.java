package tb;

import android.net.Uri;
import android.os.IBinder;
import com.taobao.aranger.core.ipc.channel.AbstractC6692a;
import com.taobao.aranger.core.ipc.channel.AbstractC6693b;
import com.taobao.aranger.core.ipc.channel.C6694c;
import com.taobao.aranger.core.ipc.channel.C6695d;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qh {
    private static final ConcurrentHashMap<Uri, AbstractC6693b> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<IBinder, AbstractC6692a> b = new ConcurrentHashMap<>();

    public static AbstractC6692a a(IBinder iBinder) {
        ConcurrentHashMap<IBinder, AbstractC6692a> concurrentHashMap = b;
        AbstractC6692a abstractC6692a = concurrentHashMap.get(iBinder);
        if (abstractC6692a == null) {
            C6694c c6694c = new C6694c(iBinder);
            concurrentHashMap.putIfAbsent(iBinder, c6694c);
            return c6694c;
        }
        return abstractC6692a;
    }

    public static AbstractC6693b b(Uri uri) {
        ConcurrentHashMap<Uri, AbstractC6693b> concurrentHashMap = a;
        AbstractC6693b abstractC6693b = concurrentHashMap.get(uri);
        if (abstractC6693b == null) {
            C6695d c6695d = new C6695d(uri);
            concurrentHashMap.putIfAbsent(uri, c6695d);
            return c6695d;
        }
        return abstractC6693b;
    }
}
