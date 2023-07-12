package mtopsdk.mtop.cache.handler;

import anetwork.network.cache.RpcCache;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CacheParserFactory {

    /* JADX INFO: Access modifiers changed from: package-private */
    /* compiled from: Taobao */
    /* renamed from: mtopsdk.mtop.cache.handler.CacheParserFactory$1  reason: invalid class name */
    /* loaded from: classes11.dex */
    public static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus;

        static {
            int[] iArr = new int[RpcCache.CacheStatus.values().length];
            $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus = iArr;
            try {
                iArr[RpcCache.CacheStatus.FRESH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$anetwork$network$cache$RpcCache$CacheStatus[RpcCache.CacheStatus.NEED_UPDATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static ICacheParser createCacheParser(RpcCache.CacheStatus cacheStatus) {
        if (cacheStatus == null) {
            return new EmptyCacheParser();
        }
        int i = AnonymousClass1.$SwitchMap$anetwork$network$cache$RpcCache$CacheStatus[cacheStatus.ordinal()];
        if (i != 1) {
            if (i != 2) {
                return new EmptyCacheParser();
            }
            return new ExpiredCacheParser();
        }
        return new FreshCacheParser();
    }
}
