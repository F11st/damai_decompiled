package mtopsdk.mtop.cache;

import anetwork.network.cache.Cache;
import anetwork.network.cache.RpcCache;
import java.util.List;
import java.util.Map;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.MtopUtils;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.mtop.cache.domain.ApiCacheDo;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.global.SDKUtils;
import mtopsdk.mtop.global.SwitchConfig;
import mtopsdk.network.domain.Request;
import mtopsdk.xstate.XState;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CacheManagerImpl implements CacheManager {
    private static final String METHOD_GET = "GET";
    private static final String QUERY_KEY_DATA = "data";
    private static final String QUERY_KEY_WUA = "wua";
    private static final String TAG = "mtopsdk.CacheManagerImpl";
    private Cache cache;

    public CacheManagerImpl(Cache cache) {
        this.cache = null;
        this.cache = cache;
    }

    private RpcCache handleCacheValidation(String str, RpcCache rpcCache) {
        if (rpcCache == null) {
            return rpcCache;
        }
        if (rpcCache.body == null) {
            rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            return rpcCache;
        }
        String str2 = rpcCache.lastModified;
        if (str2 == null && rpcCache.etag == null) {
            if (rpcCache.offline) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
            } else {
                rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            }
            return rpcCache;
        }
        if (StringUtils.isNotBlank(str2)) {
            long j = rpcCache.cacheCreateTime;
            long j2 = rpcCache.maxAge;
            long correctionTime = SDKUtils.getCorrectionTime();
            if (correctionTime >= j && correctionTime <= j + j2) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.FRESH;
            } else if (rpcCache.offline) {
                rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
            } else {
                rpcCache.cacheStatus = RpcCache.CacheStatus.TIMEOUT;
            }
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                StringBuilder sb = new StringBuilder(128);
                sb.append("[handleCacheValidation]cacheStatus=");
                sb.append(rpcCache.cacheStatus);
                sb.append(";lastModifiedStr=");
                sb.append(rpcCache.lastModified);
                sb.append(";lastModified=");
                sb.append(j);
                sb.append(";maxAge=");
                sb.append(j2);
                sb.append(";currentTime=");
                sb.append(correctionTime);
                sb.append(";t_offset=");
                sb.append(XState.getTimeOffset());
                TBSdkLog.i(TAG, str, sb.toString());
            }
        } else if (StringUtils.isNotBlank(rpcCache.etag)) {
            rpcCache.cacheStatus = RpcCache.CacheStatus.NEED_UPDATE;
        }
        return rpcCache;
    }

    private RpcCache handleResponseCacheFlag(String str, RpcCache rpcCache) {
        Map<String, List<String>> map;
        if (rpcCache != null && (map = rpcCache.header) != null) {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "last-modified");
            String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
            String singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, HttpHeaderConstant.MTOP_X_ETAG);
            if (singleHeaderFieldByKey3 == null) {
                singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "etag");
            }
            if (singleHeaderFieldByKey2 == null && singleHeaderFieldByKey == null && singleHeaderFieldByKey3 == null) {
                return rpcCache;
            }
            if (StringUtils.isNotBlank(singleHeaderFieldByKey2) && StringUtils.isNotBlank(singleHeaderFieldByKey)) {
                rpcCache.lastModified = singleHeaderFieldByKey;
                rpcCache.cacheCreateTime = MtopUtils.convertTimeFormatGMT2Long(singleHeaderFieldByKey);
                String[] split = singleHeaderFieldByKey2.split(",");
                if (split != null) {
                    for (String str2 : split) {
                        try {
                            if (str2.contains("max-age=")) {
                                rpcCache.maxAge = Long.parseLong(str2.substring(8));
                            } else if (HttpHeaderConstant.OFFLINE_FLAG_ON.equalsIgnoreCase(str2)) {
                                rpcCache.offline = true;
                            }
                        } catch (Exception unused) {
                            TBSdkLog.w(TAG, str, "[handleResponseCacheFlag] parse cacheControlStr error." + singleHeaderFieldByKey2);
                        }
                    }
                }
            }
            if (StringUtils.isNotBlank(singleHeaderFieldByKey3)) {
                rpcCache.etag = singleHeaderFieldByKey3;
            }
        }
        return rpcCache;
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public String getBlockName(String str) {
        ApiCacheDo apiCacheDoByKey;
        String str2;
        return (StringUtils.isBlank(str) || (apiCacheDoByKey = AppConfigManager.getInstance().getApiCacheDoByKey(str)) == null || (str2 = apiCacheDoByKey.blockName) == null) ? "" : str2;
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public RpcCache getCache(String str, String str2, String str3) {
        Cache cache = this.cache;
        if (cache == null) {
            return null;
        }
        RpcCache rpcCache = cache.get(str, str2);
        return rpcCache != null ? handleCacheValidation(str3, rpcCache) : rpcCache;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x005a, code lost:
        if (r9.equals(mtopsdk.mtop.cache.domain.ApiCacheDo.CacheKeyType.EXC) == false) goto L15;
     */
    @Override // mtopsdk.mtop.cache.CacheManager
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.String getCacheKey(mtopsdk.framework.domain.MtopContext r13) {
        /*
            Method dump skipped, instructions count: 382
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: mtopsdk.mtop.cache.CacheManagerImpl.getCacheKey(mtopsdk.framework.domain.MtopContext):java.lang.String");
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean isNeedReadCache(Request request, MtopListener mtopListener) {
        if (!SwitchConfig.getInstance().isGlobalCacheSwitchOpen()) {
            TBSdkLog.i(TAG, request.seqNo, "[isNeedReadCache]GlobalCacheSwitch=false,Don't read local cache.");
            return false;
        } else if (request != null && "GET".equalsIgnoreCase(request.method)) {
            return !HttpHeaderConstant.NO_CACHE.equalsIgnoreCase(request.header("cache-control"));
        } else {
            return false;
        }
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean isNeedWriteCache(Request request, Map<String, List<String>> map) {
        if (!SwitchConfig.getInstance().isGlobalCacheSwitchOpen()) {
            TBSdkLog.i(TAG, request.seqNo, "[isNeedWriteCache]GlobalCacheSwitch=false,Don't write local cache.");
            return false;
        } else if ("GET".equalsIgnoreCase(request.method) && map != null) {
            String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
            if (singleHeaderFieldByKey == null || !singleHeaderFieldByKey.contains(HttpHeaderConstant.NO_CACHE)) {
                String singleHeaderFieldByKey2 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "last-modified");
                String singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, HttpHeaderConstant.MTOP_X_ETAG);
                if (singleHeaderFieldByKey3 == null) {
                    singleHeaderFieldByKey3 = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "etag");
                }
                return (singleHeaderFieldByKey == null && singleHeaderFieldByKey2 == null && singleHeaderFieldByKey3 == null) ? false : true;
            }
            return false;
        } else {
            return false;
        }
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    public boolean putCache(String str, String str2, MtopResponse mtopResponse) {
        if (this.cache == null) {
            return false;
        }
        RpcCache rpcCache = new RpcCache();
        rpcCache.header = mtopResponse.getHeaderFields();
        rpcCache.body = mtopResponse.getBytedata();
        return this.cache.put(str, str2, handleResponseCacheFlag(mtopResponse.getMtopStat() != null ? mtopResponse.getMtopStat().seqNo : "", rpcCache));
    }

    @Override // mtopsdk.mtop.cache.CacheManager
    @Deprecated
    public String getBlockName(String str, String str2) {
        return getBlockName(StringUtils.concatStr2LowerCase(str, str2));
    }
}
