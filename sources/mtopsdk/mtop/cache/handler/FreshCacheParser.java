package mtopsdk.mtop.cache.handler;

import android.os.Handler;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.common.MtopNetworkProp;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class FreshCacheParser implements ICacheParser {
    private static final String TAG = "mtopsdk.FreshCacheParser";

    @Override // mtopsdk.mtop.cache.handler.ICacheParser
    public void parse(ResponseSource responseSource, Handler handler) {
        final String str = responseSource.seqNo;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str, "[parse]FreshCacheParser parse called");
        }
        responseSource.requireConnection = false;
        MtopContext mtopContext = responseSource.mtopContext;
        MtopRequest mtopRequest = mtopContext.mtopRequest;
        MtopStatistics mtopStatistics = mtopContext.stats;
        mtopStatistics.cacheHitType = 1;
        mtopStatistics.cacheResponseParseStartTime = mtopStatistics.currentTimeMillis();
        MtopResponse initResponseFromCache = CacheStatusHandler.initResponseFromCache(responseSource.rpcCache, mtopRequest);
        initResponseFromCache.setSource(MtopResponse.ResponseSource.FRESH_CACHE);
        mtopStatistics.cacheResponseParseEndTime = mtopStatistics.currentTimeMillis();
        initResponseFromCache.setMtopStat(mtopStatistics);
        responseSource.cacheResponse = initResponseFromCache;
        mtopStatistics.cacheReturnTime = mtopStatistics.currentTimeMillis();
        MtopNetworkProp mtopNetworkProp = mtopContext.property;
        if (mtopNetworkProp.forceRefreshCache) {
            responseSource.requireConnection = true;
            final MtopListener mtopListener = mtopContext.mtopListener;
            if (mtopListener instanceof MtopCallback.MtopCacheListener) {
                final Object obj = mtopNetworkProp.reqContext;
                final MtopCacheEvent mtopCacheEvent = new MtopCacheEvent(initResponseFromCache);
                mtopCacheEvent.seqNo = str;
                CacheStatusHandler.finishMtopStatisticsOnExpiredCache(mtopStatistics, initResponseFromCache);
                if (!mtopContext.property.skipCacheCallback) {
                    FilterUtils.submitCallbackTask(handler, new Runnable() { // from class: mtopsdk.mtop.cache.handler.FreshCacheParser.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                ((MtopCallback.MtopCacheListener) mtopListener).onCached(mtopCacheEvent, obj);
                            } catch (Exception e) {
                                TBSdkLog.e(FreshCacheParser.TAG, str, "do onCached callback error.", e);
                            }
                        }
                    }, mtopContext.seqNo.hashCode());
                }
                mtopStatistics.cacheHitType = 3;
            }
        }
    }
}
