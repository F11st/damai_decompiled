package mtopsdk.framework.filter.duplex;

import android.content.Context;
import anetwork.network.cache.Cache;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.config.AppConfigManager;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.cache.CacheManager;
import mtopsdk.mtop.cache.CacheManagerImpl;
import mtopsdk.mtop.cache.domain.ApiCacheDo;
import mtopsdk.mtop.cache.handler.CacheStatusHandler;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.global.SwitchConfig;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CacheDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.CacheDuplexFilter";
    private static final Map<Cache, CacheManager> cacheManagerMap = new ConcurrentHashMap(2);

    private void updateApiCacheConf(MtopContext mtopContext, MtopResponse mtopResponse, String str, Map<String, List<String>> map) {
        String singleHeaderFieldByKey = HeaderHandlerUtil.getSingleHeaderFieldByKey(map, "cache-control");
        if (StringUtils.isBlank(singleHeaderFieldByKey)) {
            return;
        }
        AppConfigManager appConfigManager = AppConfigManager.getInstance();
        String api = mtopResponse.getApi();
        String v = mtopResponse.getV();
        String concatStr2LowerCase = StringUtils.concatStr2LowerCase(api, v);
        ApiCacheDo apiCacheDoByKey = appConfigManager.getApiCacheDoByKey(concatStr2LowerCase);
        Context context = mtopContext.mtopInstance.getMtopConfig().context;
        if (apiCacheDoByKey != null) {
            if (singleHeaderFieldByKey.equals(apiCacheDoByKey.cacheControlHeader)) {
                return;
            }
            appConfigManager.parseCacheControlHeader(singleHeaderFieldByKey, apiCacheDoByKey);
            appConfigManager.storeApiCacheDoMap(context, mtopContext.seqNo);
            return;
        }
        ApiCacheDo apiCacheDo = new ApiCacheDo(api, v, str);
        appConfigManager.parseCacheControlHeader(singleHeaderFieldByKey, apiCacheDo);
        appConfigManager.addApiCacheDoToGroup(concatStr2LowerCase, apiCacheDo);
        appConfigManager.storeApiCacheDoMap(context, mtopContext.seqNo);
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        if (SwitchConfig.getInstance().degradeApiCacheSet != null) {
            String key = mtopContext.mtopRequest.getKey();
            if (SwitchConfig.getInstance().degradeApiCacheSet.contains(key)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    String str = mtopContext.seqNo;
                    TBSdkLog.i(TAG, str, "apiKey in degradeApiCacheList,apiKey=" + key);
                }
                return "CONTINUE";
            }
        }
        MtopResponse mtopResponse = mtopContext.mtopResponse;
        ResponseSource responseSource = mtopContext.responseSource;
        if (mtopResponse.isApiSuccess() && responseSource != null) {
            Map<String, List<String>> headerFields = mtopResponse.getHeaderFields();
            CacheManager cacheManager = responseSource.cacheManager;
            if (cacheManager.isNeedWriteCache(mtopContext.networkRequest, headerFields)) {
                cacheManager.putCache(responseSource.getCacheKey(), responseSource.getCacheBlock(), mtopResponse);
                updateApiCacheConf(mtopContext, mtopResponse, responseSource.getCacheBlock(), headerFields);
            }
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        ResponseSource responseSource;
        Exception e;
        if (SwitchConfig.getInstance().degradeApiCacheSet != null) {
            String key = mtopContext.mtopRequest.getKey();
            if (SwitchConfig.getInstance().degradeApiCacheSet.contains(key)) {
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
                    TBSdkLog.i(TAG, mtopContext.seqNo, "apiKey in degradeApiCacheList,apiKey=" + key);
                }
                return "CONTINUE";
            }
        }
        mtopContext.stats.cacheSwitch = 1;
        Cache cache = mtopContext.mtopInstance.getMtopConfig().cacheImpl;
        if (cache == null) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, mtopContext.seqNo, " CacheImpl is null. instanceId=" + mtopContext.mtopInstance.getInstanceId());
            }
            return "CONTINUE";
        }
        Map<Cache, CacheManager> map = cacheManagerMap;
        CacheManager cacheManager = map.get(cache);
        if (cacheManager == null) {
            synchronized (map) {
                cacheManager = map.get(cache);
                if (cacheManager == null) {
                    cacheManager = new CacheManagerImpl(cache);
                    map.put(cache, cacheManager);
                }
            }
        }
        ResponseSource responseSource2 = null;
        try {
        } catch (Exception e2) {
            responseSource = null;
            e = e2;
        }
        if (cacheManager.isNeedReadCache(mtopContext.networkRequest, mtopContext.mtopListener)) {
            responseSource = new ResponseSource(mtopContext, cacheManager);
            try {
                mtopContext.responseSource = responseSource;
                responseSource.rpcCache = cacheManager.getCache(responseSource.getCacheKey(), responseSource.getCacheBlock(), mtopContext.seqNo);
                CacheStatusHandler.handleCacheStatus(responseSource, mtopContext.property.handler);
            } catch (Exception e3) {
                e = e3;
                TBSdkLog.e(TAG, mtopContext.seqNo, "[initResponseSource] initResponseSource error,apiKey=" + mtopContext.mtopRequest.getKey(), e);
                responseSource2 = responseSource;
                if (responseSource2 != null) {
                }
                return "CONTINUE";
            }
            responseSource2 = responseSource;
        }
        if (responseSource2 != null || responseSource2.requireConnection) {
            return "CONTINUE";
        }
        mtopContext.mtopResponse = responseSource2.cacheResponse;
        FilterUtils.handleExceptionCallBack(mtopContext);
        return "STOP";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    public String getName() {
        return TAG;
    }
}
