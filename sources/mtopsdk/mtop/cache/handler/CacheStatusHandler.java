package mtopsdk.mtop.cache.handler;

import android.os.Handler;
import anetwork.network.cache.RpcCache;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.util.FilterUtils;
import mtopsdk.mtop.domain.MtopRequest;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.domain.ResponseSource;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class CacheStatusHandler {
    private static final String TAG = "mtopsdk.CacheStatusHandler";

    /* JADX INFO: Access modifiers changed from: protected */
    public static void finishMtopStatisticsOnExpiredCache(MtopStatistics mtopStatistics, MtopResponse mtopResponse) {
        if (mtopStatistics == null || mtopResponse == null) {
            return;
        }
        MtopStatistics mtopStatistics2 = null;
        try {
            mtopStatistics2 = (MtopStatistics) mtopStatistics.clone();
        } catch (Exception e) {
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.ErrorEnable)) {
                TBSdkLog.e(TAG, mtopStatistics.seqNo, "[finishMtopStatisticsOnCache] clone MtopStatistics error.", e);
            }
        }
        if (mtopStatistics2 != null) {
            mtopResponse.setMtopStat(mtopStatistics2);
            mtopStatistics2.serverTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.SERVER_TRACE_ID);
            mtopStatistics2.statusCode = mtopResponse.getResponseCode();
            mtopStatistics2.retCode = mtopResponse.getRetCode();
            mtopStatistics2.onEndAndCommit();
        }
    }

    public static void handleCacheStatus(ResponseSource responseSource, Handler handler) {
        if (responseSource == null) {
            return;
        }
        RpcCache rpcCache = responseSource.rpcCache;
        if (rpcCache != null) {
            CacheParserFactory.createCacheParser(rpcCache.cacheStatus).parse(responseSource, handler);
        } else {
            TBSdkLog.i(TAG, responseSource.seqNo, "[handleCacheStatus]Didn't  hit local cache ");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public static MtopResponse initResponseFromCache(RpcCache rpcCache, MtopRequest mtopRequest) {
        MtopResponse mtopResponse = new MtopResponse();
        mtopResponse.setApi(mtopRequest.getApiName());
        mtopResponse.setV(mtopRequest.getVersion());
        mtopResponse.setBytedata(rpcCache.body);
        mtopResponse.setHeaderFields(rpcCache.header);
        mtopResponse.setResponseCode(200);
        FilterUtils.parseRetCodeFromHeader(mtopResponse);
        return mtopResponse;
    }
}
