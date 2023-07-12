package mtopsdk.mtop.cache.handler;

import android.os.Handler;
import anetwork.network.cache.RpcCache;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.StringUtils;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.common.MtopCacheEvent;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.util.MtopStatistics;
import mtopsdk.network.domain.Request;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class ExpiredCacheParser implements ICacheParser {
    private static final String TAG = "mtopsdk.ExpiredCacheParser";

    @Override // mtopsdk.mtop.cache.handler.ICacheParser
    public void parse(ResponseSource responseSource, Handler handler) {
        final String str = responseSource.seqNo;
        if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.InfoEnable)) {
            TBSdkLog.i(TAG, str, "[parse]ExpiredCacheParser parse called");
        }
        MtopContext mtopContext = responseSource.mtopContext;
        MtopStatistics mtopStatistics = mtopContext.stats;
        mtopStatistics.cacheHitType = 2;
        mtopStatistics.cacheResponseParseStartTime = mtopStatistics.currentTimeMillis();
        RpcCache rpcCache = responseSource.rpcCache;
        MtopResponse initResponseFromCache = CacheStatusHandler.initResponseFromCache(rpcCache, mtopContext.mtopRequest);
        initResponseFromCache.setSource(MtopResponse.ResponseSource.EXPIRED_CACHE);
        mtopStatistics.cacheResponseParseEndTime = mtopStatistics.currentTimeMillis();
        initResponseFromCache.setMtopStat(mtopStatistics);
        final MtopListener mtopListener = mtopContext.mtopListener;
        final Object obj = mtopContext.property.reqContext;
        if (mtopListener instanceof MtopCallback.MtopCacheListener) {
            final MtopCacheEvent mtopCacheEvent = new MtopCacheEvent(initResponseFromCache);
            mtopCacheEvent.seqNo = str;
            mtopStatistics.cacheReturnTime = mtopStatistics.currentTimeMillis();
            CacheStatusHandler.finishMtopStatisticsOnExpiredCache(mtopStatistics, initResponseFromCache);
            if (!mtopContext.property.skipCacheCallback) {
                FilterUtils.submitCallbackTask(handler, new Runnable() { // from class: mtopsdk.mtop.cache.handler.ExpiredCacheParser.1
                    @Override // java.lang.Runnable
                    public void run() {
                        try {
                            ((MtopCallback.MtopCacheListener) mtopListener).onCached(mtopCacheEvent, obj);
                        } catch (Exception e) {
                            TBSdkLog.e(ExpiredCacheParser.TAG, str, "do onCached callback error.", e);
                        }
                    }
                }, mtopContext.seqNo.hashCode());
            }
        }
        mtopStatistics.cacheHitType = 3;
        Request request = mtopContext.networkRequest;
        if (request != null) {
            if (StringUtils.isNotBlank(rpcCache.lastModified)) {
                request.setHeader(HttpHeaderConstant.IF_MODIFIED_SINCE, rpcCache.lastModified);
            }
            if (StringUtils.isNotBlank(rpcCache.etag)) {
                request.setHeader(HttpHeaderConstant.IF_NONE_MATCH, rpcCache.etag);
            }
        }
        responseSource.cacheResponse = initResponseFromCache;
    }
}
