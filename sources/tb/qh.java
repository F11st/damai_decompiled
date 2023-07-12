package tb;

import android.net.Uri;
import android.os.IBinder;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class qh {
    private static final ConcurrentHashMap<Uri, com.taobao.aranger.core.ipc.channel.b> a = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<IBinder, com.taobao.aranger.core.ipc.channel.a> b = new ConcurrentHashMap<>();

    public static com.taobao.aranger.core.ipc.channel.a a(IBinder iBinder) {
        ConcurrentHashMap<IBinder, com.taobao.aranger.core.ipc.channel.a> concurrentHashMap = b;
        com.taobao.aranger.core.ipc.channel.a aVar = concurrentHashMap.get(iBinder);
        if (aVar == null) {
            com.taobao.aranger.core.ipc.channel.c cVar = new com.taobao.aranger.core.ipc.channel.c(iBinder);
            concurrentHashMap.putIfAbsent(iBinder, cVar);
            return cVar;
        }
        return aVar;
    }

    public static com.taobao.aranger.core.ipc.channel.b b(Uri uri) {
        ConcurrentHashMap<Uri, com.taobao.aranger.core.ipc.channel.b> concurrentHashMap = a;
        com.taobao.aranger.core.ipc.channel.b bVar = concurrentHashMap.get(uri);
        if (bVar == null) {
            com.taobao.aranger.core.ipc.channel.d dVar = new com.taobao.aranger.core.ipc.channel.d(uri);
            concurrentHashMap.putIfAbsent(uri, dVar);
            return dVar;
        }
        return bVar;
    }
}
