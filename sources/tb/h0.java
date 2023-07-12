package tb;

import android.taobao.windvane.jsbridge.api.WVFile;
import anet.channel.util.ALog;
import anetwork.channel.cache.Cache;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class h0 implements Cache {
    private static boolean a = true;
    private static Object b;
    private static Object c;
    private static Object d;

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class a implements IAVFSCache.OnObjectSetCallback {
        a() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectSetCallback
        public void onObjectSetCallback(String str, boolean z) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class b implements IAVFSCache.OnObjectRemoveCallback {
        b() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectRemoveCallback
        public void onObjectRemoveCallback(String str, boolean z) {
        }
    }

    /* compiled from: Taobao */
    /* loaded from: classes.dex */
    static class c implements IAVFSCache.OnAllObjectRemoveCallback {
        c() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnAllObjectRemoveCallback
        public void onAllObjectRemoveCallback(boolean z) {
        }
    }

    static {
        try {
            b = new a();
            c = new b();
            d = new c();
        } catch (ClassNotFoundException unused) {
            a = false;
            ALog.k("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache a() {
        com.taobao.alivfssdk.cache.a a2 = com.taobao.alivfssdk.cache.b.d().a("networksdk.httpcache");
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public void b() {
        com.taobao.alivfssdk.cache.a a2;
        if (a && (a2 = com.taobao.alivfssdk.cache.b.d().a("networksdk.httpcache")) != null) {
            g0 g0Var = new g0();
            g0Var.a = Long.valueOf((long) WVFile.FILE_MAX_SIZE);
            g0Var.b = 1048576L;
            a2.f(g0Var);
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void clear() {
        if (a) {
            try {
                IAVFSCache a2 = a();
                if (a2 != null) {
                    a2.removeAllObject((IAVFSCache.OnAllObjectRemoveCallback) d);
                }
            } catch (Exception e) {
                ALog.d("anet.AVFSCacheImpl", "clear cache failed", null, e, new Object[0]);
            }
        }
    }

    @Override // anetwork.channel.cache.Cache
    public Cache.Entry get(String str) {
        if (a) {
            try {
                IAVFSCache a2 = a();
                if (a2 != null) {
                    return (Cache.Entry) a2.objectForKey(zh2.h(str));
                }
            } catch (Exception e) {
                ALog.d("anet.AVFSCacheImpl", "get cache failed", null, e, new Object[0]);
            }
            return null;
        }
        return null;
    }

    @Override // anetwork.channel.cache.Cache
    public void put(String str, Cache.Entry entry) {
        if (a) {
            try {
                IAVFSCache a2 = a();
                if (a2 != null) {
                    a2.setObjectForKey(zh2.h(str), entry, (IAVFSCache.OnObjectSetCallback) b);
                }
            } catch (Exception e) {
                ALog.d("anet.AVFSCacheImpl", "put cache failed", null, e, new Object[0]);
            }
        }
    }

    @Override // anetwork.channel.cache.Cache
    public void remove(String str) {
        if (a) {
            try {
                IAVFSCache a2 = a();
                if (a2 != null) {
                    a2.removeObjectForKey(zh2.h(str), (IAVFSCache.OnObjectRemoveCallback) c);
                }
            } catch (Exception e) {
                ALog.d("anet.AVFSCacheImpl", "remove cache failed", null, e, new Object[0]);
            }
        }
    }
}
