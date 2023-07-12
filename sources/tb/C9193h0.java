package tb;

import android.taobao.windvane.jsbridge.api.WVFile;
import anet.channel.util.ALog;
import anetwork.channel.cache.Cache;
import com.taobao.alivfssdk.cache.C6258a;
import com.taobao.alivfssdk.cache.C6261b;
import com.taobao.alivfssdk.cache.IAVFSCache;

/* compiled from: Taobao */
/* renamed from: tb.h0 */
/* loaded from: classes.dex */
public class C9193h0 implements Cache {
    private static boolean a = true;
    private static Object b;
    private static Object c;
    private static Object d;

    /* compiled from: Taobao */
    /* renamed from: tb.h0$a */
    /* loaded from: classes.dex */
    static class C9194a implements IAVFSCache.OnObjectSetCallback {
        C9194a() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectSetCallback
        public void onObjectSetCallback(String str, boolean z) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.h0$b */
    /* loaded from: classes.dex */
    static class C9195b implements IAVFSCache.OnObjectRemoveCallback {
        C9195b() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnObjectRemoveCallback
        public void onObjectRemoveCallback(String str, boolean z) {
        }
    }

    /* compiled from: Taobao */
    /* renamed from: tb.h0$c */
    /* loaded from: classes.dex */
    static class C9196c implements IAVFSCache.OnAllObjectRemoveCallback {
        C9196c() {
        }

        @Override // com.taobao.alivfssdk.cache.IAVFSCache.OnAllObjectRemoveCallback
        public void onAllObjectRemoveCallback(boolean z) {
        }
    }

    static {
        try {
            b = new C9194a();
            c = new C9195b();
            d = new C9196c();
        } catch (ClassNotFoundException unused) {
            a = false;
            ALog.k("anet.AVFSCacheImpl", "no alivfs sdk!", null, new Object[0]);
        }
    }

    private IAVFSCache a() {
        C6258a a2 = C6261b.d().a("networksdk.httpcache");
        if (a2 != null) {
            return a2.c();
        }
        return null;
    }

    public void b() {
        C6258a a2;
        if (a && (a2 = C6261b.d().a("networksdk.httpcache")) != null) {
            C9152g0 c9152g0 = new C9152g0();
            c9152g0.a = Long.valueOf((long) WVFile.FILE_MAX_SIZE);
            c9152g0.b = 1048576L;
            a2.f(c9152g0);
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
