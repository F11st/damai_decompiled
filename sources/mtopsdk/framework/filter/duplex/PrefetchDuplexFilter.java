package mtopsdk.framework.filter.duplex;

import androidx.annotation.NonNull;
import com.taobao.analysis.abtest.ABTestCenter;
import com.taobao.tao.remotebusiness.MtopBusiness;
import java.util.concurrent.locks.ReentrantLock;
import mtopsdk.common.util.HeaderHandlerUtil;
import mtopsdk.common.util.HttpHeaderConstant;
import mtopsdk.common.util.RemoteConfig;
import mtopsdk.common.util.TBSdkLog;
import mtopsdk.framework.domain.MtopContext;
import mtopsdk.framework.filter.IAfterFilter;
import mtopsdk.framework.filter.IBeforeFilter;
import mtopsdk.mtop.common.MtopCallback;
import mtopsdk.mtop.common.MtopFinishEvent;
import mtopsdk.mtop.common.MtopListener;
import mtopsdk.mtop.domain.MtopResponse;
import mtopsdk.mtop.intf.Mtop;
import mtopsdk.mtop.intf.MtopBuilder;
import mtopsdk.mtop.intf.MtopPrefetch;
import mtopsdk.mtop.util.MtopStatistics;

/* compiled from: Taobao */
/* loaded from: classes11.dex */
public class PrefetchDuplexFilter implements IAfterFilter, IBeforeFilter {
    private static final String TAG = "mtopsdk.PrefetchDuplexFilter";

    private boolean isContinue() {
        if (RemoteConfig.getInstance().prefetch && Mtop.mIsFullTrackValid) {
            return (ABTestCenter.isTBSpeedEdition(RemoteConfig.TB_SPEED_TS_ENABLE) || ABTestCenter.isTBSpeedEdition(RemoteConfig.TB_SPEED_U_LAND)) ? false : true;
        }
        return true;
    }

    @Override // mtopsdk.framework.filter.IAfterFilter
    public String doAfter(MtopContext mtopContext) {
        try {
        } catch (Throwable th) {
            String str = mtopContext.seqNo;
            TBSdkLog.e(TAG, str, "checking after error " + th);
        }
        if (isContinue() || mtopContext.property.useCache) {
            return "CONTINUE";
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (mtopContext.mtopBuilder.getMtopPrefetch() != null) {
            MtopPrefetch mtopPrefetch = mtopContext.mtopBuilder.getMtopPrefetch();
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, mtopContext.seqNo + "save prefetch request and get response " + mtopContext.mtopRequest.getKey());
            }
            if (mtopContext.mtopResponse != null) {
                mtopPrefetch.prefetchResponseTime = currentTimeMillis;
                mtopContext.mtopInstance.lastPrefetchResponseTime = currentTimeMillis;
                ReentrantLock reentrantLock = mtopPrefetch.lock;
                reentrantLock.lock();
                mtopPrefetch.response.compareAndSet(false, true);
                if (mtopPrefetch.mergeContext != null) {
                    mtopPrefetch.prefetchHitTime = currentTimeMillis;
                    MtopPrefetch.onPrefetchAndCommit(MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_HIT, mtopPrefetch, mtopContext, null);
                    mtopContext.mtopInstance.getPrefetchBuilderMap().remove(mtopContext.mtopRequest.getKey());
                    MtopContext mtopContext2 = mtopPrefetch.mergeContext;
                    mtopContext.mtopListener = mtopContext2.mtopListener;
                    mtopContext.mtopBuilder = mtopContext2.mtopBuilder;
                    mtopContext.stats.isPrefetch = true;
                }
                reentrantLock.unlock();
            }
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IBeforeFilter
    public String doBefore(MtopContext mtopContext) {
        MtopBuilder mtopBuilder;
        try {
        } catch (Throwable th) {
            String str = mtopContext.seqNo;
            TBSdkLog.e(TAG, str, "call prefetch filter before error,apiKey=" + mtopContext.mtopRequest.getKey(), th);
        }
        if (isContinue()) {
            return "CONTINUE";
        }
        if (mtopContext.mtopBuilder.getMtopPrefetch() != null) {
            mtopContext.mtopInstance.addPrefetchBuilderToMap(mtopContext.mtopBuilder, mtopContext.mtopRequest.getKey());
            return "CONTINUE";
        }
        if (!mtopContext.property.useCache && (mtopBuilder = mtopContext.mtopInstance.getPrefetchBuilderMap().get(mtopContext.mtopRequest.getKey())) != null) {
            long currentTimeMillis = System.currentTimeMillis();
            MtopPrefetch.CompareResult compare = mtopBuilder.getMtopPrefetch().getComparator().compare(mtopContext.mtopBuilder, mtopBuilder);
            if (compare != null && compare.isSame()) {
                mtopBuilder.getMtopPrefetch().lock.lock();
                if (!mtopBuilder.getMtopPrefetch().response.get() && mtopBuilder.getMtopPrefetch().mergeContext == null) {
                    mtopBuilder.getMtopPrefetch().mergeContext = mtopContext;
                    mtopBuilder.getMtopPrefetch().lock.unlock();
                    return "STOP";
                }
                mtopBuilder.getMtopPrefetch().lock.unlock();
                if (currentTimeMillis - mtopBuilder.getMtopPrefetch().prefetchResponseTime > mtopBuilder.getMtopPrefetch().getPrefetchExpireTime()) {
                    MtopPrefetch.onPrefetchAndCommit(MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_EXPIRE, mtopBuilder.getMtopPrefetch(), mtopContext, null);
                    mtopContext.mtopInstance.getPrefetchBuilderMap().remove(mtopContext.mtopRequest.getKey());
                    if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                        TBSdkLog.d(TAG, mtopContext.seqNo + "not hit, time expired");
                    }
                    return "CONTINUE";
                }
                MtopStatistics mtopStatistics = mtopContext.stats;
                MtopResponse mtopResponse = mtopBuilder.getMtopContext().mtopResponse;
                mtopResponse.setMtopStat(mtopStatistics);
                mtopStatistics.rspCbDispatch = System.currentTimeMillis();
                mtopStatistics.isPrefetch = true;
                MtopFinishEvent mtopFinishEvent = new MtopFinishEvent(mtopResponse);
                mtopFinishEvent.seqNo = mtopContext.seqNo;
                mtopStatistics.serverTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.SERVER_TRACE_ID);
                mtopStatistics.eagleEyeTraceId = HeaderHandlerUtil.getSingleHeaderFieldByKey(mtopResponse.getHeaderFields(), HttpHeaderConstant.EAGLE_TRACE_ID);
                mtopStatistics.retCode = mtopResponse.getRetCode();
                mtopStatistics.statusCode = mtopResponse.getResponseCode();
                mtopStatistics.mappingCode = mtopResponse.getMappingCode();
                mtopStatistics.onEndAndCommit();
                MtopListener mtopListener = mtopContext.mtopListener;
                boolean z = true ^ (mtopContext.mtopBuilder instanceof MtopBusiness);
                if (z) {
                    mtopStatistics.rspCbStart = System.currentTimeMillis();
                }
                if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                    TBSdkLog.d(TAG, mtopContext.seqNo + "hit cache");
                }
                if (mtopListener instanceof MtopCallback.MtopFinishListener) {
                    ((MtopCallback.MtopFinishListener) mtopListener).onFinished(mtopFinishEvent, mtopContext.property.reqContext);
                }
                if (z) {
                    mtopStatistics.rspCbEnd = System.currentTimeMillis();
                    mtopStatistics.commitFullTrace();
                }
                mtopBuilder.getMtopPrefetch().prefetchHitTime = currentTimeMillis;
                MtopPrefetch.onPrefetchAndCommit(MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_HIT, mtopBuilder.getMtopPrefetch(), mtopContext, null);
                mtopContext.mtopInstance.getPrefetchBuilderMap().remove(mtopContext.mtopRequest.getKey());
                return "STOP";
            }
            MtopPrefetch.onPrefetchAndCommit(MtopPrefetch.IPrefetchCallback.PrefetchCallbackType.TYPE_MISS, mtopBuilder.getMtopPrefetch(), mtopContext, compare != null ? compare.getData() : null);
            if (TBSdkLog.isLogEnable(TBSdkLog.LogEnable.DebugEnable)) {
                TBSdkLog.d(TAG, mtopContext.seqNo + "not hit, miss not the same request");
            }
            return "CONTINUE";
        }
        return "CONTINUE";
    }

    @Override // mtopsdk.framework.filter.IMtopFilter
    @NonNull
    public String getName() {
        return TAG;
    }
}
